# Bunnymark benchmark/sample

Go in the bunnymark directory and run `gradlew build` to build this sample.  
Open the project in Godot and inspect the root node. 
You can choose between GDScript, Kotlin or C# (the C# variant needs the .NET build of the Godot editor), and the benchmark as well.  
You can also run the benchmarks from the commandline:  
Example: `godot --path . -- --bench=BunnymarkSceneTree --lang=kt`

![Godot Bunnymark](images/banner.png)

Renders an increasing number of bunny sprites until a stable 60fps is hit.  This is a decent test of real world usage as it combines Godot api usage with raw computation.

The GDScript and C# variants are line-for-line ports of the Kotlin sources: the same data holders, the same `RandomNumberGenerator` usage, the same call sequence. Nothing is tuned for one language.

## Benchmark Run - Godot-JVM 1.0.0-rc1, October 6th, 2026

All numbers are bunnies rendered at a stable 60 fps from a release export of this project. The Kotlin column is the mean of three runs made on October 6th, 2026; the GDScript and C# columns date from September 18th, 2026 and were not re-run. "Old module" is the last measurement of the engine-module version of Godot Kotlin/JVM (Alpha 0.7.2 on Godot 4.1.2, October 17th, 2023, editor run); it is kept for reference and was not re-run.

| Benchmark             | Old module (Alpha 0.7.2) | Typed GDScript | C#     | Kotlin (JVM) |
|-----------------------|--------------------------|----------------|--------|--------------|
| BunnymarkSceneTree    | 34300                    | 37600          | 48900  | 54744        |
| BunnymarkSprites      | 47400                    | 33100          | 67100  | 64230        |
| BunnymarkDrawTexture  | 82400                    | 50300          | 261489 | 230180       |
| BunnymarkScripts      | 20300                    | 34800          | 52300  | 42620        |
| BunnymarkComputation  | n/a                      | 25496          | n/a    | 138363       |

### BunnymarkScripts

Each bunny is its own node with a script updating its position.
This benchmark's goal is to measure the cost of calling many small scripts from Godot.

### BunnymarkSceneTree

Attempts to draw as many sprites as possible using Sprite nodes. It reaches them through the scene tree, calling GetChildren() to iterate the list and setting each position, and updates a Label's text once per frame. This test aims to be a better emulation of real world api usage than the ones that keep their own list.

### BunnymarkDrawTexture

Attempts to draw as many sprites to the screen as possible by drawing textures directly with the rendering server. There are no nodes at all. This test focuses on compute and render performance and avoids making godot api calls.

### BunnymarkSprites

Attempts to draw as many sprites to the screen as possible by adding Sprite nodes, kept in the benchmark's own list rather than read back from the scene tree. This test focuses on compute and render performance and avoids making godot api calls.

### BunnymarkComputation

The same shape as BunnymarkDrawTexture, drawing every bunny with `draw_texture` and using no nodes, but each bunny
orbits a random point of the screen instead of falling and bouncing. The position is rebuilt from scratch every frame: two waves
give an offset, the offset becomes a distance and an angle, a third wave perturbs the angle, and the result becomes a
position again. That is seven transcendental operations per bunny per frame, against none in the other benchmarks.

Nothing crosses the engine boundary inside the loop, so this one says little about the binding and a lot about the
language runtime's floating-point throughput. It was added after the rest of the table was first measured, which is why it
has no "Old module" or C# figure; its GDScript figure is the mean of three release runs.

### Hardware:

* CPU: 13th Gen Intel(R) Core(TM) i5-13600K 3.50 GHz
* GPU: Nvidia RTX 3070
* RAM: 32GB DDR5

### Build Info:
* OS: Windows 10
* Godot 4.7.2-stable, release export (`template_release`); the C# run uses the .NET build of the same version
* Kotlin 2.3.20, embedded JRE built with jlink from JDK 25.0.4.1 (Eclipse Temurin)
* C#: .NET SDK 8.0.425, `Godot.NET.Sdk/4.7.2`, `net8.0` target

## Benchmark Run - Apple M4 Pro, October 8th, 2026

A second machine, measured the same way, from a release export with an embedded JRE, with the C# column from an export made with the .NET build of the same Godot version. Every number is the median of its runs, three per pair and five where a run diverged by more than 10%.

| Benchmark             | Typed GDScript | C#     | Kotlin (JVM) |
|-----------------------|----------------|--------|--------------|
| BunnymarkSceneTree    | 48228          | 53326  | 55113        |
| BunnymarkSprites      | 45701          | 67823  | 66354        |
| BunnymarkDrawTexture  | 88632          | 446841 | 378301       |
| BunnymarkScripts      | 50297          | 51987  | 48874        |
| BunnymarkComputation  | 33276          | 203491 | 194794       |

### Hardware:

* CPU: Apple M4 Pro, 20 cores
* GPU: Apple M4 Pro, integrated
* RAM: 48GB

### Build Info:
* OS: macOS 26.6.2
* Godot 4.7.2-stable, release export (`template_release`, universal macOS export); the C# run uses the .NET build of the same version
* Kotlin 2.3.20, embedded JRE built with jlink from JDK 21.0.10 (Amazon Corretto)
* C#: .NET SDK 8.0.425, `Godot.NET.Sdk/4.7.2`, `net8.0` target
