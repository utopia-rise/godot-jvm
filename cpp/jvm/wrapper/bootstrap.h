#ifndef GODOT_JVM_BOOTSTRAP_H
#define GODOT_JVM_BOOTSTRAP_H

#include "jvm/wrapper/jvm_instance_wrapper.h"

JVM_INSTANCE_WRAPPER(Bootstrap, "godot.runtime.Bootstrap") {
    JVM_CLASS(Bootstrap)

    // clang-format off
    JNI_VOID_METHOD(INITIALIZE_ENGINE_TYPES)
    JNI_VOID_METHOD(INIT_JAR)
    JNI_VOID_METHOD(INIT_NATIVE_IMAGE)
    JNI_VOID_METHOD(FINISH)
    JNI_OBJECT_METHOD(GET_VERSION)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(INITIALIZE_ENGINE_TYPES, "initializeEngineTypes", "()V")
        INIT_JNI_METHOD(INIT_JAR, "initJar", "(Ljava/lang/ClassLoader;)V")
        INIT_JNI_METHOD(INIT_NATIVE_IMAGE, "initNativeImage", "()V")
        INIT_JNI_METHOD(GET_VERSION, "getVersion", "()Ljava/lang/String;")
        INIT_JNI_METHOD(FINISH, "finish", "()V")
        INIT_NATIVE_METHOD("loadClasses", "([Lgodot/registration/KtClass;)V", Bootstrap::load_classes)
        INIT_NATIVE_METHOD("registerManagedEngineTypes", "([Ljava/lang/String;[Ljava/lang/String;)V", Bootstrap::register_engine_type)
    )
    // clang-format on

public:
    static void load_classes(JNIEnv * p_env, jobject p_this, jobjectArray p_classes);
    static void register_engine_type(JNIEnv * p_env, jobject p_this, jobjectArray p_classes_names, jobjectArray p_singleton_names);

    Bootstrap(jni::Env & p_env, jni::JObject p_wrapped);
    ~Bootstrap() = default;

    void initialize_engine_types(jni::Env & p_env);
    void init_jar(jni::Env & p_env, const jni::JObject& p_class_loader);
    void init_native_image(jni::Env & p_env);
    godot::String get_version(jni::Env & p_env);
    void finish(jni::Env & p_env);
};

#endif // GODOT_JVM_BOOTSTRAP_H
