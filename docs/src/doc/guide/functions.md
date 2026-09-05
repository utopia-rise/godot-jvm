---
description: Registering ordinary functions with @Register, overriding Godot virtual functions, handling notifications, and the sixteen-argument limit.
---

# Functions and notifications

Add `@Register` to a public, non-generic function that Godot needs to call. Its parameters and return value must convert to Godot `Variant` values. Overrides of Godot callbacks are recognized automatically.

Add this method to `Player` alongside its `health` property and `healthChanged` signal:

/// tab | Kotlin
```kotlin
@Register
fun heal(amount: Int) {
    health = (health + amount).coerceAtMost(100)
    healthChanged.emit(health, 100)
}
```
///
/// tab | Java
```java
@Register
public void heal(int amount) {
    health = Math.min(health + amount, 100);
    healthChanged.emit(health, 100);
}
```
///
/// tab | Scala
```scala
@Register
def heal(amount: Int): Unit = {
  health = Math.min(health + amount, 100)
  healthChanged.emit(health, 100)
}
```
///

## Naming

Write function names in your language's usual style. Godot-JVM registers `heal()` as `heal()` and `takeDamage()` as `take_damage()` in GDScript.

## Virtual functions and Godot overrides

Virtual functions such as `_ready`, `_process`, and `_physics_process` are
declared as overridable functions. Override one to provide its behavior.
Because it is already a Godot function, the inherited declaration identifies
it without an additional `@Register`. Do not call these methods yourself;
Godot calls them at the appropriate time.

/// tab | Kotlin
```kotlin
override fun _process(delta: Double) {
    // Update this node each frame.
}
```
///

/// tab | Java
```java
@Override
public void _process(double delta) {
    // Update this node each frame.
}
```
///

/// tab | Scala
```scala
override def _process(delta: Double): Unit = {
  // Update this node each frame.
}
```
///

## Notifications

Godot exposes notifications through the overridable `_notification` method. Godot-JVM instead uses custom, zero-argument methods annotated with `@Notification` and the notification number they handle.

If several methods in the class hierarchy handle the same notification, they are all called. Normal notification
delivery follows Godot's inheritance order, from parent to child. For teardown notifications such as `NOTIFICATION_EXIT_TREE`, Godot reverses the order: the most-derived class's handler runs first.

/// tab | Kotlin
```kotlin
import godot.annotation.Notification
import godot.api.Node

@Notification(Node.NOTIFICATION_READY)
fun onReadyNotification() {
    // ...
}
```
///

/// tab | Java
```java
import godot.annotation.Notification;
import godot.api.Node;

@Notification(Node.NOTIFICATION_READY)
public void onReadyNotification() {
    // ...
}
```
///

/// tab | Scala
```scala
import godot.annotation.Notification
import godot.api.Node

@Notification(Node.NOTIFICATION_READY)
def onReadyNotification(): Unit = {
    // ...
}
```
///

## Argument limit

Registered functions accept at most 16 arguments. Group additional values in a Godot-compatible container, such as a `VariantArray` or `Dictionary`.

## Remote procedure calls

Use `@Rpc` to register a remote procedure call and configure its networking behavior. In the default registration mode, it also registers the function:

/// tab | Kotlin
```kotlin
import godot.annotation.Rpc

@Rpc
fun synchronizeHealth(value: Int) {
    health = value
}
```
///

/// tab | Java
```java
import godot.annotation.Rpc;

@Rpc
public void synchronizeHealth(int value) {
    health = value;
}
```
///

/// tab | Scala
```scala
import godot.annotation.Rpc

@Rpc
def synchronizeHealth(value: Int): Unit = {
  health = value
}
```
///
