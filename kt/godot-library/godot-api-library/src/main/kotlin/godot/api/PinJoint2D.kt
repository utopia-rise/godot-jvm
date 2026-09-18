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
 * A physics joint that attaches two 2D physics bodies at a single point, allowing them to freely
 * rotate. For example, a [RigidBody2D] can be attached to a [StaticBody2D] to create a pendulum or a
 * seesaw.
 */
@GodotBaseType
public open class PinJoint2D : Joint2D() {
  /**
   * The higher this value, the more the bond to the pinned partner can flex.
   */
  public final inline var softness: Float
    @JvmName("softnessProperty")
    get() = getSoftness()
    @JvmName("softnessProperty")
    set(`value`) {
      setSoftness(value)
    }

  /**
   * If `true`, the pin maximum and minimum rotation, defined by [angularLimitLower] and
   * [angularLimitUpper] are applied.
   */
  public final inline var angularLimitEnabled: Boolean
    @JvmName("angularLimitEnabledProperty")
    get() = isAngularLimitEnabled()
    @JvmName("angularLimitEnabledProperty")
    set(`value`) {
      setAngularLimitEnabled(value)
    }

  /**
   * The minimum rotation. Only active if [angularLimitEnabled] is `true`.
   */
  public final inline var angularLimitLower: Float
    @JvmName("angularLimitLowerProperty")
    get() = getAngularLimitLower()
    @JvmName("angularLimitLowerProperty")
    set(`value`) {
      setAngularLimitLower(value)
    }

  /**
   * The maximum rotation. Only active if [angularLimitEnabled] is `true`.
   */
  public final inline var angularLimitUpper: Float
    @JvmName("angularLimitUpperProperty")
    get() = getAngularLimitUpper()
    @JvmName("angularLimitUpperProperty")
    set(`value`) {
      setAngularLimitUpper(value)
    }

  /**
   * When activated, a motor turns the pin.
   */
  public final inline var motorEnabled: Boolean
    @JvmName("motorEnabledProperty")
    get() = isMotorEnabled()
    @JvmName("motorEnabledProperty")
    set(`value`) {
      setMotorEnabled(value)
    }

  /**
   * Target speed for the motor. In radians per second.
   */
  public final inline var motorTargetVelocity: Float
    @JvmName("motorTargetVelocityProperty")
    get() = getMotorTargetVelocity()
    @JvmName("motorTargetVelocityProperty")
    set(`value`) {
      setMotorTargetVelocity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(549, scriptPtr)
  }

  public final fun setSoftness(softness: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, softness.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSoftnessPtr, 0)
  }

  public final fun getSoftness(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSoftnessPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAngularLimitLower(angularLimitLower: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angularLimitLower.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAngularLimitLowerPtr, 0)
  }

  public final fun getAngularLimitLower(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAngularLimitLowerPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAngularLimitUpper(angularLimitUpper: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angularLimitUpper.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAngularLimitUpperPtr, 0)
  }

  public final fun getAngularLimitUpper(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAngularLimitUpperPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMotorTargetVelocity(motorTargetVelocity: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, motorTargetVelocity.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMotorTargetVelocityPtr, 0)
  }

  public final fun getMotorTargetVelocity(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMotorTargetVelocityPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMotorEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setMotorEnabledPtr, 0)
  }

  public final fun isMotorEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isMotorEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAngularLimitEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setAngularLimitEnabledPtr, 0)
  }

  public final fun isAngularLimitEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAngularLimitEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setSoftnessName: MethodStringName1<PinJoint2D, Unit, Float> =
        MethodStringName1<PinJoint2D, Unit, Float>("set_softness")

    @JvmField
    public val getSoftnessName: MethodStringName0<PinJoint2D, Float> =
        MethodStringName0<PinJoint2D, Float>("get_softness")

    @JvmField
    public val setAngularLimitLowerName: MethodStringName1<PinJoint2D, Unit, Float> =
        MethodStringName1<PinJoint2D, Unit, Float>("set_angular_limit_lower")

    @JvmField
    public val getAngularLimitLowerName: MethodStringName0<PinJoint2D, Float> =
        MethodStringName0<PinJoint2D, Float>("get_angular_limit_lower")

    @JvmField
    public val setAngularLimitUpperName: MethodStringName1<PinJoint2D, Unit, Float> =
        MethodStringName1<PinJoint2D, Unit, Float>("set_angular_limit_upper")

    @JvmField
    public val getAngularLimitUpperName: MethodStringName0<PinJoint2D, Float> =
        MethodStringName0<PinJoint2D, Float>("get_angular_limit_upper")

    @JvmField
    public val setMotorTargetVelocityName: MethodStringName1<PinJoint2D, Unit, Float> =
        MethodStringName1<PinJoint2D, Unit, Float>("set_motor_target_velocity")

    @JvmField
    public val getMotorTargetVelocityName: MethodStringName0<PinJoint2D, Float> =
        MethodStringName0<PinJoint2D, Float>("get_motor_target_velocity")

    @JvmField
    public val setMotorEnabledName: MethodStringName1<PinJoint2D, Unit, Boolean> =
        MethodStringName1<PinJoint2D, Unit, Boolean>("set_motor_enabled")

    @JvmField
    public val isMotorEnabledName: MethodStringName0<PinJoint2D, Boolean> =
        MethodStringName0<PinJoint2D, Boolean>("is_motor_enabled")

    @JvmField
    public val setAngularLimitEnabledName: MethodStringName1<PinJoint2D, Unit, Boolean> =
        MethodStringName1<PinJoint2D, Unit, Boolean>("set_angular_limit_enabled")

    @JvmField
    public val isAngularLimitEnabledName: MethodStringName0<PinJoint2D, Boolean> =
        MethodStringName0<PinJoint2D, Boolean>("is_angular_limit_enabled")
  }

  public object MethodBindings {
    internal val setSoftnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "set_softness", 373806689)

    internal val getSoftnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "get_softness", 1740695150)

    internal val setAngularLimitLowerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "set_angular_limit_lower", 373806689)

    internal val getAngularLimitLowerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "get_angular_limit_lower", 1740695150)

    internal val setAngularLimitUpperPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "set_angular_limit_upper", 373806689)

    internal val getAngularLimitUpperPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "get_angular_limit_upper", 1740695150)

    internal val setMotorTargetVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "set_motor_target_velocity", 373806689)

    internal val getMotorTargetVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "get_motor_target_velocity", 1740695150)

    internal val setMotorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "set_motor_enabled", 2586408642)

    internal val isMotorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "is_motor_enabled", 36873697)

    internal val setAngularLimitEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "set_angular_limit_enabled", 2586408642)

    internal val isAngularLimitEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint2D", "is_angular_limit_enabled", 36873697)
  }
}
