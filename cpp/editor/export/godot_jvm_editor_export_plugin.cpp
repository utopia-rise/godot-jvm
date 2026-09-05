#ifdef TOOLS_ENABLED

#include "godot_jvm_editor_export_plugin.h"

#include "api/language/names.h"
#include "api/script/source_script_parser.h"
#include "godot_jvm.h"
#include "jvm/lifecycle/jvm_user_configuration.h"
#include "logging.h"
#include "paths.h"

#include <classes/dir_access.hpp>
#include <classes/file_access.hpp>
#include <classes/project_settings.hpp>

using namespace godot;

// Desktop preset option selecting which runtime(s) the export bundles. Shown as "Godot Jvm > Runtime".
static constexpr const char* runtime_option = "godot_jvm/runtime";
enum Runtime {
    RUNTIME_NONE,
    RUNTIME_JVM,
    RUNTIME_GRAAL,
    RUNTIME_BOTH,
};
static constexpr const char* runtime_option_values = "No,JVM,Graal,Both";

namespace {
    // Export presets configure their output path as a bare project-root-relative path (e.g.
    // "./export/tests.exe" in export_presets.cfg), which Godot passes straight through to
    // _export_begin()'s p_path unresolved — neither res://-prefixed nor an OS-absolute path.
    // DirAccess::copy()/make_dir_recursive() resolve such a bare relative argument against the
    // *calling DirAccess instance's own current directory*, not the process's CWD. Since the
    // instance here is opened on the source (res://jvm/jre-...), passing a bare relative
    // destination sends the copy into a subdirectory of the source instead of next to the
    // exported binary. Normalizing to an absolute OS path removes the ambiguity outright.
    String to_absolute_path(const String& p_path) {
        if (p_path.is_absolute_path()) { return p_path; }
        return ProjectSettings::get_singleton()->globalize_path(String(RES_DIRECTORY) + p_path.trim_prefix("./"));
    }

    // Walk the tree with DirAccess's exposed list_dir_begin/get_next/copy/make_dir_recursive API.
    Error copy_directory_recursive(const String& from, const String& to) {
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

            Error sub_error;
            if (dir_access->current_is_dir()) {
                sub_error = copy_directory_recursive(from_entry, to_entry);
            } else {
                sub_error = dir_access->copy(from_entry, to_entry);
            }

            if (sub_error != OK) {
                dir_access->list_dir_end();
                return sub_error;
            }
        }
        dir_access->list_dir_end();
        return OK;
    }

    // Where the desktop runtimes live in the project, per Godot OS name. Null for non-desktop platforms.
    struct DesktopRuntimeFiles {
        const char* arm64_jre_directory;
        const char* x86_64_jre_directory;
        const char* native_image_file;
    };

    const DesktopRuntimeFiles* desktop_runtime_files(const String& p_os_name) {
        static constexpr DesktopRuntimeFiles windows = {WINDOWS_EMBEDDED_JRE_ARM_DIRECTORY, WINDOWS_EMBEDDED_JRE_AMD_DIRECTORY, WINDOWS_GRAAL_NATIVE_IMAGE_FILE};
        static constexpr DesktopRuntimeFiles linux = {LINUX_EMBEDDED_JRE_ARM_DIRECTORY, LINUX_EMBEDDED_JRE_AMD_DIRECTORY, LINUX_GRAAL_NATIVE_IMAGE_FILE};
        static constexpr DesktopRuntimeFiles macos = {MACOS_EMBEDDED_JRE_ARM_DIRECTORY, MACOS_EMBEDDED_JRE_AMD_DIRECTORY, MACOS_GRAAL_NATIVE_IMAGE_FILE};
        if (p_os_name == "Windows") { return &windows; }
        if (p_os_name == "Linux") { return &linux; }
        if (p_os_name == "macOS") { return &macos; }
        return nullptr;
    }

    // res:// paths of the embedded JREs an export needs, one per exported architecture.
    PackedStringArray embedded_jre_directories(const DesktopRuntimeFiles& p_files, bool p_arm64, bool p_x86_64) {
        PackedStringArray directories;
        if (p_arm64) { directories.push_back(String(RES_DIRECTORY) + p_files.arm64_jre_directory); }
        if (p_x86_64) { directories.push_back(String(RES_DIRECTORY) + p_files.x86_64_jre_directory); }
        return directories;
    }

    // res:// paths of the jars every desktop JVM export bundles.
    PackedStringArray desktop_jars() {
        return {String(RES_DIRECTORY) + DESKTOP_BOOTSTRAP_FILE, String(RES_DIRECTORY) + DESKTOP_USER_CODE_FILE};
    }

    // EditorExportPreset exposes no exclude-filter setter, so skip these paths in _export_file.
    bool should_skip_export(const String& p_path, const PackedStringArray& p_features, bool p_export_jvm) {
        if (p_path == JVM_CONFIGURATION_PATH) { return true; }
        // Android loads this descriptor from the Godot-JVM AAR. Exporting the project copy as
        // well makes Godot try to load it a second time from the pck, where its native-library
        // paths do not exist.
        if (p_features.has("android") && p_path == "res://addons/jvm/jvm.gdextension") { return true; }
        if (p_path.begins_with(String(BUILD_DIRECTORY) + "/")) { return true; }
        if (p_path.begins_with(String(RES_DIRECTORY) + JVM_DIRECTORY)) {
            // res://jvm/ holds the artifacts of every platform: desktop and Android jars, native images and
            // embedded JREs. Only the two jars the target platform loads at runtime belong in the pck; the
            // native image is added explicitly by _export_begin and everything else must stay out.
            if (p_features.has("ios") || !p_export_jvm) { return true; }
            bool android = p_features.has("android");
            String bootstrap = String(RES_DIRECTORY) + (android ? ANDROID_BOOTSTRAP_FILE : DESKTOP_BOOTSTRAP_FILE);
            String user_code = String(RES_DIRECTORY) + (android ? ANDROID_USER_CODE_FILE : DESKTOP_USER_CODE_FILE);
            return p_path != bootstrap && p_path != user_code;
        }
        return false;
    }
} // namespace

bool GodotJvmEditorExportPlugin::_supports_platform(const Ref<EditorExportPlatform>& p_platform) const {
    // Godot only asks supporting plugins for export options, warnings and Android libraries.
    return p_platform.is_valid() && (p_platform->get_os_name() == "Android" || desktop_runtime_files(p_platform->get_os_name()) != nullptr);
}

PackedStringArray GodotJvmEditorExportPlugin::_get_android_libraries(const Ref<EditorExportPlatform>&, bool p_debug) const {
    return {p_debug ? "jvm/libs/android/debug/godot-jvm-debug.aar" : "jvm/libs/android/release/godot-jvm-release.aar"};
}

TypedArray<Dictionary> GodotJvmEditorExportPlugin::_get_export_options(const Ref<EditorExportPlatform>& p_platform) const {
    TypedArray<Dictionary> options;
    if (desktop_runtime_files(p_platform->get_os_name()) == nullptr) { return options; }

    Dictionary property_info;
    property_info["name"] = runtime_option;
    property_info["type"] = Variant::INT;
    property_info["hint"] = PROPERTY_HINT_ENUM;
    property_info["hint_string"] = runtime_option_values;
    Dictionary option;
    option["option"] = property_info;
    option["default_value"] = RUNTIME_JVM;
    options.push_back(option);
    return options;
}

int GodotJvmEditorExportPlugin::selected_runtime() const {
    // Presets exported from the command line may predate the option; a missing value means the default.
    Variant runtime = get_option(runtime_option);
    return runtime.get_type() == Variant::NIL ? RUNTIME_JVM : int(runtime);
}

String GodotJvmEditorExportPlugin::_get_export_option_warning(const Ref<EditorExportPlatform>& p_platform, const String& p_option) const {
    if (p_option != runtime_option) { return {}; }
    const DesktopRuntimeFiles* files = desktop_runtime_files(p_platform->get_os_name());
    if (files == nullptr) { return {}; }
    int runtime = selected_runtime();

    PackedStringArray warnings;
    if (runtime == RUNTIME_JVM || runtime == RUNTIME_BOTH) {
        String architecture = get_option("binary_format/architecture");
        bool universal = architecture == "universal";
        PackedStringArray missing;
        for (const String& jre_directory : embedded_jre_directories(*files, universal || architecture == "arm64", universal || architecture == "x86_64")) {
            if (!DirAccess::dir_exists_absolute(jre_directory)) { missing.push_back(jre_directory); }
        }
        if (!missing.is_empty()) {
            warnings.push_back(vformat("No embedded JRE at %s. Run the \"Generate JRE\" Gradle task or jlink before exporting.", String(", ").join(missing)));
        }
        missing.clear();
        for (const String& jar : desktop_jars()) {
            if (!FileAccess::file_exists(jar)) { missing.push_back(jar); }
        }
        if (!missing.is_empty()) {
            warnings.push_back(vformat("No JVM build at %s. Run the \"Build\" Gradle task before exporting.", String(", ").join(missing)));
        }
    }
    if (runtime == RUNTIME_GRAAL || runtime == RUNTIME_BOTH) {
        String native_image = String(RES_DIRECTORY) + files->native_image_file;
        if (!FileAccess::file_exists(native_image)) {
            warnings.push_back(vformat("No Graal native image at %s. Run the \"Build Graal Native Image\" Gradle task before exporting.", native_image));
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

void GodotJvmEditorExportPlugin::_export_begin(const PackedStringArray& p_features, bool p_debug, const String& p_path, uint32_t p_flags) {
    JVM_LOG_INFO("Beginning Godot-Jvm specific exports.");

    // Features carry the platform in lower case; the runtime file table is keyed by Godot's OS name.
    String os_name = p_features.has("windows") ? "Windows" : p_features.has("linux") ? "Linux" : p_features.has("macos") ? "macOS" : String();
    const DesktopRuntimeFiles* desktop_files = desktop_runtime_files(os_name);

    int runtime = desktop_files != nullptr ? selected_runtime() : RUNTIME_JVM;
    bool export_jvm = runtime == RUNTIME_JVM || runtime == RUNTIME_BOTH;
    // Read back by _export_file, which is only given the export features.
    exporting_jvm_runtime = export_jvm;

    if (desktop_files != nullptr) {
        if (export_jvm) {
            bool universal = p_features.has("universal");
            bool arm64 = universal || p_features.has("arm64");
            bool x86_64 = universal || p_features.has("x86_64");
            if (!arm64 && !x86_64) {
                JVM_ERR_FAIL_MSG("This desktop architecture is not supported for export. Only arm64 and x86_64 are "
                                 "supported by Godot-JVM!");
            }

            // Godot exports the jars itself as regular resources; only their presence has to be checked here.
            for (const String& jar : desktop_jars()) {
                if (!FileAccess::file_exists(jar)) {
                    JVM_ERR_FAIL_MSG("JVM build does not exist at %s! Run the \"Build\" Gradle task before exporting.", jar);
                }
            }

            for (const String& jre_directory : embedded_jre_directories(*desktop_files, arm64, x86_64)) {
                if (!DirAccess::dir_exists_absolute(jre_directory)) {
                    JVM_ERR_FAIL_MSG("JRE does not exist at %s! make sure you've created an embedded JRE using jlink!", jre_directory);
                }

                if (os_name == "macOS") {
                    // on macos the embedded jre needs to be added as a plugin file
                    add_macos_plugin_file(jre_directory);
                } else {
                    // on windows and linux the embedded jre is copied next to the exported executable
                    String target_directory = to_absolute_path(p_path.get_base_dir()).path_join(jre_directory.trim_prefix(RES_DIRECTORY));
                    if (copy_directory_recursive(jre_directory, target_directory) != OK) {
                        JVM_ERR_FAIL_MSG(
                          "Cannot copy %s folder to export folder, please make sure you created a JRE directory at the "
                          "root of your project using jlink for the platform you want to export.",
                          jre_directory
                        );
                    }
                }
            }
        }

        if (runtime == RUNTIME_GRAAL || runtime == RUNTIME_BOTH) {
            // usercode.(so, dll, dylib) is packed into the pck and extracted to user:// at runtime.
            String native_image = String(RES_DIRECTORY) + desktop_files->native_image_file;
            if (!FileAccess::file_exists(native_image)) {
                JVM_ERR_FAIL_MSG("File can't be found, it won't be exported: %s", native_image);
            }
            add_file(native_image, FileAccess::get_file_as_bytes(native_image), false);
            JVM_LOG_INFO("Exporting %s", native_image);
        }

        // With both runtimes bundled, the editor's own runtime mode picks which one starts; a launch
        // argument can still override it.
        if (runtime == RUNTIME_BOTH) {
            _generate_export_configuration_file(GodotJvm::get_instance().get_configuration().vm_type);
        } else if (runtime == RUNTIME_JVM) {
            _generate_export_configuration_file(jni::JvmType::JVM);
        } else if (runtime == RUNTIME_GRAAL) {
            _generate_export_configuration_file(jni::JvmType::GRAAL_NATIVE_IMAGE);
        }
    } else if (p_features.has("android")) {
        _generate_export_configuration_file(jni::JvmType::ART);
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

        _generate_export_configuration_file(jni::JvmType::GRAAL_NATIVE_IMAGE);

        for (const String& static_library : static_libraries) {
            add_apple_embedded_platform_project_static_lib(static_library);
        }
    } else {
        JVM_ERR_FAIL_MSG("Godot-JVM doesn't handle this platform");
    }

    JVM_LOG_INFO("Finished Godot-Jvm specific exports.");
}

void GodotJvmEditorExportPlugin::_generate_export_configuration_file(jni::JvmType vm_type) {
    JvmUserConfiguration configuration = GodotJvm::get_instance().get_configuration(); // Copy
    configuration.vm_type = vm_type; // We only need to change the vm type

    add_file(JVM_CONFIGURATION_PATH, JvmUserConfiguration::export_configuration_to_json(configuration).to_utf8_buffer(), false);
}

String GodotJvmEditorExportPlugin::_get_name() const {
    return "Godot-JVM";
}

void GodotJvmEditorExportPlugin::_export_file(const String& p_path, const String& p_type, const PackedStringArray& p_features) {
    if (should_skip_export(p_path, p_features, exporting_jvm_runtime)) {
        skip();
        return;
    }

    String ext = p_path.get_extension();
    if (ext == GODOT_KOTLIN_SCRIPT_EXTENSION || ext == GODOT_JAVA_SCRIPT_EXTENSION
        || ext == GODOT_SCALA_SCRIPT_EXTENSION || ext == GODOT_JVM_REGISTRATION_FILE_EXTENSION) {
        // We replace the original script with another with the same path and name but with fqname content.
        // The remap boolean ensures that the original file is not kept for the export.

        String source_code;
        Error error = read_source_script_file(p_path, source_code);
        if (error != OK) {
            JVM_LOG_WARNING(vformat("Failed to read source %s", p_path));
            return;
        }

        String exported_content;
        StringName fq_name = parse_source_script_fqname(source_code, p_path);
        if (!fq_name.is_empty()) { exported_content = String(fq_name); }

        add_file(p_path, exported_content.to_utf8_buffer(), true);

        return;
    }
}

#endif
