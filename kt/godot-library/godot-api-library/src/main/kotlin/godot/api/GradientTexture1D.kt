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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 1D texture that obtains colors from a [Gradient] to fill the texture data. The texture is
 * filled by sampling the gradient for each pixel. Therefore, the texture does not necessarily
 * represent an exact copy of the gradient, as it may miss some colors if there are not enough pixels.
 * See also [GradientTexture2D], [CurveTexture] and [CurveXYZTexture].
 */
@GodotBaseType
public open class GradientTexture1D : Texture2D() {
  /**
   * The [Gradient] used to fill the texture.
   */
  public final inline var gradient: Gradient?
    @JvmName("gradientProperty")
    get() = getGradient()
    @JvmName("gradientProperty")
    set(`value`) {
      setGradient(value)
    }

  /**
   * The number of color samples that will be obtained from the [Gradient].
   */
  public final inline var width: Int
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * If `true`, the generated texture will support high dynamic range ([Image.FORMAT_RGBAF] format).
   * This allows for glow effects to work if [Environment.glowEnabled] is `true`. If `false`, the
   * generated texture will use low dynamic range; overbright colors will be clamped
   * ([Image.FORMAT_RGBA8] format).
   */
  public final inline var useHdr: Boolean
    @JvmName("useHdrProperty")
    get() = isUsingHdr()
    @JvmName("useHdrProperty")
    set(`value`) {
      setUseHdr(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(275, scriptPtr)
  }

  public final fun setGradient(gradient: Gradient?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to gradient)
    TransferContext.callMethod(MethodBindings.setGradientPtr)
  }

  public final fun getGradient(): Gradient? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGradientPtr)
    return (TransferContext.readReturnValue(OBJECT) as Gradient?)
  }

  public final fun setWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun setUseHdr(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setUseHdrPtr)
  }

  public final fun isUsingHdr(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingHdrPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("GradientTexture1D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("GradientTexture1D::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setGradientName: MethodStringName1<GradientTexture1D, Unit, Gradient?> =
        MethodStringName1<GradientTexture1D, Unit, Gradient?>("set_gradient")

    @JvmField
    public val getGradientName: MethodStringName0<GradientTexture1D, Gradient?> =
        MethodStringName0<GradientTexture1D, Gradient?>("get_gradient")

    @JvmField
    public val setWidthName: MethodStringName1<GradientTexture1D, Unit, Int> =
        MethodStringName1<GradientTexture1D, Unit, Int>("set_width")

    @JvmField
    public val setUseHdrName: MethodStringName1<GradientTexture1D, Unit, Boolean> =
        MethodStringName1<GradientTexture1D, Unit, Boolean>("set_use_hdr")

    @JvmField
    public val isUsingHdrName: MethodStringName0<GradientTexture1D, Boolean> =
        MethodStringName0<GradientTexture1D, Boolean>("is_using_hdr")
  }

  public object MethodBindings {
    internal val setGradientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture1D", "set_gradient", 2756054477)

    internal val getGradientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture1D", "get_gradient", 132272999)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture1D", "set_width", 1286410249)

    internal val setUseHdrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture1D", "set_use_hdr", 2586408642)

    internal val isUsingHdrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GradientTexture1D", "is_using_hdr", 36873697)
  }
}
