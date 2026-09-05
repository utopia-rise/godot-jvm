---
description: Field and accessor selection, export, nullability, and initialization rules for Kotlin, Java, and Scala properties.
---

# Properties

## Selection and Inspector export

| Mode | Registered property | Exported property |
|---|---|---|
| Inferred | `@Visible`, `@Export`, or a property hint | `@Export` or a property hint |
| Explicit | Direct `@Visible` | Direct `@Visible` plus direct `@Export` |
| Automatic | Public compatible property | Every selected property |

Property annotations belong to `godot.annotation`. A field must be public when there are no accessors. When accessors exist, every present getter/setter must be public. A private backing field can be exposed through public accessors.

## Declaration forms

These forms register and export `health` in all three modes:

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

## Accessors and function intent

Property shape and function selection are separate. Annotation placement must be legal for the source language: `@Visible`/`@Export` target properties or fields; `@Register` targets methods.

| Resolved annotations | Accessor treatment |
|---|---|
| No `@Register` on an accessor | Property candidate; still needs selection by the current mode |
| `@Register` on an accessor, no resolved `@Visible` on the property | Callable function; property suppressed |
| `@Register` on an accessor and resolved `@Visible` on the property | Both property and function |

/// tab | Kotlin

```kotlin
@Visible
var health: Int = 100

@Register
fun currentHealth(): Int = health
// Registers health and current_health as distinct declarations.
```


`var` supplies a getter and setter; `val` supplies only a getter. Computed properties are recognized through Kotlin metadata. Apply property annotations to the property. `@Register` cannot target a Kotlin property accessor; expose a separate named function when a callable method is needed. A private setter makes the property ineligible.

///

/// tab | Java

```java
@Visible
private int health = 100;

@Register
public int getHealth() { return health; }
public void setHealth(int value) { health = value; }
// Registers health and get_health; no Inspector export in Inferred/Explicit.
```


Recognized accessor forms are `T getX()`, `boolean/Boolean isX()`, and `void setX(T value)`. The first character of `X` is lowercased to obtain the logical property name. Field and accessor types must agree. Put property annotations on the backing field; a fieldless getter can be selected as a property in Automatic mode or as a function with `@Register`.

///

/// tab | Scala

```scala
@Visible
var storedHealth: Int = 100

@Register
def getHealth(): Int = storedHealth
// Registers stored_health and get_health as distinct declarations.
```


`var x` compiles to `x()` and `x_$eq(value)`; `val x` supplies only `x()`. A no-argument non-void `def` can also look like a property getter. Add `@Register` when it must be exposed as a function. Primitive types in generic signatures may erase to `Object`; use boxed types where a concrete Godot element type is required.

///

## Types and initialization

Registered properties accept Variant-compatible values, core Godot types, `Node`/`Resource` references, enums, `BitField<E>`, and supported enum collections. See [types and conversions](../binding/types.md) for the precise distinction between property and method types.

Primitive, string, and core-type properties cannot be nullable. Kotlin primitive/core-type properties cannot be `lateinit`; initialize them. Node and Resource references may be null. `Any`/`Object` allows a dynamic Variant value, not arbitrary JVM objects.

A getter-only or final property has no setter available to Godot. It does not become writable by adding `@Export`.

## Inspector hints

A property can have at most one hint. Enum and bitfield hints are also generated from the property type, so an extra incompatible hint is not a way to combine Inspector controls. Hint/type mismatches fail registration validation. See [Property hints](../annotations.md#property-hints).

## Single enum (dropdown)

Declare a property whose type is an enum:

/// tab | Kotlin
```kotlin
enum class Element { FIRE, WATER, EARTH }

@Script
class Player : Node() {
    @Export
    var element = Element.FIRE
}
```
///
/// tab | Java
```java
public enum Element { FIRE, WATER, EARTH }

@Script
public class Player extends Node {
    @Export
    public Element element = Element.FIRE;
}
```
///
/// tab | Scala
!!! warning "Scala enums"
    Plain Scala 3 `enum` types are not recognized.
    For registration and `BitField`, use a Scala enum that extends `java.lang.Enum[YourEnum]`.

```scala
enum Element extends java.lang.Enum[Element] {
  case FIRE, WATER, EARTH
}

@Script
class Player extends Node {
  @Export
  var element: Element = Element.FIRE
}
```
///

## Bitfield (flags)

Use `BitField<MyEnum>` (from `godot.core`) when several enum values can be selected at once:

/// tab | Kotlin
```kotlin
@Export
var elements: BitField<Element> = BitField.of(Element.FIRE, Element.WATER)
```
///
/// tab | Java
```java
@Export
public BitField<Element> elements = BitField.of(Element.FIRE, Element.WATER);
```
///
/// tab | Scala
```scala
@Export
var elements: BitField[Element] = BitField.of(Element.FIRE, Element.WATER)
```
///

For regular enums, each constant gets the bit at its ordinal (`1 << ordinal`).

## List of enums

Any `Collection<MyEnum>`, such as `List` or `Set`, becomes a resizable list where each element is a dropdown:

/// tab | Kotlin
```kotlin
@Export
var elements = listOf(Element.FIRE)
```
///
/// tab | Java
```java
@Export
public java.util.List<Element> elements = new java.util.ArrayList<>(java.util.List.of(Element.FIRE));
```
///
/// tab | Scala
```scala
@Export
var elements: java.util.List[Element] = new java.util.ArrayList(java.util.List.of(Element.FIRE))
```
///

## Inspector values

Saved Inspector values are applied after construction and before `_enter_tree()`. Initializers supply defaults; read the saved values in `_ready()`. Exported core-type fields need an initial value or the build fails.

## Node, Resource, and container exports

The following members use Inferred mode. `Texture2D` is a `Resource` subclass.

/// tab | Kotlin

```kotlin
@Export var health: Int = 100
@Export var speed: Double = 200.0
@Export var playerName: String = "Player"
@Export var active: Boolean = true
@Export var direction: Vector2 = Vector2()
@Export var target: Node? = null
@Export var texture: Texture2D? = null
@Export var checkpoints: VariantArray<Vector2> = VariantArray()
@Export var scores: Dictionary<String, Int> = Dictionary()
```

///

/// tab | Java

```java
@Export public int health = 100;
@Export public double speed = 200.0;
@Export public String playerName = "Player";
@Export public boolean active = true;
@Export public Vector2 direction = new Vector2();
@Export public Node target = null;
@Export public Texture2D texture = null;
@Export public VariantArray<Vector2> checkpoints = new VariantArray<>(Vector2.class);
@Export public Dictionary<String, Integer> scores = new Dictionary<>(String.class, Integer.class);
```

///

/// tab | Scala

```scala
@Export var health: Int = 100
@Export var speed: Double = 200.0
@Export var playerName: String = "Player"
@Export var active: Boolean = true
@Export var direction: Vector2 = new Vector2()
@Export var target: Node = null
@Export var texture: Texture2D = null
@Export var checkpoints: VariantArray[Vector2] = new VariantArray[Vector2](classOf[Vector2])
@Export var scores: Dictionary[String, Integer] = new Dictionary[String, Integer](classOf[String], classOf[Integer])
```

///
