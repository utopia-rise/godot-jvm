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
 * Returns the boolean result of the comparison between `INF` or `NaN` and a scalar parameter.
 */
@GodotBaseType
public open class VisualShaderNodeIs : VisualShaderNode() {
  /**
   * The comparison function.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(842, scriptPtr)
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
     * Comparison with `INF` (Infinity).
     */
    IS_INF(0),
    /**
     * Comparison with `NaN` (Not a Number; indicates invalid numeric results, such as division by
     * zero).
     */
    IS_NAN(1),
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
    public val setFunctionName: MethodStringName1<VisualShaderNodeIs, Unit, Function> =
        MethodStringName1<VisualShaderNodeIs, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeIs, Function> =
        MethodStringName0<VisualShaderNodeIs, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeIs", "set_function", 1438374690)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeIs", "get_function", 580678557)
  }
}
