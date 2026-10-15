# F.2: Calls across the boundary

Calls between Godot and JVM code cost as little as possible in both directions, so that scripts can talk to the engine as often as a game needs.

A game script spends its life calling the engine and being called by it: reading and writing node properties, running a callback on every node every frame, reacting to signals. If each of those calls carried a noticeable toll, users would have to batch, cache and avoid the API, which is the opposite of writing a Godot script.

The two directions are not equal. Calls from JVM code into the engine are measured to be close to free beyond the engine's own work. Calls from the engine into JVM code, which enter the JVM from native code, are the expensive direction, and the one where the binding's remaining cost lies. Per-frame callbacks matter most, since the engine makes them on every scripted node every frame.

Which engine calls are thread-safe follows Godot (B.1), and the correctness of threaded calls is B.7.

## Capabilities
- **F.2.1**: Calls from JVM code to the Godot API cost little more than the engine's own work, so that game code uses the API freely, even in hot loops.
- **F.2.2**: Godot calls the registered functions, properties, signal handlers and callables of scripts cheaply, so that wiring a game through signals and callbacks does not cost frame time.
- **F.2.3**: Per-frame callbacks such as `_process` and `_physics_process` stay cheap on thousands of nodes, so that giving each entity its own script scales.
- **F.2.4**: Godot collections, names and node paths pass to and from engine calls without their content being copied, so that a call's cost does not grow with the data it refers to.
- **F.2.5**: Several game threads call the engine at the same time without the binding serializing them, so that work spread across threads scales.

## Rules
- **F.2.R1**: Passing arguments and return values across the boundary never makes one thread wait for another.
- **F.2.R2**: Collections, names and node paths cross the boundary as references to the native instance, never by copying their elements.
- **F.2.R3**: Every value can cross the boundary whatever its size; size limits only choose between a faster and a slower path.
- **F.2.R4**: Checks that would run on every call, such as buffer capacity checks, exist only in debug builds.
