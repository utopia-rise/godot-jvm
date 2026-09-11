# Unit tests for Godot-JVM

## Preparing and running tests

Test and export tasks are deliberately dependency-free. They only run or export the files already present in the test project; they never build, import, create a native image, or create a JRE. Run every prerequisite explicitly, in order.

Debug tasks write `jvm/debug/`, release tasks write `jvm/release/`; an export with debug packs the former, a release export the latter. The editor resolves script classes from `jvm/debug/` during every export, so run `build` before a release export as well (CI does).

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

Use the `Release` tasks together with `-Prelease` for the release build, for example `gradlew -Prelease buildAndroidRelease` followed by `gradlew exportAndroidRelease`. The task selects the release variant; the property additionally makes the included `kt` build compile the Godot libraries in release mode, as a published release does.
