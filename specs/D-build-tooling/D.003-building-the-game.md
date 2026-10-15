# D.3: Building the game

One Gradle build turns the project's sources into everything the editor loads and every export ships, in a debug and a release variant.

Users write classes and annotations; the bridge to Godot (registration, packaging, platform formats) is the build's job. The same tasks work for every language and run from the Godot toolbar, an IDE or a terminal alike. The build produces artifacts; what an export packs and how the game then runs belongs to shipping (category E), and when the editor builds and reloads belongs to the editor (C.2).

The platforms these builds are made for are E.1.

## Capabilities
- **D.3.1**: One build command compiles the scripts and produces what the editor loads.
- **D.3.2**: The build registers scripts from compiled code, whatever their language, so that game developers never set up or run an annotation processor.
- **D.3.3**: Release builds compile against the release runtime and leave out development-only code, so that shipped games carry no debug overhead.
- **D.3.4**: Debug and release builds live side by side, so that building one never breaks the other or the editor.
- **D.3.5**: Game developers build their game's code for Android, for a desktop native image and for iOS from the same project, so that each platform's export finds its artifacts ready.
- **D.3.6**: Game developers run a faster build when they only changed method bodies, so that small edits reach the editor quickly.
- **D.3.7**: Game developers lay out their Gradle build and source directories as they choose, inside the Godot project, in a subdirectory or as a module of a larger build, so that Godot-JVM fits their repository layout.

## Rules
- **D.3.R1**: Debug and release outputs go to separate directories and never overwrite each other.
- **D.3.R2**: A release build never reuses debug output, and a fast build never changes what is registered.
- **D.3.R3**: The build's registration result is authoritative: no IDE or editor setting changes what a build registers.
- **D.3.R4**: The build warns when Godot cannot see a script source root.
- **D.3.R5**: Build task names and outputs are the same for Kotlin, Java and Scala projects.
- **D.3.R6**: A native-image build generates every configuration Godot-JVM itself needs; a user only adds configuration for the reflection or resources of their own code and libraries.
