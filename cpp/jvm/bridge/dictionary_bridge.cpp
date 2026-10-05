#include "dictionary_bridge.h"

#include "api/script/jvm_script.h"
#include "api/script/jvm_script_manager.h"
#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/memory/type_manager.h"
#include "jvm/memory/variant_buffer.h"

using namespace bridges;

uintptr_t DictionaryBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Dictionary()));
}

// The base class name and script a typed key or value is constrained to, from the JVM's description of the type.
static void typed_constraint(
    int64_t p_engine_type_index,
    int64_t p_script_ptr,
    godot::StringName& r_base_class_name,
    godot::Variant& r_script
) {
    godot::Ref<godot::JvmScript> user_type_script(native_or_null<godot::JvmScript>(p_script_ptr));
    if (user_type_script.is_valid()) {
        r_base_class_name = user_type_script->get_instance_base_type();
        r_script = user_type_script;
    } else if (p_engine_type_index != -1) {
        r_base_class_name = TypeManager::get_instance().get_engine_type_for_index(p_engine_type_index);
    }
}

uintptr_t DictionaryBridge::engine_call_constructor_typed(JNIEnv* p_raw_env, jobject p_instance) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t key_variant_type;
    int64_t key_engine_type_index;
    int64_t key_script_ptr;
    int64_t value_variant_type;
    int64_t value_engine_type_index;
    int64_t value_script_ptr;
    transfer->read_args(
        key_variant_type,
        key_engine_type_index,
        key_script_ptr,
        value_variant_type,
        value_engine_type_index,
        value_script_ptr
    );

    godot::StringName key_base_class_name;
    godot::Variant key_script;
    typed_constraint(key_engine_type_index, key_script_ptr, key_base_class_name, key_script);

    godot::StringName value_base_class_name;
    godot::Variant value_script;
    typed_constraint(value_engine_type_index, value_script_ptr, value_base_class_name, value_script);

    godot::Dictionary* ret = VariantAllocator::alloc(godot::Dictionary());
    ret->set_typed(
        static_cast<uint32_t>(key_variant_type),
        key_base_class_name,
        key_script,
        static_cast<uint32_t>(value_variant_type),
        value_base_class_name,
        value_script
    );
    return reinterpret_cast<uintptr_t>(ret);
}

void DictionaryBridge::engine_call_clear(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    native<godot::Dictionary>(p_handle).clear();
}

void DictionaryBridge::engine_call_duplicate(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool deep;
    transfer->read_args(deep);
    godot::Dictionary copy = native<godot::Dictionary>(p_handle).duplicate(deep);
    transfer->write_ret(copy);
}

void DictionaryBridge::engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t deep_subresources_mode;
    transfer->read_args(deep_subresources_mode);
    godot::Dictionary copy = native<godot::Dictionary>(p_handle).duplicate_deep(deep_subresources_mode);
    transfer->write_ret(copy);
}

void DictionaryBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool empty = native<godot::Dictionary>(p_handle).is_empty();
    transfer->write_ret(empty);
}

void DictionaryBridge::engine_call_erase(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant key;
    transfer->read_args(key);
    native<godot::Dictionary>(p_handle).erase(key);
}

void DictionaryBridge::engine_call_find_key(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    godot::Variant key = native<godot::Dictionary>(p_handle).find_key(value);
    transfer->write_ret(key);
}

void DictionaryBridge::engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant key;
    godot::Variant default_value;
    transfer->read_args(key, default_value);
    godot::Variant value = native<godot::Dictionary>(p_handle).get(key, default_value);
    transfer->write_ret(value);
}

void DictionaryBridge::engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant key;
    transfer->read_args(key);
    bool found = native<godot::Dictionary>(p_handle).has(key);
    transfer->write_ret(found);
}

void DictionaryBridge::engine_call_hasAll(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Array keys;
    transfer->read_args(keys);
    bool found = native<godot::Dictionary>(p_handle).has_all(keys);
    transfer->write_ret(found);
}

void DictionaryBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t hash = native<godot::Dictionary>(p_handle).hash();
    transfer->write_ret(hash);
}

void DictionaryBridge::engine_call_is_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool read_only = native<godot::Dictionary>(p_handle).is_read_only();
    transfer->write_ret(read_only);
}

void DictionaryBridge::engine_call_keys(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Array keys = native<godot::Dictionary>(p_handle).keys();
    transfer->write_ret(keys);
}

void DictionaryBridge::engine_call_make_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    native<godot::Dictionary>(p_handle).make_read_only();
}

void DictionaryBridge::engine_call_merge(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Dictionary dictionary;
    bool overwrite;
    transfer->read_args(dictionary, overwrite);
    native<godot::Dictionary>(p_handle).merge(dictionary, overwrite);
}

void DictionaryBridge::engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t size = native<godot::Dictionary>(p_handle).size();
    transfer->write_ret(size);
}

void DictionaryBridge::engine_call_sort(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    native<godot::Dictionary>(p_handle).sort();
}

void DictionaryBridge::engine_call_values(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Array values = native<godot::Dictionary>(p_handle).values();
    transfer->write_ret(values);
}

void DictionaryBridge::engine_call_operator_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant key;
    transfer->read_args(key);
    godot::Variant value = native<godot::Dictionary>(p_handle).operator[](key);
    transfer->write_ret(value);
}

void DictionaryBridge::engine_call_operator_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant key;
    godot::Variant value;
    transfer->read_args(key, value);
    native<godot::Dictionary>(p_handle).operator[](key) = value;
}

void DictionaryBridge::engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Dictionary other;
    transfer->read_args(other);
    bool equal = native<godot::Dictionary>(p_handle) == other;
    transfer->write_ret(equal);
}

DictionaryBridge::~DictionaryBridge() = default;
