#ifndef GODOT_JVM_JVM_BINDING_MANAGER_H
#define GODOT_JVM_JVM_BINDING_MANAGER_H

#include "jvm_binding.h"

#include <gdextension_interface.h>

#include <classes/wrapped.hpp>
#include <cstdint>

namespace godot{
    class JvmBindingManager {
        JvmBindingManager() = default;

        ~JvmBindingManager() = default;

        static GDExtensionInstanceBindingCallbacks _instance_binding_callbacks;

        static void* _instance_binding_create_callback(void* p_token, void* p_instance);

        static void _instance_binding_free_callback(void* p_token, void* p_instance, void* p_binding);

    public:
        JvmBindingManager(JvmBindingManager const& other) = delete;

        JvmBindingManager& operator=(const JvmBindingManager&) = delete;

        // For instance bindings, they are to bind native Godot objects to their JVM wrappers, not for the scripts. Takes the raw engine pointer directly — no godot-cpp wrapper is needed (or created) for any of this; see jvm_binding_manager.cpp for...
        static JvmBinding* set_instance_binding(GodotObject* p_object);

        // Doesn't set the KtObject as it doesn't exist yet, bind_object has be used later.
        static JvmBinding* get_instance_binding(GodotObject* p_object);

        static void free_binding(GodotObject* p_ref);
    };
}

#endif // GODOT_JVM_JVM_BINDING_MANAGER_H
