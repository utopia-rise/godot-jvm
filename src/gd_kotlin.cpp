#include <core/print_string.h>
#include <cassert>
#include "gd_kotlin.h"
#include "core/os/os.h"
#include "core/project_settings.h"
#include "bootstrap.h"

jni::JObject get_current_thread(jni::Env& env) {
    jni::JClass cls = env.find_class("java/lang/Thread");
    jni::MethodId current_thread_method = cls.get_static_method_id(env, "currentThread", "()Ljava/lang/Thread;");
    jni::JObject thread = cls.call_static_object_method(env, current_thread_method);
    assert(!thread.isNull());
    return thread;
}

jni::JObject to_java_url(jni::Env& env, const String& bootstrapJar) {
    jni::JClass cls = env.find_class("java/io/File");
    jni::MethodId ctor = cls.get_constructor_method_id(env, "(Ljava/lang/String;)V");
    jni::JObject path = env.new_string(bootstrapJar.utf8().get_data());
    jni::JObject file = cls.new_instance(env, ctor, {path});
    assert(!file.isNull());
    jni::MethodId to_url_method = cls.get_method_id(env, "toURL", "()Ljava/net/URL;");
    jni::JObject url = file.call_object_method(env, to_url_method);
    assert(!url.isNull());
    return url;
}

jni::JObject create_class_loader(jni::Env& env, const String& bootstrapJar) {
    jni::JObject url = to_java_url(env, bootstrapJar);
    jni::JClass url_cls = env.find_class("java/net/URL");
    jni::JObjectArray urls = url_cls.new_object_array(env, 1, {url});
    jni::JClass class_loader_cls = env.find_class("java/net/URLClassLoader");
    jni::MethodId ctor = class_loader_cls.get_constructor_method_id(env, "([Ljava/net/URL;)V");
    jni::JObject class_loader = class_loader_cls.new_instance(env, ctor, {urls});
    assert(!class_loader_cls.isNull());
    return class_loader;
}

void set_context_class_loader(jni::Env& env, jni::JObject thread, jni::JObject classLoader) {
    auto cls = env.find_class("java/lang/Thread");
    auto setContextClassLoaderMethod = cls.get_method_id(env, "setContextClassLoader", "(Ljava/lang/ClassLoader;)V");
    thread.call_object_method(env, setContextClassLoaderMethod, {classLoader});
}

GDKotlin& GDKotlin::get_instance() {
    static GDKotlin instance;
    return instance;
}

void load_classes_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    GDKotlin::get_instance().register_classes(env, jni::JObjectArray(p_classes));
}

void unload_classes_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    GDKotlin::get_instance().unregister_classes(env, jni::JObjectArray(p_classes));
}

void GDKotlin::init() {
    // Initialize type mappings
    KtVariant::initMethodArray();

    jni::InitArgs args;
    args.version = JNI_VERSION_10;
    args.option("-Xcheck:jni");
    args.option("-XX:+UseZGC");
    jni::Jvm::init(args);
    print_line("Starting JVM ...");
    auto project_settings = ProjectSettings::get_singleton();
    scripts_root = "res://src/main/kotlin/";
    String bootstrap_jar = project_settings->globalize_path("res://build/libs/godot-bootstrap.jar");
    print_line(vformat("Loading bootstrap jar: %s", bootstrap_jar));
    auto env = jni::Jvm::current_env();
    jni::JObject current_thread = get_current_thread(env);
    class_loader = create_class_loader(env, bootstrap_jar).new_global_ref<jni::JObject>(env);
    set_context_class_loader(env, current_thread, class_loader);

    jni::JClass bootstrap_cls = env.load_class("godot.runtime.Bootstrap", class_loader);
    jni::MethodId ctor = bootstrap_cls.get_constructor_method_id(env, "()V");
    jni::JObject instance = bootstrap_cls.new_instance(env, ctor);
    bootstrap = new Bootstrap(instance, class_loader);
    bootstrap->register_hooks(env, load_classes_hook, unload_classes_hook);
    bool is_editor = Engine::get_singleton()->is_editor_hint();
    String project_path = project_settings->globalize_path("res://");
    bootstrap->init(env, is_editor, project_path);

    jni::JClass transfer_ctx_cls = env.load_class("godot.core.TransferContext", class_loader);
    jni::FieldId transfer_ctx_instance_field = transfer_ctx_cls.get_static_field_id(env, "INSTANCE",
                                                                                    "Lgodot/core/TransferContext;");
    jni::JObject transfer_ctx_instance = transfer_ctx_cls.get_static_object_field(env, transfer_ctx_instance_field);
    CRASH_COND_MSG(transfer_ctx_instance.isNull(), "Failed to retrieve TransferContext instance")
    transfer_context = new TransferContext(transfer_ctx_instance, class_loader);
}

void GDKotlin::finish() {
    auto env = jni::Jvm::current_env();
    delete transfer_context;
    transfer_context = nullptr;
    bootstrap->finish(env);
    delete bootstrap;
    bootstrap = nullptr;
    class_loader.delete_global_ref(env);
    jni::Jvm::destroy();
    print_line("Shutting down JVM ...");
}

void GDKotlin::register_classes(jni::Env& p_env, jni::JObjectArray p_classes) {
    print_line("Loading classes ...");
    for (auto i = 0; i < p_classes.length(p_env); i++) {
        auto kt_class = new KtClass(p_classes.get(p_env, i), class_loader);
        classes[kt_class->name] = kt_class;
        print_verbose(vformat("Loaded class %s : %s", kt_class->name, kt_class->super_class));
    }
}

void GDKotlin::unregister_classes(jni::Env& p_env, jni::JObjectArray p_classes) {
    print_line("Unloading classes ...");
    Map<StringName, KtClass*>::Element* current = classes.front();
    while (current != nullptr) {
        KtClass* kt_class = current->value();
        print_verbose(vformat("Unloading class %s : %s", kt_class->name, kt_class->super_class));
        delete kt_class;
        current = current->next();
    }
    classes.clear();
}

KtClass* GDKotlin::find_class(const String& p_script_path) {
    StringName class_name = p_script_path.trim_prefix(scripts_root).trim_suffix(".kt").replace("/", ".");
    ERR_FAIL_COND_V_MSG(!classes.has(class_name), nullptr, vformat("Failed to find class %s for path: %s", class_name, p_script_path))
    return classes[class_name];
}

KtClass* GDKotlin::find_class_by_name(const String& class_name) {
    ERR_FAIL_COND_V_MSG(!classes.has(class_name), nullptr, vformat("Failed to find class for path: %s", class_name))
    return classes[class_name];
}

jni::JObject& GDKotlin::get_class_loader() {
    return class_loader;
}
