#ifndef GODOT_JVM_JVM_RESOURCE_FORMAT_SAVER_H
#define GODOT_JVM_JVM_RESOURCE_FORMAT_SAVER_H

#include <classes/resource_format_saver.hpp>
#include <classes/resource.hpp>

namespace godot {
    class JvmResourceFormatSaver : public ResourceFormatSaver {
        GDCLASS(JvmResourceFormatSaver, ResourceFormatSaver);

    protected:
        static void _bind_methods() {}

    public:
        JvmResourceFormatSaver() = default;
        JvmResourceFormatSaver(const JvmResourceFormatSaver&) = delete;

        PackedStringArray _get_recognized_extensions(const Ref<Resource>& p_resource) const override;
        bool _recognize(const Ref<Resource>& p_resource) const override;
        Error _save(const Ref<Resource>& p_resource, const String& p_path, uint32_t p_flags) override;
    };
}
#endif// GODOT_JVM_JVM_RESOURCE_FORMAT_SAVER_H
