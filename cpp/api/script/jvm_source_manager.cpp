#ifdef TOOLS_ENABLED

#include "jvm_source_manager.h"

#include "paths.h"

#include <classes/editor_file_system.hpp>
#include <classes/editor_interface.hpp>
#include <classes/file_access.hpp>
#include <classes/json.hpp>
#include <variant/array.hpp>
#include <variant/dictionary.hpp>

using namespace godot;

JvmSourceManager& JvmSourceManager::get_instance() {
    static JvmSourceManager instance;
    return instance;
}

bool JvmSourceManager::is_under_root(const String& p_path) const {
    for (const String& root : roots) {
        if (p_path.begins_with(root)) { return true; }
    }
    return false;
}

void JvmSourceManager::load_build_hashes() {
    const Vector<String> previous_roots = roots;
    roots.clear();
    built_hashes.clear();

    const String hashes_path = String(RES_DIRECTORY) + SOURCE_HASHES_FILE;
    Variant json = FileAccess::file_exists(hashes_path)
                     ? JSON::parse_string(FileAccess::get_file_as_string(hashes_path))
                     : Variant();
    if (json.get_type() == Variant::DICTIONARY) {
        Dictionary build_hashes = json;
        Array build_roots = build_hashes["roots"];
        for (const String root : build_roots) {
            if (!previous_roots.is_empty() && !previous_roots.has(root)) { roots_added = true; }
            roots.push_back(root);
        }
        Dictionary sources = build_hashes["sources"];
        for (const String source_path : sources.keys()) {
            built_hashes[source_path] = sources[source_path];
        }
    }

    Vector<String> outside_roots;
    for (const KeyValue<String, String>& source : loaded_hashes) {
        if (!is_under_root(source.key)) { outside_roots.push_back(source.key); }
    }
    for (const String& path : outside_roots) {
        loaded_hashes.erase(path);
    }
}

bool JvmSourceManager::were_roots_added() const {
    return roots_added;
}

void JvmSourceManager::record_source(const String& p_path) {
    if (is_under_root(p_path)) { loaded_hashes[p_path] = FileAccess::get_md5(p_path); }
}

bool JvmSourceManager::is_source_outdated(const String& p_path) const {
    const HashMap<String, String>::ConstIterator loaded_hash = loaded_hashes.find(p_path);
    if (!loaded_hash) { return false; }
    const HashMap<String, String>::ConstIterator built_hash = built_hashes.find(p_path);
    return !built_hash || built_hash->value != loaded_hash->value;
}

bool JvmSourceManager::is_user_code_outdated() {
    EditorFileSystem* filesystem = EditorInterface::get_singleton()->get_resource_filesystem();
    if (filesystem->is_scanning()) { return true; }

    for (const KeyValue<String, String>& source : built_hashes) {
        if (filesystem->get_file_type(source.key).is_empty()) { return true; }
        const HashMap<String, String>::ConstIterator loaded_hash = loaded_hashes.find(source.key);
        if (loaded_hash && loaded_hash->value != source.value) { return true; }
    }

    Vector<String> deleted_sources;
    for (const KeyValue<String, String>& source : loaded_hashes) {
        if (built_hashes.has(source.key)) { continue; }
        if (!filesystem->get_file_type(source.key).is_empty()) { return true; }
        deleted_sources.push_back(source.key);
    }
    for (const String& path : deleted_sources) {
        loaded_hashes.erase(path);
    }
    return false;
}

#endif // TOOLS_ENABLED
