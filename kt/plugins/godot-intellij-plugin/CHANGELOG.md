# Changelog

## [Unreleased]

### Experimental

- Registration inspections and declaration highlighting are currently experimental.

### Added

- Registration annotations on private or static members, on same-name overloads, on objects and on extension functions are reported as warnings in Kotlin, Java and Scala.
- Automatic mode matches the build: unannotated members register only when public and compatible, and an annotated incompatible member is reported.
- Interface types are reported as parameter, return and signal argument types, and property types follow the build's rules.
- Registered functions and signals report parameter, return and argument types Godot cannot represent.
- A `@Notification` function that declares parameters or returns a value is reported, like the build does.
- Every override of a Godot virtual function counts as a lifecycle override, like in the build, instead of a fixed list of eight names.
- Kotlin functions registered through a meta-annotation such as `@Rpc` or `@Notification` are now checked in Inferred mode.
- Typed callables and signals such as `Signal1` or `Callable0` are reported as parameter, return and signal argument types, with a quick fix declaring the base `Callable` or `Signal`, since Godot only ever hands back the base type.
- An unregistered lifecycle override in Explicit mode offers an "Add @Register annotation" quick fix, in Kotlin, Java and Scala.
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
- Range hints follow Godot's underlying type: `@IntRange` is accepted on any integer property (`Byte`, `Short`, `Int`, `Long`) and `@FloatRange` on `Float` or `Double`. `@LongRange` and `@DoubleRange` no longer exist.

### Fixed

- Editing a Kotlin file in Automatic mode no longer throws an analysis error from the registered class index, which now updates in the background.
- Fixed registration highlights not appearing in the editor.
- Fixed registration highlight ranges so they cover only declaration signatures, excluding indentation, bodies, initializers, and delegates.
- Fixed duplicate custom Godot class names so both declarations are reported and results update immediately after editing or renaming either name.
- Fixed stale duplicate-name highlights and an IDE error that could occur while renaming a duplicate registered class name.
- Fixed an IDE error that stopped all Kotlin registration checks in a file containing a registered `@JvmField` property or signal.
- Members of a companion object or a nested object inside a Kotlin script are no longer checked or highlighted as members of the script, since the build never registers them.
- Function references are checked only where Godot calls the function by name: `methodCallable0` to `methodCallable16`, `connectMethod`, `rpc` and `rpcId`. A reference used as a lambda, such as `connectLambda(method = ::cleanup)`, or passed to another function is no longer reported as unregistered.
- The quick fix adding `@Script` to an unregistered class now works on Kotlin classes, where it did nothing, and on Scala classes, where it left code that did not compile.
- The quick fix for an RPC target with `RpcMode.DISABLED` replaces it with `RpcMode.AUTHORITY` instead of deleting the argument, which broke annotations passing the mode positionally, such as `@Rpc(RpcMode.DISABLED, Sync.SYNC)`.
- Overloaded Scala functions are each checked against their own signature. A registered overload with an unsupported parameter type was either missed or reported on the other overload too.
- Adding a Godot-JVM module to an existing project creates it in a directory named after the module, includes it in `settings.gradle.kts` with a valid Gradle path on Windows too, and no longer gives it its own `project.godot`.
- `New | Godot Script` rejects a base class the generated script could not extend: a final class or object, such as a singleton like `Input`, a class without an accessible constructor, such as `CanvasItem`, and an abstract class with abstract members.
- Messages and inspection descriptions name the `@Script` annotation instead of `@GodotScript`, which does not exist.
- In Automatic mode, Java getters and setters are no longer highlighted as registered functions, since the build registers them as part of their property.
- Class-level problems in Scala files are underlined on the class name, as in Java and Kotlin, instead of across the whole class.
