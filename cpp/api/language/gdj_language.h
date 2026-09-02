#ifndef GODOT_JVM_GDJ_LANGUAGE_H
#define GODOT_JVM_GDJ_LANGUAGE_H

#include "jvm_language.h"
namespace godot {
    class GdjLanguage : public JvmLanguage {
        GDCLASS(GdjLanguage, JvmLanguage);

    protected:
        // Must stay distinct from JvmLanguage::_bind_methods -- see the comment there.
        static void _bind_methods() { (void)get_class_static(); }

    public:
        GdjLanguage() = default;
        ~GdjLanguage() override = default;
        GdjLanguage(const GdjLanguage&) = delete;

        static GdjLanguage* get_instance();

        void _init() override;
        void _frame() override;
        void _finish() override;

        void _thread_enter() override;
        void _thread_exit() override;

        TypedArray<Dictionary> _debug_get_current_stack_info() override;

        String _get_name() const override;
        String _get_type() const override;
        String _get_extension() const override;
        PackedStringArray _get_recognized_extensions() const override;

        bool _handles_global_class_type(const String& p_type) const override;
        Object* _create_script() const override;

        bool _supports_builtin_mode() const override;

        PackedStringArray _get_reserved_words() const override;
        bool _is_control_flow_keyword(const String& p_keyword) const override;
        PackedStringArray _get_comment_delimiters() const override;
        PackedStringArray _get_doc_comment_delimiters() const override;
        PackedStringArray _get_string_delimiters() const override;
        Ref<Script> _make_template(const String& p_template, const String& p_class_name, const String& p_base_class_name) const override;
    };
}
#endif// GODOT_JVM_GDJ_LANGUAGE_H
