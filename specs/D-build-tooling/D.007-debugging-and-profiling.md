# D.7: Debugging and profiling

A game running on a JVM can be debugged and profiled with the standard JVM tools, whether it runs from the editor, an IDE or a desktop export.

JVM languages come with mature debuggers and profilers, and users expect to use them on their game as on any JVM program. Some bugs also only appear in an exported game: on a tester's machine, after packaging, or in a release build. Godot-JVM's part is to let the game's JVM accept these tools: open a debug port, optionally wait for the debugger so startup code can be stepped through, and expose JMX and the JVM's own diagnostic options. They are runtime settings (E.4), switched on for one launch or one export preset. Debugging is a debug-build aid; monitoring stays available in release builds, where performance and memory problems matter most. Godot-JVM reuses standard tools instead of shipping its own.

## Capabilities
- **D.7.1**: Game developers attach a JVM debugger to a game run from the editor, an IDE or a debug export, and set breakpoints and inspect scripts, including code that only fails once exported.
- **D.7.2**: Game developers configure the game to wait for a debugger before running game code, so that startup and `_ready` code can be debugged.
- **D.7.3**: Game developers connect monitoring and profiling tools to a running game through JMX and the JVM's own diagnostic options, release exports included, so that they find what makes it slow or heavy where players run it.

## Rules
- **D.7.R1**: Debugging and monitoring are switched on by command-line or configuration settings, never by changing the game's code or build.
- **D.7.R2**: A release build never opens a debugger port, whatever its configuration says.
- **D.7.R3**: No debugging or monitoring port is opened unless the configuration enables it explicitly.

## Non-goals
- **D.7.N1**: Godot-JVM does not set up debugging or profiling for games running as a native image, on Android or on iOS.
  - Why: Godot-JVM's support is the desktop JVM's own debugger and JMX agents; native images and Android's runtime are left to their own platform tools, as §5 allows for debugging aids.
- **D.7.N2**: Godot-JVM ships no debugger or profiler of its own.
  - Why: Godot-JVM reuses the standard JVM tools and only lets the game's JVM accept them.
- **D.7.N3**: Godot's own debugger and profiler show no JVM frames or profiling data.
  - Why: JVM code is debugged and profiled with the JVM debugger and JVM tools (D.7.1, D.7.3), the equivalents §3 intends.
