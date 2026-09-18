#include "packed_int_32_array_bridge.h"

#include "bridges_utils.h"
#include "core/variant_allocator.h"

using namespace bridges;

uintptr_t PackedInt32ArrayBridge::engine_convert_to_godot(JNIEnv* p_raw_env, jobject, jintArray p_array) {
    jni::Env env(p_raw_env);
    jni::JIntArray arr(p_array);

    jint size = arr.length(env);

    godot::PackedInt32Array vec;
    vec.resize(size);
    arr.get_array_elements(env, reinterpret_cast<jint*>(vec.ptrw()), size);

    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::PackedInt32Array(vec)));
}

jintArray PackedInt32ArrayBridge::engine_convert_to_jvm(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    godot::PackedInt32Array& packed = native<godot::PackedInt32Array>(p_handle);
    auto size = static_cast<int>(packed.size());

    jni::Env env(p_raw_env);
    jni::JIntArray arr(env, size);
    arr.set_array_elements(env, reinterpret_cast<const jint*>(packed.ptr()), size);
    return reinterpret_cast<jintArray>(arr.get_wrapped());
}

PackedInt32ArrayBridge::~PackedInt32ArrayBridge() = default;
