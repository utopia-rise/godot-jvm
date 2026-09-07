---
template: home.html
hide:
  - navigation
description: Build Godot games in Kotlin, Java, or Scala with the Godot-JVM GDExtension addon.
---

<div class="home-hero" markdown>

# Godot-JVM

<img src="logo/logo-512.png" alt="Godot-JVM logo" width="256" height="256">

</div>

Godot-JVM brings Kotlin, Java, and Scala to the Godot engine. It is a GDExtension addon that embeds a JVM in the editor and in your exported games, so you write gameplay code in the language and tooling you already trust while keeping the official editor, scenes, and asset pipeline exactly as they are.

Godot-JVM 1.0.0 is production-ready and released under the MIT license. Begin with [Start here](start/index.md) to install the addon, create a project, run your first script, and export a build.

## Why Godot-JVM

- **Three languages, one binding.** Kotlin, Java, and Scala are first-class citizens with the same annotations, the same Godot API, and the same build pipeline. Gameplay examples use tabs for all three languages.
- **The full Godot API, typed.** Every engine class, method, property, signal, and enum is generated from Godot's own API description, so you get completion, navigation, and compile-time checking for the whole engine.
- **Feels like GDScript, compiles like the JVM.** Annotate a class with `@Script`, extend a Godot node, override `_ready()` or `_process()`, and attach it to a node. Exported properties appear in the Inspector, signals connect in the editor, and enums, bitfields, and property hints all carry over.
- **Fast iteration.** Build from the Godot editor, IntelliJ IDEA, or the command line. After a successful build the editor reloads your code automatically, without a restart.
- **The JVM ecosystem at your fingertips.** Add any Maven or Gradle dependency, share code between projects as a Godot-JVM library, and use Kotlin coroutines to suspend until a signal fires.
- **Ships everywhere Godot ships.** Export to Windows, Linux, macOS, Android, and iOS with an embedded runtime. On desktop, you can also compile your code to a GraalVM native image and ship it in place of a bundled JRE.

## A script in each language

/// tab | Kotlin

```kotlin
@Script
class Player : Node() {
    override fun _ready() {
        GD.print("Hello from Kotlin")
    }
}
```

///

/// tab | Java

```java
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

```scala
@Script
class Player extends Node {
  override def _ready(): Unit = {
    GD.print("Hello from Scala")
  }
}
```

///

## Tooling

- **IntelliJ IDEA plugin.** Create a new Godot-JVM project and scripts from a wizard, and let the IDE warn you as you type when something will not register correctly with Godot.
- **Gradle plugin.** One plugin builds your project end to end: it compiles your code, prepares it for Godot, and packages everything the editor and your exported game need. You never have to wire these steps up yourself.
- **Godot editor integration.** Kotlin, Java, and Scala show up as script languages in the editor, and a toolbar button runs the build for you, so you can stay in Godot while testing a scene.
- **Example projects.** Start from the [Godot-JVM project template](https://github.com/utopia-rise/godot-kotlin-project-template) or explore the [Godot-JVM 3D demo](https://github.com/utopia-rise/godot-kotlin-3d-demo) to see a complete game.

## Requirements

[Compatibility and versions](start/compatibility.md) lists the exact versions and supported platforms.

## Where to go next

- [Start here](start/index.md) walks from installation to a first exported build.
- [User guide](guide/index.md) covers writing gameplay code, building, debugging, libraries, and every export target.
- [FAQ](faq.md) answers common questions about builds, runtime, exports, and known limitations.
- [Reference](reference/index.md) holds the exact rules: annotations, property hints, the Gradle plugin, and a GDScript to JVM mapping.

## Community

Ask questions and discuss development on [Discord](https://discord.gg/zpb5Ru7v9x). Report bugs through [GitHub issues](https://github.com/utopia-rise/godot-jvm/issues), and follow the project at [utopia-rise/godot-jvm](https://github.com/utopia-rise/godot-jvm).
