#ifndef GODOT_JVM_VALUE_BUFFER_H
#define GODOT_JVM_VALUE_BUFFER_H

#include "engine/godot_object.h"
#include "jvm/jvm_instance_wrapper.h"
#include "jvm/jvm_singleton_wrapper.h"
#include "jvm/memory/buffer_wire.h"
#include "jvm/memory/byte_cursor.h"
#include "logging.h"

#include <core/defs.hpp>
#include <cstdint>
#include <cstring>
#include <variant/variant.hpp>

// The per-thread stack of ptrcall frames. The engine reads the arguments of a ptrcall where the JVM wrote them and
// writes its result right after them, so a frame stays live for the whole engine call, including any JVM code it
// reenters that calls the engine again. The JVM stacks one frame per live call and passes the offset of the one a
// call runs in; the Frame is positioned there and never rewound.
// clang-format off
JVM_SINGLETON_WRAPPER(ValueBuffer, "godot.internal.memory.ValueBuffer") {
    SINGLETON_CLASS(ValueBuffer)

    JNI_VOID_METHOD(SET_SIZE_FACTOR)

    INIT_JNI_BINDINGS(
        INIT_NATIVE_METHOD("bufferAddress", "(Ljava/nio/ByteBuffer;)J", ValueBuffer::buffer_address)
        INIT_JNI_METHOD(SET_SIZE_FACTOR, "setSizeFactor", "(I)V")
    )
    // clang-format on

public:
    // VARIANT_MAX is not a Variant type: the generator sends it in place of OBJECT when the engine method's declared
    // return class is a RefCounted, meaning the engine assigns a Ref<T> into the return slot rather than a plain
    // pointer. It is a return type like any other here - Wire<VARIANT_MAX> is the row that knows what to do with the
    // reference the engine leaves behind - so a caller passes it straight through and this name is only the contract
    // with the generator.
    static constexpr int REF_COUNTED_RETURN_TYPE = godot::Variant::VARIANT_MAX;

    // One ptrcall's region of the buffer. Its own type so that a value buffer frame cannot be handed to the other
    // buffer; nested calls push another frame after this one.
    class Frame : public ByteCursor {
    public:
        Frame() = default;

        Frame(uint8_t* p_base, int p_position = 0) : ByteCursor(p_base, p_position) {}

        void read_args(uint32_t p_count, const void** r_args);

        // The single argument of a setter call. It carries no type tag, because the caller passed the type instead.
        // Inline because the whole of it, for a type whose payload is the value, is one address computation; as a
        // call it cost a prologue, a call and a return around a single add. The position never moves either: a setter
        // frame holds nothing after its argument, so nobody reads it again.
        _FORCE_INLINE_ const void* read_only_arg(godot::Variant::Type p_type, ptrdiff_t p_at) const {
            if (likely(PTR_ARG_SIZES[p_type] != 0)) { return ptr + p_at; }

            const void* arg;
            PTR_ARG_READERS[p_type](ptr, p_at, &arg);
            return arg;
        }

        // Runs a call that returns a value and leaves the frame holding it. The frame decides where the return
        // record goes, the row for the type decides where the engine writes and what has to happen around the call.
        void call_ret(godot::Variant::Type p_type, const raw_godot::PtrCall& p_call);
        // The same for a getter call, whose return record is at a fixed offset and carries no type tag either.
        void call_only_ret(godot::Variant::Type p_type, ptrdiff_t p_at, const raw_godot::PtrCall& p_call);
    };

    void set_size_factor(jni::Env& p_env, int p_factor);

    // The base address of a thread's direct buffer, which only this side can obtain. The JVM asks once per thread,
    // when it creates that thread's stack, and then hands the address to every unchecked call: a Frame is built on
    // the C++ stack from it, so nothing about the buffer is kept on this side at all.
    static jlong buffer_address(JNIEnv* p_raw_env, jobject p_instance, jobject p_buffer);
};

#endif // GODOT_JVM_VALUE_BUFFER_H
