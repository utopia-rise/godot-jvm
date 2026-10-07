#ifndef GODOT_JVM_BYTE_CURSOR_H
#define GODOT_JVM_BYTE_CURSOR_H

#include "core/variant_allocator.h"
#include "logging.h"

#include <cstdint>
#include <cstring>

// A position over a byte region the JVM owns and sizes. A cursor borrows that memory rather than holding it and
// carries no bounds of its own; keeping within them is the JVM's job. Each buffer derives its own cursor type so that
// one cannot be passed where the other is expected, and everything either of them needs is declared here so that a
// per-type row can name a cursor without naming a buffer.
//
// Keep it trivially constructible: a thread_local of such a type is zero-initialised, while a single member
// initialiser would put a guard and an init call on every access, on a path taken millions of times a second. The
// `constinit` on the thread_local Transfer turns that mistake into a build failure.
class ByteCursor {
protected:
    // Visible to the derived cursors so a decoding loop can hold the position in a local and write it back once.
    uint8_t* ptr;
    int position;

public:
    ByteCursor() = default;

    ByteCursor(uint8_t* p_ptr, int p_position = 0) : ptr(p_ptr), position(p_position) {
        JVM_DEV_ASSERT(
            (reinterpret_cast<uintptr_t>(p_ptr) & 7) == 0,
            "A shared buffer must start on an eight byte boundary for the engine to read values in place."
        );
    }

    _FORCE_INLINE_ bool is_init() const { return ptr != nullptr; }

    _FORCE_INLINE_ void set_position(int p_position) { position = p_position; }

    _FORCE_INLINE_ void rewind() { position = 0; }

    _FORCE_INLINE_ void align() { position = (position + 7) & ~7; }

    _FORCE_INLINE_ uint8_t* reserve(uint32_t p_size) {
        uint8_t* cursor = ptr + position;
        position += p_size;
        return cursor;
    }

    // Reads a value where the caller says it is, leaving the position alone. A call that knows its own layout has no
    // reason to walk the region, and moving the position would only be a store nothing reads back.
    template<class T>
    _FORCE_INLINE_ T peek(ptrdiff_t p_at) const {
        T value;
        memcpy(&value, ptr + p_at, sizeof(T));
        return value;
    }

    template<class T>
    _FORCE_INLINE_ T read() {
        T value;
        memcpy(&value, reserve(sizeof(T)), sizeof(T));
        return value;
    }

    template<class T>
    _FORCE_INLINE_ void write(const T& p_value) {
        memcpy(reserve(sizeof(T)), &p_value, sizeof(T));
    }

    template<class T>
    _FORCE_INLINE_ T* read_pointer() {
        return reinterpret_cast<T*>(static_cast<uintptr_t>(read<uint64_t>()));
    }

    template<class T>
    _FORCE_INLINE_ void write_pointer(const T& p_value) {
        write<uint64_t>(reinterpret_cast<uintptr_t>(VariantAllocator::alloc(T(p_value))));
    }

    _FORCE_INLINE_ const uint8_t* read_bytes(uint32_t p_size) { return reserve(p_size); }

    _FORCE_INLINE_ void write_bytes(const void* p_source, uint32_t p_size) {
        memcpy(reserve(p_size), p_source, p_size);
    }
};

#endif // GODOT_JVM_BYTE_CURSOR_H
