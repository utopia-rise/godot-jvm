---
description: Step-by-step guide to building a local Godot-JVM branch, using it in a game project, and testing changes while contributing.
---

# Test a change from a branch

This guide takes you from a source checkout to running your local Godot-JVM changes in a game project. Use it to reproduce a bug, try a proposed fix, or check your contribution before opening a pull request.

Godot-JVM has two parts that you build separately:

- **Gradle builds the JVM libraries and build tools.** These compile and package your game's Kotlin, Java, or Scala code and provide the Godot API it uses.
- **SCons builds the native GDExtension.** This is the C++ library that Godot loads to connect the engine to the JVM.

Build both from the same checkout so your game uses a consistent version of the binding. You run them with the official Godot editor; you do not need to build Godot itself.

If you want to work in the repository's existing test project instead of a separate game, follow [Build from source](build-from-source.md) and [Run the tests](running-tests.md). The harness uses the local Gradle source through included builds, and SCons writes its native library into the harness addon by default, so that workflow does not require publishing to Maven Local.

## 1. Check the build requirements

This workflow assumes the [build prerequisites](build-from-source.md) are available. Godot-JVM requires JDK 17 or newer with `JAVA_HOME` set: the native build uses it to locate the JNI headers.

Use `./gradlew.bat` in place of `./gradlew` on Windows.

## 2. Check out the branch

Clone your fork (replace the URL below with your fork's URL), or clone the main repository to test an existing branch:

```bash
git clone --recurse-submodules https://github.com/utopia-rise/godot-jvm.git
cd godot-jvm
git checkout <branch-name>
git submodule update --init --recursive
```

For an existing checkout, run the last two commands from its root.

The submodule command checks out the `godot-cpp` revision expected by your branch. Run it again whenever you switch branches or pull changes that update the submodule.

From here on, **repository root** means this `godot-jvm` directory. **Game project root** means the separate directory containing your game's `project.godot` and Gradle build files.

## 3. Prepare a game project

Use a copy of an existing Godot-JVM game, or create a small project using the [getting started guide](../start/install.md). A small scene that exercises your change makes it easier to tell whether the fix works.

Check the `godot` version in `kt/gradle/libs.versions.toml` in your checkout and download that official Godot editor version. Install the corresponding Godot-JVM addon release into the game project root as a starting point. Confirm that `addons/jvm/jvm.gdextension` exists: this manifest tells Godot which native library to load. You will replace that library with your local build in step 5.

Close the game in Godot before replacing its native library, especially on Windows where the loaded file may be locked.

## 4. Build and publish the JVM side locally

From the **repository root**, run:

```bash
cd kt
./gradlew publishArtifactsToMavenLocal
cd ..
```

This builds and publishes the Gradle plugin, registration tools, and both debug and release JVM libraries to **Maven Local**. Your game will resolve these local artifacts in place of a published release.

Use `publishArtifactsToMavenLocal`, rather than `publishToMavenLocal`: the aggregator also publishes the included builds and both library variants that a game needs.

After Gradle reports `BUILD SUCCESSFUL`, find the version directory under:

- Linux/macOS: `~/.m2/repository/com/utopia-rise/godot-gradle-plugin/`
- Windows: `%USERPROFILE%\.m2\repository\com\utopia-rise\godot-gradle-plugin\`

For an untagged commit, the version is `<godotJvm version>-<short commit hash>-SNAPSHOT`. Tagged commits can use a release version instead. Copy the exact version you just published; you will use it in step 6.

## 5. Build the native side into your game

From the **repository root**, run the command for your platform, replacing the example path with the absolute path to your game:

```bash
# Linux
scons platform=linux target=editor target_path="/absolute/path/to/your-project/addons/jvm/libs/"
```

```powershell
# Windows
scons platform=windows target=editor target_path="C:/absolute/path/to/your-project/addons/jvm/libs/"
```

```bash
# macOS
scons platform=macos target=editor target_path="/absolute/path/to/your-project/addons/jvm/libs/"
```

Keep the trailing `/` in `target_path`. The `editor` target builds the extension used inside the Godot editor. `target_path` puts it directly into your game's addon, so there is no manual copy step. Without that option, SCons writes to `harness/tests/addons/jvm/libs/` instead.

When SCons finishes, check that the library under your game's `addons/jvm/libs/<platform>/` has been updated.

## 6. Tell your game to use the local JVM artifacts

Edit the files in the **game project root**, not those in the Godot-JVM checkout.

In `settings.gradle.kts`, add `mavenLocal()` first in the existing `pluginManagement.repositories` block. Gradle searches this block for the Godot-JVM plugin:

```kotlin
pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}
```

In `build.gradle.kts`, add `mavenLocal()` first in the existing project `repositories` block too. This is where Gradle searches for the JVM libraries resolved by the plugin:

```kotlin
repositories {
    mavenLocal()
    mavenCentral()
}
```

Keep any other repositories and configuration your game already needs. Both repository blocks are required: finding the plugin alone does not make its libraries available.

In the game's existing `plugins` block, replace the Godot-JVM version with the exact version from step 4:

```kotlin
plugins {
    id("com.utopia-rise.godot-jvm") version "<published-version>"
}
```

## 7. Build the game and try your change

From the **game project root**, run:

```bash
./gradlew --refresh-dependencies build
```

This compiles your game against the local binding and generates its registrations and JARs. `--refresh-dependencies` asks Gradle to check for updated artifacts, including when you have republished the same snapshot version.

After `BUILD SUCCESSFUL`, open the game's `project.godot` with the editor selected in step 3 and run the scene that exercises your change. Check the Godot output for loading or script errors, then verify the behavior you intended to change. A successful build alone does not check how the C++ and JVM parts work together at runtime.

Before submitting a contribution, also [run the unit and integration tests](running-tests.md). If you built only into your own game, first run SCons again without `target_path` from the repository root to supply the harness's native library.

## 8. Repeat after making changes

Close Godot before rebuilding the native library, then repeat only the steps affected by your edits:

- **C++ or project-template changes:** rebuild with the SCons command from step 5. SCons also regenerates the project templates embedded in the extension.
- **JVM library or Gradle tooling changes:** repeat step 4, then rebuild your game with `--refresh-dependencies` as in step 7.
- **Changes to both sides:** rebuild both before testing again.

After creating a new commit, check the published version again and update the game's plugin version if it changed. Uncommitted edits can reuse the same snapshot version, which is why refreshing dependencies matters.

Reopen the game and repeat your test. Once you finish testing, restore the game's original plugin version and addon if you want to return to the released binding.

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
