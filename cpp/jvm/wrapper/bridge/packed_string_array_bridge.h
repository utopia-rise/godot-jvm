#ifndef GODOT_JVM_PACKED_STRING_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_STRING_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {

    PACKED_ARRAY_BRIDGE(PackedStringArrayBridge, godot::String, "godot.core.PackedStringArray$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedStringArrayBridge, godot::String)

        // clang-format off
          INIT_JNI_BINDINGS(
              PackedArrayBridge<PackedStringArrayBridge, godot::String, PackedStringArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);
          )
        // clang-format on
    };
} // namespace bridges

#endif
