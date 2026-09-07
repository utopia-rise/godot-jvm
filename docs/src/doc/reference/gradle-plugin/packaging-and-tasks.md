---
description: The godot { } packaging and coroutine switches, plus fastBuild and the registrar threshold for incremental builds.
---

# Packaging options

These options control library packaging, optional coroutine support, and incremental builds.

## Packaging and optional features

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
- leaves a regular library JAR as the final artifact

Unlike `disableGdj`, `isLibrary` turns off the whole local runtime-registration pipeline rather than only the `.gdj` part of it.

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

## Incremental builds

Use these tasks and settings to control incremental builds.

The [`fastBuild`](tasks.md#fastbuild) task reuses the previous registration artifacts.

### `registrarIncrementalFullBuildThreshold`

Maximum number of changed classes handled by incremental registrar generation. Above this threshold, the plugin regenerates all registrars to avoid the overhead of incremental analysis.

Default:

- `32`

Example:

```kotlin
godot {
    registrarIncrementalFullBuildThreshold.set(64)
}
```

Registrar generation also falls back to a full run when there is no previous manifest, when the previous outputs are incomplete, or when the runtime classpath changed.
