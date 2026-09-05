---
description: Register a Player script with an Inspector property, a callable method, and a two-argument signal.
---

# Registering your code

Register your script classes and the members Godot needs to use by adding annotations and building the project.

The default **Inferred** mode recognizes common declarations and keeps the required annotations to a minimum. The guides use this mode throughout.

## The usual workflow

1. Mark a Godot subclass with `@Script`.
2. Use `@Export` for values you want to edit in the Inspector.
3. Use `@Register` for ordinary functions that Godot, another script, or the
   editor needs to call.
4. Build the project after adding or changing a script, an Inspector property,
   a signal, or a function that Godot calls.

For example:

/// tab | Kotlin

```kotlin
package com.yourcompany.game

import godot.annotation.Export
import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.core.signal2
import godot.global.GD

@Script
class Player : Node() {
    @Export
    var health: Int = 100

    val healthChanged by signal2<Int, Int>()

    @Register
    fun heal(amount: Int) {
        health = (health + amount).coerceAtMost(100)
        healthChanged.emit(health, 100)
    }

    override fun _ready() {
        GD.print("Player is ready")
    }
}
```

///

/// tab | Java

```java
package com.yourcompany.game;

import godot.annotation.Export;
import godot.annotation.Register;
import godot.annotation.Script;
import godot.api.Node;
import godot.core.Signal2;
import godot.global.GD;

@Script
public class Player extends Node {
    @Export
    public int health = 100;

    public final Signal2<Integer, Integer> healthChanged =
        Signal2.create(this, "healthChanged");

    @Register
    public void heal(int amount) {
        health = Math.min(health + amount, 100);
        healthChanged.emit(health, 100);
    }

    @Override
    public void _ready() {
        GD.print("Player is ready");
    }
}
```

///

/// tab | Scala

```scala
package com.yourcompany.game

import godot.annotation.{Export, Register, Script}
import godot.api.Node
import godot.core.Signal2
import godot.global.GD

@Script
class Player extends Node {
  @Export
  var health: Int = 100

  val healthChanged: Signal2[Integer, Integer] =
    Signal2.create(this, "healthChanged")

  @Register
  def heal(amount: Int): Unit = {
    health = Math.min(health + amount, 100)
    healthChanged.emit(health, 100)
  }

  override def _ready(): Unit = {
    GD.print("Player is ready")
  }
}
```

///

After a successful Gradle build, attach the source file to a node in the
editor in the same way that you would attach another script. The `health`
property is available in the Inspector, `heal` is available to Godot, and
`healthChanged` is available as a signal.

The following chapters explain each declaration in turn: classes, properties, functions, and signals. Other modes and their selection rules are covered in [Registration reference](../reference/registration.md).
