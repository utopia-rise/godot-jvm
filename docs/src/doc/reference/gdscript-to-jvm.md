---
description: A side-by-side lookup of common GDScript syntax against its Kotlin, Java, and Scala equivalent in Godot-JVM, with links to the full guide for each.
---

# GDScript to Kotlin, Java and Scala

This page is a lookup table, not a tutorial. Each row links to the guide page that explains the
full rule; read this page to find the row you need, then follow the link for the details.

## Declaring a script class

/// tab | GDScript
```gdscript
extends Node3D

class_name RotatingCube
```
///
/// tab | Kotlin
```kotlin
@Script
class RotatingCube : Node3D() {
}
```
///
/// tab | Java
```java
@Script
public class RotatingCube extends Node3D {
}
```
///
/// tab | Scala
```scala
@Script
class RotatingCube extends Node3D {
}
```
///

`@Script` is required; there is no implicit registration from extending a Godot class alone. See
[Classes](../guide/classes.md).

## Exported properties

/// tab | GDScript
```gdscript
@export var speed: float = 2.0
```
///
/// tab | Kotlin
```kotlin
@Export
var speed: Float = 2f
```
///
/// tab | Java
```java
@Export
public float speed = 2f;
```
///
/// tab | Scala
```scala
@Export
var speed: Float = 2f
```
///

See [Properties and the Inspector](../guide/properties.md) for `@Visible` (registration without an
Inspector row), and [Property hints](property-hints.md) for range sliders, file pickers, and the rest.

## Functions Godot calls on your script

/// tab | GDScript
```gdscript
func _ready():
    pass

func announce_ready():
    pass
```
///
/// tab | Kotlin
```kotlin
override fun _ready() {
}

@Register
fun announceReady() {
}
```
///
/// tab | Java
```java
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
override def _ready(): Unit = {
}

@Register
def announceReady(): Unit = {
}
```
///

Godot's own callbacks (`_ready`, `_process`, `_physics_process`, ...) are recognized from the
override alone. An ordinary function you want Godot or another script to call needs `@Register`.
See [Functions and notifications](../guide/functions.md).

## Signals

/// tab | GDScript
```gdscript
signal health_changed(current, max)

func _ready():
    health_changed.connect(_on_health_changed)

func _on_health_changed(current, max):
    pass
```
///
/// tab | Kotlin
```kotlin
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
Signal2<Integer, Integer> healthChanged = Signal2.create(this, "healthChanged");

private static final MethodStringName2<Player, Void, Integer, Integer> ON_HEALTH_CHANGED =
    new MethodStringName2<>("on_health_changed");

@Override
public void _ready() {
    SignalConnectors.connectMethod2(healthChanged, this, ON_HEALTH_CHANGED);
}

@Register
public void onHealthChanged(Integer current, Integer max) {
}
```
///
/// tab | Scala
```scala
val healthChanged: Signal2[Integer, Integer] = Signal2.create(this, "healthChanged")

private val onHealthChangedName = new MethodStringName2[Player, Void, Integer, Integer]("on_health_changed")

override def _ready(): Unit = {
  SignalConnectors.connectMethod2(healthChanged, this, onHealthChangedName)
}

@Register
def onHealthChanged(current: Integer, max: Integer): Unit = {
}
```
///

GDScript signals are dynamically typed and checked at runtime; Godot-JVM signals carry their arity
and argument types in the type itself. See [Signals and callables](../guide/signals-and-callables.md).

## Naming: camelCase in your code, snake_case in Godot

/// tab | GDScript
```gdscript
@export var move_speed: float
func take_damage(amount):
    pass
```
///
/// tab | Kotlin / Java / Scala
```kotlin
@Export
var moveSpeed: Float = 0f

@Register
fun takeDamage(amount: Int) {
}
```
///

Write properties and functions in your language's normal style; Godot-JVM registers them to Godot
in `snake_case` automatically. `moveSpeed` becomes `move_speed`, `takeDamage` becomes `take_damage`.
This applies uniformly to properties, functions, and signals.

## Type checks

/// tab | GDScript
```gdscript
if parent is CollisionShape3D:
    parent.shape = BoxShape3D.new()
```
///
/// tab | Kotlin
```kotlin
if (parent is CollisionShape3D) {
    parent.setShape(BoxShape3D())
}
```
///
/// tab | Java
```java
if (parent instanceof CollisionShape3D collisionShape) {
    collisionShape.setShape(new BoxShape3D());
}
```
///
/// tab | Scala
```scala
parent match {
  case collisionShape: CollisionShape3D =>
    collisionShape.setShape(new BoxShape3D())
  case _ =>
}
```
///

See [Working with Godot types](../guide/godot-types.md#instance-checks).

## Instantiating a script class

/// tab | GDScript
```gdscript
var instance = MyScript.new()
```
///
/// tab | Kotlin / Java / Scala
```kotlin
val instance = MyScriptClass()
```
///

Works the same from GDScript calling into a JVM class, provided the JVM class has a public
zero-argument constructor — Godot cannot call a constructor that takes arguments. See
[Constructors](../guide/classes.md#constructors).

## Enums

/// tab | GDScript
```gdscript
enum Element { FIRE, WATER, EARTH }
@export var element: Element = Element.FIRE
```
///
/// tab | Kotlin
```kotlin
enum class Element { FIRE, WATER, EARTH }

@Export
var element = Element.FIRE
```
///
/// tab | Java
```java
public enum Element { FIRE, WATER, EARTH }

@Export
public Element element = Element.FIRE;
```
///
/// tab | Scala
```scala
enum Element extends java.lang.Enum[Element] {
  case FIRE, WATER, EARTH
}

@Export
var element: Element = Element.FIRE
```
///

An exported enum-typed property becomes an Inspector dropdown automatically in all three languages.
See [Enums, bitfields and flags](../guide/enums-and-bitfields.md).

## Loading resources

/// tab | GDScript
```gdscript
var scene = preload("res://player.tscn")
var other = load("res://other.tscn")
```
///
/// tab | Kotlin / Java / Scala
```kotlin
val other = GD.load("res://other.tscn")
```
///

`load()` is available through the `GD` singleton; `preload()` has no equivalent, since it depends
on GDScript's compile-time constant folding. See [Renamed symbols and global functions](api-mapping.md#global-functions).

## What this table leaves out

Node and scene-tree access (`$NodePath`, `get_node()`, the `@onready` pattern) is not covered here
yet — that needs its own guide rather than a table row. Multiplayer RPCs and calling GDScript from
a JVM class and back are likewise short on dedicated guide coverage today; see
[Remote procedure calls](../guide/functions.md#remote-procedure-calls) for what exists so far.
