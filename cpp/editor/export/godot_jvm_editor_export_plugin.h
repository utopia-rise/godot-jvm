#ifndef GODOT_JVM_EDITOR_EXPORT_PLUGIN_H
#define GODOT_JVM_EDITOR_EXPORT_PLUGIN_H

#include "jvm/jni/jvm.h"

#include <classes/dir_access.hpp>
#include <classes/editor_export_platform.hpp>
#include <classes/editor_export_plugin.hpp>
#include <templates/hash_set.hpp>

namespace godot {
    class GodotJvmEditorExportPlugin : public EditorExportPlugin {
        GDCLASS(GodotJvmEditorExportPlugin, EditorExportPlugin);

    protected:
        static void _bind_methods() {}

    public:
        bool _supports_platform(const Ref<EditorExportPlatform>& p_platform) const override;
        PackedStringArray _get_android_libraries(const Ref<EditorExportPlatform>& p_platform, bool p_debug) const override;
        void _export_begin(const PackedStringArray& p_features, bool p_is_debug, const String& p_path, uint32_t p_flags) override;
        // Source files editions
        void _export_file(const String& p_path, const String& p_type, const PackedStringArray& p_features) override;

        String _get_name() const override;

    private:
        void _generate_export_configuration_file(jni::JvmType vm_type);
    };
} // namespace godot
#endif // GODOT_JVM_EDITOR_EXPORT_PLUGIN_H
