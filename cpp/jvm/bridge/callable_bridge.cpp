#include "callable_bridge.h"

#include "bridges_utils.h"
#include "constraints.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "jvm/bridge/kotlin_callable_custom.h"
#include "jvm/memory/variant_buffer.h"
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
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(engine::RawObject(obj).to_callable(*name)));
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
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Signal signal;
    transfer->read_args(signal);

    godot::Callable callable = memnew(KotlinCallableCustom(
        env,
        p_kt_custom_callable_instance,
        static_cast<godot::Variant::Type>(p_variant_type_ordinal),
        p_hash_code,
        true
    ));

    engine::RawObject owner = signal.get_object();
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
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    godot::Callable callable;
    transfer->read_args(callable);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Callable(callable)));
}

void CallableBridge::engine_call_bind(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Variant args[MAX_ARGUMENT_COUNT];
    uint32_t args_size = transfer->decode_args(args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    godot::Variant result;
    CALL_VARIADIC(args_size, args, result = callable.bind);
    transfer->write_ret(result);
}

void CallableBridge::engine_call_call(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Variant args[MAX_ARGUMENT_COUNT];
    uint32_t args_size = transfer->decode_args(args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    godot::Variant result;
    CALL_VARIADIC(args_size, args, result = callable.call);
    transfer->write_ret(result);
}

void CallableBridge::engine_call_call_deferred(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Variant args[MAX_ARGUMENT_COUNT];
    uint32_t args_size = transfer->decode_args(args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    CALL_VARIADIC(args_size, args, callable.call_deferred);
}

void CallableBridge::engine_call_get_bound_arguments(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Array bound_arguments = native<godot::Callable>(p_handle).get_bound_arguments();
    transfer->write_ret(bound_arguments);
}

void CallableBridge::engine_call_get_bound_arguments_count(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    int64_t count = native<godot::Callable>(p_handle).get_bound_arguments_count();
    transfer->write_ret(count);
}

void CallableBridge::engine_call_get_method(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::StringName method = native<godot::Callable>(p_handle).get_method();
    transfer->write_ret(method);
}

void CallableBridge::engine_call_get_object(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    engine::RawObject object = native<godot::Callable>(p_handle).get_object();
    transfer->write_ret(object);
}

void CallableBridge::engine_call_get_object_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    int64_t object_id = native<godot::Callable>(p_handle).get_object_id();
    transfer->write_ret(object_id);
}

void CallableBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    int64_t hash = native<godot::Callable>(p_handle).hash();
    transfer->write_ret(hash);
}

void CallableBridge::engine_call_is_custom(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    bool custom = native<godot::Callable>(p_handle).is_custom();
    transfer->write_ret(custom);
}

void CallableBridge::engine_call_is_null(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    bool null = native<godot::Callable>(p_handle).is_null();
    transfer->write_ret(null);
}

void CallableBridge::engine_call_is_standard(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    bool standard = native<godot::Callable>(p_handle).is_standard();
    transfer->write_ret(standard);
}

void CallableBridge::engine_call_is_valid(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    bool valid = native<godot::Callable>(p_handle).is_valid();
    transfer->write_ret(valid);
}

void CallableBridge::engine_call_rpc(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Variant args[MAX_ARGUMENT_COUNT];
    uint32_t args_size = transfer->decode_args(args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    CALL_VARIADIC(args_size, args, callable.rpc);
}

void CallableBridge::engine_call_rpc_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Variant args[MAX_ARGUMENT_COUNT];
    uint32_t args_size = transfer->decode_args(args);

    const godot::Callable& callable = native<godot::Callable>(p_handle);
    // args[0] is the peer id (Variant converts to int64_t implicitly); the rest are the RPC arguments.
    CALL_VARIADIC_OR(args_size, args, callable.rpc_id, JVM_ERR_FAIL_MSG("rpc_id: missing peer id"));
}

void CallableBridge::engine_call_unbind(JNIEnv* p_raw_env, jobject p_instance, jlong p_handle) {
    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();
    int64_t argcount;
    transfer->read_args(argcount);
    godot::Callable unbound = native<godot::Callable>(p_handle).unbind(argcount);
    transfer->write_ret(unbound);
}
