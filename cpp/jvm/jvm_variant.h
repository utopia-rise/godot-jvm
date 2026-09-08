#ifndef GODOT_JVM_JVM_VARIANT_H
#define GODOT_JVM_JVM_VARIANT_H

#include "core/jvm_binding_manager.h"
#include "engine/marshalls.h"
#include "engine/godot_object.h"
#include "jvm/jni/wrapper.h"
#include "jvm/wrapper/memory/long_string_queue.h"
#include "jvm/wrapper/memory/type_manager.h"
#include "logging.h"
#include "shared_buffer.h"
#include "core/variant_allocator.h"

#include <classes/os.hpp>
#include <classes/wrapped.hpp>
#include <core/object.hpp>
#include <variant/signal.hpp>
#include <variant/variant.hpp>

constexpr const int BOOL_SIZE = 4;
constexpr const int PTR_SIZE = 8;
constexpr const int INT_SIZE = 4;

class VariantToBuffer {
    template<godot::Variant::Type variantType, class T>
    static void write_core_type(SharedBuffer* des, const godot::Variant& src) {
        set_variant_type(des, variantType);

        *reinterpret_cast<T*>(des->get_cursor()) = src;
        des->increment_position(sizeof(T));
    }

    template<class TNativeCoreType>
    inline static void write_pointer(SharedBuffer* des, TNativeCoreType native_core_type) {
        des->increment_position(
          encode_uint64(reinterpret_cast<uintptr_t>(VariantAllocator::alloc(TNativeCoreType(native_core_type))), des->get_cursor())
        );
    }

    template<godot::Variant::Type variantType, class TNativeCoreType, TNativeCoreType (godot::Variant::* converter)() const>
    static void write_native_core_type(SharedBuffer* des, const godot::Variant& src) {
        set_variant_type(des, variantType);
        write_pointer(des, (src.*converter)());
    }

    static void set_variant_type(SharedBuffer* des, godot::Variant::Type variant_type) {
        des->increment_position(encode_uint32(variant_type, des->get_cursor()));
    }

    static void write_nil(SharedBuffer* des, const godot::Variant&) {
        set_variant_type(des, godot::Variant::Type::NIL);
    }

    static void write_bool(SharedBuffer* des, const godot::Variant& src) {
        set_variant_type(des, godot::Variant::Type::BOOL);
        des->increment_position(encode_uint32(src.operator bool(), des->get_cursor()));
    }

    static void write_string(SharedBuffer* des, const godot::Variant& src) {
        godot::String str = src;
        const godot::CharString& char_string = str.utf8();
        set_variant_type(des, godot::Variant::Type::STRING);
        if (int size = char_string.size(); unlikely(size > LongStringQueue::max_string_size)) {
            des->increment_position(encode_uint32(true, des->get_cursor()));
            jni::Env env = jni::Jvm::current_env();
            LongStringQueue::get_instance().send_string_to_jvm(env, str);
        } else {
            des->increment_position(encode_uint32(false, des->get_cursor()));
            des->increment_position(encode_uint32(char_string.size(), des->get_cursor()));
            if (likely(size > 0)) { des->increment_position(encode_cstring(char_string.get_data(), des->get_cursor())); }
        }
    }

    static void write_array(SharedBuffer* des, const godot::Variant& src) {
        godot::Array arr = src.operator godot::Array();
        uint64_t type = arr.get_typed_builtin();
        set_variant_type(des, godot::Variant::Type::ARRAY);
        des->increment_position(encode_uint64(reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Array(arr))), des->get_cursor()));
        des->increment_position(encode_uint64(type, des->get_cursor()));
    }

    static void write_dictionary(SharedBuffer* des, const godot::Variant& src) {
        godot::Dictionary dict = src.operator godot::Dictionary();
        uint64_t key_type = dict.get_typed_key_builtin();
        uint64_t value_type = dict.get_typed_value_builtin();
        set_variant_type(des, godot::Variant::Type::DICTIONARY);
        des->increment_position(encode_uint64(reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Dictionary(dict))), des->get_cursor()));
        des->increment_position(encode_uint64(key_type, des->get_cursor()));
        des->increment_position(encode_uint64(value_type, des->get_cursor()));
    }

    // Takes the raw engine pointer, never a godot-cpp `Object*`: that parameter type is exactly what used to make
    // Variant::operator Object*() fire and build a wrapper here (see RawObject::from_variant() in engine/godot_object.h).
    static void append_object(SharedBuffer* des, godot::GodotObject* p_raw_object) {
        if (p_raw_object == nullptr) {
            des->increment_position(encode_uint32(0, des->get_cursor()));
            des->increment_position(encode_uint64(0, des->get_cursor()));
            des->increment_position(encode_uint64(0, des->get_cursor()));
            return;
        }

        // Create a binding if it doesn't exist yet.
        godot::JvmBinding* binding = godot::JvmBindingManager::get_instance_binding(p_raw_object);
        int constructorID = binding->get_constructor_id();

        // The JVM only ever deals in raw engine pointers, never godot-cpp's wrapper pointers (see to_raw_object() below, and JvmBindingManager, for the other side of this contract).
        des->increment_position(encode_uint32(constructorID, des->get_cursor()));
        des->increment_position(encode_uint64(reinterpret_cast<uintptr_t>(p_raw_object), des->get_cursor()));
        des->increment_position(encode_uint64(raw_godot::RawObject(p_raw_object).get_instance_id(), des->get_cursor()));
    }

    static void write_object(SharedBuffer* des, const godot::Variant& src) {
        set_variant_type(des, godot::Variant::Type::OBJECT);
        append_object(des, raw_godot::RawObject::from_variant(src));
    }


    static void write_signal(SharedBuffer* des, const godot::Variant& src) {
        godot::Signal signal = src.operator godot::Signal();
        set_variant_type(des, godot::Variant::Type::SIGNAL);
        // get_object_id() rather than get_object(): the latter returns a godot-cpp wrapper.
        const int64_t object_id = signal.get_object_id();
        append_object(
          des,
          object_id != 0 ? raw_godot::RawObject::from_instance_id(object_id) : raw_godot::RawObject()
        );
        write_pointer<godot::StringName>(des, signal.get_name());
    }

public:

    static void write_variant(const godot::Variant& variant, SharedBuffer* byte_buffer) {
        // must match the value order of godot_variant_type
        static void (*variant_writers[godot::Variant::VARIANT_MAX])(SharedBuffer*, const godot::Variant&) = {
            &VariantToBuffer::write_nil,

            // atomic types
            &VariantToBuffer::write_bool,
            &VariantToBuffer::write_core_type<godot::Variant::INT, uint64_t>,
            &VariantToBuffer::write_core_type<godot::Variant::FLOAT, double>,
            &VariantToBuffer::write_string,

            // math types
            &VariantToBuffer::write_core_type<godot::Variant::VECTOR2, godot::Vector2>,
            &VariantToBuffer::write_core_type<godot::Variant::VECTOR2I, godot::Vector2i>,
            &VariantToBuffer::write_core_type<godot::Variant::RECT2, godot::Rect2>,
            &VariantToBuffer::write_core_type<godot::Variant::RECT2I, godot::Rect2i>,
            &VariantToBuffer::write_core_type<godot::Variant::VECTOR3, godot::Vector3>,
            &VariantToBuffer::write_core_type<godot::Variant::VECTOR3I, godot::Vector3i>,
            &VariantToBuffer::write_core_type<godot::Variant::TRANSFORM2D, godot::Transform2D>,
            &VariantToBuffer::write_core_type<godot::Variant::VECTOR4, godot::Vector4>,
            &VariantToBuffer::write_core_type<godot::Variant::VECTOR4I, godot::Vector4i>,
            &VariantToBuffer::write_core_type<godot::Variant::PLANE, godot::Plane>,
            &VariantToBuffer::write_core_type<godot::Variant::QUATERNION, godot::Quaternion>,
            &VariantToBuffer::write_core_type<godot::Variant::AABB, godot::AABB>,
            &VariantToBuffer::write_core_type<godot::Variant::BASIS, godot::Basis>,
            &VariantToBuffer::write_core_type<godot::Variant::TRANSFORM3D, godot::Transform3D>,
            &VariantToBuffer::write_core_type<godot::Variant::PROJECTION, godot::Projection>,

            // misc types
            &VariantToBuffer::write_core_type<godot::Variant::COLOR, godot::Color>,
            &VariantToBuffer::write_native_core_type<godot::Variant::STRING_NAME, godot::StringName,&godot::Variant::operator godot::StringName>,
            &VariantToBuffer::write_native_core_type<godot::Variant::NODE_PATH, godot::NodePath,&godot::Variant::operator godot::NodePath>,
            &VariantToBuffer::write_core_type<godot::Variant::RID, godot::RID>,
            &VariantToBuffer::write_object,
            &VariantToBuffer::write_native_core_type<godot::Variant::CALLABLE, godot::Callable, &godot::Variant::operator godot::Callable>,
            &VariantToBuffer::write_signal,
            &VariantToBuffer::write_dictionary,
            &VariantToBuffer::write_array,

            // typed arrays
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_BYTE_ARRAY,godot::PackedByteArray, &godot::Variant::operator godot::PackedByteArray>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_INT32_ARRAY,godot::PackedInt32Array, &godot::Variant::operator godot::PackedInt32Array>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_INT64_ARRAY,godot::PackedInt64Array, &godot::Variant::operator godot::PackedInt64Array>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_FLOAT32_ARRAY,godot::PackedFloat32Array, &godot::Variant::operator godot::PackedFloat32Array>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_FLOAT64_ARRAY,godot::PackedFloat64Array, &godot::Variant::operator godot::PackedFloat64Array>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_STRING_ARRAY,godot::PackedStringArray, &godot::Variant::operator godot::PackedStringArray>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_VECTOR2_ARRAY,godot::PackedVector2Array, &godot::Variant::operator godot::PackedVector2Array>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_VECTOR3_ARRAY,godot::PackedVector3Array, &godot::Variant::operator godot::PackedVector3Array>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_COLOR_ARRAY,godot::PackedColorArray, &godot::Variant::operator godot::PackedColorArray>,
            &VariantToBuffer::write_native_core_type<godot::Variant::PACKED_VECTOR4_ARRAY,godot::PackedVector4Array, &godot::Variant::operator godot::PackedVector4Array>
        };

        godot::Variant::Type type = variant.get_type();
        variant_writers[type](byte_buffer, variant);
    }
};


class BufferToVariant {
    template<class T>
    static godot::Variant read_core_type(SharedBuffer* byte_buffer) {
        T* result = reinterpret_cast<T*>(byte_buffer->get_cursor());
        byte_buffer->increment_position(sizeof(T));
        return *result;
    }

    template<class T>
    static inline T* read_pointer(SharedBuffer* byte_buffer) {
        auto ptr = static_cast<uintptr_t>(decode_uint64(byte_buffer->get_cursor()));
        byte_buffer->increment_position(PTR_SIZE);
        return reinterpret_cast<T*>(ptr);
    }

    template<class T>
    static godot::Variant read_native_core_type(SharedBuffer* byte_buffer) {
        return *read_pointer<T>(byte_buffer);
    }

    static godot::Variant read_nil(SharedBuffer*) {
        return {};
    }

    static godot::Variant read_bool(SharedBuffer* byte_buffer) {
        bool b = static_cast<bool>(decode_uint32(byte_buffer->get_cursor()));
        byte_buffer->increment_position(BOOL_SIZE);
        return b;
    }

    static godot::Variant read_string(SharedBuffer* byte_buffer) {
        bool is_long = static_cast<bool>(decode_uint32(byte_buffer->get_cursor()));
        byte_buffer->increment_position(BOOL_SIZE);
        if (unlikely(is_long)) {
            godot::String str = LongStringQueue::get_instance().poll_string();
            return str;
        } else {
            uint32_t size = decode_uint32(byte_buffer->get_cursor());
            byte_buffer->increment_position(INT_SIZE);
            godot::String str = godot::String::utf8(reinterpret_cast<const char*>(byte_buffer->get_cursor()), size);
            byte_buffer->increment_position(size);
            return str;
        }
    }

    // The buffer already holds the raw engine pointer (see append_object() above), so hand it straight back: wrapping
    // it via get_object_instance_binding() only to have Variant/Signal read `_owner` off the wrapper again would
    // attach a permanent godot-cpp instance binding for nothing.
    static inline godot::GodotObject* to_raw_object(SharedBuffer* byte_buffer) {
        auto ptr = static_cast<uintptr_t>(decode_uint64(byte_buffer->get_cursor()));
        byte_buffer->increment_position(PTR_SIZE);
        return reinterpret_cast<godot::GodotObject*>(ptr);
    }

    static godot::Variant read_object(SharedBuffer* byte_buffer) {
        return raw_godot::RawObject(to_raw_object(byte_buffer)).to_variant();
    }

    static godot::Variant read_signal(SharedBuffer* byte_buffer) {
        godot::GodotObject* object = to_raw_object(byte_buffer);
        const godot::StringName name = *read_pointer<godot::StringName>(byte_buffer);
        return raw_godot::RawObject(object).to_signal(name);
    }

public:

    static void read_variant(SharedBuffer* byte_buffer, godot::Variant& res) {
        static godot::Variant (*variant_readers[godot::Variant::VARIANT_MAX])(SharedBuffer*) = {
          &BufferToVariant::read_nil,

          // atomic types
          &BufferToVariant::read_bool,
          &BufferToVariant::read_core_type<uint64_t>,
          &BufferToVariant::read_core_type<double>,
          &BufferToVariant::read_string,

          // math types
          &BufferToVariant::read_core_type<godot::Vector2>,
          &BufferToVariant::read_core_type<godot::Vector2i>,
          &BufferToVariant::read_core_type<godot::Rect2>,
          &BufferToVariant::read_core_type<godot::Rect2i>,
          &BufferToVariant::read_core_type<godot::Vector3>,
          &BufferToVariant::read_core_type<godot::Vector3i>,
          &BufferToVariant::read_core_type<godot::Transform2D>,
          &BufferToVariant::read_core_type<godot::Vector4>,
          &BufferToVariant::read_core_type<godot::Vector4i>,
          &BufferToVariant::read_core_type<godot::Plane>,
          &BufferToVariant::read_core_type<godot::Quaternion>,
          &BufferToVariant::read_core_type<godot::AABB>,
          &BufferToVariant::read_core_type<godot::Basis>,
          &BufferToVariant::read_core_type<godot::Transform3D>,
          &BufferToVariant::read_core_type<godot::Projection>,

          // misc types
          &BufferToVariant::read_core_type<godot::Color>,
          &BufferToVariant::read_native_core_type<godot::StringName>,
          &BufferToVariant::read_native_core_type<godot::NodePath>,
          &BufferToVariant::read_core_type<godot::RID>,
          &BufferToVariant::read_object,
          &BufferToVariant::read_native_core_type<godot::Callable>,
          &BufferToVariant::read_signal,
          &BufferToVariant::read_native_core_type<godot::Dictionary>,
          &BufferToVariant::read_native_core_type<godot::Array>,

          // typed arrays
          &BufferToVariant::read_native_core_type<godot::PackedByteArray>,
          &BufferToVariant::read_native_core_type<godot::PackedInt32Array>,
          &BufferToVariant::read_native_core_type<godot::PackedInt64Array>,
          &BufferToVariant::read_native_core_type<godot::PackedFloat32Array>,
          &BufferToVariant::read_native_core_type<godot::PackedFloat64Array>,
          &BufferToVariant::read_native_core_type<godot::PackedStringArray>,
          &BufferToVariant::read_native_core_type<godot::PackedVector2Array>,
          &BufferToVariant::read_native_core_type<godot::PackedVector3Array>,
          &BufferToVariant::read_native_core_type<godot::PackedColorArray>,
          &BufferToVariant::read_native_core_type<godot::PackedVector4Array>
        };

        uint32_t variant_type_int = decode_uint32(byte_buffer->get_cursor());
        byte_buffer->increment_position(4);
        res = variant_readers[variant_type_int](byte_buffer);
    }
};

#endif // GODOT_JVM_JVM_VARIANT_H
