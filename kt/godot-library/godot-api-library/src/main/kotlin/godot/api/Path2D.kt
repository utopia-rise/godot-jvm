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
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Can have [PathFollow2D] child nodes moving along the [Curve2D]. See [PathFollow2D] for more
 * information on usage.
 *
 * **Note:** The path is considered as relative to the moved nodes (children of [PathFollow2D]). As
 * such, the curve should usually start with a zero vector (`(0, 0)`).
 */
@GodotBaseType
public open class Path2D : Node2D() {
  /**
   * A [Curve2D] describing the path.
   */
  public final inline var curve: Curve2D?
    @JvmName("curveProperty")
    get() = getCurve()
    @JvmName("curveProperty")
    set(`value`) {
      setCurve(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(514, scriptPtr)
  }

  public final fun setCurve(curve: Curve2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, curve)
    TransferContext.callMethod(MethodBindings.setCurvePtr)
  }

  public final fun getCurve(): Curve2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurvePtr)
    return (TransferContext.readReturnValue_OBJECT() as Curve2D?)
  }

  public companion object {
    @JvmField
    public val setCurveName: MethodStringName1<Path2D, Unit, Curve2D?> =
        MethodStringName1<Path2D, Unit, Curve2D?>("set_curve")

    @JvmField
    public val getCurveName: MethodStringName0<Path2D, Curve2D?> =
        MethodStringName0<Path2D, Curve2D?>("get_curve")
  }

  public object MethodBindings {
    internal val setCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Path2D", "set_curve", 659985499)

    internal val getCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Path2D", "get_curve", 660369445)
  }
}
