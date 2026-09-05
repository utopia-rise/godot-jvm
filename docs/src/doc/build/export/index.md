---
description: What happens when you export a Godot-JVM game: JARs bundled into the PCK, copied to user:// at first run, plus links to per-platform requirements.
---

# Export overview

To export your game, use the official export templates that match your Godot editor version. Godot reads `addons/jvm/jvm.gdextension` to include the native JVM library for the selected export target.

Godot packages the game's JARs in the PCK. Desktop exports also copy the project's JRE into the export directory.

The following chapters cover each target's additional requirements:

- [Desktop](desktop.md): embedded JRE creation.
- [Android](android.md): Godot's Gradle build and the Android SDK build tools.
- [iOS](ios.md): static linking with GraalVM-compiled archives.
- [GraalVM native image](graalvm-native-image.md): ahead-of-time compilation instead of an embedded JVM.

## Files copied to user://

The JVM needs filesystem paths to load `godot-bootstrap.jar` and `main.jar`. On launch, Godot-JVM copies them from `res://` to `user://` when they are missing or their MD5 hashes differ; on Android it recopies them on every launch. Include these extracted files in your uninstaller's cleanup.

!!! warning "Preserve runtime files"
    Do not wipe `user://` while the game is installed. It holds the extracted runtime JARs, Android DEX JARs, or native-image library. When clearing game data, delete only files your code created.
