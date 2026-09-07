#include "jvm_resource_format_loader.h"

#include "api/language/names.h"
#include "api/script/jvm_script.h"
#include "api/script/jvm_script_manager.h"
#include "engine/ustring.h"
#include "hash.h"
#include "api/script/source_script_parser.h"

#include <classes/file_access.hpp>
#include <classes/resource_uid.hpp>

using namespace godot;

PackedStringArray JvmResourceFormatLoader::_get_recognized_extensions() const {
    PackedStringArray extensions;
    extensions.push_back(GODOT_JVM_REGISTRATION_FILE_EXTENSION);
    extensions.push_back(GODOT_KOTLIN_SCRIPT_EXTENSION);
    extensions.push_back(GODOT_JAVA_SCRIPT_EXTENSION);
    extensions.push_back(GODOT_SCALA_SCRIPT_EXTENSION);
    return extensions;
}

String JvmResourceFormatLoader::_get_resource_type(const String& p_path) const {
    String ext = p_path.get_extension().to_lower();

    if (ext == GODOT_JVM_REGISTRATION_FILE_EXTENSION) {
        return GODOT_JVM_SCRIPT_NAME;
    } else if (ext == GODOT_KOTLIN_SCRIPT_EXTENSION) {
        return GODOT_KOTLIN_SCRIPT_NAME;
    } else if (ext == GODOT_JAVA_SCRIPT_EXTENSION) {
        return GODOT_JAVA_SCRIPT_NAME;
    } else if (ext == GODOT_SCALA_SCRIPT_EXTENSION) {
        return GODOT_SCALA_SCRIPT_NAME;
    }
    return "";
}

bool JvmResourceFormatLoader::_handles_type(const StringName& p_type) const {
    return p_type == SNAME("Script")
           || p_type == SNAME(GODOT_JVM_SCRIPT_NAME)
           || p_type == SNAME(GODOT_KOTLIN_SCRIPT_NAME)
           || p_type == SNAME(GODOT_JAVA_SCRIPT_NAME)
           || p_type == SNAME(GODOT_SCALA_SCRIPT_NAME);
}

Variant JvmResourceFormatLoader::_load(const String& p_path, const String& p_original_path, bool p_use_sub_threads, int32_t p_cache_mode) const {
    if (p_path.begins_with(GODOT_JVM_VIRTUAL_PATH_PREFIX)) {
        Ref<JvmScript> virtual_script = JvmScriptManager::get_instance()->get_script_from_registered_name(JvmScript::get_script_file_name(p_path));
        if (virtual_script.is_null()) { return (int64_t) ERR_FILE_NOT_FOUND; }
        return virtual_script;
    }

    String source_code;
    const Error read_error = read_source_script_file(p_path, source_code);
    if (read_error != OK) { return (int64_t) read_error; }

    const StringName fqdn = parse_source_script_fqname(source_code, p_path);
    Ref<JvmScript> script = JvmScriptManager::get_instance()->create_and_bind_physical_script(p_path, fqdn);
    if (script.is_valid()) {
        script->set_source_code(source_code);
#ifdef TOOLS_ENABLED
        script->set_last_source_modified_time(FileAccess::get_modified_time(p_path));
        JvmScriptManager::get_instance()->update_physical_script(script.ptr(), fqdn);
#endif
    } else {
        return (int64_t) ERR_UNAVAILABLE;
    }
    return script;
}

int64_t JvmResourceFormatLoader::_get_resource_uid(const String& p_path) const {
    String extension = p_path.get_extension();
    int64_t id = ResourceUID::INVALID_ID;
    if (extension == GODOT_JVM_REGISTRATION_FILE_EXTENSION || extension == GODOT_KOTLIN_SCRIPT_EXTENSION
        || extension == GODOT_JAVA_SCRIPT_EXTENSION || extension == GODOT_SCALA_SCRIPT_EXTENSION) {
        String source_code;
        if (read_source_script_file(p_path, source_code) != OK) { return id; }
        const StringName fqdn = parse_source_script_fqname(source_code, p_path);
        if (fqdn.is_empty()) { return id; }
        String seed = extension == GODOT_JVM_REGISTRATION_FILE_EXTENSION ? GDJ_UUID_HASH_SEED
          : extension == GODOT_JAVA_SCRIPT_EXTENSION ? JAVA_UUID_HASH_SEED
          : extension == GODOT_SCALA_SCRIPT_EXTENSION ? SCALA_UUID_HASH_SEED
          : KOTLIN_UUID_HASH_SEED;
        id = (int64_t) hash64(String(fqdn) + seed);
        id &= 0x7FFFFFFFFFFFFFFF;
    }
    return id;
}
