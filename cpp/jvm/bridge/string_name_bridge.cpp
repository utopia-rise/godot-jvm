#include "string_name_bridge.h"

#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/memory/variant_buffer.h"

#include <variant/string.hpp>
#include <variant/string_name.hpp>

using namespace bridges;

uintptr_t StringNameBridge::engine_call_constructor(JNIEnv*, jobject) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName()));
}

uintptr_t StringNameBridge::engine_call_copy_constructor(JNIEnv* p_raw_env, jobject) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::StringName name;
    transfer->read_args(name);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName(name)));
}

uintptr_t StringNameBridge::engine_call_constructor_string(JNIEnv* p_raw_env, jobject) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::String string;
    transfer->read_args(string);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::StringName(string)));
}

void StringNameBridge::engine_call_operator_string(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::String string = godot::String(native<godot::StringName>(p_handle));
    transfer->write_ret(string);
}
