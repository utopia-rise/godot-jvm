#ifndef GODOT_LOADER_ENV_H
#define GODOT_LOADER_ENV_H

#include "logging.h"

#include <jni.h>

#include <variant/string.hpp>

namespace jni {

    class JObject;
    class JClass;
    class JThrowable;
    class JArray;
    class JObjectArray;
    class JByteArray;
    class JIntArray;
    class JLongArray;
    class JFloatArray;
    class JDoubleArray;
    class JString;

    class Env {
        friend class JObject;
        friend class JClass;
        friend class JThrowable;
        friend class JArray;
        friend class JObjectArray;
        friend class JByteArray;
        friend class JIntArray;
        friend class JLongArray;
        friend class JFloatArray;
        friend class JDoubleArray;

        JNIEnv* env;

        static inline void (*exception_handler)(Env, JThrowable) = nullptr;

    public:
        // Trivially constructible on purpose, so that the thread-local instance below can be constant-initialised.
        // A type that needs code to run before first use makes the compiler guard every access to that storage with a
        // flag check and a call, on a path every single crossing takes. Leaving the member uninitialised is what lets
        // the storage be zero-initialised instead (spelled per compiler by JVM_ZERO_INIT_THREAD_LOCAL); the variable
        // is declared constinit so a future member with an initialiser fails the build rather than quietly bringing
        // the guard back.
        Env() = default;

        // Defined here rather than in the .cpp because the build has no link-time code generation, so an out-of-line
        // body would make every one of these a real call for a single store.
        Env(JNIEnv* p_env) : env(p_env) {}

        Env(const Env&) = default;
        Env& operator=(const Env&) = default;

        bool is_valid() const { return env != nullptr; }

        static void set_exception_handler(void (*p_exception_handler)(Env, JThrowable));

        JavaVM* get_jvm();

        void push_local_frame(int capacity);
        void pop_local_frame();

        JClass find_class(const char* name);

        void throw_new(const char* message);

        JObject new_string(const godot::String& str);
        godot::String from_jstring(JString str);

        bool exception_check();
        void exception_describe();
        void exception_clear();
        JThrowable exception_occurred();

        void handle_exception();

        void* get_direct_buffer_address(const jni::JObject& buffer);
        int get_direct_buffer_capacity(const jni::JObject& buffer);

        bool is_same_object(const jni::JObject& obj_1, const jni::JObject& obj_2);
    };
} // namespace jni

#endif // GODOT_LOADER_ENV_H
