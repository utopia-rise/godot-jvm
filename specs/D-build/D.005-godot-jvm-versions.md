# D.5: Godot-JVM versions

A project chooses its Godot-JVM version in one place, and the build keeps the Godot addon and the JVM libraries consistent with it.

Godot-JVM has a native side (the addon in `addons/jvm/`) and a JVM side (the libraries the build uses), and the two must come from the same version. The user should not align them by hand, nor handle native files at all: the Gradle plugin version is the single choice, and the build installs the matching addon, which the editor can also trigger from its toolbar. Users also need to try versions before they are released.

Generating typed bindings from another engine's API description is B.3.

## Capabilities
- **D.5.1**: The Godot-JVM plugin version in the build script selects every Godot-JVM library the project uses, so that upgrading is a one-line change.
- **D.5.2**: Game developers install or update the Godot-JVM addon from their build or from the editor toolbar, even while the editor is open, so that the native side matches their JVM libraries without manual downloads.
- **D.5.3**: Game developers try a development, release candidate or locally built Godot-JVM version, so that a fix or a feature is tested before its release.

## Rules
- **D.5.R1**: The addon and the JVM libraries a project runs always come from the same Godot-JVM version, and a mismatch is refused at startup, in the editor and in games, rather than run.
- **D.5.R2**: Installing the addon never leaves `addons/jvm/` half replaced, and when no matching addon can be resolved it fails without touching the current one.
