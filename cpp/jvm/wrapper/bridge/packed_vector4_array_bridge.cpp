#include "packed_vector4_array_bridge.h"

using namespace bridges;

PackedVector4ArrayBridge::~PackedVector4ArrayBridge() = default;

uintptr_t PackedVector4ArrayBridge::engine_convert_to_godot(JNIEnv* p_raw_env, jobject, jfloatArray p_array) {
    jni::Env env {p_raw_env};
    jni::JFloatArray arr {p_array};

    jint float_size = arr.length(env);
    uint64_t vector_size = float_size / 4;

    godot::PackedVector4Array* vector_packed = VariantAllocator::alloc(godot::PackedVector4Array());
    vector_packed->resize(vector_size);
    godot::Vector4* ptr = vector_packed->ptrw();
    arr.get_array_elements(env, reinterpret_cast<jfloat*>(ptr), float_size);

    return reinterpret_cast<uintptr_t>(vector_packed);
}

jfloatArray PackedVector4ArrayBridge::engine_convert_to_jvm(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env {p_raw_env};
    godot::PackedVector4Array* vector_packed {from_uint_to_ptr<godot::PackedVector4Array>(p_raw_ptr)};

    uint64_t vector_size = vector_packed->size();
    jint float_size = vector_size * 4;

    jni::JFloatArray arr {env, float_size};
    const godot::Vector4* ptr = vector_packed->ptr();
    arr.set_array_elements(env, reinterpret_cast<const jfloat*>(ptr), float_size);

    return reinterpret_cast<jfloatArray>(arr.get_wrapped());
}