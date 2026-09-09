---
description: Godot script class eligibility, constructors, abstract classes, and inherited members in Kotlin, Java, and Scala.
---

# Classes and inheritance

## Script classes

A script inherits `godot.api.Object` or a derived engine class such as `Node` or `Resource`. The source language must be identifiable as Kotlin, Java, or Scala. Inferred mode requires `@Script` directly or through a meta-annotation; Explicit requires direct `@Script`; Automatic selects public Godot subclasses.

The following declaration works in all three modes:

/// tab | Kotlin

```kotlin
import godot.annotation.Script
import godot.api.Node

@Script
class Player : Node()
```

///

/// tab | Java

```java
import godot.annotation.Script;
import godot.api.Node;

@Script
public class Player extends Node {}
```

///

/// tab | Scala

```scala
import godot.annotation.Script
import godot.api.Node

@Script
class Player extends Node
```

///

## Constructors

Only public no-argument constructors are exposed to Godot. A class can be registered without one, but Godot cannot instantiate it. Constructors with parameters remain JVM-only. A constructor's default arguments matter only if the compiler also emits a public no-argument constructor.

## Abstract classes

`@Script` is optional on an abstract base that only contributes inherited members. Add it when the abstract class itself should be registered. An abstract registered class is known to Godot but cannot be instantiated or attached as a concrete script. Concrete descendants can inherit its registered declarations.

/// tab | Kotlin
```kotlin
abstract class Character : Node() {
    @Export
    var health: Int = 100

    @Emit("current", "max")
    val healthChanged by signal2<Int, Int>()

    @Register
    fun heal(amount: Int) {
        health = (health + amount).coerceAtMost(100)
        healthChanged.emit(health, 100)
    }

    @Register
    abstract fun attack()
}

@Script
class Enemy : Character() {
    override fun attack() {
        GD.print("Enemy attacks")
    }
}
```
///
/// tab | Java
```java
public abstract class Character extends Node {
    @Export
    public int health = 100;

    @Emit(parameters = {"current", "max"})
    public final Signal2<Integer, Integer> healthChanged =
        Signal2.create(this, "healthChanged");

    @Register
    public void heal(int amount) {
        health = Math.min(health + amount, 100);
        healthChanged.emit(health, 100);
    }

    @Register
    public abstract void attack();
}

@Script
public class Enemy extends Character {
    @Override
    public void attack() {
        GD.print("Enemy attacks");
    }
}
```
///
/// tab | Scala
```scala
abstract class Character extends Node {
  @Export
  var health: Int = 100

  @Emit(parameters = Array("current", "max"))
  val healthChanged: Signal2[Integer, Integer] =
    Signal2.create(this, "healthChanged")

  @Register
  def heal(amount: Int): Unit = {
    health = Math.min(health + amount, 100)
    healthChanged.emit(health, 100)
  }

  @Register
  def attack(): Unit
}

@Script
class Enemy extends Character {
  override def attack(): Unit = {
    GD.print("Enemy attacks")
  }
}
```
///

Put the classes in separate source files.

An override without annotations keeps the parent declaration's registration, and Godot calls the override. To change the registered settings, such as an RPC configuration, annotate the override and keep its parameter list: the annotated override replaces the parent's entry.


## Inherited members

Registered properties, functions, and signals from parent classes are included in the descendant's effective registration. This includes selected members of intermediate parents that are not themselves registered. Interfaces can contribute registered functions.

Local declarations take precedence over inherited duplicates. Properties and signals are deduplicated by name; functions by name and parameter-type signature. Built-in engine members remain part of the engine API; inheritance does not register every built-in method again.

## Names and source files

The registered Godot name and the JVM fully qualified class name are different identifiers. [`@Script(className = ...)`](../annotations.md#script) changes the base registered name. [Naming policies](script-files.md#registered-class-names) determine prefixes and sanitization. The source-file association still uses the JVM class name.

Use concrete Godot-compatible types in registered signatures. A JVM generic type parameter does not define a Godot Variant type.
