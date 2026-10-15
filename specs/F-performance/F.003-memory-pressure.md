# F.3: Memory pressure and smooth frames

The binding adds as little garbage and as little per-frame bookkeeping as possible, so that a Godot-JVM game keeps a steady frame rate.

A game is judged by its worst frames as much as by its average one. On the JVM, two things can spoil them: garbage collections triggered by allocations the user never wrote, and the work of keeping Godot's and the JVM's views of every object in step. Both are the binding's doing, so both are the binding's job to keep small and spread out.

How object lifetime behaves is B.2; this spec is about what that behavior costs. Allocations made by the game's own code and the choice of garbage collector are ordinary JVM concerns, and passing JVM options is E.4.

## Capabilities
- **F.3.1**: Calls between Godot and scripts allocate as little as possible on the JVM heap, so that garbage collections stay rare and short.
- **F.3.2**: Objects that Godot and game code keep using every frame carry no per-frame lifetime cost, so that a busy scene does not pay for bookkeeping that changes nothing.
- **F.3.3**: Game code drops large numbers of objects at once, such as when clearing a level or a wave of enemies, without a frame stalling.
- **F.3.4**: Game code creates, reuses and drops Godot collections, names and node paths often without a heavy cost, as freely as in GDScript.
- **F.3.5**: A player runs the game without stutters caused by the JVM or the binding, as smoothly as any other Godot game.

## Rules
- **F.3.R1**: Releasing what the JVM has dropped is spread over several frames, so that no single frame pays for a whole burst.
- **F.3.R2**: The binding's lifetime bookkeeping is carried out once per frame on the main thread, never on every call.
