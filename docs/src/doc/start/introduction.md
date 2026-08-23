---
description: What Godot-JVM is, what this Start here track will have you do, and the Godot, Kotlin, Java, and Scala knowledge it assumes you already have.
---

# Introduction

Godot-JVM is a GDExtension addon that lets you write Godot game or application logic in Kotlin,
Java, or Scala instead of GDScript, by embedding a JVM inside the engine. Your classes are
annotated, compiled by a normal Gradle build, and attached to nodes the same way you would attach
a GDScript file.

This is the opening page of the **Start here** track. Continue to the next page once you have the background below.

## What these docs assume

This documentation covers what differs from GDScript-based Godot: the JVM languages, the Gradle
build, and the addon that connects them to the engine. It does not re-teach Godot itself, or
Kotlin, Java, or Scala as languages. For Godot itself, see
[docs.godotengine.org](https://docs.godotengine.org/).

### New to Godot

Work through Godot's own [Step by step
tutorial](https://docs.godotengine.org/en/stable/getting_started/step_by_step/index.html)
first. These docs assume you already know what a node, a scene tree, a
signal, and a resource are, and that you can find your way around the
Inspector and export templates.

### New to Kotlin

See [Kotlin's Getting Started
guide](https://kotlinlang.org/docs/getting-started.html). No prior Kotlin
experience is assumed to be already Godot-specific — just general language
familiarity.

### New to Java

See [dev.java's Learn section](https://dev.java/learn/). Any JDK 17+ feature
level is fine for Godot-JVM.

### New to Scala

See [Scala's Getting Started
guide](https://docs.scala-lang.org/getting-started/index.html). Scala
support follows the same registration model as Kotlin and Java throughout
this documentation.
