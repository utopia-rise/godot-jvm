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
import godot.core.Transform3D
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Computes an inverse or transpose function on the provided [Transform3D].
 */
@GodotBaseType
public open class VisualShaderNodeTransformFunc : VisualShaderNode() {
  /**
   * The function to be computed.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(888, scriptPtr)
  }

  public final fun setFunction(func: Function): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to func.value)
    TransferContext.callMethod(MethodBindings.setFunctionPtr)
  }

  public final fun getFunction(): Function {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFunctionPtr)
    return Function.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class Function(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Perform the inverse operation on the [Transform3D] matrix.
     */
    INVERSE(0),
    /**
     * Perform the transpose operation on the [Transform3D] matrix.
     */
    TRANSPOSE(1),
    /**
     * Represents the size of the [Function] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): Function = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFunctionName: MethodStringName1<VisualShaderNodeTransformFunc, Unit, Function> =
        MethodStringName1<VisualShaderNodeTransformFunc, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeTransformFunc, Function> =
        MethodStringName0<VisualShaderNodeTransformFunc, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformFunc", "set_function", 2900990409)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformFunc", "get_function", 2839926569)
  }
}
