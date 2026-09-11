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
import godot.core.Callable
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * By default, [MultiplayerSynchronizer] synchronizes configured properties to all peers.
 *
 * Visibility can be handled directly with [setVisibilityFor] or as-needed with
 * [addVisibilityFilter] and [updateVisibility].
 *
 * [MultiplayerSpawner]s will handle nodes according to visibility of synchronizers as long as the
 * node at [rootPath] was spawned by one.
 *
 * Internally, [MultiplayerSynchronizer] uses [MultiplayerAPI.objectConfigurationAdd] to notify
 * synchronization start passing the [Node] at [rootPath] as the `object` and itself as the
 * `configuration`, and uses [MultiplayerAPI.objectConfigurationRemove] to notify synchronization end
 * in a similar way.
 *
 * **Note:** Synchronization is not supported for [Object] type properties, like [Resource].
 * Properties that are unique to each peer, like the instance IDs of [Object]s (see
 * [Object.getInstanceId]) or [RID]s, will also not work in synchronization.
 */
@GodotBaseType
public open class MultiplayerSynchronizer : Node() {
  /**
   * Emitted when a new synchronization state is received by this synchronizer after the properties
   * have been updated.
   */
  public val synchronized: Signal0 by Signal0

  /**
   * Emitted when a new delta synchronization state is received by this synchronizer after the
   * properties have been updated.
   */
  public val deltaSynchronized: Signal0 by Signal0

  /**
   * Emitted when visibility of [forPeer] is updated. See [updateVisibility].
   */
  public val visibilityChanged: Signal1<Long> by Signal1

  /**
   * Node path that replicated properties are relative to.
   *
   * If [rootPath] was spawned by a [MultiplayerSpawner], the node will be also be spawned and
   * despawned based on this synchronizer visibility options.
   */
  public final inline var rootPath: NodePath
    @JvmName("rootPathProperty")
    get() = getRootPath()
    @JvmName("rootPathProperty")
    set(`value`) {
      setRootPath(value)
    }

  /**
   * Time interval between synchronizations. Used when the replication is set to
   * [SceneReplicationConfig.REPLICATION_MODE_ALWAYS]. If set to `0.0` (the default), synchronizations
   * happen every network process frame.
   */
  public final inline var replicationInterval: Double
    @JvmName("replicationIntervalProperty")
    get() = getReplicationInterval()
    @JvmName("replicationIntervalProperty")
    set(`value`) {
      setReplicationInterval(value)
    }

  /**
   * Time interval between delta synchronizations. Used when the replication is set to
   * [SceneReplicationConfig.REPLICATION_MODE_ON_CHANGE]. If set to `0.0` (the default), delta
   * synchronizations happen every network process frame.
   */
  public final inline var deltaInterval: Double
    @JvmName("deltaIntervalProperty")
    get() = getDeltaInterval()
    @JvmName("deltaIntervalProperty")
    set(`value`) {
      setDeltaInterval(value)
    }

  /**
   * Resource containing which properties to synchronize.
   */
  public final inline var replicationConfig: SceneReplicationConfig?
    @JvmName("replicationConfigProperty")
    get() = getReplicationConfig()
    @JvmName("replicationConfigProperty")
    set(`value`) {
      setReplicationConfig(value)
    }

  /**
   * Specifies when visibility filters are updated.
   */
  public final inline var visibilityUpdateMode: VisibilityUpdateMode
    @JvmName("visibilityUpdateModeProperty")
    get() = getVisibilityUpdateMode()
    @JvmName("visibilityUpdateModeProperty")
    set(`value`) {
      setVisibilityUpdateMode(value)
    }

  /**
   * Whether synchronization should be visible to all peers by default. See [setVisibilityFor] and
   * [addVisibilityFilter] for ways of configuring fine-grained visibility options.
   */
  public final inline var publicVisibility: Boolean
    @JvmName("publicVisibilityProperty")
    get() = isVisibilityPublic()
    @JvmName("publicVisibilityProperty")
    set(`value`) {
      setVisibilityPublic(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(396, scriptPtr)
  }

  public final fun setRootPath(path: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to path)
    TransferContext.callMethod(MethodBindings.setRootPathPtr)
  }

  public final fun getRootPath(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootPathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setReplicationInterval(milliseconds: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to milliseconds)
    TransferContext.callMethod(MethodBindings.setReplicationIntervalPtr)
  }

  public final fun getReplicationInterval(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReplicationIntervalPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setDeltaInterval(milliseconds: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to milliseconds)
    TransferContext.callMethod(MethodBindings.setDeltaIntervalPtr)
  }

  public final fun getDeltaInterval(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeltaIntervalPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setReplicationConfig(config: SceneReplicationConfig?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to config)
    TransferContext.callMethod(MethodBindings.setReplicationConfigPtr)
  }

  public final fun getReplicationConfig(): SceneReplicationConfig? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReplicationConfigPtr)
    return (TransferContext.readReturnValue(OBJECT) as SceneReplicationConfig?)
  }

  public final fun setVisibilityUpdateMode(mode: VisibilityUpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVisibilityUpdateModePtr)
  }

  public final fun getVisibilityUpdateMode(): VisibilityUpdateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityUpdateModePtr)
    return VisibilityUpdateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Updates the visibility of [forPeer] according to visibility filters. If [forPeer] is `0` (the
   * default), all peers' visibilties are updated.
   */
  @JvmOverloads
  public final fun updateVisibility(forPeer: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to forPeer.toLong())
    TransferContext.callMethod(MethodBindings.updateVisibilityPtr)
  }

  public final fun setVisibilityPublic(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setVisibilityPublicPtr)
  }

  public final fun isVisibilityPublic(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVisibilityPublicPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a peer visibility filter for this synchronizer.
   *
   * [filter] should take a peer ID [Long] and return a [Boolean].
   */
  public final fun addVisibilityFilter(filter: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to filter)
    TransferContext.callMethod(MethodBindings.addVisibilityFilterPtr)
  }

  /**
   * Removes a peer visibility filter from this synchronizer.
   */
  public final fun removeVisibilityFilter(filter: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to filter)
    TransferContext.callMethod(MethodBindings.removeVisibilityFilterPtr)
  }

  /**
   * Sets the visibility of [peer] to [visible]. If [peer] is `0`, the value of [publicVisibility]
   * will be updated instead.
   */
  public final fun setVisibilityFor(peer: Int, visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peer.toLong(), BOOL to visible)
    TransferContext.callMethod(MethodBindings.setVisibilityForPtr)
  }

  /**
   * Queries the current visibility for peer [peer].
   */
  public final fun getVisibilityFor(peer: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peer.toLong())
    TransferContext.callMethod(MethodBindings.getVisibilityForPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRootPath(path: String) = setRootPath(path.asCachedNodePath())

  public enum class VisibilityUpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Visibility filters are updated during process frames (see
     * [Node.NOTIFICATION_INTERNAL_PROCESS]).
     */
    PROCESS_IDLE(0),
    /**
     * Visibility filters are updated during physics frames (see
     * [Node.NOTIFICATION_INTERNAL_PHYSICS_PROCESS]).
     */
    PROCESS_PHYSICS(1),
    /**
     * Visibility filters are not updated automatically, and must be updated manually by calling
     * [updateVisibility].
     */
    PROCESS_NONE(2),
    ;

    public companion object {
      public fun from(`value`: Long): VisibilityUpdateMode =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setRootPathName: MethodStringName1<MultiplayerSynchronizer, Unit, NodePath> =
        MethodStringName1<MultiplayerSynchronizer, Unit, NodePath>("set_root_path")

    @JvmField
    public val getRootPathName: MethodStringName0<MultiplayerSynchronizer, NodePath> =
        MethodStringName0<MultiplayerSynchronizer, NodePath>("get_root_path")

    @JvmField
    public val setReplicationIntervalName: MethodStringName1<MultiplayerSynchronizer, Unit, Double>
        = MethodStringName1<MultiplayerSynchronizer, Unit, Double>("set_replication_interval")

    @JvmField
    public val getReplicationIntervalName: MethodStringName0<MultiplayerSynchronizer, Double> =
        MethodStringName0<MultiplayerSynchronizer, Double>("get_replication_interval")

    @JvmField
    public val setDeltaIntervalName: MethodStringName1<MultiplayerSynchronizer, Unit, Double> =
        MethodStringName1<MultiplayerSynchronizer, Unit, Double>("set_delta_interval")

    @JvmField
    public val getDeltaIntervalName: MethodStringName0<MultiplayerSynchronizer, Double> =
        MethodStringName0<MultiplayerSynchronizer, Double>("get_delta_interval")

    @JvmField
    public val setReplicationConfigName:
        MethodStringName1<MultiplayerSynchronizer, Unit, SceneReplicationConfig?> =
        MethodStringName1<MultiplayerSynchronizer, Unit, SceneReplicationConfig?>("set_replication_config")

    @JvmField
    public val getReplicationConfigName:
        MethodStringName0<MultiplayerSynchronizer, SceneReplicationConfig?> =
        MethodStringName0<MultiplayerSynchronizer, SceneReplicationConfig?>("get_replication_config")

    @JvmField
    public val setVisibilityUpdateModeName:
        MethodStringName1<MultiplayerSynchronizer, Unit, VisibilityUpdateMode> =
        MethodStringName1<MultiplayerSynchronizer, Unit, VisibilityUpdateMode>("set_visibility_update_mode")

    @JvmField
    public val getVisibilityUpdateModeName:
        MethodStringName0<MultiplayerSynchronizer, VisibilityUpdateMode> =
        MethodStringName0<MultiplayerSynchronizer, VisibilityUpdateMode>("get_visibility_update_mode")

    @JvmField
    public val updateVisibilityName: MethodStringName1<MultiplayerSynchronizer, Unit, Int> =
        MethodStringName1<MultiplayerSynchronizer, Unit, Int>("update_visibility")

    @JvmField
    public val setVisibilityPublicName: MethodStringName1<MultiplayerSynchronizer, Unit, Boolean> =
        MethodStringName1<MultiplayerSynchronizer, Unit, Boolean>("set_visibility_public")

    @JvmField
    public val isVisibilityPublicName: MethodStringName0<MultiplayerSynchronizer, Boolean> =
        MethodStringName0<MultiplayerSynchronizer, Boolean>("is_visibility_public")

    @JvmField
    public val addVisibilityFilterName: MethodStringName1<MultiplayerSynchronizer, Unit, Callable> =
        MethodStringName1<MultiplayerSynchronizer, Unit, Callable>("add_visibility_filter")

    @JvmField
    public val removeVisibilityFilterName:
        MethodStringName1<MultiplayerSynchronizer, Unit, Callable> =
        MethodStringName1<MultiplayerSynchronizer, Unit, Callable>("remove_visibility_filter")

    @JvmField
    public val setVisibilityForName: MethodStringName2<MultiplayerSynchronizer, Unit, Int, Boolean>
        = MethodStringName2<MultiplayerSynchronizer, Unit, Int, Boolean>("set_visibility_for")

    @JvmField
    public val getVisibilityForName: MethodStringName1<MultiplayerSynchronizer, Boolean, Int> =
        MethodStringName1<MultiplayerSynchronizer, Boolean, Int>("get_visibility_for")
  }

  public object MethodBindings {
    internal val setRootPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_root_path", 1348162250)

    internal val getRootPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "get_root_path", 4075236667)

    internal val setReplicationIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_replication_interval", 373806689)

    internal val getReplicationIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "get_replication_interval", 1740695150)

    internal val setDeltaIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_delta_interval", 373806689)

    internal val getDeltaIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "get_delta_interval", 1740695150)

    internal val setReplicationConfigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_replication_config", 3889206742)

    internal val getReplicationConfigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "get_replication_config", 3200254614)

    internal val setVisibilityUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_visibility_update_mode", 3494860300)

    internal val getVisibilityUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "get_visibility_update_mode", 3352241418)

    internal val updateVisibilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "update_visibility", 1995695955)

    internal val setVisibilityPublicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_visibility_public", 2586408642)

    internal val isVisibilityPublicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "is_visibility_public", 36873697)

    internal val addVisibilityFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "add_visibility_filter", 1611583062)

    internal val removeVisibilityFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "remove_visibility_filter", 1611583062)

    internal val setVisibilityForPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "set_visibility_for", 300928843)

    internal val getVisibilityForPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSynchronizer", "get_visibility_for", 1116898809)
  }
}
