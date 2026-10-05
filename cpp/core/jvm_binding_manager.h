#ifndef GODOT_JVM_JVM_BINDING_MANAGER_H
#define GODOT_JVM_JVM_BINDING_MANAGER_H

#include "jvm_binding.h"

#include <gdextension_interface.h>

#include <classes/wrapped.hpp>
#include <cstdint>

namespace godot {
    class JvmBindingManager {
        JvmBindingManager() = default;

        ~JvmBindingManager() = default;

        static GDExtensionInstanceBindingCallbacks _instance_binding_callbacks;

        static void* _instance_binding_create_callback(void* p_token, void* p_instance);

        static void _instance_binding_free_callback(void* p_token, void* p_instance, void* p_binding);

    public:
        JvmBindingManager(JvmBindingManager const& other) = delete;

        JvmBindingManager& operator=(const JvmBindingManager&) = delete;

        // Delivery of an object to the JVM. Creates the binding on first sight and takes the JVM's native reference
        // on a RefCounted. Takes the raw engine pointer: no godot-cpp wrapper is needed or created for any of this.
        static JvmBinding* bind(GodotObject* p_object);

        // Same for an object the JVM itself just instantiated, whose reference count is not initialized yet.
        static JvmBinding* bind_created(GodotObject* p_object);

        // Release protocol, see MemoryManager::sync_memory. A binding on a RefCounted owns one native reference:
        // unbinding drops it.
        static uint32_t get_deliveries(GodotObject* p_object);
        static void unbind(GodotObject* p_object);
        static void unbind_unless_delivered_since(GodotObject* p_object, uint32_t p_deliveries);
    };
} // namespace godot

#endif // GODOT_JVM_JVM_BINDING_MANAGER_H
