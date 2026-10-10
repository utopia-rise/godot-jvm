#include "project_generator.h"

#include "editor/strings.h"
#include "logging.h"
#include "templates.h"
#include "version.h"

#include <classes/dir_access.hpp>
#include <classes/file_access.hpp>
#include <classes/marshalls.hpp>
#include <classes/project_settings.hpp>

using namespace godot;

constexpr const int permissions = FileAccess::UnixPermissionFlags::UNIX_READ_OTHER
                                | FileAccess::UnixPermissionFlags::UNIX_WRITE_OTHER
                                | FileAccess::UnixPermissionFlags::UNIX_READ_GROUP
                                | FileAccess::UnixPermissionFlags::UNIX_WRITE_GROUP
                                | FileAccess::UnixPermissionFlags::UNIX_READ_OWNER
                                | FileAccess::UnixPermissionFlags::UNIX_WRITE_OWNER
                                | FileAccess::UnixPermissionFlags::UNIX_EXECUTE_OWNER;

static int get_line_start(const String& p_content, int p_position) {
    return p_position == 0 ? 0 : p_content.rfind("\n", p_position - 1) + 1;
}

static int get_next_line_start(const String& p_content, int p_position) {
    const int newline = p_content.find("\n", p_position);
    return newline == -1 ? p_content.length() : newline + 1;
}

static void remove_optional_block(String& content, const String& name) {
    const int begin = content.find("// BEGIN_OPTIONAL_" + name);
    const int end = content.find("// END_OPTIONAL_" + name, begin);
    if (begin == -1 || end == -1) { return; }

    // The blank lines separating the block from what precedes it go with it.
    int start = get_line_start(content, begin);
    while (start > 0) {
        const int previous = get_line_start(content, start - 1);
        if (!content.substr(previous, start - previous).strip_edges().is_empty()) { break; }
        start = previous;
    }
    content = content.left(start) + content.substr(get_next_line_start(content, end));
}

static void remove_optional_markers(String& content, const String& name) {
    for (const String& marker : {"// BEGIN_OPTIONAL_" + name, "// END_OPTIONAL_" + name}) {
        const int position = content.find(marker);
        if (position == -1) { continue; }
        content = content.left(get_line_start(content, position))
                + content.substr(get_next_line_start(content, position));
    }
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
                        .replace(
                            PROJECT_NAME_TEMPLATE,
                            ProjectSettings::get_singleton()->get_setting("application/config/name")
                        )
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
