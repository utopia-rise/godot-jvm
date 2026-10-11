---
description: Complete registration annotation and Inspector property-hint contracts, arguments, defaults, and Kotlin, Java, and Scala syntax.
---

# Annotations

Package: `godot.annotation`. These annotations have runtime retention and can also target annotation declarations. An annotation never makes an invalid declaration or unsupported type valid.

## Registration annotations

| Annotation | Effect |
|---|---|
| [`@Category`, `@Group`, `@Subgroup`](#inspector-groups) | Inspector sections |
| [`@Emit`](#emit) | Signal selection and argument names |
| [`@Export`](#export) | Inspector export |
| [`@Notification`](#notification) | Notification handler |
| [`@Register`](#register) | Callable function selection |
| [`@Rpc`](#rpc) | Remote procedure call configuration |
| [`@Script`](#script) | Script class selection and custom name |
| [`@Storage`](#storage) | Scene storage without Inspector visibility |
| [`@Tool`](#tool) | Tool marker; editor execution is not implemented |
| [`@Visible`](#visible) | Property selection |

Member examples belong inside a registered script class. All examples include the direct selection annotations needed by Explicit mode unless stated otherwise.

### `@Emit` { #emit }

Targets: property or field. `parameters` is an array of strings, default empty; provide one name per signal argument when naming them.

Inferred recognizes typed signals without this annotation. Explicit requires direct `@Emit`. Automatic selects public typed signals. The annotation names arguments; the signal name comes from the member. See [signal registration](registration/signals.md).

/// tab | Kotlin

```kotlin
import godot.annotation.Emit
import godot.core.signal2

@Emit("current", "maximum")
val healthChanged by signal2<Int, Int>()
```

///

/// tab | Java

```java
import godot.annotation.Emit;
import godot.core.Signal2;

@Emit(parameters = {"current", "maximum"})
public final Signal2<Integer, Integer> healthChanged =
    Signal2.create(this, "healthChanged");
```

///

/// tab | Scala

```scala
import godot.annotation.Emit
import godot.core.Signal2

@Emit(parameters = Array("current", "maximum"))
val healthChanged: Signal2[Integer, Integer] =
    Signal2.create(this, "healthChanged")
```

///

### `@Export` { #export }

Targets: property or field. No arguments.

Carries `@Storage`, so it also registers and stores the property in every mode. Automatic: a registered property is already exported unless `@Visible` or `@Storage` is written on it; written alongside them, `@Export` still wins. Adds Inspector visibility; it does not add a setter to a read-only property.

/// tab | Kotlin

```kotlin
import godot.annotation.Export
import godot.annotation.Visible

@Visible
@Export
var health: Int = 100
```

///

/// tab | Java

```java
import godot.annotation.Export;
import godot.annotation.Visible;

@Visible
@Export
public int health = 100;
```

///

/// tab | Scala

```scala
import godot.annotation.{Export, Visible}

@Visible
@Export
var health: Int = 100
```

///

### `@Notification` { #notification }

Target: function. `value` is a required `Long` annotation argument. Registration converts it to a signed 32-bit notification ID; values outside that range are truncated. Use Godot notification constants.

Selects a notification handler in every mode without an additional `@Register`. The method must be public, take no arguments, return no result, and have no RPC configuration. It is registered as a notification handler rather than an ordinary callable method.

/// tab | Kotlin

```kotlin
import godot.annotation.Notification
import godot.api.Node

@Notification(Node.NOTIFICATION_READY)
fun onReadyNotification() {}
```

///

/// tab | Java

```java
import godot.annotation.Notification;
import godot.api.Node;

@Notification(Node.NOTIFICATION_READY)
public void onReadyNotification() {}
```

///

/// tab | Scala

```scala
import godot.annotation.Notification
import godot.api.Node

@Notification(Node.NOTIFICATION_READY)
def onReadyNotification(): Unit = {}
```

///

### `@Register` { #register }

Target: function. No arguments.

Selects an ordinary method in Inferred and Explicit modes. Automatic already selects compatible public methods; `@Register` also disambiguates [accessor-shaped methods](registration/properties.md#accessors-and-function-intent). Explicit mode requires it on Godot overrides. Method names are converted to `snake_case`.

/// tab | Kotlin

```kotlin
import godot.annotation.Register

@Register
fun takeDamage(amount: Int) {}
```

///

/// tab | Java

```java
import godot.annotation.Register;

@Register
public void takeDamage(int amount) {}
```

///

/// tab | Scala

```scala
import godot.annotation.Register

@Register
def takeDamage(amount: Int): Unit = {}
```

///

### `@Rpc` { #rpc }

Target: function. Configures a registered method for RPC. Inferred: implies `@Register`. Explicit: add direct `@Register`. Automatic: configures a selected compatible method. A notification handler cannot also be an RPC function.

| Argument | Type | Default | Values |
|---|---|---|---|
| `rpcMode` | `RpcMode` | `AUTHORITY` | `DISABLED`, `ANY`, `AUTHORITY` |
| `sync` | `Sync` | `NO_SYNC` | `SYNC`, `NO_SYNC` |
| `transferMode` | `TransferMode` | `RELIABLE` | `RELIABLE`, `UNRELIABLE`, `UNRELIABLE_ORDERED` |
| `transferChannel` | 32-bit integer | `0` | Channel index passed to Godot |

`RpcMode.DISABLED` disables remote calls; `ANY` permits any peer to call; `AUTHORITY` restricts calls to the multiplayer authority. `Sync.SYNC` includes local execution (`call_local`); `NO_SYNC` is remote-only (`call_remote`). `RELIABLE` requests reliable ordered delivery; `UNRELIABLE` does not guarantee delivery/order; `UNRELIABLE_ORDERED` discards out-of-order packets.

The registrar warns when a nonzero `transferChannel` is used with a mode other than `UNRELIABLE_ORDERED`; the channel remains part of the emitted configuration. Actual transport behavior is supplied by Godot's multiplayer peer. See [Godot RPC semantics](https://docs.godotengine.org/en/stable/tutorials/networking/high_level_multiplayer.html#remote-procedure-calls).

/// tab | Kotlin

```kotlin
import godot.annotation.*

@Register
@Rpc(rpcMode = RpcMode.ANY, sync = Sync.SYNC)
fun receiveScore(score: Int) {}
```

///

/// tab | Java

```java
import godot.annotation.*;

@Register
@Rpc(rpcMode = RpcMode.ANY, sync = Sync.SYNC)
public void receiveScore(int score) {}
```

///

/// tab | Scala

```scala
import godot.annotation.*

@Register
@Rpc(rpcMode = RpcMode.ANY, sync = Sync.SYNC)
def receiveScore(score: Int): Unit = {}
```

///

### `@Script` { #script }

Target: class. `className` is a string, default `""` (use the simple JVM class name).

Inferred accepts direct or implied `@Script`. Explicit requires direct `@Script`. Automatic selects public compatible subclasses without it; the annotation can still set a custom name. The class must derive from a Godot class.

The custom name is the base name before the configured [naming policy](registration/script-files.md#registered-class-names) adds a package/project prefix and sanitizes it.

/// tab | Kotlin

```kotlin
import godot.annotation.Script
import godot.api.Node

@Script(className = "Hero")
class Player : Node()
```

///

/// tab | Java

```java
import godot.annotation.Script;
import godot.api.Node;

@Script(className = "Hero")
public class Player extends Node {}
```

///

/// tab | Scala

```scala
import godot.annotation.Script
import godot.api.Node

@Script(className = "Hero")
class Player extends Node
```

///

### `@Storage` { #storage }

Targets: property or field. No arguments.

Carries `@Visible`, so it also registers the property in every mode. Automatic: replaces the assumed `@Export`, so a registered property is stored but hidden. The value is saved and loaded with the scene or resource but does not appear in the Inspector, like GDScript's `@export_storage`. With `@Export` on the same property, the property is exported.

/// tab | Kotlin

```kotlin
import godot.annotation.Storage
import godot.annotation.Visible

@Visible
@Storage
var spawnCount: Int = 0
```

///

/// tab | Java

```java
import godot.annotation.Storage;
import godot.annotation.Visible;

@Visible
@Storage
public int spawnCount = 0;
```

///

/// tab | Scala

```scala
import godot.annotation.{Storage, Visible}

@Visible
@Storage
var spawnCount: Int = 0
```

///

### `@Tool` { #tool }

Target: class. No arguments. **Editor-time tool execution is not implemented.**

Inferred: implies `@Script`. Explicit: add direct `@Script`. Automatic: the public compatible class is already selected. The annotation does not currently make the script run as a Godot editor tool.

/// tab | Kotlin

```kotlin
import godot.annotation.Script
import godot.annotation.Tool
import godot.api.Node

@Script
@Tool
class EditorMarker : Node()
```

///

/// tab | Java

```java
import godot.annotation.Script;
import godot.annotation.Tool;
import godot.api.Node;

@Script
@Tool
public class EditorMarker extends Node {}
```

///

/// tab | Scala

```scala
import godot.annotation.{Script, Tool}
import godot.api.Node

@Script
@Tool
class EditorMarker extends Node
```

///

### `@Visible` { #visible }

Targets: property or field. No arguments.

Registers a property without storing it or exporting it to the Inspector. Add `@Storage` or `@Export` for more. Automatic assumes `@Export` on every candidate property; writing `@Visible` replaces that default, so the property is registered but neither stored nor shown in the Inspector.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible

@Visible
var health: Int = 100
```

///

/// tab | Java

```java
import godot.annotation.Visible;

@Visible
public int health = 100;
```

///

/// tab | Scala

```scala
import godot.annotation.Visible

@Visible
var health: Int = 100
```

///

### Meta-annotations { #meta-annotations }

All registration and hint annotations can annotate another annotation declaration. Every mode follows these chains recursively for declaration selection and registration configuration. The built-in chains are `@Export` to `@Storage` to `@Visible`, property hints to `@Export`, `@Rpc` and `@Notification` to `@Register`, and `@Tool` to `@Script`. Custom annotations must be retained in the compiled class for registration to see them.

Inspector hints are read only from annotations placed directly on the property. A custom annotation carrying `@FloatRange`, for example, implies selection and export, but does not transfer its range hint. Place `@FloatRange` directly on the property to apply the range.

## Property hints { #property-hints }

Targets: property, field, or annotation declaration. Each hint carries `@Export`, so a hint alone registers and exports the property in every mode.

At most one property hint is allowed, including hints inferred from enum/bitfield types. A hint/type mismatch fails registration validation. Import the shown annotations from `godot.annotation`.

| Hint | Property types | Inspector control |
|---|---|---|
| [`@ColorNoAlpha`](#colornoalpha) | `Color` | Color without alpha |
| [`@Dir`](#dir) | String | Directory picker |
| [`@ExpEasing`](#expeasing) | Float or Double | Easing curve |
| [`@File`](#file) | String | File picker |
| [`@FloatRange`](#floatrange) | Float or Double | Range with floating-point bounds |
| [`@HintString`](#hintstring) | Any supported property | Raw hint string |
| [`@IntFlag`](#intflag) | Int | Flag checkboxes |
| [`@IntRange`](#intrange) | Byte, Short, Int or Long | Range with integer bounds |
| [`@MultilineText`](#multilinetext) | String | Multiline input |
| [`@PlaceHolderText`](#placeholdertext) | String | Placeholder-text hint |

Range hints accept Int, Long, Float, or Double properties. Choose the annotation with argument precision appropriate to the property. Boolean, Byte, and Short properties are not accepted by range-hint validation.

### `@ColorNoAlpha` { #colornoalpha }

No arguments. Removes alpha editing from the color picker. Import `godot.core.Color`.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.ColorNoAlpha
import godot.core.Color

@Visible
@Export
@ColorNoAlpha
var tint: Color = Color(1, 1, 1, 1)
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.ColorNoAlpha;
import godot.core.Color;

@Visible
@Export
@ColorNoAlpha
public Color tint = new Color(1, 1, 1, 1);
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.ColorNoAlpha
import godot.core.Color

@Visible
@Export
@ColorNoAlpha
var tint: Color = new Color(1, 1, 1, 1)
```

///

### `@Dir` { #dir }

`global`: boolean, default `false`. `false` selects a project directory; `true` selects a filesystem directory.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.Dir

@Visible
@Export
@Dir(global = false)
var directory: String = "res://"
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.Dir;

@Visible
@Export
@Dir(global = false)
public String directory = "res://";
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.Dir

@Visible
@Export
@Dir(global = false)
var directory: String = "res://"
```

///

### `@ExpEasing` { #expeasing }

`attenuation`: boolean, default `false`; flips the curve when enabled. `isPositiveOnly`: boolean, default `true`; restricts editing to positive values.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.ExpEasing

@Visible
@Export
@ExpEasing(attenuation = false, isPositiveOnly = true)
var easing: Float = 1f
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.ExpEasing;

@Visible
@Export
@ExpEasing(attenuation = false, isPositiveOnly = true)
public float easing = 1f;
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.ExpEasing

@Visible
@Export
@ExpEasing(attenuation = false, isPositiveOnly = true)
var easing: Float = 1f
```

///

### `@File` { #file }

`extensions`: array of strings, default empty. Each string is a filter pattern. `global`: boolean, default `false`; enables filesystem paths instead of project paths.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.File

@Visible
@Export
@File("*.png", "*.jpg")
var imagePath: String = ""
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.File;

@Visible
@Export
@File(extensions = {"*.png", "*.jpg"})
public String imagePath = "";
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.File

@Visible
@Export
@File(extensions = Array("*.png", "*.jpg"))
var imagePath: String = ""
```

///

### `@FloatRange` { #floatrange }

`min`, `max`: required double-precision numbers. `step`: double, default `-1.0`. Also accepts every [shared range argument](#shared-range-arguments).

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.FloatRange

@Visible
@Export
@FloatRange(min = 0.0, max = 10.0)
var speed: Float = 2f
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.FloatRange;

@Visible
@Export
@FloatRange(min = 0.0, max = 10.0)
public float speed = 2f;
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.FloatRange

@Visible
@Export
@FloatRange(min = 0.0, max = 10.0)
var speed: Float = 2f
```

///

### `@HintString` { #hintstring }

`value`: required string. Replaces the generated hint string; does not choose a different Godot hint type. Use the format expected by that property's hint type.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.HintString

@Visible
@Export
@HintString("custom")
var label: String = ""
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.HintString;

@Visible
@Export
@HintString("custom")
public String label = "";
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.HintString

@Visible
@Export
@HintString("custom")
var label: String = ""
```

///

### `@IntFlag` { #intflag }

`names`: required array of flag labels (may be empty). Label positions correspond to bits. For enum-backed flags use `BitField<E>` instead.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.IntFlag

@Visible
@Export
@IntFlag("Player", "Enemy")
var mask: Int = 0
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.IntFlag;

@Visible
@Export
@IntFlag(names = {"Player", "Enemy"})
public int mask = 0;
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.IntFlag

@Visible
@Export
@IntFlag(names = Array("Player", "Enemy"))
var mask: Int = 0
```

///

### `@IntRange` { #intrange }

`min`, `max`: required 64-bit integers. `step`: integer, default `-1`. Also accepts every [shared range argument](#shared-range-arguments).

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.IntRange

@Visible
@Export
@IntRange(min = 0, max = 100)
var health: Int = 100
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.IntRange;

@Visible
@Export
@IntRange(min = 0, max = 100)
public int health = 100;
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.IntRange

@Visible
@Export
@IntRange(min = 0, max = 100)
var health: Int = 100
```

///

### `@MultilineText` { #multilinetext }

No arguments. Uses a multiline string input.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.MultilineText

@Visible
@Export
@MultilineText
var text: String = ""
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.MultilineText;

@Visible
@Export
@MultilineText
public String text = "";
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.MultilineText

@Visible
@Export
@MultilineText
var text: String = ""
```

///

### `@PlaceHolderText` { #placeholdertext }

No arguments. Sets Godot's placeholder-text hint. It has no text parameter, so the generated placeholder string is empty. Preserve the exact spelling `PlaceHolderText`.

/// tab | Kotlin

```kotlin
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.PlaceHolderText

@Visible
@Export
@PlaceHolderText
var text: String = ""
```

///

/// tab | Java

```java
import godot.annotation.Visible;
import godot.annotation.Export;
import godot.annotation.PlaceHolderText;

@Visible
@Export
@PlaceHolderText
public String text = "";
```

///

/// tab | Scala

```scala
import godot.annotation.Visible
import godot.annotation.Export
import godot.annotation.PlaceHolderText

@Visible
@Export
@PlaceHolderText
var text: String = ""
```

///

### Shared range arguments { #shared-range-arguments }

`IntRange` and `FloatRange` accept these arguments after `min`, `max`, and `step`:

| Argument | Type | Default | Effect in the Godot hint string |
|---|---|---|---|
| `or` | `Range` | `Range.NONE` | `OR_GREATER` adds `or_greater`; `OR_LESSER` adds `or_lesser`; `NONE` adds neither |
| `hideSlider` | boolean | `false` | Adds `hide_slider` |
| `isRadians` | boolean | `false` | Adds `radians` |
| `isDegrees` | boolean | `false` | Adds `degrees` |
| `isExp` | boolean | `false` | Adds `exp` |
| `suffix` | string | `"<none>"` | Adds `suffix:<value>` unless it equals the default sentinel |

A negative `step` is omitted from the generated hint. Godot interprets the resulting hint tokens. The annotations configure Inspector editing; they do not clamp assignments made by JVM code.

## Inspector groups { #inspector-groups }


Use `@Category`, `@Group`, and `@Subgroup` on the first property in a section. A category is the top-level section, a group is within a category, and a subgroup is within a group. They create Inspector markers before the annotated property; they do not change its type hint.

| Annotation | Parameters |
|---|---|
| `@Category(name)` | `name`: the category label shown in the Inspector. |
| `@Group(name, prefix = "")` | `name`: the group label. `prefix`: optional filter for following properties whose Godot names start with it; when omitted, it defaults to `name` with its first letter lowercased. |
| `@Subgroup(name, prefix = "")` | `name`: the subgroup label. `prefix`: optional filter for following properties whose Godot names start with it; when omitted, it defaults to `name` with its first letter lowercased. |

Write `prefix` in the same casing as your source property names. It is converted to the `snake_case` Godot property name automatically; for example, `movementGround` matches `movementGroundSpeed`, which Godot receives as `movement_ground_speed`.

```kotlin
@Script
class Player : Node() {
    @Category("Player")
    @Group("Movement") // Defaults to the `movement` prefix.
    @Subgroup("Ground", "movementGround")
    var movementGroundSpeed: Float = 5f

    @Export
    var movementGroundAcceleration: Float = 10f
}
```
