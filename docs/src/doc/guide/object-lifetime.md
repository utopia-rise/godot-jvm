---
description: Use `queueFree()` to remove nodes and `GD.isInstanceValid()` to check references retained after deletion.
---

# Object lifetime

For a retained `bullet` reference:

/// tab | Kotlin

```kotlin
if (GD.isInstanceValid(bullet)) {
    bullet.queueFree()
}
```

///

/// tab | Java

```java
if (GD.isInstanceValid(bullet)) {
    bullet.queueFree();
}
```

///

/// tab | Scala

```scala
if (GD.isInstanceValid(bullet)) {
  bullet.queueFree()
}
```

///

[`queueFree()`](https://docs.godotengine.org/en/stable/classes/class_node.html#class-node-method-queue-free) schedules deletion of the node and its children at the end of the frame. Scene-owned nodes are freed with their parent; dropping a JVM reference does not free a node.

!!! warning "A reference can outlive its node"
    A non-null JVM reference may refer to a deleted Godot object. `GD.isInstanceValid()` returns false for null or freed objects. Do not call methods on a freed object.
