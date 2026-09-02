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
import godot.core.Quaternion
import godot.core.VariantParser.QUATERNION
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A constant 4D vector, which can be used as an input node.
 */
@GodotBaseType
public open class VisualShaderNodeVec4Constant : VisualShaderNodeConstant() {
  /**
   * A 4D vector (represented as a [Quaternion]) constant which represents the state of this node.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constant: Quaternion
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(905, scriptPtr)
  }

  /**
   * This is a helper function for [constant] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshadernodevec4constant.constant
   * //Your changes
   * visualshadernodevec4constant.constant = myCoreType
   * ``````
   *
   * A 4D vector (represented as a [Quaternion]) constant which represents the state of this node.
   */
  @CoreTypeHelper
  public final fun constantMutate(block: Quaternion.() -> Unit): Quaternion = constant.apply {
     block(this)
     constant = this
  }

  public final fun setConstant(constant: Quaternion): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, QUATERNION to constant)
    TransferContext.callMethod(MethodBindings.setConstantPtr)
  }

  public final fun getConstant(): Quaternion {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantPtr)
    return (TransferContext.readReturnValue(QUATERNION) as Quaternion)
  }

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeVec4Constant, Unit, Quaternion> =
        MethodStringName1<VisualShaderNodeVec4Constant, Unit, Quaternion>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeVec4Constant, Quaternion> =
        MethodStringName0<VisualShaderNodeVec4Constant, Quaternion>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec4Constant", "set_constant", 1727505552)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec4Constant", "get_constant", 1222331677)
  }
}
