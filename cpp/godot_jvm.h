#ifndef GODOT_JVM_GODOT_JVM_H
#define GODOT_JVM_GODOT_JVM_H

#include "api/resource_format/java_archive.h"
#include "engine/godot_object.h"
#include "jvm/lifecycle/class_loader.h"
#include "jvm/lifecycle/jvm_manager.h"
#include "jvm/lifecycle/jvm_options.h"
#include "jvm/lifecycle/jvm_user_configuration.h"
#include "jvm/wrapper/bootstrap.h"

#include <variant/string.hpp>

namespace godot {

    class GodotJvm {
        friend class GdjLanguage;
#ifdef TOOLS_ENABLED
        friend class GodotJvmEditor;
#endif

    public:
        // Values should be in the correct initialization order, the number matters.
        enum State {
            NOT_STARTED = 0, // Default state;
            JVM_LIBRARY_LOADED = 1, // Only for Dynamic loading
            JVM_STARTED = 2, // Or retrieved in the case of Android
            BOOTSTRAP_LOADED = 3,
            CORE_LIBRARY_INITIALIZED = 4,
            ENGINE_TYPES_INITIALIZED = 5,
            JVM_SCRIPTS_INITIALIZED = 6,
        };

    private:
        State state = State::NOT_STARTED;

        JvmUserConfiguration user_configuration;
        JvmOptions jvm_options;

        ClassLoader* bootstrap_class_loader = nullptr;
        Bootstrap* bootstrap = nullptr;
        godot::Ref<JavaArchive> jar; // We keep a Reference to the jar in memory because the Godot editor require a resource to be in cache to reload.
        raw_godot::RawObject callable_middleman; // TODO: delete when https://github.com/godotengine/godot/issues/95231 is resolved

        void fetch_user_configuration();
        void set_jvm_options();

#ifndef TOOLS_ENABLED
        static String copy_new_file_to_user_dir(const String& file_name);
#endif

#ifdef DYNAMIC_JVM
        void* jvm_dynamic_library_handle = nullptr;
        bool load_dynamic_lib();
        void unload_dynamic_lib();
#ifdef TOOLS_ENABLED
        static godot::String get_path_to_environment_jvm();
        static godot::String get_path_to_java_executable();
#endif
        static String get_path_to_embedded_jvm();
        static String get_path_to_native_image();
#endif

        bool load_bootstrap();
        void unload_boostrap();

        bool initialize_core_library();
        void finalize_core_library();

        bool initialize_engine_types() const;
        bool load_user_code();
        void unload_user_code();

    public:
        GodotJvm() = default;
        ~GodotJvm() = default;
        GodotJvm(const GodotJvm&) = delete;
        GodotJvm& operator=(const GodotJvm&) = delete;

        static GodotJvm& get_instance();
        const JvmUserConfiguration& get_configuration();

        void initialize_up_to(State target_state);
        void finalize_down_to(State target_state);;
        void validate_state();

#ifdef TOOLS_ENABLED
        void reload_user_code();
#endif

        // TODO: delete when https://github.com/godotengine/godot/issues/95231 is resolved
        raw_godot::RawObject get_callable_middleman() const;
    };
} // namespace godot
#endif // GODOT_JVM_GODOT_JVM_H
