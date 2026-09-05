---
description: Export your first Godot-JVM desktop build, to prove the whole pipeline works end to end before you write more of your game.
---

# Export a test build

Export your scene for your current desktop platform to check that the addon, compiled code, and bundled runtime work outside the editor.

## 1. Install export templates

Open **Editor > Manage Export Templates** and install the official templates matching your editor version.

## 2. Create the embedded JRE

A desktop export includes a JRE so players can run the game without installing Java. Generate it from your project root:

```shell
./gradlew generateEmbeddedJre
```

You can also choose **Generate JRE** in the toolbar drop-down and click **Run Gradle**.

This creates a minimal JRE under `jvm/` for your current platform. Reuse it between exports; regenerate it when you change the JDK or remove the generated directory.

The export needs a JRE matching the preset's OS and architecture. [Desktop](../build/export/desktop.md) explains how to prepare runtimes for other targets.

## 3. Create an export preset

Open **Project > Export...**, add a preset for your platform, and export. Godot includes the addon's native library automatically.

## 4. Run the exported build

Launch the exported executable from a terminal so you can see its output. You should see the same greeting as in the editor. If the export reports a missing JRE, run `generateEmbeddedJre` and export again; otherwise check the terminal output.

## Next

You now have a script running both in the editor and in an exported game. The next section builds on this project to cover everyday scripting with Godot-JVM.
