# A.2: Script members

A script exposes functions, properties and signals to Godot, overrides the engine's callbacks, handles notifications and declares remote procedure calls, under the names a Godot user expects.

What Godot, the editor and other languages see of a script is its members. A JVM script must offer the same kinds of members a GDScript does, written in its own language's idioms (camelCase methods, fields, getters and setters) and translated to Godot's conventions on the way. Members that only JVM code uses stay invisible to Godot.

How the Inspector shows properties is A.3, connecting to signals and passing callables is B.6, and calling members of objects scripted in other languages is B.3.

## Capabilities
- **A.2.1**: Scripts expose functions that the engine, the editor and scripts in other languages can call.
- **A.2.2**: Scripts expose properties, declared as fields or through accessors, that Godot and other scripts can read and write.
- **A.2.3**: Scripts declare signals with typed arguments and emit them, and Godot, the editor and scripts in any language can connect to them.
- **A.2.4**: Scripts override Godot callbacks such as `_ready` or `_process` like any inherited method, and so follow the node lifecycle as a GDScript does.
- **A.2.5**: Scripts handle Godot notifications, the destruction of the object included, and so react to every engine event a GDScript can.
- **A.2.6**: Scripts declare functions as remote procedure calls with their multiplayer settings, so that game developers can write networked games.
- **A.2.7**: Exposed members take and return Godot values, objects, enums and typed containers, not only primitive types.
- **A.2.8**: Scripts expose their constants and enums to Godot, and other scripts and the editor use them as they use a GDScript's.
- **A.2.9**: Scripts expose static functions that Godot calls without an instance, as in GDScript.
- **A.2.10**: Exposed functions declare default argument values that Godot callers may omit, as with a GDScript function.

## Rules
- **A.2.R1**: Exposed member names follow Godot's `snake_case` convention, whatever the source language's convention.
- **A.2.R2**: A member whose type Godot cannot represent fails the build when it is selected for registration.
- **A.2.R3**: A member that is not selected for registration stays usable from JVM code.
- **A.2.R4**: An override of an exposed member keeps its parent's registration unless the override declares its own.
