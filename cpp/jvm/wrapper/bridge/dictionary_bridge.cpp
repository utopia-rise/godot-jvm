#include "dictionary_bridge.h"

#include "api/script/jvm_script.h"
#include "api/script/jvm_script_manager.h"
#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/wrapper/memory/transfer_context.h"
#include "jvm/wrapper/memory/type_manager.h"

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
    jni::Env env(p_raw_env);
    int64_t key_variant_type;
    int64_t key_engine_type_index;
    int64_t key_script_ptr;
    int64_t value_variant_type;
    int64_t value_engine_type_index;
    int64_t value_script_ptr;
    TransferContext::read_values(
        env,
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
    jni::Env env(p_raw_env);
    bool deep;
    TransferContext::read_values(env, deep);
    godot::Dictionary copy = native<godot::Dictionary>(p_handle).duplicate(deep);
    TransferContext::write_value(env, copy);
}

void DictionaryBridge::engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t deep_subresources_mode;
    TransferContext::read_values(env, deep_subresources_mode);
    godot::Dictionary copy = native<godot::Dictionary>(p_handle).duplicate_deep(deep_subresources_mode);
    TransferContext::write_value(env, copy);
}

void DictionaryBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool empty = native<godot::Dictionary>(p_handle).is_empty();
    TransferContext::write_value(env, empty);
}

void DictionaryBridge::engine_call_erase(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant key;
    TransferContext::read_values(env, key);
    native<godot::Dictionary>(p_handle).erase(key);
}

void DictionaryBridge::engine_call_find_key(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    godot::Variant key = native<godot::Dictionary>(p_handle).find_key(value);
    TransferContext::write_value(env, key);
}

void DictionaryBridge::engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant key;
    godot::Variant default_value;
    TransferContext::read_values(env, key, default_value);
    godot::Variant value = native<godot::Dictionary>(p_handle).get(key, default_value);
    TransferContext::write_value(env, value);
}

void DictionaryBridge::engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant key;
    TransferContext::read_values(env, key);
    bool found = native<godot::Dictionary>(p_handle).has(key);
    TransferContext::write_value(env, found);
}

void DictionaryBridge::engine_call_hasAll(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Array keys;
    TransferContext::read_values(env, keys);
    bool found = native<godot::Dictionary>(p_handle).has_all(keys);
    TransferContext::write_value(env, found);
}

void DictionaryBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t hash = native<godot::Dictionary>(p_handle).hash();
    TransferContext::write_value(env, hash);
}

void DictionaryBridge::engine_call_is_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool read_only = native<godot::Dictionary>(p_handle).is_read_only();
    TransferContext::write_value(env, read_only);
}

void DictionaryBridge::engine_call_keys(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Array keys = native<godot::Dictionary>(p_handle).keys();
    TransferContext::write_value(env, keys);
}

void DictionaryBridge::engine_call_make_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    native<godot::Dictionary>(p_handle).make_read_only();
}

void DictionaryBridge::engine_call_merge(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Dictionary dictionary;
    bool overwrite;
    TransferContext::read_values(env, dictionary, overwrite);
    native<godot::Dictionary>(p_handle).merge(dictionary, overwrite);
}

void DictionaryBridge::engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t size = native<godot::Dictionary>(p_handle).size();
    TransferContext::write_value(env, size);
}

void DictionaryBridge::engine_call_sort(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    native<godot::Dictionary>(p_handle).sort();
}

void DictionaryBridge::engine_call_values(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Array values = native<godot::Dictionary>(p_handle).values();
    TransferContext::write_value(env, values);
}

void DictionaryBridge::engine_call_operator_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant key;
    TransferContext::read_values(env, key);
    godot::Variant value = native<godot::Dictionary>(p_handle).operator[](key);
    TransferContext::write_value(env, value);
}

void DictionaryBridge::engine_call_operator_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant key;
    godot::Variant value;
    TransferContext::read_values(env, key, value);
    native<godot::Dictionary>(p_handle).operator[](key) = value;
}

void DictionaryBridge::engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Dictionary other;
    TransferContext::read_values(env, other);
    bool equal = native<godot::Dictionary>(p_handle) == other;
    TransferContext::write_value(env, equal);
}

DictionaryBridge::~DictionaryBridge() = default;
