#ifndef GODOT_JVM_VARIANT_TYPE_H
#define GODOT_JVM_VARIANT_TYPE_H

#include "core/jvm_binding_manager.h"
#include "engine/godot_object.h"
#include "jvm/jni/jvm.h"
#include "jvm/memory/byte_cursor.h"
#include "jvm/memory/long_string_queue.h"

#include <core/defs.hpp>
#include <cstdint>
#include <cstring>
#include <variant/variant.hpp>

// Everything the binding knows about a Variant type, one row each: the C++ type carrying it, the shape it crosses in,
// and how it becomes bytes. Both buffers read these rows and neither knows the other, so this is the only file a new
// type is declared in. Most rows are one line because a shape supplies the rest.

// How a value is carried. The shape decides the whole ptrcall wire, so a row states it once instead of the value
// buffer restating a consequence of it.
// INLINE  - the engine's own bytes, laid down as they are.
// POINTER - a native instance the JVM owns, carried as its address.
// OBJECT  - an engine object, carried as a pointer paired with the ObjectID the JVM needs.
// CUSTOM  - none of the above; the row writes its own codec and cannot cross a ptrcall.
enum class Shape : uint8_t {
    INLINE,
    POINTER,
    OBJECT,
    CUSTOM
};

// An object travels as its pointer followed by its ObjectID. The OBJECT and SIGNAL rows both lay down this pair, and
// so does a ptrcall returning an object.
constexpr uint32_t OBJECT_RECORD_SIZE = 2 * sizeof(uint64_t);

// The engine reads an ObjectID straight off the object, while reaching the JVM binding for it goes through
// object_get_instance_binding and its mutex. Only a RefCounted needs the binding here, to record the delivery and take
// the JVM's reference on the first one; for every object the JVM creates the binding itself, once, when it has no
// wrapper yet and calls MemoryManager::bind_object.
static void write_object_record(uint8_t* p_slot, raw_godot::RawObject p_object) {
    uint64_t record[2] = {0, 0};
    if (!p_object.is_null()) {
        godot::ObjectID object_id(p_object.get_instance_id());
        if (object_id.is_ref_counted()) { godot::JvmBindingManager::bind(p_object); }
        record[0] = reinterpret_cast<uintptr_t>(p_object.ptr());
        record[1] = object_id;
    }
    memcpy(p_slot, record, sizeof(record));
}

// load and store carry the native value, for a caller that knows the type; decode and encode carry a Variant, for the
// tag tables that know only the ordinal. The two shapes below supply all four, so a row that uses one is a single
// line. Nothing here is named read or write: those belong to Transfer, which takes either kind and picks between
// these.

// A value stored inline with the engine's own layout: bool, numbers, math types and RID. The engine reads and writes
// exactly these bytes, so a ptrcall copies them as they are.
template<class T>
struct InlineWire {
    using Native = T;
    static constexpr Shape SHAPE = Shape::INLINE;
    static constexpr bool OWNS_NATIVE_INSTANCE = false;

    static Native load(ByteCursor& p_cursor) { return p_cursor.read<T>(); }

    static godot::Variant decode(ByteCursor& p_cursor) { return load(p_cursor); }

    static void store(ByteCursor& p_cursor, const Native& p_value) { p_cursor.write<T>(p_value); }

    static void encode(ByteCursor& p_cursor, const godot::Variant& p_variant) { store(p_cursor, p_variant); }
};

// A native core type the JVM owns an instance of: sent as a pointer, received as a fresh allocation.
template<class T>
struct PointerWire {
    using Native = T;
    static constexpr Shape SHAPE = Shape::POINTER;
    static constexpr bool OWNS_NATIVE_INSTANCE = true;

    static Native& load(ByteCursor& p_cursor) { return *p_cursor.read_pointer<Native>(); }

    static godot::Variant decode(ByteCursor& p_cursor) { return load(p_cursor); }

    static void store(ByteCursor& p_cursor, const Native& p_value) { p_cursor.write_pointer(p_value); }

    static void encode(ByteCursor& p_cursor, const godot::Variant& p_variant) {
        store(p_cursor, static_cast<Native>(p_variant));
    }
};

// Specialized for every type below and nothing else, so a type without a row fails to compile where the tables are
// built rather than at the call that needed it.
template<godot::Variant::Type>
struct Wire;

#define GODOT_JVM_WIRE(m_type, m_base) \
    template<>                         \
    struct Wire<godot::Variant::m_type> : m_base {};

GODOT_JVM_WIRE(BOOL, InlineWire<bool>)
GODOT_JVM_WIRE(INT, InlineWire<uint64_t>)
GODOT_JVM_WIRE(FLOAT, InlineWire<double>)
GODOT_JVM_WIRE(VECTOR2, InlineWire<godot::Vector2>)
GODOT_JVM_WIRE(VECTOR2I, InlineWire<godot::Vector2i>)
GODOT_JVM_WIRE(RECT2, InlineWire<godot::Rect2>)
GODOT_JVM_WIRE(RECT2I, InlineWire<godot::Rect2i>)
GODOT_JVM_WIRE(VECTOR3, InlineWire<godot::Vector3>)
GODOT_JVM_WIRE(VECTOR3I, InlineWire<godot::Vector3i>)
GODOT_JVM_WIRE(TRANSFORM2D, InlineWire<godot::Transform2D>)
GODOT_JVM_WIRE(VECTOR4, InlineWire<godot::Vector4>)
GODOT_JVM_WIRE(VECTOR4I, InlineWire<godot::Vector4i>)
GODOT_JVM_WIRE(PLANE, InlineWire<godot::Plane>)
GODOT_JVM_WIRE(QUATERNION, InlineWire<godot::Quaternion>)
GODOT_JVM_WIRE(AABB, InlineWire<godot::AABB>)
GODOT_JVM_WIRE(BASIS, InlineWire<godot::Basis>)
GODOT_JVM_WIRE(TRANSFORM3D, InlineWire<godot::Transform3D>)
GODOT_JVM_WIRE(PROJECTION, InlineWire<godot::Projection>)
GODOT_JVM_WIRE(COLOR, InlineWire<godot::Color>)
GODOT_JVM_WIRE(RID, InlineWire<godot::RID>)
GODOT_JVM_WIRE(STRING_NAME, PointerWire<godot::StringName>)
GODOT_JVM_WIRE(NODE_PATH, PointerWire<godot::NodePath>)
GODOT_JVM_WIRE(DICTIONARY, PointerWire<godot::Dictionary>)
GODOT_JVM_WIRE(ARRAY, PointerWire<godot::Array>)
GODOT_JVM_WIRE(PACKED_BYTE_ARRAY, PointerWire<godot::PackedByteArray>)
GODOT_JVM_WIRE(PACKED_INT32_ARRAY, PointerWire<godot::PackedInt32Array>)
GODOT_JVM_WIRE(PACKED_INT64_ARRAY, PointerWire<godot::PackedInt64Array>)
GODOT_JVM_WIRE(PACKED_FLOAT32_ARRAY, PointerWire<godot::PackedFloat32Array>)
GODOT_JVM_WIRE(PACKED_FLOAT64_ARRAY, PointerWire<godot::PackedFloat64Array>)
GODOT_JVM_WIRE(PACKED_STRING_ARRAY, PointerWire<godot::PackedStringArray>)
GODOT_JVM_WIRE(PACKED_VECTOR2_ARRAY, PointerWire<godot::PackedVector2Array>)
GODOT_JVM_WIRE(PACKED_VECTOR3_ARRAY, PointerWire<godot::PackedVector3Array>)
GODOT_JVM_WIRE(PACKED_COLOR_ARRAY, PointerWire<godot::PackedColorArray>)
GODOT_JVM_WIRE(PACKED_VECTOR4_ARRAY, PointerWire<godot::PackedVector4Array>)

#undef GODOT_JVM_WIRE

// Nothing crosses, so there is no native value and no shape a buffer could act on.
template<>
struct Wire<godot::Variant::NIL> {
    static constexpr Shape SHAPE = Shape::CUSTOM;
    static constexpr bool OWNS_NATIVE_INSTANCE = false;

    static godot::Variant decode(ByteCursor&) { return godot::Variant(); }

    static void encode(ByteCursor&, const godot::Variant&) {}
};

// An object crosses as a pointer, but unlike a POINTER row the pointer is the value rather than the address of a
// JVM-owned copy: nothing is dereferenced or allocated, and the ObjectID the JVM needs travels with it.
template<>
struct Wire<godot::Variant::OBJECT> {
    using Native = raw_godot::RawObject;
    static constexpr Shape SHAPE = Shape::OBJECT;
    static constexpr bool OWNS_NATIVE_INSTANCE = false;

    static Native load(ByteCursor& p_cursor) { return p_cursor.read<Native>(); }

    static godot::Variant decode(ByteCursor& p_cursor) { return load(p_cursor).to_variant(); }

    static void store(ByteCursor& p_cursor, Native p_object) {
        write_object_record(p_cursor.reserve(OBJECT_RECORD_SIZE), p_object);
    }

    static void encode(ByteCursor& p_cursor, const godot::Variant& p_variant) {
        store(p_cursor, raw_godot::RawObject::from_variant(p_variant));
    }

    // A ptrcall writes a bare pointer where the slot must end up holding an object record, and writes nothing at all
    // for a null return, so the slot is zeroed before the call and rewritten after it.
    static void prepare_return(uint8_t* p_slot) { memset(p_slot, 0, sizeof(Native)); }

    static void finish_return(uint8_t* p_slot, bool p_release_engine_ref) {
        Native returned = *reinterpret_cast<Native*>(p_slot);
        write_object_record(p_slot, returned);

        if (p_release_engine_ref && !returned.is_null() && unlikely(returned.unreference())) { returned.destroy(); }
    }
};

// A string travels inline as UTF-8 behind a one-byte flag, or through the LongStringQueue when it exceeds the limit.
template<>
struct Wire<godot::Variant::STRING> {
    using Native = godot::String;
    static constexpr Shape SHAPE = Shape::CUSTOM;
    static constexpr bool OWNS_NATIVE_INSTANCE = false;

    static Native load(ByteCursor& p_cursor) {
        bool is_long = p_cursor.read<uint8_t>() != 0;
        if (unlikely(is_long)) { return LongStringQueue::get_instance().poll_string(); }
        uint32_t size = p_cursor.read<uint32_t>();
        return godot::String::utf8(reinterpret_cast<const char*>(p_cursor.read_bytes(size)), size);
    }

    static godot::Variant decode(ByteCursor& p_cursor) { return load(p_cursor); }

    static void store(ByteCursor& p_cursor, const Native& p_value) {
        const godot::CharString& char_string = p_value.utf8();
        int size = char_string.size();
        if (unlikely(size > LongStringQueue::max_string_size)) {
            p_cursor.write<uint8_t>(1);
            jni::Env& env = jni::Jvm::current_env();
            LongStringQueue::get_instance().send_string_to_jvm(env, p_value);
            return;
        }
        p_cursor.write<uint8_t>(0);
        p_cursor.write<uint32_t>(size);
        p_cursor.write_bytes(char_string.get_data(), size);
    }

    static void encode(ByteCursor& p_cursor, const godot::Variant& p_variant) {
        store(p_cursor, static_cast<Native>(p_variant));
    }
};

// A Callable is a pointer to a native instance the JVM creates on the fly, so it reads and writes like any
// pointer-backed type. It stays off the ptrcall deliberately: that instance is owned by a JVM wrapper which is
// already unreachable once its pointer reaches the buffer, so the binding keeps the engine reading a copy it made
// here rather than handing it the instance itself.
template<>
struct Wire<godot::Variant::CALLABLE> {
    using Native = godot::Callable;
    static constexpr Shape SHAPE = Shape::CUSTOM;
    static constexpr bool OWNS_NATIVE_INSTANCE = true;

    static Native& load(ByteCursor& p_cursor) { return *p_cursor.read_pointer<Native>(); }

    static godot::Variant decode(ByteCursor& p_cursor) { return load(p_cursor); }

    static void store(ByteCursor& p_cursor, const Native& p_value) { p_cursor.write_pointer(p_value); }

    static void encode(ByteCursor& p_cursor, const godot::Variant& p_variant) {
        store(p_cursor, static_cast<Native>(p_variant));
    }
};

template<>
struct Wire<godot::Variant::SIGNAL> {
    using Native = godot::Signal;
    static constexpr Shape SHAPE = Shape::CUSTOM;
    // The row allocates the StringName it pairs with the object, never a Signal.
    static constexpr bool OWNS_NATIVE_INSTANCE = false;

    static Native load(ByteCursor& p_cursor) {
        raw_godot::RawObject object = p_cursor.read_pointer<godot::GodotObject>();
        const godot::StringName name = *p_cursor.read_pointer<godot::StringName>();
        return object.to_signal(name);
    }

    static godot::Variant decode(ByteCursor& p_cursor) { return load(p_cursor); }

    static void store(ByteCursor& p_cursor, const Native& p_value) {
        write_object_record(p_cursor.reserve(OBJECT_RECORD_SIZE), p_value.get_object());
        p_cursor.write_pointer(p_value.get_name());
    }

    static void encode(ByteCursor& p_cursor, const godot::Variant& p_variant) {
        store(p_cursor, static_cast<Native>(p_variant));
    }
};

#endif // GODOT_JVM_VARIANT_TYPE_H
