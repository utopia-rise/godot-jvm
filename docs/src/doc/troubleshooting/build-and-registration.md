---
description: Fix editor Gradle launch failures, missing registered declarations, and disagreements between the editor and the build.
---

# Build and registration

Start with a successful full `build`, then check the missing declaration below. Registration checks run on compiled classes, so `fastBuild` cannot pick up a new or changed registration.

## Building from the editor fails with "Could not create child process: .../gradlew"

On Linux or macOS, the build can fail if `gradlew` is not executable:
```shell
ERROR: Godot-JVM: Could not create child process: /Users/username/projectname/gradlew
```

Run this command from the project root, then build again:
```shell
chmod +x gradlew
```

## Before you build

- Does the script extend a Godot class such as `Node` or `Resource`?
- If it has a constructor, is there a public constructor with no parameters?
  Godot can only instantiate a script through a public parameterless
  constructor; constructors with parameters are never exposed to Godot.
- Does every registered script have a unique Godot name? Use
  `@Script(className = "AUniqueName")` if two classes share the same simple name.
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
- In Explicit mode, is `@Script` directly present? In Inferred mode, is it present directly or through a meta-annotation?
- Does its registered name collide with another class?

## A property is missing

- Do the field and accessors have consistent names and types? The processor must recognize them as one property.
- Is its field or accessor public?
- Does the current registration mode select it?
- Is its type mappable to Godot?
- Is it a getter/setter-style method that was intentionally registered as a
  function instead (`@Register` without being annotated as a property with `@Visible`)?

## A function is missing

- Is it public and declared directly on the class (not only inherited)?
- Does the current registration mode select it?
- Is it an accessor-shaped method not annotated as a function (`@Register`)? Such
  a method stays a property unless `@Register` marks it as a function too.
- Are all parameter and return types mappable to Godot?
- Does it exceed the 16-parameter limit?

## A signal is missing

- Is the signal declared as a member of the script class?
- Does it use a `SignalN` type?
- In Explicit mode, does it have a direct `@Emit`?
- Is its containing class selected for registration?

## The editor and the build disagree

- Check that the IntelliJ **Settings > Godot-JVM > Annotation processing mode** setting matches `annotationProcessingMode` in `build.gradle.kts`
  before changing your code. Gradle decides what actually
  gets registered; the IDE setting only keeps inspections and highlighting
  consistent with it.
