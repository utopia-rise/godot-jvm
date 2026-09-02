#include "jvm_resource_format_saver.h"

#include "api/language/names.h"
#include "api/script/jvm_script.h"
#include "api/script/jvm_script_manager.h"
#include "api/script/source_script_parser.h"
#include <classes/file_access.hpp>

using namespace godot;

PackedStringArray JvmResourceFormatSaver::_get_recognized_extensions(const Ref<Resource>& p_resource) const {
    PackedStringArray extensions;
    extensions.push_back(GODOT_KOTLIN_SCRIPT_EXTENSION);
    extensions.push_back(GODOT_JVM_REGISTRATION_FILE_EXTENSION);
    extensions.push_back(GODOT_JAVA_SCRIPT_EXTENSION);
    extensions.push_back(GODOT_SCALA_SCRIPT_EXTENSION);
    return extensions;
}

bool JvmResourceFormatSaver::_recognize(const Ref<Resource>& p_resource) const {
    return Object::cast_to<JvmScript>(p_resource.ptr()) != nullptr;
}

Error JvmResourceFormatSaver::_save(const Ref<Resource>& p_resource, const String& p_path, uint32_t p_flags) {
    Ref<JvmScript> jvm_script = p_resource;
    ERR_FAIL_COND_V(jvm_script.is_null(), ERR_INVALID_PARAMETER);

    const String extension = p_path.get_extension();
#ifdef TOOLS_ENABLED
    const bool is_source_script = extension == GODOT_KOTLIN_SCRIPT_EXTENSION
                                  || extension == GODOT_JAVA_SCRIPT_EXTENSION
                                  || extension == GODOT_SCALA_SCRIPT_EXTENSION;
    if (is_source_script) {
        jvm_script->_format_template(p_path);
    }
#endif

    if (!FileAccess::file_exists(p_path) && extension == GODOT_JVM_REGISTRATION_FILE_EXTENSION) {
        JVM_LOG_WARNING("It's not recommended to create .gdj files directly as they are generated automatically from "
                        "jvm source files "
                        "when building your project.\n"
                        "Register a class with a matching name if you don't want this file to get deleted the next "
                        "time you build.");
    }

    {
        Ref<FileAccess> file {FileAccess::open(p_path, FileAccess::WRITE)};
        Error err = FileAccess::get_open_error();
        JVM_ERR_FAIL_COND_V_MSG(err != OK, err, "Cannot save Script file '" + p_path + "'.");
        file->store_string(jvm_script->get_source_code());

        if (file->get_error() != OK && file->get_error() != ERR_FILE_EOF) { return ERR_CANT_CREATE; }
    }

#ifdef TOOLS_ENABLED
    if (is_source_script) {
        const StringName fqdn = parse_source_script_fqname(jvm_script->get_source_code(), p_path);
        JvmScriptManager::get_instance()->update_physical_script(jvm_script.ptr(), fqdn);
        jvm_script->set_last_source_modified_time(FileAccess::get_modified_time(p_path));
    }
#endif

    return OK;
}
