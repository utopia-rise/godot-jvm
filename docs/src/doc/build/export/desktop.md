---
description: Generate an embedded JRE and provide runtimes matching each desktop export's OS and architecture.
---

# Desktop

Create an embedded JRE from your project's root before exporting:

```shell
./gradlew generateEmbeddedJre
```

The task builds a JRE for your current machine. To customize it, configure `GenerateEmbeddedJreTask` in `build.gradle.kts`:

```kotlin
import godot.gradle.tasks.GenerateEmbeddedJreTask

tasks.withType<GenerateEmbeddedJreTask> {
    javaHome = System.getenv("JAVA_HOME") ?: System.getProperty("java.home")
    modules = arrayOf("java.base", "java.logging", "jdk.jdwp.agent")
    arguments = arrayOf("--strip-debug", "--no-header-files", "--no-man-pages")
}
```

Use `javaHome` to choose the JDK containing `jlink`, `modules` to select Java modules, and `arguments` for other `jlink` options. `outputDir` changes the destination.

!!! warning
    The task replaces `outputDir` before generating the JRE. Point it only at a generated runtime directory.

Add optional modules as needed:

- `jdk.jdwp.agent` for remote debugging.
- `jdk.management.agent` for JMX.

## Choose the bundled runtime

Desktop presets have a **Godot Jvm > Runtime** option that selects what the export bundles:

| Value | Bundled | Runtime mode |
|---|---|---|
| `JVM` (default) | Embedded JRE, `godot-bootstrap.jar`, `main.jar` | JVM |
| `Graal` | `usercode` native image | GraalVM native image |
| `Both` | Everything above | The editor's runtime mode |
| `No` | Nothing | The export cannot run JVM code |

The export dialog warns when a bundled file is missing: the JRE directory for the preset's OS and architecture, or the native image for its OS.

## Match the export target

The export copies the JRE matching the preset's OS and architecture from `jvm/jre-<arch>-<os>`. Supported directory values are `amd64` or `arm64` for the architecture, and `linux`, `windows`, or `macos` for the OS.

For another target, run `jlink` with a JDK of that platform into the matching directory. For example, using a Linux amd64 JDK:

```shell
jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux
```

The export host does not determine which JRE is copied. A universal macOS export needs both `jre-arm64-macos` and `jre-amd64-macos`. On an arm64 Mac, an amd64 JDK running through Rosetta can generate the amd64 JRE.
