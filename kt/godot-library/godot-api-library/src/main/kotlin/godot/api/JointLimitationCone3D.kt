// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A cone shape limitation that interacts with [ChainIK3D].
 */
@GodotBaseType
public open class JointLimitationCone3D : JointLimitation3D() {
  /**
   * The radius range of the hole made by the cone.
   *
   * `0` degrees makes a sphere without hole, `180` degrees makes a hemisphere, and `360` degrees
   * become empty (no limitation).
   */
  public final inline var angle: Float
    @JvmName("angleProperty")
    get() = getAngle()
    @JvmName("angleProperty")
    set(`value`) {
      setAngle(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(343, scriptPtr)
  }

  public final fun setAngle(angle: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAnglePtr, angle.toDouble())
  }

  public final fun getAngle(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAnglePtr).toFloat()

  public companion object {
    @JvmField
    public val setAngleName: MethodStringName1<JointLimitationCone3D, Unit, Float> =
        MethodStringName1<JointLimitationCone3D, Unit, Float>("set_angle")

    @JvmField
    public val getAngleName: MethodStringName0<JointLimitationCone3D, Float> =
        MethodStringName0<JointLimitationCone3D, Float>("get_angle")
  }

  public object MethodBindings {
    internal val setAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JointLimitationCone3D", "set_angle", 373806689)

    internal val getAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JointLimitationCone3D", "get_angle", 1740695150)
  }
}
