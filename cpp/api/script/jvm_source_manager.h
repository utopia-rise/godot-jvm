#ifdef TOOLS_ENABLED

#ifndef GODOT_JVM_JVM_SOURCE_MANAGER_H
#define GODOT_JVM_JVM_SOURCE_MANAGER_H

#include <templates/hash_map.hpp>
#include <templates/vector.hpp>
#include <variant/string.hpp>

namespace godot {
    class JvmSourceManager {
        Vector<String> roots;
        HashMap<String, String> built_hashes;
        HashMap<String, String> loaded_hashes;
        bool roots_added = false;

        JvmSourceManager() = default;

        bool is_under_root(const String& p_path) const;

    public:
        static JvmSourceManager& get_instance();

        JvmSourceManager(const JvmSourceManager&) = delete;
        JvmSourceManager& operator=(const JvmSourceManager&) = delete;

        void load_build_hashes();
        bool were_roots_added() const;
        void record_source(const String& p_path);
        bool is_source_outdated(const String& p_path) const;
        bool is_user_code_outdated();
    };
} // namespace godot

#endif // GODOT_JVM_JVM_SOURCE_MANAGER_H

#endif // TOOLS_ENABLED
