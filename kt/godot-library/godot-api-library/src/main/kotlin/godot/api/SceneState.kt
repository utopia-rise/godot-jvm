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
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import godot.readReturnValue_ANY
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Maintains a list of resources, nodes, exported and overridden properties, and built-in scripts
 * associated with a scene. They cannot be modified from a [SceneState], only accessed. Useful for
 * peeking into what a [PackedScene] contains without instantiating it.
 *
 * This class cannot be instantiated directly, it is retrieved for a given scene as the result of
 * [PackedScene.getState].
 */
@GodotBaseType
public open class SceneState internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(639, scriptPtr)
  }

  /**
   * Returns the resource path to the represented [PackedScene].
   */
  public final fun getPath(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the [SceneState] of the scene that this scene inherits from, or `null` if it doesn't
   * inherit from any scene.
   */
  public final fun getBaseSceneState(): SceneState? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaseSceneStatePtr)
    return (TransferContext.readReturnValue_OBJECT() as SceneState?)
  }

  /**
   * Returns the number of nodes in the scene.
   *
   * The `idx` argument used to query node data in other `get_node_*` methods in the interval `[0,
   * get_node_count() - 1]`.
   */
  public final fun getNodeCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodeCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the type of the node at [idx].
   */
  public final fun getNodeType(idx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeTypePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the name of the node at [idx].
   */
  public final fun getNodeName(idx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the path to the node at [idx].
   *
   * If [forParent] is `true`, returns the path of the [idx] node's parent instead.
   */
  @JvmOverloads
  public final fun getNodePath(idx: Int, forParent: Boolean = false): NodePath {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, idx.toLong(), forParent)
    TransferContext.callMethod(MethodBindings.getNodePathPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Returns the path to the owner of the node at [idx], relative to the root node.
   */
  public final fun getNodeOwnerPath(idx: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeOwnerPathPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Returns `true` if the node at [idx] is an [InstancePlaceholder].
   */
  public final fun isNodeInstancePlaceholder(idx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.isNodeInstancePlaceholderPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the path to the represented scene file if the node at [idx] is an
   * [InstancePlaceholder].
   */
  public final fun getNodeInstancePlaceholder(idx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeInstancePlaceholderPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns a [PackedScene] for the node at [idx] (i.e. the whole branch starting at this node,
   * with its child nodes and resources), or `null` if the node is not an instance.
   */
  public final fun getNodeInstance(idx: Int): PackedScene? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeInstancePtr)
    return (TransferContext.readReturnValue_OBJECT() as PackedScene?)
  }

  /**
   * Returns the list of group names associated with the node at [idx].
   */
  public final fun getNodeGroups(idx: Int): PackedStringArray {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeGroupsPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns the node's index, which is its position relative to its siblings. This is only relevant
   * and saved in scenes for cases where new nodes are added to an instantiated or inherited scene
   * among siblings from the base scene. Despite the name, this index is not related to the [idx]
   * argument used here and in other methods.
   */
  public final fun getNodeIndex(idx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodeIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the number of exported or overridden properties for the node at [idx].
   *
   * The `prop_idx` argument used to query node property data in other `get_node_property_*` methods
   * in the interval `[0, get_node_property_count() - 1]`.
   */
  public final fun getNodePropertyCount(idx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getNodePropertyCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the name of the property at [propIdx] for the node at [idx].
   */
  public final fun getNodePropertyName(idx: Int, propIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, idx.toLong(), propIdx.toLong())
    TransferContext.callMethod(MethodBindings.getNodePropertyNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the value of the property at [propIdx] for the node at [idx].
   */
  public final fun getNodePropertyValue(idx: Int, propIdx: Int): Any? {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, idx.toLong(), propIdx.toLong())
    TransferContext.callMethod(MethodBindings.getNodePropertyValuePtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns the number of signal connections in the scene.
   *
   * The `idx` argument used to query connection metadata in other `get_connection_*` methods in the
   * interval `[0, get_connection_count() - 1]`.
   */
  public final fun getConnectionCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectionCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the path to the node that owns the signal at [idx], relative to the root node.
   */
  public final fun getConnectionSource(idx: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionSourcePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Returns the name of the signal at [idx].
   */
  public final fun getConnectionSignal(idx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionSignalPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the path to the node that owns the method connected to the signal at [idx], relative to
   * the root node.
   */
  public final fun getConnectionTarget(idx: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionTargetPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Returns the method connected to the signal at [idx].
   */
  public final fun getConnectionMethod(idx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionMethodPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the connection flags for the signal at [idx]. See [Object.ConnectFlags] constants.
   */
  public final fun getConnectionFlags(idx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionFlagsPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the list of bound parameters for the signal at [idx].
   */
  public final fun getConnectionBinds(idx: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionBindsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Returns the number of unbound parameters for the signal at [idx].
   */
  public final fun getConnectionUnbinds(idx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getConnectionUnbindsPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public enum class GenEditState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If passed to [PackedScene.instantiate], blocks edits to the scene state.
     */
    DISABLED(0),
    /**
     * If passed to [PackedScene.instantiate], provides inherited scene resources to the local
     * scene.
     *
     * **Note:** Only available in editor builds.
     */
    INSTANCE(1),
    /**
     * If passed to [PackedScene.instantiate], provides local scene resources to the local scene.
     * Only the main scene should receive the main edit state.
     *
     * **Note:** Only available in editor builds.
     */
    MAIN(2),
    /**
     * If passed to [PackedScene.instantiate], it's similar to [GEN_EDIT_STATE_MAIN], but for the
     * case where the scene is being instantiated to be the base of another one.
     *
     * **Note:** Only available in editor builds.
     */
    MAIN_INHERITED(3),
    ;

    public companion object {
      public fun from(`value`: Long): GenEditState = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getPathName: MethodStringName0<SceneState, String> =
        MethodStringName0<SceneState, String>("get_path")

    @JvmField
    public val getBaseSceneStateName: MethodStringName0<SceneState, SceneState?> =
        MethodStringName0<SceneState, SceneState?>("get_base_scene_state")

    @JvmField
    public val getNodeCountName: MethodStringName0<SceneState, Int> =
        MethodStringName0<SceneState, Int>("get_node_count")

    @JvmField
    public val getNodeTypeName: MethodStringName1<SceneState, StringName, Int> =
        MethodStringName1<SceneState, StringName, Int>("get_node_type")

    @JvmField
    public val getNodeNameName: MethodStringName1<SceneState, StringName, Int> =
        MethodStringName1<SceneState, StringName, Int>("get_node_name")

    @JvmField
    public val getNodePathName: MethodStringName2<SceneState, NodePath, Int, Boolean> =
        MethodStringName2<SceneState, NodePath, Int, Boolean>("get_node_path")

    @JvmField
    public val getNodeOwnerPathName: MethodStringName1<SceneState, NodePath, Int> =
        MethodStringName1<SceneState, NodePath, Int>("get_node_owner_path")

    @JvmField
    public val isNodeInstancePlaceholderName: MethodStringName1<SceneState, Boolean, Int> =
        MethodStringName1<SceneState, Boolean, Int>("is_node_instance_placeholder")

    @JvmField
    public val getNodeInstancePlaceholderName: MethodStringName1<SceneState, String, Int> =
        MethodStringName1<SceneState, String, Int>("get_node_instance_placeholder")

    @JvmField
    public val getNodeInstanceName: MethodStringName1<SceneState, PackedScene?, Int> =
        MethodStringName1<SceneState, PackedScene?, Int>("get_node_instance")

    @JvmField
    public val getNodeGroupsName: MethodStringName1<SceneState, PackedStringArray, Int> =
        MethodStringName1<SceneState, PackedStringArray, Int>("get_node_groups")

    @JvmField
    public val getNodeIndexName: MethodStringName1<SceneState, Int, Int> =
        MethodStringName1<SceneState, Int, Int>("get_node_index")

    @JvmField
    public val getNodePropertyCountName: MethodStringName1<SceneState, Int, Int> =
        MethodStringName1<SceneState, Int, Int>("get_node_property_count")

    @JvmField
    public val getNodePropertyNameName: MethodStringName2<SceneState, StringName, Int, Int> =
        MethodStringName2<SceneState, StringName, Int, Int>("get_node_property_name")

    @JvmField
    public val getNodePropertyValueName: MethodStringName2<SceneState, Any?, Int, Int> =
        MethodStringName2<SceneState, Any?, Int, Int>("get_node_property_value")

    @JvmField
    public val getConnectionCountName: MethodStringName0<SceneState, Int> =
        MethodStringName0<SceneState, Int>("get_connection_count")

    @JvmField
    public val getConnectionSourceName: MethodStringName1<SceneState, NodePath, Int> =
        MethodStringName1<SceneState, NodePath, Int>("get_connection_source")

    @JvmField
    public val getConnectionSignalName: MethodStringName1<SceneState, StringName, Int> =
        MethodStringName1<SceneState, StringName, Int>("get_connection_signal")

    @JvmField
    public val getConnectionTargetName: MethodStringName1<SceneState, NodePath, Int> =
        MethodStringName1<SceneState, NodePath, Int>("get_connection_target")

    @JvmField
    public val getConnectionMethodName: MethodStringName1<SceneState, StringName, Int> =
        MethodStringName1<SceneState, StringName, Int>("get_connection_method")

    @JvmField
    public val getConnectionFlagsName: MethodStringName1<SceneState, Int, Int> =
        MethodStringName1<SceneState, Int, Int>("get_connection_flags")

    @JvmField
    public val getConnectionBindsName: MethodStringName1<SceneState, VariantArray<Any?>, Int> =
        MethodStringName1<SceneState, VariantArray<Any?>, Int>("get_connection_binds")

    @JvmField
    public val getConnectionUnbindsName: MethodStringName1<SceneState, Int, Int> =
        MethodStringName1<SceneState, Int, Int>("get_connection_unbinds")
  }

  public object MethodBindings {
    internal val getPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_path", 201670096)

    internal val getBaseSceneStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_base_scene_state", 3479783971)

    internal val getNodeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_count", 3905245786)

    internal val getNodeTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_type", 659327637)

    internal val getNodeNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_name", 659327637)

    internal val getNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_path", 2272487792)

    internal val getNodeOwnerPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_owner_path", 408788394)

    internal val isNodeInstancePlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "is_node_instance_placeholder", 1116898809)

    internal val getNodeInstancePlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_instance_placeholder", 844755477)

    internal val getNodeInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_instance", 511017218)

    internal val getNodeGroupsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_groups", 647634434)

    internal val getNodeIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_index", 923996154)

    internal val getNodePropertyCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_property_count", 923996154)

    internal val getNodePropertyNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_property_name", 351665558)

    internal val getNodePropertyValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_node_property_value", 678354945)

    internal val getConnectionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_count", 3905245786)

    internal val getConnectionSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_source", 408788394)

    internal val getConnectionSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_signal", 659327637)

    internal val getConnectionTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_target", 408788394)

    internal val getConnectionMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_method", 659327637)

    internal val getConnectionFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_flags", 923996154)

    internal val getConnectionBindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_binds", 663333327)

    internal val getConnectionUnbindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneState", "get_connection_unbinds", 923996154)
  }
}
