#ifndef GODOT_JVM_GODOT_PRINT_BRIDGE_H
#define GODOT_JVM_GODOT_PRINT_BRIDGE_H

#include "jvm/wrapper/jvm_singleton_wrapper.h"

namespace bridges {

    JVM_SINGLETON_WRAPPER(GodotPrintBridge, "godot.internal.logging.GodotPrint") {
        SINGLETON_CLASS(GodotPrintBridge)

        JNI_OBJECT_METHOD(GET_EXCEPTION_STACKTRACE)
        JNI_OBJECT_METHOD(GET_STACKTRACE)

        // clang-format off
        INIT_JNI_BINDINGS(
            INIT_NATIVE_METHOD("print", "(Ljava/lang/String;)V", GodotPrintBridge::print)
            INIT_NATIVE_METHOD("printRich", "(Ljava/lang/String;)V", GodotPrintBridge::print_rich)
            INIT_NATIVE_METHOD("printVerbose", "(Ljava/lang/String;)V", GodotPrintBridge::print_verbose2)
            INIT_NATIVE_METHOD("printErr", "(Ljava/lang/String;)V", GodotPrintBridge::print_err)
            INIT_NATIVE_METHOD("printRaw", "(Ljava/lang/String;)V", GodotPrintBridge::print_raw)
            INIT_NATIVE_METHOD("pushError", "(Ljava/lang/String;)V", GodotPrintBridge::push_error)
            INIT_NATIVE_METHOD("pushWarning", "(Ljava/lang/String;)V", GodotPrintBridge::push_warning)

            INIT_JNI_METHOD(GET_EXCEPTION_STACKTRACE, "getExceptionStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/String;")
            INIT_JNI_METHOD(GET_STACKTRACE, "getCurrentStacktrace", "()Ljava/lang/String;")
          )
        // clang-format on

    public:
        static void print(JNIEnv * p_raw_env, jobject, jstring p_string);
        static void print_rich(JNIEnv * p_raw_env, jobject, jstring p_string);
        static void print_verbose2(JNIEnv * p_raw_env, jobject, jstring p_string); // Can't be named normally this because a godot macro of the same name is already included.
        static void print_err(JNIEnv * p_raw_env, jobject, jstring p_string);
        static void print_raw(JNIEnv * p_raw_env, jobject, jstring p_string);
        static void push_error(JNIEnv * p_raw_env, jobject, jstring p_string);
        static void push_warning(JNIEnv * p_raw_env, jobject, jstring p_string);

        static void print_exception_stacktrace(jni::Env p_env, jni::JThrowable p_throwable);
        // TODO: Use this method to get the JVM stacktrace when Godot will add the features to script https://github.com/godotengine/godot/pull/91006
        godot::String get_jvm_stacktrace(jni::Env & p_env);
    };

} // namespace bridges

#endif // GODOT_JVM_GODOT_PRINT_BRIDGE_H