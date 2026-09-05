---
description: godot-library, godot-bootstrap, main.jar and the GraalVM usercode image, what each one contains, who depends on it and when it is used.
---

# The three build artifacts

The build separates the bindings, bootstrap runtime, and user code. GraalVM combines them into a native artifact for ahead-of-time execution.

## godot-bootstrap

`godot-bootstrap.jar` bundles `godot-library` (the Godot API bindings, published to Maven Central and compiled against by user code), startup and editor-reloading code, and the project's transitive dependencies. `packageBootstrapJar` builds it from the
project's runtime classpath configuration, alongside the plugin's own `bootstrap` configuration.

Godot loads this JAR in the editor and includes it in exports. User projects do not declare it as a build dependency.

## main

The `main.jar` is built when you build your code. It is a shadow JAR containing only your compiled
code and the generated registrar. The configured `shadowJar` task clears its dependency
configurations, so none of your declared dependencies end up in it. Those dependencies are instead
bundled into `godot-bootstrap.jar`.

`godot-bootstrap.jar` loads and executes the code in `main.jar`. Both JARs are included in JVM exports.

## usercode

`usercode` combines the code from `main.jar` and `godot-bootstrap.jar` in a GraalVM native artifact: a shared library on desktop or a static archive on iOS.

Native-image mode uses `usercode` in place of both JARs. Select it through runtime configuration or launch arguments. Code changes require rebuilding the image and restarting the process.

## Extracting export artifacts

The JVM requires filesystem paths for loading JARs and cannot load them directly from the PCK. At startup the binding extracts `godot-bootstrap.jar` and `main.jar` to `user://`, comparing MD5 hashes to avoid unnecessary copies on desktop. Android recopies its runtime artifacts on each launch. Desktop native images are likewise extracted as shared libraries before loading.
