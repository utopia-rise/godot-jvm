---
description: Short definitions for Godot-JVM-specific terms, from registrar and .gdj files to the JAR artifacts, Variant, and JDK versus JRE.
---

# Glossary

**Registrar**: Generated code that tells Godot which classes, properties, functions, and signals a JVM class exposes. The registrar generator produces it from the bytecode processor's validated model.

**`.gdj` file**: A generated registration file for a class that comes from an external dependency rather than the current Godot project's own source. Godot loads it the same way it loads a compiled script.

**`godot-bootstrap.jar`**: Built by your Gradle build into `jvm/`; loaded by the editor and bundled in exports. Contains the Godot API bindings, the startup/hot-reload code, and every dependency your project declared.

**`main.jar`**: The shadow JAR built from only your own compiled code and the generated registrar, with no dependencies, executed by `godot-bootstrap.jar` at runtime.

**`usercode`**: The GraalVM native artifact that replaces both JARs for ahead-of-time execution: a shared library on desktop or a static archive on iOS. It cannot reload code at runtime.

**Shadow/fat JAR**: A JAR that combines compiled classes from multiple inputs, often including dependencies, into one archive.

**Variant**: Godot's dynamically-typed value container. Godot-JVM converts between JVM types and `Variant` at the JNI boundary for every call that crosses into or out of the engine.

**Source set**: A Gradle concept: a named group of source directories (and their own dependencies) compiled together, such as the default `main` source set.

**FQCN (fully qualified class name)**: A class name including its full package path, for example `com.example.game.Player` rather than just `Player`.

**Embedded JRE**: A `jlink`-created Java Runtime Environment bundled with an exported project, so players don't need a JVM already installed on their machine.

**JDK vs JRE**: The JRE only *runs* Java programs; the JDK additionally contains the compiler and tooling needed to build them. Godot-JVM development requires the JDK.

**`res://` vs `user://`**: Godot's two built-in path prefixes. `res://` resolves inside the project's own resource tree (read-only once exported); `user://` resolves to a writable application data directory for the current user.
