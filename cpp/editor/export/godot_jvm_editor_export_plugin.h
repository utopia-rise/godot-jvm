#ifndef GODOT_JVM_EDITOR_EXPORT_PLUGIN_H
#define GODOT_JVM_EDITOR_EXPORT_PLUGIN_H

#include "jvm/jni/jvm.h"

#include <classes/dir_access.hpp>
#include <classes/editor_export_platform.hpp>
#include <classes/editor_export_plugin.hpp>
#include <templates/hash_map.hpp>

namespace godot {
    class GodotJvmEditorExportPlugin : public EditorExportPlugin {
        GDCLASS(GodotJvmEditorExportPlugin, EditorExportPlugin);

    protected:
        static void _bind_methods() {}

    public:
        bool _supports_platform(const Ref<EditorExportPlatform>& p_platform) const override;
        PackedStringArray _get_android_libraries(const Ref<EditorExportPlatform>& p_platform, bool p_debug) const override;
        // The "Runtime" preset option; its warning is what the export dialog shows when a bundled runtime is missing.
        TypedArray<Dictionary> _get_export_options(const Ref<EditorExportPlatform>& p_platform) const override;
        String _get_export_option_warning(const Ref<EditorExportPlatform>& p_platform, const String& p_option) const override;
        bool _should_update_export_options(const Ref<EditorExportPlatform>& p_platform) const override;
        void _export_begin(const PackedStringArray& p_features, bool p_is_debug, const String& p_path, uint32_t p_flags) override;
        // Source files editions
        void _export_file(const String& p_path, const String& p_type, const PackedStringArray& p_features) override;

        String _get_name() const override;

    private:
        // Which runtime files (native image, embedded JREs) existed at the last _should_update_export_options() check, per OS name.
        mutable HashMap<String, int> runtime_file_states;
        // Set by _export_begin for the current export so _export_file knows whether the desktop jars are wanted.
        bool exporting_jvm_runtime = true;

        int selected_runtime() const;
        void _generate_export_configuration_file(jni::JvmType vm_type);
    };
} // namespace godot
#endif // GODOT_JVM_EDITOR_EXPORT_PLUGIN_H
