#ifndef GODOT_JVM_VARIANT_STACK_H
#define GODOT_JVM_VARIANT_STACK_H

#include "constraints.h"
#include "jvm/memory/thread_owned.h"

#include <core/defs.hpp>
#include <core/memory.hpp>
#include <variant/variant.hpp>

// Scratch space for the arguments of an engine call, one stack per thread. The engine takes its arguments as an array
// of pointers to Variants, so the stack hands out both the values and the pointers to them. It is a stack rather than
// a single buffer because a call can reenter: a method the JVM invokes can call back into the JVM, which can call the
// engine again before the first call returns.
class VariantStack {
public:
    static constexpr int MAX_SIZE = MAX_ARGUMENT_COUNT * 8;

    struct Slots {
        godot::Variant* args = nullptr;
        const godot::Variant** args_ptr = nullptr;

        bool is_valid() const { return args != nullptr; }
    };

private:
    struct Data {
        godot::Variant args[MAX_SIZE];
        const godot::Variant* args_ptr[MAX_SIZE];
        int offset = 0;

        Data() {
            for (int i = 0; i < MAX_SIZE; ++i) {
                args_ptr[i] = &args[i];
            }
        }
    };

    using Stack = ThreadOwned<Data>;

public:
    static Slots push(uint32_t p_count) {
        Data& data = Stack::get();
        if (unlikely(data.offset + static_cast<int>(p_count) > MAX_SIZE)) { return {}; }

        Slots slots = {data.args + data.offset, data.args_ptr + data.offset};
        data.offset += static_cast<int>(p_count);
        return slots;
    }

    _FORCE_INLINE_ static void pop(uint32_t p_count) {
        Data& data = Stack::get();
        data.offset -= static_cast<int>(p_count);

        for (uint32_t i = 0; i < p_count; ++i) {
            data.args[data.offset + static_cast<int>(i)] = godot::Variant();
        }
    }
};

#endif // GODOT_JVM_VARIANT_STACK_H
