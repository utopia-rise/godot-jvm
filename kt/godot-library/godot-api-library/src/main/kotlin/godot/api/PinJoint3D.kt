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
 * A physics joint that attaches two 3D physics bodies at a single point, allowing them to freely
 * rotate. For example, a [RigidBody3D] can be attached to a [StaticBody3D] to create a pendulum or a
 * seesaw.
 */
@GodotBaseType
public open class PinJoint3D : Joint3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(550, scriptPtr)
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
     * The force with which the pinned objects stay in positional relation to each other. The
     * higher, the stronger.
     */
    BIAS(0),
    /**
     * The force with which the pinned objects stay in velocity relation to each other. The higher,
     * the stronger.
     */
    DAMPING(1),
    /**
     * If above 0, this value is the maximum value for an impulse that this Joint3D produces.
     */
    IMPULSE_CLAMP(2),
    ;

    public companion object {
      public fun from(`value`: Long): Param = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setParamName: MethodStringName2<PinJoint3D, Unit, Param, Float> =
        MethodStringName2<PinJoint3D, Unit, Param, Float>("set_param")

    @JvmField
    public val getParamName: MethodStringName1<PinJoint3D, Float, Param> =
        MethodStringName1<PinJoint3D, Float, Param>("get_param")
  }

  public object MethodBindings {
    internal val setParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint3D", "set_param", 2059913726)

    internal val getParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PinJoint3D", "get_param", 1758438771)
  }
}
