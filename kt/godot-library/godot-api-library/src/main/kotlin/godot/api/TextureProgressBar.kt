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
import godot.core.MethodStringName2
import godot.core.Side
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * TextureProgressBar works like [ProgressBar], but uses up to 3 textures instead of Godot's [Theme]
 * resource. It can be used to create horizontal, vertical and radial progress bars.
 */
@GodotBaseType
public open class TextureProgressBar : Range() {
  /**
   * The fill direction. See [FillMode] for possible values.
   */
  public final inline var fillMode: Int
    @JvmName("fillModeProperty")
    get() = getFillMode()
    @JvmName("fillModeProperty")
    set(`value`) {
      setFillMode(value)
    }

  /**
   * Starting angle for the fill of [textureProgress] if [fillMode] is [FILL_CLOCKWISE],
   * [FILL_COUNTER_CLOCKWISE], or [FILL_CLOCKWISE_AND_COUNTER_CLOCKWISE]. When the node's `value` is
   * equal to its `min_value`, the texture doesn't show up at all. When the `value` increases, the
   * texture fills and tends towards [radialFillDegrees].
   *
   * **Note:** [radialInitialAngle] is wrapped between `0` and `360` degrees (inclusive).
   */
  public final inline var radialInitialAngle: Float
    @JvmName("radialInitialAngleProperty")
    get() = getRadialInitialAngle()
    @JvmName("radialInitialAngleProperty")
    set(`value`) {
      setRadialInitialAngle(value)
    }

  /**
   * Upper limit for the fill of [textureProgress] if [fillMode] is [FILL_CLOCKWISE],
   * [FILL_COUNTER_CLOCKWISE], or [FILL_CLOCKWISE_AND_COUNTER_CLOCKWISE]. When the node's `value` is
   * equal to its `max_value`, the texture fills up to this angle.
   *
   * See [Range.value], [Range.maxValue].
   */
  public final inline var radialFillDegrees: Float
    @JvmName("radialFillDegreesProperty")
    get() = getFillDegrees()
    @JvmName("radialFillDegreesProperty")
    set(`value`) {
      setFillDegrees(value)
    }

  /**
   * Offsets [textureProgress] if [fillMode] is [FILL_CLOCKWISE], [FILL_COUNTER_CLOCKWISE], or
   * [FILL_CLOCKWISE_AND_COUNTER_CLOCKWISE].
   *
   * **Note:** The effective radial center always stays within the [textureProgress] bounds. If you
   * need to move it outside the texture's bounds, modify the [textureProgress] to contain additional
   * empty space where needed.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var radialCenterOffset: Vector2
    @JvmName("radialCenterOffsetProperty")
    get() = getRadialCenterOffset()
    @JvmName("radialCenterOffsetProperty")
    set(`value`) {
      setRadialCenterOffset(value)
    }

  /**
   * If `true`, Godot treats the bar's textures like in [NinePatchRect]. Use the `stretch_margin_*`
   * properties like [stretchMarginBottom] to set up the nine patch's 3×3 grid. When using a radial
   * [fillMode], this setting will only enable stretching for [textureProgress], while [textureUnder]
   * and [textureOver] will be treated like in [NinePatchRect].
   */
  public final inline var ninePatchStretch: Boolean
    @JvmName("ninePatchStretchProperty")
    get() = getNinePatchStretch()
    @JvmName("ninePatchStretchProperty")
    set(`value`) {
      setNinePatchStretch(value)
    }

  /**
   * The width of the 9-patch's left column. Only effective if [ninePatchStretch] is `true`.
   */
  public final inline var stretchMarginLeft: Int
    @JvmName("stretchMarginLeftProperty")
    get() = getStretchMargin(Side.LEFT)
    @JvmName("stretchMarginLeftProperty")
    set(`value`) {
      setStretchMargin(Side.LEFT, value)
    }

  /**
   * The height of the 9-patch's top row. Only effective if [ninePatchStretch] is `true`.
   */
  public final inline var stretchMarginTop: Int
    @JvmName("stretchMarginTopProperty")
    get() = getStretchMargin(Side.TOP)
    @JvmName("stretchMarginTopProperty")
    set(`value`) {
      setStretchMargin(Side.TOP, value)
    }

  /**
   * The width of the 9-patch's right column. Only effective if [ninePatchStretch] is `true`.
   */
  public final inline var stretchMarginRight: Int
    @JvmName("stretchMarginRightProperty")
    get() = getStretchMargin(Side.RIGHT)
    @JvmName("stretchMarginRightProperty")
    set(`value`) {
      setStretchMargin(Side.RIGHT, value)
    }

  /**
   * The height of the 9-patch's bottom row. A margin of 16 means the 9-slice's bottom corners and
   * side will have a height of 16 pixels. You can set all 4 margin values individually to create
   * panels with non-uniform borders. Only effective if [ninePatchStretch] is `true`.
   */
  public final inline var stretchMarginBottom: Int
    @JvmName("stretchMarginBottomProperty")
    get() = getStretchMargin(Side.BOTTOM)
    @JvmName("stretchMarginBottomProperty")
    set(`value`) {
      setStretchMargin(Side.BOTTOM, value)
    }

  /**
   * [Texture2D] that draws under the progress bar. The bar's background.
   */
  public final inline var textureUnder: Texture2D?
    @JvmName("textureUnderProperty")
    get() = getUnderTexture()
    @JvmName("textureUnderProperty")
    set(`value`) {
      setUnderTexture(value)
    }

  /**
   * [Texture2D] that draws over the progress bar. Use it to add highlights or an upper-frame that
   * hides part of [textureProgress].
   */
  public final inline var textureOver: Texture2D?
    @JvmName("textureOverProperty")
    get() = getOverTexture()
    @JvmName("textureOverProperty")
    set(`value`) {
      setOverTexture(value)
    }

  /**
   * [Texture2D] that clips based on the node's `value` and [fillMode]. As `value` increased, the
   * texture fills up. It shows entirely when `value` reaches `max_value`. It doesn't show at all if
   * `value` is equal to `min_value`.
   *
   * The `value` property comes from [Range]. See [Range.value], [Range.minValue], [Range.maxValue].
   */
  public final inline var textureProgress: Texture2D?
    @JvmName("textureProgressProperty")
    get() = getProgressTexture()
    @JvmName("textureProgressProperty")
    set(`value`) {
      setProgressTexture(value)
    }

  /**
   * The offset of [textureProgress]. Useful for [textureOver] and [textureUnder] with fancy
   * borders, to avoid transparent margins in your progress texture.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var textureProgressOffset: Vector2
    @JvmName("textureProgressOffsetProperty")
    get() = getTextureProgressOffset()
    @JvmName("textureProgressOffsetProperty")
    set(`value`) {
      setTextureProgressOffset(value)
    }

  /**
   * Multiplies the color of the bar's [textureUnder] texture.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tintUnder: Color
    @JvmName("tintUnderProperty")
    get() = getTintUnder()
    @JvmName("tintUnderProperty")
    set(`value`) {
      setTintUnder(value)
    }

  /**
   * Multiplies the color of the bar's [textureOver] texture. The effect is similar to
   * [CanvasItem.modulate], except it only affects this specific texture instead of the entire node.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tintOver: Color
    @JvmName("tintOverProperty")
    get() = getTintOver()
    @JvmName("tintOverProperty")
    set(`value`) {
      setTintOver(value)
    }

  /**
   * Multiplies the color of the bar's [textureProgress] texture.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tintProgress: Color
    @JvmName("tintProgressProperty")
    get() = getTintProgress()
    @JvmName("tintProgressProperty")
    set(`value`) {
      setTintProgress(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(751, scriptPtr)
  }

  /**
   * This is a helper function for [radialCenterOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = textureprogressbar.radialCenterOffset
   * //Your changes
   * textureprogressbar.radialCenterOffset = myCoreType
   * ``````
   *
   * Offsets [textureProgress] if [fillMode] is [FILL_CLOCKWISE], [FILL_COUNTER_CLOCKWISE], or
   * [FILL_CLOCKWISE_AND_COUNTER_CLOCKWISE].
   *
   * **Note:** The effective radial center always stays within the [textureProgress] bounds. If you
   * need to move it outside the texture's bounds, modify the [textureProgress] to contain additional
   * empty space where needed.
   */
  @CoreTypeHelper
  public final fun radialCenterOffsetMutate(block: Vector2.() -> Unit): Vector2 =
      radialCenterOffset.apply {
     block(this)
     radialCenterOffset = this
  }

  /**
   * This is a helper function for [textureProgressOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = textureprogressbar.textureProgressOffset
   * //Your changes
   * textureprogressbar.textureProgressOffset = myCoreType
   * ``````
   *
   * The offset of [textureProgress]. Useful for [textureOver] and [textureUnder] with fancy
   * borders, to avoid transparent margins in your progress texture.
   */
  @CoreTypeHelper
  public final fun textureProgressOffsetMutate(block: Vector2.() -> Unit): Vector2 =
      textureProgressOffset.apply {
     block(this)
     textureProgressOffset = this
  }

  /**
   * This is a helper function for [tintUnder] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = textureprogressbar.tintUnder
   * //Your changes
   * textureprogressbar.tintUnder = myCoreType
   * ``````
   *
   * Multiplies the color of the bar's [textureUnder] texture.
   */
  @CoreTypeHelper
  public final fun tintUnderMutate(block: Color.() -> Unit): Color = tintUnder.apply {
     block(this)
     tintUnder = this
  }

  /**
   * This is a helper function for [tintOver] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = textureprogressbar.tintOver
   * //Your changes
   * textureprogressbar.tintOver = myCoreType
   * ``````
   *
   * Multiplies the color of the bar's [textureOver] texture. The effect is similar to
   * [CanvasItem.modulate], except it only affects this specific texture instead of the entire node.
   */
  @CoreTypeHelper
  public final fun tintOverMutate(block: Color.() -> Unit): Color = tintOver.apply {
     block(this)
     tintOver = this
  }

  /**
   * This is a helper function for [tintProgress] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = textureprogressbar.tintProgress
   * //Your changes
   * textureprogressbar.tintProgress = myCoreType
   * ``````
   *
   * Multiplies the color of the bar's [textureProgress] texture.
   */
  @CoreTypeHelper
  public final fun tintProgressMutate(block: Color.() -> Unit): Color = tintProgress.apply {
     block(this)
     tintProgress = this
  }

  public final fun setUnderTexture(tex: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to tex)
    TransferContext.callMethod(MethodBindings.setUnderTexturePtr)
  }

  public final fun getUnderTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUnderTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setProgressTexture(tex: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to tex)
    TransferContext.callMethod(MethodBindings.setProgressTexturePtr)
  }

  public final fun getProgressTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProgressTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setOverTexture(tex: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to tex)
    TransferContext.callMethod(MethodBindings.setOverTexturePtr)
  }

  public final fun getOverTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOverTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setFillMode(mode: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.toLong())
    TransferContext.callMethod(MethodBindings.setFillModePtr)
  }

  public final fun getFillMode(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFillModePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setTintUnder(tint: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to tint)
    TransferContext.callMethod(MethodBindings.setTintUnderPtr)
  }

  public final fun getTintUnder(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTintUnderPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setTintProgress(tint: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to tint)
    TransferContext.callMethod(MethodBindings.setTintProgressPtr)
  }

  public final fun getTintProgress(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTintProgressPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setTintOver(tint: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to tint)
    TransferContext.callMethod(MethodBindings.setTintOverPtr)
  }

  public final fun getTintOver(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTintOverPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setTextureProgressOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setTextureProgressOffsetPtr)
  }

  public final fun getTextureProgressOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureProgressOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setRadialInitialAngle(mode: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mode.toDouble())
    TransferContext.callMethod(MethodBindings.setRadialInitialAnglePtr)
  }

  public final fun getRadialInitialAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadialInitialAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRadialCenterOffset(mode: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to mode)
    TransferContext.callMethod(MethodBindings.setRadialCenterOffsetPtr)
  }

  public final fun getRadialCenterOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadialCenterOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setFillDegrees(mode: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mode.toDouble())
    TransferContext.callMethod(MethodBindings.setFillDegreesPtr)
  }

  public final fun getFillDegrees(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFillDegreesPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the stretch margin with the specified index. See [stretchMarginBottom] and related
   * properties.
   */
  public final fun setStretchMargin(margin: Side, `value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.setStretchMarginPtr)
  }

  /**
   * Returns the stretch margin with the specified index. See [stretchMarginBottom] and related
   * properties.
   */
  public final fun getStretchMargin(margin: Side): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getStretchMarginPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setNinePatchStretch(stretch: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to stretch)
    TransferContext.callMethod(MethodBindings.setNinePatchStretchPtr)
  }

  public final fun getNinePatchStretch(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNinePatchStretchPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class FillMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The [textureProgress] fills from left to right.
     */
    LEFT_TO_RIGHT(0),
    /**
     * The [textureProgress] fills from right to left.
     */
    RIGHT_TO_LEFT(1),
    /**
     * The [textureProgress] fills from top to bottom.
     */
    TOP_TO_BOTTOM(2),
    /**
     * The [textureProgress] fills from bottom to top.
     */
    BOTTOM_TO_TOP(3),
    /**
     * Turns the node into a radial bar. The [textureProgress] fills clockwise. See
     * [radialCenterOffset], [radialInitialAngle] and [radialFillDegrees] to control the way the bar
     * fills up.
     */
    CLOCKWISE(4),
    /**
     * Turns the node into a radial bar. The [textureProgress] fills counterclockwise. See
     * [radialCenterOffset], [radialInitialAngle] and [radialFillDegrees] to control the way the bar
     * fills up.
     */
    COUNTER_CLOCKWISE(5),
    /**
     * The [textureProgress] fills from the center, expanding both towards the left and the right.
     */
    BILINEAR_LEFT_AND_RIGHT(6),
    /**
     * The [textureProgress] fills from the center, expanding both towards the top and the bottom.
     */
    BILINEAR_TOP_AND_BOTTOM(7),
    /**
     * Turns the node into a radial bar. The [textureProgress] fills radially from the center,
     * expanding both clockwise and counterclockwise. See [radialCenterOffset], [radialInitialAngle]
     * and [radialFillDegrees] to control the way the bar fills up.
     */
    CLOCKWISE_AND_COUNTER_CLOCKWISE(8),
    ;

    public companion object {
      public fun from(`value`: Long): FillMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setUnderTextureName: MethodStringName1<TextureProgressBar, Unit, Texture2D?> =
        MethodStringName1<TextureProgressBar, Unit, Texture2D?>("set_under_texture")

    @JvmField
    public val getUnderTextureName: MethodStringName0<TextureProgressBar, Texture2D?> =
        MethodStringName0<TextureProgressBar, Texture2D?>("get_under_texture")

    @JvmField
    public val setProgressTextureName: MethodStringName1<TextureProgressBar, Unit, Texture2D?> =
        MethodStringName1<TextureProgressBar, Unit, Texture2D?>("set_progress_texture")

    @JvmField
    public val getProgressTextureName: MethodStringName0<TextureProgressBar, Texture2D?> =
        MethodStringName0<TextureProgressBar, Texture2D?>("get_progress_texture")

    @JvmField
    public val setOverTextureName: MethodStringName1<TextureProgressBar, Unit, Texture2D?> =
        MethodStringName1<TextureProgressBar, Unit, Texture2D?>("set_over_texture")

    @JvmField
    public val getOverTextureName: MethodStringName0<TextureProgressBar, Texture2D?> =
        MethodStringName0<TextureProgressBar, Texture2D?>("get_over_texture")

    @JvmField
    public val setFillModeName: MethodStringName1<TextureProgressBar, Unit, Int> =
        MethodStringName1<TextureProgressBar, Unit, Int>("set_fill_mode")

    @JvmField
    public val getFillModeName: MethodStringName0<TextureProgressBar, Int> =
        MethodStringName0<TextureProgressBar, Int>("get_fill_mode")

    @JvmField
    public val setTintUnderName: MethodStringName1<TextureProgressBar, Unit, Color> =
        MethodStringName1<TextureProgressBar, Unit, Color>("set_tint_under")

    @JvmField
    public val getTintUnderName: MethodStringName0<TextureProgressBar, Color> =
        MethodStringName0<TextureProgressBar, Color>("get_tint_under")

    @JvmField
    public val setTintProgressName: MethodStringName1<TextureProgressBar, Unit, Color> =
        MethodStringName1<TextureProgressBar, Unit, Color>("set_tint_progress")

    @JvmField
    public val getTintProgressName: MethodStringName0<TextureProgressBar, Color> =
        MethodStringName0<TextureProgressBar, Color>("get_tint_progress")

    @JvmField
    public val setTintOverName: MethodStringName1<TextureProgressBar, Unit, Color> =
        MethodStringName1<TextureProgressBar, Unit, Color>("set_tint_over")

    @JvmField
    public val getTintOverName: MethodStringName0<TextureProgressBar, Color> =
        MethodStringName0<TextureProgressBar, Color>("get_tint_over")

    @JvmField
    public val setTextureProgressOffsetName: MethodStringName1<TextureProgressBar, Unit, Vector2> =
        MethodStringName1<TextureProgressBar, Unit, Vector2>("set_texture_progress_offset")

    @JvmField
    public val getTextureProgressOffsetName: MethodStringName0<TextureProgressBar, Vector2> =
        MethodStringName0<TextureProgressBar, Vector2>("get_texture_progress_offset")

    @JvmField
    public val setRadialInitialAngleName: MethodStringName1<TextureProgressBar, Unit, Float> =
        MethodStringName1<TextureProgressBar, Unit, Float>("set_radial_initial_angle")

    @JvmField
    public val getRadialInitialAngleName: MethodStringName0<TextureProgressBar, Float> =
        MethodStringName0<TextureProgressBar, Float>("get_radial_initial_angle")

    @JvmField
    public val setRadialCenterOffsetName: MethodStringName1<TextureProgressBar, Unit, Vector2> =
        MethodStringName1<TextureProgressBar, Unit, Vector2>("set_radial_center_offset")

    @JvmField
    public val getRadialCenterOffsetName: MethodStringName0<TextureProgressBar, Vector2> =
        MethodStringName0<TextureProgressBar, Vector2>("get_radial_center_offset")

    @JvmField
    public val setFillDegreesName: MethodStringName1<TextureProgressBar, Unit, Float> =
        MethodStringName1<TextureProgressBar, Unit, Float>("set_fill_degrees")

    @JvmField
    public val getFillDegreesName: MethodStringName0<TextureProgressBar, Float> =
        MethodStringName0<TextureProgressBar, Float>("get_fill_degrees")

    @JvmField
    public val setStretchMarginName: MethodStringName2<TextureProgressBar, Unit, Side, Int> =
        MethodStringName2<TextureProgressBar, Unit, Side, Int>("set_stretch_margin")

    @JvmField
    public val getStretchMarginName: MethodStringName1<TextureProgressBar, Int, Side> =
        MethodStringName1<TextureProgressBar, Int, Side>("get_stretch_margin")

    @JvmField
    public val setNinePatchStretchName: MethodStringName1<TextureProgressBar, Unit, Boolean> =
        MethodStringName1<TextureProgressBar, Unit, Boolean>("set_nine_patch_stretch")

    @JvmField
    public val getNinePatchStretchName: MethodStringName0<TextureProgressBar, Boolean> =
        MethodStringName0<TextureProgressBar, Boolean>("get_nine_patch_stretch")
  }

  public object MethodBindings {
    internal val setUnderTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_under_texture", 4051416890)

    internal val getUnderTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_under_texture", 3635182373)

    internal val setProgressTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_progress_texture", 4051416890)

    internal val getProgressTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_progress_texture", 3635182373)

    internal val setOverTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_over_texture", 4051416890)

    internal val getOverTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_over_texture", 3635182373)

    internal val setFillModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_fill_mode", 1286410249)

    internal val getFillModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_fill_mode", 2455072627)

    internal val setTintUnderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_tint_under", 2920490490)

    internal val getTintUnderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_tint_under", 3444240500)

    internal val setTintProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_tint_progress", 2920490490)

    internal val getTintProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_tint_progress", 3444240500)

    internal val setTintOverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_tint_over", 2920490490)

    internal val getTintOverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_tint_over", 3444240500)

    internal val setTextureProgressOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_texture_progress_offset", 743155724)

    internal val getTextureProgressOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_texture_progress_offset", 3341600327)

    internal val setRadialInitialAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_radial_initial_angle", 373806689)

    internal val getRadialInitialAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_radial_initial_angle", 191475506)

    internal val setRadialCenterOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_radial_center_offset", 743155724)

    internal val getRadialCenterOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_radial_center_offset", 1497962370)

    internal val setFillDegreesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_fill_degrees", 373806689)

    internal val getFillDegreesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_fill_degrees", 191475506)

    internal val setStretchMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_stretch_margin", 437707142)

    internal val getStretchMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_stretch_margin", 1983885014)

    internal val setNinePatchStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "set_nine_patch_stretch", 2586408642)

    internal val getNinePatchStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureProgressBar", "get_nine_patch_stretch", 36873697)
  }
}
