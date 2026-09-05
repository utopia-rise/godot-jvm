---
description: Add JVM libraries to your project and publish your own Godot-JVM library with isLibrary.
---

# Libraries

## Add a library

Add a library like any Gradle dependency in `build.gradle.kts`:

```kotlin
dependencies {
    implementation("some.library:some-artifact:<version>")
}
```

If the library contains registered Godot classes, the build also generates registration files under `gdj/<library>/`. Attach those files to nodes in the Godot editor.

## Platform caveats

- **Android:** choose libraries that support Android's runtime.
- **GraalVM native image:** libraries that use reflection, JNI, or classpath resources need native-image configuration.

[GraalVM native image](export/graalvm-native-image.md) explains the configuration files needed for those dependencies.

## Publish your own library

A Godot-JVM library shares registered Godot classes with other Godot-JVM projects.

If your library does not register Godot classes, publish it as a regular JVM library without the Godot-JVM plugin.

To build a reusable Godot-JVM library, enable library mode:

```kotlin
godot {
    isLibrary.set(true)
}
```

Library mode keeps language compilation and Godot dependencies, and produces a JAR named after the Gradle project. It skips registration generation, `.gdj` files, and application packaging.

Keep registration annotations on the library's classes. The consuming project scans them and generates the registrar code and `.gdj` files.

Publish the resulting JAR with your usual Maven publishing setup, or share the project locally through a Gradle composite build.
