---
description: The godot { } properties that select the annotation-processing mode and control where .gdj registration files are written.
---

# Registration output

Use these settings to select registered declarations, locate the Godot project, and control dependency registration files.

## Registration selection

### `annotationProcessingMode`

Controls how classes and members are selected for registration.

Default: `AnnotationProcessingMode.Inferred`

```kotlin
import godot.annotation.processor.classgraph.AnnotationProcessingMode

godot {
    annotationProcessingMode.set(AnnotationProcessingMode.Inferred)
}
```

The available modes are:

- `Explicit`: only direct selection annotations count.
- `Inferred`: direct annotations and recursively implied annotations count;
  signals and compatible Godot overrides are also discovered.
- `Automatic`: all compatible declarations in Godot classes are selected;
  annotations remain useful as configuration.

In IntelliJ IDEA, choose the same mode under **Settings > Godot-JVM > Annotation processing mode**. Gradle determines what is registered; the IDE setting keeps inspections consistent with the build.

## Godot project layout and registration output

Project classes use source files. These settings locate the Godot project and control generated `.gdj` files for dependency classes.

### `godotProjectDirectory`

Directory that contains `project.godot`.

Default:

- the current Gradle project directory

Use this when the Gradle project lives in a subdirectory:

```kotlin
godot {
    godotProjectDirectory.set(file(".."))
}
```

### `registrationFilesDirectory`

Base directory where newly created external-dependency `.gdj` registration files are written. Classes from the current Godot project use their source files directly.

Default:

- `<godotProjectDirectory>/gdj`

Example:

```kotlin
godot {
    registrationFilesDirectory.set(file("custom-gdj"))
}
```

### `disableGdj`

Disables external-dependency `.gdj` registration file handling while keeping class scanning and registrar generation enabled.

Default:

- `false`

Example:

```kotlin
godot {
    disableGdj.set(true)
}
```

When enabled, the plugin:

- still scans compiled user code for registered classes
- still generates registrar sources/resources
- skips scanning the Godot project for existing `.gdj` files
- skips staged `.gdj` generation
- skips copying, replacing, or deleting `.gdj` files in the Godot project

### `registrationFilesLayoutMode`

Controls how `.gdj` files are laid out inside each library's directory under `registrationFilesDirectory`.

Values:

- `RegistrationFileLayoutMode.FLAT`: write `.gdj` files directly into the library's directory
- `RegistrationFileLayoutMode.HIERARCHICAL`: mirror the package hierarchy before the `.gdj` file

Default:

- `RegistrationFileLayoutMode.FLAT`

Example:

```kotlin
import godot.registrar.generator.RegistrationFileLayoutMode

godot {
    registrationFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
}
```

### `registrationFilesIndentation`

Controls the indentation used inside generated `.gdj` files.

Values:

- `RegistrationFileIndentation.SPACE`
- `RegistrationFileIndentation.TAB`

Default:

- `RegistrationFileIndentation.SPACE`

Example:

```kotlin
import godot.registrar.generator.RegistrationFileIndentation

godot {
    registrationFilesIndentation.set(RegistrationFileIndentation.TAB)
}
```

### `registrationNameMode`

Controls how default registered names are computed when `@Script` does not provide a custom name.

Values:

- `RegisteredNameMode.SIMPLE_NAME`: use the simple class name
- `RegisteredNameMode.FQ_NAME`: use the fully qualified class name
- `RegisteredNameMode.PROJECT_PREFIX`: use the simple class name for the current project, and prefix external classes with their source project name

Default:

- `RegisteredNameMode.SIMPLE_NAME`

Example:

```kotlin
import godot.registrar.generator.RegisteredNameMode

godot {
    registrationNameMode.set(RegisteredNameMode.FQ_NAME)
}
```
