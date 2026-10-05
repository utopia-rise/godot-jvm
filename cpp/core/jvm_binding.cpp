#include "jvm_binding.h"

#include "engine/godot_object.h"

#include <godot.hpp>

using namespace godot;

void JvmBinding::init(GodotObject* p_engine_object) {
    object_id = ObjectID(raw_godot::RawObject(p_engine_object).get_instance_id());
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
