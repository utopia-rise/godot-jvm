#ifndef GODOT_JVM_LOGGING_H
#define GODOT_JVM_LOGGING_H

#include <classes/os.hpp>
#include <variant/string.hpp>
#include <variant/variant.hpp>


// A raw pointer, not an eager `inline godot::String` global: constructing a godot::String calls
// into godot-cpp's GDExtension interface function pointers, which aren't populated until
// godot_jvm_library_init() runs GDExtensionBinding::InitObject(). An eager global of the String
// itself would run as a CRT dynamic initializer at DLL-load time, before that happens, crashing
// the load (Windows error 1114 / DLL initialization routine failed). A pointer, by contrast, is
// constant-initialized (nullptr is a constant expression) — no CRT entry, safe pre-init.
inline godot::String* format_prefix_instance = nullptr;

// Call once from godot_jvm_library_init(), after GDExtensionBinding::InitObject has run — see
// format_prefix_instance above. Deliberately not a lazy magic-static in format_prefix() itself:
// every JVM_LOG_*/JVM_ERR_* call would then pay a guard-check for a value that only ever needs
// setting once, for the lifetime of the whole extension.
inline void configure_logging() {
    format_prefix_instance = new godot::String("Godot-JVM: ");
}

inline const godot::String& format_prefix() {
    return *format_prefix_instance;
}

// message is wrapped in godot::String(...) explicitly: godot::String has overloads for operator+
// taking both `const String&` and `const StringName&`, so adding a raw string literal directly is
// ambiguous (equally valid implicit conversion to either type).
#define JVM_STRING_FORMAT(message, ...)  godot::vformat(format_prefix() + godot::String(message),  ##__VA_ARGS__)

#define JVM_LOG_INFO(message, ...) godot::print_line(JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_LOG_VERBOSE(message, ...) godot::print_verbose(JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_LOG_WARNING(message, ...) WARN_PRINT(JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_PRINT(message, ...) ERR_PRINT(JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_WARN_FAIL_V_MSG(ret_var, message, ...) \
    do {                                            \
        JVM_LOG_WARNING(message, ##__VA_ARGS__);    \
        return ret_var;                             \
    } while (false)

#ifdef TOOLS_ENABLED
#define JVM_ERR_FAIL_MSG(message, ...) ERR_FAIL_EDMSG(JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_FAIL_V_MSG(ret_var, message, ...) \
    ERR_FAIL_V_EDMSG(ret_var, JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_FAIL_COND_MSG(condition, message, ...) \
    ERR_FAIL_COND_EDMSG(condition, JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_FAIL_COND_V_MSG(condition, ret_var, message, ...) \
    ERR_FAIL_COND_V_EDMSG(condition, ret_var, JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#else
#define JVM_ERR_FAIL_MSG(message, ...) ERR_FAIL_MSG(JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_FAIL_V_MSG(ret_var, message, ...) \
    ERR_FAIL_V_MSG(ret_var, JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_FAIL_COND_MSG(condition, message, ...) \
    ERR_FAIL_COND_MSG(condition, JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#define JVM_ERR_FAIL_COND_V_MSG(condition, ret_var, message, ...) \
    ERR_FAIL_COND_V_MSG(condition, ret_var, JVM_STRING_FORMAT(message, ##__VA_ARGS__))
#endif

#ifdef DEV_ENABLED
#define JVM_DEV_LOG(message, ...) JVM_LOG_INFO(message, ##__VA_ARGS__)
#define JVM_DEV_VERBOSE(message, ...) JVM_LOG_VERBOSE(message, ##__VA_ARGS__)
#define JVM_DEV_ASSERT(m_cond, message, ...)                                                                 \
    if (unlikely(!(m_cond))) {                                                                               \
        godot::_err_print_error(FUNCTION_STR, __FILE__, __LINE__, JVM_STRING_FORMAT(message, ##__VA_ARGS__)); \
        godot::_err_flush_stdout();                                                                                 \
        GENERATE_TRAP();                                                                                     \
    } else                                                                                                   \
        ((void) 0)
#else
#define JVM_DEV_LOG(message, ...)
#define JVM_DEV_VERBOSE(message, ...)
#define JVM_DEV_ASSERT(m_cond, message, ...)
#endif

#endif// GODOT_JVM_LOGGING_H
