---
description: Packages, method and property access, singletons, virtual callbacks, renamed symbols, and engine enums.
---

# Engine API and naming

## Packages

| Package | Contents |
|---|---|
| `godot.api` | Engine classes and singletons: `Node`, `Resource`, `Input`, `Engine` |
| `godot.core` | Variant-compatible types, enums, signals, and callables |
| `godot.annotation` | Registration and Inspector annotations |
| `godot.global` | `GD` global functions |
| `godot.extension` | Binding convenience APIs |
| `godot.coroutines` | Optional Kotlin coroutine APIs |

Engine class behavior is documented in the [Godot class reference](https://docs.godotengine.org/en/stable/classes/index.html); select the engine version used by your project. This page specifies the JVM access forms and naming differences.

## Methods and properties

Regular generated methods use `camelCase`: `add_child` becomes `addChild`. Generated properties expose JVM getters/setters. Engine virtual callbacks preserve names such as `_ready` and `_physics_process`.

/// tab | Kotlin

```kotlin
import godot.api.Node3D
import godot.core.Vector3

val node = Node3D()
node.position = Vector3(1, 2, 3)
val position = node.position
node.queueFree()
```

///

/// tab | Java

```java
import godot.api.Node3D;
import godot.core.Vector3;

Node3D node = new Node3D();
node.setPosition(new Vector3(1, 2, 3));
Vector3 position = node.getPosition();
node.queueFree();
```

///

/// tab | Scala

```scala
import godot.api.Node3D
import godot.core.Vector3

val node = new Node3D()
node.setPosition(new Vector3(1, 2, 3))
val position = node.getPosition()
node.queueFree()
```

///

Value-type getters return copies; see [types and conversions](binding/types.md#copies-and-shared-storage).

## Singletons and global functions

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

## Enums and constants

Enum values are scoped under the enum type. `Node.PROCESS_MODE_INHERIT` becomes `Node.ProcessMode.INHERIT`. Generated enums expose their numeric Godot value.

/// tab | Kotlin

```kotlin
import godot.api.Node

val mode = Node.ProcessMode.INHERIT
val number: Long = mode.value
```

///

/// tab | Java

```java
import godot.api.Node;

Node.ProcessMode mode = Node.ProcessMode.INHERIT;
long number = mode.getValue();
```

///

/// tab | Scala

```scala
import godot.api.Node

val mode = Node.ProcessMode.INHERIT
val number: Long = mode.getValue()
```

///

## Renamed symbols

| Godot symbol | JVM symbol |
|---|---|
| `Array` | `VariantArray` |
| Packed-array conversion to another packed type | `toPackedXArray` / `toPackedByteArray` |
| `Error.ERR_PARAMETER_RANGE_ERROR` | `Error.PARAMETER_RANGE` |
| `MethodFlags.METHOD_FLAG_NORMAL` | `MethodFlags.NORMAL` |
| `Node.ProcessThreadMessages.FLAG_PROCESS_THREAD_MESSAGES_PHYSICS` | `Node.ProcessThreadMessages.FLAG_PHYSICS` |

Redundant enum-name prefixes are removed from generated enum entries. Engine bitfield wrappers and user `BitField<E>` are described under [enums and bitfields](binding/types.md#enums-and-bitfields).

## Registered member names

User properties, functions, and signals use `snake_case` on the Godot side: `moveSpeed` becomes `move_speed`. This is separate from generated API method access in JVM code.

String-based Godot calls and `MethodStringNameN` require the registered name. `SignalN.create` and `StringNames.toGodotName` perform conversion; `MethodStringNameN` constructors preserve their input. See [callables](binding/callables.md#methodstringnamen).

## Additional functions

Binding-specific helpers are listed under [global functions](binding/globals.md), [types](binding/types.md), [objects](binding/objects.md), and [signals](binding/signals.md).

## Finding nodes

`getNode(NodePath)` returns `Node?`; a missing path returns null and Godot reports an error. Cast to the expected subclass. Kotlin also provides `getNodeAs<T>` in `godot.extension`; it returns null for a missing node, but a wrong class cast still fails.

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

## Loading and instantiating scenes

`GD.load<T>` returns a nullable resource. `PackedScene.instantiate()` returns the scene root as a `Node`; cast to the scene's actual root type and add it to the tree. These snippets run inside a node method and expect a `Node2D` root.

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
