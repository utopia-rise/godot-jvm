---
description: Compile JVM code into a native image for desktop distribution.
---

# GraalVM native image

## 1. Install the toolchain

Install [GraalVM and native-image](https://www.graalvm.org/reference-manual/native-image/) and set `GRAALVM_HOME` to its installation directory. On Windows, also set `VC_VARS_PATH` to Visual Studio's `vcvars64.bat`.

## 2. Configure dependencies

Use GraalVM's [tracing agent](https://www.graalvm.org/reference-manual/native-image/Agent/) on a JVM build to collect configuration for dependencies using reflection, JNI, or classpath resources. Put the resulting files in a `graal/` directory at the project root.

!!! warning "Configuration paths use different bases"
    Additional JNI configuration paths are relative to `graal/`. Reflection and resource paths are passed as written; use absolute paths, as below.

Keep only entries for files your project needs. The first two settings override the environment variables and are optional.

```kotlin
godot {
    graal.homeDirectory.set("/path/to/graalvm")
    graal.windowsDeveloperVcVarsPath.set("C:/path/to/VC/Auxiliary/Build/vcvars64.bat")
    graal.additionalJniConfigurationFiles.set(arrayOf("jni-config.json"))
    graal.additionalReflectionConfigurationFiles.set(arrayOf(file("graal/reflect-config.json").absolutePath))
    graal.additionalResourceConfigurationFiles.set(arrayOf(file("graal/resource-config.json").absolutePath))
}
```

## 3. Build and run

Select **Build Graal Native Image Release** in Godot's toolbar and click **Run Gradle** (`buildGraalNativeImageRelease` in IntelliJ). Use **Build Graal Native Image** for debug builds.

Set `"useNativeImage": true` in `godot_jvm_configuration.json` to run the game with the native image.
The launch argument `--jvm-use-native-image` selects the same mode. It also works for the editor when explicitly
requested, but scripts cannot reload in native-image mode.

!!! warning "Restart after changes"
    Native images cannot reload code. Rebuild and restart after editing scripts.

## 4. Export and test

In the desktop [export preset](https://docs.godotengine.org/en/stable/tutorials/export/exporting_projects.html), set **Godot Jvm > Runtime** to **Graal**, click **Export Project**, and launch the exported game. The native image is the `usercode` library. See the [Desktop runtime table](desktop.md#choose-the-bundled-runtime) for the other packaging choices.

Details: [Reference](../../reference/gradle-plugin/export-targets.md).

Next: [iOS (optional target)](ios.md).
