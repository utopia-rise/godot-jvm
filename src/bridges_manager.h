#ifndef GODOT_JVM_BRIDGES_MANAGER_H
#define GODOT_JVM_BRIDGES_MANAGER_H


#include <modules/kotlin_jvm/src/bridges/memory_bridge.h>
#include <modules/kotlin_jvm/src/bridges/variant_array_bridge.h>
#include <core/variant.h>
#include <modules/kotlin_jvm/src/bridges/dictionary_bridge.h>
#include <modules/kotlin_jvm/src/bridges/rid_bridge.h>
#include <modules/kotlin_jvm/src/bridges/node_path_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_byte_array_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_color_array_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_int_array_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_real_array_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_string_array_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_vector2_array_bridge.h>
#include <modules/kotlin_jvm/src/bridges/pool_vector3_array_bridge.h>

class BridgesManager {
private:
    bridges::MemoryBridge* memory_bridge;

    bridges::VariantArrayBridge* variant_array_bridge;
    bridges::DictionaryBridge* dictionary_bridge;
    bridges::RidBridge* rid_bridge;
    bridges::NodePathBridge* node_path_bridge;

    bridges::PoolByteArrayBridge* pool_byte_array_bridge;
    bridges::PoolColorArrayBridge* pool_color_array_bridge;
    bridges::PoolIntArrayBridge* pool_int_array_bridge;
    bridges::PoolRealArrayBridge* pool_real_array_bridge;
    bridges::PoolStringArrayBridge* pool_string_array_bridge;
    bridges::PoolVector2ArrayBridge* pool_vector2_array_bridge;
    bridges::PoolVector3ArrayBridge* pool_vector3_array_bridge;

    BridgesManager();
    ~BridgesManager() = default;

    template<class T>
    void initialize_bridge(jni::Env& env, jni::JObject class_loader, const char* jvm_class_name, T*& fill) {
        jni::JClass bridge_class{env.load_class(jvm_class_name, class_loader)};
        jni::FieldId bridge_instance_field{
                bridge_class.get_static_field_id(env, "INSTANCE", vformat("L%s;", jvm_class_name).replace(".", "/").utf8().ptr())
        };
        jni::JObject bridge_instance{
                bridge_class.get_static_object_field(env, bridge_instance_field)
        };
        fill = new T(bridge_instance, class_loader);
    }

public:
    BridgesManager(const BridgesManager&) = delete;
    static BridgesManager& get_instance();

    void initialize_bridges(jni::Env& env, jni::JObject class_loader);
    void delete_bridges();
};


#endif //GODOT_JVM_BRIDGES_MANAGER_H
