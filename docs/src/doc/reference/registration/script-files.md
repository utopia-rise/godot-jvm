---
description: Source-script association, dependency registration files, and registered class naming policies.
---

# Script files and registered names

## Source files

Project scripts attach through `.kt`, `.java`, or `.scala` files inside the Godot project and a Gradle source set. Keep one attachable class per source file. Before a successful build supplies registration, Godot uses a placeholder.

Godot reads the package and the class following `@Script` to identify the JVM fully qualified class name. With `@Script`, the filename may differ from the class name. Without it, the filename must match the simple JVM class name; this applies to annotation-free Automatic-mode scripts.

| Source | Class association |
|---|---|
| `Player.kt` containing `@Script class Character` | JVM class `Character` in the declared package |
| `Player.java` without `@Script` | JVM class `Player` in the declared package |
| `Player.scala` without `@Script` | JVM class `Player` in the declared package |

A custom registered Godot name does not rename the JVM class or alter this association.

## Registered class names

The base name is the nonblank `@Script.className`, or the simple JVM class name when no custom name is supplied. [`registrationNameMode`](../gradle-plugin/registration.md#registrationnamemode) then applies:

| Mode | Result before sanitization |
|---|---|
| `SIMPLE_NAME` (default) | Base name |
| `FQ_NAME` | Package plus base name |
| `PROJECT_PREFIX` | Base name for this project; source-project prefix plus base name for dependencies |

Dots and hyphens become underscores in every mode. For package `game.actors`, class `Player`, and `className = "Hero"`, `FQ_NAME` yields `game_actors_Hero`. Custom names do not suppress the prefix policy.

Registered names must be unique. The build checks collisions in `SIMPLE_NAME` mode. Other naming modes do not make a collision after sanitization valid.

Property, function, and signal names are converted to `snake_case`, independently of the class naming policy.

## `.gdj` dependency scripts

The build generates `.gdj` files for non-abstract registered dependency classes whose source files are outside the current project. The format is shared by Kotlin, Java, and Scala.

New files go under `<registrationFilesDirectory>/<library>/`. `FLAT` writes directly there; `HIERARCHICAL` adds the package directories. Existing files are matched by JVM fully qualified name and updated in place. Obsolete files are removed during synchronization.

[`disableGdj`](../gradle-plugin/registration.md#disablegdj) disables dependency `.gdj` handling; it does not disable class scanning or registrar generation. See [registration settings](../gradle-plugin/registration.md) for all paths and layout options.


### File fields

The generated file is a text assignment/list format, not JSON:

```text
registeredName = Enemy
fqName = game.Enemy
baseType = Node
supertypes = []
signals = [health_changed]
properties = [health]
notifications = [on_ready_notification:13]
functions = [take_damage]
```

`registeredName` is the Godot class name; `fqName` identifies the JVM class; `baseType` is the engine base. `supertypes` lists registered script ancestors. The remaining lists contain effective inherited member names; notification entries pair a handler name with its numeric ID. Lists can span lines and use commas. The registrar supplies executable bindings; editing this metadata does not compile or register new JVM code.

## Autoload

To autoload a JVM script, first build the project, then add its `.kt`, `.java`, or `.scala` source file in **Project > Project Settings > Globals > Autoload**. For a dependency script, select its generated `.gdj` instead. The script must extend `Node` and have a public no-argument constructor. Use an autoload name distinct from the registered class name.
