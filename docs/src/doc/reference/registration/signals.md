---
description: Typed signal declarations, mode selection, argument names, and language-specific generic types.
---

# Signal registration

## Declaration and selection

A script signal is a `godot.core.SignalN` member. Inferred mode recognizes it without `@Emit`; Explicit requires direct `@Emit`; Automatic selects public signal members. `@Emit` optionally supplies argument names. No `signal` prefix is required on the member name.

These declarations work in all three modes and expose `health_changed(current, maximum)`:

/// tab | Kotlin

```kotlin
import godot.annotation.Emit
import godot.core.signal2

@Emit("current", "maximum")
val healthChanged by signal2<Int, Int>()
```

///

/// tab | Java

```java
import godot.annotation.Emit;
import godot.core.Signal2;

@Emit(parameters = {"current", "maximum"})
public final Signal2<Integer, Integer> healthChanged =
    Signal2.create(this, "healthChanged");
```

///

/// tab | Scala

```scala
import godot.annotation.Emit
import godot.core.Signal2

@Emit(parameters = Array("current", "maximum"))
val healthChanged: Signal2[Integer, Integer] =
    Signal2.create(this, "healthChanged")
```

///

## Types and names

`Signal0` through `Signal16` represent the argument count. Argument types must be Godot-compatible. Generic type arguments provide registration metadata; unrelated JVM types cannot appear in a registered signal signature.

For Java and Scala, use boxed primitive types in generic arguments, such as `Integer`, `java.lang.Boolean`, and `java.lang.Double`. Scala primitive type arguments can erase to `Object`, losing the intended Godot type. Kotlin's signal delegates capture their reified types.

The member `healthChanged` registers as `health_changed`. The factory name must identify the same signal. `@Emit.parameters` supplies human-readable argument names, not the signal's name; provide one name per argument when naming them.

Signals are not exported properties. `@Visible` and `@Export` are not their selection annotations. Inherited signals follow [class inheritance](classes.md#inherited-members).

See [Signals](../binding/signals.md) for factories, emission, connection, and disconnection, and [`@Emit`](../annotations.md#emit) for annotation syntax.
