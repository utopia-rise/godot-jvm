---
description: The exhaustive list of Kotlin-only convenience APIs in Godot-JVM, paired with the equivalent Java and Scala code for each one.
---

# Language parity

Kotlin, Java, and Scala all reach the same underlying registration model and the same runtime types. A handful of
convenience helpers, however, only exist in Kotlin because they depend on Kotlin-specific language features —
property delegates, reified generics, method references, trailing lambdas, or coroutines. This page is the
exhaustive list of that Kotlin-only surface as of this writing.

| Feature | Kotlin | Java/Scala equivalent |
|---|---|---|
| Declaring a signal | Property delegate: `val healthChanged by signal2<Int, Int>()` | `SignalN.create(this, "healthChanged")` |
| Method callable from a method reference | `methodCallableN(target, Type::method)` | `MethodCallableN.create(target, methodStringName)`, or a pre-made `MethodStringNameN` field for built-in engine methods |
| Lambda callable | `lambdaCallableN { ... }`, or `.asCallable()` on a lambda you already hold | `LambdaCallableN.create(...)` with explicit JVM classes for the argument and return types |
| Connecting a method to a signal | `signal.connectMethod(target, Type::method)` | `SignalConnectors.connectMethodN(signal, target, methodStringName)` |
| Connecting a lambda to a signal | `signal.connectLambda { ... }` | `SignalConnectors.connectLambdaN(signal, ..., lambda)` |
| Coroutines | `node.launch { ... }` and `signal.await()`, behind the `isGodotCoroutinesEnabled` Gradle flag | None. Write a Kotlin wrapper that exposes a callback-based API and call that from Java or Scala. |
| Mutating a core-type property in place | `node3D.rotationMutate { y += 10f }` | Read the property, mutate the copy, assign it back: `var v = node.getRotation(); v.setY(v.getY() + 10f); node.setRotation(v);` |
| Mutating a collection element in place | `array.mutate(index) { it.y += 10f }`, `dictionary.mutate("foo") { it.y += 5f }` | Read the element with `get`, mutate the copy, write it back with `set` |

Everything else — the typed `SignalN`/`CallableN` families, `MethodStringNameN`, `VariantCallable`, `SignalConnector`,
registration annotations, and property hints — is shared equally across all three languages.
