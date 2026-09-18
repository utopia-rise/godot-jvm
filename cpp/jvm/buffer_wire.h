#ifndef GODOT_JVM_BUFFER_WIRE_H
#define GODOT_JVM_BUFFER_WIRE_H

#include "core/jvm_binding_manager.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "jvm/jni/wrapper.h"
#include "jvm/wrapper/memory/long_string_queue.h"
#include "logging.h"
#include "shared_buffer.h"

#include <cstddef>
#include <cstring>
#include <variant/variant.hpp>

// What a Variant type looks like on the shared buffer. A value is a 4-byte Variant::Type tag followed by a payload;
// the tag is written and read by TransferContext, which dispatches on it to the row for the type. The file has two
// layers:
//   1. payload primitives shared by several rows (the type tag, pointers, the object record);
//   2. one Wire<T> row per Variant::Type, encoding that type's payload both ways for the checked call
//   (variant_read/variant_write, as a
//      Variant), for the ptrcall (ptr_read/ptr_write, as the native value the engine expects) and for a bridge with a
//      fixed signature (value_read/value_write, as the native value with no Variant in between).

// Storage for one inline value a ptrcall argument or return is copied into, sized for the largest of them.
struct PtrInlineValue {
    alignas(8) uint8_t bytes[sizeof(godot::Projection)];
};

// How much of a return slot must be null before the engine assigns a pointer-backed result over it: the size of the
// widest such type, whose data pointer is its first word.
constexpr size_t PTR_RETURN_NULL_BYTES = 2 * sizeof(void*);

static godot::Variant::Type read_type(SharedBuffer* p_buffer) {
    return static_cast<godot::Variant::Type>(p_buffer->read<uint32_t>());
}

static void write_type(SharedBuffer* p_buffer, godot::Variant::Type p_type) {
    p_buffer->write<uint32_t>(p_type);
}

template<class T>
static T* read_pointer(SharedBuffer* p_buffer) {
    return reinterpret_cast<T*>(static_cast<uintptr_t>(p_buffer->read<uint64_t>()));
}

template<class T>
static void write_pointer(SharedBuffer* p_buffer, const T& p_value) {
    p_buffer->write<uint64_t>(reinterpret_cast<uintptr_t>(VariantAllocator::alloc(T(p_value))));
}

static void write_object_payload(SharedBuffer* p_buffer, raw_godot::RawObject p_object) {
    if (p_object.is_null()) {
        p_buffer->write<uint32_t>(0);
        p_buffer->write<uint64_t>(0);
        p_buffer->write<uint64_t>(0);
        return;
    }
    godot::JvmBinding* binding = godot::JvmBindingManager::bind(p_object);
    p_buffer->write<uint32_t>(binding->get_constructor_id());
    p_buffer->write<uint64_t>(reinterpret_cast<uintptr_t>(p_object.ptr()));
    // The binding cached the ObjectID at creation: no second trip to the engine for it.
    p_buffer->write<uint64_t>(binding->get_object_id());
}

// A type the engine cannot take through a ptrcall, either because its payload has no native layout (String) or
// because the instance behind it is not stable enough (Callable, Signal). The generator never emits a ptrcall for
// such a type, so reaching these is a generator bug. Rows in this category still carry the full value pair.
struct CustomWire {
    static const void* ptr_read(SharedBuffer*, PtrInlineValue*) {
        JVM_DEV_ASSERT(false, "A type with a custom wire format cannot be passed to a ptrcall.");
        return nullptr;
    }

    static void ptr_write(SharedBuffer*, PtrInlineValue&) {
        JVM_DEV_ASSERT(false, "A type with a custom wire format cannot be returned from a ptrcall.");
    }
};

// A value stored inline with the engine's own layout: bool, numbers, math types and RID.
// The engine reads and writes exactly these bytes, so a ptrcall copies them as they are.
template<class T>
struct InlineWire {
    static godot::Variant variant_read(SharedBuffer* p_buffer) { return value_read(p_buffer); }

    static void variant_write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, p_variant);
    }

    static T value_read(SharedBuffer* p_buffer) { return p_buffer->read<T>(); }

    static void value_write(SharedBuffer* p_buffer, const T& p_value) { p_buffer->write<T>(p_value); }

    static const void* ptr_read(SharedBuffer* p_buffer, PtrInlineValue* r_storage) {
        memcpy(r_storage->bytes, p_buffer->read_bytes(sizeof(T)), sizeof(T));
        return r_storage->bytes;
    }

    static void ptr_write(SharedBuffer* p_buffer, PtrInlineValue& p_value) {
        p_buffer->write_bytes(p_value.bytes, sizeof(T));
    }
};

// A native core type the JVM owns a native instance of: sent as a pointer, received as a fresh allocation. A ptrcall
// argument is that pointer itself; a ptrcall return is the T the engine assigned into the slot, copied out into the
// JVM's allocation like a checked return, after which the slot's own reference is released.
template<class T>
struct PointerWire {
    static godot::Variant variant_read(SharedBuffer* p_buffer) { return value_read(p_buffer); }

    static void variant_write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<T>(p_variant));
    }

    static T& value_read(SharedBuffer* p_buffer) { return *read_pointer<T>(p_buffer); }

    static void value_write(SharedBuffer* p_buffer, const T& p_value) { write_pointer(p_buffer, p_value); }

    static const void* ptr_read(SharedBuffer* p_buffer, PtrInlineValue*) { return read_pointer<T>(p_buffer); }

    static void ptr_write(SharedBuffer* p_buffer, PtrInlineValue& p_value) {
        // The engine assigned over a nulled slot, the empty value of a type that is a data pointer plus padding.
        static_assert(sizeof(T) <= PTR_RETURN_NULL_BYTES, "A pointer-backed return exceeds the nulled slot prefix.");
        T& value = *reinterpret_cast<T*>(p_value.bytes);
        write_pointer(p_buffer, value);
        value.~T();
    }
};

// Wire<T> is specialized for every type below and nothing else; a type without a row fails to compile at the tables.
template<godot::Variant::Type>
struct Wire;

template<>
struct Wire<godot::Variant::NIL> : CustomWire {
    static godot::Variant variant_read(SharedBuffer*) { return godot::Variant(); }

    static void variant_write(SharedBuffer*, const godot::Variant&) {}
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
    static godot::Variant variant_read(SharedBuffer* p_buffer) { return value_read(p_buffer); }

    static void variant_write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<godot::String>(p_variant));
    }

    static godot::String value_read(SharedBuffer* p_buffer) {
        bool is_long = p_buffer->read<uint8_t>() != 0;
        if (unlikely(is_long)) { return LongStringQueue::get_instance().poll_string(); }
        uint32_t size = p_buffer->read<uint32_t>();
        return godot::String::utf8(reinterpret_cast<const char*>(p_buffer->read_bytes(size)), size);
    }

    static void value_write(SharedBuffer* p_buffer, const godot::String& p_value) {
        const godot::CharString& char_string = p_value.utf8();
        int size = char_string.size();
        if (unlikely(size > LongStringQueue::max_string_size)) {
            p_buffer->write<uint8_t>(1);
            jni::Env env = jni::Jvm::current_env();
            LongStringQueue::get_instance().send_string_to_jvm(env, p_value);
            return;
        }
        p_buffer->write<uint8_t>(0);
        p_buffer->write<uint32_t>(size);
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
    static godot::Variant variant_read(SharedBuffer* p_buffer) { return value_read(p_buffer).to_variant(); }

    static void variant_write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, raw_godot::RawObject::from_variant(p_variant));
    }

    static raw_godot::RawObject value_read(SharedBuffer* p_buffer) { return p_buffer->read<raw_godot::RawObject>(); }

    static void value_write(SharedBuffer* p_buffer, raw_godot::RawObject p_object) {
        write_object_payload(p_buffer, p_object);
    }

    static const void* ptr_read(SharedBuffer* p_buffer, PtrInlineValue* r_storage) {
        *reinterpret_cast<raw_godot::RawObject*>(r_storage->bytes) = p_buffer->read<raw_godot::RawObject>();
        return r_storage->bytes;
    }

    static void ptr_write(SharedBuffer* p_buffer, PtrInlineValue& p_value) {
        value_write(p_buffer, *reinterpret_cast<const raw_godot::RawObject*>(p_value.bytes));
    }
};

// A Callable is a pointer to a native instance the JVM creates on the fly, so it reads and writes like any
// pointer-backed type. It stays off the ptrcall deliberately: that instance is owned by a JVM wrapper which is
// already unreachable once its pointer reaches the buffer, so the binding keeps the engine reading a copy it made
// here rather than handing it the instance itself.
template<>
struct Wire<godot::Variant::CALLABLE> : CustomWire {
    static godot::Variant variant_read(SharedBuffer* p_buffer) { return value_read(p_buffer); }

    static void variant_write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<godot::Callable>(p_variant));
    }

    static godot::Callable& value_read(SharedBuffer* p_buffer) { return *read_pointer<godot::Callable>(p_buffer); }

    static void value_write(SharedBuffer* p_buffer, const godot::Callable& p_value) {
        write_pointer(p_buffer, p_value);
    }
};

template<>
struct Wire<godot::Variant::SIGNAL> : CustomWire {
    static godot::Variant variant_read(SharedBuffer* p_buffer) { return value_read(p_buffer); }

    static void variant_write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        value_write(p_buffer, static_cast<godot::Signal>(p_variant));
    }

    static godot::Signal value_read(SharedBuffer* p_buffer) {
        raw_godot::RawObject object = read_pointer<godot::GodotObject>(p_buffer);
        const godot::StringName name = *read_pointer<godot::StringName>(p_buffer);
        return object.to_signal(name);
    }

    static void value_write(SharedBuffer* p_buffer, const godot::Signal& signal) {
        write_object_payload(p_buffer, signal.get_object());
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

#endif // GODOT_JVM_BUFFER_WIRE_H
