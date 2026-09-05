---
description: Selection, Inspector export, and annotation resolution in Inferred, Explicit, and Automatic mode, with Kotlin, Java, and Scala declarations.
---

# Registration modes

Default: `Inferred`. Set [`annotationProcessingMode`](../gradle-plugin/registration.md#annotationprocessingmode) in `build.gradle.kts`.

## Selection and export { #what-selects-each-declaration }

Selection exposes a declaration to Godot only if its shape and types are valid. Inspector export is a separate property flag. Class selection does not guarantee that Godot can instantiate the class.

| Declaration or behavior | Inferred | Explicit | Automatic |
|---|---|---|---|
| Class | `@Script`, directly or through a meta-annotation | Direct `@Script` | Public Godot subclass |
| Property | `@Visible`, directly or implied by `@Export`/a hint | Direct `@Visible` | Public compatible property |
| Inspector export | `@Export`, directly or implied by a hint | Direct `@Export` on a selected property | Every selected property |
| Ordinary function | `@Register`, directly or implied by `@Rpc` | Direct `@Register` | Public compatible function |
| Godot virtual override | Compatible override | Direct `@Register` | Compatible override |
| Signal | Recognized `SignalN` member | Direct `@Emit` | Public `SignalN` member |
| Notification handler | `@Notification` implies selection | Direct `@Notification` selects the handler | `@Notification` identifies the handler |
| [Meta-annotations](../annotations.md#meta-annotations) | Resolved recursively | Not resolved | Resolved recursively |

Accessor-shaped functions also follow the [property/function intent rules](properties.md#accessors-and-function-intent). The table does not override those rules.

## Inferred { #inferred }

Direct and implied annotations select declarations. Godot overrides and typed signals are recognized without selection annotations. `@Export` implies `@Visible`; property hints imply `@Export`; `@Rpc` and `@Notification` imply `@Register`; `@Tool` implies `@Script`.

/// tab | Kotlin

```kotlin
import godot.annotation.*
import godot.api.Node
import godot.core.signal1

@Script
class Player : Node() {
    @Export
    var health: Int = 100
    val healthChanged by signal1<Int>()
    @Register
    fun heal(amount: Int) { health += amount }
    override fun _ready() {}
}
```

///

/// tab | Java

```java
import godot.annotation.*;
import godot.api.Node;
import godot.core.Signal1;

@Script
public class Player extends Node {
    @Export
    public int health = 100;
    public final Signal1<Integer> healthChanged =
        Signal1.create(this, "healthChanged");
    @Register
    public void heal(int amount) { health += amount; }
    @Override public void _ready() {}
}
```

///

/// tab | Scala

```scala
import godot.annotation.*
import godot.api.Node
import godot.core.Signal1

@Script
class Player extends Node {
    @Export
    var health: Int = 100
    val healthChanged: Signal1[Integer] =
        Signal1.create(this, "healthChanged")
    @Register
    def heal(amount: Int): Unit = { health += amount }
    override def _ready(): Unit = {}
}
```

///

With `Inferred` selected, this class produces:

| Godot declaration | Result |
|---|---|
| `Player` | Registered script; public no-argument construction |
| `health` | Integer property, exported to the Inspector |
| `health_changed` | Signal with one integer argument |
| `heal(amount)` | Callable function with one integer argument |
| `_ready()` | Godot lifecycle callback |


## Explicit { #explicit }

Only direct selection annotations count. Exported properties need `@Visible` and `@Export`; hints do not supply either. RPC methods need `@Register` and `@Rpc`. Overrides need `@Register`. A direct `@Notification` selects a notification handler without an additional `@Register`.

/// tab | Kotlin

```kotlin
import godot.annotation.*
import godot.api.Node
import godot.core.signal1

@Script
class Player : Node() {
    @Visible
    @Export
    var health: Int = 100
    @Emit
    val healthChanged by signal1<Int>()
    @Register
    fun heal(amount: Int) { health += amount }
    @Register
    override fun _ready() {}
}
```

///

/// tab | Java

```java
import godot.annotation.*;
import godot.api.Node;
import godot.core.Signal1;

@Script
public class Player extends Node {
    @Visible
    @Export
    public int health = 100;
    @Emit
    public final Signal1<Integer> healthChanged =
        Signal1.create(this, "healthChanged");
    @Register
    public void heal(int amount) { health += amount; }
    @Register
    @Override public void _ready() {}
}
```

///

/// tab | Scala

```scala
import godot.annotation.*
import godot.api.Node
import godot.core.Signal1

@Script
class Player extends Node {
    @Visible
    @Export
    var health: Int = 100
    @Emit
    val healthChanged: Signal1[Integer] =
        Signal1.create(this, "healthChanged")
    @Register
    def heal(amount: Int): Unit = { health += amount }
    @Register
    override def _ready(): Unit = {}
}
```

///

With `Explicit` selected, this class produces:

| Godot declaration | Result |
|---|---|
| `Player` | Registered script; public no-argument construction |
| `health` | Integer property, exported to the Inspector |
| `health_changed` | Signal with one integer argument |
| `heal(amount)` | Callable function with one integer argument |
| `_ready()` | Godot lifecycle callback |


## Automatic { #automatic }

Public compatible declarations are selected without annotations. All selected properties are exported to the Inspector. Annotations still configure names, hints, RPC, and notifications. `@Visible` does not hide a property from the Inspector in this mode.

/// tab | Kotlin

```kotlin
import godot.annotation.*
import godot.api.Node
import godot.core.signal1

class Player : Node() {
    var health: Int = 100
    val healthChanged by signal1<Int>()
    fun heal(amount: Int) { health += amount }
    override fun _ready() {}
}
```

///

/// tab | Java

```java
import godot.annotation.*;
import godot.api.Node;
import godot.core.Signal1;

public class Player extends Node {
    public int health = 100;
    public final Signal1<Integer> healthChanged =
        Signal1.create(this, "healthChanged");
    public void heal(int amount) { health += amount; }
    @Override public void _ready() {}
}
```

///

/// tab | Scala

```scala
import godot.annotation.*
import godot.api.Node
import godot.core.Signal1

class Player extends Node {
    var health: Int = 100
    val healthChanged: Signal1[Integer] =
        Signal1.create(this, "healthChanged")
    def heal(amount: Int): Unit = { health += amount }
    override def _ready(): Unit = {}
}
```

///

With `Automatic` selected, this class produces:

| Godot declaration | Result |
|---|---|
| `Player` | Registered script; public no-argument construction |
| `health` | Integer property, exported to the Inspector |
| `health_changed` | Signal with one integer argument |
| `heal(amount)` | Callable function with one integer argument |
| `_ready()` | Godot lifecycle callback |

Without `@Script`, name the source file `Player.kt`, `Player.java`, or `Player.scala`. See [script files](script-files.md#source-files).

## Shared requirements { #requirements-shared-by-every-mode }

- [Classes and inheritance](classes.md): bases, constructors, abstract classes, inherited declarations.
- [Properties](properties.md): visibility, accessors, supported types, initialization.
- [Functions, notifications and RPC](functions.md): signatures, selection, notifications and networking.
- [Signals](signals.md): declaration forms, argument types and names.
- [Script files and registered names](script-files.md): source association, `.gdj` and naming policies.
