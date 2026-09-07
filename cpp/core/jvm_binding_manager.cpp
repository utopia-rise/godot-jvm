#include "jvm_binding_manager.h"

#include "engine/godot_object.h"
#include "godot_jvm.h"
#include "jvm/wrapper/memory/memory_manager.h"

#include <core/error_macros.hpp>

using namespace godot;

GDExtensionInstanceBindingCallbacks JvmBindingManager::_instance_binding_callbacks = {
  &_instance_binding_create_callback,
  &_instance_binding_free_callback,
  nullptr
};

void* JvmBindingManager::_instance_binding_create_callback(void* p_token, void* p_instance) {
    JvmBinding* binding = memnew(JvmBinding);
    // p_instance is the raw engine object pointer. Pass it straight through — JvmBinding::init() uses only the raw GDExtension calls, precisely because we're called here while the engine still holds this object's instance-binding mutex (see Jv...
    binding->init(reinterpret_cast<GodotObject*>(p_instance));

    return binding;
}

void JvmBindingManager::_instance_binding_free_callback(void* p_token, void* p_instance, void* p_binding) {
    // Called in the destructor of the Object. It's the very last action done in the destructor so assume variables local to the Object have been cleaned (including script and extension).

    JvmBinding* binding = reinterpret_cast<JvmBinding*>(p_binding);
    // p_instance is the raw engine object pointer (possibly already mid-teardown at this point, per the comment above) — use the ObjectID cached in the binding at init() time instead of wrapping p_instance and calling get_instance_id() on it a...
    if (!binding->get_object_id().is_ref_counted()) { MemoryManager::get_instance().queue_dead_object(binding->get_object_id()); }
    godot::memdelete(binding);
}

JvmBinding* JvmBindingManager::set_instance_binding(GodotObject* p_object) {
    // Godot being weird. Call this function only if the JVM is the creator of the object, otherwise it will crash in case the object has any other bindings.
    raw_godot::RawObject raw_object = raw_godot::RawObject(p_object);
    bool is_rc = raw_object.is_ref_counted();
    if (is_rc) {
        // p_object was just constructed via RawObject::instantiate(), so its refcount is genuinely 0 here — init_ref() (not reference()) is required: reference() refuses to increment a true-zero, never-initialized count (it's meant for objects that already...
        // Must be dropped if RawObject::instantiate() ever moves to classdb_construct_object3, which returns
        // RefCounted instances already at refcount 1 — see the note there.
        raw_godot::RawObject(p_object).init_ref();
    }

    // Attach via the growable get_instance_binding mechanism, not the engine's raw one-shot object_set_instance_binding: that one asserts if binding slot 0 is already occupied, which it always is once godot-cpp's own wrapper binding exists for...
    JvmBinding* binding = reinterpret_cast<JvmBinding*>(
      raw_object.get_instance_binding(&GodotJvm::get_instance(), &_instance_binding_callbacks)
    );

    if (is_rc) { binding->test_and_set_incremented(); }

    return binding;
}

JvmBinding* JvmBindingManager::get_instance_binding(GodotObject* p_object) {
    // Godot being weird but this is how you create a binding if it doesn't exist already, otherwise just retrieve it. Use this function to bind an existing object to the JVM, the callbacks provided will handle the creation of the binding.
    raw_godot::RawObject raw_object = raw_godot::RawObject(p_object);
    JvmBinding* binding = reinterpret_cast<JvmBinding*>(
      raw_object.get_instance_binding(&GodotJvm::get_instance(), &_instance_binding_callbacks)
    );
    if (raw_object.is_ref_counted() && !binding->test_and_set_incremented()) {
        raw_object.reference();
    }
    return binding;
}

void JvmBindingManager::free_binding(GodotObject* p_ref) {
    raw_godot::RawObject(p_ref).free_instance_binding(&GodotJvm::get_instance());
}
