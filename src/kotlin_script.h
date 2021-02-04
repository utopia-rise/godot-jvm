#ifndef GODOT_JVM_KOTLIN_SCRIPT_H
#define GODOT_JVM_KOTLIN_SCRIPT_H
#include "core/script_language.h"
#include "kt_class.h"

class KotlinScript : public Script {
    GDCLASS(KotlinScript, Script);

private:
    String source;
    KtClass* get_kotlin_class() const;

public:
    KotlinScript() = default;

#ifdef TOOLS_ENABLED
    ~KotlinScript() override;
#else
    ~KotlinScript() override = default;
#endif

    Variant _new(const Variant **p_args, int p_argcount, Variant::CallError &r_error);

    bool can_instance() const override;

    Ref<Script> get_base_script() const override;

    StringName get_instance_base_type() const override;

    ScriptInstance* instance_create(Object* p_this) override;

    bool instance_has(const Object* p_this) const override;

    bool has_source_code() const override;

    String get_source_code() const override;

    void set_source_code(const String& p_code) override;

    Error reload(bool p_keep_state) override;

    bool has_method(const StringName& p_method) const override;

    MethodInfo get_method_info(const StringName& p_method) const override;

    bool is_tool() const override;

    bool is_valid() const override;

    ScriptLanguage* get_language() const override;

    bool has_script_signal(const StringName& p_signal) const override;

    void get_script_signal_list(List<MethodInfo>* r_signals) const override;

    bool get_property_default_value(const StringName& p_property, Variant& r_value) const override;

    void get_script_method_list(List<MethodInfo>* p_list) const override;

    void get_script_property_list(List<PropertyInfo>* p_list) const override;

#ifdef TOOLS_ENABLED
private:
    Set<PlaceHolderScriptInstance *> placeholders;

    void _placeholder_erased(PlaceHolderScriptInstance *p_placeholder) override;
public:
    PlaceHolderScriptInstance *placeholder_instance_create(Object *p_this) override;
    bool is_placeholder_fallback_enabled() const override;
#endif

protected:
    static void _bind_methods();
};

#endif //GODOT_JVM_KOTLIN_SCRIPT_H
