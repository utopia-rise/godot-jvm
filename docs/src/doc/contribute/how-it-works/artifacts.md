---
description: godot-library, godot-bootstrap, usercode.jar, the merged release game.jar and the GraalVM game image, what each one contains, who depends on it and when it is used.
---

# The build artifacts

The build separates the bindings, bootstrap runtime, and user code. Release builds merge them into one JAR, and GraalVM combines them into a native artifact for ahead-of-time execution.

Debug and release artifacts live in separate directories so that neither can be mistaken for the other:

```
<godot project>/jvm/
  jre-<arch>-<os>/            embedded JRE, shared by both variants
  ios/ios-jdk/                iOS JDK static libraries, shared by both variants
  debug/                      godot-bootstrap.jar, usercode.jar, godot-bootstrap-dex.jar, usercode-dex.jar, game.<so|dll|dylib|a>, external/
  release/                    game.<jar|so|dll|dylib|a>, game-dex.jar, external/
```

`build`, `fastBuild`, `buildAndroid`, `buildGraalNativeImage` and `buildIOS` write `jvm/debug/`; their `Release` counterparts write `jvm/release/`. The Gradle build mirrors the split under `build/libs/debug/` and `build/libs/release/`.

The editor and `template_debug` binaries load the debug variant, `template_release` binaries the release variant.

## godot-bootstrap

`godot-bootstrap.jar` bundles `godot-library` (the Godot API bindings, published to Maven Central and compiled against by user code), startup and editor-reloading code, and the project's ordinary `implementation` dependencies. `packageBootstrapJar` builds it from the
project's runtime classpath configuration, alongside the plugin's own `bootstrap` configuration.

Godot loads this JAR in the editor and includes it in debug exports. User projects do not declare it as a build dependency.

## usercode

The `usercode.jar` is built when you build your code. It is a shadow JAR containing your compiled code, the generated registrar, and dependencies declared with `godotMain`. Ordinary dependencies are bundled into `godot-bootstrap.jar`.

`godot-bootstrap.jar` loads and executes the code in `usercode.jar` through a second class loader, which is what lets the editor reload user code after a build. Both JARs are included in debug exports.

## game.jar

Release builds do not ship the pair. `packageReleaseJar` merges `godot-bootstrap.jar` and `usercode.jar` into a single `game.jar`, which the runtime loads through one class loader. There is nothing to reload, which a release build never needs.

## Dependency placement

By default, dependencies declared with `implementation` are merged into `godot-bootstrap.jar`.
Use `godotMain` for a dependency that must be loaded with user code and recreated when `usercode.jar`
reloads:

```kotlin
dependencies {
    godotMain("org.eclipse.serializer:serializer:4.0.1")
}
```

Use `godotSingle` when a dependency must remain an intact JAR, such as a signed JAR. The plugin
copies its resolved JARs to `res://jvm/<variant>/external/` and adds them to the class path of `usercode.jar` or `game.jar`:

```kotlin
dependencies {
    godotSingle("org.bouncycastle:bcprov-jdk18on:1.79")
}
```

Do not declare the same dependency in more than one of `implementation`, `godotMain`, or
`godotSingle`.

## game (native image)

The `game` native image combines the code of the variant's JARs in a GraalVM native artifact: a shared library on desktop or a static archive on iOS.

Native-image mode uses it in place of the JARs. Select it through runtime configuration or launch arguments. Code changes require rebuilding the image and restarting the process.

## Extracting export artifacts

The JVM requires filesystem paths for loading JARs and cannot load them directly from the PCK. At startup the binding extracts the packed JARs to `user://jvm/<variant>/`, comparing MD5 hashes to avoid unnecessary copies on desktop. Android recopies its runtime artifacts on each launch. Desktop native images are likewise extracted as shared libraries before loading.

Separate JARs from `godotSingle` are also copied from `res://jvm/<variant>/external/` to `user://jvm/<variant>/external/`, where the class path in the JAR manifest expects them. Native images and Android builds do not ship them: the native image compiles them in and the dex jar dexes them.
