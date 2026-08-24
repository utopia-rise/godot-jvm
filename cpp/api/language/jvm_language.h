#ifndef KOTLIN_JVM_LANGUAGE_H
#define KOTLIN_JVM_LANGUAGE_H

#include "classes/script_language_extension.hpp"

namespace godot {
    class JvmLanguage : public ScriptLanguageExtension {
        GDCLASS(JvmLanguage, ScriptLanguageExtension);

    protected:
        // Deliberately not an empty body, and the same applies to every subclass: GDCLASS only calls
        // register_virtuals() when a class's _bind_methods differs *by address* from its parent's, and
        // linkers fold byte-identical functions together (MSVC /OPT:ICF, GCC -fipa-icf at -O2). Two empty
        // bodies in a parent/child pair therefore collapse to one address in optimized builds and silently
        // drop every virtual override -- which showed up as "Required virtual method
        // GdjLanguage::_get_extension must be overridden" in template_release only. Referencing the
        // class's own static name keeps each body distinct.
        static void _bind_methods() { (void)get_class_static(); }

    public:
        Dictionary _validate(
          const String &p_script,
          const String &p_path,
          bool p_validate_functions,
          bool p_validate_errors,
          bool p_validate_warnings,
          bool p_validate_safe_lines
        ) const override;
        String _validate_path(const String& p_path) const override;
        Dictionary _get_global_class_name(const String& p_path) const override;

        // Dummy Implementations
        bool _has_named_classes() const override;
        bool _supports_documentation() const override;
        bool _can_inherit_from_file() const override;
        int32_t _find_function(const String& p_function, const String& p_code) const override;
        String _make_function(const String& p_class_name, const String& p_function_name, const PackedStringArray& p_function_args) const override;
        bool _can_make_function() const override;
        Error _open_in_external_editor(const Ref<Script>& p_script, int p_line, int p_col) override;
        bool _overrides_external_editor() override;
        ScriptLanguage::ScriptNameCasing _preferred_file_name_casing() const override;
        Dictionary _complete_code(const String& p_code, const String& p_path, Object* p_owner) const override;
        Dictionary _lookup_code(const String& p_code, const String& p_symbol, const String& p_path, Object* p_owner) const override;

        String _auto_indent_code(const String &p_code, int32_t p_from_line, int32_t p_to_line) const override;

        // GdExtension requires these to be explicitly overridden somewhere in the class hierarchy or it fatals ("Required virtual method must be overridden before calling") — GdjLanguage provides real implementations and overrides these again; Kot...
        void _init() override;
        void _frame() override;
        void _finish() override;
        void _thread_enter() override;
        void _thread_exit() override;
        TypedArray<Dictionary> _debug_get_current_stack_info() override;
        String _debug_get_error() const override;
        int32_t _debug_get_stack_level_count() const override;
        int32_t _debug_get_stack_level_line(int32_t p_level) const override;
        String _debug_get_stack_level_function(int32_t p_level) const override;
        String _debug_get_stack_level_source(int32_t p_level) const override;
        Dictionary _debug_get_stack_level_locals(int32_t p_level, int32_t p_max_subitems, int32_t p_max_depth) override;
        Dictionary _debug_get_stack_level_members(int32_t p_level, int32_t p_max_subitems, int32_t p_max_depth) override;
        void* _debug_get_stack_level_instance(int32_t p_level) override;
        Dictionary _debug_get_globals(int32_t p_max_subitems, int32_t p_max_depth) override;
        String _debug_parse_stack_level_expression(int32_t p_level, const String& p_expression, int32_t p_max_subitems, int32_t p_max_depth) override;
        void _reload_all_scripts() override;
        void _reload_scripts(const Array& p_scripts, bool p_soft_reload) override;
        void _reload_tool_script(const Ref<Script>& p_script, bool p_soft_reload) override;
        void _add_global_constant(const StringName& p_name, const Variant& p_value) override;
        void _add_named_global_constant(const StringName& p_name, const Variant& p_value) override;
        void _remove_named_global_constant(const StringName& p_name) override;

        void _profiling_start() override;
        void _profiling_stop() override;
        void _profiling_set_save_native_calls(bool p_enable) override;
        int32_t _profiling_get_accumulated_data(ScriptLanguageExtensionProfilingInfo* p_info_array, int32_t p_info_max) override;
        int32_t _profiling_get_frame_data(ScriptLanguageExtensionProfilingInfo* p_info_array, int32_t p_info_max) override;

        // Dummy Implementations (matches master exactly — these are empty no-ops there too).
        TypedArray<Dictionary> _get_built_in_templates(const StringName& p_object) const override;
        bool _is_using_templates() override;
        TypedArray<Dictionary> _get_public_functions() const override;
        Dictionary _get_public_constants() const override;
        TypedArray<Dictionary> _get_public_annotations() const override;
    };
}
#endif// KOTLIN_JVM_LANGUAGE_H
