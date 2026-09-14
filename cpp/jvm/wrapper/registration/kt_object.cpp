#include "kt_object.h"

#include "api/script/jvm_instance.h"
#include "core/jvm_binding_manager.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/bridge/bridges_utils.h"
#include "jvm/wrapper/memory/transfer_context.h"
#include "jvm/wrapper/memory/type_manager.h"
#include "logging.h"

#include <classes/ref_counted.hpp>
#include <core/object.hpp>
#include <variant/string_name.hpp>

KtObject::KtObject(jni::JObject p_global_ref) : JvmInstanceWrapper(p_global_ref) {}

KtObject::KtObject(jni::JObject p_weak_ref, jni::JObject p_pin) : JvmInstanceWrapper(p_weak_ref, p_pin) {}

KtObject* KtObject::create_object(jni::Env& p_env, jni::JObject p_local_ref) {
    jni::JObject global_ref = p_local_ref.new_global_ref<jni::JObject>(p_env);
    p_local_ref.delete_local_ref(p_env);
    return memnew(KtObject(global_ref));
}

KtObject* KtObject::create_strong_ref(jni::Env& p_env, jni::JObject p_local_ref) {
    jni::JObject weak_ref = p_local_ref.new_weak_ref<jni::JObject>(p_env);
    jni::JObject pin = p_local_ref.new_global_ref<jni::JObject>(p_env);
    p_local_ref.delete_local_ref(p_env);
    return memnew(KtObject(weak_ref, pin));
}

KtObject* KtObject::create_weak_ref(jni::Env& p_env, jni::JObject p_local_ref) {
    jni::JObject weak_ref = p_local_ref.new_weak_ref<jni::JObject>(p_env);
    p_local_ref.delete_local_ref(p_env);
    return memnew(KtObject(weak_ref, jni::JObject()));
}

void KtObject::script_instance_removed(jni::Env& p_env, uint32_t constructor_index) {
    jvalue args[1] = {jni::to_jni_arg(constructor_index)};
    wrapped.call_void_method(p_env, REMOVE_SCRIPT, args);
}

void KtObject::create_native_object(JNIEnv* p_raw_env, jobject p_instance, jint p_class_index, jlong p_script_ptr) {
    const godot::StringName& class_name = TypeManager::get_instance().get_engine_type_for_index(
        static_cast<int>(p_class_index)
    );
    // Not godot::ClassDB::instantiate(): that forwards to the script-facing ClassDB singleton, which boxes a RefCounted
    // result in a Ref<RefCounted> inside a Variant — converting that straight to Object* and letting the Variant go out
    // of scope...
    godot::GodotObject* raw_ptr_value = raw_godot::RawObject::instantiate(class_name);

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(!raw_ptr_value, "Failed to instantiate class %s", class_name);
#endif

    jni::Env env(p_raw_env);

    // bind_created() works directly on the raw pointer — no godot-cpp wrapper is created (or needed) for any
    // of this. The binding caches the ObjectID, which answers both the RefCounted question and the id sent back below.
    godot::JvmBinding* binding = godot::JvmBindingManager::bind_created(raw_ptr_value);
    bool is_rc = binding->get_object_id().is_ref_counted();

    if (auto* kotlin_script = bridges::from_uint_to_ptr<godot::JvmScript>(p_script_ptr)) {
        KtObject* kt_object = is_rc ? KtObject::create_weak_ref(env, jni::JObject(p_instance))
                                    : KtObject::create_object(env, jni::JObject(p_instance));
        raw_godot::RawObject(raw_ptr_value)
            .set_script_instance(godot::JvmInstance::create_script_instance(raw_ptr_value, kt_object, kotlin_script));
    }

    TransferContext::get_instance()
        .write_object_data(env, reinterpret_cast<uintptr_t>(raw_ptr_value), binding->get_object_id());
}

void KtObject::get_singleton(JNIEnv* p_raw_env, jobject, jint p_class_index) {
    const godot::String& singleton_name = TypeManager::get_instance().get_engine_singleton_name_for_index(
        static_cast<int>(p_class_index)
    );

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

    jni::Env env(p_raw_env);
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
    JVM_ERR_FAIL_COND_MSG(
        raw_godot::RawObject(raw_ptr_value).is_ref_counted(),
        "Can't 'free' a RefCounted godot::Object."
    );
#endif

    raw_godot::RawObject(raw_ptr_value).destroy();
}

KtObject::~KtObject() {
    // Only a RefCounted is given a weak reference, and the JVM does not announce the destruction of one: Godot owns
    // that lifetime and the instance may already be collected.
    if (wrapped_is_weak) { return; }

    jni::Env env = jni::Jvm::current_env();
    wrapped.call_void_method(env, ON_DESTROY);
}
