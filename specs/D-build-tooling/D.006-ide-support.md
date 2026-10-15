# D.6: IDE support

An IntelliJ IDEA plugin creates Godot-JVM projects and scripts, checks registration as the code is typed, and launches Godot with the right JDK.

Godot's built-in script editor offers no code insight for JVM languages, so the IDE is where JVM scripts are written. The plugin brings Godot-JVM's knowledge into it: what a project and a script look like, which declarations Godot will see, and which mistakes the build would reject or silently ignore. It never replaces the build: any editor can edit the sources and run Gradle, and the build alone decides what is registered (D.3.R3).

## Capabilities
- **D.6.1**: Game developers create a new Godot-JVM project, or add a Godot-JVM module to an existing one, from IntelliJ IDEA with the languages and platform settings they choose, and start from a working layout.
- **D.6.2**: Game developers create a script by choosing its language, its Godot base class and the lifecycle functions to override, so that new scripts start correct.
- **D.6.3**: The IDE flags registration mistakes while typing, with quick fixes, in Kotlin, Java and Scala, so that they are caught before a build.
- **D.6.4**: The IDE shows at a glance which classes and members Godot will see, so that registration never surprises game developers.
- **D.6.5**: Game developers launch the Godot editor or their game from the IDE with a JDK they choose, so that the JVM Godot uses does not depend on machine-wide settings.
- **D.6.6**: The IDE's checks follow the registration mode the build uses, so that the IDE and the build agree.

## Rules
- **D.6.R1**: Nothing in the build or the runtime requires IntelliJ IDEA; every IDE feature is a convenience over the Gradle build.
- **D.6.R2**: IDE checks only report; they never change what the build registers.

## Non-goals
- **D.6.N1**: Godot's built-in script editor offers no code completion, navigation or error checking for JVM languages.
  - Why: JVM scripts are written in a JVM IDE with Godot-JVM's IDE support, the equivalent §3 intends; Godot's script editor is kept for reading and quick edits (C.1.4).
- **D.6.N2**: Godot-JVM provides no plugin for IDEs other than IntelliJ IDEA.
  - Why: Godot-JVM maintains a single IDE plugin; any other editor still edits the sources and runs the Gradle build (D.6.R1).
  - Reopen if: someone commits to maintaining a plugin for another IDE.
