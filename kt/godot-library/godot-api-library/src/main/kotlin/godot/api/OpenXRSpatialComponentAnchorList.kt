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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.TRANSFORM3D
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries anchor result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentAnchorList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(476, scriptPtr)
  }

  /**
   * Returns the transform for the entity at this [index].
   */
  public final fun getEntityPose(index: Long): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getEntityPosePtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public companion object {
    @JvmField
    public val getEntityPoseName:
        MethodStringName1<OpenXRSpatialComponentAnchorList, Transform3D, Long> =
        MethodStringName1<OpenXRSpatialComponentAnchorList, Transform3D, Long>("get_entity_pose")
  }

  public object MethodBindings {
    internal val getEntityPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentAnchorList", "get_entity_pose", 1965739696)
  }
}
