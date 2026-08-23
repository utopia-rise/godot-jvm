---
description: Registering properties with @Visible, exporting them to the Inspector with @Export, naming conventions, and where the type-hint annotation reference lives.
---

# Properties and the Inspector

Any property of a registered class can be registered as long as it is public
and can be converted to a `Variant`. Use `@Visible` when the property only
needs to be registered. More specific annotations such as `@Export` and the
property hints already imply that registration.

/// tab | Kotlin
```kotlin
@Script
class RotatingCube : Node3D() {
    @Visible
    var someString: String = "Hello there :-)"

    @Visible
    var propertyWithDefaultValue: Float = 2f
}
```
///

/// tab | Java
```java
@Script
public class RotatingCube extends Node3D {
    @Visible
    public String someString = "Hello there :-)";

    @Visible
    public float propertyWithDefaultValue = 2f;
}
```
///

/// tab | Scala
```scala
@Script
class RotatingCube extends Node3D {
  @Visible
  var someString: String = "Hello there :-)"

  @Visible
  var propertyWithDefaultValue: Float = 2f
}
```
///

## Naming

Property names should follow the usual style of the language you use. For consistency with Godot's style,
your properties are actually registered as `snake_case`. So a property `someFlag` is usable in GDScript as `some_flag`.

## Core type specifics

Godot core type always need to have a value. Hence you cannot register properties of core types (like `Vector3`) with lateinit.

## Exporting properties

A registered property can be exported (a.k.a make it visible in the Godot editor) by annotating it with `@Export`.
A property can be exported if it is a core type, a primitive, or inherits from `godot.api.Node` or
`godot.api.RefCounted`.

/// tab | Kotlin
```kotlin
@Script
class RotatingCube : Node3D() {
    @Export
    var speed: Float = 2f
}
```
///

/// tab | Java
```java
@Script
public class RotatingCube extends Node3D {
    @Export
    public float speed = 2f;
}
```
///

/// tab | Scala
```scala
@Script
class RotatingCube extends Node3D {
  @Export
  var speed: Float = 2f
}
```
///

Exported properties can have default values (`2f` in the example above) which will be used as a default value in the Inspector.

!!! danger
    If you set a default value in code and a different value in the Inspector, the value of the latter will override the value in code after `init` and before `_enter_tree`.

## Type hint registration

This binding provides a plethora of annotations for defining property type hints.
These annotations control how Godot displays the property in the Inspector.
Each property hint annotation can only be added to certain types of properties.
Using the wrong annotation will make the compilation fail. A hint annotation already implies
`@Export` — you do not need to add `@Export` separately alongside it.

!!! note
    If you are using IntelliJ IDEA and have our plugin installed, you will get a warning about wrong annotation usages.

See the [property hints reference](../reference/property-hints.md) for the full list of annotations, their arguments, and the shared range arguments.
