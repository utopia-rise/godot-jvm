---
description: The godot { } inputs that configure Android d8/SDK paths, minimum API level, and the GraalVM native-image and iOS build tasks.
---

# Android, GraalVM and iOS inputs

These properties supply SDK paths and native-image configuration to the platform build tasks.

## Android build inputs

Used by:

- `buildAndroid`
- `buildAndroidRelease`

The Android export tasks are compatible with configuration cache, so `buildAndroid` and lower-level Android packaging tasks can be run with `--configuration-cache`.

### `d8ToolPath`

Path to the `d8` executable used for dex generation, as a string.

Default:

- the `d8` executable of the highest-named `build-tools` directory under `$ANDROID_SDK_ROOT`, when one is found

```kotlin
godot {
    d8ToolPath.set("${System.getenv("ANDROID_SDK_ROOT")}/build-tools/36.0.0/d8")
}
```

### `androidCompileSdkDirectory`

Path to the Android platform directory used for compilation, as a string.

Default:

- the highest-named directory under `$ANDROID_SDK_ROOT/platforms` that contains an `android.jar`, when one is found

```kotlin
godot {
    androidCompileSdkDirectory.set("${System.getenv("ANDROID_SDK_ROOT")}/platforms/android-36")
}
```

### `androidMinApiLevel`

Minimum Android API level passed to `d8`.

Default:

- `21`

```kotlin
godot {
    androidMinApiLevel.set(21)
}
```

## GraalVM and iOS build inputs

Used by:

- `buildGraalNativeImage`
- `buildGraalNativeImageRelease`
- `buildIOS`
- `buildIOSRelease`

The desktop GraalVM and iOS export tasks are also compatible with configuration cache.

### `graalVmHomeDirectory`

Path to the GraalVM home directory, as a string. It is used to locate the `native-image` executable.

Default:

- the value of the `GRAALVM_HOME` environment variable, when it is set

```kotlin
godot {
    graalVmHomeDirectory.set(System.getenv("GRAALVM_HOME"))
}
```

### `windowsDeveloperVcVarsPath`

Windows-only path to the Visual Studio VCVARS script used by native-image builds, as a string.

Default:

- the value of the `VC_VARS_PATH` environment variable, when it is set

```kotlin
godot {
    windowsDeveloperVcVarsPath.set(System.getenv("VC_VARS_PATH"))
}
```

### `additionalGraalJniConfigurationFiles`

Additional JNI configuration files, resolved relative to the project's `graal/` directory.

```kotlin
godot {
    additionalGraalJniConfigurationFiles.set(
        arrayOf("jni-config.json")
    )
}
```

### `additionalGraalReflectionConfigurationFiles`

Additional reflection configuration files passed directly to native-image. Use absolute paths so they resolve regardless of the build's working directory.

```kotlin
godot {
    additionalGraalReflectionConfigurationFiles.set(
        arrayOf(file("graal/reflect-config.json").absolutePath)
    )
}
```

### `additionalGraalResourceConfigurationFiles`

Additional resource configuration files passed directly to native-image. Use absolute paths so they resolve regardless of the build's working directory.

```kotlin
godot {
    additionalGraalResourceConfigurationFiles.set(
        arrayOf(file("graal/resource-config.json").absolutePath)
    )
}
```

### `isGraalNativeImageVerboseEnabled`

Turns on verbose mode for native-image generation.

Default:

- `false`

```kotlin
godot {
    isGraalNativeImageVerboseEnabled.set(true)
}
```
