#ifndef GODOT_JVM_KT_SIGNAL_INFO_H
#define GODOT_JVM_KT_SIGNAL_INFO_H

#include "jvm/jvm_instance_wrapper.h"
#include "kt_property.h"

JVM_INSTANCE_WRAPPER(KtSignalInfo, "godot.registration.KtSignalInfo") {
    JVM_CLASS(KtSignalInfo)

    // clang-format off
    JNI_OBJECT_METHOD(GET_NAME)
    JNI_OBJECT_METHOD(GET_ARGUMENTS)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_NAME, "getName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_ARGUMENTS, "getArguments", "()[Lgodot/registration/KtPropertyInfo;")
    )
    // clang-format on

public:
    explicit KtSignalInfo(jni::Env& p_env, jni::JObject p_wrapped);
    ~KtSignalInfo();

    // A StringName rather than a String: it is what MethodInfo wants, and what godot::internal::identity keys the
    // signal map on. Holding it here is what keeps that key's interned entry alive for as long as the entry exists.
    godot::StringName name;
    godot::List<KtPropertyInfo*> arguments;

    godot::MethodInfo get_member_info() const;
};

#endif // GODOT_JVM_KT_SIGNAL_INFO_H
