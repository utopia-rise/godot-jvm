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
import godot.readReturnValue_BOOL
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The FBXState handles the state data imported from FBX files.
 */
@GodotBaseType
public open class FBXState : GLTFState() {
  /**
   * If `true`, the import process used auxiliary nodes called geometry helper nodes. These nodes
   * help preserve the pivots and transformations of the original 3D model during import.
   */
  public final inline var allowGeometryHelperNodes: Boolean
    @JvmName("allowGeometryHelperNodesProperty")
    get() = getAllowGeometryHelperNodes()
    @JvmName("allowGeometryHelperNodesProperty")
    set(`value`) {
      setAllowGeometryHelperNodes(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(222, scriptPtr)
  }

  public final fun getAllowGeometryHelperNodes(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAllowGeometryHelperNodesPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAllowGeometryHelperNodes(allow: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, allow)
    TransferContext.callPtrMethod(MethodBindings.setAllowGeometryHelperNodesPtr, 0)
  }

  public companion object {
    @JvmField
    public val getAllowGeometryHelperNodesName: MethodStringName0<FBXState, Boolean> =
        MethodStringName0<FBXState, Boolean>("get_allow_geometry_helper_nodes")

    @JvmField
    public val setAllowGeometryHelperNodesName: MethodStringName1<FBXState, Unit, Boolean> =
        MethodStringName1<FBXState, Unit, Boolean>("set_allow_geometry_helper_nodes")
  }

  public object MethodBindings {
    internal val getAllowGeometryHelperNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FBXState", "get_allow_geometry_helper_nodes", 2240911060)

    internal val setAllowGeometryHelperNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FBXState", "set_allow_geometry_helper_nodes", 2586408642)
  }
}
