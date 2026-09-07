#ifndef GODOT_JVM_JVM_USER_CONFIGURATION_H
#define GODOT_JVM_JVM_USER_CONFIGURATION_H

#include "jvm/jni/jvm.h"

#include <variant/typed_array.hpp>
#include <variant/packed_string_array.hpp>
#include <templates/hash_map.hpp>

// JSON IDENTIFIER
static constexpr const char* VERSION_JSON_IDENTIFIER = "version";
static constexpr const char* VM_TYPE_JSON_IDENTIFIER = "vm_type";
static constexpr const char* USE_DEBUG_JSON_IDENTIFIER = "use_debug";
static constexpr const char* DEBUG_PORT_JSON_IDENTIFIER = "debug_port";
static constexpr const char* DEBUG_ADDRESS_JSON_IDENTIFIER = "debug_address";
static constexpr const char* JMX_PORT_JSON_IDENTIFIER = "jmx_port";
static constexpr const char* WAIT_FOR_DEBUGGER_JSON_IDENTIFIER = "wait_for_debugger";
static constexpr const char* MAX_STRING_SIZE_JSON_IDENTIFIER = "max_string_size";
static constexpr const char* DISABLE_GC_JSON_IDENTIFIER = "disable_gc";
static constexpr const char* JVM_ARGUMENTS_JSON_IDENTIFIER = "custom_jvm_args";

// COMMAND LINE IDENTIFIER
static constexpr const char* VM_TYPE_CMD_IDENTIFIER = "--jvm-vm-type";
static constexpr const char* USE_DEBUG_CMD_IDENTIFIER = "--jvm-use-debug";
static constexpr const char* DEBUG_PORT_CMD_IDENTIFIER = "--jvm-debug-port";
static constexpr const char* DEBUG_ADDRESS_CMD_IDENTIFIER = "--jvm-debug-address";
static constexpr const char* WAIT_FOR_DEBUGGER_CMD_IDENTIFIER = "--jvm-wait-for-debugger";
static constexpr const char* JMX_PORT_CMD_IDENTIFIER = "--jvm-jmx-port";
static constexpr const char* MAX_STRING_SIZE_CMD_IDENTIFIER = "--jvm-max-string-size";
static constexpr const char* DISABLE_GC_CMD_IDENTIFIER = "--jvm-disable-gc";
static constexpr const char* JVM_ARGUMENTS_CMD_IDENTIFIER = "--jvm-custom-args";

// VALUE
static constexpr const char* AUTO_STRING = "auto";
static constexpr const char* JVM_STRING = "jvm";
static constexpr const char* GRAAL_NATIVE_IMAGE_STRING = "graal_native_image";
static constexpr const char* ART_STRING = "art";
static constexpr const char* TRUE_STRING = "true";
static constexpr const char* FALSE_STRING = "false";
static constexpr const char* JSON_ARGUMENT_VERSION = "2.0";

struct JvmUserConfiguration {
    jni::JvmType vm_type = jni::JvmType::NONE;

    bool use_debug = false;
    int32_t jvm_debug_port = 5005;
    godot::String jvm_debug_address = "*";
    bool wait_for_debugger = true;

    int32_t jvm_jmx_port = -1;

    // -1 means "auto" and leaves LongStringQueue::max_string_size unchanged.
    int32_t max_string_size = -1;

    bool disable_gc = false;

    godot::Array jvm_args;

    JvmUserConfiguration() = default;
    ~JvmUserConfiguration() = default;

    static bool parse_configuration_json(const godot::String& json_string, JvmUserConfiguration& json_config);
    static godot::String export_configuration_to_json(const JvmUserConfiguration& configuration);

    static void parse_command_line(const godot::PackedStringArray& args, godot::HashMap<godot::String, godot::Variant>& configuration_map);

    static void merge_with_command_line(JvmUserConfiguration& json_config, const godot::HashMap<godot::String, godot::Variant>& cmd_map);
    static void sanitize_and_log_configuration(JvmUserConfiguration& config);
};

#endif // GODOT_JVM_JVM_USER_CONFIGURATION_H
