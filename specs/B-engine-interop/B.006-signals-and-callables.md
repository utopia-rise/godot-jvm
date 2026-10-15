# B.6: Signals and callables

JVM code connects to any object's signals and exchanges callables with Godot, with typed signatures checked by the JVM compiler and Godot's own semantics underneath.

Signals and callables are how Godot wires a game together: a timer's `timeout`, a button's `pressed`, a tween callback, a deferred call, a custom sort. They are dynamic in Godot, so the JVM adds typed handles on top that let the compiler check argument counts and types, while staying ordinary `Signal` and `Callable` values for the engine and for other languages.

A JVM lambda or method reference can be handed to any Godot API that takes a callable without being registered first, and a callable coming from Godot, whatever language created it, can be called from the JVM.

Declaring and emitting signals on a script class and configuring remote calls is A.2, and awaiting signals in coroutines is A.4.

## Capabilities
- **B.6.1**: Game code connects a JVM lambda or method to the signals of engine objects and of any script through typed handles, with Godot's connection flags such as deferred and one-shot, so that the compiler checks the handler and a quick reaction stays a one-liner.
- **B.6.2**: Game code passes JVM lambdas and methods, with bound arguments when needed, to any Godot API that takes a callable, and calls or defers callables received from Godot, so that tweens, deferred calls and engine callbacks work as in GDScript.
- **B.6.3**: Game code keeps a handle on a connection to check or end it later.
- **B.6.4**: Game code uses signals and callables by name without static types, so that it reaches signals and methods only known at runtime.

## Rules
- **B.6.R1**: A JVM lambda handed to Godot stays alive while Godot holds the callable and is released once Godot drops it.
- **B.6.R2**: Typed signal and callable handles exist only on the JVM; Godot and other languages see ordinary `Signal` and `Callable` values.
- **B.6.R3**: A typed signal or callable rejects a wrong argument count or argument type at compile time.
