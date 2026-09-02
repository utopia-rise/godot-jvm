#ifdef TOOLS_ENABLED

#ifndef GODOT_JVM_JVM_PLACEHOLDER_INSTANCE_H
#define GODOT_JVM_JVM_PLACEHOLDER_INSTANCE_H

#include <classes/script.hpp>

#include "engine/godot_object.h"
#include <classes/script_language.hpp>
#include <core/property_info.hpp>
#include <gdextension_interface.h>
#include <templates/hash_map.hpp>
#include <templates/list.hpp>

namespace godot {
    class JvmPlaceHolderInstance {
    public:
        struct JvmPlaceHolderInstanceData {
            raw_godot::RawObject owner;
            List<PropertyInfo> properties;
            HashMap<StringName, Variant> values;
            HashMap<StringName, Variant> constants;
            List<MethodInfo> methods;
            ScriptLanguage* language = nullptr;
            Ref<Script> script;
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
        static void to_string(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionBool* r_is_valid, GDExtensionStringPtr r_out);
        static void refcount_incremented(GDExtensionScriptInstanceDataPtr p_instance);
        static GDExtensionBool refcount_decremented(GDExtensionScriptInstanceDataPtr p_instance);
        static GDExtensionObjectPtr get_script(GDExtensionScriptInstanceDataPtr p_instance);
        static GDExtensionBool set_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionConstVariantPtr p_value);
        static GDExtensionBool get_fallback(GDExtensionScriptInstanceDataPtr p_instance, GDExtensionConstStringNamePtr p_name, GDExtensionVariantPtr r_ret);
        static GDExtensionScriptLanguagePtr get_language(GDExtensionScriptInstanceDataPtr p_instance);
        static void free(GDExtensionScriptInstanceDataPtr p_instance);

    public:
        static constexpr const GDExtensionScriptInstanceInfo3 jvm_placeholder_script_instance_info = {
          .set_func = &JvmPlaceHolderInstance::set,
          .get_func = &JvmPlaceHolderInstance::get,
          .get_property_list_func = &JvmPlaceHolderInstance::get_property_list,
          .free_property_list_func = &JvmPlaceHolderInstance::free_property_list,
          .get_class_category_func = &JvmPlaceHolderInstance::get_class_category,
          .property_can_revert_func = &JvmPlaceHolderInstance::property_can_revert,
          .property_get_revert_func = &JvmPlaceHolderInstance::property_get_revert,
          .get_owner_func = &JvmPlaceHolderInstance::get_owner,
          .get_property_state_func = &JvmPlaceHolderInstance::get_property_state,
          .get_method_list_func = &JvmPlaceHolderInstance::get_method_list,
          .free_method_list_func = &JvmPlaceHolderInstance::free_method_list,
          .get_property_type_func = &JvmPlaceHolderInstance::get_property_type,
          .validate_property_func = &JvmPlaceHolderInstance::validate_property,
          .has_method_func = &JvmPlaceHolderInstance::has_method,
          .get_method_argument_count_func = &JvmPlaceHolderInstance::get_method_argument_count,
          .call_func = &JvmPlaceHolderInstance::call,
          .notification_func = &JvmPlaceHolderInstance::notification,
          .to_string_func = &JvmPlaceHolderInstance::to_string,
          .refcount_incremented_func = &JvmPlaceHolderInstance::refcount_incremented,
          .refcount_decremented_func = &JvmPlaceHolderInstance::refcount_decremented,
          .get_script_func = &JvmPlaceHolderInstance::get_script,
          .is_placeholder_func = nullptr,
          .set_fallback_func = &JvmPlaceHolderInstance::set_fallback,
          .get_fallback_func = &JvmPlaceHolderInstance::get_fallback,
          .get_language_func = &JvmPlaceHolderInstance::get_language,
          .free_func = &JvmPlaceHolderInstance::free
        };

        static void update(JvmPlaceHolderInstanceData* p_instance_data, const List<PropertyInfo> &p_properties, const HashMap<StringName, Variant> &p_values);
    };
} // namespace godot

#endif // GODOT_JVM_JVM_PLACEHOLDER_INSTANCE_H

#endif // TOOLS_ENABLED
