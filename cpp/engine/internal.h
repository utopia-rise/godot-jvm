#ifndef GODOT_JVM_INTERNAL_H
#define GODOT_JVM_INTERNAL_H

#include "core/object.hpp"

#include <gdextension_interface.h>

#include <templates/list.hpp>

namespace godot::internal {
    void convert_property_to_c(const ::godot::PropertyInfo& p_source, GDExtensionPropertyInfo* p_dest);
    GDExtensionMethodInfo* create_c_method_list(const ::godot::List<::godot::MethodInfo>& p_list_cpp, uint32_t* r_size);
    void free_c_method_list(GDExtensionMethodInfo* p_list, uint32_t p_count);
} // namespace godot::internal

#endif // GODOT_JVM_INTERNAL_H
