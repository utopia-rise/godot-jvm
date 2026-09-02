#include "kt_function.h"

#include "godot_jvm.h"
#include "jvm/wrapper/memory/transfer_context.h"

#include <classes/global_constants.hpp>

KtFunction::KtFunction(jni::Env& p_env, jni::JObject p_wrapped) :
  JvmInstanceWrapper(p_env, p_wrapped) {
    method_info = new KtFunctionInfo(p_env, wrapped.call_object_method(p_env, GET_FUNCTION_INFO));
    has_return_value = method_info->return_val->type != godot::Variant::NIL
                    || (method_info->return_val->usage & godot::PropertyUsageFlags::PROPERTY_USAGE_NIL_IS_VARIANT) != 0;
}

KtFunction::~KtFunction() {
    delete method_info;
}

godot::MethodInfo KtFunction::get_member_info() {
    return method_info->to_method_info();
}

godot::StringName KtFunction::get_name() const {
    return method_info->name;
}

int KtFunction::get_parameter_count() const {
    // No "getParameterCount" JNI method exists on the real Kotlin KtFunction (never did — that JNI binding was a porting mistake, not a Kotlin-side gap). The argument count is already known locally from the getArguments() array fetched into me...
    return method_info->arguments.size();
}

KtRpcConfig* KtFunction::get_rpc_config() const {
    return method_info->rpc_config;
}

KtFunctionInfo* KtFunction::get_kt_function_info() {
    return method_info;
}

void KtFunction::invoke(jni::Env& p_env, const KtObject* instance, const godot::Variant** p_args, int args_count, godot::Variant& r_ret) {
    TransferContext& transferContext = TransferContext::get_instance();
    transferContext.write_args(p_env, p_args, args_count);
    jvalue call_args[1] = {jni::to_jni_arg(instance->get_wrapped())};

    if (has_return_value) {
        jni::JObject ret = wrapped.call_object_method<false>(p_env, INVOKE_WITH_RETURN, call_args);
        transferContext.read_return_value(p_env, r_ret);
        ret.delete_local_ref(p_env);
    } else {
        wrapped.call_void_method<false>(p_env, INVOKE, call_args);
    }
}

KtFunctionInfo::KtFunctionInfo(jni::Env& p_env, jni::JObject p_wrapped) : JvmInstanceWrapper(p_env, p_wrapped) {
    jni::JString string {wrapped.call_object_method(p_env, GET_NAME)};
    name = p_env.from_jstring(string);

    jni::JObjectArray propertyInfoArray {wrapped.call_object_method(p_env, GET_ARGUMENTS)};
    for (int i = 0; i < propertyInfoArray.length(p_env); i++) {
        arguments.push_back(new KtPropertyInfo(p_env, propertyInfoArray.get(p_env, i)));
    }

    return_val = new KtPropertyInfo(p_env, wrapped.call_object_method(p_env, GET_RETURN_VAL));
    rpc_config = new KtRpcConfig(p_env, wrapped.call_object_method(p_env, GET_RPC_CONFIG));

    propertyInfoArray.delete_local_ref(p_env);
    string.delete_local_ref(p_env);
}

KtFunctionInfo::~KtFunctionInfo() {
    delete return_val;

    godot::List<KtPropertyInfo*>::Element* current = arguments.front();
    while (current) {
        KtPropertyInfo* propertyInfo = current->get();
        delete propertyInfo;
        current = current->next();
    }
    arguments.clear();
}

godot::MethodInfo KtFunctionInfo::to_method_info() const {
    godot::MethodInfo methodInfo;
    methodInfo.name = name;
    for (auto argument : arguments) {
        methodInfo.arguments.push_back(argument->toPropertyInfo());
    }
    methodInfo.return_val = return_val->toPropertyInfo();
    return methodInfo;
}
