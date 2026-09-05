---
description: Compile JVM code into a GraalVM native image, configure reflection and JNI, and select it for desktop exports.
---

# GraalVM native image

Compile your JVM code into a native library with [GraalVM native image](https://www.graalvm.org/reference-manual/native-image/). Install GraalVM and its `native-image` tool, then set `GRAALVM_HOME` to the installation directory.

Test native-image builds early. Dependencies that use reflection, JNI, or classpath resources may need extra configuration. Native images cannot reload code in the editor; rebuild and restart to apply changes.

On Windows, also set `VC_VARS_PATH` to Visual Studio's `vcvars64.bat` file so the build can initialize the compiler tools.

## Configure the build

Use GraalVM's [tracing agent](https://www.graalvm.org/reference-manual/native-image/Agent/) to generate configuration for reflection, JNI, and resources. Run the agent against a JVM build, then create a `graal/` directory at your project root and put the JNI configuration there; `additionalGraalJniConfigurationFiles` is resolved relative to that directory. Reflection and resource files are passed to native-image as written, so give absolute paths (the example uses `file(...).absolutePath`).

This complete example includes path overrides and additional configuration files. The path settings are only needed to override `GRAALVM_HOME` and `VC_VARS_PATH`; omit configuration entries your project does not need.

```kotlin
godot {
    graalVmHomeDirectory.set("/path/to/graalvm")
    windowsDeveloperVcVarsPath.set("C:/path/to/VC/Auxiliary/Build/vcvars64.bat")
    additionalGraalJniConfigurationFiles.set(arrayOf("jni-config.json"))
    additionalGraalReflectionConfigurationFiles.set(arrayOf(file("graal/reflect-config.json").absolutePath))
    additionalGraalResourceConfigurationFiles.set(arrayOf(file("graal/resource-config.json").absolutePath))
}
```

Run `buildGraalNativeImage` or `buildGraalNativeImageRelease`. To run the result in the editor, pass `--jvm-vm-type=graal_native_image` or set `vm_type` to `graal_native_image` in `godot_jvm_configuration.json`.

## Exporting with a native image

`main.jar` and `godot-bootstrap.jar` are compiled into one `usercode` shared library. Desktop exports package it in the PCK and extract it to `user://` at runtime. Include the extracted library in your uninstaller's cleanup.

Add the desktop export feature `export-graal-native-image` to use the native image, or `export-all-jvm` to include both the JVM and native-image builds. Without an override, the export uses the editor's runtime mode. A launch argument can select a different mode.
