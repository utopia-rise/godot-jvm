---
description: Godot-JVM coroutine support is Kotlin-only, adding a Godot coroutine scope and suspending signal awaits through an opt-in Gradle flag.
---

# Coroutines

Use Kotlin's coroutine helpers to suspend work until a signal emits; Java and Scala can call these helpers through a Kotlin wrapper.

Enable coroutine support in `build.gradle.kts`:

```kotlin
godot {
    isGodotCoroutinesEnabled.set(true)
}
```

This adds the Godot coroutine library and `kotlinx.coroutines`. Add this method to `Player`: `godotCoroutine` launches a coroutine in a Godot scope and `await()` suspends until the next health change.

```kotlin
import godot.coroutines.await
import godot.coroutines.godotCoroutine

fun watchHealth() = godotCoroutine {
    val (current, max) = healthChanged.await()
    GD.print("Health changed to $current / $max")
}
```
