#include "jvm_user_configuration.h"

#include <classes/json.hpp>

bool JvmUserConfiguration::is_valid_debug_address(const godot::String& address) {
    return address == "*" || address.is_valid_ip_address();
}

bool JvmUserConfiguration::parse_configuration_json(
    const godot::String& json_string,
    JvmUserConfiguration& json_config
) {
    godot::Ref<godot::JSON> json;
    json.instantiate();
    godot::Error error = json->parse(json_string);
    godot::Variant result = json->get_data();
    if (error != godot::OK || result.get_type() != godot::Variant::DICTIONARY) {
        JVM_ERR_FAIL_V_MSG(true, "Error parsing Godot-JVM configuration file! Falling back to default configuration");
    }

    godot::Dictionary input = result;
    godot::Dictionary values = json_config.to_dictionary();
    bool is_invalid = !input.has(VERSION_JSON_IDENTIFIER);
    for (const godot::String key : input.keys()) {
        godot::Variant value = input[key];
        bool valid = values.has(key);
        if (valid) {
            godot::Variant default_value = values[key];
            if (default_value.get_type() == godot::Variant::INT) {
                // JSON numbers may be FLOAT even for integral values. Check bounds before converting.
                valid = value.get_type() == godot::Variant::INT || value.get_type() == godot::Variant::FLOAT;
                if (valid) {
                    double number = value;
                    int minimum = key == DEBUG_PORT_JSON_IDENTIFIER ? 0 : -1;
                    valid = number >= minimum
                         && number <= MAX_STRING_SIZE_LIMIT
                         && number == static_cast<int64_t>(number);
                }
            } else {
                valid = value.get_type() == default_value.get_type();
            }
            if (valid && key == DEBUG_ADDRESS_JSON_IDENTIFIER) {
                godot::String address = value;
                valid = is_valid_debug_address(address);
            }
            if (valid && key == VERSION_JSON_IDENTIFIER) { valid = godot::String(value) == JSON_ARGUMENT_VERSION; }
            if (valid && key == JVM_ARGUMENTS_JSON_IDENTIFIER) {
                godot::Array arguments = value;
                for (const godot::Variant& argument : arguments) {
                    if (argument.get_type() != godot::Variant::STRING) { valid = false; }
                }
            }
        }
        if (valid) {
            values[key] = value;
        } else {
            JVM_LOG_WARNING("Invalid or outdated configuration setting: %s. It will be ignored", key);
            is_invalid = true;
        }
    }

    json_config.use_native_image = values[USE_NATIVE_IMAGE_JSON_IDENTIFIER];
    json_config.use_debug = values[USE_DEBUG_JSON_IDENTIFIER];
    json_config.jvm_debug_port = values[DEBUG_PORT_JSON_IDENTIFIER];
    json_config.jvm_debug_address = values[DEBUG_ADDRESS_JSON_IDENTIFIER];
    json_config.wait_for_debugger = values[WAIT_FOR_DEBUGGER_JSON_IDENTIFIER];
    json_config.jvm_jmx_port = values[JMX_PORT_JSON_IDENTIFIER];
    json_config.max_string_size = values[MAX_STRING_SIZE_JSON_IDENTIFIER];
    json_config.disable_gc = values[DISABLE_GC_JSON_IDENTIFIER];
    json_config.jvm_args = values[JVM_ARGUMENTS_JSON_IDENTIFIER];
    return is_invalid;
}

godot::Dictionary JvmUserConfiguration::to_dictionary() const {
    godot::Dictionary json;
    json[VERSION_JSON_IDENTIFIER] = JSON_ARGUMENT_VERSION;
    json[USE_NATIVE_IMAGE_JSON_IDENTIFIER] = use_native_image;
    json[USE_DEBUG_JSON_IDENTIFIER] = use_debug;
    json[DEBUG_PORT_JSON_IDENTIFIER] = jvm_debug_port;
    json[DEBUG_ADDRESS_JSON_IDENTIFIER] = jvm_debug_address;
    json[WAIT_FOR_DEBUGGER_JSON_IDENTIFIER] = wait_for_debugger;
    json[JMX_PORT_JSON_IDENTIFIER] = jvm_jmx_port;
    json[MAX_STRING_SIZE_JSON_IDENTIFIER] = max_string_size;
    json[DISABLE_GC_JSON_IDENTIFIER] = disable_gc;
    json[JVM_ARGUMENTS_JSON_IDENTIFIER] = jvm_args;
    return json;
}

godot::String JvmUserConfiguration::export_configuration_to_json(const JvmUserConfiguration& configuration) {
    return godot::JSON::stringify(configuration.to_dictionary(), "    ", true, false);
}

bool get_cmd_bool_or_default(const godot::String& value, bool default_if_empty) {
    if (value.is_empty()) {
        return default_if_empty;
    } else if (value == TRUE_STRING) {
        return true;
    } else if (value == FALSE_STRING) {
        return false;
    } else {
        JVM_ERR_FAIL_V_MSG(
            false,
            "Command line argument can't be parsed as a boolean value: %s. It will be treated as false",
            value
        );
    }
}

void JvmUserConfiguration::parse_command_line(
    const godot::PackedStringArray& args,
    godot::HashMap<godot::String, godot::Variant>& configuration_map
) {
    // We use a HashMap instead of JvmUserConfiguration so we can still make the difference between a
    // JvmUserConfiguration default value and the absence of the matching command line argument. Knowing this is
    // essential when merging with the json configuration later.

    for (const auto& arg : args) {
        int split_position = arg.find("=");
        godot::String identifier = split_position == -1 ? arg : arg.substr(0, split_position);
        godot::String value = split_position == -1 ? godot::String() : arg.substr(split_position + 1);

        if (identifier == USE_NATIVE_IMAGE_CMD_IDENTIFIER) {
            configuration_map[USE_NATIVE_IMAGE_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, true);
        } else if (identifier == USE_DEBUG_CMD_IDENTIFIER) {
            configuration_map[USE_DEBUG_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, true);
        } else if (identifier == DEBUG_PORT_CMD_IDENTIFIER) {
            int64_t port = -1;
            if (value.is_valid_int()) { port = value.to_int(); }
            if (port >= 0 && port <= 65535) {
                configuration_map[DEBUG_PORT_CMD_IDENTIFIER] = port;
            } else {
                JVM_LOG_WARNING("Invalid JVM port value in command line arguments: %s. It will be ignored", port);
            }
        } else if (identifier == DEBUG_ADDRESS_CMD_IDENTIFIER) {
            if (is_valid_debug_address(value)) {
                configuration_map[DEBUG_ADDRESS_CMD_IDENTIFIER] = value;
            } else {
                JVM_LOG_WARNING("Invalid JVM address value command line arguments: %s. It will be ignored", value);
            }
        } else if (identifier == WAIT_FOR_DEBUGGER_CMD_IDENTIFIER) {
            configuration_map[WAIT_FOR_DEBUGGER_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, true);
        } else if (identifier == JMX_PORT_CMD_IDENTIFIER) {
            int64_t port = -2;
            if (value.is_valid_int()) { port = value.to_int(); }
            if (port >= -1 && port <= 65535) {
                configuration_map[JMX_PORT_CMD_IDENTIFIER] = port;
            } else {
                JVM_LOG_WARNING("Invalid JMX port value command line arguments: %s. It will be ignored", port);
            }
        } else if (identifier == MAX_STRING_SIZE_CMD_IDENTIFIER) {
            int64_t size = -1;
            if (value.is_valid_int()) { size = value.to_int(); }
            if (value.is_valid_int() && size >= -1 && size <= MAX_STRING_SIZE_LIMIT) {
                configuration_map[MAX_STRING_SIZE_CMD_IDENTIFIER] = size;
            } else {
                JVM_LOG_WARNING(
                    "Invalid Maximum String Size value in command line arguments: %s. It will be ignored",
                    size
                );
            }
        } else if (identifier == DISABLE_GC_CMD_IDENTIFIER) {
            configuration_map[DISABLE_GC_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, true);
        } else if (identifier == JVM_PATH_CMD_IDENTIFIER) {
            godot::String path = value.strip_edges().trim_prefix("\"").trim_suffix("\"");
            if (!path.is_empty()) {
                configuration_map[JVM_PATH_CMD_IDENTIFIER] = path;
            } else {
                JVM_LOG_WARNING("Empty JVM path in command line arguments. It will be ignored");
            }
        } else if (identifier == JVM_ARGUMENTS_CMD_IDENTIFIER) {
            godot::Array arr;
            // Support both comma-separated and space-separated values.
            // Space separation requires quoting at shell level, e.g.:
            // --jvm-custom-args="-Xmx4g -Xms4g"
            for (godot::String jvm_arg : value.replace(",", " ").split(" ", false)) {
                godot::String stripped_jvm_arg = jvm_arg.strip_edges();
                if (!stripped_jvm_arg.is_empty()) { arr.append(stripped_jvm_arg); }
            }
            configuration_map[JVM_ARGUMENTS_CMD_IDENTIFIER] = arr;
        }
    }
    for (const auto& map_element : configuration_map) {
        JVM_DEV_VERBOSE("Value for commandline argument: %s -> %s", map_element.key, map_element.value);
    }
}

template<typename T>
void replace_json_value_by_cmd_value(
    const godot::HashMap<godot::String, godot::Variant>& map,
    T& json_value,
    const godot::String& cmd_key
) {
    if (map.has(cmd_key)) { json_value = godot::VariantCaster<T>::cast(map[cmd_key]); }
}

void JvmUserConfiguration::merge_with_command_line(
    JvmUserConfiguration& json_config,
    const godot::HashMap<godot::String, godot::Variant>& cmd_map
) {
    replace_json_value_by_cmd_value(cmd_map, json_config.use_native_image, USE_NATIVE_IMAGE_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_debug_port, DEBUG_PORT_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_debug_address, DEBUG_ADDRESS_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.wait_for_debugger, WAIT_FOR_DEBUGGER_CMD_IDENTIFIER);

    replace_json_value_by_cmd_value(cmd_map, json_config.use_debug, USE_DEBUG_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_jmx_port, JMX_PORT_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.max_string_size, MAX_STRING_SIZE_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.disable_gc, DISABLE_GC_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_args, JVM_ARGUMENTS_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_path, JVM_PATH_CMD_IDENTIFIER);
}

void JvmUserConfiguration::sanitize_and_log_configuration(JvmUserConfiguration& config) {
#ifdef ANDROID_ENABLED
    config.vm_type = jni::JvmType::ART;
#elif defined(IOS_ENABLED)
    config.vm_type = jni::JvmType::GRAAL_NATIVE_IMAGE;
#else
    config.vm_type = config.use_native_image ? jni::JvmType::GRAAL_NATIVE_IMAGE : jni::JvmType::JVM;
#endif

    if (config.max_string_size != -1) {
        JVM_LOG_WARNING(
            "The max string size was changed to %s which can modify the size of the shared buffer."
            "Be aware that it might impact performance and memory usage. Set to -1 if you want the default size.",
            config.max_string_size
        );
    }

    if (!config.jvm_path.is_empty()) {
        if (config.vm_type != jni::JvmType::JVM) {
            JVM_LOG_WARNING("Ignoring --jvm-path because this runtime does not use a desktop JVM: %s", config.jvm_path);
            config.jvm_path = godot::String();
        } else {
            JVM_LOG_WARNING(
                "A JVM path is forced through the command line. The embedded JRE and the environment are ignored: %s",
                config.jvm_path
            );
        }
    }
}
