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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is an abstract class. See the derived types for descriptions of the possible operations.
 */
@GodotBaseType
public open class VisualShaderNodeVectorBase internal constructor() : VisualShaderNode() {
  /**
   * A vector type that this operation is performed on.
   */
  public final inline var opType: OpType
    @JvmName("opTypeProperty")
    get() = getOpType()
    @JvmName("opTypeProperty")
    set(`value`) {
      setOpType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(907, scriptPtr)
  }

  public final fun setOpType(type: OpType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, type.value)
    TransferContext.callMethod(MethodBindings.setOpTypePtr)
  }

  public final fun getOpType(): OpType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOpTypePtr)
    return OpType.from(TransferContext.readReturnValue_LONG())
  }

  public enum class OpType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A 2D vector type.
     */
    VECTOR_2D(0),
    /**
     * A 3D vector type.
     */
    VECTOR_3D(1),
    /**
     * A 4D vector type.
     */
    VECTOR_4D(2),
    /**
     * Represents the size of the [OpType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): OpType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOpTypeName: MethodStringName1<VisualShaderNodeVectorBase, Unit, OpType> =
        MethodStringName1<VisualShaderNodeVectorBase, Unit, OpType>("set_op_type")

    @JvmField
    public val getOpTypeName: MethodStringName0<VisualShaderNodeVectorBase, OpType> =
        MethodStringName0<VisualShaderNodeVectorBase, OpType>("get_op_type")
  }

  public object MethodBindings {
    internal val setOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVectorBase", "set_op_type", 1692596998)

    internal val getOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVectorBase", "get_op_type", 2568738462)
  }
}
