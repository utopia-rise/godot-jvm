//
// Created by cedric on 05.02.21.
//

#ifndef GODOT_JVM_LOGGING_H
#define GODOT_JVM_LOGGING_H

#include <core/engine.h>
#include <core/print_string.h>

#define LOG_VERBOSE(message) \
    print_verbose(vformat("Godot-JVM: %s", message));

#define LOG_INFO(message) \
    print_line(vformat("Godot-JVM: %s", message));

#define LOG_WARNING(message) \
    WARN_PRINT(vformat("Godot-JVM: %s", message))

#define LOG_ERROR(message) \
    ERR_PRINT(vformat("Godot-JVM: %s", message))

#define JVM_ERR_FAIL_COND_V_MSG(condition, ret_var, message) \
    ERR_FAIL_COND_V_MSG(condition, ret_var, vformat("Godot-JVM: %s", message))

#define JVM_CRASH_COND_MSG(condition, message) \
    CRASH_COND_MSG(condition, vformat("Godot-JVM: %s", message))

#endif //GODOT_JVM_LOGGING_H
