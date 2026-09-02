---
description: Building and exporting a GraalVM native image instead of an embedded JVM, including reflection, JNI, and resource configuration, and export feature flags.
---

# GraalVM native image

!!! danger
    If you intend to use GraalVM native image for your project, it should be considered from the beginning of your project and the configurations tested regularly! Adding GraalVM native image after the fact can be very hard to do! 

!!! warning
    Reloading code changes in the editor is not possible with native image, as it would require reloading the JVM itself.

!!! warning
    GraalVM native image is an advanced feature and requires a lot of work to support, especially if you rely on many third-party libraries.

On desktop platform, you can choose to build a [GraalVM native image](https://www.graalvm.org/reference-manual/native-image/). You first need to install GraalVM and its native-image tool. Then, set the `GRAALVM_HOME` environment variable to point to GraalVM's home folder.

On Windows, also set the `VC_VARS_PATH` environment variable to point to the vcvars bat file. This is mandatory so that Visual Studio's build tools can be initialized. (Example: `C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvars64.bat`)

In order to build a native image, configure the Gradle plugin like this and then invoke `buildGraalNativeImage` or `buildGraalNativeImageRelease`:
```kotlin
godot {
    graalVmHomeDirectory.set(File(System.getenv("GRAALVM_HOME")))
    windowsDeveloperVcVarsPath.set(File(System.getenv("VC_VARS_PATH")))
}
```

In order to use the generated native image, you can pass the `--java-vm-type=graal` argument to the engine, or simply change `godot_jvm_configuration.json` to set `vm_type` to `graal_native_image`.

## Reflection, libraries and JNI with native image

GraalVM native image performs AOT compilation. In order to be able to use reflection and JNI, you need to provide an additional configuration file.
This also applies to any third-party library you use that relies on reflection. You can find documentation on how to easily generate these configuration files [here](https://www.graalvm.org/reference-manual/native-image/Agent/).

Add the generated JSON files to the `graal` folder of your project (it is created the first time you build a GraalVM native image). Then add the `additionalGraalJniConfigurationFiles` and `additionalGraalReflectionConfigurationFiles` parameters like this:

```kotlin
godot {
    graalVmHomeDirectory.set(File(System.getenv("GRAALVM_HOME")))
    windowsDeveloperVcVarsPath.set(File(System.getenv("VC_VARS_PATH")))
    
    additionalGraalJniConfigurationFiles.set(arrayOf("my-jni-configuration-file.json", "another-conf.json"))
    additionalGraalReflectionConfigurationFiles.set(arrayOf("my-reflection-configuration-file.json", "another-conf.json"))
}
```

The same applies to resource files that should be added (basically any files in the `res` folder of your project or a dependency of it):

```kotlin
godot {
    graalVmHomeDirectory.set(File(System.getenv("GRAALVM_HOME")))
    windowsDeveloperVcVarsPath.set(File(System.getenv("VC_VARS_PATH")))
    
    additionalGraalJniConfigurationFiles.set(arrayOf("my-jni-configuration-file.json", "another-conf.json"))
    additionalGraalReflectionConfigurationFiles.set(arrayOf("my-reflection-configuration-file.json", "another-conf.json"))
    additionalGraalResourceConfigurationFiles.set(arrayOf("my-resource-configuration-file.json", "another-conf.json"))
}
```

## Exporting with a native image

The `main.jar` and `godot-bootstrap.jar` are compiled into a single `usercode` shared library, which is copied into `pck` during the export process. Similar to the regular export versions, the `usercode` shared library is copied to the `user://` dir. Don't forget to delete it when creating an uninstaller.

On desktop, you can add the feature `export-graal-native-image` to make your game run on GraalVM native image.
You can also use `export-all-jvm` to export both the JVM and the Native Image. By default, your export will use the same mode as the one used by the editor that exported it, but you can easily override this by using a command-line argument when launching.
