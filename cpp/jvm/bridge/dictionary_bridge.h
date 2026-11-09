#ifndef GODOT_JVM_DICTIONARY_BRIDGE_H
#define GODOT_JVM_DICTIONARY_BRIDGE_H

#include "jvm/jvm_singleton_wrapper.h"

namespace bridges {

    JVM_SINGLETON_WRAPPER(DictionaryBridge, "godot.core.Dictionary$Bridge") {
        SINGLETON_CLASS(DictionaryBridge)

        // clang-format off
        INIT_JNI_BINDINGS(
            INIT_NATIVE_METHOD("engine_call_constructor", "()J", DictionaryBridge::engine_call_constructor)
            INIT_NATIVE_METHOD("engine_call_constructor_typed","()J", DictionaryBridge::engine_call_constructor_typed)
            INIT_NATIVE_METHOD("engine_call_copy_constructor","(J)J", DictionaryBridge::engine_call_copy_constructor)
            INIT_NATIVE_METHOD("engine_call_clear", "(J)V", DictionaryBridge::engine_call_clear)
            INIT_NATIVE_METHOD("engine_call_duplicate", "(J)V", DictionaryBridge::engine_call_duplicate)
            INIT_NATIVE_METHOD("engine_call_duplicate_deep", "(J)V", DictionaryBridge::engine_call_duplicate_deep)
            INIT_NATIVE_METHOD("engine_call_is_empty","(J)V", DictionaryBridge::engine_call_is_empty)
            INIT_NATIVE_METHOD("engine_call_erase", "(J)V", DictionaryBridge::engine_call_erase)
            INIT_NATIVE_METHOD("engine_call_find_key", "(J)V", DictionaryBridge::engine_call_find_key)
            INIT_NATIVE_METHOD("engine_call_get", "(J)V", DictionaryBridge::engine_call_get)
            INIT_NATIVE_METHOD("engine_call_has", "(J)V", DictionaryBridge::engine_call_has)
            INIT_NATIVE_METHOD("engine_call_hasAll", "(J)V", DictionaryBridge::engine_call_hasAll)
            INIT_NATIVE_METHOD("engine_call_hash", "(J)V", DictionaryBridge::engine_call_hash)
            INIT_NATIVE_METHOD("engine_call_is_read_only", "(J)V", DictionaryBridge::engine_call_is_read_only)
            INIT_NATIVE_METHOD("engine_call_keys", "(J)V", DictionaryBridge::engine_call_keys)
            INIT_NATIVE_METHOD("engine_call_make_read_only", "(J)V", DictionaryBridge::engine_call_make_read_only)
            INIT_NATIVE_METHOD("engine_call_merge", "(J)V", DictionaryBridge::engine_call_merge)
            INIT_NATIVE_METHOD("engine_call_size", "(J)V", DictionaryBridge::engine_call_size)
            INIT_NATIVE_METHOD("engine_call_sort", "(J)V", DictionaryBridge::engine_call_sort)
            INIT_NATIVE_METHOD("engine_call_values", "(J)V", DictionaryBridge::engine_call_values)
            INIT_NATIVE_METHOD("engine_call_equals", "(J)V", DictionaryBridge::engine_call_equals)
            INIT_NATIVE_METHOD("engine_call_assign", "(J)V", DictionaryBridge::engine_call_assign)
            INIT_NATIVE_METHOD("engine_call_get_or_add", "(J)V", DictionaryBridge::engine_call_get_or_add)
            INIT_NATIVE_METHOD("engine_call_get_typed_key_class_name", "(J)V", DictionaryBridge::engine_call_get_typed_key_class_name)
            INIT_NATIVE_METHOD("engine_call_get_typed_value_class_name", "(J)V", DictionaryBridge::engine_call_get_typed_value_class_name)
            INIT_NATIVE_METHOD("engine_call_get_typed_key_script", "(J)V", DictionaryBridge::engine_call_get_typed_key_script)
            INIT_NATIVE_METHOD("engine_call_get_typed_value_script", "(J)V", DictionaryBridge::engine_call_get_typed_value_script)
            INIT_NATIVE_METHOD("engine_call_is_same_typed", "(J)V", DictionaryBridge::engine_call_is_same_typed)
            INIT_NATIVE_METHOD("engine_call_is_same_typed_key", "(J)V", DictionaryBridge::engine_call_is_same_typed_key)
            INIT_NATIVE_METHOD("engine_call_is_same_typed_value", "(J)V", DictionaryBridge::engine_call_is_same_typed_value)
            INIT_NATIVE_METHOD("engine_call_merged", "(J)V", DictionaryBridge::engine_call_merged)
            INIT_NATIVE_METHOD("engine_call_recursive_equal", "(J)V", DictionaryBridge::engine_call_recursive_equal)
            INIT_NATIVE_METHOD("engine_call_set", "(J)V", DictionaryBridge::engine_call_set)
          )
        // clang-format on

    public:
        static uintptr_t engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_typed(JNIEnv* p_raw_env, jobject p_instance);
        static uintptr_t engine_call_copy_constructor(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_clear(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_duplicate(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_erase(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_find_key(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_hasAll(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_is_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_keys(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_make_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_merge(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_sort(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_values(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_assign(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get_or_add(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get_typed_key_class_name(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get_typed_value_class_name(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get_typed_key_script(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_get_typed_value_script(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_is_same_typed(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_is_same_typed_key(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_is_same_typed_value(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_merged(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_recursive_equal(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
        static void engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle);
    };

} // namespace bridges

#endif // GODOT_JVM_DICTIONARY_BRIDGE_H
