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
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the main query result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot]. This must always be the first component requested.
 */
@GodotBaseType
public open class OpenXRSpatialQueryResultData : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(493, scriptPtr)
  }

  /**
   * Returns the number of entities that were retrieved.
   */
  public final fun getCapacity(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCapacityPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the entity id (`XrSpatialEntityIdEXT`) for the entity at this [index].
   */
  public final fun getEntityId(index: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getEntityIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the entity state for the entity at this [index].
   */
  public final fun getEntityState(index: Long): OpenXRSpatialEntityTracker.EntityTrackingState {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getEntityStatePtr)
    return OpenXRSpatialEntityTracker.EntityTrackingState.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val getCapacityName: MethodStringName0<OpenXRSpatialQueryResultData, Long> =
        MethodStringName0<OpenXRSpatialQueryResultData, Long>("get_capacity")

    @JvmField
    public val getEntityIdName: MethodStringName1<OpenXRSpatialQueryResultData, Long, Long> =
        MethodStringName1<OpenXRSpatialQueryResultData, Long, Long>("get_entity_id")

    @JvmField
    public val getEntityStateName:
        MethodStringName1<OpenXRSpatialQueryResultData, OpenXRSpatialEntityTracker.EntityTrackingState, Long>
        =
        MethodStringName1<OpenXRSpatialQueryResultData, OpenXRSpatialEntityTracker.EntityTrackingState, Long>("get_entity_state")
  }

  public object MethodBindings {
    internal val getCapacityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialQueryResultData", "get_capacity", 3905245786)

    internal val getEntityIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialQueryResultData", "get_entity_id", 923996154)

    internal val getEntityStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialQueryResultData", "get_entity_state", 1411962015)
  }
}
