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
import godot.core.VariantParser.LONG
import godot.core.Vector2
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * UV functions are similar to [Vector2] functions, but the input port of this node uses the
 * shader's UV value by default.
 */
@GodotBaseType
public open class VisualShaderNodeUVFunc : VisualShaderNode() {
  /**
   * A function to be applied to the texture coordinates.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(896, scriptPtr)
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
     * Translates `uv` by using `scale` and `offset` values using the following formula: `uv = uv +
     * offset * scale`. `uv` port is connected to `UV` built-in by default.
     */
    PANNING(0),
    /**
     * Scales `uv` by using `scale` and `pivot` values using the following formula: `uv = (uv -
     * pivot) * scale + pivot`. `uv` port is connected to `UV` built-in by default.
     */
    SCALING(1),
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
    public val setFunctionName: MethodStringName1<VisualShaderNodeUVFunc, Unit, Function> =
        MethodStringName1<VisualShaderNodeUVFunc, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeUVFunc, Function> =
        MethodStringName0<VisualShaderNodeUVFunc, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUVFunc", "set_function", 765791915)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUVFunc", "get_function", 3772902164)
  }
}
