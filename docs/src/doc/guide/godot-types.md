---
description: Instantiating Godot types and singletons, checking instance types, and the value-vs-reference semantics of core types, collections, StringName, and NodePath.
---

# Working with Godot types

## Instance types and singletons

Creating a new instance of a Godot type can be done like any JVM object.

/// tab | Kotlin
```kotlin
val node3D = Node3D()
val vec = Vector3()
```
///

/// tab | Java
```java
Node3D node3D = new Node3D();
Vector3 vec = new Vector3();
```
///

/// tab | Scala
```scala
val node3D = new Node3D()
val vec = new Vector3()
```
///

Godot's singletons are exposed as static access points.

/// tab | Kotlin
```kotlin
PhysicsServer2D.areaGetTransform(area)
```
///

/// tab | Java
```java
PhysicsServer2D.areaGetTransform(area);
```
///

/// tab | Scala
```scala
PhysicsServer2D.areaGetTransform(area)
```
///

## Instance checks

Checking if an object is an instance of a particular type can be done via the `is` operator.

/// tab | Kotlin
```kotlin
override fun _ready() {
    val parent = getParent()
    if (parent is CollisionShape3D) {
        // smart cast works!
        parent.setShape(BoxShape3D())
    } else {
        throw AssertionError("Unexpected parent!")
    }
}
```
///

/// tab | Java
```java
@Override
public void _ready() {
    Node parent = getParent();
    if (parent instanceof CollisionShape3D collisionShape) {
        collisionShape.setShape(new BoxShape3D());
    } else {
        throw new AssertionError("Unexpected parent!");
    }
}
```
///

/// tab | Scala
```scala
override def _ready(): Unit = {
  getParent() match {
    case collisionShape: CollisionShape3D =>
      collisionShape.setShape(new BoxShape3D())
    case _ =>
      throw new AssertionError("Unexpected parent!")
  }
}
```
///

This also works for any type you define.

!!! info
    If you are sure that an object is always an instance of some type, then you can take advantage of Kotlin's [contracts](https://kotlinlang.org/docs/reference/whatsnew13.html#contracts) feature. This allows you to avoid having nested `if`s.

    ```kotlin
    override fun _ready() {
        val parent = getParent()
        require(parent is CollisionShape3D)
        // Smart Cast works here as well!
        parent.setShape(BoxShape3D())
    }
    ```

## Core types

Godot's built-in types are passed by value (except for `Dictionary` and `VariantArray` - more on this later), so the following snippet won't work as expected.

/// tab | Kotlin
```kotlin
val node3D = Node3D()
node3D.rotation.y += 10f
```
///

/// tab | Java
```java
Node3D node3D = new Node3D();
node3D.getRotation().setY(node3D.getRotation().getY() + 10f);
```
///

/// tab | Scala
```scala
val node3D = new Node3D()
node3D.getRotation.setY(node3D.getRotation.getY + 10f)
```
///

You are *actually mutating a copy* of the `rotation` property, not a reference to it. To get the desired behaviour you have to re-assign the copy back.

/// tab | Kotlin
```kotlin
val rotation = node3D.rotation
rotation.y += 10f
node3D.rotation = rotation
```
///

/// tab | Java
```java
Vector3 rotation = node3D.getRotation();
rotation.setY(rotation.getY() + 10f);
node3D.setRotation(rotation);
```
///

/// tab | Scala
```scala
val rotation = node3D.getRotation
rotation.setY(rotation.getY + 10f)
node3D.setRotation(rotation)
```
///

This approach introduces a lot of boilerplate, so this binding provides a concise way of achieving the same behaviour. The mutating helpers are Kotlin-only, because they rely on Kotlin's trailing-lambda syntax; in Java and Scala, keep using the read-modify-write form shown above.

```kotlin
node3D.rotationMutate {
  y += 10f
}
```

The snippet above is functionally equivalent to the previous one.

## Collection types

While `VariantArray` and `Dictionary` are passed by reference, the value returned by the retrieval methods (`VariantArray.get(...)` and `Dictionary.get(...)`) are not.

/// tab | Kotlin
```kotlin
array[index].y += 10f
dictionary["foo"].y += 5f
```
///

/// tab | Java
```java
array.get(index).setY(array.get(index).getY() + 10f);
dictionary.get("foo").setY(dictionary.get("foo").getY() + 5f);
```
///

/// tab | Scala
```scala
array.get(index).setY(array.get(index).getY + 10f)
dictionary.get("foo").setY(dictionary.get("foo").getY + 5f)
```
///

To get the desired behaviour, you can re-assign the copy back. In Kotlin, `VariantArray.mutate` and `Dictionary.mutate` do that for you; the Java and Scala tabs below show the equivalent manual read-modify-write.

/// tab | Kotlin
```kotlin
array.mutate(index) {
  it.y += 10f
}

dictionary.mutate("foo") {
  it.y += 5f
}
```
///

/// tab | Java
```java
Vector3 arrayValue = array.get(index);
arrayValue.setY(arrayValue.getY() + 10f);
array.set(index, arrayValue);

Vector3 dictionaryValue = dictionary.get("foo");
dictionaryValue.setY(dictionaryValue.getY() + 5f);
dictionary.set("foo", dictionaryValue);
```
///

/// tab | Scala
```scala
val arrayValue = array.get(index)
arrayValue.setY(arrayValue.getY + 10f)
array.set(index, arrayValue)

val dictionaryValue = dictionary.get("foo")
dictionaryValue.setY(dictionaryValue.getY + 5f)
dictionary.set("foo", dictionaryValue)
```
///

## StringName and NodePath

Several Godot functions take `StringName` or `NodePath` as a parameter.
It's often more convenient to directly use a String and convert it.

This kind of operation can be costly so we provide extension functions which cache the result of the conversion for later calls:

/// tab | Kotlin
```kotlin
    val stringName = "myString".asCachedStringName() // Cache the string for faster future calls.
    val nodePath = "myNode/myChildNode".asCachedNodePath() // Cache the string for faster future calls.
    val snakeCaseStringName = "myString".toGodotName() // Convert the string to snake_case and cache it for faster future calls.
```
///

/// tab | Java
```java
    StringName stringName = StringNames.asCachedStringName("myString");
    NodePath nodePath = NodePaths.asCachedNodePath("myNode/myChildNode");
    StringName snakeCaseStringName = StringNames.toGodotName("myString");
```
///

/// tab | Scala
```scala
    val stringName = StringNames.asCachedStringName("myString")
    val nodePath = NodePaths.asCachedNodePath("myNode/myChildNode")
    val snakeCaseStringName = StringNames.toGodotName("myString")
```
///

You can also use the non-cached version of them if you simply want ease of conversion:

/// tab | Kotlin
```kotlin
    val stringName = "myString".asStringName()
    val nodePath = "myNode/myChildNode".asNodePath()
```
///

/// tab | Java
```java
    StringName stringName = StringNames.asStringName("myString");
    NodePath nodePath = NodePaths.asNodePath("myNode/myChildNode");
```
///

/// tab | Scala
```scala
    val stringName = StringNames.asStringName("myString")
    val nodePath = NodePaths.asNodePath("myNode/myChildNode")
```
///
