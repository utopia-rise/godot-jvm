---
description: Every Godot-JVM runtime flag, its JSON key in godot_jvm_configuration.json, its default and accepted values, from VM type to debugging and custom JVM arguments.
---

# Runtime configuration and JVM arguments

Configure the runtime with launch arguments or `godot_jvm_configuration.json` in the project root. The table lists the corresponding names, defaults, and accepted values.

The binding reads the file from `res://godot_jvm_configuration.json` and writes a fresh one with the current defaults
if it is missing or out of date.

Command-line arguments override values in the JSON file.

The boolean flags (`--jvm-use-debug`, `--jvm-wait-for-debugger`, `--jvm-disable-gc`) can be passed bare, in which
case they mean `true`. Pass `=true` or `=false` explicitly to be unambiguous. In the JSON file they are regular
JSON booleans.

| Command-line            | JSON key | Default value | Description                                                                                                                                                                                                                                                          | Example                                                                                                 |
|-------------------------|---------------------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| --jvm-vm-type           | vm_type             | auto          | Select `auto`, `jvm`, `graal_native_image`, or `art`; `auto` uses `jvm` on desktop, while Android always uses `art` and iOS always uses `graal_native_image`. On other platforms, requesting `art` falls back to `jvm`.                                                                    | `--jvm-vm-type=jvm` or `"vm_type": "jvm"`                                                                    |
| --jvm-use-debug         | use_debug           | false         | Starts the JVM debug server.                                                                                                                                                                                                                   | `--jvm-use-debug` or `"use_debug": true`                                                                   |
| --jvm-debug-port        | debug_port          | 5005          | Port for remote debugger connections. Accepted values are `0` to `65535`.                           | `--jvm-debug-port=5005` or `"debug_port": 5005`                                                            |
| --jvm-debug-address     | debug_address       | `*` (any address) | Address used for debugger connections. On the command line only a valid IP address is accepted; in the JSON file you can also use `*` to accept any address                                                                                             | `--jvm-debug-address=127.0.0.1` or `"debug_address": "*"`                                            |
| --jvm-wait-for-debugger | wait_for_debugger   | true          | Waits for a remote debugger before running the game when debugging is enabled (`true` or `false`). Passing `--jvm-debug-port`, `--jvm-debug-address`, or `--jvm-wait-for-debugger` on the command line enables debugging implicitly.                                                                     | `--jvm-wait-for-debugger` or `"wait_for_debugger": true`                                                   |
| --jvm-jmx-port          | jmx_port            | -1 (disabled) | Port for JMX connections. Accepted values are `-1` to disable it, or `0` to `65535`.                                                                                                                                                | `--jvm-jmx-port=5006` or `"jmx_port": 5006`                                                                |
| --jvm-max-string-size   | max_string_size     | -1 (auto, 512 bytes) | Maximum inline string size in bytes; larger strings use JNI directly, and `-1` restores the 512-byte default. Increasing this value increases each thread's buffer size. | `--jvm-max-string-size=1024` or `"max_string_size": 1024`                                                    |
| --jvm-disable-gc        | disable_gc          | false         | Disables Godot-JVM's cleanup of collected wrappers. **This causes leaks of `RefCounted` and native types.**                                                                                                         | `--jvm-disable-gc` or `"disable_gc": true`                                                                 |
| --jvm-custom-args       | custom_jvm_args     |               | Additional JVM arguments, supplied as a quoted space-separated or comma-separated list on the command line. Invalid arguments can prevent startup; use the dedicated settings for debugging and JMX. | `--jvm-custom-args="-Xmx4g -Xms4g"` (quoted, space-separated), `--jvm-custom-args=-Xmx4g,-Xms4g` (comma-separated), or `"custom_jvm_args": ["-Xmx4g", "-Xms4g"]` |

!!! note "Embedded JRE modules"
    Remote debugging requires `jdk.jdwp.agent`; JMX requires `jdk.management.agent` in the embedded JRE.

## The configuration file

`godot_jvm_configuration.json` lives at the root of the project, at `res://godot_jvm_configuration.json`. A minimal file only needs the keys you want to override; a complete one looks like this:

```json
{
    "version": "2.0",
    "vm_type": "auto",
    "use_debug": false,
    "debug_port": 5005,
    "debug_address": "*",
    "wait_for_debugger": true,
    "jmx_port": -1,
    "max_string_size": -1,
    "disable_gc": false,
    "custom_jvm_args": []
}
```
