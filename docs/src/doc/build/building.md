---
description: Running a Gradle build from the Godot editor, your IDE, or the command line, choosing between the debug and release targets, and what a rebuild reloads.
---

# Building your project

Click **Run Gradle** in Godot's toolbar, use your IDE's Gradle panel, or run Gradle in a terminal at the project root.

## Targets

The build targets are `debug` (the default) and `release`. For a release build, run `buildRelease` or pass `-Prelease` to `build`.

Example:

/// tab | Windows
```shell
gradlew build -Prelease
gradlew buildRelease
```
///

/// tab | Unix
```bash
./gradlew build -Prelease
./gradlew buildRelease
```
///

Use `debug` during development for additional runtime checks. Use `release` for distribution; it omits those checks.

## What a rebuild reloads

After a successful build, the editor reloads `godot-bootstrap.jar` and `main.jar` automatically.

Choose **Fast Build** in the toolbar drop-down (or run `./gradlew fastBuild`) after a full build when only method bodies changed. [Packaging and build tasks](../reference/gradle-plugin/packaging-and-tasks.md) covers when a full build is required.

GraalVM native images cannot reload code. Rebuild and restart to apply changes.
