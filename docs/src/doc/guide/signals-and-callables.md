---
description: Connect signals to react to events and pass callables to Godot APIs.
---

# Signals and callables

Connect [signals](https://docs.godotengine.org/en/stable/getting_started/step_by_step/signals.html) to react to events and pass callables to Godot APIs.

## Connect a built-in signal

The following `Player` example creates a `Timer` in `_ready()` and connects its `timeout` signal to a lambda. The callback calls `heal(1)` every second.

/// tab | Kotlin

```kotlin
import godot.api.Timer
import godot.extension.connectLambda

override fun _ready() {
    val timer = Timer()
    addChild(timer)
    timer.timeout.connectLambda { heal(1) }
    timer.start(1.0)
}
```

///

/// tab | Java

```java
import godot.api.Timer;
import godot.extension.SignalConnectors;

@Override
public void _ready() {
    Timer timer = new Timer();
    addChild(timer);
    SignalConnectors.connectLambda0(timer.getTimeout(), () -> heal(1));
    timer.start(1.0);
}
```

///

/// tab | Scala

```scala
import godot.api.Timer
import godot.extension.SignalConnectors

override def _ready(): Unit = {
  val timer = new Timer()
  addChild(timer)
  SignalConnectors.connectLambda0(timer.getTimeout(), () => heal(1))
  timer.start(1.0)
}
```

///

## Declare a signal

The signal is registered without `@Emit`. This optional annotation names the parameters shown in Godot; here they are `current` and `max`. Import `Emit` from `godot.annotation` and `signal2` (Kotlin) or `Signal2` (Java and Scala) from `godot.core`.

/// tab | Kotlin

```kotlin
@Emit("current", "max")
val healthChanged by signal2<Int, Int>()
```

///

/// tab | Java

```java
@Emit(parameters = {"current", "max"})
public final Signal2<Integer, Integer> healthChanged =
    Signal2.create(this, "healthChanged");
```

///

/// tab | Scala

```scala
@Emit(parameters = Array("current", "max"))
val healthChanged: Signal2[Integer, Integer] =
  Signal2.create(this, "healthChanged")
```

///

The Kotlin delegate derives the owner and member name. In Java and Scala, pass the owner and exact member name to `Signal2.create`. Godot-JVM converts `healthChanged` to `health_changed` for Godot.

`Signal2` accepts two arguments with the declared types. Typed signals catch mismatched argument counts and types at compile time.

## Emit a signal

This emits the current and maximum health:

/// tab | Kotlin

```kotlin
healthChanged.emit(health, 100)
```

///

/// tab | Java

```java
healthChanged.emit(health, 100);
```

///

/// tab | Scala

```scala
healthChanged.emit(health, 100)
```

///

## Connect your signal

The following connections are made in `_ready()`.

### Connect a lambda

Import `SignalConnector` from `godot.extension` when naming the return type. For inline subscriptions, Kotlin provides `connectLambda`, and Java and Scala use `SignalConnectors.connectLambdaN(...)`.

/// tab | Kotlin

```kotlin
val connector = healthChanged.connectLambda { current, max ->
    GD.print("Health changed to $current / $max")
}
```

///

/// tab | Java

```java
SignalConnector connector = SignalConnectors.connectLambda2(
    healthChanged,
    Integer.class,
    Integer.class,
    (current, max) -> GD.print("Health changed to " + current + " / " + max)
);
```

///

/// tab | Scala

```scala
val connector = SignalConnectors.connectLambda2(
  healthChanged,
  classOf[Integer],
  classOf[Integer],
  (current: Integer, max: Integer) => GD.print(s"Health changed to $current / $max")
)
```

///

Keep the returned connector to check or disconnect the subscription. Store it in a field when its lifetime spans several methods. To end the subscription:

/// tab | Kotlin

```kotlin
connector.disconnect()
```

///

/// tab | Java

```java
connector.disconnect();
```

///

/// tab | Scala

```scala
connector.disconnect()
```

///

### Connect a registered method

The following `Player` handler connects in `_ready()`. The target is the current scene instance, `this`. Kotlin uses `connectMethod` from `godot.extension`; Java and Scala use `MethodStringName2` from `godot.core`.

/// tab | Kotlin

```kotlin
@Register
fun onHealthChanged(current: Int, max: Int) {
    GD.print("Health: $current / $max")
}

override fun _ready() {
    healthChanged.connectMethod(this, Player::onHealthChanged)
}
```

///

/// tab | Java

!!! warning "MethodStringNameN takes the Godot name"
    `SignalN.create(...)` converts to `snake_case`; `MethodStringNameN(...)` does not. In Java and Scala, pass `on_health_changed`, the name Godot knows.

```java
@Register
public void onHealthChanged(int current, int max) {
    GD.print("Health: " + current + " / " + max);
}

private final MethodStringName2<Player, Void, Integer, Integer> onHealthChangedName =
    new MethodStringName2<>("on_health_changed");

@Override
public void _ready() {
    SignalConnectors.connectMethod2(
        healthChanged,
        this,
        onHealthChangedName
    );
}
```

///

/// tab | Scala

```scala
@Register
def onHealthChanged(current: Int, max: Int): Unit = {
  GD.print(s"Health: $current / $max")
}

private val onHealthChangedName =
  new MethodStringName2[Player, Void, Integer, Integer]("on_health_changed")

override def _ready(): Unit = {
  SignalConnectors.connectMethod2(
    healthChanged,
    this,
    onHealthChangedName
  )
}
```

///

Kotlin's `connectMethod` takes a method reference. Java and Scala use `SignalConnectors.connectMethod2` with a typed method name. Declare that name once for a script method. Generated Godot base-class methods already provide `...Name` fields, such as `Node.queueFreeName`.

## Pass a callable to Godot

The following `recoverLater()` method schedules a registered method with a [Tween](https://docs.godotengine.org/en/stable/classes/class_tween.html).

/// tab | Kotlin

```kotlin
import godot.core.methodCallable0

@Register
fun announceRecovery() {
    GD.print("Recovery complete")
}

fun recoverLater() {
    val tween = createTween()
    tween.tweenInterval(1.0)
    tween.tweenCallback(methodCallable0(this, Player::announceRecovery))
}
```

///

/// tab | Java

```java
import godot.core.MethodCallable0;
import godot.core.MethodStringName0;

@Register
public void announceRecovery() {
    GD.print("Recovery complete");
}

private final MethodStringName0<Player, Void> announceRecoveryName =
    new MethodStringName0<>("announce_recovery");

public void recoverLater() {
    var tween = createTween();
    tween.tweenInterval(1.0);
    tween.tweenCallback(MethodCallable0.create(
        this, announceRecoveryName
    ));
}
```

///

/// tab | Scala

```scala
import godot.core.{MethodCallable0, MethodStringName0}

@Register
def announceRecovery(): Unit = {
  GD.print("Recovery complete")
}

private val announceRecoveryName =
  new MethodStringName0[Player, Void]("announce_recovery")

def recoverLater(): Unit = {
  val tween = createTween()
  tween.tweenInterval(1.0)
  tween.tweenCallback(MethodCallable0.create(
    this, announceRecoveryName
  ))
}
```

///

!!! note "Scala signal types"
    Use boxed Java types such as `Integer` and `java.lang.Boolean` as signal type arguments. Primitive Scala type arguments may register as untyped Variants.
