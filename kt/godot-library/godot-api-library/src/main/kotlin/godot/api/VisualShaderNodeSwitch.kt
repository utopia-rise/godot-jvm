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
 * Returns an associated value of the [opType] type if the provided boolean value is `true` or
 * `false`.
 */
@GodotBaseType
public open class VisualShaderNodeSwitch : VisualShaderNode() {
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
    createNativeObject(874, scriptPtr)
  }

  public final fun setOpType(type: OpType): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOpTypePtr, type.value)
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
     * A boolean type.
     */
    BOOLEAN(6),
    /**
     * A transform type.
     */
    TRANSFORM(7),
    /**
     * Represents the size of the [OpType] enum.
     */
    MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): OpType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOpTypeName: MethodStringName1<VisualShaderNodeSwitch, Unit, OpType> =
        MethodStringName1<VisualShaderNodeSwitch, Unit, OpType>("set_op_type")

    @JvmField
    public val getOpTypeName: MethodStringName0<VisualShaderNodeSwitch, OpType> =
        MethodStringName0<VisualShaderNodeSwitch, OpType>("get_op_type")
  }

  public object MethodBindings {
    internal val setOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeSwitch", "set_op_type", 510471861)

    internal val getOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeSwitch", "get_op_type", 2517845071)
  }
}
