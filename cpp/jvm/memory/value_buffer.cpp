#include "value_buffer.h"

#include "jvm/memory/buffer_wire.h"

#include <array>
#include <utility>

// One entry longer: a return can also be announced as REF_COUNTED_RETURN_TYPE, which has a row of its own.
using ReturnTypes = std::make_index_sequence<ValueBuffer::REF_COUNTED_RETURN_TYPE + 1>;

// How many bytes a return of each type occupies in the frame, which is the value itself for a type the engine can
// write where the JVM reads it and an address for one the JVM keeps past the call.
template<size_t... I>
static constexpr auto make_ret_sizes(std::index_sequence<I...>) {
    return std::array<uint32_t, sizeof...(I)> {Wire<static_cast<godot::Variant::Type>(I)>::PTR_SLOT_SIZE...};
}

// Making the call belongs to the row because where the engine writes does: into the slot for a value the JVM reads
// out of the frame, into an allocation of its own for one it keeps after the frame is reused. The row runs the call
// between the two halves it owns, so neither the address the engine was given nor the order of the halves is
// something a caller can get wrong.
template<size_t... I>
static constexpr auto make_ret_calls(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::ptr_call...};
}

ValueBuffer::~ValueBuffer() = default;

jlong ValueBuffer::buffer_address(JNIEnv* p_raw_env, jobject, jobject p_buffer) {
    jni::Env env(p_raw_env);
    jni::JObject buffer(p_buffer);
    JVM_DEV_ASSERT(!buffer.is_null(), "Buffer is null");
    return reinterpret_cast<jlong>(env.get_direct_buffer_address(buffer));
}

void ValueBuffer::Frame::read_args(uint32_t p_count, const void** r_args) {
    // The offset lives in a local for the whole loop and is written back once. No row touches the frame - each takes
    // the offset and hands the new one back - so nothing here has to be kept coherent in memory, and the offset stays
    // in a register instead of being stored per value and reloaded on the next one.
    // The region is copied out too: writing r_args could alias the frame as far as the compiler knows, so leaving it
    // as a member would reload it after every argument.
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

        // A row whose payload is the value itself is inlined here; the rest go through their own row.
        if (uint32_t size = PTR_ARG_SIZES[value_type]; likely(size != 0)) {
            r_args[i] = base + at;
            at += size;
        } else {
            at = PTR_ARG_READERS[value_type](base, at, &r_args[i]);
        }
    }
    position = static_cast<int>(at);
}

void ValueBuffer::Frame::call_only_ret(godot::Variant::Type p_type, ptrdiff_t p_at, const raw_godot::PtrCall& p_call) {
    static constexpr auto calls = make_ret_calls(ReturnTypes());

    // The position never moves: a getter frame holds nothing after its return, so nobody reads it again.
    calls[p_type](ptr + p_at, p_call);
}

void ValueBuffer::Frame::call_ret(godot::Variant::Type p_type, const raw_godot::PtrCall& p_call) {
    static constexpr auto sizes = make_ret_sizes(ReturnTypes());
    static constexpr auto calls = make_ret_calls(ReturnTypes());

    // The return carries no type tag: the generator knows what it asked for and hardcoded the read on the JVM side,
    // so the tag would only be eight bytes written for nobody. The alignment the tag used to carry stays here, and
    // the JVM seals its frame on the same boundary.
    align();
    calls[p_type](reserve(sizes[p_type]), p_call);
}

void ValueBuffer::set_size_factor(jni::Env& p_env, int p_factor) {
    jvalue args[1] = {jni::to_jni_arg(p_factor)};
    wrapped.call_void_method(p_env, SET_SIZE_FACTOR, args);
}
