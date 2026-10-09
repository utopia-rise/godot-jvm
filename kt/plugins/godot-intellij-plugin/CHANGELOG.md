# Changelog

## [Unreleased]

### Experimental

- Registration inspections and declaration highlighting are currently experimental.

### Added

- `@Storage` without `@Visible` is reported in Explicit mode, like `@Export`.
- Automatic mode matches the build: unannotated members register only when public and compatible, and an annotated incompatible member is reported.
- Interface types are reported as parameter, return and signal argument types, and property types follow the build's rules.
- Registered functions and signals report parameter, return and argument types Godot cannot represent.
- A `@Notification` function that declares parameters or returns a value is reported, like the build does.
- Every override of a Godot virtual function counts as a lifecycle override, like in the build, instead of a fixed list of eight names.
- Kotlin functions registered through a meta-annotation such as `@Rpc` or `@Notification` are now checked in Inferred mode.
- Typed callables and signals such as `Signal1` or `Callable0` are reported as parameter, return and signal argument types, with a quick fix declaring the base `Callable` or `Signal`, since Godot only ever hands back the base type.
- Functions passed to `lambdaCallable` no longer have to be registered, since the JVM calls them directly. Only `methodCallable` targets do.
- Added a `Godot` run configuration type. It runs the editor or the game of the current Godot project with a JDK picked from the ones the IDE knows or
  detects, so the JVM used by Godot no longer depends on machine wide settings. The selected JDK is passed with `--jvm-path`, which takes priority over an
  embedded JRE and over the environment.
- Added a `New | Godot Script` action in the project view. It asks for a name, language, Godot base class, and the lifecycle functions to override, and
  generates the class with the annotations required by the selected registration mode.
- Added project-wide selection of the Explicit, Inferred, and Automatic registration modes. Registration inspections follow the selected mode for Kotlin, Java,
  and Scala.
- Added subtle declaration-line highlighting inside Godot scripts: orange for declarations that cannot be registered, blue for registration candidates, and
  green for registered declarations.
- Added a project setting to show or hide registration highlights. Highlights are enabled by default.
- Added a missing-parameterless-constructor error for concrete registered classes while allowing abstract Godot classes to omit one.
- Added complete descriptions for the Java, Kotlin, and Scala registration inspections.

### Improved

- Registration checks for classes, properties, signals, functions, lifecycle methods, and annotations now match the behavior of each registration mode.
- Corrected inspection severities so registration errors and advisory warnings are reported appropriately.
- Expanded Java and Scala inspections for shared class and function registration rules.
- Improved compatibility with IntelliJ IDEA 2025.1, 2025.2, and 2026.1.

### Fixed

- Fixed registration highlights not appearing in the editor.
- Fixed registration highlight ranges so they cover only declaration signatures, excluding indentation, bodies, initializers, and delegates.
- Fixed duplicate custom Godot class names so both declarations are reported and results update immediately after editing or renaming either name.
- Fixed stale duplicate-name highlights and an IDE error that could occur while renaming a duplicate registered class name.
