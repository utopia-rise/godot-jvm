# D.2: Languages and toolchains

One project compiles Kotlin, Java and Scala side by side, with compiler versions the user may raise above Godot-JVM's minimums.

A team picks its language per script, not per project, and often already has a preferred JDK, Kotlin or Scala version. The build therefore accepts any mix of the three languages and any toolchain at or above what Godot-JVM supports, while still working when the user chooses nothing. It is not a way to run Godot-JVM on toolchains older than its minimums (D.1).

## Capabilities
- **D.2.1**: Game developers write scripts in any mix of Kotlin, Java and Scala within one project.
- **D.2.2**: Game developers choose which languages a project compiles, so that unused compilers cost no build time and no runtime library.
- **D.2.3**: Game developers choose a newer JDK, Kotlin or Scala version than Godot-JVM's default, so that recent language features do not wait for a Godot-JVM release.

## Rules
- **D.2.R1**: A project that chooses no toolchain version gets Godot-JVM's defaults, and a version the project chooses at or above the minimum is used as it is.
- **D.2.R2**: The chosen JDK version applies to the compilation of every enabled language.
