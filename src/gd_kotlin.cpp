#include <core/print_string.h>
#include <main/main.h>
#include "gd_kotlin.h"
#include "core/project_settings.h"
#include "bridges_manager.h"
#include "jni/class_loader.h"
#include <core/io/resource_loader.h>

#ifndef TOOLS_ENABLED

#include <core/os/dir_access.h>

#endif

#ifdef __ANDROID__

#include <platform/android/os_android.h>
#include <platform/android/java_godot_wrapper.h>

#endif

GDKotlin& GDKotlin::get_instance() {
    static GDKotlin instance;
    return instance;
}

void load_classes_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    jni::JObjectArray classes{jni::JObjectArray(p_classes)};
    jni::JObject j_object{p_this};

    GDKotlin::get_instance().register_classes(env, classes);

    j_object.delete_local_ref(env);
    classes.delete_local_ref(env);
}

void unload_classes_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_classes) {
    jni::Env env(p_env);
    jni::JObjectArray classes{jni::JObjectArray(p_classes)};
    jni::JObject j_object{p_this};

    GDKotlin::get_instance().unregister_classes(env, classes);

    j_object.delete_local_ref(env);
    classes.delete_local_ref(env);
}

void
register_engine_types_hook(
        JNIEnv* p_env,
        jobject p_this,
        jobjectArray p_engine_types,
        jobjectArray p_singleton_names,
        jobjectArray p_method_names,
        jobjectArray p_types_of_methods) {
#ifdef DEBUG_ENABLED
    LOG_VERBOSE("Starting to register managed engine types...")
#endif
    jni::Env env(p_env);

    jni::JObjectArray engine_types{p_engine_types};
    for (int i = 0; i < engine_types.length(env); ++i) {
        jni::JObject type = engine_types.get(env, i);
        const String& class_name = env.from_jstring(static_cast<jni::JString>(type));
        GDKotlin::get_instance().engine_type_names.insert(i, class_name);
        TypeManager::get_instance().JAVA_ENGINE_TYPES_CONSTRUCTORS[class_name] = i;
#ifdef DEBUG_ENABLED
        LOG_VERBOSE(vformat("Registered %s engine type with index %s.", class_name, i))
#endif
        type.delete_local_ref(env);
    }

    jni::JObjectArray singleton_names{p_singleton_names};
    for (int i = 0; i < singleton_names.length(env); ++i) {
        jni::JObject name = singleton_names.get(env, i);
        const String& singleton_name{env.from_jstring(static_cast<jni::JString>(name))};
        GDKotlin::get_instance().engine_singleton_names.insert(i, singleton_name);
        name.delete_local_ref(env);
    }

    jni::JObjectArray method_names{p_method_names};
    jni::JObjectArray types_of_methods{p_types_of_methods};
    jni::JClass integer_class{env.load_class("java.lang.Integer", ClassLoader::get_default_loader())};
    jni::MethodId integer_get_value_method{integer_class.get_method_id(env, "intValue", "()I")};
    for (int i = 0; i < method_names.length(env); i++) {
        jni::JObject type = types_of_methods.get(env, i);
        jni::JObject name = method_names.get(env, i);
        int type_of_method{static_cast<int>(type.call_int_method(env, integer_get_value_method))};
        GDKotlin::get_instance().engine_type_method.insert(
                i,
                ClassDB::get_method(
                        GDKotlin::get_instance().engine_type_names[type_of_method],
                        env.from_jstring(name)
                )
        );
        name.delete_local_ref(env);
        type.delete_local_ref(env);
    }
    jni::JObject j_object{p_this};
    j_object.delete_local_ref(env);
    engine_types.delete_local_ref(env);
    singleton_names.delete_local_ref(env);
    method_names.delete_local_ref(env);
    types_of_methods.delete_local_ref(env);
    integer_class.delete_local_ref(env);
#ifdef DEBUG_ENABLED
    LOG_VERBOSE("Done registering managed engine types...")
#endif
}

void register_user_types_hook(JNIEnv* p_env, jobject p_this, jobjectArray p_types) {
    print_verbose("Starting to register user types...");
    jni::Env env(p_env);
    jni::JObjectArray types{p_types};
    for (int i = 0; i < types.length(env); ++i) {
        const String& script_path{env.from_jstring(static_cast<jni::JString>(types.get(env, i)))};
        GDKotlin::get_instance().user_scripts.insert(i, ResourceLoader::load(script_path, "KotlinScript"));
#ifdef DEBUG_ENABLED
        LOG_VERBOSE(vformat("Registered %s user type with index %s.", script_path, i));
#endif
    }
    LOG_VERBOSE("Done registering user types.");
}

void register_user_types_members_hook(JNIEnv* p_env, jobject p_this) {
    jni::Env env(p_env);
    GDKotlin::get_instance().register_members(env);
}

void GDKotlin::init() {
    if (Main::is_project_manager()) {
#ifdef DEBUG_ENABLED
        LOG_VERBOSE("Detected that we're in the project manager. Won't initialize kotlin lang.")
#endif
        return;
    }

    jni::InitArgs args;
#ifndef __ANDROID__
    args.version = JNI_VERSION_1_8;
#endif
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
    int jvm_to_engine_max_string_size{LongStringQueue::max_string_size};
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
        } else if (cmd_arg.find("--jvm-to-engine-max-string-size") >= 0) {
            String result;
            if (split_jvm_debug_argument(cmd_arg, result) == OK) {
                jvm_to_engine_max_string_size = result.to_int();
                //https://godot-kotl.in/en/latest/advanced/commandline-args/
                LOG_WARNING(
                        vformat("Warning ! The max string size was changed to %s which modify the size of the buffer, this is not a recommended practice",
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
#ifdef DEBUG_ENABLED
        LOG_VERBOSE(vformat("Started JMX on port: %s", jvm_jmx_port))
#endif
    }

    jni::Jvm::init(args);
    LOG_INFO("Starting JVM ...")
    auto project_settings = ProjectSettings::get_singleton();

#ifdef __ANDROID__
    String bootstrap_jar_file{"godot-bootstrap-dex.jar"};
    String main_jar_file{"main-dex.jar"};
#elif !defined(__GRAAL__)
    String bootstrap_jar_file{"godot-bootstrap.jar"};
    String main_jar_file{"main.jar"};
#endif

#ifndef __GRAAL__
    check_and_copy_jar(bootstrap_jar_file);
    check_and_copy_jar(main_jar_file);

#ifdef TOOLS_ENABLED
    String bootstrap_jar{OS::get_singleton()->get_executable_path().get_base_dir() + "/godot-bootstrap.jar"};
#else
    String bootstrap_jar{ProjectSettings::get_singleton()->globalize_path(vformat("user://%s", bootstrap_jar_file))};
#endif

#ifdef TOOLS_ENABLED
    JVM_CRASH_COND_MSG(!FileAccess::exists(bootstrap_jar),
                   "No godot-bootstrap.jar found! This file needs to stay alongside the godot editor executable!")
#elif DEBUG_ENABLED
    JVM_CRASH_COND_MSG(!FileAccess::exists(bootstrap_jar), "No godot-bootstrap.jar found!")
#endif

    LOG_INFO(vformat("Loading bootstrap jar: %s", bootstrap_jar))
#endif
    jni::Env env{jni::Jvm::current_env()};
#ifndef __GRAAL__

    jni::JObject class_loader {ClassLoader::provide_loader(env, bootstrap_jar, jni::JObject(nullptr))};
    ClassLoader::set_default_loader(class_loader);
    class_loader.delete_local_ref(env);

    class_loader = ClassLoader::get_default_loader();
#else
    jni::JObject class_loader;
#endif

    jni::JClass transfer_ctx_cls = env.load_class("godot.core.TransferContext", class_loader);
    jni::FieldId transfer_ctx_instance_field = transfer_ctx_cls.get_static_field_id(env, "INSTANCE",
                                                                                    "Lgodot/core/TransferContext;");
    jni::JObject transfer_ctx_instance = transfer_ctx_cls.get_static_object_field(env, transfer_ctx_instance_field);
    JVM_CRASH_COND_MSG(transfer_ctx_instance.is_null(), "Failed to retrieve TransferContext instance")
    transfer_context = new TransferContext(transfer_ctx_instance, class_loader);

    LongStringQueue::get_instance();
    if (jvm_to_engine_max_string_size != LongStringQueue::max_string_size) {
        LongStringQueue::get_instance().set_string_max_size(jvm_to_engine_max_string_size);
    }

    //Garbage Collector
    jni::JClass garbage_collector_cls{env.load_class("godot.core.GarbageCollector", class_loader)};
    jni::FieldId garbage_collector_instance_field{
            garbage_collector_cls.get_static_field_id(env, "INSTANCE", "Lgodot/core/GarbageCollector;")
    };
    jni::JObject garbage_collector_instance{
            garbage_collector_cls.get_static_object_field(env, garbage_collector_instance_field)
    };
    JVM_CRASH_COND_MSG(garbage_collector_instance.is_null(), "Failed to retrieve GarbageCollector instance")

    BridgesManager::get_instance().initialize_bridges(env, class_loader);

    if (is_gc_activated) {
        if (is_gc_force_mode) {
#ifdef DEBUG_ENABLED
            LOG_VERBOSE("Starting GC thread with force mode.")
#endif
        }
        jni::MethodId start_method_id{garbage_collector_cls.get_method_id(env, "start", "(Z)V")};
        jvalue start_args[2] = {jni::to_jni_arg(is_gc_force_mode)};
        garbage_collector_instance.call_void_method(env, start_method_id, start_args);
#ifdef DEBUG_ENABLED
        LOG_VERBOSE("GC thread started.")
#endif
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

    bootstrap->register_hooks(env, load_classes_hook, unload_classes_hook, register_engine_types_hook,
                              register_user_types_hook, register_user_types_members_hook);
    bool is_editor = Engine::get_singleton()->is_editor_hint();

#ifdef TOOLS_ENABLED
    String jar_path{project_settings->globalize_path("res://build/libs/")};
#else
    String jar_path{project_settings->globalize_path("user://")};
#endif

    String project_path{project_settings->globalize_path("res://")};

#ifdef __ANDROID__
    String main_jar{ProjectSettings::get_singleton()->globalize_path(vformat("user://%s", main_jar_file))};
#endif

    bootstrap->init(
            env,
            is_editor,
            project_path,
            jar_path,
#ifndef __GRAAL__
            main_jar_file,
#else
            "graal_usercode",
#endif
#ifdef __ANDROID__
            ClassLoader::provide_loader(env, main_jar, class_loader)
#else
            jni::JObject()
#endif
    );
}

void GDKotlin::finish() {
    if (Main::is_project_manager()) {
#ifdef DEBUG_ENABLED
        LOG_VERBOSE("Detected that we're in the project manager. No cleanup necessary")
#endif
        return;
    }
    auto env = jni::Jvm::current_env();

    delete transfer_context;
    transfer_context = nullptr;
    bootstrap->finish(env);
    delete bootstrap;
    bootstrap = nullptr;

    if (is_gc_started) {
        jni::JClass garbage_collector_cls{env.load_class("godot.core.GarbageCollector",
                                                         ClassLoader::get_default_loader())};
        jni::FieldId garbage_collector_instance_field{
                garbage_collector_cls.get_static_field_id(env, "INSTANCE", "Lgodot/core/GarbageCollector;")
        };
        jni::JObject garbage_collector_instance{
                garbage_collector_cls.get_static_object_field(env, garbage_collector_instance_field)
        };
        JVM_CRASH_COND_MSG(garbage_collector_instance.is_null(), "Failed to retrieve GarbageCollector instance")
        jni::MethodId close_method_id{garbage_collector_cls.get_method_id(env, "close", "()V")};
        garbage_collector_instance.call_void_method(env, close_method_id);
        jni::MethodId has_closed_method_id{garbage_collector_cls.get_method_id(env, "isClosed", "()Z")};
        while (!garbage_collector_instance.call_boolean_method(env, has_closed_method_id)) {
            OS::get_singleton()->delay_usec(600000);
        }
#ifdef DEBUG_ENABLED
        LOG_VERBOSE("JVM GC thread was closed")
#endif
        jni::MethodId clean_up_method_id{garbage_collector_cls.get_method_id(env, "cleanUp", "()V")};
        garbage_collector_instance.call_void_method(env, clean_up_method_id);
    }

    LongStringQueue::destroy();
    BridgesManager::get_instance().delete_bridges();

    engine_type_method.clear();
    engine_type_names.clear();
    user_scripts.clear();

    TypeManager::get_instance().JAVA_ENGINE_TYPES_CONSTRUCTORS.clear();
    ClassLoader::delete_default_loader(env);
    jni::Jvm::destroy();
    LOG_INFO("Shutting down JVM ...")
}

void GDKotlin::register_classes(jni::Env& p_env, jni::JObjectArray p_classes) {
#ifdef DEBUG_ENABLED
    LOG_INFO("Loading classes ...")
#endif
    jni::JObject class_loader = ClassLoader::get_default_loader();
    for (auto i = 0; i < p_classes.length(p_env); i++) {
        jni::JObject clazz = p_classes.get(p_env, i);
        auto* kt_class = new KtClass(clazz, class_loader);
        classes[kt_class->name] = kt_class;
#ifdef DEBUG_ENABLED
        LOG_VERBOSE(vformat("Loaded class %s : %s, as %s", kt_class->name, kt_class->super_class,
                            kt_class->registered_class_name))
#endif
        clazz.delete_local_ref(p_env);
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

KtClass* GDKotlin::find_class(const StringName& p_script_path) {
#ifdef DEBUG_ENABLED
    if (!classes.has(p_script_path)) {
        return nullptr;
    }
#endif
    return classes[p_script_path];
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

void GDKotlin::check_and_copy_jar(const String& jar_name) {
#ifndef TOOLS_ENABLED
    String libs_res_path{"res://build/libs"};
    String jar_user_path{vformat("user://%s", jar_name)};
    String jar_res_path{vformat("%s/%s", libs_res_path, jar_name)};

    if (!FileAccess::exists(jar_user_path)
        || FileAccess::get_md5(jar_user_path) != FileAccess::get_md5(jar_res_path)) {
#ifdef DEBUG_ENABLED
        LOG_INFO(vformat("%s jar has changed, will copy it from res...", jar_name));
#endif

        Error err;
        DirAccess* dir_access{
                DirAccess::open(libs_res_path, &err)
        };

#ifdef DEBUG_ENABLED
        JVM_CRASH_COND_MSG(err != OK, vformat("Cannot open %s jar in res.", jar_name))
#endif

        dir_access->copy(jar_res_path, jar_user_path);
        memdelete(dir_access);
    }
#endif
}

GDKotlin::GDKotlin() :
        bootstrap(nullptr),
        is_gc_started(false),
        transfer_context(nullptr) {
}

void GDKotlin::register_members(jni::Env& p_env) {
    auto* map_entry{classes.front()};
    while (map_entry) {
        map_entry->get()->fetch_members();
        map_entry = map_entry->next();
    }
}
