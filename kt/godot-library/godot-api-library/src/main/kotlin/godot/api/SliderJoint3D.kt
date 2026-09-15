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
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * A physics joint that restricts the movement of a 3D physics body along an axis relative to
 * another physics body. For example, Body A could be a [StaticBody3D] representing a piston base,
 * while Body B could be a [RigidBody3D] representing the piston head, moving up and down.
 */
@GodotBaseType
public open class SliderJoint3D : Joint3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(683, scriptPtr)
  }

  /**
   * Assigns [value] to the given parameter.
   */
  public final fun setParam(`param`: Param, `value`: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, param.value, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setParamPtr, 0)
  }

  /**
   * Returns the value of the given parameter.
   */
  public final fun getParam(`param`: Param): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, param.value)
    TransferContext.callPtrMethod(MethodBindings.getParamPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public enum class Param(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant for accessing [linearLimit/upperDistance]. The maximum difference between the pivot
     * points on their X axis before damping happens.
     */
    LINEAR_LIMIT_UPPER(0),
    /**
     * Constant for accessing [linearLimit/lowerDistance]. The minimum difference between the pivot
     * points on their X axis before damping happens.
     */
    LINEAR_LIMIT_LOWER(1),
    /**
     * Constant for accessing [linearLimit/softness]. A factor applied to the movement across the
     * slider axis once the limits get surpassed. The lower, the slower the movement.
     */
    LINEAR_LIMIT_SOFTNESS(2),
    /**
     * Constant for accessing [linearLimit/restitution]. The amount of restitution once the limits
     * are surpassed. The lower, the more velocity-energy gets lost.
     */
    LINEAR_LIMIT_RESTITUTION(3),
    /**
     * Constant for accessing [linearLimit/damping]. The amount of damping once the slider limits
     * are surpassed.
     */
    LINEAR_LIMIT_DAMPING(4),
    /**
     * Constant for accessing [linearMotion/softness]. A factor applied to the movement across the
     * slider axis as long as the slider is in the limits. The lower, the slower the movement.
     */
    LINEAR_MOTION_SOFTNESS(5),
    /**
     * Constant for accessing [linearMotion/restitution]. The amount of restitution inside the
     * slider limits.
     */
    LINEAR_MOTION_RESTITUTION(6),
    /**
     * Constant for accessing [linearMotion/damping]. The amount of damping inside the slider
     * limits.
     */
    LINEAR_MOTION_DAMPING(7),
    /**
     * Constant for accessing [linearOrtho/softness]. A factor applied to the movement across axes
     * orthogonal to the slider.
     */
    LINEAR_ORTHOGONAL_SOFTNESS(8),
    /**
     * Constant for accessing [linearMotion/restitution]. The amount of restitution when movement is
     * across axes orthogonal to the slider.
     */
    LINEAR_ORTHOGONAL_RESTITUTION(9),
    /**
     * Constant for accessing [linearMotion/damping]. The amount of damping when movement is across
     * axes orthogonal to the slider.
     */
    LINEAR_ORTHOGONAL_DAMPING(10),
    /**
     * Constant for accessing [angularLimit/upperAngle]. The upper limit of rotation in the slider.
     */
    ANGULAR_LIMIT_UPPER(11),
    /**
     * Constant for accessing [angularLimit/lowerAngle]. The lower limit of rotation in the slider.
     */
    ANGULAR_LIMIT_LOWER(12),
    /**
     * Constant for accessing [angularLimit/softness]. A factor applied to the all rotation once the
     * limit is surpassed.
     */
    ANGULAR_LIMIT_SOFTNESS(13),
    /**
     * Constant for accessing [angularLimit/restitution]. The amount of restitution of the rotation
     * when the limit is surpassed.
     */
    ANGULAR_LIMIT_RESTITUTION(14),
    /**
     * Constant for accessing [angularLimit/damping]. The amount of damping of the rotation when the
     * limit is surpassed.
     */
    ANGULAR_LIMIT_DAMPING(15),
    /**
     * Constant for accessing [angularMotion/softness]. A factor applied to the all rotation in the
     * limits.
     */
    ANGULAR_MOTION_SOFTNESS(16),
    /**
     * Constant for accessing [angularMotion/restitution]. The amount of restitution of the rotation
     * in the limits.
     */
    ANGULAR_MOTION_RESTITUTION(17),
    /**
     * Constant for accessing [angularMotion/damping]. The amount of damping of the rotation in the
     * limits.
     */
    ANGULAR_MOTION_DAMPING(18),
    /**
     * Constant for accessing [angularOrtho/softness]. A factor applied to the all rotation across
     * axes orthogonal to the slider.
     */
    ANGULAR_ORTHOGONAL_SOFTNESS(19),
    /**
     * Constant for accessing [angularOrtho/restitution]. The amount of restitution of the rotation
     * across axes orthogonal to the slider.
     */
    ANGULAR_ORTHOGONAL_RESTITUTION(20),
    /**
     * Constant for accessing [angularOrtho/damping]. The amount of damping of the rotation across
     * axes orthogonal to the slider.
     */
    ANGULAR_ORTHOGONAL_DAMPING(21),
    /**
     * Represents the size of the [Param] enum.
     */
    MAX(22),
    ;

    public companion object {
      public fun from(`value`: Long): Param = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setParamName: MethodStringName2<SliderJoint3D, Unit, Param, Float> =
        MethodStringName2<SliderJoint3D, Unit, Param, Float>("set_param")

    @JvmField
    public val getParamName: MethodStringName1<SliderJoint3D, Float, Param> =
        MethodStringName1<SliderJoint3D, Float, Param>("get_param")
  }

  public object MethodBindings {
    internal val setParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SliderJoint3D", "set_param", 918243683)

    internal val getParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SliderJoint3D", "get_param", 959925627)
  }
}
