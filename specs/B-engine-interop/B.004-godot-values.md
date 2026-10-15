# B.4: Godot values

Godot's built-in value types, from numbers and strings to vectors, colors, transforms, names and paths, are ordinary values in JVM code and behave as they do in Godot.

Most of what a game manipulates is not objects but values: positions, rotations, colors, node paths, the dynamic `Variant` that Godot passes around. JVM code must handle them as naturally as GDScript does, with the same operations and the same results, so that game logic and math ported from GDScript or from Godot's documentation keep working.

Where the JVM already has a matching type, Godot's value is mapped to it: `bool`, `int`, `float` and `String` are JVM booleans, numbers and strings, and a dynamic `Variant` is any JVM value Godot can represent. Godot's other value types are JVM classes of the same name. They are values, not shared objects: what JVM code reads from a Godot property is a copy, exactly like in GDScript.

Arrays, dictionaries and packed arrays are B.5, and signals and callables as values are B.6.

## Capabilities
- **B.4.1**: Game code handles Godot's numbers, booleans and strings as its language's own types, with that language's standard library.
- **B.4.2**: Vectors, rectangles, transforms, bases, quaternions, planes, bounding boxes, projections, colors, `StringName` and `NodePath` offer the same operations, comparisons and results as in GDScript, so that game logic ported from GDScript or Godot's documentation behaves the same.
- **B.4.3**: Value types read from Godot are copies that game code writes back explicitly, as in GDScript, with a shorter form in Kotlin, so that changing a value never silently fails or touches the wrong object.
- **B.4.4**: Game code passes and receives dynamic values that hold any Godot value, as GDScript's `Variant` does, so that it calls untyped Godot APIs and other languages' scripts.
- **B.4.5**: The project's own enums and flag sets cross into Godot as integers and come back as typed values, so that JVM code keeps type safety while Godot sees what it expects.

## Rules
- **B.4.R1**: A Godot value type offers on the JVM the operations of its Godot counterpart, under the same names adapted to the language's naming convention.
- **B.4.R2**: Operations on Godot value types give the same results as Godot's, within floating-point precision.
- **B.4.R3**: Only values Godot can represent cross into Godot; an arbitrary JVM object never silently becomes a Godot value.

## Non-goals
- **B.4.N1**: JVM strings do not offer Godot's `String` methods.
  - Why: JVM strings keep their language's own string API, which is the equivalent §3 intends for Godot's `String` methods.
