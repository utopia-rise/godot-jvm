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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A constant [Vector2], which can be used as an input node.
 */
@GodotBaseType
public open class VisualShaderNodeVec2Constant : VisualShaderNodeConstant() {
  /**
   * A [Vector2] constant which represents the state of this node.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constant: Vector2
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(901, scriptPtr)
  }

  /**
   * This is a helper function for [constant] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshadernodevec2constant.constant
   * //Your changes
   * visualshadernodevec2constant.constant = myCoreType
   * ``````
   *
   * A [Vector2] constant which represents the state of this node.
   */
  @CoreTypeHelper
  public final fun constantMutate(block: Vector2.() -> Unit): Vector2 = constant.apply {
     block(this)
     constant = this
  }

  public final fun setConstant(constant: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to constant)
    TransferContext.callMethod(MethodBindings.setConstantPtr)
  }

  public final fun getConstant(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeVec2Constant, Unit, Vector2> =
        MethodStringName1<VisualShaderNodeVec2Constant, Unit, Vector2>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeVec2Constant, Vector2> =
        MethodStringName0<VisualShaderNodeVec2Constant, Vector2>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec2Constant", "set_constant", 743155724)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec2Constant", "get_constant", 3341600327)
  }
}
