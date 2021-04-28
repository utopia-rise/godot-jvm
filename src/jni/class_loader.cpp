#include "class_loader.h"
#include <cassert>

ClassLoader::ClassLoader(): class_loader{jni::JObject()} {

}

jni::JObject to_java_url(jni::Env& env, const String& bootstrapJar) {
    jni::JClass cls  {env.find_class("java/io/File")};
    jni::MethodId ctor {cls.get_constructor_method_id(env, "(Ljava/lang/String;)V")};
    jni::JObject path {env.new_string(bootstrapJar.utf8().get_data())};
    jvalue args[1] = {jni::to_jni_arg(path)};
    jni::JObject file {cls.new_instance(env, ctor, args)};
    assert(!file.is_null());
    jni::MethodId to_url_method {cls.get_method_id(env, "toURL", "()Ljava/net/URL;")};
    jni::JObject url {file.call_object_method(env, to_url_method)};
    assert(!url.is_null());
    return url;
}

jni::JObject ClassLoader::provide_loader(jni::Env& env, const String& full_jar_path, const jni::JObject& p_parent_loader) {
#ifdef __ANDROID__
    jni::JClass class_loader_cls{env.find_class("dalvik/system/DexClassLoader")};
    jni::MethodId ctor{
            class_loader_cls.get_constructor_method_id(
                    env,
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V"
            )
    };
    jni::JObject jar_path{env.new_string(full_jar_path.utf8().get_data())};
    jvalue args[4] = {
            jni::to_jni_arg(jar_path),
            jni::to_jni_arg(jni::JObject(nullptr)),
            jni::to_jni_arg(jni::JObject(nullptr)),
            jni::to_jni_arg(p_parent_loader)
    };
    return class_loader_cls.new_instance(env, ctor, args);
#elif defined(__GRAAL__)
    return jni::JObject();
#else
    jni::JObject url = to_java_url(env, full_jar_path);
    jni::JClass url_cls = env.find_class("java/net/URL");
    jni::JObjectArray urls = url_cls.new_object_array(env, 1, {url});
    jni::JClass class_loader_cls = env.find_class("java/net/URLClassLoader");
    jni::MethodId ctor = class_loader_cls.get_constructor_method_id(
            env,
            "([Ljava/net/URL;Ljava/lang/ClassLoader;)V"
    );
    jvalue args[2] = {jni::to_jni_arg(urls), jni::to_jni_arg(p_parent_loader)};
    jni::JObject class_loader = class_loader_cls.new_instance(env, ctor, args);
    assert(!class_loader_cls.is_null());
    return class_loader;
#endif
}

void ClassLoader::set_default_loader(jni::JObject& p_class_loader) {
#ifndef __GRAAL__
    jni::Env env{jni::Jvm::current_env()};
    get_instance().class_loader = p_class_loader.new_global_ref<jni::JObject>(env);

    jni::JClass cls {env.find_class("java/lang/Thread")};
    jni::MethodId current_thread_method {cls.get_static_method_id(env, "currentThread", "()Ljava/lang/Thread;")};
    jni::JObject thread {cls.call_static_object_method(env, current_thread_method)};
    assert(!thread.is_null());

    _jmethodID * setContextClassLoaderMethod {cls.get_method_id(env, "setContextClassLoader", "(Ljava/lang/ClassLoader;)V")};
    jvalue args[1] = {jni::to_jni_arg(p_class_loader)};

    thread.call_void_method(env, setContextClassLoaderMethod, args);
#endif
}

jni::JObject& ClassLoader::get_default_loader() {
    return get_instance().class_loader;
}

void ClassLoader::delete_default_loader(jni::Env& env) {
#ifndef __GRAAL__
    get_instance().class_loader.delete_global_ref(env);
    get_instance().class_loader = jni::JObject(nullptr);
#endif
}

ClassLoader& ClassLoader::get_instance() {
    static ClassLoader instance;
    return instance;
}
