// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_LONG_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName1
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries plane alignment result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentPlaneAlignmentList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(485, scriptPtr)
  }

  /**
   * Returns the plane alignment for the parent entity at this [index].
   */
  public final fun getPlaneAlignment(index: Long): PlaneAlignment =
      PlaneAlignment.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getPlaneAlignmentPtr, index))

  public enum class PlaneAlignment(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Plane is facing upward.
     */
    HORIZONTAL_UPWARD(0),
    /**
     * Plane is facing downwards.
     */
    HORIZONTAL_DOWNWARD(1),
    /**
     * Plane is vertically aligned.
     */
    VERTICAL(2),
    /**
     * Plane has an arbitrary alignment.
     */
    ARBITRARY(3),
    ;

    public companion object {
      public fun from(`value`: Long): PlaneAlignment = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getPlaneAlignmentName:
        MethodStringName1<OpenXRSpatialComponentPlaneAlignmentList, PlaneAlignment, Long> =
        MethodStringName1<OpenXRSpatialComponentPlaneAlignmentList, PlaneAlignment, Long>("get_plane_alignment")
  }

  public object MethodBindings {
    internal val getPlaneAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentPlaneAlignmentList", "get_plane_alignment", 3340200270)
  }
}
