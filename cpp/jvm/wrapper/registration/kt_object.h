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
    explicit KtObject(jni::JObject p_global_ref);
    KtObject(jni::JObject p_weak_ref, jni::JObject p_pin);

public:
    KtObject(KtObject && p_other) noexcept = default;

    // A plain Object: one strong global reference, never promoted or demoted.
    static KtObject create_object(jni::Env & p_env, jni::JObject p_local_ref);
    // A RefCounted something other than the JVM owns too: the permanent weak reference plus the pin that holds it.
    static KtObject create_strong_ref(jni::Env & p_env, jni::JObject p_local_ref);
    // A RefCounted the JVM alone owns: the permanent weak reference, collectable from the start.
    static KtObject create_weak_ref(jni::Env & p_env, jni::JObject p_local_ref);
    ~KtObject();

    void script_instance_removed(jni::Env & p_env, uint32_t constructor_index);
    static void create_native_object(JNIEnv * p_raw_env, jobject instance, jint p_class_index, jlong p_script_ptr);
    static void get_singleton(JNIEnv * p_raw_env, jobject p_instance, jint p_class_index);
    static void free_object(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
};

// One KtObject lives inside every JvmInstanceData: the permanent reference, the pin, and the flag telling them
// apart. Keep it padding-free.
static_assert(sizeof(KtObject) == 3 * sizeof(void*));

#endif // GODOT_JVM_KT_OBJECT_H
