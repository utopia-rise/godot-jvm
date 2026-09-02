---
description: Printing to both the CLI and the Godot editor output panel with the GD singleton, instead of the JVM's own print functions.
---

# Logging and errors

If you want logs to appear both in CLI and in the Godot editor you will have to use the print functions inside the `GD` singleton like:

/// tab | Kotlin
```kotlin
GD.print("Hello There!")
```
///

/// tab | Java
```java
GD.print("Hello There!");
```
///

/// tab | Scala
```scala
GD.print("Hello There!")
```
///

The JVM's own print functions — Kotlin's and Scala's `println`, Java's `System.out.println` — only write to the CLI. They never appear in the Godot editor's output panel.
