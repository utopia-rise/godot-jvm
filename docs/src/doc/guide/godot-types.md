---
description: Instantiating Godot types and singletons, checking instance types, and the value-vs-reference semantics of core types, collections, StringName, and NodePath.
---

# Working with Godot types

## Creating Godot objects

Construct Godot types as you would other JVM objects:

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

Access Godot's singletons through static methods.

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

## Checking a node's type

Use your language's type-checking syntax to test an object's type:

/// tab | Kotlin
```kotlin
override fun _ready() {
    val parent = getParent()
    if (parent is CollisionShape3D) {
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

!!! tip
    In Kotlin, `require` can establish a type check for the code that follows. It throws if the check fails:

    ```kotlin
    override fun _ready() {
        val parent = getParent()
        require(parent is CollisionShape3D)
        parent.setShape(BoxShape3D())
    }
    ```

## Value types are copies

Value types such as `Vector3` are copied when read from Godot properties. This changes a copy and does nothing:

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

To update `rotation`, change the copy and assign it back to the property:

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

Kotlin's mutation helpers combine these steps. In Java and Scala, use the read-modify-write form above.

```kotlin
node3D.rotationMutate {
  y += 10f
}
```

The helper writes the changed value back automatically.

## Collections share storage

`VariantArray` and `Dictionary` share their contents with Godot. Reading a value-type element, such as a `Vector3`, still returns a copy:

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

Write the changed element back into the collection. Kotlin provides `mutate` helpers; Java and Scala use `get` and `set`:

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

When a Godot function expects a `StringName` or `NodePath`, you can convert a string with these helpers. The cached versions reuse the converted value on later calls:

/// tab | Kotlin
```kotlin
val stringName = "myString".asCachedStringName()
val nodePath = "myNode/myChildNode".asCachedNodePath()
val snakeCaseStringName = "myString".toGodotName()
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

`toGodotName()` also converts the name to `snake_case`.

For a one-off conversion, use the non-cached helpers:

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
