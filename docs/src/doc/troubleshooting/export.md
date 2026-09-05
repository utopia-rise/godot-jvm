---
description: Fix missing export JREs, Android AARs, and deleted runtime files in exported Godot-JVM games.
---

# Export

## Missing JRE for the export target

**Symptom:** the export fails with `JRE does not exist at res://jvm/jre-...`.

**Explanation:** Godot selects the JRE directory from the export preset's OS and architecture, not the export host.

**Fix:** create a JRE for that target with a matching JDK in `jvm/jre-<amd64|arm64>-<linux|windows|macos>`. A universal macOS export needs both architectures.

## Android export fails because an AAR file is missing

**Symptom:** exporting to Android fails because
`addons/jvm/libs/android/debug/godot-jvm-debug.aar` or
`addons/jvm/libs/android/release/godot-jvm-release.aar` is missing.

**Explanation:** Godot adds one of these files automatically during export;
Godot-JVM's addon package must already contain it.

**Fix:** reinstall a complete Godot-JVM addon release before exporting.

## Runtime files deleted from user://

**Symptom:** clearing game data deletes runtime JARs and breaks the next launch.

**Fix:** restrict cleanup to your game's own files so runtime files remain available.
