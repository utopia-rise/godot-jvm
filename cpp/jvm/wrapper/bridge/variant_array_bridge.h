#ifndef GODOT_JVM_VARIANT_ARRAY_BRIDGE_H
#define GODOT_JVM_VARIANT_ARRAY_BRIDGE_H

#include "jvm/wrapper/jvm_singleton_wrapper.h"

namespace bridges {

    JVM_SINGLETON_WRAPPER(VariantArrayBridge, "godot.core.VariantArray$Bridge") {
        SINGLETON_CLASS(VariantArrayBridge)

        // clang-format off
        INIT_JNI_BINDINGS(
            INIT_NATIVE_METHOD("engine_call_constructor", "()J", VariantArrayBridge::engine_call_constructor)
            INIT_NATIVE_METHOD("engine_call_constructor_typed","()J", VariantArrayBridge::engine_call_constructor_typed)
            INIT_NATIVE_METHOD("engine_call_size","(J)V", VariantArrayBridge::engine_call_size)
            INIT_NATIVE_METHOD("engine_call_clear","(J)V", VariantArrayBridge::engine_call_clear)
            INIT_NATIVE_METHOD("engine_call_isEmpty","(J)V", VariantArrayBridge::engine_call_is_empty)
            INIT_NATIVE_METHOD("engine_call_hash","(J)V", VariantArrayBridge::engine_call_hash)
            INIT_NATIVE_METHOD("engine_call_reverse","(J)V", VariantArrayBridge::engine_call_reverse)
            INIT_NATIVE_METHOD("engine_call_removeAt","(J)V", VariantArrayBridge::engine_call_remove_at)
            INIT_NATIVE_METHOD("engine_call_resize","(J)V", VariantArrayBridge::engine_call_resize)
            INIT_NATIVE_METHOD("engine_call_shuffle","(J)V", VariantArrayBridge::engine_call_shuffle)
            INIT_NATIVE_METHOD("engine_call_sort","(J)V", VariantArrayBridge::engine_call_sort)
            INIT_NATIVE_METHOD("engine_call_sortCustom","(J)V", VariantArrayBridge::engine_call_sortCustom)
            INIT_NATIVE_METHOD("engine_call_append","(J)V", VariantArrayBridge::engine_call_append)
            INIT_NATIVE_METHOD("engine_call_bsearch","(J)V", VariantArrayBridge::engine_call_bsearch)
            INIT_NATIVE_METHOD("engine_call_bsearchCustom","(J)V", VariantArrayBridge::engine_call_bsearchCustom)
            INIT_NATIVE_METHOD("engine_call_count","(J)V", VariantArrayBridge::engine_call_count)
            INIT_NATIVE_METHOD("engine_call_duplicate","(J)V", VariantArrayBridge::engine_call_duplicate)
            INIT_NATIVE_METHOD("engine_call_duplicate_deep","(J)V", VariantArrayBridge::engine_call_duplicate_deep)
            INIT_NATIVE_METHOD("engine_call_erase","(J)V", VariantArrayBridge::engine_call_erase)
            INIT_NATIVE_METHOD("engine_call_find","(J)V", VariantArrayBridge::engine_call_find)
            INIT_NATIVE_METHOD("engine_call_front","(J)V", VariantArrayBridge::engine_call_front)
            INIT_NATIVE_METHOD("engine_call_has","(J)V", VariantArrayBridge::engine_call_has)
            INIT_NATIVE_METHOD("engine_call_insert","(J)V", VariantArrayBridge::engine_call_insert)
            INIT_NATIVE_METHOD("engine_call_max","(J)V", VariantArrayBridge::engine_call_max)
            INIT_NATIVE_METHOD("engine_call_min","(J)V", VariantArrayBridge::engine_call_min)
            INIT_NATIVE_METHOD("engine_call_popBack","(J)V", VariantArrayBridge::engine_call_popBack)
            INIT_NATIVE_METHOD("engine_call_popFront","(J)V", VariantArrayBridge::engine_call_popFront)
            INIT_NATIVE_METHOD("engine_call_pushBack","(J)V", VariantArrayBridge::engine_call_pushBack)
            INIT_NATIVE_METHOD("engine_call_pushFront","(J)V", VariantArrayBridge::engine_call_pushFront)
            INIT_NATIVE_METHOD("engine_call_rfind","(J)V", VariantArrayBridge::engine_call_rfind)
            INIT_NATIVE_METHOD("engine_call_slice","(J)V", VariantArrayBridge::engine_call_slice)
            INIT_NATIVE_METHOD("engine_call_operator_set","(J)V", VariantArrayBridge::engine_call_operator_set)
            INIT_NATIVE_METHOD("engine_call_operator_get","(J)V", VariantArrayBridge::engine_call_operator_get)
            INIT_NATIVE_METHOD("engine_call_all","(J)V", VariantArrayBridge::engine_call_all)
            INIT_NATIVE_METHOD("engine_call_any","(J)V", VariantArrayBridge::engine_call_any)
            INIT_NATIVE_METHOD("engine_call_appendArray","(J)V", VariantArrayBridge::engine_call_appendArray)
            INIT_NATIVE_METHOD("engine_call_back","(J)V", VariantArrayBridge::engine_call_back)
            INIT_NATIVE_METHOD("engine_call_fill","(J)V", VariantArrayBridge::engine_call_fill)
            INIT_NATIVE_METHOD("engine_call_filter","(J)V", VariantArrayBridge::engine_call_filter)
            INIT_NATIVE_METHOD("engine_call_getTypedClassName","(J)V", VariantArrayBridge::engine_call_getTypedClassName)
            INIT_NATIVE_METHOD("engine_call_getTypedScript","(J)V", VariantArrayBridge::engine_call_getTypedScript)
            INIT_NATIVE_METHOD("engine_call_isReadOnly","(J)V", VariantArrayBridge::engine_call_isReadOnly)
            INIT_NATIVE_METHOD("engine_call_isTyped","(J)V", VariantArrayBridge::engine_call_isTyped)
            INIT_NATIVE_METHOD("engine_call_map","(J)V", VariantArrayBridge::engine_call_map)
            INIT_NATIVE_METHOD("engine_call_pickRandom","(J)V", VariantArrayBridge::engine_call_pickRandom)
            INIT_NATIVE_METHOD("engine_call_reduce","(J)V", VariantArrayBridge::engine_call_reduce)
          )
        // clang-format on

    public:
        static uintptr_t engine_call_constructor(JNIEnv * p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_typed(JNIEnv * p_raw_env, jobject p_instance);

        static void engine_call_size(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_clear(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_is_empty(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_hash(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_reverse(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_remove_at(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_resize(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_shuffle(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_sort(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_sortCustom(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_append(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_bsearch(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_bsearchCustom(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_count(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_duplicate(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_erase(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_find(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_front(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_has(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_insert(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_max(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_min(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_popBack(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_popFront(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_pushBack(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_pushFront(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_rfind(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_slice(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_operator_set(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_operator_get(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_all(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_any(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_appendArray(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_back(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_fill(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_filter(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getTypedClassName(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getTypedScript(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_isReadOnly(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_isTyped(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_map(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_pickRandom(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_reduce(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };

} // namespace bridges

#endif // GODOT_JVM_VARIANT_ARRAY_BRIDGE_H
