---
description: Exact registration selection rules for classes, properties, functions, signals, notifications, and the Inferred, Explicit, and Automatic modes.
---

# Registration reference

[Registering your code](../guide/registration.md) covers the normal workflow. This page is the reference for the selection rules that apply when a declaration does not behave as expected or when you intentionally choose a non-default mode.

## Modes

| Mode | Selects | Use it when |
|---|---|---|
| `Inferred` | Direct and implied annotations, compatible Godot overrides, and `SignalN` members | Almost every project |
| `Explicit` | Direct selection annotations only | Every Godot-facing declaration should be marked deliberately |
| `Automatic` | Compatible declarations on Godot classes | Public compatible members should be exposed by default |

`Inferred` is the default. It is the mode used by the Guide and its examples.

Choose a non-default mode with `registration.annotationProcessingMode`; see [Registration output](gradle-plugin/registration.md) only for that configuration setting and `.gdj` output options.

## What selects each declaration

| Declaration | Inferred | Explicit | Automatic |
|---|---|---|---|
| Script class | `@Script` | Direct `@Script` | Compatible Godot subclass |
| Property | `@Visible`, `@Export`, or a property hint | Direct `@Visible`; add `@Export` to show it in the Inspector | Compatible public property |
| Ordinary function | `@Register` or `@Rpc` | Direct `@Register` or `@Rpc` | Compatible public function |
| Godot override | Matching override is recognized | Matching override is recognized | Matching override is recognized |
| Signal | `SignalN` member; `@Emit` optionally names arguments | Direct `@Emit` on the `SignalN` member | Compatible `SignalN` member |
| Notification handler | `@Notification(...)` | Direct `@Notification(...)` | `@Notification(...)` |

In Explicit mode, annotations do not imply one another. An Inspector property therefore needs both `@Visible` and `@Export`; a property hint only chooses the Inspector control.

!!! note
    In Automatic mode, the source filename must match the registered class name when a file has no `@Script` annotation. Use `@Script` when that rule does not fit the file.

## Requirements shared by every mode

- A script class extends `godot.api.Object` or a subtype. Its registered Godot name must be unique.
- A registered property is public and converts to a Godot `Variant`. A core Godot type needs an actual value and cannot be `lateinit`.
- Registered functions are declared on the class, use Godot-supported parameter and return types, are non-generic, and take at most sixteen arguments.
- A script can be registered without a public no-argument constructor, but Godot can instantiate it only when one exists.
- Godot-facing names are converted to `snake_case` unless a particular API documents otherwise.

Build again after adding, removing, renaming, or changing a script, exposed property, signal, or callable Godot function. Changing only a method body does not require a registration change.

## Related reference

- [Annotations](annotations.md) for the annotation lookup table
- [Property hints](property-hints.md) for Inspector controls and their arguments
- [Build and registration troubleshooting](../troubleshooting/build-and-registration.md) when a declaration is missing after a build
