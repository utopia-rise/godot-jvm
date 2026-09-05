---
description: How the editor reconciles physical script resources with classes from the project JAR, why FQCN is the shared identity, and why reload order does not matter.
---

# JAR and script reloading

The editor reloads compiled classes after a build and reconciles them with existing script resources. This process applies to editor sessions; exported games do not reload source files or JAR registrations.

## Mental model

A `JvmScript` can start from either side of the integration:

- A **physical script** is a real Godot resource such as `res://game/Foo.kt`.
  It is created by the resource loader and is the resource Godot attaches to
  nodes.
- A **virtual script** is created from a `KtClass` read from the project JAR.
  It has a `jvm://` path and exists when Godot knows the registered class before
  it has a matching source resource.

The fully qualified class name (FQCN) is the identity that joins them. A
physical and virtual script with the same FQCN represent one script, never two.
When both exist, the physical resource becomes the canonical script because Godot owns that resource.

The manager maintains two different views:

- registered name -> script: the classes in the current JAR;
- FQCN -> script: every live physical or virtual script with a known FQCN.

The FQCN map is weak. Godot or another resource owns the script itself; the
manager only indexes it.

## Resource loading

For a normal `res://` load, `JvmResourceFormatLoader` reads the source, parses
its FQCN, and creates or binds the physical script. A `jvm://` load only
resolves an already registered virtual script by its filename; it never reads
or creates a file.

`CACHE_MODE_IGNORE` is used by the Script editor to inspect an externally
changed file. When the JVM script is already cached, the loader calls that
script's `reload_from_file()` and returns it. This deliberately refreshes the
canonical physical script rather than creating a temporary JVM script.

## JAR reload

A JAR reload refreshes registrations, not source files.

1. Clear the current registered-name map and JVM class indices.
2. Clear the old `KtClass` from every live FQCN candidate. The script resource
   and its FQCN identity remain available.
3. For every `KtClass` in the new JAR, find its FQCN candidate. Reuse it when
   present; otherwise create a virtual script.
4. Rebuild the registered-name map and JVM class indices from those new
   `KtClass` objects.
5. Remove dead weak FQCN entries.

This retains a physical source resource even when one JAR build temporarily
does not contain its class. It also retains externally owned virtual resources
so a later JAR build or source reload can reuse them.

## Physical source reload

Godot calls `JvmScript::reload_from_file()` for an already loaded source
resource. It rereads the file, stores the source text, records the source file
modification time, parses its FQCN, and updates the manager's physical-script
mapping.

The reconciliation rules are:

- Same FQCN and already canonical: no manager change is required.
- FQCN changed: detach the old `KtClass` into a virtual script so the old JAR
  class remains represented.
- No parsed FQCN: leave the physical script unbound until a valid reload.
- Matching virtual script: promote the physical script, move its `KtClass`,
  migrate placeholders and exported values, and update `TypeManager`.
- Matching orphan virtual script: do not promote it because it has no
  `KtClass` to transfer; make the physical script the FQCN mapping and wait for
  a JAR containing that class.
- Matching different physical script: report a duplicate FQCN error.
- No match: make this physical script the FQCN mapping.

## Source warning

The node warning is timestamp-based, not a reload-order flag. Each physical
script stores the source file modification time when it is loaded, saved, or
reloaded. The manager records the current time when it reloads `main.jar`. A
placeholder warns only when its source timestamp is newer than the JAR reload
timestamp. Reloading either resource therefore gives the same result regardless
of which one Godot processes first.

## Reload order

Both reload orders resolve to the same physical resource:

- **Source first:** the physical script enters the FQCN map; the next JAR
  reload binds the new `KtClass` to it.
- **JAR first:** the JAR may create a virtual script; the following physical
  source reload promotes the physical resource and removes that virtual twin.

An empty or invalid source has no FQCN and is intentionally not mapped. Once it
becomes valid and reloads, it follows the normal physical-source rules.
