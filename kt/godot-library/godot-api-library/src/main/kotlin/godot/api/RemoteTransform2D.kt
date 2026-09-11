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
import godot.core.NodePath
import godot.core.Transform2D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.NODE_PATH
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * RemoteTransform2D pushes its own [Transform2D] to another [Node2D] derived node (called the
 * remote node) in the scene.
 *
 * It can be set to update another node's position, rotation and/or scale. It can use either global
 * or local coordinates.
 */
@GodotBaseType
public open class RemoteTransform2D : Node2D() {
  /**
   * The [NodePath] to the remote node, relative to the RemoteTransform2D's position in the scene.
   */
  public final inline var remotePath: NodePath
    @JvmName("remotePathProperty")
    get() = getRemoteNode()
    @JvmName("remotePathProperty")
    set(`value`) {
      setRemoteNode(value)
    }

  /**
   * If `true`, global coordinates are used. If `false`, local coordinates are used.
   */
  public final inline var useGlobalCoordinates: Boolean
    @JvmName("useGlobalCoordinatesProperty")
    get() = getUseGlobalCoordinates()
    @JvmName("useGlobalCoordinatesProperty")
    set(`value`) {
      setUseGlobalCoordinates(value)
    }

  /**
   * If `true`, the remote node's position is updated.
   */
  public final inline var updatePosition: Boolean
    @JvmName("updatePositionProperty")
    get() = getUpdatePosition()
    @JvmName("updatePositionProperty")
    set(`value`) {
      setUpdatePosition(value)
    }

  /**
   * If `true`, the remote node's rotation is updated.
   */
  public final inline var updateRotation: Boolean
    @JvmName("updateRotationProperty")
    get() = getUpdateRotation()
    @JvmName("updateRotationProperty")
    set(`value`) {
      setUpdateRotation(value)
    }

  /**
   * If `true`, the remote node's scale is updated.
   */
  public final inline var updateScale: Boolean
    @JvmName("updateScaleProperty")
    get() = getUpdateScale()
    @JvmName("updateScaleProperty")
    set(`value`) {
      setUpdateScale(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(607, scriptPtr)
  }

  public final fun setRemoteNode(path: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to path)
    TransferContext.callMethod(MethodBindings.setRemoteNodePtr)
  }

  public final fun getRemoteNode(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRemoteNodePtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * [RemoteTransform2D] caches the remote node. It may not notice if the remote node disappears;
   * [forceUpdateCache] forces it to update the cache again.
   */
  public final fun forceUpdateCache(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceUpdateCachePtr)
  }

  public final fun setUseGlobalCoordinates(useGlobalCoordinates: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useGlobalCoordinates)
    TransferContext.callMethod(MethodBindings.setUseGlobalCoordinatesPtr)
  }

  public final fun getUseGlobalCoordinates(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseGlobalCoordinatesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUpdatePosition(updateRemotePosition: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to updateRemotePosition)
    TransferContext.callMethod(MethodBindings.setUpdatePositionPtr)
  }

  public final fun getUpdatePosition(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpdatePositionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUpdateRotation(updateRemoteRotation: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to updateRemoteRotation)
    TransferContext.callMethod(MethodBindings.setUpdateRotationPtr)
  }

  public final fun getUpdateRotation(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpdateRotationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUpdateScale(updateRemoteScale: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to updateRemoteScale)
    TransferContext.callMethod(MethodBindings.setUpdateScalePtr)
  }

  public final fun getUpdateScale(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpdateScalePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRemoteNode(path: String) = setRemoteNode(path.asCachedNodePath())

  public companion object {
    @JvmField
    public val setRemoteNodeName: MethodStringName1<RemoteTransform2D, Unit, NodePath> =
        MethodStringName1<RemoteTransform2D, Unit, NodePath>("set_remote_node")

    @JvmField
    public val getRemoteNodeName: MethodStringName0<RemoteTransform2D, NodePath> =
        MethodStringName0<RemoteTransform2D, NodePath>("get_remote_node")

    @JvmField
    public val forceUpdateCacheName: MethodStringName0<RemoteTransform2D, Unit> =
        MethodStringName0<RemoteTransform2D, Unit>("force_update_cache")

    @JvmField
    public val setUseGlobalCoordinatesName: MethodStringName1<RemoteTransform2D, Unit, Boolean> =
        MethodStringName1<RemoteTransform2D, Unit, Boolean>("set_use_global_coordinates")

    @JvmField
    public val getUseGlobalCoordinatesName: MethodStringName0<RemoteTransform2D, Boolean> =
        MethodStringName0<RemoteTransform2D, Boolean>("get_use_global_coordinates")

    @JvmField
    public val setUpdatePositionName: MethodStringName1<RemoteTransform2D, Unit, Boolean> =
        MethodStringName1<RemoteTransform2D, Unit, Boolean>("set_update_position")

    @JvmField
    public val getUpdatePositionName: MethodStringName0<RemoteTransform2D, Boolean> =
        MethodStringName0<RemoteTransform2D, Boolean>("get_update_position")

    @JvmField
    public val setUpdateRotationName: MethodStringName1<RemoteTransform2D, Unit, Boolean> =
        MethodStringName1<RemoteTransform2D, Unit, Boolean>("set_update_rotation")

    @JvmField
    public val getUpdateRotationName: MethodStringName0<RemoteTransform2D, Boolean> =
        MethodStringName0<RemoteTransform2D, Boolean>("get_update_rotation")

    @JvmField
    public val setUpdateScaleName: MethodStringName1<RemoteTransform2D, Unit, Boolean> =
        MethodStringName1<RemoteTransform2D, Unit, Boolean>("set_update_scale")

    @JvmField
    public val getUpdateScaleName: MethodStringName0<RemoteTransform2D, Boolean> =
        MethodStringName0<RemoteTransform2D, Boolean>("get_update_scale")
  }

  public object MethodBindings {
    internal val setRemoteNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "set_remote_node", 1348162250)

    internal val getRemoteNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "get_remote_node", 4075236667)

    internal val forceUpdateCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "force_update_cache", 3218959716)

    internal val setUseGlobalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "set_use_global_coordinates", 2586408642)

    internal val getUseGlobalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "get_use_global_coordinates", 36873697)

    internal val setUpdatePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "set_update_position", 2586408642)

    internal val getUpdatePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "get_update_position", 36873697)

    internal val setUpdateRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "set_update_rotation", 2586408642)

    internal val getUpdateRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "get_update_rotation", 36873697)

    internal val setUpdateScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "set_update_scale", 2586408642)

    internal val getUpdateScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RemoteTransform2D", "get_update_scale", 36873697)
  }
}
