---
description: Why Godot-JVM swapped MpApt and KSP for a ClassGraph bytecode processor, what the registrar generator expects as input, and how to debug the pipeline.
---

# Registrar generation

## General

To make it more language agnostic, the registrar generator provides a set of model classes which represent the information about the source code that the registrar generator needs.
It expects this information to be gathered and assembled by the calling tool and provided as input to the registrar generator.

For Kotlin, Java and Scala, this tool is `godot-class-graph-symbol-processor`, which analyses the byte code and gathers the information needed by the registrar generator.
It then calls the registrar generator which in turn generates the needed registrar files.

## The godot-class-graph-symbol-processor

Previously, we implemented our own compiler plugin based on the [mpapt](https://github.com/Foso/MpApt) and [ksp](https://github.com/google/ksp) project.
Even though it worked very well, the code was far from easy to understand and as the compiler plugin API is not stable yet.
Furthermore, `MpApt` introduced a lot of maintenance work to keep it up to date with the ever evolving Kotlin compiler and `Ksp` wasn't able to process Scala files.

To mitigate that problem we switched to [ClassGraph](https://github.com/classgraph/classgraph), a classpath scanner which reads compiled bytecode.
It is not a compiler plugin at all: it runs after compilation and lets you inspect the resulting class files through an abstracted and simplified API.
This means for us that we can work against a more stable API and the work of keeping it up to date with the Kotlin language is removed.

We use ClassGraph to gather all needed information for the registrar generator and convert it into the format it understands.
With this it should be far easier to implement additional JVM languages as ClassGraph is language agnostic and only minor tweak are necessary to support additional static languages.

## Debugging

There is no compiler plugin and no Kotlin compiler daemon involved anymore.
Both `godot-class-graph-symbol-processor` and the registrar generator are called directly from the task action of the `registrarGenerationGenerateFiles` Gradle task, so they run inside the Gradle build JVM and are debugged like any other Gradle task.

To debug a project, open a terminal, change to the project's root directory and type the following command:

```bash
./gradlew registrarGenerationGenerateFiles --rerun-tasks --no-build-cache -Dorg.gradle.debug=true
```

This will halt the build until you attach a remote debugger from IntelliJ IDEA to `localhost:5005`.

`registrarGenerationGenerateFiles` is a cacheable task with declared inputs and outputs.
Without `--rerun-tasks --no-build-cache`, an unchanged project resolves the task as up-to-date or from the build cache, the task action never executes, and no breakpoint is ever reached.

!!! note
    Running the build with a debugger attached will be way slower, especially for the initial build. So, please, be patient. It takes some time until it hits your breakpoints.
