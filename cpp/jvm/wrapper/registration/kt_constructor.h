#ifndef GODOT_JVM_KT_CONSTRUCTOR_H
#define GODOT_JVM_KT_CONSTRUCTOR_H

#include "jvm/wrapper/jvm_instance_wrapper.h"
#include "kt_object.h"

JVM_INSTANCE_WRAPPER(KtConstructor, "godot.registration.KtConstructor") {
    JVM_CLASS(KtConstructor)

    // clang-format off
    JNI_OBJECT_METHOD(CONSTRUCT)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(CONSTRUCT, "construct", "(JJ)Lgodot/core/KtObject;")
    )
    // clang-format on

public:
    explicit KtConstructor(jni::Env & p_env, jni::JObject p_wrapped);
    ~KtConstructor() = default;
    KtObject* create_instance(jni::Env & env, godot::GodotObject * p_owner);
};

#endif // GODOT_JVM_KT_CONSTRUCTOR_H
