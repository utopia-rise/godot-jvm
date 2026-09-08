#include "node_path_bridge.h"

#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/wrapper/memory/transfer_context.h"

using namespace bridges;
using namespace godot;

uintptr_t NodePathBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath()));
}

uintptr_t NodePathBridge::engine_call_constructor_string(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env = p_raw_env;
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath(args[0].operator godot::String())));
}

uintptr_t NodePathBridge::engine_call_constructor_node_path(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env = p_raw_env;
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath(args[0].operator NodePath())));
}

void NodePathBridge::engine_call_path(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = godot::String(*from_uint_to_ptr<NodePath>(p_raw_ptr));
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getAsPropertyPath(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_as_property_path();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getName(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_name(args[0].operator signed int());
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getNameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_name_count();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getSubname(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_subname(args[0].operator signed int());
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getSubnameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_subname_count();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_isAbsolute(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->is_absolute();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->hash();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_isEmpty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->is_empty();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getConcatenatedNames(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_concatenated_names();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_getConcatenatedSubnames(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant variant = from_uint_to_ptr<NodePath>(p_raw_ptr)->get_concatenated_subnames();
    TransferContext::get_instance().write_return_value(env, variant);
}

void NodePathBridge::engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = p_raw_env;
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = *from_uint_to_ptr<NodePath>(p_raw_ptr) == args[0].operator NodePath();
    TransferContext::get_instance().write_return_value(env, variant);
}

NodePathBridge::~NodePathBridge() = default;