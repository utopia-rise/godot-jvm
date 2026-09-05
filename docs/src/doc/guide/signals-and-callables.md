---
description: Declare and emit a signal, connect methods or lambdas, and create typed callables in Kotlin, Java, and Scala.
---

# Signals and callables

Use a signal to announce changes in your script, and a callable to handle them. Use the two-argument `healthChanged` signal on `Player`.

## Declare a signal

`@Emit` names the parameters shown in Godot; here they are `current` and `max`.

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

!!! note "Scala primitives in signal types"
    Use the boxed Java types (`Integer`, `java.lang.Boolean`, ...) as signal type arguments, as in the example above. Scala compiles a primitive type argument such as `Boolean` to `Object` in the class file, and that is the only type information Godot-JVM can read at build time. A signal declared as `Signal1[Boolean]` still emits and connects normally, but Godot registers its argument as an untyped Variant, so the editor's signal dialog and `get_signal_list()` show no type for it. An import alias such as `import java.lang.{Boolean => JBoolean}` avoids repeating the package name.

`Signal2` accepts two arguments with the declared types. Typed signals catch mismatched argument counts and types at compile time.

## Emit a signal

Emit the current and maximum health after changing the player's health:

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

## Connect a handler

### Connect a registered method

Add a registered handler to `Player`, then connect it in `_ready()`. The target here is the current scene instance, `this`.

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
```java
@Register
public void onHealthChanged(int current, int max) {
    GD.print("Health: " + current + " / " + max);
}

@Override
public void _ready() {
    SignalConnectors.connectMethod2(
        healthChanged,
        this,
        new MethodStringName2<Player, Void, Integer, Integer>("on_health_changed")
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

override def _ready(): Unit = {
  SignalConnectors.connectMethod2(
    healthChanged,
    this,
    new MethodStringName2[Player, Void, Integer, Integer]("on_health_changed")
  )
}
```
///

Kotlin's `connectMethod` takes a method reference. Java and Scala use `SignalConnectors.connectMethod2` with a typed method name.

!!! warning "MethodStringNameN takes the Godot name"
    Unlike `SignalN.create(...)`, the `MethodStringNameN(...)` constructor does not convert the string. Pass `on_health_changed`, the `snake_case` name Godot knows, rather than `onHealthChanged`.

### Connect a lambda

For inline subscriptions, Kotlin provides `connectLambda`, and Java and Scala use `SignalConnectors.connectLambdaN(...)`.

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

## Callables on their own

Create a callable when a Godot API expects a callback. A method callable targets a registered method; these snippets use the current `Player` instance and its `onHealthChanged` handler:

/// tab | Kotlin
```kotlin
val handler = methodCallable2(this, Player::onHealthChanged)
```
///
/// tab | Java
```java
var handler = MethodCallable2.create(
    this,
    new MethodStringName2<Player, Void, Integer, Integer>("on_health_changed")
);
```
///
/// tab | Scala
```scala
val handler = MethodCallable2.create(
  this,
  new MethodStringName2[Player, Void, Integer, Integer]("on_health_changed")
)
```
///

For built-in methods, Java and Scala can use generated fields such as `AnimatedSprite2D.pauseName`. Let the compiler infer the callable type; generated methods with no return value use `kotlin.Unit`.

### Lambda callables

Use a lambda callable when the callback only exists on the JVM side and is not a registered Godot method.

- Kotlin usually uses `lambdaCallableN { ... }` or `.asCallable()`. Both are Kotlin-only, since they read the argument and return types from Kotlin's reified generics.
- Java and Scala use `LambdaCallableN.create(...)` and provide explicit JVM classes for arguments and return values.

For a callable with a return value:

/// tab | Kotlin
```kotlin
val format = lambdaCallable2<String, Int, String> { amount, unit ->
    "$amount $unit"
}
```

///

/// tab | Java
```java
LambdaCallable2<String, Integer, String> format = LambdaCallable2.create(
    String.class,
    Integer.class,
    String.class,
    (amount, unit) -> amount + " " + unit
);
```

///

/// tab | Scala
```scala
val format = LambdaCallable2.create(
  classOf[String],
  classOf[Integer],
  classOf[String],
  (amount: Integer, unit: String) => s"$amount $unit"
)
```
///

In Kotlin, convert an existing lambda with `asCallable()`:

```kotlin
val printHealth = { current: Int, max: Int ->
    GD.print("Lambda saw $current / $max")
}.asCallable()
```

### Calling and binding typed callables

Each typed callable provides `call(...)`, `invoke(...)`, `callDeferred(...)`, and `bind(...)`. Reuse the `format` callable from the examples above:

/// tab | Kotlin
```kotlin
val result = format(24, "HP")
val fixedUnit = format.bind("HP")

GD.print(result)        // 24 HP
GD.print(fixedUnit(10)) // 10 HP
```

///

/// tab | Java
```java
String result = format.call(24, "HP");
Callable1<String, Integer> fixedUnit = format.bind("HP");

GD.print(result);             // 24 HP
GD.print(fixedUnit.call(10)); // 10 HP
```

///

/// tab | Scala
```scala
val result = format.call(24, "HP")
val fixedUnit = format.bind("HP")

GD.print(result)             // 24 HP
GD.print(fixedUnit.call(10)) // 10 HP
```
///

`bind(...)` always binds arguments from the right and returns a callable with a smaller arity.

## Dynamic API

Use `Signal.emitUnsafe`, `Signal.connectUnsafe`, or the `Callable` methods ending in `Unsafe` when a signature is known only at runtime. `VariantCallable` wraps native dynamic callables. Prefer typed signals and callables when you know the signature.
