---
description: The godot { } properties that control which JVM languages compile and which Java, Kotlin, and Scala versions the build uses.
---

# Languages and toolchains

These properties select the source languages and Java, Kotlin, and Scala versions used by the build.

## `languages`

Controls which JVM source languages participate in the initial `classes` compilation pass.

Default:

- Kotlin
- Java
- Scala

Example:

```kotlin
import godot.gradle.GodotLanguage

godot {
    languages.set(setOf(GodotLanguage.KOTLIN, GodotLanguage.JAVA))
}
```

Effect:

- `compileKotlin` only runs when `KOTLIN` is enabled
- `compileJava` only runs when `JAVA` is enabled
- `compileScala` only runs when `SCALA` is enabled
- The Scala plugin and runtime are added only when `SCALA` is enabled

## `javaVersion`

Configures the Java and Kotlin toolchains used for compilation.

Default:

- `17`

Example:

```kotlin
godot {
    javaVersion.set(21)
}
```

Rules:

- the plugin rejects any value below JDK `17`
- the value is applied to both the Java toolchain and the Kotlin JVM toolchain

## `kotlinVersion`

Expected Kotlin Gradle plugin version for the build.

Default:

- `2.3.20`

Example:

```kotlin
godot {
    kotlinVersion.set("2.3.20")
}
```

Rules:

- must be at least `2.3.20` for the current Godot-JVM release
- if no Kotlin JVM plugin is declared, Godot-JVM applies Kotlin `2.3.20` automatically
- an explicitly declared higher version is accepted when `kotlinVersion` keeps its default
- if you override it, you must also apply `org.jetbrains.kotlin.jvm` explicitly with the same version before `com.utopia-rise.godot-jvm`, otherwise the build fails with a version mismatch

Example with explicit override:

```kotlin
plugins {
    kotlin("jvm") version "YOUR_KOTLIN_VERSION"
    id("com.utopia-rise.godot-jvm") version "YOUR_GODOT_JVM_VERSION"
}

godot {
    kotlinVersion.set("YOUR_KOTLIN_VERSION")
}
```

## `scalaVersion`

Scala version used when Scala support is enabled.

Default:

- `3.6.3`

Example:

```kotlin
godot {
    scalaVersion.set("3.6.3")
}
```

Rules:

- only matters when `languages` contains `GodotLanguage.SCALA`
- must be at least Scala `3.0.0`
