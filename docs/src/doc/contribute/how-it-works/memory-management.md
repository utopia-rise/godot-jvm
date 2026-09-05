---
description: How Godot instance bindings and the JVM garbage collector are reconciled, and why RefCounted script instances need a weak JNI reference to avoid leaking.
---

# Memory management

Godot-JVM coordinates native object lifetimes with JVM garbage collection. The binding must keep objects alive while either runtime needs them and release them once neither does.

## Regular Godot memory management

### Object and RefCounted

Godot `Object` instances require explicit cleanup. `RefCounted` subclasses maintain a reference count and are freed when it reaches zero. The JVM binding must respect both lifetime models.

### Instance binding

Godot's instance-binding callbacks notify a language binding when an object is created, destroyed, or has its reference count changed. Godot-JVM uses these notifications to keep native and JVM instances in sync.

## Java Virtual Machine

### Garbage Collector

The JVM garbage collector reclaims objects that are no longer reachable. Collection is delayed until the collector runs, unlike Godot's immediate cleanup when a reference count reaches zero. Godot-JVM bridges this timing difference and the two runtimes' ownership rules.

### Wrapper and script instance

A native Godot object can have two JVM representations:

- A **wrapper** holds its C++ pointer and exposes the Godot API to JVM code.
- A **script instance** is the user's JVM subclass. It exposes the script's properties and methods to Godot.

### Memory manager

A Godot object has a native base type and an optional script. On the JVM, the script instance inherits a wrapper type, but a separate wrapper can also exist for the same native object. The wrapper follows the object's lifetime; the script instance follows its attached script.

Because Godot can replace a script while its object remains alive, `MemoryManager` tracks both representations. It:

- Records live JVM wrappers and script instances.
- Resolves native pointers to the appropriate JVM instance.
- Coordinates cleanup through Godot's instance-binding callbacks.

![Memory Manager](../../assets/img/memory_manager.png)

### RefCounted base type

A JVM binding holds a native reference while it needs a `RefCounted` object. When its wrapper is collected, the memory manager decrements the native reference count. Other native references can keep the object alive after the wrapper is gone.

This resembles Godot's C++ `Ref<>` ownership, with the release delayed until JVM collection.

### RefCounted scripts

A `RefCounted` script needs protection from collection while native code uses it. C++ therefore holds a JNI reference to the JVM script. If that reference stayed strong, it would create an ownership cycle: the native object would keep the script alive, and the script's binding would keep the native reference count above zero.

When the native reference count reaches one, only the JVM binding remains. Godot-JVM demotes the script's JNI reference to a weak reference, allowing collection if JVM code no longer needs it. Cleanup then decrements the native count and releases the object. If native ownership increases again, the reference is promoted to strong.

### Cyclical references

Wrappers and script instances can refer to each other. A caller may retain a wrapper before another part of the program attaches a JVM script to the native object. That older wrapper must then keep the new script instance reachable. The manager coordinates these relationships when switching between the two representations.
