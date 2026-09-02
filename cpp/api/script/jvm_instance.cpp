#include "jvm_instance.h"

#include "engine/godot_object.h"

#include "jvm/wrapper/memory/memory_manager.h"

using namespace godot;

GDExtensionBool JvmInstance::set(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;

    jni::LocalFrame localFrame(1000);
    jni::Env env {jni::Jvm::current_env()};
    Variant value {p_value};

    if (KtProperty* ktProperty {kt_class->get_property(*reinterpret_cast<const StringName*>(p_name))}) {
        ktProperty->call_set(env, kt_object, value);
        return true;
    }

    if (KtFunction* function {kt_class->get_method(SNAME("_set"))}) {
        Variant ret;
        const int arg_count = 2;
        Variant name {*reinterpret_cast<const StringName*>(p_name)};
        const Variant* args[arg_count] {&name, &value};
        function->invoke(env, kt_object, args, arg_count, ret);
        return true;
    }

    return false;
}

GDExtensionBool JvmInstance::get(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;
    GodotObject* owner = instance_data->owner;
    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);
    Variant& r_return = *reinterpret_cast<Variant*>(r_ret);


    jni::LocalFrame localFrame(1000);
    jni::Env env {jni::Jvm::current_env()};

    KtProperty* ktProperty {kt_class->get_property(parameter_name)};
    if (ktProperty) {
        ktProperty->call_get(env, kt_object, r_return);
        return true;
    }

    KtSignalInfo* kt_signal {kt_class->get_signal(parameter_name)};
    if (kt_signal) {
        r_return = raw_godot::RawObject(owner).to_signal(parameter_name);
        return true;
    }

    if (KtFunction* function {kt_class->get_method(SNAME("_get"))}) {
        const int arg_count = 1;
        Variant name = parameter_name;
        const Variant* args[arg_count] = {&name};
        function->invoke(env, kt_object, args, arg_count, r_return);
        return true;
    }

    return false;
}

const GDExtensionPropertyInfo* JvmInstance::get_property_list(GDExtensionScriptInstanceDataPtr p_instance, uint32_t* r_count) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;

    // The property-list bridge owns this freshly allocated list and frees it later.
    List<PropertyInfo>* properties = memnew(List<PropertyInfo>);
    kt_class->get_property_list(properties);
    jni::Env env {jni::Jvm::current_env()};

    if (KtFunction* function {kt_class->get_method(SNAME("_get_property_list"))}) {
        Variant ret_var;
        function->invoke(env, kt_object, {}, 0, ret_var);
        Array ret_array = ret_var;
        for (int i = 0; i < ret_array.size(); ++i) {
            properties->push_back(PropertyInfo::from_dict(ret_array.get(i)));
        }
    }

    return internal::create_c_property_list(properties, r_count);
}

void JvmInstance::free_property_list(GDExtensionScriptInstanceDataPtr p_instance, const GDExtensionPropertyInfo* p_list, uint32_t p_count) {
    internal::free_c_property_list(const_cast<GDExtensionPropertyInfo*>(p_list));
}

GDExtensionBool JvmInstance::get_class_category(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionPropertyInfo* p_class_category) {
    return false;
}

GDExtensionBool JvmInstance::property_can_revert(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;
    const StringName& property_name = *reinterpret_cast<const StringName*>(p_name);

    jni::Env env {jni::Jvm::current_env()};

    if (KtFunction* function {kt_class->get_method(SNAME("_property_can_revert"))}) {
        const int arg_count = 1;
        Variant ret;
        Variant name = property_name;
        const Variant* args[arg_count] = {&name};
        function->invoke(env, kt_object, args, arg_count, ret);
        return ret.operator bool();
    }

    return false;
}

GDExtensionBool JvmInstance::property_get_revert(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;
    Variant& r_return = *reinterpret_cast<Variant*>(r_ret);

    jni::Env env {jni::Jvm::current_env()};

    if (KtFunction* function {kt_class->get_method(SNAME("_property_get_revert"))}) {
        const int arg_count = 1;
        Variant name = p_name;
        const Variant* args[arg_count] = {&name};
        function->invoke(env, kt_object, args, arg_count, r_return);
        return true;
    }

    return false;
}

GDExtensionObjectPtr JvmInstance::get_owner(GDExtensionScriptInstanceDataPtr p_instance) {
    // The engine expects the raw object pointer here, not our godot-cpp wrapper.
    return reinterpret_cast<JvmInstanceData*>(p_instance)->owner;
}

//TODO: Remove when https://github.com/godotengine/godot/pull/105896 is released
void JvmInstance::get_property_state(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionScriptInstancePropertyStateAdd p_add_func, void* p_userdata) {
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

//TODO: Do the conversion within ktClass
const GDExtensionMethodInfo* JvmInstance::get_method_list(GDExtensionScriptInstanceDataPtr p_instance, uint32_t* r_count) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;

    List<MethodInfo>& methods = instance_data->method_list;
    JVM_ERR_FAIL_COND_V_MSG(!methods.is_empty(), nullptr, "Internal error, method list was not freed by engine");

    kt_class->get_method_list(&methods);
    return internal::create_c_method_list(methods, r_count);
}

void JvmInstance::free_method_list(GDExtensionScriptInstanceDataPtr p_instance, const GDExtensionMethodInfo* p_list, uint32_t p_count) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    instance_data->method_list.clear();
    internal::free_c_method_list(const_cast<GDExtensionMethodInfo*>(p_list), p_count);
}

GDExtensionVariantType JvmInstance::get_property_type(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionBool* r_is_valid) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    const StringName& parameter_name = *reinterpret_cast<const StringName*>(p_name);

    if (KtProperty* kt_property = kt_class->get_property(parameter_name)) {
        *r_is_valid = true;
        return (GDExtensionVariantType) kt_property->get_member_info().type;
    }

    *r_is_valid = false;
    return GDExtensionVariantType::GDEXTENSION_VARIANT_TYPE_NIL;
}

GDExtensionBool JvmInstance::validate_property(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionPropertyInfo* p_property) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;

    jni::Env env {jni::Jvm::current_env()};

    if (KtFunction* function {kt_class->get_method(SNAME("_validate_property"))}) {
        Variant ret_var;
        PropertyInfo converted;
        converted.type = (Variant::Type) p_property->type;
        converted.name = *reinterpret_cast<StringName*>(p_property->name);
        converted.class_name = *reinterpret_cast<StringName*>(p_property->class_name);
        converted.hint = p_property->hint;
        converted.hint_string = *reinterpret_cast<String*>(p_property->hint_string);
        converted.usage = p_property->usage;
        Variant property_arg = (Dictionary) converted;
        const int arg_count {1};
        const Variant* args[arg_count] = {&property_arg};
        function->invoke(env, kt_object, args, arg_count, ret_var);
        internal::convert_property_to_c(PropertyInfo::from_dict(property_arg), p_property);
        return true;
    }

    return false;
}

GDExtensionBool JvmInstance::has_method(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;

    return kt_class->get_method(*reinterpret_cast<const StringName*>(p_name)) != nullptr;
}

GDExtensionInt JvmInstance::get_method_argument_count(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionBool* r_is_valid) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;

    if (KtFunction* method = kt_class->get_method(*reinterpret_cast<const StringName*>(p_name))) {
        *r_is_valid = true;
        return method->get_parameter_count();
    }

    *r_is_valid = false;
    return -1;
}

void JvmInstance::call(
  GDExtensionScriptInstanceDataPtr p_instance,
  GDExtensionConstStringNamePtr p_method,
  const GDExtensionConstVariantPtr* p_args,
  GDExtensionInt p_argument_count,
  GDExtensionVariantPtr r_return,
  GDExtensionCallError* r_error
) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;

    jni::Env env {jni::Jvm::current_env()};

    if (KtFunction* function {kt_class->get_method(*reinterpret_cast<const StringName*>(p_method))}) {
        auto* arguments = reinterpret_cast<const Variant* const*>(p_args);
        Variant& r_ret = *reinterpret_cast<Variant*>(r_return);
        function->invoke(env, kt_object, const_cast<const Variant**>(arguments), static_cast<int>(p_argument_count), r_ret);
        r_error->error = GDExtensionCallErrorType::GDEXTENSION_CALL_OK;
    } else {
        r_error->error = GDExtensionCallErrorType::GDEXTENSION_CALL_ERROR_INVALID_METHOD;
    }
}

void JvmInstance::notification(GDExtensionScriptInstanceDataPtr p_instance, int32_t p_what, GDExtensionBool p_reversed) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;

    if (p_what == Object::NOTIFICATION_PREDELETE) { instance_data->delete_flag = false; }

    jni::Env env {jni::Jvm::current_env()};
    kt_class->do_notification(env, instance_data->kt_object, p_what, p_reversed);
}

void JvmInstance::to_string(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionBool* r_is_valid, GDExtensionStringPtr r_out) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtClass* kt_class = instance_data->kt_class;
    KtObject* kt_object = instance_data->kt_object;

    jni::Env env {jni::Jvm::current_env()};

    if (KtFunction* function {kt_class->get_method(SNAME("_to_string"))}) {
        const int arg_count = 0;
        Variant ret;
        function->invoke(env, kt_object, nullptr, arg_count, ret);
        *r_is_valid = true;
        *reinterpret_cast<String*>(r_out) = ret;
        return;
    }
    *r_is_valid = false;
}

void JvmInstance::refcount_incremented(GDExtensionScriptInstanceDataPtr p_instance) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtObject* kt_object = instance_data->kt_object;

    // This function should only ever be called for a RefCounted, so the count can be read straight off the raw pointer.
    int refcount = raw_godot::RawObject(instance_data->owner).get_reference_count();

    if (refcount > 1 && kt_object->is_ref_weak()) {
        // The JVM holds a reference to that object already, if the counter is greater than 1, it means the native side holds a reference as well. The reference is changed to a strong one so the JVM instance is not collected if it is not referenced...
        MemoryManager::get_instance().try_promotion(instance_data);
    }
}

GDExtensionBool JvmInstance::refcount_decremented(GDExtensionScriptInstanceDataPtr p_instance) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);

    // This function should only ever be called for a RefCounted, so the count can be read straight off the raw pointer.
    int refcount = raw_godot::RawObject(instance_data->owner).get_reference_count();

    if (refcount == 1) {
        // The JVM holds a reference to that object already, if the counter is equal to 1, it means the JVM is the only side with a reference to the object. The reference is changed to a weak one so the JVM instance can be collected if it is not re...
        if (!instance_data->to_demote_flag.is_set()) {
            MemoryManager::get_instance().queue_demotion(instance_data);
            instance_data->to_demote_flag.set();
        }
    }
    // Return true when the counter is 0, it means that the JVM and the native side are no longer using the reference, so it can be safely deleted.
    return refcount == 0;
}

GDExtensionObjectPtr JvmInstance::get_script(GDExtensionScriptInstanceDataPtr p_instance) {
    // The engine expects the raw object pointer here, not our godot-cpp wrapper.
    return reinterpret_cast<JvmInstanceData*>(p_instance)->script.ptr()->_owner;
}

GDExtensionBool JvmInstance::set_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value) {
    return false;
}

GDExtensionBool JvmInstance::get_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret) {
    *reinterpret_cast<Variant*>(r_ret) = Variant();
    return false;
}

GDExtensionScriptLanguagePtr JvmInstance::get_language(GDExtensionScriptInstanceDataPtr p_instance) {
    // The engine compares this raw language pointer with object_get_script_instance() results.
    return reinterpret_cast<JvmInstanceData*>(p_instance)->script->_get_language()->_owner;
}

void JvmInstance::free(GDExtensionScriptInstanceDataPtr p_instance) {
    auto* instance_data = reinterpret_cast<JvmInstanceData*>(p_instance);
    KtObject* kt_object = instance_data->kt_object;

    jni::Env env {jni::Jvm::current_env()};
    if (instance_data->delete_flag) {
        kt_object->script_instance_removed(
          env,
          JvmBindingManager::get_instance_binding(instance_data->owner)->get_constructor_id()
        );
    }
    if (instance_data->to_demote_flag.is_set()) {
        MemoryManager::get_instance().cancel_demotion(instance_data);
    }
    memdelete(kt_object);
    memdelete(instance_data);
}

void JvmInstance::promote_reference(JvmInstance::JvmInstanceData* instance_data) {
    KtObject* kt_object = instance_data->kt_object;

    if (kt_object->is_ref_weak()) {
        jni::Env env {jni::Jvm::current_env()};
        kt_object->swap_to_strong_unsafe(env);
    }
}

void JvmInstance::demote_reference(JvmInstance::JvmInstanceData* instance_data) {
    int refcount = raw_godot::RawObject(instance_data->owner).get_reference_count();

    KtObject* kt_object = instance_data->kt_object;

    if (refcount == 1 && !kt_object->is_ref_weak()) {
        jni::Env env {jni::Jvm::current_env()};
        kt_object->swap_to_weak_unsafe(env);
    }

    instance_data->to_demote_flag.clear();
}

JvmInstance::JvmInstanceData* JvmInstance::create_instance_data(jni::Env& p_env, GodotObject* p_owner, KtObject* p_kt_object, const JvmScript* p_script) {
    JvmInstanceData* instance_data = memnew(JvmInstanceData);
    instance_data->owner = p_owner;
    instance_data->kt_object = p_kt_object;
    instance_data->kt_class = p_script->kotlin_class;
    instance_data->script = Ref<JvmScript>(p_script);
    instance_data->to_demote_flag.set_to(false);
    instance_data->delete_flag = true;

    if (!raw_godot::RawObject(p_owner).is_ref_counted()) { return instance_data; }

    int refcount = raw_godot::RawObject(p_owner).get_reference_count();

    if (refcount == 1 && !p_kt_object->is_ref_weak()) {
        // The JVM holds a reference to that object already, if the counter is equal to 1, it means the JVM is the only side with a reference to the object. The reference is changed to a weak one so the JVM instance can be collected if it is not re...
        p_kt_object->swap_to_weak_unsafe(p_env);
    }

    return instance_data;
}

#ifdef TOOLS_ENABLED
bool JvmInstance::get_or_default(JvmInstance::JvmInstanceData* instance_data, const StringName& p_name, Variant& r_ret) {
    jni::LocalFrame localFrame(1000);
    jni::Env env {jni::Jvm::current_env()};

    KtProperty* ktProperty {instance_data->kt_class->get_property(p_name)};
    if (ktProperty) {
        ktProperty->call_get(env, instance_data->kt_object, r_ret);
        return true;
    } else {
        return false;
    }
}
#endif
