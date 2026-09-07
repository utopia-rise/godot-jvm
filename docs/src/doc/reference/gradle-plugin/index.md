---
description: Alphabetical index of every godot block option, plus task and editor settings references.
---

# Gradle options index

Plugin ID: `com.utopia-rise.godot-jvm`. Options below belong to the `godot { ... }` block in **`build.gradle.kts`**, independently of the language used for gameplay scripts. Paths are resolved as specified by each option.

## Options

| Option | Reference |
|---|---|
| [`additionalGraalJniConfigurationFiles`](export-targets.md#additionalgraaljniconfigurationfiles) | Export options |
| [`additionalGraalReflectionConfigurationFiles`](export-targets.md#additionalgraalreflectionconfigurationfiles) | Export options |
| [`additionalGraalResourceConfigurationFiles`](export-targets.md#additionalgraalresourceconfigurationfiles) | Export options |
| [`androidCompileSdkDirectory`](export-targets.md#androidcompilesdkdirectory) | Export options |
| [`androidMinApiLevel`](export-targets.md#androidminapilevel) | Export options |
| [`annotationProcessingMode`](registration.md#annotationprocessingmode) | Registration settings |
| [`d8ToolPath`](export-targets.md#d8toolpath) | Export options |
| [`disableGdj`](registration.md#disablegdj) | Registration settings |
| [`godotProjectDirectory`](registration.md#godotprojectdirectory) | Registration settings |
| [`graalVmHomeDirectory`](export-targets.md#graalvmhomedirectory) | Export options |
| [`isGodotCoroutinesEnabled`](packaging-and-tasks.md#isgodotcoroutinesenabled) | Packaging options |
| [`isGraalNativeImageVerboseEnabled`](export-targets.md#isgraalnativeimageverboseenabled) | Export options |
| [`isLibrary`](packaging-and-tasks.md#islibrary) | Packaging options |
| [`javaVersion`](languages-and-toolchains.md#javaversion) | Languages and toolchains |
| [`kotlinVersion`](languages-and-toolchains.md#kotlinversion) | Languages and toolchains |
| [`languages`](languages-and-toolchains.md#languages) | Languages and toolchains |
| [`registrarIncrementalFullBuildThreshold`](packaging-and-tasks.md#registrarincrementalfullbuildthreshold) | Packaging options |
| [`registrationFilesDirectory`](registration.md#registrationfilesdirectory) | Registration settings |
| [`registrationFilesIndentation`](registration.md#registrationfilesindentation) | Registration settings |
| [`registrationFilesLayoutMode`](registration.md#registrationfileslayoutmode) | Registration settings |
| [`registrationNameMode`](registration.md#registrationnamemode) | Registration settings |
| [`scalaVersion`](languages-and-toolchains.md#scalaversion) | Languages and toolchains |
| [`windowsDeveloperVcVarsPath`](export-targets.md#windowsdevelopervcvarspath) | Export options |

## Tasks and related settings

- [Gradle tasks](tasks.md): public build targets, outputs, and embedded JRE generation.
- [Editor and IDE settings](../intellij-plugin.md): editor build behavior and annotation inspections.
- [Runtime settings](../runtime-configuration.md): JVM launch arguments and JSON configuration.

## Debug build constant


Guard development-only code with the generated `GodotJvmBuildConfig.DEBUG` constant. Release builds remove the guarded code and its condition check.

Example:

/// tab | Kotlin
```kotlin
import kotlincompile.definitions.GodotJvmBuildConfig

if (GodotJvmBuildConfig.DEBUG) {
    // ...
}
```
///

/// tab | Java
```java
import kotlincompile.definitions.GodotJvmBuildConfig;

if (GodotJvmBuildConfig.DEBUG) {
    // ...
}
```
///

/// tab | Scala
```scala
import kotlincompile.definitions.GodotJvmBuildConfig

if (GodotJvmBuildConfig.DEBUG) {
  // ...
}
```
///
