---
description: How Godot enums, renamed symbols, global GDScript functions, and extension helpers map onto their Kotlin, Java, and Scala equivalents.
---

# Renamed symbols and global functions

## Enums and constants

Godot enums are mapped to JVM enums, and the generated enum exposes a `value` property that represents the value in Godot. Constants in Godot classes that represent an enum value (such as `Node.PROCESS_MODE_INHERIT`) are not present in this binding; use the generated enum instead (`Node.ProcessMode.INHERIT`).

## Renamed symbols

These names differ from Godot's API to avoid conflicts with JVM types:

- `Array` -> `VariantArray`
- `PackedXArray::toByteArray` -> `PackedXArray::toPackedByteArray`
- `PackedByteArray::toXArray` -> `PackedByteArray::toPackedXArray`
- Enum values omit redundant enum-name prefixes. For example:
  - `Error.ERR_PARAMETER_RANGE_ERROR` -> `Error.PARAMETER_RANGE`
  - `MethodFlags.METHOD_FLAG_NORMAL` -> `MethodFlags.NORMAL`
  - `Node.ProcessThreadMessages.FLAG_PROCESS_THREAD_MESSAGES_PHYSICS` -> `Node.ProcessThreadMessages.FLAG_PHYSICS`

## Global functions

GDScript exposes global functions for tasks such as mathematics, random numbers, and resource loading.

Godot-JVM exposes global helpers through `GD`. Some GDScript operations have no JVM equivalent: `GD.load()` is available, but `preload()` is not.

## Additional functions

Kotlin extension helpers add operations such as property mutation and string conversion. Their implementations live in the [Godot extension library](https://github.com/utopia-rise/godot-jvm/tree/master/kt/godot-library/godot-extension-library/src/main/kotlin/godot/extension).
