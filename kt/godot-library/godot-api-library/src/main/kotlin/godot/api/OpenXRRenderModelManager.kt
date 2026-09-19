// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal1
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This helper node will automatically manage displaying render models. It will create new
 * [OpenXRRenderModel] nodes as controllers and other hand held devices are detected, and remove those
 * nodes when they are deactivated.
 *
 * **Note:** If you want more control over this logic you can alternatively call
 * [OpenXRRenderModelExtension.renderModelGetAll] to obtain a list of active render model ids and
 * create [OpenXRRenderModel] instances for each render model id provided.
 */
@GodotBaseType
public open class OpenXRRenderModelManager : Node3D() {
  /**
   * Emitted when a render model node is added as a child to this node.
   */
  public val renderModelAdded: Signal1<OpenXRRenderModel> by Signal1

  /**
   * Emitted when a render model child node is about to be removed from this node.
   */
  public val renderModelRemoved: Signal1<OpenXRRenderModel> by Signal1

  /**
   * Limits render models to the specified tracker. Include: 0 = All render models, 1 = Render
   * models not related to a tracker, 2 = Render models related to the left hand tracker, 3 = Render
   * models related to the right hand tracker.
   */
  public final inline var tracker: RenderModelTracker
    @JvmName("trackerProperty")
    get() = getTracker()
    @JvmName("trackerProperty")
    set(`value`) {
      setTracker(value)
    }

  /**
   * Position render models local to this pose (this will adjust the position of the render models
   * container node).
   */
  public final inline var makeLocalToPose: String
    @JvmName("makeLocalToPoseProperty")
    get() = getMakeLocalToPose()
    @JvmName("makeLocalToPoseProperty")
    set(`value`) {
      setMakeLocalToPose(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(467, scriptPtr)
  }

  public final fun getTracker(): RenderModelTracker =
      RenderModelTracker.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTrackerPtr))

  public final fun setTracker(tracker: RenderModelTracker): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTrackerPtr, tracker.value)
  }

  public final fun getMakeLocalToPose(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getMakeLocalToPosePtr)

  public final fun setMakeLocalToPose(makeLocalToPose: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setMakeLocalToPosePtr, makeLocalToPose)
  }

  public enum class RenderModelTracker(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * All active render models are shown regardless of what tracker they relate to.
     */
    ANY(0),
    /**
     * Only active render models are shown that are not related to any tracker we manage.
     */
    NONE_SET(1),
    /**
     * Only active render models are shown that are related to the left hand tracker.
     */
    LEFT_HAND(2),
    /**
     * Only active render models are shown that are related to the right hand tracker.
     */
    RIGHT_HAND(3),
    ;

    public companion object {
      public fun from(`value`: Long): RenderModelTracker = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getTrackerName: MethodStringName0<OpenXRRenderModelManager, RenderModelTracker> =
        MethodStringName0<OpenXRRenderModelManager, RenderModelTracker>("get_tracker")

    @JvmField
    public val setTrackerName: MethodStringName1<OpenXRRenderModelManager, Unit, RenderModelTracker>
        = MethodStringName1<OpenXRRenderModelManager, Unit, RenderModelTracker>("set_tracker")

    @JvmField
    public val getMakeLocalToPoseName: MethodStringName0<OpenXRRenderModelManager, String> =
        MethodStringName0<OpenXRRenderModelManager, String>("get_make_local_to_pose")

    @JvmField
    public val setMakeLocalToPoseName: MethodStringName1<OpenXRRenderModelManager, Unit, String> =
        MethodStringName1<OpenXRRenderModelManager, Unit, String>("set_make_local_to_pose")
  }

  public object MethodBindings {
    internal val getTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelManager", "get_tracker", 2456466356)

    internal val setTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelManager", "set_tracker", 2814627380)

    internal val getMakeLocalToPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelManager", "get_make_local_to_pose", 201670096)

    internal val setMakeLocalToPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelManager", "set_make_local_to_pose", 83702148)
  }
}
