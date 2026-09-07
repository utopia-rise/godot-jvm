---
description: Kotlin coroutine scope, dispatchers, signal awaits, frame scheduling, and resource loading.
---

# Coroutines

Package: `godot.coroutines`. Requires [`isGodotCoroutinesEnabled`](../gradle-plugin/packaging-and-tasks.md#isgodotcoroutinesenabled) in `build.gradle.kts`.

## Availability

/// tab | Kotlin

The suspend and reified APIs below are directly available from Kotlin.

```kotlin
import godot.coroutines.await
import godot.coroutines.godotCoroutine

fun watchHealth() = godotCoroutine {
    val health = healthChanged.await()
}
```

///

/// tab | Java

There is no direct Java equivalent to Kotlin suspend calls. Use [signal connections](signals.md#lambda-connections) for callback-based code.

///

/// tab | Scala

There is no direct Scala equivalent to Kotlin suspend calls. Use [signal connections](signals.md#lambda-connections) for callback-based code.

///

## `godotCoroutine`

Launches work in the shared `GodotCoroutine` scope. `context` defaults to `EmptyCoroutineContext`; `start` defaults to `CoroutineStart.DEFAULT`. The scope combines `GodotDispatchers.ThreadPool` and `SupervisorJob`.

Returns `Unit`, not a `Job`. This global scope is not tied to a particular node's lifetime. For explicit cancellation ownership, launch through a coroutine scope/Job controlled by your code. A worker-thread coroutine must switch to the main thread for engine operations that require it.

## `GodotDispatchers`

| Dispatcher | Execution |
|---|---|
| `MainThread` | Runs immediately when already on the main thread; otherwise dispatches through a deferred callable |
| `ThreadPool` | Runs through Godot's worker thread pool |
| `ProcessFrame` | Resumes through a one-shot `SceneTree.processFrame` connection |
| `PhysicsFrame` | Resumes through a one-shot `SceneTree.physicsFrame` connection |

Frame dispatchers require a `SceneTree` main loop.

## `SignalN.await`

Suspends until the next emission. `Signal0.await()` returns `Unit`; `Signal1<P0>.await()` returns `P0`; higher arities return `SignalArgumentsN` with `p0`, `p1`, and subsequent fields, supporting destructuring. The signal promise's cancellation callback cancels the suspended continuation.

## Thread and frame helpers

`awaitMainThread { ... }`, `awaitProcessFrame { ... }`, and `awaitPhysicsFrame { ... }` execute a block on the matching dispatcher and return its result. They are suspend functions. `awaitMainThread` does not wait for a later frame when already on the main thread.

## Resource loading

`ResourceLoader.awaitLoad(path, typeHint = "", cacheMode = REUSE)` returns `Resource?`. An already cached resource is loaded immediately; otherwise loading runs on the worker thread pool. `awaitLoadAs<R>` supplies a typed result. A load failure returns null.
