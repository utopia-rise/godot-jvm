---
description: Defining abstract Godot base classes in Kotlin, Java and Scala, which members they can register, and why Godot never sees the abstract type itself.
---

# Abstract classes

You can define and derive from any abstract class you define, as long as any of your superclasses is a Godot class.

This allows you to define default functions for your inheriting classes and override them in some, but not all subclasses if you want.

You can define an abstract class and register its members the same way as you do for normal classes.

Under the hood, we only register your normal classes, and let them register all members your abstract class defines.

!!! info
    For this reason, the `@Script` annotation is optional for abstract classes.

!!! warning
    As in Kotlin, Java, and Scala, you cannot instantiate abstract classes directly from any other scripting language like GDScript! In fact, godot does not even know (or care) that your abstract class exists.

## Example

Abstract class definition:

/// tab | Kotlin
```kotlin
// register class annotation is optional for abstract classes
abstract class AbstractClassInheritanceParent: Node() {

    @Export
    var registeredExportedPropertyInAbstractClass = false

    @Emit("message")
    val signalInAbstractClass by signal1<String>()

    @Register
    fun functionInAbstractClassWithDefaultImplementation() {
        // some implementation
    }

    @Register
    abstract fun abstractFunction()
}
```
///

/// tab | Java
```java
// register class annotation is optional for abstract classes
public abstract class AbstractClassInheritanceParent extends Node {

    @Export
    public boolean registeredExportedPropertyInAbstractClass = false;

    @Emit(parameters = {"message"})
    public final Signal1<String> signalInAbstractClass =
            Signal1.create(this, "signalInAbstractClass");

    @Register
    public void functionInAbstractClassWithDefaultImplementation() {
        // some implementation
    }

    @Register
    public abstract void abstractFunction();
}
```
///

/// tab | Scala
```scala
// register class annotation is optional for abstract classes
abstract class AbstractClassInheritanceParent extends Node {

  @Export
  var registeredExportedPropertyInAbstractClass: Boolean = false

  @Emit(parameters = Array("message"))
  val signalInAbstractClass: Signal1[String] =
    Signal1.create(this, "signalInAbstractClass")

  @Register
  def functionInAbstractClassWithDefaultImplementation(): Unit = {
    // some implementation
  }

  @Register
  def abstractFunction(): Unit
}
```
///

Child class definition:

/// tab | Kotlin
```kotlin
@Script
class AbstractClassInheritanceChild: AbstractClassInheritanceParent() {
    override fun abstractFunction() {
        // some implementation
    }
}
```
///

/// tab | Java
```java
@Script
public class AbstractClassInheritanceChild extends AbstractClassInheritanceParent {
    @Override
    public void abstractFunction() {
        // some implementation
    }
}
```
///

/// tab | Scala
```scala
@Script
class AbstractClassInheritanceChild extends AbstractClassInheritanceParent {
  override def abstractFunction(): Unit = {
    // some implementation
  }
}
```
///

!!! warning "Overridden members"
    Overriding a parent member changes its behavior.
    If the child should also be exposed differently, add the annotation again on the child declaration.
