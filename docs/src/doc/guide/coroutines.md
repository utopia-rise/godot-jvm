---
description: Use Kotlin-only coroutine helpers to wait for a signal without blocking the game.
---

# Coroutines

Enable coroutine support in `build.gradle.kts`, then reload the Gradle project in IntelliJ IDEA:

```kotlin title="build.gradle.kts"
godot {
    isGodotCoroutinesEnabled.set(true)
}
```

!!! warning "Use the main thread for node access"
    Coroutines run on a worker pool by default. Use `GodotDispatchers.MainThread` or `awaitMainThread` before touching nodes; follow Godot's [thread-safety rules](https://docs.godotengine.org/en/stable/tutorials/performance/thread_safe_apis.html).

/// tab | Kotlin

The following `Player` method waits for the next `healthChanged` emission. It can be invoked from `_ready()`.

```kotlin
import godot.coroutines.GodotDispatchers
import godot.coroutines.await
import godot.coroutines.godotCoroutine

fun watchHealth() = godotCoroutine(GodotDispatchers.MainThread) {
    val (current, max) = healthChanged.await()
    GD.print("Health changed to $current / $max")
}
```

///

These coroutine helpers are Kotlin-only. Java and Scala use normal signal connections instead.
