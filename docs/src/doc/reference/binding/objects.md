---
description: Construction, validity, freeing, cleanup callbacks, reference counting, and static object lifetime.
---

# Objects and lifetime

## Construction and validity

Constructing an engine class creates its Godot object. A JVM reference can outlive the native object. `GD.isInstanceValid(object)` returns `false` for null or a deleted object; a non-null reference is not a validity check.

/// tab | Kotlin

```kotlin
import godot.api.Node
import godot.global.GD

val node = Node()
val valid = GD.isInstanceValid(node)
node.free()
```

///

/// tab | Java

```java
import godot.api.Node;
import godot.global.GD;

Node node = new Node();
boolean valid = GD.isInstanceValid(node);
node.free();
```

///

/// tab | Scala

```scala
import godot.api.Node
import godot.global.GD

val node = new Node()
val valid = GD.isInstanceValid(node)
node.free()
```

///

## Cleanup operations

| Operation/type | Contract |
|---|---|
| `Object.free()` | Frees the native object immediately; existing JVM references no longer represent a live object |
| `Node.queueFree()` | Queues deletion through Godot's scene lifecycle |
| `RefCounted` | Lifetime follows reference counting coordinated with JVM garbage collection |
| `_onDestroy()` | Binding cleanup callback on non-`RefCounted` classes; final on `RefCounted` |
| `GD.syncMemory()` | Requests a binding memory synchronization; does not replace ownership rules |

Dropping a JVM reference is not an explicit deletion operation for a plain `Object`/`Node`. Nodes owned by the scene tree follow the tree's lifetime. Do not call methods through references to freed objects.

## `_onDestroy`

Only override `_onDestroy()` in a non-`RefCounted` class. It is a JVM binding callback, not a registered Godot method, and does not require `@Register`.

/// tab | Kotlin

```kotlin
override fun _onDestroy() {
    // Release resources owned by this instance.
}
```

///

/// tab | Java

```java
@Override
public void _onDestroy() {
    // Release resources owned by this instance.
}
```

///

/// tab | Scala

```scala
override def _onDestroy(): Unit = {
  // Release resources owned by this instance.
}
```

///

## `asStatic`

Registers a non-`RefCounted` object for freeing at JVM shutdown and returns the same object. Null and `RefCounted` inputs are returned unchanged. It retains ordinary objects for the JVM session; use it only for objects with that intended lifetime.

/// tab | Kotlin

```kotlin
import godot.api.Node
import godot.extension.asStatic

val node = Node().asStatic()
```

///

/// tab | Java

```java
import godot.api.Node;
import godot.extension.ObjectUtils;

Node node = ObjectUtils.asStatic(new Node());
```

///

/// tab | Scala

```scala
import godot.api.Node
import godot.extension.ObjectUtils

val node = ObjectUtils.asStatic(new Node())
```

///

## `GD.callWhenClosing`

Registers a JVM shutdown callback. Callback order is unspecified. Godot has already partly shut down, so the scene tree and some engine APIs are unavailable. The callback type returns Kotlin `Unit`, including when called from Java or Scala.

/// tab | Kotlin

```kotlin
import godot.global.GD

val worker = java.util.concurrent.Executors.newSingleThreadExecutor()
GD.callWhenClosing { worker.shutdown() }
```

///

/// tab | Java

```java
import godot.global.GD;

var worker = java.util.concurrent.Executors.newSingleThreadExecutor();
GD.callWhenClosing(() -> {
    worker.shutdown();
    return kotlin.Unit.INSTANCE;
});
```

///

/// tab | Scala

```scala
import godot.global.GD

val worker = java.util.concurrent.Executors.newSingleThreadExecutor()
GD.callWhenClosing(() => {
  worker.shutdown()
  kotlin.Unit.INSTANCE
})
```

///

[Memory management](../../contribute/how-it-works/memory-management.md) documents the implementation. [Runtime settings](../runtime-configuration.md#jvm-disable-gc) describe the binding GC flag.

`_onDestroy()` runs on native destruction, like Godot's `NOTIFICATION_PREDELETE`, rather than on leaving the scene tree.
