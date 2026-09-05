---
description: Attach IntelliJ IDEA's remote JVM debugger to Godot and keep development-only code out of release builds.
---

# Debugging

Attach IntelliJ IDEA's remote JVM debugger to set breakpoints and inspect your running game.

An embedded JRE needs the `jdk.jdwp.agent` module; a full system JDK includes it. [Desktop](export/desktop.md) explains how to add runtime modules.

## In Godot

Open Godot's [run-instance settings](https://docs.godotengine.org/en/stable/tutorials/scripting/debug/overview_of_debugging_tools.html) with **Debug > Customize Run Instances** and add `--jvm-debug-port=5005` to **Main Run Args**.

![Customize Run Instances menu](../assets/img/remote_debug_configuration_godot_menu.png)

![Main Run Args with the debug port](../assets/img/remote_debug_configuration_godot_dialog.png)

The game waits for a debugger when you set a debug port or address. Add `--jvm-wait-for-debugger=false` to let it start immediately.

## In IntelliJ IDEA

1. Add a **Remote JVM Debug** run configuration named **Debug Game**.
2. Set the host to `localhost` and the port to `5005`.
3. Set a breakpoint in your script.
4. Run the scene or project in Godot, then start **Debug Game** in IntelliJ IDEA.

![Remote JVM Debug configuration](../assets/img/remote_debug_configuration_intellij.png)

Execution pauses at the breakpoint so you can inspect variables and step through the code.

`godot_jvm_configuration.json` in the project root stores persistent runtime settings. See the Reference below for its keys and all JVM flags.

Details: [Reference](../reference/runtime-configuration.md).

Next: [Libraries](libraries.md).
