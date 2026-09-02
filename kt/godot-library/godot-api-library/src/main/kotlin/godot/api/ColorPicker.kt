// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedColorArray
import godot.core.Signal1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A widget that provides an interface for selecting or modifying a color. It can optionally provide
 * functionalities like a color sampler (eyedropper), color modes, and presets.
 *
 * **Note:** This control is the color picker widget itself. You can use a [ColorPickerButton]
 * instead if you need a button that brings up a [ColorPicker] in a popup.
 */
@GodotBaseType
public open class ColorPicker : VBoxContainer() {
  /**
   * Emitted when the color is changed.
   */
  public val colorChanged: Signal1<Color> by Signal1

  /**
   * Emitted when a preset is added.
   */
  public val presetAdded: Signal1<Color> by Signal1

  /**
   * Emitted when a preset is removed.
   */
  public val presetRemoved: Signal1<Color> by Signal1

  /**
   * The currently selected color.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var color: Color
    @JvmName("colorProperty")
    get() = getPickColor()
    @JvmName("colorProperty")
    set(`value`) {
      setPickColor(value)
    }

  /**
   * If `true`, shows an alpha channel slider (opacity).
   */
  public final inline var editAlpha: Boolean
    @JvmName("editAlphaProperty")
    get() = isEditingAlpha()
    @JvmName("editAlphaProperty")
    set(`value`) {
      setEditAlpha(value)
    }

  /**
   * If `true`, shows an intensity slider. The intensity is applied as follows: convert the color to
   * linear encoding, multiply it by `2 ** intensity`, and then convert it back to nonlinear sRGB
   * encoding.
   */
  public final inline var editIntensity: Boolean
    @JvmName("editIntensityProperty")
    get() = isEditingIntensity()
    @JvmName("editIntensityProperty")
    set(`value`) {
      setEditIntensity(value)
    }

  /**
   * The currently selected color mode.
   */
  public final inline var colorMode: ColorModeType
    @JvmName("colorModeProperty")
    get() = getColorMode()
    @JvmName("colorModeProperty")
    set(`value`) {
      setColorMode(value)
    }

  /**
   * If `true`, the color will apply only after the user releases the mouse button, otherwise it
   * will apply immediately even in mouse motion event (which can cause performance issues).
   */
  public final inline var deferredMode: Boolean
    @JvmName("deferredModeProperty")
    get() = isDeferredMode()
    @JvmName("deferredModeProperty")
    set(`value`) {
      setDeferredMode(value)
    }

  /**
   * The shape of the color space view.
   */
  public final inline var pickerShape: PickerShapeType
    @JvmName("pickerShapeProperty")
    get() = getPickerShape()
    @JvmName("pickerShapeProperty")
    set(`value`) {
      setPickerShape(value)
    }

  /**
   * If `true`, it's possible to add presets under Swatches. If `false`, the button to add presets
   * is disabled.
   */
  public final inline var canAddSwatches: Boolean
    @JvmName("canAddSwatchesProperty")
    get() = areSwatchesEnabled()
    @JvmName("canAddSwatchesProperty")
    set(`value`) {
      setCanAddSwatches(value)
    }

  /**
   * If `true`, the color sampler and color preview are visible.
   */
  public final inline var samplerVisible: Boolean
    @JvmName("samplerVisibleProperty")
    get() = isSamplerVisible()
    @JvmName("samplerVisibleProperty")
    set(`value`) {
      setSamplerVisible(value)
    }

  /**
   * If `true`, the color mode buttons are visible.
   */
  public final inline var colorModesVisible: Boolean
    @JvmName("colorModesVisibleProperty")
    get() = areModesVisible()
    @JvmName("colorModesVisibleProperty")
    set(`value`) {
      setModesVisible(value)
    }

  /**
   * If `true`, the color sliders are visible.
   */
  public final inline var slidersVisible: Boolean
    @JvmName("slidersVisibleProperty")
    get() = areSlidersVisible()
    @JvmName("slidersVisibleProperty")
    set(`value`) {
      setSlidersVisible(value)
    }

  /**
   * If `true`, the hex color code input field is visible.
   */
  public final inline var hexVisible: Boolean
    @JvmName("hexVisibleProperty")
    get() = isHexVisible()
    @JvmName("hexVisibleProperty")
    set(`value`) {
      setHexVisible(value)
    }

  /**
   * If `true`, the Swatches and Recent Colors presets are visible.
   */
  public final inline var presetsVisible: Boolean
    @JvmName("presetsVisibleProperty")
    get() = arePresetsVisible()
    @JvmName("presetsVisibleProperty")
    set(`value`) {
      setPresetsVisible(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(170, scriptPtr)
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = colorpicker.color
   * //Your changes
   * colorpicker.color = myCoreType
   * ``````
   *
   * The currently selected color.
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  public final fun setPickColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setPickColorPtr)
  }

  public final fun getPickColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPickColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setDeferredMode(mode: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to mode)
    TransferContext.callMethod(MethodBindings.setDeferredModePtr)
  }

  public final fun isDeferredMode(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDeferredModePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setColorMode(colorMode: ColorModeType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to colorMode.value)
    TransferContext.callMethod(MethodBindings.setColorModePtr)
  }

  public final fun getColorMode(): ColorModeType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorModePtr)
    return ColorModeType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEditAlpha(show: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to show)
    TransferContext.callMethod(MethodBindings.setEditAlphaPtr)
  }

  public final fun isEditingAlpha(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditingAlphaPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEditIntensity(show: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to show)
    TransferContext.callMethod(MethodBindings.setEditIntensityPtr)
  }

  public final fun isEditingIntensity(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditingIntensityPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCanAddSwatches(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCanAddSwatchesPtr)
  }

  public final fun areSwatchesEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areSwatchesEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPresetsVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setPresetsVisiblePtr)
  }

  public final fun arePresetsVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.arePresetsVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setModesVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setModesVisiblePtr)
  }

  public final fun areModesVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areModesVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSamplerVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setSamplerVisiblePtr)
  }

  public final fun isSamplerVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSamplerVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSlidersVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setSlidersVisiblePtr)
  }

  public final fun areSlidersVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areSlidersVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHexVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setHexVisiblePtr)
  }

  public final fun isHexVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHexVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds the given color to a list of color presets. The presets are displayed in the color picker
   * and the user will be able to select them.
   *
   * **Note:** The presets list is only for *this* color picker.
   */
  public final fun addPreset(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.addPresetPtr)
  }

  /**
   * Removes the given color from the list of color presets of this color picker.
   */
  public final fun erasePreset(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.erasePresetPtr)
  }

  /**
   * Returns the list of colors in the presets of the color picker.
   */
  public final fun getPresets(): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPresetsPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
  }

  /**
   * Adds the given color to a list of color recent presets so that it can be picked later. Recent
   * presets are the colors that were picked recently, a new preset is automatically created and added
   * to recent presets when you pick a new color.
   *
   * **Note:** The recent presets list is only for *this* color picker.
   */
  public final fun addRecentPreset(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.addRecentPresetPtr)
  }

  /**
   * Removes the given color from the list of color recent presets of this color picker.
   */
  public final fun eraseRecentPreset(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.eraseRecentPresetPtr)
  }

  /**
   * Returns the list of colors in the recent presets of the color picker.
   */
  public final fun getRecentPresets(): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRecentPresetsPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
  }

  public final fun setPickerShape(shape: PickerShapeType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.setPickerShapePtr)
  }

  public final fun getPickerShape(): PickerShapeType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPickerShapePtr)
    return PickerShapeType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class ColorModeType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Allows editing the color with Red/Green/Blue sliders in sRGB color space.
     */
    MODE_RGB(0),
    /**
     * Allows editing the color with Hue/Saturation/Value sliders.
     */
    MODE_HSV(1),
    MODE_RAW(2),
    /**
     * Allows editing the color with Red/Green/Blue sliders in linear color space.
     */
    MODE_LINEAR(2),
    /**
     * Allows editing the color with Hue/Saturation/Lightness sliders.
     *
     * OKHSL is a new color space similar to HSL but that better match perception by leveraging the
     * Oklab color space which is designed to be simple to use, while doing a good job at predicting
     * perceived lightness, chroma and hue.
     *
     * [url=https://bottosson.github.io/posts/colorpicker/]Okhsv and Okhsl color spaces[/url]
     */
    MODE_OKHSL(3),
    ;

    public companion object {
      public fun from(`value`: Long): ColorModeType = entries.single { it.`value` == `value` }
    }
  }

  public enum class PickerShapeType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * HSV Color Model rectangle color space.
     */
    SHAPE_HSV_RECTANGLE(0),
    /**
     * HSV Color Model rectangle color space with a wheel.
     */
    SHAPE_HSV_WHEEL(1),
    /**
     * HSV Color Model circle color space. Use Saturation as a radius.
     */
    SHAPE_VHS_CIRCLE(2),
    /**
     * HSL OK Color Model circle color space.
     */
    SHAPE_OKHSL_CIRCLE(3),
    /**
     * The color space shape and the shape select button are hidden. Can't be selected from the
     * shapes popup.
     */
    SHAPE_NONE(4),
    /**
     * OKHSL Color Model rectangle with constant lightness.
     */
    SHAPE_OK_HS_RECTANGLE(5),
    /**
     * OKHSL Color Model rectangle with constant saturation.
     */
    SHAPE_OK_HL_RECTANGLE(6),
    ;

    public companion object {
      public fun from(`value`: Long): PickerShapeType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPickColorName: MethodStringName1<ColorPicker, Unit, Color> =
        MethodStringName1<ColorPicker, Unit, Color>("set_pick_color")

    @JvmField
    public val getPickColorName: MethodStringName0<ColorPicker, Color> =
        MethodStringName0<ColorPicker, Color>("get_pick_color")

    @JvmField
    public val setDeferredModeName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_deferred_mode")

    @JvmField
    public val isDeferredModeName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("is_deferred_mode")

    @JvmField
    public val setColorModeName: MethodStringName1<ColorPicker, Unit, ColorModeType> =
        MethodStringName1<ColorPicker, Unit, ColorModeType>("set_color_mode")

    @JvmField
    public val getColorModeName: MethodStringName0<ColorPicker, ColorModeType> =
        MethodStringName0<ColorPicker, ColorModeType>("get_color_mode")

    @JvmField
    public val setEditAlphaName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_edit_alpha")

    @JvmField
    public val isEditingAlphaName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("is_editing_alpha")

    @JvmField
    public val setEditIntensityName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_edit_intensity")

    @JvmField
    public val isEditingIntensityName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("is_editing_intensity")

    @JvmField
    public val setCanAddSwatchesName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_can_add_swatches")

    @JvmField
    public val areSwatchesEnabledName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("are_swatches_enabled")

    @JvmField
    public val setPresetsVisibleName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_presets_visible")

    @JvmField
    public val arePresetsVisibleName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("are_presets_visible")

    @JvmField
    public val setModesVisibleName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_modes_visible")

    @JvmField
    public val areModesVisibleName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("are_modes_visible")

    @JvmField
    public val setSamplerVisibleName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_sampler_visible")

    @JvmField
    public val isSamplerVisibleName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("is_sampler_visible")

    @JvmField
    public val setSlidersVisibleName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_sliders_visible")

    @JvmField
    public val areSlidersVisibleName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("are_sliders_visible")

    @JvmField
    public val setHexVisibleName: MethodStringName1<ColorPicker, Unit, Boolean> =
        MethodStringName1<ColorPicker, Unit, Boolean>("set_hex_visible")

    @JvmField
    public val isHexVisibleName: MethodStringName0<ColorPicker, Boolean> =
        MethodStringName0<ColorPicker, Boolean>("is_hex_visible")

    @JvmField
    public val addPresetName: MethodStringName1<ColorPicker, Unit, Color> =
        MethodStringName1<ColorPicker, Unit, Color>("add_preset")

    @JvmField
    public val erasePresetName: MethodStringName1<ColorPicker, Unit, Color> =
        MethodStringName1<ColorPicker, Unit, Color>("erase_preset")

    @JvmField
    public val getPresetsName: MethodStringName0<ColorPicker, PackedColorArray> =
        MethodStringName0<ColorPicker, PackedColorArray>("get_presets")

    @JvmField
    public val addRecentPresetName: MethodStringName1<ColorPicker, Unit, Color> =
        MethodStringName1<ColorPicker, Unit, Color>("add_recent_preset")

    @JvmField
    public val eraseRecentPresetName: MethodStringName1<ColorPicker, Unit, Color> =
        MethodStringName1<ColorPicker, Unit, Color>("erase_recent_preset")

    @JvmField
    public val getRecentPresetsName: MethodStringName0<ColorPicker, PackedColorArray> =
        MethodStringName0<ColorPicker, PackedColorArray>("get_recent_presets")

    @JvmField
    public val setPickerShapeName: MethodStringName1<ColorPicker, Unit, PickerShapeType> =
        MethodStringName1<ColorPicker, Unit, PickerShapeType>("set_picker_shape")

    @JvmField
    public val getPickerShapeName: MethodStringName0<ColorPicker, PickerShapeType> =
        MethodStringName0<ColorPicker, PickerShapeType>("get_picker_shape")
  }

  public object MethodBindings {
    internal val setPickColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_pick_color", 2920490490)

    internal val getPickColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "get_pick_color", 3444240500)

    internal val setDeferredModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_deferred_mode", 2586408642)

    internal val isDeferredModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "is_deferred_mode", 36873697)

    internal val setColorModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_color_mode", 1579114136)

    internal val getColorModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "get_color_mode", 392907674)

    internal val setEditAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_edit_alpha", 2586408642)

    internal val isEditingAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "is_editing_alpha", 36873697)

    internal val setEditIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_edit_intensity", 2586408642)

    internal val isEditingIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "is_editing_intensity", 36873697)

    internal val setCanAddSwatchesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_can_add_swatches", 2586408642)

    internal val areSwatchesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "are_swatches_enabled", 36873697)

    internal val setPresetsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_presets_visible", 2586408642)

    internal val arePresetsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "are_presets_visible", 36873697)

    internal val setModesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_modes_visible", 2586408642)

    internal val areModesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "are_modes_visible", 36873697)

    internal val setSamplerVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_sampler_visible", 2586408642)

    internal val isSamplerVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "is_sampler_visible", 36873697)

    internal val setSlidersVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_sliders_visible", 2586408642)

    internal val areSlidersVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "are_sliders_visible", 36873697)

    internal val setHexVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_hex_visible", 2586408642)

    internal val isHexVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "is_hex_visible", 36873697)

    internal val addPresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "add_preset", 2920490490)

    internal val erasePresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "erase_preset", 2920490490)

    internal val getPresetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "get_presets", 1392750486)

    internal val addRecentPresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "add_recent_preset", 2920490490)

    internal val eraseRecentPresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "erase_recent_preset", 2920490490)

    internal val getRecentPresetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "get_recent_presets", 1392750486)

    internal val setPickerShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "set_picker_shape", 3981373861)

    internal val getPickerShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ColorPicker", "get_picker_shape", 1143229889)
  }
}
