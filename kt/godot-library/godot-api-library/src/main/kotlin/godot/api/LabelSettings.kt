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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [LabelSettings] is a resource that provides common settings to customize the text in a [Label].
 * It will take priority over the properties defined in [Control.theme]. The resource can be shared
 * between multiple labels and changed on the fly, so it's convenient and flexible way to setup text
 * style.
 */
@GodotBaseType
public open class LabelSettings : Resource() {
  /**
   * Additional vertical spacing between lines (in pixels), spacing is added to line descent. This
   * value can be negative.
   */
  public final inline var lineSpacing: Float
    @JvmName("lineSpacingProperty")
    get() = getLineSpacing()
    @JvmName("lineSpacingProperty")
    set(`value`) {
      setLineSpacing(value)
    }

  /**
   * Vertical space between paragraphs. Added on top of [lineSpacing].
   */
  public final inline var paragraphSpacing: Float
    @JvmName("paragraphSpacingProperty")
    get() = getParagraphSpacing()
    @JvmName("paragraphSpacingProperty")
    set(`value`) {
      setParagraphSpacing(value)
    }

  /**
   * [Font] used for the text.
   */
  public final inline var font: Font?
    @JvmName("fontProperty")
    get() = getFont()
    @JvmName("fontProperty")
    set(`value`) {
      setFont(value)
    }

  /**
   * Size of the text.
   */
  public final inline var fontSize: Int
    @JvmName("fontSizeProperty")
    get() = getFontSize()
    @JvmName("fontSizeProperty")
    set(`value`) {
      setFontSize(value)
    }

  /**
   * Color of the text.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var fontColor: Color
    @JvmName("fontColorProperty")
    get() = getFontColor()
    @JvmName("fontColorProperty")
    set(`value`) {
      setFontColor(value)
    }

  /**
   * Text outline size.
   */
  public final inline var outlineSize: Int
    @JvmName("outlineSizeProperty")
    get() = getOutlineSize()
    @JvmName("outlineSizeProperty")
    set(`value`) {
      setOutlineSize(value)
    }

  /**
   * The color of the outline.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var outlineColor: Color
    @JvmName("outlineColorProperty")
    get() = getOutlineColor()
    @JvmName("outlineColorProperty")
    set(`value`) {
      setOutlineColor(value)
    }

  /**
   * Size of the shadow effect.
   */
  public final inline var shadowSize: Int
    @JvmName("shadowSizeProperty")
    get() = getShadowSize()
    @JvmName("shadowSizeProperty")
    set(`value`) {
      setShadowSize(value)
    }

  /**
   * Color of the shadow effect. If alpha is `0`, no shadow will be drawn.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var shadowColor: Color
    @JvmName("shadowColorProperty")
    get() = getShadowColor()
    @JvmName("shadowColorProperty")
    set(`value`) {
      setShadowColor(value)
    }

  /**
   * Offset of the shadow effect, in pixels.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var shadowOffset: Vector2
    @JvmName("shadowOffsetProperty")
    get() = getShadowOffset()
    @JvmName("shadowOffsetProperty")
    set(`value`) {
      setShadowOffset(value)
    }

  /**
   * The number of stacked outlines.
   */
  public final inline var stackedOutlineCount: Int
    @JvmName("stackedOutlineCountProperty")
    get() = getStackedOutlineCount()
    @JvmName("stackedOutlineCountProperty")
    set(`value`) {
      setStackedOutlineCount(value)
    }

  /**
   * The number of stacked shadows.
   */
  public final inline var stackedShadowCount: Int
    @JvmName("stackedShadowCountProperty")
    get() = getStackedShadowCount()
    @JvmName("stackedShadowCountProperty")
    set(`value`) {
      setStackedShadowCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(352, scriptPtr)
  }

  /**
   * This is a helper function for [fontColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = labelsettings.fontColor
   * //Your changes
   * labelsettings.fontColor = myCoreType
   * ``````
   *
   * Color of the text.
   */
  @CoreTypeHelper
  public final fun fontColorMutate(block: Color.() -> Unit): Color = fontColor.apply {
     block(this)
     fontColor = this
  }

  /**
   * This is a helper function for [outlineColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = labelsettings.outlineColor
   * //Your changes
   * labelsettings.outlineColor = myCoreType
   * ``````
   *
   * The color of the outline.
   */
  @CoreTypeHelper
  public final fun outlineColorMutate(block: Color.() -> Unit): Color = outlineColor.apply {
     block(this)
     outlineColor = this
  }

  /**
   * This is a helper function for [shadowColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = labelsettings.shadowColor
   * //Your changes
   * labelsettings.shadowColor = myCoreType
   * ``````
   *
   * Color of the shadow effect. If alpha is `0`, no shadow will be drawn.
   */
  @CoreTypeHelper
  public final fun shadowColorMutate(block: Color.() -> Unit): Color = shadowColor.apply {
     block(this)
     shadowColor = this
  }

  /**
   * This is a helper function for [shadowOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = labelsettings.shadowOffset
   * //Your changes
   * labelsettings.shadowOffset = myCoreType
   * ``````
   *
   * Offset of the shadow effect, in pixels.
   */
  @CoreTypeHelper
  public final fun shadowOffsetMutate(block: Vector2.() -> Unit): Vector2 = shadowOffset.apply {
     block(this)
     shadowOffset = this
  }

  public final fun setLineSpacing(spacing: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to spacing.toDouble())
    TransferContext.callMethod(MethodBindings.setLineSpacingPtr)
  }

  public final fun getLineSpacing(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineSpacingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setParagraphSpacing(spacing: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to spacing.toDouble())
    TransferContext.callMethod(MethodBindings.setParagraphSpacingPtr)
  }

  public final fun getParagraphSpacing(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParagraphSpacingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFont(font: Font?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font)
    TransferContext.callMethod(MethodBindings.setFontPtr)
  }

  public final fun getFont(): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  public final fun setFontSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setFontSizePtr)
  }

  public final fun getFontSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFontColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setFontColorPtr)
  }

  public final fun getFontColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setOutlineSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setOutlineSizePtr)
  }

  public final fun getOutlineSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutlineSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setOutlineColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setOutlineColorPtr)
  }

  public final fun getOutlineColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutlineColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setShadowSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setShadowSizePtr)
  }

  public final fun getShadowSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setShadowColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setShadowColorPtr)
  }

  public final fun getShadowColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setShadowOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setShadowOffsetPtr)
  }

  public final fun getShadowOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getStackedOutlineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStackedOutlineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setStackedOutlineCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setStackedOutlineCountPtr)
  }

  /**
   * Adds a new stacked outline to the label at the given [index]. If [index] is `-1`, the new
   * stacked outline will be added at the end of the list.
   */
  @JvmOverloads
  public final fun addStackedOutline(index: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.addStackedOutlinePtr)
  }

  /**
   * Moves the stacked outline at index [fromIndex] to the given position [toPosition] in the array.
   */
  public final fun moveStackedOutline(fromIndex: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveStackedOutlinePtr)
  }

  /**
   * Removes the stacked outline at index [index].
   */
  public final fun removeStackedOutline(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removeStackedOutlinePtr)
  }

  /**
   * Sets the size of the stacked outline identified by the given [index] to [size].
   */
  public final fun setStackedOutlineSize(index: Int, size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setStackedOutlineSizePtr)
  }

  /**
   * Returns the size of the stacked outline at [index].
   */
  public final fun getStackedOutlineSize(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStackedOutlineSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the color of the stacked outline identified by the given [index] to [color].
   */
  public final fun setStackedOutlineColor(index: Int, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setStackedOutlineColorPtr)
  }

  /**
   * Returns the color of the stacked outline at [index].
   */
  public final fun getStackedOutlineColor(index: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStackedOutlineColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun getStackedShadowCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStackedShadowCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setStackedShadowCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setStackedShadowCountPtr)
  }

  /**
   * Adds a new stacked shadow to the label at the given [index]. If [index] is `-1`, the new
   * stacked shadow will be added at the end of the list.
   */
  @JvmOverloads
  public final fun addStackedShadow(index: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.addStackedShadowPtr)
  }

  /**
   * Moves the stacked shadow at index [fromIndex] to the given position [toPosition] in the array.
   */
  public final fun moveStackedShadow(fromIndex: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveStackedShadowPtr)
  }

  /**
   * Removes the stacked shadow at index [index].
   */
  public final fun removeStackedShadow(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removeStackedShadowPtr)
  }

  /**
   * Sets the offset of the stacked shadow identified by the given [index] to [offset].
   */
  public final fun setStackedShadowOffset(index: Int, offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setStackedShadowOffsetPtr)
  }

  /**
   * Returns the offset of the stacked shadow at [index].
   */
  public final fun getStackedShadowOffset(index: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStackedShadowOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the color of the stacked shadow identified by the given [index] to [color].
   */
  public final fun setStackedShadowColor(index: Int, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setStackedShadowColorPtr)
  }

  /**
   * Returns the color of the stacked shadow at [index].
   */
  public final fun getStackedShadowColor(index: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStackedShadowColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the outline size of the stacked shadow identified by the given [index] to [size].
   */
  public final fun setStackedShadowOutlineSize(index: Int, size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setStackedShadowOutlineSizePtr)
  }

  /**
   * Returns the outline size of the stacked shadow at [index].
   */
  public final fun getStackedShadowOutlineSize(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStackedShadowOutlineSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public companion object {
    @JvmField
    public val setLineSpacingName: MethodStringName1<LabelSettings, Unit, Float> =
        MethodStringName1<LabelSettings, Unit, Float>("set_line_spacing")

    @JvmField
    public val getLineSpacingName: MethodStringName0<LabelSettings, Float> =
        MethodStringName0<LabelSettings, Float>("get_line_spacing")

    @JvmField
    public val setParagraphSpacingName: MethodStringName1<LabelSettings, Unit, Float> =
        MethodStringName1<LabelSettings, Unit, Float>("set_paragraph_spacing")

    @JvmField
    public val getParagraphSpacingName: MethodStringName0<LabelSettings, Float> =
        MethodStringName0<LabelSettings, Float>("get_paragraph_spacing")

    @JvmField
    public val setFontName: MethodStringName1<LabelSettings, Unit, Font?> =
        MethodStringName1<LabelSettings, Unit, Font?>("set_font")

    @JvmField
    public val getFontName: MethodStringName0<LabelSettings, Font?> =
        MethodStringName0<LabelSettings, Font?>("get_font")

    @JvmField
    public val setFontSizeName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("set_font_size")

    @JvmField
    public val getFontSizeName: MethodStringName0<LabelSettings, Int> =
        MethodStringName0<LabelSettings, Int>("get_font_size")

    @JvmField
    public val setFontColorName: MethodStringName1<LabelSettings, Unit, Color> =
        MethodStringName1<LabelSettings, Unit, Color>("set_font_color")

    @JvmField
    public val getFontColorName: MethodStringName0<LabelSettings, Color> =
        MethodStringName0<LabelSettings, Color>("get_font_color")

    @JvmField
    public val setOutlineSizeName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("set_outline_size")

    @JvmField
    public val getOutlineSizeName: MethodStringName0<LabelSettings, Int> =
        MethodStringName0<LabelSettings, Int>("get_outline_size")

    @JvmField
    public val setOutlineColorName: MethodStringName1<LabelSettings, Unit, Color> =
        MethodStringName1<LabelSettings, Unit, Color>("set_outline_color")

    @JvmField
    public val getOutlineColorName: MethodStringName0<LabelSettings, Color> =
        MethodStringName0<LabelSettings, Color>("get_outline_color")

    @JvmField
    public val setShadowSizeName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("set_shadow_size")

    @JvmField
    public val getShadowSizeName: MethodStringName0<LabelSettings, Int> =
        MethodStringName0<LabelSettings, Int>("get_shadow_size")

    @JvmField
    public val setShadowColorName: MethodStringName1<LabelSettings, Unit, Color> =
        MethodStringName1<LabelSettings, Unit, Color>("set_shadow_color")

    @JvmField
    public val getShadowColorName: MethodStringName0<LabelSettings, Color> =
        MethodStringName0<LabelSettings, Color>("get_shadow_color")

    @JvmField
    public val setShadowOffsetName: MethodStringName1<LabelSettings, Unit, Vector2> =
        MethodStringName1<LabelSettings, Unit, Vector2>("set_shadow_offset")

    @JvmField
    public val getShadowOffsetName: MethodStringName0<LabelSettings, Vector2> =
        MethodStringName0<LabelSettings, Vector2>("get_shadow_offset")

    @JvmField
    public val getStackedOutlineCountName: MethodStringName0<LabelSettings, Int> =
        MethodStringName0<LabelSettings, Int>("get_stacked_outline_count")

    @JvmField
    public val setStackedOutlineCountName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("set_stacked_outline_count")

    @JvmField
    public val addStackedOutlineName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("add_stacked_outline")

    @JvmField
    public val moveStackedOutlineName: MethodStringName2<LabelSettings, Unit, Int, Int> =
        MethodStringName2<LabelSettings, Unit, Int, Int>("move_stacked_outline")

    @JvmField
    public val removeStackedOutlineName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("remove_stacked_outline")

    @JvmField
    public val setStackedOutlineSizeName: MethodStringName2<LabelSettings, Unit, Int, Int> =
        MethodStringName2<LabelSettings, Unit, Int, Int>("set_stacked_outline_size")

    @JvmField
    public val getStackedOutlineSizeName: MethodStringName1<LabelSettings, Int, Int> =
        MethodStringName1<LabelSettings, Int, Int>("get_stacked_outline_size")

    @JvmField
    public val setStackedOutlineColorName: MethodStringName2<LabelSettings, Unit, Int, Color> =
        MethodStringName2<LabelSettings, Unit, Int, Color>("set_stacked_outline_color")

    @JvmField
    public val getStackedOutlineColorName: MethodStringName1<LabelSettings, Color, Int> =
        MethodStringName1<LabelSettings, Color, Int>("get_stacked_outline_color")

    @JvmField
    public val getStackedShadowCountName: MethodStringName0<LabelSettings, Int> =
        MethodStringName0<LabelSettings, Int>("get_stacked_shadow_count")

    @JvmField
    public val setStackedShadowCountName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("set_stacked_shadow_count")

    @JvmField
    public val addStackedShadowName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("add_stacked_shadow")

    @JvmField
    public val moveStackedShadowName: MethodStringName2<LabelSettings, Unit, Int, Int> =
        MethodStringName2<LabelSettings, Unit, Int, Int>("move_stacked_shadow")

    @JvmField
    public val removeStackedShadowName: MethodStringName1<LabelSettings, Unit, Int> =
        MethodStringName1<LabelSettings, Unit, Int>("remove_stacked_shadow")

    @JvmField
    public val setStackedShadowOffsetName: MethodStringName2<LabelSettings, Unit, Int, Vector2> =
        MethodStringName2<LabelSettings, Unit, Int, Vector2>("set_stacked_shadow_offset")

    @JvmField
    public val getStackedShadowOffsetName: MethodStringName1<LabelSettings, Vector2, Int> =
        MethodStringName1<LabelSettings, Vector2, Int>("get_stacked_shadow_offset")

    @JvmField
    public val setStackedShadowColorName: MethodStringName2<LabelSettings, Unit, Int, Color> =
        MethodStringName2<LabelSettings, Unit, Int, Color>("set_stacked_shadow_color")

    @JvmField
    public val getStackedShadowColorName: MethodStringName1<LabelSettings, Color, Int> =
        MethodStringName1<LabelSettings, Color, Int>("get_stacked_shadow_color")

    @JvmField
    public val setStackedShadowOutlineSizeName: MethodStringName2<LabelSettings, Unit, Int, Int> =
        MethodStringName2<LabelSettings, Unit, Int, Int>("set_stacked_shadow_outline_size")

    @JvmField
    public val getStackedShadowOutlineSizeName: MethodStringName1<LabelSettings, Int, Int> =
        MethodStringName1<LabelSettings, Int, Int>("get_stacked_shadow_outline_size")
  }

  public object MethodBindings {
    internal val setLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_line_spacing", 373806689)

    internal val getLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_line_spacing", 1740695150)

    internal val setParagraphSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_paragraph_spacing", 373806689)

    internal val getParagraphSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_paragraph_spacing", 1740695150)

    internal val setFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_font", 1262170328)

    internal val getFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_font", 3229501585)

    internal val setFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_font_size", 1286410249)

    internal val getFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_font_size", 3905245786)

    internal val setFontColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_font_color", 2920490490)

    internal val getFontColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_font_color", 3444240500)

    internal val setOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_outline_size", 1286410249)

    internal val getOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_outline_size", 3905245786)

    internal val setOutlineColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_outline_color", 2920490490)

    internal val getOutlineColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_outline_color", 3444240500)

    internal val setShadowSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_shadow_size", 1286410249)

    internal val getShadowSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_shadow_size", 3905245786)

    internal val setShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_shadow_color", 2920490490)

    internal val getShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_shadow_color", 3444240500)

    internal val setShadowOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_shadow_offset", 743155724)

    internal val getShadowOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_shadow_offset", 3341600327)

    internal val getStackedOutlineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_outline_count", 3905245786)

    internal val setStackedOutlineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_outline_count", 1286410249)

    internal val addStackedOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "add_stacked_outline", 1025054187)

    internal val moveStackedOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "move_stacked_outline", 3937882851)

    internal val removeStackedOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "remove_stacked_outline", 1286410249)

    internal val setStackedOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_outline_size", 3937882851)

    internal val getStackedOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_outline_size", 923996154)

    internal val setStackedOutlineColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_outline_color", 2878471219)

    internal val getStackedOutlineColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_outline_color", 3457211756)

    internal val getStackedShadowCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_shadow_count", 3905245786)

    internal val setStackedShadowCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_shadow_count", 1286410249)

    internal val addStackedShadowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "add_stacked_shadow", 1025054187)

    internal val moveStackedShadowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "move_stacked_shadow", 3937882851)

    internal val removeStackedShadowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "remove_stacked_shadow", 1286410249)

    internal val setStackedShadowOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_shadow_offset", 163021252)

    internal val getStackedShadowOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_shadow_offset", 2299179447)

    internal val setStackedShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_shadow_color", 2878471219)

    internal val getStackedShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_shadow_color", 3457211756)

    internal val setStackedShadowOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "set_stacked_shadow_outline_size", 3937882851)

    internal val getStackedShadowOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LabelSettings", "get_stacked_shadow_outline_size", 923996154)
  }
}
