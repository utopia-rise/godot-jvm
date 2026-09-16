#ifndef GODOT_JVM_TRANSFER_CONTEXT_H
#define GODOT_JVM_TRANSFER_CONTEXT_H

#include "engine/godot_object.h"
#include "jvm/shared_buffer.h"
#include "jvm/wrapper/jvm_instance_wrapper.h"
#include "jvm/wrapper/jvm_singleton_wrapper.h"

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

    SharedBuffer* get_and_rewind_buffer(jni::Env& p_env)const;

    static void icall(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr);
    static void icall_ptr(JNIEnv* rawEnv, jobject instance, jlong j_method_ptr, jint p_return_type);

    static bool read_receiver(jni::Env& p_env, SharedBuffer* p_buffer, raw_godot::RawObject& r_receiver);

public:
    void write_args(jni::Env& p_env, const godot::Variant** p_args, int args_size)const;
    uint32_t read_args(jni::Env& p_env, godot::Variant* args)const;
    void write_return(jni::Env& p_env, godot::Variant& variant)const;
    godot::Variant read_return(jni::Env& p_env)const;
    void write_object_info(jni::Env& p_env, uintptr_t ptr, godot::ObjectID id)const;
};

// clang-format on
#endif // GODOT_JVM_TRANSFER_CONTEXT_H
