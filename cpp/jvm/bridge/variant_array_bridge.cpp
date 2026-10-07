#include "variant_array_bridge.h"

#include "api/script/jvm_script_manager.h"
#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "jvm/memory/type_manager.h"
#include "jvm/memory/variant_buffer.h"

using namespace bridges;

uintptr_t VariantArrayBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Array()));
}

uintptr_t VariantArrayBridge::engine_call_constructor_typed(JNIEnv* p_raw_env, jobject p_instance) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t variant_type;
    int64_t engine_type_index;
    int64_t script_ptr;
    transfer->read_args(variant_type, engine_type_index, script_ptr);

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
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t size = native<godot::Array>(p_handle).size();
    transfer->write_ret(size);
}

void VariantArrayBridge::engine_call_clear(JNIEnv*, jobject, jlong p_handle) {
    native<godot::Array>(p_handle).clear();
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool empty = native<godot::Array>(p_handle).is_empty();
    transfer->write_ret(empty);
}

void VariantArrayBridge::engine_call_hash(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t hash = native<godot::Array>(p_handle).hash();
    transfer->write_ret(hash);
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_reverse(JNIEnv*, jobject, jlong p_handle) {
    native<godot::Array>(p_handle).reverse();
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_remove_at(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t index;
    transfer->read_args(index);
    native<godot::Array>(p_handle).remove_at(index);
}

void VariantArrayBridge::engine_call_resize(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t size;
    transfer->read_args(size);
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
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable callable;
    transfer->read_args(callable);
    native<godot::Array>(p_handle).sort_custom(callable);
}

void VariantArrayBridge::engine_call_append(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    native<godot::Array>(p_handle).append(value);
}

void VariantArrayBridge::engine_call_bsearch(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    bool before;
    transfer->read_args(value, before);
    int64_t index = native<godot::Array>(p_handle).bsearch(value, before);
    transfer->write_ret(index);
}

// TODO/4.0: modify method signature in jvm code (from object + method name to callable)
void VariantArrayBridge::engine_call_bsearchCustom(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    godot::Callable callable;
    bool before;
    transfer->read_args(value, callable, before);
    int64_t index = native<godot::Array>(p_handle).bsearch_custom(value, callable, before);
    transfer->write_ret(index);
}

void VariantArrayBridge::engine_call_count(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    int64_t count = native<godot::Array>(p_handle).count(value);
    transfer->write_ret(count);
}

void VariantArrayBridge::engine_call_duplicate(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool deep;
    transfer->read_args(deep);
    godot::Array copy = native<godot::Array>(p_handle).duplicate(deep);
    transfer->write_ret(copy);
}

void VariantArrayBridge::engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t deep_subresources_mode;
    transfer->read_args(deep_subresources_mode);
    godot::Array copy = native<godot::Array>(p_handle).duplicate_deep(deep_subresources_mode);
    transfer->write_ret(copy);
}

void VariantArrayBridge::engine_call_erase(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    native<godot::Array>(p_handle).erase(value);
}

void VariantArrayBridge::engine_call_find(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    int64_t from;
    transfer->read_args(value, from);
    int64_t index = native<godot::Array>(p_handle).find(value, from);
    transfer->write_ret(index);
}

void VariantArrayBridge::engine_call_front(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).front();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_has(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    bool found = native<godot::Array>(p_handle).has(value);
    transfer->write_ret(found);
}

void VariantArrayBridge::engine_call_insert(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t position;
    godot::Variant value;
    transfer->read_args(position, value);
    native<godot::Array>(p_handle).insert(position, value);
}

void VariantArrayBridge::engine_call_max(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).max();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_min(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).min();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_popBack(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).pop_back();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_popFront(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).pop_front();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_pushBack(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    native<godot::Array>(p_handle).push_back(value);
}

void VariantArrayBridge::engine_call_pushFront(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    native<godot::Array>(p_handle).push_front(value);
}

void VariantArrayBridge::engine_call_rfind(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    int64_t from;
    transfer->read_args(value, from);
    int64_t index = native<godot::Array>(p_handle).rfind(value, from);
    transfer->write_ret(index);
}

void VariantArrayBridge::engine_call_slice(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t begin;
    int64_t end;
    int64_t step;
    bool deep;
    transfer->read_args(begin, end, step, deep);
    godot::Array slice = native<godot::Array>(p_handle).slice(begin, end, step, deep);
    transfer->write_ret(slice);
}

void VariantArrayBridge::engine_call_operator_set(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t index;
    godot::Variant value;
    transfer->read_args(index, value);
    native<godot::Array>(p_handle).operator[](index) = value;
}

void VariantArrayBridge::engine_call_operator_get(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t index;
    transfer->read_args(index);
    godot::Variant element = native<godot::Array>(p_handle).get(index);
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_all(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable method;
    transfer->read_args(method);
    bool all = native<godot::Array>(p_handle).all(method);
    transfer->write_ret(all);
}

void VariantArrayBridge::engine_call_any(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable method;
    transfer->read_args(method);
    bool any = native<godot::Array>(p_handle).any(method);
    transfer->write_ret(any);
}

void VariantArrayBridge::engine_call_appendArray(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Array array;
    transfer->read_args(array);
    native<godot::Array>(p_handle).append_array(array);
}

void VariantArrayBridge::engine_call_back(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).back();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_fill(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant value;
    transfer->read_args(value);
    native<godot::Array>(p_handle).fill(value);
}

void VariantArrayBridge::engine_call_filter(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable method;
    transfer->read_args(method);
    godot::Array filtered = native<godot::Array>(p_handle).filter(method);
    transfer->write_ret(filtered);
}

void VariantArrayBridge::engine_call_getTypedClassName(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::StringName class_name = native<godot::Array>(p_handle).get_typed_class_name();
    transfer->write_ret(class_name);
}

void VariantArrayBridge::engine_call_getTypedScript(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant script = native<godot::Array>(p_handle).get_typed_script();
    transfer->write_ret(script);
}

void VariantArrayBridge::engine_call_isReadOnly(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool read_only = native<godot::Array>(p_handle).is_read_only();
    transfer->write_ret(read_only);
}

void VariantArrayBridge::engine_call_isTyped(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    bool typed = native<godot::Array>(p_handle).is_typed();
    transfer->write_ret(typed);
}

void VariantArrayBridge::engine_call_map(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable method;
    transfer->read_args(method);
    godot::Array mapped = native<godot::Array>(p_handle).map(method);
    transfer->write_ret(mapped);
}

void VariantArrayBridge::engine_call_pickRandom(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Variant element = native<godot::Array>(p_handle).pick_random();
    transfer->write_ret(element);
}

void VariantArrayBridge::engine_call_reduce(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable method;
    godot::Variant accum;
    transfer->read_args(method, accum);
    godot::Variant accumulated = native<godot::Array>(p_handle).reduce(method, accum);
    transfer->write_ret(accumulated);
}
