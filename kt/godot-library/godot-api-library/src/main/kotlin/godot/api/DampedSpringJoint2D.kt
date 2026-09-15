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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A physics joint that connects two 2D physics bodies with a spring-like force. This behaves like a
 * spring that always wants to stretch to a given length.
 */
@GodotBaseType
public open class DampedSpringJoint2D : Joint2D() {
  /**
   * The spring joint's maximum length. The two attached bodies cannot stretch it past this value.
   */
  public final inline var length: Float
    @JvmName("lengthProperty")
    get() = getLength()
    @JvmName("lengthProperty")
    set(`value`) {
      setLength(value)
    }

  /**
   * When the bodies attached to the spring joint move they stretch or squash it. The joint always
   * tries to resize towards this length.
   */
  public final inline var restLength: Float
    @JvmName("restLengthProperty")
    get() = getRestLength()
    @JvmName("restLengthProperty")
    set(`value`) {
      setRestLength(value)
    }

  /**
   * The higher the value, the less the bodies attached to the joint will deform it. The joint
   * applies an opposing force to the bodies, the product of the stiffness multiplied by the size
   * difference from its resting length.
   */
  public final inline var stiffness: Float
    @JvmName("stiffnessProperty")
    get() = getStiffness()
    @JvmName("stiffnessProperty")
    set(`value`) {
      setStiffness(value)
    }

  /**
   * The spring joint's damping ratio. A value between `0` and `1`. When the two bodies move into
   * different directions the system tries to align them to the spring axis again. A high [damping]
   * value forces the attached bodies to align faster.
   */
  public final inline var damping: Float
    @JvmName("dampingProperty")
    get() = getDamping()
    @JvmName("dampingProperty")
    set(`value`) {
      setDamping(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(203, scriptPtr)
  }

  public final fun setLength(length: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, length.toDouble())
    TransferContext.callMethod(MethodBindings.setLengthPtr)
  }

  public final fun getLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRestLength(restLength: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, restLength.toDouble())
    TransferContext.callMethod(MethodBindings.setRestLengthPtr)
  }

  public final fun getRestLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRestLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setStiffness(stiffness: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, stiffness.toDouble())
    TransferContext.callMethod(MethodBindings.setStiffnessPtr)
  }

  public final fun getStiffness(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStiffnessPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDamping(damping: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, damping.toDouble())
    TransferContext.callMethod(MethodBindings.setDampingPtr)
  }

  public final fun getDamping(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDampingPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setLengthName: MethodStringName1<DampedSpringJoint2D, Unit, Float> =
        MethodStringName1<DampedSpringJoint2D, Unit, Float>("set_length")

    @JvmField
    public val getLengthName: MethodStringName0<DampedSpringJoint2D, Float> =
        MethodStringName0<DampedSpringJoint2D, Float>("get_length")

    @JvmField
    public val setRestLengthName: MethodStringName1<DampedSpringJoint2D, Unit, Float> =
        MethodStringName1<DampedSpringJoint2D, Unit, Float>("set_rest_length")

    @JvmField
    public val getRestLengthName: MethodStringName0<DampedSpringJoint2D, Float> =
        MethodStringName0<DampedSpringJoint2D, Float>("get_rest_length")

    @JvmField
    public val setStiffnessName: MethodStringName1<DampedSpringJoint2D, Unit, Float> =
        MethodStringName1<DampedSpringJoint2D, Unit, Float>("set_stiffness")

    @JvmField
    public val getStiffnessName: MethodStringName0<DampedSpringJoint2D, Float> =
        MethodStringName0<DampedSpringJoint2D, Float>("get_stiffness")

    @JvmField
    public val setDampingName: MethodStringName1<DampedSpringJoint2D, Unit, Float> =
        MethodStringName1<DampedSpringJoint2D, Unit, Float>("set_damping")

    @JvmField
    public val getDampingName: MethodStringName0<DampedSpringJoint2D, Float> =
        MethodStringName0<DampedSpringJoint2D, Float>("get_damping")
  }

  public object MethodBindings {
    internal val setLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "set_length", 373806689)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "get_length", 1740695150)

    internal val setRestLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "set_rest_length", 373806689)

    internal val getRestLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "get_rest_length", 1740695150)

    internal val setStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "set_stiffness", 373806689)

    internal val getStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "get_stiffness", 1740695150)

    internal val setDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "set_damping", 373806689)

    internal val getDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DampedSpringJoint2D", "get_damping", 1740695150)
  }
}
