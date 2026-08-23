---
description: What happens when you export a Godot-JVM game — jars bundled into the pck, copied to user:// at first run, plus links to per-platform requirements.
---

# Export overview

To export your game, use the official export templates that match your Godot editor version. Godot must meet the minimum version required by your Godot-JVM release. Ensure the `addons/jvm` directory, including `jvm.gdextension`, is part of your project before exporting. Godot reads this manifest to include the native JVM library for the selected export target.

After the templates have been installed, you can export your game. Your game `jar` will be included in `pck`.
On desktop platforms, this also copies the JRE folder of your project in the exported game folder.

Each export target has its own extra requirements:

- [Desktop](desktop.md) — embedded JRE creation.
- [Android](android.md) — Godot's Gradle build and the Android SDK build tools.
- [iOS](ios.md) — static linking with GraalVM-compiled archives.
- [GraalVM native image](graalvm-native-image.md) — ahead-of-time compilation instead of an embedded JVM.

## Specifics

`godot-bootstrap.jar` and `main.jar` are copied into `pck` during the export process.
As a real file path is needed to handle them, they are copied on the first game version start
from `res://` to `user://` (we check if they exist and also check the md5 hash) to only update when needed.
Don't forget to remove them when writing an uninstaller for your game.
