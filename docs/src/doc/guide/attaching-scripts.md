---
description: The difference between attachable source files and generated .gdj registration files, the filename rule, and how .gdj files are laid out on disk.
---

# Attaching scripts and .gdj files

Attach your project scripts through their source files and dependency scripts through generated registration files.

## Source files (.kt, .java, .scala)

Attach a project class through its source file. These rules apply:

- The source file must be inside both the Godot project and a configured Gradle source set.
- Keep one attachable script class in each source file.
- The registered class information is available after a successful build. Before then, Godot keeps a placeholder until the class is built.

Godot associates a project source file with its compiled JVM class by looking for a `@Script`
annotation in the file and taking the class declared right after it. The package declaration
supplies the rest of the fully qualified name. The **file name does not need to match the class
name** when `@Script` is present:

```text
Player.kt declaring "@Script class Player"    -> class Player
Player.kt declaring "@Script class Character" -> class Character, not Player
```

Without `@Script`, Godot looks for a class whose simple name matches the filename: `Player.kt` must declare `Player`. This matters in Automatic mode, which can register classes without `@Script`. Keeping the file and class names alike works in either case.

## Registration files (.gdj)

For each non-abstract registered class discovered in an external dependency, the build generates a corresponding `.gdj` registration file.
They make dependency classes available when their source files are not part of the Godot project:

- Each dependency class gets its own `.gdj`, including classes from different modules and libraries.
- Registration files are language agnostic: Kotlin, Java, and Scala dependencies use the same format.

During sync, the build updates matching registration files, deletes obsolete ones, and copies newly discovered registrations into the configured directory.

New dependency registration files are grouped under `gdj/<library>/`. The default layout is flat; `HIERARCHICAL` mirrors the package directories within each library. Existing files stay where you put them; the layout setting controls where new files are created. [Registration output](../reference/gradle-plugin/registration.md) covers the directory and layout settings.
