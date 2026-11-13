---
description: The Godot-JVM library, godot-bootstrap, usercode.jar, the merged release game.jar and the GraalVM game image, what each one contains, who depends on it and when it is used.
---

# The build artifacts

The build separates the bindings, bootstrap runtime, and user code. Release builds merge them into one JAR, and GraalVM combines them into a native artifact for ahead-of-time execution.

Debug and release artifacts live in separate directories so that neither can be mistaken for the other, next to the few files both share:

```
<godot project>/jvm/
  jre-<arch>-<os>/            embedded JRE, shared by both variants
  ios/ios-jdk/                iOS JDK static libraries, shared by both variants
  dependencies/               split dependency jars, shared by both variants, and split-dependencies.txt
  editor/                     source-hashes.json, read by the editor only
  debug/                      godot-bootstrap.jar, usercode.jar, godot-bootstrap-dex.jar, usercode-dex.jar, game.<so|dll|dylib|a>
  release/                    game.<jar|so|dll|dylib|a>, game-dex.jar
```

`build`, `fastBuild`, `buildAndroid`, `buildGraalNativeImage` and `buildIOS` write `jvm/debug/`; their `Release` counterparts run `build`, then write `jvm/release/`. The editor always loads the debug jars, a release export included, and names the global classes of JVM scripts from them. The Gradle build mirrors the split under `build/libs/debug/` and `build/libs/release/`. [The Gradle plugin](gradle-plugin.md) describes the tasks.

The editor and `template_debug` binaries load the debug variant, `template_release` binaries the release variant.

`jvm/editor/source-hashes.json` maps the `res://` path of every Kotlin, Java and Scala source of the debug build inside the Godot project to its MD5. One task copies it together with `jvm/debug/usercode.jar`, and any source change rewrites both, comment-only changes included, so the hashes always describe the jar the editor runs. The editor reads it only when it loads `usercode.jar`, at startup and on every reload. It is never exported.

Each script records the MD5 of its file when the editor loads or saves it, and counts as modified since the last build, for the warning of its nodes, when the build has a hash for its path and that hash differs. A script the build has no hash for, such as a test or a source no build compiled yet, never counts as modified; when its class is missing from the jar, its nodes warn that the script cannot be found instead. Modification times are never compared.

## godot-bootstrap

`godot-bootstrap.jar` bundles the Godot-JVM library (the Godot API bindings and the runtime modules, published to Maven Central in `godot-jvm` and compiled against by user code), startup and editor-reloading code, and the project's ordinary `implementation` dependencies. `packageBootstrapJar` builds it from the
project's runtime classpath configuration, alongside the plugin's own `bootstrap` configuration.

Godot loads this JAR in the editor and includes it in debug exports. User projects do not declare it as a build dependency.

## usercode

The `usercode.jar` is built when you build your code. It is a shadow JAR containing your compiled code, the generated registrar, and dependencies declared with `godotGameImplementation`. Ordinary dependencies are bundled into `godot-bootstrap.jar`.

`godot-bootstrap.jar` loads and executes the code in `usercode.jar` through a second class loader, which is what lets the editor reload user code after a build. Both JARs are included in debug exports.

## game.jar

Release builds do not ship the pair. `packageGameJar` merges `godot-bootstrap.jar` and `usercode.jar` into a single `game.jar`, which the runtime loads through one class loader. There is nothing to reload, which a release build never needs.

## Dependency placement

By default, dependencies declared with `implementation` are merged into `godot-bootstrap.jar`.
Use `godotGameImplementation` for a dependency that must be loaded with user code and recreated
when `usercode.jar` reloads:

```kotlin
dependencies {
    godotGameImplementation("org.eclipse.serializer:serializer:4.0.1")
}
```

Use `godotSplitImplementation` when a dependency must remain an intact JAR, such as a signed
JAR. The plugin copies its resolved JARs to `res://jvm/dependencies/`, shared by both variants, and adds them to the
class path of `godot-bootstrap.jar` or `game.jar`. Only desktop JVM builds keep them intact: Android dexes them into
`godot-bootstrap-dex.jar` or `game-dex.jar`, and native images, iOS included, compile them in:

```kotlin
dependencies {
    godotSplitImplementation("org.bouncycastle:bcprov-jdk18on:1.79")
}
```

`godotGameRuntimeOnly` and `godotSplitRuntimeOnly` place a dependency like their `Implementation`
counterparts but leave it off the compile classpath, as `runtimeOnly` does for `godot-bootstrap.jar`.

Do not declare the same dependency in more than one of `implementation`, `runtimeOnly`,
`godotGameImplementation`, `godotGameRuntimeOnly`, `godotSplitImplementation` or `godotSplitRuntimeOnly`.

Shadow, which merges the JARs, copies the `META-INF/versions/` classes of multi-release dependencies
but not the `Multi-Release: true` attribute that makes the JVM use them, so every merged JAR declares
it in its own manifest. Every merged JAR also merges the `META-INF/services/` files of its inputs, so
dependencies registering the same service all stay visible to `ServiceLoader`.

## game (native image)

The `game` native image combines the code of the variant's JARs in a GraalVM native artifact: a shared library on desktop or a static archive on iOS.

Native-image mode uses it in place of the JARs. Select it through runtime configuration or launch arguments. Code changes require rebuilding the image and restarting the process.

## Extracting export artifacts

The JVM requires filesystem paths for loading JARs and cannot load them directly from the PCK. At startup the binding extracts the packed JARs to `user://jvm/<variant>/`, comparing MD5 hashes to avoid unnecessary copies on desktop. Android recopies its runtime artifacts on each launch. Desktop native images are likewise extracted as shared libraries before loading.

Exports pack only the split JARs that `res://jvm/dependencies/split-dependencies.txt` names, one file name per line, never the list itself. On Windows the open editor keeps a JAR its class path loaded, so a dependency dropped from the build can stay in the directory until the split dependencies change again; nothing loads it and the list leaves it out of every export.

Separate JARs from `godotSplitImplementation` and `godotSplitRuntimeOnly` are also copied from `res://jvm/dependencies/` to `user://jvm/dependencies/`, where the class path in the JAR manifest expects them. Native images and Android builds do not ship them: the native image compiles them in and the dex jar dexes them.
