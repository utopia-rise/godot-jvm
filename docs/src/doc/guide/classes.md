---
description: Register a script class, choose a unique Godot name, and make it constructible from Godot.
---

# Classes

Extend `godot.api.Object` or one of its subclasses and add `@Script` to register a class:

/// tab | Kotlin
```kotlin
@Script
class Player : Node()
```
///
/// tab | Java
```java
@Script
public class Player extends Node {}
```
///
/// tab | Scala
```scala
@Script
class Player extends Node
```
///

## Naming

Each script needs a unique Godot name. Godot does not see packages, so two classes named `Player` in different packages clash. Use `@Script(className = "GamePlayer")` to give one a different registered name.

Keep JVM class names distinct from GDScript and C# class names too; build checks cover JVM classes only.

To change how default names are generated, use `registrationNameMode`. [Registration output](../reference/gradle-plugin/registration.md) lists its modes.

## Constructors

Godot registers a public no-argument constructor when one exists. Constructors with arguments remain available to JVM code, but Godot cannot call them. A class without a public no-argument constructor can still be registered as a base for a concrete script.

With a public no-argument constructor, you can create the class from GDScript:

```gdscript
var player := Player.new()
```
