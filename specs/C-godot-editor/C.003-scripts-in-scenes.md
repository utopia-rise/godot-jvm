# C.3: Scripts in edited scenes

In the editor, a node with a JVM script shows and stores its exported properties, and explains when its script cannot work, whether or not the class is built.

Scenes are edited while the code is still being written: a script can be attached before its class is built, edited after the last build, broken, deleted or renamed. The editor stands in for the script in each of these cases, keeps what the user set on the node, and says what is wrong, the way it does for a GDScript with errors. A failed build or a missing class must never damage a scene.

Which properties are exported and how the Inspector shows them is A.3.

## Capabilities
- **C.3.1**: Game developers attach a script whose class is not built yet and set values on it, so that a scene is laid out before its code is written or built.
- **C.3.2**: Scenes using a script open and keep their saved values while that script is not built, broken, deleted or renamed, so that fixing the code or the reference never loses the scene.
- **C.3.3**: A node warns, before the game runs, when its script was never built, was modified since the last build, or cannot be instantiated by Godot.

## Rules
- **C.3.R1**: A node never loses the values set on its script because the class is missing, not built yet or stale.
- **C.3.R2**: A saved scene stores only the property values that differ from the defaults of the class.
