---
description: Running a Gradle build from the Godot editor, your IDE, or the command line, choosing between the debug and release targets, and what a rebuild reloads.
---

# Building your project

To compile your project, run a Gradle build — from the Godot editor's build button, your IDE's Gradle panel, or the command line. See [Your first script](../start/your-first-script.md) for a walkthrough with screenshots.

## Targets

We have two targets: `debug` and `release`.
In order to build in release, use the dedicated `buildRelease` task or add the `release` parameter to your Gradle build command.

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

Using debug builds is recommended when developing. It adds some sanity checks that are cut off in `release`.

Release builds are recommended when distributing to retail.

## What a rebuild reloads

After a successful build, the editor automatically reloads `godot-bootstrap.jar` and `main.jar` — you do not have to restart it. This holds no matter what kind of change you made: changing the body of a method needs only a rebuild, and so does adding, removing, or renaming a registered class, property, function, or signal. There is no separate registration step to run either way.

`fastBuild` rebuilds `main.jar` while reusing the last generated registration artifacts instead of rescanning your classes:

```shell
./gradlew fastBuild
```

Use it only when you changed implementation details that don't affect registration, such as a method body. It requires a previous successful full build, and it should not be used right after adding, removing, renaming, or otherwise structurally changing a registered class, function, property, or signal — run a normal `build` for that instead.

GraalVM native image builds are the one exception to all of this: while a native image is in use, nothing can be reloaded, since doing so would require restarting the JVM. See [GraalVM native image export](export/graalvm-native-image.md).

For how the editor reconciles physical scripts, virtual scripts, and JAR registrations behind the scenes, see [JAR and script reloading](../contribute/how-it-works/jar-and-script-reloading.md).
