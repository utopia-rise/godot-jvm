#ifndef GODOT_JVM_METHODS_H
#define GODOT_JVM_METHODS_H

#include <jni.h>

namespace jni {
    typedef jmethodID MethodID;

    struct VoidMethodID {
        jmethodID methodId = nullptr;
    };

    struct BooleanMethodID {
        jmethodID methodId = nullptr;
    };

    struct IntMethodID {
        jmethodID methodId = nullptr;
    };

    struct LongMethodID {
        jmethodID methodId = nullptr;
    };

    struct FloatMethodID {
        jmethodID methodId = nullptr;
    };

    struct DoubleMethodID {
        jmethodID methodId = nullptr;
    };

    struct ObjectMethodID {
        jmethodID methodId = nullptr;
    };
}// namespace jni

#endif// GODOT_JVM_METHODS_H
