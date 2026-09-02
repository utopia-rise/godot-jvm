#ifndef GODOT_JVM_PACKED_FLOAT_64_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_FLOAT_64_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {

    PACKED_ARRAY_BRIDGE(PackedFloat64ArrayBridge, double, "godot.core.PackedFloat64Array$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedFloat64ArrayBridge, double)

        // clang-format off
        INIT_JNI_BINDINGS(
            PackedArrayBridge<PackedFloat64ArrayBridge, double, PackedFloat64ArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);
            INIT_NATIVE_METHOD("engine_convert_to_godot", "([D)J", PackedFloat64ArrayBridge::engine_convert_to_godot)
            INIT_NATIVE_METHOD("engine_convert_to_jvm", "(J)[D", PackedFloat64ArrayBridge::engine_convert_to_jvm)
        )
        // clang-format on

    public:
        static uintptr_t engine_convert_to_godot(JNIEnv * p_raw_env, jobject p_instance, jdoubleArray p_array);
        static jdoubleArray engine_convert_to_jvm(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif // GODOT_JVM_PACKED_FLOAT_64_ARRAY_BRIDGE_H
