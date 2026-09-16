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

Two native entry points read this layout. `icallPtr` uses the unchecked `object_method_bind_ptrcall`: each argument the buffer holds in native layout (booleans, numbers, math types, `RID`, object pointers) is copied to the call's own stack, since a nested JVM call from inside the engine call would rewrite the buffer, and the pointer-backed core types such as `StringName` or `Array` pass the pointer to the object the JVM owns; the return type is passed as a JNI argument so the value can be copied back behind its tag (`read_ptr_args` and `write_ptr_return` in `cpp/jvm/wrapper/memory/transfer_context.cpp`). `icall` decodes every argument into a `Variant` and uses the checked `object_method_bind_call` (`read_variant` and `write_variant` in the same file); the generator picks it for variadic methods and for any method whose arguments or return include a type the ptrcall table does not cover: `String`, `Callable`, `Signal` and `Variant`. Both consume the caller pointer and `ObjectID` directly before reading the argument list.

The return type `icallPtr` receives is a `Variant::Type` ordinal with one extra value: `VARIANT_MAX` (`39` today, read by the generator from `TYPE_MAX` in `api.json`), which is never a real type tag. The generator sends it instead of `OBJECT` when the method's declared return class inherits `RefCounted`. Such a method returns a `Ref<T>` in the engine, and a ptrcall encodes it by assigning that `Ref` over the caller's return slot, leaving an owned reference there; a method declared as returning a plain `Object*` stores only the pointer. The two cases leave identical bytes, and GDExtension offers no way to ask a method bind for its return type, so the declared type from `api.json` is the only source of truth. On the native side the return slot starts null, since the `Ref` assignment releases whatever the slot held before; the object is bound to the JVM, which takes the JVM's own reference on first delivery; then the engine's reference is released, standing in for the destructor of a `Ref` local that never existed. The native `TransferContext` defines it as `REF_COUNTED_RETURN_TYPE`, equal to `Variant::VARIANT_MAX`, so both sides follow a new Variant type automatically; the generator also checks `TYPE_MAX` against its own ordinal table and fails if they disagree.

Objects sent from Kotlin to C++ use only their pointer. A null Kotlin object is encoded as a pointer of `0` (`nullptr`). Only an object method call's receiver includes an `ObjectID`, which the native call checks against `ObjectDB` in debug builds.

Type tags follow Godot's `Variant::Type` ordinals. The table below describes C++-to-JVM payloads, excluding the 4-byte tag. The reverse direction uses only a native pointer for objects and collections. The per-type rows in `cpp/jvm/buffer_wire.h` define the wire format, and `transfer_context.cpp` builds its dispatch tables from them.

| Type | Ordinal | Payload |
|---|---|---|
| Nil | 0 | None |
| Bool | 1 | 1-byte boolean |
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
| Dictionary, Array | 27, 28 | 8-byte native pointer; element converters come from the JVM declaration, never from the engine's typed builtin |
| Packed arrays | 29 to 38 | 8-byte native pointer |

Mathematical values use their native component layout. Integer components are 4 bytes; real-valued components follow the build's precision. The JVM and native converters must agree on that layout.

## Value copies

Mathematical values such as `Vector3` are serialized as components in the shared buffer and reconstructed as JVM values. A getter does not return a view into the native property. Changing those components affects only the reconstructed value until a setter transfers them back. Container wrappers instead carry native pointers and share storage, while value-type elements retrieved from them still cross the buffer by value.

## Exceptions at the JNI boundary

Registered function and property wrappers catch `Throwable` on the JVM side. `KtFunction.invokeWithReturn()` and `KtProperty.callGet()` log the stack trace and write a nil Variant into the return buffer on failure; setters and void calls log the failure without a return value.

For exceptions that reach JNI, JNI leaves a pending throwable when JVM code throws across a native call. `jni::Env::handle_exception()` obtains and clears it, then invokes the handler installed by `JvmManager`. `GodotPrintBridge::print_exception_stacktrace()` asks the JVM for the formatted stack trace and reports it through Godot. The exception does not unwind Godot's C++ stack; the boundary returns its default result and engine execution continues. Before the handler is installed, JNI describes and clears the exception directly.
