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
import godot.core.MethodStringName1
import godot.core.Transform3D
import godot.readReturnValue_OBJECT
import godot.readReturnValue_TRANSFORM3D
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries 3d mesh result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentMesh3DList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(482, scriptPtr)
  }

  /**
   * Returns the transform for positioning our mesh for the entity at this [index].
   */
  public final fun getTransform(index: Long): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Returns the mesh for the entity at this [index].
   */
  public final fun getMesh(index: Long): Mesh? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue_OBJECT() as Mesh?)
  }

  public companion object {
    @JvmField
    public val getTransformName:
        MethodStringName1<OpenXRSpatialComponentMesh3DList, Transform3D, Long> =
        MethodStringName1<OpenXRSpatialComponentMesh3DList, Transform3D, Long>("get_transform")

    @JvmField
    public val getMeshName: MethodStringName1<OpenXRSpatialComponentMesh3DList, Mesh?, Long> =
        MethodStringName1<OpenXRSpatialComponentMesh3DList, Mesh?, Long>("get_mesh")
  }

  public object MethodBindings {
    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentMesh3DList", "get_transform", 1965739696)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentMesh3DList", "get_mesh", 1576363275)
  }
}
