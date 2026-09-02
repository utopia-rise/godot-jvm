---
description: Declaring typed signals and callable targets, then emitting, calling, and connecting them in Kotlin, Java, and Scala.
---

# Signals and callables

A signal represents an event, and a callable supplies the method or lambda that handles it.

## Dynamic and typed APIs

GDScript `Signal` and `Callable` values are typeless and arityless: they do not record an argument count or argument types. Godot therefore checks a connection or call only at runtime:

```gdscript
signal health_changed(current, maximum)

func _ready():
    health_changed.connect(_on_health_changed)

func _on_health_changed(current, maximum):
    print(current, "/", maximum)
```

As a result, a wrong argument count or type is discovered only when the signal emits or the callable runs.

Godot-JVM provides the unsafe equivalent through its typeless, arityless base `Signal` and `Callable` types. Their `Unsafe` methods have the same runtime-only validation as GDScript:

- `Signal.emitUnsafe(...)` and `Signal.connectUnsafe(...)`
- `Callable.callUnsafe(...)`, `Callable.callDeferredUnsafe(...)`, and `Callable.bindUnsafe(...)`

They take a `vararg Any?` argument list and defer validation to runtime. These APIs are unsafe and are not recommended for normal JVM code; use them only when a value arriving from Godot genuinely has no known JVM signature.

The recommended API is the typed `Signal0` through `Signal16` and `Callable0` through `Callable16` families. Their arity and generic parameter types are part of the type itself:

- `emit(...)` replaces `emitUnsafe(...)`
- `connect(...)` replaces `connectUnsafe(...)`
- `call(...)`, `invoke(...)`, and typed `bind(...)` replace their unsafe counterparts

A `Signal2<Int, Int>` can emit exactly two `Int` values and connect only to a matching two-argument callable. The compiler catches a mismatched argument count or type before the call reaches Godot.

!!! warning "Signal parameter count"
    Typed signals and callables currently support zero through sixteen parameters.

Kotlin provides delegate, method-reference, and lambda helpers such as `signal2`, `methodCallable2`, and `connectMethod`. They rely on Kotlin language features. Java and Scala use the same typed runtime families, but construct `SignalN`, `MethodCallableN`, and `LambdaCallableN` explicitly.

## Signals

### Declaring signals

The cross-language baseline is a plain field holding a `SignalN`.
Java and Scala build it with the static factory `SignalN.create(...)`.
That factory is generated for the JVM only, so Kotlin uses the matching `SignalN(...)` builder on the enclosing object instead:

/// tab | Kotlin
```kotlin
val ready = Signal0("ready")
val healthChanged = Signal2<Int, Int>("healthChanged")
```

///

/// tab | Java
```java
Signal0 ready = Signal0.create(this, "ready");
Signal2<Integer, Integer> healthChanged = Signal2.create(this, "healthChanged");
```

///

/// tab | Scala
```scala
val ready: Signal0 = Signal0.create(this, "ready")
val healthChanged: Signal2[Integer, Integer] = Signal2.create(this, "healthChanged")
```
///

All three snippets are written inside a class extending a Godot `Object`, since the signal needs an owner.
For Java and Scala, this is also the normal declaration style.
Make sure the variable name and the string passed to the builder are the same.
Use the source-language name such as `healthChanged`, not a manually converted `snake_case` version.
The signal is registered to Godot from the variable itself, but the signal instance also needs to carry its own name so Godot can identify it correctly.
The conversion to Godot's `snake_case` name happens automatically.

Kotlin also provides a delegate syntax, which is usually the recommended form for Kotlin classes:

```kotlin
@Script
class Player : Node() {
    @Emit("current", "max")
    val healthChanged by signal2<Int, Int>()
}
```

This is lightweight.
The delegate does not store a dedicated `Signal2` instance on the object.
It recreates a wrapper on access from the owning object and the property name.

The delegate factories are `signal0()` through `signal16()`.
That syntax is Kotlin-only: Java and Scala have no equivalent and must use `SignalN.create(...)`.

### Emitting signals

Typed signals expose a typed `emit` function:

/// tab | Kotlin
```kotlin
healthChanged.emit(24, 100)
```

///

/// tab | Java
```java
healthChanged.emit(24, 100);
```

///

/// tab | Scala
```scala
healthChanged.emit(24, 100)
```
///

## Callables

A callable represents a method, a JVM lambda, or a native Godot callable. Construct one when you need to call code indirectly or connect a signal.

### Method callables

Use a method callable when the callback is an existing registered Godot method.

Kotlin and Java/Scala reach that goal differently:

- Kotlin usually uses method references, so `methodCallableN(target, Type::method)` is the most natural form. `methodCallableN` is Kotlin-only, since it relies on Kotlin reflection to read the method name off the reference.
- Java and Scala create a `MethodCallableN` explicitly from a typed method name, with `MethodCallableN.create(target, methodStringName)`.
- For built-in Godot API methods, Java and Scala should prefer the pre-made `MethodStringNameN` fields exposed by engine classes.

For a method you registered yourself:

/// tab | Kotlin
```kotlin
@Script
class UiController : Node() {
    @Register
    fun onHealthChanged(current: Int, max: Int) {
        println("UI update: $current / $max")
    }
}

val controller = UiController()
val callableFromReference: MethodCallable2<Unit, Int, Int> =
    methodCallable2(controller, UiController::onHealthChanged)
```

///

/// tab | Java
```java
@Script
public class UiController extends Node {
    @Register
    public void onHealthChanged(Integer current, Integer max) {
        System.out.println("UI update: " + current + " / " + max);
    }
}

UiController controller = new UiController();
MethodCallable2<Void, Integer, Integer> callableFromName = MethodCallable2.create(
    controller,
    new MethodStringName2<UiController, Void, Integer, Integer>("on_health_changed")
);
```

///

/// tab | Scala
```scala
@Script
class UiController extends Node {
  @Register
  def onHealthChanged(current: Integer, max: Integer): Unit = {
    println(s"UI update: $current / $max")
  }
}

val controller = new UiController()
val callableFromName: MethodCallable2[Void, Integer, Integer] = MethodCallable2.create(
  controller,
  new MethodStringName2[UiController, Void, Integer, Integer]("on_health_changed")
)
```
///

!!! warning "MethodStringNameN takes the Godot name"
    Unlike `SignalN.create(...)`, the `MethodStringNameN(...)` constructor does not convert the string for you. Pass the `snake_case` name Godot knows the method by, so `on_health_changed` and not `onHealthChanged`.

For built-in Godot API methods, use the pre-made typed method-name fields exposed by engine classes.

/// tab | Kotlin
```kotlin
val sprite = AnimatedSprite2D()

val pauseCallable: MethodCallable0<Unit> = methodCallable0(sprite, AnimatedSprite2D::pause)
```

///

/// tab | Java
```java
AnimatedSprite2D sprite = new AnimatedSprite2D();

var pauseCallable = MethodCallable0.create(sprite, AnimatedSprite2D.pauseName);
var playCallable = MethodCallable3.create(sprite, AnimatedSprite2D.playName);
```

///

/// tab | Scala
```scala
val sprite = new AnimatedSprite2D()

val pauseCallable = MethodCallable0.create(sprite, AnimatedSprite2D.pauseName)
val playCallable = MethodCallable3.create(sprite, AnimatedSprite2D.playName)
```
///

Those pre-made fields carry the return type declared by the Kotlin API, so a Godot method returning nothing yields a `MethodCallableN<kotlin.Unit, ...>` rather than a `MethodCallableN<Void, ...>`. Letting the compiler infer the callable type, as above, avoids having to spell that out in Java or Scala.

The fallback `MethodCallableN.createUnsafe(target, "methodName")` form still exists, but it drops back to string-based runtime checks. Use it only when you cannot express the callable with a typed helper.

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

Kotlin can also turn a lambda it already holds into a callable with `asCallable()`. This helper is Kotlin-only; Java and Scala have to go back through `LambdaCallableN.create(...)`.

```kotlin
val printHealth = { current: Int, max: Int ->
    println("Lambda saw $current / $max")
}.asCallable()
```

If you expose one of those Java or Scala callables as a registered property, prefer the base `Callable` type for the property itself. The stored value can still be a `LambdaCallableN`, but the property surface should currently stay at `Callable`.

### Variant callables

`VariantCallable` is the native, fully dynamic callable wrapper. It is useful when a callable comes from Godot itself and not from the typed APIs shown above. In user code, prefer the typed families when you know the signature.

### Calling and binding typed callables

Each typed callable exposes `call(...)`, `invoke(...)`, `callDeferred(...)`, and `bind(...)`. Reuse the `format` callable from the examples above:

/// tab | Kotlin
```kotlin
val result = format(24, "HP")
val fixedUnit = format.bind("HP")

println(result)        // 24 HP
println(fixedUnit(10)) // 10 HP
```

///

/// tab | Java
```java
String result = format.call(24, "HP");
Callable1<String, Integer> fixedUnit = format.bind("HP");

System.out.println(result);             // 24 HP
System.out.println(fixedUnit.call(10)); // 10 HP
```

///

/// tab | Scala
```scala
val result = format.call(24, "HP")
val fixedUnit = format.bind("HP")

println(result)             // 24 HP
println(fixedUnit.call(10)) // 10 HP
```
///

`bind(...)` always binds arguments from the right and returns a callable with a smaller arity.

## Connecting signals and callables

Connect a signal to a callable with a matching signature.

/// tab | Kotlin
```kotlin
val callable: Callable2<Unit, Int, Int> = ...

healthChanged.connect(
    callable
)
```

///

/// tab | Java
```java
Callable2<Void, Integer, Integer> callable = ...;

healthChanged.connect(
    callable
);
```

///

/// tab | Scala
```scala
val callable: Callable2[Void, Integer, Integer] = ...

healthChanged.connect(
  callable
)
```
///

## SignalConnector

`SignalConnector` is a small helper around one `Signal` plus one `Callable`.

It exists for the cases where you want a reusable connection handle instead of just calling `signal.connect(callable)` directly.
That makes it easy to:

- `connect()`
- `disconnect()`
- `isConnected()`
- `isValid()`

### Create one from a method

Kotlin provides `connectMethod`, which creates the callable, connects it immediately, and returns a `SignalConnector`.
`connectMethod` is Kotlin-only, since it takes a method reference.
Java and Scala reach the same result through the arity-specific `SignalConnectors.connectMethodN(...)` with a pre-made typed method name:

/// tab | Kotlin
```kotlin
val finished = Signal0("finished")
val sprite = AnimatedSprite2D()

val connector = finished.connectMethod(sprite, AnimatedSprite2D::pause)

connector.isConnected()
connector.disconnect()
```

///

/// tab | Java
```java
Signal0 finished = Signal0.create(this, "finished");
AnimatedSprite2D sprite = new AnimatedSprite2D();

SignalConnector connector = SignalConnectors.connectMethod0(
    finished,
    sprite,
    AnimatedSprite2D.pauseName
);

connector.isConnected();
connector.disconnect();
```

///

/// tab | Scala
```scala
val finished: Signal0 = Signal0.create(this, "finished")
val sprite = new AnimatedSprite2D()

val connector = SignalConnectors.connectMethod0(
  finished,
  sprite,
  AnimatedSprite2D.pauseName
)

connector.isConnected()
connector.disconnect()
```
///

### Create one from a lambda

For inline subscriptions, Kotlin provides `connectLambda`, and Java and Scala use `SignalConnectors.connectLambdaN(...)`.
Under the hood both create a typed `LambdaCallableN`, connect it, and return a `SignalConnector`.

/// tab | Kotlin
```kotlin
val connector = healthChanged.connectLambda { current, max ->
    println("Health changed to $current / $max")
}
```

///

/// tab | Java
```java
SignalConnector connector = SignalConnectors.connectLambda2(
    healthChanged,
    Integer.class,
    Integer.class,
    (current, max) -> System.out.println("Health changed to " + current + " / " + max)
);
```

///

/// tab | Scala
```scala
val connector = SignalConnectors.connectLambda2(
  healthChanged,
  classOf[Integer],
  classOf[Integer],
  (current: Integer, max: Integer) => println(s"Health changed to $current / $max")
)
```
///

This avoids having to rebuild the same callable manually later or keep the raw signal/callable pair around yourself.

## Naming

For consistency with Godot, signals are registered to Godot in `snake_case`.
For example, a property named `healthChanged` is exposed to Godot as `health_changed`.
When you create a signal wrapper manually with `SignalN.create(...)` in Java or Scala, or with `SignalN(...)` in Kotlin, pass the original property name.
The wrapper converts it to the Godot name automatically.

For the handwritten runtime layer underneath these typed families, and how the generated arities are produced, see
[Signals and callables internals](../contribute/how-it-works/signals-and-callables.md).
