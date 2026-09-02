---
description: Exporting to iOS, which requires GraalVM and static linking of the compiled usercode archive into the application executable.
---

# iOS

!!! warning
    With this export you don't have a choice regarding JVM version you use. Please use [GraalVM for JDK 25.0.2](https://download.oracle.com/graalvm/25/archive/graalvm-jdk-25.0.2_macos-aarch64_bin.tar.gz). The exact update matters: the static libraries come from labs-openjdk 25.0.2, and JDK 25.0.3 replaced the `java.io.Console.istty` native with `ttyStatus`, so a 25.0.3 or newer GraalVM builds an image that fails to link.

iOS uses static linking. `buildIOS` produces `jvm/ios/usercode.a` together with the matching
`libjava-release.a` and `libjvm-release.a`. During export, Godot links these archives with the
Godot-JVM iOS GDExtension archive into the application executable; they are not loaded at runtime.
Run `buildIOS` (or `buildIOSRelease`) before exporting the Godot project.

The static libraries and the CAP cache the native-image build needs are downloaded together, as a
single bundle published by
[ios-graal-native-image](https://github.com/utopia-rise/ios-graal-native-image), and cached under
`build/libs/ios/ios-jdk` and `build/graal/ios/capcache`. Each file is checked against the
`SHA256SUMS` shipped in the bundle, so a truncated download fails the build instead of producing a
broken archive.

Additionally, to the regular GraalVM configuration mentioned above, add the following in `build.gradle.kts`, then invoke `buildIOS` or `buildIOSRelease`:

```kotlin
godot {
    graalVmHomeDirectory.set("Path to your GraalVM install") // or set up GRAALVM_HOME.
}
```
