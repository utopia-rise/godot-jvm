---
description: How Godot-JVM turns annotated Kotlin, Java and Scala bytecode into registered Godot classes, and what Explicit, Inferred and Automatic modes select.
---

# Registration pipeline

Registration is the bridge between JVM source code and Godot's runtime type
system. It answers two different questions:

1. **Which classes and members should Godot know about?**
2. **How should each selected class or member behave in Godot?**

Selection and configuration are separate responsibilities.

An annotation can participate in either question:

- `@Script`, `@Visible`, `@Emit`, and `@Register` select declarations.
- `@Tool`, `@Export`, property hints, and `@Rpc` configure declarations.
- `@Notification` both selects a method and supplies its notification value.
- Some configuration annotations are themselves meta-annotated with a
  selection annotation. Whether that implied selection counts depends on the
  registration mode.

The mode changes **selection**. It does not remove compatibility requirements
or change what the annotations mean after a declaration has been selected.

## The pipeline at a glance

```text
Kotlin / Java / Scala source
            |
            v
       JVM bytecode
            |
            v
  ClassGraph classpath scan
            |
            v
 language-specific logical shape
 (class, properties, signals, methods)
            |
            v
 registration-mode selection
            |
            v
       validated model
            |
            v
 generated registrar source
            |
            v
 packaged project artifacts
            |
            v
 Godot loads classes and members
```

Kotlin, Java, and Scala encode properties, annotations, and accessors differently, so the front end first reconstructs a language-neutral view.

## Stage 1: compiling user code

The normal JVM compilation tasks run first. Depending on the configured
languages, that can include:

- `compileKotlin`
- `compileJava`
- `compileScala`

Registration reads the completed compilation output. New or changed declarations become available after a successful build.

The registration task receives:

- the compiled user classpath
- the compiled output roots that identify project-owned classes
- the project name
- the selected annotation-processing mode

The default mode is `Inferred`.

## Stage 2: discovering candidate classes

ClassGraph scans the compiled classpath. A candidate script class must:

- inherit `godot.core.KtObject`, normally through a Godot API type such as
  `Node`, `Resource`, or one of their descendants
- be user code rather than a generated Godot base binding
- have an identifiable Kotlin, Java, or Scala source file

`Automatic` mode does not make arbitrary JVM classes into Godot scripts. It
automatically selects from this candidate set of Godot-compatible classes.

Language identification uses the source-file extension stored in bytecode:

- `.kt` selects Kotlin reconstruction
- `.java` selects Java reconstruction
- `.scala` selects Scala reconstruction

An unknown language is skipped with a warning because the processor cannot
safely guess how its bytecode maps back to source-level properties and
signals.

The editor associates a source resource with a compiled class by fully qualified name. `parse_source_script_fqname` in `cpp/api/script/source_script_parser.cpp` combines the package with the class following `@Script`. Without that annotation, it looks for a class whose simple name matches the filename. The registrar does not reconstruct source paths.

## Stage 3: reconstructing a logical class

The processor normalizes each candidate into a `LogicalClassShape` containing:

- the class and its annotations
- logical properties
- logical signals
- logical methods

Only declared members are placed in this local shape. Inherited Godot API
members are not copied into every child.

### Why language normalization is necessary

A source property does not have one universal JVM representation.

Kotlin may emit:

- a backing field
- getter and setter methods
- a synthetic annotation carrier
- delegated-property support fields

Java may expose:

- a public field
- JavaBean-style `getX`, `isX`, and `setX` methods

Scala commonly exposes:

- an accessor named like the property
- a setter named `property_$eq`

The language adapter reconstructs those representations into one logical
property and merges relevant annotations from the field, getter, setter, and
language-specific annotation carriers.

### Accessor-shaped methods

A method can look like both a property accessor and a callable function.
Registration intent resolves the ambiguity:

- `@Visible` indicates property intent.
- `@Register` indicates function intent.
- both can register both views.
- without an explicit function intent, an accessor remains a property rather
  than becoming a duplicate callable.

This decision happens after the language adapter has identified the shape.

## Stage 4: selecting declarations

The selected `AnnotationProcessingMode` controls which logical declarations
enter the registration model.

### Selection matrix

| Declaration | Explicit | Inferred | Automatic |
|---|---|---|---|
| Class | direct `@Script` | effective `@Script` | every public Godot-compatible candidate |
| Property | direct `@Visible` | effective `@Visible` | every public mappable logical property |
| Signal | direct `@Emit` | every logical signal | every logical signal |
| Method | direct `@Register` or `@Notification` | effective `@Register`, or a mappable Godot override | every public mappable logical method |
| Property exported | direct `@Export` | effective `@Export` | yes, by default |

"Effective" means the annotation may be present directly or reached
recursively through meta-annotations.

### Explicit mode: spelling out the public Godot surface

Explicit mode uses only directly declared selection annotations.

Examples of implications that **do not** select in this mode:

- `@Tool` contains `@Script`, but `@Tool` alone does not select the class.
- `@Export` contains `@Visible`, but `@Export` alone does not select the
  property.
- a property hint such as `@IntRange` contains `@Export`, but it does not
  select or export the property by itself.
- `@Rpc` contains `@Register`, but `@Rpc` alone does not select the function.
- overriding `_ready` does not select `_ready`.

The direct annotations must be written alongside the configuration:

```kotlin
@Script
class Player : Node() {
    @Export
    @Visible
    @IntRange(0, 100)
    var health = 100

    @Rpc
    @Register
    fun synchronizeHealth(value: Int) {
        health = value
    }

    @Register
    override fun _ready() {
    }
}
```

Use Explicit mode when the source should visibly describe the complete Godot
API boundary.

### Inferred mode: following annotation meaning

Inferred mode recursively expands meta-annotations.

The built-in chains include:

```text
@Tool -> @Script
@Export -> @Visible
@IntRange and other property hints -> @Export -> @Visible
@Rpc -> @Register
@Notification -> @Register
```

This means configuration can also provide selection:

```kotlin
@Tool
class Player : Node() {
    @IntRange(0, 100)
    var health = 100

    @Rpc
    fun synchronizeHealth(value: Int) {
        health = value
    }

    override fun _ready() {
    }
}
```

Inferred mode also:

- selects every logical signal in a selected class
- selects compatible overrides of Godot base methods

Ordinary project methods still need an effective `@Register`. Inferred does
not mean every public method is exposed.

Custom project annotations can participate in the same mechanism by being
meta-annotated with the built-in annotations.

### Automatic mode: selecting compatible declarations

Automatic mode selects compatible declarations by shape and type:

- all public candidate Godot classes
- all public mappable properties
- all logical signals
- all public mappable methods

Properties are exported by default.

```kotlin
class Player : Node() {
    var health = 100
    val damaged by signal1<Int>()

    fun heal(amount: Int) {
        health += amount
    }

    override fun _ready() {
    }
}
```

Annotations remain useful as metadata:

```kotlin
@IntRange(0, 100)
var health = 100

@Rpc(rpcMode = RpcMode.ANY)
fun synchronizeHealth(value: Int) {
    health = value
}
```

Here the property and function would already be selected. The annotations
configure the Inspector and networking behavior.

## Stage 5: mapping annotations to metadata

Once a declaration is selected, annotations configure the final model.

### Class metadata

- `@Script(className = "...")` supplies a custom registered name.
- `@Tool` records editor-time script metadata. Tool mode itself is not implemented yet.

Without a custom name, `registrationNameMode` determines how the default name
is computed.

### Property metadata

- `@Export` marks a property for the Inspector in Explicit or Inferred mode.
- Automatic properties are exported by default.
- property-hint annotations configure controls such as numeric ranges, file
  pickers, multiline text, colors, enums, and flags.

Property registration and Inspector export are related but distinct:

- a registered property is available to Godot
- an exported property is additionally presented in the Inspector

### Signal metadata

The signal type provides its parameter types. `@Emit` can provide friendly
parameter names. Without explicit names, generated names such as `param1` are
used.

### Function metadata

- `@Rpc` creates an RPC configuration.
- `@Notification(value)` marks a selected method as a notification handler.

`@Notification` is special: automatic method selection does not turn an
ordinary method into a notification handler. The annotation is still
required because its numeric notification value is metadata that cannot be
inferred.

## Stage 6: building and validating the registration model

Selected declarations are mapped into:

- `ScriptClass`
- `RegisteredProperty`
- `RegisteredSignal`
- `RegisteredFunction`
- `RegisteredConstructor`

Creating this model resolves:

- registered names
- Godot base classes and script inheritance
- property binding through a property reference or accessor methods
- parameter and return types
- property mutability and nullability
- property hints
- RPC and notification configuration

The model is then checked as a whole. Registration fails when an invalid
Godot-facing API would be generated.

### Class requirements

- A registered class must inherit a Godot-compatible type.
- A public parameterless constructor is optional. When present, the generated
  registrar exposes it for Godot instantiation; constructors with parameters
  remain JVM-only.
- Registered names must be unique within the known JVM registration set.
- Generic classes cannot be exposed as concrete Godot script types.

### Function requirements

- Registered methods must be public.
- Parameters and return values must be mappable to Godot.
- Unrelated JVM source classes cannot appear in the exposed signature.
- A function can have at most 16 parameters.
- Generic registered methods are not supported.

### Property requirements

A registered property must be public through its field or accessors and use a
supported Godot-facing type, including:

- supported primitives and strings
- Godot core types
- Godot `Node` and `Resource` types
- supported Kotlin and Java collections
- enums
- `BitField<Enum>`

Additional constraints include:

- Godot core types and primitive-like registered values cannot be nullable.
- Godot core types cannot use `lateinit`; provide a default value.
- a property can have only one effective editor hint
- a hint must match the property type
- a `BitField` enum can have at most 32 entries

Registered Kotlin `val` properties are allowed and are exposed read-only.
Mutability is not a universal requirement.

### Signal requirements

- The logical signal must resolve to a `Signal` type.
- Typed signal arity is limited by the available `Signal0` through
  `Signal16` families.
- Signals should be stable immutable members; replacing a signal instance
  would break the registered connection identity.

### RPC requirements

An RPC method must also be a selected registered function. This happens:

- directly with `@Register` in Explicit mode
- through `@Rpc`'s meta-annotation in Inferred mode
- through automatic method selection in Automatic mode

A non-zero transfer channel only has an effect with
`UNRELIABLE_ORDERED`; other transfer modes produce a warning.

## Stage 7: generating registrar source

The back end consumes only the validated model. It does not repeat
language-specific bytecode interpretation.

For each registered class it generates a registrar that records:

- the registered class name
- source file name for language identification, without a reconstructed path
- registered supertypes
- Godot base type
- abstract/concrete state
- constructor, when a public parameterless constructor exists
- signals
- properties
- notification handlers
- functions and RPC configuration

Abstract classes get registrar metadata for inheritance and default-value
support but are not instantiated and do not directly register concrete
members.

## Stage 8: packaging and runtime loading

The Gradle plugin compiles the generated registrar code and packages it with
the user project artifacts. At runtime:

1. the JVM bootstrap discovers the generated registrars
2. each registrar describes its class to the Godot-JVM bridge
3. Godot creates script instances through the registered constructor
4. generated bindings route property, signal, function, RPC, and notification
   operations between Godot and the JVM

The registration mode is a build-time selection policy. Runtime code consumes
the resulting registrar and does not re-evaluate the annotations.

The next chapter covers the registrar generator's input model and how to debug its Gradle task.

In the editor, JAR registrations and physical script resources are reconciled by fully qualified class name. The [JAR and script reloading](jar-and-script-reloading.md) chapter later covers resource ownership, placeholders, and reload order.

## Inheritance behavior

Registration preserves the script family rather than flattening every
inherited member into every class.

Expected behavior:

- exposed parent members remain available to children
- a child override supplies the child behavior
- an un-annotated override keeps the parent's registration; an annotated override with the same parameter list replaces it
- interfaces and abstract script classes participate in the registered type
  family
- only locally declared members are reconstructed in a class's logical shape

This avoids duplicate registrations while retaining normal JVM dispatch.

## Build mode and IDE mode must agree

The Gradle build mode is configured in `build.gradle.kts`:

```kotlin
import godot.annotation.processor.classgraph.AnnotationProcessingMode

godot {
    annotationProcessingMode.set(AnnotationProcessingMode.Inferred)
}
```

The IntelliJ plugin stores its inspection mode as project editor state. Set it
under **Settings | Godot-JVM | Annotation processing mode**.

These settings currently have separate owners. Keep them on the same value:

- Gradle decides what the build registers.
- IntelliJ decides what the editor reports.

Both default to `Inferred`.

## Diagnosing unexpected registration

Trace a missing declaration through class discovery, language reconstruction, mode selection, and model validation. Inspect the first stage that excludes it. If the build and IDE disagree, compare their registration modes before changing policy.

## Ownership boundaries

The registration implementation intentionally keeps a short chain of
responsibility:

- `JvmLanguage`: reconstruct source meaning from language-specific bytecode
- `RegistrationPolicy`: decide what the selected mode includes
- `RegistrationMapper`: create the final model and attach metadata
- registration-model checks: reject invalid Godot-facing APIs
- registrar generator: emit code from valid models
- Gradle plugin: order tasks and package outputs
- IntelliJ plugin: report the same expected policy while editing

When changing behavior, update the narrowest owner and add coverage across
Kotlin, Java, Scala, and all three registration modes where applicable.

## Editor default instances

The editor instantiates each concrete script class outside a scene to read exported property defaults. Constructors and field initializers therefore also run during registration reloads. A node allocated there without scene ownership or explicit freeing can leak on each rebuild. Saved Inspector values are applied later to scene instances; constructors only see the initial defaults.
