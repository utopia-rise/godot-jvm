// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_LONG_ret_RID
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.RID
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries parent result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentParentList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(483, scriptPtr)
  }

  /**
   * Returns the RID for the parent entity at this [index].
   */
  public final fun getParent(index: Long): RID =
      TransferContext.callPtrMethod_LONG_ret_RID(ptr, objectID.id, MethodBindings.getParentPtr, index)

  public companion object {
    @JvmField
    public val getParentName: MethodStringName1<OpenXRSpatialComponentParentList, RID, Long> =
        MethodStringName1<OpenXRSpatialComponentParentList, RID, Long>("get_parent")
  }

  public object MethodBindings {
    internal val getParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentParentList", "get_parent", 495598643)
  }
}
