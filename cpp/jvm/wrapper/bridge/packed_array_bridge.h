#ifndef GODOT_JVM_PACKED_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_ARRAY_BRIDGE_H

#include "bridges_utils.h"
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
    // Variant only has conversions to/from the concrete Packed*Array types, not godot-cpp's generic Vector<T> — map each bridge's element type to its real backing Packed*Array type.
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

    // PackedByteArray has no to_byte_array() of its own (it already is bytes); every other Packed*Array type exposes one returning a real PackedByteArray copy.
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

#define PACKED_ARRAY_BRIDGE_CLASS(NAME, ELEMENT_TYPE)                                 \
    friend class PackedArrayBridge<NAME, ELEMENT_TYPE, NAME##QualifiedName>;          \
    friend class JvmSingletonWrapper<NAME, NAME##QualifiedName>;                      \
    JVM_CLASS(NAME)                                                                   \
                                                                                      \
public:                                                                               \
    NAME(const NAME&) = delete;                                                       \
    void operator=(const NAME&) = delete;                                             \
    NAME& operator=(NAME&&) noexcept = delete;                                        \
    NAME(NAME&&) noexcept = delete;                                                   \
                                                                                      \
protected:                                                                            \
    explicit NAME(jni::Env& p_env, jni::JObject p_wrapped) :                          \
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

        static void engine_call_append(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_appendArray(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_bsearch(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_clear(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_count(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_duplicate(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_fill(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_find(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_insert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_reverse(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_rfind(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_pushback(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_remove_at(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_resize(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_slice(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_sort(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_to_byte_array(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };

    template<class Derived, class T, const char* fq_name>
    uintptr_t PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor(JNIEnv*, jobject) {
        return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(PackedType()));
    }

    template<class Derived, class T, const char* fq_name>
    uintptr_t PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor_packed_array(JNIEnv* p_raw_env, jobject) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(PackedType(args[0].operator PackedType())));
    }

    template<class Derived, class T, const char* fq_name>
    uintptr_t PackedArrayBridge<Derived, T, fq_name>::engine_call_constructor_array(JNIEnv* p_raw_env, jobject) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);

        // Brace-init here would resolve to Array's std::initializer_list<Variant> constructor instead of its
        // copy/move constructor, since Array converts implicitly to Variant -- wrapping the whole source array
        // as a single nested element rather than copying its contents. Use copy-initialization instead.
        godot::Array array = args[0].operator godot::Array();
        auto* ret = VariantAllocator::alloc(PackedType());
        int64_t size = array.size();
        ret->resize(size);
        for (int64_t i = 0; i < size; ++i) {
            (*ret)[i] = static_cast<T>(array[i]);
        }
        return reinterpret_cast<uintptr_t>(ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_append(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->append(args[0].operator T());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_appendArray(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->append_array(args[0].operator PackedType());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_bsearch(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[2];
        TransferContext::get_instance().read_args(env, args);
        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->bsearch(args[0].operator T(), args[1].operator bool());
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_clear(JNIEnv*, jobject, jlong p_raw_ptr) {
        from_uint_to_ptr<PackedType>(p_raw_ptr)->clear();
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_count(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);

        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->count(args[0].operator T());
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_duplicate(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->duplicate();
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_fill(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->fill(args[0].operator T());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_find(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->find(args[0].operator T());
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_get(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        godot::Variant variant = from_uint_to_ptr<PackedType>(p_raw_ptr)->operator[](args[0].operator unsigned int());
        TransferContext::get_instance().write_return_value(env, variant);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_has(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->has(args[0].operator T());
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_insert(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[2];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->insert(args[0].operator unsigned int(), args[1].operator T());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_is_empty(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant variant = from_uint_to_ptr<PackedType>(p_raw_ptr)->is_empty();
        TransferContext::get_instance().write_return_value(env, variant);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_reverse(JNIEnv*, jobject, jlong p_raw_ptr) {
        from_uint_to_ptr<PackedType>(p_raw_ptr)->reverse();
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_rfind(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[2];
        TransferContext::get_instance().read_args(env, args);

        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->rfind(args[0].operator T(), args[1].operator int());
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_pushback(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->push_back(args[0].operator T());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_remove_at(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->remove_at(args[0].operator unsigned int());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_resize(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[1];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->resize(args[0].operator unsigned int());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_set(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[2];
        TransferContext::get_instance().read_args(env, args);
        from_uint_to_ptr<PackedType>(p_raw_ptr)->set(args[0].operator unsigned int(), args[1].operator T());
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_size(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant variant = from_uint_to_ptr<PackedType>(p_raw_ptr)->size();
        TransferContext::get_instance().write_return_value(env, variant);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_slice(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant args[2];
        TransferContext::get_instance().read_args(env, args);

        godot::Variant ret = from_uint_to_ptr<PackedType>(p_raw_ptr)->slice(args[0].operator int(), args[1].operator int());
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_sort(JNIEnv*, jobject, jlong p_raw_ptr) {
        from_uint_to_ptr<PackedType>(p_raw_ptr)->sort();
    }

    template<class Derived, class T, const char* fq_name>
    void PackedArrayBridge<Derived, T, fq_name>::engine_call_to_byte_array(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
        jni::Env env = p_raw_env;
        godot::Variant ret = packed_array_to_byte_array(*from_uint_to_ptr<PackedType>(p_raw_ptr));
        TransferContext::get_instance().write_return_value(env, ret);
    }

    template<class Derived, class T, const char* fq_name>
    PackedArrayBridge<Derived, T, fq_name>::PackedArrayBridge(jni::Env& p_env, jni::JObject p_wrapped) :
      JvmSingletonWrapper<Derived, fq_name>(p_env, p_wrapped) {}
} // namespace bridges

#endif // GODOT_JVM_PACKED_ARRAY_BRIDGE_H
