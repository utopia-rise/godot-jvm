---
description: Exporting to Android with Godot's Gradle build, the bundled GDExtension AAR, and configuring the d8 tool path, compile SDK, and minimum API level.
---

# Android

Export with Godot's Gradle build and the Android plugin AAR included in the addon. It connects Godot-JVM to Android's ART runtime, so no embedded JRE is needed.

Android exports require Godot's Gradle build:

1. Install the Android build template from **Project > Install Android Build Template**.
2. Enable **Gradle Build > Use Gradle Build** in the Android export preset.
3. Build the JVM project with `buildAndroid` or `buildAndroidRelease` before exporting.

Install the Android SDK build tools through Android Studio's SDK manager and set `ANDROID_SDK_ROOT`. The Gradle plugin uses them to convert your JARs to DEX format. It selects the newest installed build tools by default.

During export, Godot adds `addons/jvm/libs/android/debug/godot-jvm-debug.aar` or `addons/jvm/libs/android/release/godot-jvm-release.aar` automatically. If either file is missing, reinstall a complete Godot-JVM addon release before exporting.

## Configuration

To override SDK discovery or the minimum API level, use `d8ToolPath`, `androidCompileSdkDirectory`, and `androidMinApiLevel`. [Android, GraalVM and iOS inputs](../../reference/gradle-plugin/export-targets.md) lists their defaults and examples.
