#include "dictionary_bridge.h"

#include "api/script/jvm_script.h"
#include "api/script/jvm_script_manager.h"
#include "bridges_utils.h"
#include "constraints.h"
#include "core/variant_allocator.h"
#include "jvm/wrapper/memory/transfer_context.h"

using namespace bridges;

uintptr_t DictionaryBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Dictionary()));
}

uintptr_t DictionaryBridge::engine_call_constructor_typed(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env {p_raw_env};
    godot::Variant args[6] = {};
    TransferContext::get_instance().read_args(env, args);

    auto ret {VariantAllocator::alloc(godot::Dictionary())};

    auto key_variant_type = args[0].operator uint32_t();
    auto key_engine_type_index {args[1].operator int64_t()};
    auto key_user_type_script = godot::Ref(bridges::from_uint_to_ptr<godot::JvmScript>(args[2].operator int64_t()));

    auto value_variant_type = args[3].operator uint32_t();
    auto value_engine_type_index {args[4].operator int64_t()};
    auto value_user_type_script = godot::Ref(bridges::from_uint_to_ptr<godot::JvmScript>(args[5].operator int64_t()));

    godot::StringName key_base_class_name;
    godot::Variant key_script;
    if (key_user_type_script.is_valid()) {
        key_base_class_name = key_user_type_script->get_instance_base_type();
        key_script = key_user_type_script;
    } else if (key_engine_type_index != -1) {
        key_base_class_name = TypeManager::get_instance().get_engine_type_for_index(key_engine_type_index);
    }

    godot::StringName value_base_class_name;
    godot::Variant value_script;
    if (value_user_type_script.is_valid()) {
        value_base_class_name = value_user_type_script->get_instance_base_type();
        value_script = value_user_type_script;
    } else if (value_engine_type_index != -1) {
        value_base_class_name = TypeManager::get_instance().get_engine_type_for_index(value_engine_type_index);
    }

    ret->set_typed(key_variant_type, key_base_class_name, key_script, value_variant_type, value_base_class_name, value_script);
    return reinterpret_cast<uintptr_t>(ret);
}

void DictionaryBridge::engine_call_clear(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->clear();
}

void DictionaryBridge::engine_call_duplicate(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->duplicate(args[0].operator bool());
    TransferContext::get_instance().write_return_value(env, variant);
}


void DictionaryBridge::engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->duplicate_deep(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->is_empty();
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_erase(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->erase(args[0]);
}

void DictionaryBridge::engine_call_find_key(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret  = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->find_key(args[0]);
    TransferContext::get_instance().write_return_value(env, ret);
}

void DictionaryBridge::engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->get(args[0], args[1]);
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_has(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->has(args[0]);
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_hasAll(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->has_all(args[0]);
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->hash();
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_is_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant ret = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->is_read_only();
    TransferContext::get_instance().write_return_value(env, ret);
}

void DictionaryBridge::engine_call_keys(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->keys();
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_make_read_only(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->make_read_only();
}

void DictionaryBridge::engine_call_merge(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->merge(args[0], args[1]);
}

void DictionaryBridge::engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->size();
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_sort(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->sort();
}

void DictionaryBridge::engine_call_values(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->values();
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_operator_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->operator[](args[0]);
    TransferContext::get_instance().write_return_value(env, variant);
}

void DictionaryBridge::engine_call_operator_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Dictionary>(p_raw_ptr)->operator[](args[0]) = args[1];
}

void DictionaryBridge::engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = *from_uint_to_ptr<godot::Dictionary>(p_raw_ptr) == args[0].operator godot::Dictionary();
    TransferContext::get_instance().write_return_value(env, variant);
}

DictionaryBridge::~DictionaryBridge() = default;
