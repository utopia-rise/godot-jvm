---
description: Registering ordinary functions with @Register, overriding Godot virtual functions, handling notifications, and the sixteen-argument limit.
---

# Functions and notifications

Any Kotlin, Java, or Scala function can be registered as long as its
parameters and return type can be converted to a `Variant`. Annotate ordinary
project functions with `@Register`. Compatible overrides of Godot functions
are recognized from the base class.

/// tab | Kotlin
```kotlin
import godot.global.GD

@Script
class RotatingCube : Node3D() {
    @Register
    fun announceReady() {
        GD.print("I am ready!")
    }

    override fun _ready() {
        announceReady()
    }
}
```
///

/// tab | Java
```java
import godot.global.GD;

@Script
public class RotatingCube extends Node3D {
    @Register
    public void announceReady() {
        GD.print("I am ready!");
    }

    @Override
    public void _ready() {
        announceReady();
    }
}
```
///

/// tab | Scala
```scala
import godot.global.GD

@Script
class RotatingCube extends Node3D {
  @Register
  def announceReady(): Unit = {
    GD.print("I am ready!")
  }

  override def _ready(): Unit = {
    announceReady()
  }
}
```
///

## Naming

Function names should follow the usual style of the language you use. For consistency with Godot's style,
your functions are actually registered as `snake_case`.
Therefore, a function called `doSomething()` is usable in GDScript as `do_something()`.

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

Register notification handlers with `@Notification`.

Unlike GDScript and C++, you do not override
[_notification](https://docs.godotengine.org/en/stable/classes/class_object.html#class-object-private-method-notification)
directly. Instead, each handled notification is a regular zero-argument method annotated with the notification
number it handles.

If several methods in the class hierarchy handle the same notification, they are all called. Normal notification
delivery follows Godot's inheritance order, from parent to child. Reversed notification delivery calls them from
child to parent.

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

Notification handlers are not registered as callable Godot methods. In explicit and inferred registration modes,
`@Notification` is enough to select the method. In automatic mode, a method only becomes a notification handler when
the annotation is present.

## Arguments count

Registered functions are limited to `16` arguments. If you want to pass more than 16 parameters in
a function, you need to wrap them in a container (like a custom container class or a `VariantArray`
or `Dictionary`).

## Remote procedure calls

`@Rpc` selects a function for multiplayer replication in the same way `@Register` selects an ordinary function, while
also configuring its networking behavior. Documenting `@Rpc`'s full set of options is out of scope for this page, but
the annotation is used the same way as `@Register`:

/// tab | Kotlin
```kotlin
import godot.annotation.Rpc

@Rpc
fun setHealth(value: Int) {
    health = value
}
```
///

/// tab | Java
```java
import godot.annotation.Rpc;

@Rpc
public void setHealth(int value) {
    health = value;
}
```
///

/// tab | Scala
```scala
import godot.annotation.Rpc

@Rpc
def setHealth(value: Int): Unit = {
  health = value
}
```
///

See the [registration reference](../reference/registration.md) for how function selection changes between modes.
