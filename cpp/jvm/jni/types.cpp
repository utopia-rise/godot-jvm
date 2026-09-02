#include "types.h"

namespace jni {

    JValue::JValue(JObject obj) {
        value.l = obj.obj;
    }

    JValue::JValue(jint i) {
        value.i = i;
    }

    JValue::JValue(jlong i) {
        value.j = i;
    }

    JValue::JValue(jboolean b) {
        value.z = b;
    }

    JValue::JValue(jfloat f) {
        value.f = f;
    }

    JValue::JValue(jdouble d) {
        value.d = d;
    }

    JValue::JValue(jbyte b) {
        value.b = b;
    }

    JValue::JValue(jchar c) {
        value.c = c;
    }

    JValue::JValue(jshort s) {
        value.s = s;
    }

    JObject::JObject(jobject obj) : obj(obj) {}

    jobject JObject::get_wrapped() const{
        return obj;
    }

    void JObject::delete_global_ref(Env& p_env) {
        p_env.env->DeleteGlobalRef(obj);
    }

    void JObject::delete_weak_ref(Env& p_env) {
        p_env.env->DeleteWeakGlobalRef(obj);
    }

    void JObject::delete_local_ref(Env& p_env) {
        p_env.env->DeleteLocalRef(obj);
    }

    bool JObject::is_null() const{
        return obj == nullptr;
    }

    bool JObject::is_same_object(Env& env, const JObject& other) const {
        return env.is_same_object(obj, other.obj);
    }

    MethodID JClass::get_method_id(Env& env, const char* name, const char* signature) {
        auto id = env.env->GetMethodID((jclass) obj, name, signature);
        JVM_DEV_ASSERT(id, "Method not found: %s with signature: %s", name, signature);
        env.handle_exception();
        return id;
    }

    MethodID JClass::get_static_method_id(Env& env, const char* name, const char* signature) {
        auto id = env.env->GetStaticMethodID((jclass) obj, name, signature);
        JVM_DEV_ASSERT(id, "Method not found: %s with signature: %s", name, signature);
        env.handle_exception();
        return id;
    }

    FieldID JClass::get_static_field_id(Env& env, const char* name, const char* signature) {
        auto id = env.env->GetStaticFieldID((jclass) obj, name, signature);
        JVM_DEV_ASSERT(id, "Field not found: %s with signature: %s", name, signature);
        env.handle_exception();
        return id;
    }

    void JClass::register_natives(Env& env, godot::Vector<JNativeMethod> methods) {
        env.env->RegisterNatives((jclass) obj, methods.ptr(), methods.size());
        env.handle_exception();
    }

    void JClass::unregister_natives(Env& env) {
        env.env->UnregisterNatives((jclass) obj);
        env.handle_exception();
    }

    MethodID JClass::get_constructor_method_id(Env& env, const char* signature) {
        return get_method_id(env, "<init>", signature);
    }

    JObject JClass::new_instance(Env& env, MethodID ctor, jvalue* args) {
        auto ret = env.env->NewObjectA((jclass) obj, ctor, args);
        JVM_DEV_ASSERT(ret, "Failed to instantiated object!");
        env.handle_exception();
        return JObject(ret);
    }

    JObject JClass::call_static_object_method(Env& env, MethodID method, jvalue* args) {
        auto ret = env.env->CallStaticObjectMethodA((jclass) obj, method, args);
        env.handle_exception();
        return JObject(ret);
    }

    JObject JClass::get_static_object_field(Env& env, FieldID field) {
        auto value = env.env->GetStaticObjectField((jclass) obj, field);
        env.handle_exception();
        return JObject(value);
    }

    JObjectArray JClass::new_object_array(Env& env, int size, JObject initial) {
        auto ret = env.env->NewObjectArray(size, (jclass) obj, initial.obj);
        JVM_DEV_ASSERT(ret, "Failed to instantiated object array!");
        return JObjectArray(ret);
    }

    bool JClass::is_assignable_from(Env& env, JClass p_other) const {
        return static_cast<bool>(env.env->IsAssignableFrom(static_cast<jclass>(p_other.obj), static_cast<jclass>(obj)));
    }

    int JArray::length(Env& env) {
        return env.env->GetArrayLength((jarray) obj);
    }

    void JObjectArray::set(Env& env, int index, JObject value) {
        env.env->SetObjectArrayElement((jobjectArray) obj, index, value.obj);
    }

    JObject JObjectArray::get(Env& env, int index) {
        auto ret = env.env->GetObjectArrayElement((jobjectArray) obj, index);
        return JObject(ret);
    }

    JByteArray::JByteArray(Env& env, const jsize size) {
        // Allocate an Array with reserved size;
        obj = env.env->NewByteArray(size);
    }

    JIntArray::JIntArray(Env& env, const jsize size) {
        // Allocate an Array with reserved size;
        obj = env.env->NewIntArray(size);
    }

    JLongArray::JLongArray(Env& env, const jsize size) {
        // Allocate an Array with reserved size;
        obj = env.env->NewLongArray(size);
    }

    JFloatArray::JFloatArray(Env& env, const jsize size) {
        // Allocate an Array with reserved size;
        obj = env.env->NewFloatArray(size);
    }

    JDoubleArray::JDoubleArray(Env& env, const jsize size) {
        // Allocate an Array with reserved size;
        obj = env.env->NewDoubleArray(size);
    }

    void JByteArray::get_array_elements(Env& env, jbyte* arr, const jsize size) {
        // Convert java array to native array
        jbyte* nativeArray = env.env->GetByteArrayElements((jbyteArray) obj, nullptr);

        // Copy elements
        std::copy(nativeArray, nativeArray + size, arr);

        // Release the original Java array
        env.env->ReleaseByteArrayElements((jbyteArray) obj, nativeArray, 0);
    }

    void JIntArray::get_array_elements(Env& env, jint* arr, const jsize size) {
        // Convert java array to native array
        jint* nativeArray = env.env->GetIntArrayElements((jintArray) obj, nullptr);

        // Copy elements
        std::copy(nativeArray, nativeArray + size, arr);

        // Release the original Java array
        env.env->ReleaseIntArrayElements((jintArray) obj, nativeArray, 0);
    }

    void JLongArray::get_array_elements(Env& env, jlong* arr, const jsize size) {
        // Convert java array to native array
        jlong* nativeArray = env.env->GetLongArrayElements((jlongArray) obj, nullptr);

        // Copy elements
        std::copy(nativeArray, nativeArray + size, arr);

        // Release the original Java array
        env.env->ReleaseLongArrayElements((jlongArray) obj, nativeArray, 0);
    }

    void JFloatArray::get_array_elements(Env& env, jfloat* arr, const jsize size) {
        // Convert java array to native array
        jfloat* nativeArray = env.env->GetFloatArrayElements((jfloatArray) obj, nullptr);

        // Copy elements
        std::copy(nativeArray, nativeArray + size, arr);

        // Release the original Java array
        env.env->ReleaseFloatArrayElements((jfloatArray) obj, nativeArray, 0);
    }

    void JDoubleArray::get_array_elements(Env& env, jdouble* arr, const jsize size) {
        // Convert java array to native array
        jdouble* nativeArray = env.env->GetDoubleArrayElements((jdoubleArray) obj, nullptr);

        // Copy elements
        std::copy(nativeArray, nativeArray + size, arr);

        // Release the original Java array
        env.env->ReleaseDoubleArrayElements((jdoubleArray) obj, nativeArray, 0);
    }

    void JByteArray::set_array_elements(Env& env, const jbyte* arr, const jsize size) {
        env.env->SetByteArrayRegion((jbyteArray) obj, 0, size, arr);
    }

    void JIntArray::set_array_elements(Env& env, const jint* arr, const jsize size) {
        env.env->SetIntArrayRegion((jintArray) obj, 0, size, arr);
    }

    void JLongArray::set_array_elements(Env& env, const jlong* arr, const jsize size) {
        env.env->SetLongArrayRegion((jlongArray) obj, 0, size, arr);
    }

    void JFloatArray::set_array_elements(Env& env, const jfloat* arr, const jsize size) {
        env.env->SetFloatArrayRegion((jfloatArray) obj, 0, size, arr);
    }

    void JDoubleArray::set_array_elements(Env& env, const jdouble* arr, const jsize size) {
        env.env->SetDoubleArrayRegion((jdoubleArray) obj, 0, size, arr);
    }

}// namespace jni