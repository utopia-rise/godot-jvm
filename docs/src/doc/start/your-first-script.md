---
description: Write a Kotlin, Java, or Scala script class, build it from the Godot editor, your IDE, or the command line, then attach it to a node in the scene tree.
---

# Your first script

Create a `Player` script that prints a message when its node is ready. Use the example for one of the languages enabled in your project.

/// tab | Kotlin

Create `src/main/kotlin/com/yourcompany/game/Player.kt`:

```kotlin
package com.yourcompany.game

import godot.annotation.Script
import godot.api.Node
import godot.global.GD

@Script
class Player : Node() {
    override fun _ready() {
        GD.print("Hello from Kotlin")
    }
}
```

///

/// tab | Java

Create `src/main/java/com/yourcompany/game/Player.java`:

```java
package com.yourcompany.game;

import godot.annotation.Script;
import godot.api.Node;
import godot.global.GD;

@Script
public class Player extends Node {
    @Override
    public void _ready() {
        GD.print("Hello from Java");
    }
}
```

///

/// tab | Scala

Create `src/main/scala/com/yourcompany/game/Player.scala`:

```scala
package com.yourcompany.game

import godot.annotation.Script
import godot.api.Node
import godot.global.GD

@Script
class Player extends Node {
  override def _ready(): Unit = {
    GD.print("Hello from Scala")
  }
}
```

///

This small example already shows the main building blocks:

- `@Script` makes the class available to Godot.
- Inheriting `Node` makes it a Godot script class.
- Overriding `_ready()` runs code once the node and its children are ready.
- `GD.print(...)` writes to the Godot output.

## Build it

Run a Gradle build using any of the options below.

In the editor toolbar, leave the task drop-down on **Build** and click **Run Gradle**:

![Build button](../assets/img/editor-plugin/build_button.png)

!!! note
    On Linux or macOS, the build can fail if `gradlew` is not executable:
    ```shell
    ERROR: Godot-JVM: Could not create child process: /Users/username/projectname/gradlew
    ```

    Run this command from the project root, then build again:
    ```shell
    chmod +x gradlew
    ```

In your IDE, run the Gradle `build` task:

![Gradle task](../assets/img/build_ide.png)

Or run the build from a terminal in the project root:

/// tab | Windows
```shell
gradlew build
```
///

/// tab | Unix
```bash
./gradlew build
```
///

## Attach it to a node

Build before attaching the script. The toolbar's JVM status indicator is red when no JVM library could be loaded, yellow while the JVM starts or waits for code, and green when your classes are loaded.

![Run Gradle and JVM status indicator](../assets/img/run-gradle-ready.png)

After the build succeeds, drag `Player.kt`, `Player.java`, or `Player.scala` from the FileSystem panel onto a node in your scene. You can also use the node's **Attach Script** dialog. Run the scene and check the Output panel for your greeting.

If you rebuild while the editor is open, your classes are reloaded
automatically.

!!! warning "If you attach the file before a successful build"
    Godot keeps a placeholder until the compiled class is available. Your properties and methods will be missing, and `_ready()` will not run. Build the project successfully to replace the placeholder with your class.

Once you see the greeting, you're ready to export a test build.
