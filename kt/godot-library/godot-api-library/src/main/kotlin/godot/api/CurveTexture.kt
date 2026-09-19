// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 1D texture where pixel brightness corresponds to points on a unit [Curve] resource, either in
 * grayscale or in red. This visual representation simplifies the task of saving curves as image files.
 *
 * If you need to store up to 3 curves within a single texture, use [CurveXYZTexture] instead. See
 * also [GradientTexture1D] and [GradientTexture2D].
 */
@GodotBaseType
public open class CurveTexture : Texture2D() {
  /**
   * The width of the texture (in pixels). Higher values make it possible to represent
   * high-frequency data better (such as sudden direction changes), at the cost of increased generation
   * time and memory usage.
   */
  public final inline var width: Int
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * The format the texture should be generated with. When passing a CurveTexture as an input to a
   * [Shader], this may need to be adjusted.
   */
  public final inline var textureMode: TextureMode
    @JvmName("textureModeProperty")
    get() = getTextureMode()
    @JvmName("textureModeProperty")
    set(`value`) {
      setTextureMode(value)
    }

  /**
   * The [Curve] that is rendered onto the texture. Should be a unit [Curve].
   */
  public final inline var curve: Curve?
    @JvmName("curveProperty")
    get() = getCurve()
    @JvmName("curveProperty")
    set(`value`) {
      setCurve(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(197, scriptPtr)
  }

  public final fun setWidth(width: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setWidthPtr, width.toLong())
  }

  public final fun setCurve(curve: Curve?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setCurvePtr, curve)
  }

  public final fun getCurve(): Curve? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getCurvePtr) as Curve?)

  public final fun setTextureMode(textureMode: TextureMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextureModePtr, textureMode.value)
  }

  public final fun getTextureMode(): TextureMode =
      TextureMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextureModePtr))

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("CurveTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("CurveTexture::_getHeight can't be called from the JVM.")
  }

  public enum class TextureMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Store the curve equally across the red, green and blue channels. This uses more video memory,
     * but is more compatible with shaders that only read the green and blue values.
     */
    RGB(0),
    /**
     * Store the curve only in the red channel. This saves video memory, but some custom shaders may
     * not be able to work with this.
     */
    RED(1),
    ;

    public companion object {
      public fun from(`value`: Long): TextureMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setWidthName: MethodStringName1<CurveTexture, Unit, Int> =
        MethodStringName1<CurveTexture, Unit, Int>("set_width")

    @JvmField
    public val setCurveName: MethodStringName1<CurveTexture, Unit, Curve?> =
        MethodStringName1<CurveTexture, Unit, Curve?>("set_curve")

    @JvmField
    public val getCurveName: MethodStringName0<CurveTexture, Curve?> =
        MethodStringName0<CurveTexture, Curve?>("get_curve")

    @JvmField
    public val setTextureModeName: MethodStringName1<CurveTexture, Unit, TextureMode> =
        MethodStringName1<CurveTexture, Unit, TextureMode>("set_texture_mode")

    @JvmField
    public val getTextureModeName: MethodStringName0<CurveTexture, TextureMode> =
        MethodStringName0<CurveTexture, TextureMode>("get_texture_mode")
  }

  public object MethodBindings {
    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveTexture", "set_width", 1286410249)

    internal val setCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveTexture", "set_curve", 270443179)

    internal val getCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveTexture", "get_curve", 2460114913)

    internal val setTextureModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveTexture", "set_texture_mode", 1321955367)

    internal val getTextureModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveTexture", "get_texture_mode", 715756376)
  }
}
