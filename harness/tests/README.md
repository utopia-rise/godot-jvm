# Unit tests for Godot-JVM

## Preparing and running tests

Test and export tasks are deliberately dependency-free. They only run or export the files already present in the test project; they never build, import, create a native image, or create a JRE. Run every prerequisite explicitly, in order.

For JVM tests in the editor:

```shell
gradlew build
gradlew importResources
gradlew runGDTests
```

Godot currently has some problems with plugin resources so you either need to start the editor twice (only for the first time) before you can start the tests in the editor, or import first using the command above.

The GraalVM Native Image variants use the same test project. After configuring `GRAALVM_HOME`, prepare and run the editor variant explicitly:

```shell
gradlew build
gradlew importResources
gradlew buildGraalNativeImage
gradlew runGraalGDTests
```

For a desktop JVM export, also create the bundled JRE before exporting:

```shell
gradlew build
gradlew importResources
jlink --add-modules java.base,java.logging --output jvm/jre-<architecture>-<platform>
gradlew exportDebug # or: gradlew exportRelease
gradlew runExportedGDTests
```

For the GraalVM native-image export, build the native image before the export:

```shell
gradlew buildGraalNativeImage
gradlew importResources
gradlew exportDebug # or: gradlew exportRelease
gradlew runExportedGraalGDTests
```

For mobile exports, build the platform artifact explicitly before exporting:

```shell
gradlew buildAndroid
gradlew exportAndroidDebug

gradlew buildIOS
gradlew exportIOSDebug
```

Use `-Prelease` for the release build, for example `gradlew -Prelease buildAndroid` followed by `gradlew exportAndroidRelease`.
