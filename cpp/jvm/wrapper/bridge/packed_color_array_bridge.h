#ifndef GODOT_JVM_PACKED_COLOR_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_COLOR_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {
    PACKED_ARRAY_BRIDGE(PackedColorArrayBridge, godot::Color, "godot.core.PackedColorArray$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedColorArrayBridge, godot::Color)

        // clang-format off
          INIT_JNI_BINDINGS(
              PackedArrayBridge<PackedColorArrayBridge, godot::Color, PackedColorArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);
              INIT_NATIVE_METHOD("engine_convert_to_godot", "([F)J", PackedColorArrayBridge::engine_convert_to_godot)
              INIT_NATIVE_METHOD("engine_convert_to_jvm", "(J)[F", PackedColorArrayBridge::engine_convert_to_jvm)
          )
        // clang-format on

    public:
        static uintptr_t engine_convert_to_godot(JNIEnv * p_raw_env, jobject p_instance, jfloatArray p_array);
        static jfloatArray engine_convert_to_jvm(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif
