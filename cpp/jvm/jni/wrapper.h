#ifndef GODOT_JVM_WRAPPER_H
#define GODOT_JVM_WRAPPER_H

#include "env.h"
#include "jvm.h"
#include "types.h"
#include "local_frame.h"

namespace jni {

    template<class T>
    inline T JObject::new_global_ref(Env& env) {
        auto ref = env.env->NewGlobalRef(obj);
        return T {JObject(ref).obj};
    }

    template<class T>
    inline T JObject::new_weak_ref(Env& env) {
        auto ref = env.env->NewWeakGlobalRef(obj);
        return T {JObject(ref).obj};
    }

    static inline jvalue to_jni_arg(JObject j_object) {
        return static_cast<JValue>(j_object.obj).value;
    }

    static inline jvalue to_jni_arg(void* ptr) {
        return static_cast<JValue>(static_cast<jlong>(reinterpret_cast<uintptr_t>(ptr))).value;
    }

    static inline jvalue to_jni_arg(long l) {
        return static_cast<JValue>(static_cast<jlong>(l)).value;
    }

    static inline jvalue to_jni_arg(uint32_t uint32) {
        return static_cast<JValue>(static_cast<jint>(uint32)).value;
    }

    static inline jvalue to_jni_arg(uint64_t uint64) {
        return static_cast<JValue>(static_cast<jlong>(uint64)).value;
    }

    static inline jvalue to_jni_arg(int i) {
        return static_cast<JValue>(static_cast<jint>(i)).value;
    }

    static inline jvalue to_jni_arg(bool b) {
        return static_cast<JValue>(static_cast<jboolean>(b)).value;
    }

}// namespace jni

#endif// GODOT_JVM_WRAPPER_H
