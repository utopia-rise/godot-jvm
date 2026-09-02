#ifndef GODOT_JVM_DYNAMIC_LIBRARY_H
#define GODOT_JVM_DYNAMIC_LIBRARY_H

#include <classes/global_constants.hpp>
#include <variant/string.hpp>

// godot-cpp exposes no public equivalent to the engine-internal OS::open_dynamic_library /
// OS::close_dynamic_library / OS::get_dynamic_library_symbol_handle, so this loads/queries
// the JVM shared library directly through the native OS API instead of going through Godot.
namespace godot_jvm_native {
    godot::Error open_dynamic_library(const godot::String& p_path, void*& r_library_handle);
    godot::Error close_dynamic_library(void* p_library_handle);
    godot::Error get_dynamic_library_symbol_handle(void* p_library_handle, const char* p_symbol_name, void*& r_symbol_handle);
} // namespace godot_jvm_native

#endif // GODOT_JVM_DYNAMIC_LIBRARY_H
