---
description: Checklist for diagnosing why a script, property, function, or signal fails to register, or why the editor and Gradle build disagree.
---

# Build and registration

Work through the checklist that matches your symptom before changing any
code. See [Registration reference](../reference/registration.md) for the
annotation and mode selection rules, and
[Registration pipeline](../contribute/how-it-works/registration-pipeline.md)
for why registration is structured this way.

## Before you build

- Does the script extend a Godot class such as `Node` or `Resource`?
- If it has a constructor, is there a public constructor with no parameters?
  Godot can only instantiate a script through a public parameterless
  constructor; constructors with parameters are never exposed to Godot.
- Does every registered script have a unique Godot name? Use
  `@Script("AUniqueName")` if two classes share the same simple name.
- Do exposed properties and function parameters use Godot-supported types?
- Are the registered classes and functions non-generic?

Build again after adding, removing, renaming, or changing an exported
property, a signal, a function that Godot calls, or a script class. Changing
only the code inside an existing method does not require any additional
registration steps.

## A class is missing

- Does it inherit a Godot API class?
- Was its source language identified? Godot-JVM recognizes `.kt`, `.java`,
  and `.scala` source files; an unrecognized extension is skipped.
- Does the current registration mode select it?
- In Explicit or Inferred mode, is the required direct or effective
  `@Script` present?
- Does its registered name collide with another class?

## A property is missing

- Was it reconstructed as one logical property? A field and its accessors
  must line up consistently for the language adapter to merge them.
- Is its field or accessor public?
- Does the current registration mode select it?
- Is its type mappable to Godot?
- Is it an accessor-shaped method that was intentionally registered as a
  function instead (`@Register` without property intent)?

## A function is missing

- Is it public and declared directly on the class (not only inherited)?
- Does the current registration mode select it?
- Is it an accessor-shaped method without an explicit function intent? Such
  a method stays a property unless `@Register` marks it as a function too.
- Are all parameter and return types mappable to Godot?
- Does it exceed the 16-parameter limit?

## A signal is missing

- Was the source declaration reconstructed as a logical signal?
- Does it use a `SignalN` type?
- In Explicit mode, does it have a direct `@Emit`?
- Is its containing class selected for registration?

## The editor and the build disagree

- Check that the IntelliJ **Settings | Godot-JVM | Annotation processing
  mode** setting matches `annotationProcessingMode` in `build.gradle.kts`
  before changing any analyzer or build logic. Gradle decides what actually
  gets registered; the IDE setting only keeps inspections and highlighting
  consistent with it.
