To export your game, use the official export templates that match your Godot editor version. Godot must meet the minimum version required by your Godot-JVM release. Ensure the `addons/jvm` directory, including `jvm.gdextension`, is part of your project before exporting. Godot reads this manifest to include the native JVM library for the selected export target.

After the templates have been installed, you can export your game. Your game `jar` will be included in `pck`.
On desktop platforms, this also copies the JRE folder of your project in the exported game folder.


## Requirements

To export your game, you need to have an embedded JRE created. Run the following command within your project's root.

- amd64 systems:
    ```shell
    jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux
    ```
- arm64 systems:
    ```shell
    jlink --add-modules java.base,java.logging --output jvm/jre-arm64-macos
    ```

!!! info
    As the jre is platform dependent, you need to create a jre for each platform. Adjust the above command on a per-platform basis:    
    - For Linux: `jvm/jre-amd64-linux`  
    - For Windows: `jvm/jre-amd64-windows`    
    - For MacOS:  
        - `jvm/jre-amd64-macos`  
        - `jvm/jre-arm64-macos`    
    - For iOS and Android, no embedded JRE is needed

The above command will create a very minimal JVM, if you need extra features you can include the following modules:

- `jdk.jdwp.agent` to enable remote debugging
- `jdk.management.agent` to enable JMX.

*Special note for MacOS*: To create a universal app, you'll need both amd64 and arm64 JRE. You can create an amd64 JRE
by using `jlink` with rosetta and an amd64 JDK on an arm64 MacOS.

!!!warning Correct JRE for desktops
    For desktop exports you need to make exports based on the platform you're on, as exporting will copy the generated jre folder to
    your export. An MacOS JRE will not work on Windows, so you'll need a Windows host to export for Windows.

Alternatively we provide a configurable gradle task which generates the JRE for your current host OS:
`./gradlew generateEmbeddedJre`

The task can be configured like so:
```kotlin
tasks.withType<GenerateEmbeddedJreTask> {
    // the values in this example are the default values of the task
    // defaults to JAVA_HOME, falling back to the JVM running Gradle. Must point to a JDK (jlink is required).
    this.javaHome = System.getenv("JAVA_HOME")
    this.arguments = arrayOf(
        "--strip-debug",
        "--no-header-files",
        "--no-man-pages",
    ) // arguments to pass to the jlink command
    this.modules = arrayOf(
        "java.base",
        "java.logging",
    ) // java module to include in the jre
}
```

## Specifics

`godot-bootstrap.jar` and `main.jar` are copied into `pck` during the export process.
As a real file path is needed to handle them, they are copied on the first game version start
from `res://` to `user://` (we check if they exist and also check the md5 hash) to only update when needed.
Don't forget to remove them when writing an uninstaller for your game.

## Android

!!! warning
    If you plan to export your game to android, make sure the libraries you use, are actually compatible with android.

The Godot-JVM addon includes a Godot Android v2 plugin AAR. The AAR contains the Android GDExtension libraries and a small Java entry point that gives the extension access to Android's existing ART virtual machine. You do not need to install a JRE on the device.

Android exports require Godot's Gradle build:

1. Install the Android build template from **Project > Install Android Build Template**.
2. Enable **Gradle Build > Use Gradle Build** in the Android export preset.
3. Build the JVM project with `buildAndroid` or `buildAndroidRelease` before exporting.

/// tab | build.gradke.kts
```kt
godot {
    d8ToolPath.set(File("${System.getenv("ANDROID_SDK_ROOT")}/build-tools/36.0.0/d8"))
    androidCompileSdkDirectory.set(File("${System.getenv("ANDROID_SDK_ROOT")}/platforms/android-36"))
}
```
///

The project JARs must still be converted to `.dex` format. The Godot-JVM Gradle plugin handles this, but it requires the Android SDK build tools. Install them with Android Studio's SDK manager and set `ANDROID_SDK_ROOT`.

!!! warning
    Ensure you have the build tools version 35 or newer installed!

During export, Godot adds `addons/jvm/libs/android/debug/godot-jvm-debug.aar` or `addons/jvm/libs/android/release/godot-jvm-release.aar` automatically. If either file is missing, reinstall a complete Godot-JVM addon release before exporting.

### Configuration
While our gradle plugin is able to automatically find the newest installed build tools (if the env variable `ANDROID_SDK_ROOT` is properly set), it sometimes is required to manually set the build tools version. This can be done optionally like so:

- Setting the `d8` tool:
    ```kt
    godot {
        d8ToolPath.set(File("${System.getenv("ANDROID_SDK_ROOT")}/build-tools/36.0.0/d8"))
    }
    ```

- Setting the `androidCompileSdkDirectory` to your target SDK version (most of the time, you want to set it to the newest version available):
    ```kt
    godot {
        androidCompileSdkDirectory.set(File("${System.getenv("ANDROID_SDK_ROOT")}/platforms/android-36"))
    }
    ```

- Setting the `androidMinApiLevel` (equivalent to the `--min-api` argument of `d8`), default is `21`:
    ```kt
    godot {
        androidMinApiLevel.set(22)
    }
    ```

!!!danger
    Similar to the desktop targets, the game copies the needed jar files to the `user://` directory upon first execution or if the files have changed. On Android this is the applications `files` folder. If you do IO operations on Android, never empty the whole `files` folder! Only delete what you have added or exclude the following two files when clearing the `files` folder: `godot-bootstrap-dex.jar` and `main-dex.jar`.

## GraalVM Native Image

!!! warning
    GraalVM Native Image is an advanced feature and requires a lot of work to support. Especially if you rely on many third party libraries.

In order to build for graalvm, configure `graalVmHomeDirectory` and then use `buildGraalNativeImage` or `buildGraalNativeImageRelease`. See the `GraalVM native-image` section in [advanced user guide](./advanced/graal-vm-native-image.md).

The `main.jar` and `godot-bootstrap.jar` are compiled into a single `usercode` shared library is copied into `pck` during the export process. Similar to the regular export versions, the `usercode` shared library is copied to the `user://` dir. Don't forget to delete it when creating an uninstaller.

On desktop, you can add the feature `export-graal-native-image` to make your game run on GraalVM Native Image. 
You can also use `export-all-jvm` to export both the JVM and the Native Image. By default, your export will use the same mode as the one used by the editor that exported it, but you can easily override this by using a command-line argument when launching.

## iOS

!!! warning
    With this export you don't have a choice regarding JVM version you use. Please use [GraalVM 23.1.3](https://download.oracle.com/graalvm/21/latest/graalvm-jdk-21_macos-aarch64_bin.tar.gz).

iOS uses static linking. `buildIOS` produces `jvm/ios/usercode.a` together with the matching
`libjava-release.a` and `libjvm-release.a`. During export, Godot links these archives with the
Godot-JVM iOS GDExtension archive into the application executable; they are not loaded at runtime.
Run `buildIOS` (or `buildIOSRelease`) before exporting the Godot project.

Additionally, to the regular GraalVM configuration mentioned above, add the following in `build.gradle.kts`, then invoke `buildIOS` or `buildIOSRelease`:

```kotlin
godot {
    graalVmHomeDirectory.set(File("Path to your GraalVM install")) // or set up GRAALVM_HOME.
}
```
