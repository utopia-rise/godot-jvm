---
description: Testing an unreleased Godot-JVM branch in your own game by publishing its Gradle artifacts to mavenLocal and building the native library into the addon.
---

# Test a change from a branch

Test an unreleased branch in your game by publishing its Gradle artifacts locally and building its native library into your addon. Use artifacts from the same branch for both sides.

!!! warning
    Back up your project before testing unreleased changes.

After republishing the same snapshot version, run `./gradlew --refresh-dependencies build` in your game project so Gradle uses the updated artifacts.

1. Ensure `JAVA_HOME` is set. JDK 17 or newer is required.
2. Download the Godot-JVM addon release for the branch's minimum supported Godot version and extract it into your project's root. Confirm that `addons/jvm/jvm.gdextension` exists.
3. Clone this repository and switch to the branch you want to test:

    ```bash
    git clone --recurse-submodules git@github.com:utopia-rise/godot-jvm.git
    cd godot-jvm
    git checkout <branch-name>
    ```

4. Publish the branch's Gradle artifacts locally:

    ```bash
    cd kt
    ./gradlew publishArtifactsToMavenLocal
    ```

5. Build the native GDExtension directly into your project's addon. Run this from the repository root and replace the platform and absolute project path as needed:

    ```bash
    scons platform=linux target=editor target_path=/absolute/path/to/your-project/addons/jvm/libs/
    ```

6. Configure your project's `settings.gradle.kts` to use `mavenLocal()`:

    ```kotlin
    pluginManagement {
        repositories {
            mavenLocal()
            mavenCentral()
            gradlePluginPortal()
            google()
        }
    }

    rootProject.name = "your-project-name"
    ```

7. Find the published snapshot version in `~/.m2/repository/com/utopia-rise/godot-gradle-plugin/` and use that exact version in your project.
8. Build the project, then open or run it with the official Godot editor version supported by the branch.

## Test an Android export

From the Godot-JVM repository root, build the Android native libraries. The default output is the local staging directory `build/android/`:

```bash
scons platform=android target=template_debug arch=arm64
scons platform=android target=template_release arch=arm64
scons platform=android target=template_debug arch=x86_64
scons platform=android target=template_release arch=x86_64
```

Package them into the Android plugin AARs:

```bash
./kt/gradlew -p kt :android-plugin:assemble
```

Copy the resulting AARs into the addon in the project being tested:

```bash
mkdir -p /absolute/path/to/your-project/addons/jvm/libs/android/debug
mkdir -p /absolute/path/to/your-project/addons/jvm/libs/android/release
cp kt/android-plugin/build/outputs/aar/godot-jvm-debug.aar /absolute/path/to/your-project/addons/jvm/libs/android/debug/
cp kt/android-plugin/build/outputs/aar/godot-jvm-release.aar /absolute/path/to/your-project/addons/jvm/libs/android/release/
```

In Godot, install the Android build template and enable **Gradle Build > Use Gradle Build** in the Android export preset. Build your project with `buildAndroid` (or `buildAndroidRelease`) before exporting so its JVM code is converted to DEX. The exported APK chooses the matching debug or release AAR automatically.
