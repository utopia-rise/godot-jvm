#ifdef TOOLS_ENABLED

#include "godot_jvm_editor_export_plugin.h"

#include "api/language/names.h"
#include "api/script/source_script_parser.h"
#include "jvm/lifecycle/jvm_user_configuration.h"
#include "logging.h"
#include "paths.h"

#include <classes/dir_access.hpp>
#include <classes/file_access.hpp>
#include <classes/json.hpp>
#include <classes/project_settings.hpp>

using namespace godot;

static constexpr const char* runtime_option = "godot_jvm/runtime/type";
static constexpr const char* debug_options_prefix = "godot_jvm/debug/";
static constexpr const char* debug_override_option = "godot_jvm/debug/override";
static constexpr const char* enable_debugger_option = "godot_jvm/debug/enable_debugger";
static constexpr const char* debug_port_option = "godot_jvm/debug/debug_port";
static constexpr const char* debug_address_option = "godot_jvm/debug/debug_address";
static constexpr const char* wait_for_debugger_option = "godot_jvm/debug/wait_for_debugger_attachment";
static constexpr const char* jmx_port_option = "godot_jvm/debug/jmx_port";
static constexpr const char* memory_options_prefix = "godot_jvm/memory/";
static constexpr const char* memory_override_option = "godot_jvm/memory/override";
static constexpr const char* max_string_size_option = "godot_jvm/memory/max_string_size";
static constexpr const char* disable_gc_option = "godot_jvm/memory/disable_gc";
static constexpr const char* custom_arguments_option = "godot_jvm/custom_arguments/override_custom_args";

enum Runtime {
    RUNTIME_NONE,
    RUNTIME_JVM,
    RUNTIME_GRAAL,
};

// Override categories, each toggled by the checkbox on its section header. Debug options only reach desktop JVM games.
enum Category {
    CATEGORY_DEBUG,
    CATEGORY_MEMORY,
};

static constexpr const char* override_options[] = {debug_override_option, memory_override_option};

struct ConfigurationOption {
    Category category;
    const char* key; // Field in godot_jvm_configuration.json.
    const char* option; // Preset option name.
    const char* range; // Range hint for integer fields.
};

static constexpr ConfigurationOption configuration_options[] = {
    {CATEGORY_DEBUG, USE_DEBUG_JSON_IDENTIFIER, enable_debugger_option, nullptr},
    {CATEGORY_DEBUG, DEBUG_PORT_JSON_IDENTIFIER, debug_port_option, "0,65535,1"},
    {CATEGORY_DEBUG, DEBUG_ADDRESS_JSON_IDENTIFIER, debug_address_option, nullptr},
    {CATEGORY_DEBUG, WAIT_FOR_DEBUGGER_JSON_IDENTIFIER, wait_for_debugger_option, nullptr},
    {CATEGORY_DEBUG, JMX_PORT_JSON_IDENTIFIER, jmx_port_option, "-1,65535,1"},
    {CATEGORY_MEMORY, MAX_STRING_SIZE_JSON_IDENTIFIER, max_string_size_option, "-1,65535,1"},
    {CATEGORY_MEMORY, DISABLE_GC_JSON_IDENTIFIER, disable_gc_option, nullptr},
};

static Dictionary export_option(
    const char* p_name,
    Variant::Type p_type,
    const Variant& p_default,
    PropertyHint p_hint,
    const char* p_hint_string,
    bool p_update_visibility
) {
    Dictionary property_info;
    property_info["name"] = p_name;
    property_info["type"] = p_type;
    property_info["hint"] = p_hint;
    property_info["hint_string"] = p_hint_string;
    Dictionary option;
    option["option"] = property_info;
    option["default_value"] = p_default;
    option["update_visibility"] = p_update_visibility;
    return option;
}

// Walk the tree with DirAccess's exposed list_dir_begin/get_next/copy/make_dir_recursive API.
static Error copy_directory_recursive(const String& from, const String& to) {
    Ref<DirAccess> dir_access = DirAccess::open(from);
    if (dir_access.is_null()) { return DirAccess::get_open_error(); }

    Error error = dir_access->make_dir_recursive(to);
    if (error != OK) { return error; }

    error = dir_access->list_dir_begin();
    if (error != OK) { return error; }

    for (String entry = dir_access->get_next(); !entry.is_empty(); entry = dir_access->get_next()) {
        if (entry == "." || entry == "..") { continue; }
        String from_entry = from.path_join(entry);
        String to_entry = to.path_join(entry);
        error = dir_access->current_is_dir() ? copy_directory_recursive(from_entry, to_entry)
                                             : dir_access->copy(from_entry, to_entry);
        if (error != OK) { break; }
    }
    dir_access->list_dir_end();
    return error;
}

// Where the desktop runtimes live in the project, per Godot OS name. Null for non-desktop platforms.
struct DesktopRuntimeFiles {
    const char* arm64_jre_directory;
    const char* x86_64_jre_directory;
    const char* native_image_file;
};

static const DesktopRuntimeFiles* desktop_runtime_files(const String& p_os_name) {
    static constexpr DesktopRuntimeFiles windows = {
        WINDOWS_EMBEDDED_JRE_ARM_DIRECTORY,
        WINDOWS_EMBEDDED_JRE_AMD_DIRECTORY,
        WINDOWS_GRAAL_NATIVE_IMAGE_FILE
    };
    static constexpr DesktopRuntimeFiles linux = {
        LINUX_EMBEDDED_JRE_ARM_DIRECTORY,
        LINUX_EMBEDDED_JRE_AMD_DIRECTORY,
        LINUX_GRAAL_NATIVE_IMAGE_FILE
    };
    static constexpr DesktopRuntimeFiles macos = {
        MACOS_EMBEDDED_JRE_ARM_DIRECTORY,
        MACOS_EMBEDDED_JRE_AMD_DIRECTORY,
        MACOS_GRAAL_NATIVE_IMAGE_FILE
    };
    if (p_os_name == "Windows") { return &windows; }
    if (p_os_name == "Linux") { return &linux; }
    if (p_os_name == "macOS") { return &macos; }
    return nullptr;
}

// res:// paths of the embedded JREs an export needs, one per exported architecture.
static PackedStringArray embedded_jre_directories(const DesktopRuntimeFiles& p_files, bool p_arm64, bool p_x86_64) {
    PackedStringArray directories;
    if (p_arm64) { directories.push_back(String(RES_DIRECTORY) + p_files.arm64_jre_directory); }
    if (p_x86_64) { directories.push_back(String(RES_DIRECTORY) + p_files.x86_64_jre_directory); }
    return directories;
}

// res:// paths of the jars every desktop JVM export bundles.
static PackedStringArray desktop_jars() {
    return {String(RES_DIRECTORY) + DESKTOP_BOOTSTRAP_FILE, String(RES_DIRECTORY) + DESKTOP_USER_CODE_FILE};
}

bool GodotJvmEditorExportPlugin::_supports_platform(const Ref<EditorExportPlatform>& p_platform) const {
    // Godot only asks supporting plugins for export options, warnings and Android libraries.
    return p_platform.is_valid()
        && (p_platform->get_os_name() == "Android"
            || p_platform->get_os_name() == "iOS"
            || desktop_runtime_files(p_platform->get_os_name()) != nullptr);
}

PackedStringArray GodotJvmEditorExportPlugin::_get_android_libraries(
    const Ref<EditorExportPlatform>&,
    bool p_debug
) const {
    return {p_debug ? "jvm/libs/android/debug/godot-jvm-debug.aar" : "jvm/libs/android/release/godot-jvm-release.aar"};
}

TypedArray<Dictionary> GodotJvmEditorExportPlugin::_get_export_options(
    const Ref<EditorExportPlatform>& p_platform
) const {
    TypedArray<Dictionary> options;
    bool desktop = desktop_runtime_files(p_platform->get_os_name()) != nullptr;
    if (desktop) {
        options.push_back(
            export_option(runtime_option, Variant::INT, RUNTIME_JVM, PROPERTY_HINT_ENUM, "No,JVM,Graal", true)
        );
    }
    Dictionary defaults = JvmUserConfiguration().to_dictionary();
    int declared_category = -1;
    for (const ConfigurationOption& option : configuration_options) {
        if (option.category == CATEGORY_DEBUG && !desktop) { continue; }
        if (option.category != declared_category) {
            declared_category = option.category;
            options.push_back(export_option(
                override_options[option.category],
                Variant::BOOL,
                false,
                PROPERTY_HINT_GROUP_ENABLE,
                "checkbox_only",
                true
            ));
        }
        Variant default_value = defaults[option.key];
        options.push_back(export_option(
            option.option,
            default_value.get_type(),
            default_value,
            option.range != nullptr ? PROPERTY_HINT_RANGE : PROPERTY_HINT_NONE,
            option.range != nullptr ? option.range : "",
            String(option.option) == enable_debugger_option
        ));
    }
    if (p_platform->get_os_name() != "Android") {
        options.push_back(
            export_option(custom_arguments_option, Variant::STRING, String(), PROPERTY_HINT_NONE, "", false)
        );
    }
    return options;
}

bool GodotJvmEditorExportPlugin::_get_export_option_visibility(
    const Ref<EditorExportPlatform>&,
    const String& p_option
) const {
    // Godot asks every plugin about every option; options are only declared on the platforms supporting them.
    if (p_option.begins_with(debug_options_prefix)) {
        if (selected_runtime() == RUNTIME_GRAAL) { return false; }
        if (p_option == debug_override_option) { return true; }
        if (!bool(get_option(debug_override_option))) { return false; }
        return p_option == enable_debugger_option
            || p_option == jmx_port_option
            || bool(get_option(enable_debugger_option));
    }
    if (p_option.begins_with(memory_options_prefix)) {
        return p_option == memory_override_option || bool(get_option(memory_override_option));
    }
    return true;
}

int GodotJvmEditorExportPlugin::selected_runtime() const {
    // Presets exported from the command line may predate the option; a missing value means the default.
    Variant runtime = get_option(runtime_option);
    int selected = runtime.get_type() == Variant::NIL ? RUNTIME_JVM : int(runtime);
    return selected >= RUNTIME_NONE && selected <= RUNTIME_GRAAL ? selected : RUNTIME_JVM;
}

String GodotJvmEditorExportPlugin::_get_export_option_warning(
    const Ref<EditorExportPlatform>& p_platform,
    const String& p_option
) const {
    if (p_option == debug_address_option) {
        return _get_export_option_visibility(p_platform, p_option)
                    && !JvmUserConfiguration::is_valid_debug_address(get_option(p_option))
                 ? "Debug Address must be an IP address or * to listen on every address."
                 : String();
    }
    if (p_option != runtime_option) { return String(); }

    const DesktopRuntimeFiles* files = desktop_runtime_files(p_platform->get_os_name());
    if (files == nullptr) { return String(); }
    int runtime = selected_runtime();

    PackedStringArray warnings;
    if (runtime == RUNTIME_JVM) {
        String architecture = get_option("binary_format/architecture");
        bool universal = architecture == "universal";
        PackedStringArray missing;
        for (const String& jre_directory : embedded_jre_directories(
                 *files,
                 universal || architecture == "arm64",
                 universal || architecture == "x86_64"
             )) {
            if (!DirAccess::dir_exists_absolute(jre_directory)) { missing.push_back(jre_directory); }
        }
        if (!missing.is_empty()) {
            warnings.push_back(vformat(
                "No embedded JRE at %s. Run the \"Generate JRE\" Gradle task or jlink before exporting.",
                String(", ").join(missing)
            ));
        }
        missing.clear();
        for (const String& jar : desktop_jars()) {
            if (!FileAccess::file_exists(jar)) { missing.push_back(jar); }
        }
        if (!missing.is_empty()) {
            warnings.push_back(vformat(
                "No JVM build at %s. Run the \"Build\" Gradle task before exporting.",
                String(", ").join(missing)
            ));
        }
    }
    if (runtime == RUNTIME_GRAAL) {
        String native_image = String(RES_DIRECTORY) + files->native_image_file;
        if (!FileAccess::file_exists(native_image)) {
            warnings.push_back(vformat(
                "No Graal native image at %s. Run the \"Build Graal Native Image\" Gradle task before exporting.",
                native_image
            ));
        }
    }
    return String("\n").join(warnings);
}

bool GodotJvmEditorExportPlugin::_should_update_export_options(const Ref<EditorExportPlatform>& p_platform) const {
    // Makes the dialog re-evaluate the warning above once the user generates a JRE or a native image. The
    // preset (hence the architecture) is unknown here, so both JRE directories of the platform are watched.
    String os_name = p_platform->get_os_name();
    const DesktopRuntimeFiles* files = desktop_runtime_files(os_name);
    if (files == nullptr) { return false; }

    int state = FileAccess::file_exists(String(RES_DIRECTORY) + files->native_image_file) ? 1 : 0;
    int bit = 2;
    for (const String& jre_directory : embedded_jre_directories(*files, true, true)) {
        if (DirAccess::dir_exists_absolute(jre_directory)) { state |= bit; }
        bit <<= 1;
    }
    for (const String& jar : desktop_jars()) {
        if (FileAccess::file_exists(jar)) { state |= bit; }
        bit <<= 1;
    }

    int* known_state = runtime_file_states.getptr(os_name);
    if (known_state != nullptr && *known_state == state) { return false; }
    runtime_file_states[os_name] = state;
    return true;
}

void GodotJvmEditorExportPlugin::_export_begin(
    const PackedStringArray& p_features,
    bool p_debug,
    const String& p_path,
    uint32_t p_flags
) {
    JVM_LOG_INFO("Beginning Godot-Jvm specific exports.");

    // Features carry the platform in lower case; the runtime file table is keyed by Godot's OS name.
    String os_name = p_features.has("windows") ? "Windows"
                   : p_features.has("linux")   ? "Linux"
                   : p_features.has("macos")   ? "macOS"
                   : p_features.has("android") ? "Android"
                   : p_features.has("ios")     ? "iOS"
                                               : String();
    const DesktopRuntimeFiles* desktop_files = desktop_runtime_files(os_name);
    int runtime = desktop_files != nullptr ? selected_runtime() : RUNTIME_JVM;
    // Read back by _export_file, which is only given the export features.
    exporting_jvm_runtime = runtime == RUNTIME_JVM;

    if (desktop_files != nullptr) {
        if (runtime == RUNTIME_JVM) {
            bool universal = p_features.has("universal");
            bool arm64 = universal || p_features.has("arm64");
            bool x86_64 = universal || p_features.has("x86_64");
            if (!arm64 && !x86_64) {
                JVM_ERR_FAIL_MSG(
                    "This desktop architecture is not supported for export. Only arm64 and x86_64 are "
                    "supported by Godot-JVM!"
                );
            }

            // Godot exports the jars itself as regular resources; only their presence has to be checked here.
            for (const String& jar : desktop_jars()) {
                if (!FileAccess::file_exists(jar)) {
                    JVM_ERR_FAIL_MSG(
                        "JVM build does not exist at %s! Run the \"Build\" Gradle task before exporting.",
                        jar
                    );
                }
            }

            // Presets give a bare project-relative export path ("./export/game.exe"), which DirAccess::copy()
            // would resolve against the source directory. Godot's globalize_path makes it an absolute OS path.
            String export_directory = p_path.get_base_dir();
            if (!export_directory.is_absolute_path()) {
                export_directory = ProjectSettings::get_singleton()->globalize_path(
                    String(RES_DIRECTORY) + export_directory.trim_prefix("./")
                );
            }
            for (const String& jre_directory : embedded_jre_directories(*desktop_files, arm64, x86_64)) {
                if (!DirAccess::dir_exists_absolute(jre_directory)) {
                    JVM_ERR_FAIL_MSG(
                        "JRE does not exist at %s! make sure you've created an embedded JRE using jlink!",
                        jre_directory
                    );
                }
                if (os_name == "macOS") {
                    // on macos the embedded jre needs to be added as a plugin file
                    add_macos_plugin_file(jre_directory);
                } else {
                    // on windows and linux the embedded jre is copied next to the exported executable
                    String target_directory = export_directory.path_join(jre_directory.trim_prefix(RES_DIRECTORY));
                    if (copy_directory_recursive(jre_directory, target_directory) != OK) {
                        JVM_ERR_FAIL_MSG(
                            "Cannot copy %s folder to export folder, please make sure you created a JRE directory at "
                            "the root of your project using jlink for the platform you want to export.",
                            jre_directory
                        );
                    }
                }
            }
        }

        if (runtime == RUNTIME_GRAAL) {
            // usercode.(so, dll, dylib) is packed into the pck and extracted to user:// at runtime.
            String native_image = String(RES_DIRECTORY) + desktop_files->native_image_file;
            if (!FileAccess::file_exists(native_image)) {
                JVM_ERR_FAIL_MSG("File can't be found, it won't be exported: %s", native_image);
            }
            add_file(native_image, FileAccess::get_file_as_bytes(native_image), false);
            JVM_LOG_INFO("Exporting %s", native_image);
        }
    } else if (p_features.has("ios")) {
        PackedStringArray static_libraries = {
            ProjectSettings::get_singleton()->globalize_path(IOS_JAVA_STATIC_LIBRARY),
            ProjectSettings::get_singleton()->globalize_path(IOS_JVM_STATIC_LIBRARY),
            ProjectSettings::get_singleton()->globalize_path(IOS_GRAAL_NATIVE_IMAGE_ARCHIVE),
        };
        for (const String& static_library : static_libraries) {
            if (!FileAccess::file_exists(static_library)) {
                JVM_ERR_FAIL_MSG(
                    "Missing iOS static library: %s. Run buildIOS or buildIOSRelease before exporting.",
                    static_library
                );
            }
        }
        for (const String& static_library : static_libraries) {
            add_apple_embedded_platform_project_static_lib(static_library);
        }
    } else if (!p_features.has("android")) {
        JVM_ERR_FAIL_MSG("Godot-JVM doesn't handle this platform");
    }

    // Configuration: the project file read at export time, with the preset overrides applied on top. Neither
    // editor defaults nor command-line overrides belong in the package.
    JvmUserConfiguration configuration;
    if (FileAccess::file_exists(JVM_CONFIGURATION_PATH)) {
        JvmUserConfiguration::parse_configuration_json(
            FileAccess::get_file_as_string(JVM_CONFIGURATION_PATH),
            configuration
        );
    }
    Dictionary values = configuration.to_dictionary();
    Dictionary defaults = JvmUserConfiguration().to_dictionary();
    for (const ConfigurationOption& option : configuration_options) {
        if (option.category == CATEGORY_DEBUG && desktop_files == nullptr) { continue; }
        if (!bool(get_option(override_options[option.category]))) { continue; }
        // Presets exported from the command line may predate an option; a missing value means the default.
        Variant value = get_option(option.option);
        values[option.key] = value.get_type() == Variant::NIL ? defaults[option.key] : value;
    }
    String arguments = os_name != "Android" ? String(get_option(custom_arguments_option)) : String();
    if (!arguments.strip_edges().is_empty()) {
        HashMap<String, Variant> parsed;
        JvmUserConfiguration::parse_command_line({String(JVM_ARGUMENTS_CMD_IDENTIFIER) + "=" + arguments}, parsed);
        values[JVM_ARGUMENTS_JSON_IDENTIFIER] = parsed[JVM_ARGUMENTS_CMD_IDENTIFIER];
    }
    JVM_ERR_FAIL_COND_MSG(
        JvmUserConfiguration::parse_configuration_json(JSON::stringify(values), configuration),
        "Invalid Godot-JVM export preset configuration"
    );
    if (runtime != RUNTIME_NONE) { configuration.use_native_image = runtime == RUNTIME_GRAAL; }

    // Pack only the keys the platform reads.
    values = configuration.to_dictionary();
    if (desktop_files == nullptr) {
        values.erase(USE_NATIVE_IMAGE_JSON_IDENTIFIER);
        for (const ConfigurationOption& option : configuration_options) {
            if (option.category == CATEGORY_DEBUG) { values.erase(option.key); }
        }
    }
    if (os_name == "Android") { values.erase(JVM_ARGUMENTS_JSON_IDENTIFIER); }
    add_file(JVM_CONFIGURATION_PATH, JSON::stringify(values, "    ", true, false).to_utf8_buffer(), false);

    JVM_LOG_INFO("Finished Godot-Jvm specific exports.");
}

String GodotJvmEditorExportPlugin::_get_name() const {
    return "Godot-JVM";
}

void GodotJvmEditorExportPlugin::_export_file(
    const String& p_path,
    const String& p_type,
    const PackedStringArray& p_features
) {
    // EditorExportPreset exposes no exclude-filter setter, so the files Godot must not pack are skipped here.
    bool android = p_features.has("android");
    bool excluded = p_path == JVM_CONFIGURATION_PATH || p_path.begins_with(String(BUILD_DIRECTORY) + "/");
    // Android loads this descriptor from the Godot-JVM AAR. Exporting the project copy as well makes Godot try
    // to load it a second time from the pck, where its native-library paths do not exist.
    excluded = excluded || (android && p_path == "res://addons/jvm/jvm.gdextension");
    if (!excluded && p_path.begins_with(String(RES_DIRECTORY) + JVM_DIRECTORY)) {
        // res://jvm/ holds the artifacts of every platform: desktop and Android jars, native images and
        // embedded JREs. JVM exports need their runtime jars and, on desktop, intact external dependencies;
        // the native image is added explicitly by _export_begin and everything else must stay out.
        String bootstrap = String(RES_DIRECTORY) + (android ? ANDROID_BOOTSTRAP_FILE : DESKTOP_BOOTSTRAP_FILE);
        String user_code = String(RES_DIRECTORY) + (android ? ANDROID_USER_CODE_FILE : DESKTOP_USER_CODE_FILE);
        bool external_jar = !android && p_path.begins_with(String(RES_DIRECTORY) + EXTERNAL_JARS_DIRECTORY);
        excluded = p_features.has("ios")
                || !exporting_jvm_runtime
                || (!external_jar && p_path != bootstrap && p_path != user_code);
    }
    if (excluded) {
        skip();
        return;
    }

    String ext = p_path.get_extension();
    if (ext == GODOT_KOTLIN_SCRIPT_EXTENSION
        || ext == GODOT_JAVA_SCRIPT_EXTENSION
        || ext == GODOT_SCALA_SCRIPT_EXTENSION
        || ext == GODOT_JVM_REGISTRATION_FILE_EXTENSION) {
        // The exported script only carries the fully qualified class name; remapping drops the original source.
        String source_code;
        if (read_source_script_file(p_path, source_code) != OK) {
            JVM_LOG_WARNING(vformat("Failed to read source %s", p_path));
            return;
        }
        StringName fq_name = parse_source_script_fqname(source_code, p_path);
        add_file(p_path, String(fq_name).to_utf8_buffer(), true);
    }
}

#endif
