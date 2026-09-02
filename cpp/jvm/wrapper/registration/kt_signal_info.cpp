#include "kt_signal_info.h"

KtSignalInfo::KtSignalInfo(jni::Env& p_env, jni::JObject p_wrapped) : JvmInstanceWrapper(p_env, p_wrapped) {
    jni::JString string {wrapped.call_object_method(p_env, GET_NAME)};
    name = p_env.from_jstring(string);

    jni::JObjectArray args_array {wrapped.call_object_method(p_env, GET_ARGUMENTS)};

    for (int i = 0; i < args_array.length(p_env); i++) {
        arguments.push_back(new KtPropertyInfo(p_env, args_array.get(p_env, i)));
    }

    string.delete_local_ref(p_env);
    args_array.delete_local_ref(p_env);
}

KtSignalInfo::~KtSignalInfo() {
    for (const KtPropertyInfo* argument : arguments) {
        delete argument;
    }
}

godot::MethodInfo KtSignalInfo::get_member_info() const {
    godot::MethodInfo method_info;
    method_info.name = name;
    for (const KtPropertyInfo* argument : arguments) {
        method_info.arguments.push_back(argument->toPropertyInfo());
    }
    return method_info;
}
