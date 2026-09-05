#ifndef GODOT_LOADER_JOBJECT_H
#define GODOT_LOADER_JOBJECT_H

#include "env.h"
#include "methods.h"

#include <jni.h>

#include <templates/vector.hpp>

namespace jni {

    class JObject;

    class JValue {
    public:
        jvalue value = jvalue();

        JValue(JObject obj);

        JValue(jint i);

        JValue(jlong i);

        JValue(jboolean b);

        JValue(jfloat f);

        JValue(jdouble d);

        JValue(jbyte b);

        JValue(jchar c);

        JValue(jshort s);

        JValue() = default;
    };

    typedef jfieldID FieldID;

    class JObject {
    public:
        jobject obj = nullptr;

        JObject() = default;
        JObject(jobject);

        JObject(const JObject&) = default;
        JObject& operator=(const JObject&) = default;

        jobject get_wrapped() const;

        template<class T>
        inline T new_global_ref(Env& env);

        void delete_global_ref(Env& p_env);

        template<class T>
        inline T new_weak_ref(Env& env);

        void delete_weak_ref(Env& p_env);

        void delete_local_ref(Env& p_env);

        template<bool CHECK_EXCEPTION = true>
        void call_void_method(Env& p_env, VoidMethodID method, jvalue* args = nullptr) const;

        template<bool CHECK_EXCEPTION = true>
        jboolean call_boolean_method(Env& p_env, BooleanMethodID method, jvalue* args = nullptr) const;

        template<bool CHECK_EXCEPTION = true>
        jint call_int_method(Env& p_env, IntMethodID method, jvalue* args = nullptr) const;

        template<bool CHECK_EXCEPTION = true>
        jlong call_long_method(Env& p_env, LongMethodID method, jvalue* args = nullptr) const;

        template<bool CHECK_EXCEPTION = true>
        jdouble call_float_method(Env& p_env, FloatMethodID method, jvalue* args = nullptr) const;

        template<bool CHECK_EXCEPTION = true>
        jdouble call_double_method(Env& p_env, DoubleMethodID method, jvalue* args = nullptr) const;

        template<bool CHECK_EXCEPTION = true>
        JObject call_object_method(Env& p_env, ObjectMethodID method, jvalue* args = nullptr) const;

        bool is_null() const;

        bool is_same_object(Env& env, const JObject& other) const;
    };

#ifdef DEV_ENABLED
#define CHECK_EXCEPTION_TEMPLATE p_env.handle_exception()
#else
#define CHECK_EXCEPTION_TEMPLATE                                 \
    if constexpr (CHECK_EXCEPTION) { p_env.handle_exception(); } \
    (void) 0
#endif

    template<bool CHECK_EXCEPTION>
    void JObject::call_void_method(Env& p_env, VoidMethodID method, jvalue* args) const {
        p_env.env->CallVoidMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
    }

    template<bool CHECK_EXCEPTION>
    jboolean JObject::call_boolean_method(Env& p_env, BooleanMethodID method, jvalue* args) const {
        jboolean ret = p_env.env->CallBooleanMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
        return ret;
    }

    template<bool CHECK_EXCEPTION>
    jint JObject::call_int_method(Env& p_env, IntMethodID method, jvalue* args) const {
        jint ret = p_env.env->CallIntMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
        return ret;
    }

    template<bool CHECK_EXCEPTION>
    jlong JObject::call_long_method(Env& p_env, LongMethodID method, jvalue* args) const {
        jlong ret = p_env.env->CallLongMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
        return ret;
    }

    template<bool CHECK_EXCEPTION>
    jdouble JObject::call_float_method(Env& p_env, FloatMethodID method, jvalue* args) const {
        jfloat ret = p_env.env->CallFloatMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
        return ret;
    }

    template<bool CHECK_EXCEPTION>
    jdouble JObject::call_double_method(Env& p_env, DoubleMethodID method, jvalue* args) const {
        jdouble ret = p_env.env->CallDoubleMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
        return ret;
    }

    template<bool CHECK_EXCEPTION>
    JObject JObject::call_object_method(Env& p_env, ObjectMethodID method, jvalue* args) const {
        JObject ret = p_env.env->CallObjectMethodA((jobject) obj, method.methodId, args);
        CHECK_EXCEPTION_TEMPLATE;
        return ret;
    }

    class JString : public JObject {
    public:
        JString() = default;

        JString(jstring string) : JObject(string) {}

        explicit JString(JObject jObject) : JObject(jObject) {};
    };

    class JArray : public JObject {
    public:
        JArray() = default;

        JArray(jarray array) : JObject(array) {}

        explicit JArray(JObject jObject) : JObject(jObject) {};

        int length(Env& env);
    };

    class JObjectArray : public JArray {
    public:
        JObjectArray() = default;

        JObjectArray(jarray array) : JArray(array) {}

        explicit JObjectArray(JObject jObject) : JArray(jObject) {};

        void set(Env& env, int index, JObject value);

        JObject get(Env& env, int index);
    };

    class JByteArray : public JArray {
    public:
        JByteArray() = default;
        JByteArray(Env& env, jsize size = 0);

        JByteArray(jbyteArray array) : JArray(array) {}

        explicit JByteArray(JObject jObject) : JArray(jObject) {};

        void get_array_elements(Env& env, jbyte* arr, jsize size);
        void set_array_elements(Env& env, const jbyte* arr, jsize size);
    };

    class JIntArray : public JArray {
    public:
        JIntArray() = default;
        JIntArray(Env& env, jsize size = 0);

        JIntArray(jintArray array) : JArray(array) {}

        explicit JIntArray(JObject jObject) : JArray(jObject) {};

        void get_array_elements(Env& env, jint* arr, jsize size);
        void set_array_elements(Env& env, const jint* arr, jsize size);
    };

    class JLongArray : public JArray {
    public:
        JLongArray() = default;
        JLongArray(Env& env, jsize size = 0);

        JLongArray(jlongArray array) : JArray(array) {}

        explicit JLongArray(JObject jObject) : JArray(jObject) {};

        void get_array_elements(Env& env, jlong* arr, jsize size);
        void set_array_elements(Env& env, const jlong* arr, jsize size);
    };

    class JFloatArray : public JArray {
    public:
        JFloatArray() = default;
        JFloatArray(Env& env, jsize size = 0);

        JFloatArray(jfloatArray array) : JArray(array) {}

        explicit JFloatArray(JObject jObject) : JArray(jObject) {};

        void get_array_elements(Env& env, jfloat* arr, jsize size);
        void set_array_elements(Env& env, const jfloat* arr, jsize size);
    };

    class JDoubleArray : public JArray {
    public:
        JDoubleArray() = default;
        JDoubleArray(Env& env, jsize size = 0);

        JDoubleArray(jdoubleArray array) : JArray(array) {}

        explicit JDoubleArray(JObject jObject) : JArray(jObject) {};

        void get_array_elements(Env& env, jdouble* arr, jsize size);
        void set_array_elements(Env& env, const jdouble* arr, jsize size);
    };

    typedef JNINativeMethod JNativeMethod;

    class JClass : public JObject {
    public:
        JClass() = default;
        JClass(jclass clazz) : JObject(clazz) {};

        explicit JClass(JObject jObject) : JObject(jObject) {};

        JObject new_instance(Env& env, MethodID ctor, jvalue* args = nullptr);

        JObjectArray new_object_array(Env& env, int size, JObject initial = JObject());

        MethodID get_constructor_method_id(Env& env, const char* signature);

        MethodID get_method_id(Env& env, const char* name, const char* signature);

        MethodID get_static_method_id(Env& env, const char* name, const char* signature);

        FieldID get_static_field_id(Env& env, const char* name, const char* signature);

        void register_natives(Env& env, godot::Vector<JNativeMethod> methods);

        void unregister_natives(Env& env);

        JObject call_static_object_method(Env& env, MethodID method, jvalue* args = nullptr);

        JObject get_static_object_field(Env& env, FieldID field);

        bool is_assignable_from(Env& env, JClass p_other) const;
    };

    class JThrowable : public JObject {
    public:
        JThrowable() = default;
        JThrowable(jthrowable throwable) : JObject(throwable) {};

        explicit JThrowable(JObject jObject) : JObject(jObject) {};
    };

} // namespace jni

#endif // GODOT_LOADER_JOBJECT_H
