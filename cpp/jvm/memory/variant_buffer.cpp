#include "variant_buffer.h"

#include "jvm/jni/jvm.h"

#include <array>
#include <utility>

constinit static thread_local VariantBuffer::Transfer transfer;

using VariantTypes = std::make_index_sequence<godot::Variant::VARIANT_MAX>;

template<size_t... I>
static constexpr auto make_variant_readers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::template variant_read<VariantBuffer::Transfer>...};
}

template<size_t... I>
static constexpr auto make_variant_writers(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::template variant_write<VariantBuffer::Transfer>...};
}

VariantBuffer::~VariantBuffer() = default;

VariantBuffer::Transfer* VariantBuffer::get_transfer() {
    if (unlikely(!transfer.is_init())) {
        jni::Env& env = jni::Jvm::current_env();
        jni::JObject buffer = get_instance().wrapped.call_object_method(env, GET_BUFFER);
        JVM_DEV_ASSERT(!buffer.is_null(), "Buffer is null");
        transfer = Transfer(static_cast<uint8_t*>(env.get_direct_buffer_address(buffer)));
        buffer.delete_local_ref(env);
    }
    return &transfer;
}

godot::Variant VariantBuffer::Transfer::decode() {
    static constexpr auto readers = make_variant_readers(VariantTypes());
    return readers[read_type(this)](this);
}

void VariantBuffer::Transfer::encode(const godot::Variant& p_variant) {
    static constexpr auto writers = make_variant_writers(VariantTypes());
    write_type(this, p_variant.get_type());
    writers[p_variant.get_type()](this, p_variant);
}

uint32_t VariantBuffer::Transfer::read_args(godot::Variant* args) {
    rewind();
    const uint32_t size = read<uint32_t>();
    for (uint32_t i = 0; i < size; ++i) {
        args[i] = decode();
    }
    return size;
}

godot::Variant VariantBuffer::Transfer::read_ret() {
    rewind();
    return decode();
}

void VariantBuffer::Transfer::write_args(const godot::Variant** p_args, const int args_size) {
    rewind();
    write<uint32_t>(args_size);
    for (int i = 0; i < args_size; ++i) {
        encode(*p_args[i]);
    }
}

void VariantBuffer::Transfer::write_object(const uintptr_t ptr, const godot::ObjectID id) {
    rewind();
    write<uint64_t>(ptr);
    write<uint64_t>(id);
}
