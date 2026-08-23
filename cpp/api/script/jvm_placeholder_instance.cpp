#ifdef TOOLS_ENABLED

#include "jvm_placeholder_instance.h"

#include "engine/internal.h"
#include "engine/godot_object.h"
#include "jvm_script_manager.h"

using namespace godot;

static bool is_placeholder_fallback_enabled(const Ref<Script>& p_script) {
    if (auto* script_extension = Object::cast_to<ScriptExtension>(p_script.ptr())) {
        return script_extension->_is_placeholder_fallback_enabled();
    }

    return false;
}

// The engine's PlaceHolderScriptInstance::get() only claims a property when
// Script::get_property_default_value() reports that a default actually exists — that bool is what
// makes unknown names fall through to Object, which is how Object::get("script") ends up returning
// the real Script. godot-cpp's Script::get_property_default_value() drops that bool, so ask the
// ScriptExtension virtuals directly to recover it.
static bool try_get_property_default_value(const Ref<Script>& p_script, const StringName& p_name, Variant& r_value) {
    auto* script_extension = Object::cast_to<ScriptExtension>(p_script.ptr());
    if (!script_extension || !script_extension->_has_property_default_value(p_name)) { return false; }

    r_value = script_extension->_get_property_default_value(p_name);
    return true;
}

GDExtensionBool JvmPlaceHolderInstance::set(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    Ref<Script> script = instance_data->script;
    HashMap<StringName, Variant>& values = instance_data->values;

    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);
    const Variant& parameter_value = *reinterpret_cast<const Variant*>(p_value);

    if (is_placeholder_fallback_enabled(script)) {
        return false;
    }

    if (values.has(parameter_name)) {
        Variant default_value;
        if (try_get_property_default_value(script, parameter_name, default_value)) {
            // The evaluate function ensures that a NIL variant is equal to e.g. an empty Resource. Simply doing default_value == parameter_value does not do this.
            Variant result;
            bool valid;
            Variant::evaluate(Variant::OP_EQUAL, default_value, parameter_value, result, valid);
            if (valid && result.operator bool()) {
                values.erase(parameter_name);
                return true;
            }
        }
        values[parameter_name] = parameter_value;
        return true;
    }

    Variant default_value;
    if (try_get_property_default_value(script, parameter_name, default_value)) {
        Variant result;
        bool valid;
        Variant::evaluate(Variant::OP_EQUAL, default_value, parameter_value, result, valid);
        if (valid && !result.operator bool()) {
            values[parameter_name] = parameter_value;
        }
        return true;
    }

    return false;
}

GDExtensionBool JvmPlaceHolderInstance::get(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    Ref<Script> script = instance_data->script;
    HashMap<StringName, Variant>& values = instance_data->values;
    HashMap<StringName, Variant>& constants = instance_data->constants;

    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);
    auto* result = reinterpret_cast<Variant*>(r_ret);

    if (values.has(parameter_name)) {
        *result = values[parameter_name];
        return true;
    }

    if (constants.has(parameter_name)) {
        *result = constants[parameter_name];
        return true;
    }

    // Claiming every remaining name here (rather than only those the script has a default for) makes
    // the placeholder answer "script" itself with a null Variant, so Object::get("script") reports no
    // script at all. Scenes re-packed from an editor-instantiated tree — which is what the export
    // TSCN->SCN conversion does — then see the script property as equal to its null default and drop
    // it, silently stripping every script from the exported scene.
    if (!is_placeholder_fallback_enabled(script) && try_get_property_default_value(script, parameter_name, *result)) {
        return true;
    }

    return false;
}

const GDExtensionPropertyInfo* JvmPlaceHolderInstance::get_property_list(GDExtensionScriptInstanceDataPtr p_instance, uint32_t* r_count) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);

    // create_c_property_list()/free_c_property_list() (godot-cpp) stash this pointer and memdelete() it later in free_property_list() below — it must be a fresh memnew() copy, not the address of instance_data->properties itself, which is a per...
    List<PropertyInfo>* properties_copy = memnew(List<PropertyInfo>(instance_data->properties));
    return internal::create_c_property_list(properties_copy, r_count);
}

void JvmPlaceHolderInstance::free_property_list(GDExtensionScriptInstanceDataPtr p_instance, const GDExtensionPropertyInfo* p_list, uint32_t) {
    internal::free_c_property_list(const_cast<GDExtensionPropertyInfo*>(p_list));
}

GDExtensionBool JvmPlaceHolderInstance::get_class_category(GDExtensionScriptInstanceDataPtr, GDExtensionPropertyInfo*) {
    return false;
}

GDExtensionBool JvmPlaceHolderInstance::property_can_revert(GDExtensionScriptInstanceDataPtr, GDExtensionConstStringNamePtr) {
    return false;
}

GDExtensionBool JvmPlaceHolderInstance::property_get_revert(GDExtensionScriptInstanceDataPtr, GDExtensionConstStringNamePtr, GDExtensionVariantPtr) {
    return false;
}

GDExtensionObjectPtr JvmPlaceHolderInstance::get_owner(GDExtensionScriptInstanceDataPtr p_instance) {
    // The engine expects the raw object pointer here, not our godot-cpp wrapper.
    return reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance)->owner;
}

//TODO: Remove when https://github.com/godotengine/godot/pull/105896 is released
void JvmPlaceHolderInstance::get_property_state(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionScriptInstancePropertyStateAdd p_add_func, void* p_userdata) {
    uint32_t property_count;
    const GDExtensionPropertyInfo* property_infos = get_property_list(p_instance, &property_count);
    for (int i = 0; i < property_count; ++i) {
        const GDExtensionPropertyInfo property_info = property_infos[i];
        if (property_info.usage & PROPERTY_USAGE_STORAGE) {
            Variant temp_value;
            GDExtensionVariantPtr r_ret = &temp_value;
            if (get(p_instance, property_info.name, r_ret)) {
                p_add_func(property_info.name, r_ret, p_userdata);
            }
        }
    }
    free_property_list(p_instance, property_infos, property_count);
}

const GDExtensionMethodInfo* JvmPlaceHolderInstance::get_method_list(GDExtensionScriptInstanceDataPtr p_instance, uint32_t* r_count) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    Ref<Script> script = instance_data->script;

    List<MethodInfo>& methods = instance_data->methods;

    if (is_placeholder_fallback_enabled(script)) {
        return internal::create_c_method_list(methods, r_count);
    }

    if (script.is_valid()) {
        const TypedArray<Dictionary>& script_methods = script->get_script_method_list();
        for (int i = 0; i < script_methods.size(); ++i) {
            methods.push_back(MethodInfo::from_dict(script_methods.get(i)));
        }
    }

    return internal::create_c_method_list(methods, r_count);
}

void JvmPlaceHolderInstance::free_method_list(GDExtensionScriptInstanceDataPtr p_instance, const GDExtensionMethodInfo* p_list, uint32_t p_count) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    instance_data->methods.clear();
    internal::free_c_method_list(const_cast<GDExtensionMethodInfo*>(p_list), p_count);
}

GDExtensionVariantType JvmPlaceHolderInstance::get_property_type(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionBool* r_is_valid) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    HashMap<StringName, Variant>& values = instance_data->values;
    HashMap<StringName, Variant>& constants = instance_data->constants;

    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);

    if (values.has(parameter_name)) {
        if (r_is_valid) {
            *r_is_valid = true;
        }
        return (GDExtensionVariantType) values[parameter_name].get_type();
    }

    if (constants.has(parameter_name)) {
        if (r_is_valid) {
            *r_is_valid = true;
        }
        return (GDExtensionVariantType) constants[parameter_name].get_type();
    }

    if (r_is_valid) {
        *r_is_valid = false;
    }

    return GDExtensionVariantType::GDEXTENSION_VARIANT_TYPE_NIL;
}

GDExtensionBool JvmPlaceHolderInstance::validate_property(GDExtensionScriptInstanceDataPtr, GDExtensionPropertyInfo*) {
    // Per the GDExtensionScriptInstanceValidateProperty contract (see godot-cpp's Wrapped::validate_property_bind), the return value signals whether this call actually validated/mutated p_property, not merely whether the property is "valid". T...
    return false;
}

GDExtensionBool JvmPlaceHolderInstance::has_method(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name) {
    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);

    if (parameter_name == SNAME("_get_configuration_warnings")) { return true; }

    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    Ref<Script> script = instance_data->script;

    if (is_placeholder_fallback_enabled(script)) {
        return false;
    }

    if (script.is_valid()) {
        Ref<Script> scr = script;
        while (scr.is_valid()) {
            if (scr->has_method(parameter_name)) {
                return true;
            }
            scr = scr->get_base_script();
        }
    }
    return false;
}

GDExtensionInt JvmPlaceHolderInstance::get_method_argument_count(GDExtensionScriptInstanceDataPtr, GDExtensionConstStringNamePtr, GDExtensionBool* r_is_valid) {
    if (r_is_valid) {
        *r_is_valid = false;
    }
    return 0;
}

void JvmPlaceHolderInstance::call(
  GDExtensionScriptInstanceDataPtr p_instance,
  GDExtensionConstStringNamePtr p_method,
  const GDExtensionConstVariantPtr*,
  GDExtensionInt,
  GDExtensionVariantPtr r_return,
  GDExtensionCallError* r_error
) {
    const StringName& parameter_method = *reinterpret_cast<const StringName*>(p_method);
    auto* result = reinterpret_cast<Variant*>(r_return);

    if (parameter_method == SNAME("_get_configuration_warnings")) {
        // get_script() returns a raw ABI pointer; Ref needs the stored godot-cpp wrapper.
        Ref<JvmScript> script_ref = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance)->script;
        if (!script_ref->_is_valid()) {
            PackedStringArray packed {};
            packed.append("This script can't be found in your JVM project. Don't forget to build it and use a valid "
                          "gdj/kt/java file.");
            *result = packed;
        } else if (script_ref->get_last_source_modified_time() > JvmScriptManager::get_instance()->get_last_jar_modified_time()) {
            PackedStringArray packed {};
            packed.append("This script has been modified since the last time you built your project.");
            *result = packed;
        } else if (script_ref->_is_abstract()) {
            PackedStringArray packed {};
            packed.append("This script is abstract, so Godot cannot instantiate it.");
            *result = packed;
        } else if (!script_ref->kotlin_class->can_zero_init()) {
            PackedStringArray packed {};
            packed.append("This script has no public zero-argument constructor, so Godot cannot instantiate it.");
            *result = packed;
        } else {
            *result = PackedStringArray();
        }
        r_error->error = GDExtensionCallErrorType::GDEXTENSION_CALL_OK;
        return;
    }

    r_error->error = GDExtensionCallErrorType::GDEXTENSION_CALL_ERROR_INVALID_METHOD;
    *reinterpret_cast<Variant*>(r_return) = Variant();
}

void JvmPlaceHolderInstance::notification(GDExtensionScriptInstanceDataPtr, int32_t, GDExtensionBool) {}

void JvmPlaceHolderInstance::to_string(GDExtensionScriptInstanceDataPtr, GDExtensionBool* r_is_valid, GDExtensionStringPtr r_out) {
    if (r_is_valid) {
        *r_is_valid = false;
    }
    *reinterpret_cast<String*>(r_out) = String();
}

void JvmPlaceHolderInstance::refcount_incremented(GDExtensionScriptInstanceDataPtr) {}

GDExtensionBool JvmPlaceHolderInstance::refcount_decremented(GDExtensionScriptInstanceDataPtr) {
    return true;
}

GDExtensionObjectPtr JvmPlaceHolderInstance::get_script(GDExtensionScriptInstanceDataPtr p_instance) {
    // The engine expects the raw object pointer here, not our godot-cpp wrapper.
    return reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance)->script.ptr()->_owner;
}

GDExtensionBool JvmPlaceHolderInstance::set_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    Ref<Script> script = instance_data->script;
    HashMap<StringName, Variant>& values = instance_data->values;
    List<PropertyInfo>& properties = instance_data->properties;

    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);
    const Variant& parameter_value = *reinterpret_cast<const Variant*>(p_value);

    if (is_placeholder_fallback_enabled(script)) {
        HashMap<StringName, Variant>::Iterator E = values.find(parameter_name);

        if (E) {
            E->value = parameter_value;
        } else {
            values.insert(parameter_name, parameter_value);
        }

        bool found = false;
        for (const PropertyInfo &F : properties) {
            if (F.name == parameter_name) {
                found = true;
                break;
            }
        }
        if (!found) {
            PropertyHint hint = PROPERTY_HINT_NONE;
            const Object *obj = parameter_value.get_validated_object();
            if (obj && obj->is_class("Node")) {
                hint = PROPERTY_HINT_NODE_TYPE;
            }
            properties.push_back(PropertyInfo(parameter_value.get_type(), parameter_name, hint, "", PROPERTY_USAGE_NO_EDITOR | PROPERTY_USAGE_SCRIPT_VARIABLE));
        }
    }

    return false;
}

GDExtensionBool JvmPlaceHolderInstance::get_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret) {
    auto* instance_data = reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance);
    Ref<Script> script = instance_data->script;
    HashMap<StringName, Variant>& constants = instance_data->constants;
    HashMap<StringName, Variant>& values = instance_data->values;

    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);

    auto* r_return = reinterpret_cast<Variant*>(r_ret);

    if (is_placeholder_fallback_enabled(script)) {
        HashMap<StringName, Variant>::ConstIterator E = values.find(parameter_name);

        if (E) {
            *r_return = E->value;
            return true;
        }

        E = constants.find(parameter_name);
        if (E) {
            *r_return = E->value;
            return true;
        }
    }

    *r_return = Variant();
    return false;
}

GDExtensionScriptLanguagePtr JvmPlaceHolderInstance::get_language(GDExtensionScriptInstanceDataPtr p_instance) {
    // The engine expects the raw language pointer here, not our godot-cpp wrapper.
    return reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance)->language->_owner;
}

void JvmPlaceHolderInstance::free(GDExtensionScriptInstanceDataPtr p_instance) {
    memdelete(reinterpret_cast<JvmPlaceHolderInstanceData*>(p_instance));
}

void JvmPlaceHolderInstance::update(
  JvmPlaceHolderInstance::JvmPlaceHolderInstanceData* p_instance_data,
  const List<PropertyInfo>& p_properties,
  const HashMap<StringName, Variant>& p_values
) {
    HashMap<StringName, Variant>& values = p_instance_data->values;
    
    HashSet<StringName> new_values;
    for (const PropertyInfo &E : p_properties) {
        if (E.usage & (PROPERTY_USAGE_GROUP | PROPERTY_USAGE_SUBGROUP | PROPERTY_USAGE_CATEGORY)) {
            continue;
        }
        
        StringName n = E.name;
        new_values.insert(n);

        if (!values.has(n) || (E.type != Variant::NIL && values[n].get_type() != E.type)) {
            if (p_values.has(n)) {
                values[n] = p_values[n];
            }
        }
    }

    p_instance_data->properties = p_properties;
    List<StringName> to_remove;

    Ref<Script>& script = p_instance_data->script;
    for (KeyValue<StringName, Variant> &E : values) {
        if (!new_values.has(E.key)) {
            to_remove.push_back(E.key);
        }

        Variant default_value;
        // Remove because it is the same as the default value.
        if (try_get_property_default_value(script, E.key, default_value) && default_value == E.value) {
            to_remove.push_back(E.key);
        }
    }

    while (to_remove.size()) {
        values.erase(to_remove.front()->get());
        to_remove.pop_front();
    }

    RawObject owner {p_instance_data->owner};
    if (owner && internal::gdextension_interface_object_get_script_instance(owner, p_instance_data->language->_owner) == p_instance_data) {
        owner.notify_property_list_changed();
    }
    //change notify

    HashMap<StringName, Variant>& instance_constants = p_instance_data->constants;
    instance_constants.clear();
    Dictionary constants = Object::cast_to<ScriptExtension>(script.ptr())->_get_constants();
    Array keys = constants.keys();
    for (int i = 0; i < keys.size(); i++) {
        Variant key = keys[i];
        if (key.get_type() == Variant::STRING_NAME || key.get_type() == Variant::STRING) {
            StringName string_key = StringName(key);
            Variant value = constants[key];
            instance_constants.insert(string_key, value);
        }
    }
}

#endif
