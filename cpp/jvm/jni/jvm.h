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

        static Env current_env();

        static JvmType get_type();
    };
} // namespace jni

VARIANT_ENUM_CAST(jni::JvmType)

#endif // GODOT_LOADER_JVM_H
