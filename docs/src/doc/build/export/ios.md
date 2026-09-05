---
description: iOS cannot run a JVM, so it uses a native image.
---

# iOS

Use GraalVM for JDK 21, build 23.1.3. Install the full GraalVM JDK separately; the build downloads its matching static libraries from the [v23.1.3-21-b33 release](https://github.com/utopia-rise/ios-graal-jdk-21/releases/tag/v23.1.3-21-b33).

1. Prepare the macOS/Xcode toolchain described in [Godot's iOS export documentation](https://docs.godotengine.org/en/stable/tutorials/export/exporting_for_ios.html).
2. Set `GRAALVM_HOME` to your GraalVM installation. Apply the dependency configuration from [GraalVM native image](graalvm-native-image.md).
3. Select **Build iOS Release** in Godot's toolbar and click **Run Gradle** (`buildIOSRelease` in IntelliJ). Use **Build iOS** for debug builds.
4. Export with an iOS preset, build the exported Xcode project, and run it on your device.

The JVM build produces `jvm/ios/usercode.a`, `libjava-release.a`, and `libjvm-release.a`. The export links these with the Godot-JVM iOS extension into the application.

Details: [Reference](../../reference/gradle-plugin/export-targets.md).

Next: run the exported game on your device.
