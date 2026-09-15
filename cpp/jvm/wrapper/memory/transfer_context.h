#ifndef GODOT_JVM_TRANSFER_CONTEXT_H
#define GODOT_JVM_TRANSFER_CONTEXT_H

#include "engine/marshalls.h"
#include "jvm/variant_converter.h"
#include "jvm/wrapper/jvm_instance_wrapper.h"

// clang-format off
JVM_SINGLETON_WRAPPER(TransferContext, "godot.internal.memory.TransferContext") {
    SINGLETON_CLASS(TransferContext)

    JNI_OBJECT_METHOD(GET_BUFFER)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_BUFFER, "getBuffer", "()Ljava/nio/ByteBuffer;")
        // Both must match the Kotlin declarations exactly: `private external fun icall(methodPtr: VoidPtr)` and
        // `icallPtr(methodPtr: VoidPtr, returnType: Int)` in TransferContext.kt. The receiver pointer/ID are written
        // directly into the shared buffer by Kotlin before the call, not passed as extra native arguments; an earlier
        // version declared "(JJI)V", which matched no Kotlin method and made RegisterNatives fail at startup.
        INIT_NATIVE_METHOD("icall", "(J)V", TransferContext::icall)
        INIT_NATIVE_METHOD("icallPtr", "(JI)V", TransferContext::icall_ptr)
    )

public:

    void write_return_value(jni::Env& p_env, godot::Variant& variant);
    void read_return_value(jni::Env& p_env, godot::Variant& r_ret);
    void write_args(jni::Env& p_env, const godot::Variant** p_args, int args_size);
    uint32_t read_args(jni::Env& p_env, godot::Variant* args);
    void write_object_data(jni::Env& p_env, uintptr_t ptr, godot::ObjectID id);

    // Two ways to invoke an engine method bind from the shared buffer:
    // - icall decodes every argument into a Variant and lets the engine validate and convert them (BufferToVariant).
    // - icall_ptr is the unchecked ptrcall: the engine reads the arguments where they already are (BufferToPtr) and
    //   writes the return value in place, its type announced by the JVM as a Variant::Type ordinal or
    //   REF_COUNTED_RETURN_TYPE. The generator only emits it for methods whose types BufferToPtr supports.
    static void icall(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr);
    static void icall_ptr(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr, jint p_return_type);

    // One past the Variant::Type ordinals. A RefCounted comes out of a ptrcall with one reference the caller owns,
    // which a plain Object return does not, so the JVM tells the two apart.
    static constexpr int REF_COUNTED_RETURN_TYPE = godot::Variant::VARIANT_MAX;

private:
    // Consumes the receiver from the buffer. False when the receiver was freed (debug builds only): the buffer then
    // already holds a NIL return and a JVM exception is pending.
    static bool read_receiver(jni::Env& p_env, SharedBuffer* p_buffer, raw_godot::RawObject& r_receiver);

    SharedBuffer* get_and_rewind_buffer(jni::Env& p_env);

    _FORCE_INLINE_ static uint32_t read_args_size(SharedBuffer* buffer) {
        uint32_t args_size = godot::decode_uint32(buffer->get_cursor());
        buffer->increment_position(4);
        return args_size;
    }

    _FORCE_INLINE_ static void read_args_to_array(SharedBuffer* buffer, godot::Variant* p_args, uint32_t args_size) {
        for (uint32_t i = 0; i < args_size; ++i) {
            BufferToVariant::read_variant(buffer, p_args[i]);
        }
    }
};

// clang-format on
#endif // GODOT_JVM_TRANSFER_CONTEXT_H
