---
description: Equivalent GDScript, Kotlin, Java, and Scala syntax for common Godot scripting tasks.
---

# GDScript to Kotlin, Java and Scala

Compare common GDScript patterns with their JVM equivalents. These examples use the default Inferred registration mode.

## Declaring a script class

/// tab | GDScript
```gdscript
extends Node

class_name Player
```
///
/// tab | Kotlin
```kotlin
@Script
class Player : Node() {
}
```
///
/// tab | Java
```java
@Script
public class Player extends Node {
}
```
///
/// tab | Scala
```scala
@Script
class Player extends Node {
}
```
///

In Inferred mode, extending a Godot class does not register the script by itself; add `@Script`.

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

Use `@Visible` to register a property without showing it in the Inspector. [Property hints](property-hints.md) table lists annotations for sliders, file pickers, and other controls.

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
public final Signal2<Integer, Integer> healthChanged = Signal2.create(this, "healthChanged");

@Override
public void _ready() {
    SignalConnectors.connectMethod2(healthChanged, this, new MethodStringName2<Player, Void, Integer, Integer>("on_health_changed"));
}

@Register
public void onHealthChanged(int current, int max) {
}
```
///
/// tab | Scala
```scala
val healthChanged: Signal2[Integer, Integer] = Signal2.create(this, "healthChanged")

override def _ready(): Unit = {
  SignalConnectors.connectMethod2(healthChanged, this, new MethodStringName2[Player, Void, Integer, Integer]("on_health_changed"))
}

@Register
def onHealthChanged(current: Int, max: Int): Unit = {
}
```
///

The typed JVM signal carries its argument count and types, allowing the compiler to check calls to `emit`.

## Naming: camelCase in your code, snake_case in Godot

/// tab | GDScript
```gdscript
@export var move_speed: float
func take_damage(amount):
    pass
```
///
/// tab | Kotlin
```kotlin
@Export
var moveSpeed: Float = 0f

@Register
fun takeDamage(amount: Int) {
}
```
///
/// tab | Java
```java
@Export
public float moveSpeed = 0f;

@Register
public void takeDamage(int amount) {
}
```
///
/// tab | Scala
```scala
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

These checks also work with your own Godot subclasses.

## Instantiating a script class

/// tab | GDScript
```gdscript
var instance = Player.new()
```
///
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

## Loading resources

/// tab | GDScript
```gdscript
var scene = preload("res://player.tscn")
var other = load("res://other.tscn")
```
///
/// tab | Kotlin
```kotlin
val other = GD.load<PackedScene>("res://other.tscn")
```
///
/// tab | Java
```java
PackedScene other = GD.load("res://other.tscn");
```
///
/// tab | Scala
```scala
val other = GD.load[PackedScene]("res://other.tscn")
```
///

`GD.load()` loads a resource at runtime. GDScript's compile-time `preload()` has no JVM equivalent.
