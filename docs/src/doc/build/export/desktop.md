---
description: Bundle an embedded JRE matching the desktop export's operating system and architecture.
---

# Desktop

Select **Generate JRE** in Godot's toolbar and click **Run Gradle**. It runs `generateEmbeddedJre` and creates `jvm/jre-<arch>-<os>` for the current machine. On macOS the entry is per architecture, see [universal macOS exports](#universal-macos-exports). Reuse the embedded JRE between exports; regenerate it after changing the JDK or required modules.

The default modules are `java.base` and `java.logging`. Include modules required by your dependencies; add `jdk.jdwp.agent` for remote debugging or `jdk.management.agent` for JMX. See [task customization](../../reference/gradle-plugin/tasks.md#generateembeddedjre) for the module list and JDK selection.

## Choose the bundled runtime

Desktop presets have a **Godot Jvm > Runtime** option that selects what the export bundles:

| Value | Bundled | Runtime mode |
|---|---|---|
| `JVM` (default) | Embedded JRE, the JARs of the exported variant (`godot-bootstrap.jar` and `usercode.jar`, or the release `game.jar`), and `godotSingle` JARs | JVM |
| `Graal` | The `game` native image of the exported variant | GraalVM native image |
| `No` | Nothing | The export cannot run JVM code |

The export dialog warns when a bundled file is missing: the JRE directory for the preset's OS and architecture, and the debug or release build for its OS.

Presets inherit the on-disk game configuration and can override its debug, memory, and custom-argument
settings. See [preset overrides](../../reference/runtime-configuration.md#preset-overrides). The editor's own
runtime and command-line arguments never become export settings.

## Match the export target

The export copies the JRE matching the preset's OS and architecture from `jvm/jre-<arch>-<os>`. Supported directory values are `amd64` or `arm64` for the architecture, and `linux`, `windows`, or `macos` for the OS.

For another target, generate an embedded JRE using a JDK for that platform and place it in the matching directory. For example, using a Linux amd64 JDK:

```shell
jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux
```

The export host does not determine which JRE is copied.

### Universal macOS exports

Godot's macOS presets default to a **universal** binary, one that runs natively on both Apple Silicon (arm64) and Intel (x86_64) Macs. A JRE is native code too, so a universal export needs two of them: `jvm/jre-arm64-macos` and `jvm/jre-amd64-macos`. No vendor publishes a universal JDK, so each JRE is generated from a JDK of its own architecture.

The second JDK does not need to run on your Mac. `jlink` builds a runtime by unpacking the module files (`jmods`) of the JDK you point it at, so a JDK for the other architecture only needs to be downloaded and unzipped. Install it with the vendor's package installer or place it anywhere on disk; it must be the same major version as the JDK you build with (`JAVA_HOME`).

On macOS the toolbar offers three operations:

| Operation | Gradle tasks | Output |
|---|---|---|
| **Generate JRE (arm64)** | `generateEmbeddedJreArm64` | `jvm/jre-arm64-macos` |
| **Generate JRE (x86_64)** | `generateEmbeddedJreAmd64` | `jvm/jre-amd64-macos` |
| **Generate JRE (universal)** | both | both directories |

For the architecture that is not your Mac's, the task looks for an installed JDK of that architecture and of the same major version as your `JAVA_HOME`, preferring the same vendor and release. It searches, in this order:

- the directory containing your `JAVA_HOME` JDK, which covers sdkman, asdf, jabba and hand-made layouts
- `~/.sdkman/candidates/java`
- `/Library/Java/JavaVirtualMachines`, where package installers put JDKs
- `~/Library/Java/JavaVirtualMachines`, where IntelliJ IDEA downloads JDKs
- `/opt/homebrew/opt` and `/usr/local/opt`, the Apple Silicon and Intel Homebrew prefixes

If none is found, the task fails and lists the directories it searched. Vendor package installers use the same install name for both architectures, so installing the second `.pkg` replaces the first. Download the `.tar.gz` of the other architecture instead, and unpack it into one of the directories above, for example `/Library/Java/JavaVirtualMachines/temurin-17-x64.jdk`.

By hand, the same universal setup on an Apple Silicon Mac with Temurin 17 unpacked that way is two `jlink` commands, run from the project directory. `--module-path` selects whose modules go into the runtime:

```shell
jlink --add-modules java.base,java.logging --strip-debug --no-header-files --no-man-pages --output jvm/jre-arm64-macos
jlink --module-path /Library/Java/JavaVirtualMachines/temurin-17-x64.jdk/Contents/Home/jmods --add-modules java.base,java.logging --strip-debug --no-header-files --no-man-pages --output jvm/jre-amd64-macos
```

The export bundles whichever of the two directories exist. With only one present it still succeeds, with a warning, and the exported game starts only on that JRE's architecture. To skip the second JRE altogether, set the preset's **Binary Format > Architecture** to `arm64` or `x86_64` instead of `universal`.

Open **Project > Export** and select your desktop [export preset](https://docs.godotengine.org/en/stable/tutorials/export/exporting_projects.html). Leave **Godot Jvm > Runtime** on **JVM**, resolve missing-file warnings, and click **Export Project**. Launch the exported executable to finish the desktop workflow.

Details: [Reference](../../reference/gradle-plugin/tasks.md).

Next: [Android (optional target)](android.md).
