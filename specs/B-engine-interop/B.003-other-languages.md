# B.3: Working with other languages

JVM scripts and scripts written in GDScript, C# or another GDExtension language use each other freely within one project.

Projects mix languages: an existing GDScript codebase, an addon written in C#, a GDExtension from the asset library. A JVM script must be one more participant in that mix, not an island.

Members of other scripts are reached dynamically, by their Godot name, since their types are not known to the JVM compiler. Classes added by a GDExtension or by a custom engine build are different: Godot describes them like engine classes, so the build can generate typed bindings for them from the engine's own API description.

## Capabilities
- **B.3.1**: JVM scripts call methods, read properties and connect to signals of objects scripted in other languages, so that existing code and addons are reused.
- **B.3.2**: Scripts in other languages call the members JVM scripts expose, so that a mixed-language project works in both directions.
- **B.3.3**: Game developers have the build generate typed bindings from an API description they dump from the engine the game runs on, so that classes added by GDExtensions, custom modules or a newer engine are used from JVM code like engine classes.

## Rules
- **B.3.R1**: Languages interoperate only through Godot's own mechanisms (calls, properties, signals); no language needs a dedicated bridge to reach JVM scripts.
- **B.3.R2**: An object whose class has no JVM binding is seen as its nearest ancestor class that has one, and stays fully usable through dynamic calls.
- **B.3.R3**: Custom bindings replace only the generated Godot API; Godot-JVM's own core types and helpers stay the published ones.

## Non-goals
- **B.3.N1**: JVM scripts do not inherit from GDScript or C# scripts, and scripts in those languages do not inherit from JVM scripts.
  - Why: Godot itself does not allow script inheritance across languages.
