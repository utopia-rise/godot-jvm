# E.2: Debug and release exports

A game exports with debug, for testing, or for release, for players, and each export carries exactly the build of the game made for it.

Godot distinguishes an export with debug from a release export, and Godot-JVM follows that split. A debug export keeps the debug build of the JVM code with its checks, so a tester's game behaves like the one run from the editor. A release export carries a separate release build, merged into one piece and free of debug checks, because a player's game never reloads code. Both run the same game; only the debugging aids differ.

The export is also where mistakes surface: a build that was never run, or one for the wrong variant, must be reported while exporting rather than discovered by a player.

Producing the debug and release builds with Gradle is D.3.

## Capabilities
- **E.2.1**: An export with debug carries the debug build of the game's JVM code, so that testers run the game with the same checks and debugging aids as in the editor.
- **E.2.2**: A release export carries a release build of the game's JVM code without debug checks, so that players get the leanest and fastest version of the game.
- **E.2.3**: Exported games ship the JVM libraries they depend on, including those that must stay intact jars.
- **E.2.4**: The export dialog warns game developers about a missing build or runtime before they export, and the export reports every missing piece, naming what to build, then fails, so that no game ships that cannot start.
- **E.2.5**: Game developers ship their game without the source code of its scripts.

## Rules
- **E.2.R1**: An export packs the artifacts of its own variant only, never those of the other variant or of another platform.
- **E.2.R2**: A debug export template loads only the debug build and a release export template only the release build.
- **E.2.R3**: An exported game carries compiled code only; a script file is exported as a reference to its class.
- **E.2.R4**: An export needs only the build of its own variant: nothing it packs, the global class names of JVM scripts included, depends on a build of the other variant.

## Non-goals
- **E.2.N1**: Exported games do not reload their JVM code.
  - Why: Reloading is an editor aid, which §5 lets differ between the editor and exports: an exported game loads its code once at startup, and a release export merges it into one piece.
