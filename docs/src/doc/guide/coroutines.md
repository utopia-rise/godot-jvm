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

`Node.launch` starts on Godot's main thread and cancels its child coroutines when the node exits the scene tree. Start it in `_ready()` or later, while the node is inside the tree. The body runs immediately, until it first suspends, so a coroutine that never suspends finishes before `launch` returns; see the reference's "Threads" section before emitting signals that other scripts await.

/// tab | Kotlin

The following `Player` method waits for the next `healthChanged` emission. It can be invoked from `_ready()`.

```kotlin
import godot.coroutines.await
import godot.coroutines.launch

fun watchHealth() = launch {
    val (current, max) = healthChanged.await()
    GD.print("Health changed to $current / $max")
}
```

///

These coroutine helpers are Kotlin-only. Java and Scala use normal signal connections instead.

See the [coroutine reference](../reference/binding/coroutines.md) for frame waits, flows, thread switching, and a complete encounter example.
