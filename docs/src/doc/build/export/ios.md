---
description: Exporting to iOS, which requires GraalVM and static linking of the compiled usercode archive into the application executable.
---

# iOS

Build for iOS with GraalVM for JDK 21, build 23.1.3. The build downloads matching static libraries from the [v23.1.3-21-b33 release](https://github.com/utopia-rise/ios-graal-jdk-21/releases/tag/v23.1.3-21-b33); install the full GraalVM JDK separately.

iOS uses static linking. `buildIOS` produces `jvm/ios/usercode.a` together with the matching
`libjava-release.a` and `libjvm-release.a`. During export, Godot links these archives with the
Godot-JVM iOS GDExtension archive into the application executable; they are not loaded at runtime.
Run `buildIOS` (or `buildIOSRelease`) before exporting the Godot project.

Configure the GraalVM installation and build inputs in `build.gradle.kts` as shown below. [GraalVM native image](graalvm-native-image.md) explains reflection, JNI, and resource configuration, which also applies to iOS.

```kotlin
godot {
    graalVmHomeDirectory.set("Path to your GraalVM install") // or set up GRAALVM_HOME.
}
```
