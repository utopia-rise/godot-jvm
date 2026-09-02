#include "internal.h"

#include <templates/local_vector.hpp>

using namespace godot;

namespace godot::internal {
    void convert_property_to_c(const ::godot::PropertyInfo& p_source, GDExtensionPropertyInfo* p_dest) {
        p_dest->type = static_cast<GDExtensionVariantType>(p_source.type);
        p_dest->name = p_source.name._native_ptr();
        p_dest->hint = p_source.hint;
        p_dest->hint_string = p_source.hint_string._native_ptr();
        p_dest->class_name = p_source.class_name._native_ptr();
        p_dest->usage = p_source.usage;
    }

    GDExtensionPropertyInfo* create_c_property_list(const ::godot::LocalVector<::godot::PropertyInfo> &plist_cpp) {
        const uint32_t plist_size = plist_cpp.size();
        auto* plist = reinterpret_cast<GDExtensionPropertyInfo*>(memalloc(sizeof(GDExtensionPropertyInfo) * plist_size));
        uint32_t i = 0;
        for (const ::godot::PropertyInfo &E : plist_cpp) {
            convert_property_to_c(E, &plist[i]);
            ++i;
        }
        return plist;
    }

    GDExtensionVariantPtr* create_c_default_arguments(const ::godot::LocalVector<godot::Variant>& p_list) {
        const uint32_t clist_size = p_list.size();
        auto* clist = reinterpret_cast<GDExtensionVariantPtr*>(memalloc(sizeof(GDExtensionVariantPtr) * clist_size));
        uint32_t i = 0;
        for (const godot::Variant& item : p_list) {
            clist[i] = const_cast<godot::Variant*>(&item);
            ++i;
        }
        return clist;
    }

    GDExtensionMethodInfo* create_c_method_list(const ::godot::List<::godot::MethodInfo>& p_list_cpp, uint32_t* r_size) {
        GDExtensionMethodInfo* c_list = nullptr;

        const uint32_t p_list_size = p_list_cpp.size();

        if (r_size != nullptr) {
            *r_size = p_list_size;
        }

        c_list = reinterpret_cast<GDExtensionMethodInfo*>(memalloc(sizeof(GDExtensionMethodInfo) * p_list_size));
        uint32_t i = 0;
        for (const ::godot::MethodInfo& E : p_list_cpp) {
            c_list[i].name = E.name._native_ptr();
            c_list[i].return_value = GDExtensionPropertyInfo {
              .type = static_cast<GDExtensionVariantType>(E.return_val.type),
              .name = E.return_val.name._native_ptr(),
              .class_name = E.return_val.class_name._native_ptr(),
              .hint = E.return_val.hint,
              .hint_string = E.return_val.hint_string._native_ptr(),
              .usage = E.return_val.usage
            };
            c_list[i].flags = E.flags;
            c_list[i].id = E.id;
            c_list[i].argument_count = E.arguments.size(),
            c_list[i].arguments = create_c_property_list(E.arguments);
            c_list[i].default_argument_count = E.default_arguments.size();
            c_list[i].default_arguments = create_c_default_arguments(E.default_arguments);
            ++i;
        }

        return c_list;
    }

    void free_c_method_list(GDExtensionMethodInfo* p_list, uint32_t p_count) {
        for (uint32_t i = 0; i < p_count; ++i) {
            memfree(p_list[i].arguments);
            memfree(p_list[i].default_arguments);
        }

        memfree(p_list);
    }
} // namespace godot::internal