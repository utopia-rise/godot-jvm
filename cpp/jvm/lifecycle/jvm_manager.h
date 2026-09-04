#ifndef GODOT_JVM_JVM_MANAGER_H
#define GODOT_JVM_JVM_MANAGER_H

#include "class_loader.h"
#include "jvm/jni/env.h"
#include "jvm_options.h"
#include "jvm_user_configuration.h"

#if defined WINDOWS_ENABLED || defined LINUX_ENABLED || defined MACOS_ENABLED
#define DYNAMIC_JVM
#elif defined ANDROID_ENABLED
#define PROVIDED_JVM
#elif defined IOS_ENABLED
#define STATIC_JVM
#endif

class JvmManager {
public:
#ifdef ANDROID_ENABLED
    static void set_android_jvm(JNIEnv* p_env);
#endif

    static bool initialize_or_get_jvm(void* lib_handle, JvmUserConfiguration& user_configuration, JvmOptions& jvm_options);
    static bool initialize_jvm_wrappers(jni::Env& p_env, ClassLoader* class_loader);
    static void finalize_jvm_wrappers(jni::Env& p_env, ClassLoader* class_loader);
    static bool close_jvm();

private:
#ifdef ANDROID_ENABLED
    inline static JavaVM* android_jvm = nullptr;
#endif
};

#endif// GODOT_JVM_JVM_MANAGER_H
