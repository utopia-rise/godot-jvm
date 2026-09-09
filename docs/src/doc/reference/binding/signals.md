---
description: Signal factories, typed emission and connections, SignalConnector lifetime, and dynamic signal operations.
---

# Signals

## `SignalN`

Package: `godot.core`. `Signal0` through `Signal16` encode the number and types of emitted arguments. `SignalN` is a handle to a signal on a Godot object; declaring a JVM member alone still follows [registration selection](../registration/signals.md).

/// tab | Kotlin

```kotlin
import godot.core.signal1

val healthChanged by signal1<Int>()
// Inside a method:
// healthChanged.emit(100)
```

///

/// tab | Java

```java
import godot.core.Signal1;

public final Signal1<Integer> healthChanged =
    Signal1.create(this, "healthChanged");
// Inside a method:
// healthChanged.emit(100);
```

///

/// tab | Scala

```scala
import godot.core.Signal1

val healthChanged: Signal1[Integer] = Signal1.create(this, "healthChanged")
// Inside a method:
// healthChanged.emit(100)
```

///

## Operations

| Method | Result/effect |
|---|---|
| `emit(p0, ..., pN)` | Emits arguments checked against the typed signal |
| `connect(callable, flags)` | Connects a compatible typed callable; returns no value |
| `disconnect(callable)` | Disconnects that callable |
| `isConnected(callable)` | Whether the callable is connected |
| `isValid()` | Whether the owner exists and has the signal |
| `hasConnections()` | Whether any connection exists |
| `getConnections()` | Godot connection-list dictionaries |

`flags` defaults to `godot.api.Object.ConnectFlags.DEFAULT`. Other generated flags include `DEFERRED`, `ONE_SHOT`, and `REFERENCE_COUNTED`.

## Method connections

`connectMethod` / `SignalConnectors.connectMethodN` connects a [registered method](../registration/functions.md) and returns a `SignalConnector`. In these snippets, `this` is a `Player` instance with `onHealthChanged` registered and `healthChanged` declared as above.

/// tab | Kotlin

```kotlin
import godot.extension.connectMethod

val connector = healthChanged.connectMethod(this, Player::onHealthChanged)
```

///

/// tab | Java

```java
import godot.extension.SignalConnectors;
import godot.core.MethodStringName1;

var onHealthChangedName =
    new MethodStringName1<Player, Void, Integer>("on_health_changed");
var connector = SignalConnectors.connectMethod1(
    healthChanged, this, onHealthChangedName
);
```

///

/// tab | Scala

```scala
import godot.extension.SignalConnectors
import godot.core.MethodStringName1

val onHealthChangedName =
  new MethodStringName1[Player, Void, Integer]("on_health_changed")
val connector = SignalConnectors.connectMethod1(
  healthChanged, this, onHealthChangedName
)
```

///

`MethodStringNameN` takes the exact Godot name; it does not convert camelCase. Declare it once and reuse it for each connection or callable targeting the same script method. Godot-JVM already generates `...Name` fields for every method on a generated Godot base class, such as `Node.queueFreeName`; use those fields instead of creating a `MethodStringNameN` yourself.

## Lambda connections

A lambda connection has no registered method requirement. Java and Scala supply explicit boxed argument classes. Each helper returns a connected `SignalConnector`.

/// tab | Kotlin

```kotlin
import godot.extension.connectLambda
import godot.global.GD

val connector = healthChanged.connectLambda { health -> GD.print(health) }
```

///

/// tab | Java

```java
import godot.extension.SignalConnectors;
import godot.global.GD;

var connector = SignalConnectors.connectLambda1(
    healthChanged, Integer.class, health -> GD.print(health)
);
```

///

/// tab | Scala

```scala
import godot.extension.SignalConnectors
import godot.global.GD

val connector = SignalConnectors.connectLambda1(
  healthChanged, classOf[Integer], (health: Integer) => GD.print(health)
)
```

///

## `SignalConnector`

Package: `godot.extension`. Holds the signal/callable pair.

| Method | Contract |
|---|---|
| `disconnect()` | Removes the connection |
| `isConnected()` | Checks the connection |
| `isValid()` | Checks both signal and callable validity |
| `connect(flags)` | Connects/reconnects; returns `godot.core.Error` |
| `createUnsafe(signal, callable)` | Creates a connector without connecting it |

Kotlin can omit `flags` on `connect`; Java/Scala pass `Object.ConnectFlags.DEFAULT` explicitly. Retain the connector when disconnection is required later.

## Dynamic signals

`Signal.createUnsafe(owner, name)` creates an untyped handle and converts the name to Godot spelling. `emitUnsafe(args...)`, `connectUnsafe(callable, flags)`, and `disconnectUnsafe(callable)` operate without typed argument checking. `connectUnsafe` returns Godot's connection error code. The owner must actually have the named signal.
