# E.1: Platforms

A Godot-JVM game exports to the desktop and mobile platforms Godot supports, and players run it like any other game.

A game is made to be played where its players are. Each platform imposes its own way of running JVM code (B.1.R3), but none of it may show to the player. Exports use Godot's official export templates and Godot's own export dialog; Godot-JVM only adds what its runtime needs to the exported game.

## Capabilities
- **E.1.1**: Game developers export their game for Windows.
- **E.1.2**: Game developers export their game for Linux.
- **E.1.3**: Game developers export their game for macOS.
- **E.1.4**: Game developers export their game for Android.
- **E.1.5**: Game developers export their game for iOS.
- **E.1.6**: Game developers ship one signed macOS app that runs natively on both Apple Silicon and Intel Macs, so that a single build is notarized and distributed.
- **E.1.7**: Game developers export their game for arm64 Linux and Windows machines.

## Rules
- **E.1.R1**: Players never install a JDK or any other runtime to play a Godot-JVM game.
- **E.1.R2**: A desktop export targets the operating system and architecture of its preset, whatever machine it is exported from.

## Non-goals
- **E.1.N1**: Games using Godot-JVM do not export to the web.
  - Why: Godot-JVM maintains no runtime that runs inside a browser next to Godot's web export, and does not plan one.
  - Reopen if: a maintained JVM or native-image target for WebAssembly can run inside Godot's web export.
- **E.1.N2**: Games using Godot-JVM do not export to 32-bit targets.
  - Why: Godot-JVM builds, tests and ships 64-bit runtimes only.
