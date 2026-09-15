// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Child [CanvasItem] nodes of a [CanvasGroup] are drawn as a single object. It allows to e.g. draw
 * overlapping translucent 2D nodes without causing the overlapping sections to be more opaque than
 * intended (set the [CanvasItem.selfModulate] property on the [CanvasGroup] to achieve this effect).
 *
 * **Note:** The [CanvasGroup] uses a custom shader to read from the backbuffer to draw its
 * children. Assigning a [Material] to the [CanvasGroup] overrides the built-in shader. To duplicate
 * the behavior of the built-in shader in a custom [Shader], use the following:
 *
 * ```
 * shader_type canvas_item;
 * render_mode unshaded;
 *
 * uniform sampler2D screen_texture : hint_screen_texture, repeat_disable, filter_nearest;
 *
 * void fragment() {
 * 	vec4 c = textureLod(screen_texture, SCREEN_UV, 0.0);
 *
 * 	if (c.a > 0.0001) {
 * 		c.rgb /= c.a;
 * 	}
 *
 * 	COLOR *= c;
 * }
 * ```
 *
 * **Note:** Since [CanvasGroup] and [CanvasItem.clipChildren] both utilize the backbuffer, children
 * of a [CanvasGroup] who have their [CanvasItem.clipChildren] set to anything other than
 * [CanvasItem.CLIP_CHILDREN_DISABLED] will not function correctly.
 */
@GodotBaseType
public open class CanvasGroup : Node2D() {
  /**
   * Sets the size of a margin used to expand the drawable rect of this [CanvasGroup]. The size of
   * the [CanvasGroup] is determined by fitting a rect around its children then expanding that rect by
   * [fitMargin]. This increases both the backbuffer area used and the area covered by the
   * [CanvasGroup] both of which can reduce performance. This should be kept as small as possible and
   * should only be expanded when an increased size is needed (e.g. for custom shader effects).
   */
  public final inline var fitMargin: Float
    @JvmName("fitMarginProperty")
    get() = getFitMargin()
    @JvmName("fitMarginProperty")
    set(`value`) {
      setFitMargin(value)
    }

  /**
   * Sets the size of the margin used to expand the clearing rect of this [CanvasGroup]. This
   * expands the area of the backbuffer that will be used by the [CanvasGroup]. A smaller margin will
   * reduce the area of the backbuffer used which can increase performance, however if [useMipmaps] is
   * enabled, a small margin may result in mipmap errors at the edge of the [CanvasGroup]. Accordingly,
   * this should be left as small as possible, but should be increased if artifacts appear along the
   * edges of the canvas group.
   */
  public final inline var clearMargin: Float
    @JvmName("clearMarginProperty")
    get() = getClearMargin()
    @JvmName("clearMarginProperty")
    set(`value`) {
      setClearMargin(value)
    }

  /**
   * If `true`, calculates mipmaps for the backbuffer before drawing the [CanvasGroup] so that
   * mipmaps can be used in a custom [ShaderMaterial] attached to the [CanvasGroup]. Generating mipmaps
   * has a performance cost so this should not be enabled unless required.
   */
  public final inline var useMipmaps: Boolean
    @JvmName("useMipmapsProperty")
    get() = isUsingMipmaps()
    @JvmName("useMipmapsProperty")
    set(`value`) {
      setUseMipmaps(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(141, scriptPtr)
  }

  public final fun setFitMargin(fitMargin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fitMargin.toDouble())
    TransferContext.callMethod(MethodBindings.setFitMarginPtr)
  }

  public final fun getFitMargin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFitMarginPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setClearMargin(clearMargin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, clearMargin.toDouble())
    TransferContext.callMethod(MethodBindings.setClearMarginPtr)
  }

  public final fun getClearMargin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClearMarginPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setUseMipmaps(useMipmaps: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, useMipmaps)
    TransferContext.callMethod(MethodBindings.setUseMipmapsPtr)
  }

  public final fun isUsingMipmaps(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingMipmapsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setFitMarginName: MethodStringName1<CanvasGroup, Unit, Float> =
        MethodStringName1<CanvasGroup, Unit, Float>("set_fit_margin")

    @JvmField
    public val getFitMarginName: MethodStringName0<CanvasGroup, Float> =
        MethodStringName0<CanvasGroup, Float>("get_fit_margin")

    @JvmField
    public val setClearMarginName: MethodStringName1<CanvasGroup, Unit, Float> =
        MethodStringName1<CanvasGroup, Unit, Float>("set_clear_margin")

    @JvmField
    public val getClearMarginName: MethodStringName0<CanvasGroup, Float> =
        MethodStringName0<CanvasGroup, Float>("get_clear_margin")

    @JvmField
    public val setUseMipmapsName: MethodStringName1<CanvasGroup, Unit, Boolean> =
        MethodStringName1<CanvasGroup, Unit, Boolean>("set_use_mipmaps")

    @JvmField
    public val isUsingMipmapsName: MethodStringName0<CanvasGroup, Boolean> =
        MethodStringName0<CanvasGroup, Boolean>("is_using_mipmaps")
  }

  public object MethodBindings {
    internal val setFitMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasGroup", "set_fit_margin", 373806689)

    internal val getFitMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasGroup", "get_fit_margin", 1740695150)

    internal val setClearMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasGroup", "set_clear_margin", 373806689)

    internal val getClearMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasGroup", "get_clear_margin", 1740695150)

    internal val setUseMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasGroup", "set_use_mipmaps", 2586408642)

    internal val isUsingMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasGroup", "is_using_mipmaps", 36873697)
  }
}
