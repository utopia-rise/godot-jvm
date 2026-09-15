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
import godot.core.Vector3
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries 3d bounding box result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentBounded3DList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(478, scriptPtr)
  }

  /**
   * Returns the center of our bounding box for the entity at this [index].
   */
  public final fun getCenterPose(index: Long): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getCenterPosePtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Returns the size of our bounding box for the entity at this [index].
   */
  public final fun getSize(index: Long): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  public companion object {
    @JvmField
    public val getCenterPoseName:
        MethodStringName1<OpenXRSpatialComponentBounded3DList, Transform3D, Long> =
        MethodStringName1<OpenXRSpatialComponentBounded3DList, Transform3D, Long>("get_center_pose")

    @JvmField
    public val getSizeName: MethodStringName1<OpenXRSpatialComponentBounded3DList, Vector3, Long> =
        MethodStringName1<OpenXRSpatialComponentBounded3DList, Vector3, Long>("get_size")
  }

  public object MethodBindings {
    internal val getCenterPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentBounded3DList", "get_center_pose", 1965739696)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentBounded3DList", "get_size", 711720468)
  }
}
