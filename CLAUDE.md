# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What This Project Is

**Godot-JVM** is a GDExtension-based JVM binding that enables Kotlin, Java, and Scala as scripting languages. It is a hybrid C++/JVM project: the C++ side integrates with Godot through GDExtension, and the Kotlin/Gradle side provides the runtime libraries and tooling for user projects.

The binding version is defined in `kt/gradle/libs.versions.toml` (`godotJvm`) and mirrored in `cpp/version.h` (`GODOT_JVM_VERSION`); the two must match. The targeted Godot version is `godot` in the same toml, and `GODOT_VERSION` in `.github/workflows/trigger_ci.yml` for CI.

## godot-cpp fork

The `godot-cpp` submodule points at
[`utopia-rise/godot-cpp`](https://github.com/utopia-rise/godot-cpp), branch
`godot-jvm` (not upstream `godotengine/godot-cpp` directly, and not the
fork's `master`). This branch customizes godot-cpp's generated-binding
behavior for Godot-JVM's own object-tracking model — it is not a collection
of upstream bug fixes.

**Every time a commit is added to `godot-jvm` in the `godot-cpp` fork**:

1. Push the commit to `utopia-rise/godot-cpp` on the `godot-jvm` branch.
2. Update the submodule pointer in this repo (`git -C godot-cpp` checkout of
   the new commit, then `git add godot-cpp`).
3. Append an entry to [`godot-cpp-divergence.md`](godot-cpp-divergence.md)
   with the commit hash and a brief explanation of what it does and why.
4. Re-read this section — it must stay accurate as the fork evolves (e.g. if
   the branch is ever rebased onto a newer upstream tag, update the tag
   named above).

## Engineering Principles

- **Avoid needless helpers** — Keep trivial single-use code inline. Extract a helper only when it has multiple call sites or its body is substantial enough to make the caller clearer.
- **KISS** — Prefer the simplest design that clearly solves the current problem.
- **YAGNI** — Do not add behavior or abstractions for requirements that do not exist yet.
- **DRY** — Keep each piece of knowledge and behavior in one authoritative place.
- **Lambdas** — Not banned, but use one only when strictly necessary (a callback API) or when the code would be markedly more complex without it. Prefer a plain loop, a file-local function, or a data table over a local lambda that merely groups a few lines.
- **No anonymous namespaces** — File-local C++ helpers are `static` free functions in the `.cpp` (or private members when they belong to the class); nothing lives in `namespace { }`. `.clang-tidy` is an allowlist, so no check pushes toward anonymous namespaces.
- **`godot` namespace in `cpp/api/` and `cpp/editor/`** — Headers wrap their declarations in a `namespace godot { }` block and `.cpp` files start with `using namespace godot;`, so no `godot::` prefixes appear in those directories (`raw_godot::` is a different namespace and stays). Macro-only headers such as `api/language/names.h` have nothing to wrap.
- **Includes** — Every file includes what it uses directly and nothing it does not; do not rely on a header reaching you through another include. When a header only includes something for its `.cpp`, move the include to the `.cpp`. Build `editor`, `template_debug` and `template_release` after touching includes: the three targets compile different `#ifdef` branches.
- **clang-format** — Run `clang-format -i` (version 20 or newer, the repo `.clang-format` uses recent options) over every `.cpp`, `.h` and `.mm` under `cpp/` except the generated `cpp/editor/project/templates.h`, which carries `// clang-format off`.
- **C++ initialization** — Use `=` for scalar values and expressions already of the declared type (`int count = 0;`, `String name = get_name();`). Use direct `()` initialization whenever an object is constructed, whether its constructor is explicit or implicit: `Type value(expr);`, never `Type value = Type(expr);`. This includes JNI wrappers built from raw handles or call results: `jni::Env env(p_raw_env);`, `jni::JLongArray array(p_raw_array);`, `jni::JObject result(wrapped.call_object_method(...));`. Use `()` for constructor calls with several arguments (`Vector3 pos(1, 2, 3);`), `{}` only for arrays, aggregates, `std::initializer_list` parameters, and returned/passed temporary aggregates (`return {ptr, size};`). Member initializer lists use `()`, default member initializers use `=`. Never `Type value{expr};`, never `Type value();`, never `Foo f{};` on a class type (write `Foo f;`); zero PODs with `= {}`.

## Prerequisites

- **JDK 17+** required for building, running, and developing Godot-JVM projects
- Use **Adoptium/Eclipse Temurin** JDK — Microsoft JDK causes IDE plugin build failures (known issue [microsoft/openjdk#339](https://github.com/microsoft/openjdk/issues/339)). If you must use Microsoft JDK, manually create the `Packages` folder inside `JAVA_HOME`.
- `JAVA_HOME` must be set
- Standard Godot build deps: SCons, Python, C++ compiler

## Build Commands

The project has two independent build systems that must both be built.

### Native GDExtension (SCons)

Run SCons commands from this repository's root. They build the native GDExtension library. Valid platforms are `linux`, `windows`, `macos`, `android`, and `ios` (godot-cpp naming, not the engine's `linuxbsd`).

```bash
scons platform=linux target=editor               # Linux editor
scons platform=windows target=editor             # Windows editor
scons platform=linux target=template_release     # export template
scons platform=linux -j$(nproc) debug_symbols=yes dev_build=yes  # debug build (multi-core)
```

The built library lands directly in `harness/tests/addons/jvm/libs/` (Android builds go to `build/android/`), where the harness project's `.gdextension` manifest picks it up. Nothing needs to be copied after a build. `SConstruct` also regenerates `cpp/editor/project/templates.h` from the IntelliJ templates on every build.

### Kotlin/Gradle

```bash
cd kt/
./gradlew build                  # build all subprojects
./gradlew build -Prelease        # production/release build
./gradlew publishArtifactsToMavenLocal  # publish everything a user project needs to mavenLocal
```

`publishArtifactsToMavenLocal` (`kt/build.gradle.kts`) is an aggregator that runs five nested Gradle invocations: `common`, `tools-common`, and `api-generator` (included builds, unreachable from the root `publishToMavenLocal`), then the main build twice, once without and once with `-Prelease=true`, because every `godot-library` module names its artifact `-debug` or `-release` from that property. Together they publish every `com.utopia-rise` coordinate the gradle plugin resolves: the plugin and its marker, `common`, `tools-common`, `api-generator`, the `godot-registration` fat jar, and the six `godot-*-library-{debug,release}` jars. A bare `./gradlew publishToMavenLocal` is not enough. The Android plugin AARs are not Maven artifacts and are copied by hand (see `test-a-branch.md`).

The snapshot version appears in `~/.m2/repository/com/utopia-rise/godot-gradle-plugin/`. The consuming project needs `mavenLocal()` in both `pluginManagement.repositories` (`settings.gradle.kts`) and the project `repositories` block (`build.gradle.kts`); the plugin resolves the libraries from the latter and adds no repository itself.

### Template Generation (Python)

`generate_templates.py` converts the `.template` and `.godot_template` files under `kt/plugins/godot-intellij-plugin/src/main/resources/template/` into base64-encoded C++ headers at `cpp/editor/project/templates.h`, split into 8KB chunks to avoid C++ header size limits. `SConstruct` runs it automatically, so editing a template only requires rebuilding the native GDExtension. Run it by hand only to inspect the output:

```bash
python generate_templates.py
```

## Testing

```bash
# Kotlin unit tests
cd kt/ && ./gradlew test

# Integration tests (gdUnit4-based)
cd harness/tests/
./gradlew generateEmbeddedJre   # jlink an embedded JRE into the project, once
./gradlew importResources       # build the harness with the gradle plugin and import resources
./gradlew runGDTests            # also: runGraalGDTests, runExportedGDTests
```

The `harness/tests/` directory is a full Godot-JVM project driven by the official Godot editor, not a custom binary. Place the editor in `harness/tests/bin` or point `GODOT_EDITOR` at its executable. The Gradle build produces `jvm/debug/godot-bootstrap.jar` and `jvm/debug/usercode.jar` inside the project itself, and the SCons build drops the native library into `harness/tests/addons/jvm/libs/`, so nothing needs to be copied anywhere before running.

### Testing Changes from a Feature Branch

1. Publish locally (see above)
2. Add `mavenLocal()` to both repository blocks of the user project and use the exact snapshot version you published (`<godotJvm version>-<short commit hash>-SNAPSHOT`)
3. Build the GDExtension straight into the project: `scons platform=<p> target=editor target_path=/abs/path/to/project/addons/jvm/libs/`
4. Open the project with the official Godot editor

Full workflow: `docs/src/doc/contribute/test-a-branch.md`

### Debugging JVM Code

```bash
# Start Godot with debug port
godot --jvm-use-debug --jvm-debug-port=5005
# Then attach a remote debugger in IntelliJ IDEA to localhost:5005
```

Debugging the registrar generator (bytecode processing):
```bash
cd kt/
./gradlew registrarGenerationGenerateFiles --rerun-tasks --no-build-cache -Dorg.gradle.debug=true
# Halts the build until a remote debugger attaches at localhost:5005
# Note: --rerun-tasks --no-build-cache is required — the task is cacheable, so without them
# an unchanged project resolves it as up-to-date and the breakpoint is never reached.
```

## Architecture

### C++ Layer (`cpp/`)

- **`cpp/godot_jvm.h` / `cpp/godot-jvm.cpp`** — `GodotJvm` singleton; owns the runtime state machine (`NOT_STARTED → JVM_LIBRARY_LOADED → JVM_STARTED → BOOTSTRAP_LOADED → CORE_LIBRARY_INITIALIZED → ENGINE_TYPES_INITIALIZED → JVM_SCRIPTS_INITIALIZED`), driven by `initialize_up_to()` / `finalize_down_to()`. Many operations gate on correct state — check here first when debugging startup issues.
- **`cpp/register_types.cpp`** — GDExtension entry point; registers `JvmScript` types, script languages, resource loaders/savers with Godot.
- **`cpp/jvm/lifecycle/`** — JVM startup (`jvm_manager`), class loader management, project settings parsing.
- **`cpp/jvm/wrapper/`** — JNI bridges, type conversion, per-thread shared buffer communication.
- **`cpp/api/script/`** — `JvmScript` (abstract base), `JvmInstance`, placeholder instance, script manager, source parser. Concrete script types live in **`cpp/api/script/language/`**: `KotlinScript`, `JavaScript`, `GdjScript`, `ScalaScript`.
- **`cpp/api/language/`** — `ScriptLanguage` implementations (`KotlinLanguage`, `JavaLanguage`, etc.) registered as Godot editor language options.
- **`cpp/core/`** — Binding manager; maps Godot objects to JVM instances, synchronizes lifecycle.
- **`cpp/editor/`** — Editor plugin, Gradle task dialog, project generation from templates.
- **`cpp/api/resource_format/`** — `JvmResourceFormatLoader`/`Saver` for JAR files.

### Kotlin/JVM Layer (`kt/`)

- **`godot-library/godot-api-library/`** — Auto-generated Godot API bindings. **Never edit manually.** Regenerate with `kt/api-generator` after `api.json` changes.
- **`godot-library/godot-core-library/`** — Core types, signal infrastructure, base classes for user code.
- **`godot-library/godot-internal-library/`** — Internal utilities shared by the Godot-JVM libraries.
- **`godot-library/godot-extension-library/`** — Convenience extensions built on top of the base Godot API (e.g. `connectLambda`).
- **`godot-library/godot-coroutine-library/`** — Kotlin coroutine support in a Godot context (`GodotDispatchers`, awaiting signals).
- **`godot-library/godot-bootstrap-library/`** — JVM bootstrapper; initializes and hot-reloads user classes in the editor.
- **`godot-registration/`** — Umbrella module (the directory is itself the Gradle module, like `godot-library`); shadow-merges the three sub-modules below into the single publishable `godot-registration` fat jar consumed by the gradle plugin and as a standalone tool.
- **`godot-registration/godot-class-graph-symbol-processor/`** — Front-end: bytecode processor using ClassGraph (replaced KSP/Mpapt; language-agnostic, supports Kotlin/Java/Scala equally). Reads compiled bytecode and produces model instances. No validation.
- **`godot-registration/godot-registration-model/`** — The validated IR shared between processor and generator. Owns the registration model and its sanity checks; an instance existing means it is valid.
- **`godot-registration/godot-registrar-generator/`** — Back-end: consumes models from the processor and generates registration glue code. No validation.
- **`api-generator/`** — Reads Godot's `api.json`, generates all Kotlin bindings in `godot-api-library/`. Run in CI when Godot API changes.
- **`plugins/godot-gradle-plugin/`** — Applied to all user Godot-JVM projects; orchestrates compile → symbol processing → registrar generation → JAR packaging.
- **`plugins/godot-intellij-plugin/`** — IntelliJ IDEA integration (code insight, run configs, templates).
- **`common/`**, **`tools-common/`** — Shared utilities across subprojects.

### Android plugin (`kt/android-plugin/`)

- Packages the Android native GDExtension libraries and `jvm.gdextension` into debug/release Godot Android v2 plugin AARs.
- Its Kotlin entry point loads `libgodot_jvm.so` and passes Android's existing `JavaVM` to the native extension through JNI.
- Build it after all Android ABIs with `./kt/gradlew -p kt :android-plugin:assemble`.

### Data Flow (User Code → Runtime)

```
User writes @Script Kotlin, Java, or Scala code
  → Kotlin compiler + ClassGraph bytecode processor
  → registrar-generator produces registration glue
  → godot-gradle-plugin packages godot-bootstrap.jar + usercode.jar (debug) or the merged game.jar (release)
  → JvmResourceFormatLoader loads JARs in editor
  → C++ jvm_manager starts embedded JVM
  → Bootstrap initializes user classes via JNI reflection
  → JvmBindingManager (cpp/core/) maps JVM objects ↔ Godot nodes
```

### JAR Artifacts

| JAR | Contents | Purpose |
|-----|----------|---------|
| `jvm/debug/godot-bootstrap.jar` | godot-library + startup/reload code + the project's ordinary `implementation` dependencies | Loaded in the editor and included in debug exports; loads and reloads `usercode.jar` |
| `jvm/debug/usercode.jar` | user code + generated registrar + `godotMain` dependencies (shadow) | Reloaded after each build in the editor; bundled in debug exports |
| `jvm/release/game.jar` | both JARs merged | Release exports; one class loader, no reloading |
| `game` (native image) | GraalVM AOT compilation of the variant's JARs | Replaces the JARs; no runtime reloading |

Debug and release artifacts live under `jvm/debug/` and `jvm/release/` (Gradle: `build/libs/<variant>/`) and never overwrite each other; the editor and `template_debug` load the debug variant, `template_release` the release variant (`cpp/paths.h` selects `BOOTSTRAP_FILE`, `USER_CODE_FILE` and `GRAAL_NATIVE_IMAGE_FILE` per `DEBUG_ENABLED`). The export plugin packs exactly the variant matching the export type and reports a missing one. `godotSingle` dependencies stay as intact JARs under `res://jvm/<variant>/external/` and are added to the JAR's class path. Details: `docs/src/doc/contribute/how-it-works/artifacts.md`

### Memory Management

Each Godot object can have two JVM instances:
- **Wrapper** — wraps the C++ pointer, allows JVM to call C++ methods
- **Script Instance** — user's Kotlin subclass; stored as a strong JNI reference on the C++ side

`MemoryManager` singleton synchronizes lifecycle between Godot and JVM via Godot's instance binding callbacks.

**`RefCounted` objects (critical):** When the reference counter reaches 1 (JVM is the only user), the wrapper converts its reference to a **weak reference** to prevent cyclic memory leaks. The C++ side holds a strong JNI reference to the script instance, preventing GC while the native object is alive.

**`Object` (non-ref-counted):** Simpler — manually freed; binding lifecycle follows the Godot object directly.

Full details: `docs/src/doc/contribute/how-it-works/memory-management.md`

### JNI Shared Buffer (Performance)

To reduce JNI overhead for frequent calls, a **per-thread buffer** is used for C++/JVM parameter exchange. Its size is derived from the maximum inline string size and the 16-argument limit (`MAX_FUNCTION_ARG_COUNT` in `cpp/constraints.h`):
- First 4 bytes: variable count (object method calls prefix this with the caller pointer and `ObjectID`)
- Each variable: 4-byte type ordinal + type-specific bytes
- Type ordinals 0–38 cover all Godot variant types (primitives at fixed size, strings up to 512 bytes inline, larger strings via JNI queue, `Array` at 28, packed arrays at 29–38)

Details: `docs/src/doc/contribute/how-it-works/shared-buffer.md`

### Runtime configuration

Game settings live in `res://godot_jvm_configuration.json` (schema `version` `"3.0"`) and have `--jvm-*` command-line equivalents; precedence is defaults → JSON → command line (`cpp/jvm/lifecycle/jvm_user_configuration.*`, `GodotJvm::fetch_user_configuration`). The editor validates and repairs the file, but applies only command-line settings to its own defaults. `--jvm-use-native-image` works in the editor but disables script reloading. Command-line values are never written back. Reference: `docs/src/doc/reference/runtime-configuration.md`.

Behaviour that is easy to miss in the code:
- `use_debug`, `debug_port`, `debug_address`, `wait_for_debugger` apply only to desktop JVM games in `DEBUG_ENABLED` builds (`GodotJvm::set_jvm_options`); `jmx_port` also applies in release builds. These dedicated options are ignored by native images and mobile runtimes.
- `custom_jvm_args` applies to desktop JVM runs and supported native-image runtime options on desktop and iOS. The editor accepts custom arguments through the command line only; Android ignores them.
- On Android the extension attaches to the existing ART VM, so no `JvmOptions` (debug, JMX, custom args) or `--jvm-path` apply.
- `max_string_size` is capped at 65535 because `LongStringQueue::max_string_size` is a `uint16_t`.
- The export plugin reads the JSON at export time, applies enabled preset override categories (debug, memory) and a nonempty custom-argument override, then packs only platform-relevant keys. Desktop JVM/Graal presets force `useNativeImage` false/true. Editor command-line overrides never reach the exported JSON.
- Field definitions, JSON/command-line parsing, and validation belong to `JvmUserConfiguration`. Everything export related (preset options and their names, override categories, option visibility and warnings, platform filtering of the packed JSON) lives in `GodotJvmEditorExportPlugin`.

### JVM Modes

Desktop games select JVM or native image with `useNativeImage` (default false), or `--jvm-use-native-image`.
Android always uses ART; iOS always uses native image. The internal `JvmType` is resolved at startup, not serialized.
- **Embedded JVM** — `jlink`-created JRE bundled with the project (recommended for distribution)
- **Dynamic JVM** — discovered at runtime from `JAVA_HOME` first, then from a `java` executable on
  `PATH`, and on macOS from `/usr/libexec/java_home -v 17+` last (see `get_path_to_environment_jvm()` /
  `get_path_to_java_executable()` in `cpp/godot-jvm.cpp`). This discovery is compiled only in editor
  builds (`TOOLS_ENABLED`); exported games use the embedded JRE. `--jvm-path` overrides all of it,
  including the embedded JRE.

## Key Gotchas

- **Kotlin version** — The gradle plugin requires a minimum Kotlin version, not an exact one, and applies its default when the project declares none. A higher version is accepted; overriding `toolchain.kotlinVersion` requires applying the Kotlin JVM plugin explicitly with the same version. See `docs/src/doc/reference/gradle-plugin/languages-and-toolchains.md`.
- **Godot API auto-generation** — `kt/godot-library/godot-api-library/` is fully generated. Any manual edits will be overwritten.
- **Template generation** — Editing `.template` files has no effect until the native GDExtension is rebuilt; SCons regenerates `templates.h` as part of the build.

### GDScript global scope sync commit

When checking whether the `GD` singleton needs to be synchronized with GDScript global functions, compare Godot's `@GlobalScope` changes against this baseline:

- Godot `4.7.1-stable`: `a13da4feb8d8aefc283c3763d33a2f170a18d541`

## CI/CD

Workflows in `.github/workflows/`. The canonical Godot version (`GODOT_VERSION`) and JDK version (`JVM_VERSION`) are defined at the top of `trigger_ci.yml` (and mirrored in `trigger_on_tag.yml`). Build matrix: Android, iOS, Linux, macOS, Windows × editor/template_release targets.

## Documentation

- Contribution setup: `docs/src/doc/contribute/build-from-source.md`
- Guidelines: `docs/src/doc/contribute/index.md`
- Memory management deep dive: `docs/src/doc/contribute/how-it-works/memory-management.md`
- Registrar generation: `docs/src/doc/contribute/how-it-works/registrar-generation.md`
- JNI shared buffer: `docs/src/doc/contribute/how-it-works/shared-buffer.md`
- Testing branch changes: `docs/src/doc/contribute/test-a-branch.md`

Serve docs locally: `cd docs/ && ./run.sh`
