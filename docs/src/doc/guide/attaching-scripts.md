---
description: The difference between attachable source files and generated .gdj registration files, the filename rule, and how .gdj files are laid out on disk.
---

# Attaching scripts and .gdj files

Godot-JVM uses source files for classes declared in the current Godot project and registration files for classes contributed by external dependencies.

- Project classes are attached through their `.kt`, `.java`, or `.scala` source file.
- Dependency classes have no source file inside the Godot project. The Gradle plugin generates a `.gdj` registration file for each usable registered dependency class so it can be attached in the editor.

## Source files (.kt, .java, .scala)

Just like GDScript, you can directly attach Kotlin, Java, and Scala files from the current Godot project to Nodes as scripts. This is the default representation for project classes.

The limitations are the following:

- The source file must be inside both the Godot project and a configured Gradle source set.
- Keep one attachable script class in each source file.
- The registered class information is available after a successful build. Before then, Godot keeps a best-effort source placeholder.

Use the source file directly for project classes.

Godot associates a project source file with its compiled JVM class by looking for a `@Script`
annotation in the file and taking the class declared right after it — the package declaration
supplies the rest of the fully qualified name. The **file name does not need to match the class
name** when `@Script` is present:

```text
Player.kt declaring "@Script class Player"    -> class Player
Player.kt declaring "@Script class Character" -> class Character, not Player
```

**Only when a file has no `@Script` annotation at all** does Godot fall back to matching a class
whose name equals the file's own name (without extension) — `Player.kt` would then only resolve if
it declares a class literally named `Player`. In practice this fallback only matters for
`Automatic` mode, since `Inferred` and `Explicit` mode both require `@Script` for a class to be a
script in the first place — see [Registration reference](../reference/registration.md). Naming
the file after the class is still good practice everywhere, since it is the only case where the
fallback would otherwise fail.

## Registration files (.gdj)

For each non-abstract registered class discovered in an external dependency, the build generates a corresponding `.gdj` registration file. Like source files, these files can be attached to Nodes.
They make dependency classes available when their source files are not part of the Godot project:

- Each dependency class gets its own `.gdj`, including classes from different modules and libraries.
- Registration files are language agnostic: Kotlin, Java, and Scala dependencies use the same format.

By default, dependency registration files are generated into a folder called `gdj` in the root of your Godot project.

You can however configure the Godot root and the base directory used for newly created registration files inside your `build.gradle.kts`:

```kotlin
import godot.gradle.GodotLanguage

godot {
    // Optional: limit the initial compile pass to the JVM languages your project actually uses.
    languages.set(setOf(GodotLanguage.KOTLIN, GodotLanguage.JAVA))

    // Only needed when the Gradle project directory is not the Godot project root.
    godotProjectDirectory.set(file(".."))

    registration {
        gdjFilesDirectory.set(<folder>)
    }
}
```

During the sync step, the Gradle plugin scans the configured Godot project for existing dependency `.gdj` files. Matching files are updated in place, obsolete ones are deleted, and only newly discovered dependency registrations are copied into `gdjFilesDirectory`.

!!! info "Reason"
    JVM languages are compiled. A dependency contributes JAR files rather than source files inside your Godot project, so the Gradle plugin scans its compiled classes and creates `.gdj` files that Godot can attach.

## Layout on disk

As mentioned beforehand, Godot does not have the concept of namespaces. So all classes are registered at top level. It does not matter where in the folder hierarchy a script resides in, it still is accessed the same way. Hence, it does not matter if dependency registration files are all in one directory, or scattered across multiple directories.

By default, new dependency registration files are generated flat inside the configured base directory:

- `com.mygame.packageA.ClassA`
- `com.mygame.packageB.ClassB`

```
[gdjFilesDirectory]/
|- ClassA.gdj
`- ClassB.gdj
```

If you prefer the `.gdj` files to mirror the package hierarchy, you can switch to hierarchical layout in your `build.gradle.kts`:

```kotlin
import godot.registrar.generator.RegistrationFileLayoutMode

godot {
    registration {
        gdjFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
    }
}
```

Which would result in a folder structure like the following:

- `com.mygame.packageA.ClassA`
- `com.mygame.packageB.ClassB`

```
[gdjFilesDirectory]/
`- com/
   `- mygame/
      |- packageA/
      |  `- ClassA.gdj
      `- packageB/
         `- ClassB.gdj
```

When registration files come from external projects, they are always grouped by project name first. For example, if `gdjFilesDirectory` is `scripts` and an external library named `sharedlib` contributes a class, its `.gdj` file is generated under:

- `scripts/sharedlib/MyExternalClass.gdj` in flat mode
- `scripts/sharedlib/com/example/MyExternalClass.gdj` in hierarchical mode

The Gradle plugin updates existing `.gdj` files in place wherever they already live inside the configured Godot project. `gdjFilesDirectory` is therefore the default home for new `.gdj` files, not the only directory the sync task considers. The directory is created only when the build actually has a new `.gdj` file to place there.

See [Registration output](../reference/gradle-plugin/registration.md) for the full list of Gradle plugin settings that control this behaviour.
