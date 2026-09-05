---
description: Current Godot-JVM limitations that are not implemented yet or not planned, including tool mode, addons, web export, and function argument count.
---

# Known limitations

- **No tool mode.** `@Tool` exists and implies `@Script`, but has no effect yet.
- **No addon support.** You cannot use Godot-JVM to write Godot plugins or
  addons yet. You can share Godot-specific code through JVM libraries consumed by Godot-JVM projects.
- **Web export is not supported.** The supported targets are Windows, Linux, macOS, Android, and iOS.
- **GraalVM native image cannot reload code changes.** Rebuild and restart to apply script changes.
- **Functions are limited to 16 parameters.** This is a Godot-JVM limitation, not
  a Godot engine one. Group additional values in a Godot-compatible container such as a `VariantArray` or `Dictionary`.
