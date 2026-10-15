# F.5: Benchmarks

Godot-JVM's performance is measured, not assumed: benchmarks compare it with GDScript and C# on identical games, and compare two builds of Godot-JVM with each other.

Performance claims are only worth what their measurement is worth. The targets of F.1 need a fair comparison with Godot's other languages, and every change to the binding needs a way to show whether it made things faster, slower or neither. Benchmarks are the project's tool for both, and they are also where a runtime's weaknesses become visible, which is their point.

## Capabilities
- **F.5.1**: Benchmarks play the same game in Kotlin, GDScript and C#, so that Godot-JVM is compared fairly with Godot's other languages.
- **F.5.2**: Benchmarks compare two builds of Godot-JVM on an identical, deterministic workload with a verdict that accounts for run-to-run noise, so that a change's effect is measured rather than guessed.
- **F.5.3**: Benchmarks measure the binding's own mechanisms (engine calls, object delivery, object creation, lifetime bookkeeping) in isolation, so that a regression can be traced to its cause.
- **F.5.4**: Benchmark reports include worst frames, stutters, allocation, garbage collection and JIT activity besides averages, so that smoothness and memory pressure are measured too.
- **F.5.5**: Game developers read published benchmark results comparing Godot-JVM with GDScript and C#, so that they judge what a JVM language costs or gains for their game.

## Rules
- **F.5.R1**: The language variants of a benchmark are line-for-line ports playing the same game, and none is tuned for one language.
- **F.5.R2**: A benchmark reports a runtime's weak results as they are; a workload is never reshaped to hide one.
- **F.5.R3**: A comparison between two runs is refused when they did not play the same workload with the same settings.
- **F.5.R4**: Published results state the machine, operating system, Godot version, runtime and export type they were measured with.
