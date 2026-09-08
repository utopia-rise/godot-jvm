#include "packed_float_64_array_bridge.h"

#include "bridges_utils.h"

using namespace bridges;

uintptr_t PackedFloat64ArrayBridge::engine_convert_to_godot(JNIEnv* p_raw_env, jobject, jdoubleArray p_array) {
    jni::Env env = p_raw_env;
    jni::JDoubleArray arr = p_array;

    jint size = arr.length(env);

    godot::PackedFloat64Array vec;
    vec.resize(size);
    arr.get_array_elements(env, reinterpret_cast<jdouble*>(vec.ptrw()), size);

    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::PackedFloat64Array(vec)));
}

jdoubleArray PackedFloat64ArrayBridge::engine_convert_to_jvm(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    godot::PackedFloat64Array* packed = from_uint_to_ptr<godot::PackedFloat64Array>(p_raw_ptr);
    auto size = static_cast<int>(packed->size());

    jni::Env env = p_raw_env;
    jni::JDoubleArray arr = jni::JDoubleArray(env, size);
    arr.set_array_elements(env, reinterpret_cast<const jdouble*>(packed->ptr()), size);
    return reinterpret_cast<jdoubleArray>(arr.get_wrapped());
}

PackedFloat64ArrayBridge::~PackedFloat64ArrayBridge() = default;