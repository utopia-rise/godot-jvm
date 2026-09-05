---
description: Registering single enums, BitField flag sets, and enum lists as Inspector-visible properties, and using GodotEnum to control the underlying integer values.
---

# Enums, bitfields and flags

For an exported enum or flag property, Godot-JVM chooses the Inspector control from its type. No additional hint annotation is needed.

| Property type            | Inspector widget                       |
|--------------------------|----------------------------------------|
| `MyEnum`                 | a dropdown to pick a single value      |
| `BitField<MyEnum>`       | a checkbox grid (bitmask / flags)      |
| any `Collection<MyEnum>` | a resizable list of enum dropdowns     |

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

For regular enums, each constant gets the bit at its ordinal (`1 shl ordinal`).

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

## Custom values

By default an enum constant's Inspector value is its ordinal. To control the exact integers, to match a
Godot engine enum or choose specific flag bits, implement `GodotEnum` (from `godot.core`):

/// tab | Kotlin
```kotlin
enum class Element(override val value: Long) : GodotEnum {
    FIRE(2), WATER(8), EARTH(16)
}
```
///
/// tab | Java
```java
public enum Element implements GodotEnum {
    FIRE(2), WATER(8), EARTH(16);

    private final long value;

    Element(long value) {
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }
}
```
///
/// tab | Scala
```scala
enum Element(val v: Long) extends java.lang.Enum[Element], GodotEnum {
  case FIRE  extends Element(2)
  case WATER extends Element(8)
  case EARTH extends Element(16)

  override def getValue(): Long = v
}
```
///

The Inspector dropdowns and `BitField` masks use the values you supply.
