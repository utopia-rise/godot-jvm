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
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_DOUBLE
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * The [Generic6DOFJoint3D] (6 Degrees Of Freedom) joint allows for implementing custom types of
 * joints by locking the rotation and translation of certain axes.
 *
 * The first 3 DOF represent the linear motion of the physics bodies and the last 3 DOF represent
 * the angular motion of the physics bodies. Each axis can be either locked, or limited.
 */
@GodotBaseType
public open class Generic6DOFJoint3D : Joint3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(269, scriptPtr)
  }

  public final fun setParamX(`param`: Param, `value`: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, param.value, value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamXPtr)
  }

  public final fun getParamX(`param`: Param): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, param.value)
    TransferContext.callMethod(MethodBindings.getParamXPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setParamY(`param`: Param, `value`: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, param.value, value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamYPtr)
  }

  public final fun getParamY(`param`: Param): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, param.value)
    TransferContext.callMethod(MethodBindings.getParamYPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setParamZ(`param`: Param, `value`: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, param.value, value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamZPtr)
  }

  public final fun getParamZ(`param`: Param): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, param.value)
    TransferContext.callMethod(MethodBindings.getParamZPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFlagX(flag: Flag, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, flag.value, value)
    TransferContext.callMethod(MethodBindings.setFlagXPtr)
  }

  public final fun getFlagX(flag: Flag): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flag.value)
    TransferContext.callMethod(MethodBindings.getFlagXPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFlagY(flag: Flag, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, flag.value, value)
    TransferContext.callMethod(MethodBindings.setFlagYPtr)
  }

  public final fun getFlagY(flag: Flag): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flag.value)
    TransferContext.callMethod(MethodBindings.getFlagYPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFlagZ(flag: Flag, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, flag.value, value)
    TransferContext.callMethod(MethodBindings.setFlagZPtr)
  }

  public final fun getFlagZ(flag: Flag): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flag.value)
    TransferContext.callMethod(MethodBindings.getFlagZPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class Param(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The minimum difference between the pivot points' axes.
     */
    LINEAR_LOWER_LIMIT(0),
    /**
     * The maximum difference between the pivot points' axes.
     */
    LINEAR_UPPER_LIMIT(1),
    /**
     * A factor applied to the movement across the axes. The lower, the slower the movement.
     */
    LINEAR_LIMIT_SOFTNESS(2),
    /**
     * The amount of restitution on the axes' movement. The lower, the more momentum gets lost.
     */
    LINEAR_RESTITUTION(3),
    /**
     * The amount of damping that happens at the linear motion across the axes.
     */
    LINEAR_DAMPING(4),
    /**
     * The velocity the linear motor will try to reach.
     */
    LINEAR_MOTOR_TARGET_VELOCITY(5),
    /**
     * The maximum force the linear motor will apply while trying to reach the velocity target.
     */
    LINEAR_MOTOR_FORCE_LIMIT(6),
    LINEAR_SPRING_STIFFNESS(7),
    LINEAR_SPRING_DAMPING(8),
    LINEAR_SPRING_EQUILIBRIUM_POINT(9),
    /**
     * The minimum rotation in negative direction to break loose and rotate around the axes.
     */
    ANGULAR_LOWER_LIMIT(10),
    /**
     * The minimum rotation in positive direction to break loose and rotate around the axes.
     */
    ANGULAR_UPPER_LIMIT(11),
    /**
     * The speed of all rotations across the axes.
     */
    ANGULAR_LIMIT_SOFTNESS(12),
    /**
     * The amount of rotational damping across the axes. The lower, the more damping occurs.
     */
    ANGULAR_DAMPING(13),
    /**
     * The amount of rotational restitution across the axes. The lower, the more restitution occurs.
     */
    ANGULAR_RESTITUTION(14),
    /**
     * The maximum amount of force that can occur, when rotating around the axes.
     */
    ANGULAR_FORCE_LIMIT(15),
    /**
     * When rotating across the axes, this error tolerance factor defines how much the correction
     * gets slowed down. The lower, the slower.
     */
    ANGULAR_ERP(16),
    /**
     * Target speed for the motor at the axes.
     */
    ANGULAR_MOTOR_TARGET_VELOCITY(17),
    /**
     * Maximum acceleration for the motor at the axes.
     */
    ANGULAR_MOTOR_FORCE_LIMIT(18),
    ANGULAR_SPRING_STIFFNESS(19),
    ANGULAR_SPRING_DAMPING(20),
    ANGULAR_SPRING_EQUILIBRIUM_POINT(21),
    /**
     * Represents the size of the [Param] enum.
     */
    MAX(22),
    ;

    public companion object {
      public fun from(`value`: Long): Param = entries.single { it.`value` == `value` }
    }
  }

  public enum class Flag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If enabled, linear motion is possible within the given limits.
     */
    ENABLE_LINEAR_LIMIT(0),
    /**
     * If enabled, rotational motion is possible within the given limits.
     */
    ENABLE_ANGULAR_LIMIT(1),
    ENABLE_LINEAR_SPRING(3),
    ENABLE_ANGULAR_SPRING(2),
    /**
     * If enabled, there is a rotational motor across these axes.
     */
    ENABLE_MOTOR(4),
    /**
     * If enabled, there is a linear motor across these axes.
     */
    ENABLE_LINEAR_MOTOR(5),
    /**
     * Represents the size of the [Flag] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): Flag = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setParamXName: MethodStringName2<Generic6DOFJoint3D, Unit, Param, Float> =
        MethodStringName2<Generic6DOFJoint3D, Unit, Param, Float>("set_param_x")

    @JvmField
    public val getParamXName: MethodStringName1<Generic6DOFJoint3D, Float, Param> =
        MethodStringName1<Generic6DOFJoint3D, Float, Param>("get_param_x")

    @JvmField
    public val setParamYName: MethodStringName2<Generic6DOFJoint3D, Unit, Param, Float> =
        MethodStringName2<Generic6DOFJoint3D, Unit, Param, Float>("set_param_y")

    @JvmField
    public val getParamYName: MethodStringName1<Generic6DOFJoint3D, Float, Param> =
        MethodStringName1<Generic6DOFJoint3D, Float, Param>("get_param_y")

    @JvmField
    public val setParamZName: MethodStringName2<Generic6DOFJoint3D, Unit, Param, Float> =
        MethodStringName2<Generic6DOFJoint3D, Unit, Param, Float>("set_param_z")

    @JvmField
    public val getParamZName: MethodStringName1<Generic6DOFJoint3D, Float, Param> =
        MethodStringName1<Generic6DOFJoint3D, Float, Param>("get_param_z")

    @JvmField
    public val setFlagXName: MethodStringName2<Generic6DOFJoint3D, Unit, Flag, Boolean> =
        MethodStringName2<Generic6DOFJoint3D, Unit, Flag, Boolean>("set_flag_x")

    @JvmField
    public val getFlagXName: MethodStringName1<Generic6DOFJoint3D, Boolean, Flag> =
        MethodStringName1<Generic6DOFJoint3D, Boolean, Flag>("get_flag_x")

    @JvmField
    public val setFlagYName: MethodStringName2<Generic6DOFJoint3D, Unit, Flag, Boolean> =
        MethodStringName2<Generic6DOFJoint3D, Unit, Flag, Boolean>("set_flag_y")

    @JvmField
    public val getFlagYName: MethodStringName1<Generic6DOFJoint3D, Boolean, Flag> =
        MethodStringName1<Generic6DOFJoint3D, Boolean, Flag>("get_flag_y")

    @JvmField
    public val setFlagZName: MethodStringName2<Generic6DOFJoint3D, Unit, Flag, Boolean> =
        MethodStringName2<Generic6DOFJoint3D, Unit, Flag, Boolean>("set_flag_z")

    @JvmField
    public val getFlagZName: MethodStringName1<Generic6DOFJoint3D, Boolean, Flag> =
        MethodStringName1<Generic6DOFJoint3D, Boolean, Flag>("get_flag_z")
  }

  public object MethodBindings {
    internal val setParamXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "set_param_x", 2018184242)

    internal val getParamXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "get_param_x", 2599835054)

    internal val setParamYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "set_param_y", 2018184242)

    internal val getParamYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "get_param_y", 2599835054)

    internal val setParamZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "set_param_z", 2018184242)

    internal val getParamZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "get_param_z", 2599835054)

    internal val setFlagXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "set_flag_x", 2451594564)

    internal val getFlagXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "get_flag_x", 2122427807)

    internal val setFlagYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "set_flag_y", 2451594564)

    internal val getFlagYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "get_flag_y", 2122427807)

    internal val setFlagZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "set_flag_z", 2451594564)

    internal val getFlagZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Generic6DOFJoint3D", "get_flag_z", 2122427807)
  }
}
