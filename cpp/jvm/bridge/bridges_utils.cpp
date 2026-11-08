#include "bridges_utils.h"

#include <cinttypes>
#include <cstdio>

#ifdef DEBUG_ENABLED
static jni::JClass index_out_of_bounds_class;

void bridges::initialize_exception_classes(jni::Env& p_env) {
    jni::JClass local_class = p_env.find_class("java/lang/IndexOutOfBoundsException");
    index_out_of_bounds_class = local_class.new_global_ref<jni::JClass>(p_env);
    local_class.delete_local_ref(p_env);
}

void bridges::finalize_exception_classes(jni::Env& p_env) {
    index_out_of_bounds_class.delete_global_ref(p_env);
    index_out_of_bounds_class = jni::JClass();
}

void bridges::throw_index_out_of_bounds(JNIEnv* p_raw_env, int64_t p_index, int64_t p_size) {
    char message[80];
    snprintf(message, sizeof(message), "Index %" PRId64 " out of bounds for length %" PRId64, p_index, p_size);
    p_raw_env->ThrowNew(static_cast<jclass>(index_out_of_bounds_class.obj), message);
}
#endif
