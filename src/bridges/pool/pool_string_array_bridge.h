#ifndef GODOT_JVM_POOL_STRING_ARRAY_BRIDGE_H
#define GODOT_JVM_POOL_STRING_ARRAY_BRIDGE_H


#include <modules/kotlin_jvm/src/java_instance_wrapper.h>
#include "PoolArrays.hpp"
#include "String.hpp"

namespace bridges {

    class PoolStringArrayBridge : JavaInstanceWrapper<PoolStringArrayBridge> {
    public:
        PoolStringArrayBridge(jni::JObject p_wrapped, jni::JObject p_class_loader);
        ~PoolStringArrayBridge() = default;

        static uintptr_t engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance, jboolean has_param);

        static void engine_call_append(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_appendArray(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_insert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_invert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_pushback(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_remove(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_resize(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);

        DECLARE_JNI_METHODS()
    };
}


#endif
