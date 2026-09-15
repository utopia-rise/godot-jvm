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
import kotlin.jvm.JvmName

/**
 * A physics joint that connects two 3D physics bodies in a way that simulates a ball-and-socket
 * joint. The twist axis is initiated as the X axis of the [ConeTwistJoint3D]. Once the physics bodies
 * swing, the twist axis is calculated as the middle of the X axes of the joint in the local space of
 * the two physics bodies. Useful for limbs like shoulders and hips, lamps hanging off a ceiling, etc.
 */
@GodotBaseType
public open class ConeTwistJoint3D : Joint3D() {
  /**
   * Swing is rotation from side to side, around the axis perpendicular to the twist axis.
   *
   * The swing span defines, how much rotation will not get corrected along the swing axis.
   *
   * Could be defined as looseness in the [ConeTwistJoint3D].
   *
   * If below 0.05, this behavior is locked.
   */
  public final inline var swingSpan: Float
    @JvmName("swingSpanProperty")
    get() = getParam(ConeTwistJoint3D.Param.SWING_SPAN)
    @JvmName("swingSpanProperty")
    set(`value`) {
      setParam(ConeTwistJoint3D.Param.SWING_SPAN, value)
    }

  /**
   * Twist is the rotation around the twist axis, this value defined how far the joint can twist.
   *
   * Twist is locked if below 0.05.
   */
  public final inline var twistSpan: Float
    @JvmName("twistSpanProperty")
    get() = getParam(ConeTwistJoint3D.Param.TWIST_SPAN)
    @JvmName("twistSpanProperty")
    set(`value`) {
      setParam(ConeTwistJoint3D.Param.TWIST_SPAN, value)
    }

  /**
   * The speed with which the swing or twist will take place.
   *
   * The higher, the faster.
   */
  public final inline var bias: Float
    @JvmName("biasProperty")
    get() = getParam(ConeTwistJoint3D.Param.BIAS)
    @JvmName("biasProperty")
    set(`value`) {
      setParam(ConeTwistJoint3D.Param.BIAS, value)
    }

  /**
   * The ease with which the joint starts to twist. If it's too low, it takes more force to start
   * twisting the joint.
   */
  public final inline var softness: Float
    @JvmName("softnessProperty")
    get() = getParam(ConeTwistJoint3D.Param.SOFTNESS)
    @JvmName("softnessProperty")
    set(`value`) {
      setParam(ConeTwistJoint3D.Param.SOFTNESS, value)
    }

  /**
   * Defines, how fast the swing- and twist-speed-difference on both sides gets synced.
   */
  public final inline var relaxation: Float
    @JvmName("relaxationProperty")
    get() = getParam(ConeTwistJoint3D.Param.RELAXATION)
    @JvmName("relaxationProperty")
    set(`value`) {
      setParam(ConeTwistJoint3D.Param.RELAXATION, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(181, scriptPtr)
  }

  /**
   * Sets the value of the specified parameter.
   */
  public final fun setParam(`param`: Param, `value`: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, param.value, value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamPtr)
  }

  /**
   * Returns the value of the specified parameter.
   */
  public final fun getParam(`param`: Param): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, param.value)
    TransferContext.callMethod(MethodBindings.getParamPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public enum class Param(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Swing is rotation from side to side, around the axis perpendicular to the twist axis.
     *
     * The swing span defines, how much rotation will not get corrected along the swing axis.
     *
     * Could be defined as looseness in the [ConeTwistJoint3D].
     *
     * If below 0.05, this behavior is locked.
     */
    SWING_SPAN(0),
    /**
     * Twist is the rotation around the twist axis, this value defined how far the joint can twist.
     *
     * Twist is locked if below 0.05.
     */
    TWIST_SPAN(1),
    /**
     * The speed with which the swing or twist will take place.
     *
     * The higher, the faster.
     */
    BIAS(2),
    /**
     * The ease with which the joint starts to twist. If it's too low, it takes more force to start
     * twisting the joint.
     */
    SOFTNESS(3),
    /**
     * Defines, how fast the swing- and twist-speed-difference on both sides gets synced.
     */
    RELAXATION(4),
    /**
     * Represents the size of the [Param] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): Param = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setParamName: MethodStringName2<ConeTwistJoint3D, Unit, Param, Float> =
        MethodStringName2<ConeTwistJoint3D, Unit, Param, Float>("set_param")

    @JvmField
    public val getParamName: MethodStringName1<ConeTwistJoint3D, Float, Param> =
        MethodStringName1<ConeTwistJoint3D, Float, Param>("get_param")
  }

  public object MethodBindings {
    internal val setParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConeTwistJoint3D", "set_param", 1062470226)

    internal val getParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConeTwistJoint3D", "get_param", 2928790850)
  }
}
