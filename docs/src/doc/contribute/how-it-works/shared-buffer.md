---
description: A per-thread buffer replaces most JNI calls between Godot and the JVM: its memory layout, the type ordinal table, and how oversized strings are handled.
---

# The JNI shared buffer

## General

The classical way of making the JVM and C++ code interact with each other is to use Java Native Interface (JNI).
JNI works well, but its overhead is too high when you wish to make a lot of small calls, especially when you wish
to call a method with a lot of parameters. A way to bypass this is to create a buffer that will be shared between
the two languages so we only have to write and read from that buffer to exchange data.

## Marshalls

The only data written in that buffer are the usual Godot types: primitives, strings, coreTypes, and objects.
We don't need a generic way of serializing data like *protobuff*. We tried that solution at first, but it was
too slow for an interprocess job. Writing data to the buffer is quite simple in C++, we just use the `Marshalls`
utility of the Godot Engine. On the Kotlin side, we just reimplement them from scratch.

## Memory

To avoid unnecessary locks, we create one buffer for each thread that works with both C++ and the JVM.
That way, one thread doesn't need to wait for another to finish its job with the buffer.
The buffer size is derived from the maximum inline string size and the maximum of 16 function arguments.
It also reserves 4 bytes for the argument count and another 16 bytes for an object method call's caller pointer and `ObjectID`.

## Strings

Strings are a special case because they can change their size dynamically.
We have set a maximum string size allowed in the buffer. If we go above it, it switches to a regular JNI call.
When it is done that way, the string is stored in a queue so we can retrieve the strings from it instead
of reading from the buffer. In most cases, you would rarely reach that maximum size in a video game.
Other dynamic types like `Array` and `Dictionary` are not an issue as only their pointers is sent to the JVM.

## Buffer structure

Regular argument lists begin with an `Int` that indicates the number of variables to read.
Each variable starts with another integer (the *ordinal*) indicating its type then followed by the relevant data of that type.

Object method calls use a distinct layout because the receiver is not a method argument:

```text
[caller pointer: Long][caller ObjectID: Long][argument count: Int][arguments...]
```

The native `icall` reader consumes the caller pointer and `ObjectID` directly before reading the regular argument list.

Objects sent from Kotlin to C++ use only their pointer. A null Kotlin object is encoded as a pointer of `0` (`nullptr`). Only an object method call's receiver includes an `ObjectID`, which `icall` checks against `ObjectDB` in debug builds.

The table below shows how each type is mapped to its ordinal number, giving a meaning to the passed data:

| type        | ordinal  | content                                                                                                          |
|-------------|----------|------------------------------------------------------------------------------------------------------------------|
| Nil         | 0        | <nothing>                                                                                                        |
| Bool        | 1        | Bool: 4 Bytes                                                                                                    |
| Int         | 2        | Long: 8 Bytes                                                                                                    |
| Real        | 3        | Double: 8 Bytes                                                                                                  |
| String      | 4        | Bool: 4Bytes, Dynamic: 512 Bytes at most (if Bool is set to true, empty otherwise)                               |
| Vector2     | 5        | x: Float: 4 Bytes, y: Float: 4 Bytes                                                                             |
| Rect2       | 6        | position : Vector2: 8 Bytes, size : Vector2: 8 Bytes                                                             |
| Vector3     | 7        | x: Float: 4 Bytes, y: Float: 4 Bytes, z: Float: 4 Bytes                                                          |
| Transform2D | 8        | x: Vector2: 8 Bytes, y: Vector2: 8 Bytes, origin: Vector2: 8 Bytes                                               |
| Plane       | 9        | normal: Vector3: 12 Bytes, d: Float: 4 Bytes                                                                     |
| Quat        | 10       | x: Float: 4 Bytes, y: Float: 4 Bytes, z: Float: 4 Bytes, w: Float: 4 Bytes                                       |
| AABB        | 11       | position : Vector3: 12 Bytes, size : Vector3: 12 Bytes                                                           |
| Basis       | 12       | x : Vector3: 12 Bytes, y : Vector3: 12 Bytes, z : Vector3: 12 Bytes                                              |
| Transform   | 13       | basis: Basis: 36 Bytes, origin: Vector3: 12 Bytes                                                                |
| Color       | 14       | red: Float: 4 Bytes, green: Float: 4 Bytes, blue: Float: 4 Bytes, alpha: Float: 4 Bytes                          |
| NodePath    | 15       | pointer: ptr: 8 Bytes                                                                                            |
| RID         | 16       | pointer: ptr: 8 Bytes                                                                                            |
| Object      | 17       | pointer: ptr: 8 Bytes, JVM_constructor_index: Int: 4 Bytes, isReference: Bool: 4 Bytes, object_id: Long: 8 Bytes |
| Dictionnary | 18       | pointer: ptr: 8 Bytes                                                                                            |
| Array       | 19       | pointer: ptr: 8 Bytes                                                                                            |
| PoolXArray  | 20 to 27 | pointer: ptr: 8 Bytes                                                                                            |
