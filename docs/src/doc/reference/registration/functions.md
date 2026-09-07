---
description: Method signatures, lifecycle overrides, notification handlers, and RPC registration across the three modes and languages.
---

# Functions, notifications and RPC

## Ordinary functions

A registered function must be public and use [supported parameter/return types](../binding/types.md#registered-signatures). Inferred mode accepts `@Register` or an annotation that implies it; Explicit requires direct `@Register`; Automatic selects compatible public methods, subject to [accessor intent](properties.md#accessors-and-function-intent).

/// tab | Kotlin

```kotlin
import godot.annotation.Register

@Register
fun takeDamage(amount: Int) {}
```

///

/// tab | Java

```java
import godot.annotation.Register;

@Register
public void takeDamage(int amount) {}
```

///

/// tab | Scala

```scala
import godot.annotation.Register

@Register
def takeDamage(amount: Int): Unit = {}
```

///

Godot sees `take_damage(amount)`. Registered names use `snake_case`.

## Godot virtual overrides

Overrides of compatible engine virtual methods such as `_ready` and `_process` are selected in Inferred and Automatic modes. Explicit mode requires `@Register` on the override. The following works in every mode:

/// tab | Kotlin

```kotlin
@Register
override fun _ready() {}
```

///

/// tab | Java

```java
@Register
@Override
public void _ready() {}
```

///

/// tab | Scala

```scala
@Register
override def _ready(): Unit = {}
```

///

## Signature restrictions

- At most 16 parameters per registered function.
- Return types may additionally be `Unit`/`void` for no result.
- JVM collections of enums are a property feature, not a registered function parameter/return representation.
- JVM arrays/varargs and unrelated JVM classes are not substitutes for Godot containers. Use `VariantArray`, a packed array, or a Godot-compatible object.
- Generic type parameters do not supply a concrete Godot signature. Use concrete supported types.
- JVM default arguments do not supply Godot call defaults. Pass the registered arguments explicitly.
- Godot calls methods by their registered name. Give Godot-facing methods distinct names instead of relying on JVM overload resolution.

[Inherited functions](classes.md#inherited-members) are included in effective registration. Unselected methods remain callable from ordinary JVM code. Selected invalid signatures fail registration checks; Automatic can skip incompatible methods before those checks.

## Notifications

`@Notification(value)` associates a public, no-argument, no-result method with a Godot notification ID. It is emitted as a notification handler, not an ordinary callable method. It cannot also be an RPC method. No additional `@Register` is required, including in Explicit mode.

/// tab | Kotlin

```kotlin
import godot.annotation.Notification
import godot.api.Node

@Notification(Node.NOTIFICATION_READY)
fun onReadyNotification() {}
```

///

/// tab | Java

```java
import godot.annotation.Notification;
import godot.api.Node;

@Notification(Node.NOTIFICATION_READY)
public void onReadyNotification() {}
```

///

/// tab | Scala

```scala
import godot.annotation.Notification
import godot.api.Node

@Notification(Node.NOTIFICATION_READY)
def onReadyNotification(): Unit = {}
```

///

## RPC

`@Rpc` supplies RPC configuration. In Inferred mode it also selects the method. In Explicit mode add direct `@Register`; in Automatic mode compatible methods are already selected.

/// tab | Kotlin

```kotlin
import godot.annotation.Register
import godot.annotation.Rpc
import godot.annotation.RpcMode

@Register
@Rpc(rpcMode = RpcMode.ANY)
fun receiveScore(score: Int) {}
```

///

/// tab | Java

```java
import godot.annotation.Register;
import godot.annotation.Rpc;
import godot.annotation.RpcMode;

@Register
@Rpc(rpcMode = RpcMode.ANY)
public void receiveScore(int score) {}
```

///

/// tab | Scala

```scala
import godot.annotation.{Register, Rpc, RpcMode}

@Register
@Rpc(rpcMode = RpcMode.ANY)
def receiveScore(score: Int): Unit = {}
```

///

The annotation configures the method; an ordinary JVM call remains local. See [`@Rpc`](../annotations.md#rpc) for every argument, default, and enum value.

## Notification delivery

`_notification` cannot be overridden in JVM scripts; use `@Notification`. Multiple handlers for the same notification, including inherited handlers, all run. Normal delivery runs from parent to child; reversed delivery, such as `NOTIFICATION_EXIT_TREE`, runs from child to parent.
