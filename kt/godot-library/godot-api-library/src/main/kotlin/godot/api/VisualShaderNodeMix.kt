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
 * Translates to `mix(a, b, weight)` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeMix : VisualShaderNode() {
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
    createNativeObject(844, scriptPtr)
  }

  public final fun setOpType(opType: OpType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, opType.value)
    TransferContext.callPtrMethod(MethodBindings.setOpTypePtr, 0)
  }

  public final fun getOpType(): OpType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOpTypePtr, 2)
    return OpType.from(TransferContext.readReturnValue_LONG())
  }

  public enum class OpType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A floating-point scalar.
     */
    SCALAR(0),
    /**
     * A 2D vector type.
     */
    VECTOR_2D(1),
    /**
     * The `a` and `b` ports use a 2D vector type. The `weight` port uses a scalar type.
     */
    VECTOR_2D_SCALAR(2),
    /**
     * A 3D vector type.
     */
    VECTOR_3D(3),
    /**
     * The `a` and `b` ports use a 3D vector type. The `weight` port uses a scalar type.
     */
    VECTOR_3D_SCALAR(4),
    /**
     * A 4D vector type.
     */
    VECTOR_4D(5),
    /**
     * The `a` and `b` ports use a 4D vector type. The `weight` port uses a scalar type.
     */
    VECTOR_4D_SCALAR(6),
    /**
     * Represents the size of the [OpType] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): OpType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOpTypeName: MethodStringName1<VisualShaderNodeMix, Unit, OpType> =
        MethodStringName1<VisualShaderNodeMix, Unit, OpType>("set_op_type")

    @JvmField
    public val getOpTypeName: MethodStringName0<VisualShaderNodeMix, OpType> =
        MethodStringName0<VisualShaderNodeMix, OpType>("get_op_type")
  }

  public object MethodBindings {
    internal val setOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeMix", "set_op_type", 3397501671)

    internal val getOpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeMix", "get_op_type", 4013957297)
  }
}
