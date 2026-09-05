---
description: The godot { } packaging and coroutine switches, plus fastBuild and the registrar threshold for incremental builds.
---

# Packaging options

These options control library packaging, optional coroutine support, and incremental builds.

## Packaging and optional features

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
- leaves a regular library JAR as the final artifact

Unlike `registration.disableGdj`, `isLibrary` turns off the whole local runtime-registration pipeline rather than only the `.gdj` part of it.

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

## Incremental builds

Use these tasks and settings to control incremental builds.

The [`fastBuild`](tasks.md#fastbuild) task reuses the previous registration artifacts.

### `registration.incrementalFullBuildThreshold`

Maximum number of changed classes handled by incremental registrar generation. Above this threshold, the plugin regenerates all registrars to avoid the overhead of incremental analysis.

Default:

- `32`

Example:

```kotlin
godot {
    registration.incrementalFullBuildThreshold.set(64)
}
```

Registrar generation also falls back to a full run when there is no previous manifest, when the previous outputs are incomplete, or when the runtime classpath changed.
