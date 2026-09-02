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
import godot.core.RID
import godot.core.Rect2
import godot.core.Side
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A texture-based nine-patch [StyleBox], in a way similar to [NinePatchRect]. This stylebox
 * performs a 3×3 scaling of a texture, where only the center cell is fully stretched. This makes it
 * possible to design bordered styles regardless of the stylebox's size.
 */
@GodotBaseType
public open class StyleBoxTexture : StyleBox() {
  /**
   * The texture to use when drawing this style box.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * Increases the left margin of the 3×3 texture box.
   *
   * A higher value means more of the source texture is considered to be part of the left border of
   * the 3×3 box.
   *
   * This is also the value used as fallback for [StyleBox.contentMarginLeft] if it is negative.
   */
  public final inline var textureMarginLeft: Float
    @JvmName("textureMarginLeftProperty")
    get() = getTextureMargin(Side.LEFT)
    @JvmName("textureMarginLeftProperty")
    set(`value`) {
      setTextureMargin(Side.LEFT, value)
    }

  /**
   * Increases the top margin of the 3×3 texture box.
   *
   * A higher value means more of the source texture is considered to be part of the top border of
   * the 3×3 box.
   *
   * This is also the value used as fallback for [StyleBox.contentMarginTop] if it is negative.
   */
  public final inline var textureMarginTop: Float
    @JvmName("textureMarginTopProperty")
    get() = getTextureMargin(Side.TOP)
    @JvmName("textureMarginTopProperty")
    set(`value`) {
      setTextureMargin(Side.TOP, value)
    }

  /**
   * Increases the right margin of the 3×3 texture box.
   *
   * A higher value means more of the source texture is considered to be part of the right border of
   * the 3×3 box.
   *
   * This is also the value used as fallback for [StyleBox.contentMarginRight] if it is negative.
   */
  public final inline var textureMarginRight: Float
    @JvmName("textureMarginRightProperty")
    get() = getTextureMargin(Side.RIGHT)
    @JvmName("textureMarginRightProperty")
    set(`value`) {
      setTextureMargin(Side.RIGHT, value)
    }

  /**
   * Increases the bottom margin of the 3×3 texture box.
   *
   * A higher value means more of the source texture is considered to be part of the bottom border
   * of the 3×3 box.
   *
   * This is also the value used as fallback for [StyleBox.contentMarginBottom] if it is negative.
   */
  public final inline var textureMarginBottom: Float
    @JvmName("textureMarginBottomProperty")
    get() = getTextureMargin(Side.BOTTOM)
    @JvmName("textureMarginBottomProperty")
    set(`value`) {
      setTextureMargin(Side.BOTTOM, value)
    }

  /**
   * Expands the left margin of this style box when drawing, causing it to be drawn larger than
   * requested.
   */
  public final inline var expandMarginLeft: Float
    @JvmName("expandMarginLeftProperty")
    get() = getExpandMargin(Side.LEFT)
    @JvmName("expandMarginLeftProperty")
    set(`value`) {
      setExpandMargin(Side.LEFT, value)
    }

  /**
   * Expands the top margin of this style box when drawing, causing it to be drawn larger than
   * requested.
   */
  public final inline var expandMarginTop: Float
    @JvmName("expandMarginTopProperty")
    get() = getExpandMargin(Side.TOP)
    @JvmName("expandMarginTopProperty")
    set(`value`) {
      setExpandMargin(Side.TOP, value)
    }

  /**
   * Expands the right margin of this style box when drawing, causing it to be drawn larger than
   * requested.
   */
  public final inline var expandMarginRight: Float
    @JvmName("expandMarginRightProperty")
    get() = getExpandMargin(Side.RIGHT)
    @JvmName("expandMarginRightProperty")
    set(`value`) {
      setExpandMargin(Side.RIGHT, value)
    }

  /**
   * Expands the bottom margin of this style box when drawing, causing it to be drawn larger than
   * requested.
   */
  public final inline var expandMarginBottom: Float
    @JvmName("expandMarginBottomProperty")
    get() = getExpandMargin(Side.BOTTOM)
    @JvmName("expandMarginBottomProperty")
    set(`value`) {
      setExpandMargin(Side.BOTTOM, value)
    }

  /**
   * Controls how the stylebox's texture will be stretched or tiled horizontally.
   */
  public final inline var axisStretchHorizontal: AxisStretchMode
    @JvmName("axisStretchHorizontalProperty")
    get() = getHAxisStretchMode()
    @JvmName("axisStretchHorizontalProperty")
    set(`value`) {
      setHAxisStretchMode(value)
    }

  /**
   * Controls how the stylebox's texture will be stretched or tiled vertically.
   */
  public final inline var axisStretchVertical: AxisStretchMode
    @JvmName("axisStretchVerticalProperty")
    get() = getVAxisStretchMode()
    @JvmName("axisStretchVerticalProperty")
    set(`value`) {
      setVAxisStretchMode(value)
    }

  /**
   * The region to use from the [texture].
   *
   * This is equivalent to first wrapping the [texture] in an [AtlasTexture] with the same region.
   *
   * If empty (`Rect2(0, 0, 0, 0)`), the whole [texture] is used.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var regionRect: Rect2
    @JvmName("regionRectProperty")
    get() = getRegionRect()
    @JvmName("regionRectProperty")
    set(`value`) {
      setRegionRect(value)
    }

  /**
   * Modulates the color of the texture when this style box is drawn.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var modulateColor: Color
    @JvmName("modulateColorProperty")
    get() = getModulate()
    @JvmName("modulateColorProperty")
    set(`value`) {
      setModulate(value)
    }

  /**
   * If `true`, the nine-patch texture's center tile will be drawn.
   */
  public final inline var drawCenter: Boolean
    @JvmName("drawCenterProperty")
    get() = isDrawCenterEnabled()
    @JvmName("drawCenterProperty")
    set(`value`) {
      setDrawCenter(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(719, scriptPtr)
  }

  /**
   * This is a helper function for [regionRect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxtexture.regionRect
   * //Your changes
   * styleboxtexture.regionRect = myCoreType
   * ``````
   *
   * The region to use from the [texture].
   *
   * This is equivalent to first wrapping the [texture] in an [AtlasTexture] with the same region.
   *
   * If empty (`Rect2(0, 0, 0, 0)`), the whole [texture] is used.
   */
  @CoreTypeHelper
  public final fun regionRectMutate(block: Rect2.() -> Unit): Rect2 = regionRect.apply {
     block(this)
     regionRect = this
  }

  /**
   * This is a helper function for [modulateColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = styleboxtexture.modulateColor
   * //Your changes
   * styleboxtexture.modulateColor = myCoreType
   * ``````
   *
   * Modulates the color of the texture when this style box is drawn.
   */
  @CoreTypeHelper
  public final fun modulateColorMutate(block: Color.() -> Unit): Color = modulateColor.apply {
     block(this)
     modulateColor = this
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Sets the margin to [size] pixels for the specified [Side].
   */
  public final fun setTextureMargin(margin: Side, size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setTextureMarginPtr)
  }

  /**
   * Sets the margin to [size] pixels for all sides.
   */
  public final fun setTextureMarginAll(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setTextureMarginAllPtr)
  }

  /**
   * Returns the margin size of the specified [Side].
   */
  public final fun getTextureMargin(margin: Side): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getTextureMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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
   * Returns the expand margin size of the specified [Side].
   */
  public final fun getExpandMargin(margin: Side): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getExpandMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRegionRect(region: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to region)
    TransferContext.callMethod(MethodBindings.setRegionRectPtr)
  }

  public final fun getRegionRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRegionRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setDrawCenter(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawCenterPtr)
  }

  public final fun isDrawCenterEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawCenterEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setModulate(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setModulatePtr)
  }

  public final fun getModulate(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setHAxisStretchMode(mode: AxisStretchMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setHAxisStretchModePtr)
  }

  public final fun getHAxisStretchMode(): AxisStretchMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHAxisStretchModePtr)
    return AxisStretchMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVAxisStretchMode(mode: AxisStretchMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVAxisStretchModePtr)
  }

  public final fun getVAxisStretchMode(): AxisStretchMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVAxisStretchModePtr)
    return AxisStretchMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _draw(toCanvasItem: RID, rect: Rect2): Unit {
    throw NotImplementedError("StyleBoxTexture::_draw can't be called from the JVM.")
  }

  public enum class AxisStretchMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Stretch the stylebox's texture. This results in visible distortion unless the texture size
     * matches the stylebox's size perfectly.
     */
    STRETCH(0),
    /**
     * Repeats the stylebox's texture to match the stylebox's size according to the nine-patch
     * system.
     */
    TILE(1),
    /**
     * Repeats the stylebox's texture to match the stylebox's size according to the nine-patch
     * system. Unlike [AXIS_STRETCH_MODE_TILE], the texture may be slightly stretched to make the
     * nine-patch texture tile seamlessly.
     */
    TILE_FIT(2),
    ;

    public companion object {
      public fun from(`value`: Long): AxisStretchMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<StyleBoxTexture, Unit, Texture2D?> =
        MethodStringName1<StyleBoxTexture, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<StyleBoxTexture, Texture2D?> =
        MethodStringName0<StyleBoxTexture, Texture2D?>("get_texture")

    @JvmField
    public val setTextureMarginName: MethodStringName2<StyleBoxTexture, Unit, Side, Float> =
        MethodStringName2<StyleBoxTexture, Unit, Side, Float>("set_texture_margin")

    @JvmField
    public val setTextureMarginAllName: MethodStringName1<StyleBoxTexture, Unit, Float> =
        MethodStringName1<StyleBoxTexture, Unit, Float>("set_texture_margin_all")

    @JvmField
    public val getTextureMarginName: MethodStringName1<StyleBoxTexture, Float, Side> =
        MethodStringName1<StyleBoxTexture, Float, Side>("get_texture_margin")

    @JvmField
    public val setExpandMarginName: MethodStringName2<StyleBoxTexture, Unit, Side, Float> =
        MethodStringName2<StyleBoxTexture, Unit, Side, Float>("set_expand_margin")

    @JvmField
    public val setExpandMarginAllName: MethodStringName1<StyleBoxTexture, Unit, Float> =
        MethodStringName1<StyleBoxTexture, Unit, Float>("set_expand_margin_all")

    @JvmField
    public val getExpandMarginName: MethodStringName1<StyleBoxTexture, Float, Side> =
        MethodStringName1<StyleBoxTexture, Float, Side>("get_expand_margin")

    @JvmField
    public val setRegionRectName: MethodStringName1<StyleBoxTexture, Unit, Rect2> =
        MethodStringName1<StyleBoxTexture, Unit, Rect2>("set_region_rect")

    @JvmField
    public val getRegionRectName: MethodStringName0<StyleBoxTexture, Rect2> =
        MethodStringName0<StyleBoxTexture, Rect2>("get_region_rect")

    @JvmField
    public val setDrawCenterName: MethodStringName1<StyleBoxTexture, Unit, Boolean> =
        MethodStringName1<StyleBoxTexture, Unit, Boolean>("set_draw_center")

    @JvmField
    public val isDrawCenterEnabledName: MethodStringName0<StyleBoxTexture, Boolean> =
        MethodStringName0<StyleBoxTexture, Boolean>("is_draw_center_enabled")

    @JvmField
    public val setModulateName: MethodStringName1<StyleBoxTexture, Unit, Color> =
        MethodStringName1<StyleBoxTexture, Unit, Color>("set_modulate")

    @JvmField
    public val getModulateName: MethodStringName0<StyleBoxTexture, Color> =
        MethodStringName0<StyleBoxTexture, Color>("get_modulate")

    @JvmField
    public val setHAxisStretchModeName: MethodStringName1<StyleBoxTexture, Unit, AxisStretchMode> =
        MethodStringName1<StyleBoxTexture, Unit, AxisStretchMode>("set_h_axis_stretch_mode")

    @JvmField
    public val getHAxisStretchModeName: MethodStringName0<StyleBoxTexture, AxisStretchMode> =
        MethodStringName0<StyleBoxTexture, AxisStretchMode>("get_h_axis_stretch_mode")

    @JvmField
    public val setVAxisStretchModeName: MethodStringName1<StyleBoxTexture, Unit, AxisStretchMode> =
        MethodStringName1<StyleBoxTexture, Unit, AxisStretchMode>("set_v_axis_stretch_mode")

    @JvmField
    public val getVAxisStretchModeName: MethodStringName0<StyleBoxTexture, AxisStretchMode> =
        MethodStringName0<StyleBoxTexture, AxisStretchMode>("get_v_axis_stretch_mode")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_texture", 3635182373)

    internal val setTextureMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_texture_margin", 4290182280)

    internal val setTextureMarginAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_texture_margin_all", 373806689)

    internal val getTextureMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_texture_margin", 2869120046)

    internal val setExpandMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_expand_margin", 4290182280)

    internal val setExpandMarginAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_expand_margin_all", 373806689)

    internal val getExpandMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_expand_margin", 2869120046)

    internal val setRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_region_rect", 2046264180)

    internal val getRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_region_rect", 1639390495)

    internal val setDrawCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_draw_center", 2586408642)

    internal val isDrawCenterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "is_draw_center_enabled", 36873697)

    internal val setModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_modulate", 2920490490)

    internal val getModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_modulate", 3444240500)

    internal val setHAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_h_axis_stretch_mode", 2965538783)

    internal val getHAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_h_axis_stretch_mode", 3807744063)

    internal val setVAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "set_v_axis_stretch_mode", 2965538783)

    internal val getVAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBoxTexture", "get_v_axis_stretch_mode", 3807744063)
  }
}
