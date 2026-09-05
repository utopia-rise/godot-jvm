---
description: Public Gradle build tasks, artifacts, registration behavior, library mode, and embedded JRE inputs.
---

# Gradle tasks

Run through the project's Gradle wrapper. The names below are identical for Kotlin, Java, and Scala projects. A normal build compiles enabled languages, updates registration when needed, and packages the runtime artifacts.

## Build targets

| Task | Output/effect | Required inputs |
|---|---|---|
| `build` | Desktop debug JARs; normal Gradle build/check lifecycle | Configured JVM toolchain |
| `buildRelease` | Desktop release JARs | Same as `build` |
| `buildAndroid` | Desktop JARs and Android dex artifacts | Android d8 and platform SDK |
| `buildAndroidRelease` | Release Android artifacts | Same as `buildAndroid` |
| `buildGraalNativeImage` | Desktop JARs and native image | GraalVM and native compiler |
| `buildGraalNativeImageRelease` | Release native image | Same as `buildGraalNativeImage` |
| `buildIOS` | iOS static library from packaged JVM code | iOS native-image toolchain |
| `buildIOSRelease` | Release iOS static library | Same as `buildIOS` |

Release tasks select release runtime artifacts. `build -Prelease` also selects release mode. Platform configuration keys are listed under [Export options](export-targets.md).

Desktop distribution artifacts are `godot-bootstrap.jar` and `main.jar`. Android packaging produces dex JARs, and native-image packaging produces `usercode` artifacts. These tasks prepare JVM-side artifacts; Godot's export preset produces the final game package.

## `fastBuild`

Recompiles project code and rebuilds desktop JARs while reusing the previous registrar output. Requires an earlier successful full build. No class scan, registrar generation, or `.gdj` synchronization runs.

Valid for method-body changes. Adding, removing, renaming, or changing the signature of a registered class/member requires a normal build. `fastBuild` does not enable native-image hot reloading.

```shell
./gradlew fastBuild
```

## Library mode

When [`isLibrary`](packaging-and-tasks.md#islibrary) is true, `build`, `buildRelease`, and `fastBuild` use the ordinary library build. No local registrar or runnable-project packaging is produced. Android, GraalVM, and iOS build targets fail as unavailable in this mode.

## `generateEmbeddedJre`

Runs `jlink` from the selected JDK. Replaces its output directory before generating the runtime. The defaults target the host OS and architecture.

Task type: `godot.gradle.tasks.GenerateEmbeddedJreTask`. These are task properties, not `godot { }` options:

| Property | Default | Effect |
|---|---|---|
| `modules` | `java.base`, `java.logging` | JDK modules included in the runtime |
| `outputDir` | `jvm/jre-<amd64 or arm64>-<windows, linux or macos>` | Runtime directory |
| `arguments` | `--strip-debug`, `--no-header-files`, `--no-man-pages` | Additional jlink arguments |
| `javaHome` | `JAVA_HOME`, falling back to the Gradle JVM's `java.home` | JDK containing `bin/jlink` |

```kotlin title="build.gradle.kts"
import godot.gradle.tasks.GenerateEmbeddedJreTask

tasks.withType<GenerateEmbeddedJreTask> {
    modules = arrayOf("java.base", "java.logging", "jdk.jdwp.agent")
}
```

Remote debugging needs `jdk.jdwp.agent`; JMX needs `jdk.management.agent`.

## `clean`

Runs the standard Gradle clean lifecycle and recreates the ignore files required by the Godot project. It is not a substitute for a full registration rebuild.
