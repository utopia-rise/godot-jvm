---
description: What the Godot-JVM IntelliJ IDEA plugin adds, how to install it from the Marketplace, and which setting must match your Gradle build.
---

# IntelliJ IDEA plugin

IntelliJ IDEA is the supported IDE for Godot-JVM development. Other editors can edit the source and run Gradle, but do not receive the same dedicated integration. The built-in Godot script editor is not supported for JVM code.

The [Godot-JVM plugin](https://plugins.jetbrains.com/plugin/16505-godot-jvm) adds registration inspections, code helpers, and a project wizard.

## Install and create a project

After installing the plugin and restarting the IDE, find the wizard under **New Project > Godot-JVM**.

## Keeping IDE and Gradle settings in sync

The plugin's inspections and highlighting need to agree with how your Gradle build registers classes. If you set a
non-default `annotationProcessingMode` in `build.gradle.kts`, set the
same mode in the IDE under **Settings > Godot-JVM > Annotation processing mode**. Gradle controls the actual build;
the IDE setting keeps inspections and highlighting accurate.
