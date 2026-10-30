# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What This Project Is

**Godot-JVM** is a GDExtension-based JVM binding that enables Kotlin, Java, and Scala as scripting languages. It is a hybrid C++/JVM project: the C++ side integrates with Godot through GDExtension, and the Kotlin/Gradle side provides the runtime libraries and tooling for user projects.

The Godot-JVM version is defined in `kt/gradle/libs.versions.toml` (`godotJvm`) only: `SConstruct` writes it into `cpp/version.h` (`GODOT_JVM_VERSION`) on every build through `generate_version.py`, like `templates.h`, and the native library refuses jars reporting another one. It is distinct from the build version that published artifacts carry (see Kotlin/Gradle below). The targeted Godot version is `godot` in the same toml, and `GODOT_VERSION` in `.github/workflows/trigger_ci.yml` for CI.

## Specs

[`specs/`](specs/) is the guidance of the project: what Godot-JVM offers its users, and the global rules (runtimes, languages, toolchains, Godot integration) every implementation follows. Those product and technical rules live there, not in this file. Read `specs/CLAUDE.md` before implementing or changing a feature; it explains how the directory works and how to keep it in sync with the code.

Run the `spec-review` skill, unasked, before committing or opening a PR for any change to `cpp/`, `kt/`, `harness/`, `docs/` or `specs/`, including spec edits you made yourself. Report every conflict to the maintainer with the ways to resolve it (change the code, change the spec, or record the gap as `partial` with a `breaks` note) and your recommendation, and wait for their decision: never settle a conflict by editing a spec on your own.

## Skills

Recurring procedures are Claude Code skills under `.claude/skills/`: `build-native`, `check-cpp`, `run-harness-tests`, `run-editor-probes`, `test-in-project`, `regenerate-api`, `bump-godot`, `godot-cpp-fork-commit` and `spec-review`. Use them instead of re-deriving the steps from this file.

## godot-cpp fork

The `godot-cpp` submodule tracks the `godot-jvm` branch of [`utopia-rise/godot-cpp`](https://github.com/utopia-rise/godot-cpp), not upstream `godotengine/godot-cpp` and not the fork's `master`. The branch adapts godot-cpp's generated bindings to Godot-JVM's object-tracking model; it is not a collection of upstream fixes. Every commit on it follows the `godot-cpp-fork-commit` skill.

## Engineering Principles

### General

These apply to every language in the repository.

- **Code is documentation** — Names and structure carry the meaning, so most code needs no comment at all. Inside a function body, comment only what a reader could not work out quickly from the code itself: a non-obvious invariant, a cross-thread protocol, an engine quirk being worked around. Never restate what the next line does. A short summary on a class is welcome; properties and methods get no comment unless their behavior is genuinely complex.
- **Avoid needless helpers** — Keep trivial single-use code inline. Extract a helper only when it has multiple call sites or its body is substantial enough to make the caller clearer.
- **KISS** — Prefer the simplest design that clearly solves the current problem.
- **YAGNI** — Do not add behavior or abstractions for requirements that do not exist yet.
- **DRY** — Keep each piece of knowledge and behavior in one authoritative place.

### C++

- **Lambdas** — Not banned, but use one only when strictly necessary (a callback API) or when the code would be markedly more complex without it. Prefer a plain loop, a file-local function, or a data table over a local lambda that merely groups a few lines.
- **No anonymous namespaces** — File-local C++ helpers are `static` free functions in the `.cpp` (or private members when they belong to the class); nothing lives in `namespace { }`. `.clang-tidy` is an allowlist, so no check pushes toward anonymous namespaces.
- **`godot` namespace in `cpp/api/`, `cpp/editor/` and `cpp/engine/`** — Headers wrap their declarations in a `namespace godot { }` block and `.cpp` files start with `using namespace godot;`, so no `godot::` prefixes appear in those directories. A `.cpp` defining free functions reopens the namespace instead, since a using-directive cannot define a namespaced function. The extension's own engine-level code under `cpp/engine/` (`godot_object.h`, `internal.h`, `dynamic_library.h`) lives in the top-level `engine` namespace instead: headers wrap it in `namespace engine { using namespace godot; … }`, and the `.cpp` files start with `using namespace godot;` and define their functions with the `engine::` qualifier. The files in that directory that are verbatim copies of engine sources (`marshalls.h`, `paged_allocator.h`, `ustring.*`) keep the `godot` namespace they were written in. Macro-only headers such as `api/language/names.h` have nothing to wrap, and macro bodies stay fully qualified because they expand at the use site.
- **Includes** — Every file includes what it uses directly and nothing it does not; do not rely on a header reaching you through another include. When a header only includes something for its `.cpp`, move the include to the `.cpp`. Build `editor`, `template_debug` and `template_release` after touching includes: the three targets compile different `#ifdef` branches.
- **clang-format** — Run `clang-format -i` (version 20 or newer, the repo `.clang-format` uses recent options) over every `.cpp`, `.h` and `.mm` under `cpp/` except the generated `cpp/editor/project/templates.h`, which carries `// clang-format off`.
- **Initialization** — Use `=` for scalar values and expressions already of the declared type (`int count = 0;`, `String name = get_name();`, `jni::JObject result = wrapped.call_object_method(...);`). Use direct `()` initialization whenever an object is constructed from something of another type, whether its constructor is explicit or implicit: `Type value(expr);`, never `Type value = Type(expr);`. This includes JNI wrappers built from raw handles or from a call returning a different wrapper: `jni::Env env(p_raw_env);`, `jni::JLongArray array(p_raw_array);`, `jni::JString name(wrapped.call_object_method(...));`. Use `()` for constructor calls with several arguments (`Vector3 pos(1, 2, 3);`), `{}` only for arrays, aggregates, `std::initializer_list` parameters, and returned/passed temporary aggregates (`return {ptr, size};`). Member initializer lists use `()`, default member initializers use `=`. Never `Type value{expr};`, never `Type value();`, never `Foo f{};` on a class type (write `Foo f;`); zero PODs with `= {}`.

## Prerequisites

- **JDK 17+** required for building, running, and developing Godot-JVM projects. 17 is also the minimum compile toolchain for Java, Kotlin and Scala, both for the Godot-JVM modules (`toolchain-jvm` in `kt/gradle/libs.versions.toml`; the IntelliJ plugin uses 21, as its platform requires) and for user projects (`MINIMUM_JDK_VERSION` in the gradle plugin's `checkVersionCompatibility.kt`)
- Use **Adoptium/Eclipse Temurin** JDK — Microsoft JDK causes IDE plugin build failures (known issue [microsoft/openjdk#339](https://github.com/microsoft/openjdk/issues/339)). If you must use Microsoft JDK, manually create the `Packages` folder inside `JAVA_HOME`.
- `JAVA_HOME` must be set
- Standard Godot build deps: SCons, Python, C++ compiler

## Build Commands

The project has two independent build systems that must both be built.

### Native GDExtension (SCons)

SCons, run from the repository root, builds the native library straight into `harness/tests/addons/jvm/libs/` (Android: `build/android/`). Platforms use godot-cpp naming (`linux`, `windows`, `macos`, `android`, `ios`). Commands, `dev_build` and the other options: `build-native` skill.

### Kotlin/Gradle

```bash
cd kt/
./gradlew build                  # build all subprojects, every library module in both debug and release
./gradlew publishLocal           # publish everything a user project needs to mavenLocal
```

Publishing has three lifecycle tasks in `kt/build.gradle.kts`, one per destination: `publishLocal` (mavenLocal), `publishCentral` (Maven Central, plus the Gradle Plugin Portal for releases) and `publishJitpack` (run by the root `jitpack.yml`). `publishLocal` and `publishCentral` publish the two coordinates a user project resolves: the gradle plugin with its marker, and `com.utopia-rise:godot-jvm`. `godot-library` names only the runtime modules under `kt/godot-library/`; the published whole, tools included, is `godot-jvm`. `godot-jvm` is a single GAV published with Gradle Module Metadata that keeps one jar per module, each selected by its capability `com.utopia-rise:godot-jvm-<module>`: `common`, `internal`, `core`, `api`, `extension`, `bootstrap`, `coroutine` (`internal`, `core` and `api` with a debug and a release jar; the others are the same bytes in both builds and publish one jar behind a debug and a release variant, told apart like the rest by the `com.utopia-rise.godot.build-type` attribute), plus `tools-common`, `api-generator`, `class-graph-symbol-processor`, `registration-model` and `registrar-generator` (one jar each). Every module has a `java-api` and a `java-runtime` variant over the same jar, whose dependencies are the module's own `api` and `api` + `implementation` declarations, so `internal` stays off user compile classpaths. Dependencies between modules become capability dependencies on the same GAV, always pinned: a debug or release variant to its own build type, a tool module (single variant, no build type) to `release`, because a plugin classpath carries no build type and the plugin runs with the release library; a dependency on `api` is never published, since a capability cannot be excluded and the custom API replaces it, so the gradle plugin adds `api` itself. The plugin jar holds only the plugin classes and depends on the five tool capabilities, which bring `core`, `internal`, `bootstrap` and `common` (release) but not the API. `internal`, `core` and `api` compile twice in one invocation (`compileKotlin` and `compileReleaseKotlin`, from the `com.utopia-rise.release-flavor` build-logic plugin), so no `-Prelease` pass is needed. When the `godotJvmAddon` Gradle property points at an addon zip, `godot-jvm` also carries it as `godot-jvm-<version>-addon.zip`, in its own variant (capability `com.utopia-rise:godot-jvm-addon`, category `godot-addon`, so library resolution never selects it). `deploy_jvm.yml` passes the addon `assemble_addon.yml` built in the same run, so every tagged release carries it; a local `publishLocal` does not, since it only has the host's native libraries. The gradle plugin's `installAddon` resolves it at the plugin's own version and replaces the project's `addons/jvm/` with it: it moves the old directory to a hidden `addons/.jvm-previous-<time>/`, because Windows lets a running editor's library be renamed but not deleted, and removes it then or on the next run. The editor runs it from the toolbar as **Sync Addon Version**; `GodotJvmEditor` records the modification time of `addons/jvm/jvm.gdextension` at startup and, when it changes, shows a toast and a yellow status light asking for a restart, like it does for a replaced `godot-bootstrap.jar`. The root build script only declares the modules (`godotJvm { flavored(…); shared(…); tool(…) }`) and the lifecycle tasks; the mechanics live in build-logic: `com.utopia-rise.godot-jvm-publication` (`GodotJvmPublicationPlugin`: the component, its variants, the jars and the `godot-jvm` publication) and `com.utopia-rise.individual-jars-publication` (`IndividualJarsPublicationPlugin`). JitPack cannot serve `godot-jvm`: it rewrites the Gradle module metadata it serves, renaming every variant's file to the main jar and dropping the capabilities requested by dependencies (seen on a real build). `publishJitpack`, run by the root `jitpack.yml`, therefore publishes every jar as its own POM-only artifact, `<module>-<debug|release>` (tools without suffix), whose POM depends on the other artifacts of the same build type; JitPack serves them as `com.github.utopia-rise.godot-jvm:<artifact>:<tag or commit>`, e.g. `com.github.utopia-rise.godot-jvm:core-release:1.0.0`. They are for picking jars by hand: the gradle plugin only ever uses `com.utopia-rise:godot-jvm`, and the individual artifacts never go to Maven Central. Both projects apply the `com.utopia-rise.maven-central` build-logic plugin (`MavenCentralPlugin`), which sets the POM metadata Central requires on every publication and configures the Central repository and signing only when the `mavenCentralUsername`, `mavenCentralPassword`, `signingInMemoryKey` and `signingInMemoryKeyPassword` Gradle properties are all set (CI passes them as `ORG_GRADLE_PROJECT_*`). Artifacts carry the build version, not the Godot-JVM version: the commit's version tag when it has one, its short hash otherwise (`buildVersion` in `VersionInfoPlugin`, which also sets every project's group). A commit tagged `x.y.z` is the release `x.y.z`; a commit tagged `x.y.z-devN` or `x.y.z-rcN` becomes `x.y.z-devN-SNAPSHOT` or `x.y.z-rcN-SNAPSHOT`; any other commit is `<short hash>-SNAPSHOT`, and a reproducible CI build `ci-SNAPSHOT`. A version tag must equal `godotJvm`, and a commit may carry only one, otherwise the build fails. The rule lives in `BuildVersion` (`kt/tools-common/src/version/kotlin`), a dependency-free file compiled into both build-logic and `tools-common`; the generated `BUILD_VERSION` in `tools-common` holds the tag and the hash, and the plugin requests `godot-jvm` at its `value`. A version ending in `-SNAPSHOT` is uploaded to `https://central.sonatype.com/repository/maven-snapshots/` instead and skips the Plugin Portal, which rejects snapshots. A snapshot is consumed like a mavenLocal build, with `maven("https://central.sonatype.com/repository/maven-snapshots/")` in both `pluginManagement.repositories` and the project `repositories`. The Android plugin AARs are not Maven artifacts and are copied by hand (see `test-a-branch.md`).

The snapshot version appears in `~/.m2/repository/com/utopia-rise/godot-gradle-plugin/`. The consuming project needs `mavenLocal()` in both `pluginManagement.repositories` (`settings.gradle.kts`) and the project `repositories` block (`build.gradle.kts`); the plugin resolves the libraries from the latter and adds no repository itself.

## Testing

```bash
cd kt/ && ./gradlew test   # Kotlin unit tests
```

`harness/tests/` is a full Godot-JVM project driven by the official Godot editor and built against the repository sources; its gdUnit4 suites are the integration tests (`run-harness-tests` skill). `harness/editor-monkey/` drives the real editor to test editor features and jar reloading (`run-editor-probes` skill); CI runs it on Linux, and `assemble-addon` waits for it. To try a branch in another project, use the `test-in-project` skill.

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
- **`cpp/jvm/bridge/`, `cpp/jvm/memory/`, `cpp/jvm/registration/`** — JNI bridges for the core types, the per-thread `VariantBuffer` and `ValueBuffer` with the wire format, and the wrappers of the registered Kotlin classes.
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
- **`godot-registration/`** — Directory grouping the three registration modules below (not a Gradle module itself); each is published as its own jar in the `godot-jvm` GAV.
- **`godot-registration/godot-class-graph-symbol-processor/`** — Front-end: bytecode processor using ClassGraph (replaced KSP/Mpapt; language-agnostic, supports Kotlin/Java/Scala equally). Reads compiled bytecode and produces model instances. No validation.
- **`godot-registration/godot-registration-model/`** — The validated IR shared between processor and generator. Owns the registration model and its sanity checks; an instance existing means it is valid.
- **`godot-registration/godot-registrar-generator/`** — Back-end: consumes models from the processor and generates registration glue code. No validation.
- **`api-generator/`** — Reads Godot's `api.json`, generates all Kotlin bindings in `godot-api-library/`. Run in CI when Godot API changes.
- **`plugins/godot-gradle-plugin/`** — Applied to all user Godot-JVM projects; orchestrates compile → symbol processing → registrar generation → JAR packaging.
- **`plugins/godot-intellij-plugin/`** — IntelliJ IDEA integration (code insight, run configs, templates).
- **`common/`**, **`tools-common/`** — Shared utilities across subprojects; each is published as its own jar in the `godot-jvm` GAV.

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
| `jvm/debug/usercode.jar` | user code + generated registrar + `godotGameImplementation` and `godotGameRuntimeOnly` dependencies (shadow) | Reloaded after each build in the editor; bundled in debug exports |
| `jvm/release/game.jar` | both JARs merged | Release exports; one class loader, no reloading |
| `game` (native image) | GraalVM AOT compilation of the variant's JARs | Replaces the JARs; no runtime reloading |

Debug and release artifacts live under `jvm/debug/` and `jvm/release/` (Gradle: `build/libs/<variant>/`) and never overwrite each other; the editor and `template_debug` load the debug variant, `template_release` the release variant (`cpp/paths.h` selects `BOOTSTRAP_FILE`, `USER_CODE_FILE` and `GRAAL_NATIVE_IMAGE_FILE` per `DEBUG_ENABLED`). The export plugin packs exactly the variant matching the export type and reports a missing one. `godotSplitImplementation` and `godotSplitRuntimeOnly` dependencies stay as intact JARs under `res://jvm/<variant>/dependencies/` and are added to the JAR's class path. Every build also writes `jvm/script-classes.json` (`ScriptClassIndexBuilder`, copied by `copyScriptClassIndex`), the registered name and base of each class by fully qualified name; the editor reloads it in `GodotJvmEditor::on_filesystem_change` and `JvmLanguage::_get_global_class_name` falls back on it when the JVM has no class for a script, so a release export needs no debug build for its global class cache. The export plugin reports every missing artifact without stopping and ends with one summary error. Details: `docs/src/doc/contribute/how-it-works/artifacts.md`

### Memory Management

Each Godot object can have two JVM instances:
- **Wrapper** — wraps the C++ pointer, allows JVM to call C++ methods
- **Script Instance** — user's Kotlin subclass; stored as a strong JNI reference on the C++ side

`MemoryManager` singleton synchronizes lifecycle between Godot and JVM via Godot's instance binding callbacks.

**`RefCounted` objects (critical):** When the reference counter reaches 1 (JVM is the only user), the wrapper converts its reference to a **weak reference** to prevent cyclic memory leaks. The C++ side holds a strong JNI reference to the script instance, preventing GC while the native object is alive.

**`Object` (non-ref-counted):** Simpler — manually freed; binding lifecycle follows the Godot object directly.

Full details: `docs/src/doc/contribute/how-it-works/memory-management.md`

### JNI Shared Buffers (Performance)

To reduce JNI overhead for frequent calls, two **per-thread buffers** carry C++/JVM parameter exchange. Every value is an 8-byte type ordinal followed by its payload, both aligned on 8 bytes; type ordinals 0–38 cover all Godot variant types (primitives at fixed size, strings up to 128 bytes inline and larger ones via the JNI queue, `Array` at 28, packed arrays at 29–38). The per-type rows live in `cpp/jvm/memory/variant_type.h` and the Kotlin `VariantParser`. A row states the C++ type, its *shape* (inline, pointer, object, custom) and whether the JVM owns a native instance of it; `cpp/jvm/memory/variant_table.h` derives from those rows the five tables indexed by a Variant ordinal — argument formats the value buffer walks and return formats the unchecked call picks its destination from, decoders and encoders for the variant buffer, releasers for the sweep. Neither buffer depends on the other and adding a type is one line.
- **`VariantBuffer`** — everything but an unchecked engine call. Rewound by every exchange, so it holds one call at a time: an argument count (object method calls prefix it with the caller pointer and `ObjectID`) then the values. Sized for 16 values of the largest kind, a String at the inline limit (`MAX_ARGUMENT_COUNT` in `cpp/constraints.h`).
- **`ValueBuffer`** — a stack of unchecked call (`ptrcall`) frames, packed one after another. The engine reads the arguments in place and writes the result after them, so a frame lives for the whole call; nested calls stack. Each frame's own offset and return offset live in the JVM stack frame of the generated call, so the only shared state is where the next frame starts. `value_buffer_size_factor` sizes the stack in entirely full frames (4 by default), a capacity rather than a nesting limit; the check exists only in debug builds.
- The two engine call entry points, `icall` and `icallPtr`, are static natives on `godot.core.KtObject` (`cpp/jvm/registration/kt_object.cpp`), and that file is the only one that makes a ptrcall: the frame reserves the return slot, the entry point picks where the engine writes.
- `_process` and `_physics_process` never touch the `VariantBuffer`: the registrar generator registers an override with the engine's exact signature as a `KtProcess` (`kt/godot-library/godot-bootstrap-library`), a slot on `KtClass` on both sides rather than an entry in its function list, and `KtClass::call` (`cpp/jvm/registration/kt_class.h`) passes `delta` as a JNI argument to its entry. Any other overload is an ordinary `KtFunction`.

Details: `docs/src/doc/contribute/how-it-works/shared-buffer.md`

### Runtime configuration

Game settings live in `res://godot_jvm_configuration.json` (schema `version` `"3.0"`) and have `--jvm-*` command-line equivalents; precedence is defaults → JSON → command line (`cpp/jvm/lifecycle/jvm_user_configuration.*`, `GodotJvm::fetch_user_configuration`). The editor validates and repairs the file, but applies only command-line settings to its own defaults. `--jvm-use-native-image` works in the editor but disables script reloading. Command-line values are never written back. Reference: `docs/src/doc/reference/runtime-configuration.md`.

Behaviour that is easy to miss in the code:
- `use_debug`, `debug_port`, `debug_address`, `wait_for_debugger` apply only to desktop JVM games in `DEBUG_ENABLED` builds (`GodotJvm::set_jvm_options`); `jmx_port` also applies in release builds. These dedicated options are ignored by native images and mobile runtimes.
- `custom_jvm_args` applies to desktop JVM runs and supported native-image runtime options on desktop and iOS. The editor accepts custom arguments through the command line only; Android ignores them.
- On Android the extension attaches to the existing ART VM, so no `JvmOptions` (debug, JMX, custom args) or `--jvm-path` apply.
- `max_string_size` is capped at 65535 because `LongStringQueue::max_string_size` is a `uint16_t`. It sizes the `VariantBuffer` only; `value_buffer_size_factor` sizes the `ValueBuffer` and applies to every runtime, including Android, since both buffers live on the JVM side.
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
- **Single-build modules** — `extension`, `bootstrap` and `coroutine` are published once for debug and release builds. They must never read `GodotJvmBuildConfig.DEBUG`, and must not call an inline `core` or `internal` function that does: the inlined debug check would ship in release builds. `VariantArray<T>()` and `Dictionary<K, V>()` are such functions today, which is why `api` keeps two builds.

## CI/CD

Workflows in `.github/workflows/`. The canonical Godot version (`GODOT_VERSION`) and JDK version (`JVM_VERSION`) are defined at the top of `trigger_ci.yml` (and mirrored in `trigger_on_tag.yml`). Build matrix: Android, iOS, Linux, macOS, Windows × editor/template_release targets.

`deploy_jvm.yml` (called from `trigger_on_tag.yml`) publishes with one `kt/gradlew -p kt publishCentral` step, the remote counterpart of `publishLocal`: `godot-jvm` and the gradle plugin are signed and uploaded to Maven Central (two releases per version; the deployment is not released automatically, so it is released from the Central Portal), and the plugin also goes to the Gradle Plugin Portal. All three tag kinds run the same pipeline (GitHub release, native builds, Maven publishing); an `x.y.z` tag publishes a true release, while `x.y.z-devN` and `x.y.z-rcN` tags publish the snapshot version to the Central snapshot repository and skip the Plugin Portal and the stable docs; the IntelliJ plugin goes to the Marketplace for `x.y.z-rcN` tags, on the `alpha` channel, and for releases, on `stable`, but not for `x.y.z-devN` tags. Test jobs build the harness against the local sources through `harness/godot-jvm-builds.settings.gradle.kts`, which substitutes `com.utopia-rise:godot-jvm` and the plugin with the `kt/` projects, and the release matrix entries build with the `…Release` tasks, which make the plugin select the release variants, in included builds too. The path-change gate in `trigger_ci.yml` treats `kt/build-logic` as part of both the runtime libraries and the Gradle plugin. Cache layout: `.github/CI_CACHES.md`.

## Documentation

- Contribution setup: `docs/src/doc/contribute/build-from-source.md`
- Guidelines: `docs/src/doc/contribute/index.md`
- Memory management deep dive: `docs/src/doc/contribute/how-it-works/memory-management.md`
- Registrar generation: `docs/src/doc/contribute/how-it-works/registrar-generation.md`
- JNI shared buffers: `docs/src/doc/contribute/how-it-works/shared-buffer.md`
- Testing branch changes: `docs/src/doc/contribute/test-a-branch.md`

Serve docs locally: `cd docs/ && ./run.sh`
