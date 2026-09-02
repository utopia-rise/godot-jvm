---
description: Attaching an IntelliJ remote debugger to a running Godot-JVM game with the --jvm-debug-port option, and guarding code behind GodotJvmBuildConfig.DEBUG.
---

# Debugging

## Prerequisites

To debug through an embedded JRE, that JRE must include the `jdk.jdwp.agent` module — see [Desktop export](export/desktop.md) for the full `jlink` command to build one. If you're using the JDK installed on your system instead of an embedded JRE, you don't need to do this.

## Run and attach a Remote Debugger

Breakpoint based debugging is available via the remote debugger.

### 1. Customize Run Instances in Godot

Open up the **Customize Run Instances** dialog from the **Debug** menu in Godot

![remote debug configuration_step_1](../assets/img/remote_debug_configuration_godot_menu.png)

### 2. Specify the arguments

In the **Main Run Args**, you should specify your commandline options. In the example below we use port `5005` by specifying: `--jvm-debug-port=5005`

!!! info
    If you specify either `--jvm-debug-port` or `--jvm-debug-address` the execution of the game will suspend until you attach a remote debugger. You can configure this behaviour by specifying `--jvm-wait-for-debugger=true` or `--jvm-wait-for-debugger=false`

![remote debug configuration_step_2](../assets/img/remote_debug_configuration_godot_dialog.png)

### 3. Create a new configuration in IntelliJ

Create a new **Configuration** using **Remote JVM Debug**

![remote debug configuration_step_3](../assets/img/remote_debug_configuration_intellij.png)

### 4. Setup the new configuration in IntelliJ

Use the same port as you used in step 2, in our case `5005`
![remote debug configuration_step_4](../assets/img/remote_debug_configuration.png)

### 5. Set a breakpoint in IntelliJ

![remote debug configuration_step_5](../assets/img/remote_debug_configuration_intellij_breakpoint.png)

### 6. Launch the game in Godot

Depending on your flags (`--jvm-wait-for-debugger`), the game will suspend until you attached the remote debugger from IntelliJ

### 7. Run the Debug Game configuration

Run the **Debug Game** configuration you made earlier in IntelliJ

![remote debug configuration_step_6](../assets/img/remote_debug_configuration_intellij_configuration.png)

### 8. Breakpoint

IntelliJ will now automatically pause when the breakpoint is hit

![remote debug configuration_step_7](../assets/img/remote_debug_configuration_intellij_breakpoint_hit.png)

## Write debug code

You can add code only for debug version of your project by using the generated `GodotJvmBuildConfig`.
When building your project with the release flag, those ifs are going to be automatically removed from your code, not even the condition check is left.

Example:

/// tab | Kotlin
```kotlin
import kotlincompile.definitions.GodotJvmBuildConfig

if (GodotJvmBuildConfig.DEBUG) {
    // ...
}
```
///

/// tab | Java
```java
import kotlincompile.definitions.GodotJvmBuildConfig;

if (GodotJvmBuildConfig.DEBUG) {
    // ...
}
```
///

/// tab | Scala
```scala
import kotlincompile.definitions.GodotJvmBuildConfig

if (GodotJvmBuildConfig.DEBUG) {
  // ...
}
```
///
