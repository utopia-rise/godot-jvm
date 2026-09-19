// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Constrains a value to lie between `min` and `max` values.
 */
@GodotBaseType
public open class VisualShaderNodeClamp : VisualShaderNode() {
  /**
   * A type of operands and returned value.
   */
  public final inline var opType: OpType
    @JvmName("opTypeProperty")
    get() = getOpType()
    @JvmName("opTypeProperty")
    set(`value`) {
      setOpType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(809, scriptPtr)
  }

  public final fun setOpType(opType: OpType): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOpTypePtr, opType.value)
  }

  public final fun getOpType(): OpType =
      OpType.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOpTypePtr))

  public enum class OpType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A floating-point scalar.
     */
    FLOAT(0),
    /**
     * An integer scalar.
     */
    INT(1),
    /**
     * An unsigned integer scalar.
     */
    UINT(2),
    /**
     * A 2D vector type.
     */
    VECTOR_2D(3),
    /**
     * A 3D vector type.
     */
    VECTOR_3D(4),
    /**
     * A 4D vector type.
     */
    VECTOR_4D(5),
    /**
     * Represents the size of the [OpType] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): OpType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOpTypeName: MethodStringName1<VisualShaderNodeClamp, Unit, OpType> =
        MethodStringName1<VisualShaderNodeClamp, Unit, OpType>("set_op_type")

    @JvmField
    public val getOpTypeName: MethodStringName0<VisualShaderNodeClamp, OpType> =
        MethodStringName0<VisualShaderNodeClamp, OpType>("get_op_type")
  }

  public object MethodBindings {
    internal val setOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeClamp", "set_op_type", 405010749)

    internal val getOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeClamp", "get_op_type", 233276050)
  }
}
