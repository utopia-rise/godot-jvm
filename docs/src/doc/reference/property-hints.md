---
description: Every property-hint annotation that controls how an exported property is displayed in the Godot Inspector, plus the range arguments they share.
---

# Property hints

Property hints control how exported values appear in the Inspector. Each hint supports the property types listed below. In Inferred mode, a hint also implies `@Export`; in Explicit mode, add both `@Visible` and `@Export`.

| Annotation        | Type of Property | Arguments                                                                                                                                                                                     | Inspector control                                                                                                                   |
|-------------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| `IntRange`        | Int              | `min: Int`, `max: Int`, `step: Int = -1`, plus the [shared range arguments](#shared-range-arguments)                                                                                            | Numeric range with optional steps                                                                    |
| `LongRange`       | Long             | `min: Long`, `max: Long`, `step: Long = -1L`, plus the [shared range arguments](#shared-range-arguments)                                                                                        | Numeric range with optional steps                                                                   |
| `FloatRange`      | Float            | `min: Float`, `max: Float`, `step: Float = -1f`, plus the [shared range arguments](#shared-range-arguments)                                                                                     | Numeric range with optional steps                                                                  |
| `DoubleRange`     | Double           | `min: Double`, `max: Double`, `step: Double = -1.0`, plus the [shared range arguments](#shared-range-arguments)                                                                                 | Numeric range with optional steps                                                                 |
| `ExpEasing`       | Float, Double    | `attenuation: Boolean = false`, `isPositiveOnly: Boolean = true`                                                                                                                                | Easing curve editor. `attenuation` flips the curve, `isPositiveOnly` restricts it to positive values.        |
| `IntFlag`         | Int              | `vararg names: String`                                                                                                                                                                          | Named flag checkboxes. Use `BitField<YourEnum>` for enum-backed flags. |
| `File`            | String           | `vararg extensions: String = []`, `global: Boolean = false`                                                                                                                                     | File picker.          |
| `Dir`             | String           | `global: Boolean = false`                                                                                                                                                                       | Directory picker.|
| `MultilineText`   | String           |                                                                                                                                                                                                 | Multiline text input.                                                                                         |
| `PlaceHolderText` | String           |                                                                                                                                                                                                 | Marks the property with Godot's placeholder-text hint. The annotation carries no text, so the placeholder itself stays empty.       |
| `ColorNoAlpha`    | Color            |                                                                                                                                                                                                 | Color picker without alpha                                                                          |
| `HintString`      | Any              | `value: String`                                                                                                                                                                                 | Sets Godot's hint string. You are responsible for using the format expected by Godot.                                               |

## Shared range arguments

`IntRange`, `LongRange`, `FloatRange`, and `DoubleRange` all accept the same trailing arguments after
`min`, `max`, and `step`:

| Argument                      | Token added to Godot's range hint string                                                                 |
|-------------------------------|------------------------------------------------------------------------------------------------------------|
| `or: Range = Range.NONE`      | `or_greater` for `Range.OR_GREATER`, `or_lesser` for `Range.OR_LESSER`. `Range.NONE` adds nothing.           |
| `hideSlider: Boolean = false` | `hide_slider`                                                                                                |
| `isRadians: Boolean = false`  | `radians`                                                                                                    |
| `isDegrees: Boolean = false`  | `degrees`                                                                                                    |
| `isExp: Boolean = false`      | `exp`                                                                                                        |
| `suffix: String = "<none>"`   | `suffix:<your value>`. The default `"<none>"` is the sentinel for "no suffix" and adds nothing.              |

A `step` below `0` is omitted from the generated hint, which is why the default is negative.
Godot itself decides what each token means; see its documentation for `PROPERTY_HINT_RANGE`.

If a hint is missing or behaves incorrectly, report it in a [GitHub issue](https://github.com/utopia-rise/godot-jvm/issues). Include the annotation, property type, and expected Inspector control.
