---
description: Marking a class with @Script, choosing a unique Godot registration name, and how public no-argument constructors let Godot instantiate a class.
---

# Classes

To expose a class written in Kotlin, Java, or Scala, it needs to extend `godot.api.Object` (or any of its subtype) and must be annotated with `@Script`.

/// tab | Kotlin
```kotlin
@Script
class RotatingCube : Node3D() {
    // ...
}
```
///

/// tab | Java
```java
@Script
public class RotatingCube extends Node3D {
    // ...
}
```
///

/// tab | Scala
```scala
@Script
class RotatingCube extends Node3D {
  // ...
}
```
///

## Naming

Classes need to be registered with a unique name as Godot does not support namespaces (or packages in this case) for script classes.

By default, classes are registered with their simple Kotlin class name. This is enough in many cases, but it can lead to conflicts if different packages contain classes with the same name. For example:

- `com.package.a.MyClass`
- `com.package.b.MyClass`

Both would be registered as `MyClass`.

So you are responsible for making sure that classes have a unique name.
We do however provide you with some assistance:

- We have compile time checks in place which should let the *build fail* if classes would end up having the same name.
- The `@Script` annotation lets you define a custom registration name: `@Script("CustomRegistrationName")`.
- You can configure how default registration names are computed:

```kotlin
import godot.registrar.generator.RegisteredNameMode

godot {
    registrationNameMode.set(RegisteredNameMode.FQ_NAME)
}
```

The available modes are:

- `RegisteredNameMode.SIMPLE_NAME`: default. Uses the custom name if present, otherwise the Kotlin class name.
- `RegisteredNameMode.FQ_NAME`: uses the custom name if present, otherwise the fully qualified class name.
- `RegisteredNameMode.PROJECT_PREFIX`: uses the custom name if present, otherwise the Kotlin class name. Classes from external projects are prefixed with their source project name.

!!! warning "Class names from other languages"
    Even with all these checks and helpers in place, we cannot check the names of classes from other languages like GDScript or C#. It's your responsibility to make sure there are no naming conflicts. Installing our IntelliJ plugin is also recommended, since it shows duplicated registered class names in the editor as an error.

## Constructors

A script class does not need a default constructor to be registered. If it has
a public constructor with no arguments, Godot registers that constructor for
you. Godot does not register constructors with arguments, although you can use
them normally from Kotlin, Java, or Scala.

### Instantiate script classes in GDScript

From GDScript, you can create an instance only when the registered JVM class
has a public constructor with no arguments:

```gdscript
var instance := YourJvmClass.new()
```

Godot cannot call constructors with arguments. If a script has no public
no-argument constructor, it is still registered, but Godot cannot instantiate
it as a script. A concrete subclass with a public no-argument constructor can
be instantiated normally.
