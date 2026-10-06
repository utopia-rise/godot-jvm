#ifndef GODOT_JVM_VALUE_BUFFER_H
#define GODOT_JVM_VALUE_BUFFER_H

#include "jvm/jvm_instance_wrapper.h"
#include "jvm/jvm_singleton_wrapper.h"
#include "jvm/memory/byte_cursor.h"
#include "jvm/memory/variant_table.h"
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
    // One ptrcall's region of the buffer. Its own type so that a value buffer frame cannot be handed to the other
    // buffer; nested calls push another frame after this one.
    class Frame : public ByteCursor {
    public:
        Frame(uint8_t* p_base, int p_position = 0) : ByteCursor(p_base, p_position) {}

        void read_args(uint32_t p_count, const void** r_args) {
            const uint8_t* const base = ptr;
            ptrdiff_t at = position;
            for (uint32_t i = 0; i < p_count; ++i) {
                at = (at + 7) & ~static_cast<ptrdiff_t>(7);
                uint64_t tag;
                memcpy(&tag, base + at, sizeof(tag));
                at += sizeof(tag);
                auto value_type = static_cast<godot::Variant::Type>(tag);
                JVM_DEV_ASSERT(
                    value_type < godot::Variant::VARIANT_MAX,
                    "Argument %s has an invalid type tag %s.",
                    i,
                    value_type
                );

                const ArgFormat format = ARG_FORMATS[value_type];
                r_args[i] = arg_in(base + at, format);
                at += format.stride();
            }
            position = static_cast<int>(at);
        }

        _FORCE_INLINE_ const void* peek_arg(godot::Variant::Type p_type, ptrdiff_t p_at) const {
            return arg_in(ptr + p_at, ARG_FORMATS[p_type]);
        }

        uint8_t* reserve_return(const ReturnFormat& p_format) {
            align();
            return reserve(p_format.slot_size);
        }

        uint8_t* at(ptrdiff_t p_at) { return ptr + p_at; }

    private:
        _FORCE_INLINE_ static const void* arg_in(const uint8_t* p_slot, ArgFormat p_format) {
            JVM_DEV_ASSERT(
                p_format.is_ptrcallable(),
                "A type with a custom wire format cannot be passed to a ptrcall."
            );

            if (!p_format.is_indirect()) { return p_slot; }

            uint64_t handle;
            memcpy(&handle, p_slot, sizeof(handle));
            return reinterpret_cast<const void*>(static_cast<uintptr_t>(handle));
        }
    };

    void set_size_factor(jni::Env& p_env, int p_factor) const {
        jvalue args[1] = {jni::to_jni_arg(p_factor)};
        wrapped.call_void_method(p_env, SET_SIZE_FACTOR, args);
    }

    static jlong buffer_address(JNIEnv* p_raw_env, jobject, jobject p_buffer) {
        jni::Env env(p_raw_env);
        jni::JObject buffer(p_buffer);
        JVM_DEV_ASSERT(!buffer.is_null(), "Buffer is null");
        return reinterpret_cast<jlong>(env.get_direct_buffer_address(buffer));
    }
};

#endif // GODOT_JVM_VALUE_BUFFER_H
