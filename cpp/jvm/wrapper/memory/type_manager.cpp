#include "type_manager.h"

#include <godot.hpp>

void TypeManager::clear() {
    engine_type_names.clear();
    java_engine_types_constructors.clear();
    engine_singleton_names.clear();
}

int TypeManager::get_java_engine_type_constructor_index_for_type(const godot::StringName& p_type_name) const {
    return java_engine_types_constructors[p_type_name];
}

bool TypeManager::java_engine_type_constructor_for_type_exists(const godot::StringName& p_type_name) const {
    return java_engine_types_constructors.has(p_type_name);
}

const godot::StringName& TypeManager::get_engine_type_for_index(int p_index) const {
    return engine_type_names[p_index];
}

const godot::String& TypeManager::get_engine_singleton_name_for_index(int p_index) const {
    return engine_singleton_names[p_index];
}

void TypeManager::register_engine_types(jni::Env& p_env, jni::JObjectArray& p_engine_types) {
    for (int i = 0; i < p_engine_types.length(p_env); ++i) {
        jni::JObject type = p_engine_types.get(p_env, i);
        const godot::String& class_name = p_env.from_jstring(static_cast<jni::JString>(type));
        engine_type_names.insert(i, class_name);
        java_engine_types_constructors[class_name] = i;
#ifdef DEV_ENABLED
        JVM_LOG_VERBOSE("Registered %s engine type with index %s.", class_name, i);
#endif
        type.delete_local_ref(p_env);
    }
}

void TypeManager::register_engine_singletons(jni::Env& p_env, jni::JObjectArray& p_singletons) {
    for (int i = 0; i < p_singletons.length(p_env); ++i) {
        jni::JObject name = p_singletons.get(p_env, i);
        const godot::String& singleton_name = p_env.from_jstring(static_cast<jni::JString>(name));
        engine_singleton_names.insert(i, singleton_name);
        name.delete_local_ref(p_env);
    }
}

void TypeManager::assign_script_to_class(jni::Env& p_env, int p_index, const godot::Ref<godot::JvmScript>& p_script) const {
    jvalue args[2] = {
      jni::to_jni_arg(p_index),
      jni::to_jni_arg(p_script.ptr())
    };
    wrapped.call_void_method(p_env, ASSIGN_SCRIPT_TO_CLASS, args);
}

uintptr_t TypeManager::get_method_bind_ptr(JNIEnv* p_raw_env, jobject, jstring p_class_name, jstring p_method_name, jlong hash) {
    jni::Env env = p_raw_env;
    godot::StringName class_name = env.from_jstring(jni::JString(p_class_name));
    godot::StringName method_name = env.from_jstring(jni::JString(p_method_name));

    GDExtensionMethodBindPtr bind =
      godot::internal::gdextension_interface_classdb_get_method_bind(class_name._native_ptr(), method_name._native_ptr(), hash);

    JVM_ERR_FAIL_COND_V_MSG(
      !bind,
      0,
      "Method %s from Class %s doesn't exist. Check that your Godot-JVM library matches this Godot version.",
      method_name,
      class_name
    );

    return reinterpret_cast<uintptr_t>(bind);
}

TypeManager::~TypeManager() = default;
