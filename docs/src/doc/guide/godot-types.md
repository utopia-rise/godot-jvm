---
description: Find child nodes, instantiate scenes, and update Godot values from JVM code.
---

# Working with Godot types

Find child nodes, instantiate scenes, and update Godot values from JVM code.

## Find a child node

For a scene with a child named `Timer`, the following code accesses it from `_ready()`. [`getNode`](https://docs.godotengine.org/en/stable/classes/class_node.html#class-node-method-get-node) returns a nullable node; cast it to the expected type.

/// tab | Kotlin

```kotlin
import godot.api.Timer
import godot.core.NodePath
import godot.extension.getNodeAs

val child = getNode(NodePath("Timer")) // Node?, nullable
val timer = getNodeAs<Timer>("Timer")
timer?.start(1.0)
```

///

/// tab | Java

```java
import godot.api.Timer;
import godot.core.NodePath;

Timer timer = (Timer) getNode(new NodePath("Timer"));
if (timer != null) {
    timer.start(1.0);
}
```

///

/// tab | Scala

```scala
import godot.api.Timer
import godot.core.NodePath

val timer = getNode(new NodePath("Timer")).asInstanceOf[Timer]
if (timer != null) {
  timer.start(1.0)
}
```

///

## Load a scene

This example loads a [PackedScene](https://docs.godotengine.org/en/stable/classes/class_packedscene.html) named `bullet.tscn`, instantiates its `Node2D` root, and adds it as a child from a node method.

/// tab | Kotlin

```kotlin
import godot.api.Node2D
import godot.api.PackedScene
import godot.global.GD

val scene = GD.load<PackedScene>("res://bullet.tscn")
if (scene != null) {
    val bullet = scene.instantiate() as Node2D
    addChild(bullet)
}
```

///

/// tab | Java

```java
import godot.api.Node2D;
import godot.api.PackedScene;
import godot.global.GD;

PackedScene scene = GD.load("res://bullet.tscn");
if (scene != null) {
    Node2D bullet = (Node2D) scene.instantiate();
    addChild(bullet);
}
```

///

/// tab | Scala

```scala
import godot.api.Node2D
import godot.api.PackedScene
import godot.global.GD

val scene = GD.load[PackedScene]("res://bullet.tscn")
if (scene != null) {
  val bullet = scene.instantiate().asInstanceOf[Node2D]
  addChild(bullet)
}
```

///

## Value types are copies

!!! warning "Assign value types back"
    Value types such as `Vector3` are copies when read from Godot properties. Changing the copy does not update the node.

This changes only a copy:

/// tab | Kotlin

```kotlin
val node3D = Node3D()
node3D.rotation.y += 10f
```

///

/// tab | Java

```java
Node3D node3D = new Node3D();
node3D.getRotation().setY(node3D.getRotation().getY() + 10f);
```

///

/// tab | Scala

```scala
val node3D = new Node3D()
node3D.getRotation.setY(node3D.getRotation.getY + 10f)
```

///

To update `rotation`, change the copy and assign it back to the property:

/// tab | Kotlin

```kotlin
val rotation = node3D.rotation
rotation.y += 10f
node3D.rotation = rotation
```

///

/// tab | Java

```java
Vector3 rotation = node3D.getRotation();
rotation.setY(rotation.getY() + 10f);
node3D.setRotation(rotation);
```

///

/// tab | Scala

```scala
val rotation = node3D.getRotation
rotation.setY(rotation.getY + 10f)
node3D.setRotation(rotation)
```

///

Kotlin's mutation helpers combine these steps and write the changed value back automatically. In Java and Scala, use the read-modify-write form above.

/// tab | Kotlin

```kotlin
node3D.rotationMutate {
  y += 10f
}
```

///

## Collections share storage

`VariantArray` and `Dictionary` share their contents with Godot. Value-type elements still need read-modify-write: retrieve the element, change it, then assign it back to the same index or key.

Use your language's type checks for engine classes and your own scripts: `is` in Kotlin, `instanceof` in Java, and pattern matching in Scala.

## Use a singleton

Engine singletons are accessed through their generated class. Global helpers are on `godot.global.GD`.

/// tab | Kotlin

```kotlin
import godot.api.Engine
import godot.global.GD

GD.print(Engine.getFramesPerSecond())
```

///

/// tab | Java

```java
import godot.api.Engine;
import godot.global.GD;

GD.print(Engine.getFramesPerSecond());
```

///

/// tab | Scala

```scala
import godot.api.Engine
import godot.global.GD

GD.print(Engine.getFramesPerSecond())
```

///
