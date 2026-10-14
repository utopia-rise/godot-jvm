# godot-registration

Tooling that turns compiled user code selected by `@Script`, `@Register`,
`@Notification`, `@Visible`, and `@Emit` into registrar source. It also
generates `.gdj` registration files for registered classes supplied by external dependencies.

This directory groups three Gradle modules. Each is published as its own jar in the `godot-jvm` artifact, whose
metadata declares their dependencies; the Godot Gradle plugin depends on them.

## Pipeline

```
compiled user bytecode
  -> [godot-class-graph-symbol-processor]  front-end: ClassGraph scan -> registration model
  -> [godot-registration-model]            shared model + sanity checks
  -> [godot-registrar-generator]           model -> registrar Kotlin source
```

The Gradle plugin task
`plugins/godot-gradle-plugin/.../registrar_generation/ClassGraphGenerateRegistrarFilesTask.kt`
orchestrates the whole flow.

1. `ClassGraphProcessor.process(runtimeClassPathFiles, ProcessorSettings)` returns `List<ScriptClass>`.
2. `ModelCheck.check(allRegisteredClasses, logger, registeredNameProvider?)` validates the model.
3. `RegistrarGenerator.generateClassArtifacts(...)` writes generated registrar source, and the Gradle task writes
   the `ClassRegistrar` service file.
4. For external dependencies, the Gradle task optionally stages `.gdj` files through
   `RegistrationFileGenerator`.

## Submodules

| Module                               | Role                                                                                                                            | Entry point                                                            |
|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------|
| `godot-class-graph-symbol-processor` | Front-end. Uses ClassGraph to scan compiled Kotlin/Java/Scala bytecode and map relevant classes into the registration model.    | `ClassGraphProcessor.process(...)`                                     |
| `godot-registration-model`           | Shared IR and validation layer. Owns `ScriptClass`, registered members, type hierarchy nodes, property hints, and model checks. | `ModelCheck.check(...)`                                                |
| `godot-registrar-generator`          | Back-end. Consumes validated models and emits registrar Kotlin source, service metadata, and generator-side JVM type helpers.   | `RegistrarGenerator.generateClassArtifacts(...)`                       |

## Property And Method Intent

The symbol processor rebuilds JVM property shape before registration selection. A method can be
accessor-shaped without being forced to register only as a property.

The current split is:

- `godot-class-graph-symbol-processor` detects property shape from JVM fields and accessor-shaped methods.
- `RegistrationMapper` resolves registration intent.

For accessor-shaped methods:

- `@Visible` marks property intent.
- `@Register` marks function intent.
- no annotation defaults to property intent.
- both annotations register both a property and a function.

This is especially important for Java custom `getX()` / `setX()` APIs and Kotlin computed properties.

In explicit mode, method registration is now truly annotation-only:

- `@Register` is required for methods
- `@Notification` is required for notification handlers
- overriding a Godot base method does not auto-register it

Godot base overrides are only auto-selected in inferred mode.

Notification handlers stay in `ScriptClass.functions` as `RegisteredFunction` entries with a notification id.
The generator emits them through the registrar's `notification(id, Class::method)` API instead of exposing them
as regular callable methods. A notification handler must be public, take no arguments, return `Unit`, and must not
be an RPC function.

## Model Shape

The main top-level output is `ScriptClass`, not the old entry-generation `Clazz` or `RegisteredClass`.

Hierarchy is represented by `ScriptFamily`:

- `ScriptClass`: user-authored Kotlin/Java/Scala class. It may be registered, abstract registered, or a
  non-registered intermediate parent whose members must be hoisted into the nearest registered descendant.
- `GodotBaseClass`: built-in Godot API class such as `Node`, `Button`, `Resource`, or `NavigationMesh`.
  It carries no registered members, but it preserves the built-in parent chain for ancestry checks.
- `ScriptInterface`: user-authored interface that can contribute registered functions.

Class-like families implement `GodotClass`, which provides `parent`, `baseGodotClass`, and
`inheritsRefCounted`. Every `ScriptFamily` has cached `allAncestry`, built from direct parent plus direct
interfaces plus each ancestor's own ancestry.

The symbol processor also uses lightweight referenced hierarchy nodes for property/parameter/return types:
`ReferencedGodotClass` and `ReferencedScriptInterface`. They preserve ancestry for checks like
`Type.isNodeType()` without recursively materializing all registered members of referenced classes.

The member lists on `ScriptClass` and `ScriptInterface` are local-only. Parent and interface links are
preserved separately.

`RegisteredFunctionConfiguration`, `RegisteredPropertyConfiguration`, and `RegisteredSignalConfiguration`
were removed. The final model now stores direct values instead of one-field configuration wrappers:

- `RegisteredFunction` stores `rpcConfig` directly
- `RegisteredFunction.notification` stores the handled notification id, when the function is a notification handler
- `RegisteredSignal` stores `parameterNames` directly
- `RegisteredProperty` stores `isExported`, binding strategy, and accessor names directly

`JvmType` is not part of this shared model. It now lives in `godot-registrar-generator` because it is only a
generator-side JVM type bucketing helper used by hint validation and fqname matching.

Properties also carry their generator binding strategy explicitly:

- `PROPERTY_REFERENCE`
- `ACCESSOR_METHODS`

This keeps the generator dumb. It no longer has to guess whether a property should be emitted as
`Class::property` or `Class::getter` / `Class::setter`.

## Validation

Validation belongs in `godot-registration-model`, under `checks/`. The processor maps bytecode into model
objects; the generator assumes the model was already checked.

`ModelCheck` executes every check and reports all issues before returning failure. Current checks cover
constructor shape, function argument count, notification handler shape, signal type usage,
property type/mutability/lateinit/nullability, RPC usage, and optional registered-name uniqueness.

Registered-name uniqueness is enabled by the Gradle task only for `RegisteredNameMode.SIMPLE_NAME`, where
two classes from different packages can otherwise collapse to the same Godot registered name.

## Naming

The generator computes registered names with `ScriptClass.getRegisteredName(settings)`:

- `SIMPLE_NAME`: custom name if present, otherwise the Kotlin/JVM simple class name.
- `FQ_NAME`: package plus class name.
- `PROJECT_PREFIX`: simple name for the current project, project-prefixed name for external project roots.

The final name is sanitized by replacing `.` and `-` with `_`.

## Generator Hierarchy Behavior

The generator is not local-only even though the model is.

For one registrar, `godot-registrar-generator` walks parent classes and interfaces through the preserved
hierarchy references, then generates an effective inherited view:

- properties: local + inherited, deduplicated by property name
- signals: local + inherited, deduplicated by signal name
- functions: local + inherited, deduplicated by function signature

Local members are added first, so child overrides win and inherited duplicates are dropped during
generation.

For property emission, the generator follows the property binding already chosen by the processor:

- Kotlin properties use `Class::property`
- Java field-only properties use `Class::property`
- Java bean-style and Scala accessor properties use explicit accessor references

Scala setter names such as `name_$eq` are emitted with escaped Kotlin member references.

## Language Detection

`JvmLanguage` selection is source-file based:

- `.kt` -> Kotlin
- `.scala` -> Scala
- `.java` -> Java

If a candidate script class cannot be matched to one of those source origins, the processor emits a warning
and skips that class instead of failing the whole run.

## Building

From the `kt/` Gradle build:

```bash
./gradlew :godot-class-graph-symbol-processor:build :godot-registration-model:build :godot-registrar-generator:build
```

The harness project is a useful end-to-end check for this module:

```bash
cd harness/tests
./gradlew build
```


