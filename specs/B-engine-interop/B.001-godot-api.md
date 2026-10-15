# B.1: Godot API

JVM code reaches the whole Godot API, under the names Godot users already know.

A JVM script is only a first-class Godot script if nothing the engine offers is out of its reach. The API must also read like Godot's own, so that Godot's documentation, tutorials and answers apply directly to JVM code.

The API is generated from the description Godot publishes of itself, so it follows each Godot release instead of being maintained by hand. Engine classes, singletons, enums and constants come from that description; the global functions of `@GlobalScope` are gathered in one place, where the pure math ones run on the JVM.

Declaring the members of a script class and overriding engine callbacks such as `_ready` is A.2, and bindings for GDExtension classes and custom engine builds are B.3.

## Capabilities
- **B.1.1**: Game code uses every Godot class, method, property, signal and constant.
- **B.1.2**: Game code calls Godot's global functions (printing, math, random numbers, loading resources, instance checks) from one place under their GDScript names, so that GDScript code and examples translate directly.
- **B.1.3**: The API exposes Godot enums, bitfields and constants as typed values, so that the compiler catches a wrong flag or an enum from another type.
- **B.1.4**: The IDE shows Godot's class reference for each class and member of the generated API.
- **B.1.5**: The API follows each language's habits: properties in Kotlin, getters and setters in Java, nullable results where Godot may return nothing.

## Rules
- **B.1.R1**: Godot classes, methods, properties, signals and constants keep their name and meaning on the JVM, adapted only to each language's naming convention.
- **B.1.R2**: What is thread-safe in Godot is thread-safe from the JVM, and nothing more is promised.
- **B.1.R3**: Desktop games run on a JVM or as a native image, Android games on ART and iOS games as a native image.
- **B.1.R4**: A Godot name is changed beyond the naming convention only when a JVM language forbids it or the generated API would clash with itself, and every such change is listed in the user documentation.
