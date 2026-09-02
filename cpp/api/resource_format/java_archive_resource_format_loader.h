#ifndef GODOT_JVM_JAVA_ARCHIVE_LOADER_H
#define GODOT_JVM_JAVA_ARCHIVE_LOADER_H

#include <classes/resource.hpp>
#include <classes/resource_format_loader.hpp>
#include <templates/list.hpp>
#include <variant/string.hpp>

namespace godot {
    class JavaArchiveFormatLoader : public ResourceFormatLoader {
        GDCLASS(JavaArchiveFormatLoader, ResourceFormatLoader);

    protected:
        static void _bind_methods() {}

    public:
        JavaArchiveFormatLoader() = default;
        ~JavaArchiveFormatLoader() = default;
        JavaArchiveFormatLoader(const JavaArchiveFormatLoader&) = delete;

        PackedStringArray _get_recognized_extensions() const override;
        String _get_resource_type(const String& p_path) const override;
        bool _handles_type(const StringName& p_type) const override;
        Variant _load(const String& p_path, const String& p_original_path, bool p_use_sub_threads, int32_t p_cache_mode) const override;
        int64_t _get_resource_uid(const String& p_path) const override;
    };
}
#endif// GODOT_JVM_JAVA_ARCHIVE_LOADER_H
