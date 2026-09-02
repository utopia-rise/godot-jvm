---
description: The godot { } properties that select the annotation-processing mode and control where .gdj registration files are written.
---

# Registration output

These settings control how classes and members are selected for registration, and where the plugin looks for the Godot project and writes `.gdj` registration files for external dependencies.

## Registration selection

### `registration.annotationProcessingMode`

Controls how classes and members are selected for registration.

Default: `AnnotationProcessingMode.Inferred`

```kotlin
import godot.annotation.processor.classgraph.AnnotationProcessingMode

godot {
    registration {
        annotationProcessingMode.set(AnnotationProcessingMode.Inferred)
    }
}
```

The available modes are:

- `Explicit`: only direct selection annotations count.
- `Inferred`: direct annotations and recursively implied annotations count;
  signals and compatible Godot overrides are also discovered.
- `Automatic`: all compatible declarations in Godot classes are selected;
  annotations remain useful as configuration.

For the complete selection rules, see the
[registration reference](../registration.md). If you use the IntelliJ
plugin, select the same mode under
**Settings | Godot-JVM | Annotation processing mode** so its
inspections and highlighting match the Gradle build — see the
[IntelliJ IDEA plugin](../intellij-plugin.md) page.

## Godot project layout and registration output

These settings control where the plugin looks for the Godot project and where it writes `.gdj` registration files for external dependencies.

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

### `registration.gdjFilesDirectory`

Base directory where newly created external-dependency `.gdj` registration files are written. Classes from the current Godot project use their source files directly.

The plugin creates this directory only when it has a generated `.gdj` file to write there.

Default:

- `<godotProjectDirectory>/gdj`

Example:

```kotlin
godot {
    registration {
        gdjFilesDirectory.set(file("custom-gdj"))
    }
}
```

### `registration.disableGdj`

Disables external-dependency `.gdj` registration file handling while keeping class scanning and registrar generation enabled.

Default:

- `false`

Example:

```kotlin
godot {
    registration {
        disableGdj.set(true)
    }
}
```

When enabled, the plugin:

- still scans compiled user code for registered classes
- still generates registrar sources/resources
- skips scanning the Godot project for existing `.gdj` files
- skips staged `.gdj` generation
- skips copying, replacing, or deleting `.gdj` files in the Godot project

### `registration.gdjFilesLayoutMode`

Controls how `.gdj` files are laid out inside each project directory.

Values:

- `RegistrationFileLayoutMode.FLAT`: write `.gdj` files directly into the project directory
- `RegistrationFileLayoutMode.HIERARCHICAL`: mirror the package hierarchy before the `.gdj` file

Default:

- `RegistrationFileLayoutMode.FLAT`

Example:

```kotlin
import godot.registrar.generator.RegistrationFileLayoutMode

godot {
    registration {
        gdjFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
    }
}
```

### `registration.gdjFilesIndentation`

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
    registration {
        gdjFilesIndentation.set(RegistrationFileIndentation.TAB)
    }
}
```

### `registration.nameMode`

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
    registration {
        nameMode.set(RegisteredNameMode.FQ_NAME)
    }
}
```
