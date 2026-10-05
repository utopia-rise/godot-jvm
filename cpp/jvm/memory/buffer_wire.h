#ifndef GODOT_JVM_BUFFER_WIRE_H
#define GODOT_JVM_BUFFER_WIRE_H

#include "core/jvm_binding_manager.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "jvm/jni/wrapper.h"
#include "jvm/memory/long_string_queue.h"
#include "logging.h"

#include <array>
#include <cstddef>
#include <cstring>
#include <utility>
#include <variant/variant.hpp>

// What a Variant type looks like on the shared buffer. A value is an eight byte Variant::Type tag followed by a
// payload, both starting on an eight byte boundary so the engine can read a payload where it lies; the tag is
// written and read by the buffer that carries it, which dispatches on it to the row for the type. The file has two
// layers:
//   1. payload primitives shared by several rows (the type tag, pointers, the object record);
//   2. one Wire<T> row per Variant::Type, encoding that type's payload both ways for the checked call
//   (variant_read/variant_write, as a
//      Variant), for the ptrcall (ptr_read and the return slot description, as the native value the engine expects)
//      and for a bridge with a fixed signature (value_read/value_write, as the native value with no Variant in
//      between).

constexpr size_t OBJECT_PAYLOAD_SIZE = 2 * sizeof(uint64_t);

template<class B>
static godot::Variant::Type read_type(B* p_buffer) {
    p_buffer->align();
    return static_cast<godot::Variant::Type>(p_buffer->template read<uint64_t>());
}

template<class B>
static void write_type(B* p_buffer, godot::Variant::Type p_type) {
    p_buffer->align();
    p_buffer->template write<uint64_t>(p_type);
}

template<class T, class B>
static T* read_pointer(B* p_buffer) {
    return reinterpret_cast<T*>(static_cast<uintptr_t>(p_buffer->template read<uint64_t>()));
}

template<class T, class B>
static void write_pointer(B* p_buffer, const T& p_value) {
    p_buffer->template write<uint64_t>(reinterpret_cast<uintptr_t>(VariantAllocator::alloc(T(p_value))));
}

// The engine reads an ObjectID straight off the object, while reaching the JVM binding for it goes through
// object_get_instance_binding and its mutex. Only a RefCounted needs the binding here, to record the delivery and take
// the JVM's reference on the first one; for every object the JVM creates the binding itself, once, when it has no
// wrapper yet and calls MemoryManager::bind_object.
static void write_object_payload(uint8_t* p_slot, raw_godot::RawObject p_object) {
    uint64_t record[2] = {0, 0};
    if (!p_object.is_null()) {
        godot::ObjectID object_id(p_object.get_instance_id());
        if (object_id.is_ref_counted()) { godot::JvmBindingManager::bind(p_object); }
        record[0] = reinterpret_cast<uintptr_t>(p_object.ptr());
        record[1] = object_id;
    }
    memcpy(p_slot, record, sizeof(record));
}

// A type the engine cannot take through a ptrcall, either because its payload has no native layout (String) or
// because the instance behind it is not stable enough (Callable, Signal). The generator never emits a ptrcall for
// such a type, so reaching these is a generator bug. Rows in this category still carry the full value pair.
struct CustomWire {
    static constexpr uint32_t PTR_SLOT_SIZE = 0;
    static constexpr uint32_t PTR_ARG_SIZE = 0;

    // Takes the region and the offset by value and hands the offset back, so the frame itself never reaches a row:
    // if it did, the compiler would have to keep the frame's position coherent in memory at every call site and the
    // decoding loop could not hold it in a register.
    static ptrdiff_t ptr_read(const uint8_t*, ptrdiff_t p_at, const void** r_arg) {
        JVM_DEV_ASSERT(false, "A type with a custom wire format cannot be passed to a ptrcall.");
        *r_arg = nullptr;
        return p_at;
    }

    static void ptr_call(uint8_t*, const raw_godot::PtrCall&) {
        JVM_DEV_ASSERT(false, "A type with a custom wire format cannot be returned from a ptrcall.");
    }
};

// A value stored inline with the engine's own layout: bool, numbers, math types and RID.
// The engine reads and writes exactly these bytes, so a ptrcall copies them as they are.
template<class T>
struct InlineWire {
    template<class B>
    static godot::Variant variant_read(B* p_buffer) {
        return value_read(p_buffer);
    }

    template<class B>
    static void variant_write(B* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, p_variant);
    }

    template<class B>
    static T value_read(B* p_buffer) {
        return p_buffer->template read<T>();
    }

    template<class B>
    static void value_write(B* p_buffer, const T& p_value) {
        p_buffer->template write<T>(p_value);
    }

    static constexpr uint32_t PTR_SLOT_SIZE = sizeof(T);
    static constexpr uint32_t PTR_ARG_SIZE = sizeof(T);

    static ptrdiff_t ptr_read(const uint8_t* p_base, ptrdiff_t p_at, const void** r_arg) {
        *r_arg = p_base + p_at;
        return p_at + sizeof(T);
    }

    // The engine writes the value where the JVM will read it, in the layout the JVM expects, so there is nothing to
    // arrange on either side of the call.
    static void ptr_call(uint8_t* p_slot, const raw_godot::PtrCall& p_call) { p_call(p_slot); }
};

// A native core type the JVM owns a native instance of: sent as a pointer, received as a fresh allocation. A ptrcall
// argument is that pointer itself; a ptrcall return is assigned by the engine into that allocation directly, and the
// frame carries only its address.
template<class T>
struct PointerWire {
    template<class B>
    static godot::Variant variant_read(B* p_buffer) {
        return value_read(p_buffer);
    }

    template<class B>
    static void variant_write(B* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<T>(p_variant));
    }

    template<class B>
    static T& value_read(B* p_buffer) {
        return *read_pointer<T>(p_buffer);
    }

    template<class B>
    static void value_write(B* p_buffer, const T& p_value) {
        write_pointer(p_buffer, p_value);
    }

    static constexpr uint32_t PTR_SLOT_SIZE = sizeof(uint64_t);
    static constexpr uint32_t PTR_ARG_SIZE = 0;

    static ptrdiff_t ptr_read(const uint8_t* p_base, ptrdiff_t p_at, const void** r_arg) {
        uint64_t handle;
        memcpy(&handle, p_base + p_at, sizeof(handle));
        *r_arg = reinterpret_cast<const T*>(static_cast<uintptr_t>(handle));
        return p_at + sizeof(handle);
    }

    // The JVM keeps the value after the call, so the engine is pointed straight at the allocation it will own rather
    // than at the frame, which the next call reuses. The slot carries the address, which is known before the call.
    static void ptr_call(uint8_t* p_slot, const raw_godot::PtrCall& p_call) {
        T* value = VariantAllocator::alloc_slot<T>();
        uint64_t handle = reinterpret_cast<uintptr_t>(value);
        memcpy(p_slot, &handle, sizeof(handle));
        p_call(value);
    }
};

// Wire<T> is specialized for every type below and nothing else; a type without a row fails to compile at the tables.
template<godot::Variant::Type>
struct Wire;

template<>
struct Wire<godot::Variant::NIL> : CustomWire {
    template<class B>
    static godot::Variant variant_read(B*) {
        return godot::Variant();
    }

    template<class B>
    static void variant_write(B*, const godot::Variant&) {}
};

template<>
struct Wire<godot::Variant::BOOL> : InlineWire<bool> {};

template<>
struct Wire<godot::Variant::INT> : InlineWire<uint64_t> {};

template<>
struct Wire<godot::Variant::FLOAT> : InlineWire<double> {};

// A string travels inline as UTF-8 behind a one-byte flag, or through the LongStringQueue when it exceeds the limit.
template<>
struct Wire<godot::Variant::STRING> : CustomWire {
    template<class B>
    static godot::Variant variant_read(B* p_buffer) {
        return value_read(p_buffer);
    }

    template<class B>
    static void variant_write(B* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<godot::String>(p_variant));
    }

    template<class B>
    static godot::String value_read(B* p_buffer) {
        bool is_long = p_buffer->template read<uint8_t>() != 0;
        if (unlikely(is_long)) { return LongStringQueue::get_instance().poll_string(); }
        uint32_t size = p_buffer->template read<uint32_t>();
        return godot::String::utf8(reinterpret_cast<const char*>(p_buffer->read_bytes(size)), size);
    }

    template<class B>
    static void value_write(B* p_buffer, const godot::String& p_value) {
        const godot::CharString& char_string = p_value.utf8();
        int size = char_string.size();
        if (unlikely(size > LongStringQueue::max_string_size)) {
            p_buffer->template write<uint8_t>(1);
            jni::Env& env = jni::Jvm::current_env();
            LongStringQueue::get_instance().send_string_to_jvm(env, p_value);
            return;
        }
        p_buffer->template write<uint8_t>(0);
        p_buffer->template write<uint32_t>(size);
        p_buffer->write_bytes(char_string.get_data(), size);
    }
};

template<>
struct Wire<godot::Variant::VECTOR2> : InlineWire<godot::Vector2> {};

template<>
struct Wire<godot::Variant::VECTOR2I> : InlineWire<godot::Vector2i> {};

template<>
struct Wire<godot::Variant::RECT2> : InlineWire<godot::Rect2> {};

template<>
struct Wire<godot::Variant::RECT2I> : InlineWire<godot::Rect2i> {};

template<>
struct Wire<godot::Variant::VECTOR3> : InlineWire<godot::Vector3> {};

template<>
struct Wire<godot::Variant::VECTOR3I> : InlineWire<godot::Vector3i> {};

template<>
struct Wire<godot::Variant::TRANSFORM2D> : InlineWire<godot::Transform2D> {};

template<>
struct Wire<godot::Variant::VECTOR4> : InlineWire<godot::Vector4> {};

template<>
struct Wire<godot::Variant::VECTOR4I> : InlineWire<godot::Vector4i> {};

template<>
struct Wire<godot::Variant::PLANE> : InlineWire<godot::Plane> {};

template<>
struct Wire<godot::Variant::QUATERNION> : InlineWire<godot::Quaternion> {};

template<>
struct Wire<godot::Variant::AABB> : InlineWire<godot::AABB> {};

template<>
struct Wire<godot::Variant::BASIS> : InlineWire<godot::Basis> {};

template<>
struct Wire<godot::Variant::TRANSFORM3D> : InlineWire<godot::Transform3D> {};

template<>
struct Wire<godot::Variant::PROJECTION> : InlineWire<godot::Projection> {};

template<>
struct Wire<godot::Variant::COLOR> : InlineWire<godot::Color> {};

template<>
struct Wire<godot::Variant::STRING_NAME> : PointerWire<godot::StringName> {};

template<>
struct Wire<godot::Variant::NODE_PATH> : PointerWire<godot::NodePath> {};

template<>
struct Wire<godot::Variant::RID> : InlineWire<godot::RID> {};

// An object crosses as a pointer, but unlike the other pointer rows the pointer is the value, not the address of a
// JVM-owned copy: nothing is dereferenced or allocated, a ptrcall wants the address of a slot holding the pointer
// and returns one. PointerWire is used for readability but requires every method to be overridden.
template<>
struct Wire<godot::Variant::OBJECT> : PointerWire<raw_godot::RawObject> {
    template<class B>
    static godot::Variant variant_read(B* p_buffer) {
        return value_read(p_buffer).to_variant();
    }

    template<class B>
    static void variant_write(B* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, raw_godot::RawObject::from_variant(p_variant));
    }

    template<class B>
    static raw_godot::RawObject value_read(B* p_buffer) {
        return p_buffer->template read<raw_godot::RawObject>();
    }

    template<class B>
    static void value_write(B* p_buffer, raw_godot::RawObject p_object) {
        write_object_payload(p_buffer->reserve(OBJECT_PAYLOAD_SIZE), p_object);
    }

    static constexpr uint32_t PTR_SLOT_SIZE = OBJECT_PAYLOAD_SIZE;
    static constexpr uint32_t PTR_ARG_SIZE = sizeof(raw_godot::RawObject);

    static ptrdiff_t ptr_read(const uint8_t* p_base, ptrdiff_t p_at, const void** r_arg) {
        *r_arg = p_base + p_at;
        return p_at + sizeof(raw_godot::RawObject);
    }

    // The engine writes the pointer alone, in place; the ObjectID the JVM pairs it with is only knowable afterwards,
    // so the slot is left holding a null object for a call that returns none and widened once the call is through.
    static void ptr_call(uint8_t* p_slot, const raw_godot::PtrCall& p_call) {
        memset(p_slot, 0, sizeof(raw_godot::RawObject));
        p_call(p_slot);
        write_object_payload(p_slot, *reinterpret_cast<raw_godot::RawObject*>(p_slot));
    }
};

// A method whose declared return class inherits RefCounted. The engine assigns a Ref<T> over the return slot, which
// is bytewise the same object pointer as a plain return but leaves an **owned** reference in it, and GDExtension
// offers no way to ask a method binding which of the two it does. The generator therefore sends this ordinal, one
// past the last real Variant type, in place of OBJECT's, so the difference reaches the buffer as a row of its own
// rather than as a flag its callers have to act on. See ValueBuffer::REF_COUNTED_RETURN_TYPE.
// It is a return only: an argument is never announced with it, and the row is reachable from the return tables alone.
template<>
struct Wire<godot::Variant::VARIANT_MAX> : Wire<godot::Variant::OBJECT> {
    static void ptr_call(uint8_t* p_slot, const raw_godot::PtrCall& p_call) {
        memset(p_slot, 0, sizeof(raw_godot::RawObject));
        p_call(p_slot);
        raw_godot::RawObject returned = *reinterpret_cast<raw_godot::RawObject*>(p_slot);
        // Writing the payload binds the object, which takes the JVM's own reference the first time it is seen.
        // Releasing the engine's then stands in for the destructor of the Ref local that never existed.
        write_object_payload(p_slot, returned);
        if (!returned.is_null() && unlikely(returned.unreference())) { returned.destroy(); }
    }
};

// A Callable is a pointer to a native instance the JVM creates on the fly, so it reads and writes like any
// pointer-backed type. It stays off the ptrcall deliberately: that instance is owned by a JVM wrapper which is
// already unreachable once its pointer reaches the buffer, so the binding keeps the engine reading a copy it made
// here rather than handing it the instance itself.
template<>
struct Wire<godot::Variant::CALLABLE> : CustomWire {
    template<class B>
    static godot::Variant variant_read(B* p_buffer) {
        return value_read(p_buffer);
    }

    template<class B>
    static void variant_write(B* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<godot::Callable>(p_variant));
    }

    template<class B>
    static godot::Callable& value_read(B* p_buffer) {
        return *read_pointer<godot::Callable>(p_buffer);
    }

    template<class B>
    static void value_write(B* p_buffer, const godot::Callable& p_value) {
        write_pointer(p_buffer, p_value);
    }
};

template<>
struct Wire<godot::Variant::SIGNAL> : CustomWire {
    template<class B>
    static godot::Variant variant_read(B* p_buffer) {
        return value_read(p_buffer);
    }

    template<class B>
    static void variant_write(B* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<godot::Signal>(p_variant));
    }

    template<class B>
    static godot::Signal value_read(B* p_buffer) {
        raw_godot::RawObject object = read_pointer<godot::GodotObject>(p_buffer);
        const godot::StringName name = *read_pointer<godot::StringName>(p_buffer);
        return object.to_signal(name);
    }

    template<class B>
    static void value_write(B* p_buffer, const godot::Signal& signal) {
        write_object_payload(p_buffer->reserve(OBJECT_PAYLOAD_SIZE), signal.get_object());
        write_pointer(p_buffer, signal.get_name());
    }
};

template<>
struct Wire<godot::Variant::DICTIONARY> : PointerWire<godot::Dictionary> {};

template<>
struct Wire<godot::Variant::ARRAY> : PointerWire<godot::Array> {};

template<>
struct Wire<godot::Variant::PACKED_BYTE_ARRAY> : PointerWire<godot::PackedByteArray> {};

template<>
struct Wire<godot::Variant::PACKED_INT32_ARRAY> : PointerWire<godot::PackedInt32Array> {};

template<>
struct Wire<godot::Variant::PACKED_INT64_ARRAY> : PointerWire<godot::PackedInt64Array> {};

template<>
struct Wire<godot::Variant::PACKED_FLOAT32_ARRAY> : PointerWire<godot::PackedFloat32Array> {};

template<>
struct Wire<godot::Variant::PACKED_FLOAT64_ARRAY> : PointerWire<godot::PackedFloat64Array> {};

template<>
struct Wire<godot::Variant::PACKED_STRING_ARRAY> : PointerWire<godot::PackedStringArray> {};

template<>
struct Wire<godot::Variant::PACKED_VECTOR2_ARRAY> : PointerWire<godot::PackedVector2Array> {};

template<>
struct Wire<godot::Variant::PACKED_VECTOR3_ARRAY> : PointerWire<godot::PackedVector3Array> {};

template<>
struct Wire<godot::Variant::PACKED_COLOR_ARRAY> : PointerWire<godot::PackedColorArray> {};

template<>
struct Wire<godot::Variant::PACKED_VECTOR4_ARRAY> : PointerWire<godot::PackedVector4Array> {};

// The ptrcall argument rows flattened into tables a runtime type ordinal can index. They live here, with the rows
// they are built from, because reading an argument is small enough to be worth inlining at a call site that knows
// its own shape, which needs them visible in a header.
//
// PTR_ARG_SIZES gives how many bytes a value of each type occupies in an argument record, or zero for a type whose
// payload is not the value itself. For everything else reading an argument is "take the current address, then step
// over it", which a caller does inline; going through ptr_read instead would mean an indirect call whose only
// payload is this number, and which forces the frame position out to memory and back on every argument.
template<size_t... I>
constexpr auto make_ptr_arg_sizes(std::index_sequence<I...>) {
    return std::array<uint32_t, sizeof...(I)> {Wire<static_cast<godot::Variant::Type>(I)>::PTR_ARG_SIZE...};
}

template<size_t... I>
constexpr auto make_ptr_arg_readers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::ptr_read...};
}

// An argument is never announced as REF_COUNTED_RETURN_TYPE, so these stop at the last real Variant type.
inline constexpr auto PTR_ARG_SIZES = make_ptr_arg_sizes(std::make_index_sequence<godot::Variant::VARIANT_MAX>());
inline constexpr auto PTR_ARG_READERS = make_ptr_arg_readers(std::make_index_sequence<godot::Variant::VARIANT_MAX>());

#endif // GODOT_JVM_BUFFER_WIRE_H
