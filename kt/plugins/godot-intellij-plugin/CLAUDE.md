# Godot IntelliJ Plugin Guide

This file is the authoritative guide for working on
`kt/plugins/godot-intellij-plugin`.

The plugin provides Godot JVM code insight for Kotlin, Java, and Scala. Keep
the implementation small: inspections dispatch PSI elements, analyzers own
the rules, and tests exercise the same source fixtures through IntelliJ's
real highlighting pipeline.

## Inspection Architecture

Inspection entry points live in:

- `src/main/kotlin/godot/intellij/plugin/inspection/JavaInspection.kt`
- `src/main/kotlin/godot/intellij/plugin/inspection/KotlinInspection.kt`
- `src/main/kotlin/godot/intellij/plugin/inspection/ScalaInspection.kt`
- `src/main/kotlin/godot/intellij/plugin/inspection/CoreTypeCopyModificationInspection.kt`

Shared JVM rules live under `analysis/jvm/`. Kotlin PSI and K2-specific rules
live under `analysis/kotlin/`. Registration-mode decisions belong in
`registration/RegistrationPolicy.kt`.

Keep inspection classes as dispatchers. Do not copy rule logic into the
language entry points when a shared analyzer can express it cleanly.

## New Script Action

`action/NewGodotScriptAction` adds `New | Godot Script` to the project view.
It is only visible for directories inside a Godot project.

`NewGodotScriptDialog` collects the class name, language, Godot base class,
and lifecycle overrides. The base class chooser is an inheritance chooser
rooted at `KtObject`, and only the lifecycle functions declared by the chosen
base class can be selected.

`GodotScriptGenerator` builds the source. Annotations follow
`RegistrationMode`: none in Automatic, `@Script` in Inferred, and `@Script`
plus `@Register` on every override in Explicit. Its output is covered by
`GodotScriptGeneratorTest` for Kotlin, Java, and Scala.

## Run Configuration

`run/GodotRunConfigurationType` registers the `Godot` configuration type. Its
factory is applicable only when the project contains a `project.godot`, which
`Project.godotRoot` resolves through `GodotProjectScopeService`.

`GodotRunConfiguration.buildCommandLine` is the part worth protecting. It
passes the chosen JDK with `--jvm-path`, which the binding resolves before the
embedded JRE and the environment. It also exports `JAVA_HOME` for the tools
Godot starts itself, such as Gradle, but never touches `PATH` and never falls
back to either: Godot-JVM builds without that argument are not supported.
`GodotRunConfigurationTest` covers the editor, game, and JDK cases.

The JDK picker is the platform `SdkComboBox`, so the project SDK, registered
JDKs, and JDKs detected on the machine are all offered without extra code.

## IDE Compatibility

`pluginVerification.ides` in `build.gradle.kts` lists the oldest supported IDE
plus the versions the Marketplace verifies against. Keep it in sync with the
Marketplace, and run it before publishing:

```powershell
.\gradlew.bat :godot-intellij-plugin:verifyPlugin
```

Verifying only the IDEs the plugin is built against hides breakage: Kotlin
plugin internals such as `KtUltraLightClass` disappear in newer builds. Prefer
public, long lived APIs (`KtLightClass`), and own small helpers rather than
calling deprecated Kotlin PSI methods.

## Marketplace Metadata

Both descriptions the Marketplace shows are generated at build time by
`patchPluginXml`; never edit `plugin.xml` for them.

- description: the `<!-- Plugin description -->` block in `README.md`.
  Keep it current when a user-visible feature is added.
- what's new: `CHANGELOG.md`. `publishPlugin` depends on `patchChangelog`,
  which turns `[Unreleased]` into a versioned section, so `changeNotes`
  reads the released version first and falls back to `[Unreleased]`.

Add every user-visible change to `[Unreleased]` under a Keep a Changelog
group. It is published, not just internal documentation.

## Registration Highlighting

Registration highlighting is separate from inspections. It gives declaration
lines a subtle background:

- orange: the declaration is not structurally registerable
- blue: the declaration is a registration candidate
- green: the current mode selects the declaration for registration

Only Godot script classes and their members are highlighted. Unrelated classes
must remain untouched. The shared eligibility rules live under `highlighting/`;
the Scala annotator only adapts Scala property PSI to those rules.

`RegistrationHighlightingTest` covers the same Kotlin/Java/Scala by
Explicit/Inferred/Automatic 3x3 matrix as regular registration inspections.

## Registration Modes

Every regular registration inspection must be tested in all three modes.

### Explicit

Only direct registration annotations count:

- class: `@Script`
- property: `@Visible`
- signal: `@Emit`
- function: `@Register` or `@Notification`

Meta-annotations are not expanded. Godot lifecycle overrides such as
`_ready` must be registered explicitly.

### Inferred

Registration meta-annotations are expanded. Examples:

- `@Tool` carries `@Script`
- `@Export` and property hints carry property registration metadata
- `@Rpc` carries function registration metadata

Godot lifecycle overrides are inferred. Logical signals in registered
classes are inferred, while an effective `@Emit` still identifies a signal
inside a class that is missing registration.

### Automatic

Compatible declarations are selected without registration annotations:

- Godot subclasses are registered
- compatible properties and methods are registered
- logical signals are registered
- properties are exported by default

Annotations can still configure behavior. For example, RPC configuration and
property hints remain meaningful.

## Required 3x3 Test Matrix

The regular inspection suite is a 3x3 matrix:

| Language | Explicit | Inferred | Automatic |
|----------|---------:|---------:|----------:|
| Kotlin   | required | required |  required |
| Java     | required | required |  required |
| Scala    | required | required |  required |

These are nine independent test methods backed by nine source files in the
IDE-check harness. The three mode files for a language intentionally contain
the same declaration cases, with mode-specific package, class, and registered
names so the files do not interfere when opened together.

Test classes:

- `src/test/kotlin/godot/intellij/plugin/inspection/KotlinInspectionTest.kt`
- `src/test/kotlin/godot/intellij/plugin/inspection/JavaInspectionTest.kt`
- `src/test/kotlin/godot/intellij/plugin/inspection/ScalaInspectionTest.kt`

Each class must contain:

- `testExplicitFixture`
- `testInferredFixture`
- `testAutomaticFixture`

## Harness Fixtures

The source fixtures are part of the standalone IDE-check harness. Each
language has `Explicit`, `Inferred`, and `Automatic` variants:

- `../../../harness/intellij-check/src/main/kotlin/godot/inspection/IdeKotlinInspection<Mode>.kt`
- `../../../harness/intellij-check/src/main/java/godot/inspection/IdeJavaInspection<Mode>.java`
- `../../../harness/intellij-check/src/main/scala/godot/inspection/IdeScalaInspection<Mode>.scala`

The fixtures serve two purposes:

1. automated `CodeInsightTestFixture` highlighting tests
2. readable examples that can be opened in the sandbox IDE

Keep equivalent declaration cases aligned across the three files for a
language. Inline comments describe the original Explicit baseline; the test
method for each file is authoritative for its mode-specific diagnostics.

### Checks shared by Kotlin, Java, and Scala

The regular fixtures cover:

- tool classes that are not explicitly registered
- registered members inside an unregistered class
    - properties
    - signals
    - functions
- registered classes that do not inherit a Godot type
- duplicate registered class names, reported on both declarations
- generic registered classes
- generic registered functions
- Godot lifecycle overrides missing explicit registration
- registered functions exceeding the 16-parameter limit

### Additional Kotlin checks

The Kotlin fixture also covers Kotlin-specific PSI and K2 rules:

- overridden registered abstract functions
- nullable registered primitive/core properties
- `lateinit` Godot core properties
- unsupported registered property types
- `VariantArray<Enum>`
- `@Export` without direct `@Visible` in Explicit mode
- property hints without registration in Explicit mode
- wrong property types for every supported hint family
- bitfields with more than 32 enum entries
- mutable signals
- `@Emit` on a non-signal value
- ignored RPC transfer channels
- unregistered signal connection targets
- unregistered callable targets
- RPC targets that are unregistered
- RPC targets without `@Rpc`
- RPC targets using `RpcMode.DISABLED`

## Separate Core-Type Copy Suite

Core-type copy mutation is not part of the 3x3 registration matrix. It is a
separate Kotlin-only inspection with its existing fixture:

- fixture:
  `../../../harness/intellij-check/src/main/kotlin/godot/inspection/CopyModificationCheckTestClass.kt`
- test:
  `KotlinInspectionTest.testCoreTypeCopyFixture`

Do not mix these cases into the nine registration tests. This inspection
checks mutation through copies returned by `@CoreTypeLocalCopy` getters and
has different semantics from annotation registration.

The expected fixture currently reports ten errors.

## How the Test Fixture Works

`CodeInsightFixtureTestBase.kt` extends IntelliJ's `BasePlatformTestCase`,
which provides `CodeInsightTestFixture`.

For every test it:

1. creates an in-memory `project.godot`, making the fixture a Godot project
2. registers the running JDK as the test module SDK
3. attaches Kotlin stdlib and the Godot annotation, common, core, API, and
   extension jars
4. copies a harness source file into the light test project
5. writes the selected `RegistrationMode` to `RegistrationSettings`
6. enables the requested inspection
7. runs `myFixture.doHighlighting()`
8. fails immediately if the fixture has compiler errors
9. keeps only highlights produced by the inspection under test
10. compares the exact severity, message, and occurrence count

This is deliberately an integration-style inspection test. It validates PSI
resolution, K2 analysis, Java/Scala light elements, inspection registration,
and emitted highlighting without launching an IDE sandbox manually.

### Test dependencies

`build.gradle.kts` supplies:

- IntelliJ Platform test framework
- IntelliJ Java plugin test framework
- bundled Kotlin plugin
- Scala plugin
- `godot-api-library`
- `godot-extension-library`
- JUnit 4

The Gradle test task passes the harness root through
`godot.intellij.fixture.root` and enables K2.

## Expected Result Conventions

Use `assertProblems` with:

- `error(message, count)`
- `weakWarning(message, count)`

Messages must come from `GodotPluginBundle`; do not repeat user-facing
strings in tests.

The assertion is intentionally order-independent, but it is strict about:

- inspection severity
- full rendered message
- number of occurrences
- unexpected extra problems
- missing expected problems

Do not weaken the assertion to make a failing inspection pass. First
determine whether the fixture expectation, registration policy, or analyzer
is wrong.

## Updating or Adding an Inspection Check

When changing a regular registration check:

1. add or update the source case in every language the check supports
2. update the Explicit, Inferred, and Automatic expectations for each
   affected language
3. keep unsupported language-specific checks out of the other fixtures
4. run the complete plugin test task
5. use the sandbox only for visual confirmation when necessary

Before accepting a mode result, compare it with the registration processor
under `kt/godot-registration/godot-class-graph-symbol-processor`. The IDE
policy must describe what the actual registration pipeline will select.

If the test reveals different behavior for equivalent Java, Kotlin, and
Scala declarations, investigate the PSI representation before adding a
language-specific exception. Scala properties may appear through generated
accessor methods; Kotlin declarations may resolve compiled annotations
through constructors or light elements.

## Commands

Run commands from the `kt` directory.

Complete plugin test suite:

```powershell
.\gradlew.bat :godot-intellij-plugin:test
```

One language:

```powershell
.\gradlew.bat :godot-intellij-plugin:test --tests "*KotlinInspectionTest"
.\gradlew.bat :godot-intellij-plugin:test --tests "*JavaInspectionTest"
.\gradlew.bat :godot-intellij-plugin:test --tests "*ScalaInspectionTest"
```

One mode:

```powershell
.\gradlew.bat :godot-intellij-plugin:test --tests "*testExplicitFixture"
.\gradlew.bat :godot-intellij-plugin:test --tests "*testInferredFixture"
.\gradlew.bat :godot-intellij-plugin:test --tests "*testAutomaticFixture"
```

Compile the plugin:

```powershell
.\gradlew.bat :godot-intellij-plugin:compileKotlin
```

Run the sandbox IDE:

```powershell
.\gradlew.bat :godot-intellij-plugin:runIde
```

## Sandbox Rule

When asked to open or launch the sandbox, reset its project/editor state
first unless the user explicitly asks for a non-clean launch. Automated
inspection tests do not require a sandbox reset.

## Design Rules

- Follow KISS and YAGNI.
- Keep the 3x3 matrix complete.
- Keep the core-type copy suite separate.
- Keep one source fixture per language and registration mode.
- Keep inspection entry points small.
- Put shared behavior in analyzers or `RegistrationPolicy`.
- Prefer a failing precise test over a permissive test.
- Do not use manual sandbox checking as a substitute for fixture tests.
