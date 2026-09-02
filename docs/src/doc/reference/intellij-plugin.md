---
description: What the Godot-JVM IntelliJ IDEA plugin adds, how to install it from the Marketplace, and which setting must match your Gradle build.
---

# IntelliJ IDEA plugin

There is currently no plan to support the built-in Godot editor for writing code; using [IntelliJ IDEA](https://jetbrains.com/idea) is strongly recommended (the community edition is free). Editors such as VSCode can be used, however, we only provide first class support for IntelliJ IDEA. You can install it via the [JetBrains Toolbox](https://www.jetbrains.com/toolbox-app/) app.

We also recommend installing our [IntelliJ IDEA plugin](https://plugins.jetbrains.com/plugin/16505-godot-jvm) as it provides you with a lot of useful checks and helpers to detect errors during development, and a project wizard that creates a whole Godot-JVM project in one action.

## Install and create a project

The **Start here** track owns the installation and project-wizard steps. Follow [Create a project](../start/create-a-project.md) to install the plugin and create a Godot-JVM project from IntelliJ's **New Project** wizard.

## Keeping IDE and Gradle settings in sync

The plugin's inspections and highlighting need to agree with how your Gradle build registers classes. If you set a
non-default [`annotationProcessingMode`](gradle-plugin/registration.md) in `build.gradle.kts`, set the
same mode in the IDE under **Settings | Godot-JVM | Annotation processing mode**. Gradle controls the actual build;
the IDE setting keeps inspections and highlighting accurate.
