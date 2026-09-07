---
description: godot-library, godot-bootstrap, main.jar and the GraalVM usercode image, what each one contains, who depends on it and when it is used.
---

# The three build artifacts

This document describes what the individual artifacts are for and how they are used.

## godot-library

### Overview

The `godot-library` contains the Godot APIs as Kotlin classes as well as registration code.
It is automatically added as a dependency to your code by the `godot-gradle-plugin`.
Hence, it is deployed to `mavenCentral`. It is also used as a dependency by `godot-bootstrap` and
thus present in the `godot-bootstrap.jar` which gets shipped alongside the engine.

### Usage

The `godot-library` is primarily used implicitly. You do not add it manually, instead, the `godot-gradle-plugin`
performs this task. Meanwhile, the `godot-bootstrap.jar` also utilizes it for initial loading and editor usage.
It's crucial to note that during runtime, only the version added to your code via the `godot-gradle-plugin` is used.
The version within the `godot-bootstrap` is exclusively for the editor.

## godot-bootstrap

### Overview

The `godot-bootstrap` is a "shadow JAR" (also known as [fat JAR](https://jenkov.com/tutorials/maven/maven-build-fat-jar.html))
which contains the `godot-library`, runtime code to reload usercode in the editor after rebuilds,
and every dependency you declared, recursively. `packageBootstrapJarTask` builds it from the
project's runtime classpath configuration, alongside the plugin's own `bootstrap` configuration.

### Usage

The `godot-bootstrap` is shipped alongside the engine for editor use and is bundled together with the game executable
during export. You never use it directly, and it is not added as a dependency anywhere.

## main

### Overview

The `main.jar` is built when you build your code. It is a shadow JAR containing your compiled code,
the generated registrar, and dependencies declared with `godotMain`. Ordinary dependencies are
instead bundled into `godot-bootstrap.jar`.

### Usage

This JAR is bundled together with the game executable during export and executed through the `godot-bootstrap` during
runtime. It is nowhere else used.

## Dependency placement

By default, dependencies declared with `implementation` are merged into `godot-bootstrap.jar`.
Use `godotMain` for a dependency that must be loaded with user code and recreated when `main.jar`
reloads:

```kotlin
dependencies {
    godotMain("org.eclipse.serializer:serializer:4.0.1")
}
```

Use `godotSingle` when a dependency must remain an intact JAR, such as a signed JAR. The plugin
copies its resolved JARs to `res://jvm/external/` and adds them to `main.jar`'s class path:

```kotlin
dependencies {
    godotSingle("org.bouncycastle:bcprov-jdk18on:1.79")
}
```

Do not declare the same dependency in more than one of `implementation`, `godotMain`, or
`godotSingle`.

## usercode

### Overview

The `usercode` artifact is a shared library which is only used on GraalVM native image builds. It contains all code from
the `main.jar` and the `godot-bootstrap.jar`.

### Usage

It replaces the `godot-bootstrap.jar` and the `main.jar` when the game is exported. It is only used when configured
either as a command line argument or through the configuration file (see [GraalVM documentation](../../build/export/graalvm-native-image.md) for more information).
While it is used (either in game or editor) no usercode can be reloaded.
