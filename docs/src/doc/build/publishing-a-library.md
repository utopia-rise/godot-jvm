---
description: What a Godot-JVM library is, enabling library mode with isLibrary to produce a plain library jar, and publishing it like any other JVM library.
---

# Publishing a Godot-JVM library

## What a Godot-JVM library is

A Godot-JVM library is basically the equivalent of a Godot addon, but specifically for use in other Godot-JVM projects such as games or applications. It is a regular JVM library built with the Godot Gradle plugin in library mode.

!!! info "When you need this"
    If you build a library which does not register any classes to Godot, you can just create a regular JVM library, and you will have no need for this page.

## Setting up a library project

The basic project setup is the same as for regular Godot-JVM projects. Head over to [Start here](../start/index.md) to set up the basics of the project.

To build a reusable Godot-JVM library, enable library mode:

```kotlin
godot {
    isLibrary.set(true)
}
```

In this mode the plugin keeps the enabled language compile setup and Godot dependencies, but skips registrar scanning, registrar generation, `.gdj` generation and synchronization, and the runtime jar packaging used for a standalone Godot project (`main.jar`, `godot-bootstrap.jar`, and the Godot project copy pipeline). Instead it produces a regular library jar named after the Gradle project.

Registered classes can still live inside the library — the consuming Godot-JVM project scans the library from its dependency graph and generates the registrar files and `.gdj` files for them itself. See [Using JVM libraries](using-libraries.md) for what that looks like from the consuming side.

All registration-related Gradle settings only matter in the consuming Godot project, because that is where registrar files and `.gdj` files are actually generated.

## Publishing

Since library mode leaves you with a standard library jar named after the Gradle project, publishing it works exactly like publishing any other JVM library: use the same Maven or composite-build workflows you already use for regular JVM libraries.
