---
description: Build your JVM code from IntelliJ IDEA or Godot before running the game.
---

# Building your project

In IntelliJ IDEA, open **Run > Edit Configurations**, add a **Gradle** configuration for your project, and enter `build` as the task. Select that configuration and click **Run** after editing scripts.

In Godot, select **Build** in the toolbar drop-down and click **Run Gradle**. Run the scene with **Run Current Scene** (F6), or the project with **Run Project** (F5), following Godot's [scene workflow](https://docs.godotengine.org/en/stable/getting_started/step_by_step/nodes_and_scenes.html).

## What a rebuild reloads

After a successful build, the editor reloads `godot-bootstrap.jar` and `main.jar`, making the compiled classes and their registration available. Restart a running game to use the new build.

Select **Fast Build** only after a successful full build and only when method bodies changed. Use **Build** after changing registered classes, members, signatures, annotations, or dependencies.

Native images cannot reload code. Rebuild and restart to apply changes.

## Release builds

Select **Build Release** and click **Run Gradle** for distribution. **Build** selects debug runtime artifacts with additional checks; **Build Release** selects release artifacts.

The equivalent IntelliJ Gradle tasks are `build`, `fastBuild`, and `buildRelease`. The `build` task also accepts `-Prelease`.

To build automatically before playing, enable **Editor > Editor Settings > Kotlin Jvm > Editor > Build Gradle Before Start**. If the wrapper is outside the Godot project, set **Project > Project Settings > Kotlin Jvm > Gradle > Gradle Wrapper Dir** to its directory.

Details: [Reference](../reference/gradle-plugin/tasks.md).

Next: [Debugging](debugging.md).
