---
description: Export your first Godot-JVM desktop build, to prove the whole pipeline works end to end before you write more of your game.
---

# Export a test build

You have a script running in the editor. Before writing more of your game, export one desktop
build now — it is much cheaper to find an export problem with one class than with a whole project's
worth of code, and this proves your build, addon, and embedded JRE all work outside the editor too.

## 1. Install export templates

This part is plain Godot, not specific to this project: open **Editor > Manage Export Templates**
and install the templates matching your editor version. See Godot's own
[Exporting projects](https://docs.godotengine.org/en/stable/tutorials/export/exporting_projects.html)
page if you have not done this before.

## 2. Create the embedded JRE

This part is Godot-JVM specific. A desktop export bundles a JRE alongside your game, and that JRE
has to be built once for your host platform:

```shell
./gradlew generateEmbeddedJre
```

This writes a minimal JRE under `jvm/` sized for your current OS. You only need to re-run it if you
change `JAVA_HOME` or clean the `jvm/` directory — not on every export.

!!! warning "Export from the platform you're targeting"
    The JRE this task creates is for your **current host OS**. A JRE built on macOS will not run on
    Windows. If you need to export for multiple desktop platforms, build on each one, or see
    [Desktop exports](../build/export/desktop.md) for the per-platform `jlink` commands.

## 3. Create an export preset

Also plain Godot: **Project > Export...**, add a preset for your platform, and export. Godot-JVM
needs nothing extra here — the `addons/jvm` directory, including `jvm.gdextension`, is already part
of your project from [installing the addon](install-the-addon.md), and Godot includes it
automatically for the platforms it supports.

## 4. Run the exported build

Run the exported executable directly (not through the editor). You should see the same output your
script produced in the editor. If the window opens and closes immediately, or the log shows a JVM
startup error, see [Export](../troubleshooting/export.md).

## What you just proved

A successful export means your build, the addon, and the embedded JRE all work outside the editor
too — not just in the editor's own JVM. The Start here track is complete.
