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
//   1. payload primitives shared by several rows (pointers, the object record);
//   2. one Wire<T> row per Variant::Type, encoding that type's payload both ways for the checked call (read/write, as a
//      Variant) and for the ptrcall (ptr_read/ptr_write, as the native value the engine expects).

// Storage for one inline value a ptrcall argument or return is copied into, sized for the largest of them.
struct PtrInlineValue {
    alignas(8) uint8_t bytes[sizeof(godot::Projection)];
};

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

// A type whose wire format is its own (NIL, String, Callable, Signal) is read and written as a Variant only. The
// generator never emits a ptrcall for such a type, so reaching these is a generator bug.
struct CustomWire {
    static const void* ptr_read(SharedBuffer*, PtrInlineValue*) {
        JVM_DEV_ASSERT(false, "A type with a custom wire format cannot be passed to a ptrcall.");
        return nullptr;
    }

    static void ptr_write(SharedBuffer*, const PtrInlineValue&) {
        JVM_DEV_ASSERT(false, "A type with a custom wire format cannot be returned from a ptrcall.");
    }
};

// A value stored inline with the engine's own layout: bool, numbers, math types, RID, and the raw object pointer.
// The engine reads and writes exactly these bytes, so a ptrcall copies them as they are.
template<class T>
struct InlineWire {
    static godot::Variant read(SharedBuffer* p_buffer) { return p_buffer->read<T>(); }

    static void write(SharedBuffer* p_buffer, const godot::Variant& p_variant) { p_buffer->write<T>(p_variant); }

    static const void* ptr_read(SharedBuffer* p_buffer, PtrInlineValue* r_storage) {
        memcpy(r_storage->bytes, p_buffer->read_bytes(sizeof(T)), sizeof(T));
        return r_storage->bytes;
    }

    static void ptr_write(SharedBuffer* p_buffer, const PtrInlineValue& p_value) {
        p_buffer->write_bytes(p_value.bytes, sizeof(T));
    }
};

// A native core type the JVM owns a native instance of: sent as a pointer, received as a fresh allocation. A ptrcall
// argument is that pointer itself; the generator keeps returns of these types on the checked call.
template<class T>
struct PointerWire {
    static godot::Variant read(SharedBuffer* p_buffer) { return *read_pointer<T>(p_buffer); }

    static void write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        write_pointer(p_buffer, static_cast<T>(p_variant));
    }

    static const void* ptr_read(SharedBuffer* p_buffer, PtrInlineValue*) { return read_pointer<T>(p_buffer); }

    static void ptr_write(SharedBuffer*, const PtrInlineValue&) {
        JVM_DEV_ASSERT(false, "A pointer-backed type cannot be returned from a ptrcall.");
    }
};

// Wire<T> is specialized for every type below and nothing else; a type without a row fails to compile at the tables.
template<godot::Variant::Type>
struct Wire;

template<>
struct Wire<godot::Variant::NIL> : CustomWire {
    static godot::Variant read(SharedBuffer*) { return godot::Variant(); }

    static void write(SharedBuffer*, const godot::Variant&) {}
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
    static godot::Variant read(SharedBuffer* p_buffer) {
        bool is_long = p_buffer->read<uint8_t>() != 0;
        if (unlikely(is_long)) { return LongStringQueue::get_instance().poll_string(); }
        uint32_t size = p_buffer->read<uint32_t>();
        return godot::String::utf8(reinterpret_cast<const char*>(p_buffer->read_bytes(size)), size);
    }

    static void write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        godot::String str = p_variant;
        const godot::CharString& char_string = str.utf8();
        int size = char_string.size();
        if (unlikely(size > LongStringQueue::max_string_size)) {
            p_buffer->write<uint8_t>(1);
            jni::Env env = jni::Jvm::current_env();
            LongStringQueue::get_instance().send_string_to_jvm(env, str);
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

// An object crosses as its raw pointer in both directions: the JVM sends one, a ptrcall wants a pointer to it, and
// a ptrcall returns one. Towards the JVM the pointer is expanded into the full record of write_object_payload.
template<>
struct Wire<godot::Variant::OBJECT> : InlineWire<godot::GodotObject*> {
    static godot::Variant read(SharedBuffer* p_buffer) {
        return raw_godot::RawObject(read_pointer<godot::GodotObject>(p_buffer)).to_variant();
    }

    static void write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        write_object_payload(p_buffer, raw_godot::RawObject::from_variant(p_variant));
    }

    static void ptr_write(SharedBuffer* p_buffer, const PtrInlineValue& p_value) {
        write_object_payload(p_buffer, *reinterpret_cast<godot::GodotObject* const*>(p_value.bytes));
    }
};

// A Callable's native instance is created on the fly by the JVM: fine to read as a Variant, not stable enough for a
// ptrcall.
template<>
struct Wire<godot::Variant::CALLABLE> : PointerWire<godot::Callable> {
    static const void* ptr_read(SharedBuffer* p_buffer, PtrInlineValue* r_storage) {
        return CustomWire::ptr_read(p_buffer, r_storage);
    }
};

template<>
struct Wire<godot::Variant::SIGNAL> : CustomWire {
    static godot::Variant read(SharedBuffer* p_buffer) {
        raw_godot::RawObject object = read_pointer<godot::GodotObject>(p_buffer);
        const godot::StringName name = *read_pointer<godot::StringName>(p_buffer);
        return object.to_signal(name);
    }

    static void write(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
        godot::Signal signal = p_variant.operator godot::Signal();
        // get_object_id() rather than get_object(): the latter returns a godot-cpp wrapper.
        const int64_t object_id = signal.get_object_id();
        write_object_payload(
            p_buffer,
            object_id != 0 ? raw_godot::RawObject::from_instance_id(object_id) : raw_godot::RawObject()
        );
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
