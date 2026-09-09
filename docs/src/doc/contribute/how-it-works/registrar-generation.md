---
description: Why Godot-JVM swapped MpApt and KSP for a ClassGraph bytecode processor, what the registrar generator expects as input, and how to debug the pipeline.
---

# Registrar generation

## General

The registrar generator consumes a language-neutral model of the classes and members to expose. It generates registration code from that validated model without interpreting source-language details.

`godot-class-graph-symbol-processor` supplies the model for Kotlin, Java, and Scala. It scans compiled bytecode, reconstructs declarations, and passes the resulting model to the generator.

## The godot-class-graph-symbol-processor

Earlier implementations used MpApt and KSP. Maintaining compiler integration required frequent Kotlin updates, and KSP did not cover Scala.

The current processor uses [ClassGraph](https://github.com/classgraph/classgraph) to inspect compiled class files after compilation. This separates registration from compiler-plugin APIs and lets all three languages share the scan and generation pipeline. Language adapters handle differences in how their compilers represent declarations.

## Debugging

Both the processor and generator run inside the Gradle JVM, in the `registrarGenerationGenerateFiles` task action. Attach the debugger to Gradle to inspect either component.

From the project root, run:

```bash
./gradlew registrarGenerationGenerateFiles --rerun-tasks --no-build-cache -Dorg.gradle.debug=true
```

This will halt the build until you attach a remote debugger from IntelliJ IDEA to `localhost:5005`.

`registrarGenerationGenerateFiles` is a cacheable task with declared inputs and outputs.
Without `--rerun-tasks --no-build-cache`, an unchanged project resolves the task as up-to-date or from the build cache, the task action never executes, and no breakpoint is ever reached.

!!! note
    Debugging can slow the build, especially the first run. Allow time for compilation before the registration breakpoints are reached.
