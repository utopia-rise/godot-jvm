#include <core/print_string.h>
#include <cassert>
#include <main/main.h>
#include "gd_kotlin.h"
#include "core/os/os.h"
#include "core/project_settings.h"
#include "bootstrap.h"
#include "type_manager.h"
#include "bridges_manager.h"
#include "logging.h"

// If changed, remember to change also TransferContext::bufferCapacity on JVM side
const int DEFAULT_SHARED_BUFFER_SIZE{20'000'000};

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
    jvalue args[1] = {jni::to_jni_arg(path)};
    jni::JObject file = cls.new_instance(env, ctor, args);
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
    jvalue args[1] = {jni::to_jni_arg(urls)};
    jni::JObject class_loader = class_loader_cls.new_instance(env, ctor, args);
    assert(!class_loader_cls.isNull());
    return class_loader;
}

void set_context_class_loader(jni::Env& env, jni::JObject thread, jni::JObject classLoader) {
    auto cls = env.find_class("java/lang/Thread");
    auto setContextClassLoaderMethod = cls.get_method_id(env, "setContextClassLoader", "(Ljava/lang/ClassLoader;)V");
    jvalue args[1] = {jni::to_jni_arg(classLoader)};
    thread.call_object_method(env, setContextClassLoaderMethod, args);
}

GDKotlin& GDKotlin::get_instance() {
    static GDKotlin instance;
    return instance;
}

void load_classes_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    jni::JObjectArray classes{jni::JObjectArray(p_classes)};
    GDKotlin::get_instance().register_classes(env, classes);
    jni::JObject j_object{p_this};
    j_object.delete_local_ref(env);
    classes.delete_local_ref(env);
}

void unload_classes_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    jni::JObjectArray classes{jni::JObjectArray(p_classes)};
    GDKotlin::get_instance().unregister_classes(env, classes);
    jni::JObject j_object{p_this};
    j_object.delete_local_ref(env);
    classes.delete_local_ref(env);
}

void register_engine_types_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_engine_types, jobjectArray p_method_names,
                                jobjectArray p_types_of_methods) {
    LOG_VERBOSE("Starting to register managed engine types...")
    jni::Env env(p_env);
    jni::JObjectArray engine_types{p_engine_types};
    for (int i = 0; i < engine_types.length(env); ++i) {
        const String& class_name = env.from_jstring(static_cast<jni::JString>(engine_types.get(env, i)));
        GDKotlin::get_instance().engine_type_names.insert(i, class_name);
        TypeManager::get_instance().JAVA_ENGINE_TYPES_CONSTRUCTORS[class_name] = i;
        LOG_VERBOSE(vformat("Registered %s engine type with index %s.", class_name, i))
    }
    jni::JObjectArray method_names{p_method_names};
    jni::JObjectArray types_of_methods{p_types_of_methods};
    jni::JClass integer_class{env.load_class("java.lang.Integer", GDKotlin::get_instance().get_class_loader())};
    jni::MethodId integer_get_value_method{integer_class.get_method_id(env, "intValue", "()I")};
    for (int i = 0; i < method_names.length(env); i++) {
        int type_of_method{static_cast<int>(types_of_methods.get(env, i).call_int_method(env, integer_get_value_method))};
        GDKotlin::get_instance().engine_type_method.insert(
                i,
                ClassDB::get_method(
                        GDKotlin::get_instance().engine_type_names[type_of_method],
                        env.from_jstring(method_names.get(env, i))
                )
        );
    }
    jni::JObject j_object{p_this};
    j_object.delete_local_ref(env);
    engine_types.delete_local_ref(env);
    method_names.delete_local_ref(env);
    LOG_VERBOSE("Done registering managed engine types...")
}

void GDKotlin::init() {
    if (Main::is_project_manager()) {
        LOG_VERBOSE("Detected that we're in the project manager. Won't initialize kotlin lang.")
        return;
    }
    jni::InitArgs args;
    args.version = JNI_VERSION_1_8;
#ifdef DEBUG_ENABLED
    args.option("-Xcheck:jni");
#endif

    // Initialize remote jvm debug if one of jvm debug arguments is encountered.
    // Initialize if jvm GC should be forced
    String jvm_debug_port;
    String jvm_debug_address;
    String jvm_jmx_port;
    bool is_gc_force_mode{false};
    bool is_gc_activated{true};
    long gc_thread_period_interval{500};
    int jvm_to_engine_shared_buffer_size{DEFAULT_SHARED_BUFFER_SIZE};
    bool should_display_leaked_jvm_instances_on_close{true};
    const List<String>& cmdline_args{OS::get_singleton()->get_cmdline_args()};
    for (int i = 0; i < cmdline_args.size(); ++i) {
        const String cmd_arg{cmdline_args[i]};
        if (cmd_arg.find("--jvm-debug-port") >= 0) {
            if (split_jvm_debug_argument(cmd_arg, jvm_debug_port) == OK) {
                if (jvm_debug_port.empty()) {
                    jvm_debug_port = "5005";
                }
            } else {
                break;
            }
        } else if (cmd_arg.find("--jvm-debug-address") >= 0) {
            if (split_jvm_debug_argument(cmd_arg, jvm_debug_address) == OK) {
                if (jvm_debug_address.empty()) {
                    jvm_debug_address = "*";
                }
            } else {
                break;
            }
        } else if (cmd_arg.find("--jvm-jmx-port") >= 0) {
            if (split_jvm_debug_argument(cmd_arg, jvm_jmx_port) == OK) {
                if (jvm_jmx_port.empty()) {
                    jvm_jmx_port = "9010";
                }
            }
        } else if (cmd_arg.find("--jvm-gc-thread-period-millis") >= 0) {
            String result;
            if (split_jvm_debug_argument(cmd_arg, result) == OK) {
                gc_thread_period_interval = result.to_int64();
            }
        } else if (cmd_arg.find("--jvm-to-engine-shared-buffer-size") >= 0) {
            String result;
            if (split_jvm_debug_argument(cmd_arg, result) == OK) {
                jvm_to_engine_shared_buffer_size = result.to_int();
                //TODO: Link to documentation
                LOG_WARNING(
                        vformat("Warning ! Buffer capacity was changed to %s, this is not a recommended practice",
                                result)
                )
            }
        } else if (cmd_arg == "--jvm-force-gc") {
            is_gc_force_mode = true;
            //TODO: Link to documentation
            LOG_WARNING("GC is started in force mode, this should only be done for debugging purpose")
        } else if (cmd_arg == "--jvm-disable-gc") {
            is_gc_activated = false;
            //TODO: Link to documentation
            LOG_WARNING("GC thread was disable. --jvm-disable-gc should only be used for debugging purpose")
        } else if (cmd_arg == "--jvm-disable-closing-leaks-warning") {
            LOG_WARNING(
                    "JVM leaked instances will not be displayed in console (see --jvm-disable-closing-leaks-warning)")
            should_display_leaked_jvm_instances_on_close = false;
        }
    }

    if (!jvm_debug_port.empty() || !jvm_debug_address.empty()) {
        if (jvm_debug_address.empty()) {
            jvm_debug_address = "*";
        } else if (jvm_debug_port.empty()) {
            jvm_debug_port = "5005";
        }

        String debug_command{
                "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=" + jvm_debug_address + ":" +
                jvm_debug_port};
        args.option(debug_command.utf8());
    }

    if (!jvm_jmx_port.empty()) {
        String port_command{"-Dcom.sun.management.jmxremote.port=" + jvm_jmx_port};
        String rmi_port{"-Dcom.sun.management.jmxremote.rmi.port=" + jvm_jmx_port};
        args.option("-Djava.rmi.server.hostname=127.0.0.1");
        args.option("-Dcom.sun.management.jmxremote");
        args.option(port_command.utf8());
        args.option(rmi_port.utf8());
        args.option("-Dcom.sun.management.jmxremote.local.only=false");
        args.option("-Dcom.sun.management.jmxremote.authenticate=false");
        args.option("-Dcom.sun.management.jmxremote.ssl=false");
        LOG_VERBOSE(vformat("Started JMX on port: %s", jvm_jmx_port))
    }

    jni::Jvm::init(args);
    LOG_INFO("Starting JVM ...")
    auto project_settings = ProjectSettings::get_singleton();
    scripts_root = "res://src/main/kotlin/";
    String bootstrap_jar = OS::get_singleton()->get_executable_path().get_base_dir() + "/godot-bootstrap.jar";
    JVM_CRASH_COND_MSG(!FileAccess::exists(bootstrap_jar),
                   "No godot-bootstrap.jar found! This file needs to stay alongside the godot editor executable!")

    LOG_INFO(vformat("Loading bootstrap jar: %s", bootstrap_jar))
    jni::Env env{jni::Jvm::current_env()};
    jni::JObject current_thread = get_current_thread(env);
    class_loader = create_class_loader(env, bootstrap_jar).new_global_ref<jni::JObject>(env);
    set_context_class_loader(env, current_thread, class_loader);

    jni::JClass transfer_ctx_cls = env.load_class("godot.core.TransferContext", class_loader);
    jni::FieldId transfer_ctx_instance_field = transfer_ctx_cls.get_static_field_id(env, "INSTANCE",
                                                                                    "Lgodot/core/TransferContext;");
    jni::JObject transfer_ctx_instance = transfer_ctx_cls.get_static_object_field(env, transfer_ctx_instance_field);
    JVM_CRASH_COND_MSG(transfer_ctx_instance.isNull(), "Failed to retrieve TransferContext instance")
    transfer_context = new TransferContext(transfer_ctx_instance, class_loader);
    if (jvm_to_engine_shared_buffer_size != DEFAULT_SHARED_BUFFER_SIZE) {
        jni::MethodId set_buffer_size_method{transfer_ctx_cls.get_method_id(env, "setBufferSize", "(I)V")};
        jvalue buffer_size[1] = {jni::to_jni_arg(jvm_to_engine_shared_buffer_size)};
        transfer_ctx_instance.call_void_method(env, set_buffer_size_method, buffer_size);
    }

    jni::JClass garbage_collector_cls{env.load_class("godot.core.GarbageCollector", class_loader)};
    jni::FieldId garbage_collector_instance_field{
            garbage_collector_cls.get_static_field_id(env, "INSTANCE", "Lgodot/core/GarbageCollector;")
    };
    jni::JObject garbage_collector_instance{
            garbage_collector_cls.get_static_object_field(env, garbage_collector_instance_field)
    };
    JVM_CRASH_COND_MSG(garbage_collector_instance.isNull(), "Failed to retrieve GarbageCollector instance")

    BridgesManager::get_instance().initialize_bridges(env, class_loader);

    if (is_gc_activated) {
        if (is_gc_force_mode) {
            LOG_VERBOSE("Starting GC thread with force mode.")
        }
        jni::MethodId start_method_id{garbage_collector_cls.get_method_id(env, "start", "(ZJ)V")};
        jvalue start_args[2] = {jni::to_jni_arg(is_gc_force_mode), jni::to_jni_arg(gc_thread_period_interval)};
        garbage_collector_instance.call_void_method(env, start_method_id, start_args);
        LOG_VERBOSE("GC thread started.")
        is_gc_started = true;
    }

    if (!should_display_leaked_jvm_instances_on_close) {
        jni::MethodId set_should_display_method_id{garbage_collector_cls.get_method_id(
                env, "setShouldDisplayLeakInstancesOnClose", "(Z)V")};
        jvalue d_arg[1] = {jni::to_jni_arg(false)};
        garbage_collector_instance.call_void_method(env, set_should_display_method_id, d_arg);
    }

    jni::JClass bootstrap_cls = env.load_class("godot.runtime.Bootstrap", class_loader);
    jni::MethodId ctor = bootstrap_cls.get_constructor_method_id(env, "()V");
    jni::JObject instance = bootstrap_cls.new_instance(env, ctor);
    bootstrap = new Bootstrap(instance, class_loader);
    bootstrap->register_hooks(env, load_classes_hook, unload_classes_hook, register_engine_types_hook);
    bool is_editor = Engine::get_singleton()->is_editor_hint();
    String project_path = project_settings->globalize_path("res://");

    bootstrap->init(env, is_editor, project_path);
}

void GDKotlin::finish() {
    if (Main::is_project_manager()) {
        LOG_VERBOSE("Detected that we're in the project manager. No cleanup necessary")
        return;
    }
    auto env = jni::Jvm::current_env();

    delete transfer_context;
    transfer_context = nullptr;
    bootstrap->finish(env);
    delete bootstrap;
    bootstrap = nullptr;

    if (is_gc_started) {
        jni::JClass garbage_collector_cls{env.load_class("godot.core.GarbageCollector", class_loader)};
        jni::FieldId garbage_collector_instance_field{
                garbage_collector_cls.get_static_field_id(env, "INSTANCE", "Lgodot/core/GarbageCollector;")
        };
        jni::JObject garbage_collector_instance{
                garbage_collector_cls.get_static_object_field(env, garbage_collector_instance_field)
        };
        JVM_CRASH_COND_MSG(garbage_collector_instance.isNull(), "Failed to retrieve GarbageCollector instance")
        jni::MethodId close_method_id{garbage_collector_cls.get_method_id(env, "close", "()V")};
        garbage_collector_instance.call_void_method(env, close_method_id);
        jni::MethodId has_closed_method_id{garbage_collector_cls.get_method_id(env, "isClosed", "()Z")};
        while (!garbage_collector_instance.call_boolean_method(env, has_closed_method_id)) {
            OS::get_singleton()->delay_usec(600000);
        }
        LOG_VERBOSE("JVM GC thread was closed")
        jni::MethodId clean_up_method_id{garbage_collector_cls.get_method_id(env, "cleanUp", "()V")};
        garbage_collector_instance.call_void_method(env, clean_up_method_id);
    }

    BridgesManager::get_instance().delete_bridges();

    engine_type_method.clear();
    engine_type_names.clear();

    TypeManager::get_instance().JAVA_ENGINE_TYPES_CONSTRUCTORS.clear();
    class_loader.delete_global_ref(env);
    jni::Jvm::destroy();
    LOG_INFO("Shutting down JVM ...")
}

void GDKotlin::register_classes(jni::Env& p_env, jni::JObjectArray p_classes) {
#ifdef DEBUG_ENABLED
    LOG_INFO("Loading classes ...")
#endif
    for (auto i = 0; i < p_classes.length(p_env); i++) {
        auto kt_class = new KtClass(p_classes.get(p_env, i), class_loader);
        classes[kt_class->name] = kt_class;
#ifdef DEBUG_ENABLED
        LOG_VERBOSE(vformat("Loaded class %s : %s, as %s", kt_class->name, kt_class->super_class,
                              kt_class->registered_class_name))
#endif
    }
}

void GDKotlin::unregister_classes(jni::Env& p_env, jni::JObjectArray p_classes) {
#ifdef DEBUG_ENABLED
    LOG_INFO("Unloading classes ...")
#endif
    Map<StringName, KtClass*>::Element* current = classes.front();
    while (current != nullptr) {
        KtClass* kt_class = current->value();
#ifdef DEBUG_ENABLED
        LOG_VERBOSE(vformat("Unloading class %s : %s", kt_class->name, kt_class->super_class))
#endif
        delete kt_class;
        current = current->next();
    }
    classes.clear();
}

KtClass* GDKotlin::find_class(const String& p_script_path) {
    StringName class_name = p_script_path.trim_prefix(scripts_root).trim_suffix(".kt").replace("/", ".");
    JVM_ERR_FAIL_COND_V_MSG(!classes.has(class_name), nullptr,
                   vformat("Failed to find class %s for path: %s", class_name, p_script_path));
    return classes[class_name];
}

KtClass* GDKotlin::find_class_by_name(const String& class_name) {
    JVM_ERR_FAIL_COND_V_MSG(!classes.has(class_name), nullptr, vformat("Failed to find class for path: %s", class_name))
    return classes[class_name];
}

jni::JObject& GDKotlin::get_class_loader() {
    return class_loader;
}

Error GDKotlin::split_jvm_debug_argument(const String& cmd_arg, String& result) {
    Vector<String> jvm_debug_split{cmd_arg.split("=")};

    if (jvm_debug_split.size() == 2) {
        result = jvm_debug_split[1];
    } else if (jvm_debug_split.size() != 1) {
        print_error(vformat("Unrecognized --jvm-debug arg pattern: %s", cmd_arg));
        return FAILED;
    }
    return OK;
}

GDKotlin::GDKotlin() : bootstrap(nullptr), is_gc_started(false), transfer_context(nullptr) {

}
