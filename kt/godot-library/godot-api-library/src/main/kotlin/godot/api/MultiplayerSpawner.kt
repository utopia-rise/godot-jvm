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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.Signal1
import godot.core.asCachedNodePath
import godot.readReturnValue_CALLABLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_ANY
import godot.writeMethodArguments_CALLABLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_STRING
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Spawnable scenes can be configured in the editor or through code (see [addSpawnableScene]).
 *
 * Also supports custom node spawns through [spawn], calling [spawnFunction] on all peers.
 *
 * Internally, [MultiplayerSpawner] uses [MultiplayerAPI.objectConfigurationAdd] to notify spawns
 * passing the spawned node as the `object` and itself as the `configuration`, and
 * [MultiplayerAPI.objectConfigurationRemove] to notify despawns in a similar way.
 */
@GodotBaseType
public open class MultiplayerSpawner : Node() {
  /**
   * Emitted when a spawnable scene or custom spawn was despawned by the multiplayer authority. Only
   * called on remote peers.
   */
  public val despawned: Signal1<Node> by Signal1

  /**
   * Emitted when a spawnable scene or custom spawn was spawned by the multiplayer authority. Only
   * called on remote peers.
   */
  public val spawned: Signal1<Node> by Signal1

  /**
   * Path to the spawn root. Spawnable scenes that are added as direct children are replicated to
   * other peers.
   */
  public final inline var spawnPath: NodePath
    @JvmName("spawnPathProperty")
    get() = getSpawnPath()
    @JvmName("spawnPathProperty")
    set(`value`) {
      setSpawnPath(value)
    }

  /**
   * Maximum number of nodes allowed to be spawned by this spawner. Includes both spawnable scenes
   * and custom spawns.
   *
   * When set to `0` (the default), there is no limit.
   */
  public final inline var spawnLimit: Long
    @JvmName("spawnLimitProperty")
    get() = getSpawnLimit()
    @JvmName("spawnLimitProperty")
    set(`value`) {
      setSpawnLimit(value)
    }

  /**
   * Method called on all peers when a custom [spawn] is requested by the authority. Will receive
   * the `data` parameter, and should return a [Node] that is not in the scene tree.
   *
   * **Note:** The returned node should **not** be added to the scene with [Node.addChild]. This is
   * done automatically.
   */
  public final inline var spawnFunction: Callable
    @JvmName("spawnFunctionProperty")
    get() = getSpawnFunction()
    @JvmName("spawnFunctionProperty")
    set(`value`) {
      setSpawnFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(393, scriptPtr)
  }

  /**
   * Adds a scene path to spawnable scenes, making it automatically replicated from the multiplayer
   * authority to other peers when added as children of the node pointed by [spawnPath].
   */
  public final fun addSpawnableScene(path: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.addSpawnableScenePtr)
  }

  /**
   * Returns the count of spawnable scene paths.
   */
  public final fun getSpawnableSceneCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpawnableSceneCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the spawnable scene path by index.
   */
  public final fun getSpawnableScene(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getSpawnableScenePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Clears all spawnable scenes. Does not despawn existing instances on remote peers.
   */
  public final fun clearSpawnableScenes(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearSpawnableScenesPtr)
  }

  /**
   * Requests a custom spawn, with [data] passed to [spawnFunction] on all peers. Returns the
   * locally spawned node instance already inside the scene tree, and added as a child of the node
   * pointed by [spawnPath].
   *
   * **Note:** Spawnable scenes are spawned automatically. [spawn] is only needed for custom spawns.
   */
  @JvmOverloads
  public final fun spawn(`data`: Any? = null): Node? {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, data)
    TransferContext.callMethod(MethodBindings.spawnPtr)
    return (TransferContext.readReturnValue_OBJECT() as Node?)
  }

  public final fun getSpawnPath(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpawnPathPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setSpawnPath(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.setSpawnPathPtr)
  }

  public final fun getSpawnLimit(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpawnLimitPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setSpawnLimit(limit: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, limit)
    TransferContext.callMethod(MethodBindings.setSpawnLimitPtr)
  }

  public final fun getSpawnFunction(): Callable {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpawnFunctionPtr)
    return TransferContext.readReturnValue_CALLABLE()
  }

  public final fun setSpawnFunction(spawnFunction: Callable): Unit {
    TransferContext.writeMethodArguments_CALLABLE(ptr, objectID.id, spawnFunction)
    TransferContext.callMethod(MethodBindings.setSpawnFunctionPtr)
  }

  public final fun setSpawnPath(path: String) = setSpawnPath(path.asCachedNodePath())

  public companion object {
    @JvmField
    public val addSpawnableSceneName: MethodStringName1<MultiplayerSpawner, Unit, String> =
        MethodStringName1<MultiplayerSpawner, Unit, String>("add_spawnable_scene")

    @JvmField
    public val getSpawnableSceneCountName: MethodStringName0<MultiplayerSpawner, Int> =
        MethodStringName0<MultiplayerSpawner, Int>("get_spawnable_scene_count")

    @JvmField
    public val getSpawnableSceneName: MethodStringName1<MultiplayerSpawner, String, Int> =
        MethodStringName1<MultiplayerSpawner, String, Int>("get_spawnable_scene")

    @JvmField
    public val clearSpawnableScenesName: MethodStringName0<MultiplayerSpawner, Unit> =
        MethodStringName0<MultiplayerSpawner, Unit>("clear_spawnable_scenes")

    @JvmField
    public val spawnName: MethodStringName1<MultiplayerSpawner, Node?, Any?> =
        MethodStringName1<MultiplayerSpawner, Node?, Any?>("spawn")

    @JvmField
    public val getSpawnPathName: MethodStringName0<MultiplayerSpawner, NodePath> =
        MethodStringName0<MultiplayerSpawner, NodePath>("get_spawn_path")

    @JvmField
    public val setSpawnPathName: MethodStringName1<MultiplayerSpawner, Unit, NodePath> =
        MethodStringName1<MultiplayerSpawner, Unit, NodePath>("set_spawn_path")

    @JvmField
    public val getSpawnLimitName: MethodStringName0<MultiplayerSpawner, Long> =
        MethodStringName0<MultiplayerSpawner, Long>("get_spawn_limit")

    @JvmField
    public val setSpawnLimitName: MethodStringName1<MultiplayerSpawner, Unit, Long> =
        MethodStringName1<MultiplayerSpawner, Unit, Long>("set_spawn_limit")

    @JvmField
    public val getSpawnFunctionName: MethodStringName0<MultiplayerSpawner, Callable> =
        MethodStringName0<MultiplayerSpawner, Callable>("get_spawn_function")

    @JvmField
    public val setSpawnFunctionName: MethodStringName1<MultiplayerSpawner, Unit, Callable> =
        MethodStringName1<MultiplayerSpawner, Unit, Callable>("set_spawn_function")
  }

  public object MethodBindings {
    internal val addSpawnableScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "add_spawnable_scene", 83702148)

    internal val getSpawnableSceneCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "get_spawnable_scene_count", 3905245786)

    internal val getSpawnableScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "get_spawnable_scene", 844755477)

    internal val clearSpawnableScenesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "clear_spawnable_scenes", 3218959716)

    internal val spawnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "spawn", 1991184589)

    internal val getSpawnPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "get_spawn_path", 4075236667)

    internal val setSpawnPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "set_spawn_path", 1348162250)

    internal val getSpawnLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "get_spawn_limit", 3905245786)

    internal val setSpawnLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "set_spawn_limit", 1286410249)

    internal val getSpawnFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "get_spawn_function", 1307783378)

    internal val setSpawnFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerSpawner", "set_spawn_function", 1611583062)
  }
}
