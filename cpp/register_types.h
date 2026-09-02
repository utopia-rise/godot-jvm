#ifndef GODOT_JVM_REGISTER_TYPES_H
#define GODOT_JVM_REGISTER_TYPES_H

#include <core/class_db.hpp>

using namespace godot;

void initialize_godot_jvm_library(ModuleInitializationLevel p_level);
void uninitialize_godot_jvm_library(ModuleInitializationLevel p_level);

#endif //GODOT_JVM_REGISTER_TYPES_H
