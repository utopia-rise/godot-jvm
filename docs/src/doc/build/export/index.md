---
description: Build release artifacts and bundle the runtime needed by your export target.
---

# Export your game

## 1. Install export templates

Open **Editor > Manage Export Templates** and install the official templates matching the editor version, to supply Godot's platform executables. The addon supplies the JVM GDExtension; no custom Godot templates are needed.

## 2. Build your project

Select **Build Release** in Godot's toolbar and click **Run Gradle**, to prepare desktop release JARs. For another target, use the platform build action in its page below.

## 3. Prepare the runtime

Follow the target page so the exported game can execute your code:

- [Desktop](desktop.md): bundle an embedded JRE.
- [Android](android.md): use ART and prepare Android artifacts.
- [GraalVM native image](graalvm-native-image.md): compile a native image for desktop.
- [iOS](ios.md): build the native image required by iOS.

## 4. Create a preset and export

Open **Project > Export**, add an [export preset](https://docs.godotengine.org/en/stable/tutorials/export/exporting_projects.html) for your platform, and resolve missing-file warnings so all runtime artifacts are included. Click **Export Project** and choose a destination.

## 5. Run the exported build

Launch the exported executable to verify the same behavior as in the editor. Run it from a terminal if you need to inspect startup output. For a missing runtime warning, prepare the runtime for the preset's OS and architecture and export again.

!!! warning "Preserve runtime files"
    Do not wipe `user://` while the game is installed. It holds extracted runtime files. When clearing game data, delete only files your code created.

Details: [Reference](../../reference/gradle-plugin/export-targets.md).

Next: [Desktop](desktop.md).
