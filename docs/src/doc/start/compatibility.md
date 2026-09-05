---
description: Supported Godot, JDK and language versions, default toolchains, and target platforms.
---

# Compatibility and requirements

## Godot and JDK

| Requirement | Version |
|---|---|
| Godot | 4.7.2 or newer |
| JDK | 17 or newer |
| Default Java toolchain | 17 |

Use the Godot-JVM addon and Gradle plugin from the same release. Godot-JVM versions are independent of Godot versions. Each binding release specifies the engine version it supports; earlier Godot versions are not guaranteed compatible.

## Language versions

/// tab | Kotlin

Minimum Kotlin version: **2.3.20**. Default Kotlin plugin version: **2.3.20**. Lower versions are rejected. See [`kotlinVersion`](../reference/gradle-plugin/languages-and-toolchains.md#kotlinversion) for override rules.

///

/// tab | Java

Minimum Java toolchain: **17**. Default: **17**. See [`javaVersion`](../reference/gradle-plugin/languages-and-toolchains.md#javaversion) for configuration.

///

/// tab | Scala

Minimum Scala version: **3.0.0**. Default Scala runtime/compiler version: **3.6.3**. Lower major versions are rejected. See [`scalaVersion`](../reference/gradle-plugin/languages-and-toolchains.md#scalaversion) for configuration.

///

## Supported platforms

| Platform | Architectures |
|---|---|
| Windows | x86_64 |
| Linux | x86_64 |
| macOS | x86_64, arm64 |
| Android | arm64, x86_64 |
| iOS | arm64 |

Web and 32-bit targets are not supported. Desktop exports can use an embedded JRE or GraalVM native image. Android uses ART; iOS uses native-image compilation. See [export requirements](../build/export/index.md) for each target and [known limitations](../faq.md#known-limitations) for unsupported features.
