// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.COLOR
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Has two output ports representing RGB and alpha channels of [Color].
 *
 * Translated to `vec3 rgb` and `float alpha` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeColorConstant : VisualShaderNodeConstant() {
  /**
   * A [Color] constant which represents a state of this node.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constant: Color
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(810, scriptPtr)
  }

  /**
   * This is a helper function for [constant] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshadernodecolorconstant.constant
   * //Your changes
   * visualshadernodecolorconstant.constant = myCoreType
   * ``````
   *
   * A [Color] constant which represents a state of this node.
   */
  @CoreTypeHelper
  public final fun constantMutate(block: Color.() -> Unit): Color = constant.apply {
     block(this)
     constant = this
  }

  public final fun setConstant(constant: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to constant)
    TransferContext.callMethod(MethodBindings.setConstantPtr)
  }

  public final fun getConstant(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeColorConstant, Unit, Color> =
        MethodStringName1<VisualShaderNodeColorConstant, Unit, Color>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeColorConstant, Color> =
        MethodStringName0<VisualShaderNodeColorConstant, Color>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeColorConstant", "set_constant", 2920490490)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeColorConstant", "get_constant", 3444240500)
  }
}
