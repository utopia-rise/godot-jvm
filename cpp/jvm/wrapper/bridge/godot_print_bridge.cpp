#include "godot_print_bridge.h"

#include "jvm/wrapper/memory/transfer_context.h"

#include <core/print_string.hpp>

using namespace bridges;

void GodotPrintBridge::print(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    godot::print_line(env.from_jstring(p_string));
}

void GodotPrintBridge::print_rich(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    godot::print_line_rich(env.from_jstring(p_string));
}

void GodotPrintBridge::print_verbose2(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    godot::print_verbose(env.from_jstring(p_string));
}

void GodotPrintBridge::print_err(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    godot::print_error(env.from_jstring(p_string));
}

void GodotPrintBridge::print_raw(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    godot::print_line(env.from_jstring(p_string).utf8().get_data());
}

void GodotPrintBridge::push_error(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    ERR_PRINT(env.from_jstring(p_string));
}

void GodotPrintBridge::push_warning(JNIEnv* p_raw_env, jobject, jstring p_string) {
    jni::Env env {p_raw_env};
    WARN_PRINT(env.from_jstring(p_string));
}

void GodotPrintBridge::print_exception_stacktrace(jni::Env p_env, jni::JThrowable p_throwable) {
    jvalue args[1] = {jni::to_jni_arg(p_throwable)};
    jni::JString str {get_instance().wrapped.call_object_method(p_env, GET_EXCEPTION_STACKTRACE, args)};
    godot::String string {p_env.from_jstring(str)};
    str.delete_local_ref(p_env);
    JVM_ERR_FAIL_MSG(string);
}

godot::String GodotPrintBridge::get_jvm_stacktrace(jni::Env& p_env) {
    jni::JString str {wrapped.call_object_method(p_env, GET_STACKTRACE)};
    godot::String ret {p_env.from_jstring(str)};
    str.delete_local_ref(p_env);
    return ret;
}

GodotPrintBridge::~GodotPrintBridge() = default;