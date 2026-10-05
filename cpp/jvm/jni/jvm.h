#ifndef GODOT_LOADER_JVM_H
#define GODOT_LOADER_JVM_H

#include "env.h"
#include "jni.h"

#include <godot_cpp/core/binder_common.hpp>

namespace jni {
    typedef jint(JNICALL* CreateJavaVM)(JavaVM**, void**, void*);

    enum JvmType {
        NONE = 0,
        JVM = 1,
        GRAAL_NATIVE_IMAGE = 2,
        ART = 3,
    };

    class Jvm {
        static Jvm* _instance;

        // The JNIEnv of the calling thread. constinit, so reading it is a plain thread-local load rather than a
        // guarded one: see the note on Env's default constructor.
        static inline constinit thread_local Env thread_env;

        JavaVM* vm = nullptr;
        jint version = 0;
        JvmType vm_type = JvmType::NONE;

        Jvm(JavaVM* vm, JvmType vm_type, jint version);
        ~Jvm() = default;

    public:
        Jvm() = delete;
        Jvm(const Jvm&) = delete;
        void operator=(const Jvm&) = delete;
        Jvm& operator=(Jvm&&) noexcept = delete;
        Jvm(Jvm&&) noexcept = delete;

        static void initialize(JavaVM* p_vm, JvmType p_type, jint p_version);
        static bool destroy();

        static void attach();
        static void detach();

        static void fetch_thread_env();

        // Inline and by reference: every crossing in both directions goes through here, and with no link-time code
        // generation an out-of-line body would add a call, and a copy, to each of them. Fetching the environment for a
        // thread that has not used it yet stays out of line, where it belongs.
        _FORCE_INLINE_ static Env& current_env() {
            if (unlikely(!thread_env.is_valid())) { fetch_thread_env(); }
            return thread_env;
        }

        static JvmType get_type();
    };
} // namespace jni

VARIANT_ENUM_CAST(jni::JvmType)

#endif // GODOT_LOADER_JVM_H
