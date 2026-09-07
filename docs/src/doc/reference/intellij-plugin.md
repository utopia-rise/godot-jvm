---
description: Godot editor build settings and IntelliJ registration inspection settings and actions.
---

# Editor and IDE settings

## Godot project settings

### `kotlin_jvm/gradle/gradle_wrapper_dir` { #gradle-wrapper-directory }

Type: directory path. Default: `res://`.

Directory containing `gradlew`/`gradlew.bat`, resolved through Godot's project paths. Used by the editor's Gradle runner. Configure it when the wrapper is outside the Godot project root.

## Godot editor settings

### `kotlin_jvm/editor/build_gradle_before_start` { #build-before-start }

Type: boolean. Default: `false`.

When true, the editor builds the Gradle project before starting the game. This is an editor setting, not a project setting or a JVM launch flag.

## IntelliJ settings

Location: **Settings > Godot-JVM**. Settings are stored per project.

### Annotation processing mode { #annotation-processing-mode }

Default: `Inferred`. Values: `Inferred`, `Explicit`, `Automatic`.

Controls registration inspections and highlighting. It does not change Gradle's registration mode. Match [`annotationProcessingMode`](gradle-plugin/registration.md#annotationprocessingmode) to keep IDE feedback consistent with the build.

### Registration highlighting

Type: boolean. Default: enabled. Controls registration-aware editor highlighting.

## Actions and scope

| Location/action | Effect |
|---|---|
| **New Project > Godot-JVM** | Creates a project with the selected JVM languages |
| Godot **Run Gradle** toolbar | Runs the selected build task |
| Godot **Fast Build** | Rebuilds JVM code using existing registration |
| Godot **Project > Tools > Kotlin/JVM > Generate JVM project** | Generates Gradle/project scaffolding |

The IntelliJ plugin provides registration inspections, code helpers, and project/script templates. The Godot built-in script editor does not provide JVM source editing support. Other editors can edit sources and run Gradle.

Installation and project creation are covered in [Create a project](../start/create-a-project.md#option-2-intellij-idea-wizard).
