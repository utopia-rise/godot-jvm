---
description: Every runtime flag and JSON key, defaults, precedence, accepted values, and launch examples.
---

# Runtime settings and JVM arguments

Configure the runtime with launch arguments or `godot_jvm_configuration.json` in the project root. The table lists the corresponding names, defaults, and accepted values.

Tools-enabled builds validate `res://godot_jvm_configuration.json` and rewrite it if missing, malformed, or out of date,
preserving compatible valid values. The editor applies command-line settings to its own defaults, ignoring
the JSON values. It can use a native image when explicitly requested on the command line, but scripts cannot reload.

File creation and repair also apply when running a game directly with an editor binary, without editor mode.
Export templates never rewrite the file.

Unexported games use this file. Exports inherit it at export time, apply the preset's enabled overrides,
and package the resulting configuration. The source file is not modified by exporting.

Command-line arguments override values in the JSON file. `--jvm-path` is command-line only; it has no JSON counterpart.

The boolean flags (`--jvm-use-native-image`, `--jvm-use-debug`, `--jvm-wait-for-debugger`, `--jvm-disable-gc`) can be passed bare, in which
case they mean `true`. Pass `=true` or `=false` explicitly to be unambiguous. In the JSON file they are regular
JSON booleans.

## Settings index

| Argument | JSON key | Default | Platforms |
|---|---|---|---|
| [`--jvm-use-native-image`](#jvm-use-native-image) | `useNativeImage` | false | Desktop only |
| [`--jvm-use-debug`](#jvm-use-debug) | `use_debug` | false | Desktop only |
| [`--jvm-debug-port`](#jvm-debug-port) | `debug_port` | 5005 | Desktop only |
| [`--jvm-debug-address`](#jvm-debug-address) | `debug_address` | `*` (any address) | Desktop only |
| [`--jvm-wait-for-debugger`](#jvm-wait-for-debugger) | `wait_for_debugger` | true | Desktop only |
| [`--jvm-jmx-port`](#jvm-jmx-port) | `jmx_port` | -1 (disabled) | Desktop only |
| [`--jvm-max-string-size`](#jvm-max-string-size) | `max_string_size` | -1 (auto, 512 bytes) | ALL |
| [`--jvm-disable-gc`](#jvm-disable-gc) | `disable_gc` | false | ALL |
| [`--jvm-path`](#jvm-path) | Command line only | | Desktop JVM only |
| [`--jvm-custom-args`](#jvm-custom-args) | `custom_jvm_args` | | Desktop & iOS |

## `--jvm-use-native-image` { #jvm-use-native-image }

JSON key: `useNativeImage`. Default: false.

Desktop games use the JVM when false and a GraalVM native image when true. The editor can select a native image
through `--jvm-use-native-image`, at the cost of script reloading.
Android always uses ART and iOS always uses a native image; this flag has no effect on either mobile platform.
Version 3 removes `vm_type` and `--jvm-vm-type`.

Example: `--jvm-use-native-image` or `"useNativeImage": true`

## `--jvm-use-debug` { #jvm-use-debug }

JSON key: `use_debug`. Default: false.

Starts the JVM debug server in desktop JVM runs using a `DEBUG_ENABLED` extension build.
The editor accepts these settings through the command line only. The four debugger settings have no effect
in native-image mode, Android, or iOS.

Example: `--jvm-use-debug` or `"use_debug": true`

## `--jvm-debug-port` { #jvm-debug-port }

JSON key: `debug_port`. Default: 5005.

Port for remote debugger connections. Accepted values are `0` to `65535`.

Example: `--jvm-debug-port=5005` or `"debug_port": 5005`

## `--jvm-debug-address` { #jvm-debug-address }

JSON key: `debug_address`. Default: `*` (any address).

Address used for debugger connections. Accepts a valid IP address or `*` to listen on every address.

Example: `--jvm-debug-address=127.0.0.1` or `"debug_address": "*"`

## `--jvm-wait-for-debugger` { #jvm-wait-for-debugger }

JSON key: `wait_for_debugger`. Default: true.

Waits for a remote debugger before running when debugging is enabled (`true` or `false`). Port, address, and wait settings only configure the debugger; they never enable it. Enable debugging explicitly with `--jvm-use-debug` or `"use_debug": true` in the game's JSON. The default wait value has no effect while debugging is disabled.

Example: `--jvm-wait-for-debugger` or `"wait_for_debugger": true`

## `--jvm-jmx-port` { #jvm-jmx-port }

JSON key: `jmx_port`. Default: -1 (disabled).

Port for JMX connections in desktop JVM games. Accepted values are `-1` to disable it, or `0` to `65535`.
Unlike JDWP, this option also applies in release builds. The editor accepts it through the command line only. It has no effect in native-image mode,
Android, or iOS. The binding's native-image build does not enable a JMX server.

Example: `--jvm-jmx-port=5006` or `"jmx_port": 5006`

## `--jvm-max-string-size` { #jvm-max-string-size }

JSON key: `max_string_size`. Default: -1 (auto, 512 bytes).

Maximum inline string size in bytes, up to 65535; larger strings use JNI directly, and `-1` restores the 512-byte default. Increasing this value increases each thread's buffer size.

Example: `--jvm-max-string-size=1024` or `"max_string_size": 1024`

## `--jvm-disable-gc` { #jvm-disable-gc }

JSON key: `disable_gc`. Default: false.

Disables Godot-JVM's cleanup of collected wrappers. **This causes leaks of `RefCounted` and native types.**

Example: `--jvm-disable-gc` or `"disable_gc": true`

## `--jvm-path` { #jvm-path }

Path, absolute or relative to the working directory, to a JVM home directory or its dynamic library. It applies only to desktop JVM runs, where it overrides the embedded JRE, `JAVA_HOME`, and `PATH`; startup fails if the explicit path is unusable. It is ignored by native-image, Android, and iOS runs. Tooling such as the IntelliJ run configuration uses it to choose a JVM for one run, so there is deliberately no JSON setting.

Examples: `--jvm-path=/usr/lib/jvm/temurin-17` or `--jvm-path="C:/Program Files/Java/jdk-17/bin/server/jvm.dll"`.

## `--jvm-custom-args` { #jvm-custom-args }

JSON key: `custom_jvm_args`. Default: `[]`.

Additional runtime arguments, supplied as a quoted space-separated or comma-separated list on the command line.
They apply to desktop JVM runs and to native images on desktop and iOS, but are ignored by Android.
The editor accepts custom arguments through the command line only.
Native images accept only options supported by the compiled image, such as `-Xmx256m` and `-Dname=value`;
arbitrary HotSpot or native-image build-time flags do not apply. Invalid arguments can prevent startup.
Use the dedicated settings for desktop JVM debugging and JMX.

Example: `--jvm-custom-args="-Xmx4g -Xms4g"` (quoted, space-separated), `--jvm-custom-args=-Xmx4g,-Xms4g` (comma-separated), or `"custom_jvm_args": ["-Xmx4g", "-Xms4g"]`

!!! note "Embedded JRE modules"
    Remote debugging requires `jdk.jdwp.agent`; JMX requires `jdk.management.agent` in the embedded JRE.

## The configuration file

`godot_jvm_configuration.json` lives at the root of the project, at `res://godot_jvm_configuration.json`. The `version` key is mandatory; every other key is optional and falls back to its default when absent. The editor rewrites the file when `version` is missing or outdated, when a key is unknown, or when a value is invalid, keeping the valid values and dropping the rest. A complete file looks like this:

```json
{
    "version": "3.0",
    "useNativeImage": false,
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

## Exported runtime files

### Preset overrides

Under **Godot Jvm** in the export preset:

- **Override Debug** replaces the debugger and JMX settings together. Available on desktop except Graal-only exports.
  **Enable Debugger** defaults to false. Port, address, and **Wait for Debugger Attachment** appear only when
  enabled; waiting defaults to true so startup code can be debugged. JMX remains independently configurable.
- **Override Memory** replaces `max_string_size` and `disable_gc` together on every supported platform.
- **Override Custom Args** accepts space- or comma-separated arguments on desktop and iOS. Empty or whitespace-only
  inherits the JSON array; a nonempty value replaces the entire array. Android does not expose this field.

Disabled categories inherit the file. Enabled categories use their preset values, including defaults for fields
not explicitly changed. Desktop **JVM** and **Graal** presets force `useNativeImage` false and true respectively.
Only platform-relevant settings are packed into the exported JSON. The game's command-line arguments can still
override the packaged values.

An export with debug packs the debug variant from `res://jvm/debug/`, a release export packs the release variant
from `res://jvm/release/`, and never both:

- `jvm/debug/godot-bootstrap.jar` and `jvm/debug/usercode.jar`, or `jvm/release/game.jar` (on Android
  `godot-bootstrap-dex.jar` and `usercode-dex.jar`, or `game-dex.jar`)
- `jvm/<variant>/game.so`, `game.dll`, or `game.dylib` for native-image exports
- `jvm/<variant>/external/` with the intact JARs declared through `godotSingle`

A `template_debug` binary loads the debug variant and a `template_release` binary the release variant, so an
export always finds the variant it packed. The embedded JRE is not packed; the export places it next to the
executable (inside `PlugIns/` in a macOS bundle). On launch, Godot-JVM copies the files above from `res://` to
`user://jvm/<variant>/` when they are missing or their MD5 hashes differ; on Android it recopies them on every
launch. Include these extracted files in your uninstaller's cleanup.
