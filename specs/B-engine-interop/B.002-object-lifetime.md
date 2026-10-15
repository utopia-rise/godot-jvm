# B.2: Object lifetime

Godot objects used from JVM code live and die as they would in GDScript, without manual memory management.

Godot frees plain objects explicitly and reference-counts the others, while the JVM relies on a garbage collector. A user must not have to know how the two are reconciled: keeping a reference keeps an object alive, dropping it lets the object go, and freeing works as Godot documents it.

A Godot object reached from the JVM has a JVM wrapper, plus a script instance when a JVM script is attached. Both must follow the native object through its whole life, including scripts being attached, swapped or removed while it lives, and the end of the game, when JVM code may still hold objects that Godot is shutting down.

Checking whether a kept reference is still valid is one of Godot's global functions (B.1), reacting to an object's destruction from its script is a script member (A.2), and what the lifetime bookkeeping costs is F.3.

## Capabilities
- **B.2.1**: A Godot object that game code references stays alive while it is used and is released once nothing uses it, so game code never manages memory beyond what Godot itself asks.
- **B.2.2**: Game code frees objects that are not reference-counted exactly as GDScript does, so object lifetime follows Godot's documentation.
- **B.2.3**: Game code's references to an object keep working when a script is attached to it, replaced or removed.
- **B.2.4**: Game code keeps Godot objects for the whole game session and runs code when the game closes, so global state is cleaned up at shutdown.

## Rules
- **B.2.R1**: Neither side frees an object the other side still uses, and an object that neither side uses is eventually released.
  - Except: the diagnostic setting that disables memory management for investigations and benchmarks.
- **B.2.R2**: While a Godot object is alive, every time it reaches the JVM it is the same JVM object.
- **B.2.R3**: Dropping every JVM reference to an object that is not reference-counted never frees it.
