#ifndef GODOT_JVM_JVM_SCRIPT_H
#define GODOT_JVM_JVM_SCRIPT_H

#include "jvm/wrapper/registration/kt_class.h"
#include "jvm_placeholder_instance.h"
#include "templates/hash_set.hpp"

#include <classes/script_extension.hpp>
#include <classes/script_language_extension.hpp>

namespace godot {

    class JvmInstance;

    class JvmScript : public ScriptExtension {
        GDCLASS(JvmScript, ScriptExtension);

        friend class JvmInstance;
        friend class JvmScriptManager;
        friend class JvmPlaceHolderInstance;

    protected:
        KtClass* kotlin_class;
        // mutable: written from _set_path_cache(), which the engine (and Resource::_set_path_cache) requires to be const.
        mutable String source;

        GodotObject* _object_create() const;
#ifdef DEBUG_ENABLED
        bool validate_instance_creation() const;
#endif
        void* create_jvm_instance(GodotObject* p_raw_owner) const;

    public:
        JvmScript();
        ~JvmScript() override;

        Variant _new();
        bool _can_instantiate() const override;
        bool _inherits_script(const Ref<Script>& p_script) const override;
        Ref<Script> _get_base_script() const override;
        StringName _get_instance_base_type() const override;
        void* _instance_create(GodotObject* p_for_object) const override;
        bool _has_source_code() const override;
        String _get_source_code() const override;
        void _set_source_code(const String& p_code) override;
        StringName _get_global_name() const override;
        Error _reload(bool p_keep_state) override;
        bool _has_method(const StringName& p_method) const override;
        Dictionary _get_method_info(const StringName& p_method) const override;
        bool _is_tool() const override;
        bool _is_valid() const override;
        bool _is_placeholder_fallback_enabled() const override;
        bool _is_abstract() const override;
        bool _has_script_signal(const StringName& p_signal) const override;
        TypedArray<Dictionary> _get_script_signal_list() const override;
        bool _has_property_default_value(const StringName& p_property) const override;
        Variant _get_property_default_value(const StringName& p_property) const override;
        TypedArray<Dictionary> _get_script_method_list() const override;
        TypedArray<Dictionary> _get_script_property_list() const override;
        TypedArray<StringName> _get_members() const override;
        Dictionary _get_constants() const override;
        void get_script_exported_property_list(List<PropertyInfo>* p_list) const;
        Variant _get_rpc_config() const override;

        // Dummy implementations: no real static-method introspection, and export-list refresh outside the editor is handled by update_script_exports() (TOOLS_ENABLED only, below).
        bool _has_static_method(const StringName& p_method) const override;
        void _update_exports() override;

    private:
        void _get_script_property_info_list(List<PropertyInfo>* p_list) const;

    public:

        _FORCE_INLINE_ static String get_script_file_name(const String& path) {
            return path.get_file().trim_suffix(path.get_extension()).trim_suffix(".");
        }

#ifdef TOOLS_ENABLED
        // This concerns placeholders script instances only

    private:
        mutable HashMap<GDExtensionScriptInstancePtr, JvmPlaceHolderInstance::JvmPlaceHolderInstanceData*> placeholders;
        mutable HashMap<StringName, Variant> exported_members_default_value_cache;
        StringName last_physical_fqdn;
        uint64_t last_source_modified_time = 0;
        mutable bool export_dirty_flag = true;

        void move_placeholders_to(JvmScript* p_script);

    public:
        bool _editor_can_reload_from_file() override;
        void* _placeholder_instance_create(GodotObject* p_for_object) const override;
        uint64_t get_last_source_modified_time() const;
        void set_last_source_modified_time(uint64_t p_time);
        void update_source_sync_warning();

        TypedArray<Dictionary> _get_documentation() const override;
        String _get_class_icon_path() const override;
        StringName _get_doc_class_name() const override;

        void update_script_exports() const;

        void _placeholder_erased(void* p_placeholder) override;
        virtual void _format_template(const String& p_path) const;

        // Real Resource virtual, invoked by the engine whenever this resource's path is assigned/cached (mirrors master's per-language Script::set_path() override trigger point, which GDExtension's ScriptExtension has no direct equivalent for).
        void _set_path_cache(const String& p_path) const override;
#endif

    protected:
        static void _bind_methods();
    };

} // namespace godot
#endif // GODOT_JVM_JVM_SCRIPT_H
