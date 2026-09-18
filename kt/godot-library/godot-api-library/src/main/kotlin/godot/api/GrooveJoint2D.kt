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
 * A physics joint that restricts the movement of two 2D physics bodies to a fixed axis. For
 * example, a [StaticBody2D] representing a piston base can be attached to a [RigidBody2D] representing
 * the piston head, moving up and down.
 */
@GodotBaseType
public open class GrooveJoint2D : Joint2D() {
  /**
   * The groove's length. The groove is from the joint's origin towards [length] along the joint's
   * local Y axis.
   */
  public final inline var length: Float
    @JvmName("lengthProperty")
    get() = getLength()
    @JvmName("lengthProperty")
    set(`value`) {
      setLength(value)
    }

  /**
   * The body B's initial anchor position defined by the joint's origin and a local offset
   * [initialOffset] along the joint's Y axis (along the groove).
   */
  public final inline var initialOffset: Float
    @JvmName("initialOffsetProperty")
    get() = getInitialOffset()
    @JvmName("initialOffsetProperty")
    set(`value`) {
      setInitialOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(283, scriptPtr)
  }

  public final fun setLength(length: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, length.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setLengthPtr, 0)
  }

  public final fun getLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setInitialOffset(offset: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, offset.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setInitialOffsetPtr, 0)
  }

  public final fun getInitialOffset(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInitialOffsetPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setLengthName: MethodStringName1<GrooveJoint2D, Unit, Float> =
        MethodStringName1<GrooveJoint2D, Unit, Float>("set_length")

    @JvmField
    public val getLengthName: MethodStringName0<GrooveJoint2D, Float> =
        MethodStringName0<GrooveJoint2D, Float>("get_length")

    @JvmField
    public val setInitialOffsetName: MethodStringName1<GrooveJoint2D, Unit, Float> =
        MethodStringName1<GrooveJoint2D, Unit, Float>("set_initial_offset")

    @JvmField
    public val getInitialOffsetName: MethodStringName0<GrooveJoint2D, Float> =
        MethodStringName0<GrooveJoint2D, Float>("get_initial_offset")
  }

  public object MethodBindings {
    internal val setLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GrooveJoint2D", "set_length", 373806689)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GrooveJoint2D", "get_length", 1740695150)

    internal val setInitialOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GrooveJoint2D", "set_initial_offset", 373806689)

    internal val getInitialOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GrooveJoint2D", "get_initial_offset", 1740695150)
  }
}
