# F.4: Tuning and runtime choice

A game developer can trade speed, memory and warm-up through a few runtime settings and the choice of runtime, without touching the native side.

The defaults suit a typical game, but games differ: one passes long strings to the engine every frame, another nests deep engine calls, another needs a small memory footprint or full speed from the first frame. The binding exposes the few sizes that matter as runtime settings and lets desktop games run as a native image instead of on a JVM (E.3).

A JVM reaches full speed only once its JIT compiler has compiled the hot paths; a native image is compiled ahead of time and trades peak throughput and reloading for no warm-up and a smaller footprint.

Where the settings live, how exports pack them and how standard JVM options are passed is E.4; this spec is about what they let a user trade. Which runtime a mobile game uses is fixed by B.1.R3.

## Capabilities
- **F.4.1**: Game developers size what the binding reserves per thread, such as how long a string crosses inline or how deeply engine calls can nest, so that they trade memory against speed for what their game does.
- **F.4.2**: A desktop game shipped as a native image runs at full speed without JIT warm-up and with a smaller memory footprint, so that the runtime choice is a real performance option.

## Rules
- **F.4.R1**: Every tuning setting is optional, and its default suits a typical game.
- **F.4.R2**: A tuning setting changes only speed and memory use; a value too small for what the game does is reported as an error, never silently corrupts data.
