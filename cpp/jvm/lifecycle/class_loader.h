#ifndef GODOT_JVM_CLASS_LOADER_H
#define GODOT_JVM_CLASS_LOADER_H

#include "jvm/jni/wrapper.h"

class ClassLoader {
private:
    jni::JObject wrapped;

    ClassLoader(jni::Env& p_env, jni::JObject p_wrapped);

public:
    ClassLoader() = delete;
    ClassLoader(const ClassLoader&) = delete;
    void operator=(const ClassLoader&) = delete;
    ClassLoader(ClassLoader&& instance) = delete;
    void operator=(ClassLoader& $) = delete;
    ~ClassLoader();

    const jni::JObject& get_wrapped() const;

    jni::JClass load_class(jni::Env& env, const char* name);
    void set_as_context_loader(jni::Env& env);

    static ClassLoader* create_instance(jni::Env& env, const godot::String& full_jar_path, const jni::JObject& p_parent_loader);
};

#endif// GODOT_JVM_CLASS_LOADER_H
