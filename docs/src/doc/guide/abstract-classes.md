---
description: Share registered members through an abstract Character class and implement it in an Enemy script.
---

# Abstract classes

Use an abstract class to share members between scripts. `@Script` is optional on abstract classes, and Godot never instantiates them. Concrete subclasses inherit their registered members.

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

Put the classes in separate source files and attach `Enemy` to a node.

An override without annotations keeps the parent declaration's registration, and Godot calls the override. To change the registered settings, such as an RPC configuration, annotate the override and keep its parameter list: the annotated override replaces the parent's entry.
