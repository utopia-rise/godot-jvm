# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What This Project Is

**Godot-JVM** is a GDExtension-based JVM binding that enables Kotlin, Java, and Scala as scripting languages. It is a hybrid C++/JVM project: the C++ side integrates with Godot through GDExtension, and the Kotlin/Gradle side provides the runtime libraries and tooling for user projects.

Current binding version: `1.0.0` targeting Godot `4.7.2`.

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

## Prerequisites

- **JDK 17+** required for building, running, and developing Godot-JVM projects
- Use **Adoptium/Eclipse Temurin** JDK — Microsoft JDK causes IDE plugin build failures (known issue [microsoft/openjdk#339](https://github.com/microsoft/openjdk/issues/339)). If you must use Microsoft JDK, manually create the `Packages` folder inside `JAVA_HOME`.
- `JAVA_HOME` must be set
- Standard Godot build deps: SCons, Python, C++ compiler

## Build Commands

The project has two independent build systems that must both be built.

### Native GDExtension (SCons)

Run SCons commands from this repository's root. They build the native GDExtension library.

```bash
scons platform=linuxbsd target=editor             # Linux editor
scons platform=windows target=editor              # Windows editor
scons platform=linuxbsd target=template_release   # export template
scons p=linuxbsd -j$(nproc) debug_symbols=yes dev_build=yes  # debug build (multi-core)
```

### Kotlin/Gradle

```bash
cd kt/
./gradlew build                  # build all subprojects
./gradlew build -Prelease        # production/release build
./gradlew publishToMavenLocal    # publish artifacts locally for branch testing
./gradlew publishArtifactsToMavenLocal  # publish all local-consumption artifacts to mavenLocal
```

Full local publish (for testing unreleased branch changes in a user project):
```bash
cd kt/
./gradlew publishArtifactsToMavenLocal
# Version will appear in ~/.m2/repository/com/utopia-rise/godot-gradle-plugin/
```

### Template Generation (Python)

Run after modifying any `.template` or `.godot_template` files under `kt/plugins/godot-intellij-plugin/src/main/resources/template/`:

```bash
python generate_templates.py
```

This converts templates into base64-encoded C++ headers at `cpp/editor/project/templates.h` (split into 8KB chunks to avoid C++ header size limits), then rebuild the native GDExtension.

## Testing

```bash
# Kotlin unit tests
cd kt/ && ./gradlew test

# Integration tests (GUT-based, requires a built editor binary)
cd harness/tests/
jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux  # create JRE first
./gradlew runGutTests
```

The `harness/tests/` directory is a full Godot project. It requires a built editor binary and `godot-bootstrap.jar` copied to the Godot root `bin/` folder before running.

### Testing Changes from a Feature Branch

1. Publish locally (see above)
2. Configure the user project's Gradle repositories to use `mavenLocal()` and use the exact snapshot version you published (e.g. `1.0.0-d68f299-SNAPSHOT`)
3. Run with the dev build: `./bin/godot.linuxbsd.editor.dev.x86_64.jvm` (or platform equivalent)

Full workflow: `docs/src/doc/contribute/test-a-branch.md`

### Debugging JVM Code

```bash
# Start Godot with debug port
godot --jvm-debug-port=5005
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

- **`cpp/gd_kotlin.h/cpp`** — `GDKotlin` singleton; owns the runtime state machine (`uninitialized → project_discovered → jvm_started → project_loaded → ...`). Many operations gate on correct state — check here first when debugging startup issues.
- **`register_types.cpp`** — GDExtension entry point; registers `JvmScript` types, script languages, resource loaders/savers with Godot.
- **`cpp/jvm/lifecycle/`** — JVM startup (`jvm_manager`), class loader management, project settings parsing.
- **`cpp/jvm/wrapper/`** — JNI bridges, type conversion, per-thread shared buffer communication.
- **`cpp/api/script/`** — Script types: `JvmScript` (abstract base), `KotlinScript`, `JavaScriptLanguage`, `GdjScript`, `ScalaScript`.
- **`cpp/api/language/`** — `ScriptLanguage` implementations (`KotlinLanguage`, `JavaLanguage`, etc.) registered as Godot editor language options.
- **`cpp/core/`** — Binding manager; maps Godot objects to JVM instances, synchronizes lifecycle.
- **`cpp/editor/`** — Editor plugin, Gradle task dialog, project generation from templates.
- **`cpp/api/resource_format/`** — `JvmResourceFormatLoader`/`Saver` for JAR files.

### Kotlin/JVM Layer (`kt/`)

- **`godot-library/godot-api-library/`** — Auto-generated Godot API bindings. **Never edit manually.** Regenerate with `kt/api-generator` after `api.json` changes.
- **`godot-library/godot-core-library/`** — Core types, signal infrastructure, base classes for user code.
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
  → godot-gradle-plugin packages godot-bootstrap.jar + main.jar
  → JvmResourceFormatLoader loads JARs in editor
  → C++ jvm_manager starts embedded JVM
  → Bootstrap initializes user classes via JNI reflection
  → GDKotlin binding manager maps JVM objects ↔ Godot nodes
```

### JAR Artifacts

| JAR | Contents | Purpose |
|-----|----------|---------|
| `godot-bootstrap.jar` | godot-library + startup code | Editor use; reloads user code after rebuilds |
| `main.jar` | user code + dependencies (shadow) | Bundled in exports, executed at runtime |
| `usercode` (native image) | GraalVM AOT compilation | Replaces both JARs; no runtime reloading |

### Memory Management

Each Godot object can have two JVM instances:
- **Wrapper** — wraps the C++ pointer, allows JVM to call C++ methods
- **Script Instance** — user's Kotlin subclass; stored as a strong JNI reference on the C++ side

`MemoryManager` singleton synchronizes lifecycle between Godot and JVM via Godot's instance binding callbacks.

**`RefCounted` objects (critical):** When the reference counter reaches 1 (JVM is the only user), the wrapper converts its reference to a **weak reference** to prevent cyclic memory leaks. The C++ side holds a strong JNI reference to the script instance, preventing GC while the native object is alive.

**`Object` (non-ref-counted):** Simpler — manually freed; binding lifecycle follows the Godot object directly.

Full details: `docs/src/doc/contribute/how-it-works/memory-management.md`

### JNI Shared Buffer (Performance)

To reduce JNI overhead for frequent calls, a **per-thread 8KB buffer** is used for C++/JVM parameter exchange:
- First 4 bytes: variable count
- Each variable: 4-byte type ordinal + type-specific bytes
- Type ordinals 0–27 cover all Godot variant types (primitives at fixed size, strings up to 512 bytes inline, larger strings via JNI queue)

Details: `docs/src/doc/contribute/how-it-works/shared-buffer.md`

### JVM Modes

Configured in Godot project settings:
- **Embedded JVM** — `jlink`-created JRE bundled with the project (recommended for distribution)
- **Dynamic JVM** — discovered at runtime via a `java` executable on `PATH` first, falling back to
  `JAVA_HOME` only if nothing usable is found on `PATH` (see `get_path_to_java_executable()` /
  `get_path_to_environment_jvm()` in `cpp/godot-jvm.cpp`)

## Key Gotchas

- **Kotlin version** — The compiler plugin requires a specific Kotlin version. Mismatches cause build failures. Override via gradle plugin config; see `docs/src/doc/reference/gradle-plugin/languages-and-toolchains.md`.
- **Godot API auto-generation** — `kt/godot-library/godot-api-library/` is fully generated. Any manual edits will be overwritten.
- **Template generation** — Editing `.template` files without running `generate_templates.py` and rebuilding C++ will have no effect.
- **Adding a new script language** — Requires: `JvmScript` C++ subclass + `ScriptLanguage` subclass + registration in `register_types.cpp` + entry in `JvmResourceFormatLoader`/`Saver`.

### GDScript global scope sync commit

When checking whether the `GD` singleton needs to be synchronized with GDScript global functions, compare Godot's `@GlobalScope` changes against this baseline:

- Godot `4.7.1-stable`: `a13da4feb8d8aefc283c3763d33a2f170a18d541`

## CI/CD

Workflows in `.github/workflows/`. The canonical Godot version and JDK version (17) are defined in `trigger_on_push_master.yml`. Build matrix: Android, iOS, Linux, macOS, Windows × editor/template_release targets.

## Documentation

- Contribution setup: `docs/src/doc/contribute/build-from-source.md`
- Guidelines: `docs/src/doc/contribute/index.md`
- Memory management deep dive: `docs/src/doc/contribute/how-it-works/memory-management.md`
- Registrar generation: `docs/src/doc/contribute/how-it-works/registrar-generation.md`
- JNI shared buffer: `docs/src/doc/contribute/how-it-works/shared-buffer.md`
- Testing branch changes: `docs/src/doc/contribute/test-a-branch.md`

Serve docs locally: `cd docs/ && ./run.sh`

