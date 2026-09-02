---
description: Short definitions for Godot-JVM-specific terms, from registrar and .gdj files to the JAR artifacts, Variant, and JDK versus JRE.
---

# Glossary

**Registrar**
: Generated code that tells Godot which classes, properties, functions, and signals a JVM class exposes. Produced by the registrar-generator from the model the class-graph symbol processor builds.

**`.gdj` file**
: A generated registration file for a class that comes from an external dependency rather than the current Godot project's own source. Godot loads it the same way it loads a compiled script.

**`godot-bootstrap.jar`**
: The JAR shipped alongside the editor and bundled with exported games that contains the Godot API bindings, the startup/hot-reload code, and every dependency your project declared.

**`main.jar`**
: The shadow JAR built from only your own compiled code and the generated registrar — no dependencies — executed by `godot-bootstrap.jar` at runtime.

**`usercode`**
: The GraalVM native-image shared library that replaces both `godot-bootstrap.jar` and `main.jar` when a project is exported with ahead-of-time compilation. No runtime code reloading is possible while it's used.

For the full relationship between these artifacts, see [The three build artifacts](../contribute/how-it-works/artifacts.md).

**Shadow/fat jar**
: A JAR that bundles its dependencies' classes inside itself, so it can run standalone without a separate classpath.

**Variant**
: Godot's dynamically-typed value container. Godot-JVM converts between JVM types and `Variant` at the JNI boundary for every call that crosses into or out of the engine.

**Source set**
: A Gradle concept: a named group of source directories (and their own dependencies) compiled together, such as the default `main` source set.

**FQCN (fully qualified class name)**
: A class name including its full package path, for example `com.example.game.Player` rather than just `Player`.

**Embedded JRE**
: A `jlink`-created Java Runtime Environment bundled with an exported project, so players don't need a JVM already installed on their machine.

**JDK vs JRE**
: The JRE only *runs* Java programs; the JDK additionally contains the compiler and tooling needed to build them. Godot-JVM development requires the JDK.

**`res://` vs `user://`**
: Godot's two built-in path prefixes. `res://` resolves inside the project's own resource tree (read-only once exported); `user://` resolves to a writable, per-installation data directory.
