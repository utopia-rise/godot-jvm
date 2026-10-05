#include "jvm_binding.h"

#include "jvm/wrapper/memory/type_manager.h"

#include <godot.hpp>

using namespace godot;

void JvmBinding::init_from_class_name(ObjectID p_object_id, const StringName& p_class_name) {
    object_id = p_object_id;

    StringName class_name = p_class_name;
    do {
        if (!TypeManager::get_instance().java_engine_type_constructor_for_type_exists(class_name)) {
            class_name = ClassDB::get_parent_class(class_name);
        } else {
            break;
        }
    } while (class_name != StringName());
    constructor_id = TypeManager::get_instance().get_java_engine_type_constructor_index_for_type(class_name);
}

void JvmBinding::init(GodotObject* p_engine_object) {
    raw_godot::RawObject object = p_engine_object;
    const ObjectID id = ObjectID(object.get_instance_id());
    StringName class_name = object.get_class_name();

    init_from_class_name(id, class_name);
}

int JvmBinding::get_constructor_id() const {
    return constructor_id;
}

ObjectID JvmBinding::get_object_id() const {
    return object_id;
}

uint32_t JvmBinding::record_delivery() {
    return deliveries.fetch_add(1, std::memory_order_acq_rel);
}

uint32_t JvmBinding::get_deliveries() const {
    return deliveries.load(std::memory_order_acquire);
}
