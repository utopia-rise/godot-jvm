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
#include <templates/vector.hpp>

using namespace godot;

static constexpr const char* graal_feature {"export-graal-native-image"};
static constexpr const char* all_jvm_feature {"export-all-jvm"};

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

    // godot-cpp's DirAccess exposes no recursive-copy equivalent to the engine-internal
    // DirAccess::copy_dir master relied on, so we walk the tree ourselves with the exposed
    // list_dir_begin/get_next/copy/make_dir_recursive API.
    Error copy_directory_recursive(const String& from, const String& to) {
        Ref<DirAccess> dir_access {DirAccess::open(from)};
        if (dir_access.is_null()) { return DirAccess::get_open_error(); }

        Error error = dir_access->make_dir_recursive(to);
        if (error != OK) { return error; }

        error = dir_access->list_dir_begin();
        if (error != OK) { return error; }

        for (String entry = dir_access->get_next(); !entry.is_empty(); entry = dir_access->get_next()) {
            if (entry == "." || entry == "..") { continue; }

            String from_entry {from.path_join(entry)};
            String to_entry {to.path_join(entry)};

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

    // godot-cpp's EditorExportPreset exposes get_exclude_filter() but no setter, so master's approach
    // of registering these paths in the preset's exclude filter isn't reachable from a GDExtension.
    // We get the same functional result (these paths never end up in the exported pck) by skipping
    // them from within _export_file instead.
    bool should_skip_export(const String& p_path, const PackedStringArray& p_features) {
        if (p_path == JVM_CONFIGURATION_PATH) { return true; }
        // Android loads this descriptor from the Godot-JVM AAR. Exporting the project copy as
        // well makes Godot try to load it a second time from the pck, where its native-library
        // paths do not exist.
        if (p_features.has("android") && p_path == "res://addons/jvm/jvm.gdextension") { return true; }
        if (p_path.begins_with(String(BUILD_DIRECTORY) + "/")) { return true; }
        if (p_path.begins_with(String(RES_DIRECTORY) + JVM_DIRECTORY) && p_path.find("jre-") != -1 && p_path.get_extension() == "jar") {
            return true;
        }
        return false;
    }
} // namespace

bool GodotJvmEditorExportPlugin::_supports_platform(const Ref<EditorExportPlatform>& p_platform) const {
    return p_platform.is_valid() && p_platform->get_os_name() == "Android";
}

PackedStringArray GodotJvmEditorExportPlugin::_get_android_libraries(const Ref<EditorExportPlatform>&, bool p_debug) const {
    return {p_debug ? "jvm/libs/android/debug/godot-jvm-debug.aar" : "jvm/libs/android/release/godot-jvm-release.aar"};
}

void GodotJvmEditorExportPlugin::_export_begin(const PackedStringArray& p_features, bool p_debug, const String& p_path, uint32_t p_flags) {
    JVM_LOG_INFO("Beginning Godot-Jvm specific exports.");

    // Add mandatory jars to pck
    Vector<String> files_to_add;

    bool is_windows_export {p_features.has("windows")};
    bool is_linux_export {p_features.has("linux")};
    bool is_macos_export {p_features.has("macos")};
    bool is_desktop_export {is_windows_export || is_linux_export || is_macos_export};
    bool is_android_export {p_features.has("android")};
    bool is_ios_export {p_features.has("ios")};

    bool is_universal {p_features.has("universal")};
    bool is_arm64 {p_features.has("arm64") || is_universal};
    bool is_x64 {p_features.has("x86_64") || is_universal};

    bool export_all {p_features.has(all_jvm_feature)};
    bool export_graal {p_features.has(graal_feature) || export_all};
    bool export_jvm {!p_features.has(graal_feature) || export_all};

    if (is_desktop_export) {
        if (export_jvm) {
            // add embedded jre
            if (is_macos_export) {
                // on macos the embedded jre needs to be added as a plugin file
                if (is_arm64) {
                    String jre_path {String(RES_DIRECTORY).path_join(MACOS_EMBEDDED_JRE_ARM_DIRECTORY)};
                    if (!DirAccess::dir_exists_absolute(jre_path)) {
                        JVM_ERR_FAIL_MSG("JRE does not exist at %s! make sure you've created an embedded JRE using jlink!", jre_path);
                    }
                    add_macos_plugin_file(jre_path);
                }
                if (is_x64) {
                    String jre_path {String(RES_DIRECTORY).path_join(MACOS_EMBEDDED_JRE_AMD_DIRECTORY)};
                    if (!DirAccess::dir_exists_absolute(jre_path)) {
                        JVM_ERR_FAIL_MSG("JRE does not exist at %s! make sure you've created an embedded JRE using jlink!", jre_path);
                    }
                    add_macos_plugin_file(jre_path);
                }

                if (!is_arm64 && !is_x64) {
                    JVM_ERR_FAIL_MSG("This desktop architecture is not supported for export. Only arm64 and x86_64 are "
                                     "supported by Godot-JVM!");
                }
            } else if (is_linux_export || is_windows_export) {
                // on windows and linux the embedded jre can be added as a normal export dir
                String jre_dir {RES_DIRECTORY};
                String target_dir {to_absolute_path(p_path.get_base_dir())};

                if (is_arm64) {
                    if (is_linux_export) {
                        jre_dir = jre_dir.path_join(LINUX_EMBEDDED_JRE_ARM_DIRECTORY);
                        target_dir = target_dir.path_join(LINUX_EMBEDDED_JRE_ARM_DIRECTORY);
                    }
                    if (is_windows_export) {
                        jre_dir = jre_dir.path_join(WINDOWS_EMBEDDED_JRE_ARM_DIRECTORY);
                        target_dir = target_dir.path_join(WINDOWS_EMBEDDED_JRE_ARM_DIRECTORY);
                    }
                }
                if (is_x64) {
                    if (is_linux_export) {
                        jre_dir = jre_dir.path_join(LINUX_EMBEDDED_JRE_AMD_DIRECTORY);
                        target_dir = target_dir.path_join(LINUX_EMBEDDED_JRE_AMD_DIRECTORY);
                    }
                    if (is_windows_export) {
                        jre_dir = jre_dir.path_join(WINDOWS_EMBEDDED_JRE_AMD_DIRECTORY);
                        target_dir = target_dir.path_join(WINDOWS_EMBEDDED_JRE_AMD_DIRECTORY);
                    }
                }
                if (!is_arm64 && !is_x64) {
                    JVM_ERR_FAIL_MSG("This desktop architecture is not supported for export. Only arm64 and x86_64 are "
                                     "supported by Godot-JVM!");
                }
                if (jre_dir.is_empty() || target_dir.is_empty()) {
                    JVM_ERR_FAIL_MSG("Could not find a jre directory for the current export configuration");
                }

                // copy the jre to res
                if (copy_directory_recursive(jre_dir, target_dir) != OK) {
                    JVM_ERR_FAIL_MSG(
                      "Cannot copy %s folder to export folder, please make sure you created a JRE directory at the "
                      "root of your project using jlink for the platform you want to export.",
                      jre_dir
                    );
                }
            } else {
                JVM_ERR_FAIL_MSG("Current desktop export target platform is not supported by Godot-JVM! Only "
                                 "supported desktop targets are linux, macos and windows");
            }
        }

        // graal native image (usercode.(so, dll, dylib))
        if (export_graal) {
            if (is_windows_export) {
                files_to_add.push_back(String(RES_DIRECTORY).path_join(WINDOWS_GRAAL_NATIVE_IMAGE_FILE));
            } else if (is_linux_export) {
                files_to_add.push_back(String(RES_DIRECTORY).path_join(LINUX_GRAAL_NATIVE_IMAGE_FILE));
            } else if (is_macos_export) {
                files_to_add.push_back(String(RES_DIRECTORY).path_join(MACOS_GRAAL_NATIVE_IMAGE_FILE));
            } else {
                JVM_ERR_FAIL_MSG("Export target platform is not supported for graalvm export");
            }
        }

        // Add the Godot-JVM configuration file based on export targets.
        if (export_all) {
            _generate_export_configuration_file(GodotJvm::get_instance().get_configuration().vm_type);
        } else if (export_jvm) {
            _generate_export_configuration_file(jni::JvmType::JVM);
        } else if (export_graal) {
            _generate_export_configuration_file(jni::JvmType::GRAAL_NATIVE_IMAGE);
        }
    } else if (is_android_export) {
        _generate_export_configuration_file(jni::JvmType::ART);
    } else if (is_ios_export) {
        PackedStringArray static_libraries {
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

    for (const String& file_to_add : files_to_add) {
        if (!FileAccess::file_exists(file_to_add)) {
            JVM_ERR_FAIL_MSG("File can't be found, it won't be exported: %s", file_to_add);
        }
        add_file(file_to_add, FileAccess::get_file_as_bytes(file_to_add), false);
        JVM_LOG_INFO("Exporting %s", file_to_add);
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
    if (should_skip_export(p_path, p_features)) {
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
