---
description: How the per-thread JNI buffer carries arguments and return values, including type tags, native payloads, and oversized strings.
---

# The JNI shared buffer

## General

Godot-JVM uses JNI to cross between C++ and the JVM. To reduce per-argument conversion overhead, it exchanges most call data through a shared buffer. Both sides read and write the same memory before transferring control through JNI.

## Marshalling

The buffer carries Godot Variant types: primitives, strings, mathematical values, and native object references. A dedicated binary format avoids the overhead of a general-purpose serializer. C++ uses the marshalling helpers in `cpp/engine/marshalls.h`; JVM converters implement the matching layout.

## Memory

Each thread that crosses between C++ and the JVM owns one buffer, so no thread waits for another.
The buffer size is derived from the maximum inline string size and the maximum of 16 function arguments.
It also reserves 4 bytes for the argument count and another 16 bytes for an object method call's caller pointer and `ObjectID`.

## Strings

Strings up to the configured inline limit are written into the buffer. Larger strings travel through JNI and a queue; a flag tells the receiver which path to read. The default inline limit is 512 bytes.

Collections use native pointers rather than copying their contents into the buffer, so their length does not affect buffer capacity.

## Buffer structure

Regular argument lists begin with an `Int` that indicates the number of variables to read.
Each variable starts with another integer (the *ordinal*) indicating its type then followed by the relevant data of that type.

Object method calls use a distinct layout because the receiver is not a method argument:

```text
[caller pointer: Long][caller ObjectID: Long][argument count: Int][arguments...]
```

The native `icall` reader consumes the caller pointer and `ObjectID` directly before reading the regular argument list.

Objects sent from Kotlin to C++ use only their pointer. A null Kotlin object is encoded as a pointer of `0` (`nullptr`). Only an object method call's receiver includes an `ObjectID`, which `icall` checks against `ObjectDB` in debug builds.

Type tags follow Godot's `Variant::Type` ordinals. The table below describes C++-to-JVM payloads, excluding the 4-byte tag. The reverse direction uses only a native pointer for objects and collections. The readers and writers in `cpp/jvm/jvm_variant.h` define the wire format.

| Type | Ordinal | Payload |
|---|---|---|
| Nil | 0 | None |
| Bool | 1 | 4-byte boolean |
| Int | 2 | 8-byte integer |
| Float | 3 | 8-byte double |
| String | 4 | 4-byte long-string flag; inline strings also carry a 4-byte byte count and UTF-8 data |
| Vector2, Vector2i | 5, 6 | Two components |
| Rect2, Rect2i | 7, 8 | Position and size, each with two components |
| Vector3, Vector3i | 9, 10 | Three components |
| Transform2D | 11 | Three two-component vectors |
| Vector4, Vector4i | 12, 13 | Four components |
| Plane | 14 | Three-component normal and distance |
| Quaternion | 15 | Four components |
| AABB | 16 | Three-component position and size |
| Basis | 17 | Three three-component vectors |
| Transform3D | 18 | Basis and three-component origin |
| Projection | 19 | Four four-component vectors |
| Color | 20 | Four 4-byte floats |
| StringName, NodePath | 21, 22 | 8-byte native pointer |
| RID | 23 | 8-byte resource ID |
| Object | 24 | 4-byte constructor ID, 8-byte native pointer, 8-byte ObjectID |
| Callable | 25 | 8-byte native pointer |
| Signal | 26 | Object payload followed by an 8-byte pointer to its StringName |
| Dictionary | 27 | 8-byte native pointer and two 8-byte type tags for keys and values |
| Array | 28 | 8-byte native pointer and 8-byte element type tag |
| Packed arrays | 29 to 38 | 8-byte native pointer |

Mathematical values use their native component layout. Integer components are 4 bytes; real-valued components follow the build's precision. The JVM and native converters must agree on that layout.
