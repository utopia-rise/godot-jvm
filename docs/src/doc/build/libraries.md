---
description: Add JVM dependencies or publish a library of reusable Godot scripts.
---

# Libraries

## Add a dependency

Add the library's coordinates to `build.gradle.kts`, click **Load Gradle Changes** in IntelliJ IDEA, then build:

```kotlin title="build.gradle.kts"
dependencies {
    implementation("some.library:some-artifact:<version>")
}
```

Replace the placeholder with the library's group, artifact, and version. If it supplies Godot scripts, attach the generated [registration files (.gdj)](../guide/registration-files.md).

Choose Android-compatible libraries for Android. Dependencies using reflection, JNI, or classpath resources may need [native-image configuration](export/graalvm-native-image.md).

## Publish a Godot-JVM library

Keep registration annotations on the library's classes and enable library mode in `build.gradle.kts`:

```kotlin title="build.gradle.kts"
plugins {
    `maven-publish`
    // Keep the existing Godot-JVM plugin declaration.
}

group = "com.example"
version = "1.0.0"

godot {
    isLibrary.set(true)
}

publishing {
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
        }
    }
}
```

Merge these blocks into the existing build file. Library mode produces a JAR named after the Gradle project and skips application packaging. The consuming project registers the library's scripts and generates their registration files (.gdj).

In IntelliJ's Gradle panel, run **publishing > publishToMavenLocal**. To test it in another project, add `mavenLocal()` to that project's `repositories` block and an `implementation("com.example:<library-project-name>:1.0.0")` dependency. For remote distribution, configure your Maven repository in `publishing.repositories` and run **publishing > publish**.

A library with no Godot scripts can use ordinary JVM publishing without the Godot-JVM plugin.

Details: [Reference](../reference/gradle-plugin/packaging-and-tasks.md).

Next: [Export your game](export/index.md).
