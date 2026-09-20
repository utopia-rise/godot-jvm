#ifndef GODOT_JVM_INTERNAL_H
#define GODOT_JVM_INTERNAL_H

#include <gdextension_interface.h>

#include <core/object.hpp>
#include <templates/list.hpp>
#include <variant/string_name.hpp>

namespace godot::internal {
    void convert_property_to_c(const PropertyInfo& p_source, GDExtensionPropertyInfo* p_dest);
    GDExtensionMethodInfo* create_c_method_list(List<MethodInfo>* p_list_cpp, uint32_t* r_size);
    void free_c_method_list(GDExtensionMethodInfo* p_list, uint32_t p_count);

    // A StringName is an eight byte handle on a name the engine interns, so two of them holding the same name always
    // hold the same handle. Comparing or hashing them goes through the engine, one ptrcall each; comparing the handles
    // does not, which is what makes these worth having on a path taken once per script call.
    //
    // The engine drops an interned entry once the last StringName on it is gone, and hands the block to the next name.
    // A handle is therefore only meaningful while something holds the name: reading one from a temporary and using it
    // in the same expression is fine, storing one that outlives the name it came from is not, and silently so, because
    // the stale handle goes on comparing equal to whatever was interned next.
    _FORCE_INLINE_ const void* identity(const StringName& p_name) {
        return *reinterpret_cast<const void* const*>(p_name._native_ptr());
    }

    _FORCE_INLINE_ bool same_name(const StringName& p_left, const StringName& p_right) {
        return identity(p_left) == identity(p_right);
    }
} // namespace godot::internal

#endif // GODOT_JVM_INTERNAL_H
