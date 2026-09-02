#ifndef GODOT_JVM_TYPE_MANAGER_H
#define GODOT_JVM_TYPE_MANAGER_H

#include "api/script/jvm_script.h"
#include "jvm/jni/env.h"
#include "jvm/wrapper/jvm_singleton_wrapper.h"

#include <classes/ref.hpp>
#include <templates/hash_map.hpp>
#include <variant/string_name.hpp>

// clang-format off
JVM_SINGLETON_WRAPPER(TypeManager, "godot.internal.reflection.TypeManager") {
    SINGLETON_CLASS(TypeManager)

    JNI_VOID_METHOD(ASSIGN_SCRIPT_TO_CLASS)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(ASSIGN_SCRIPT_TO_CLASS, "assignScriptToClass", "(IJ)V")
        INIT_NATIVE_METHOD("getMethodBindPtr", "(Ljava/lang/String;Ljava/lang/String;J)J",TypeManager::get_method_bind_ptr)
    )

public:
    void clear();
    int get_java_engine_type_constructor_index_for_type(const godot::StringName& p_type_name) const;
    bool java_engine_type_constructor_for_type_exists(const godot::StringName& p_type_name) const;
    const godot::StringName& get_engine_type_for_index(int p_index) const;
    const godot::String& get_engine_singleton_name_for_index(int p_index) const;

    void register_engine_types(jni::Env& p_env, jni::JObjectArray & p_engine_types);
    void register_engine_singletons(jni::Env& p_env, jni::JObjectArray & p_singletons);

    void assign_script_to_class(jni::Env& p_env, int p_index, const godot::Ref<godot::JvmScript>& p_script) const;

    static uintptr_t get_method_bind_ptr(JNIEnv * p_raw_env, jobject j_instance, jstring p_class_name, jstring p_method_name, jlong hash);

private:
    godot::Vector<godot::StringName> engine_type_names;
    godot::HashMap<godot::StringName, int> java_engine_types_constructors;
    godot::Vector<godot::String> engine_singleton_names;
};

// clang-format on
#endif// GODOT_JVM_TYPE_MANAGER_H
