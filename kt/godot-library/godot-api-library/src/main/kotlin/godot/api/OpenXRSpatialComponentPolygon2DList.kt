// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_LONG_ret_TRANSFORM3D
import godot.callPtrMethod_RID_LONG_ret_PACKED_VECTOR2_ARRAY
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.Transform3D
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries 2D polygon result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentPolygon2DList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(487, scriptPtr)
  }

  /**
   * Returns the transform for positioning our polygon for the entity at this [index].
   */
  public final fun getTransform(index: Long): Transform3D =
      TransferContext.callPtrMethod_LONG_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.getTransformPtr, index)

  /**
   * Returns the polygon vertices for the entity at this [index].
   */
  public final fun getVertices(snapshot: RID, index: Long): PackedVector2Array =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_VECTOR2_ARRAY(ptr, objectID.id, MethodBindings.getVerticesPtr, snapshot, index)

  public companion object {
    @JvmField
    public val getTransformName:
        MethodStringName1<OpenXRSpatialComponentPolygon2DList, Transform3D, Long> =
        MethodStringName1<OpenXRSpatialComponentPolygon2DList, Transform3D, Long>("get_transform")

    @JvmField
    public val getVerticesName:
        MethodStringName2<OpenXRSpatialComponentPolygon2DList, PackedVector2Array, RID, Long> =
        MethodStringName2<OpenXRSpatialComponentPolygon2DList, PackedVector2Array, RID, Long>("get_vertices")
  }

  public object MethodBindings {
    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentPolygon2DList", "get_transform", 1965739696)

    internal val getVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentPolygon2DList", "get_vertices", 110850971)
  }
}
