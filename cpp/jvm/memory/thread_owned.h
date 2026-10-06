#ifndef GODOT_JVM_THREAD_OWNED_H
#define GODOT_JVM_THREAD_OWNED_H

#include <core/defs.hpp>
#include <core/memory.hpp>

// One instance of T per thread, built on that thread's first use and freed when the thread ends. For state too large
// to leave in thread-local storage for every thread that never asks for it.
//
// The pointer and the freeing are deliberately two thread_locals. A `constinit` thread_local takes a type that is both
// trivially constructible and trivially destructible, and anything that frees what it owns is neither; without
// `constinit` the variable is dynamically initialised, which puts a module-wide guard and a `__dyn_tls_on_demand_init`
// call in front of every access. So the pointer stays trivial and keeps a guard-free access, and the closer -- which
// holds nothing but a destructor -- is touched only on the one call per thread that allocates.
template<class T>
class ThreadOwned {
    static inline constinit thread_local T* instance = nullptr;

    struct Closer {
        ~Closer() {
            godot::memdelete(instance);
            instance = nullptr;
        }
    };

    _NO_INLINE_ static T& open() {
        thread_local Closer closer;
        instance = memnew(T);
        return *instance;
    }

public:
    _FORCE_INLINE_ static T& get() {
        if (unlikely(instance == nullptr)) { return open(); }
        return *instance;
    }
};

#endif // GODOT_JVM_THREAD_OWNED_H
