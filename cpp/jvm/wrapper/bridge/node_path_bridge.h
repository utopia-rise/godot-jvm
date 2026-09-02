#ifndef GODOT_JVM_NODE_PATH_BRIDGE_H
#define GODOT_JVM_NODE_PATH_BRIDGE_H

#include "jvm/wrapper/jvm_singleton_wrapper.h"

namespace bridges {

    JVM_SINGLETON_WRAPPER(NodePathBridge, "godot.core.NodePath$Bridge") {
        SINGLETON_CLASS(NodePathBridge)

        // clang-format off
        INIT_JNI_BINDINGS(
            INIT_NATIVE_METHOD("engine_call_constructor", "()J", NodePathBridge::engine_call_constructor)
            INIT_NATIVE_METHOD("engine_call_constructor_string", "()J", NodePathBridge::engine_call_constructor_string)
            INIT_NATIVE_METHOD("engine_call_constructor_node_path", "()J", NodePathBridge::engine_call_constructor_node_path)
            INIT_NATIVE_METHOD("engine_call_path", "(J)V", NodePathBridge::engine_call_path)
            INIT_NATIVE_METHOD("engine_call_getAsPropertyPath", "(J)V", NodePathBridge::engine_call_getAsPropertyPath)
            INIT_NATIVE_METHOD("engine_call_getName", "(J)V", NodePathBridge::engine_call_getName)
            INIT_NATIVE_METHOD("engine_call_getNameCount", "(J)V", NodePathBridge::engine_call_getNameCount)
            INIT_NATIVE_METHOD("engine_call_getSubname", "(J)V", NodePathBridge::engine_call_getSubname)
            INIT_NATIVE_METHOD("engine_call_getSubnameCount", "(J)V", NodePathBridge::engine_call_getSubnameCount)
            INIT_NATIVE_METHOD("engine_call_isAbsolute", "(J)V", NodePathBridge::engine_call_isAbsolute)
            INIT_NATIVE_METHOD("engine_call_hash", "(J)V",  NodePathBridge::engine_call_hash)
            INIT_NATIVE_METHOD("engine_call_isEmpty", "(J)V", NodePathBridge::engine_call_isEmpty)
            INIT_NATIVE_METHOD("engine_call_getConcatenatedSubnames", "(J)V", NodePathBridge::engine_call_getConcatenatedSubnames)
            INIT_NATIVE_METHOD("engine_call_getConcatenatedNames", "(J)V", NodePathBridge::engine_call_getConcatenatedNames)
            INIT_NATIVE_METHOD("engine_call_equals", "(J)V", NodePathBridge::engine_call_equals)
          )
        // clang-format on

    public:
        static uintptr_t engine_call_constructor(JNIEnv * p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_string(JNIEnv * p_raw_env, jobject p_instance);
        static uintptr_t engine_call_constructor_node_path(JNIEnv * p_raw_env, jobject p_instance);

        static void engine_call_path(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getAsPropertyPath(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getName(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getNameCount(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getSubname(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getSubnameCount(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_isAbsolute(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_hash(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_isEmpty(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getConcatenatedNames(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getConcatenatedSubnames(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_equals(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif // GODOT_JVM_NODE_PATH_BRIDGE_H
