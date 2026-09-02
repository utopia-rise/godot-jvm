---
description: Download the Godot-JVM GDExtension addon into your Godot project, and confirm it is listed and enabled in Project Settings.
---

# Install the addon

Download the `godot-jvm-addon-<version>.zip` archive from the [GitHub releases](https://github.com/utopia-rise/godot-jvm/releases) page and extract it into the root of your Godot project. The archive already starts with the `addons` directory, so preserve its directory structure. The extension manifest must be located at:

```
<project root>/addons/jvm/jvm.gdextension
```

Open the project in Godot `4.7.2` or newer, then select **Project > Project Settings > GDExtension**. Confirm that `res://addons/jvm/jvm.gdextension` is listed and enabled.

![Installed Godot-JVM GDExtension](../assets/img/gdextension-installed.png)

The addon manifest also selects the native JVM library used for each export target, so exporting needs the official Godot export template that matches your editor version. See [Export](../build/export/index.md) for JVM-specific export requirements.
