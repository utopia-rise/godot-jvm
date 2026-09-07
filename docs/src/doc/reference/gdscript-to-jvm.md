---
description: Equivalent GDScript, Kotlin, Java, and Scala syntax for common Godot scripting tasks.
---

# GDScript differences

Lookup by GDScript construct. GDScript stays visible above the selected JVM language. Examples use **Inferred** registration unless another mode is stated. Full contracts are linked from each entry. Member snippets belong inside a registered script class; `Player` denotes that class.

## Declaring a script class

```gdscript
extends Node

class_name Player
```

/// tab | Kotlin
```kotlin
import godot.annotation.Script
import godot.api.Node

@Script
class Player : Node() {
}
```
///
/// tab | Java
```java
import godot.annotation.Script;
import godot.api.Node;

@Script
public class Player extends Node {
}
```
///
/// tab | Scala
```scala
import godot.annotation.Script
import godot.api.Node

@Script
class Player extends Node {
}
```
///

In Inferred mode, extending a Godot class does not register the script by itself; add `@Script`.

## Exported properties

```gdscript
@export var speed: float = 2.0
```

/// tab | Kotlin
```kotlin
import godot.annotation.Export

@Export
var speed: Float = 2f
```
///
/// tab | Java
```java
import godot.annotation.Export;

@Export
public float speed = 2f;
```
///
/// tab | Scala
```scala
import godot.annotation.Export

@Export
var speed: Float = 2f
```
///

Use `@Visible` to register a property without showing it in the Inspector. [Property hints](annotations.md#property-hints) table lists annotations for sliders, file pickers, and other controls.

## Functions Godot calls on your script

```gdscript
func _ready():
    pass

func announce_ready():
    pass
```

/// tab | Kotlin
```kotlin
import godot.annotation.Register

override fun _ready() {
}

@Register
fun announceReady() {
}
```
///
/// tab | Java
```java
import godot.annotation.Register;

@Override
public void _ready() {
}

@Register
public void announceReady() {
}
```
///
/// tab | Scala
```scala
import godot.annotation.Register

override def _ready(): Unit = {
}

@Register
def announceReady(): Unit = {
}
```
///

Godot's own callbacks (`_ready`, `_process`, `_physics_process`, ...) are recognized from the
override alone. An ordinary function you want Godot or another script to call needs `@Register`.

## Signals

```gdscript
signal health_changed(current, max)

func _ready():
    health_changed.connect(_on_health_changed)

func _on_health_changed(current, max):
    pass
```

/// tab | Kotlin
```kotlin
import godot.annotation.Register
import godot.core.signal2

val healthChanged by signal2<Int, Int>()

override fun _ready() {
    healthChanged.connectMethod(this, Player::onHealthChanged)
}

@Register
fun onHealthChanged(current: Int, max: Int) {
}
```
///
/// tab | Java
```java
import godot.annotation.Register;
import godot.core.Signal2;
import godot.core.MethodStringName2;
import godot.extension.SignalConnectors;

public final Signal2<Integer, Integer> healthChanged = Signal2.create(this, "healthChanged");

@Override
public void _ready() {
    var onHealthChangedName =
        new MethodStringName2<Player, Void, Integer, Integer>("on_health_changed");
    SignalConnectors.connectMethod2(healthChanged, this, onHealthChangedName);
}

@Register
public void onHealthChanged(int current, int max) {
}
```
///
/// tab | Scala
```scala
import godot.annotation.Register
import godot.core.Signal2
import godot.core.MethodStringName2
import godot.extension.SignalConnectors

val healthChanged: Signal2[Integer, Integer] = Signal2.create(this, "healthChanged")

override def _ready(): Unit = {
  val onHealthChangedName =
    new MethodStringName2[Player, Void, Integer, Integer]("on_health_changed")
  SignalConnectors.connectMethod2(healthChanged, this, onHealthChangedName)
}

@Register
def onHealthChanged(current: Int, max: Int): Unit = {
}
```
///

The typed JVM signal carries its argument count and types, allowing the compiler to check calls to `emit`.

## Naming: camelCase in your code, snake_case in Godot

```gdscript
@export var move_speed: float
func take_damage(amount):
    pass
```

/// tab | Kotlin
```kotlin
import godot.annotation.Export
import godot.annotation.Register

@Export
var moveSpeed: Float = 0f

@Register
fun takeDamage(amount: Int) {
}
```
///
/// tab | Java
```java
import godot.annotation.Export;
import godot.annotation.Register;

@Export
public float moveSpeed = 0f;

@Register
public void takeDamage(int amount) {
}
```
///
/// tab | Scala
```scala
import godot.annotation.Export
import godot.annotation.Register

@Export
var moveSpeed: Float = 0f

@Register
def takeDamage(amount: Int): Unit = {
}
```
///

Write properties and functions in your language's normal style; Godot-JVM registers them to Godot
in `snake_case` automatically. `moveSpeed` becomes `move_speed`, `takeDamage` becomes `take_damage`.
This applies uniformly to properties, functions, and signals.

## Type checks

```gdscript
if parent is CollisionShape3D:
    parent.shape = BoxShape3D.new()
```

/// tab | Kotlin
```kotlin
import godot.api.CollisionShape3D
import godot.api.BoxShape3D

if (parent is CollisionShape3D) {
    parent.shape = BoxShape3D()
}
```
///
/// tab | Java
```java
import godot.api.CollisionShape3D;
import godot.api.BoxShape3D;

if (parent instanceof CollisionShape3D collisionShape) {
    collisionShape.setShape(new BoxShape3D());
}
```
///
/// tab | Scala
```scala
import godot.api.CollisionShape3D
import godot.api.BoxShape3D

parent match {
  case collisionShape: CollisionShape3D =>
    collisionShape.setShape(new BoxShape3D())
  case _ =>
}
```
///

These checks also work with your own Godot subclasses.

/// tab | Kotlin

`require` establishes a type check for subsequent code and throws if it fails:

```kotlin
require(parent is CollisionShape3D)
parent.shape = BoxShape3D()
```

///

## Instantiating a script class

```gdscript
var instance = Player.new()
```

/// tab | Kotlin
```kotlin
val instance = Player()
```
///
/// tab | Java
```java
Player instance = new Player();
```
///
/// tab | Scala
```scala
val instance = new Player()
```
///

GDScript can instantiate the JVM class when it has a public no-argument constructor. Constructors with arguments remain available only from JVM code.

## Enums

```gdscript
enum Element { FIRE, WATER, EARTH }
@export var element: Element = Element.FIRE
```

/// tab | Kotlin
```kotlin
import godot.annotation.Export

enum class Element { FIRE, WATER, EARTH }

@Export
var element = Element.FIRE
```
///
/// tab | Java
```java
import godot.annotation.Export;

public enum Element { FIRE, WATER, EARTH }

@Export
public Element element = Element.FIRE;
```
///
/// tab | Scala
```scala
import godot.annotation.Export

enum Element extends java.lang.Enum[Element] {
  case FIRE, WATER, EARTH
}

@Export
var element: Element = Element.FIRE
```
///

An exported enum-typed property becomes an Inspector dropdown automatically in all three languages.

## Loading resources

```gdscript
var scene = preload("res://player.tscn")
var other = load("res://other.tscn")
```

/// tab | Kotlin
```kotlin
import godot.api.PackedScene
import godot.global.GD

val other = GD.load<PackedScene>("res://other.tscn")
```
///
/// tab | Java
```java
import godot.api.PackedScene;
import godot.global.GD;

PackedScene other = GD.load("res://other.tscn");
```
///
/// tab | Scala
```scala
import godot.api.PackedScene
import godot.global.GD

val other = GD.load[PackedScene]("res://other.tscn")
```
///

`GD.load()` loads a resource at runtime and may return null on failure. GDScript's compile-time `preload()` has no JVM equivalent.


## `@rpc`

```gdscript
@rpc("any_peer")
func receive_score(score: int):
    pass
```

/// tab | Kotlin

```kotlin
@godot.annotation.Rpc(rpcMode = godot.annotation.RpcMode.ANY)
fun receiveScore(score: Int) {}
```

///

/// tab | Java

```java
@godot.annotation.Rpc(rpcMode = godot.annotation.RpcMode.ANY)
public void receiveScore(int score) {}
```

///

/// tab | Scala

```scala
@godot.annotation.Rpc(rpcMode = godot.annotation.RpcMode.ANY)
def receiveScore(score: Int): Unit = {}
```

///

Explicit mode additionally requires `@Register`. JVM calls are local; remote calls use Godot RPC operations. See [`@Rpc`](annotations.md#rpc).

## `@tool`

`@Tool` exists, but JVM editor-time tool execution is not implemented. Its class-selection effect depends on the registration mode. See [`@Tool`](annotations.md#tool).

## `Variant`, `Array`, and `Dictionary`

```gdscript
var value: Variant = 10
var values: Array[int] = []
var labels: Dictionary = {}
```

/// tab | Kotlin

```kotlin
import godot.core.VariantArray
import godot.core.Dictionary

var value: Any = 10
val values = VariantArray<Int>()
val labels = Dictionary<String, String>()
```

///

/// tab | Java

```java
import godot.core.VariantArray;
import godot.core.Dictionary;

java.lang.Object value = 10;
var values = new VariantArray<Integer>(Integer.class);
var labels = new Dictionary<String, String>(String.class, String.class);
```

///

/// tab | Scala

```scala
import godot.core.{VariantArray, Dictionary}

var value: Any = 10
val values = new VariantArray[Integer](classOf[Integer])
val labels = new Dictionary[String, String](classOf[String], classOf[String])
```

///

A dynamic Variant carrier accepts values Godot can represent, not arbitrary JVM objects. JVM arrays/collections are not general substitutes for Godot containers. See [types and conversions](binding/types.md#registered-signatures).

## `StringName` and `NodePath`

```gdscript
var member = &"take_damage"
var path = ^"Player/Camera"
```

/// tab | Kotlin

```kotlin
import godot.core.asCachedStringName
import godot.core.asCachedNodePath

val member = "take_damage".asCachedStringName()
val path = "Player/Camera".asCachedNodePath()
```

///

/// tab | Java

```java
import godot.core.StringNames;
import godot.core.NodePaths;

var member = StringNames.asCachedStringName("take_damage");
var path = NodePaths.asCachedNodePath("Player/Camera");
```

///

/// tab | Scala

```scala
import godot.core.{StringNames, NodePaths}

val member = StringNames.asCachedStringName("take_damage")
val path = NodePaths.asCachedNodePath("Player/Camera")
```

///

These helpers preserve spelling. `toGodotName` converts camelCase member names; [conversion reference](binding/types.md#stringname-and-nodepath).

## `Callable`

GDScript method references become typed JVM method callables; JVM lambdas become lambda callables. Method callables require a Godot-visible method. A JVM lambda does not need a registered script function. See [Callables](binding/callables.md) for each language's construction and binding signatures.

## `await`

GDScript's `await signal` has a Kotlin coroutine equivalent, `signal.await()`, inside a coroutine. Java and Scala use callbacks through signal connections; there is no corresponding language-level suspend operation supplied by the binding. See [Coroutines](binding/coroutines.md#availability) and [signal connections](binding/signals.md#lambda-connections).

## Value-type property mutation

A value such as `Vector3` read from Godot is a copy. Mutating the copy does not update its original property. Assign it back; see [copy and shared-storage rules](binding/types.md#copies-and-shared-storage). JVM container wrappers can share their storage with Godot while individual value-type elements are copied.

## `free`, `queue_free`, and validity

The binding exposes `free()`, `queueFree()`, and `GD.isInstanceValid(...)`. A non-null JVM reference may point to an already freed native object. JVM garbage collection does not replace scene ownership or explicit cleanup of ordinary Godot objects. See [Objects and lifetime](binding/objects.md).

## Script files and reloading

Project scripts attach through `.kt`, `.java`, or `.scala`; dependency scripts use `.gdj`. Registration changes require a full build. `fastBuild` reuses registration for implementation-only edits. GraalVM native images cannot reload classes. See [script files](registration/script-files.md) and [Gradle tasks](gradle-plugin/tasks.md).

## Calling GDScript from JVM code

Use dynamic `call` and `get` with Godot member names on a node with a GDScript attached. These snippets belong inside a node method; the child `Other` defines `heal(amount)` and `health`.

/// tab | Kotlin

```kotlin
val other = getNode(godot.core.NodePath("Other"))
other?.call(godot.core.StringName("heal"), 10)
val health = other?.get(godot.core.StringName("health"))
```

///

/// tab | Java

```java
Node other = getNode(new godot.core.NodePath("Other"));
if (other != null) {
    other.call(new godot.core.StringName("heal"), 10);
    java.lang.Object health = other.get(new godot.core.StringName("health"));
}
```

///

/// tab | Scala

```scala
val other = getNode(new godot.core.NodePath("Other"))
if (other != null) {
  other.call(new godot.core.StringName("heal"), 10)
  val health = other.get(new godot.core.StringName("health"))
}
```

///
