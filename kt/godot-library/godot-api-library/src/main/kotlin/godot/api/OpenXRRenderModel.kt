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
import godot.core.RID
import godot.core.Signal0
import godot.core.VariantParser.STRING
import godot.core.VariantParser._RID
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node will display an OpenXR render model by accessing the associated GLTF and processes all
 * animation data (if supported by the XR runtime).
 *
 * Render models were introduced to allow showing the correct model for the controller (or other
 * device) the user has in hand, since the OpenXR action map does not provide information about the
 * hardware used by the user. Note that while the controller (or device) can be somewhat inferred by
 * the bound action map profile, this is a dangerous approach as the user may be using hardware not
 * known at time of development and OpenXR will simply simulate an available interaction profile.
 */
@GodotBaseType
public open class OpenXRRenderModel : Node3D() {
  /**
   * Emitted when the top level path of this render model has changed.
   */
  public val renderModelTopLevelPathChanged: Signal0 by Signal0

  /**
   * The render model RID for the render model to load, as returned by
   * [OpenXRRenderModelExtension.renderModelCreate] or [OpenXRRenderModelExtension.renderModelGetAll].
   */
  public final inline var renderModel: RID
    @JvmName("renderModelProperty")
    get() = getRenderModel()
    @JvmName("renderModelProperty")
    set(`value`) {
      setRenderModel(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(465, scriptPtr)
  }

  /**
   * Returns the top level path related to this render model.
   */
  public final fun getTopLevelPath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTopLevelPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun getRenderModel(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderModelPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setRenderModel(renderModel: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to renderModel)
    TransferContext.callMethod(MethodBindings.setRenderModelPtr)
  }

  public companion object {
    @JvmField
    public val getTopLevelPathName: MethodStringName0<OpenXRRenderModel, String> =
        MethodStringName0<OpenXRRenderModel, String>("get_top_level_path")

    @JvmField
    public val getRenderModelName: MethodStringName0<OpenXRRenderModel, RID> =
        MethodStringName0<OpenXRRenderModel, RID>("get_render_model")

    @JvmField
    public val setRenderModelName: MethodStringName1<OpenXRRenderModel, Unit, RID> =
        MethodStringName1<OpenXRRenderModel, Unit, RID>("set_render_model")
  }

  public object MethodBindings {
    internal val getTopLevelPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModel", "get_top_level_path", 201670096)

    internal val getRenderModelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModel", "get_render_model", 2944877500)

    internal val setRenderModelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRRenderModel", "set_render_model", 2722037293)
  }
}
