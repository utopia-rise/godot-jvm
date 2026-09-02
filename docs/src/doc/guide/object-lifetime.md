---
description: Hooking into instance init and destroy, registering JVM shutdown callbacks with GD.callWhenClosing, and preventing singleton-held object leaks with asStatic.
---

# Object lifetime and cleanup

## Lifecycle

If you want to be notified when initialization and destruction of your class' instance happens, use the `init` block
and override the `_onDestroy` function respectively.

/// tab | Kotlin
```kotlin
@Script
class RotatingCube : Node3D() {
    init {
        println("Initializing RotatingCube!")
    }

    override fun _onDestroy() {
        println("Cleaning up RotatingCube!")
    }
}
```
///

/// tab | Java
```java
@Script
public class RotatingCube extends Node3D {
    public RotatingCube() {
        System.out.println("Initializing RotatingCube!");
    }

    @Override
    public void _onDestroy() {
        System.out.println("Cleaning up RotatingCube!");
    }
}
```
///

/// tab | Scala
```scala
@Script
class RotatingCube extends Node3D {
  println("Initializing RotatingCube!")

  override def _onDestroy(): Unit = {
    println("Cleaning up RotatingCube!")
  }
}
```
///

## Cleanup operations

When running Kotlin/Java/Scala code, the JVM is embedded and managed directly by Godot, which offers little control over the shutdown sequence when the game is closing. This becomes a problem if you use a third-party library whose resources need to be freed or saved, or whose threads need to be closed.
To that end, we provide a simple method that allows you to register callbacks that will be called when the JVM is shut down.

/// tab | Kotlin
```kotlin
fun foo() {
    val resource = AcquireSomeThirdPartyResource()
    GD.callWhenClosing {
        resource.close()
    }
}
```
///

/// tab | Java
```java
void foo() {
    var resource = AcquireSomeThirdPartyResource();
    GD.callWhenClosing(() -> {
        resource.close();
        return Unit.INSTANCE;
    });
}
```
///

/// tab | Scala
```scala
def foo(): Unit = {
  val resource = AcquireSomeThirdPartyResource()
  GD.callWhenClosing(() => {
    resource.close()
    kotlin.Unit.INSTANCE
  })
}
```
///

!!! note
    `callWhenClosing` takes a Kotlin function type, which compiles to `kotlin.jvm.functions.Function0<kotlin.Unit>`.
    Java and Scala lambdas must therefore return `kotlin.Unit.INSTANCE` instead of falling off the end of the block.

!!! warning
    Be mindful that this operation happens when Godot has already been partially closed.
    The SceneTree is no longer present and a part of the Godot API has been unregistered.
    The order of execution is not guaranteed. Make sure that those callbacks don't depend on each other.


Sometimes you need to store some Godot objects or references in a Kotlin singleton.
This can cause some memory leak warnings when the program ends because they are kept alive by the singleton.
This issue is fixed by using the method `asStatic()` on singleton properties. Those properties will be freed once the running JVM ends.
It accepts both `Object` and `RefCounted`: a plain `Object` is freed when the JVM shuts down, while a `RefCounted` is
returned unchanged because its reference counting already frees it.

!!! warning
    Only use it on a singleton, otherwise all the properties of all instances are going to be kept alive until the end of the JVM.

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

!!! note
    `asStatic()` is Kotlin-only: it is a Kotlin extension function declared in `godot.extension.api`. Java and Scala
    call it as a static method on `godot.extension.api.ObjectUtils` instead, passing the object as the first argument.
    Java has no language-level singleton, so the example above uses a final class with static fields and a private
    constructor; Scala uses its own `object`.

For the reasoning behind `RefCounted` needing no cleanup here, see
[Memory management](../contribute/how-it-works/memory-management.md).
