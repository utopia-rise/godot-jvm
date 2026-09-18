#include "string_name_bridge.h"

#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/wrapper/memory/transfer_context.h"

#include <variant/string.hpp>
#include <variant/string_name.hpp>

using namespace bridges;

uintptr_t StringNameBridge::engine_call_constructor(JNIEnv*, jobject) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName()));
}

uintptr_t StringNameBridge::engine_call_copy_constructor(JNIEnv* p_raw_env, jobject) {
    jni::Env env(p_raw_env);
    godot::StringName name;
    TransferContext::read_values(env, name);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName(name)));
}

uintptr_t StringNameBridge::engine_call_constructor_string(JNIEnv* p_raw_env, jobject) {
    jni::Env env(p_raw_env);
    godot::String string;
    TransferContext::read_values(env, string);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName(string)));
}

void StringNameBridge::engine_call_operator_string(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String string = godot::String(native<godot::StringName>(p_handle));
    TransferContext::write_value(env, string);
}

StringNameBridge::~StringNameBridge() = default;
