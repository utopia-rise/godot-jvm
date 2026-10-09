# CLAUDE.md - godot-registration

Guidance for working inside the `godot-registration` umbrella module. This complements the repo-root
`CLAUDE.md`; read that first for wider project conventions. Keep this file and `README.md` in sync when
the module shape changes.

## What This Is

`godot-registration` turns compiled user bytecode into the generated registrar code and `.gdj` files Godot
uses at runtime. It replaces the older entry-generation layer with a ClassGraph-based pipeline that works
for Kotlin, Java, and Scala because it reads compiled classes.

The umbrella module shadow-merges three child modules into one self-contained fat jar:

- `godot-class-graph-symbol-processor`
- `godot-registration-model`
- `godot-registrar-generator`

The Gradle plugin consumes that fat jar from
`plugins/godot-gradle-plugin/.../registrar_generation/ClassGraphGenerateRegistrarFilesTask.kt`.

## Pipeline

```
compiled user bytecode
  -> godot-class-graph-symbol-processor   (front-end, ClassGraph -> model)
  -> godot-registration-model             (shared IR + sanity checks)
  -> godot-registrar-generator            (back-end, model -> files)
```

Preserve the separation:

- The processor maps bytecode into model objects.
- The model owns validation in `ModelCheck` and `checks/`.
- The generator consumes checked models and writes output.
- The processor must not depend on the generator.
- The generator must not depend on the processor.

## Front-End: godot-class-graph-symbol-processor

Package: `godot.annotation.processor.classgraph`

Entry point:

```kotlin
ClassGraphProcessor.process(
    runtimeClassPathFiles: Set<File>,
    settings: ProcessorSettings,
): List<ScriptClass>
```

Important details:

- Uses ClassGraph with class, annotation, field, and method info enabled.
- Requires non-empty `ProcessorSettings.userCodeClassPathRoots`; compilation must happen before scanning.
- Selects classes annotated with `@Script`, subclassing `KtObject`, and not annotated
  `@GodotBaseType`.
- Uses `ProcessorContext` as per-run state for scan result access, caches, settings, and errors.
- Maps class hierarchy into `ScriptClass`, `GodotBaseClass`, `ScriptInterface`, and lightweight referenced
  type nodes.
- Uses only declared/local fields and methods when reconstructing logical members. Inherited Godot API members
  are not supposed to enter the local model shape.

### Language Detection

JVM language selection is intentionally simple and symmetric:

- `.kt` source file -> `KotlinJvmLanguage`
- `.scala` source file -> `ScalaJvmLanguage`
- `.java` source file -> `JavaJvmLanguage`

If a candidate script class cannot be matched to one of those source file origins, the mapper should warn and
skip that class rather than fail the whole processing run.

### Property Shape vs Registration Intent

Keep the front-end and mapper split clear:

- `JvmLanguage` detects JVM property shape.
- `RegistrationMapper` decides whether an accessor-shaped member registers as a property, a function, or
  both.

Accessor-shaped methods currently resolve like this:

- `@Visible`: property intent
- `@Register`: function intent
- no annotation: property intent
- both annotations: register both a property and a function

That rule exists so Java-style custom `getX()` / `setX()` methods and Kotlin computed properties can still
be represented without forcing all accessor-shaped methods to become property-only.

The generated property binding form is also chosen here, not in the generator:

- Kotlin logical properties use property references
- Java field-only properties use property references
- Java bean and Scala accessor properties use accessor-method references

When adding annotation support, parse user-facing annotations here and map them into model fields or
property hints. Do not add misuse checks here unless the mapping itself cannot be completed.

## Model: godot-registration-model

Package: `godot.registration.model`

The model is the shared IR between processor and generator. It owns:

- Registered members: `RegisteredConstructor`, `RegisteredFunction`, `RegisteredProperty`,
  `RegisteredSignal`, `ValueParameter`.
- Type nodes: `Type`, `TypeKind`, `ScriptFamily`, `GodotClass`, `ScriptClass`, `GodotBaseClass`,
  `ScriptInterface`, `ReferencedGodotClass`, `ReferencedScriptInterface`.
- Property hint models under `hint/property/`.
- Sanity checks under `checks/`.

`JvmType` no longer lives here. It is generator-only and now lives in `godot-registrar-generator`.

Thin one-field configuration wrappers were removed from the registered-member model:

- `RegisteredFunction` stores `rpcConfig` directly
- `RegisteredSignal` stores `parameterNames` directly
- `RegisteredProperty` stores `isExported`, binding kind, and accessor names directly

### Hierarchy Model

`ScriptFamily` is the common interface for things that can appear in a script class ancestry graph:

- `ScriptClass`: user-authored Kotlin/Java/Scala class. It carries constructors, signals, properties,
  functions, `customName`, `sourceProjectName`, `sourceFileName`, `isRegistered`, `isAbstract`, and `isTool`.
- `GodotBaseClass`: built-in Godot API class. It carries no registered members, but it keeps its built-in
  `parent` chain so checks can recognize `Button -> Node` and `NavigationMesh -> RefCounted`.
- `ScriptInterface`: user-authored interface. It contributes registered functions and can inherit other
  interfaces.

`GodotClass` is the class-like subset of `ScriptFamily`. It provides:

- `parent: GodotClass?`
- `baseGodotClass: String`
- `inheritsRefCounted: Boolean`

Every `ScriptFamily` exposes cached `allAncestry`. It is built from direct parent plus direct interfaces,
then each ancestor's own cached ancestry, deduped by fqName. Use it for model-backed hierarchy checks such
as `Type.isNodeType()`, `Type.isRefCounted()`, and `Type.isResource()`.

Member lists on `ScriptClass` and `ScriptInterface` remain local-only. Parent and interface links carry the
hierarchy; inherited effective member views are a generator concern.

`RegisteredProperty` now carries the generator-side binding choice explicitly:

- `PROPERTY_REFERENCE`
- `ACCESSOR_METHODS`

That exists so the generator does not try to infer source-language intent from JVM accessor names.

### Registered vs Abstract

`ScriptClass.isRegistered` and `ScriptClass.isAbstract` are independent:

- `isRegistered=true, isAbstract=false`: normal registered class.
- `isRegistered=true, isAbstract=true`: abstract class known to Godot.
- `isRegistered=false`: intermediate parent, abstract or concrete, that is not emitted as its own top-level
  registered class.

Non-registered parents still keep full member and interface data because their registered members must be
hoisted into the nearest registered descendant. Registered parents register themselves; their descendants
can still include them in ancestry metadata, but should not duplicate members that are already represented
by that registered parent unless the generator intentionally needs inherited callable/property references.

### Referenced Type Nodes

Property, parameter, and return types need hierarchy information for checks and hints, but they should not
recursively materialize a full `ScriptClass` with all members. The processor uses:

- `ReferencedGodotClass`
- `ReferencedScriptInterface`

These lightweight nodes preserve `parent`, `interfaces`, and `allAncestry` while leaving member lists empty.

### Validation

`ModelCheck.check(registeredClasses, logger, registeredNameProvider?)` runs all checks and returns `true`
only when none fail. Checks currently include:

- `ConstructorCheck`
- `GenericClassCheck`
- `FunctionArgCountCheck`
- `RegisteredNameUniquenessCheck` when a name provider is supplied
- `SignalTypeCheck`
- `PropertyTypeCheck`
- `PropertyMutablilityCheck`
- `LateinitPropertyCheck`
- `RpcCheck`

Add new model invariants as `BaseCheck` implementations and wire them into `ModelCheck`. If a check needs
generator settings, prefer passing only the small derived function or value it needs, as with registered
name uniqueness. That keeps the model from depending on the generator module.

## Back-End: godot-registrar-generator

Package: `godot.registrar.generator`

Entry point:

```kotlin
RegistrarGenerator.generateRegistrarFilesUsingRegisteredClasses(
    settings,
    registeredClasses,
    logger,
    jvmTypeFqNamesProvider,
    sourceOutputDir,
    serviceFile,
)
```

The generator writes:

- Kotlin registrar source under `godot.registrar`.
- The `META-INF/services/godot.registration.ClassRegistrar` service file.
- `.gdj` registration files through `RegistrationFileGenerator`.

For one registrar, generation is effective-inherited rather than local-only:

- it starts with the class's local properties, functions, and signals
- it walks parent classes and interfaces through the model references
- it appends inherited members
- it deduplicates at the end with child-first precedence

Current dedup rules are:

- properties by property name
- signals by signal name
- functions by function signature

Because local members are added first, child overrides win and inherited duplicates are dropped in the
generated registrar.

Useful areas:

- `GeneratorContext.kt`: per-run generator state.
- `builder/`: per-class registrar spec building.
- `source/`: Kotlin registrar class emission.
- `service/`: service file emission.
- `filebuilder/RegistrationFileGenerator.kt`: `.gdj` file generation.
- `generator/`: constructor, function, property, and signal registration generators.
- `generator/hintstring/`: property hint string generation.
- `generator/typehint/`: property type hint selection.
- `ext/NamingExtensions.kt`: registered-name and Godot class-name mapping.
- `ext/RegisteredClassExtensions.kt`: `.gdj` file path and generator-side hierarchy flattening.

The top-level split is:

- `RegistrarGenerator`: orchestration entry point only.
- `RegistrarClassGenerator`: iterates registered classes and writes registrar Kotlin files.
- `ClassRegistrarSpecBuilder`: builds the full registrar `FileSpec` for one `ScriptClass`.
- `RegistrarServiceFileGenerator`: writes the `META-INF/services` file.

`JvmType` is generator-owned and lives beside these back-end pieces because it is used only for generator
JVM type bucketing and hint validation.

Do not move property-binding decisions into the generator. The generator should only emit the binding already
stored in `RegisteredProperty`, including escaped Kotlin references for Scala setter names such as
`` `name_$eq` ``.

`RegisteredNameMode` lives in generator settings:

- `SIMPLE_NAME`
- `FQ_NAME`
- `PROJECT_PREFIX`

The Gradle task enables `RegisteredNameUniquenessCheck` only for `SIMPLE_NAME`.

## Invocation From Gradle

`ClassGraphGenerateRegistrarFilesTask.generate()` does the end-to-end run:

1. Build `Settings` and `ProcessorSettings`.
2. Call `ClassGraphProcessor.process(...)`.
3. Call `ModelCheck.check(...)`.
4. Call `RegistrarGenerator.generateRegistrarFilesUsingRegisteredClasses(...)`.
5. Optionally generate and sync `.gdj` files.

When debugging, the harness is the fastest end-to-end sanity check:

```bash
cd harness/tests
./gradlew build
```

The generated registrar files land under:

```text
harness/tests/build/generated/registrar-generation/main/kotlin/godot/registrar
```

The generated `.gdj` files land under:

```text
harness/tests/build/generated/registrar-generation/registration
```

## Conventions

- Keep validation out of the front-end and back-end unless the code cannot proceed without it.
- Keep generator settings out of the model. Pass small callbacks or derived values into checks when needed.
- Do not reintroduce entry-generation terminology such as `Clazz`, `RegisteredClass`, or `CanBeParent`.
- Property hints are model hints, not parsed annotation mirrors. Prefer `XHint` names in the model.
- Only properties carry `hints`; class/function/signal metadata lives as direct model fields.
- In explicit mode, methods require `@Register`. Godot base overrides auto-register only in inferred mode.
- Do not manually edit generated Godot API classes referenced by this module.
- Submodules are not published individually; the umbrella module publishes the self-contained shadow jar.


