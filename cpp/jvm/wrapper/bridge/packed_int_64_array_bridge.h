#ifndef GODOT_JVM_PACKED_INT_64_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_INT_64_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {

    PACKED_ARRAY_BRIDGE(PackedInt64ArrayBridge, int64_t, "godot.core.PackedInt64Array$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedInt64ArrayBridge, int64_t)

        // clang-format off
        INIT_JNI_BINDINGS(
            PackedArrayBridge<PackedInt64ArrayBridge, int64_t, PackedInt64ArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);

            INIT_NATIVE_METHOD("engine_convert_to_godot", "([J)J", PackedInt64ArrayBridge::engine_convert_to_godot)
            INIT_NATIVE_METHOD("engine_convert_to_jvm", "(J)[J", PackedInt64ArrayBridge::engine_convert_to_jvm)
        )
        // clang-format on

    public:
        static uintptr_t engine_convert_to_godot(JNIEnv * p_raw_env, jobject p_instance, jlongArray p_array);
        static jlongArray engine_convert_to_jvm(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };
} // namespace bridges

#endif // GODOT_JVM_PACKED_INT_64_ARRAY_BRIDGE_H
