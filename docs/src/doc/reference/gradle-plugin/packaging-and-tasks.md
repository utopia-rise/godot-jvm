---
description: The godot { } library-packaging switch, plus the fastBuild, registrar-threshold, and coroutine build tasks the plugin adds to Gradle.
---

# Packaging and build tasks

These settings affect how the project is packaged, which optional runtime helpers are added, and which higher-level tasks the plugin adds on top of the normal Gradle lifecycle.

## Packaging and optional runtime features

### `isLibrary`

Marks the project as a reusable Godot-JVM library instead of a runnable Godot project.

Default:

- `false`

Example:

```kotlin
godot {
    isLibrary.set(true)
}
```

When enabled, the plugin:

- keeps compile setup and Godot dependencies
- skips registrar scanning and `.gdj` generation for the local project
- skips the runnable-project packaging flow
- leaves a regular library jar as the final artifact

Unlike `disableGdj`, `isLibrary` turns off the whole local runtime-registration pipeline rather than only the `.gdj` part of it.

### `godotMain` and `godotSingle` dependencies

Dependencies declared with `implementation` are merged into `godot-bootstrap.jar`. Two additional
dependency configurations control different packaging requirements:

```kotlin
dependencies {
    godotMain("org.eclipse.serializer:serializer:4.0.1")
    godotSingle("org.bouncycastle:bcprov-jdk18on:1.79")
}
```

- `godotMain` merges the dependency into `main.jar`. Use it when the library must load user-code
  classes or be recreated with editor reloads.
- `godotSingle` preserves the dependency as a separate JAR in `res://jvm/external/`. Use it for
  signed JARs or libraries that cannot be merged safely.

Both configurations are available while compiling and testing, but neither is merged into
`godot-bootstrap.jar`.

## Build tasks

The plugin adds a few higher-level tasks on top of the normal Gradle lifecycle.

### `fastBuild`

Builds fresh desktop jars while reusing the last generated registrar artifacts instead of rescanning registered classes and regenerating `.gdj` files.

Use this when you only changed implementation details that do not affect registration structure, for example method bodies.

Example:

```shell
./gradlew fastBuild
```

Rules:

- requires a previous successful full build so the generated registrar jar already exists
- still recompiles the project and rebuilds `main.jar`
- should not be used after adding, removing, renaming, or structurally changing registered classes, functions, properties, or signals

### `registrarIncrementalFullBuildThreshold`

Maximum number of changed classes for which registrar generation still takes the incremental path. When more classes than this change between two successful builds, the plugin falls back to a full registrar generation run instead of paying the incremental prepass overhead.

Default:

- `32`

Example:

```kotlin
godot {
    registrarIncrementalFullBuildThreshold.set(64)
}
```

Registrar generation also falls back to a full run when there is no previous manifest, when the previous outputs are incomplete, or when the runtime classpath changed.

### `isGodotCoroutinesEnabled`

Adds the Godot coroutine library and Kotlin coroutines dependency.

Default:

- `false`

Example:

```kotlin
godot {
    isGodotCoroutinesEnabled.set(true)
}
```
