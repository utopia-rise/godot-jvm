# C.2: Building and reloading in the editor

The project's Gradle tasks run from the Godot editor, and after every successful build, wherever it was started, the editor takes the new code into account without being restarted.

A user arranging scenes in Godot should not have to switch to an IDE or a terminal just to pick up a code change, and compiled languages need a build before a change shows. The editor is a front end to the project's own Gradle build: it starts the tasks, shows their output and reports their result, but the build itself stays the one described by the project (D.3). Once a build succeeds, that build is the only step: the editor notices the new user code and updates scripts, the Inspector and the class lists in place, while keeping the work done in scenes. Reloading is a development aid of the editor; it does not exist in exported games.

What the Gradle tasks do and how the build is configured is category D, and taking an updated Godot-JVM runtime archive or addon needs an editor restart, which C.4 reports.

## Capabilities
- **C.2.1**: The editor toolbar runs the project's main Gradle tasks, from the ordinary build to release, mobile and native-image builds and the embedded runtime, and shows their output, so that building and preparing an export need no terminal.
- **C.2.2**: The editor builds before starting the game, always or only when a script changed since the last build, so that the game never runs stale code.
- **C.2.3**: The editor loads the new code after a successful build, whether it started from the editor, an IDE or a terminal, without being restarted.
- **C.2.4**: After a reload, the Inspector, the script members and the class lists reflect added, removed and changed members, base classes and scripts.
- **C.2.5**: Values set on nodes survive a reload, while values never touched follow the new defaults of their classes, so that rebuilding never undoes scene work.
- **C.2.6**: A failed build leaves the last working code loaded, so that a compile error never breaks the scenes being edited.

## Rules
- **C.2.R1**: The editor runs the project's own Gradle wrapper, so a build started from the editor is the same as one started from an IDE or a terminal.
- **C.2.R2**: Only one Gradle task started from the editor runs at a time.
- **C.2.R3**: A failed build started with the game keeps the game from starting and shows the Gradle output.
- **C.2.R4**: Reloading user code never requires restarting the editor.
  - Except: an editor running user code as a native image (C.2.N2), and a change to the runtime archive, such as an ordinary dependency, which C.4.3 reports.
- **C.2.R5**: A reload never changes a value the user set on a node.
- **C.2.R6**: The choice of building before the game starts is stored in the user's editor data, never in files shared with the project.

## Non-goals
- **C.2.N1**: A game that is already running does not reload new code; it is restarted to run a new build.
  - Why: Godot-JVM reloads user code only in the editor, where a reload keeps the scene data the user edits; carrying a running game's live state over to new code is not attempted, and restarting the game is the supported way to run a new build.
- **C.2.N2**: An editor running user code as a native image does not reload it.
  - Why: A native image is compiled ahead of time with the user code inside it and loads no new classes, so a new build needs a new image; reloading is a development aid that §5 lets differ between runtimes.
