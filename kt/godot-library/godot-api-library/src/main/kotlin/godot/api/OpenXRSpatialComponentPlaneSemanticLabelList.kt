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
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries plane semantic label result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentPlaneSemanticLabelList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(486, scriptPtr)
  }

  /**
   * Returns the plane semantic label for the parent entity at this [index].
   */
  public final fun getPlaneSemanticLabel(index: Long): PlaneSemanticLabel {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getPlaneSemanticLabelPtr)
    return PlaneSemanticLabel.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class PlaneSemanticLabel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Uncategorized plane.
     */
    UNCATEGORIZED(1),
    /**
     * Plane represents a floor.
     */
    FLOOR(2),
    /**
     * Plane represents a wall.
     */
    WALL(3),
    /**
     * Plane represents a ceiling.
     */
    CEILING(4),
    /**
     * Plane represents the surface of a table.
     */
    TABLE(5),
    ;

    public companion object {
      public fun from(`value`: Long): PlaneSemanticLabel = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getPlaneSemanticLabelName:
        MethodStringName1<OpenXRSpatialComponentPlaneSemanticLabelList, PlaneSemanticLabel, Long> =
        MethodStringName1<OpenXRSpatialComponentPlaneSemanticLabelList, PlaneSemanticLabel, Long>("get_plane_semantic_label")
  }

  public object MethodBindings {
    internal val getPlaneSemanticLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentPlaneSemanticLabelList", "get_plane_semantic_label", 1889332427)
  }
}
