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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 1D texture where the red, green, and blue color channels correspond to points on 3 unit [Curve]
 * resources. Compared to using separate [CurveTexture]s, this further simplifies the task of saving
 * curves as image files.
 *
 * If you only need to store one curve within a single texture, use [CurveTexture] instead. See also
 * [GradientTexture1D] and [GradientTexture2D].
 */
@GodotBaseType
public open class CurveXYZTexture : Texture2D() {
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
   * The [Curve] that is rendered onto the texture's red channel. Should be a unit [Curve].
   */
  public final inline var curveX: Curve?
    @JvmName("curveXProperty")
    get() = getCurveX()
    @JvmName("curveXProperty")
    set(`value`) {
      setCurveX(value)
    }

  /**
   * The [Curve] that is rendered onto the texture's green channel. Should be a unit [Curve].
   */
  public final inline var curveY: Curve?
    @JvmName("curveYProperty")
    get() = getCurveY()
    @JvmName("curveYProperty")
    set(`value`) {
      setCurveY(value)
    }

  /**
   * The [Curve] that is rendered onto the texture's blue channel. Should be a unit [Curve].
   */
  public final inline var curveZ: Curve?
    @JvmName("curveZProperty")
    get() = getCurveZ()
    @JvmName("curveZProperty")
    set(`value`) {
      setCurveZ(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(198, scriptPtr)
  }

  public final fun setWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun setCurveX(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setCurveXPtr)
  }

  public final fun getCurveX(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurveXPtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setCurveY(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setCurveYPtr)
  }

  public final fun getCurveY(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurveYPtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setCurveZ(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setCurveZPtr)
  }

  public final fun getCurveZ(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurveZPtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("CurveXYZTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("CurveXYZTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setWidthName: MethodStringName1<CurveXYZTexture, Unit, Int> =
        MethodStringName1<CurveXYZTexture, Unit, Int>("set_width")

    @JvmField
    public val setCurveXName: MethodStringName1<CurveXYZTexture, Unit, Curve?> =
        MethodStringName1<CurveXYZTexture, Unit, Curve?>("set_curve_x")

    @JvmField
    public val getCurveXName: MethodStringName0<CurveXYZTexture, Curve?> =
        MethodStringName0<CurveXYZTexture, Curve?>("get_curve_x")

    @JvmField
    public val setCurveYName: MethodStringName1<CurveXYZTexture, Unit, Curve?> =
        MethodStringName1<CurveXYZTexture, Unit, Curve?>("set_curve_y")

    @JvmField
    public val getCurveYName: MethodStringName0<CurveXYZTexture, Curve?> =
        MethodStringName0<CurveXYZTexture, Curve?>("get_curve_y")

    @JvmField
    public val setCurveZName: MethodStringName1<CurveXYZTexture, Unit, Curve?> =
        MethodStringName1<CurveXYZTexture, Unit, Curve?>("set_curve_z")

    @JvmField
    public val getCurveZName: MethodStringName0<CurveXYZTexture, Curve?> =
        MethodStringName0<CurveXYZTexture, Curve?>("get_curve_z")
  }

  public object MethodBindings {
    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "set_width", 1286410249)

    internal val setCurveXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "set_curve_x", 270443179)

    internal val getCurveXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "get_curve_x", 2460114913)

    internal val setCurveYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "set_curve_y", 270443179)

    internal val getCurveYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "get_curve_y", 2460114913)

    internal val setCurveZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "set_curve_z", 270443179)

    internal val getCurveZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CurveXYZTexture", "get_curve_z", 2460114913)
  }
}
