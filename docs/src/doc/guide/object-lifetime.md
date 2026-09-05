---
description: Hooking into instance init and destroy, registering JVM shutdown callbacks with GD.callWhenClosing, and preventing singleton-held object leaks with asStatic.
---

# Object lifetime and cleanup

Initialize an instance in its constructor or Kotlin `init` block. Override `_onDestroy()` for cleanup on `Node` and other non-`RefCounted` classes. It is final on `RefCounted`, where reference counting handles destruction:

/// tab | Kotlin
```kotlin
@Script
class Player : Node() {
    init {
        GD.print("Initializing Player!")
    }

    override fun _onDestroy() {
        GD.print("Cleaning up Player!")
    }
}
```
///

/// tab | Java
```java
@Script
public class Player extends Node {
    public Player() {
        GD.print("Initializing Player!");
    }

    @Override
    public void _onDestroy() {
        GD.print("Cleaning up Player!");
    }
}
```
///

/// tab | Scala
```scala
@Script
class Player extends Node {
  GD.print("Initializing Player!")

  override def _onDestroy(): Unit = {
    GD.print("Cleaning up Player!")
  }
}
```
///

## Cleanup operations

Godot manages the embedded JVM's shutdown. Use `GD.callWhenClosing` to release library resources, save pending data, or stop threads when the JVM closes:

/// tab | Kotlin
```kotlin
fun startWorker() {
    val worker = java.util.concurrent.Executors.newSingleThreadExecutor()
    GD.callWhenClosing {
        worker.shutdown()
    }
}
```
///

/// tab | Java
```java
void startWorker() {
    var worker = java.util.concurrent.Executors.newSingleThreadExecutor();
    GD.callWhenClosing(() -> {
        worker.shutdown();
        return kotlin.Unit.INSTANCE;
    });
}
```
///

/// tab | Scala
```scala
def startWorker(): Unit = {
  val worker = java.util.concurrent.Executors.newSingleThreadExecutor()
  GD.callWhenClosing(() => {
    worker.shutdown()
    kotlin.Unit.INSTANCE
  })
}
```
///

Java and Scala lambdas must return `kotlin.Unit.INSTANCE`.

!!! warning
    These callbacks run after Godot has partly shut down. The scene tree is gone and some Godot APIs are unavailable. Callback order is unspecified, so keep each callback independent.

## Objects held in static fields

For a Godot `Object` stored in a singleton or static field, use `asStatic()` to free it when the JVM shuts down. Otherwise, the singleton can keep it alive until exit and cause a leak warning. `RefCounted` values are returned unchanged because reference counting already manages them.

!!! warning
    Use `asStatic()` only for objects intended to live until shutdown. Applying it to ordinary instance properties keeps those objects alive for the entire JVM session.

/// tab | Kotlin
```kotlin
object GodotStatic {
    var ref = (ResourceLoader.load("res://Spatial.tscn") as PackedScene?).asStatic()
    var myScene = Node().asStatic()
}
```
///

/// tab | Java
```java
public final class GodotStatic {
    public static PackedScene ref =
            ObjectUtils.asStatic((PackedScene) ResourceLoader.load("res://Spatial.tscn"));
    public static Node myScene = ObjectUtils.asStatic(new Node());

    private GodotStatic() {}
}
```
///

/// tab | Scala
```scala
object GodotStatic {
  var ref: PackedScene =
    ObjectUtils.asStatic(ResourceLoader.load("res://Spatial.tscn").asInstanceOf[PackedScene])
  var myScene: Node = ObjectUtils.asStatic(new Node())
}
```
///

`asStatic()` is a Kotlin extension in `godot.extension.api`. Java and Scala call `ObjectUtils.asStatic(...)`.

[Memory management](../contribute/how-it-works/memory-management.md) explains how Godot-JVM coordinates reference counting and garbage collection.
