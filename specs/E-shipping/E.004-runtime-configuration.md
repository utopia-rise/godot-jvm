# E.4: Runtime configuration

The runtime of a game is configured in one project file, which each export preset can override and every launch can override again from the command line.

Some settings are not code: whether a desktop game runs as a native image, how the JVM is debugged or monitored, the size of the buffers shared with Godot, extra runtime arguments. They live in `godot_jvm_configuration.json` at the root of the project, so that every run and every export starts from the same values. An export preset adjusts them for one kind of build, a launch argument adjusts them for one run, and a player never has to see any of it.

Validating and repairing the configuration file in the editor is C.5, what the debugging settings enable is D.7, and what the memory settings trade is F.4.

## Capabilities
- **E.4.1**: Game developers configure the runtime of their game in one file of the project, from which every run and every export of the game starts.
- **E.4.2**: Game developers override any runtime setting for one launch of the game with a `--jvm-*` argument, without editing the project.
- **E.4.3**: An export preset overrides the debug, memory and runtime argument settings of the game, so that different builds of one game are configured differently without editing the project file.
- **E.4.4**: Game developers pass their own runtime arguments, such as the heap size, the garbage collector or system properties, to their game, and so tune the runtime it ships with as in any JVM application.

## Rules
- **E.4.R1**: Settings resolve as defaults, then the configuration file, then the command line, each overriding the previous one.
- **E.4.R2**: An exported game carries the project file with its preset overrides applied, and nothing from the editor's own settings or command line.
- **E.4.R3**: Exporting never modifies the project's configuration file, and an exported game never rewrites the configuration it carries.
- **E.4.R4**: A setting the running platform cannot apply is ignored, and an export packs only the settings its platform reads.
- **E.4.R5**: A missing or invalid setting falls back to its default instead of preventing the game from starting.
