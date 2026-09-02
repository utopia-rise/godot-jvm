#ifndef GODOT_JVM_BRIDGES_UTILS_H
#define GODOT_JVM_BRIDGES_UTILS_H

#include "jvm/jni/wrapper.h"

namespace bridges {

    template<class T>
    static inline T* from_uint_to_ptr(jlong raw_ptr) {
        return reinterpret_cast<T*>(static_cast<uintptr_t>(raw_ptr));
    }
} // namespace bridges

#endif // GODOT_JVM_BRIDGES_UTILS_H
