---
description: Print messages and report errors or warnings through Godot's GD singleton.
---

# Logging and errors

Use `GD` to send messages to both the terminal and Godot's Output panel:

/// tab | Kotlin
```kotlin
GD.print("Player is ready")
```
///

/// tab | Java
```java
GD.print("Player is ready");
```
///

/// tab | Scala
```scala
GD.print("Player is ready")
```
///

Kotlin and Scala's `println` and Java's `System.out.println` write to standard output only. Use `GD.print` when you also want to see the message in the editor.

Use `GD.printErr` for error output, or `GD.pushError` and `GD.pushWarning` to report a diagnostic to Godot's debugger:

/// tab | Kotlin
```kotlin
GD.printErr("Could not read the save file")
GD.pushError("Player spawn point is missing")
GD.pushWarning("Using the default player name")
```
///
/// tab | Java
```java
GD.printErr("Could not read the save file");
GD.pushError("Player spawn point is missing");
GD.pushWarning("Using the default player name");
```
///
/// tab | Scala
```scala
GD.printErr("Could not read the save file")
GD.pushError("Player spawn point is missing")
GD.pushWarning("Using the default player name")
```
///
