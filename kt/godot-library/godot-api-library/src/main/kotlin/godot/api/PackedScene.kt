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
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A simplified interface to a scene file. Provides access to operations and checks that can be
 * performed on the scene resource itself.
 *
 * Can be used to save a node to a file. When saving, the node as well as all the nodes it owns get
 * saved (see [Node.owner] property).
 *
 * **Note:** The node doesn't need to own itself.
 *
 * **Example:** Load a saved scene:
 *
 * ```gdscript
 * //gdscript
 * # Use load() instead of preload() if the path isn't known at compile-time.
 * var scene = preload("res://scene.tscn").instantiate()
 * # Add the node as a child of the node the script is attached to.
 * add_child(scene)
 * ```
 *
 * ```csharp
 * //csharp
 * // C# has no preload, so you have to always use ResourceLoader.Load<PackedScene>().
 * var scene = ResourceLoader.Load<PackedScene>("res://scene.tscn").Instantiate();
 * // Add the node as a child of the node the script is attached to.
 * AddChild(scene);
 * ```
 *
 * **Example:** Save a node with different owners. The following example creates 3 objects: [Node2D]
 * (`node`), [RigidBody2D] (`body`) and [CollisionObject2D] (`collision`). `collision` is a child of
 * `body` which is a child of `node`. Only `body` is owned by `node` and [pack] will therefore only
 * save those two nodes, but not `collision`.
 *
 * ```gdscript
 * //gdscript
 * # Create the objects.
 * var node = Node2D.new()
 * var body = RigidBody2D.new()
 * var collision = CollisionShape2D.new()
 *
 * # Create the object hierarchy.
 * body.add_child(collision)
 * node.add_child(body)
 *
 * # Change owner of `body`, but not of `collision`.
 * body.owner = node
 * var scene = PackedScene.new()
 *
 * # Only `node` and `body` are now packed.
 * var result = scene.pack(node)
 * if result == OK:
 * 	var error = ResourceSaver.save(scene, "res://path/name.tscn")  # Or "user://..."
 * 	if error != OK:
 * 		push_error("An error occurred while saving the scene to disk.")
 * ```
 *
 * ```csharp
 * //csharp
 * // Create the objects.
 * var node = new Node2D();
 * var body = new RigidBody2D();
 * var collision = new CollisionShape2D();
 *
 * // Create the object hierarchy.
 * body.AddChild(collision);
 * node.AddChild(body);
 *
 * // Change owner of `body`, but not of `collision`.
 * body.Owner = node;
 * var scene = new PackedScene();
 *
 * // Only `node` and `body` are now packed.
 * Error result = scene.Pack(node);
 * if (result == Error.Ok)
 * {
 * 	Error error = ResourceSaver.Save(scene, "res://path/name.tscn"); // Or "user://..."
 * 	if (error != Error.Ok)
 * 	{
 * 		GD.PushError("An error occurred while saving the scene to disk.");
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class PackedScene : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(501, scriptPtr)
  }

  /**
   * Packs the [path] node, and all owned sub-nodes, into this [PackedScene]. Any existing data will
   * be cleared. See [Node.owner].
   */
  public final fun pack(path: Node?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to path)
    TransferContext.callMethod(MethodBindings.packPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Instantiates the scene's node hierarchy. Triggers child scene instantiation(s). Triggers a
   * [Node.NOTIFICATION_SCENE_INSTANTIATED] notification on the root node.
   */
  @JvmOverloads
  public final fun instantiate(editState: GenEditState = PackedScene.GenEditState.DISABLED): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to editState.value)
    TransferContext.callMethod(MethodBindings.instantiatePtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Returns `true` if the scene file has nodes.
   */
  public final fun canInstantiate(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canInstantiatePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [SceneState] representing the scene file contents.
   */
  public final fun getState(): SceneState? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStatePtr)
    return (TransferContext.readReturnValue(OBJECT) as SceneState?)
  }

  public enum class GenEditState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If passed to [instantiate], blocks edits to the scene state.
     */
    DISABLED(0),
    /**
     * If passed to [instantiate], provides local scene resources to the local scene.
     *
     * **Note:** Only available in editor builds.
     */
    INSTANCE(1),
    /**
     * If passed to [instantiate], provides local scene resources to the local scene. Only the main
     * scene should receive the main edit state.
     *
     * **Note:** Only available in editor builds.
     */
    MAIN(2),
    /**
     * It's similar to [GEN_EDIT_STATE_MAIN], but for the case where the scene is being instantiated
     * to be the base of another one.
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
    public val packName: MethodStringName1<PackedScene, Error, Node?> =
        MethodStringName1<PackedScene, Error, Node?>("pack")

    @JvmField
    public val instantiateName: MethodStringName1<PackedScene, Node?, GenEditState> =
        MethodStringName1<PackedScene, Node?, GenEditState>("instantiate")

    @JvmField
    public val canInstantiateName: MethodStringName0<PackedScene, Boolean> =
        MethodStringName0<PackedScene, Boolean>("can_instantiate")

    @JvmField
    public val getStateName: MethodStringName0<PackedScene, SceneState?> =
        MethodStringName0<PackedScene, SceneState?>("get_state")
  }

  public object MethodBindings {
    internal val packPtr: VoidPtr = TypeManager.getMethodBindPtr("PackedScene", "pack", 2584678054)

    internal val instantiatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PackedScene", "instantiate", 2628778455)

    internal val canInstantiatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PackedScene", "can_instantiate", 36873697)

    internal val getStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PackedScene", "get_state", 3479783971)
  }
}
