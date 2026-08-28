#ifndef GODOT_JVM_JVM_INSTANCE_H
#define GODOT_JVM_JVM_INSTANCE_H

#include "core/jvm_binding_manager.h"
#include "engine/internal.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/jvm_singleton_wrapper.h"
#include "jvm/wrapper/registration/kt_class.h"
#include "jvm_script.h"

namespace godot {

    class JvmInstance {
    public:
        struct JvmInstanceData {
            GodotObject* owner;
            KtObject* kt_object;
            KtClass* kt_class;
            Ref<JvmScript> script;
            List<MethodInfo> method_list;
            SafeFlag to_demote_flag;
            bool delete_flag;
        };

    private:
        static GDExtensionBool set(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value);
        static GDExtensionBool get(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret);
        static const GDExtensionPropertyInfo* get_property_list(GDExtensionScriptInstanceDataPtr p_instance, uint32_t* r_count);
        static void free_property_list(GDExtensionScriptInstanceDataPtr p_instance, const GDExtensionPropertyInfo* p_list, uint32_t p_count);
        static GDExtensionBool get_class_category(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionPropertyInfo* p_class_category);
        static GDExtensionBool property_can_revert(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name);
        static GDExtensionBool property_get_revert(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret);
        static GDExtensionObjectPtr get_owner(GDExtensionScriptInstanceDataPtr p_instance);
        static void get_property_state(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionScriptInstancePropertyStateAdd p_add_func, void* p_userdata);
        static const GDExtensionMethodInfo* get_method_list(GDExtensionScriptInstanceDataPtr p_instance, uint32_t* r_count);
        static void free_method_list(GDExtensionScriptInstanceDataPtr p_instance, const GDExtensionMethodInfo* p_list, uint32_t p_count);
        static GDExtensionVariantType get_property_type(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionBool* r_is_valid);
        static GDExtensionBool validate_property(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionPropertyInfo* p_property);
        static GDExtensionBool has_method(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name);
        static GDExtensionInt get_method_argument_count(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionBool* r_is_valid);
        static void call(
          GDExtensionScriptInstanceDataPtr p_instance,
          GDExtensionConstStringNamePtr p_method,
          const GDExtensionConstVariantPtr* p_args,
          GDExtensionInt p_argument_count,
          GDExtensionVariantPtr r_return,
          GDExtensionCallError* r_error
        );
        static void notification(GDExtensionScriptInstanceDataPtr p_instance, int32_t p_what, GDExtensionBool p_reversed);
        static void to_string(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionBool *r_is_valid, GDExtensionStringPtr r_out);
        static void refcount_incremented(GDExtensionScriptInstanceDataPtr p_instance);
        static GDExtensionBool refcount_decremented(GDExtensionScriptInstanceDataPtr p_instance);
        static GDExtensionObjectPtr get_script(GDExtensionScriptInstanceDataPtr p_instance);
        static GDExtensionBool set_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value);
        static GDExtensionBool get_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret);
        static GDExtensionScriptLanguagePtr get_language(GDExtensionScriptInstanceDataPtr p_instance);
        static void free(GDExtensionScriptInstanceDataPtr p_instance);

    public:
        static constexpr GDExtensionScriptInstanceInfo3 jvm_script_instance_info = {
          .set_func = &JvmInstance::set,
          .get_func = &JvmInstance::get,
          .get_property_list_func = &JvmInstance::get_property_list,
          .free_property_list_func = &JvmInstance::free_property_list,
          .get_class_category_func = &JvmInstance::get_class_category,
          .property_can_revert_func = &JvmInstance::property_can_revert,
          .property_get_revert_func = &JvmInstance::property_get_revert,
          .get_owner_func = &JvmInstance::get_owner,
          .get_property_state_func = &JvmInstance::get_property_state,
          .get_method_list_func = &JvmInstance::get_method_list,
          .free_method_list_func = &JvmInstance::free_method_list,
          .get_property_type_func = &JvmInstance::get_property_type,
          .validate_property_func = &JvmInstance::validate_property,
          .has_method_func = &JvmInstance::has_method,
          .get_method_argument_count_func = &JvmInstance::get_method_argument_count,
          .call_func = &JvmInstance::call,
          .notification_func = &JvmInstance::notification,
          .to_string_func = &JvmInstance::to_string,
          .refcount_incremented_func = &JvmInstance::refcount_incremented,
          .refcount_decremented_func = &JvmInstance::refcount_decremented,
          .get_script_func = &JvmInstance::get_script,
          .is_placeholder_func = nullptr,
          .set_fallback_func = &JvmInstance::set_fallback,
          .get_fallback_func = &JvmInstance::get_fallback,
          .get_language_func = &JvmInstance::get_language,
          .free_func = &JvmInstance::free
        };

        static void promote_reference(JvmInstanceData* instance_data);
        static void demote_reference(JvmInstanceData* instance_data);

        static JvmInstanceData* create_instance_data(jni::Env& p_env, GodotObject* p_owner, KtObject* p_kt_object, const JvmScript* p_script);

#ifdef TOOLS_ENABLED
        static bool get_or_default(JvmInstanceData* instance_data, const StringName& p_name, Variant& r_ret);
#endif
    };
}
#endif// GODOT_JVM_JVM_INSTANCE_H
