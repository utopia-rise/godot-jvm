---
description: Exact registration selection rules for classes, properties, functions, signals, notifications, and the Inferred, Explicit, and Automatic modes.
---

# Registration reference

Registration mode determines which compatible classes and members Godot-JVM exposes. The tables below separate declaration selection from the requirements that apply in every mode.

## Modes

| Mode | Selects | Use it when |
|---|---|---|
| `Inferred` | Direct and implied annotations, compatible Godot overrides, and `SignalN` members | Almost every project |
| `Explicit` | Direct selection annotations only | Every Godot-facing declaration should be marked deliberately |
| `Automatic` | Public compatible declarations on public Godot subclasses | Public compatible members should be exposed by default |

`Inferred` is the default.

Set the mode with `annotationProcessingMode` in the `godot { ... }` block. [Registration output](gradle-plugin/registration.md) gives the configuration syntax and file-output options.

## What selects each declaration

| Declaration | Inferred | Explicit | Automatic |
|---|---|---|---|
| Script class | `@Script` | Direct `@Script` | Public compatible Godot subclass |
| Property | `@Visible`, `@Export`, or a property hint | Direct `@Visible`; add `@Export` to show it in the Inspector | Compatible public property |
| Ordinary function | `@Register` or `@Rpc` | Direct `@Register`; add `@Rpc` for RPC configuration | Compatible public function |
| Godot override | Matching override is recognized | Direct `@Register` | Matching override is recognized |
| Signal | `SignalN` member; `@Emit` optionally names arguments | Direct `@Emit` on the `SignalN` member | Compatible `SignalN` member |
| Notification handler | `@Notification(...)` | Direct `@Notification(...)` | `@Notification(...)` |

In Explicit mode, annotations do not imply one another. An Inspector property therefore needs both `@Visible` and `@Export`; a property hint only chooses the Inspector control.

!!! note
    Without `@Script`, a source filename must match the class's simple JVM name. This matters in Automatic mode, which can select classes without the annotation.

## Requirements shared by every mode

- A script class extends `godot.api.Object` or a subtype. Its registered Godot name must be unique.
- A registered property is public and converts to a Godot `Variant`. A core Godot type needs an actual value and cannot be `lateinit`.
- Registered functions are declared on the class, use Godot-supported parameter and return types, are non-generic, and take at most sixteen arguments.
- A script can be registered without a public no-argument constructor, but Godot can instantiate it only when one exists.
- Godot-facing names are converted to `snake_case` unless a particular API documents otherwise.

A normal build updates registration and compiled code together. For method-body changes alone, `fastBuild` can reuse the existing registration output.
