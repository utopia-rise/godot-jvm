#include "callable_bridge.h"

#include "bridges_utils.h"
#include "constraints.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/kotlin_callable_custom.h"
#include "jvm/wrapper/memory/transfer_context.h"
#include "logging.h"

#include <classes/object.hpp>
#include <variant/array.hpp>

using namespace bridges;

uintptr_t CallableBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Callable()));
}

uintptr_t CallableBridge::engine_call_constructor_object_string_name(
    JNIEnv* p_raw_env,
    jobject p_instance,
    jlong object_ptr,
    jlong method_name_ptr
) {
    // object_ptr is the raw engine pointer, and make_callable() issues the same engine constructor godot-cpp's
    // Callable(Object*, StringName) does — without materializing the wrapper it would only read `_owner` off.
    auto* obj = reinterpret_cast<godot::GodotObject*>(object_ptr);
    auto* name = reinterpret_cast<godot::StringName*>(method_name_ptr);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(raw_godot::RawObject(obj).to_callable(*name)));
}

uintptr_t CallableBridge::engine_call_constructor_lambda_callable(
    JNIEnv* p_raw_env,
    jobject p_instance,
    jobject p_lambda_container,
    jint p_variant_type_ordinal,
    jint p_hash_code
) {
    jni::Env env(p_raw_env);
    // has_on_destroy is only used by the cancellable one-shot signal connection below.
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(
        godot::Callable(memnew(KotlinCallableCustom(
            env,
            p_lambda_container,
            static_cast<godot::Variant::Type>(p_variant_type_ordinal),
            p_hash_code,
            false
        )))
    ));
}

void CallableBridge::engine_call_constructor_cancellable(
    JNIEnv* p_raw_env,
    jobject p_instance,
    jobject p_kt_custom_callable_instance,
    jint p_variant_type_ordinal,
    jint p_hash_code
) {
    jni::Env env(p_raw_env);
    godot::Signal signal;
    TransferContext::read_values(env, signal);

    godot::Callable callable = memnew(KotlinCallableCustom(
        env,
        p_kt_custom_callable_instance,
        static_cast<godot::Variant::Type>(p_variant_type_ordinal),
        p_hash_code,
        true
    ));

    raw_godot::RawObject owner = signal.get_object();
    if (owner.is_null()) { return; }
    if (owner.is_class(SNAME("Node"))) {
        owner.call_thread_safe(
            SNAME("connect"),
            signal.get_name(),
            callable,
            static_cast<int64_t>(godot::Object::CONNECT_ONE_SHOT)
        );
    } else {
        signal.connect(callable, godot::Object::CONNECT_ONE_SHOT);
    }
}

uintptr_t CallableBridge::engine_call_copy_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env(p_raw_env);
    godot::Callable callable;
    TransferContext::read_values(env, callable);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Callable(callable)));
}

void CallableBridge::engine_call_bind(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::read_variants(env, args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    godot::Variant result;
    CALL_VARIADIC(args_size, args, result = callable.bind);
    TransferContext::write_value(env, result);
}

void CallableBridge::engine_call_call(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::read_variants(env, args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    godot::Variant result;
    CALL_VARIADIC(args_size, args, result = callable.call);
    TransferContext::write_value(env, result);
}

void CallableBridge::engine_call_call_deferred(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::read_variants(env, args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    CALL_VARIADIC(args_size, args, callable.call_deferred);
}

void CallableBridge::engine_call_get_bound_arguments(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::Array bound_arguments = native<godot::Callable>(p_handle).get_bound_arguments();
    TransferContext::write_value(env, bound_arguments);
}

void CallableBridge::engine_call_get_bound_arguments_count(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    int64_t count = native<godot::Callable>(p_handle).get_bound_arguments_count();
    TransferContext::write_value(env, count);
}

void CallableBridge::engine_call_get_method(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::StringName method = native<godot::Callable>(p_handle).get_method();
    TransferContext::write_value(env, method);
}

void CallableBridge::engine_call_get_object(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    raw_godot::RawObject object = native<godot::Callable>(p_handle).get_object();
    TransferContext::write_value(env, object);
}

void CallableBridge::engine_call_get_object_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    int64_t object_id = native<godot::Callable>(p_handle).get_object_id();
    TransferContext::write_value(env, object_id);
}

void CallableBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    int64_t hash = native<godot::Callable>(p_handle).hash();
    TransferContext::write_value(env, hash);
}

void CallableBridge::engine_call_is_custom(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    bool custom = native<godot::Callable>(p_handle).is_custom();
    TransferContext::write_value(env, custom);
}

void CallableBridge::engine_call_is_null(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    bool null = native<godot::Callable>(p_handle).is_null();
    TransferContext::write_value(env, null);
}

void CallableBridge::engine_call_is_standard(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    bool standard = native<godot::Callable>(p_handle).is_standard();
    TransferContext::write_value(env, standard);
}

void CallableBridge::engine_call_is_valid(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    bool valid = native<godot::Callable>(p_handle).is_valid();
    TransferContext::write_value(env, valid);
}

void CallableBridge::engine_call_rpc(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::read_variants(env, args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    CALL_VARIADIC(args_size, args, callable.rpc);
}

void CallableBridge::engine_call_rpc_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::read_variants(env, args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    // args[0] is the peer id (Variant converts to int64_t implicitly); the rest are the RPC arguments.
    CALL_VARIADIC_OR(args_size, args, callable.rpc_id, JVM_ERR_FAIL_MSG("rpc_id: missing peer id"));
}

void CallableBridge::engine_call_unbind(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t argcount;
    TransferContext::read_values(env, argcount);
    godot::Callable unbound = native<godot::Callable>(p_handle).unbind(argcount);
    TransferContext::write_value(env, unbound);
}

CallableBridge::~CallableBridge() = default;
