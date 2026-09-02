---
description: Symptoms and fixes for problems that surface specifically when exporting a Godot-JVM game to desktop, Android, iOS, or a GraalVM native image.
---

# Export

## Building from the editor fails with "Could not create child process: .../gradlew"

**Symptom:** an Android, iOS, or GraalVM native-image build invoked through
the Gradle plugin (`buildAndroid`, `buildIOS`, `buildGraalNativeImage`, and
their `Release` variants) fails on Linux or macOS with an error naming
`gradlew`.

**Explanation:** this is the same underlying issue as the general
Godot-editor build error described in
[Build and run](../build/building.md) — the `gradlew` script lost its
executable bit, often because the project was created from the IntelliJ
template.

**Fix:** `chmod +x gradlew` in the project root, then export again.

## Wrong JRE architecture for the export platform

**Symptom:** a desktop export fails to start, or fails at export time,
because the embedded JRE does not match the target platform.

**Explanation:** desktop exports copy the JRE folder generated for the host
you exported from. A JRE built for macOS will not run on Windows, and an
amd64 JRE will not run on arm64 (or vice versa).

**Fix:** export desktop platforms from a host running that platform, and
generate a JRE per platform beforehand (see
[Desktop export](../build/export/desktop.md)). For a universal macOS build,
generate both an amd64 and an arm64 JRE.

## Android export fails because an AAR file is missing

**Symptom:** exporting to Android fails because
`addons/jvm/libs/android/debug/godot-jvm-debug.aar` or
`addons/jvm/libs/android/release/godot-jvm-release.aar` is missing.

**Explanation:** Godot adds one of these files automatically during export;
Godot-JVM's addon package must already contain it.

**Fix:** reinstall a complete Godot-JVM addon release before exporting.

## Don't clear the whole `user://` (or Android `files/`) folder

**Symptom:** clearing your game's save/data directory as part of your own
IO code also deletes the JVM runtime jars, breaking the next launch.

**Explanation:** on first run (or whenever the files changed), the exported
game copies `godot-bootstrap.jar` and `main.jar` from `res://` into
`user://` so they have a real file path. On Android, `user://` is the app's
`files` folder, and the copied names are `godot-bootstrap-dex.jar` and
`main-dex.jar`.

**Fix:** never wipe the whole `user://` or `files/` folder from your own
code. Only delete files your game itself added, or explicitly exclude the
runtime jars from any bulk clear. Also remember to delete them yourself when
writing an uninstaller.

## GraalVM native image does not reload code changes

**Symptom:** editing a script while running a GraalVM native-image build has
no effect, even after rebuilding.

**Explanation:** native image is ahead-of-time compiled; picking up a change
would require reloading the JVM itself, which native image does not support.

**Fix:** none — this is a native-image limitation, also listed in
[Known limitations](known-limitations.md). Use the regular embedded or
dynamic JVM mode while iterating, and switch to native image only for the
builds where you need it.
