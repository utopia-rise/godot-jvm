#include "string_name_bridge.h"

#include "bridges_utils.h"
#include "jvm/wrapper/memory/transfer_context.h"

#include <variant/string.hpp>
#include <variant/string_name.hpp>

using namespace bridges;

uintptr_t StringNameBridge::engine_call_constructor(JNIEnv*, jobject) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName()));
}

uintptr_t StringNameBridge::engine_call_copy_constructor(JNIEnv* p_raw_env, jobject) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName(args[0].operator godot::StringName())));
}

uintptr_t StringNameBridge::engine_call_constructor_string(JNIEnv* p_raw_env, jobject) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName(args[0].operator godot::String())));
}

void StringNameBridge::engine_call_operator_string(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant result = godot::String(*from_uint_to_ptr<godot::StringName>(p_raw_ptr));
    TransferContext::get_instance().write_return_value(env, result);
}

StringNameBridge::~StringNameBridge() = default;