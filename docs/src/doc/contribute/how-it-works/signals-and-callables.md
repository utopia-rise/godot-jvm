---
description: The handwritten runtime layer, the generated typed arity families above it, and which generator owns each part of the signal and callable API.
---

# Signals and callables

Signals and callables share a dynamic runtime layer and generated typed APIs. This chapter explains their responsibilities and where to make changes.

## Start with the model

Godot is dynamic at the engine boundary. The JVM API adds argument counts and types through two layers:

- Handwritten runtime classes communicate with Godot.
- Generated classes provide typed signatures for arities `0` through `MAX_FUNCTION_ARG_COUNT`.

Put behavior shared by all arities in the runtime layer. Generators should describe signatures and forward calls.

## Inheritance and roles

The handwritten types implement runtime behavior. Generated types add argument counts and generic signatures.

### Callable hierarchy

- `Callable` is the base interface. It is the dynamic contract and exposes the unsafe API such as `callUnsafe(vararg Any?)`, `bindUnsafe(vararg Any?)`, and `callDeferredUnsafe(vararg Any?)`.
- `CallableN` extends `Callable` and adds the safe arity-specific API such as typed `call`, `invoke`, `callDeferred`, and `bind`.
- `MethodCallable` is the handwritten runtime implementation for a Godot object plus a method name.
- `MethodCallableN` extends `MethodCallable` and implements `CallableN`.
- `LambdaCallable<R>` is the handwritten runtime implementation for JVM lambdas.
- `LambdaCallableN` extends `LambdaCallable<R>` and implements `CallableN`.
- `VariantCallable` implements `Callable` directly and represents the engine-facing native callable value.

### Signal hierarchy

- `Signal` is the handwritten base runtime class.
- `SignalN` extends `Signal` and adds typed `emit`, `connect`, and `disconnect`.

### Connector role

`SignalConnector` holds a `Signal` and a `Callable`. It provides a reusable handle for connecting, checking, and disconnecting the pair, independently of either inheritance hierarchy.

## The runtime layer

The runtime layer calls Godot and handles conversion, binding, and invocation. Generated classes add typed signatures to these operations.

### `Signal`

`Signal` stores:

- the owning Godot `Object`
- the signal `StringName`

Its main operations are simple forwards:

- `emitUnsafe(...)` delegates to `godotObject.emitSignal(...)`
- `connectUnsafe(...)` delegates to `godotObject.connect(...)`
- `disconnectUnsafe(...)` delegates to `godotObject.disconnect(...)`

Generated `SignalN` classes add typed wrappers around these operations.

### `Callable`

`Callable` defines the dynamic contract: `vararg Any?` arguments, runtime binding, and deferred calls. All callable implementations share this contract; generated families add compile-time signatures.

### `MethodCallable`

`MethodCallable` stores the target `Object`, method `StringName`, and optional bound arguments. It implements:

- `callUnsafe(...)` through `target.call(...)`.
- `callDeferredUnsafe(...)` through `target.callDeferred(...)`.
- `toNativeCallable()` by creating a `VariantCallable`.
- Argument binding through trailing `boundArgs`.

`MethodCallableN` adds typed calls and return types for `bind(...)`.

### `LambdaCallable` and `LambdaContainer`

`LambdaCallable` handles binding, native conversion, deferred calls, and invalidation. It delegates JVM invocation to a `LambdaContainer`.

The container stores the function and its parameter and return converters. It unpacks Godot arguments, invokes the JVM lambda, and supports cancellation for promise helpers. This separation lets the callable manage engine integration while the container manages typed invocation.

### `VariantCallable`

`VariantCallable` represents a native Godot callable and communicates through `Callable.Bridge`. It handles callables received from Godot and native conversion of JVM callables.

## The generated layer

The API generator emits a separate typed family for each argument count from `0` to `Constraints.MAX_FUNCTION_ARG_COUNT`. This keeps signatures consistent without maintaining every arity by hand.

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

Generated types define:

- generic parameter lists
- typed signatures
- typed `bind(...)` return types
- convenience factories

Keep shared behavior in the runtime layer.

## What each generator owns

Three services generate the typed API.

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

It controls:

- how generics are ordered
- how `call`, `invoke`, and `callDeferred` are exposed
- how `bind(...)` reduces arity
- which factories are Kotlin-facing and which ones are Java/Scala-facing

Kotlin construction uses:

- `lambdaCallableN { ... }`
- `someLambda.asCallable()`
- Kotlin method-reference helpers

Java and Scala construction uses:

- `MethodStringNameN`
- `LambdaCallableN.create(...)` through `@JvmName`
- `JvmFunctionN` for returning lambdas
- `JvmActionN` for non-returning lambdas

Both construction paths produce the same runtime objects.

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

The companion object provides:

- property delegates for Kotlin
- named creation for Java and Scala

Change this generator for declaration syntax. Change `Signal` for engine interactions.

### `ConnectorGenerationService`

Source:
`kt/api-generator/src/main/kotlin/godot/codegen/services/impl/ConnectorGenerationService.kt`

This service owns the convenience layer on top of signals.
It generates per-arity extension helpers such as:

- `connectLambda(...)`
- `connectMethod(...)`
- `promise(...)`

These helpers create a callable and connect it immediately.

The generated entry points differ by language:

- Kotlin-specific `connectMethod(...)` depends on method references and is `@JvmSynthetic`
- Kotlin-specific `connectLambda(...)` depends on function types and extensions
- JVM-facing overloads are also generated for `connectMethod(...)` and `connectLambda(...)`, using `MethodStringNameN` and `JvmActionN`

Java and Scala can use the generated `SignalConnectors` methods or construct a callable and pass it to `SignalN.connect(...)` directly.

## The full flow

The layers compose in this order:

1. The runtime layer defines the real engine bridge.
2. The generators expand typed families over that runtime layer.
3. Kotlin gets idiomatic helpers on top of the typed families.
4. Java and Scala get explicit factories that still end in the same runtime objects.

For example:

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

uses the same runtime signal and callable objects.

## Where the type information comes from

Generic signatures provide compile-time checks. Runtime converters translate values crossing the Godot boundary.

### For method callables

A method callable identifies a target object and method name. The typed layer associates that name with a signature.

Kotlin gets method names from method references:

- `SomeType::someMethod`
- cast to `KCallable`
- extract `.name`
- convert to `StringName`

Java and Scala cannot use that same path here, so they use `MethodStringNameN` instead.

`MethodStringNameN`:

- it carries the method name explicitly
- it keeps the generics aligned with target type, return type, and parameter types
- it gives Java/Scala a typed construction path without forcing them down to raw strings immediately

A handwritten typed name must match the actual method signature. Prefer generated constants for built-in Godot methods.

### For lambda callables

Lambda callables need runtime converters because the JVM lambda has to receive actual typed values after Godot has passed variants across the boundary.

So `LambdaContainer` stores:

- one return converter
- one array of parameter converters
- one JVM function

Kotlin factories use reified generics and `getVariantConverter<T>()`.
Java/Scala factories use explicit `Class` arguments and `getVariantConverter(clazz)`.

Both paths supply the converters needed to turn Godot Variants into the typed values expected by the lambda.

## Kotlin vs Java/Scala

Preserve each language's construction API when changing shared runtime behavior.

### Kotlin path

Kotlin helpers use:

- function types
- extension functions
- property delegates
- method references
- inline reified helper factories

### Java/Scala path

For registered properties:

- when a Java or Scala class exposes a callable as a registered property, the property should currently use the base `Callable` type rather than `CallableN`

The stored instance can still be a typed `LambdaCallableN` or `MethodCallableN`.
This is only about the property surface that the registration layer sees.

`@JvmSynthetic` hides Kotlin-specific helpers from JVM consumers. `@JvmName` gives Java and Scala factories their intended names. Preserve these annotations when changing API visibility or naming.

## How code is generated

All three generators follow the same broad pattern:

1. Loop from arity `0` to `Constraints.MAX_FUNCTION_ARG_COUNT`.
2. Use `GenericClassNameInfo` to derive class names, type variables, lambda shapes, and parameter lists.
3. Emit KotlinPoet types and functions for that arity.
4. Write the generated file into the `gen` source set.

Edit the generator or runtime class, then regenerate. Changes made directly to generated files will be overwritten.

## Maintenance rules of thumb

Keep these invariants when changing the API:

- Arity has to stay aligned across `CallableN`, `MethodCallableN`, `LambdaCallableN`, `LambdaContainerN`, `SignalN`, and connector helpers.
- `bind(...)` semantics must stay consistent across all callable families.
- Java/Scala-facing factories and Kotlin-facing helpers must continue to build the same underlying runtime objects.
- Keep engine behavior in runtime classes and signatures, overloads, typed wrappers, and naming in generators.

## Files to read together

Read the relevant generator alongside its runtime implementation:

- `kt/api-generator/src/main/kotlin/godot/codegen/services/impl/CallableGenerationService.kt`
- `kt/api-generator/src/main/kotlin/godot/codegen/services/impl/SignalGenerationService.kt`
- `kt/api-generator/src/main/kotlin/godot/codegen/services/impl/ConnectorGenerationService.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/Callable.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/Signal.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/MethodCallable.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/LambdaCallable.kt`
- `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/callback/VariantCallable.kt`
- `kt/godot-library/godot-extension-library/src/main/kotlin/godot/extension/callback/SignalConnector.kt`

Inspect one generated file to verify the signatures produced by your change.
