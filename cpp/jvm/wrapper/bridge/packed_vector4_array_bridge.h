#ifndef GODOT_JVM_PACKED_VECTOR4_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_VECTOR4_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {
    PACKED_ARRAY_BRIDGE(PackedVector4ArrayBridge, godot::Vector4, "godot.core.PackedVector4Array$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedVector4ArrayBridge, godot::Vector4)

        // clang-format off
        INIT_JNI_BINDINGS(
            PackedArrayBridge<PackedVector4ArrayBridge, godot::Vector4, PackedVector4ArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);
            INIT_NATIVE_METHOD("engine_convert_to_godot", "([F)J", PackedVector4ArrayBridge::engine_convert_to_godot)
            INIT_NATIVE_METHOD("engine_convert_to_jvm", "(J)[F", PackedVector4ArrayBridge::engine_convert_to_jvm)
        )
        // clang-format on

    public:
        static uintptr_t engine_convert_to_godot(JNIEnv * p_raw_env, jobject p_instance, jfloatArray p_array);
        static jfloatArray engine_convert_to_jvm(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif // GODOT_JVM_PACKED_VECTOR4_ARRAY_BRIDGE_H
