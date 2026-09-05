---
description: Kotlin convenience APIs and their Java and Scala equivalents.
---

# Language parity

Kotlin, Java, and Scala share registration rules and runtime types. Kotlin also provides convenience APIs based on delegates, reified generics, and other language features. This table gives the corresponding Java and Scala patterns.

| Feature | Kotlin | Java/Scala equivalent |
|---|---|---|
| Declaring a signal | Property delegate: `val healthChanged by signal2<Int, Int>()` | `Signal2.create(this, "healthChanged")` |
| Method callable from a method reference | `methodCallableN(target, Type::method)` | `MethodCallableN.create(target, methodStringName)`, or a pre-made `MethodStringNameN` field for built-in engine methods |
| Lambda callable | `lambdaCallableN { ... }`, or `.asCallable()` on a lambda you already hold | `LambdaCallableN.create(...)` with explicit JVM classes for the argument and return types |
| Connecting a method to a signal | `signal.connectMethod(target, Type::method)` | `SignalConnectors.connectMethodN(signal, target, methodStringName)` |
| Connecting a lambda to a signal | `signal.connectLambda { ... }` | `SignalConnectors.connectLambdaN(signal, ..., lambda)` |
| Coroutines | `godotCoroutine { ... }` and `signal.await()`, behind the `isGodotCoroutinesEnabled` Gradle flag | None. Write a Kotlin wrapper that exposes a callback-based API and call that from Java or Scala. |
| Mutating a core-type property in place | `node3D.rotationMutate { y += 10f }` | Read the property, mutate the copy, assign it back: `var v = node.getRotation(); v.setY(v.getY() + 10f); node.setRotation(v);` |
| Mutating a collection element in place | `array.mutate(index) { it.y += 10f }`, `dictionary.mutate("foo") { it.y += 5f }` | Read the element with `get`, mutate the copy, write it back with `set` |
| String and node-path conversions | `"Player".asCachedStringName()`, `"Player".asCachedNodePath()`, `"healthChanged".toGodotName()` | `StringNames.asCachedStringName(...)`, `NodePaths.asCachedNodePath(...)`, `StringNames.toGodotName(...)` |
| Static Godot objects | `node.asStatic()` | `ObjectUtils.asStatic(node)` |

The typed `SignalN` and `CallableN` families, `MethodStringNameN`, `VariantCallable`, `SignalConnector`, registration annotations, and property hints are available in all three languages.
