#ifndef GODOT_JVM_SHARED_BUFFER_H
#define GODOT_JVM_SHARED_BUFFER_H

#include "core/defs.hpp"

#include <cstdint>
#ifdef DEBUG_ENABLED
#include "logging.h"
#endif

class SharedBuffer {
private:
    uint8_t* ptr;
    int position;

#ifdef DEBUG_ENABLED
    int capacity;
#endif

public:
    SharedBuffer();

#ifdef DEBUG_ENABLED
    SharedBuffer(uint8_t* p_ptr, int p_position, int p_capacity);
#else
    SharedBuffer(uint8_t* p_ptr, int p_position);
#endif

    ~SharedBuffer() = default;

    _FORCE_INLINE_ uint8_t* get_cursor() const { return ptr + position; }

    _FORCE_INLINE_ void increment_position(uint32_t increment) {
        position += increment;
#ifdef DEBUG_ENABLED
        JVM_ERR_FAIL_COND_MSG(position > capacity, "Shared buffer overflow!");
#endif
    }

    _FORCE_INLINE_ void decrement_position(uint32_t decrement) {
        position -= decrement;
#ifdef DEBUG_ENABLED
        JVM_ERR_FAIL_COND_MSG(position < 0, "Shared buffer underflow!");
#endif
    }

    _FORCE_INLINE_ bool is_init() const { return ptr != nullptr; }

    _FORCE_INLINE_ void rewind() { position = 0; }
};

#endif // GODOT_JVM_SHARED_BUFFER_H
