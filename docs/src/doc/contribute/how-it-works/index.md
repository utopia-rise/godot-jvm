---
description: The path a class takes from source to a running node, the three build artifacts, and a learning-ordered map of the How it works pages.
---

# Where to start

These chapters explain Godot-JVM's internal design and the responsibilities of each component. Read them in order: artifacts and memory management establish the foundation for registration, callbacks, and reloading.

## The path one class takes

You run a Gradle build; your Kotlin, Java or Scala sources are compiled to bytecode, a processor
scans that bytecode for the classes you registered, a registrar is generated from what it finds,
and everything is packaged into two JARs that are copied into `res://jvm/`. The Godot-JVM addon
loads those JARs, and that is how the editor and the running game learn about your classes.

```mermaid
flowchart LR
    subgraph build["Your Gradle build"]
        direction TB
        src["Player.kt"]
        cls["compiled bytecode"]
        reg["generated registrar entry"]
        jar["main.jar"]
        src --> cls --> reg --> jar
    end

    subgraph editor["Godot editor"]
        direction TB
        addon["jvm addon loads<br/>res://jvm/main.jar"]
        node["Node in your scene"]
        addon --> node
    end

    jar ==> addon
    src -. "com.example.game.Player" .-> node
```

The solid arrows follow compiled code. The dotted arrow shows how the attached source file identifies a class: Godot reads its package and class name, then resolves that fully qualified name to the compiled class in `main.jar`.

The diagram follows a project class attached through its source file. Dependency classes use generated `.gdj` files because their source is outside the Godot project. Both identify compiled classes for Godot to load.

## The three artifacts

```mermaid
flowchart LR
    subgraph artifacts["Build artifacts"]
        direction TB
        boot["godot-bootstrap.jar"]
        main["main.jar"]
        user["usercode<br/>(native image only)"]
    end

    subgraph edit["Edit time"]
        direction TB
        e1["Loaded into the<br/>editor's JVM"]
        e2["Reloaded after<br/>every build"]
        e1 --> e2
    end

    subgraph export["Export time"]
        direction TB
        g1["Bundled with<br/>the game"]
        g2["Bootstrap runs<br/>your code"]
        g1 --> g2
    end

    boot ==> e1
    main ==> e1
    boot ==> g1
    main ==> g1
    user -. "native image export:<br/>replaces both JARs" .-> export
```

1. **[The three build artifacts](artifacts.md)**: what `godot-bootstrap.jar`, `main.jar`, and the
   GraalVM native-image `usercode` output each contain, and when each one is used.
2. **[Memory management](memory-management.md)**: how Godot's object bindings and the JVM garbage
   collector are reconciled, and why `RefCounted` script instances need a weak JNI reference.
3. **[The JNI shared buffer](shared-buffer.md)**: the per-thread buffer used to exchange call arguments and return values, and its memory layout.
4. **[Registration pipeline](registration-pipeline.md)**: how annotated Kotlin, Java, and Scala
   code becomes classes and members Godot knows about.
5. **[Registrar generation](registrar-generation.md)**: how the bytecode processor and the
   registrar generator turn a validated model into registration glue code.
6. **[Signals and callables](signals-and-callables.md)**: the handwritten runtime layer
   underneath signals and callables, and the generated typed arity families above it.
7. **[JAR and script reloading](jar-and-script-reloading.md)**: how the editor reconciles script
   resources with classes from the project JAR after a rebuild.
