---
description: Alphabetical index of every godot block option, plus task and editor settings references.
---

# Gradle options index

Plugin ID: `com.utopia-rise.godot-jvm`. Options below belong to the `godot { ... }` block in **`build.gradle.kts`**, independently of the language used for gameplay scripts. Paths are resolved as specified by each option.

## Options

| Option | Reference |
|---|---|
| [`android.compileSdkDirectory`](export-targets.md#androidcompilesdkdirectory) | Export options |
| [`android.d8ToolPath`](export-targets.md#androidd8toolpath) | Export options |
| [`android.minApiLevel`](export-targets.md#androidminapilevel) | Export options |
| [`apiJsonFile`](packaging-and-tasks.md#custom-godot-api-bindings) | Packaging options |
| [`godotProjectDirectory`](registration.md#godotprojectdirectory) | Registration settings |
| [`graal.additionalJniConfigurationFiles`](export-targets.md#graaladditionaljniconfigurationfiles) | Export options |
| [`graal.additionalReflectionConfigurationFiles`](export-targets.md#graaladditionalreflectionconfigurationfiles) | Export options |
| [`graal.additionalResourceConfigurationFiles`](export-targets.md#graaladditionalresourceconfigurationfiles) | Export options |
| [`graal.homeDirectory`](export-targets.md#graalhomedirectory) | Export options |
| [`graal.strictImageHeapEnabled`](export-targets.md#graalstrictimageheapenabled) | Export options |
| [`graal.verbose`](export-targets.md#graalverbose) | Export options |
| [`graal.windowsDeveloperVcVarsPath`](export-targets.md#graalwindowsdevelopervcvarspath) | Export options |
| [`isCustomApiEnabled`](packaging-and-tasks.md#custom-godot-api-bindings) | Packaging options |
| [`isGodotCoroutinesEnabled`](packaging-and-tasks.md#isgodotcoroutinesenabled) | Packaging options |
| [`isLibrary`](packaging-and-tasks.md#islibrary) | Packaging options |
| [`languages`](languages-and-toolchains.md#languages) | Languages and toolchains |
| [`registration.annotationProcessingMode`](registration.md#registrationannotationprocessingmode) | Registration settings |
| [`registration.disableGdj`](registration.md#registrationdisablegdj) | Registration settings |
| [`registration.gdjFilesDirectory`](registration.md#registrationgdjfilesdirectory) | Registration settings |
| [`registration.gdjFilesIndentation`](registration.md#registrationgdjfilesindentation) | Registration settings |
| [`registration.gdjFilesLayoutMode`](registration.md#registrationgdjfileslayoutmode) | Registration settings |
| [`registration.incrementalFullBuildThreshold`](packaging-and-tasks.md#registrationincrementalfullbuildthreshold) | Packaging options |
| [`registration.nameMode`](registration.md#registrationnamemode) | Registration settings |
| [`toolchain.javaVersion`](languages-and-toolchains.md#toolchainjavaversion) | Languages and toolchains |
| [`toolchain.kotlinVersion`](languages-and-toolchains.md#toolchainkotlinversion) | Languages and toolchains |
| [`toolchain.scalaVersion`](languages-and-toolchains.md#toolchainscalaversion) | Languages and toolchains |

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
