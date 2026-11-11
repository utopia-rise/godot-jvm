---
description: Build your JVM code from IntelliJ IDEA or Godot before running the game.
---

# Building your project

In IntelliJ IDEA, open **Run > Edit Configurations**, add a **Gradle** configuration for your project, and enter `build` as the task. Select that configuration and click **Run** after editing scripts.

In Godot, select **Build** in the toolbar drop-down and click **Run Gradle**. Run the scene with **Run Current Scene** (F6), or the project with **Run Project** (F5), following Godot's [scene workflow](https://docs.godotengine.org/en/stable/getting_started/step_by_step/nodes_and_scenes.html).

## Build when the game starts

The **Build on Run** button sits in the toolbar next to **Run Gradle** and is saved per project, in the editor's own data rather than in `project.godot`. A click switches between its two options, which decide what the play buttons, F5, and F6 do:

| Option | Icon | Builds first |
|---|---|---|
| Never (default) | dimmed hammer and wrench | never |
| Always | hammer and wrench in the accent color | always |

**Ctrl**+click a play button (**Cmd**+click on macOS) to build first whatever the option is.

A node whose script changed since the last build shows a configuration warning. A script counts as changed when its content differs from what the last debug build compiled: saving a file unchanged or reverting an edit clears the warning, while a comment-only change shows it until the next build.

The build blocks the editor until Gradle finishes. If it fails, the game does not start and the Gradle output opens in a window.

## What a rebuild reloads

After a successful build, the editor reloads `jvm/debug/godot-bootstrap.jar` and `jvm/debug/usercode.jar`, making the compiled classes and their registration available. Restart a running game to use the new build.

Select **Fast Build** only after a successful full build and only when method bodies changed. Use **Build** after changing registered classes, members, signatures, annotations, or dependencies.

Native images cannot reload code. Rebuild and restart to apply changes.

## Release builds

Select **Build Release** and click **Run Gradle** for distribution. **Build** writes the debug JARs into `jvm/debug/`; **Build Release** runs **Build** first, then merges a second compilation of your code against the release runtime libraries into a single `jvm/release/game.jar`. The two directories never overwrite each other, and the editor keeps using the debug JARs. A release export packs `jvm/release/`, an export with debug packs `jvm/debug/`, see [Export your game](export/index.md).

The equivalent IntelliJ Gradle tasks are `build`, `fastBuild`, and `buildRelease`.

If the wrapper is outside the Godot project, set **Project > Project Settings > Kotlin Jvm > Gradle > Gradle Wrapper Dir** to its directory.

Details: [Reference](../reference/gradle-plugin/tasks.md).

Next: [Debugging](debugging.md).
