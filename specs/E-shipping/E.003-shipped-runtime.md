# E.3: Shipped runtime

Every exported game carries, or relies on, the runtime that executes its JVM code, so that it starts on the player's machine with nothing else installed.

JVM code needs a runtime, and players cannot be asked to install one. Which runtime each platform uses is B.1.R3: Android games rely on the device's ART and iOS games link a native image into the app, so the only choice left to the developer is on desktop, between a Java runtime trimmed to what the game uses and a GraalVM native image of its code. This spec covers what the game ships and how it finds its runtime at startup.

The runtime is also most of the size Godot-JVM adds to a game. The embedded Java runtime holds only the JDK modules the game declares, and a native image holds only the code the game reaches.

Generating the embedded runtime and compiling the native image with Gradle is D.3, finding a JDK for the editor is C.4, and what the choice of runtime means for speed and footprint is F.4.

## Capabilities
- **E.3.1**: Desktop exports bundle a Java runtime that contains only the JDK modules the game and its libraries need, so that players install nothing and the game stays small.
- **E.3.2**: Game developers choose in each desktop export preset to ship the game as a GraalVM native image instead of a Java runtime, so that it starts faster and carries no Java runtime at all.
- **E.3.3**: Game developers start an exported desktop game on another Java runtime of their choice for one run, without exporting again.

## Rules
- **E.3.R1**: An exported game never runs on a Java installation found on the player's machine; it uses the runtime it ships, or one named explicitly at launch.
- **E.3.R2**: A runtime file an exported game extracts to run is replaced when the game is updated, and a file the current version no longer ships is never loaded.
- **E.3.R3**: When the runtime of an exported game cannot be found or started, the game reports why instead of failing silently.
