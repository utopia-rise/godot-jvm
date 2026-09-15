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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * A physics joint that restricts the rotation of a 3D physics body around an axis relative to
 * another physics body. For example, Body A can be a [StaticBody3D] representing a door hinge that a
 * [RigidBody3D] rotates around.
 */
@GodotBaseType
public open class HingeJoint3D : Joint3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(295, scriptPtr)
  }

  /**
   * Sets the value of the specified parameter.
   */
  public final fun setParam(`param`: Param, `value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamPtr)
  }

  /**
   * Returns the value of the specified parameter.
   */
  public final fun getParam(`param`: Param): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * If `true`, enables the specified flag.
   */
  public final fun setFlag(flag: Flag, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFlagPtr)
  }

  /**
   * Returns the value of the specified flag.
   */
  public final fun getFlag(flag: Flag): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.getFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class Param(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The speed with which the two bodies get pulled together when they move in different
     * directions.
     */
    BIAS(0),
    /**
     * The maximum rotation. Only active if [angularLimit/enable] is `true`.
     */
    LIMIT_UPPER(1),
    /**
     * The minimum rotation. Only active if [angularLimit/enable] is `true`.
     */
    LIMIT_LOWER(2),
    /**
     * The speed with which the rotation across the axis perpendicular to the hinge gets corrected.
     */
    LIMIT_BIAS(3),
    LIMIT_SOFTNESS(4),
    /**
     * The lower this value, the more the rotation gets slowed down.
     */
    LIMIT_RELAXATION(5),
    /**
     * Target speed for the motor.
     */
    MOTOR_TARGET_VELOCITY(6),
    /**
     * Maximum acceleration for the motor.
     */
    MOTOR_MAX_IMPULSE(7),
    /**
     * Represents the size of the [Param] enum.
     */
    MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): Param = entries.single { it.`value` == `value` }
    }
  }

  public enum class Flag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If `true`, the hinges maximum and minimum rotation, defined by [angularLimit/lower] and
     * [angularLimit/upper] has effects.
     */
    USE_LIMIT(0),
    /**
     * When activated, a motor turns the hinge.
     */
    ENABLE_MOTOR(1),
    /**
     * Represents the size of the [Flag] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): Flag = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setParamName: MethodStringName2<HingeJoint3D, Unit, Param, Float> =
        MethodStringName2<HingeJoint3D, Unit, Param, Float>("set_param")

    @JvmField
    public val getParamName: MethodStringName1<HingeJoint3D, Float, Param> =
        MethodStringName1<HingeJoint3D, Float, Param>("get_param")

    @JvmField
    public val setFlagName: MethodStringName2<HingeJoint3D, Unit, Flag, Boolean> =
        MethodStringName2<HingeJoint3D, Unit, Flag, Boolean>("set_flag")

    @JvmField
    public val getFlagName: MethodStringName1<HingeJoint3D, Boolean, Flag> =
        MethodStringName1<HingeJoint3D, Boolean, Flag>("get_flag")
  }

  public object MethodBindings {
    internal val setParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HingeJoint3D", "set_param", 3082977519)

    internal val getParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HingeJoint3D", "get_param", 4066002676)

    internal val setFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HingeJoint3D", "set_flag", 1083494620)

    internal val getFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HingeJoint3D", "get_flag", 2841369610)
  }
}
