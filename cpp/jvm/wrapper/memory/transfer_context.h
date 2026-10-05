#ifndef GODOT_JVM_TRANSFER_CONTEXT_H
#define GODOT_JVM_TRANSFER_CONTEXT_H

#include "engine/godot_object.h"
#include "jvm/buffer_wire.h"
#include "jvm/shared_buffer.h"
#include "jvm/wrapper/jvm_instance_wrapper.h"
#include "jvm/wrapper/jvm_singleton_wrapper.h"
#include "logging.h"

#include <core/type_info.hpp>
#include <type_traits>
#include <variant/variant.hpp>

// clang-format off
JVM_SINGLETON_WRAPPER(TransferContext, "godot.internal.memory.TransferContext") {
    SINGLETON_CLASS(TransferContext)

    JNI_OBJECT_METHOD(GET_BUFFER)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_BUFFER, "getBuffer", "()Ljava/nio/ByteBuffer;")
        INIT_NATIVE_METHOD("icall", "(J)V", TransferContext::icall)
        INIT_NATIVE_METHOD("icallPtr", "(JI)V", TransferContext::icall_ptr)
    )

    static constexpr int REF_COUNTED_RETURN_TYPE = godot::Variant::VARIANT_MAX;


    static SharedBuffer* get_and_rewind_buffer(jni::Env& p_env);

    static void icall(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr);
    static void icall_ptr(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr, jint p_return_type);

    static bool read_receiver(jni::Env& p_env, SharedBuffer* p_buffer, raw_godot::RawObject& r_receiver);
    static godot::Variant decode_variant(SharedBuffer* p_buffer);
    static void encode_variant(SharedBuffer* p_buffer, const godot::Variant& p_variant);

    template<class T>
    static T decode_value(SharedBuffer* p_buffer);

public:
    // Every method below rewinds the shared buffer first. "value" means the native type the caller declares, decoded
    // through its wire row with no Variant in between; "variant" means a Variant, dispatched on the type tag on the
    // wire. Singular reads or writes one, plural a whole argument list.

    // The arguments of a bridge with a fixed signature, each into the local its type declares:
    //     int64_t index;
    //     godot::Variant element;
    //     TransferContext::read_values(env, index, element);
    // A local declared as a Variant takes whatever type the JVM tagged; any other local names its type, and the tag
    // only confirms it.
    template<class... Args>
    static void read_values(jni::Env& p_env, Args&... r_args);

    // The arguments of a bridge whose arity is only known at runtime, into `args`; returns how many were sent.
    static uint32_t read_variants(jni::Env& p_env, godot::Variant* args);

    // The value a Kotlin function, property getter or callable returned.
    static godot::Variant read_variant(jni::Env& p_env);

    // The result of a bridge, through the wire row of its type: a Variant is dispatched on its runtime type,
    // anything else is written as the native value its own row expects.
    template<class T>
    static void write_value(jni::Env& p_env, const T& p_value);

    // The arguments of a call into Kotlin, as the engine handed them over.
    static void write_variants(jni::Env& p_env, const godot::Variant** p_args, int args_size);

    // The pointer and ObjectID of a freshly created engine object, the payload the JVM binds its wrapper to.
    static void write_object_info(jni::Env& p_env, uintptr_t ptr, godot::ObjectID id);
};

template<class T>
void TransferContext::write_value(jni::Env& p_env, const T& p_value) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    if constexpr (!std::is_same_v<T, godot::Variant>) {
        constexpr godot::Variant::Type TYPE = static_cast<godot::Variant::Type>(godot::GetTypeInfo<T>::VARIANT_TYPE);
        write_type(buffer, TYPE);
        Wire<TYPE>::value_write(buffer, p_value);
    } else {
        encode_variant(buffer, p_value);
    }
}

template<class... Args>
void TransferContext::read_values(jni::Env& p_env, Args&... r_args) {
    SharedBuffer* buffer = get_and_rewind_buffer(p_env);
    uint32_t count = buffer->read<uint32_t>();
    JVM_DEV_ASSERT(count == sizeof...(Args), "The bridge reads %s arguments but the JVM sent %s.", sizeof...(Args), count);
    (void(r_args = decode_value<Args>(buffer)), ...);
}

template<class T>
T TransferContext::decode_value(SharedBuffer* p_buffer) {
    if constexpr (!std::is_same_v<T, godot::Variant>) {
        constexpr godot::Variant::Type TYPE = static_cast<godot::Variant::Type>(godot::GetTypeInfo<T>::VARIANT_TYPE);
        godot::Variant::Type sent = read_type(p_buffer);
        JVM_DEV_ASSERT(sent == TYPE, "Expected an argument of type %s but the JVM sent %s.", TYPE, sent);
        return static_cast<T>(Wire<TYPE>::value_read(p_buffer));
    } else {
        return decode_variant(p_buffer);
    }
}

// clang-format on
#endif // GODOT_JVM_TRANSFER_CONTEXT_H
