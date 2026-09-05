---
description: Attach classes from libraries through generated registration files (.gdj).
---

# Registration files (.gdj)

A **dependency script** is a registered Godot class supplied by another module or JVM library, whose source is outside the current project.

1. Build the project in IntelliJ IDEA or with Godot's **Build > Run Gradle** toolbar action.
2. Find the generated file under `gdj/<library>/` in the FileSystem dock.
3. Drag it onto a compatible node, just as you [attach a script](https://docs.godotengine.org/en/stable/getting_started/step_by_step/scripting_first_script.html#creating-a-new-script).

Kotlin, Java, and Scala dependency scripts all use the same file format. The file identifies a compiled class; edit that class in its library project, rebuild the library, and rebuild the consuming project to update it.

**Sync** means the build creates files for new dependency scripts, updates existing files, and removes files for scripts no longer present. Existing files are updated where you placed them.
