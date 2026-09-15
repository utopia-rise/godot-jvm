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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Rect2
import godot.core.Side
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RECT2
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_RECT2
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Also known as 9-slice panels, [NinePatchRect] produces clean panels of any size based on a small
 * texture. To do so, it splits the texture in a 3×3 grid. When you scale the node, it tiles the
 * texture's edges horizontally or vertically, tiles the center on both axes, and leaves the corners
 * unchanged.
 */
@GodotBaseType
public open class NinePatchRect : Control() {
  /**
   * Emitted when the node's texture changes.
   */
  public val textureChanged: Signal0 by Signal0

  /**
   * The node's texture resource.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * If `true`, draw the panel's center. Else, only draw the 9-slice's borders.
   */
  public final inline var drawCenter: Boolean
    @JvmName("drawCenterProperty")
    get() = isDrawCenterEnabled()
    @JvmName("drawCenterProperty")
    set(`value`) {
      setDrawCenter(value)
    }

  /**
   * Rectangular region of the texture to sample from. If you're working with an atlas, use this
   * property to define the area the 9-slice should use. All other properties are relative to this one.
   * If the rect is empty, NinePatchRect will use the whole texture.
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
   * The width of the 9-slice's left column. A margin of 16 means the 9-slice's left corners and
   * side will have a width of 16 pixels. You can set all 4 margin values individually to create panels
   * with non-uniform borders.
   */
  public final inline var patchMarginLeft: Int
    @JvmName("patchMarginLeftProperty")
    get() = getPatchMargin(Side.LEFT)
    @JvmName("patchMarginLeftProperty")
    set(`value`) {
      setPatchMargin(Side.LEFT, value)
    }

  /**
   * The height of the 9-slice's top row. A margin of 16 means the 9-slice's top corners and side
   * will have a height of 16 pixels. You can set all 4 margin values individually to create panels
   * with non-uniform borders.
   */
  public final inline var patchMarginTop: Int
    @JvmName("patchMarginTopProperty")
    get() = getPatchMargin(Side.TOP)
    @JvmName("patchMarginTopProperty")
    set(`value`) {
      setPatchMargin(Side.TOP, value)
    }

  /**
   * The width of the 9-slice's right column. A margin of 16 means the 9-slice's right corners and
   * side will have a width of 16 pixels. You can set all 4 margin values individually to create panels
   * with non-uniform borders.
   */
  public final inline var patchMarginRight: Int
    @JvmName("patchMarginRightProperty")
    get() = getPatchMargin(Side.RIGHT)
    @JvmName("patchMarginRightProperty")
    set(`value`) {
      setPatchMargin(Side.RIGHT, value)
    }

  /**
   * The height of the 9-slice's bottom row. A margin of 16 means the 9-slice's bottom corners and
   * side will have a height of 16 pixels. You can set all 4 margin values individually to create
   * panels with non-uniform borders.
   */
  public final inline var patchMarginBottom: Int
    @JvmName("patchMarginBottomProperty")
    get() = getPatchMargin(Side.BOTTOM)
    @JvmName("patchMarginBottomProperty")
    set(`value`) {
      setPatchMargin(Side.BOTTOM, value)
    }

  /**
   * The stretch mode to use for horizontal stretching/tiling.
   */
  public final inline var axisStretchHorizontal: AxisStretchMode
    @JvmName("axisStretchHorizontalProperty")
    get() = getHAxisStretchMode()
    @JvmName("axisStretchHorizontalProperty")
    set(`value`) {
      setHAxisStretchMode(value)
    }

  /**
   * The stretch mode to use for vertical stretching/tiling.
   */
  public final inline var axisStretchVertical: AxisStretchMode
    @JvmName("axisStretchVerticalProperty")
    get() = getVAxisStretchMode()
    @JvmName("axisStretchVerticalProperty")
    set(`value`) {
      setVAxisStretchMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(418, scriptPtr)
  }

  /**
   * This is a helper function for [regionRect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = ninepatchrect.regionRect
   * //Your changes
   * ninepatchrect.regionRect = myCoreType
   * ``````
   *
   * Rectangular region of the texture to sample from. If you're working with an atlas, use this
   * property to define the area the 9-slice should use. All other properties are relative to this one.
   * If the rect is empty, NinePatchRect will use the whole texture.
   */
  @CoreTypeHelper
  public final fun regionRectMutate(block: Rect2.() -> Unit): Rect2 = regionRect.apply {
     block(this)
     regionRect = this
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callPtrMethod(MethodBindings.setTexturePtr, 0)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTexturePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * Sets the size of the margin on the specified [Side] to [value] pixels.
   */
  public final fun setPatchMargin(margin: Side, `value`: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, margin.value, value.toLong())
    TransferContext.callPtrMethod(MethodBindings.setPatchMarginPtr, 0)
  }

  /**
   * Returns the size of the margin on the specified [Side].
   */
  public final fun getPatchMargin(margin: Side): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, margin.value)
    TransferContext.callPtrMethod(MethodBindings.getPatchMarginPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setRegionRect(rect: Rect2): Unit {
    TransferContext.writeMethodArguments_RECT2(ptr, objectID.id, rect)
    TransferContext.callPtrMethod(MethodBindings.setRegionRectPtr, 0)
  }

  public final fun getRegionRect(): Rect2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRegionRectPtr, 7)
    return TransferContext.readReturnValue_RECT2()
  }

  public final fun setDrawCenter(drawCenter: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, drawCenter)
    TransferContext.callPtrMethod(MethodBindings.setDrawCenterPtr, 0)
  }

  public final fun isDrawCenterEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isDrawCenterEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setHAxisStretchMode(mode: AxisStretchMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setHAxisStretchModePtr, 0)
  }

  public final fun getHAxisStretchMode(): AxisStretchMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHAxisStretchModePtr, 2)
    return AxisStretchMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setVAxisStretchMode(mode: AxisStretchMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setVAxisStretchModePtr, 0)
  }

  public final fun getVAxisStretchMode(): AxisStretchMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVAxisStretchModePtr, 2)
    return AxisStretchMode.from(TransferContext.readReturnValue_LONG())
  }

  public enum class AxisStretchMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Stretches the center texture across the NinePatchRect. This may cause the texture to be
     * distorted.
     */
    STRETCH(0),
    /**
     * Repeats the center texture across the NinePatchRect. This won't cause any visible distortion.
     * The texture must be seamless for this to work without displaying artifacts between edges.
     */
    TILE(1),
    /**
     * Repeats the center texture across the NinePatchRect, but will also stretch the texture to
     * make sure each tile is visible in full. This may cause the texture to be distorted, but less
     * than [AXIS_STRETCH_MODE_STRETCH]. The texture must be seamless for this to work without
     * displaying artifacts between edges.
     */
    TILE_FIT(2),
    ;

    public companion object {
      public fun from(`value`: Long): AxisStretchMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<NinePatchRect, Unit, Texture2D?> =
        MethodStringName1<NinePatchRect, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<NinePatchRect, Texture2D?> =
        MethodStringName0<NinePatchRect, Texture2D?>("get_texture")

    @JvmField
    public val setPatchMarginName: MethodStringName2<NinePatchRect, Unit, Side, Int> =
        MethodStringName2<NinePatchRect, Unit, Side, Int>("set_patch_margin")

    @JvmField
    public val getPatchMarginName: MethodStringName1<NinePatchRect, Int, Side> =
        MethodStringName1<NinePatchRect, Int, Side>("get_patch_margin")

    @JvmField
    public val setRegionRectName: MethodStringName1<NinePatchRect, Unit, Rect2> =
        MethodStringName1<NinePatchRect, Unit, Rect2>("set_region_rect")

    @JvmField
    public val getRegionRectName: MethodStringName0<NinePatchRect, Rect2> =
        MethodStringName0<NinePatchRect, Rect2>("get_region_rect")

    @JvmField
    public val setDrawCenterName: MethodStringName1<NinePatchRect, Unit, Boolean> =
        MethodStringName1<NinePatchRect, Unit, Boolean>("set_draw_center")

    @JvmField
    public val isDrawCenterEnabledName: MethodStringName0<NinePatchRect, Boolean> =
        MethodStringName0<NinePatchRect, Boolean>("is_draw_center_enabled")

    @JvmField
    public val setHAxisStretchModeName: MethodStringName1<NinePatchRect, Unit, AxisStretchMode> =
        MethodStringName1<NinePatchRect, Unit, AxisStretchMode>("set_h_axis_stretch_mode")

    @JvmField
    public val getHAxisStretchModeName: MethodStringName0<NinePatchRect, AxisStretchMode> =
        MethodStringName0<NinePatchRect, AxisStretchMode>("get_h_axis_stretch_mode")

    @JvmField
    public val setVAxisStretchModeName: MethodStringName1<NinePatchRect, Unit, AxisStretchMode> =
        MethodStringName1<NinePatchRect, Unit, AxisStretchMode>("set_v_axis_stretch_mode")

    @JvmField
    public val getVAxisStretchModeName: MethodStringName0<NinePatchRect, AxisStretchMode> =
        MethodStringName0<NinePatchRect, AxisStretchMode>("get_v_axis_stretch_mode")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "get_texture", 3635182373)

    internal val setPatchMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "set_patch_margin", 437707142)

    internal val getPatchMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "get_patch_margin", 1983885014)

    internal val setRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "set_region_rect", 2046264180)

    internal val getRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "get_region_rect", 1639390495)

    internal val setDrawCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "set_draw_center", 2586408642)

    internal val isDrawCenterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "is_draw_center_enabled", 36873697)

    internal val setHAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "set_h_axis_stretch_mode", 3219608417)

    internal val getHAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "get_h_axis_stretch_mode", 3317113799)

    internal val setVAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "set_v_axis_stretch_mode", 3219608417)

    internal val getVAxisStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NinePatchRect", "get_v_axis_stretch_mode", 3317113799)
  }
}
