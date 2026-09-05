---
description: Godot-JVM's current version, minimum supported Godot and Kotlin versions, and the platforms the binding currently supports.
---

# Compatibility and versions

## Versioning

Godot-JVM uses semantic versioning independently of Godot. Each release specifies the minimum Godot version it supports.

Version: `1.0.0`

Minimum Godot Version: `4.7.2`

Godot-JVM 1.0.0 requires at least Kotlin `2.3.20`, Java `17`, and Scala `3.0.0`.

Explicit Kotlin JVM plugin versions below `2.3.20` are rejected. If you also override `kotlinVersion`, it must match the applied plugin version.

## Supported platforms

Supported Godot-JVM targets:

- Windows X64
- Linux X64
- macOS x64 / arm64
- Android (arm64v8, x86_64)
- iOS (arm64v8)
