# A.5: Tool scripts

Scripts can run inside the Godot editor, as GDScript's `@tool` scripts and editor plugins do.

Godot users extend their own editor: previewing procedural content in the viewport, validating a scene while it is edited, adding docks and importers through an editor plugin. Today JVM scripts only run in the game; in the editor they stand in as placeholders that show their exported properties (C.3). A tool annotation already exists so that scripts can be marked, but marking a script has no effect yet, and the editor-only Godot classes an editor plugin needs are not part of the JVM API (B.1).

Godot-JVM's own editor integration, such as the build toolbar and project generation, is category C.

## Capabilities
- **A.5.1**: Scripts marked as tool scripts run in the editor, so that procedural content is previewed and edited live.
- **A.5.2**: Scripts implement editor plugins that extend the Godot editor of their project.

## Rules
- **A.5.R1**: A script that is not marked as a tool script never runs its code in the editor.

## Non-goals
- **A.5.N1**: Godot-JVM scripts are not packaged as standalone Godot addons for projects that do not use Godot-JVM.
  - Why: A JVM script needs the Godot-JVM extension, a JVM and the project's Gradle build, which compiles all code into one jar per project; shared JVM code is distributed as a library instead (D.4).
  - Reopen if: Godot-JVM loads several independently built jars as separate addons in one project.
