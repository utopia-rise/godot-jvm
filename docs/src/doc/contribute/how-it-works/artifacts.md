---
description: godot-library, godot-bootstrap, main.jar and the GraalVM usercode image, what each one contains, who depends on it and when it is used.
---

# The three build artifacts

The build separates the bindings, bootstrap runtime, and user code. GraalVM combines them into a native artifact for ahead-of-time execution.

## godot-bootstrap

`godot-bootstrap.jar` bundles `godot-library` (the Godot API bindings, published to Maven Central and compiled against by user code), startup and editor-reloading code, and the project's ordinary `implementation` dependencies. `packageBootstrapJar` builds it from the
project's runtime classpath configuration, alongside the plugin's own `bootstrap` configuration.

Godot loads this JAR in the editor and includes it in exports. User projects do not declare it as a build dependency.

## main

The `main.jar` is built when you build your code. It is a shadow JAR containing your compiled code, the generated registrar, and dependencies declared with `godotMain`. Ordinary dependencies are bundled into `godot-bootstrap.jar`.

`godot-bootstrap.jar` loads and executes the code in `main.jar`. Both JARs are included in JVM exports.

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

`usercode` combines the code from `main.jar` and `godot-bootstrap.jar` in a GraalVM native artifact: a shared library on desktop or a static archive on iOS.

Native-image mode uses `usercode` in place of both JARs. Select it through runtime configuration or launch arguments. Code changes require rebuilding the image and restarting the process.

## Extracting export artifacts

The JVM requires filesystem paths for loading JARs and cannot load them directly from the PCK. At startup the binding extracts `godot-bootstrap.jar` and `main.jar` to `user://`, comparing MD5 hashes to avoid unnecessary copies on desktop. Android recopies its runtime artifacts on each launch. Desktop native images are likewise extracted as shared libraries before loading.

Separate JARs from `godotSingle` are also copied from `res://jvm/external/` to `user://jvm/external/`, where the class path in the manifest of `main.jar` expects them. Native images and Android builds do not ship them: the native image compiles them in and `main-dex.jar` dexes them.
