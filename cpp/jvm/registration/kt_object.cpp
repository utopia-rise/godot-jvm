#include "kt_object.h"

#include "api/script/jvm_instance.h"
#include "compiler.h"
#include "constraints.h"
#include "core/jvm_binding_manager.h"
#include "engine/godot_object.h"
#include "jvm/bridge/bridges_utils.h"
#include "jvm/memory/type_manager.h"
#include "jvm/memory/value_buffer.h"
#include "jvm/memory/variant_buffer.h"
#include "jvm/memory/variant_stack.h"
#include "logging.h"

#include <classes/ref_counted.hpp>
#include <core/object.hpp>
#include <utility>
#include <variant/string_name.hpp>

KtObject::KtObject(jni::JObject p_global_ref) : JvmInstanceWrapper(p_global_ref) {}

KtObject::KtObject(jni::JObject p_weak_ref, jni::JObject p_pin) : JvmInstanceWrapper(p_weak_ref, p_pin) {}

KtObject KtObject::create_object(jni::Env& p_env, jni::JObject p_local_ref) {
    jni::JObject global_ref = p_local_ref.new_global_ref<jni::JObject>(p_env);
    p_local_ref.delete_local_ref(p_env);
    return KtObject(global_ref);
}

KtObject KtObject::create_strong_ref(jni::Env& p_env, jni::JObject p_local_ref) {
    jni::JObject weak_ref = p_local_ref.new_weak_ref<jni::JObject>(p_env);
    jni::JObject pin = p_local_ref.new_global_ref<jni::JObject>(p_env);
    p_local_ref.delete_local_ref(p_env);
    return KtObject(weak_ref, pin);
}

KtObject KtObject::create_weak_ref(jni::Env& p_env, jni::JObject p_local_ref) {
    jni::JObject weak_ref = p_local_ref.new_weak_ref<jni::JObject>(p_env);
    p_local_ref.delete_local_ref(p_env);
    return KtObject(weak_ref, jni::JObject());
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
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    // bind_created() works directly on the raw pointer — no godot-cpp wrapper is created (or needed) for any
    // of this. The binding caches the ObjectID, which answers both the RefCounted question and the id sent back below.
    godot::JvmBinding* binding = godot::JvmBindingManager::bind_created(raw_ptr_value);
    bool is_rc = binding->get_object_id().is_ref_counted();

    if (auto* kotlin_script = bridges::native_or_null<godot::JvmScript>(p_script_ptr)) {
        KtObject kt_object = is_rc ? KtObject::create_weak_ref(env, jni::JObject(p_instance))
                                   : KtObject::create_object(env, jni::JObject(p_instance));
        raw_godot::RawObject(raw_ptr_value)
            .set_script_instance(
                godot::JvmInstance::create_script_instance(raw_ptr_value, std::move(kt_object), kotlin_script)
            );
    }

    transfer->write_object(reinterpret_cast<uintptr_t>(raw_ptr_value), binding->get_object_id());
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

    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    transfer->write_object(
        reinterpret_cast<uintptr_t>(raw_singleton.ptr()),
        godot::ObjectID(raw_singleton.get_instance_id())
    );
}

void KtObject::free_object(JNIEnv*, jobject, jlong p_handle) {
    // Stays on the raw engine pointer throughout: get_object_instance_binding() would materialize a godot-cpp
    // wrapper (and its instance binding) purely to destroy it one line later, and memdelete() on such a wrapper is
    // itself specialized to forward to object_destroy(_owner) anyway.
    auto* raw_ptr_value = reinterpret_cast<godot::GodotObject*>(static_cast<uintptr_t>(p_handle));

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(
        raw_godot::RawObject(raw_ptr_value).is_ref_counted(),
        "Can't 'free' a RefCounted godot::Object."
    );
#endif

    raw_godot::RawObject(raw_ptr_value).destroy();
}

// The caller record every frame starts with: the object the call is made on, followed by its ObjectID. Only a debug
// build looks at that id, checking it against ObjectDB so a call on an already freed object is reported instead of
// dereferencing a dangling pointer.
//
// WALK decides how the record is reached. The general call steps over it, because its argument count sits right after
// and it has to arrive there anyway; a specialised call knows where its own value lies, so it reads the pointer in
// place and leaves the position alone. Outside a debug build neither variant loads the id at all.
template<bool WALK, class View>
static _FORCE_INLINE_ bool read_caller(
    [[maybe_unused]] jni::Env& p_env,
    View* p_view,
    raw_godot::RawObject& r_receiver,
    [[maybe_unused]] ptrdiff_t p_at = 0
) {
    if constexpr (WALK) {
        r_receiver = reinterpret_cast<GDExtensionObjectPtr>(static_cast<uintptr_t>(p_view->template read<uint64_t>()));
    } else {
        r_receiver = reinterpret_cast<GDExtensionObjectPtr>(
            static_cast<uintptr_t>(p_view->template peek<uint64_t>(p_at))
        );
    }

#ifdef DEBUG_ENABLED
    uint64_t receiver_id;
    if constexpr (WALK) {
        receiver_id = p_view->template read<uint64_t>();
    } else {
        receiver_id = p_view->template peek<uint64_t>(p_at + sizeof(uint64_t));
    }
    if (unlikely(r_receiver != raw_godot::RawObject::from_instance_id(receiver_id))) {
        constexpr const char* message = "Cannot call a method on a previously freed instance.";
        JVM_ERR_PRINT("%s", message);
        p_env.throw_new(message);
        return false;
    }
#else
    // Nothing reads the id here, but the general call still has to end up past it.
    if constexpr (WALK) { p_view->reserve(sizeof(uint64_t)); }
#endif
    return true;
}

// Where a specialised frame's own value starts: straight after the caller pointer and its ObjectID. Mirrors
// ValueBuffer.CALLER_SIZE on the JVM side.
static constexpr ptrdiff_t CALLER_SIZE = 2 * sizeof(uint64_t);

JVM_NO_STACK_PROTECTOR void KtObject::icall(JNIEnv* p_raw_env, jclass, jlong p_method_ptr) {
    jni::Env env(p_raw_env);
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    transfer->rewind();

    raw_godot::RawObject receiver;
    if (unlikely(!read_caller<true>(env, transfer, receiver))) { return; }

    uint32_t args_size = transfer->read<uint32_t>();
    JVM_DEV_ASSERT(
        args_size <= MAX_FUNCTION_ARG_COUNT,
        "Cannot have more than %s arguments for a method call but tried to call with %s args",
        MAX_FUNCTION_ARG_COUNT,
        args_size
    );

    GDExtensionMethodBindPtr method_bind = reinterpret_cast<GDExtensionMethodBindPtr>(
        static_cast<uintptr_t>(p_method_ptr)
    );
    GDExtensionCallError r_error = {GDExtensionCallErrorType::GDEXTENSION_CALL_OK, 0, 0};
    godot::Variant ret_value;

    VariantStack::Slots slots = VariantStack::push(args_size);
    if (likely(slots.is_valid())) {
        for (uint32_t i = 0; i < args_size; ++i) {
            slots.args[i] = transfer->decode();
        }
        receiver.call_method_bind(
            method_bind,
            reinterpret_cast<GDExtensionConstVariantPtr*>(slots.args_ptr),
            args_size,
            &ret_value,
            &r_error
        );
        VariantStack::pop(args_size);
    } else {
        godot::Variant args[MAX_FUNCTION_ARG_COUNT];
        const godot::Variant* args_ptr[MAX_FUNCTION_ARG_COUNT];
        for (uint32_t i = 0; i < args_size; ++i) {
            args[i] = transfer->decode();
            args_ptr[i] = &args[i];
        }
        receiver.call_method_bind(
            method_bind,
            reinterpret_cast<GDExtensionConstVariantPtr*>(args_ptr),
            args_size,
            &ret_value,
            &r_error
        );
    }

    transfer->rewind();
    transfer->encode(ret_value);

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(
        r_error.error != GDExtensionCallErrorType::GDEXTENSION_CALL_OK,
        "Call to method bind failed with error %s.",
        static_cast<int>(r_error.error)
    );
#endif
}

// Three specialisations of the ptrcall below, for the shapes the generator can recognise from a signature. Each one
// leaves out what its shape cannot need: no argument count on the wire, no type tag on a value both sides already
// know, no return record for a call that returns nothing, and no argument array for a call that takes nothing.
JVM_NO_STACK_PROTECTOR void KtObject::icall_ptr_simple(
    JNIEnv* p_raw_env,
    jclass,
    jlong p_method_ptr,
    jlong p_base,
    jint p_frame_offset
) {
    jni::Env env(p_raw_env);
    ValueBuffer::Frame frame(reinterpret_cast<uint8_t*>(p_base));

    raw_godot::RawObject receiver;
    if (unlikely(!read_caller<false>(env, &frame, receiver, p_frame_offset))) { return; }

    receiver.ptrcall_method_bind(
        reinterpret_cast<GDExtensionMethodBindPtr>(static_cast<uintptr_t>(p_method_ptr)),
        nullptr,
        nullptr
    );
}

JVM_NO_STACK_PROTECTOR void KtObject::icall_ptr_setter(
    JNIEnv* p_raw_env,
    jclass,
    jlong p_method_ptr,
    jlong p_base,
    jint p_frame_offset,
    jint p_argument_type
) {
    jni::Env env(p_raw_env);
    ValueBuffer::Frame frame(reinterpret_cast<uint8_t*>(p_base));

    raw_godot::RawObject receiver;
    if (unlikely(!read_caller<false>(env, &frame, receiver, p_frame_offset))) { return; }

    const void* arg = frame.read_only_arg(
        static_cast<godot::Variant::Type>(p_argument_type),
        static_cast<ptrdiff_t>(p_frame_offset) + CALLER_SIZE
    );
    receiver.ptrcall_method_bind(
        reinterpret_cast<GDExtensionMethodBindPtr>(static_cast<uintptr_t>(p_method_ptr)),
        &arg,
        nullptr
    );
}

JVM_NO_STACK_PROTECTOR void KtObject::icall_ptr_getter(
    JNIEnv* p_raw_env,
    jclass,
    jlong p_method_ptr,
    jlong p_base,
    jint p_frame_offset,
    jint p_return_type
) {
    jni::Env env(p_raw_env);
    ValueBuffer::Frame frame(reinterpret_cast<uint8_t*>(p_base));

    raw_godot::RawObject receiver;
    if (unlikely(!read_caller<false>(env, &frame, receiver, p_frame_offset))) { return; }

    frame.call_only_ret(
        static_cast<godot::Variant::Type>(p_return_type),
        static_cast<ptrdiff_t>(p_frame_offset) + CALLER_SIZE,
        {receiver, reinterpret_cast<GDExtensionMethodBindPtr>(static_cast<uintptr_t>(p_method_ptr)), nullptr}
    );
}

JVM_NO_STACK_PROTECTOR void KtObject::icall_ptr(
    JNIEnv* p_raw_env,
    jclass,
    jlong p_method_ptr,
    jlong p_base,
    jint p_return_type,
    jint p_frame_offset
) {
    jni::Env env(p_raw_env);
    ValueBuffer::Frame frame(reinterpret_cast<uint8_t*>(p_base), p_frame_offset);

    raw_godot::RawObject receiver;
    if (unlikely(!read_caller<true>(env, &frame, receiver))) { return; }

    uint32_t args_size = frame.read<uint32_t>();
    JVM_DEV_ASSERT(
        args_size <= MAX_FUNCTION_ARG_COUNT,
        "Cannot have more than %s arguments for a method call but tried to call with %s args",
        MAX_FUNCTION_ARG_COUNT,
        args_size
    );

    GDExtensionMethodBindPtr method_bind = reinterpret_cast<GDExtensionMethodBindPtr>(
        static_cast<uintptr_t>(p_method_ptr)
    );

    const void* args[MAX_FUNCTION_ARG_COUNT];
    frame.read_args(args_size, args);

    if (p_return_type == godot::Variant::NIL) {
        receiver.ptrcall_method_bind(method_bind, args, nullptr);
        return;
    }

    frame.call_ret(static_cast<godot::Variant::Type>(p_return_type), {receiver, method_bind, args});
}

KtObject::~KtObject() {
    // Only a RefCounted is given a weak reference, and the JVM does not announce the destruction of one: Godot owns
    // that lifetime and the instance may already be collected. A moved-from wrapper has nothing to announce either.
    if (wrapped_is_weak || wrapped.is_null()) { return; }

    jni::Env& env = jni::Jvm::current_env();
    wrapped.call_void_method(env, ON_DESTROY);
}
