---
description: Variant mappings, supported registered signatures, primitive and generic types, copies, collections, enums, bitfields, and name conversions.
---

# Types and conversions

## Registered signatures

| Value family | Property | Function parameter / return |
|---|---|---|
| Boolean, Byte, Short, Int, Long, Float, Double, String | Supported | Supported |
| Dynamic Variant (`Any` / `Object`) | Supported | Supported |
| Core Godot types | Supported | Supported |
| `Node` or `Resource` subclass | Supported | Supported |
| Other `godot.api.Object` subclasses | Not a supported property type | Supported |
| JVM enum | Supported | Supported |
| `BitField<E>` | Supported when `E` is an enum | Supported |
| JVM collection of enums | Supported as an enum-list property | Not supported |
| No result (`Unit` / `void`) | Not a property value | Return only |
| Arbitrary JVM classes, JVM arrays, generic type parameters | Not supported | Not supported |

Container element types must also be representable. `Any`/`Object` does not make an arbitrary JVM instance serializable to a Godot Variant. Primitive, string, and core-type properties must not be nullable; Node and Resource references may be null.

## Type names

These are accepted JVM representations, including narrower numeric types; they do not imply equal range or precision.

/// tab | Kotlin

| Godot | Kotlin |
|---|---|
| bool | `Boolean` |
| int (signed 64-bit) | `Byte, Short, Int, Long` |
| float (64-bit) | `Float, Double` |
| String | `String` |
| Variant / dynamic value | `Any?` |
| Object reference | `Node?, Resource?, or another supported class` |
| Array | `VariantArray<T>` |
| Dictionary | `Dictionary<K, V>` |
| No return value | `Unit` |

///

/// tab | Java

| Godot | Java |
|---|---|
| bool | `boolean / Boolean` |
| int (signed 64-bit) | `byte, short, int, long / boxed equivalents` |
| float (64-bit) | `float, double / boxed equivalents` |
| String | `String` |
| Variant / dynamic value | `java.lang.Object` |
| Object reference | `Node, Resource, or another supported class (nullable)` |
| Array | `VariantArray<T>` |
| Dictionary | `Dictionary<K, V>` |
| No return value | `void` |

Use boxed primitives in generic arguments, such as `VariantArray<Integer>`. `godot.api.Object` is the engine base class; `java.lang.Object` is the dynamic Variant carrier.

///

/// tab | Scala

| Godot | Scala |
|---|---|
| bool | `Boolean` |
| int (signed 64-bit) | `Byte, Short, Int, Long` |
| float (64-bit) | `Float, Double` |
| String | `String` |
| Variant / dynamic value | `Any` |
| Object reference | `Node, Resource, or another supported class (nullable)` |
| Array | `VariantArray[T]` |
| Dictionary | `Dictionary[K, V]` |
| No return value | `Unit` |

Use boxed types such as `Integer` and `java.lang.Boolean` in generic arguments when registration needs concrete primitive metadata. Scala primitive generic arguments can erase to `Object`.

///

Narrower numeric types can lose range or precision when receiving Godot values. `Char` is not a registered primitive; use a string or integer instead.

### Core types

Use the same class names from `godot.core` in each language:

- Math: `Vector2`, `Vector2i`, `Vector3`, `Vector3i`, `Vector4`, `Vector4i`, `Rect2`, `Rect2i`, `Transform2D`, `Transform3D`, `Plane`, `Quaternion`, `AABB`, `Basis`, `Projection`, `Color`.
- Names and handles: `StringName`, `NodePath`, `RID`.
- Containers: `VariantArray`, `Dictionary`, `PackedByteArray`, `PackedInt32Array`, `PackedInt64Array`, `PackedFloat32Array`, `PackedFloat64Array`, `PackedStringArray`, `PackedVector2Array`, `PackedVector3Array`, `PackedVector4Array`, `PackedColorArray`.
- Callbacks: `Signal` and `Callable` families.

## Copies and shared storage

Core value types read from Godot properties are copies. Mutating the copy affects the property only after assignment back. `VariantArray` and `Dictionary` share container storage with Godot, but reading a value-type element still returns a copy.

/// tab | Kotlin

```kotlin
import godot.api.Node3D

val node = Node3D()
val rotation = node.rotation
rotation.y += 1.0
node.rotation = rotation
// Kotlin also provides node.rotationMutate { y += 1.0 }.
```

///

/// tab | Java

```java
import godot.api.Node3D;

Node3D node = new Node3D();
var rotation = node.getRotation();
rotation.setY(rotation.getY() + 1.0);
node.setRotation(rotation);
```

///

/// tab | Scala

```scala
import godot.api.Node3D

val node = new Node3D()
val rotation = node.getRotation()
rotation.setY(rotation.getY() + 1.0)
node.setRotation(rotation)
```

///

The same write-back rule applies to collection elements: `get`, mutate, then `set`. Kotlin additionally provides `array.mutate(index) { ... }` and `dictionary.mutate(key) { ... }` in `godot.core`.

## StringName and NodePath

Keep names and paths as ordinary strings while building or passing them around. Converting a `String` to a `StringName` or `NodePath` costs more than using the string itself. When code uses the same name or path repeatedly, convert it once with a cached helper and reuse the result.

| Operation | Effect |
|---|---|
| `asCachedStringName` | Cached interned name; preserves spelling |
| `asCachedNodePath` | Cached node path; preserves spelling |
| `toGodotName` | Converts a member name to `snake_case` and returns a `StringName` |

/// tab | Kotlin

```kotlin
import godot.core.asCachedStringName
import godot.core.asCachedNodePath
import godot.core.toGodotName

val name = "Player".asCachedStringName()
val path = "Player/Camera".asCachedNodePath()
val method = "takeDamage".toGodotName()
```

///

/// tab | Java

```java
import godot.core.StringNames;
import godot.core.NodePaths;

var name = StringNames.asCachedStringName("Player");
var path = NodePaths.asCachedNodePath("Player/Camera");
var method = StringNames.toGodotName("takeDamage");
```

///

/// tab | Scala

```scala
import godot.core.{StringNames, NodePaths}

val name = StringNames.asCachedStringName("Player")
val path = NodePaths.asCachedNodePath("Player/Camera")
val method = StringNames.toGodotName("takeDamage")
```

///

## Enums and bitfields

!!! warning "Scala enums"
    Plain Scala 3 `enum` types are not recognized for registration. Extend `java.lang.Enum[YourEnum]`.

A registered enum property automatically receives an Inspector dropdown. Ordinary JVM enums use their ordinal as the numeric value. `GodotEnum` permits custom values; the numeric accessor is `value` in Kotlin and `getValue()` in Java/Scala.

A `BitField<E>` holds a flag mask for enum `E`. Ordinary enum entries use `1L << ordinal`; `GodotEnum` entries use their explicit value as the mask. Exported bitfields support at most 32 entries. Engine bitfield wrapper types cannot be exported directly as properties; use `BitField<E>` with an enum.

This complete script exports one property of each kind: a regular enum dropdown, a `GodotEnum` dropdown with explicit values, and a `BitField` checkbox group.

/// tab | Kotlin

```kotlin
import godot.annotation.Export
import godot.annotation.Script
import godot.api.Node
import godot.core.BitField
import godot.core.GodotEnum

@Script
class Player : Node() {
    enum class Element { FIRE, WATER, EARTH }

    enum class DamageType(override val value: Long) : GodotEnum {
        PHYSICAL(10), FIRE(20), MAGIC(30)
    }

    @Export
    var element: Element = Element.FIRE

    @Export
    var damageType: DamageType = DamageType.PHYSICAL

    @Export
    var elements: BitField<Element> = BitField.of(Element.FIRE, Element.WATER)
}
```

///

/// tab | Java

```java
import godot.annotation.Export;
import godot.annotation.Script;
import godot.api.Node;
import godot.core.BitField;
import godot.core.GodotEnum;

@Script
public class Player extends Node {
    public enum Element { FIRE, WATER, EARTH }

    public enum DamageType implements GodotEnum {
        PHYSICAL(10), FIRE(20), MAGIC(30);

        private final long value;

        DamageType(long value) {
            this.value = value;
        }

        @Override
        public long getValue() {
            return value;
        }
    }

    @Export
    public Element element = Element.FIRE;

    @Export
    public DamageType damageType = DamageType.PHYSICAL;

    @Export
    public BitField<Element> elements = BitField.of(Element.FIRE, Element.WATER);
}
```

///

/// tab | Scala

```scala
import godot.annotation.{Export, Script}
import godot.api.Node
import godot.core.{BitField, GodotEnum}

@Script
class Player extends Node {
  enum Element extends java.lang.Enum[Element] {
    case FIRE, WATER, EARTH
  }

  enum DamageType(val v: Long) extends java.lang.Enum[DamageType], GodotEnum {
    case PHYSICAL extends DamageType(10)
    case FIRE extends DamageType(20)
    case MAGIC extends DamageType(30)

    override def getValue(): Long = v
  }

  @Export
  var element: Element = Element.FIRE

  @Export
  var damageType: DamageType = DamageType.PHYSICAL

  @Export
  var elements: BitField[Element] = BitField.of(Element.FIRE, Element.WATER)
}
```

///

`BitField` exposes `or`, `and`, `xor`, `contains`, `inv`, `shl`, `shr`, and `ushr`. Operations return a new wrapper. The numeric mask is `flag` in Kotlin or `getFlag()` in Java/Scala. The Inspector uses the explicit `GodotEnum` values for its dropdown and bitfield masks.

A collection of enums on a property receives an enum-list hint. It does not make general JVM collections a replacement for `VariantArray` in registered function signatures. See [property registration](../registration/properties.md).
