#ifndef GODOT_JVM_STRING_NAME_BRIDGE_H
#define GODOT_JVM_STRING_NAME_BRIDGE_H

#include "jvm/wrapper/jvm_singleton_wrapper.h"

namespace bridges {
    JVM_SINGLETON_WRAPPER(StringNameBridge, "godot.core.StringName$Bridge") {
        SINGLETON_CLASS(StringNameBridge)

        // clang-format off
        INIT_JNI_BINDINGS(
            INIT_NATIVE_METHOD("engine_call_constructor","()J", StringNameBridge::engine_call_constructor)
            INIT_NATIVE_METHOD("engine_call_copy_constructor","()J", StringNameBridge::engine_call_copy_constructor)
            INIT_NATIVE_METHOD("engine_call_constructor_string", ("()J"), StringNameBridge::engine_call_constructor_string)
            INIT_NATIVE_METHOD("engine_call_operator_string","(J)V", StringNameBridge::engine_call_operator_string)
          )
        // clang-format on

    public:
        static uintptr_t engine_call_constructor(JNIEnv * p_raw_env, jobject p_instance);
        static uintptr_t engine_call_copy_constructor(JNIEnv * p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_string(JNIEnv * p_raw_env, jobject p_instance);

        static void engine_call_operator_string(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif // GODOT_JVM_STRING_NAME_BRIDGE_H
