---
description: Export properties to the Inspector, register values for scripts, and choose property hints.
---

# Properties and the Inspector

Add `@Export` to make a property editable in the Inspector. For the `Player` script, start with health:

/// tab | Kotlin
```kotlin
@Script
class Player : Node() {
    @Export
    var health: Int = 100
}
```
///
/// tab | Java
```java
@Script
public class Player extends Node {
    @Export
    public int health = 100;
}
```
///
/// tab | Scala
```scala
@Script
class Player extends Node {
  @Export
  var health: Int = 100
}
```
///

The initial value, `100`, becomes the Inspector default. Supported types are primitives and strings, Godot core types, `Node` and `Resource` subclasses, enums, `BitField`, collections of enums, and `Any`.

!!! note "Inspector values take precedence"
    Godot applies saved Inspector values after initialization and before `_enter_tree()`. Read those values once the node enters the tree, rather than during construction.

## Register without showing in the Inspector

Use `@Visible` instead of `@Export` when other scripts need access to a property but you do not want it editable in the Inspector.

## Naming

Use your language's usual naming style. Godot-JVM registers properties in `snake_case`, so `maxHealth` becomes `max_health` in GDScript.

## Initialize core types

Initialize properties of Godot core types, such as `Vector3`, with a value. They cannot use Kotlin's `lateinit`.

## Choosing the Inspector control

Property hints select controls such as a numeric range or file picker. A hint implies `@Export`, so use the hint annotation alone. An incompatible hint fails the build; the IntelliJ plugin also highlights incompatible annotations while you edit.

[Property hints](../reference/property-hints.md) lists every hint, its supported types, and its arguments.
