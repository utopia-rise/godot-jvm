#include "class_loader.h"

#include "jvm/jni/local_frame.h"
#include "jvm/jni/methods.h"

#ifdef ANDROID_ENABLED
#include <sys/stat.h>
#endif

#include <cassert>

ClassLoader::ClassLoader(jni::Env& p_env, jni::JObject p_wrapped) {
    wrapped = p_wrapped.new_global_ref<jni::JObject>(p_env);
    p_wrapped.delete_local_ref(p_env);
}

ClassLoader::~ClassLoader() {
    jni::Env env = jni::Jvm::current_env();
    wrapped.delete_global_ref(env);
}

#ifndef ANDROID_ENABLED
jni::JObject to_java_url(jni::Env& env, const godot::String& bootstrapJar) {
    jni::JClass cls = env.find_class("java/io/File");
    jni::MethodID ctor = cls.get_constructor_method_id(env, "(Ljava/lang/String;)V");
    jni::JObject path = env.new_string(bootstrapJar.utf8().get_data());
    jvalue args[1] = {jni::to_jni_arg(path)};
    jni::JObject file = cls.new_instance(env, ctor, args);
    assert(!file.is_null());

    jni::ObjectMethodID to_url_method = jni::ObjectMethodID {cls.get_method_id(env, "toURL", "()Ljava/net/URL;")};
    jni::JObject url = file.call_object_method(env, to_url_method);
    assert(!url.is_null());

    return url;
}
#endif

ClassLoader* ClassLoader::create_instance(
    jni::Env& env,
    const godot::String& full_jar_path,
    const jni::JObject& p_parent_loader
) {
    // A class loader is built from half a dozen intermediate references, and which ones exist depends on the
    // platform, so they are dropped together rather than one by one down each branch. The loader itself survives:
    // the ClassLoader constructor promotes it to a global reference before the frame is popped.
    jni::LocalFrame local_frame(16);

#ifdef ANDROID_ENABLED
    // mark file as read only. Needed since android 14:
    // https://developer.android.com/about/versions/14/behavior-changes-14#safer-dynamic-code-loading
    chmod(full_jar_path.utf8().get_data(), S_IRUSR | S_IRGRP | S_IROTH);

    jni::JClass class_loader_cls = env.find_class("dalvik/system/DexClassLoader");
    jni::MethodID ctor = class_loader_cls.get_constructor_method_id(
        env,
        "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V"
    );
    jni::JObject jar_path = env.new_string(full_jar_path.utf8().get_data());
    jvalue args[4] = {
        jni::to_jni_arg(jar_path),
        jni::to_jni_arg(jni::JObject(nullptr)),
        jni::to_jni_arg(jni::JObject(nullptr)),
        jni::to_jni_arg(p_parent_loader)
    };
#else
    jni::JObject url = to_java_url(env, full_jar_path);
    jni::JClass url_cls = env.find_class("java/net/URL");
    jni::JObjectArray urls = url_cls.new_object_array(env, 1, url);
    jni::JClass class_loader_cls = env.find_class("java/net/URLClassLoader");
    jni::MethodID ctor = class_loader_cls.get_constructor_method_id(env, "([Ljava/net/URL;Ljava/lang/ClassLoader;)V");

    jni::JObject parent_loader;
    if (p_parent_loader.is_null()) {
        jni::MethodID get_system_loader =
            class_loader_cls.get_static_method_id(env, "getSystemClassLoader", "()Ljava/lang/ClassLoader;");
        parent_loader = class_loader_cls.call_static_object_method(env, get_system_loader);
    } else {
        parent_loader = p_parent_loader;
    }
    jvalue args[2] = {jni::to_jni_arg(urls), jni::to_jni_arg(parent_loader)};
#endif
    jni::JObject class_loader = class_loader_cls.new_instance(env, ctor, args);
    assert(!class_loader_cls.is_null());
    return new ClassLoader(env, class_loader);
}

jni::JClass ClassLoader::load_class(jni::Env& env, const char* name) {
    static jni::ObjectMethodID loadClassMethodId;

    if (loadClassMethodId.methodId == nullptr) {
        jni::JClass cls = env.find_class("java/lang/ClassLoader");
        loadClassMethodId.methodId = cls.get_method_id(env, "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;");
        cls.delete_local_ref(env);
    }
    jni::JString class_name(env.new_string(name));
    jvalue args[1] = {jni::to_jni_arg(class_name)};
    // No frame here: the class is returned as a local reference and belongs to the caller.
    jni::JObject ret = wrapped.call_object_method(env, loadClassMethodId, args);
    class_name.delete_local_ref(env);
    return jni::JClass((jclass) ret.obj);
}

void ClassLoader::set_as_context_loader(jni::Env& env) {
    jni::JClass cls = env.find_class("java/lang/Thread");
    jni::ObjectMethodID current_thread_method = jni::ObjectMethodID {
        cls.get_static_method_id(env, "currentThread", "()Ljava/lang/Thread;")
    };
    jni::JObject thread = cls.call_static_object_method(env, current_thread_method.methodId);
    assert(!thread.is_null());

    jni::VoidMethodID setContextClassLoaderMethod = jni::VoidMethodID {
        cls.get_method_id(env, "setContextClassLoader", "(Ljava/lang/ClassLoader;)V")
    };
    jvalue args[1] = {jni::to_jni_arg(wrapped)};

    thread.call_void_method(env, setContextClassLoaderMethod, args);
    thread.delete_local_ref(env);
    cls.delete_local_ref(env);
}

const jni::JObject& ClassLoader::get_wrapped() const {
    return wrapped;
}
