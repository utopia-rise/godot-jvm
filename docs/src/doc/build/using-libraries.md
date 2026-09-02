---
description: Adding regular or Godot-JVM dependencies to a project, finding the generated registration files for library classes, and export compatibility caveats.
---

# Using JVM libraries

## Regular JVM libraries

Regular JVM libraries can be used the same way as for regular Gradle projects:

```kotlin
// build.gradle.kts

dependencies {
    implementation("some.library:some-artifact:<some_version>")
}
```

## Godot-JVM libraries

Godot-JVM libraries can also be used the same way as for regular Gradle projects:

```kotlin
//build.gradle.kts

dependencies {
    implementation("some.library:some-artifact:<some_version>")
}
```

But, during compilation, registration files for the registered classes in these libraries are generated for you,
so you can use those and attach them to nodes in the Godot editor.
These registration files for those libraries are grouped by the source project name inside your
configured root directory for registration files:

```
[registrationFilesDirectory]/
├── libraryA/
│   └── ClassFromLibraryA.gdj
├── libraryB/
│   └── ClassFromLibraryB.gdj
└── // your own registration files
```

The folder structure configuration is the same as you configured for your own project, just inside the `<library_name>/` directory for each external project.

## Dependency caveats

- **Android** — only depend on libraries that are actually compatible with Android; the exported jars are converted to `.dex` format, and a dependency that assumes a full desktop JVM stack can fail there. See [Android export](export/android.md).
- **GraalVM native image** — AOT compilation means any dependency that relies on reflection or JNI needs its own GraalVM configuration, supplied through `additionalGraalJniConfigurationFiles`, `additionalGraalReflectionConfigurationFiles`, or `additionalGraalResourceConfigurationFiles`. See [GraalVM native image export](export/graalvm-native-image.md).
