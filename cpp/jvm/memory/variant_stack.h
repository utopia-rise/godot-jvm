#ifndef GODOT_JVM_VARIANT_STACK_H
#define GODOT_JVM_VARIANT_STACK_H

#include "constraints.h"

#include <variant/variant.hpp>

// Scratch space for the arguments of an engine call, one stack per thread. The engine takes its arguments as an array
// of pointers to Variants, so the stack hands out both the values and the pointers to them. It is a stack rather than
// a single buffer because a call can reenter: a method the JVM invokes can call back into the JVM, which can call the
// engine again before the first call returns.
class VariantStack {
public:
    static constexpr int MAX_SIZE = MAX_FUNCTION_ARG_COUNT * 8;

    struct Slots {
        godot::Variant* args = nullptr;
        const godot::Variant** args_ptr = nullptr;

        bool is_valid() const { return args != nullptr; }
    };

    // Invalid slots once the reentrancy depth is exhausted, leaving the caller to use storage of its own.
    static Slots push(uint32_t p_count);
    static void pop(uint32_t p_count);
};

#endif // GODOT_JVM_VARIANT_STACK_H
