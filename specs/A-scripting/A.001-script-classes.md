# A.1: Script classes

A class written in Kotlin, Java or Scala that extends a Godot class becomes a Godot script, known to the engine by name like a GDScript with a `class_name`.

The script class is the unit of game code in Godot. A JVM class has to play that role without ceremony: extend a Godot type, be recognized as a script, and be usable wherever Godot expects a scripted object, whether that is a node in a scene, a custom resource, an autoload or a plain object created from code. Which declarations count as scripts and members is decided once per project, so a team can choose between explicit annotations and registering everything public.

How the build registers scripts is D.3, how the editor attaches, shows and reloads them is category C, and Godot classes themselves and the lifetime of their instances are B.1 and B.2.

## Capabilities
- **A.1.1**: Script classes extend any Godot class, such as a node, a resource or a plain object, and serve as scripts anywhere Godot takes one, autoloads included.
- **A.1.2**: Script classes are known to Godot by name and listed in the editor's class lists, and the editor and scripts in any language create them like a GDScript `class_name`.
- **A.1.3**: Script classes inherit from one another, abstract ones included, and keep the members their parents expose, so that game logic is shared through a class hierarchy.
- **A.1.4**: A build setting chooses whether only annotated declarations or every public declaration are registered, so that each project trades explicitness for brevity as it prefers.
- **A.1.5**: Script classes take a Godot name different from their JVM name, so that classes with the same simple name, including ones from different libraries, coexist.

## Rules
- **A.1.R1**: Godot creates script instances only through a public no-argument constructor; other constructors remain available to JVM code only.
- **A.1.R2**: Registered class names are unique in a project, and a collision fails the build.
- **A.1.R3**: A declaration marked for registration that cannot be registered fails the build instead of being silently ignored.
- **A.1.R4**: An exception escaping a script callback is reported in Godot with its stack trace and never stops the game.
- **A.1.R5**: An abstract script class is known to Godot but is never instantiated.
