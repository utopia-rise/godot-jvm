---
description: How @Script, @Export, @Register and @Rpc expose your Kotlin, Java or Scala classes to Godot, and when you need to rebuild after changing them.
---

# Registering your code

Before Godot can use a JVM class as a script, the class and the members you
want to expose must be registered. In most projects, this only means adding a
few annotations and building the project.

Godot-JVM registers members in **Inferred** mode by default, and the rest of
this documentation assumes it. Read this page top to bottom and you have the
whole of the everyday workflow.

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
package com.example.game

import godot.annotation.Export
import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.core.signal1
import godot.global.GD

@Script
class Player : Node() {
    @Export
    var health = 100

    val healthChanged by signal1<Int>()

    @Register
    fun heal(amount: Int) {
        health = (health + amount).coerceAtMost(100)
        healthChanged.emit(health)
    }

    override fun _ready() {
        GD.print("Player is ready")
    }
}
```

///

/// tab | Java

```java
package com.example.game;

import godot.annotation.Export;
import godot.annotation.Register;
import godot.annotation.Script;
import godot.api.Node;
import godot.core.Signal1;
import godot.global.GD;

@Script
public class Player extends Node {
    @Export
    public int health = 100;

    public final Signal1<Integer> healthChanged =
        Signal1.create(this, "healthChanged");

    @Register
    public void heal(int amount) {
        health = Math.min(health + amount, 100);
        healthChanged.emit(health);
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
package com.example.game

import godot.annotation.{Export, Register, Script}
import godot.api.Node
import godot.core.Signal1
import godot.global.GD

@Script
class Player extends Node {
  @Export
  var health: Int = 100

  val healthChanged: Signal1[Integer] =
    Signal1.create(this, "healthChanged")

  @Register
  def heal(amount: Int): Unit = {
    health = Math.min(health + amount, 100)
    healthChanged.emit(health)
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

That is the normal Inferred-mode workflow. The following Guide pages explain each kind of Godot-facing declaration in detail.

For exact selection rules, non-default modes, and shared requirements, see the [Registration reference](../reference/registration.md). If a declaration does not appear after a build, use [Build and registration troubleshooting](../troubleshooting/build-and-registration.md).
