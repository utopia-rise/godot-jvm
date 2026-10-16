---
name: run-harness-tests
description: Run the gdUnit4 integration tests of harness/tests against the current sources - in the editor, as a native image, or from a debug or release export - in the order CI uses. Use to verify a change end to end.
argument-hint: "[editor | graal | export-debug | export-release]; default: editor"
---

# Run the harness tests

Work in `harness/tests/`. It builds against the repository sources through included builds: nothing to publish.

## Before

- **Native library:** build the host `editor` target in this checkout (`build-native` skill). Exports also need `template_debug` or `template_release`. Never copy a library from another checkout or worktree: even on the same commit it may have been built from an older `godotJvm` version, and the JVM then refuses the jars.
- **Fresh git worktree:** `godot-cpp` is empty; clone it from the main checkout without touching the shared config with `git -c protocol.file.allow=always -c submodule.godot-cpp.url=<main checkout>/godot-cpp submodule update --init godot-cpp`. Export `GIT_DIR` to the main repository's `.git` for every `gradlew` call, or Gradle fails with "head(...) must not be null".
- **Godot editor:** the official editor of the version in `kt/gradle/libs.versions.toml`, placed in `harness/tests/bin/` or named by an absolute `GODOT_EDITOR`.
- **Embedded JRE, once:** `./gradlew generateEmbeddedJre`.
- Run only this project. Bunnymark, Bulletmark and the stress test are for explicit requests.

## Sequence

Harness tasks never depend on one another, and Gradle may start the editor before a build in the same invocation has copied the new jars. **Run each line as its own invocation:**

| Variant | Steps |
|---|---|
| editor | `./gradlew build` → `./gradlew importResources` → `./gradlew runGDTests` |
| graal | `./gradlew build` → `./gradlew buildGraalNativeImage` → `./gradlew importResources` → `./gradlew runGraalGDTests` |
| export-debug | `./gradlew build` → `./gradlew importResources` → `./gradlew exportDebug` → `./gradlew runExportedGDTests` |
| export-release | `./gradlew build` → `./gradlew buildRelease` → `./gradlew importResources` → `./gradlew exportRelease` → `./gradlew runExportedGDTests` |

After the last `importResources`, search its output for `Version mismatch` or `couldn't be fully initialized` and fix that first: the suites cannot pass without a running JVM.

Native-image exports use `exportGraalDebug` / `exportGraalRelease` after the matching `buildGraalNativeImage[Release]`.

## When it goes wrong

- **`Version mismatch! C++ module is X / Jar is Y`:** the native library is stale; rebuild it.
- **"Could not find type X" or "Identifier X not declared" across many unrelated suites:** the JVM never started, so no script class exists. Look for the cause in the `importResources` output, usually a version mismatch; clearing caches will not help.
- **GDScript "Could not find type X" or "Identifier X not declared" only for a new or renamed script class:** delete `.godot/global_script_class_cache.cfg` and `.godot/editor/filesystem_cache*`, then run `importResources` twice.
- **`NoSuchMethodError` from Scala tests only:** `compileScala` was served from cache; rerun with `./gradlew compileScala --rerun build`.
- **"Can't open GDExtension dynamic library":** a Godot editor left open on the project holds the library; ask the user to close it.
- The build regenerates the API with LF endings: `git checkout` generated files whose diff is empty before committing.

Report the gdUnit4 statistics line of every suite run, and any `[ERROR]` or JVM exception in the output even when the suites pass.
