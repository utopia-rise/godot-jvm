#ifndef GODOT_JVM_VARIANT_BUFFER_H
#define GODOT_JVM_VARIANT_BUFFER_H

#include "engine/godot_object.h"
#include "jvm/jni/jvm.h"
#include "jvm/jvm_instance_wrapper.h"
#include "jvm/jvm_singleton_wrapper.h"
#include "jvm/memory/byte_cursor.h"
#include "jvm/memory/variant_table.h"
#include "logging.h"

#include <core/defs.hpp>
#include <core/type_info.hpp>
#include <cstdint>
#include <type_traits>
#include <variant/variant.hpp>

// The per-thread buffer every exchange but a ptrcall goes through: bridges, checked engine calls, and calls from the
// engine into JVM code. Each exchange rewinds it, so it only ever holds one call, whose arguments both sides copy out
// before anything else can use it. How a value becomes bytes belongs to its row in variant_type.h; what the Transfer
// adds is the tag before each value and the shape of a call around them. Values are laid down in the native byte
// order, which is the little-endian order the JVM configures its ByteBuffer with.
// clang-format off
JVM_SINGLETON_WRAPPER(VariantBuffer, "godot.internal.memory.VariantBuffer") {
    SINGLETON_CLASS(VariantBuffer)

    JNI_OBJECT_METHOD(GET_BUFFER)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_BUFFER, "getBuffer", "()Ljava/nio/ByteBuffer;")
    )
    // clang-format on

public:
    // One exchange through the buffer. The byte primitives a type writes through are the cursor's; what is added here
    // is the shape of a call: a rewind, an argument count, and the tag before each value.
    class Transfer : public ByteCursor {
    public:
        Transfer() = default;

        explicit Transfer(uint8_t* p_ptr) : ByteCursor(p_ptr) {}

        template<class... Args>
        void read_args(Args&... r_args) {
            rewind();
            uint32_t count = read<uint32_t>();
            JVM_DEV_ASSERT(
                count == sizeof...(Args),
                "The bridge reads %s arguments but the JVM sent %s.",
                sizeof...(Args),
                count
            );
            (void(r_args = read_arg<Args>()), ...);
        }

        template<class T>
        void write_ret(const T& p_value) {
            rewind();
            if constexpr (!std::is_same_v<T, godot::Variant>) {
                constexpr godot::Variant::Type TYPE = static_cast<godot::Variant::Type>(
                    godot::GetTypeInfo<T>::VARIANT_TYPE
                );
                write_type(TYPE);
                Wire<TYPE>::store(*this, p_value);
            } else {
                encode(p_value);
            }
        }

        void write_object(const uintptr_t p_ptr, const godot::ObjectID p_id) {
            rewind();
            write<uint64_t>(p_ptr);
            write<uint64_t>(p_id);
        }

        godot::Variant decode() { return DECODERS[read_type()](*this); }

        uint32_t decode_args(godot::Variant* args) {
            rewind();
            const uint32_t size = read<uint32_t>();
            for (uint32_t i = 0; i < size; ++i) {
                args[i] = decode();
            }
            return size;
        }

        godot::Variant decode_ret() {
            rewind();
            return decode();
        }

        void encode(const godot::Variant& p_variant) {
            const godot::Variant::Type type = p_variant.get_type();
            write_type(type);
            ENCODERS[type](*this, p_variant);
        }

        void encode_args(const godot::Variant** p_args, const int args_size) {
            rewind();
            write<uint32_t>(args_size);
            for (int i = 0; i < args_size; ++i) {
                encode(*p_args[i]);
            }
        }

    private:
        _FORCE_INLINE_ godot::Variant::Type read_type() {
            align();
            return static_cast<godot::Variant::Type>(read<uint64_t>());
        }

        _FORCE_INLINE_ void write_type(godot::Variant::Type p_type) {
            align();
            write<uint64_t>(p_type);
        }

        template<class T>
        T read_arg() {
            if constexpr (!std::is_same_v<T, godot::Variant>) {
                constexpr godot::Variant::Type TYPE = static_cast<godot::Variant::Type>(
                    godot::GetTypeInfo<T>::VARIANT_TYPE
                );
                godot::Variant::Type sent = read_type();
                JVM_DEV_ASSERT(sent == TYPE, "Expected an argument of type %s but the JVM sent %s.", TYPE, sent);
                return static_cast<T>(Wire<TYPE>::load(*this));
            } else {
                return decode();
            }
        }
    };

    static Transfer* get_transfer() {
        if (unlikely(!transfer.is_init())) {
            jni::Env& env = jni::Jvm::current_env();
            jni::JObject buffer = get_instance().wrapped.call_object_method(env, GET_BUFFER);
            JVM_DEV_ASSERT(!buffer.is_null(), "Buffer is null");
            transfer = Transfer(static_cast<uint8_t*>(env.get_direct_buffer_address(buffer)));
            buffer.delete_local_ref(env);
        }
        return &transfer;
    }

private:
    static inline constinit thread_local Transfer transfer;
};

#endif // GODOT_JVM_VARIANT_BUFFER_H
