---
description: Register a Player script with an Inspector property and a callable method.
---

# Registering your code

Register your script classes and the members Godot needs to use by adding annotations.

The guide uses the default registration settings. `@Script` exposes a class, `@Export` exposes a property in the [Inspector](https://docs.godotengine.org/en/stable/tutorials/editor/inspector_dock.html), and `@Register` exposes a function to Godot.

A Godot subclass uses `@Script`. `@Export` makes a property editable in the Inspector, and `@Register` makes an ordinary function callable by Godot, another script, or the editor.

For example:

/// tab | Kotlin

```kotlin
package com.example.game

import godot.annotation.Export
import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.global.GD

@Script
class Player : Node() {
    @Export
    var health: Int = 100

    @Register
    fun heal(amount: Int) {
        health = (health + amount).coerceAtMost(100)
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
import godot.global.GD;

@Script
public class Player extends Node {
    @Export
    public int health = 100;

    @Register
    public void heal(int amount) {
        health = Math.min(health + amount, 100);
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
import godot.global.GD

@Script
class Player extends Node {
  @Export
  var health: Int = 100

  @Register
  def heal(amount: Int): Unit = {
    health = Math.min(health + amount, 100)
  }

  override def _ready(): Unit = {
    GD.print("Player is ready")
  }
}
```

///
