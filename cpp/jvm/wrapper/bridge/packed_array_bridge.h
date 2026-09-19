#ifndef GODOT_JVM_PACKED_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_ARRAY_BRIDGE_H

#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/wrapper/jvm_singleton_wrapper.h"
#include "jvm/wrapper/memory/transfer_context.h"

#include <variant/packed_byte_array.hpp>
#include <variant/packed_color_array.hpp>
#include <variant/packed_float32_array.hpp>
#include <variant/packed_float64_array.hpp>
#include <variant/packed_int32_array.hpp>
#include <variant/packed_int64_array.hpp>
#include <variant/packed_string_array.hpp>
#include <variant/packed_vector2_array.hpp>
#include <variant/packed_vector3_array.hpp>
#include <variant/packed_vector4_array.hpp>
#include <variant/typed_array.hpp>

namespace bridges {
    // Variant only has conversions to/from the concrete Packed*Array types, not godot-cpp's generic Vector<T> — map
    // each bridge's element type to its real backing Packed*Array type.
    template<typename T>
    struct PackedArrayTypeTrait;

    template<>
    struct PackedArrayTypeTrait<uint8_t> {
        using type = godot::PackedByteArray;
    };

    template<>
    struct PackedArrayTypeTrait<godot::Color> {
        using type = godot::PackedColorArray;
    };

    template<>
    struct PackedArrayTypeTrait<float> {
        using type = godot::PackedFloat32Array;
    };

    template<>
    struct PackedArrayTypeTrait<double> {
        using type = godot::PackedFloat64Array;
    };

    template<>
    struct PackedArrayTypeTrait<int> {
        using type = godot::PackedInt32Array;
    };

    template<>
    struct PackedArrayTypeTrait<int64_t> {
        using type = godot::PackedInt64Array;
    };

    template<>
    struct PackedArrayTypeTrait<godot::String> {
        using type = godot::PackedStringArray;
    };

    template<>
    struct PackedArrayTypeTrait<godot::Vector2> {
        using type = godot::PackedVector2Array;
    };

    template<>
    struct PackedArrayTypeTrait<godot::Vector3> {
        using type = godot::PackedVector3Array;
    };

    template<>
    struct PackedArrayTypeTrait<godot::Vector4> {
        using type = godot::PackedVector4Array;
    };

    // PackedByteArray has no to_byte_array() of its own (it already is bytes); every other Packed*Array type exposes
    // one returning a real PackedByteArray copy.
    inline godot::PackedByteArray packed_array_to_byte_array(const godot::PackedByteArray& p_array) {
        return p_array;
    }

    template<typename PackedType>
    godot::PackedByteArray packed_array_to_byte_array(const PackedType& p_array) {
        return p_array.to_byte_array();
    }
} // namespace bridges

#define PACKED_ARRAY_BRIDGE(NAME, ELEMENT_TYPE, FQNAME)                \
    inline static constexpr const char NAME##QualifiedName[] = FQNAME; \
    class NAME : public PackedArrayBridge<NAME, ELEMENT_TYPE, NAME##QualifiedName>

#define PACKED_ARRAY_BRIDGE_CLASS(NAME, ELEMENT_TYPE)                                   \
    friend class PackedArrayBridge<NAME, ELEMENT_TYPE, NAME##QualifiedName>;            \
    friend class JvmSingletonWrapper<NAME, NAME##QualifiedName>;                        \
    JVM_CLASS(NAME)                                                                     \
                                                                                        \
public:                                                                                 \
    NAME(const NAME&) = delete;                                                         \
    void operator=(const NAME&) = delete;                                               \
    NAME& operator=(NAME&&) noexcept = delete;                                          \
    NAME(NAME&&) noexcept = delete;                                                     \
                                                                                        \
protected:                                                                              \
    explicit NAME(jni::Env& p_env, jni::JObject p_wrapped) :                            \
        PackedArrayBridge<NAME, ELEMENT_TYPE, NAME##QualifiedName>(p_env, p_wrapped) {} \
    ~NAME();

namespace bridges {

    template<class Derived, class T, const char* fq_name>
    class PackedArrayBridge : public JvmSingletonWrapper<Derived, fq_name> {
        friend class JvmSingletonWrapper<Derived, fq_name>;

        using PackedType = typename PackedArrayTypeTrait<T>::type;

    public:
        PackedArrayBridge(const PackedArrayBridge<Derived, T, fq_name>&) = delete;
        void operator=(const PackedArrayBridge<Derived, T, fq_name>&) = delete;
        PackedArrayBridge<Derived, T, fq_name>& operator=(PackedArrayBridge<Derived, T, fq_name>&&) noexcept = delete;
        PackedArrayBridge(PackedArrayBridge<Derived, T, fq_name>&&) noexcept = delete;

    protected:
        explicit PackedArrayBridge(jni::Env& p_env, jni::JObject p_wrapped);
        ~PackedArrayBridge() = default;

        // clang-format off
        INIT_JNI_BINDINGS(
            INIT_NATIVE_METHOD("engine_call_constructor", "()J", (PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor))
            INIT_NATIVE_METHOD("engine_call_constructor_packed_array", "()J", (PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor_packed_array))
            INIT_NATIVE_METHOD("engine_call_constructor_array", "()J", (PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor_array))
            INIT_NATIVE_METHOD("engine_call_append", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_append))
            INIT_NATIVE_METHOD("engine_call_appendArray", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_appendArray))
            INIT_NATIVE_METHOD("engine_call_bsearch", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_bsearch))
            INIT_NATIVE_METHOD("engine_call_clear", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_clear))
            INIT_NATIVE_METHOD("engine_call_count", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_count))
            INIT_NATIVE_METHOD("engine_call_duplicate", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_duplicate))
            INIT_NATIVE_METHOD("engine_call_fill", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_fill))
            INIT_NATIVE_METHOD("engine_call_find", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_find))
            INIT_NATIVE_METHOD("engine_call_is_empty", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_is_empty))
            INIT_NATIVE_METHOD("engine_call_get", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_get))
            INIT_NATIVE_METHOD("engine_call_has", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_has))
            INIT_NATIVE_METHOD("engine_call_insert", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_insert))
            INIT_NATIVE_METHOD("engine_call_reverse", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_reverse))
            INIT_NATIVE_METHOD("engine_call_pushback", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_pushback))
            INIT_NATIVE_METHOD("engine_call_remove_at", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_remove_at))
            INIT_NATIVE_METHOD("engine_call_resize", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_resize))
            INIT_NATIVE_METHOD("engine_call_rfind", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_rfind))
            INIT_NATIVE_METHOD("engine_call_set", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_set))
            INIT_NATIVE_METHOD("engine_call_size", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_size))
            INIT_NATIVE_METHOD("engine_call_slice", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_slice))
            INIT_NATIVE_METHOD("engine_call_sort", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_sort))
            INIT_NATIVE_METHOD("engine_call_to_byte_array", "(J)V", (PackedArrayBridge<Derived, T, fq_name>::engine_call_to_byte_array))
        )
        // clang-format on

    public:
        static uintptr_t engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_packed_array(JNIEnv* p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_array(JNIEnv* p_raw_env, jobject p_instance);

        static void engine_call_append(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_appendArray(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_bsearch(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_clear(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_count(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_duplicate(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_fill(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_find(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_insert(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_reverse(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_rfind(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_pushback(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_remove_at(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_resize(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_slice(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_sort(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_to_byte_array(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
    };

    template<class Derived, class T, const char* fq_name>
    uintptr_t PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor(JNIEnv*, jobject) {
        return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(PackedType()));
    }

    template<class Derived, class T, const char* fq_name>
    uintptr_t PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor_packed_array(JNIEnv* p_raw_env, jobject) {
        jni::Env env(p_raw_env);
        PackedType from;
        TransferContext::read_values(env, from);
        return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(PackedType(from)));
    }

    template<class Derived, class T, const char* fq_name>
    uintptr_t PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor_array(JNIEnv* p_raw_env, jobject) {
        jni::Env env(p_raw_env);
        godot::Array array;
        TransferContext::read_values(env, array);

        PackedType* ret = VariantAllocator::alloc(PackedType());
        int64_t size = array.size();
        ret->resize(size);
        for (int64_t i = 0; i < size; ++i) {
            (*ret)[i] = static_cast<T>(array[i]);
        }
        return reinterpret_cast<uintptr_t>(ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_append(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        TransferContext::read_values(env, value);
        native<PackedType>(p_handle).append(value);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_appendArray(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        PackedType array;
        TransferContext::read_values(env, array);
        native<PackedType>(p_handle).append_array(array);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_bsearch(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        bool before;
        TransferContext::read_values(env, value, before);
        int64_t index = native<PackedType>(p_handle).bsearch(value, before);
        TransferContext::write_value(env, index);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_clear(JNIEnv*, jobject, jlong p_handle) {
        native<PackedType>(p_handle).clear();
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_count(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        TransferContext::read_values(env, value);
        int64_t count = native<PackedType>(p_handle).count(value);
        TransferContext::write_value(env, count);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_duplicate(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        PackedType copy = native<PackedType>(p_handle).duplicate();
        TransferContext::write_value(env, copy);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_fill(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        TransferContext::read_values(env, value);
        native<PackedType>(p_handle).fill(value);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_find(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        TransferContext::read_values(env, value);
        int64_t index = native<PackedType>(p_handle).find(value);
        TransferContext::write_value(env, index);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_get(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t index;
        TransferContext::read_values(env, index);
        T element = native<PackedType>(p_handle).operator[](index);
        TransferContext::write_value(env, element);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_has(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        TransferContext::read_values(env, value);
        bool found = native<PackedType>(p_handle).has(value);
        TransferContext::write_value(env, found);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_insert(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t index;
        T value;
        TransferContext::read_values(env, index, value);
        native<PackedType>(p_handle).insert(index, value);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_is_empty(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        bool empty = native<PackedType>(p_handle).is_empty();
        TransferContext::write_value(env, empty);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_reverse(JNIEnv*, jobject, jlong p_handle) {
        native<PackedType>(p_handle).reverse();
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_rfind(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        int64_t from;
        TransferContext::read_values(env, value, from);
        int64_t index = native<PackedType>(p_handle).rfind(value, from);
        TransferContext::write_value(env, index);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_pushback(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        T value;
        TransferContext::read_values(env, value);
        native<PackedType>(p_handle).push_back(value);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_remove_at(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t index;
        TransferContext::read_values(env, index);
        native<PackedType>(p_handle).remove_at(index);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_resize(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t size;
        TransferContext::read_values(env, size);
        native<PackedType>(p_handle).resize(size);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_set(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t index;
        T value;
        TransferContext::read_values(env, index, value);
        native<PackedType>(p_handle).set(index, value);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_size(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t size = native<PackedType>(p_handle).size();
        TransferContext::write_value(env, size);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_slice(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        int64_t begin;
        int64_t end;
        TransferContext::read_values(env, begin, end);
        PackedType slice = native<PackedType>(p_handle).slice(begin, end);
        TransferContext::write_value(env, slice);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_sort(JNIEnv*, jobject, jlong p_handle) {
        native<PackedType>(p_handle).sort();
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_to_byte_array(JNIEnv* p_raw_env, jobject, jlong p_handle) {
        jni::Env env(p_raw_env);
        godot::PackedByteArray bytes = packed_array_to_byte_array(native<PackedType>(p_handle));
        TransferContext::write_value(env, bytes);
    }

    template<class Derived, class T, const char* fq_name>
    PackedArrayBridge<Derived, T, fq_name>::PackedArrayBridge(jni::Env& p_env, jni::JObject p_wrapped) :
        JvmSingletonWrapper<Derived, fq_name>(p_env, p_wrapped) {}
} // namespace bridges

#endif // GODOT_JVM_PACKED_ARRAY_BRIDGE_H
