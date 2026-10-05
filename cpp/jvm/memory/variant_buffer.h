#ifndef GODOT_JVM_VARIANT_BUFFER_H
#define GODOT_JVM_VARIANT_BUFFER_H

#include "engine/godot_object.h"
#include "jvm/jvm_instance_wrapper.h"
#include "jvm/jvm_singleton_wrapper.h"
#include "jvm/memory/buffer_wire.h"
#include "jvm/memory/byte_cursor.h"
#include "logging.h"

#include <core/defs.hpp>
#include <core/type_info.hpp>
#include <cstdint>
#include <cstring>
#include <type_traits>
#include <variant/variant.hpp>

// The per-thread buffer every exchange but a ptrcall goes through: bridges, checked engine calls, and calls from the
// engine into JVM code. Each exchange rewinds it, so it only ever holds one call, whose arguments both sides copy out
// before anything else can use it. The Transfer is the only place that knows how a value becomes bytes; values are laid
// down in the native byte order, which is the little-endian order the JVM configures its ByteBuffer with.
// clang-format off
JVM_SINGLETON_WRAPPER(VariantBuffer, "godot.internal.memory.VariantBuffer") {
    SINGLETON_CLASS(VariantBuffer)

    JNI_OBJECT_METHOD(GET_BUFFER)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_BUFFER, "getBuffer", "()Ljava/nio/ByteBuffer;")
    )
    // clang-format on

public:
    // The one exchange the buffer holds. Its own type so that it cannot be handed to the other buffer, and the only
    // place that knows how a value becomes bytes. Every exchange below starts by rewinding, because the buffer holds
    // one call at a time and each of arguments, return value and object payload begins at the start of it; decode() and
    // encode() do not, since they step through a sequence one value at a time.
    class Transfer : public ByteCursor {
    public:
        Transfer() = default;

        explicit Transfer(uint8_t* p_ptr) : ByteCursor(p_ptr) {}

        godot::Variant decode();
        void encode(const godot::Variant& p_variant);

        template<class... Args>
        void read_args(Args&... r_args);
        uint32_t read_args(godot::Variant* args);
        godot::Variant read_ret();

        template<class T>
        void write_ret(const T& p_value);
        void write_args(const godot::Variant** p_args, int args_size);
        void write_object(uintptr_t ptr, godot::ObjectID id);

    private:
        template<class T>
        T decode_arg();
    };

    // The calling thread's transfer. Fetching the JVM's direct buffer needs an environment, but only on the first call
    // from a thread, so it is looked up there rather than asked of every caller.
    static Transfer* get_transfer();
};

template<class T>
void VariantBuffer::Transfer::write_ret(const T& p_value) {
    rewind();
    if constexpr (!std::is_same_v<T, godot::Variant>) {
        constexpr godot::Variant::Type TYPE = static_cast<godot::Variant::Type>(godot::GetTypeInfo<T>::VARIANT_TYPE);
        write_type(this, TYPE);
        Wire<TYPE>::value_write(this, p_value);
    } else {
        encode(p_value);
    }
}

template<class... Args>
void VariantBuffer::Transfer::read_args(Args&... r_args) {
    rewind();
    uint32_t count = read<uint32_t>();
    JVM_DEV_ASSERT(
        count == sizeof...(Args),
        "The bridge reads %s arguments but the JVM sent %s.",
        sizeof...(Args),
        count
    );
    (void(r_args = decode_arg<Args>()), ...);
}

template<class T>
T VariantBuffer::Transfer::decode_arg() {
    if constexpr (!std::is_same_v<T, godot::Variant>) {
        constexpr godot::Variant::Type TYPE = static_cast<godot::Variant::Type>(godot::GetTypeInfo<T>::VARIANT_TYPE);
        godot::Variant::Type sent = read_type(this);
        JVM_DEV_ASSERT(sent == TYPE, "Expected an argument of type %s but the JVM sent %s.", TYPE, sent);
        return static_cast<T>(Wire<TYPE>::value_read(this));
    } else {
        return decode();
    }
}

#endif // GODOT_JVM_VARIANT_BUFFER_H
