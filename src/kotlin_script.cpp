#include "kotlin_script.h"
#include "kotlin_language.h"
#include "kotlin_instance.h"
#include "gd_kotlin.h"
#include "logging.h"

bool KotlinScript::can_instance() const {
#ifdef TOOLS_ENABLED
    if (Engine::get_singleton()->is_editor_hint()) {
        return false;
    } else {
        return true;
    }
#else
    return true;
#endif
}

Ref<Script> KotlinScript::get_base_script() const {
    return Ref<Script>();
}

StringName KotlinScript::get_instance_base_type() const {
    if (KtClass* kotlin_class{get_kotlin_class()}) {
        return kotlin_class->base_godot_class;
    }
    // not found
    return StringName();
}

ScriptInstance* KotlinScript::instance_create(Object* p_this) {
    KtClass* kt_class { get_kotlin_class() };
    logging::verbose(vformat("Try to create %s instance.", kt_class->name));
    jni::Env env = jni::Jvm::current_env();
    KtObject *wrapped = kt_class->create_instance(env, nullptr, 0, p_this);
    return memnew(KotlinInstance(wrapped, p_this, kt_class));
}

bool KotlinScript::instance_has(const Object* p_this) const {
    return false;
}

bool KotlinScript::has_source_code() const {
    return !source.empty();
}

String KotlinScript::get_source_code() const {
    return source;
}

void KotlinScript::set_source_code(const String& p_code) {
    if (source == p_code) return;
    source = p_code;

    //TODO : deal with tool mode
}

Error KotlinScript::reload(bool p_keep_state) {
    return ERR_UNAVAILABLE;
}

bool KotlinScript::has_method(const StringName& p_method) const {
    KtClass* kotlinClass = get_kotlin_class();
    return kotlinClass ? kotlinClass->get_method(p_method) != nullptr : false;
}

MethodInfo KotlinScript::get_method_info(const StringName& p_method) const {
    if (KtClass* kotlin_class{get_kotlin_class()}) {
        if (KtFunction* method{kotlin_class->get_method(p_method)}) {
            return method->get_member_info();
        }
    }
    return MethodInfo();
}

bool KotlinScript::is_tool() const {
    return false;
}

bool KotlinScript::is_valid() const {
    return false;
}

ScriptLanguage* KotlinScript::get_language() const {
    return &KotlinLanguage::get_instance();
}

bool KotlinScript::has_script_signal(const StringName& p_signal) const {
    KtClass* kotlin_class{get_kotlin_class()};
    return kotlin_class ? kotlin_class->get_signal(p_signal) != nullptr : false;
}

void KotlinScript::get_script_signal_list(List<MethodInfo>* r_signals) const {
    if (KtClass* kotlin_class{get_kotlin_class()}) {
        kotlin_class->get_signal_list(r_signals);
    }
}

bool KotlinScript::get_property_default_value(const StringName& p_property, Variant& r_value) const {
    bool has_default{false};
    if (KtClass* kt_class{get_kotlin_class()}) {
        if (KtProperty* property{kt_class->get_property(p_property)}) {
            property->get_default_value(r_value);
            has_default = true;
        }
    }
    return has_default;
}

void KotlinScript::get_script_method_list(List<MethodInfo>* p_list) const {
    KtClass* kotlinClass { get_kotlin_class() };
    if (kotlinClass) {
        kotlinClass->get_method_list(p_list);
    }
}

void KotlinScript::get_script_property_list(List<PropertyInfo>* p_list) const {
    KtClass* kotlinClass { get_kotlin_class() };
    if (kotlinClass) {
        kotlinClass->get_property_list(p_list);
    }
}

KtClass* KotlinScript::get_kotlin_class() const {
    return GDKotlin::get_instance().find_class(get_path());
}

Variant KotlinScript::_new(const Variant **p_args, int p_argcount, Variant::CallError &r_error) {
    r_error.error = Variant::CallError::CALL_OK;

    Object* owner{ClassDB::instance(get_kotlin_class()->base_godot_class)};

    REF ref;
    auto* r{Object::cast_to<Reference>(owner)};
    if (r) {
        ref = REF(r);
    }

    ScriptInstance* instance{instance_create(owner)};
    owner->set_script_instance(instance);
    if (!instance) {
        if (ref.is_null()) {
            memdelete(owner); //no owner, sorry
        }
        return Variant();
    }

    if (ref.is_valid()) {
        return ref;
    } else {
        return owner;
    }
}

#ifdef TOOLS_ENABLED
PlaceHolderScriptInstance* KotlinScript::placeholder_instance_create(Object* p_this) {
    PlaceHolderScriptInstance* placeholder{
        memnew(PlaceHolderScriptInstance(&KotlinLanguage::get_instance(), Ref<Script>(this), p_this))
    };
    p_this->set_script_instance(placeholder);
    placeholders.insert(placeholder);
    _update_exports(placeholder);
    return placeholder;
}

void KotlinScript::update_exports() {
    for (Set<PlaceHolderScriptInstance *>::Element *E = placeholders.front(); E; E = E->next()) {
        _update_exports(E->get());
    }
}

void KotlinScript::_update_exports(PlaceHolderScriptInstance* placeholder) const {
    List<PropertyInfo> properties;
    Map<StringName, Variant> default_values;
    get_script_property_list(&properties);
    for (int i = 0; i < properties.size(); ++i) {
        StringName property_name{properties[i].name};
        Variant ret;
        get_property_default_value(property_name, ret);
        default_values[property_name] = ret;
    }
    placeholder->update(properties, default_values);
}

void KotlinScript::_placeholder_erased(PlaceHolderScriptInstance* p_placeholder) {
    placeholders.erase(p_placeholder);
}
#endif

#ifdef TOOLS_ENABLED
KotlinScript::~KotlinScript() {
    for (Set<PlaceHolderScriptInstance *>::Element *E = placeholders.front(); E; E = E->next()) {
        memdelete(E->get());
    }

    placeholders.clear();
}
#endif

void KotlinScript::_bind_methods() {
    ClassDB::bind_vararg_method(METHOD_FLAGS_DEFAULT, "new", &KotlinScript::_new, MethodInfo("new"));
}