#include "jvm.h"

#include "logging.h"

namespace jni {
    Jvm* Jvm::_instance = nullptr;

    Jvm::Jvm(JavaVM* vm, JvmType vm_type, jint version) : vm(vm), version(version), vm_type(vm_type) {}

    void Jvm::initialize(JavaVM* p_vm, JvmType p_type, jint p_version) {
        _instance = new Jvm(p_vm, p_type, p_version);
    }

    bool Jvm::destroy() {
        if (_instance == nullptr) { return true; }

        if (thread_env.is_valid()) { detach(); }
        if (_instance->vm->DestroyJavaVM() != JNI_OK) { return false; }

        delete _instance;
        _instance = nullptr;
        return true;
    }

    void Jvm::attach() {
        JNIEnv* r_env;
#ifdef ANDROID_ENABLED
        jint result = _instance->vm->AttachCurrentThread(&r_env, nullptr);
#else
        jint result = _instance->vm->AttachCurrentThread((void**) &r_env, nullptr);
#endif
        JVM_DEV_ASSERT(result == JNI_OK, "Failed to attach vm to current thread!");
        thread_env = Env(r_env);
    }

    void Jvm::detach() {
        jint result = _instance->vm->DetachCurrentThread();
        JVM_DEV_ASSERT(result == JNI_OK, "Failed to detach vm to current thread!");
        thread_env = Env(nullptr);
    }

    void Jvm::fetch_thread_env() {
        JNIEnv* r_env;
        jint result = _instance->vm->GetEnv((void**) &r_env, _instance->version);
        JVM_DEV_ASSERT(result != JNI_EDETACHED, "Current thread is not attached!");
        thread_env = Env(r_env);
    }

    JvmType Jvm::get_type() {
        return _instance->vm_type;
    }
} // namespace jni
