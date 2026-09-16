#ifndef GODOT_JVM_SHARED_BUFFER_H
#define GODOT_JVM_SHARED_BUFFER_H

#include "core/defs.hpp"

#include <cstdint>
#include <cstring>
#ifdef DEBUG_ENABLED
#include "logging.h"
#endif

// A typed cursor over the per-thread byte buffer the JVM and the native side share. This is the only place that
// knows how a value becomes bytes: everything above it reads and writes typed values. Values are laid down in the
// native byte order, which is the little-endian order the JVM side configures its ByteBuffer with.
class SharedBuffer {
    uint8_t* ptr = nullptr;
    int position = 0;

#ifdef DEBUG_ENABLED
    int capacity = 0;
#endif

    _FORCE_INLINE_ uint8_t* advance(uint32_t p_size) {
        uint8_t* cursor = ptr + position;
        position += p_size;
#ifdef DEBUG_ENABLED
        JVM_ERR_FAIL_COND_V_MSG(position > capacity, cursor, "Shared buffer overflow!");
#endif
        return cursor;
    }

public:
    SharedBuffer() = default;

#ifdef DEBUG_ENABLED
    SharedBuffer(uint8_t* p_ptr, int p_position, int p_capacity);
#else
    SharedBuffer(uint8_t* p_ptr, int p_position);
#endif

    ~SharedBuffer() = default;

    _FORCE_INLINE_ bool is_init() const { return ptr != nullptr; }

    _FORCE_INLINE_ void rewind() { position = 0; }

    template<class T>
    _FORCE_INLINE_ T read() {
        T value;
        memcpy(&value, advance(sizeof(T)), sizeof(T));
        return value;
    }

    template<class T>
    _FORCE_INLINE_ void write(const T& p_value) {
        memcpy(advance(sizeof(T)), &p_value, sizeof(T));
    }

    _FORCE_INLINE_ const uint8_t* read_bytes(uint32_t p_size) { return advance(p_size); }

    _FORCE_INLINE_ void write_bytes(const void* p_source, uint32_t p_size) {
        memcpy(advance(p_size), p_source, p_size);
    }
};

#endif // GODOT_JVM_SHARED_BUFFER_H
