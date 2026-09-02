---
description: Exporting to iOS, which requires GraalVM and static linking of the compiled usercode archive into the application executable.
---

# iOS

!!! warning
    With this export you don't have a choice regarding JVM version you use. Please use [GraalVM 23.1.3](https://download.oracle.com/graalvm/21/latest/graalvm-jdk-21_macos-aarch64_bin.tar.gz).

iOS uses static linking. `buildIOS` produces `jvm/ios/usercode.a` together with the matching
`libjava-release.a` and `libjvm-release.a`. During export, Godot links these archives with the
Godot-JVM iOS GDExtension archive into the application executable; they are not loaded at runtime.
Run `buildIOS` (or `buildIOSRelease`) before exporting the Godot project.

Additionally, to the regular GraalVM configuration mentioned above, add the following in `build.gradle.kts`, then invoke `buildIOS` or `buildIOSRelease`:

```kotlin
godot {
    graalVmHomeDirectory.set("Path to your GraalVM install") // or set up GRAALVM_HOME.
}
```
