# Bunnymark benchmark/sample

Go in the bunnymark directory and run `gradlew build` to build this sample.  
Open the project in Godot and inspect the root node. 
You can choose between GdScript or Kotlin (also C# if you built the engine with mono enabled), and the benchmark as well.  
You can also run the benchmarks from the commandline:  
Example: `../../../../bin/godot.x11.opt.tools.64.mono --bench=BunnymarkV2 --lang=kt`

![Godot Bunnymark](images/banner.png)

Renders an increasing number of bunny sprites until a stable 60fps is hit.  This is a decent test of real world usage as it combines Godot api usage with raw computation.

## Benchmark Run - Alpha 0.7.2, October 17th, 2023 

### BunnymarkV3

V3 is a test where each bunny is its own node with a script updating their positions.  
This benchmark's goal is to measure the cost of calling many small scripts from Godot.

| Language             | Bunnies Rendered |
|----------------------|------------------|
| Typed GDScript       | 22500            |
| Kotlin(JVM)          | 20300            |
| Kotlin(Native image) | 12600            |

### BunnymarkV2

Attempts to draw as many sprites as possible using Sprite nodes.  It calls GetChildren() to iterate over a list of Sprites and sets their positions.  It also updates a Label's text once per frame.  This test aims to be a better emulation of real world api usage than the V1 tests.

| Language             | Bunnies Rendered |
|----------------------|------------------|
| Typed GDScript       | 24700            |
| Kotlin(JVM)          | 34300            |
| Kotlin(Native image) | 17900            |

### BunnymarkV1 - DrawTexture

Attempts to draw as many sprites to the screen as possible by drawing textures directly with VisualServer.  This test focuses on compute / render performance and avoids making godot api calls.

| Language             | Bunnies Rendered |
|----------------------|------------------|
| Typed GDScript       | 35040            |
| Kotlin(JVM)          | 82400            |
| Kotlin(Native image) | 47100            |

### BunnymarkV1 - Sprites

Attempts to draw as many sprites to the screen as possible by adding Sprite nodes.  This test focuses on compute / render performance and avoids making godot api calls.

| Language             | Bunnies Rendered |
|----------------------|------------------|
| Typed GDScript       | 23500            |
| Kotlin(JVM)          | 47400            |
| Kotlin(Native image) | 22200            |


### Hardware:

* CPU: 13th Gen Intel(R) Core(TM) i5-13600K 3.50 GHz
* GPU: Nvidia RTX 3070
* RAM: 32GB DDR5 @ 5800 MT/s

### Build Info:
* OS: Windows 10
* Godot 4.1.2-stable, Target: editor 
* Kotlin 1.9.0
* JDK 17

