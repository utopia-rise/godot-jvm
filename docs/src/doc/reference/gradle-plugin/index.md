---
description: A quick-start example of the godot { } Gradle block, recommended Gradle performance settings, and related Gradle/editor configuration.
---

# The godot { } block at a glance

Configure `com.utopia-rise.godot-jvm` in the `godot { ... }` block in `build.gradle.kts`. The following pages list each property's purpose, default, and usage:

- [Languages and toolchains](languages-and-toolchains.md)
- [Registration output](registration.md)
- [Packaging and build tasks](packaging-and-tasks.md)
- [Android, GraalVM and iOS inputs](export-targets.md)

## Starter-project example

```kotlin
import godot.gradle.GodotLanguage

godot {
    languages.set(setOf(GodotLanguage.KOTLIN, GodotLanguage.JAVA, GodotLanguage.SCALA))
    isGodotCoroutinesEnabled.set(true)
}
```

This is the core of a Godot-JVM project with every language and Godot coroutines enabled. Settings not shown here retain their plugin defaults. Configure Android, GraalVM, or iOS only when needed; see [Android, GraalVM and iOS inputs](export-targets.md).

## Recommended Gradle performance settings

Set these properties in `gradle.properties` to enable parallel task execution and the configuration cache:

```properties
org.gradle.parallel=true
org.gradle.configuration-cache=true
```

## Related Gradle and editor configuration

These are often configured together with the plugin, but they are not `godot { ... }` properties.

### Custom source directories

If you want Gradle to compile sources from a non-default Kotlin source directory, configure the regular Kotlin source set:

```kotlin
kotlin.sourceSets.main {
    kotlin.srcDirs("scripts")
}
```

### Gradle wrapper path in the Godot editor

Sometimes the Godot project is nested inside a larger repository and the Gradle wrapper lives in a parent directory:

![Example project setup](../../assets/img/custom_gradle_wrapper_path_example_project_setup.png)

In that case, the Godot editor may not find the wrapper automatically because it only looks inside the Godot project directory.

Set `kotlin_jvm/gradle/gradle_wrapper_dir` in Godot's project settings to the wrapper directory so the editor can run builds. The screenshot shows an older editor layout:

![Example project setup](../../assets/img/change_gradle_wrapper_path.png)
