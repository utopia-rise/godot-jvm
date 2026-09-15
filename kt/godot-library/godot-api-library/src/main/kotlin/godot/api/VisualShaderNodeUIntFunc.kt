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
 * Accept an unsigned integer scalar (`x`) to the input port and transform it according to
 * [function].
 */
@GodotBaseType
public open class VisualShaderNodeUIntFunc : VisualShaderNode() {
  /**
   * A function to be applied to the scalar.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(893, scriptPtr)
  }

  public final fun setFunction(func: Function): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, func.value)
    TransferContext.callMethod(MethodBindings.setFunctionPtr)
  }

  public final fun getFunction(): Function {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFunctionPtr)
    return Function.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Function(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Negates the `x` using `-(x)`.
     */
    NEGATE(0),
    /**
     * Returns the result of bitwise `NOT` operation on the integer. Translates to `~a` in the Godot
     * Shader Language.
     */
    BITWISE_NOT(1),
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
    public val setFunctionName: MethodStringName1<VisualShaderNodeUIntFunc, Unit, Function> =
        MethodStringName1<VisualShaderNodeUIntFunc, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeUIntFunc, Function> =
        MethodStringName0<VisualShaderNodeUIntFunc, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntFunc", "set_function", 2273148961)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntFunc", "get_function", 4187123296)
  }
}
