#ifndef GODOT_JVM_KT_OBJECT_H
#define GODOT_JVM_KT_OBJECT_H

#include "jvm/wrapper/jvm_instance_wrapper.h"

JVM_INSTANCE_WRAPPER(KtObject, "godot.core.KtObject") {
    JVM_CLASS(KtObject)

    // clang-format off
    JNI_VOID_METHOD(ON_DESTROY)
    JNI_VOID_METHOD(REMOVE_SCRIPT)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(ON_DESTROY, "_onDestroy", "()V")
        INIT_JNI_METHOD(REMOVE_SCRIPT, "removeScript", "(I)V")
        INIT_NATIVE_METHOD("createNativeObject", "(IJ)V", KtObject::create_native_object)
        INIT_NATIVE_METHOD("getSingleton", "(I)V", KtObject::get_singleton)
        INIT_NATIVE_METHOD("freeObject", "(J)V", KtObject::free_object)
    )
    // clang-format on

private:
    bool is_ref;

public:
    explicit KtObject(jni::Env & p_env, jni::JObject p_wrapped, bool p_is_ref);
    ~KtObject();

    void script_instance_removed(jni::Env & p_env, uint32_t constructor_index);
    static void create_native_object(JNIEnv * p_raw_env, jobject instance, jint p_class_index, jlong p_script_ptr);
    static void get_singleton(JNIEnv * p_raw_env, jobject p_instance, jint p_class_index);
    static void free_object(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
};

#endif // GODOT_JVM_KT_OBJECT_H
