#include "variant_stack.h"

#include <core/defs.hpp>
#include <core/memory.hpp>

struct VariantStackData {
    godot::Variant args[VariantStack::MAX_SIZE];
    const godot::Variant* args_ptr[VariantStack::MAX_SIZE];
    int offset = 0;

    VariantStackData() {
        for (int i = 0; i < VariantStack::MAX_SIZE; ++i) {
            args_ptr[i] = &args[i];
        }
    }
};

// Heap allocated so a thread that never calls the engine does not carry the whole stack in its thread local storage,
// and held by an object here so the thread ending destroys it: a bare thread_local pointer is trivially destructible
// and would take the pointer with it while leaving the allocation behind.
struct VariantStackHolder {
    VariantStackData* data = nullptr;

    ~VariantStackHolder() {
        if (data != nullptr) { godot::memdelete(data); }
    }
};

static VariantStackData& get_thread_data() {
    thread_local VariantStackHolder holder;
    if (unlikely(holder.data == nullptr)) { holder.data = memnew(VariantStackData); }
    return *holder.data;
}

VariantStack::Slots VariantStack::push(uint32_t p_count) {
    VariantStackData& data = get_thread_data();
    if (unlikely(data.offset + static_cast<int>(p_count) > MAX_SIZE)) { return {}; }

    Slots slots = {data.args + data.offset, data.args_ptr + data.offset};
    data.offset += static_cast<int>(p_count);
    return slots;
}

void VariantStack::pop(uint32_t p_count) {
    VariantStackData& data = get_thread_data();
    data.offset -= static_cast<int>(p_count);

    // Cleared here rather than on the next reservation, so whatever the arguments hold is released with the call.
    for (uint32_t i = 0; i < p_count; ++i) {
        data.args[data.offset + static_cast<int>(i)] = godot::Variant();
    }
}
