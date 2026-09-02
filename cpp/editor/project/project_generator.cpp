#include "project_generator.h"

#include "editor/strings.h"
#include "version.h"

#include <classes/dir_access.hpp>
#include <classes/file_access.hpp>
#include <classes/marshalls.hpp>
#include <classes/project_settings.hpp>

using namespace godot;

constexpr const int permissions = FileAccess::UnixPermissionFlags::UNIX_READ_OTHER | FileAccess::UnixPermissionFlags::UNIX_WRITE_OTHER
                                  | FileAccess::UnixPermissionFlags::UNIX_READ_GROUP | FileAccess::UnixPermissionFlags::UNIX_WRITE_GROUP
                                  | FileAccess::UnixPermissionFlags::UNIX_READ_OWNER | FileAccess::UnixPermissionFlags::UNIX_WRITE_OWNER
                                  | FileAccess::UnixPermissionFlags::UNIX_EXECUTE_OWNER;

void remove_optional_block(String& content, const String& name) {
    const String begin_marker = "// BEGIN_OPTIONAL_" + name;
    const String end_marker = "// END_OPTIONAL_" + name;
    const int begin = content.find(begin_marker);
    const int end = content.find(end_marker, begin);
    if (begin != -1 && end != -1) {
        content = content.left(begin) + content.substr(end + end_marker.length());
    }
}

void remove_optional_markers(String& content, const String& name) {
    content = content
        .replace("// BEGIN_OPTIONAL_" + name, "")
        .replace("// END_OPTIONAL_" + name, "");
}

void ProjectGenerator::generate_jvm_files(bool erase_existing) {
    JVM_LOG_INFO("Generating JVM project files...");

    String root = String("res://");
    Ref<DirAccess> root_directory = DirAccess::open(root);
    Marshalls* marshall = memnew(Marshalls);

    for (int i = 0; i < number_of_files; ++i) {
        String file_location = String(file_names[i]);
        String directory_path = file_location.get_base_dir();

        if (!erase_existing && FileAccess::file_exists(file_location)) { continue; }

        if (!FileAccess::file_exists(root.path_join(file_location))) {
            root_directory->make_dir_recursive(directory_path);
        }

        {
            // Its own scope so the FileAccess is automatically closed.
            Ref<FileAccess> file = FileAccess::open(file_location, FileAccess::WRITE);
            if (FileAccess::get_open_error() != OK) {
                JVM_LOG_WARNING("Cannot save template file '" + file_location + "'.");
            } else if (file_is_binary[i]) {
                PackedByteArray file_content = marshall->base64_to_raw(file_contents[i]);
                file->store_buffer(file_content);
            } else {
                String file_content =
                  marshall->base64_to_utf8(file_contents[i])
                    .replace(VERSION_TEMPLATE, GODOT_JVM_VERSION)
                    .replace(PROJECT_NAME_TEMPLATE, ProjectSettings::get_singleton()->get_setting("application/config/name"))
                    .replace("GODOT_LANGUAGES", "GodotLanguage.KOTLIN, GodotLanguage.JAVA, GodotLanguage.SCALA");
                remove_optional_block(file_content, "ANDROID");
                remove_optional_block(file_content, "GRAAL");
                remove_optional_markers(file_content, "COROUTINES");
                file->store_string(file_content);
            }
        }
#if UNIX_ENABLED
        FileAccess::set_unix_permissions(file_location, permissions);
#endif
    }
    memdelete(marshall);
    JVM_LOG_INFO("JVM project files generated.");
}
