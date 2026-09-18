#include "variant_array_bridge.h"

#include "api/script/jvm_script_manager.h"
#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/wrapper/memory/transfer_context.h"
#include "jvm/wrapper/memory/type_manager.h"

using namespace bridges;

uintptr_t VariantArrayBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Array()));
}

uintptr_t VariantArrayBridge::engine_call_constructor_typed(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env(p_raw_env);
    int64_t variant_type;
    int64_t engine_type_index;
    int64_t script_ptr;
    TransferContext::read_values(env, variant_type, engine_type_index, script_ptr);

    godot::Array* ret = VariantAllocator::alloc(godot::Array());
    godot::Ref<godot::JvmScript> user_type_script(native_or_null<godot::JvmScript>(script_ptr));

    godot::StringName base_class_name;
    godot::Variant script;
    if (user_type_script.is_valid()) {
        base_class_name = user_type_script->get_instance_base_type();
        script = user_type_script;
    } else if (engine_type_index != -1) {
        base_class_name = TypeManager::get_instance().get_engine_type_for_index(engine_type_index);
    }
    ret->set_typed(static_cast<uint32_t>(variant_type), base_class_name, script);
    return reinterpret_cast<uintptr_t>(ret);
}

void VariantArrayBridge::engine_call_size(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t size = native<godot::Array>(p_handle).size();
    TransferContext::write_value(env, size);
}

void VariantArrayBridge::engine_call_clear(JNIEnv*, jobject, jlong p_handle) {
    native<godot::Array>(p_handle).clear();
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool empty = native<godot::Array>(p_handle).is_empty();
    TransferContext::write_value(env, empty);
}

void VariantArrayBridge::engine_call_hash(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t hash = native<godot::Array>(p_handle).hash();
    TransferContext::write_value(env, hash);
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_reverse(JNIEnv*, jobject, jlong p_handle) {
    native<godot::Array>(p_handle).reverse();
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_remove_at(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t index;
    TransferContext::read_values(env, index);
    native<godot::Array>(p_handle).remove_at(index);
}

void VariantArrayBridge::engine_call_resize(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t size;
    TransferContext::read_values(env, size);
    native<godot::Array>(p_handle).resize(size);
}

void VariantArrayBridge::engine_call_shuffle(JNIEnv*, jobject, jlong p_handle) {
    native<godot::Array>(p_handle).shuffle();
}

void VariantArrayBridge::engine_call_sort(JNIEnv*, jobject, jlong p_handle) {
    native<godot::Array>(p_handle).sort();
}

// TODO/4.0: modify method signature in jvm code (from object + method name to callable)
void VariantArrayBridge::engine_call_sortCustom(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Callable callable;
    TransferContext::read_values(env, callable);
    native<godot::Array>(p_handle).sort_custom(callable);
}

void VariantArrayBridge::engine_call_append(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    native<godot::Array>(p_handle).append(value);
}

void VariantArrayBridge::engine_call_bsearch(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    bool before;
    TransferContext::read_values(env, value, before);
    int64_t index = native<godot::Array>(p_handle).bsearch(value, before);
    TransferContext::write_value(env, index);
}

// TODO/4.0: modify method signature in jvm code (from object + method name to callable)
void VariantArrayBridge::engine_call_bsearchCustom(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    godot::Callable callable;
    bool before;
    TransferContext::read_values(env, value, callable, before);
    int64_t index = native<godot::Array>(p_handle).bsearch_custom(value, callable, before);
    TransferContext::write_value(env, index);
}

void VariantArrayBridge::engine_call_count(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    int64_t count = native<godot::Array>(p_handle).count(value);
    TransferContext::write_value(env, count);
}

void VariantArrayBridge::engine_call_duplicate(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool deep;
    TransferContext::read_values(env, deep);
    godot::Array copy = native<godot::Array>(p_handle).duplicate(deep);
    TransferContext::write_value(env, copy);
}

void VariantArrayBridge::engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t deep_subresources_mode;
    TransferContext::read_values(env, deep_subresources_mode);
    godot::Array copy = native<godot::Array>(p_handle).duplicate_deep(deep_subresources_mode);
    TransferContext::write_value(env, copy);
}

void VariantArrayBridge::engine_call_erase(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    native<godot::Array>(p_handle).erase(value);
}

void VariantArrayBridge::engine_call_find(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    int64_t from;
    TransferContext::read_values(env, value, from);
    int64_t index = native<godot::Array>(p_handle).find(value, from);
    TransferContext::write_value(env, index);
}

void VariantArrayBridge::engine_call_front(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).front();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_has(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    bool found = native<godot::Array>(p_handle).has(value);
    TransferContext::write_value(env, found);
}

void VariantArrayBridge::engine_call_insert(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t position;
    godot::Variant value;
    TransferContext::read_values(env, position, value);
    native<godot::Array>(p_handle).insert(position, value);
}

void VariantArrayBridge::engine_call_max(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).max();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_min(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).min();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_popBack(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).pop_back();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_popFront(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).pop_front();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_pushBack(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    native<godot::Array>(p_handle).push_back(value);
}

void VariantArrayBridge::engine_call_pushFront(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    native<godot::Array>(p_handle).push_front(value);
}

void VariantArrayBridge::engine_call_rfind(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    int64_t from;
    TransferContext::read_values(env, value, from);
    int64_t index = native<godot::Array>(p_handle).rfind(value, from);
    TransferContext::write_value(env, index);
}

void VariantArrayBridge::engine_call_slice(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t begin;
    int64_t end;
    int64_t step;
    bool deep;
    TransferContext::read_values(env, begin, end, step, deep);
    godot::Array slice = native<godot::Array>(p_handle).slice(begin, end, step, deep);
    TransferContext::write_value(env, slice);
}

void VariantArrayBridge::engine_call_operator_set(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t index;
    godot::Variant value;
    TransferContext::read_values(env, index, value);
    native<godot::Array>(p_handle).operator[](index) = value;
}

void VariantArrayBridge::engine_call_operator_get(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t index;
    TransferContext::read_values(env, index);
    godot::Variant element = native<godot::Array>(p_handle).get(index);
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_all(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Callable method;
    TransferContext::read_values(env, method);
    bool all = native<godot::Array>(p_handle).all(method);
    TransferContext::write_value(env, all);
}

void VariantArrayBridge::engine_call_any(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Callable method;
    TransferContext::read_values(env, method);
    bool any = native<godot::Array>(p_handle).any(method);
    TransferContext::write_value(env, any);
}

void VariantArrayBridge::engine_call_appendArray(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Array array;
    TransferContext::read_values(env, array);
    native<godot::Array>(p_handle).append_array(array);
}

void VariantArrayBridge::engine_call_back(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).back();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_fill(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant value;
    TransferContext::read_values(env, value);
    native<godot::Array>(p_handle).fill(value);
}

void VariantArrayBridge::engine_call_filter(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Callable method;
    TransferContext::read_values(env, method);
    godot::Array filtered = native<godot::Array>(p_handle).filter(method);
    TransferContext::write_value(env, filtered);
}

void VariantArrayBridge::engine_call_getTypedClassName(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::StringName class_name = native<godot::Array>(p_handle).get_typed_class_name();
    TransferContext::write_value(env, class_name);
}

void VariantArrayBridge::engine_call_getTypedScript(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant script = native<godot::Array>(p_handle).get_typed_script();
    TransferContext::write_value(env, script);
}

void VariantArrayBridge::engine_call_isReadOnly(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool read_only = native<godot::Array>(p_handle).is_read_only();
    TransferContext::write_value(env, read_only);
}

void VariantArrayBridge::engine_call_isTyped(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    bool typed = native<godot::Array>(p_handle).is_typed();
    TransferContext::write_value(env, typed);
}

void VariantArrayBridge::engine_call_map(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Callable method;
    TransferContext::read_values(env, method);
    godot::Array mapped = native<godot::Array>(p_handle).map(method);
    TransferContext::write_value(env, mapped);
}

void VariantArrayBridge::engine_call_pickRandom(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Variant element = native<godot::Array>(p_handle).pick_random();
    TransferContext::write_value(env, element);
}

void VariantArrayBridge::engine_call_reduce(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::Callable method;
    godot::Variant accum;
    TransferContext::read_values(env, method, accum);
    godot::Variant accumulated = native<godot::Array>(p_handle).reduce(method, accum);
    TransferContext::write_value(env, accumulated);
}

VariantArrayBridge::~VariantArrayBridge() = default;
