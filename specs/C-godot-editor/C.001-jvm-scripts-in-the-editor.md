# C.1: JVM scripts in the editor

Kotlin, Java and Scala are script languages of the Godot editor: scripts are created, attached, found and browsed there the same way as GDScript.

In Godot a script is a file in the project that a scene points to. A Godot user expects to pick a language in the Attach Script dialog, drag a script file onto a node and find their classes in the editor's dialogs. JVM scripts take part in all of these workflows: a `.kt`, `.java` or `.scala` file inside the project is the script, and scripts from libraries are attached through the registration files the build generates for them (D.4). Writing the code itself is better done in a JVM IDE, so the editor offers what is needed to attach and browse scripts rather than full code insight.

Code completion, navigation and error checking while typing come from the IDE (D.6), and what a script class can declare is category A.

## Capabilities
- **C.1.1**: The Attach Script dialog offers Kotlin, Java and Scala, with a ready-made template for nodes and for plain objects.
- **C.1.2**: Game developers attach a `.kt`, `.java` or `.scala` file to a node or resource by dragging it or through Attach Script, as they do with `.gd` files.
- **C.1.3**: The editor follows a script file that is renamed, moved or repackaged, so that reorganizing sources never breaks scenes.
- **C.1.4**: Godot's script editor opens JVM sources with syntax highlighting, so that reading or quickly editing one needs no other tool.
- **C.1.5**: JVM script classes show their own icon and their documentation in the editor's help, like built-in and GDScript classes.

## Rules
- **C.1.R1**: A JVM script is identified by the fully qualified name of its class, never by its file path.
- **C.1.R2**: A source file declares at most one attachable script class, and a class is bound to at most one source file at a time.
