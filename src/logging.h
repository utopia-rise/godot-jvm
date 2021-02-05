//
// Created by cedric on 05.02.21.
//

#ifndef GODOT_JVM_LOGGING_H
#define GODOT_JVM_LOGGING_H

#include <core/engine.h>
#include <core/print_string.h>

namespace logging {
    static inline void verbose(const String& message) {
        print_verbose(vformat("Godot-JVM: %s", message));
    }

    static inline void info(const String& message) {
        print_line(vformat("Godot-JVM: %s", message));
    }

    static inline void warning(const String& message) {
        WARN_PRINT(vformat("Godot-JVM: %s", message))
    }

    static inline void error(const String& message) {
        ERR_PRINT(vformat("Godot-JVM: %s", message))
    }

    static inline void* error(bool condition, Error* ret_var, const String& message) {
        ERR_FAIL_COND_V_MSG(condition, ret_var, vformat("Godot-JVM: %s", message))
        return nullptr;
    }

    static inline void error(bool condition, const String& message) {
        CRASH_COND_MSG(condition, vformat("Godot-JVM: %s", message))
    }
}

#endif //GODOT_JVM_LOGGING_H
