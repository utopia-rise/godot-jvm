# Godot-JVM IntelliJ Plugin

[![Version](https://img.shields.io/jetbrains/plugin/v/com.utopia-rise.godotjvmideaplugin.svg)](https://plugins.jetbrains.com/plugin/com.utopia-rise.godotjvmideaplugin)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.utopia-rise.godotjvmideaplugin.svg)](https://plugins.jetbrains.com/plugin/com.utopia-rise.godotjvmideaplugin)

This module contains the IntelliJ IDEA plugin for Godot-JVM.

It is intentionally small and Kotlin-first:

- K2-only
- focused on editor checks, quick fixes, and the project wizard
- structured so new checks are easy to add without touching unrelated code

Java and Scala support are welcome when they naturally fit the same JVM-facing implementation, but Kotlin remains the main target.

## Scope

[comment]: <> (To keep everything working, do not remove `<!-- ... -->` sections. These are added to the plugin description through gradle during build)
<!-- Plugin description -->
Godot-JVM support for IntelliJ IDEA: write Godot scripts in Kotlin, Java, or Scala with registration-aware code insight.

Requires the K2 Kotlin mode.

Features:

- creates Godot-JVM projects and modules, with optional Android and iOS/GraalVM build setup
- creates Godot script classes from the project view: pick the language, the Godot base class, and the lifecycle functions to override
- runs the Godot editor or game from a `Godot` run configuration, with a JDK picked from the ones the IDE knows or detects
- validates `@Script`, `@Visible`, `@Register`, `@Emit`, `@Export`, and `@Rpc` usage
- follows the registration mode selected for the project: Explicit, Inferred, or Automatic
- highlights script declarations as ineligible, registration candidates, or registered
- reports duplicate registered class names on both declarations
- validates callable references used in Godot signal, `call`, and `rpc` patterns
- detects nested mutation of `@CoreTypeLocalCopy` getter results
- offers quick fixes for common registration and mutability mistakes

Checks only run inside Godot projects, so the rest of your code is left untouched.

<!-- Plugin description end -->

## Internal Structure

The code is split into a few small layers:

- root package:
    - plugin wiring
    - startup activity
    - project-level indexing and registered-name caches
- `project/`:
    - shared PSI helpers
    - Godot root detection
    - project-scope service
- `inspection/`:
    - editor-facing inspections
    - language entry points:
        - `JavaInspection`
        - `KotlinInspection`
        - `ScalaInspection`
        - `CoreTypeCopyModificationInspection`
- `analysis/`:
    - small rule objects that return problems
    - keeps rule logic out of inspection UI glue
- `quickfix/`:
    - source edits for common fixes
- `wizard/`:
    - project/module creation flow
- `run/`:
    - Godot run configuration
- `action/`:
    - project view actions
    - new Godot script creation

That split is meant to keep each file easy to scan:

- inspections decide when to run
- analyzers decide what is wrong
- quick fixes decide how to repair it

## Current Feature Areas

### Class registration

Checks around `@Script`, including:

- invalid Godot inheritance
- generic classes
- missing registration on classes that use registered members
- duplicate registered names

Relevant files:

- [JavaInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/JavaInspection.kt)
- [ScalaInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/ScalaInspection.kt)
- [GodotScriptAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/jvm/GodotScriptAnalyzer.kt)

### Property and export checks

Checks around `@Visible` and `@Export`, including:

- mutability
- missing property registration
- unsupported exported types
- nullability and `lateinit` restrictions
- property hint annotation validation

Relevant files:

- [KotlinInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/KotlinInspection.kt)
- [VisibleAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/VisibleAnalyzer.kt)
- [PropertyHintAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/PropertyHintAnalyzer.kt)

### Function and RPC checks

Checks around `@Register` and `@Rpc`, including:

- generic registered functions
- argument-count limits
- notification-function registration
- overriding rules
- invalid `transferChannel` usage for RPC

Relevant files:

- [JavaInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/JavaInspection.kt)
- [ScalaInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/ScalaInspection.kt)
- [KotlinInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/KotlinInspection.kt)
- [RegisterMethodAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/jvm/RegisterMethodAnalyzer.kt)
- [RegisterAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/RegisterAnalyzer.kt)
- [RpcAnnotationAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/RpcAnnotationAnalyzer.kt)

### Signal and callable-reference checks

Checks around `@Emit` and callable references used in Godot patterns such as signal connect, `call`, and `rpc`.

Relevant files:

- [KotlinInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/KotlinInspection.kt)
- [EmitAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/EmitAnalyzer.kt)
- [CallFunctionReferenceAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/reference/CallFunctionReferenceAnalyzer.kt)
- [RpcFunctionReferenceAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/reference/RpcFunctionReferenceAnalyzer.kt)
- [SignalFunctionReferenceAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/reference/SignalFunctionReferenceAnalyzer.kt)

### Core-type copy mutation check

Dedicated inspection for the common Godot core-type pitfall where a getter returns a copy and code tries to mutate a nested member of that copy through either
an assignment chain or a core-type helper call.

Example:

- `transform.basis.x.x = 1.0`
- `transform.basis.x { y = 1.0 }`

Current scope:

- intentionally conservative
- checks ordinary dot-qualified assignment left-hand sides
- checks ordinary dot-qualified helper-call chains whose final call resolves to `@CoreTypeHelper`
- prefers false negatives over false positives

Relevant files:

- [CoreTypeCopyModificationInspection.kt](src/main/kotlin/godot/intellij/plugin/inspection/CoreTypeCopyModificationInspection.kt)
- [CoreTypeCopyModificationAnalyzer.kt](src/main/kotlin/godot/intellij/plugin/analysis/kotlin/CoreTypeCopyModificationAnalyzer.kt)

### Quick fixes

Common fix classes live under:

- [quickfix/](src/main/kotlin/godot/intellij/plugin/quickfix)

Examples:

- add missing registration annotations
- fix mutability mistakes
- remove invalid RPC channel arguments
- navigate to already-registered classes

### Godot script action

`New | Godot Script` in the project view creates a Godot script class, comparable to attaching a script from the Godot editor.

Current behavior:

- only visible for directories inside a Godot project
- asks for the class name, language, and Godot base class
- the base class chooser is limited to Godot types
- offers only the lifecycle functions the chosen base class actually declares, with `_ready` preselected
- emits `@Script` and `@Register` only where the project's registration mode requires them

Relevant files:

- [NewGodotScriptAction.kt](src/main/kotlin/godot/intellij/plugin/action/NewGodotScriptAction.kt)
- [NewGodotScriptDialog.kt](src/main/kotlin/godot/intellij/plugin/action/NewGodotScriptDialog.kt)
- [GodotScriptGenerator.kt](src/main/kotlin/godot/intellij/plugin/action/GodotScriptGenerator.kt)

### Run configuration

A `Godot` run configuration type runs the current Godot project. It exists so the JVM Godot uses is chosen per project instead of through machine wide
settings.

Current behavior:

- offered only for projects that contain a `project.godot`
- asks for the Godot executable and a JDK, and whether to launch the editor
- the JDK list contains the project SDK, the JDKs the IDE knows, and the JDKs detected on the machine
- runs the executable with `--path <godot project>`, plus `--editor` when the editor is requested
- passes the selected JDK with `--jvm-path`, which Godot-JVM resolves before the embedded JRE and the environment, so it needs a Godot-JVM build that
  supports that argument
- exports the same JDK as `JAVA_HOME`, for the tools Godot starts itself such as Gradle. `PATH` is left untouched

Relevant files:

- [GodotRunConfigurationType.kt](src/main/kotlin/godot/intellij/plugin/run/GodotRunConfigurationType.kt)
- [GodotRunConfiguration.kt](src/main/kotlin/godot/intellij/plugin/run/GodotRunConfiguration.kt)
- [GodotRunConfigurationEditor.kt](src/main/kotlin/godot/intellij/plugin/run/GodotRunConfigurationEditor.kt)

### Wizard

The wizard uses IntelliJ's current New Project Wizard API and writes minimal starter templates.

Current behavior:

- uses IntelliJ's built-in project name
- asks for default package and language
- supports Kotlin, Java, and Scala starter files
- writes `godot.languages` in the generated Gradle build so the initial compile pass matches the selected starter language
- offers top-level Android and iOS toggles
- unfolds Android and GraalVM details only when enabled
- automatically enables Graal native-image when iOS export is enabled
- writes Android, GraalVM, and iOS export-related Gradle values

Relevant files:

- [GodotNewProjectWizard.kt](src/main/kotlin/godot/intellij/plugin/wizard/GodotNewProjectWizard.kt)
- [GodotNewProjectWizardStep.kt](src/main/kotlin/godot/intellij/plugin/wizard/GodotNewProjectWizardStep.kt)
- [template/](src/main/resources/template)

## Project Detection

Most checks only run when a file belongs to a Godot project.

That logic is intentionally centralized now:

- [GodotProjectScopeService.kt](src/main/kotlin/godot/intellij/plugin/GodotProjectScopeService.kt)
- [godotRootExt.kt](src/main/kotlin/godot/intellij/plugin/project/godotRootExt.kt)

The file-level root lookup is cached on the `VirtualFile`, so inspections do not have to rediscover the Godot root for every PSI element.

## Running And Testing

Run commands from:

`kt/`

### Run a sandbox IDE

This is the normal development loop.

```powershell
.\gradlew.bat :godot-intellij-plugin:runIde
```

That task builds the latest plugin and opens a sandbox IntelliJ instance with the plugin already installed.

### Compile just this module

```powershell
.\gradlew.bat :godot-intellij-plugin:compileKotlin
```

### Build the plugin zip

```powershell
.\gradlew.bat :godot-intellij-plugin:buildPlugin
```

The zip is written to:

`kt/plugins/godot-intellij-plugin/build/distributions/`

## Manual Test Checklist

There are no substantial checked-in tests yet, so verification is mostly manual.

Recommended checks after `runIde`:

- `@Visible` on a `val`
- `@Export` without `@Visible`
- duplicate registered class names
- invalid `@Rpc` channel usage
- callable reference to a non-registered function
- nested copy mutation such as `position.x += 1` or `transform.basis.x.x = 1.0`
- helper-call copy mutation such as `transform.basis.x { y = 1.0 }`
- wizard generation for Kotlin, Java, and Scala
- `New | Godot Script` for Kotlin, Java, and Scala in each registration mode
- a `Godot` run configuration against a real Godot binary, with a JDK that differs from the system default

## Development Notes

If you are working on the codebase itself, also read:

- [CLAUDE.md](CLAUDE.md)

That file explains the internal mental model, startup flow, and the best files to read first.


