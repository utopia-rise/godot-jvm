---
description: Current Godot-JVM limitations that are not implemented yet or not planned, including tool mode, addons, web export, and function argument count.
---

# Known limitations

- **No tool mode.** `@Tool` can already be set on a `@Script` class, but it
  currently has no effect.
- **No addon support.** You cannot use Godot-JVM to write Godot plugins or
  addons yet. You can still [write libraries](../build/using-libraries.md)
  that contain Godot-specific code for use from a regular Godot-JVM project.
- **Web export is not supported.** See the list of currently supported
  platforms for what is available.
- **GraalVM native image cannot reload code changes.** Because native image
  is ahead-of-time compiled, picking up an edited script would require
  reloading the JVM itself, which native image does not support.
- **Functions are limited to 16 parameters.** This is a Godot-JVM limitation, not
  a Godot engine one. Pass more values by wrapping them in a container, such as
  a custom container class, a `VariantArray`, or a `Dictionary`.
