---
description: Every property-hint annotation that controls how an exported property is displayed in the Godot Inspector, plus the range arguments they share.
---

# Property hints

Below is a list of currently implemented type hints. Each one can only be added to certain types of properties, and
takes effect only when the property is also exported.

| Annotation        | Type of Property | Arguments                                                                                                                                                                                     | Short Description                                                                                                                   |
|-------------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| `IntRange`        | Int              | `min: Int`, `max: Int`, `step: Int = -1`, plus the [shared range arguments](#shared-range-arguments)                                                                                            | Provides a range of ints from `min` to `max`, with optional steps                                                                    |
| `LongRange`       | Long             | `min: Long`, `max: Long`, `step: Long = -1L`, plus the [shared range arguments](#shared-range-arguments)                                                                                        | Provides a range of longs from `min` to `max`, with optional steps                                                                   |
| `FloatRange`      | Float            | `min: Float`, `max: Float`, `step: Float = -1f`, plus the [shared range arguments](#shared-range-arguments)                                                                                     | Provides a range of floats from `min` to `max`, with optional steps                                                                  |
| `DoubleRange`     | Double           | `min: Double`, `max: Double`, `step: Double = -1.0`, plus the [shared range arguments](#shared-range-arguments)                                                                                 | Provides a range of doubles from `min` to `max`, with optional steps                                                                 |
| `ExpEasing`       | Float, Double    | `attenuation: Boolean = false`, `isPositiveOnly: Boolean = true`                                                                                                                                | The Inspector shows an easing curve editor. `attenuation` flips the curve, `isPositiveOnly` restricts it to positive values.        |
| `IntFlag`         | Int              | `vararg names: String`                                                                                                                                                                          | Registers a raw `Int` bitmask with the given flag names. For type-safe flags backed by an enum, use `BitField` instead (see below). |
| `File`            | String           | `vararg extensions: String = []`, `global: Boolean = false`                                                                                                                                     | The Inspector will show a File dialog in which you can select a File. The Path of the file will be stored in the property.          |
| `Dir`             | String           | `global: Boolean = false`                                                                                                                                                                       | The Inspector will show a File dialog in which you can select a directory. The Path of the directory will be stored in the property.|
| `MultilineText`   | String           |                                                                                                                                                                                                 | The Inspector shows a multiline text input.                                                                                         |
| `PlaceHolderText` | String           |                                                                                                                                                                                                 | Marks the property with Godot's placeholder-text hint. The annotation carries no text, so the placeholder itself stays empty.       |
| `ColorNoAlpha`    | Color            |                                                                                                                                                                                                 | The Inspector shows a color selection dialog without alpha                                                                          |
| `HintString`      | Any              | `value: String`                                                                                                                                                                                 | Sets Godot's hint string. You are responsible for using the format expected by Godot.                                               |

### Shared range arguments

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

!!! note
    It's not easy to track changes to these property hints on the Godot project. If one is missing or not working as expected, please file an [issue on GitHub](https://github.com/utopia-rise/godot-jvm/issues).
