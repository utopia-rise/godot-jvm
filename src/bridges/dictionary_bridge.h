#ifndef GODOT_JVM_DICTIONARY_BRIDGE_H
#define GODOT_JVM_DICTIONARY_BRIDGE_H


#include <modules/kotlin_jvm/src/java_instance_wrapper.h>
#include <core/dictionary.h>

namespace bridges {

    class DictionaryBridge  : public JavaInstanceWrapper<DictionaryBridge> {
    public:
        DictionaryBridge(jni::JObject p_wrapped, jni::JObject p_class_loader);
        ~DictionaryBridge() = default;

        static uintptr_t engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance);
        static void engine_call_clear(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_duplicate(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_erase(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_hasAll(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_keys(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_values(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_operator_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_operator_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);

        DECLARE_JNI_METHODS()
    };

}


#endif //GODOT_JVM_DICTIONARY_BRIDGE_H
