#include "transfer_context.h"

#include "api/script/jvm_instance.h"
#include "constraints.h"
#include "jvm/ptr_converter.h"
#include "jvm/variant_stack.h"
#include "logging.h"

#include <core/object.hpp>

static thread_local SharedBuffer shared_buffer;

TransferContext::~TransferContext() = default;

SharedBuffer* TransferContext::get_and_rewind_buffer(jni::Env& p_env) {
    if (unlikely(!shared_buffer.is_init())) {
        jni::JObject buffer = wrapped.call_object_method(p_env, GET_BUFFER);
        JVM_DEV_ASSERT(!buffer.is_null(), "Buffer is null");
        auto* address = static_cast<uint8_t*>(p_env.get_direct_buffer_address(buffer));
#ifdef DEBUG_ENABLED
        shared_buffer = SharedBuffer(address, 0, p_env.get_direct_buffer_capacity(buffer));
#else
        shared_buffer = SharedBuffer(address, 0);
#endif
        buffer.delete_local_ref(p_env);
    }
    shared_buffer.rewind();
    return &shared_buffer;
}

void TransferContext::read_return_value(jni::Env& p_env, godot::Variant& r_ret) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    BufferToVariant::read_variant(buffer, r_ret);
}

void TransferContext::write_args(jni::Env& p_env, const godot::Variant** p_args, int args_size) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    buffer->increment_position(godot::encode_uint32(args_size, buffer->get_cursor()));
    for (auto i = 0; i < args_size; ++i) {
        VariantToBuffer::write_variant(*p_args[i], buffer);
    }
}

uint32_t TransferContext::read_args(jni::Env& p_env, godot::Variant* args) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    uint32_t size = read_args_size(buffer);
    for (uint32_t i = 0; i < size; ++i) {
        BufferToVariant::read_variant(buffer, args[i]);
    }
    return size;
}

void TransferContext::write_return_value(jni::Env& p_env, godot::Variant& variant) {
    VariantToBuffer::write_variant(variant, get_and_rewind_buffer(p_env));
}

void TransferContext::write_object_data(jni::Env& p_env, uintptr_t ptr, godot::ObjectID id) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    buffer->increment_position(godot::encode_uint64(ptr, buffer->get_cursor()));
    buffer->increment_position(godot::encode_uint64(id, buffer->get_cursor()));
}

bool TransferContext::read_receiver(jni::Env& p_env, SharedBuffer* p_buffer, raw_godot::RawObject& r_receiver) {
    // The receiver pointer and ObjectID are written directly into the buffer by Kotlin before the call.
    uintptr_t receiver_ptr = static_cast<uintptr_t>(godot::decode_uint64(p_buffer->get_cursor()));
#ifdef DEBUG_ENABLED
    uint64_t receiver_id = godot::decode_uint64(p_buffer->get_cursor() + PTR_SIZE);
#endif
    p_buffer->increment_position(PTR_SIZE + PTR_SIZE);
    // receiver_ptr is the raw engine pointer the JVM was given.
    r_receiver = reinterpret_cast<GDExtensionObjectPtr>(receiver_ptr);

#ifdef DEBUG_ENABLED
    if (unlikely(r_receiver != raw_godot::RawObject::from_instance_id(receiver_id))) {
        p_buffer->rewind();
        godot::Variant return_value;
        VariantToBuffer::write_variant(return_value, p_buffer);
        constexpr const char* message = "Cannot call a method on a previously freed instance.";
        JVM_ERR_PRINT("%s", message);
        p_env.throw_new(message);
        return false;
    }
#endif
    return true;
}

void TransferContext::icall(JNIEnv* rawEnv, jobject, jlong j_method_ptr) {
    jni::Env env(rawEnv);
    SharedBuffer* buffer = get_instance().get_and_rewind_buffer(env);

    raw_godot::RawObject receiver;
    if (unlikely(!read_receiver(env, buffer, receiver))) { return; }

    uint32_t args_size = read_args_size(buffer);

    GDExtensionMethodBindPtr method_bind = reinterpret_cast<GDExtensionMethodBindPtr>(
        static_cast<uintptr_t>(j_method_ptr)
    );

    // A GDExtensionMethodBindPtr is an opaque engine handle with no exposed name or class accessors.
    JVM_DEV_ASSERT(
        args_size <= MAX_FUNCTION_ARG_COUNT,
        "Cannot have more than %s arguments for a method call but tried to call with %s args",
        MAX_FUNCTION_ARG_COUNT,
        args_size
    );

    GDExtensionCallError r_error = {GDExtensionCallErrorType::GDEXTENSION_CALL_OK, 0, 0};

    godot::Variant ret_value;
    VariantStack::Slots slots = VariantStack::push(args_size);
    if (likely(slots.is_valid())) {
        read_args_to_array(buffer, slots.args, args_size);

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
        read_args_to_array(buffer, args, args_size);

        const godot::Variant* args_ptr[MAX_FUNCTION_ARG_COUNT];
        for (uint32_t i = 0; i < args_size; i++) {
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

    buffer->rewind();
    VariantToBuffer::write_variant(ret_value, buffer);

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(
        r_error.error != GDExtensionCallErrorType::GDEXTENSION_CALL_OK,
        "Call to method bind failed with error %s.",
        static_cast<int>(r_error.error)
    );
#endif
}

void TransferContext::icall_ptr(JNIEnv* rawEnv, jobject, jlong j_method_ptr, jint p_return_type) {
    jni::Env env(rawEnv);
    SharedBuffer* buffer = get_instance().get_and_rewind_buffer(env);

    raw_godot::RawObject receiver;
    if (unlikely(!read_receiver(env, buffer, receiver))) { return; }

    uint32_t args_size = read_args_size(buffer);
    JVM_DEV_ASSERT(
        args_size <= MAX_FUNCTION_ARG_COUNT,
        "Cannot have more than %s arguments for a method call but tried to call with %s args",
        MAX_FUNCTION_ARG_COUNT,
        args_size
    );

    GDExtensionMethodBindPtr method_bind = reinterpret_cast<GDExtensionMethodBindPtr>(
        static_cast<uintptr_t>(j_method_ptr)
    );

    // Per-call storage on this frame: a nested JVM call from inside the engine call rewrites the shared buffer.
    const void* args[MAX_FUNCTION_ARG_COUNT];
    BufferToPtr::InlineValue inline_args[MAX_FUNCTION_ARG_COUNT];
    BufferToPtr::read_args(buffer, args_size, args, inline_args);

    if (p_return_type == godot::Variant::NIL) {
        receiver.ptrcall_method_bind(method_bind, args, nullptr);
    } else if (p_return_type == godot::Variant::OBJECT || p_return_type == REF_COUNTED_RETURN_TYPE) {
        // Must start null: for a RefCounted return the engine assigns a Ref over this slot, releasing whatever it
        // previously pointed to.
        godot::GodotObject* ret = nullptr;
        receiver.ptrcall_method_bind(method_bind, args, &ret);
        buffer->rewind();
        VariantToBuffer::write_object(buffer, ret);
        // The binding taken by write_object holds the JVM's own reference, so the one the engine handed over is
        // surplus. Its release cannot free the object, but the destroy branch keeps the protocol honest.
        if (p_return_type == REF_COUNTED_RETURN_TYPE && ret != nullptr) {
            raw_godot::RawObject returned = ret;
            if (unlikely(returned.unreference())) { returned.destroy(); }
        }
    } else {
        BufferToPtr::InlineValue ret;
        receiver.ptrcall_method_bind(method_bind, args, ret.bytes);
        buffer->rewind();
        BufferToPtr::write_inline_return(buffer, static_cast<godot::Variant::Type>(p_return_type), ret);
    }
}
