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
    jni::Env env(p_raw_env);
    String path;
    TransferContext::read_values(env, path);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath(path)));
}

uintptr_t NodePathBridge::engine_call_constructor_node_path(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env(p_raw_env);
    NodePath path;
    TransferContext::read_values(env, path);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath(path)));
}

void NodePathBridge::engine_call_path(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    String path = String(native<NodePath>(p_handle));
    TransferContext::write_value(env, path);
}

void NodePathBridge::engine_call_getAsPropertyPath(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    NodePath property_path = native<NodePath>(p_handle).get_as_property_path();
    TransferContext::write_value(env, property_path);
}

void NodePathBridge::engine_call_getName(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t index;
    TransferContext::read_values(env, index);
    StringName name = native<NodePath>(p_handle).get_name(index);
    TransferContext::write_value(env, name);
}

void NodePathBridge::engine_call_getNameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t count = native<NodePath>(p_handle).get_name_count();
    TransferContext::write_value(env, count);
}

void NodePathBridge::engine_call_getSubname(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t index;
    TransferContext::read_values(env, index);
    StringName subname = native<NodePath>(p_handle).get_subname(index);
    TransferContext::write_value(env, subname);
}

void NodePathBridge::engine_call_getSubnameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t count = native<NodePath>(p_handle).get_subname_count();
    TransferContext::write_value(env, count);
}

void NodePathBridge::engine_call_isAbsolute(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool absolute = native<NodePath>(p_handle).is_absolute();
    TransferContext::write_value(env, absolute);
}

void NodePathBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t hash = native<NodePath>(p_handle).hash();
    TransferContext::write_value(env, hash);
}

void NodePathBridge::engine_call_isEmpty(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool empty = native<NodePath>(p_handle).is_empty();
    TransferContext::write_value(env, empty);
}

void NodePathBridge::engine_call_getConcatenatedNames(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    StringName names = native<NodePath>(p_handle).get_concatenated_names();
    TransferContext::write_value(env, names);
}

void NodePathBridge::engine_call_getConcatenatedSubnames(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    StringName subnames = native<NodePath>(p_handle).get_concatenated_subnames();
    TransferContext::write_value(env, subnames);
}

void NodePathBridge::engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    NodePath other;
    TransferContext::read_values(env, other);
    bool equal = native<NodePath>(p_handle) == other;
    TransferContext::write_value(env, equal);
}

NodePathBridge::~NodePathBridge() = default;
