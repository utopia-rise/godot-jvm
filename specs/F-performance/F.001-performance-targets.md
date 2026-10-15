# F.1: Performance targets

JVM scripts aim to be at least as fast as GDScript and as fast as C#.

Performance is a reason to pick a compiled JVM language over GDScript, and C# is the natural comparison. Both targets are a best effort: calls between Godot and the JVM have a cost, and some conveniences are worth a little speed. A missed target is a known gap to work on, not an accepted state.

The targets are judged on the same game written in each language and run from release exports, so that the comparison covers both the language runtime and the binding around it (F.5).

## Capabilities
- **F.1.1**: JVM scripts run at least as fast as the equivalent GDScript.
- **F.1.2**: JVM scripts run as fast as the equivalent C#.
