#include "kt_process.h"

#include <core/property_info.hpp>

KtProcess::KtProcess(jni::Env& p_env, jni::JObject p_wrapped) : JvmInstanceWrapper(p_env, p_wrapped) {
    jni::JString string(wrapped.call_object_method(p_env, GET_NAME));
    name = godot::StringName(p_env.from_jstring(string));
    string.delete_local_ref(p_env);
}

godot::MethodInfo KtProcess::get_member_info() const {
    return godot::MethodInfo(godot::Variant::NIL, name, godot::PropertyInfo(godot::Variant::FLOAT, "delta"));
}
