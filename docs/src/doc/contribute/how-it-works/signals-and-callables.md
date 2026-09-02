---
description: The handwritten runtime layer, the generated typed arity families above it, and which generator owns each part of the signal and callable API.
---

# Signals and callables

This page is for maintainers of the typed signal and callable system.
It does not try to document every generated overload.
The goal is to explain the mental model, the responsibilities of each layer, and the places where changes usually belong.

## Start with the model

The whole system is built around one idea:

- Godot is dynamic at the engine boundary.
- the JVM bindings expose a typed, arity-based API on top of that dynamic core.

That means almost every piece in this area lives in one of two layers:

- a small handwritten runtime layer that talks to Godot
- a generated typed layer that expands the same patterns for arities `0` to `MAX_FUNCTION_ARG_COUNT`

If this split stays clear, the code is usually easy to reason about.
If a change starts duplicating behavior across generated families, it is often a sign that the runtime layer should absorb that behavior instead.

## Inheritance and roles

Before looking at generators, it helps to know which types are foundational and which ones are just typed wrappers.

### Callable hierarchy

- `Callable` is the base interface. It is the dynamic contract and exposes the unsafe API such as `callUnsafe(vararg Any?)`, `bindUnsafe(vararg Any?)`, and `callDeferredUnsafe(vararg Any?)`.
- `CallableN` extends `Callable` and adds the safe arity-specific API such as typed `call`, `invoke`, `callDeferred`, and `bind`.
- `MethodCallable` is the handwritten runtime implementation for a Godot object plus a method name.
- `MethodCallableN` extends `MethodCallable` and implements `CallableN`.
- `LambdaCallable<R>` is the handwritten runtime implementation for JVM lambdas.
- `LambdaCallableN` extends `LambdaCallable<R>` and implements `CallableN`.
- `VariantCallable` implements `Callable` directly and represents the engine-facing native callable value.

So the important chains are:

- `MethodCallableN -> MethodCallable -> Callable`
- `LambdaCallableN -> LambdaCallable -> Callable`
- `VariantCallable -> Callable`

### Signal hierarchy

- `Signal` is the handwritten base runtime class.
- `SignalN` extends `Signal` and adds typed `emit`, `connect`, and `disconnect`.

So the signal side is simply:

- `SignalN -> Signal`

### Connector role

`SignalConnector` is intentionally outside both hierarchies.
It is just a helper object that stores one `Signal` plus one `Callable`.
It exists for ergonomics: connect now, keep a handle, disconnect later.

## The runtime layer

The runtime layer is the part that actually knows how to talk to Godot.
Everything generated above it is mostly shape and typing.

### `Signal`

`Signal` is very small on purpose.
It stores:

- the owning Godot `Object`
- the signal `StringName`

Its main operations are simple forwards:

- `emitUnsafe(...)` delegates to `godotObject.emitSignal(...)`
- `connectUnsafe(...)` delegates to `godotObject.connect(...)`
- `disconnectUnsafe(...)` delegates to `godotObject.disconnect(...)`

That is the core signal model.
The generated `SignalN` classes only add typed wrappers around those operations.

### `Callable`

`Callable` is the common engine-facing abstraction.
The important design choice here is that the base contract stays dynamic:

- arguments are passed as `vararg Any?`
- binding is handled dynamically
- deferred calls are still part of the base contract

This mirrors Godot closely and gives the runtime types a common surface.
The typed families are layered on top of this base rather than replacing it.

### `MethodCallable`

`MethodCallable` is the runtime wrapper for:

- one target `Object`
- one method `StringName`
- optional bound arguments

Its job is to bridge a typed method-callable API back to what Godot fundamentally needs: object plus method name.

Important behavior stays here:

- `callUnsafe(...)` calls `target.call(methodName, ...)`
- `callDeferredUnsafe(...)` calls `target.callDeferred(...)`
- `toNativeCallable()` builds a `VariantCallable`
- binding stores extra trailing arguments in `boundArgs`

So when maintaining method callables, think of `MethodCallable` as the real behavior, and `MethodCallableN` as typed sugar plus typed `bind(...)` return types.

### `LambdaCallable` and `LambdaContainer`

`LambdaCallable` is the runtime wrapper for JVM-side functions.
The important part is that it does not hold raw engine state itself.
It delegates the actual invocation work to a `LambdaContainer`.

That split matters:

- `LambdaCallable` is the `Callable` implementation and owns binding/native conversion concerns
- `LambdaContainer` owns JVM invocation and variant conversion

`LambdaCallable` is responsible for:

- `callUnsafe(...)`
- `callDeferredUnsafe(...)`
- `bindUnsafe(...)`
- `toNativeCallable()`
- invalidation through `invalidate()`

`LambdaContainer` is responsible for:

- storing the JVM function
- storing parameter and return converters
- unpacking arguments received from Godot
- invoking the JVM lambda
- supporting cancellation for promise-style helpers

This is why lambda support is a little more involved than method support.
Methods already exist on Godot objects.
JVM lambdas need a container that understands both the JVM function shape and the Godot variant conversion rules.

### `VariantCallable`

`VariantCallable` is the native bridge.
It represents the engine-side callable value and talks to the JNI layer through `Callable.Bridge`.

This is the compatibility point for:

- callables received from Godot
- native callable creation
- dynamic engine interactions that cannot stay purely on the typed JVM side

In practice, all typed callables eventually reduce to this layer when they must cross fully into Godot.

## The generated layer

The generated layer exists because Kotlin cannot express “one typed callable abstraction for every arity” without eventually spelling out those arities.

Instead of maintaining all of that by hand, the API generator expands the families mechanically for every argument count from `0` to `Constraints.MAX_FUNCTION_ARG_COUNT`.

The generated families are:

- `Signal0` to `Signal16`
- `Callable0` to `Callable16`
- `MethodCallable0` to `MethodCallable16`
- `LambdaCallable0` to `LambdaCallable16`
- `LambdaContainer0` to `LambdaContainer16`
- `MethodStringName0` to `MethodStringName16`
- `JvmFunction0` to `JvmFunction16`
- `JvmAction0` to `JvmAction16`
- typed connector extensions for every signal arity

The generated types should stay thin.
They mainly describe:

- generic parameter lists
- typed signatures
- typed `bind(...)` return types
- convenience factories

They should not become a second behavior layer.

## What each generator owns

Three services generate the public surface.
Each one owns a different slice of the same model.

### `CallableGenerationService`

Source:
`kt/api-generator/src/main/kotlin/godot/codegen/services/impl/CallableGenerationService.kt`

This service owns the callable family.
It generates:

- `CallableN`
- `MethodStringNameN`
- `MethodCallableN`
- `LambdaContainerN`
- `LambdaCallableN`
- top-level `methodCallableN(...)`
- top-level `lambdaCallableN(...)`
- function-type `.asCallable()`
- JVM-facing `JvmFunctionN` and `JvmActionN`

This service is mostly about type shape.
It decides:

- how generics are ordered
- how `call`, `invoke`, and `callDeferred` are exposed
- how `bind(...)` reduces arity
- which factories are Kotlin-facing and which ones are Java/Scala-facing

This is also where the current language split is expressed.

Kotlin-facing construction stays idiomatic:

- `lambdaCallableN { ... }`
- `someLambda.asCallable()`
- Kotlin method-reference helpers

Java/Scala-facing construction is additive and explicit:

- `MethodStringNameN`
- `LambdaCallableN.create(...)` through `@JvmName`
- `JvmFunctionN` for returning lambdas
- `JvmActionN` for non-returning lambdas

That split is deliberate.
The binding is still Kotlin-first, but Java and Scala get an explicit path that does not force Kotlin ergonomics to degrade.

### `SignalGenerationService`

Source:
`kt/api-generator/src/main/kotlin/godot/codegen/services/impl/SignalGenerationService.kt`

This service owns the typed signal family.
It generates:

- `SignalN`
- the `signalN()` delegate helper
- the `Object.SignalN("name")` factory extension
- the Java-facing companion `create(...)` entry point through `@JvmName`

Each generated `SignalN` is intentionally simple:

- `emit(...)` forwards to `emitUnsafe(...)`
- `connect(...)` forwards to `connectUnsafe(...)`
- `disconnect(...)` forwards to `disconnectUnsafe(...)`

The companion object handles the declaration story:

- property delegates for Kotlin
- named creation for Java and Scala

So if you are changing how typed signals are declared or exposed, this is the place to look.
If you are changing how signals actually talk to Godot, that belongs back in `Signal`.

### `ConnectorGenerationService`

Source:
`kt/api-generator/src/main/kotlin/godot/codegen/services/impl/ConnectorGenerationService.kt`

This service owns the convenience layer on top of signals.
It generates per-arity extension helpers such as:

- `connectLambda(...)`
- `connectMethod(...)`
- `promise(...)`

These helpers are intentionally not the core signal API.
They are convenience wrappers that create the right callable and connect it immediately.

This is also where the Kotlin-only story is most obvious:

- Kotlin-specific `connectMethod(...)` depends on method references and is `@JvmSynthetic`
- Kotlin-specific `connectLambda(...)` depends on function types and extensions
- JVM-facing overloads are also generated for `connectMethod(...)` and `connectLambda(...)`, using `MethodStringNameN` and `JvmActionN`

Java and Scala do not use these exact helpers.
They build the same flow explicitly with `SignalN.connect(...)`, `MethodCallableN`, `LambdaCallableN`, and optionally `SignalConnector`.

## The full flow

When you read this system from top to bottom, the flow is usually:

1. The runtime layer defines the real engine bridge.
2. the generators expand typed families over that runtime layer.
3. Kotlin gets idiomatic helpers on top of the typed families.
4. Java and Scala get explicit factories that still end in the same runtime objects.

That means a user-facing call like this:

```kotlin
signal.connectLambda { value -> ... }
```

eventually becomes:

1. generated `connectLambda(...)`
2. generated lambda callable creation
3. `LambdaContainerN` invocation wiring
4. `Signal.connectUnsafe(...)`
5. `Object.connect(...)`

And a Java/Scala flow like this:

```java
signal.connect(LambdaCallable1.create(String.class, value -> { ... }));
```

still ends up at the same runtime signal and callable objects.
Only the construction path differs.

## Where the type information comes from

This system works because static type information and runtime converter information are both preserved, but they are preserved in different ways.

### For method callables

Method callables fundamentally reduce to a target object plus a method name.
The typed layer exists to make that pairing safer and nicer.

Kotlin gets method names from method references:

- `SomeType::someMethod`
- cast to `KCallable`
- extract `.name`
- convert to `StringName`

Java and Scala cannot use that same path here, so they use `MethodStringNameN` instead.

That is why `MethodStringNameN` exists:

- it carries the method name explicitly
- it keeps the generics aligned with target type, return type, and parameter types
- it gives Java/Scala a typed construction path without forcing them down to raw strings immediately

It is still only as safe as the typed name provided.
For built-in Godot API methods, pre-made typed constants are the strongest version of that idea.

### For lambda callables

Lambda callables need runtime converters because the JVM lambda has to receive actual typed values after Godot has passed variants across the boundary.

So `LambdaContainer` stores:

- one return converter
- one array of parameter converters
- one JVM function

Kotlin factories use reified generics and `getVariantConverter<T>()`.
Java/Scala factories use explicit `Class` arguments and `getVariantConverter(clazz)`.

That is the bridge between:

- the generic typed API users see
- the runtime variant conversion system Godot actually needs

## Kotlin vs Java/Scala

This area now has a clearer language split than before, and that is worth stating explicitly because it affects maintenance decisions.

### Kotlin path

Kotlin gets the idiomatic surface:

- function types
- extension functions
- property delegates
- method references
- inline reified helper factories

That is why Kotlin has helpers like:

- `signalN()`
- `lambdaCallableN { ... }`
- `.asCallable()`
- `connectLambda(...)`
- `connectMethod(...)`

### Java/Scala path

Java and Scala use the same runtime model, but they need more explicit construction:

- `SignalN.create(...)`
- `MethodCallableN.create(...)`
- `MethodStringNameN`
- `LambdaCallableN.create(...)`
- `JvmFunctionN`
- `JvmActionN`

One practical detail from the current registration pipeline is worth remembering:

- when a Java or Scala class exposes a callable as a registered property, the property should currently use the base `Callable` type rather than `CallableN`

The stored instance can still be a typed `LambdaCallableN` or `MethodCallableN`.
This is only about the property surface that the registration layer sees.

The current design tries to preserve the best Kotlin experience while adding JVM-language support with minimal regression risk.
That is why the Java/Scala API is mostly additive instead of replacing Kotlin-first helpers.

It is also why some helpers are hidden from Java/Scala with `@JvmSynthetic`, while JVM-facing factories are given normal JVM names but intentionally ugly Kotlin names through `@JvmName`.

If you are changing API visibility or names, keep that language split in mind.
It is part of the design, not an accident.

## How code is generated

All three generators follow the same broad pattern:

1. Loop from arity `0` to `Constraints.MAX_FUNCTION_ARG_COUNT`.
2. Use `GenericClassNameInfo` to derive class names, type variables, lambda shapes, and parameter lists.
3. Emit KotlinPoet types and functions for that arity.
4. Write the generated file into the `gen` source set.

This means maintenance usually happens at the pattern level, not per generated type.
If you want to change the behavior of every `SignalN`, you should almost never edit generated output directly.
You change the generator or the runtime class and then regenerate.

## Maintenance rules of thumb

These are the invariants that matter most.

- Arity has to stay aligned across `CallableN`, `MethodCallableN`, `LambdaCallableN`, `LambdaContainerN`, `SignalN`, and connector helpers.
- `bind(...)` semantics must stay consistent across all callable families.
- `MethodStringNameN`, `MethodCallableN`, and Kotlin method-reference helpers must describe the same target/return/parameter shape.
- Java/Scala-facing factories and Kotlin-facing helpers must continue to build the same underlying runtime objects.
- If a change affects how Godot is called, it probably belongs in `Signal`, `MethodCallable`, `LambdaCallable`, `LambdaContainer`, or `VariantCallable`.
- If a change affects only signatures, overloads, typed wrappers, or naming, it probably belongs in a generator.
- If a change feels repetitive across all arities, it belongs in the generators.
- If a change feels behavior-heavy, it probably belongs in the runtime layer.

## Files to read together

If you need to understand or modify this area, these are the most useful files to open side by side:

- `kt/api-generator/src/main/kotlin/godot/codegen/services/impl/CallableGenerationService.kt`
- `kt/api-generator/src/main/kotlin/godot/codegen/services/impl/SignalGenerationService.kt`
- `kt/api-generator/src/main/kotlin/godot/codegen/services/impl/ConnectorGenerationService.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/Callable.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/Signal.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/MethodCallable.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/LambdaCallable.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/VariantCallable.kt`
- `kt/godot-library/godot-extension-library/src/main/kotlin/godot/extension/callback/SignalConnector.kt`

Then, if something still feels abstract, read one generated output file that matches the area you are changing.
That is usually the fastest way to verify that the generator is producing the shape you think it is producing.

## Practical takeaway

The system is larger than the handwritten runtime classes, but conceptually it is still simple:

- Godot stays dynamic underneath.
- the handwritten runtime layer is the only real behavior layer.
- the generated layer expands typed wrappers over that runtime.
- Kotlin gets the nicest surface.
- Java and Scala get an explicit but compatible path.

If you keep those boundaries intact, the system stays maintainable.
