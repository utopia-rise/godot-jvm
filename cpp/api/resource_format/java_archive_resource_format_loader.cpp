
#include "java_archive_resource_format_loader.h"

#include "engine/ustring.h"
#include "engine/godot_object.h"
#include "godot_jvm.h"
#include "hash.h"
#include "java_archive.h"
#include "logging.h"
#include "paths.h"

#include <classes/resource_uid.hpp>

using namespace godot;

PackedStringArray JavaArchiveFormatLoader::_get_recognized_extensions() const {
    PackedStringArray recognized_extensions;
    recognized_extensions.push_back("jar");
    recognized_extensions.push_back("dex");
    return recognized_extensions;
}

String JavaArchiveFormatLoader::_get_resource_type(const String& p_path) const {
    String ext = p_path.get_extension().to_lower();
    if(ext == "jar" || ext == "dex"){ return "JavaArchive";}
    return "";
}

bool JavaArchiveFormatLoader::_handles_type(const StringName& p_type) const {
    return p_type == SNAME("JavaArchive");
}

Variant JavaArchiveFormatLoader::_load(
  const String& p_path,
  const String& p_original_path,
  bool p_use_sub_threads,
  int32_t p_cache_mode
) const {
    JVM_LOG_VERBOSE(vformat("Loading Java Archive at: %s", p_path));
    Ref<JavaArchive> ref;
    ref.instantiate();

#ifdef TOOLS_ENABLED
    if(p_path.ends_with(USER_CODE_FILE)){ GodotJvm::get_instance().reload_user_code();
    }
#endif

    return ref;
}

int64_t JavaArchiveFormatLoader::_get_resource_uid(const String& p_path) const {
    String ext = p_path.get_extension().to_lower();
    int64_t id = ResourceUID::INVALID_ID;
    if(ext == "jar" || ext == "dex"){
        id = (int64_t) hash64(p_path + String(JAVA_ARCHIVE_UUID_HASH_SEED));
        id &= 0x7FFFFFFFFFFFFFFF;
    }
    return id;
}
