---
description: How the two per-thread JNI buffers carry arguments and return values, why one is rewound and the other stacked, and how values are encoded.
---

# The JNI shared buffers

## General

Godot-JVM uses JNI to cross between C++ and the JVM. Passing each argument as a JNI call of its own would cost more
than the work most calls do, so instead both sides agree on a block of memory and a binary layout: the caller writes
the arguments, crosses through a single JNI call, and the callee reads them back on the other side.

Every thread that crosses between C++ and the JVM owns its own buffers, so no thread ever waits for another and no
locking is involved.

## Two buffers, two lifetimes

There are two buffers because call data has two very different lifetimes.

Most of the time the receiving side decodes the arguments the moment it is handed control, turning them into its own
`Variant`s or JVM objects. The buffer is scratch space: once decoded, nothing cares what happens to those bytes.

An unchecked engine call is different. It does not decode anything — it hands the engine pointers straight into the
buffer and lets the engine read the values where they lie. The bytes therefore have to stay untouched for the whole
duration of the call, and an engine call is not a leaf: it can run script code, emit a signal, or invoke a
`Callable`, all of which reenter the JVM, which can call the engine again.

That gives the two designs: a buffer that is **reset before every use** because nothing outlives the crossing, and a
buffer that is **stacked** because data must outlive the crossing that wrote it.

## The variant buffer

The mental model is a countertop that is wiped before each use. Every exchange starts by rewinding to the beginning,
writes what it needs, crosses, and the receiver reads it back from the beginning.

It carries everything except unchecked engine calls:

- **Bridge calls**, where JVM code asks the native side to operate on a core type it owns, such as appending to an
  `Array` or comparing two `StringName`s.
- **Checked engine calls**, which decode their arguments into real `Variant`s before handing them to the engine.
- **Calls from the engine into JVM code**: script method overrides, property getters and setters, signal handlers.
  The one exception is `_process` and `_physics_process`, which the engine calls every frame on every node: the
  registrar generator registers them as a `KtProcess` held by the class itself rather than as functions, and the
  native side passes `delta` as a JNI argument to its entry instead of writing it to the buffer, whether the engine
  or a call by name reaches it.

The discipline that makes a single shared countertop safe is that **the receiver copies out before doing anything
else**. By the time anything nested could reuse the buffer, the outer call has already taken what it needed, so
reentrancy cannot corrupt it. The cost is a copy per value, which is the right trade for the checked path since it
was going to build a `Variant` anyway.

Because the data only has to survive until it is decoded, this buffer can carry values of any shape, including
strings. It is sized for a single call: the maximum number of arguments, each at the size of the largest kind of
value, which is a string at the inline limit.

Unlike the value buffer, this one does keep a native cursor per thread, and that cursor has to stay **trivially
constructible and trivially destructible**. A `thread_local` of such a type is zero-initialised; one that needs code
to run before first use, or after last use, makes the compiler guard every access to that storage with a flag check
and a call to `__dyn_tls_on_demand_init`, on a path taken millions of times a second. Leaving the members without initialisers is
what keeps the defaulted constructor trivial, and declaring the variable `constinit` with no initialiser is what turns
a later member initialiser into a build failure rather than a quietly restored guard. MSVC rejects every other form
there: `= {}`, a `constexpr` constructor, member initialisers, in a header or in a `.cpp`.

Clangd reports that declaration as *"variable does not have a constant initializer"*, because it wants a `constexpr`
constructor where MSVC wants a trivial one, and a defaulted constructor cannot be both — `constexpr` has to initialise
every member, trivial has to initialise none. The form every compiler this project builds with accepts is the one that
wins. `jni::Env` has the same shape and the same diagnostic.

Per-thread state that has to be *freed* cannot meet that bar, because freeing is a destructor. The checked path's
scratch stack of `Variant`s is that case: too large to give every thread, so a thread allocates it on its first
checked call and must release it when it ends. `ThreadOwned<T>` in `cpp/jvm/memory/thread_owned.h` keeps the two
halves in two thread-locals — a `constinit` bare pointer that every access reads with no guard, and an empty object
touched only by the once-per-thread allocation, which exists solely so that a destructor runs at thread exit. Giving
the pointer the destructor instead measured at 37 instructions and two tests per access against 8 and one, and a
pointer with no destructor was the only form that matched, by leaking the stack of every thread that ever made a
checked call.

## The value buffer

The mental model is a call stack. Each unchecked engine call in flight on a thread owns a frame, pushed and popped
exactly as native stack frames are.

A frame holds the call's arguments and, right after them, the slot the engine writes its result into. Both are
reserved before the call starts, so the engine reads its arguments and writes its return directly in memory the JVM
can see. Nothing is copied on either side, which is the entire point of this path.

The frame must survive the call because the engine reads from it throughout, so a nested call cannot be allowed to
reuse those bytes. Stacking is what guarantees that: an engine call that reenters JVM code that calls the engine
again simply gets the next frame up.

Frames are packed: one begins where the previous one ended, so a call consumes only what it writes. Every value on
this path has a bounded size, because an unchecked call never carries a string — the engine has no native layout to
read one from, so any method involving a string takes the checked path instead — which is what makes a frame's extent
known as soon as its arguments are written.

A frame's own offset and the offset of its return record are the caller's business, and the caller already has a
place to keep them: the JVM stack frame of the generated call, one of which exists per live call by construction. The
only state the stack itself keeps is where the next frame begins.

Every unchecked call is started by the JVM, so the JVM is also the side that says **where** its buffer is: it asks the
native side once, when it creates a thread's stack, for the address the direct buffer starts at, and then passes that
address to each call alongside the frame offset. The native side therefore keeps nothing of its own per thread — no
thread-local, no lazily claimed buffer — and builds its cursor on the C++ stack from the two numbers it was handed.
Resolving thread-local storage twice per call, once on each side, was pure duplication: the JVM had already done it to
write the arguments.

Keeping the buffer within bounds is the JVM's job for the same reason. It sizes the stack for the worst case a frame
can reach, checks in a debug build that the frame it is about to open still fits, and cannot overrun it on the way in
because every `ByteBuffer` write is bounds checked whatever the build. The native side carries no capacity and reports
no overrun: the only thing such a check could still catch is this side misreading a region the JVM wrote correctly,
which is a bug in the binding rather than something a user can provoke.

The `value_buffer_size_factor` setting in the [runtime configuration](../../reference/runtime-configuration.md) sizes
the whole stack, counted in frames that are entirely full, four by default. Since real calls are much smaller than
that, far more than four of them nest before the room runs out. Running out is checked on the JVM side and only in
debug builds, as the check would otherwise sit in the hottest path in the binding.

## Choosing between the two

The choice is made once, when the bindings are generated, not at runtime. A method takes the unchecked path when
every one of its arguments and its return value has a native layout the engine can read in place: booleans, numbers,
mathematical types, `RID`, object pointers, and the pointer-backed core types such as `StringName`, `Array` or the
packed arrays, which travel as a pointer to the instance the JVM owns.

Anything else takes the checked path: variadic methods, and any method mentioning `String`, `Callable`, `Signal` or
an untyped `Variant`. The generated call therefore names its buffer directly, and the runtime never has to decide.

## Call layout

An argument list begins with the number of values in it. Each value is then a type *ordinal* in an eight-byte slot
followed by that type's payload, both aligned on eight bytes so that the engine can read a payload where it lies
without a misaligned load.

A call on an object needs its receiver, which is not one of the method's arguments, so it carries a header first:

```text
[caller pointer: Long][caller ObjectID: Long][argument count: Int][arguments...]
```

The `ObjectID` travels alongside the pointer so debug builds can check it against `ObjectDB` and report a call on an
object that was already freed, rather than dereferencing a dangling pointer.

Objects sent from the JVM to C++ carry only their pointer, and a null object is a pointer of `0`.

A **return** is written after the arguments, on the next eight-byte boundary, and it carries a tag only on the checked
path. There, C++ writes the runtime type of the `Variant` the engine produced, which is information the JVM does not
otherwise have: a method declared as returning a `Variant` discovers its type from the tag, and even a method declared
as returning an object can come back as a nil `Variant`. On the unchecked path there is no `Variant` at all — the
engine writes raw bytes into a slot whose type the generator fixed on both sides when it emitted the call — so a tag
there would be eight bytes written for nobody, and none is written.

A pointer-backed return, such as `Array` or a packed array, is the one case where the engine does not write into the
frame. The JVM keeps such a value after the call while the frame is reused by the next one, so the native side hands
the engine an allocation from its own pool instead and the frame carries only that address, written before the call
starts. Every other return the engine writes exactly where the JVM reads it.

## Shapes of an unchecked call

The layout above carries everything an arbitrary call might need, which means most calls carry something they do not.
A property setter never has a return value, a getter never has arguments, and a method such as `queue_redraw` has
neither. Those three shapes are recognisable from a signature alone, so the generator emits a call carrying only what
its shape uses and the native side has an entry point for each:

| Shape | Entry point | Frame |
|---|---|---|
| No arguments, no return | `icallPtrSimple` | `[caller][id]` |
| One argument, no return | `icallPtrSetter` | `[caller][id][value]` |
| No arguments, one return | `icallPtrGetter` | `[caller][id][return]` |
| Anything else | `icallPtr` | `[caller][id][count][tag][value]…[return]` |

Every `[return]` above is untagged, on the general shape as much as on the specialised ones.

A method that takes one argument *and* returns a value keeps the general form, as do variadic methods and everything
on the checked path.

Three things leave the specialised frames.

The **argument count** is not written, because each shape's count is part of the shape.

The **argument type ordinal** is not written either. A tag exists so a reader can discover a type it does not
otherwise know, and on these shapes both sides know it when the binding is generated. The type travels as an argument
of the call instead of as eight bytes in the buffer: `icallPtrSetter` is told the type of its argument, `icallPtrGetter`
the type it asked for, and the value sits alone straight after the caller record. Only the general shape writes
argument tags, because only it has a variable number of arguments for the native side to walk.

The **return record** is not reserved for a call that returns nothing, and a call with no arguments has the engine
write its result where the arguments would have gone.

Every offset is therefore constant per shape and neither side walks the frame: the receiver is at the start, and the
single value, where there is one, sixteen bytes in. The reference-counted rule below applies unchanged to
`icallPtrGetter`, the only specialised shape that can return an object.

## Reference-counted returns

An unchecked call is told its return type as an ordinal, with one value that is not a real type: `TYPE_MAX`, one past
the last `Variant` type. The generator sends it in place of the object ordinal when the method's declared return
class inherits `RefCounted`.

The reason is that the engine encodes those two cases identically in memory but means different things by them. A
method declared as returning a plain object writes just a pointer. A method returning a `Ref<T>` assigns that
reference over the caller's return slot, which leaves an **owned reference** there — the caller has inherited a
reference count that something must eventually release. The bytes are the same either way, and GDExtension offers no
way to ask a method binding what it returns, so the declared type from Godot's API description is the only source of
truth.

The native side therefore treats the ordinal as a return type of its own, carried as one extra entry in the return
format table past the last real type rather than as a flag its callers act on. That return starts the slot zeroed, because assigning a `Ref` releases whatever the slot
held before; binds the returned object to the JVM, which takes the JVM's own reference the first time it sees it; and
then releases the engine's reference, standing in for the destructor of the `Ref` local that never existed. The two
references have different owners and different release points — the JVM drops its own when the wrapper is collected —
so the engine's cannot simply be left in place, or a getter returning the same object every frame would raise its
count once per call and never free it.

Both sides derive this sentinel from `TYPE_MAX` rather than hardcoding it, so a new `Variant` type in a future Godot
release moves them together, and the generator fails the build if its own ordinal table and Godot's disagree.

## Where a ptrcall writes its return

The destination of a ptrcall's return is one of the call's parameters, so it has to be chosen before the engine runs,
and the right choice depends on what the JVM expects to find in the slot afterwards:

| Return | Engine writes | JVM expects in the slot | Destination |
|---|---|---|---|
| Inline — `Vector3`, `int`, `Color`… | the value's bytes | the value's bytes | the slot itself |
| Pointer — `Array`, `Dictionary`, `StringName`… | the native instance | the address of an instance it now owns | an allocation from the native pool, whose address is written into the slot before the call |
| Object — `Object`, `Ref<T>` | a bare pointer | a 16-byte record of pointer and `ObjectID` | the slot, zeroed first; the record is built from the pointer after the call |

The frame only reserves the slot, at the size the return format gives. Choosing the destination and making the call is
the entry point's job, in `cpp/jvm/registration/kt_object.cpp`: a force-inlined decision keeps the inline case a
straight fall-through into the engine and sends the other two to an out-of-line function, and the object case's
before and after live on the `Object` row of `variant_type.h`, as the one part of it that is knowledge about that
type. No other file makes a ptrcall. An earlier design had the frame make the call through a small functor so that it
could pick the destination itself; moving the call out removed the functor and the three stores that built it on
every unchecked call.

## Strings

Strings up to the configured inline limit are written into the buffer. Larger ones travel through JNI and a queue,
with a flag in the buffer telling the receiver which path to read. The default inline limit is 128 bytes, and raising
it makes the variant buffer proportionally larger on every thread.

Collections travel as native pointers rather than by copying their contents, so their length never affects buffer
capacity.

## Value encoding

Type ordinals follow Godot's own `Variant::Type` values. The table below describes the payload of each type as sent
from C++ to the JVM, excluding the eight-byte tag; in the other direction objects and collections are sent as a
native pointer alone.

| Type | Ordinal | Payload |
|---|---|---|
| Nil | 0 | None |
| Bool | 1 | 1-byte boolean |
| Int | 2 | 8-byte integer |
| Float | 3 | 8-byte double |
| String | 4 | 1-byte long-string flag; inline strings also carry a 4-byte byte count and UTF-8 data |
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
| Object | 24 | 8-byte native pointer, 8-byte ObjectID |
| Callable | 25 | 8-byte native pointer |
| Signal | 26 | Object payload followed by an 8-byte pointer to its StringName |
| Dictionary, Array | 27, 28 | 8-byte native pointer; element converters come from the JVM declaration, never from the engine's typed builtin |
| Packed arrays | 29 to 38 | 8-byte native pointer |

Mathematical values use their native component layout, with 4-byte components throughout. The JVM side writes real
components as 32-bit floats unconditionally, so the binding assumes a single-precision engine build; a
double-precision one would have the two sides disagree on the width of every real-valued type.

One row per type defines this format in `cpp/jvm/memory/variant_type.h`, and that file is the only place a type is
declared. A row states which C++ type carries the value, its *shape* — written inline in the engine's own layout,
carried as a pointer to an instance the JVM owns, carried as an engine object, or none of those — and whether the JVM
owns a native instance of it.

Those last two are separate facts, not one. A shape says whether a value can cross a ptrcall; ownership says whether
the sweep has to free an instance. `Callable` is the type that separates them: it never crosses a ptrcall, yet the JVM
allocates one. `Signal` is the opposite case and shows why the distinction is worth stating, since it allocates the
`StringName` it pairs with the object and never a `Signal`.

Everything else is derived, in `cpp/jvm/memory/variant_table.h`, as five tables indexed by the ordinal the JVM sends:
the argument formats the value buffer walks and the return formats an unchecked call picks its destination from,
the decoder and encoder pairs the variant buffer dispatches
through, and the releasers the sweep calls. Neither buffer knows the other; all five read the same rows. Adding a type
is one line, and a type whose shape cannot describe it fails to compile until it supplies a codec of its own.

## How a ptrcall reads its arguments

An unchecked call gives the engine an array of `void*`, one per argument, each pointing at that argument in the
layout the engine expects. Turning the frame's bytes into that array is the only per-argument work the native side
does, so it is worth following closely.

A frame for `draw_texture(Texture2D, Vector2, Color)` looks like this:

| Offset | Contents |
|---|---|
| 0 | Caller pointer |
| 8 | Caller ObjectID |
| 16 | Argument count, padded to a 24-byte header |
| 24 | Tag: Object |
| 32 | Texture2D pointer |
| 40 | Tag: Vector2 |
| 48 | x, y |
| 56 | Tag: Color |
| 64 | r, g, b, a |

Each row answers two questions about its type.

**How far does the payload reach?** The *stride*. Reading the tag at 24 puts the payload at 32, and the next tag
begins at 40, so Object's stride is 8. It is called a stride rather than a size because for a type held natively it
measures the handle in the frame, not the value behind it: a `Dictionary` argument has a stride of 8 however large
the dictionary is.

**Is the payload the value, or its address?** A `Vector2` payload is the value, so the engine is handed where it
lies. A `Dictionary` payload is a pointer to an instance on the native heap, so the engine is handed what the slot
holds. Those are the only two forms a `void*` argument can have, and a type's shape decides which one it takes.

Which shape a type uses follows from how the JVM holds it. Mathematical values and numbers are plain JVM data and are
written straight into the frame in the engine's layout. Containers, strings names, node paths and packed arrays are
JVM wrappers around a native instance, so only the pointer crosses.

`Object` is the exception worth remembering: it is held natively, yet its shape is direct. A ptrcall taking an object
parameter expects a pointer *to a slot holding* the object pointer, and the frame already holds that pointer, so the
slot's own address is what the engine wants.

Both answers share one 32-bit word per type, `ArgFormat`: the stride in the low bits, the indirect bit in the top
one. Reading an argument needs both, so packing them means a single table and a single load, and no call through a
per-type function. Its indirect test reads the sign bit rather than masking, which is what lets the compiler fold it
into one compare against the table entry.

## Value copies

Mathematical values such as `Vector3` are sent as components and rebuilt as JVM values, so a getter returns a copy
rather than a view into the native property. Changing its components affects only that copy until a setter sends them
back. Container wrappers instead hold a native pointer and share storage with the engine, though value-type elements
read out of them still cross by value.

## Exceptions at the JNI boundary

Registered function and property wrappers catch `Throwable` on the JVM side. A failing function or property getter
logs the stack trace and writes a nil `Variant` as its return value; setters and void calls log the failure and
return nothing.

For exceptions that reach JNI, JNI leaves a pending throwable when JVM code throws across a native call. The native
side obtains and clears it, then reports the formatted stack trace through Godot. The exception does not unwind
Godot's C++ stack: the boundary returns its default result and engine execution continues.
