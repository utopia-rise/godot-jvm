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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [MultiMeshInstance3D] is a specialized node to instance [GeometryInstance3D]s based on a
 * [MultiMesh] resource.
 *
 * This is useful to optimize the rendering of a high number of instances of a given mesh (for
 * example trees in a forest or grass strands).
 */
@GodotBaseType
public open class MultiMeshInstance3D : GeometryInstance3D() {
  /**
   * The [MultiMesh] resource that will be used and shared among all instances of the
   * [MultiMeshInstance3D].
   */
  public final inline var multimesh: MultiMesh?
    @JvmName("multimeshProperty")
    get() = getMultimesh()
    @JvmName("multimeshProperty")
    set(`value`) {
      setMultimesh(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(388, scriptPtr)
  }

  public final fun setMultimesh(multimesh: MultiMesh?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, multimesh)
    TransferContext.callMethod(MethodBindings.setMultimeshPtr)
  }

  public final fun getMultimesh(): MultiMesh? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMultimeshPtr)
    return (TransferContext.readReturnValue_OBJECT() as MultiMesh?)
  }

  public companion object {
    @JvmField
    public val setMultimeshName: MethodStringName1<MultiMeshInstance3D, Unit, MultiMesh?> =
        MethodStringName1<MultiMeshInstance3D, Unit, MultiMesh?>("set_multimesh")

    @JvmField
    public val getMultimeshName: MethodStringName0<MultiMeshInstance3D, MultiMesh?> =
        MethodStringName0<MultiMeshInstance3D, MultiMesh?>("get_multimesh")
  }

  public object MethodBindings {
    internal val setMultimeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiMeshInstance3D", "set_multimesh", 2246127404)

    internal val getMultimeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiMeshInstance3D", "get_multimesh", 1385450523)
  }
}
