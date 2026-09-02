#ifndef GODOT_JVM_LONG_STRING_QUEUE_H
#define GODOT_JVM_LONG_STRING_QUEUE_H

#include "jvm/wrapper/jvm_singleton_wrapper.h"

JVM_SINGLETON_WRAPPER(LongStringQueue, "godot.internal.memory.LongStringQueue") {
    SINGLETON_CLASS(LongStringQueue)
    // clang-format off
    JNI_VOID_METHOD(QUEUE_STRING)
    JNI_VOID_METHOD(SET_STRING_MAX_SIZE)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(QUEUE_STRING, "queueString", "(Ljava/lang/String;)V")
        INIT_JNI_METHOD(SET_STRING_MAX_SIZE, "setStringMaxSize", "(I)V")
        INIT_NATIVE_METHOD("sendStringToCPP", "(Ljava/lang/String;)V", LongStringQueue::send_string_to_cpp)
    )
    // clang-format on

public:
    static uint16_t max_string_size;

    void set_string_max_size(jni::Env & p_env, int max_size);
    void send_string_to_jvm(jni::Env & p_env, const godot::String& str);

    static godot::String poll_string();
    static void queue_string(const godot::String& str);

    static void send_string_to_cpp(JNIEnv * p_raw_env, jobject p_instance, jstring p_string);
};

#endif // GODOT_JVM_LONG_STRING_QUEUE_H
