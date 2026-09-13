#include "jvm_binding_manager.h"

#include "engine/godot_object.h"
#include "godot_jvm.h"
#include "jvm/wrapper/memory/memory_manager.h"

using namespace godot;

GDExtensionInstanceBindingCallbacks JvmBindingManager::_instance_binding_callbacks = {
    &_instance_binding_create_callback,
    &_instance_binding_free_callback,
    nullptr
};

void* JvmBindingManager::_instance_binding_create_callback(void* p_token, void* p_instance) {
    JvmBinding* binding = memnew(JvmBinding);
    // p_instance is the raw engine object pointer. Pass it straight through — JvmBinding::init() uses only the raw
    // GDExtension calls, precisely because we're called here while the engine still holds this object's
    // instance-binding mutex (see Jv...
    binding->init(reinterpret_cast<GodotObject*>(p_instance));

    return binding;
}

void JvmBindingManager::_instance_binding_free_callback(void* p_token, void* p_instance, void* p_binding) {
    // Called in the destructor of the Object. It's the very last action done in the destructor so assume variables
    // local to the Object have been cleaned (including script and extension).

    JvmBinding* binding = reinterpret_cast<JvmBinding*>(p_binding);
    if (!binding->get_object_id().is_ref_counted()) {
        MemoryManager::get_instance().queue_dead_object(binding->get_object_id());
    }
    godot::memdelete(binding);
}

JvmBinding* JvmBindingManager::bind_created(GodotObject* p_object) {
    // Attach via the growable get_instance_binding mechanism, not the engine's raw one-shot
    // object_set_instance_binding: that one asserts if binding slot 0 is already occupied, which it always is once
    // godot-cpp's own wrapper binding exists for the object.
    JvmBinding* binding = reinterpret_cast<JvmBinding*>(
        raw_godot::RawObject(p_object).get_instance_binding(&GodotJvm::get_instance(), &_instance_binding_callbacks)
    );

    if (binding->get_object_id().is_ref_counted()) {
        // p_object was just constructed via RawObject::instantiate(), so its refcount is genuinely 0 here — init_ref()
        // (not reference()) is required: reference() refuses to increment a true-zero, never-initialized count (it's
        // meant for objects that already... Must be dropped if RawObject::instantiate() ever moves to
        // classdb_construct_object3, which returns RefCounted instances already at refcount 1 — see the note there.
        raw_godot::RawObject(p_object).init_ref();
        binding->record_delivery();
    }

    return binding;
}

JvmBinding* JvmBindingManager::bind(GodotObject* p_object) {
    raw_godot::RawObject raw_object(p_object);
    JvmBinding* binding = reinterpret_cast<JvmBinding*>(
        raw_object.get_instance_binding(&GodotJvm::get_instance(), &_instance_binding_callbacks)
    );
    if (binding->get_object_id().is_ref_counted() && binding->record_delivery() == 0) { raw_object.reference(); }
    return binding;
}

static JvmBinding* find_binding(raw_godot::RawObject p_object) {
    return reinterpret_cast<JvmBinding*>(p_object.get_instance_binding(&GodotJvm::get_instance(), nullptr));
}

static void unbind(raw_godot::RawObject p_object, JvmBinding* p_binding) {
    bool is_ref_counted = p_binding->get_object_id().is_ref_counted();
    p_object.free_instance_binding(&GodotJvm::get_instance());
    if (is_ref_counted && p_object.unreference()) { p_object.destroy(); }
}

uint32_t JvmBindingManager::get_deliveries(GodotObject* p_object) {
    JvmBinding* binding = find_binding(p_object);
    return binding != nullptr ? binding->get_deliveries() : 0;
}

void JvmBindingManager::unbind(GodotObject* p_object) {
    JvmBinding* binding = find_binding(p_object);
    if (binding != nullptr) { ::unbind(p_object, binding); }
}

void JvmBindingManager::unbind_unless_delivered_since(GodotObject* p_object, uint32_t p_deliveries) {
    JvmBinding* binding = find_binding(p_object);
    if (binding != nullptr && binding->get_deliveries() == p_deliveries) { ::unbind(p_object, binding); }
}
