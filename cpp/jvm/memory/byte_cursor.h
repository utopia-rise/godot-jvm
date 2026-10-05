#ifndef GODOT_JVM_BYTE_CURSOR_H
#define GODOT_JVM_BYTE_CURSOR_H

#include "logging.h"

#include <cstdint>
#include <cstring>

// A position over a byte region the JVM owns. The shared buffers are direct ByteBuffers allocated on the
// JVM side, so a cursor borrows that memory rather than holding it, and every read or write goes through reserve(),
// which moves the position along and, in a debug build, reports an overrun.
//
// Trivially constructible on purpose. An instance that lives in thread-local storage and needs code to run before
// first use makes the compiler guard every access to that storage with a flag check and a call to
// __dyn_tls_on_demand_init, on a path taken millions of times a second.
//
// Leaving the members without initialisers is what keeps the defaulted constructor trivial, and a thread-local of a
// trivially constructible type is zero-initialised rather than dynamically initialised. Declare such a variable
// `constinit` with no initialiser, so that a future member with an initialiser fails the build rather than quietly
// bringing the guard back, and leave it at that: MSVC rejects `= {}` there, and it rejects the declaration outright
// once the constructor stops being trivial, whether the members carry initialisers or the constructor is marked
// `constexpr`, and whether the variable sits in a header or a .cpp -- all four were tried.
//
// Clangd reports that declaration as "variable does not have a constant initializer", because it wants a constexpr
// constructor where MSVC wants a trivial one, and a defaulted constructor cannot be both: constexpr has to initialise
// every member, trivial has to initialise none. No form satisfies both, so the form every compiler this project
// builds with accepts is the one that wins. jni::Env carries the same shape and the same diagnostic.
//
// It holds no capacity and reports no overrun. The JVM side owns both buffers: it sizes them for the worst case a
// call can reach, checks in a debug build that the frame it is about to open still fits, and cannot overrun them on
// the way in because every ByteBuffer write is bounds checked whatever the build. What is left for a bound here to
// catch is this side misreading a region the JVM wrote correctly, which is a bug in the binding rather than
// something a user can provoke.
//
// Each buffer derives its own cursor type from this so that one cannot be passed where the other is expected: they
// address different regions with different layouts.
class ByteCursor {
protected:
    // Visible to the two derived cursors so a decoding loop can hold the position in a local and write it back once,
    // instead of storing it per value and reloading it on the next one.
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

    _FORCE_INLINE_ const uint8_t* read_bytes(uint32_t p_size) { return reserve(p_size); }

    _FORCE_INLINE_ void write_bytes(const void* p_source, uint32_t p_size) {
        memcpy(reserve(p_size), p_source, p_size);
    }
};

#endif // GODOT_JVM_BYTE_CURSOR_H
