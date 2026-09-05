#include "kt_object.h"

#include "api/script/jvm_instance.h"
#include "jvm/wrapper/bridge/bridges_utils.h"
#include "core/jvm_binding_manager.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/memory/transfer_context.h"

#include <core/object.hpp>
#include <variant/string_name.hpp>

KtObject::KtObject(jni::Env& p_env, jni::JObject p_wrapped, bool p_is_ref) :
  JvmInstanceWrapper(p_env, p_wrapped),
  is_ref(p_is_ref) {}

void KtObject::script_instance_removed(jni::Env& p_env, uint32_t constructor_index) {
    jvalue args[1] = {jni::to_jni_arg(constructor_index)};
    wrapped.call_void_method(p_env, REMOVE_SCRIPT, args);
}

void KtObject::create_native_object(JNIEnv* p_raw_env, jobject p_instance, jint p_class_index, jlong p_script_ptr) {
    const godot::StringName& class_name = TypeManager::get_instance().get_engine_type_for_index(static_cast<int>(p_class_index));
    // Not godot::ClassDB::instantiate(): that forwards to the script-facing ClassDB singleton, which boxes a RefCounted result in a Ref<RefCounted> inside a Variant — converting that straight to Object* and letting the Variant go out of scope...
    godot::GodotObject* raw_ptr_value = raw_godot::RawObject::instantiate(class_name);

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(!raw_ptr_value, "Failed to instantiate class %s", class_name);
#endif

    jni::Env env = p_raw_env;

    // set_instance_binding()/RawObject::is_ref_counted() work directly on the raw pointer — no godot-cpp wrapper is created (or needed) for any of this.
    godot::JvmBindingManager::set_instance_binding(raw_ptr_value);
    bool is_rc = raw_godot::RawObject(raw_ptr_value).is_ref_counted();

    if (auto* kotlin_script = bridges::from_uint_to_ptr<godot::JvmScript>(p_script_ptr)) {
        KtObject* kt_object = memnew(KtObject(env, jni::JObject(p_instance), is_rc));
        auto* instance_data = godot::JvmInstance::create_instance_data(env, raw_ptr_value, kt_object, kotlin_script);
        GDExtensionScriptInstancePtr script_instance = godot::internal::gdextension_interface_script_instance_create3(
          &godot::JvmInstance::jvm_script_instance_info,
          instance_data
        );
        raw_godot::RawObject(raw_ptr_value).set_script_instance(script_instance);
    }

    TransferContext::get_instance().write_object_data(
      env,
      reinterpret_cast<uintptr_t>(raw_ptr_value),
      godot::ObjectID(raw_godot::RawObject(raw_ptr_value).get_instance_id())
    );
}

void KtObject::get_singleton(JNIEnv* p_raw_env, jobject, jint p_class_index) {
    const godot::String& singleton_name = TypeManager::get_instance().get_engine_singleton_name_for_index(static_cast<int>(p_class_index));

    // Deliberately NOT Engine::get_singleton()->get_singleton(name): that returns a godot-cpp wrapper, and
    // materializing one permanently attaches godot-cpp's instance binding to an engine-owned singleton. Godot
    // never clears instance bindings when it unloads an extension at shutdown, and some singletons
    // (GDExtensionManager, Time, ResourceUID, IP) are destroyed *after* the library is unloaded — their
    // ~Object then calls a free callback that lives in unmapped memory and the process segfaults on exit.
    // The JVM only ever needs the raw pointer and the ObjectID, so ask for them directly.
    raw_godot::RawObject raw_singleton = raw_godot::RawObject::get_singleton(godot::StringName(singleton_name));

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(!raw_singleton, "Failed to retrieve engine singleton %s", singleton_name);
#endif

    jni::Env env = p_raw_env;
    TransferContext::get_instance().write_object_data(
      env,
      reinterpret_cast<uintptr_t>(raw_singleton.ptr()),
      godot::ObjectID(raw_singleton.get_instance_id())
    );
}

void KtObject::free_object(JNIEnv*, jobject, jlong p_raw_ptr) {
    // Stays on the raw engine pointer throughout: get_object_instance_binding() would materialize a godot-cpp
    // wrapper (and its instance binding) purely to destroy it one line later, and memdelete() on such a wrapper is
    // itself specialized to forward to object_destroy(_owner) anyway.
    auto* raw_ptr_value = reinterpret_cast<godot::GodotObject*>(static_cast<uintptr_t>(p_raw_ptr));

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(raw_godot::RawObject(raw_ptr_value).is_ref_counted(), "Can't 'free' a RefCounted godot::Object.");
#endif

    raw_godot::RawObject(raw_ptr_value).destroy();
}

KtObject::~KtObject() {
    if (is_ref) { return; }
    jni::Env env = jni::Jvm::current_env();
    wrapped.call_void_method(env, ON_DESTROY);
}
