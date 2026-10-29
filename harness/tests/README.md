# Unit tests for Godot-JVM

## Preparing and running tests

Test and export tasks are deliberately dependency-free. They only run or export the files already present in the test project; they never build, import, create a native image, or create a JRE. Run every prerequisite explicitly, in order.

Debug tasks write `jvm/debug/`, release tasks write `jvm/release/`; an export with debug packs the former, a release export the latter. A release export does not need `build`: without the debug jars, the editor builds the global class cache from `jvm/script-classes.json`, which every build writes. CI exports releases without a debug build, so `test_global_class_names.gd` checks the cache built that way.

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

Use the `Release` tasks for the release build, for example `gradlew buildAndroidRelease` followed by `gradlew exportAndroidRelease`. The task selects the release variant, for the harness, its included third-party library and the Godot libraries the included `kt` build compiles.
