#include "internal.h"

#include <templates/local_vector.hpp>

namespace godot::internal {
    void convert_property_to_c(const PropertyInfo& p_source, GDExtensionPropertyInfo* p_dest) {
        p_dest->type = static_cast<GDExtensionVariantType>(p_source.type);
        p_dest->name = p_source.name._native_ptr();
        p_dest->hint = p_source.hint;
        p_dest->hint_string = p_source.hint_string._native_ptr();
        p_dest->class_name = p_source.class_name._native_ptr();
        p_dest->usage = p_source.usage;
    }

    GDExtensionPropertyInfo* create_c_property_list(const LocalVector<PropertyInfo>& plist_cpp) {
        const uint32_t plist_size = plist_cpp.size();
        auto* plist = reinterpret_cast<GDExtensionPropertyInfo*>(
            memalloc(sizeof(GDExtensionPropertyInfo) * plist_size)
        );
        uint32_t i = 0;
        for (const PropertyInfo& E : plist_cpp) {
            convert_property_to_c(E, &plist[i]);
            ++i;
        }
        return plist;
    }

    GDExtensionVariantPtr* create_c_default_arguments(const LocalVector<Variant>& p_list) {
        const uint32_t clist_size = p_list.size();
        auto* clist = reinterpret_cast<GDExtensionVariantPtr*>(memalloc(sizeof(GDExtensionVariantPtr) * clist_size));
        uint32_t i = 0;
        for (const Variant& item : p_list) {
            clist[i] = const_cast<Variant*>(&item);
            ++i;
        }
        return clist;
    }

    // The C list keeps the stashed pointer in the allocation's padding, exactly as godot-cpp does for property lists.
    static List<MethodInfo>** stashed_list(void* p_mem) {
        return reinterpret_cast<List<MethodInfo>**>(
            static_cast<uint8_t*>(p_mem) - Memory::DATA_OFFSET + Memory::ELEMENT_OFFSET
        );
    }

    GDExtensionMethodInfo* create_c_method_list(List<MethodInfo>* p_list_cpp, uint32_t* r_size) {
        const uint32_t p_list_size = p_list_cpp->size();

        if (r_size != nullptr) { *r_size = p_list_size; }

        void* mem = Memory::alloc_static(sizeof(GDExtensionMethodInfo) * p_list_size, true);
        *stashed_list(mem) = p_list_cpp;

        auto* c_list = reinterpret_cast<GDExtensionMethodInfo*>(mem);
        uint32_t i = 0;
        for (const MethodInfo& E : *p_list_cpp) {
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
            c_list[i].argument_count = E.arguments.size(), c_list[i].arguments = create_c_property_list(E.arguments);
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

        List<MethodInfo>* list_cpp = *stashed_list(p_list);
        Memory::free_static(p_list, true);
        memdelete(list_cpp);
    }
} // namespace godot::internal
