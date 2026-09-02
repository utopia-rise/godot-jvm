#include "api/script/jvm_script_manager.h"
#include "godot_jvm.h"
#include "jvm/jni/env.h"
#include "engine/dynamic_library.h"
#include "jvm/lifecycle/jvm_manager.h"
#include "jvm/wrapper/memory/long_string_queue.h"
#include "jvm/wrapper/memory/memory_manager.h"
#include "jvm/wrapper/memory/type_manager.h"
#include "paths.h"
#include "version.h"

#include <classes/engine.hpp>
#include <classes/dir_access.hpp>
#include <classes/file_access.hpp>
#include <classes/project_settings.hpp>
#include <classes/resource_loader.hpp>

using namespace godot;

GodotJvm& GodotJvm::get_instance() {
    static GodotJvm instance;
    return instance;
}

const JvmUserConfiguration& GodotJvm::get_configuration() {
    return user_configuration;
}

#ifdef DYNAMIC_JVM
bool GodotJvm::load_dynamic_lib() {
    String path_to_jvm_lib;
    switch (user_configuration.vm_type) {
        case jni::JvmType::JVM:
            if (String embedded_jvm = get_path_to_embedded_jvm(); FileAccess::file_exists(embedded_jvm)) {
                path_to_jvm_lib = embedded_jvm;
            }
#ifdef TOOLS_ENABLED
            else {
                String dynamic_jvm = get_path_to_java_executable();
                if (dynamic_jvm.is_empty()) {
                    dynamic_jvm = get_path_to_environment_jvm();
                }

                if (!dynamic_jvm.is_empty()) {
                    JVM_LOG_WARNING(
                      "Godot-JVM: You really should embed a JRE in your project with jlink! See the "
                      "documentation if you don't know how to do that"
                    );
                    path_to_jvm_lib = dynamic_jvm;
                } else {
#ifdef MACOS_ENABLED
                    JVM_WARN_FAIL_V_MSG(
                      false,
                      "Godot Kotlin/JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
                      "No embedded JRE or usable Java installation was found.",
                      "Make sure a JDK 17+ is available through JAVA_HOME or PATH, or add an embedded JRE to your "
                      "project using jlink."
                    );
#else
                    JVM_WARN_FAIL_V_MSG(
                      false,
                      "Godot Kotlin/JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
                      "No embedded JRE or usable Java installation was found.",
                      "Make sure a JDK 17+ is available through JAVA_HOME or PATH, or add an embedded JRE to your "
                      "project using jlink."
                    );
#endif
                }
            }
#else
            else {
                JVM_ERR_FAIL_V_MSG(false, "No embedded JRE found at: %s!", get_path_to_embedded_jvm());
            }
#endif

            break;
        case jni::JvmType::GRAAL_NATIVE_IMAGE:
            if (String native_jvm = get_path_to_native_image(); FileAccess::file_exists(native_jvm)) {
                path_to_jvm_lib = native_jvm;
            } else {
                JVM_WARN_FAIL_V_MSG(
                  false,
                  "Godot-JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
                  "Couldn't open Graal Native Image.",
                  "Make sure you have built your JVM project with Graal native image enabled in your gradle build."
                );
            }
            break;
        default:
            // Sanity check. Should never happen
            JVM_DEV_ASSERT(false, "Tried to load a VM that's neither the JVM nor Graal Native Image");
    }

    if (godot_jvm_native::open_dynamic_library(path_to_jvm_lib, jvm_dynamic_library_handle) != OK) {
        JVM_WARN_FAIL_V_MSG(
          false,
          "Godot-JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
          "Failed to load the jvm dynamic library from path: " + path_to_jvm_lib,
          "Make sure you use a valid JVM 17+ with proper read access."
        );
    }
    return true;
}

#ifdef TOOLS_ENABLED
String GodotJvm::get_path_to_embedded_jvm() {
    String godot_path {String(HOST_EMBEDDED_JRE_DIRECTORY).path_join(RELATIVE_JVM_LIB_PATH)};
    return ProjectSettings::get_singleton()->globalize_path(godot_path);
}

String GodotJvm::get_path_to_native_image() {
    return ProjectSettings::get_singleton()->globalize_path(GRAAL_NATIVE_IMAGE_FILE);
}

String GodotJvm::get_path_to_environment_jvm() {
    String javaHome {OS::get_singleton()->get_environment("JAVA_HOME")};
    if (javaHome.is_empty()) { return {}; }

    String jvm_library = javaHome.path_join(RELATIVE_JVM_LIB_PATH);
    return FileAccess::file_exists(jvm_library) ? jvm_library : String {};
}

String GodotJvm::get_path_to_java_executable() {
#ifdef MACOS_ENABLED
    PackedStringArray arguments;
    arguments.push_back("-v");
    arguments.push_back("17+");
    Array output;
    if (OS::get_singleton()->execute("/usr/libexec/java_home", arguments, output, true) == 0 && !output.is_empty()) {
        String macos_java_home = output[0];
        String jvm_library = macos_java_home.strip_edges().path_join(RELATIVE_JVM_LIB_PATH);
        if (FileAccess::file_exists(jvm_library)) { return jvm_library; }
    }
#endif

#ifdef WINDOWS_ENABLED
    constexpr const char* java_executable_name {"java.exe"};
    constexpr const char* path_separator {";"};
#else
    constexpr const char* java_executable_name {"java"};
    constexpr const char* path_separator {":"};
#endif

    PackedStringArray path_entries = String(OS::get_singleton()->get_environment("PATH")).split(path_separator, false);
    for (const String& path_entry : path_entries) {
        String java_executable = path_entry.strip_edges().trim_prefix("\"").trim_suffix("\"").path_join(java_executable_name);
        if (!FileAccess::file_exists(java_executable)) { continue; }

        Ref<DirAccess> dir_access = DirAccess::open(java_executable.get_base_dir());
        if (dir_access.is_null()) { continue; }
        while (dir_access->is_link(java_executable)) {
            String link_target = dir_access->read_link(java_executable);
            java_executable = link_target.is_absolute_path()
                              ? link_target
                              : java_executable.get_base_dir().path_join(link_target).simplify_path();
        }

        String jvm_library = java_executable.get_base_dir().get_base_dir().path_join(RELATIVE_JVM_LIB_PATH);
        if (FileAccess::file_exists(jvm_library)) { return jvm_library; }
    }

    return {};
}
#else

String GodotJvm::get_path_to_embedded_jvm() {
    return OS::get_singleton()
      ->get_executable_path()
      .get_base_dir()
#if defined(MACOS_ENABLED)
      .path_join("../PlugIns/")
      .path_join(String(HOST_EMBEDDED_JRE_DIRECTORY).get_file()) // Only use the last subdir, as the export doesn't keep the relative path
#else
      .path_join(HOST_EMBEDDED_JRE_DIRECTORY)
#endif
      .path_join(RELATIVE_JVM_LIB_PATH);
}

String GodotJvm::get_path_to_native_image() {
    return ProjectSettings::get_singleton()->globalize_path(copy_new_file_to_user_dir(GRAAL_NATIVE_IMAGE_FILE));
}
#endif

void GodotJvm::unload_dynamic_lib() {
    if (godot_jvm_native::close_dynamic_library(jvm_dynamic_library_handle) != OK) {
        JVM_ERR_FAIL_MSG("Failed to close the jvm dynamic library!");
    }
}
#endif

void GodotJvm::fetch_user_configuration() {
    bool invalid_file_content = false;
    bool configuration_file_exist = FileAccess::file_exists(JVM_CONFIGURATION_PATH);

    if (configuration_file_exist) {
        Ref<FileAccess> file_access = FileAccess::open(JVM_CONFIGURATION_PATH, FileAccess::READ);
        String content = file_access->get_as_text();

        // The function is going to mutate the provided configuration with the valid values found in the file.
        // If some of the values parsed in the file are invalid, it will return true;
        JVM_LOG_VERBOSE("Parsing JSON configuration file...");
        invalid_file_content = JvmUserConfiguration::parse_configuration_json(content, user_configuration);
        if (invalid_file_content) {
            JVM_LOG_WARNING("Configuration file is malformed. One or several settings might not be applied.");
        }
    } else {
        // No need for a warning, it's most likely the first time the project is run.
        JVM_LOG_INFO("No JVM user_configuration file found. Default settings for your platform will be used.");
    }

#ifdef TOOLS_ENABLED
    // If configuration is missing or malformed, then we write a new one.
    // Valid values from the json file should be in the instance already, so they won't be lost when writing to disk.
    if (invalid_file_content || !configuration_file_exist) {
        Ref<FileAccess> file_access = FileAccess::open(JVM_CONFIGURATION_PATH, FileAccess::WRITE);
        String json = JvmUserConfiguration::export_configuration_to_json(user_configuration);
        JVM_LOG_INFO("Writing a new configuration file to disk at %s", JVM_CONFIGURATION_PATH);
        file_access->store_string(json);
    }
#endif

    HashMap<String, Variant> cmd_argument_map;
    JVM_LOG_VERBOSE("Parsing commandline arguments...");
    JvmUserConfiguration::parse_command_line(OS::get_singleton()->get_cmdline_args(), cmd_argument_map);
    JVM_LOG_VERBOSE("Creating final JVM Configuration...");
    JvmUserConfiguration::merge_with_command_line(user_configuration, cmd_argument_map);
    JvmUserConfiguration::sanitize_and_log_configuration(user_configuration);
}

void GodotJvm::set_jvm_options() {
#ifdef DEV_ENABLED
    jvm_options.add_jni_checks();
#endif

#ifdef DEBUG_ENABLED
    if (user_configuration.use_debug) {
        jvm_options.add_debug_options(
          user_configuration.jvm_debug_port,
          user_configuration.jvm_debug_address,
          user_configuration.wait_for_debugger
        );
    }
#endif

    if (user_configuration.jvm_jmx_port >= 0) { jvm_options.add_jmx_option(user_configuration.jvm_jmx_port); }

    if (!Engine::get_singleton()->is_editor_hint() && !user_configuration.jvm_args.is_empty()) {
        JVM_LOG_WARNING(
          "You are using custom arguments for the JVM. Make sure they are valid or you risk the JVM to "
          "not launch properly"
        );
        for (String jvm_arg : user_configuration.jvm_args) {
            jvm_options.add_custom_options(jvm_arg);
        }
    }
}

#ifndef TOOLS_ENABLED

#include <classes/dir_access.hpp>

#ifdef ANDROID_ENABLED
#include <unistd.h>
#endif

String GodotJvm::copy_new_file_to_user_dir(const String& file_name) {
    String file_res_path {String(RES_DIRECTORY) + file_name};
    String file_user_path {String(USER_DIRECTORY) + file_name};

#ifndef ANDROID_ENABLED
    if (!FileAccess::file_exists(file_user_path) || FileAccess::get_md5(file_user_path) != FileAccess::get_md5(file_res_path)) {
        JVM_LOG_VERBOSE("%s file has changed. Copying it from %s to %s.", file_name, file_res_path, file_user_path);
#else
    // as per suggestion of https://developer.android.com/about/versions/14/behavior-changes-14#safer-dynamic-code-loading, we first delete existing files and then copy them again
    // if we don't do this, subsequent app starts where the files already exist, error out

    String file_user_path_global {ProjectSettings::get_singleton()->globalize_path(file_user_path)};
    unlink(file_user_path_global.utf8().get_data()); // we do not really care about errors here
#endif
        Ref<DirAccess> dir_access {DirAccess::open(USER_DIRECTORY)};
        dir_access->make_dir(JVM_DIRECTORY);
        dir_access->copy(file_res_path, file_user_path);
#ifndef ANDROID_ENABLED
    }
#endif

    return file_user_path;
}

void GodotJvm::copy_external_jars_to_user_dir() {
    String source_directory {String(RES_DIRECTORY) + EXTERNAL_JARS_DIRECTORY};
    Ref<DirAccess> source {DirAccess::open(source_directory)};
    if (source.is_null()) { return; }

    Ref<DirAccess> destination {DirAccess::open(USER_DIRECTORY)};
    destination->make_dir_recursive(EXTERNAL_JARS_DIRECTORY);

    if (source->list_dir_begin() != OK) { return; }
    for (String entry = source->get_next(); !entry.is_empty(); entry = source->get_next()) {
        if (source->current_is_dir() || entry.get_extension() != "jar") { continue; }

        String source_file {source_directory.path_join(entry)};
        String destination_file {String(EXTERNAL_JARS_DIRECTORY).path_join(entry)};
        if (!FileAccess::file_exists(String(USER_DIRECTORY) + destination_file) ||
            FileAccess::get_md5(String(USER_DIRECTORY) + destination_file) != FileAccess::get_md5(source_file)) {
            destination->copy(source_file, destination_file);
        }
    }
    source->list_dir_end();
}

#endif

bool GodotJvm::load_bootstrap() {
    jni::Env env {jni::Jvm::current_env()};
    if (user_configuration.vm_type != jni::JvmType::GRAAL_NATIVE_IMAGE) { // Bootstrap already part of the image
#ifdef TOOLS_ENABLED
        String bootstrap_jar {ProjectSettings::get_singleton()->globalize_path(String(RES_DIRECTORY).path_join(BOOTSTRAP_FILE))};
        constexpr const char* hint_text {"Make sure to build your gradle project before running the game."};
#else
        String bootstrap_jar {ProjectSettings::get_singleton()->globalize_path(copy_new_file_to_user_dir(BOOTSTRAP_FILE))};
        constexpr const char* hint_text {"The export of the project might be invalid."};
#endif

        if (!FileAccess::file_exists(bootstrap_jar)) {
            if (Engine::get_singleton()->is_editor_hint()) {
                // Most likely when starting a new project, there is no need to log it as an error or warning as long as the users doesn't run the game.
                // We already have node warning if they try to attach a JVM script without building.
                return false;
            }
            JVM_WARN_FAIL_V_MSG(
              false,
              "Godot-JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
              "No godot-bootstrap.jar found!",
              hint_text
            );
        }

        JVM_LOG_VERBOSE("Loading bootstrap jar: %s", bootstrap_jar);
        bootstrap_class_loader = ClassLoader::create_instance(env, bootstrap_jar, jni::JObject(nullptr));

        // set context classloader to bootstrap initially
        bootstrap_class_loader->set_as_context_loader(env);
    }

    if (Bootstrap::initialize(env, bootstrap_class_loader)) {
        bootstrap = Bootstrap::create_instance(env, bootstrap_class_loader);
        String version = bootstrap->get_version(env);
        if (version != String(GODOT_JVM_VERSION)) {
            JVM_ERR_FAIL_V_MSG(
              false,
              "Godot-JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
              vformat("Version mismatch! C++ module is : %s / Jar is : %s.", GODOT_JVM_VERSION, version),
              "Check if your build.gradle file use the same version as the editor."
            );
        }
    } else {
        JVM_WARN_FAIL_V_MSG(
          false,
          "Godot-JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
          "The boostrap.jar is invalid and can't be loaded.",
          "Check if your build.gradle file use the same version as the editor."
        );
    }

    return true;
}

bool GodotJvm::initialize_core_library() {
    callable_middleman = memnew(Object);
    jni::Env env {jni::Jvm::current_env()};

    if (!JvmManager::initialize_jvm_wrappers(env, bootstrap_class_loader)) {
        JVM_WARN_FAIL_V_MSG(
          false,
          "Godot-JVM module couldn't be fully initialized. Cause: %s. Possible solution: %s",
          "The boostrap.jar is invalid and can't be loaded.",
          "Check if your build.gradle file use the same version as the editor."
        );
    }

    if (user_configuration.max_string_size != -1) {
        LongStringQueue::get_instance().set_string_max_size(env, user_configuration.max_string_size);
    }

    return true;
}

bool GodotJvm::load_user_code() {
    jni::Env env {jni::Jvm::current_env()};
    if (user_configuration.vm_type == jni::JvmType::GRAAL_NATIVE_IMAGE) {
        bootstrap->init_native_image(env);
        return true;
    } else {
#ifdef TOOLS_ENABLED
        String user_code_path {String(RES_DIRECTORY).path_join(USER_CODE_FILE)};
#else
        String user_code_path {copy_new_file_to_user_dir(USER_CODE_FILE)};
        copy_external_jars_to_user_dir();
#endif

        if (!FileAccess::file_exists(user_code_path)) {
            String message {"No main.jar detected at %s. No classes will be loaded. Build the gradle "
                            "project to load classes"};
#ifdef TOOLS_ENABLED
            JVM_LOG_WARNING(message, user_code_path);
            return false;
#elif defined DEBUG_ENABLED
            JVM_ERR_FAIL_V_MSG(false, message, user_code_path);
#endif
        }

        JVM_LOG_VERBOSE("Loading usercode file at: %s", user_code_path);
#ifdef TOOLS_ENABLED
        jar.instantiate();
        jar->take_over_path(user_code_path);
#endif

        ClassLoader* user_class_loader = ClassLoader::create_instance(
          env,
          ProjectSettings::get_singleton()->globalize_path(user_code_path),
          bootstrap_class_loader->get_wrapped()
        );

        // update context classloader to use usercode jar
        user_class_loader->set_as_context_loader(env);

        bootstrap->init_jar(env, user_class_loader->get_wrapped());
        delete user_class_loader;
        return FileAccess::file_exists(user_code_path);
    }
}

void GodotJvm::unload_user_code() {
    jni::Env env {jni::Jvm::current_env()};

    // Graal native images include bootstrap directly, so no bootstrap classloader is created.
    if (bootstrap_class_loader != nullptr) {
        bootstrap_class_loader->set_as_context_loader(env);
    }

    bootstrap->finish(env);
    jar.unref();
}

void GodotJvm::finalize_core_library() {
    jni::Env env {jni::Jvm::current_env()};

    MemoryManager::get_instance().clean_up(env);

    JvmScriptManager::finalize();
    JvmManager::finalize_jvm_wrappers(env, bootstrap_class_loader);

    memdelete(callable_middleman);
    callable_middleman = nullptr;
}

bool GodotJvm::initialize_engine_types() const {
    jni::Env env = jni::Jvm::current_env();
    bootstrap->initialize_engine_types(env);
    return true;
}

void GodotJvm::unload_boostrap() {
    jni::Env env {jni::Jvm::current_env()};
    Bootstrap::finalize(env, bootstrap_class_loader);
    delete bootstrap;
    bootstrap = nullptr;
    delete bootstrap_class_loader;
    bootstrap_class_loader = nullptr;
}

#define SET_LOADING_STATE(cond, new_state, target_state) \
    if (state < State::new_state) {                      \
        if (!cond) { return; }                           \
        state = State::new_state;                        \
        if (new_state == target_state) { return; }       \
    }

void GodotJvm::initialize_up_to(State target_state) {
    if (state == State::NOT_STARTED) {
        fetch_user_configuration();
        set_jvm_options();
    }

#ifdef DYNAMIC_JVM
    SET_LOADING_STATE(load_dynamic_lib(), JVM_LIBRARY_LOADED, target_state)
    SET_LOADING_STATE(JvmManager::initialize_or_get_jvm(jvm_dynamic_library_handle, user_configuration, jvm_options), JVM_STARTED, target_state)
#else
    SET_LOADING_STATE(JvmManager::initialize_or_get_jvm(nullptr, user_configuration, jvm_options), JVM_STARTED, target_state)
#endif
    SET_LOADING_STATE(load_bootstrap(), BOOTSTRAP_LOADED, target_state)
    SET_LOADING_STATE(initialize_core_library(), CORE_LIBRARY_INITIALIZED, target_state)
    SET_LOADING_STATE(initialize_engine_types(), ENGINE_TYPES_INITIALIZED, target_state)
    SET_LOADING_STATE(load_user_code(), JVM_SCRIPTS_INITIALIZED, target_state)
}

#define UNSET_LOADING_STATE(function, new_state, target_state) \
    if (state > State::new_state) {                            \
        function;                                              \
        state = State::new_state;                              \
        if (new_state == target_state) { return; }             \
    }

void GodotJvm::finalize_down_to(State target_state) {
    UNSET_LOADING_STATE(unload_user_code(), ENGINE_TYPES_INITIALIZED, target_state)
    UNSET_LOADING_STATE(TypeManager::get_instance().clear(), CORE_LIBRARY_INITIALIZED, target_state)
    UNSET_LOADING_STATE(finalize_core_library(), BOOTSTRAP_LOADED, target_state)
    UNSET_LOADING_STATE(unload_boostrap(), JVM_STARTED, target_state)
#ifdef DYNAMIC_JVM
    if (state > State::JVM_LIBRARY_LOADED) {
        if (!JvmManager::close_jvm()) { return; }
        state = State::JVM_LIBRARY_LOADED;
        if (State::JVM_LIBRARY_LOADED == target_state) { return; }
    }
    UNSET_LOADING_STATE(unload_dynamic_lib(), NOT_STARTED, target_state)
#else
    if (state > State::NOT_STARTED) {
        if (!JvmManager::close_jvm()) { return; }
        state = State::NOT_STARTED;
    }
#endif
}

#ifdef TOOLS_ENABLED
void GodotJvm::reload_user_code() {
    if (user_configuration.vm_type == jni::JvmType::JVM) {
        finalize_down_to(ENGINE_TYPES_INITIALIZED);
        initialize_up_to(JVM_SCRIPTS_INITIALIZED);
    }
}
#endif

Object* GodotJvm::get_callable_middleman() const {
    return callable_middleman;
}

void GodotJvm::validate_state() {
    // Don't invalidate the state because everything is either loaded or the Kotlin project has simply not be built.
    if (state >= State::JVM_STARTED) { return; }

    finalize_down_to(NOT_STARTED);
    JVM_LOG_WARNING("JVM not properly started, you won't be able to use Java or Kotlin scripts.");
}
