#ifndef GODOT_JVM_HASH_H
#define GODOT_JVM_HASH_H

// Be cautious when modifying these values: they define the persisted UID namespaces
// for Godot-JVM resources and will change how the editor identifies them.
static constexpr const char* GDJ_UUID_HASH_SEED {"GODOT_JVM_GDJ_f365477a"};
static constexpr const char* KOTLIN_UUID_HASH_SEED {"GODOT_JVM_KT_f365477a"};
static constexpr const char* JAVA_UUID_HASH_SEED {"GODOT_JVM_JAVA_f365477a"};
static constexpr const char* SCALA_UUID_HASH_SEED {"GODOT_JVM_SCALA_f365477a"};
static constexpr const char* JAVA_ARCHIVE_UUID_HASH_SEED {"GODOT_JVM_ARCHIVE_f365477a"};

#endif // GODOT_JVM_HASH_H
