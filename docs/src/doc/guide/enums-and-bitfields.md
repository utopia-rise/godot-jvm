---
description: Registering single enums, BitField flag sets, and enum lists as Inspector-visible properties, and using GodotEnum to control the underlying integer values.
---

# Enums, bitfields and flags

Enums and flags are registered **from the property type** — you usually don't need any hint annotation.


| Property type            | Inspector widget                       |
|--------------------------|----------------------------------------|
| `MyEnum`                 | a dropdown to pick a single value      |
| `BitField<MyEnum>`       | a checkbox grid (bitmask / flags)      |
| any `Collection<MyEnum>` | a resizable list of enum dropdowns     |

This works the same in Kotlin, Java and Scala.

!!! warning "Scala enums"
    Plain Scala 3 `enum` types are not recognized.
    For registration and `BitField`, use a Scala enum that extends `java.lang.Enum[YourEnum]`.

## Single enum (dropdown)

Declare a property whose type is an enum:

/// tab | Kotlin
```kotlin
enum class Element { FIRE, WATER, EARTH }

@Script
class Spell : Node() {
    @Export
    var element = Element.FIRE
}
```
///
/// tab | Java
```java
public enum Element { FIRE, WATER, EARTH }

@Script
public class Spell extends Node {
    @Export
    public Element element = Element.FIRE;
}
```
///
/// tab | Scala
```scala
enum Element extends java.lang.Enum[Element] {
  case FIRE, WATER, EARTH
}

@Script
class Spell extends Node {
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

Regular enums use `1 shl ordinal`. A [`GodotEnum`](#custom-values) uses its explicit value as the mask.

## List of enums

Any `Collection<MyEnum>` (`List`, `Set`, …) becomes a resizable list where each element is a dropdown:

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

By default an enum constant's Inspector value is its ordinal. To control the exact integers — to match a
Godot engine enum, or to choose specific flag bits — implement `GodotEnum` (from `godot.core`):

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

The dropdown, enum list, and `BitField` then use those exact values.
