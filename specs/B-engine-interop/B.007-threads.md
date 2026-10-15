# B.7: Threads

JVM code uses Godot from any thread, and Godot's threads call into JVM scripts, under Godot's own threading rules.

Games move work off the main thread: loading, path finding, procedural generation. Threads come from both sides: Godot's `Thread` and `WorkerThreadPool`, and the JVM's own threads and executors. Every one of them must be able to cross the boundary without any setup, with what Godot promises about thread safety (B.1.R2) as the only limit.

Coroutine dispatchers that switch between Godot's threads are A.4, and threads calling the engine without waiting for each other is a speed concern of F.2.

## Capabilities
- **B.7.1**: Game code calls the Godot API from threads it creates on the JVM, so that the JVM's concurrency tools serve game work.
- **B.7.2**: Godot's threads and worker pool call into JVM scripts, so that threaded code written against Godot's API works with them.

## Rules
- **B.7.R1**: No thread has to be registered, attached or prepared by the user before it calls Godot or is called by Godot.
- **B.7.R2**: Work on one thread never corrupts the exchanges of another thread with Godot.
- **B.7.R3**: A thread that ends gives back what the binding allocated for it, so that many short-lived threads never leak.

## Non-goals
- **B.7.N1**: Godot-JVM does not make thread-unsafe Godot APIs safe to call from several threads.
  - Why: Thread safety stays Godot's contract (B.1.R2); Godot-JVM adds no locking around engine calls, which would slow every call and make JVM code behave differently from GDScript.
