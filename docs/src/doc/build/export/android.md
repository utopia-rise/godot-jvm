---
description: Exporting to Android with Godot's Gradle build, the bundled GDExtension AAR, and configuring the d8 tool path, compile SDK, and minimum API level.
---

# Android

!!! warning
    If you plan to export your game to android, make sure the libraries you use, are actually compatible with android.

The Godot-JVM addon includes a Godot Android v2 plugin AAR. The AAR contains the Android GDExtension libraries and a small Java entry point that gives the extension access to Android's existing ART virtual machine. You do not need to install a JRE on the device.

Android exports require Godot's Gradle build:

1. Install the Android build template from **Project > Install Android Build Template**.
2. Enable **Gradle Build > Use Gradle Build** in the Android export preset.
3. Build the JVM project with `buildAndroid` or `buildAndroidRelease` before exporting.

The project JARs must still be converted to `.dex` format. The Godot-JVM Gradle plugin handles this, but it requires the Android SDK build tools. Install them with Android Studio's SDK manager and set `ANDROID_SDK_ROOT`, which is the variable the Godot-JVM Gradle plugin reads. It discovers the newest installed build tools by default; configure a path manually only when that discovery does not fit your SDK installation.

!!! warning
    Ensure you have the build tools version 35 or newer installed!

During export, Godot adds `addons/jvm/libs/android/debug/godot-jvm-debug.aar` or `addons/jvm/libs/android/release/godot-jvm-release.aar` automatically. If either file is missing, reinstall a complete Godot-JVM addon release before exporting.

## Configuration
When automatic discovery is not appropriate, configure the Android SDK inputs explicitly:

- Setting the `d8` tool:
    ```kotlin
    godot {
        d8ToolPath.set("${System.getenv("ANDROID_SDK_ROOT")}/build-tools/36.0.0/d8")
    }
    ```

- Setting the `androidCompileSdkDirectory` to your target SDK version (most of the time, you want to set it to the newest version available):
    ```kotlin
    godot {
        androidCompileSdkDirectory.set("${System.getenv("ANDROID_SDK_ROOT")}/platforms/android-36")
    }
    ```

- Setting the `androidMinApiLevel` (equivalent to the `--min-api` argument of `d8`), default is `21`:
    ```kotlin
    godot {
        androidMinApiLevel.set(22)
    }
    ```

!!! danger
    Similar to the desktop targets, the game copies the needed jar files to the `user://` directory upon first execution or if the files have changed. On Android this is the applications `files` folder. If you do IO operations on Android, never empty the whole `files` folder! Only delete what you have added or exclude the following two files when clearing the `files` folder: `godot-bootstrap-dex.jar` and `main-dex.jar`.
