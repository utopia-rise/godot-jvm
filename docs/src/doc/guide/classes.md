---
description: Extend a Godot node class and give the script a unique name and a public no-argument constructor.
---

# Classes

Extend a Godot base class and give the script a unique name and a public no-argument constructor. This guide uses [Node](https://docs.godotengine.org/en/stable/classes/class_node.html) as its example base class.

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

Keep the class name unique across the project, including classes supplied by libraries. Use the same name for the source file: `Player.kt`, `Player.java`, or `Player.scala`.

Godot needs a public no-argument constructor to instantiate the script; all three examples supply one.

!!! warning "Wait for the scene tree"
    Constructors and field initializers can perform ordinary JVM initialization. Wait until `_enterTree()` or `_ready()` before creating nodes or accessing the scene tree.

An abstract base class can hold `@Export` properties and `@Register` functions. Concrete children inherit these registered members.

`@Tool` is not implemented; see the [FAQ](../faq.md#known-limitations).
