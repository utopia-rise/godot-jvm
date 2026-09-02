#ifndef GODOT_JVM_KT_FUNCTION_H
#define GODOT_JVM_KT_FUNCTION_H

#include "jvm/wrapper/jvm_instance_wrapper.h"
#include "kt_object.h"
#include "kt_property.h"
#include "kt_rpc_config.h"

JVM_INSTANCE_WRAPPER(KtFunctionInfo, "godot.registration.KtFunctionInfo") {
    JVM_CLASS(KtFunctionInfo)

    // clang-format off
    JNI_OBJECT_METHOD(GET_NAME)
    JNI_OBJECT_METHOD(GET_ARGUMENTS)
    JNI_OBJECT_METHOD(GET_RETURN_VAL)
    JNI_OBJECT_METHOD(GET_RPC_CONFIG)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_NAME, "getName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_ARGUMENTS, "getArguments", "()[Lgodot/registration/KtPropertyInfo;")
        INIT_JNI_METHOD(GET_RETURN_VAL, "getReturnVal", "()Lgodot/registration/KtPropertyInfo;")
        INIT_JNI_METHOD(GET_RPC_CONFIG, "getRpcConfig", "()Lgodot/registration/KtRpcConfig;")
    )

    // clang-format on

public:
    explicit KtFunctionInfo(jni::Env & p_env, jni::JObject p_wrapped);
    ~KtFunctionInfo();

    godot::String name;
    godot::List<KtPropertyInfo*> arguments;
    KtPropertyInfo* return_val;
    KtRpcConfig* rpc_config;

    godot::MethodInfo to_method_info() const;
};

JVM_INSTANCE_WRAPPER(KtFunction, "godot.registration.KtFunction") {
    JVM_CLASS(KtFunction)

    // clang-format off
    JNI_OBJECT_METHOD(GET_FUNCTION_INFO)
    JNI_VOID_METHOD(INVOKE)
    JNI_OBJECT_METHOD(INVOKE_WITH_RETURN)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_FUNCTION_INFO, "getFunctionInfo", "()Lgodot/registration/KtFunctionInfo;")
        INIT_JNI_METHOD(INVOKE, "invoke", "(Lgodot/core/KtObject;)V")
        INIT_JNI_METHOD(INVOKE_WITH_RETURN, "invokeWithReturn", "(Lgodot/core/KtObject;)Ljava/lang/Object;")
    )
    // clang-format on

private:
    KtFunctionInfo* method_info;
    bool has_return_value;

public:
    explicit KtFunction(jni::Env & p_env, jni::JObject p_wrapped);
    ~KtFunction();

    godot::StringName get_name() const;
    int get_parameter_count() const;
    KtRpcConfig* get_rpc_config() const;

    godot::MethodInfo get_member_info();
    KtFunctionInfo* get_kt_function_info();

    void invoke(jni::Env & p_env, const KtObject* instance, const godot::Variant** p_args, int args_count, godot::Variant& r_ret);
};

#endif // GODOT_JVM_KT_FUNCTION_H
