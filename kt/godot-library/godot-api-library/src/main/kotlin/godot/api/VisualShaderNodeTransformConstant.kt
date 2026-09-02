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
import godot.core.Transform3D
import godot.core.VariantParser.TRANSFORM3D
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A constant [Transform3D], which can be used as an input node.
 */
@GodotBaseType
public open class VisualShaderNodeTransformConstant : VisualShaderNodeConstant() {
  /**
   * A [Transform3D] constant which represents the state of this node.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constant: Transform3D
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(886, scriptPtr)
  }

  /**
   * This is a helper function for [constant] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshadernodetransformconstant.constant
   * //Your changes
   * visualshadernodetransformconstant.constant = myCoreType
   * ``````
   *
   * A [Transform3D] constant which represents the state of this node.
   */
  @CoreTypeHelper
  public final fun constantMutate(block: Transform3D.() -> Unit): Transform3D = constant.apply {
     block(this)
     constant = this
  }

  public final fun setConstant(constant: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to constant)
    TransferContext.callMethod(MethodBindings.setConstantPtr)
  }

  public final fun getConstant(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public companion object {
    @JvmField
    public val setConstantName:
        MethodStringName1<VisualShaderNodeTransformConstant, Unit, Transform3D> =
        MethodStringName1<VisualShaderNodeTransformConstant, Unit, Transform3D>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeTransformConstant, Transform3D> =
        MethodStringName0<VisualShaderNodeTransformConstant, Transform3D>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformConstant", "set_constant", 2952846383)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformConstant", "get_constant", 3229777777)
  }
}
