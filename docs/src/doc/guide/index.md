---
description: How this section is organized — exposing your code to Godot, calling into the Godot API from your code, and the runtime behaviour to know about.
---

# Write your game

This section covers day-to-day work writing a Godot-JVM game once your
project is set up. It is split into three parts: **Exposing your code to
Godot** covers making your Kotlin, Java, or Scala classes something Godot can
see and call — registration, classes, properties, enums, functions, signals and callables,
abstract classes, and attaching scripts. **Calling into Godot** covers using the Godot API from
your own code — Godot's types and logging. **Runtime behaviour**
covers how your code behaves once it is running — object lifetime and
coroutines.

## Exposing your code to Godot

- [Registering your code](registration.md)
- [Classes](classes.md)
- [Properties](properties.md)
- [Enums and bitfields](enums-and-bitfields.md)
- [Functions](functions.md)
- [Signals and callables](signals-and-callables.md)
- [Abstract classes](abstract-classes.md)
- [Attaching scripts and .gdj files](attaching-scripts.md)

## Calling into Godot

- [Godot types](godot-types.md)
- [Logging and errors](logging-and-errors.md)

## Runtime behaviour

- [Object lifetime](object-lifetime.md)
- [Coroutines](coroutines.md)
