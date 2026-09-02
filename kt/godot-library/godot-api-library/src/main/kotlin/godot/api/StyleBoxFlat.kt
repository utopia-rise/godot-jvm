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
import godot.core.Corner
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Rect2
import godot.core.Side
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * By configuring various properties of this style box, you can achieve many common looks without
 * the need of a texture. This includes optionally rounded borders, antialiasing, shadows, and skew.
 *
 * Setting corner radius to high values is allowed. As soon as corners overlap, the stylebox will
 * switch to a relative system:
 *
 * [codeblock lang=text]
 *
 * height = 30
 *
 * corner_radius_top_left = 50
 *
 * corner_radius_bottom_left = 100
 *
 * ```
 * The relative system now would take the 1:2 ratio of the two left corners to calculate the actual
 * corner width. Both corners added will **never** be more than the height. Result:
 * [codeblock lang=text]
 * corner_radius_top_left: 10
 * corner_radius_bottom_left: 20
 * ```
 */
@GodotBaseType
public open class StyleBoxFlat : StyleBox() {
  /**
   * The background color of the stylebox.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bgColor: Color
    @JvmName("bgColorProperty")
    get() = getBgColor()
    @JvmName("bgColorProperty")
    set(`value`) {
      setBgColor(value)
    }

  /**
   * Toggles drawing of the inner part of the stylebox.
   */
  public final inline var drawCenter: Boolean
    @JvmName("drawCenterProperty")
    get() = isDrawCenterEnabled()
    @JvmName("drawCenterProperty")
    set(`value`) {
      setDrawCenter(value)
    }

  /**
   * If set to a non-zero value on either axis, [skew] distorts the StyleBox horizontally and/or
   * vertically. This can be used for "futuristic"-style UIs. Positive values skew the StyleBox towards
   * the right (X axis) and upwards (Y axis), while negative values skew the StyleBox towards the left
   * (X axis) and downwards (Y axis).
   *
   * **Note:** To ensure text does not touch the StyleBox's edges, consider increasing the
   * [StyleBox]'s content margin (see [StyleBox.contentMarginBottom]). It is preferable to increase the
   * content margin instead of the expand margin (see [expandMarginBottom]), as increasing the expand
   * margin does not increase the size of the clickable area for [Control]s.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var skew: Vector2
    @JvmName("skewProperty")
    get() = getSkew()
    @JvmName("skewProperty")
    set(`value`) {
      setSkew(value)
    }

  /**
   * Border width for the left border.
   */
  public final inline var borderWidthLeft: Int
    @JvmName("borderWidthLeftProperty")
    get() = getBorderWidth(Side.LEFT)
    @JvmName("borderWidthLeftProperty")
    set(`value`) {
      setBorderWidth(Side.LEFT, value)
    }

  /**
   * Border width for the top border.
   */
  public final inline var borderWidthTop: Int
    @JvmName("borderWidthTopProperty")
    get() = getBorderWidth(Side.TOP)
    @JvmName("borderWidthTopProperty")
    set(`value`) {
      setBorderWidth(Side.TOP, value)
    }

  /**
   * Border width for the right border.
   */
  public final inline var borderWidthRight: Int
    @JvmName("borderWidthRightProperty")
    get() = getBorderWidth(Side.RIGHT)
    @JvmName("borderWidthRightProperty")
    set(`value`) {
      setBorderWidth(Side.RIGHT, value)
    }

  /**
   * Border width for the bottom border.
   */
  public final inline var borderWidthBottom: Int
    @JvmName("borderWidthBottomProperty")
    get() = getBorderWidth(Side.BOTTOM)
    @JvmName("borderWidthBottomProperty")
    set(`value`) {
      setBorderWidth(Side.BOTTOM, value)
    }

  /**
   * Sets the color of the border.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var borderColor: Color
    @JvmName("borderColorProperty")
    get() = getBorderColor()
    @JvmName("borderColorProperty")
    set(`value`) {
      setBorderColor(value)
    }

  /**
   * If `true`, the border will fade into the background color.
   */
  public final inline var borderBlend: Boolean
    @JvmName("borderBlendProperty")
    get() = getBorderBlend()
    @JvmName("borderBlendProperty")
    set(`value`) {
      setBorderBlend(value)
    }

  /**
   * The top-left corner's radius. If `0`, the corner is not rounded.
   */
  public final inline var cornerRadiusTopLeft: Int
    @JvmName("cornerRadiusTopLeftProperty")
    get() = getCornerRadius(Corner.TOP_LEFT)
    @JvmName("cornerRadiusTopLeftProperty")
    set(`value`) {
      setCornerRadius(Corner.TOP_LEFT, value)
    }

  /**
   * The top-right corner's radius. If `0`, the corner is not rounded.
   */
  public final inline var cornerRadiusTopRight: Int
    @JvmName("cornerRadiusTopRightProperty")
    get() = getCornerRadius(Corner.TOP_RIGHT)
    @JvmName("cornerRadiusTopRightProperty")
    set(`value`) {
      setCornerRadius(Corner.TOP_RIGHT, value)
    }

  /**
   * The bottom-right corner's radius. If `0`, the corner is not rounded.
   */
  public final inline var cornerRadiusBottomRight: Int
    @JvmName("cornerRadiusBottomRightProperty")
    get() = getCornerRadius(Corner.BOTTOM_RIGHT)
    @JvmName("cornerRadiusBottomRightProperty")
    set(`value`) {
      setCornerRadius(Corner.BOTTOM_RIGHT, value)
    }

  /**
   * The bottom-left corner's radius. If `0`, the corner is not rounded.
   */
  public final inline var cornerRadiusBottomLeft: Int
    @JvmName("cornerRadiusBottomLeftProperty")
    get() = getCornerRadius(Corner.BOTTOM_LEFT)
    @JvmName("cornerRadiusBottomLeftProperty")
    set(`value`) {
      setCornerRadius(Corner.BOTTOM_LEFT, value)
    }

  /**
   * This sets the number of vertices used for each corner. Higher values result in rounder corners
   * but take more processing power to compute. When choosing a value, you should take the corner
   * radius ([setCornerRadiusAll]) into account.
   *
   * For corner radii less than 10, `4` or `5` should be enough. For corner radii less than 30,
   * values between `8` and `12` should be enough.
   *
   * A corner detail of `1` will result in chamfered corners instead of rounded corners, which is
   * useful for some artistic effects.
   */
  public final inline var cornerDetail: Int
    @JvmName("cornerDetailProperty")
    get() = getCornerDetail()
    @JvmName("cornerDetailProperty")
    set(`value`) {
      setCornerDetail(value)
    }

  /**
   * Expands the stylebox outside of the control rect on the left edge. Useful in combination with
   * [borderWidthLeft] to draw a border outside the control rect.
   *
   * **Note:** Unlike [StyleBox.contentMarginLeft], [expandMarginLeft] does *not* affect the size of
   * the clickable area for [Control]s. This can negatively impact usability if used wrong, as the user
   * may try to click an area of the StyleBox that cannot actually receive clicks.
   */
  public final inline var expandMarginLeft: Float
    @JvmName("expandMarginLeftProperty")
    get() = getExpandMargin(Side.LEFT)
    @JvmName("expandMarginLeftProperty")
    set(`value`) {
      setExpandMargin(Side.LEFT, value)
    }

  /**
   * Expands the stylebox outside of the control rect on the top edge. Useful in combination with
   * [borderWidthTop] to draw a border outside the control rect.
   *
   * **Note:** Unlike [StyleBox.contentMarginTop], [expandMarginTop] does *not* affect the size of
   * the clickable area for [Control]s. This can negatively impact usability if used wrong, as the user
   * may try to click an area of the StyleBox that cannot actually receive clicks.
   */
  public final inline var expandMarginTop: Float
    @JvmName("expandMarginTopProperty")
    get() = getExpandMargin(Side.TOP)
    @JvmName("expandMarginTopProperty")
    set(`value`) {
      setExpandMargin(Side.TOP, value)
    }

  /**
   * Expands the stylebox outside of the control rect on the right edge. Useful in combination with
   * [borderWidthRight] to draw a border outside the control rect.
   *
   * **Note:** Unlike [StyleBox.contentMarginRight], [expandMarginRight] does *not* affect the size
   * of the clickable area for [Control]s. This can negatively impact usability if used wrong, as the
   * user may try to click an area of the StyleBox that cannot actually receive clicks.
   */
  public final inline var expandMarginRight: Float
    @JvmName("expandMarginRightProperty")
    get() = getExpandMargin(Side.RIGHT)
    @JvmName("expandMarginRightProperty")
    set(`value`) {
      setExpandMargin(Side.RIGHT, value)
    }

  /**
   * Expands the stylebox outside of the control rect on the bottom edge. Useful in combination with
   * [borderWidthBottom] to draw a border outside the control rect.
   *
   * **Note:** Unlike [StyleBox.contentMarginBottom], [expandMarginBottom] does *not* affect the
   * size of the clickable area for [Control]s. This can negatively impact usability if used wrong, as
   * the user may try to click an area of the StyleBox that cannot actually receive clicks.
   */
  public final inline var expandMarginBottom: Float
    @JvmName("expandMarginBottomProperty")
    get() = getExpandMargin(Side.BOTTOM)
    @JvmName("expandMarginBottomProperty")
    set(`value`) {
      setExpandMargin(Side.BOTTOM, value)
    }

  /**
   * The color of the shadow. This has no effect if [shadowSize] is lower than 1.
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
   * The shadow size in pixels.
   */
  public final inline var shadowSize: Int
    @JvmName("shadowSizeProperty")
    get() = getShadowSize()
    @JvmName("shadowSizeProperty")
    set(`value`) {
      setShadowSize(value)
    }

  /**
   * The shadow offset in pixels. Adjusts the position of the shadow relatively to the stylebox.
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
   * Antialiasing draws a small ring around the edges, which fades to transparency. As a result,
   * edges look much smoother. This is only noticeable when using rounded corners or [skew].
   *
   * **Note:** When using beveled corners with 45-degree angles ([cornerDetail] = 1), it is
   * recommended to set [antiAliasing] to `false` to ensure crisp visuals and avoid possible visual
   * glitches.
   */
  public final inline var antiAliasing: Boolean
    @JvmName("antiAliasingProperty")
    get() = isAntiAliased()
    @JvmName("antiAliasingProperty")
    set(`value`) {
      setAntiAliased(value)
    }

  /**
   * This changes the size of the antialiasing effect. `1.0` is recommended for an optimal result at
   * 100&#37; scale, identical to how rounded rectangles are rendered in web browsers and most vector
   * drawing software.
   *
   * **Note:** Higher values may produce a blur effect but can also create undesired artifacts on
   * small boxes with large-radius corners.
   */
  public final inline var antiAliasingSize: Float
    @JvmName("antiAliasingSizeProperty")
    get() = getAaSize()
    @JvmName("antiAliasingSizeProperty")
    set(`value`) {
      setAaSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(717, scriptPtr)
  }

  /**
   * This is a helper function for [bgColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxflat.bgColor
   * //Your changes
   * styleboxflat.bgColor = myCoreType
   * ``````
   *
   * The background color of the stylebox.
   */
  @CoreTypeHelper
  public final fun bgColorMutate(block: Color.() -> Unit): Color = bgColor.apply {
     block(this)
     bgColor = this
  }

  /**
   * This is a helper function for [skew] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxflat.skew
   * //Your changes
   * styleboxflat.skew = myCoreType
   * ``````
   *
   * If set to a non-zero value on either axis, [skew] distorts the StyleBox horizontally and/or
   * vertically. This can be used for "futuristic"-style UIs. Positive values skew the StyleBox towards
   * the right (X axis) and upwards (Y axis), while negative values skew the StyleBox towards the left
   * (X axis) and downwards (Y axis).
   *
   * **Note:** To ensure text does not touch the StyleBox's edges, consider increasing the
   * [StyleBox]'s content margin (see [StyleBox.contentMarginBottom]). It is preferable to increase the
   * content margin instead of the expand margin (see [expandMarginBottom]), as increasing the expand
   * margin does not increase the size of the clickable area for [Control]s.
   */
  @CoreTypeHelper
  public final fun skewMutate(block: Vector2.() -> Unit): Vector2 = skew.apply {
     block(this)
     skew = this
  }

  /**
   * This is a helper function for [borderColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxflat.borderColor
   * //Your changes
   * styleboxflat.borderColor = myCoreType
   * ``````
   *
   * Sets the color of the border.
   */
  @CoreTypeHelper
  public final fun borderColorMutate(block: Color.() -> Unit): Color = borderColor.apply {
     block(this)
     borderColor = this
  }

  /**
   * This is a helper function for [shadowColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxflat.shadowColor
   * //Your changes
   * styleboxflat.shadowColor = myCoreType
   * ``````
   *
   * The color of the shadow. This has no effect if [shadowSize] is lower than 1.
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
   * val myCoreType = styleboxflat.shadowOffset
   * //Your changes
   * styleboxflat.shadowOffset = myCoreType
   * ``````
   *
   * The shadow offset in pixels. Adjusts the position of the shadow relatively to the stylebox.
   */
  @CoreTypeHelper
  public final fun shadowOffsetMutate(block: Vector2.() -> Unit): Vector2 = shadowOffset.apply {
     block(this)
     shadowOffset = this
  }

  public final fun setBgColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setBgColorPtr)
  }

  public final fun getBgColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBgColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setBorderColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setBorderColorPtr)
  }

  public final fun getBorderColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the border width to [width] pixels for all sides.
   */
  public final fun setBorderWidthAll(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setBorderWidthAllPtr)
  }

  /**
   * Returns the smallest border width out of all four borders.
   */
  public final fun getBorderWidthMin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderWidthMinPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the specified [Side]'s border width to [width] pixels.
   */
  public final fun setBorderWidth(margin: Side, width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setBorderWidthPtr)
  }

  /**
   * Returns the specified [Side]'s border width.
   */
  public final fun getBorderWidth(margin: Side): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getBorderWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setBorderBlend(blend: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to blend)
    TransferContext.callMethod(MethodBindings.setBorderBlendPtr)
  }

  public final fun getBorderBlend(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderBlendPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the corner radius to [radius] pixels for all corners.
   */
  public final fun setCornerRadiusAll(radius: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to radius.toLong())
    TransferContext.callMethod(MethodBindings.setCornerRadiusAllPtr)
  }

  /**
   * Sets the corner radius to [radius] pixels for the given [corner].
   */
  public final fun setCornerRadius(corner: Corner, radius: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to corner.value, LONG to radius.toLong())
    TransferContext.callMethod(MethodBindings.setCornerRadiusPtr)
  }

  /**
   * Returns the given [corner]'s radius.
   */
  public final fun getCornerRadius(corner: Corner): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to corner.value)
    TransferContext.callMethod(MethodBindings.getCornerRadiusPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the expand margin to [size] pixels for the specified [Side].
   */
  public final fun setExpandMargin(margin: Side, size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setExpandMarginPtr)
  }

  /**
   * Sets the expand margin to [size] pixels for all sides.
   */
  public final fun setExpandMarginAll(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setExpandMarginAllPtr)
  }

  /**
   * Returns the size of the specified [Side]'s expand margin.
   */
  public final fun getExpandMargin(margin: Side): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getExpandMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDrawCenter(drawCenter: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to drawCenter)
    TransferContext.callMethod(MethodBindings.setDrawCenterPtr)
  }

  public final fun isDrawCenterEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawCenterEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSkew(skew: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to skew)
    TransferContext.callMethod(MethodBindings.setSkewPtr)
  }

  public final fun getSkew(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkewPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
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

  public final fun setShadowSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setShadowSizePtr)
  }

  public final fun getShadowSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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

  public final fun setAntiAliased(antiAliased: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to antiAliased)
    TransferContext.callMethod(MethodBindings.setAntiAliasedPtr)
  }

  public final fun isAntiAliased(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAntiAliasedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAaSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setAaSizePtr)
  }

  public final fun getAaSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAaSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCornerDetail(detail: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to detail.toLong())
    TransferContext.callMethod(MethodBindings.setCornerDetailPtr)
  }

  public final fun getCornerDetail(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCornerDetailPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _draw(toCanvasItem: RID, rect: Rect2): Unit {
    throw NotImplementedError("StyleBoxFlat::_draw can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setBgColorName: MethodStringName1<StyleBoxFlat, Unit, Color> =
        MethodStringName1<StyleBoxFlat, Unit, Color>("set_bg_color")

    @JvmField
    public val getBgColorName: MethodStringName0<StyleBoxFlat, Color> =
        MethodStringName0<StyleBoxFlat, Color>("get_bg_color")

    @JvmField
    public val setBorderColorName: MethodStringName1<StyleBoxFlat, Unit, Color> =
        MethodStringName1<StyleBoxFlat, Unit, Color>("set_border_color")

    @JvmField
    public val getBorderColorName: MethodStringName0<StyleBoxFlat, Color> =
        MethodStringName0<StyleBoxFlat, Color>("get_border_color")

    @JvmField
    public val setBorderWidthAllName: MethodStringName1<StyleBoxFlat, Unit, Int> =
        MethodStringName1<StyleBoxFlat, Unit, Int>("set_border_width_all")

    @JvmField
    public val getBorderWidthMinName: MethodStringName0<StyleBoxFlat, Int> =
        MethodStringName0<StyleBoxFlat, Int>("get_border_width_min")

    @JvmField
    public val setBorderWidthName: MethodStringName2<StyleBoxFlat, Unit, Side, Int> =
        MethodStringName2<StyleBoxFlat, Unit, Side, Int>("set_border_width")

    @JvmField
    public val getBorderWidthName: MethodStringName1<StyleBoxFlat, Int, Side> =
        MethodStringName1<StyleBoxFlat, Int, Side>("get_border_width")

    @JvmField
    public val setBorderBlendName: MethodStringName1<StyleBoxFlat, Unit, Boolean> =
        MethodStringName1<StyleBoxFlat, Unit, Boolean>("set_border_blend")

    @JvmField
    public val getBorderBlendName: MethodStringName0<StyleBoxFlat, Boolean> =
        MethodStringName0<StyleBoxFlat, Boolean>("get_border_blend")

    @JvmField
    public val setCornerRadiusAllName: MethodStringName1<StyleBoxFlat, Unit, Int> =
        MethodStringName1<StyleBoxFlat, Unit, Int>("set_corner_radius_all")

    @JvmField
    public val setCornerRadiusName: MethodStringName2<StyleBoxFlat, Unit, Corner, Int> =
        MethodStringName2<StyleBoxFlat, Unit, Corner, Int>("set_corner_radius")

    @JvmField
    public val getCornerRadiusName: MethodStringName1<StyleBoxFlat, Int, Corner> =
        MethodStringName1<StyleBoxFlat, Int, Corner>("get_corner_radius")

    @JvmField
    public val setExpandMarginName: MethodStringName2<StyleBoxFlat, Unit, Side, Float> =
        MethodStringName2<StyleBoxFlat, Unit, Side, Float>("set_expand_margin")

    @JvmField
    public val setExpandMarginAllName: MethodStringName1<StyleBoxFlat, Unit, Float> =
        MethodStringName1<StyleBoxFlat, Unit, Float>("set_expand_margin_all")

    @JvmField
    public val getExpandMarginName: MethodStringName1<StyleBoxFlat, Float, Side> =
        MethodStringName1<StyleBoxFlat, Float, Side>("get_expand_margin")

    @JvmField
    public val setDrawCenterName: MethodStringName1<StyleBoxFlat, Unit, Boolean> =
        MethodStringName1<StyleBoxFlat, Unit, Boolean>("set_draw_center")

    @JvmField
    public val isDrawCenterEnabledName: MethodStringName0<StyleBoxFlat, Boolean> =
        MethodStringName0<StyleBoxFlat, Boolean>("is_draw_center_enabled")

    @JvmField
    public val setSkewName: MethodStringName1<StyleBoxFlat, Unit, Vector2> =
        MethodStringName1<StyleBoxFlat, Unit, Vector2>("set_skew")

    @JvmField
    public val getSkewName: MethodStringName0<StyleBoxFlat, Vector2> =
        MethodStringName0<StyleBoxFlat, Vector2>("get_skew")

    @JvmField
    public val setShadowColorName: MethodStringName1<StyleBoxFlat, Unit, Color> =
        MethodStringName1<StyleBoxFlat, Unit, Color>("set_shadow_color")

    @JvmField
    public val getShadowColorName: MethodStringName0<StyleBoxFlat, Color> =
        MethodStringName0<StyleBoxFlat, Color>("get_shadow_color")

    @JvmField
    public val setShadowSizeName: MethodStringName1<StyleBoxFlat, Unit, Int> =
        MethodStringName1<StyleBoxFlat, Unit, Int>("set_shadow_size")

    @JvmField
    public val getShadowSizeName: MethodStringName0<StyleBoxFlat, Int> =
        MethodStringName0<StyleBoxFlat, Int>("get_shadow_size")

    @JvmField
    public val setShadowOffsetName: MethodStringName1<StyleBoxFlat, Unit, Vector2> =
        MethodStringName1<StyleBoxFlat, Unit, Vector2>("set_shadow_offset")

    @JvmField
    public val getShadowOffsetName: MethodStringName0<StyleBoxFlat, Vector2> =
        MethodStringName0<StyleBoxFlat, Vector2>("get_shadow_offset")

    @JvmField
    public val setAntiAliasedName: MethodStringName1<StyleBoxFlat, Unit, Boolean> =
        MethodStringName1<StyleBoxFlat, Unit, Boolean>("set_anti_aliased")

    @JvmField
    public val isAntiAliasedName: MethodStringName0<StyleBoxFlat, Boolean> =
        MethodStringName0<StyleBoxFlat, Boolean>("is_anti_aliased")

    @JvmField
    public val setAaSizeName: MethodStringName1<StyleBoxFlat, Unit, Float> =
        MethodStringName1<StyleBoxFlat, Unit, Float>("set_aa_size")

    @JvmField
    public val getAaSizeName: MethodStringName0<StyleBoxFlat, Float> =
        MethodStringName0<StyleBoxFlat, Float>("get_aa_size")

    @JvmField
    public val setCornerDetailName: MethodStringName1<StyleBoxFlat, Unit, Int> =
        MethodStringName1<StyleBoxFlat, Unit, Int>("set_corner_detail")

    @JvmField
    public val getCornerDetailName: MethodStringName0<StyleBoxFlat, Int> =
        MethodStringName0<StyleBoxFlat, Int>("get_corner_detail")
  }

  public object MethodBindings {
    internal val setBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_bg_color", 2920490490)

    internal val getBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_bg_color", 3444240500)

    internal val setBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_border_color", 2920490490)

    internal val getBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_border_color", 3444240500)

    internal val setBorderWidthAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_border_width_all", 1286410249)

    internal val getBorderWidthMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_border_width_min", 3905245786)

    internal val setBorderWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_border_width", 437707142)

    internal val getBorderWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_border_width", 1983885014)

    internal val setBorderBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_border_blend", 2586408642)

    internal val getBorderBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_border_blend", 36873697)

    internal val setCornerRadiusAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_corner_radius_all", 1286410249)

    internal val setCornerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_corner_radius", 2696158768)

    internal val getCornerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_corner_radius", 3982397690)

    internal val setExpandMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_expand_margin", 4290182280)

    internal val setExpandMarginAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_expand_margin_all", 373806689)

    internal val getExpandMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_expand_margin", 2869120046)

    internal val setDrawCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_draw_center", 2586408642)

    internal val isDrawCenterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "is_draw_center_enabled", 36873697)

    internal val setSkewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_skew", 743155724)

    internal val getSkewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_skew", 3341600327)

    internal val setShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_shadow_color", 2920490490)

    internal val getShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_shadow_color", 3444240500)

    internal val setShadowSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_shadow_size", 1286410249)

    internal val getShadowSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_shadow_size", 3905245786)

    internal val setShadowOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_shadow_offset", 743155724)

    internal val getShadowOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_shadow_offset", 3341600327)

    internal val setAntiAliasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_anti_aliased", 2586408642)

    internal val isAntiAliasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "is_anti_aliased", 36873697)

    internal val setAaSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_aa_size", 373806689)

    internal val getAaSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_aa_size", 1740695150)

    internal val setCornerDetailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "set_corner_detail", 1286410249)

    internal val getCornerDetailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxFlat", "get_corner_detail", 3905245786)
  }
}
