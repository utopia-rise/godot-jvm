---
description: Selection, Inspector export, and annotation resolution in Inferred, Explicit, and Automatic mode, with Kotlin, Java, and Scala declarations.
---

# Registration modes

Default: `Inferred`. Set [`registration.annotationProcessingMode`](../gradle-plugin/registration.md#registrationannotationprocessingmode) in `build.gradle.kts`.

## Selection and export { #what-selects-each-declaration }

Every mode reads the same annotations, [meta-annotations](../annotations.md#meta-annotations) included, and only registers *candidates*: a public class that is not an object, and its public instance members. The mode sets the annotation assumed on a candidate that has none written; a written annotation replaces that default. An annotation written on something that is not a candidate, such as a private or static member, an object, an extension function or one of several same-name overloads, fails the build and is flagged by the IDE.

| Declaration or behavior | Inferred | Explicit | Automatic |
|---|---|---|---|
| Class | `@Script` | `@Script` | Assumed `@Script` |
| Property | `@Visible` | `@Visible` | Assumed `@Export` |
| Inspector export | `@Export` | `@Export` | Every property, unless `@Visible` or `@Storage` is written |
| Ordinary function | `@Register` | `@Register` | Assumed `@Register` |
| Godot virtual override | Assumed `@Register` | `@Register` | Assumed `@Register` |
| Signal | Assumed `@Emit` | `@Emit` | Assumed `@Emit` |
| Notification handler | `@Notification` | `@Notification` | `@Notification` |

`@Export` carries `@Storage`, which carries `@Visible`; property hints carry `@Export`; `@Rpc` and `@Notification` carry `@Register`; `@Tool` carries `@Script`. Inspector export is a separate property flag. Class selection does not guarantee that Godot can instantiate the class.

Accessor-shaped functions also follow the [property/function intent rules](properties.md#accessors-and-function-intent). The table does not override those rules.

## Inferred { #inferred }

Annotations select declarations. Godot overrides and typed signals are assumed registered without one.

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

Nothing is assumed: every registered declaration carries an annotation, written or carried by another one. Overrides need `@Register` and signals need `@Emit`. `@Export` alone exports a property and `@Rpc` alone registers an RPC method, as in the other modes.

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

Every candidate is assumed registered without annotations, and properties are assumed `@Export`. Writing `@Visible` or `@Storage` replaces that default with the lower exposure. Annotations that add something the default lacks, such as `@Rpc`, must still be written. Annotations also configure names, hints, and notifications.

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
