#include "variant_array_bridge.h"

#include "api/script/jvm_script_manager.h"
#include "bridges_utils.h"
#include "jvm/wrapper/memory/transfer_context.h"

using namespace bridges;

uintptr_t VariantArrayBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Array()));
}

uintptr_t VariantArrayBridge::engine_call_constructor_typed(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env {p_raw_env};
    godot::Variant args[3] = {};
    TransferContext::get_instance().read_args(env, args);

    auto ret {VariantAllocator::alloc(godot::Array())};

    auto engineTypeIndex {args[1].operator int64_t()};
    auto user_type_script = godot::Ref(bridges::from_uint_to_ptr<godot::JvmScript>(args[2].operator int64_t()));

    godot::StringName base_class_name;
    godot::Variant script;
    if (user_type_script.is_valid()) {
        base_class_name = user_type_script->get_instance_base_type();
        script = user_type_script;
    } else if (engineTypeIndex != -1) {
        base_class_name = TypeManager::get_instance().get_engine_type_for_index(engineTypeIndex);
    }
    ret->set_typed(static_cast<uint32_t>(args[0].operator int64_t()), base_class_name, script);
    return reinterpret_cast<uintptr_t>(ret);
}

void VariantArrayBridge::engine_call_size(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->size();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_clear(JNIEnv*, jobject, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->clear();
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->is_empty();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_hash(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->hash();
    TransferContext::get_instance().write_return_value(env, variant);
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_reverse(JNIEnv*, jobject, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->reverse();
}

// TODO/4.0: modify naming in jvm code
void VariantArrayBridge::engine_call_remove_at(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->remove_at(args[0].operator int64_t());
}

void VariantArrayBridge::engine_call_resize(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->resize(args[0].operator int64_t());
}

void VariantArrayBridge::engine_call_shuffle(JNIEnv*, jobject, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->shuffle();
}

void VariantArrayBridge::engine_call_sort(JNIEnv*, jobject, jlong p_raw_ptr) {
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->sort();
}

// TODO/4.0: modify method signature in jvm code (from object + method name to callable)
void VariantArrayBridge::engine_call_sortCustom(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->sort_custom(args[0].operator godot::Callable());
}

void VariantArrayBridge::engine_call_append(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->append(args[0]);
}

void VariantArrayBridge::engine_call_bsearch(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->bsearch(args[0], args[1].operator bool());
    transfer_context.write_return_value(env, variant);
}

// TODO/4.0: modify method signature in jvm code (from object + method name to callable)
void VariantArrayBridge::engine_call_bsearchCustom(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[3] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant =
      from_uint_to_ptr<godot::Array>(p_raw_ptr)->bsearch_custom(args[0], args[1].operator godot::Callable(), args[2].operator bool())
    ;
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_count(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->count(args[0]);
}

void VariantArrayBridge::engine_call_duplicate(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->duplicate(args[0].operator bool());
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_duplicate_deep(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->duplicate_deep(args[0].operator int64_t());
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_erase(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->erase(args[0]);
}

void VariantArrayBridge::engine_call_find(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->find(args[0], args[1].operator int64_t());
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_front(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->front();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_has(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->has(args[0]);
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_insert(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->insert(args[0].operator int64_t(), args[1]);
}

void VariantArrayBridge::engine_call_max(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->max();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_min(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->min();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_popBack(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->pop_back();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_popFront(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->pop_front();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_pushBack(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->push_back(args[0]);
}

void VariantArrayBridge::engine_call_pushFront(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->push_front(args[0]);
}

void VariantArrayBridge::engine_call_rfind(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->rfind(args[0], args[1].operator int64_t());
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_slice(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[4] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant =
      from_uint_to_ptr<godot::Array>(p_raw_ptr)
        ->slice(args[0].operator int64_t(), args[1].operator int64_t(), args[2].operator int64_t(), args[3].operator bool())
    ;
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_operator_set(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->operator[](args[0].operator int64_t()) = args[1];
}

void VariantArrayBridge::engine_call_operator_get(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->get(args[0]);
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_all(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->all(args[0]);
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_any(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->any(args[0]);
    transfer_context.write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_appendArray(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->append_array(args[0]);
}

void VariantArrayBridge::engine_call_back(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant variant = from_uint_to_ptr<godot::Array>(p_raw_ptr)->back();
    TransferContext::get_instance().write_return_value(env, variant);
}

void VariantArrayBridge::engine_call_fill(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::Array>(p_raw_ptr)->fill(args[0]);
}

void VariantArrayBridge::engine_call_filter(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    TransferContext& transfer_context = TransferContext::get_instance();
    godot::Variant args[1] = {};
    transfer_context.read_args(env, args);
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->filter(args[0]);
    transfer_context.write_return_value(env, result);
}

void VariantArrayBridge::engine_call_getTypedClassName(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->get_typed_class_name();
    TransferContext::get_instance().write_return_value(env, result);
}

void VariantArrayBridge::engine_call_getTypedScript(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->get_typed_script();
    TransferContext::get_instance().write_return_value(env, result);
}

void VariantArrayBridge::engine_call_isReadOnly(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->is_read_only();
    TransferContext::get_instance().write_return_value(env, result);
}

void VariantArrayBridge::engine_call_isTyped(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->is_typed();
    TransferContext::get_instance().write_return_value(env, result);
}

void VariantArrayBridge::engine_call_map(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->map(args[0]);
    transfer_context.write_return_value(env, result);
}

void VariantArrayBridge::engine_call_pickRandom(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->pick_random();
    TransferContext::get_instance().write_return_value(env, result);
}

void VariantArrayBridge::engine_call_reduce(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[2] = {};
    TransferContext& transfer_context = TransferContext::get_instance();
    transfer_context.read_args(env, args);
    godot::Variant result = from_uint_to_ptr<godot::Array>(p_raw_ptr)->reduce(args[0], args[1]);
    transfer_context.write_return_value(env, result);
}

VariantArrayBridge::~VariantArrayBridge() = default;
