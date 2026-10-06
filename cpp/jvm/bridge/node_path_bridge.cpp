#include "node_path_bridge.h"

#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/memory/variant_buffer.h"

using namespace bridges;
using namespace godot;

uintptr_t NodePathBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath()));
}

uintptr_t NodePathBridge::engine_call_constructor_string(JNIEnv* p_raw_env, jobject p_instance) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    String path;
    transfer->read_args(path);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath(path)));
}

uintptr_t NodePathBridge::engine_call_constructor_node_path(JNIEnv* p_raw_env, jobject p_instance) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    NodePath path;
    transfer->read_args(path);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(NodePath(path)));
}

void NodePathBridge::engine_call_path(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    String path = String(native<NodePath>(p_handle));
    transfer->write_ret(path);
}

void NodePathBridge::engine_call_getAsPropertyPath(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    NodePath property_path = native<NodePath>(p_handle).get_as_property_path();
    transfer->write_ret(property_path);
}

void NodePathBridge::engine_call_getName(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t index;
    transfer->read_args(index);
    StringName name = native<NodePath>(p_handle).get_name(index);
    transfer->write_ret(name);
}

void NodePathBridge::engine_call_getNameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t count = native<NodePath>(p_handle).get_name_count();
    transfer->write_ret(count);
}

void NodePathBridge::engine_call_getSubname(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t index;
    transfer->read_args(index);
    StringName subname = native<NodePath>(p_handle).get_subname(index);
    transfer->write_ret(subname);
}

void NodePathBridge::engine_call_getSubnameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t count = native<NodePath>(p_handle).get_subname_count();
    transfer->write_ret(count);
}

void NodePathBridge::engine_call_isAbsolute(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool absolute = native<NodePath>(p_handle).is_absolute();
    transfer->write_ret(absolute);
}

void NodePathBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t hash = native<NodePath>(p_handle).hash();
    transfer->write_ret(hash);
}

void NodePathBridge::engine_call_isEmpty(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool empty = native<NodePath>(p_handle).is_empty();
    transfer->write_ret(empty);
}

void NodePathBridge::engine_call_getConcatenatedNames(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    StringName names = native<NodePath>(p_handle).get_concatenated_names();
    transfer->write_ret(names);
}

void NodePathBridge::engine_call_getConcatenatedSubnames(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    StringName subnames = native<NodePath>(p_handle).get_concatenated_subnames();
    transfer->write_ret(subnames);
}

void NodePathBridge::engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    NodePath other;
    transfer->read_args(other);
    bool equal = native<NodePath>(p_handle) == other;
    transfer->write_ret(equal);
}
