#ifndef GODOT_JVM_TRANSFER_CONTEXT_H
#define GODOT_JVM_TRANSFER_CONTEXT_H

#include "engine/marshalls.h"
#include "jvm/jvm_variant.h"
#include "jvm/wrapper/jvm_instance_wrapper.h"

// clang-format off
JVM_SINGLETON_WRAPPER(TransferContext, "godot.internal.memory.TransferContext") {
    SINGLETON_CLASS(TransferContext)

    JNI_OBJECT_METHOD(GET_BUFFER)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_BUFFER, "getBuffer", "()Ljava/nio/ByteBuffer;")
        // Must match the real Kotlin declaration exactly: `private external fun icall(methodPtr:
        // VoidPtr)` in TransferContext.kt — a single Long, unchanged from master. The receiver
        // pointer/ID are written directly into the shared buffer by Kotlin's
        // writeMethodArguments() before this is called, not passed as extra native arguments; an
        // earlier version of this binding declared "(JJI)V" (extra jlong + jint), which doesn't
        // match any real Kotlin method and made JNI's RegisterNatives fail at JVM startup.
        INIT_NATIVE_METHOD("icall", "(J)V", TransferContext::icall)
    )

public:

    void write_return_value(jni::Env& p_env, godot::Variant& variant);
    void read_return_value(jni::Env& p_env, godot::Variant& r_ret);
    void write_args(jni::Env& p_env, const godot::Variant** p_args, int args_size);
    uint32_t read_args(jni::Env& p_env, godot::Variant* args);
    void write_object_data(jni::Env& p_env, uintptr_t ptr, godot::ObjectID id);

    static void icall(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr);

private:
    SharedBuffer* get_and_rewind_buffer(jni::Env& p_env);

    _FORCE_INLINE_ static uint32_t read_args_size(SharedBuffer* buffer) {
        uint32_t args_size {decode_uint32(buffer->get_cursor())};
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
