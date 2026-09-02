#ifndef GODOT_JVM_KOTLIN_CALLABLE_CUSTOM_H
#define GODOT_JVM_KOTLIN_CALLABLE_CUSTOM_H

#include "jvm/wrapper/jvm_instance_wrapper.h"

#include <gdextension_interface.h>
#include <variant/callable.hpp>
#include <variant/callable_custom.hpp>

JVM_INSTANCE_WRAPPER(LambdaContainer, "godot.core.LambdaContainer") {
    JVM_CLASS(LambdaContainer)
    // clang-format off

    JNI_VOID_METHOD(INVOKE_NO_RETURN)
    JNI_OBJECT_METHOD(INVOKE_WITH_RETURN)
    JNI_VOID_METHOD(CANCEL)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(INVOKE_NO_RETURN, "invoke", "()V")
        INIT_JNI_METHOD(INVOKE_WITH_RETURN, "invokeWithReturn", "()Ljava/lang/Object;")
        INIT_JNI_METHOD(CANCEL, "cancel", "()V")
    )

    // clang-format on

public:
    void invoke(jni::Env & p_env, const godot::Variant** p_args, int args_count, godot::Variant& r_ret) const;
    void on_destroy(jni::Env & p_env) const;
    int get_hash_code() const;
    bool equals(const LambdaContainer& other) const;

    LambdaContainer(jni::Env & p_env, jni::JObject p_wrapped, godot::Variant::Type return_type, int p_hash_code, bool p_has_on_cancel);

private:
    int hash_code;
    bool has_return_value;
    bool has_on_cancel;
    mutable bool has_been_called;
};

class KotlinCallableCustom : public godot::CallableCustom {
public:
    void call(const godot::Variant** p_arguments, int p_argcount, godot::Variant& r_return_value, GDExtensionCallError& r_call_error) const override;

    uint32_t hash() const override;
    godot::String get_as_text() const override;
    CompareEqualFunc get_compare_equal_func() const override;
    CompareLessFunc get_compare_less_func() const override;
    godot::ObjectID get_object() const override;

    KotlinCallableCustom(jni::Env& p_env, jni::JObject p_wrapped, godot::Variant::Type return_type, int p_hash_code, bool p_has_on_destroy);
    ~KotlinCallableCustom();

private:
    LambdaContainer kt_callable;

    static bool compare_equal(const godot::CallableCustom* p_a, const godot::CallableCustom* p_b);
    static bool compare_less(const godot::CallableCustom* p_a, const godot::CallableCustom* p_b);
};

#endif // GODOT_JVM_KOTLIN_CALLABLE_CUSTOM_H
