---
description: Print messages and report errors or warnings through Godot's GD singleton.
---

# Logging and errors

Use `GD.print` to send messages to both the terminal and [Godot's Output panel](https://docs.godotengine.org/en/stable/tutorials/scripting/debug/output_panel.html). Kotlin and Scala's `println` and Java's `System.out.println` write to standard output only.

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

Use `GD.pushError` and `GD.pushWarning` to report a diagnostic to Godot's debugger:

/// tab | Kotlin

```kotlin
GD.pushError("Player spawn point is missing")
GD.pushWarning("Using the default player name")
```

///

/// tab | Java

```java
GD.pushError("Player spawn point is missing");
GD.pushWarning("Using the default player name");
```

///

/// tab | Scala

```scala
GD.pushError("Player spawn point is missing")
GD.pushWarning("Using the default player name")
```

///

!!! warning "Exceptions do not stop the game"
    An exception escaping a JVM callback is logged with its stack trace. The Godot-side call returns a default value and the game keeps running. Statements after the throw in that callback do not run.
