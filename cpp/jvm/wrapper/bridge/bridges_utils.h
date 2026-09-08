#ifndef GODOT_JVM_BRIDGES_UTILS_H
#define GODOT_JVM_BRIDGES_UTILS_H

#include "constraints.h"
#include "jvm/jni/wrapper.h"
#include "logging.h"

// clang-format off
//
// godot-cpp exposes several builtin vararg methods (Callable::call, call_deferred, bind, rpc, rpc_id, ...) only as
// variadic templates, so a runtime-sized argument array has to be unpacked into a compile-time arity by hand.
// `m_call` is the callee expression (e.g. `callable.call_deferred` or `result = callable.call`), `m_args` a
// Variant array holding `m_count` elements (0 <= m_count <= MAX_FUNCTION_ARG_COUNT) and `m_case_0` the statement
// to run when there are no arguments, since some callees (rpc_id) require at least one.
#define VARIADIC_ARGS_1(a) (a)[0]
#define VARIADIC_ARGS_2(a) VARIADIC_ARGS_1(a), (a)[1]
#define VARIADIC_ARGS_3(a) VARIADIC_ARGS_2(a), (a)[2]
#define VARIADIC_ARGS_4(a) VARIADIC_ARGS_3(a), (a)[3]
#define VARIADIC_ARGS_5(a) VARIADIC_ARGS_4(a), (a)[4]
#define VARIADIC_ARGS_6(a) VARIADIC_ARGS_5(a), (a)[5]
#define VARIADIC_ARGS_7(a) VARIADIC_ARGS_6(a), (a)[6]
#define VARIADIC_ARGS_8(a) VARIADIC_ARGS_7(a), (a)[7]
#define VARIADIC_ARGS_9(a) VARIADIC_ARGS_8(a), (a)[8]
#define VARIADIC_ARGS_10(a) VARIADIC_ARGS_9(a), (a)[9]
#define VARIADIC_ARGS_11(a) VARIADIC_ARGS_10(a), (a)[10]
#define VARIADIC_ARGS_12(a) VARIADIC_ARGS_11(a), (a)[11]
#define VARIADIC_ARGS_13(a) VARIADIC_ARGS_12(a), (a)[12]
#define VARIADIC_ARGS_14(a) VARIADIC_ARGS_13(a), (a)[13]
#define VARIADIC_ARGS_15(a) VARIADIC_ARGS_14(a), (a)[14]
#define VARIADIC_ARGS_16(a) VARIADIC_ARGS_15(a), (a)[15]

#define VARIADIC_CASE(n, m_call, m_args)        \
    case n:                                     \
        m_call(VARIADIC_ARGS_##n(m_args));      \
        break;

#define CALL_VARIADIC_OR(m_count, m_args, m_call, m_case_0)                 \
    switch (m_count) {                                                      \
        case 0:                                                             \
            m_case_0;                                                       \
            break;                                                          \
        VARIADIC_CASE(1, m_call, m_args)                                    \
        VARIADIC_CASE(2, m_call, m_args)                                    \
        VARIADIC_CASE(3, m_call, m_args)                                    \
        VARIADIC_CASE(4, m_call, m_args)                                    \
        VARIADIC_CASE(5, m_call, m_args)                                    \
        VARIADIC_CASE(6, m_call, m_args)                                    \
        VARIADIC_CASE(7, m_call, m_args)                                    \
        VARIADIC_CASE(8, m_call, m_args)                                    \
        VARIADIC_CASE(9, m_call, m_args)                                    \
        VARIADIC_CASE(10, m_call, m_args)                                   \
        VARIADIC_CASE(11, m_call, m_args)                                   \
        VARIADIC_CASE(12, m_call, m_args)                                   \
        VARIADIC_CASE(13, m_call, m_args)                                   \
        VARIADIC_CASE(14, m_call, m_args)                                   \
        VARIADIC_CASE(15, m_call, m_args)                                   \
        VARIADIC_CASE(16, m_call, m_args)                                   \
        default:                                                            \
            JVM_ERR_FAIL_MSG(#m_call ": too many arguments (%d)", m_count); \
            break;                                                          \
    }

#define CALL_VARIADIC(m_count, m_args, m_call) CALL_VARIADIC_OR(m_count, m_args, m_call, m_call())
// clang-format on

namespace bridges {

    template<class T>
    static inline T* from_uint_to_ptr(jlong raw_ptr) {
        return reinterpret_cast<T*>(static_cast<uintptr_t>(raw_ptr));
    }
} // namespace bridges

#endif // GODOT_JVM_BRIDGES_UTILS_H
