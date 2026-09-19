// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_RID
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.RID
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Abstract render data object, exists for the duration of rendering a single viewport. See also
 * [RenderDataRD], [RenderSceneData], and [RenderSceneDataRD].
 *
 * **Note:** This is an internal rendering server object. Do not instantiate this class from a
 * script.
 */
@GodotBaseType
public open class RenderData internal constructor() : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(609, scriptPtr)
  }

  /**
   * Returns the [RenderSceneBuffers] object managing the scene buffers for rendering this viewport.
   */
  public final fun getRenderSceneBuffers(): RenderSceneBuffers? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getRenderSceneBuffersPtr) as RenderSceneBuffers?)

  /**
   * Returns the [RenderSceneData] object managing this frames scene data.
   */
  public final fun getRenderSceneData(): RenderSceneData? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getRenderSceneDataPtr) as RenderSceneData?)

  /**
   * Returns the [RID] of the environment object in the [RenderingServer] being used to render this
   * viewport.
   */
  public final fun getEnvironment(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getEnvironmentPtr)

  /**
   * Returns the [RID] of the camera attributes object in the [RenderingServer] being used to render
   * this viewport.
   */
  public final fun getCameraAttributes(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getCameraAttributesPtr)

  public companion object {
    @JvmField
    public val getRenderSceneBuffersName: MethodStringName0<RenderData, RenderSceneBuffers?> =
        MethodStringName0<RenderData, RenderSceneBuffers?>("get_render_scene_buffers")

    @JvmField
    public val getRenderSceneDataName: MethodStringName0<RenderData, RenderSceneData?> =
        MethodStringName0<RenderData, RenderSceneData?>("get_render_scene_data")

    @JvmField
    public val getEnvironmentName: MethodStringName0<RenderData, RID> =
        MethodStringName0<RenderData, RID>("get_environment")

    @JvmField
    public val getCameraAttributesName: MethodStringName0<RenderData, RID> =
        MethodStringName0<RenderData, RID>("get_camera_attributes")
  }

  public object MethodBindings {
    internal val getRenderSceneBuffersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderData", "get_render_scene_buffers", 2793216201)

    internal val getRenderSceneDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderData", "get_render_scene_data", 1288715698)

    internal val getEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderData", "get_environment", 2944877500)

    internal val getCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderData", "get_camera_attributes", 2944877500)
  }
}
