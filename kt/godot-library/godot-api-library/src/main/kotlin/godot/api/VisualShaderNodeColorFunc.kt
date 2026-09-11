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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Accept a [Color] to the input port and transform it according to [function].
 */
@GodotBaseType
public open class VisualShaderNodeColorFunc : VisualShaderNode() {
  /**
   * A function to be applied to the input color.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(811, scriptPtr)
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
     * Converts the color to grayscale using the following formula:
     *
     * ```
     * vec3 c = input;
     * float max1 = max(c.r, c.g);
     * float max2 = max(max1, c.b);
     * float max3 = max(max1, max2);
     * return vec3(max3, max3, max3);
     * ```
     */
    GRAYSCALE(0),
    /**
     * Converts HSV vector to RGB equivalent.
     */
    HSV2RGB(1),
    /**
     * Converts RGB vector to HSV equivalent.
     */
    RGB2HSV(2),
    /**
     * Applies sepia tone effect using the following formula:
     *
     * ```
     * vec3 c = input;
     * float r = (c.r * 0.393) + (c.g * 0.769) + (c.b * 0.189);
     * float g = (c.r * 0.349) + (c.g * 0.686) + (c.b * 0.168);
     * float b = (c.r * 0.272) + (c.g * 0.534) + (c.b * 0.131);
     * return vec3(r, g, b);
     * ```
     */
    SEPIA(3),
    /**
     * Converts color from linear encoding to nonlinear sRGB encoding using the following formula:
     *
     * ```
     * const vec3 a = vec3(0.055f);
     * return mix((vec3(1.0f) + a) * pow(c.rgb, vec3(1.0f / 2.4f)) - a, 12.92f * c.rgb,
     * lessThan(c.rgb, vec3(0.0031308f)));
     * ```
     *
     * The Compatibility renderer uses a simpler formula that may produce undefined behavior with
     * negative input values:
     *
     * ```
     * vec3 c = input;
     * return max(vec3(1.055) * pow(c, vec3(0.416666667)) - vec3(0.055), vec3(0.0));
     * ```
     */
    LINEAR_TO_SRGB(4),
    /**
     * Converts color from nonlinear sRGB encoding to linear encoding using the following formula:
     *
     * ```
     * vec3 c = input;
     * return mix(pow((c.rgb + vec3(0.055)) * (1.0 / (1.0 + 0.055)), vec3(2.4)), c.rgb * (1.0 /
     * 12.92), lessThan(c.rgb, vec3(0.04045)));
     * ```
     *
     * The Compatibility renderer uses a simpler formula that behaves poorly with negative input
     * values:
     *
     * ```
     * vec3 c = input;
     * return c * (c * (c * 0.305306011 + 0.682171111) + 0.012522878);
     * ```
     */
    SRGB_TO_LINEAR(5),
    /**
     * Represents the size of the [Function] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): Function = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFunctionName: MethodStringName1<VisualShaderNodeColorFunc, Unit, Function> =
        MethodStringName1<VisualShaderNodeColorFunc, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeColorFunc, Function> =
        MethodStringName0<VisualShaderNodeColorFunc, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeColorFunc", "set_function", 3973396138)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeColorFunc", "get_function", 554863321)
  }
}
