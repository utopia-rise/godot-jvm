#ifndef GODOT_JVM_PACKED_INT_32_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_INT_32_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {

    PACKED_ARRAY_BRIDGE(PackedInt32ArrayBridge, int, "godot.core.PackedInt32Array$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedInt32ArrayBridge, int)

        // clang-format off
        INIT_JNI_BINDINGS(
            PackedArrayBridge<PackedInt32ArrayBridge, int, PackedInt32ArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);

            INIT_NATIVE_METHOD("engine_convert_to_godot", "([I)J", PackedInt32ArrayBridge::engine_convert_to_godot)
            INIT_NATIVE_METHOD("engine_convert_to_jvm", "(J)[I", PackedInt32ArrayBridge::engine_convert_to_jvm)
          )
        // clang-format on

    public:
        static uintptr_t engine_convert_to_godot(JNIEnv * p_raw_env, jobject p_instance, jintArray p_array);
        static jintArray engine_convert_to_jvm(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif
