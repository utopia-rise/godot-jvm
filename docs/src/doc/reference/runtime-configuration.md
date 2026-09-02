---
description: Every Godot-JVM runtime flag, its JSON key in godot_jvm_configuration.json, its default and accepted values, from VM type to debugging and custom JVM arguments.
---

# Runtime configuration and JVM arguments

The following arguments can be either used in the command line or the `godot_jvm_configuration.json` file at the root
of the project to customize the behaviour of the Godot-JVM binding.

The binding reads the file from `res://godot_jvm_configuration.json` and writes a fresh one with the current defaults
if it is missing or out of date.

!!! info
    Note that in case the same argument is used in both JSON and command-line, the command-line argument got the priority.

!!! tip
    The boolean flags (`--jvm-use-debug`, `--jvm-wait-for-debugger`, `--jvm-disable-gc`) can be passed bare, in which
    case they mean `true`. Pass `=true` or `=false` explicitly to be unambiguous. In the JSON file they are regular
    JSON booleans.

| Command-line            | Configuration  json | Default value | Description                                                                                                                                                                                                                                                          | Example                                                                                                 |
|-------------------------|---------------------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| --jvm-vm-type           | vm_type             | auto          | Defines the VM to run on. Possible values are `auto`, `jvm`, `graal_native_image` and `art`. When set to `graal_native_image` it uses Graal native image. `auto` resolves to `jvm` on desktop, `art` on Android and `graal_native_image` on iOS; on Android and iOS any other value is overridden.                                                                    | `--jvm-vm-type=jvm` or `"vm_type": "jvm"`                                                                    |
| --jvm-use-debug         | use_debug           | false         | Defines if the jvm debug server should be started.                                                                                                                                                                                                                   | `--jvm-use-debug` or `"use_debug": true`                                                                   |
| --jvm-debug-port        | debug_port          | 5005          | Defines the port to which you can attach a remote debugger. Accepted values are `0` to `65535`. **Note:** the module `jdk.jdwp.agent` is needed in the embedded JRE if you want to debug your application. If you need `jmx`, also the module `jdk.management.agent` is needed                           | `--jvm-debug-port=5005` or `"debug_port": 5005`                                                            |
| --jvm-debug-address     | debug_address       | `*` (any address) | Defines which addresses are allowed for debugging. On the command line only a valid IP address is accepted; in the JSON file you can also use `*` to accept any address                                                                                             | `--jvm-debug-address=127.0.0.1` or `"debug_address": "*"`                                            |
| --jvm-wait-for-debugger | wait_for_debugger   | true          | Accepted values: `true` or `false`. Defines if the jvm should suspend execution until a remote debugger is attached. Only effective when debugging is enabled; passing `--jvm-debug-port`, `--jvm-debug-address` or `--jvm-wait-for-debugger` on the command line enables it implicitly                                                                     | `--jvm-wait-for-debugger` or `"wait_for_debugger": true`                                                   |
| --jvm-jmx-port          | jmx_port            | -1 (disabled) | Defines the jmx port. Accepted values are `-1` to disable it, or `0` to `65535`. **Note:** the module `jdk.management.agent` is needed in the embedded JRE to be able to use jmx                                                                                                                                                | `--jvm-jmx-port=5006` or `"jmx_port": 5006`                                                                |
| --jvm-max-string-size   | max_string_size     | -1 (auto, 512 bytes) | Maximum size of strings sent through the buffer. When above that value, strings are sent with a slower JNI Call. A bigger size means a bigger buffer. Increase if you need a lot of long strings and don't mind using more memory. One buffer exists for each thread. Set it back to `-1` to restore the built-in default of 512 | `--jvm-max-string-size=1024` or `"max_string_size": 1024`                                                    |
| --jvm-disable-gc        | disable_gc          | false         | Disables our GC. **Caution:** If you disable our GC you **will** have memory leaks as all `RefCounted` types and Native Types are not Garbage collected anymore                                                                                                         | `--jvm-disable-gc` or `"disable_gc": true`                                                                 |
| --jvm-custom-args       | custom_jvm_args     |               | Allows to set your own arguments for the JVM, make sure they are valid if you don't want the JVM not starting properly. Avoid overlapping with others arguments if you want to set debug or jmx. For command line usage, pass a quoted space-separated list or a comma-separated list. | `--jvm-custom-args="-Xmx4g -Xms4g"` (quoted, space-separated), `--jvm-custom-args=-Xmx4g,-Xms4g` (comma-separated), or `"custom_jvm_args": ["-Xmx4g", "-Xms4g"]` |

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

`auto` resolves to `jvm` on desktop, `art` on Android, and `graal_native_image` on iOS. `art` is only meaningful on Android; requesting it on any other platform falls back to `jvm`.
