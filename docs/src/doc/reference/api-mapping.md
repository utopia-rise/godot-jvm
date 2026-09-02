---
description: How Godot enums, renamed symbols, global GDScript functions, and extension helpers map onto their Kotlin, Java, and Scala equivalents.
---

# Renamed symbols and global functions

## Enums and constants

Godot enums are mapped to Kotlin enums, and the generated enum exposes a `value` property that represents the value in Godot. Constants in Godot classes that represent an enum value (such as `Node.PROCESS_MODE_INHERIT`) are not present in this binding; use the generated enum instead (`Node.ProcessMode.INHERIT`).

## Renamed symbols

To avoid confusion and conflict with Kotlin types, the following Godot symbol is renamed.

- `Array` -> `VariantArray` (to avoid confusion with a built-in type in Kotlin)
- `PackedXArray::toByteArray` -> `PackedXArray::toPackedByteArray` (to avoid confusion with a built-in type in Kotlin)
- `PackedByteArray::toXArray` -> `PackedByteArray::toPackedXArray` (to avoid confusion with a built-in type in Kotlin)
- All enum values are shortened, the name of the enum itself has been removed. Here are some examples:
  - `Error.ERR_PARAMETER_RANGE_ERROR` -> `Error.PARAMETER_RANGE`
  - `MethodFlags.METHOD_FLAG_NORMAL` -> `MethodFlags.NORMAL`
  - `Node.ProcessThreadMessages.FLAG_PROCESS_THREAD_MESSAGES_PHYSICS` -> `Node.ProcessThreadMessages.FLAG_PHYSICS`

## Global functions

In GDScript, some functions are always available (such as mathematical or RNG functions).
The complete list can be found on the following [page](https://docs.godotengine.org/en/stable/classes/class_%40gdscript.html) of Godot's documentation.

In Kotlin, Java, and Scala, global functions are available through the `GD` singleton helpers. However, don't forget that some functions couldn't be reproduced exactly on the JVM side.
For example, `load()` is available but `preload()` is not.

## Additional functions

For comfort, some objects got some additional functions to enjoy some Kotlin syntax sugar.
You can find them all [in this folder](https://github.com/utopia-rise/godot-jvm/tree/master/kt/godot-library/src/main/kotlin/godot/extensions).
