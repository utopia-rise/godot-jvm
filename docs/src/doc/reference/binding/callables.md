---
description: Typed method and lambda callables, MethodStringName, argument binding, dynamic calls, and RPC.
---

# Callables

## `CallableN`

Package: `godot.core`. `Callable0<R>` through `Callable16<R, ...>` encode a return type followed by parameter types. `MethodCallableN` targets a Godot method; `LambdaCallableN` wraps a JVM lambda. `VariantCallable` is the native/dynamic representation.

## Method callables

The target method must be available to Godot. Kotlin helpers take an unbound method reference; Java and Scala factories take a typed method name. Here `Player.onHealthChanged` is a registered one-integer, no-result method.

/// tab | Kotlin

```kotlin
import godot.core.methodCallable1

val handler = methodCallable1(this, Player::onHealthChanged)
```

///

/// tab | Java

```java
import godot.core.MethodCallable1;
import godot.core.MethodStringName1;

var onHealthChangedName =
    new MethodStringName1<Player, Void, Integer>("on_health_changed");
var handler = MethodCallable1.create(
    this, onHealthChangedName
);
```

///

/// tab | Scala

```scala
import godot.core.{MethodCallable1, MethodStringName1}

val onHealthChangedName =
  new MethodStringName1[Player, Void, Integer]("on_health_changed")
val handler = MethodCallable1.create(
  this, onHealthChangedName
)
```

///

## `MethodStringNameN`

Type arguments are owner, return, then parameters. The constructor preserves the supplied string; pass `on_health_changed`, not `onHealthChanged`. Declare a name once for a registered script method. Every method on a generated Godot base class already has a generated `...Name` field, such as `Node.queueFreeName`; use it directly. Built-in no-result method fields use Kotlin `Unit`; let factory inference preserve that type.

`MethodCallableN.createUnsafe(owner, name)` in Java/Scala accepts an untyped string and converts it to `snake_case`; its generic signature is a caller assertion, not proof that the target method matches.

## Lambda callables

Value-returning Java/Scala factories take the return class, parameter classes, then the lambda. Action overloads omit the return class and use `Void` as the callable return type. Kotlin captures types through reified helpers.

/// tab | Kotlin

```kotlin
import godot.core.lambdaCallable2

val format = lambdaCallable2<String, Int, String> { amount, unit ->
    "$amount $unit"
}
```

///

/// tab | Java

```java
import godot.core.LambdaCallable2;

var format = LambdaCallable2.create(
    String.class, Integer.class, String.class,
    (amount, unit) -> amount + " " + unit
);
```

///

/// tab | Scala

```scala
import godot.core.LambdaCallable2

val format = LambdaCallable2.create(
  classOf[String], classOf[Integer], classOf[String],
  (amount: Integer, unit: String) => s"$amount $unit"
)
```

///

Kotlin also converts an existing lambda with `asCallable()` from `godot.core`. Java/Scala use `LambdaCallableN.create`. The argument and return classes must have Godot Variant converters.

## Calling and binding

| Method | Contract |
|---|---|
| `call(args...)` / `invoke(args...)` | Calls with typed arguments and returns `R` |
| `callDeferred(args...)` | Schedules a call during Godot idle processing; no result is returned |
| `bind(trailingArgs...)` | Returns a callable with fewer parameters; bound arguments are appended after future call arguments |
| `unbind(count)` | Returns a `VariantCallable` that ignores trailing arguments supplied by the caller |

/// tab | Kotlin

```kotlin
val text = format.call(3, "coins")
val coins = format.bind("coins")
val moreText = coins.call(5)
```

///

/// tab | Java

```java
String text = format.call(3, "coins");
var coins = format.bind("coins");
String moreText = coins.call(5);
```

///

/// tab | Scala

```scala
val text = format.call(3, "coins")
val coins = format.bind("coins")
val moreText = coins.call(5)
```

///

## Dynamic operations and metadata

| Method | Contract |
|---|---|
| `callUnsafe(args...)` | Dynamic call; result is a Variant-compatible value |
| `callDeferredUnsafe(args...)` | Dynamic deferred call |
| `bindUnsafe(args...)` | Dynamic argument binding |
| `toNativeCallable()` | Native `VariantCallable` representation |
| `isValid()`, `isNull()` | Validity and empty-target checks; not interchangeable |
| `isCustom()`, `isStandard()` | Callable kind |
| `getObject()`, `getObjectId()`, `getMethod()` | Target metadata |
| `getBoundArguments()`, `getBoundArgumentCount()` | Bound argument metadata |
| `rpc(args...)`, `rpcId(peerId, args...)` | Remote invocation of a method with RPC configuration |

An ordinary `call` is local even when the target has `@Rpc`. See [RPC registration](../registration/functions.md#rpc).
