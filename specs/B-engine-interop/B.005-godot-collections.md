# B.5: Godot collections

Godot's arrays, dictionaries and packed arrays are usable from JVM code with Godot's semantics and with the JVM's collection APIs.

Godot's containers are shared, reference-like values: a GDScript array passed to a function is the same array, not a copy. JVM code receiving or creating one must see the same contents as Godot and every other language, and its changes must be seen by them. At the same time a JVM developer expects to iterate, filter and transform collections with the standard library of their language, so Godot's containers also present themselves as JVM collections.

Godot 4 also types its containers. A typed array or dictionary created on the JVM must be typed on the Godot side as well, so that GDScript, the inspector and the engine see the same element type.

## Capabilities
- **B.5.1**: Godot arrays and dictionaries in JVM code share their contents with Godot, and a change on either side is seen on the other as in GDScript.
- **B.5.2**: Typed arrays and dictionaries match GDScript's typed collections, so that element types are checked and other languages see the same types.
- **B.5.3**: Game code iterates and transforms Godot collections with its language's collection API.
- **B.5.4**: Packed arrays convert to and from JVM arrays in bulk, so that large numeric or binary data moves cheaply between game code and Godot.
- **B.5.5**: Arrays, dictionaries and packed arrays offer Godot's own operations under their Godot names, so that GDScript code and examples using them translate directly.

## Rules
- **B.5.R1**: A Godot array or dictionary is never silently copied when it crosses between Godot and the JVM; only an explicit duplicate makes a copy.
- **B.5.R2**: A typed collection created on the JVM carries the same element type on the Godot side.
