# Bunnymark benchmark/sample

Go in the bunnymark directory and run `gradlew build` to build this sample.  
Open the project in Godot and inspect the root node. 
You can choose between GDScript, Kotlin or C# (the C# variant needs the .NET build of the Godot editor), and the benchmark as well.  
You can also run the benchmarks from the commandline:  
Example: `godot --path . -- --bench=BunnymarkV2 --lang=kt`

![Godot Bunnymark](images/banner.png)

Renders an increasing number of bunny sprites until a stable 60fps is hit.  This is a decent test of real world usage as it combines Godot api usage with raw computation.

The GDScript and C# variants are line-for-line ports of the Kotlin sources: the same data holders, the same `RandomNumberGenerator` usage, the same call sequence. Nothing is tuned for one language.

## Benchmark Run - Godot-JVM 1.0.0-rc1, September 18th, 2026

All numbers are bunnies rendered at a stable 60 fps from a release export of this project. "Old module" is the last measurement of the engine-module version of Godot Kotlin/JVM (Alpha 0.7.2 on Godot 4.1.2, October 17th, 2023, editor run); it is kept for reference and was not re-run.

| Benchmark               | Old module (Alpha 0.7.2) | Typed GDScript | C#      | Kotlin (JVM) |
|-------------------------|--------------------------|----------------|---------|--------------|
| BunnymarkV2             | 34300                    | 37600          | 48900   | 35800        |
| BunnymarkV1 Sprites     | 47400                    | 33100          | 67100   | 54800        |
| BunnymarkV1 DrawTexture | 82400                    | 50300          | 261489  | 198040       |
| BunnymarkV3             | 20300                    | 34800          | 52300   | 36600        |

### BunnymarkV3

V3 is a test where each bunny is its own node with a script updating their positions.  
This benchmark's goal is to measure the cost of calling many small scripts from Godot.

### BunnymarkV2

Attempts to draw as many sprites as possible using Sprite nodes.  It calls GetChildren() to iterate over a list of Sprites and sets their positions.  It also updates a Label's text once per frame.  This test aims to be a better emulation of real world api usage than the V1 tests.

### BunnymarkV1 - DrawTexture

Attempts to draw as many sprites to the screen as possible by drawing textures directly with the rendering server.  This test focuses on compute / render performance and avoids making godot api calls.

### BunnymarkV1 - Sprites

Attempts to draw as many sprites to the screen as possible by adding Sprite nodes.  This test focuses on compute / render performance and avoids making godot api calls.

### Hardware:

* CPU: 13th Gen Intel(R) Core(TM) i5-13600K 3.50 GHz
* GPU: Nvidia RTX 3070
* RAM: 32GB DDR5

### Build Info:
* OS: Windows 10
* Godot 4.7.2-stable, release export (`template_release`); the C# run uses the .NET build of the same version
* Kotlin 2.3.20, embedded JRE built with jlink from JDK 17 (Azul Zulu 17.28)
* C#: .NET SDK 8.0.425, `Godot.NET.Sdk/4.7.2`, `net8.0` target
