---
description: A quick lookup table matching each registration task to the annotation that performs it, from @Script and @Export to @Rpc and @Emit.
---

# Annotations

The table below uses Inferred mode. In this mode, export and hint annotations also select the property for registration; `@Emit` is optional for typed signals.

| What you want to do | Use |
|---|---|
| Make a class available as a Godot script | `@Script` |
| Give a script class a custom Godot name | `@Script(className = "PlayerCharacter")` |
| Register a property without showing it in the Inspector | `@Visible` |
| Show and edit a property in the Inspector | `@Export` |
| Choose an Inspector control, such as a range or file picker | A property hint such as `@IntRange` |
| Let Godot call an ordinary function | `@Register` |
| Configure a remote procedure call | `@Rpc` |
| Handle a Godot notification | `@Notification(...)` |
| Give signal arguments readable names | `@Emit`, listing the parameter names |
| Mark a script for editor-time execution | `@Tool` (tool mode is not implemented yet) |
