---
description: Custom Godot API generation, library packaging, fastBuild, registrar thresholds, and coroutine support in the Gradle plugin.
---

# Packaging and build tasks

These settings affect how the project is packaged, which optional runtime helpers are added, and which higher-level tasks the plugin adds on top of the normal Gradle lifecycle.

## Packaging and optional runtime features

### Custom Godot API bindings

By default, the plugin uses the Godot API library published with the selected Godot-JVM release. Enable custom API generation when the project uses a newer Godot build, additional engine modules, or GDExtensions that expose extra API classes:

```kotlin
godot {
    isCustomApiEnabled.set(true)
}
```

The plugin reads `api.json` from the root Gradle project by default. Set `apiJsonFile` when the file is elsewhere; it has no effect while `isCustomApiEnabled` is `false`:

```kotlin
godot {
    isCustomApiEnabled.set(true)
    apiJsonFile.set(file("godot-api/custom-api.json"))
}
```

When enabled, the plugin generates and compiles a local binding jar, compiles user code against it, and adds it to `godot-bootstrap.jar` instead of the published API library. The maintained core and runtime libraries remain published dependencies.

Custom generation only produces the API-layer classes. The maintained core types and helpers, including `Object`, `RefCounted`, signals, callables, connectors, and coroutine support, remain the published versions. `generateCustomGodotApi`, its compilation, and `customGodotApiJar` use declared Gradle inputs and outputs. An unchanged `api.json` is therefore up to date and can be restored from the Gradle build cache. `packageBootstrapJar` also remains up to date while its binding jar and other inputs are unchanged.

This consumer task is separate from the API generator plugin's existing `generateAPI` task used by Godot-JVM maintainers to regenerate the published libraries.

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
