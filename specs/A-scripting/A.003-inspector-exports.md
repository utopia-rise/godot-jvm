# A.3: Inspector exports

Script properties can be exported to Godot's Inspector, with the same controls, defaults and layout GDScript's `@export` family offers.

The Inspector is where designers tune a game without touching code: numbers within a range, a file to load, a color, a set of flags, a reference to another node. A JVM script has to give the same editing experience as GDScript, and saved values must reach the script exactly as GDScript receives them.

Showing and editing exported properties before the project is built is C.3.

## Capabilities
- **A.3.1**: Scripts export properties to the Inspector with their initial value as the default, so that values are tuned per scene without code changes.
- **A.3.2**: Scripts give an exported property any Inspector control GDScript's export annotations give, such as a range, a file or directory picker, multiline text or a color without alpha.
- **A.3.3**: Scripts export every type GDScript can, with enums as dropdowns, flag sets as checkboxes, references to nodes and resources (the project's own script types included) and typed arrays and dictionaries, so that only valid values can be picked and scenes are wired together in the editor.
- **A.3.4**: Scripts organize exported properties into categories, groups and subgroups, so that large scripts stay readable in the Inspector.

## Rules
- **A.3.R1**: Values saved in a scene are applied after the script is constructed and before it enters the tree.
- **A.3.R2**: An exported property has at most one hint, and a hint that does not fit the property's type fails the build.
- **A.3.R3**: Exporting a property never makes it writable from Godot if JVM code cannot write it.
