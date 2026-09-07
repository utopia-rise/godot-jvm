---
description: Godot-JVM's current version, minimum supported Godot and Kotlin versions, and the platforms the binding currently supports.
---

# Compatibility and versions

## Versioning

Godot-JVM uses semantic versioning. Godot is versioned independently as a minimum supported version.

Version: `1.0.0`

Minimum Godot Version: `4.7.2`

Godot-JVM uses its Gradle plugin to compile your project, then scans the resulting bytecode with ClassGraph to generate registration code. It does not use a Kotlin compiler plugin.

Godot-JVM 1.0.0 requires at least Kotlin `2.3.20`, Java `17`, and Scala `3.0.0`.

!!! info
    It is possible to use Godot-JVM with other Kotlin versions as well, but we do not provide guarantees for them. Find more information in the [`toolchain.kotlinVersion`](gradle-plugin/languages-and-toolchains.md#toolchainkotlinversion) section.

## Supported platforms

While Kotlin and Godot support a wide range of platforms, Godot-JVM currently supports the following:

- Windows X64
- Linux X64
- MacOS X64 / arm64
- Android (arm64v8, x86_64)
- iOS (arm64v8)
