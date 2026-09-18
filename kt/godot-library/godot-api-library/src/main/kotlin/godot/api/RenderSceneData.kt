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
import godot.core.Projection
import godot.core.RID
import godot.core.Transform3D
import godot.core.Vector3
import godot.readReturnValue_LONG
import godot.readReturnValue_PROJECTION
import godot.readReturnValue_RID
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Abstract scene data object, exists for the duration of rendering a single viewport. See also
 * [RenderSceneDataRD], [RenderData], and [RenderDataRD].
 *
 * **Note:** This is an internal rendering server object. Do not instantiate this class from a
 * script.
 */
@GodotBaseType
public open class RenderSceneData internal constructor() : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(616, scriptPtr)
  }

  /**
   * Returns the camera transform used to render this frame.
   *
   * **Note:** If more than one view is rendered, this will return a centered transform.
   */
  public final fun getCamTransform(): Transform3D {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCamTransformPtr, 18)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Returns the camera projection used to render this frame.
   *
   * **Note:** If more than one view is rendered, this will return a combined projection.
   */
  public final fun getCamProjection(): Projection {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCamProjectionPtr, 19)
    return TransferContext.readReturnValue_PROJECTION()
  }

  /**
   * Returns the number of views being rendered.
   */
  public final fun getViewCount(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getViewCountPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns the eye offset per view used to render this frame. This is the offset between our
   * camera transform and the eye transform.
   */
  public final fun getViewEyeOffset(view: Long): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, view)
    TransferContext.callPtrMethod(MethodBindings.getViewEyeOffsetPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the view projection per view used to render this frame.
   *
   * **Note:** If a single view is rendered, this returns the camera projection. If more than one
   * view is rendered, this will return a projection for the given view including the eye offset.
   */
  public final fun getViewProjection(view: Long): Projection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, view)
    TransferContext.callPtrMethod(MethodBindings.getViewProjectionPtr, 19)
    return TransferContext.readReturnValue_PROJECTION()
  }

  /**
   * Return the [RID] of the uniform buffer containing the scene data as a UBO.
   */
  public final fun getUniformBuffer(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUniformBufferPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public companion object {
    @JvmField
    public val getCamTransformName: MethodStringName0<RenderSceneData, Transform3D> =
        MethodStringName0<RenderSceneData, Transform3D>("get_cam_transform")

    @JvmField
    public val getCamProjectionName: MethodStringName0<RenderSceneData, Projection> =
        MethodStringName0<RenderSceneData, Projection>("get_cam_projection")

    @JvmField
    public val getViewCountName: MethodStringName0<RenderSceneData, Long> =
        MethodStringName0<RenderSceneData, Long>("get_view_count")

    @JvmField
    public val getViewEyeOffsetName: MethodStringName1<RenderSceneData, Vector3, Long> =
        MethodStringName1<RenderSceneData, Vector3, Long>("get_view_eye_offset")

    @JvmField
    public val getViewProjectionName: MethodStringName1<RenderSceneData, Projection, Long> =
        MethodStringName1<RenderSceneData, Projection, Long>("get_view_projection")

    @JvmField
    public val getUniformBufferName: MethodStringName0<RenderSceneData, RID> =
        MethodStringName0<RenderSceneData, RID>("get_uniform_buffer")
  }

  public object MethodBindings {
    internal val getCamTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneData", "get_cam_transform", 3229777777)

    internal val getCamProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneData", "get_cam_projection", 2910717950)

    internal val getViewCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneData", "get_view_count", 3905245786)

    internal val getViewEyeOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneData", "get_view_eye_offset", 711720468)

    internal val getViewProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneData", "get_view_projection", 3179846605)

    internal val getUniformBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneData", "get_uniform_buffer", 2944877500)
  }
}
