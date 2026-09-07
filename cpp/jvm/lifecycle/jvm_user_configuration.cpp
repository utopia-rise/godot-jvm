#include "jvm_user_configuration.h"

#include <classes/json.hpp>

bool JvmUserConfiguration::parse_configuration_json(const godot::String& json_string, JvmUserConfiguration& json_config) {
    bool is_invalid = false;
    godot::Ref<godot::JSON> json;
    json.instantiate();
    godot::Error error = json->parse(json_string);
    godot::Variant result = json->get_data();

    if (error != godot::OK || result.get_type() != godot::Variant::DICTIONARY) {
        JVM_ERR_FAIL_V_MSG(true, "Error parsing Godot-JVM configuration file! Falling back to default configuration");
    }

    godot::Dictionary json_dict = result;
    if (json_dict.has(VM_TYPE_JSON_IDENTIFIER)) {
        godot::String value = json_dict[VM_TYPE_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", VM_TYPE_JSON_IDENTIFIER, value);
        if (value == AUTO_STRING) {
            json_config.vm_type = jni::JvmType::NONE;
        } else if (value == JVM_STRING) {
            json_config.vm_type = jni::JvmType::JVM;
        } else if (value == GRAAL_NATIVE_IMAGE_STRING) {
            json_config.vm_type = jni::JvmType::GRAAL_NATIVE_IMAGE;
        } else if (value == ART_STRING) {
            json_config.vm_type = jni::JvmType::ART;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Wrong JVM type in configuration file: %s. It will be ignored", value);
        }
        json_dict.erase(VM_TYPE_JSON_IDENTIFIER);
    }
    if (json_dict.has(USE_DEBUG_JSON_IDENTIFIER)) {
        godot::String boolean = json_dict[USE_DEBUG_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", USE_DEBUG_JSON_IDENTIFIER, boolean);
        if (boolean == TRUE_STRING) {
            json_config.use_debug = true;
        } else if (boolean == FALSE_STRING) {
            json_config.use_debug = false;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid Use Debug value in configuration file: %s. It will be ignored", boolean);
        }
        json_dict.erase(USE_DEBUG_JSON_IDENTIFIER);
    }
    if (json_dict.has(DEBUG_PORT_JSON_IDENTIFIER)) {
        int32_t port = json_dict[DEBUG_PORT_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", DEBUG_PORT_JSON_IDENTIFIER, port);
        if (port >= 0 && port <= 65535) {
            json_config.jvm_debug_port = port;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid JVM port value in configuration file: %s. It will be ignored", port);
        }
        json_dict.erase(DEBUG_PORT_JSON_IDENTIFIER);
    }
    if (json_dict.has(DEBUG_ADDRESS_JSON_IDENTIFIER)) {
        godot::String address = json_dict[DEBUG_ADDRESS_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", DEBUG_ADDRESS_JSON_IDENTIFIER, address);
        if (address.is_valid_ip_address() || address == "*") {
            json_config.jvm_debug_address = address;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid JVM address value in configuration file: %s. It will be ignored", address);
        }
        json_dict.erase(DEBUG_ADDRESS_JSON_IDENTIFIER);
    }
    if (json_dict.has(WAIT_FOR_DEBUGGER_JSON_IDENTIFIER)) {
        godot::String boolean = json_dict[WAIT_FOR_DEBUGGER_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", WAIT_FOR_DEBUGGER_JSON_IDENTIFIER, boolean);
        if (boolean == TRUE_STRING) {
            json_config.wait_for_debugger = true;
        } else if (boolean == FALSE_STRING) {
            json_config.wait_for_debugger = false;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid Waiting for Debugger value in configuration file: %s. It will be ignored", boolean);
        }
        json_dict.erase(WAIT_FOR_DEBUGGER_JSON_IDENTIFIER);
    }
    if (json_dict.has(JMX_PORT_JSON_IDENTIFIER)) {
        int32_t port = json_dict[JMX_PORT_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", JMX_PORT_JSON_IDENTIFIER, port);
        if (port >= -1 && port <= 65535) {
            json_config.jvm_jmx_port = port;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid JMX port value in configuration file: %s. It will be ignored", port);
        }
        json_dict.erase(JMX_PORT_JSON_IDENTIFIER);
    }
    if (json_dict.has(MAX_STRING_SIZE_JSON_IDENTIFIER)) {
        int32_t size = json_dict[MAX_STRING_SIZE_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", MAX_STRING_SIZE_JSON_IDENTIFIER, size);
        if (size >= -1) {
            json_config.max_string_size = size;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid Maximum String Size value in configuration file: %s. It will be ignored", size);
        }
        json_dict.erase(MAX_STRING_SIZE_JSON_IDENTIFIER);
    }
    if (json_dict.has(DISABLE_GC_JSON_IDENTIFIER)) {
        godot::String boolean = json_dict[DISABLE_GC_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", DISABLE_GC_JSON_IDENTIFIER, boolean);
        if (boolean == TRUE_STRING) {
            json_config.disable_gc = true;
        } else if (boolean == FALSE_STRING) {
            json_config.disable_gc = false;
        } else {
            is_invalid = true;
            JVM_LOG_WARNING("Invalid Disable GC value in configuration file: %s. It will be ignored", boolean);
        }
        json_dict.erase(DISABLE_GC_JSON_IDENTIFIER);
    }
    if (json_dict.has(JVM_ARGUMENTS_JSON_IDENTIFIER)) {
        json_config.jvm_args = json_dict[JVM_ARGUMENTS_JSON_IDENTIFIER];
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", JVM_ARGUMENTS_JSON_IDENTIFIER, json_config.jvm_args);
        json_dict.erase(JVM_ARGUMENTS_JSON_IDENTIFIER);
    }

    if (json_dict.has(VERSION_JSON_IDENTIFIER)) {
        godot::String version {json_dict[VERSION_JSON_IDENTIFIER]};
        JVM_DEV_VERBOSE("Value for json argument: %s -> %s", VERSION_JSON_IDENTIFIER, version);
        if (version != JSON_ARGUMENT_VERSION) {
            JVM_LOG_WARNING("Your existing jvm json configuration file was made for an older version of this binding. A "
                        "new will one will be created. Your previous settings should remain if compatible.");
            is_invalid = true;
        }
        json_dict.erase(VERSION_JSON_IDENTIFIER);
    } else {
        JVM_LOG_WARNING("No version found in the configuration file");
        is_invalid = true;
    }

    if (!json_dict.is_empty()) {
        godot::Array keys = json_dict.keys();
        for (int i = 0; i < keys.size(); i++) {
            godot::String key = keys[i];
            godot::String value = json_dict[key];
            JVM_LOG_WARNING("Invalid json configuration argument name: %s", key);
        }
        is_invalid = true;
    }

    return is_invalid;
}

godot::String JvmUserConfiguration::export_configuration_to_json(const JvmUserConfiguration& configuration) {
    // This function assumes all values are valid.
    godot::Dictionary json;

    godot::String vm_type_value;
    switch (configuration.vm_type) {
        case jni::JvmType::NONE:
            vm_type_value = AUTO_STRING;
            break;
        case jni::JvmType::JVM:
            vm_type_value = JVM_STRING;
            break;
        case jni::JvmType::GRAAL_NATIVE_IMAGE:
            vm_type_value = GRAAL_NATIVE_IMAGE_STRING;
            break;
        case jni::JvmType::ART:
            vm_type_value = ART_STRING;
            break;
    }
    json[VERSION_JSON_IDENTIFIER] = JSON_ARGUMENT_VERSION;
    json[VM_TYPE_JSON_IDENTIFIER] = vm_type_value;

    json[USE_DEBUG_JSON_IDENTIFIER] = configuration.use_debug;
    json[DEBUG_PORT_JSON_IDENTIFIER] = configuration.jvm_debug_port;
    json[DEBUG_ADDRESS_JSON_IDENTIFIER] = configuration.jvm_debug_address;
    json[WAIT_FOR_DEBUGGER_JSON_IDENTIFIER] = configuration.wait_for_debugger;

    json[JMX_PORT_JSON_IDENTIFIER] = configuration.jvm_jmx_port;

    json[MAX_STRING_SIZE_JSON_IDENTIFIER] = configuration.max_string_size;

    json[DISABLE_GC_JSON_IDENTIFIER] = configuration.disable_gc;

    json[JVM_ARGUMENTS_JSON_IDENTIFIER] = configuration.jvm_args;

    return godot::JSON::stringify(json, "    ", true, false);
}

godot::Error split_argument(const godot::String& cmd_arg, godot::String& identifier, godot::String& value) {
    int split_position = cmd_arg.find("=");
    if (split_position == -1) {
        identifier = cmd_arg;
        value = "";
        return godot::OK;
    }

    identifier = cmd_arg.substr(0, split_position);
    value = cmd_arg.substr(split_position + 1, cmd_arg.length());
    return godot::OK;
}

bool get_cmd_bool_or_default(const godot::String& value, bool default_if_empty) {
    if (value.is_empty()) {
        return default_if_empty;
    } else if (value == TRUE_STRING) {
        return true;
    } else if (value == FALSE_STRING) {
        return false;
    } else {
        JVM_ERR_FAIL_V_MSG(false, "Command line argument can't be parsed as a boolean value: %s. It will be treated as false", value);
    }
}

void JvmUserConfiguration::parse_command_line(const godot::PackedStringArray& args, godot::HashMap<godot::String, godot::Variant>& configuration_map) {
    // We use a HashMap instead of JvmUserConfiguration so we can still make the difference between a
    // JvmUserConfiguration default value and the absence of the matching command line argument. Knowing this is
    // essential when merging with the json configuration later.

    // Keep in sync with https://godot-jvm.dev/en/latest/advanced/commandline-args/
    for (const auto& arg : args) {
        godot::String identifier;
        godot::String value;
        if (split_argument(arg, identifier, value) != godot::Error::OK) { continue; }

        if (identifier == VM_TYPE_CMD_IDENTIFIER) {
            if (value == AUTO_STRING) {
                configuration_map[VM_TYPE_CMD_IDENTIFIER] = jni::JvmType::NONE;
            } else if (value == JVM_STRING) {
                configuration_map[VM_TYPE_CMD_IDENTIFIER] = jni::JvmType::JVM;
            } else if (value == GRAAL_NATIVE_IMAGE_STRING) {
                configuration_map[VM_TYPE_CMD_IDENTIFIER] = jni::JvmType::GRAAL_NATIVE_IMAGE;
            } else if (value == ART_STRING) {
                configuration_map[VM_TYPE_CMD_IDENTIFIER] = jni::JvmType::ART;
            } else {
                JVM_LOG_WARNING("Wrong JVM type in command line arguments: %s. It will be ignored", value);
            }
        } else if (identifier == USE_DEBUG_CMD_IDENTIFIER) {
            configuration_map[USE_DEBUG_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, TRUE_STRING);
        } else if (identifier == DEBUG_PORT_CMD_IDENTIFIER) {
            int64_t port = -1;
            if (value.is_valid_int()) { port = value.to_int(); }
            if (port >= 0 && port <= 65535) {
                configuration_map[DEBUG_PORT_CMD_IDENTIFIER] = port;
            } else {
                JVM_LOG_WARNING("Invalid JVM port value in command line arguments: %s. It will be ignored", port);
            }
        } else if (identifier == DEBUG_ADDRESS_CMD_IDENTIFIER) {
            if (value.is_valid_ip_address()) {
                configuration_map[DEBUG_ADDRESS_CMD_IDENTIFIER] = value;
            } else {
                JVM_LOG_WARNING("Invalid JVM address value command line arguments: %s. It will be ignored", value);
            }
        } else if (identifier == WAIT_FOR_DEBUGGER_CMD_IDENTIFIER) {
            configuration_map[WAIT_FOR_DEBUGGER_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, TRUE_STRING);
        } else if (identifier == JMX_PORT_CMD_IDENTIFIER) {
            int64_t port = -1;
            if (value.is_valid_int()) { port = value.to_int(); }
            if (port >= 0 && port <= 65535) {
                configuration_map[JMX_PORT_CMD_IDENTIFIER] = port;
            } else {
                JVM_LOG_WARNING("Invalid JMX port value command line arguments: %s. It will be ignored", port);
            }
        } else if (identifier == MAX_STRING_SIZE_CMD_IDENTIFIER) {
            int64_t size = -1;
            if (value.is_valid_int()) { size = value.to_int(); }
            if (value.is_valid_int() && size >= -1) {
                configuration_map[MAX_STRING_SIZE_CMD_IDENTIFIER] = size;
            } else {
                JVM_LOG_WARNING("Invalid Maximum String Size value in configuration file: %s. It will be ignored", size);
            }
        } else if (identifier == DISABLE_GC_CMD_IDENTIFIER) {
            configuration_map[DISABLE_GC_CMD_IDENTIFIER] = get_cmd_bool_or_default(value, TRUE_STRING);
        } else if (identifier == JVM_PATH_CMD_IDENTIFIER) {
            godot::String path = value.strip_edges().trim_prefix("\"").trim_suffix("\"");
            if (!path.is_empty()) {
                configuration_map[JVM_PATH_CMD_IDENTIFIER] = path;
            } else {
                JVM_LOG_WARNING("Empty JVM path in command line arguments. It will be ignored");
            }
        } else if (identifier == JVM_ARGUMENTS_CMD_IDENTIFIER) {
            godot::Array arr {};
            // Support both comma-separated and space-separated values.
            // Space separation requires quoting at shell level, e.g.:
            // --jvm-custom-args="-Xmx4g -Xms4g"
            for (godot::String jvm_arg : value.replace(",", " ").split(" ", false)) {
                godot::String stripped_jvm_arg = jvm_arg.strip_edges();
                if (!stripped_jvm_arg.is_empty()) {
                    arr.append(stripped_jvm_arg);
                }
            }
            configuration_map[JVM_ARGUMENTS_CMD_IDENTIFIER] = arr;
        }

        for (const auto& map_element : configuration_map) {
            JVM_DEV_VERBOSE("Value for commandline argument: %s -> %s", map_element.key, map_element.value);
        }
    }
}

template<typename T>
void replace_json_value_by_cmd_value(const godot::HashMap<godot::String, godot::Variant>& map, T& json_value, const godot::String& cmd_key) {
    if (map.has(cmd_key)) { json_value = godot::VariantCaster<T>::cast(map[cmd_key]); }
}

void JvmUserConfiguration::merge_with_command_line(JvmUserConfiguration& json_config, const godot::HashMap<godot::String, godot::Variant>& cmd_map) {
    replace_json_value_by_cmd_value(cmd_map, json_config.vm_type, VM_TYPE_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_debug_port, DEBUG_PORT_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_debug_address, DEBUG_ADDRESS_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.wait_for_debugger, WAIT_FOR_DEBUGGER_CMD_IDENTIFIER);

    if (cmd_map.has(DEBUG_PORT_CMD_IDENTIFIER) || cmd_map.has(DEBUG_ADDRESS_CMD_IDENTIFIER) || cmd_map.has(WAIT_FOR_DEBUGGER_CMD_IDENTIFIER)) {
        // Set use debug to true if any of the 3 previous arguments are used.
        // Will be overridden if the actual argument is used.
        json_config.use_debug = true;
    }
    replace_json_value_by_cmd_value(cmd_map, json_config.use_debug, USE_DEBUG_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_jmx_port, JMX_PORT_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.max_string_size, MAX_STRING_SIZE_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.disable_gc, DISABLE_GC_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_args, JVM_ARGUMENTS_CMD_IDENTIFIER);
    replace_json_value_by_cmd_value(cmd_map, json_config.jvm_path, JVM_PATH_CMD_IDENTIFIER);
}

void JvmUserConfiguration::sanitize_and_log_configuration(JvmUserConfiguration& config) {
    if (config.max_string_size != -1) {
        JVM_LOG_WARNING(
          "The max string size was changed to %s which can modify the size of the shared buffer."
          "Be aware that it might impact performance and memory usage. Set to -1 if you want the default size.",
          config.max_string_size
        );
    }

    if (!config.jvm_path.is_empty()) {
        JVM_LOG_WARNING("A JVM path is forced through the command line. The embedded JRE and the environment are ignored: %s", config.jvm_path);
    }

    if (!config.jvm_args.is_empty()) {
        JVM_LOG_WARNING("Custom JVM arguments are provided, they can causes the JVM to not properly start if invalid: %s", config.jvm_args);
    }

#ifdef ANDROID_ENABLED
    if (config.vm_type == jni::JvmType::NONE) {
        config.vm_type = jni::JvmType::ART;
        JVM_LOG_INFO("You are running on Android. VM automatically set to ART");
    } else if (config.vm_type != jni::JvmType::ART) {
        config.vm_type = jni::JvmType::ART;
        JVM_LOG_WARNING("You are running on Android. Switching VM to ART");
    }
#elif IOS_ENABLED
    if (config.vm_type == jni::JvmType::NONE) {
        config.vm_type = jni::JvmType::GRAAL_NATIVE_IMAGE;
        JVM_LOG_INFO("You are running on iOS. VM automatically set to Graal native_image");
    } else if (config.vm_type != jni::JvmType::GRAAL_NATIVE_IMAGE) {
        config.vm_type = jni::JvmType::GRAAL_NATIVE_IMAGE;
        JVM_LOG_WARNING("You are running on iOS. Switching VM to Graal native_image");
    }
#else
    if (config.vm_type == jni::JvmType::NONE) {
        config.vm_type = jni::JvmType::JVM;
        JVM_LOG_INFO("You are running on desktop. VM automatically set to JVM");
    } else if (config.vm_type == jni::JvmType::ART) {
        config.vm_type = jni::JvmType::JVM;
        JVM_LOG_WARNING("You can't run ART on desktop. Switching VM to JVM");
    }
#endif
    else {
        switch (config.vm_type) {
            case jni::JvmType::JVM:
                JVM_LOG_INFO("VM set to %s", JVM_STRING);
                break;
            case jni::JvmType::GRAAL_NATIVE_IMAGE:
                JVM_LOG_INFO("VM set to %s", GRAAL_NATIVE_IMAGE_STRING);
                break;
            case jni::JvmType::ART:
                JVM_LOG_INFO("VM set to %s", ART_STRING);
                break;
            case jni::JvmType::NONE:
                // Should never happen.
                break;
        }
    }
}
