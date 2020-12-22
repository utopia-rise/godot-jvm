#include <modules/kotlin_jvm/src/gd_kotlin.h>
#include <modules/kotlin_jvm/src/bridges/bridges_utils.h>
#include "pool_vector3_array_bridge.h"
#include "constants.h"

using namespace bridges;

JNI_INIT_STATICS_FOR_CLASS(PoolVector3ArrayBridge)

PoolVector3ArrayBridge::PoolVector3ArrayBridge(jni::JObject p_wrapped, jni::JObject p_class_loader)
        : JavaInstanceWrapper(POOL_VECTOR3_ARRAY_BRIDGE_CLASS_NAME, p_wrapped, p_class_loader) {
    jni::JNativeMethod engine_call_constructor_method{
            "engine_call_constructor",
            "(Z)J",
            (void*) PoolVector3ArrayBridge::engine_call_constructor
    };
    jni::JNativeMethod engine_call_append_method{
            "engine_call_append",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_append
    };
    jni::JNativeMethod engine_call_appendArray_method{
            "engine_call_appendArray",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_appendArray
    };
    jni::JNativeMethod engine_call_get_method{
            "engine_call_get",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_get
    };
    jni::JNativeMethod engine_call_insert_method{
            "engine_call_insert",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_insert
    };
    jni::JNativeMethod engine_call_invert_method{
            "engine_call_invert",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_invert
    };
    jni::JNativeMethod engine_call_pushback_method{
            "engine_call_pushback",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_pushback
    };
    jni::JNativeMethod engine_call_remove_method{
            "engine_call_remove",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_remove
    };
    jni::JNativeMethod engine_call_resize_method{
            "engine_call_resize",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_resize
    };
    jni::JNativeMethod engine_call_set_method{
            "engine_call_set",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_set
    };
    jni::JNativeMethod engine_call_size_method{
            "engine_call_size",
            "(J)V",
            (void*) PoolVector3ArrayBridge::engine_call_size
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

uintptr_t PoolVector3ArrayBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance, jboolean has_param) {
    return reinterpret_cast<uintptr_t>(new PoolVector3Array());
}

void PoolVector3ArrayBridge::engine_call_append(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->append(args[0].operator Vector3());
}

void PoolVector3ArrayBridge::engine_call_appendArray(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->append_array(args[0].operator PoolVector3Array());
}

void PoolVector3ArrayBridge::engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    Variant variant{from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->operator[](args[0].operator unsigned int())};
    transfer_context->write_return_value(env, variant);
}

void PoolVector3ArrayBridge::engine_call_insert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[2] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->insert(args[0].operator unsigned int(), args[1].operator Vector3());
}

void PoolVector3ArrayBridge::engine_call_invert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->invert();
}

void PoolVector3ArrayBridge::engine_call_pushback(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->push_back(args[0].operator Vector3());
}

void PoolVector3ArrayBridge::engine_call_remove(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->remove(args[0].operator unsigned int());
}

void PoolVector3ArrayBridge::engine_call_resize(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->remove(args[0].operator unsigned int());
}

void PoolVector3ArrayBridge::engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant args[2] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->set(args[0].operator unsigned int(), args[1].operator Vector3());
}

void PoolVector3ArrayBridge::engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};;
    Variant variant{from_uint_to_ptr<PoolVector3Array>(p_raw_ptr)->size()};
    GDKotlin::get_instance().transfer_context->write_return_value(env, variant);
}