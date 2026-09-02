#include "env.h"

#include "types.h"

using namespace godot;

namespace jni {


    void Env::set_exception_handler(void (*p_exception_handler)(Env, JThrowable)) {
      exception_handler = p_exception_handler;
    }

    Env::Env(JNIEnv* env) {
        this->env = env;
    }

    void Env::push_local_frame(int capacity) {
        auto result = env->PushLocalFrame(capacity);
        JVM_ERR_FAIL_COND_MSG(result != JNI_OK, "Failed to push local frame!");
    }

    void Env::pop_local_frame() {
        env->PopLocalFrame(nullptr);
    }

    bool Env::is_valid() {
        return env != nullptr;
    }

    //Support fully qualified class names with "a/b/c" and "a.b.c" format
    JClass Env::find_class(const char* name) {
        jclass cls = env->FindClass(String(name).replace(".", "/").utf8().get_data());
        JVM_DEV_ASSERT(cls, "Class not found: %s", name);
        handle_exception();
        return JClass(cls);
    }

    void Env::throw_new(const char* message) {
        jclass exception_class {env->FindClass("java/lang/RuntimeException")};
        if (exception_class == nullptr) { return; }

        env->ThrowNew(exception_class, message);
        env->DeleteLocalRef(exception_class);
    }

    bool Env::exception_check() {
        return env->ExceptionCheck();
    }

    void Env::exception_describe() {
        env->ExceptionDescribe();
    }

    void Env::exception_clear() {
        env->ExceptionClear();
    }

    JThrowable Env::exception_occurred() {
        return env->ExceptionOccurred();
    }

    void Env::handle_exception() {
        if (unlikely(exception_check())) {
            if(exception_handler) {
                JThrowable throwable = exception_occurred();
                exception_clear();
                exception_handler(*this, throwable);
            } else {
                exception_describe();
                exception_clear();
            }
        }
    }

    void* Env::get_direct_buffer_address(const jni::JObject& buffer) {
        void* res = env->GetDirectBufferAddress(buffer.obj);
        handle_exception();
        return res;
    }

    int Env::get_direct_buffer_capacity(const JObject& buffer) {
        auto capacity = env->GetDirectBufferCapacity(buffer.obj);
        handle_exception();
        return capacity;
    }

    bool Env::is_same_object(const JObject& obj_1, const JObject& obj_2) {
        return env->IsSameObject(obj_1.obj, obj_2.obj);
    }

    JObject Env::new_string(const char* str) {
        auto jstr = env->NewStringUTF(str);
        handle_exception();
        return JObject(jstr);
    }

    String Env::from_jstring(jni::JString str) {
        auto jstr = (jstring) str.obj;
        auto utfString = env->GetStringUTFChars(jstr, nullptr);
        String ret = String::utf8(utfString);
        handle_exception();
        env->ReleaseStringUTFChars(jstr, utfString);
        return ret;
    }

    JavaVM* Env::get_jvm() {
        JavaVM* jvm;
        env->GetJavaVM(&jvm);
        return jvm;
    }
}// namespace jni
