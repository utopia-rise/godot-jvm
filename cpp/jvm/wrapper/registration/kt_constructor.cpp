#include "kt_constructor.h"

#include "engine/godot_object.h"
#include "jvm/wrapper/memory/transfer_context.h"

KtConstructor::KtConstructor(jni::Env& p_env, jni::JObject p_wrapped) : JvmInstanceWrapper(p_env, p_wrapped) {}

// Takes the raw engine pointer rather than the godot-cpp wrapper, because that pointer is exactly what has to reach
// Kotlin: it stores whatever we pass as its "native pointer" and hands it straight back on every later self-call
// (TransferContext::icall), which decodes it as a real GodotObject*. A wrapper's address has nothing to do with the
// engine object's. Nothing else here needs a wrapper either.
KtObject* KtConstructor::create_instance(jni::Env& p_env, godot::GodotObject* p_owner) {
    uint64_t id = godot::internal::gdextension_interface_object_get_instance_id(p_owner);
    jvalue args[2] = {jni::to_jni_arg(p_owner), jni::to_jni_arg(id)};
    jni::JObject j_kt_object = wrapped.call_object_method(p_env, CONSTRUCT, args);
    return memnew(KtObject(p_env, j_kt_object, raw_godot::RawObject(p_owner).is_ref_counted()));
}
