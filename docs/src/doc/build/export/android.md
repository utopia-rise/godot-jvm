---
description: Exporting to Android with Godot's Gradle build, the bundled GDExtension AAR, and configuring the d8 tool path, compile SDK, and minimum API level.
---

# Android

Android uses its ART runtime, so no embedded JRE is needed.

Export with [Godot's Android Gradle build](https://docs.godotengine.org/en/stable/tutorials/export/android_gradle_build.html) and the Android plugin AAR included in the addon.

Android exports require Godot's Gradle build:

1. Install the Android build template from **Project > Install Android Build Template**.
2. Enable **Gradle Build > Use Gradle Build** in the Android export preset.
3. Select **Build Android Release** in Godot's toolbar and click **Run Gradle** before exporting (`buildAndroidRelease` in IntelliJ). Use **Build Android** / `buildAndroid` for a debug build.

Install the Android SDK build tools through Android Studio's SDK manager and set `ANDROID_SDK_ROOT`. The Gradle plugin uses them to convert your JARs to DEX format. It selects the newest installed build tools by default.

During export, Godot adds `addons/jvm/libs/android/debug/godot-jvm-debug.aar` or `addons/jvm/libs/android/release/godot-jvm-release.aar` automatically. If either file is missing, reinstall a complete Godot-JVM addon release before exporting.

## Configuration

To override SDK discovery or the minimum API level, use `d8ToolPath`, `androidCompileSdkDirectory`, and `androidMinApiLevel`. [Android, GraalVM and iOS inputs](../../reference/gradle-plugin/export-targets.md) lists their defaults and examples.

Details: [Reference](../../reference/gradle-plugin/export-targets.md).

Next: [GraalVM native image (optional target)](graalvm-native-image.md).
