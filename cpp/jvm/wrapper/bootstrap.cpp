#include "bootstrap.h"

#include "api/script/jvm_script_manager.h"
#include "jvm/wrapper/memory/type_manager.h"
#include "jvm/wrapper/registration/kt_class.h"

void Bootstrap::load_classes(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    jni::JObjectArray jni_classes {p_classes};
    jni::JObject j_object {p_this};

    godot::Vector<KtClass*> classes;
    for (auto i = 0; i < jni_classes.length(env); i++) {
        KtClass* kt_class = new KtClass(env, jni_classes.get(env, i));
        kt_class->fetch_members(env);
        classes.append(kt_class);
        JVM_DEV_VERBOSE("Loaded class %s : %s", kt_class->registered_class_name, kt_class->base_godot_class);
    }

    j_object.delete_local_ref(env);
    jni_classes.delete_local_ref(env);

    godot::JvmScriptManager::get_instance()->initialize_scripts(classes);
}

void Bootstrap::register_engine_type(JNIEnv* p_env, jobject p_this, jobjectArray p_classes_names, jobjectArray p_singleton_names) {
#ifdef DEV_ENABLED
    JVM_LOG_VERBOSE("Starting to register managed engine types...");
#endif
    jni::Env env(p_env);

    jni::JObjectArray engine_types {p_classes_names};
    TypeManager::get_instance().register_engine_types(env, engine_types);

    jni::JObjectArray singleton_names {p_singleton_names};
    TypeManager::get_instance().register_engine_singletons(env, singleton_names);

    jni::JObject j_object {p_this};
    j_object.delete_local_ref(env);
    engine_types.delete_local_ref(env);
    singleton_names.delete_local_ref(env);
#ifdef DEV_ENABLED
    JVM_LOG_VERBOSE("Done registering managed engine types...");
#endif
}

Bootstrap::Bootstrap(jni::Env& p_env, jni::JObject p_wrapped) : JvmInstanceWrapper(p_env, p_wrapped) {}

void Bootstrap::initialize_engine_types(jni::Env& p_env) {
    wrapped.call_void_method(p_env, INITIALIZE_ENGINE_TYPES);
}

void Bootstrap::init_jar(jni::Env& p_env, const jni::JObject& p_class_loader) {
    jvalue args[1] = {jni::to_jni_arg(p_class_loader)};
    wrapped.call_void_method(p_env, INIT_JAR, args);
}

void Bootstrap::init_native_image(jni::Env& p_env) {
    wrapped.call_void_method(p_env, INIT_NATIVE_IMAGE);
}

godot::String Bootstrap::get_version(jni::Env& p_env) {
    jni::JString str {wrapped.call_object_method(p_env, GET_VERSION)};
    godot::String ret {p_env.from_jstring(str)};
    str.delete_local_ref(p_env);
    return ret;
}

void Bootstrap::finish(jni::Env& p_env) {
    wrapped.call_void_method(p_env, FINISH);
}