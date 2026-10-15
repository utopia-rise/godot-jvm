# A.4: Coroutines

Kotlin scripts write asynchronous game logic with coroutines: waiting for signals, frames and background work without blocking the game, the way GDScript uses `await`.

Gameplay is full of sequences that span frames: play an animation, wait for it to finish, then spawn the next wave. GDScript expresses them with `await`; Kotlin's coroutines are the natural equivalent and bring structured cancellation on top, so that a sequence owned by a node stops when the node leaves the scene. Coroutines are a Kotlin language feature, so this capability is Kotlin-only, as §4 allows; Java and Scala express the same logic with signal connections. Support is opt-in, so projects that do not use it carry no coroutine dependency.

Connecting to signals without suspending is B.6, using Godot from threads in general is B.7, and the thread safety of the Godot API is B.1.

## Capabilities
- **A.4.1**: Game code suspends until a signal is emitted and receives its arguments, or consumes its emissions as a stream, and so writes event sequences like GDScript's `await`.
- **A.4.2**: Game code suspends until the next frame or physics frame, of the whole tree or of a given node, so that work is spread over frames.
- **A.4.3**: Coroutines started from a node are cancelled when it leaves the scene tree, so that a removed node never keeps running game logic.
- **A.4.4**: Game code moves heavy work, such as computations or resource loading, to Godot's worker threads and resumes on the main thread with its result, so that it does not stall a frame.
- **A.4.5**: A single build setting enables coroutine support, so that projects that do not use it stay lean.

## Rules
- **A.4.R1**: Coroutines start and resume on Godot's main thread unless the code explicitly asks for another dispatcher.
- **A.4.R2**: Cancelling a coroutine that waits on a signal or a frame releases that wait.

## Non-goals
- **A.4.N1**: Java and Scala scripts have no `await` equivalent.
  - Why: Suspending a function is a Kotlin language feature, so this falls under §4's Except; Java and Scala express the same sequences with signal connections (B.6).
  - Reopen if: Java virtual threads or Scala continuations can suspend game code and resume it on Godot's main thread.
