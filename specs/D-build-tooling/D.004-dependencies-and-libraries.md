# D.4: Dependencies and libraries

A project uses JVM libraries as ordinary Gradle dependencies, and library authors publish reusable Godot scripts that consuming projects attach like their own.

The JVM ecosystem is a main reason to pick a JVM language, so adding a library must work as in any other Gradle project. Godot-JVM adds two things on top: a choice of how a dependency is packaged, because reloading and some libraries (signed JARs, libraries that load user classes) need it, and libraries that carry Godot scripts of their own. Such scripts are registered by the project that uses them, so a library stays an ordinary JVM artifact. Since their source is not in the project, the build gives each one a small registration file that is attached in the editor like a source file.

Giving distinct Godot names to same-named classes from different libraries is A.1.

## Capabilities
- **D.4.1**: Game developers add any JVM library to their project as an ordinary Gradle dependency.
- **D.4.2**: Game developers choose whether a dependency reloads with their code or stays an intact JAR, so that libraries that load game classes or must not be repackaged keep working.
- **D.4.3**: Library authors publish a library of Godot scripts with ordinary Maven publishing, and game developers add it like any other dependency.
- **D.4.4**: The scripts of a library dependency appear as files that game developers attach to nodes like their own, kept in sync with the library by the build.
- **D.4.5**: Library authors publish a library without Godot scripts without applying the Godot-JVM plugin.

## Rules
- **D.4.R1**: A library's scripts are registered by the project that consumes it, never by the library's own build.
- **D.4.R2**: The build creates, updates and removes the registration files of dependency scripts, and leaves an existing file where the user moved it.
- **D.4.R3**: A registration file only points to a compiled class and never changes its code.
- **D.4.R4**: Every dependency, whatever its packaging, is available to compilation and tests.

## Non-goals
- **D.4.N1**: Godot-JVM does not adapt a library to the restrictions of Android's ART or of native images.
  - Why: Compatibility with a platform's runtime is the library's concern, as §6 allows; the build only generates the native-image configuration Godot-JVM itself needs (D.3.R6).
