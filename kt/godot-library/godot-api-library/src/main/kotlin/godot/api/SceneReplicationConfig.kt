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
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.VariantArray
import godot.core.asCachedNodePath
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_NODE_PATH_BOOL
import godot.writeMethodArguments_NODE_PATH_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

@GodotBaseType
public open class SceneReplicationConfig : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(638, scriptPtr)
  }

  /**
   * Returns a list of synchronized property [NodePath]s.
   */
  public final fun getProperties(): VariantArray<NodePath> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPropertiesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<NodePath>)
  }

  /**
   * Adds the property identified by the given [path] to the list of the properties being
   * synchronized, optionally passing an [index].
   *
   * **Note:** For details on restrictions and limitations on property synchronization, see
   * [MultiplayerSynchronizer].
   */
  @JvmOverloads
  public final fun addProperty(path: NodePath, index: Int = -1): Unit {
    TransferContext.writeMethodArguments_NODE_PATH_LONG(ptr, objectID.id, path, index.toLong())
    TransferContext.callMethod(MethodBindings.addPropertyPtr)
  }

  /**
   * Returns `true` if the given [path] is configured for synchronization.
   */
  public final fun hasProperty(path: NodePath): Boolean {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.hasPropertyPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Removes the property identified by the given [path] from the configuration.
   */
  public final fun removeProperty(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.removePropertyPtr)
  }

  /**
   * Finds the index of the given [path].
   */
  public final fun propertyGetIndex(path: NodePath): Int {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.propertyGetIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the property identified by the given [path] is configured to be synchronized
   * on spawn.
   */
  public final fun propertyGetSpawn(path: NodePath): Boolean {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.propertyGetSpawnPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets whether the property identified by the given [path] is configured to be synchronized on
   * spawn.
   */
  public final fun propertySetSpawn(path: NodePath, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_NODE_PATH_BOOL(ptr, objectID.id, path, enabled)
    TransferContext.callMethod(MethodBindings.propertySetSpawnPtr)
  }

  /**
   * Returns the replication mode for the property identified by the given [path].
   */
  public final fun propertyGetReplicationMode(path: NodePath): ReplicationMode {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.propertyGetReplicationModePtr)
    return ReplicationMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the synchronization mode for the property identified by the given [path].
   */
  public final fun propertySetReplicationMode(path: NodePath, mode: ReplicationMode): Unit {
    TransferContext.writeMethodArguments_NODE_PATH_LONG(ptr, objectID.id, path, mode.value)
    TransferContext.callMethod(MethodBindings.propertySetReplicationModePtr)
  }

  /**
   * Returns `true` if the property identified by the given [path] is configured to be synchronized
   * on process.
   */
  public final fun propertyGetSync(path: NodePath): Boolean {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.propertyGetSyncPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets whether the property identified by the given [path] is configured to be synchronized on
   * process.
   */
  public final fun propertySetSync(path: NodePath, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_NODE_PATH_BOOL(ptr, objectID.id, path, enabled)
    TransferContext.callMethod(MethodBindings.propertySetSyncPtr)
  }

  /**
   * Returns `true` if the property identified by the given [path] is configured to be reliably
   * synchronized when changes are detected on process.
   */
  public final fun propertyGetWatch(path: NodePath): Boolean {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.propertyGetWatchPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets whether the property identified by the given [path] is configured to be reliably
   * synchronized when changes are detected on process.
   */
  public final fun propertySetWatch(path: NodePath, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_NODE_PATH_BOOL(ptr, objectID.id, path, enabled)
    TransferContext.callMethod(MethodBindings.propertySetWatchPtr)
  }

  /**
   * Adds the property identified by the given [path] to the list of the properties being
   * synchronized, optionally passing an [index].
   *
   * **Note:** For details on restrictions and limitations on property synchronization, see
   * [MultiplayerSynchronizer].
   */
  @JvmOverloads
  public final fun addProperty(path: String, index: Int = -1) =
      addProperty(path.asCachedNodePath(), index)

  /**
   * Returns `true` if the given [path] is configured for synchronization.
   */
  public final fun hasProperty(path: String): Boolean = hasProperty(path.asCachedNodePath())

  /**
   * Removes the property identified by the given [path] from the configuration.
   */
  public final fun removeProperty(path: String) = removeProperty(path.asCachedNodePath())

  /**
   * Finds the index of the given [path].
   */
  public final fun propertyGetIndex(path: String): Int = propertyGetIndex(path.asCachedNodePath())

  /**
   * Returns `true` if the property identified by the given [path] is configured to be synchronized
   * on spawn.
   */
  public final fun propertyGetSpawn(path: String): Boolean =
      propertyGetSpawn(path.asCachedNodePath())

  /**
   * Sets whether the property identified by the given [path] is configured to be synchronized on
   * spawn.
   */
  public final fun propertySetSpawn(path: String, enabled: Boolean) =
      propertySetSpawn(path.asCachedNodePath(), enabled)

  /**
   * Returns the replication mode for the property identified by the given [path].
   */
  public final fun propertyGetReplicationMode(path: String): ReplicationMode =
      propertyGetReplicationMode(path.asCachedNodePath())

  /**
   * Sets the synchronization mode for the property identified by the given [path].
   */
  public final fun propertySetReplicationMode(path: String, mode: ReplicationMode) =
      propertySetReplicationMode(path.asCachedNodePath(), mode)

  /**
   * Returns `true` if the property identified by the given [path] is configured to be synchronized
   * on process.
   */
  public final fun propertyGetSync(path: String): Boolean = propertyGetSync(path.asCachedNodePath())

  /**
   * Sets whether the property identified by the given [path] is configured to be synchronized on
   * process.
   */
  public final fun propertySetSync(path: String, enabled: Boolean) =
      propertySetSync(path.asCachedNodePath(), enabled)

  /**
   * Returns `true` if the property identified by the given [path] is configured to be reliably
   * synchronized when changes are detected on process.
   */
  public final fun propertyGetWatch(path: String): Boolean =
      propertyGetWatch(path.asCachedNodePath())

  /**
   * Sets whether the property identified by the given [path] is configured to be reliably
   * synchronized when changes are detected on process.
   */
  public final fun propertySetWatch(path: String, enabled: Boolean) =
      propertySetWatch(path.asCachedNodePath(), enabled)

  public enum class ReplicationMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not keep the given property synchronized.
     */
    NEVER(0),
    /**
     * Replicate the given property on process by constantly sending updates using unreliable
     * transfer mode.
     */
    ALWAYS(1),
    /**
     * Replicate the given property on process by sending updates using reliable transfer mode when
     * its value changes.
     */
    ON_CHANGE(2),
    ;

    public companion object {
      public fun from(`value`: Long): ReplicationMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getPropertiesName: MethodStringName0<SceneReplicationConfig, VariantArray<NodePath>>
        = MethodStringName0<SceneReplicationConfig, VariantArray<NodePath>>("get_properties")

    @JvmField
    public val addPropertyName: MethodStringName2<SceneReplicationConfig, Unit, NodePath, Int> =
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Int>("add_property")

    @JvmField
    public val hasPropertyName: MethodStringName1<SceneReplicationConfig, Boolean, NodePath> =
        MethodStringName1<SceneReplicationConfig, Boolean, NodePath>("has_property")

    @JvmField
    public val removePropertyName: MethodStringName1<SceneReplicationConfig, Unit, NodePath> =
        MethodStringName1<SceneReplicationConfig, Unit, NodePath>("remove_property")

    @JvmField
    public val propertyGetIndexName: MethodStringName1<SceneReplicationConfig, Int, NodePath> =
        MethodStringName1<SceneReplicationConfig, Int, NodePath>("property_get_index")

    @JvmField
    public val propertyGetSpawnName: MethodStringName1<SceneReplicationConfig, Boolean, NodePath> =
        MethodStringName1<SceneReplicationConfig, Boolean, NodePath>("property_get_spawn")

    @JvmField
    public val propertySetSpawnName:
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Boolean> =
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Boolean>("property_set_spawn")

    @JvmField
    public val propertyGetReplicationModeName:
        MethodStringName1<SceneReplicationConfig, ReplicationMode, NodePath> =
        MethodStringName1<SceneReplicationConfig, ReplicationMode, NodePath>("property_get_replication_mode")

    @JvmField
    public val propertySetReplicationModeName:
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, ReplicationMode> =
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, ReplicationMode>("property_set_replication_mode")

    @JvmField
    public val propertyGetSyncName: MethodStringName1<SceneReplicationConfig, Boolean, NodePath> =
        MethodStringName1<SceneReplicationConfig, Boolean, NodePath>("property_get_sync")

    @JvmField
    public val propertySetSyncName:
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Boolean> =
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Boolean>("property_set_sync")

    @JvmField
    public val propertyGetWatchName: MethodStringName1<SceneReplicationConfig, Boolean, NodePath> =
        MethodStringName1<SceneReplicationConfig, Boolean, NodePath>("property_get_watch")

    @JvmField
    public val propertySetWatchName:
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Boolean> =
        MethodStringName2<SceneReplicationConfig, Unit, NodePath, Boolean>("property_set_watch")
  }

  public object MethodBindings {
    internal val getPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "get_properties", 3995934104)

    internal val addPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "add_property", 4094619021)

    internal val hasPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "has_property", 861721659)

    internal val removePropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "remove_property", 1348162250)

    internal val propertyGetIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_get_index", 1382022557)

    internal val propertyGetSpawnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_get_spawn", 3456846888)

    internal val propertySetSpawnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_set_spawn", 3868023870)

    internal val propertyGetReplicationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_get_replication_mode", 2870606336)

    internal val propertySetReplicationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_set_replication_mode", 3200083865)

    internal val propertyGetSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_get_sync", 3456846888)

    internal val propertySetSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_set_sync", 3868023870)

    internal val propertyGetWatchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_get_watch", 3456846888)

    internal val propertySetWatchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneReplicationConfig", "property_set_watch", 3868023870)
  }
}
