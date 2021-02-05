#include <modules/kotlin_jvm/src/bridges/constants.h>
#include "bridges_manager.h"

BridgesManager& BridgesManager::get_instance() {
    static BridgesManager bridgesManager;
    return bridgesManager;
}

void BridgesManager::initialize_bridges(jni::Env& env, jni::JObject class_loader) {
    initialize_bridge(env, class_loader, bridges::MEMORY_BRIDGE_CLASS_NAME, memory_bridge);

    initialize_bridge(env, class_loader, bridges::VARIANT_ARRAY_BRIDGE_CLASS_NAME, variant_array_bridge);
    initialize_bridge(env, class_loader, bridges::DICTIONARY_BRIDGE_CLASS_NAME, dictionary_bridge);
    initialize_bridge(env, class_loader, bridges::RID_BRIDGE_CLASS_NAME, rid_bridge);
    initialize_bridge(env, class_loader, bridges::NODE_PATH_BRIDGE_CLASS_NAME, node_path_bridge);

    initialize_bridge(env, class_loader, bridges::POOL_BYTE_ARRAY_BRIDGE_CLASS_NAME, pool_byte_array_bridge);
    initialize_bridge(env, class_loader, bridges::POOL_COLOR_ARRAY_BRIDGE_CLASS_NAME, pool_color_array_bridge);
    initialize_bridge(env, class_loader, bridges::POOL_INT_ARRAY_BRIDGE_CLASS_NAME, pool_int_array_bridge);
    initialize_bridge(env, class_loader, bridges::POOL_REAL_ARRAY_BRIDGE_CLASS_NAME, pool_real_array_bridge);
    initialize_bridge(env, class_loader, bridges::POOL_STRING_ARRAY_BRIDGE_CLASS_NAME, pool_string_array_bridge);
    initialize_bridge(env, class_loader, bridges::POOL_VECTOR2_ARRAY_BRIDGE_CLASS_NAME, pool_vector2_array_bridge);
    initialize_bridge(env, class_loader, bridges::POOL_VECTOR3_ARRAY_BRIDGE_CLASS_NAME, pool_vector3_array_bridge);
}

BridgesManager::BridgesManager() : memory_bridge(nullptr), variant_array_bridge(nullptr), dictionary_bridge(nullptr),
                                   rid_bridge(nullptr), node_path_bridge(nullptr), pool_byte_array_bridge(nullptr),
                                   pool_color_array_bridge(nullptr), pool_int_array_bridge(nullptr),
                                   pool_real_array_bridge(nullptr), pool_string_array_bridge(nullptr),
                                   pool_vector2_array_bridge(nullptr), pool_vector3_array_bridge(nullptr) {

}

void BridgesManager::delete_bridges() {
    delete memory_bridge;
    memory_bridge = nullptr;

    delete variant_array_bridge;
    variant_array_bridge = nullptr;

    delete dictionary_bridge;
    dictionary_bridge = nullptr;

    delete rid_bridge;
    rid_bridge = nullptr;

    delete node_path_bridge;
    node_path_bridge = nullptr;

    delete pool_byte_array_bridge;
    pool_byte_array_bridge = nullptr;

    delete pool_color_array_bridge;
    pool_color_array_bridge = nullptr;

    delete pool_int_array_bridge;
    pool_int_array_bridge = nullptr;

    delete pool_real_array_bridge;
    pool_real_array_bridge = nullptr;

    delete pool_string_array_bridge;
    pool_string_array_bridge = nullptr;

    delete pool_vector2_array_bridge;
    pool_vector2_array_bridge = nullptr;

    delete pool_vector3_array_bridge;
    pool_vector3_array_bridge = nullptr;
}
