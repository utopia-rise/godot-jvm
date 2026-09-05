#include "transfer_context.h"

#include "api/script/jvm_instance.h"

#include <core/object.hpp>

const int MAX_STACK_SIZE = MAX_FUNCTION_ARG_COUNT * 8;

struct TransferContextThreadStorage {
    godot::Variant args[MAX_STACK_SIZE];
    const godot::Variant* args_ptr[MAX_STACK_SIZE];
    SharedBuffer shared_buffer;
    int stack_offset = -1;
};

static TransferContextThreadStorage& get_thread_storage() {
    thread_local TransferContextThreadStorage* storage = nullptr;
    if (unlikely(!storage)) { storage = memnew(TransferContextThreadStorage); }
    return *storage;
}

TransferContext::~TransferContext() = default;

SharedBuffer* TransferContext::get_and_rewind_buffer(jni::Env& p_env) {
    SharedBuffer& shared_buffer = get_thread_storage().shared_buffer;

    if (unlikely(!shared_buffer.is_init())) {
        jni::JObject buffer = wrapped.call_object_method(p_env, GET_BUFFER);
        JVM_DEV_ASSERT(!buffer.is_null(), "Buffer is null");
        auto* address = static_cast<uint8_t*>(p_env.get_direct_buffer_address(buffer));
#ifdef DEBUG_ENABLED
        shared_buffer = SharedBuffer {address, 0, p_env.get_direct_buffer_capacity(buffer)};
#else
        shared_buffer = SharedBuffer {address, 0};
#endif
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
    buffer->increment_position(encode_uint32(args_size, buffer->get_cursor()));
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
    buffer->increment_position(encode_uint64(ptr, buffer->get_cursor()));
    buffer->increment_position(encode_uint64(id, buffer->get_cursor()));
}

void TransferContext::icall(JNIEnv* rawEnv, jobject, jlong j_method_ptr) {
    TransferContextThreadStorage& storage = get_thread_storage();
    if (unlikely(storage.stack_offset == -1)) {
        // The only place variant_args()'s guard-checked thread_local init actually runs, once per thread — everything below this block reads the cached variant_args_base instead.
        for (int i = 0; i < MAX_STACK_SIZE; i++) {
            storage.args_ptr[i] = &storage.args[i];
        }
        storage.stack_offset = 0;
    }

    jni::Env env = rawEnv;

    SharedBuffer* buffer = get_instance().get_and_rewind_buffer(env);

    // The receiver pointer and ObjectID are written directly into the buffer by Kotlin's
    // TransferContext.writeMethodArguments() before this call.
    uintptr_t receiver_ptr = static_cast<uintptr_t>(decode_uint64(buffer->get_cursor()));
#ifdef DEBUG_ENABLED
    uint64_t receiver_id = decode_uint64(buffer->get_cursor() + PTR_SIZE);
#endif
    buffer->increment_position(PTR_SIZE + PTR_SIZE);
    // receiver_ptr is the raw engine pointer the JVM was given.
    GDExtensionObjectPtr ptr = reinterpret_cast<GDExtensionObjectPtr>(receiver_ptr);

    uint32_t args_size = read_args_size(buffer);

    GDExtensionMethodBindPtr method_bind = reinterpret_cast<GDExtensionMethodBindPtr>(static_cast<uintptr_t>(j_method_ptr));
    raw_godot::RawObject receiver = ptr;

#ifdef DEBUG_ENABLED
    if (unlikely(receiver != raw_godot::RawObject::from_instance_id(receiver_id))) {
        buffer->rewind();
        godot::Variant return_value;
        VariantToBuffer::write_variant(return_value, buffer);
        constexpr const char* message = "Cannot call a method on a previously freed instance.";
        JVM_ERR_PRINT("%s", message);
        env.throw_new(message);
        return;
    }
#endif

    // A GDExtensionMethodBindPtr is an opaque engine handle with no exposed name or class accessors.
    JVM_DEV_ASSERT(
      args_size <= MAX_FUNCTION_ARG_COUNT,
      "Cannot have more than %s arguments for a method call but tried to call with %s args",
      MAX_FUNCTION_ARG_COUNT,
      args_size
    );

    GDExtensionCallError r_error = {GDExtensionCallErrorType::GDEXTENSION_CALL_OK, 0, 0};

    if (unlikely(storage.stack_offset + args_size > MAX_STACK_SIZE)) {
        godot::Variant args[MAX_FUNCTION_ARG_COUNT];
        read_args_to_array(buffer, args, args_size);

        const godot::Variant* args_ptr[MAX_FUNCTION_ARG_COUNT];
        for (uint32_t i = 0; i < args_size; i++) {
            args_ptr[i] = &args[i];
        }

        godot::Variant ret_value;
        receiver.call_method_bind(
          method_bind,
          reinterpret_cast<GDExtensionConstVariantPtr*>(args_ptr),
          args_size,
          &ret_value,
          &r_error
        );

        buffer->rewind();
        VariantToBuffer::write_variant(ret_value, buffer);
    } else {
        godot::Variant* args = storage.args + storage.stack_offset;
        read_args_to_array(buffer, args, args_size);

        const godot::Variant** args_ptr = storage.args_ptr + storage.stack_offset;

        storage.stack_offset += args_size;
        godot::Variant ret_value;
        receiver.call_method_bind(
          method_bind,
          reinterpret_cast<GDExtensionConstVariantPtr*>(args_ptr),
          args_size,
          &ret_value,
          &r_error
        );
        // Remove Variants so memory can be freed immediately after method call.
        for (uint32_t i = 0; i < args_size; i++) {
            args[i] = godot::Variant();
        }
        storage.stack_offset -= args_size;

        buffer->rewind();
        VariantToBuffer::write_variant(ret_value, buffer);
    }

#ifdef DEBUG_ENABLED
    JVM_ERR_FAIL_COND_MSG(
      r_error.error != GDExtensionCallErrorType::GDEXTENSION_CALL_OK,
      "Call to method bind failed with error %s.",
      static_cast<int>(r_error.error)
    );
#endif
}
