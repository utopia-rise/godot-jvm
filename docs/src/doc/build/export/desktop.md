---
description: Bundle an embedded JRE matching the desktop export's operating system and architecture.
---

# Desktop

Select **Generate JRE** in Godot's toolbar and click **Run Gradle**. It runs `generateEmbeddedJre` and creates `jvm/jre-<arch>-<os>` for the current machine. Reuse the embedded JRE between exports; regenerate it after changing the JDK or required modules.

The default modules are `java.base` and `java.logging`. Include modules required by your dependencies; add `jdk.jdwp.agent` for remote debugging or `jdk.management.agent` for JMX. See [task customization](../../reference/gradle-plugin/tasks.md#generateembeddedjre) for the module list and JDK selection.

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

For another target, generate an embedded JRE using a JDK for that platform and place it in the matching directory. For example, using a Linux amd64 JDK:

```shell
jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux
```

The export host does not determine which JRE is copied. A universal macOS export needs both `jre-arm64-macos` and `jre-amd64-macos`. On an arm64 Mac, an amd64 JDK running through Rosetta can generate the amd64 JRE.

Open **Project > Export** and select your desktop [export preset](https://docs.godotengine.org/en/stable/tutorials/export/exporting_projects.html). Leave **Godot Jvm > Runtime** on **JVM**, resolve missing-file warnings, and click **Export Project**. Launch the exported executable to finish the desktop workflow.

Details: [Reference](../../reference/gradle-plugin/tasks.md).

Next: [Android (optional target)](android.md).
