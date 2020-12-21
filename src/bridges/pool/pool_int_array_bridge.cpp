#include <modules/kotlin_jvm/src/gd_kotlin.h>
#include "pool_int_array_bridge.h"
#include "constants.h"
#include "bridges_utils.h"

using namespace bridges;

JNI_INIT_STATICS_FOR_CLASS(PoolIntArrayBridge)

PoolIntArrayBridge::PoolIntArrayBridge(jni::JObject p_wrapped, jni::JObject p_class_loader)
        : JavaInstanceWrapper(POOL_INT_ARRAY_CLASS_NAME, p_wrapped, p_class_loader) {
    jni::JNativeMethod engine_call_constructor_method{
            "engine_call_constructor",
            "(Z)J",
            (void*) PoolIntArrayBridge::engine_call_constructor
    };
    jni::JNativeMethod engine_call_append_method{
            "engine_call_append",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_append
    };
    jni::JNativeMethod engine_call_appendArray_method{
            "engine_call_appendArray",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_appendArray
    };
    jni::JNativeMethod engine_call_get_method{
            "engine_call_get",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_get
    };
    jni::JNativeMethod engine_call_insert_method{
            "engine_call_insert",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_insert
    };
    jni::JNativeMethod engine_call_invert_method{
            "engine_call_invert",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_invert
    };
    jni::JNativeMethod engine_call_pushback_method{
            "engine_call_pushback",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_pushback
    };
    jni::JNativeMethod engine_call_remove_method{
            "engine_call_remove",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_remove
    };
    jni::JNativeMethod engine_call_resize_method{
            "engine_call_resize",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_resize
    };
    jni::JNativeMethod engine_call_set_method{
            "engine_call_set",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_set
    };
    jni::JNativeMethod engine_call_size_method{
            "engine_call_size",
            "(J)V",
            (void*) PoolIntArrayBridge::engine_call_size
    };

    Vector<jni::JNativeMethod> methods;
    methods.push_back(engine_call_constructor_method);
    methods.push_back(engine_call_append_method);
    methods.push_back(engine_call_appendArray_method);
    methods.push_back(engine_call_get_method);
    methods.push_back(engine_call_insert_method);
    methods.push_back(engine_call_invert_method);
    methods.push_back(engine_call_pushback_method);
    methods.push_back(engine_call_remove_method);
    methods.push_back(engine_call_remove_method);
    methods.push_back(engine_call_set_method);
    methods.push_back(engine_call_size_method);

    jni::Env env{jni::Jvm::current_env()};
    j_class.register_natives(env, methods);
    p_wrapped.delete_local_ref(env);
}

uintptr_t PoolIntArrayBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance, jboolean has_param) {
    return reinterpret_cast<uintptr_t>(new PoolINTArray());
}

void PoolIntArrayBridge::engine_call_append(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->append(args[0].operator signed int());
}

void PoolIntArrayBridge::engine_call_appendArray(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->append_array(args[0].operator PoolIntArray());
}

void PoolIntArrayBridge::engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    Variant variant{from_uint_to_ptr<PoolIntArray>(p_raw_ptr)[args[0].operator unsigned int()]};
    transfer_context->write_return_value(env, variant);
}

void PoolIntArrayBridge::engine_call_insert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[2] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->insert(args[0].operator unsigned int(), args[1].operator signed int());
}

void PoolIntArrayBridge::engine_call_invert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->append(args[0].operator PoolIntArray());
}

void PoolIntArrayBridge::engine_call_pushback(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->push_back(args[0].operator signed int());
}

void PoolIntArrayBridge::engine_call_remove(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->remove(args[0].operator unsigned int());
}

void PoolIntArrayBridge::engine_call_resize(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->remove(args[0].operator unsigned int());
}

void PoolIntArrayBridge::engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant args[2] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->set(args[0].operator unsigned int(), , args[1].operator signed int());
}

void PoolIntArrayBridge::engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{jni::Jvm::current_env()};
    Variant variant{from_uint_to_ptr<PoolIntArray>(p_raw_ptr)->size()};
    transfer_context->write_return_value(env, variant);
}