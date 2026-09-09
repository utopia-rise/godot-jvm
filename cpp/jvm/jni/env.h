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
        Env(JNIEnv*);

        Env(const Env&) = default;
        Env& operator=(const Env&) = default;

        static void set_exception_handler(void (*p_exception_handler)(Env, JThrowable));

        JavaVM* get_jvm();

        void push_local_frame(int capacity);
        void pop_local_frame();

        JClass find_class(const char* name);

        void throw_new(const char* message);

        JObject new_string(const char* str);
        godot::String from_jstring(JString str);

        bool exception_check();
        void exception_describe();
        void exception_clear();
        JThrowable exception_occurred();

        void handle_exception();

        void* get_direct_buffer_address(const jni::JObject& buffer);
        int get_direct_buffer_capacity(const jni::JObject& buffer);

        bool is_same_object(const jni::JObject& obj_1, const jni::JObject& obj_2);

        bool is_valid();
    };
} // namespace jni

#endif // GODOT_LOADER_ENV_H
