---
description: Write a Kotlin, Java, or Scala script class, build it from the Godot editor, your IDE, or the command line, then attach it to a node in the scene tree.
---

# Your first script

Create a `Player` script with one exported property and one overridden method: when its node is ready, it prints a greeting that names the language it was written in. Use the example for one of the languages enabled in your project.

/// tab | Kotlin

Create `src/main/kotlin/com/example/game/Player.kt`:

```kotlin
package com.example.game

import godot.annotation.Export
import godot.annotation.Script
import godot.api.Node
import godot.global.GD

@Script
class Player : Node() {
    @Export
    var language: String = "Kotlin"

    override fun _ready() {
        GD.print("Hello from $language")
    }
}
```

///

/// tab | Java

Create `src/main/java/com/example/game/Player.java`:

```java
package com.example.game;

import godot.annotation.Export;
import godot.annotation.Script;
import godot.api.Node;
import godot.global.GD;

@Script
public class Player extends Node {
    @Export
    public String language = "Java";

    @Override
    public void _ready() {
        GD.print("Hello from " + language);
    }
}
```

///

/// tab | Scala

Create `src/main/scala/com/example/game/Player.scala`:

```scala
package com.example.game

import godot.annotation.Export
import godot.annotation.Script
import godot.api.Node
import godot.global.GD

@Script
class Player extends Node {
  @Export
  var language: String = "Scala"

  override def _ready(): Unit = {
    GD.print(s"Hello from $language")
  }
}
```

///

This small example already shows the main building blocks:

- `@Script` makes the class available to Godot.
- Inheriting `Node` makes it a Godot script class.
- `@Export` registers the property and shows it in the Inspector, where you can change the greeting without touching the code.
- Overriding `_ready()` runs code once the node and its children are ready.
- `GD.print(...)` writes to the Godot output.

## Build it

Your scripts are compiled by Gradle, and you can start that build from wherever you are working:

- **From Godot.** In the editor toolbar, leave the task drop-down on **Build** and click **Run Gradle**. This is convenient when you are arranging scenes and only need to pick up a code change.

    ![Build button](../assets/img/editor-plugin/build_button.png)

- **From IntelliJ IDEA.** The IDE already manages Gradle for you: run the `build` task from the Gradle panel, or bind it to a run configuration.

    ![Gradle task](../assets/img/build_ide.png)

- **From a terminal.** Run the wrapper at the project root: `gradlew build` on Windows, `./gradlew build` on Linux and macOS.

!!! note
    On Linux or macOS, the build can fail if `gradlew` is not executable:
    ```shell
    ERROR: Godot-JVM: Could not create child process: /Users/username/projectname/gradlew
    ```

    Run this command from the project root, then build again:
    ```shell
    chmod +x gradlew
    ```

Whichever way you build, the editor notices the new jar and reloads your classes automatically. The toolbar's JVM status indicator is red when no JVM library could be loaded, yellow while the JVM starts or waits for code, and green when your classes are loaded.

![Run Gradle and JVM status indicator](../assets/img/run-gradle-ready.png)

## Attach it to a node

Attach `Player.kt`, `Player.java`, or `Player.scala` exactly like a GDScript: drag it from the FileSystem dock onto the node, or use **Attach Script**. In the dialog, the **Language** entries are **Kotlin**, **Java**, and **Scala**; select the language and the source path. Edit the source in IntelliJ IDEA; Godot's script editor does not support JVM source editing.

!!! warning "Build the script JAR"
    A source file alone is not enough. If you attach it before building, the node warns that the script cannot be found in the JVM project. Its class must be present in the built JAR. Build the JVM project to load the class and its exported properties.

Select the node: the Inspector shows the **Language** property from the example. See [Script files](../reference/registration/script-files.md) for source-file association rules.

## Run it

Run the scene or the project exactly as you would with any Godot game, with the play buttons or F5 and F6. The Output panel shows your greeting. Change the **Language** value in the Inspector and run again to see the exported property in action.

Godot-JVM keeps an eye on stale builds for you. If you edit a script and forget to rebuild, every node using it shows a configuration warning in the scene tree saying the script has been modified since the last build. Rebuild, and the warning disappears.

To never think about it, enable **Kotlin Jvm > Editor > Build Gradle Before Start** in **Editor > Editor Settings**. Godot then runs the Gradle build each time you start the game from the editor, and does not start it if the build fails, so what you play is always what you wrote.

Once you see the greeting, you know the whole loop works: write, build, attach, run. The [User guide](../guide/index.md) covers everyday scripting with Godot-JVM, building and debugging your project, and exporting your game.
