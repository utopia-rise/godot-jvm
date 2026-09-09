---
description: iOS cannot run a JVM, so it uses a native image.
---

# iOS

Use [GraalVM for JDK 25.0.2](https://download.oracle.com/graalvm/25/archive/graalvm-jdk-25.0.2_macos-aarch64_bin.tar.gz), and exactly that update. The static libraries come from labs-openjdk 25.0.2, and JDK 25.0.3 renamed a native the image links against, so a newer GraalVM builds an image that fails to link. Install the full GraalVM JDK; the build downloads its matching static libraries and CAP cache as one bundle from [ios-graal-native-image](https://github.com/utopia-rise/ios-graal-native-image).

1. Prepare the macOS/Xcode toolchain described in [Godot's iOS export documentation](https://docs.godotengine.org/en/stable/tutorials/export/exporting_for_ios.html).
2. Set `GRAALVM_HOME` to your GraalVM installation. Apply the dependency configuration from [GraalVM native image](graalvm-native-image.md).
3. Select **Build iOS Release** in Godot's toolbar and click **Run Gradle** (`buildIOSRelease` in IntelliJ). Use **Build iOS** for debug builds.
4. Export with an iOS preset, build the exported Xcode project, and run it on your device.

The JVM build produces `jvm/ios/usercode.a`, `libjava-release.a`, and `libjvm-release.a`. The export links these with the Godot-JVM iOS extension into the application.

Details: [Reference](../../reference/gradle-plugin/export-targets.md).

Next: run the exported game on your device.
