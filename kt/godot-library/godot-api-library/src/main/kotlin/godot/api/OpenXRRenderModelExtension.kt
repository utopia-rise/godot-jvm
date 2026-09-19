// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_RID_LONG_ret_STRING
import godot.callMethod_RID_ret_STRING
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_LONG_ret_RID
import godot.callPtrMethod_RID
import godot.callPtrMethod_RID_LONG_ret_BOOL
import godot.callPtrMethod_RID_LONG_ret_TRANSFORM3D
import godot.callPtrMethod_RID_ret_LONG
import godot.callPtrMethod_RID_ret_OBJECT
import godot.callPtrMethod_RID_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_RID_ret_TRANSFORM3D
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedStringArray
import godot.core.RID
import godot.core.Signal1
import godot.core.Transform3D
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This class implements the OpenXR Render Model Extension, if enabled it will maintain a list of
 * active render models and provides an interface to the render model data.
 */
@GodotBaseType
public open class OpenXRRenderModelExtension : OpenXRExtensionWrapper() {
  /**
   * Emitted when a new render model is added.
   */
  public val renderModelAdded: Signal1<RID> by Signal1

  /**
   * Emitted when a render model is removed.
   */
  public val renderModelRemoved: Signal1<RID> by Signal1

  /**
   * Emitted when the top level path associated with a render model changed.
   */
  public val renderModelTopLevelPathChanged: Signal1<RID> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(466, scriptPtr)
  }

  /**
   * Returns `true` if OpenXR's render model extension is supported and enabled.
   *
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public final fun isActive(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isActivePtr)

  /**
   * Creates a render model object within OpenXR using a render model id.
   *
   * **Note:** This function is exposed for dependent OpenXR extensions that provide render model
   * ids to be used with the render model extension.
   */
  public final fun renderModelCreate(renderModelId: Long): RID =
      TransferContext.callPtrMethod_LONG_ret_RID(ptr, objectID.id, MethodBindings.renderModelCreatePtr, renderModelId)

  /**
   * Destroys a render model object within OpenXR that was previously created with
   * [renderModelCreate].
   *
   * **Note:** This function is exposed for dependent OpenXR extensions that provide render model
   * ids to be used with the render model extension.
   */
  public final fun renderModelDestroy(renderModel: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.renderModelDestroyPtr, renderModel)
  }

  /**
   * Returns an array of all currently active render models registered with this extension.
   */
  public final fun renderModelGetAll(): VariantArray<RID> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.renderModelGetAllPtr) as VariantArray<RID>)

  /**
   * Returns an instance of a subscene that contains all [MeshInstance3D] nodes that allow you to
   * visualize the render model.
   */
  public final fun renderModelNewSceneInstance(renderModel: RID): Node3D? =
      (TransferContext.callPtrMethod_RID_ret_OBJECT(ptr, objectID.id, MethodBindings.renderModelNewSceneInstancePtr, renderModel) as Node3D?)

  /**
   * Returns a list of active subaction paths for this [renderModel].
   *
   * **Note:** If different devices are bound to your actions than available in suggested
   * interaction bindings, this information shows paths related to the interaction bindings being
   * mimicked by that device.
   */
  public final fun renderModelGetSubactionPaths(renderModel: RID): PackedStringArray =
      TransferContext.callPtrMethod_RID_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.renderModelGetSubactionPathsPtr, renderModel)

  /**
   * Returns the top level path associated with this [renderModel]. If provided this identifies
   * whether the render model is associated with the player's hands or other body part.
   */
  public final fun renderModelGetTopLevelPath(renderModel: RID): String =
      TransferContext.callMethod_RID_ret_STRING(ptr, objectID.id, MethodBindings.renderModelGetTopLevelPathPtr, renderModel)

  /**
   * Returns the tracking confidence of the tracking data for the render model.
   */
  public final fun renderModelGetConfidence(renderModel: RID): XRPose.TrackingConfidence =
      XRPose.TrackingConfidence.from(TransferContext.callPtrMethod_RID_ret_LONG(ptr, objectID.id, MethodBindings.renderModelGetConfidencePtr, renderModel))

  /**
   * Returns the root transform of a render model. This is the tracked position relative to our
   * [XROrigin3D] node.
   */
  public final fun renderModelGetRootTransform(renderModel: RID): Transform3D =
      TransferContext.callPtrMethod_RID_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.renderModelGetRootTransformPtr, renderModel)

  /**
   * Returns the number of animatable nodes this render model has.
   */
  public final fun renderModelGetAnimatableNodeCount(renderModel: RID): Long =
      TransferContext.callPtrMethod_RID_ret_LONG(ptr, objectID.id, MethodBindings.renderModelGetAnimatableNodeCountPtr, renderModel)

  /**
   * Returns the name of the given animatable node.
   */
  public final fun renderModelGetAnimatableNodeName(renderModel: RID, index: Long): String =
      TransferContext.callMethod_RID_LONG_ret_STRING(ptr, objectID.id, MethodBindings.renderModelGetAnimatableNodeNamePtr, renderModel, index)

  /**
   * Returns `true` if this animatable node should be visible.
   */
  public final fun renderModelIsAnimatableNodeVisible(renderModel: RID, index: Long): Boolean =
      TransferContext.callPtrMethod_RID_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.renderModelIsAnimatableNodeVisiblePtr, renderModel, index)

  /**
   * Returns the current local transform for an animatable node. This is updated every frame.
   */
  public final fun renderModelGetAnimatableNodeTransform(renderModel: RID, index: Long): Transform3D
      =
      TransferContext.callPtrMethod_RID_LONG_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.renderModelGetAnimatableNodeTransformPtr, renderModel, index)

  public companion object {
    @JvmField
    public val isActiveName: MethodStringName0<OpenXRRenderModelExtension, Boolean> =
        MethodStringName0<OpenXRRenderModelExtension, Boolean>("is_active")

    @JvmField
    public val renderModelCreateName: MethodStringName1<OpenXRRenderModelExtension, RID, Long> =
        MethodStringName1<OpenXRRenderModelExtension, RID, Long>("render_model_create")

    @JvmField
    public val renderModelDestroyName: MethodStringName1<OpenXRRenderModelExtension, Unit, RID> =
        MethodStringName1<OpenXRRenderModelExtension, Unit, RID>("render_model_destroy")

    @JvmField
    public val renderModelGetAllName:
        MethodStringName0<OpenXRRenderModelExtension, VariantArray<RID>> =
        MethodStringName0<OpenXRRenderModelExtension, VariantArray<RID>>("render_model_get_all")

    @JvmField
    public val renderModelNewSceneInstanceName:
        MethodStringName1<OpenXRRenderModelExtension, Node3D?, RID> =
        MethodStringName1<OpenXRRenderModelExtension, Node3D?, RID>("render_model_new_scene_instance")

    @JvmField
    public val renderModelGetSubactionPathsName:
        MethodStringName1<OpenXRRenderModelExtension, PackedStringArray, RID> =
        MethodStringName1<OpenXRRenderModelExtension, PackedStringArray, RID>("render_model_get_subaction_paths")

    @JvmField
    public val renderModelGetTopLevelPathName:
        MethodStringName1<OpenXRRenderModelExtension, String, RID> =
        MethodStringName1<OpenXRRenderModelExtension, String, RID>("render_model_get_top_level_path")

    @JvmField
    public val renderModelGetConfidenceName:
        MethodStringName1<OpenXRRenderModelExtension, XRPose.TrackingConfidence, RID> =
        MethodStringName1<OpenXRRenderModelExtension, XRPose.TrackingConfidence, RID>("render_model_get_confidence")

    @JvmField
    public val renderModelGetRootTransformName:
        MethodStringName1<OpenXRRenderModelExtension, Transform3D, RID> =
        MethodStringName1<OpenXRRenderModelExtension, Transform3D, RID>("render_model_get_root_transform")

    @JvmField
    public val renderModelGetAnimatableNodeCountName:
        MethodStringName1<OpenXRRenderModelExtension, Long, RID> =
        MethodStringName1<OpenXRRenderModelExtension, Long, RID>("render_model_get_animatable_node_count")

    @JvmField
    public val renderModelGetAnimatableNodeNameName:
        MethodStringName2<OpenXRRenderModelExtension, String, RID, Long> =
        MethodStringName2<OpenXRRenderModelExtension, String, RID, Long>("render_model_get_animatable_node_name")

    @JvmField
    public val renderModelIsAnimatableNodeVisibleName:
        MethodStringName2<OpenXRRenderModelExtension, Boolean, RID, Long> =
        MethodStringName2<OpenXRRenderModelExtension, Boolean, RID, Long>("render_model_is_animatable_node_visible")

    @JvmField
    public val renderModelGetAnimatableNodeTransformName:
        MethodStringName2<OpenXRRenderModelExtension, Transform3D, RID, Long> =
        MethodStringName2<OpenXRRenderModelExtension, Transform3D, RID, Long>("render_model_get_animatable_node_transform")
  }

  public object MethodBindings {
    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "is_active", 36873697)

    internal val renderModelCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_create", 937000113)

    internal val renderModelDestroyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_destroy", 2722037293)

    internal val renderModelGetAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_all", 2915620761)

    internal val renderModelNewSceneInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_new_scene_instance", 788010739)

    internal val renderModelGetSubactionPathsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_subaction_paths", 2801473409)

    internal val renderModelGetTopLevelPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_top_level_path", 642473191)

    internal val renderModelGetConfidencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_confidence", 2350330949)

    internal val renderModelGetRootTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_root_transform", 1128465797)

    internal val renderModelGetAnimatableNodeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_animatable_node_count", 2198884583)

    internal val renderModelGetAnimatableNodeNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_animatable_node_name", 1464764419)

    internal val renderModelIsAnimatableNodeVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_is_animatable_node_visible", 3120086654)

    internal val renderModelGetAnimatableNodeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModelExtension", "render_model_get_animatable_node_transform", 1050775521)
  }
}
