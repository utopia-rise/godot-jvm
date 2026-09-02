#ifndef GODOT_LOADER_INIT_ARGS_H
#define GODOT_LOADER_INIT_ARGS_H

#include "jvm_user_configuration.h"

#include <variant/string.hpp>
#include <templates/local_vector.hpp>
#include <jni.h>

class JvmManager;
namespace godot {
    class GodotJvm;
}


class JvmOptions {
    friend class JvmManager;
    friend class godot::GodotJvm;

#ifdef ANDROID_ENABLED
    int version {JNI_VERSION_1_6};
#else
    int version {JNI_VERSION_1_8};
#endif

    godot::LocalVector<godot::CharString> options;

    void add_jni_checks();
    void add_debug_options(uint16_t p_port, godot::String& p_address, bool p_wait);
    void add_jmx_option(uint16_t p_port);
    void add_custom_options(const godot::String& custom_options);

public:
    JvmOptions() = default;
};

#endif// GODOT_LOADER_INIT_ARGS_H
