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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal1
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_RID
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * These are trackers created and managed by OpenXR's spatial entity extensions that give access to
 * specific data related to OpenXR's spatial entities. They will always be of type `TRACKER_ANCHOR`.
 */
@GodotBaseType
public open class OpenXRSpatialEntityTracker : XRPositionalTracker() {
  /**
   * Emitted when the next-chain changes, from either [addNext] or [removeNext].
   */
  public val nextChanged: Signal0 by Signal0

  public val spatialTrackingStateChanged: Signal1<Long> by Signal1

  /**
   * The spatial entity associated with this tracker.
   */
  public final inline var entity: RID
    @JvmName("entityProperty")
    get() = getEntity()
    @JvmName("entityProperty")
    set(`value`) {
      setEntity(value)
    }

  /**
   * The spatial tracking state for this tracker.
   */
  public final inline var spatialTrackingState: EntityTrackingState
    @JvmName("spatialTrackingStateProperty")
    get() = getSpatialTrackingState()
    @JvmName("spatialTrackingStateProperty")
    set(`value`) {
      setSpatialTrackingState(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(490, scriptPtr)
  }

  /**
   * Sets the spatial context used to create this tracker.
   */
  public final fun setSpatialContext(spatialContext: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, spatialContext)
    TransferContext.callMethod(MethodBindings.setSpatialContextPtr)
  }

  /**
   * Gets the spatial context used to create this [OpenXRSpatialEntityTracker].
   */
  public final fun getSpatialContext(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpatialContextPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setEntity(entity: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, entity)
    TransferContext.callMethod(MethodBindings.setEntityPtr)
  }

  public final fun getEntity(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEntityPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setSpatialTrackingState(spatialTrackingState: EntityTrackingState): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, spatialTrackingState.value)
    TransferContext.callMethod(MethodBindings.setSpatialTrackingStatePtr)
  }

  public final fun getSpatialTrackingState(): EntityTrackingState {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpatialTrackingStatePtr)
    return EntityTrackingState.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Gets the head [OpenXRStructureBase] in the next-chain.
   *
   * See also [addNext] and [removeNext].
   */
  public final fun getNext(): OpenXRStructureBase? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRStructureBase?)
  }

  /**
   * Adds a new [OpenXRStructureBase] to the next-chain.
   *
   * [getNext] will return this [next] until either [addNext] is called again or it's removed in
   * [removeNext].
   */
  public final fun addNext(next: OpenXRStructureBase?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, next)
    TransferContext.callMethod(MethodBindings.addNextPtr)
  }

  /**
   * Removes a [next] object previously added in [addNext] from the next-chain.
   */
  public final fun removeNext(next: OpenXRStructureBase?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, next)
    TransferContext.callMethod(MethodBindings.removeNextPtr)
  }

  public enum class EntityTrackingState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This anchor has stopped tracking.
     */
    STOPPED(1),
    /**
     * Tracking is currently paused.
     */
    PAUSED(2),
    /**
     * This anchor is currently being tracked.
     */
    TRACKING(3),
    ;

    public companion object {
      public fun from(`value`: Long): EntityTrackingState = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSpatialContextName: MethodStringName1<OpenXRSpatialEntityTracker, Unit, RID> =
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, RID>("set_spatial_context")

    @JvmField
    public val getSpatialContextName: MethodStringName0<OpenXRSpatialEntityTracker, RID> =
        MethodStringName0<OpenXRSpatialEntityTracker, RID>("get_spatial_context")

    @JvmField
    public val setEntityName: MethodStringName1<OpenXRSpatialEntityTracker, Unit, RID> =
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, RID>("set_entity")

    @JvmField
    public val getEntityName: MethodStringName0<OpenXRSpatialEntityTracker, RID> =
        MethodStringName0<OpenXRSpatialEntityTracker, RID>("get_entity")

    @JvmField
    public val setSpatialTrackingStateName:
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, EntityTrackingState> =
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, EntityTrackingState>("set_spatial_tracking_state")

    @JvmField
    public val getSpatialTrackingStateName:
        MethodStringName0<OpenXRSpatialEntityTracker, EntityTrackingState> =
        MethodStringName0<OpenXRSpatialEntityTracker, EntityTrackingState>("get_spatial_tracking_state")

    @JvmField
    public val getNextName: MethodStringName0<OpenXRSpatialEntityTracker, OpenXRStructureBase?> =
        MethodStringName0<OpenXRSpatialEntityTracker, OpenXRStructureBase?>("get_next")

    @JvmField
    public val addNextName:
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, OpenXRStructureBase?> =
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, OpenXRStructureBase?>("add_next")

    @JvmField
    public val removeNextName:
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, OpenXRStructureBase?> =
        MethodStringName1<OpenXRSpatialEntityTracker, Unit, OpenXRStructureBase?>("remove_next")
  }

  public object MethodBindings {
    internal val setSpatialContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "set_spatial_context", 2722037293)

    internal val getSpatialContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "get_spatial_context", 2944877500)

    internal val setEntityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "set_entity", 2722037293)

    internal val getEntityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "get_entity", 2944877500)

    internal val setSpatialTrackingStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "set_spatial_tracking_state", 2170234447)

    internal val getSpatialTrackingStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "get_spatial_tracking_state", 3351876560)

    internal val getNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "get_next", 2798796760)

    internal val addNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "add_next", 334698771)

    internal val removeNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityTracker", "remove_next", 334698771)
  }
}
