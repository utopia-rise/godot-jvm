#include "packed_float_32_array_bridge.h"

#include "bridges_utils.h"

using namespace bridges;

uintptr_t PackedFloat32ArrayBridge::engine_convert_to_godot(JNIEnv* p_raw_env, jobject, jfloatArray p_array) {
    jni::Env env = p_raw_env;
    jni::JFloatArray arr = p_array;

    jint size = arr.length(env);

    godot::PackedFloat32Array vec;
    vec.resize(size);
    arr.get_array_elements(env, reinterpret_cast<jfloat*>(vec.ptrw()), size);

    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::PackedFloat32Array(vec)));
}

jfloatArray PackedFloat32ArrayBridge::engine_convert_to_jvm(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    godot::PackedFloat32Array* packed = from_uint_to_ptr<godot::PackedFloat32Array>(p_raw_ptr);
    auto size = static_cast<int>(packed->size());

    jni::Env env = p_raw_env;
    jni::JFloatArray arr = jni::JFloatArray(env, size);
    arr.set_array_elements(env, reinterpret_cast<const jfloat*>(packed->ptr()), size);
    return reinterpret_cast<jfloatArray>(arr.get_wrapped());
}

PackedFloat32ArrayBridge::~PackedFloat32ArrayBridge() = default;