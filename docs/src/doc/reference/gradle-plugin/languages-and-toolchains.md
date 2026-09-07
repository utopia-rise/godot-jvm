---
description: The godot { } properties that control which JVM languages compile and which Java, Kotlin, and Scala versions the build uses.
---

# Languages and toolchains

These settings control which JVM languages participate in the initial compilation pass, and which Java/Kotlin/Scala versions are used for the build. See [the block at a glance](index.md) for a full example.

## Build languages and toolchains

### `languages`

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
- Scala plugin/runtime wiring is only added when `SCALA` is enabled

### `toolchain.javaVersion`

Configures the Java and Kotlin toolchains used for compilation.

Default:

- `17`

Example:

```kotlin
godot {
    toolchain {
        javaVersion.set(21)
    }
}
```

Rules:

- the plugin rejects any value below JDK `17`
- the value is applied to both the Java toolchain and the Kotlin JVM toolchain

### `toolchain.kotlinVersion`

Expected Kotlin Gradle plugin version for the build.

Default:

- `2.3.20`

Example:

```kotlin
godot {
    toolchain {
        kotlinVersion.set("2.3.20")
    }
}
```

Rules:

- must be at least `2.3.20` for the current Godot-JVM release
- if you keep the default, the Godot plugin applies Kotlin `2.3.20` automatically
- if you override it, you must also apply `org.jetbrains.kotlin.jvm` explicitly with the same version before `com.utopia-rise.godot-jvm`, otherwise the build fails with a version mismatch

Example with explicit override:

```kotlin
plugins {
    kotlin("jvm") version "YOUR_KOTLIN_VERSION"
    id("com.utopia-rise.godot-jvm") version "YOUR_GODOT_JVM_VERSION"
}

godot {
    toolchain {
        kotlinVersion.set("YOUR_KOTLIN_VERSION")
    }
}
```

### `toolchain.scalaVersion`

Scala version used when Scala support is enabled.

Default:

- `3.6.3`

Example:

```kotlin
godot {
    toolchain {
        scalaVersion.set("3.6.3")
    }
}
```

Rules:

- only matters when `languages` contains `GodotLanguage.SCALA`
- must be at least Scala `3.0.0`
