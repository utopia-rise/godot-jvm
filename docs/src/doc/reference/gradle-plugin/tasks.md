---
description: Public Gradle build tasks, artifacts, registration behavior, library mode, and embedded JRE inputs.
---

# Gradle tasks

Run through the project's Gradle wrapper. The names below are identical for Kotlin, Java, and Scala projects. A normal build compiles enabled languages, updates registration when needed, and packages the runtime artifacts.

## Build targets

| Task | Output/effect | Required inputs |
|---|---|---|
| `build` | `jvm/debug/godot-bootstrap.jar` and `jvm/debug/usercode.jar`; normal Gradle build/check lifecycle | Configured JVM toolchain |
| `buildRelease` | `jvm/release/game.jar`, the two JARs merged into one | Same as `build` |
| `buildAndroid` | The debug JARs and `jvm/debug/godot-bootstrap-dex.jar` plus `usercode-dex.jar` | Android d8 and platform SDK |
| `buildAndroidRelease` | `jvm/release/game-dex.jar` | Same as `buildAndroid` |
| `buildGraalNativeImage` | The debug JARs and `jvm/debug/game.<so, dll or dylib>` | GraalVM and native compiler |
| `buildGraalNativeImageRelease` | `jvm/release/game.<so, dll or dylib>` | Same as `buildGraalNativeImage` |
| `buildIOS` | `jvm/debug/game.a` and the shared `jvm/ios/ios-jdk/` | iOS native-image toolchain |
| `buildIOSRelease` | `jvm/release/game.a` | Same as `buildIOS` |

Release tasks select the release runtime libraries and write into `jvm/release/`; debug tasks write into `jvm/debug/`. The two directories never overwrite each other, so both variants can be kept built. `build -Prelease` also selects release mode and then produces only the release artifacts. Platform configuration keys are listed under [Export options](export-targets.md).

Every `godotSplitImplementation` JAR is copied intact into `jvm/<variant>/dependencies/`. These tasks prepare JVM-side artifacts; Godot's export preset produces the final game package from the variant matching the export type.

## `fastBuild`

Recompiles project code and rebuilds the desktop debug JARs while reusing the previous registrar output. Requires an earlier successful full build. No class scan, registrar generation, or `.gdj` synchronization runs. It fails in release mode, which never reuses debug output.

Valid for method-body changes. Adding, removing, renaming, or changing the signature of a registered class/member requires a normal build. `fastBuild` does not enable native-image hot reloading.

```shell
./gradlew fastBuild
```

## `installAddon`

Installs the Godot-JVM addon of the plugin's own version in the project's `addons/jvm/`, replacing the current one if any, so the native libraries always match the JVM libraries the build uses. The addon is published next to those libraries, in `com.utopia-rise:godot-jvm`, and resolved from the same repositories.

```shell
./gradlew installAddon
```

The task deletes everything in `addons/jvm/` before extracting the new addon, so local changes to its files are lost. It can run while the Godot editor is open: the editor keeps the previous native library loaded until it restarts, and the files it still holds stay in a hidden `addons/.jvm-previous-<time>/` directory that the next run removes.

Every published Godot-JVM version carries the addon, dev and release candidates included. With a Godot-JVM version built from source or taken from JitPack, the task fails without touching `addons/jvm/`.

## Library mode

When [`isLibrary`](packaging-and-tasks.md#islibrary) is true, `build`, `buildRelease`, and `fastBuild` use the ordinary library build. No local registrar or runnable-project packaging is produced. Android, GraalVM, and iOS build targets fail as unavailable in this mode.

## `generateEmbeddedJre`

Runs `jlink` from the selected JDK. Replaces its output directory once its checks passed. The defaults target the host OS and architecture. On macOS, `generateEmbeddedJreArm64` and `generateEmbeddedJreAmd64` target one architecture each, so a universal export can bundle both. For the architecture that is not the host's, the task finds an installed JDK of that architecture and of the same major version as `javaHome`, and jlink assembles that JDK's `jmods` without running it. See [universal macOS exports](../../build/export/desktop.md#universal-macos-exports) for where it looks.

Task type: `godot.gradle.tasks.GenerateEmbeddedJreTask`. These are task properties, not `godot { }` options; `tasks.withType` applies them to every architecture's task, `tasks.named` to one:

| Property | Default | Effect |
|---|---|---|
| `modules` | `java.base`, `java.logging` | JDK modules included in the runtime |
| `outputDir` | `jvm/jre-<amd64 or arm64>-<windows, linux or macos>` | Runtime directory |
| `arguments` | `--strip-debug`, `--no-header-files`, `--no-man-pages` | Additional jlink arguments |
| `javaHome` | `JAVA_HOME`, falling back to the Gradle JVM's `java.home` | JDK containing `bin/jlink`, and whose modules make up a host-architecture runtime |

```kotlin title="build.gradle.kts"
import godot.gradle.tasks.GenerateEmbeddedJreTask

tasks.withType<GenerateEmbeddedJreTask> {
    modules = arrayOf("java.base", "java.logging", "jdk.jdwp.agent")
}
```

Remote debugging needs `jdk.jdwp.agent`; JMX needs `jdk.management.agent`.

## `clean`

Runs the standard Gradle clean lifecycle and recreates the ignore files required by the Godot project. It is not a substitute for a full registration rebuild.

## Custom API tasks

With [`isCustomApiEnabled`](packaging-and-tasks.md#custom-godot-api-bindings), `generateCustomGodotApi`, the custom API compilation, and `customGodotApiJar` produce local bindings from `api.json`. They use declared inputs and outputs for up-to-date checks and the Gradle build cache. The maintainer task `generateAPI` remains separate.
