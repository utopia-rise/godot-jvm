#ifndef GODOT_JVM_KT_PROCESS_H
#define GODOT_JVM_KT_PROCESS_H

#include "jvm/jni/wrapper.h"
#include "jvm/jvm_instance_wrapper.h"
#include "kt_object.h"

#include <core/object.hpp>
#include <variant/string_name.hpp>

// clang-format off
// A _process or _physics_process override, called every frame on every node: delta travels as a JNI argument.
JVM_INSTANCE_WRAPPER(KtProcess, "godot.registration.KtProcess") {
    JVM_CLASS(KtProcess)

    JNI_OBJECT_METHOD(GET_NAME)
    JNI_VOID_METHOD(INVOKE)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_NAME, "getName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(INVOKE, "invoke", "(Lgodot/core/KtObject;D)V")
    )
    // clang-format on

public:
    godot::StringName name;

    explicit KtProcess(jni::Env& p_env, jni::JObject p_wrapped);

    godot::MethodInfo get_member_info() const;

    _FORCE_INLINE_ void invoke(jni::Env& p_env, const KtObject* p_instance, double p_delta) const {
        if (p_instance->is_collected(p_env)) { return; }
        jvalue call_args[2] = {jni::to_jni_arg(p_instance->get_wrapped()), jni::to_jni_arg(p_delta)};
        wrapped.call_void_method<false>(p_env, INVOKE, call_args);
    }
};

#endif // GODOT_JVM_KT_PROCESS_H
