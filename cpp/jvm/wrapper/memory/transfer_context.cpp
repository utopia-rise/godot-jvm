#include "transfer_context.h"

#include "api/script/jvm_instance.h"
#include "constraints.h"
#include "jvm/buffer_wire.h"
#include "jvm/variant_stack.h"
#include "logging.h"

#include <array>
#include <core/object.hpp>
#include <utility>

static thread_local SharedBuffer shared_buffer;

// One table entry per Variant::Type ordinal, expanded from the Wire rows: a type without a row does not compile.
using VariantTypes = std::make_index_sequence<godot::Variant::VARIANT_MAX>;

template<size_t... I>
static constexpr auto make_variant_readers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::variant_read...};
}

template<size_t... I>
static constexpr auto make_variant_writers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::variant_write...};
}

template<size_t... I>
static constexpr auto make_ptr_arg_readers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::ptr_read...};
}

template<size_t... I>
static constexpr auto make_ptr_return_writers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::ptr_write...};
}

godot::Variant TransferContext::decode_variant(SharedBuffer* p_buffer) {
    static constexpr auto readers = make_variant_readers(VariantTypes());
    return readers[read_type(p_buffer)](p_buffer);
}

void TransferContext::encode_variant(SharedBuffer* p_buffer, const godot::Variant& p_variant) {
    static constexpr auto writers = make_variant_writers(VariantTypes());
    write_type(p_buffer, p_variant.get_type());
    writers[p_variant.get_type()](p_buffer, p_variant);
}

// r_args is the argument list the ptrcall receives; r_storage backs the inline values it points into.
static void read_ptr_args(SharedBuffer* p_buffer, uint32_t p_count, const void** r_args, PtrInlineValue* r_storage) {
    static constexpr auto readers = make_ptr_arg_readers(VariantTypes());
    for (uint32_t i = 0; i < p_count; ++i) {
        godot::Variant::Type value_type = read_type(p_buffer);
        JVM_DEV_ASSERT(
            value_type < godot::Variant::VARIANT_MAX,
            "Argument %s has an invalid type tag %s.",
            i,
            value_type
        );
        r_args[i] = readers[value_type](p_buffer, &r_storage[i]);
    }
}

// The inline value the engine wrote into caller storage, behind its tag.
static void write_ptr_return(SharedBuffer* p_buffer, godot::Variant::Type p_type, PtrInlineValue& p_value) {
    static constexpr auto writers = make_ptr_return_writers(VariantTypes());
    write_type(p_buffer, p_type);
    writers[p_type](p_buffer, p_value);
}

TransferContext::~TransferContext() = default;

SharedBuffer* TransferContext::get_and_rewind_buffer(jni::Env& p_env) {
    if (unlikely(!shared_buffer.is_init())) {
        jni::JObject buffer = get_instance().wrapped.call_object_method(p_env, GET_BUFFER);
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

void TransferContext::write_variants(jni::Env& p_env, const godot::Variant** p_args, int args_size) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    buffer->write<uint32_t>(args_size);
    for (auto i = 0; i < args_size; ++i) {
        encode_variant(buffer, *p_args[i]);
    }
}

uint32_t TransferContext::read_variants(jni::Env& p_env, godot::Variant* args) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    uint32_t size = buffer->read<uint32_t>();
    for (uint32_t i = 0; i < size; ++i) {
        args[i] = decode_variant(buffer);
    }
    return size;
}

godot::Variant TransferContext::read_variant(jni::Env& p_env) {
    return decode_variant(get_and_rewind_buffer(p_env));
}

void TransferContext::write_object_info(jni::Env& p_env, uintptr_t ptr, godot::ObjectID id) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    buffer->write<uint64_t>(ptr);
    buffer->write<uint64_t>(id);
}

bool TransferContext::read_receiver(jni::Env& p_env, SharedBuffer* p_buffer, raw_godot::RawObject& r_receiver) {
    // The raw engine pointer the JVM was given, and its ObjectID.
    r_receiver = reinterpret_cast<GDExtensionObjectPtr>(static_cast<uintptr_t>(p_buffer->read<uint64_t>()));
    uint64_t receiver_id = p_buffer->read<uint64_t>();

#ifdef DEBUG_ENABLED
    if (unlikely(r_receiver != raw_godot::RawObject::from_instance_id(receiver_id))) {
        p_buffer->rewind();
        godot::Variant return_value;
        encode_variant(p_buffer, return_value);
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
    SharedBuffer* buffer = get_and_rewind_buffer(env);

    raw_godot::RawObject receiver;
    if (unlikely(!read_receiver(env, buffer, receiver))) { return; }

    uint32_t args_size = buffer->read<uint32_t>();
    JVM_DEV_ASSERT(
        args_size <= MAX_FUNCTION_ARG_COUNT,
        "Cannot have more than %s arguments for a method call but tried to call with %s args",
        MAX_FUNCTION_ARG_COUNT,
        args_size
    );

    GDExtensionMethodBindPtr method_bind = reinterpret_cast<GDExtensionMethodBindPtr>(
        static_cast<uintptr_t>(j_method_ptr)
    );
    GDExtensionCallError r_error = {GDExtensionCallErrorType::GDEXTENSION_CALL_OK, 0, 0};
    godot::Variant ret_value;

    VariantStack::Slots slots = VariantStack::push(args_size);
    if (likely(slots.is_valid())) {
        for (uint32_t i = 0; i < args_size; ++i) {
            slots.args[i] = decode_variant(buffer);
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
            args[i] = decode_variant(buffer);
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
    encode_variant(buffer, ret_value);

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
    SharedBuffer* buffer = get_and_rewind_buffer(env);

    raw_godot::RawObject receiver;
    if (unlikely(!read_receiver(env, buffer, receiver))) { return; }

    uint32_t args_size = buffer->read<uint32_t>();
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
    PtrInlineValue inline_args[MAX_FUNCTION_ARG_COUNT];
    read_ptr_args(buffer, args_size, args, inline_args);

    if (p_return_type == godot::Variant::NIL) {
        receiver.ptrcall_method_bind(method_bind, args, nullptr);
        return;
    }

    // A pointer-backed or Ref<T> result is assigned over the slot, releasing what it held, so the slot starts as the
    // empty value: a null pointer in the first word, padding after it in the widest such type.
    // An inline result only overwrites, so the rest of the slot is left alone.
    PtrInlineValue ret;
    memset(ret.bytes, 0, PTR_RETURN_NULL_BYTES);

    if (p_return_type == REF_COUNTED_RETURN_TYPE) {
        // VARIANT_MAX (39) is not a Variant type: the generator sends it in place of OBJECT when the engine method's
        // declared return class is a RefCounted, meaning the engine encodes a Ref<T> into the slot rather than a
        // plain pointer.
        // The Ref is assigned over the slot, releasing whatever it pointed to, hence the nulled slot.
        godot::GodotObject** slot = reinterpret_cast<godot::GodotObject**>(ret.bytes);
        receiver.ptrcall_method_bind(method_bind, args, ret.bytes);
        buffer->rewind();
        write_ptr_return(buffer, godot::Variant::OBJECT, ret);
        raw_godot::RawObject returned(*slot);
        if (!returned.is_null() && unlikely(returned.unreference())) { returned.destroy(); }
        return;
    }

    receiver.ptrcall_method_bind(method_bind, args, ret.bytes);
    buffer->rewind();
    write_ptr_return(buffer, static_cast<godot::Variant::Type>(p_return_type), ret);
}
