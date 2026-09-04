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
    jni::Env env = jni::Env(p_raw_env);
    // has_on_destroy is only used by the cancellable one-shot signal connection below.
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
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    godot::Signal signal = args[0].operator godot::Signal();

    godot::Callable callable = memnew(
      KotlinCallableCustom(env, p_kt_custom_callable_instance, static_cast<godot::Variant::Type>(p_variant_type_ordinal), p_hash_code, true)
    );

    // Signal::get_object() materializes a godot-cpp wrapper. The id path stays raw instead.
    raw_godot::RawObject owner = raw_godot::RawObject::from_instance_id(signal.get_object_id());
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
    jni::Env env = jni::Env(p_raw_env);
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);
    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::Callable(args[0].operator godot::Callable())));
}

void CallableBridge::engine_call_bind(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::get_instance().read_args(env, args);

    // godot-cpp exposes no pointer-array bindp(); build an Array and go through bindv() instead.
    godot::Array bind_args;
    for (uint32_t i = 0; i < args_size; ++i) {
        bind_args.push_back(args[i]);
    }

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->bindv(bind_args);
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_call(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::get_instance().read_args(env, args);

    // godot-cpp exposes no pointer-array callp()/Callable::CallError; build an Array and go through callv() instead, which reports failures internally rather than via an out-param.
    godot::Array call_args;
    for (uint32_t i = 0; i < args_size; ++i) {
        call_args.push_back(args[i]);
    }

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->callv(call_args);
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_call_deferred(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::get_instance().read_args(env, args);

    // godot-cpp's call_deferred() is a variadic template with no pointer-array/Array overload, so the runtime argument count has to be unpacked by hand.
    const godot::Callable& callable = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    switch (args_size) {
        case 0: callable.call_deferred(); break;
        case 1: callable.call_deferred(args[0]); break;
        case 2: callable.call_deferred(args[0], args[1]); break;
        case 3: callable.call_deferred(args[0], args[1], args[2]); break;
        case 4: callable.call_deferred(args[0], args[1], args[2], args[3]); break;
        case 5: callable.call_deferred(args[0], args[1], args[2], args[3], args[4]); break;
        case 6: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5]); break;
        case 7: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6]); break;
        case 8: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]); break;
        case 9: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]); break;
        case 10: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]); break;
        case 11: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]); break;
        case 12: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11]); break;
        case 13: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12]); break;
        case 14: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13]); break;
        case 15: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14]); break;
        case 16: callable.call_deferred(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15]); break;
        default: JVM_ERR_FAIL_MSG("call_deferred: too many arguments"); break;
    }
}

void CallableBridge::engine_call_get_bound_arguments(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_bound_arguments();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_bound_arguments_count(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_bound_arguments_count();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_method(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_method();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_object(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_object();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_get_object_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result = from_uint_to_ptr<godot::Callable>(p_raw_ptr)->get_object_id();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_hash(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->hash();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_custom(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_custom();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_null(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_null();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_standard(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_standard();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_is_valid(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->is_valid();
    TransferContext::get_instance().write_return_value(env, result);
}

void CallableBridge::engine_call_rpc(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::get_instance().read_args(env, args);

    const godot::Variant* args_ptr[MAX_FUNCTION_ARG_COUNT];
    for (uint32_t i = 0; i < args_size; ++i) {
        args_ptr[i] = &args[i];
    }
    godot::Variant instance = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    instance.call(SNAME("rpc"), args_ptr);
}

void CallableBridge::engine_call_rpc_id(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);

    godot::Variant args[MAX_FUNCTION_ARG_COUNT];
    uint32_t args_size = TransferContext::get_instance().read_args(env, args);

    const godot::Variant* args_ptr[MAX_FUNCTION_ARG_COUNT];
    for (uint32_t i = 0; i < args_size; ++i) {
        args_ptr[i] = &args[i];
    }

    godot::Variant instance = *from_uint_to_ptr<godot::Callable>(p_raw_ptr);
    instance.call(SNAME("rpc_id"), args_ptr);
}

void CallableBridge::engine_call_unbind(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env = jni::Env(p_raw_env);
    godot::Variant args[1];
    TransferContext::get_instance().read_args(env, args);

    godot::Variant result =from_uint_to_ptr<godot::Callable>(p_raw_ptr)->unbind(args[0]);
    TransferContext::get_instance().write_return_value(env, result);
}

CallableBridge::~CallableBridge() = default;
