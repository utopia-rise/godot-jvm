#include "callable_bridge.h"

#include "bridges_utils.h"
#include "constraints.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/kotlin_callable_custom.h"
#include "jvm/wrapper/memory/transfer_context.h"

#include <classes/object.hpp>
#include <variant/array.hpp>

using namespace bridges;

uintptr_t CallableBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Callable()));
}

uintptr_t CallableBridge::engine_call_constructor_object_string_name(JNIEnv* p_raw_env, jobject p_instance, jlong object_ptr, jlong method_name_ptr) {
    // object_ptr is the raw engine pointer, and make_callable() issues the same engine constructor godot-cpp's
    // Callable(Object*, StringName) does — without materializing the wrapper it would only read `_owner` off.
    auto* obj {reinterpret_cast<godot::GodotObject*>(object_ptr)};
    auto* name {reinterpret_cast<godot::StringName*>(method_name_ptr)};
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(raw_godot::RawObject(obj).to_callable(*name)));
}

uintptr_t CallableBridge::engine_call_constructor_lambda_callable(
  JNIEnv* p_raw_env,
  jobject p_instance,
  jobject p_lambda_container,
  jint p_variant_type_ordinal,
  jint p_hash_code
) {
    jni::Env env {p_raw_env};
    // has_on_destroy is always false here — matches master exactly. It's only ever true for the "cancellable" one-shot-signal-connection case below, not the general lambda-callable case; neither Kotlin call site passes it explicitly (there is...
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(
      godot::Callable(memnew(
        KotlinCallableCustom(env, p_lambda_container, static_cast<godot::Variant::Type>(p_variant_type_ordinal), p_hash_code, false)
      ))
    ));
}

void CallableBridge::engine_call_constructor_cancellable(
  JNIEnv* p_raw_env,
  jobject p_instance,
  jobject p_kt_custom_callable_instance,
  jint p_variant_type_ordinal,
  jint p_hash_code
) {
    jni::Env env {p_raw_env};

    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Signal signal = args[0].operator godot::Signal();

    godot::Callable callable {memnew(
      KotlinCallableCustom(env, p_kt_custom_callable_instance, static_cast<godot::Variant::Type>(p_variant_type_ordinal), p_hash_code, true)
    )};

    // Signal::get_object() materializes a godot-cpp wrapper. The id path stays raw instead.
    raw_godot::RawObject owner {raw_godot::RawObject::from_instance_id(signal.get_object_id())};
    if (owner.is_null()) {
        return;
    }
    if (owner.is_class(SNAME("Node"))) {
        owner.call_thread_safe(SNAME("connect"), signal.get_name(), callable, static_cast<int64_t>(godot::Object::CONNECT_ONE_SHOT));
    } else {
        signal.connect(callable, godot::Object::CONNECT_ONE_SHOT);
    }
}

uintptr_t CallableBridge::engine_call_copy_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Callable(args[0].operator godot::Callable())));
}

void CallableBridge::engine_call_bind(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size {TransferContext::get_instance().read_args(env, args)};

    const godot::Callable& callable = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    godot::Variant result;
    CALL_VARIADIC(args_size, args, result = callable.bind);
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_call(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size {TransferContext::get_instance().read_args(env, args)};

    const godot::Callable& callable = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    godot::Variant result;
    CALL_VARIADIC(args_size, args, result = callable.call);
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_call_deferred(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size {TransferContext::get_instance().read_args(env, args)};

    const godot::Callable& callable = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    CALL_VARIADIC(args_size, args, callable.call_deferred);
}

void CallableBridge::engine_call_get_bound_arguments(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_bound_arguments();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_bound_arguments_count(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_bound_arguments_count();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_method(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_method();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_object(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_object();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_object_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_object_id();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->hash();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_custom(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_custom();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_null(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_null();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_standard(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_standard();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_valid(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_valid();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_rpc(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size {TransferContext::get_instance().read_args(env, args)};

    const godot::Callable& callable = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    CALL_VARIADIC(args_size, args, callable.rpc);
}

void CallableBridge::engine_call_rpc_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size {TransferContext::get_instance().read_args(env, args)};

    const godot::Callable& callable = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    // args[0] is the peer id (Variant converts to int64_t implicitly); the rest are the RPC arguments.
    CALL_VARIADIC_OR(args_size, args, callable.rpc_id, JVM_ERR_FAIL_MSG("rpc_id: missing peer id"));
}

void CallableBridge::engine_call_unbind(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->unbind(args[0]);
    TransferContext::get_instance().write_return_value(env, result);
}

CallableBridge::~CallableBridge() = default;
