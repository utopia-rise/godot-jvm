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
import godot.core.NodePath
import godot.core.Signal0
import godot.core.asCachedNodePath
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_OBJECT
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A node used for advanced animation transitions in an [AnimationPlayer].
 *
 * **Note:** When linked with an [AnimationPlayer], several properties and methods of the
 * corresponding [AnimationPlayer] will not function as expected. Playback and transitions should be
 * handled using only the [AnimationTree] and its constituent [AnimationNode](s). The [AnimationPlayer]
 * node should be used solely for adding, deleting, and editing animations.
 */
@GodotBaseType
public open class AnimationTree : AnimationMixer() {
  /**
   * Emitted when the [animPlayer] is changed.
   */
  public val animationPlayerChanged: Signal0 by Signal0

  /**
   * The root animation node of this [AnimationTree]. See [AnimationRootNode].
   */
  public final inline var treeRoot: AnimationRootNode?
    @JvmName("treeRootProperty")
    get() = getTreeRoot()
    @JvmName("treeRootProperty")
    set(`value`) {
      setTreeRoot(value)
    }

  /**
   * The path to the [Node] used to evaluate the [AnimationNode] [Expression] if one is not
   * explicitly specified internally.
   */
  public final inline var advanceExpressionBaseNode: NodePath
    @JvmName("advanceExpressionBaseNodeProperty")
    get() = getAdvanceExpressionBaseNode()
    @JvmName("advanceExpressionBaseNodeProperty")
    set(`value`) {
      setAdvanceExpressionBaseNode(value)
    }

  /**
   * The path to the [AnimationPlayer] used for animating.
   */
  public final inline var animPlayer: NodePath
    @JvmName("animPlayerProperty")
    get() = getAnimationPlayer()
    @JvmName("animPlayerProperty")
    set(`value`) {
      setAnimationPlayer(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(37, scriptPtr)
  }

  public final fun setTreeRoot(animationNode: AnimationRootNode?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, animationNode)
    TransferContext.callPtrMethod(MethodBindings.setTreeRootPtr, 0)
  }

  public final fun getTreeRoot(): AnimationRootNode? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTreeRootPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AnimationRootNode?)
  }

  public final fun setAdvanceExpressionBaseNode(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callPtrMethod(MethodBindings.setAdvanceExpressionBaseNodePtr, 0)
  }

  public final fun getAdvanceExpressionBaseNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAdvanceExpressionBaseNodePtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setAnimationPlayer(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callPtrMethod(MethodBindings.setAnimationPlayerPtr, 0)
  }

  public final fun getAnimationPlayer(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAnimationPlayerPtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the process notification in which to update animations.
   */
  public final fun setProcessCallback(mode: AnimationProcessCallback): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setProcessCallbackPtr, 0)
  }

  /**
   * Returns the process notification in which to update animations.
   */
  public final fun getProcessCallback(): AnimationProcessCallback {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getProcessCallbackPtr, 2)
    return AnimationProcessCallback.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAdvanceExpressionBaseNode(path: String) =
      setAdvanceExpressionBaseNode(path.asCachedNodePath())

  public final fun setAnimationPlayer(path: String) = setAnimationPlayer(path.asCachedNodePath())

  public enum class AnimationProcessCallback(
    public override val `value`: Long,
  ) : GodotEnum {
    PHYSICS(0),
    IDLE(1),
    MANUAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): AnimationProcessCallback =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTreeRootName: MethodStringName1<AnimationTree, Unit, AnimationRootNode?> =
        MethodStringName1<AnimationTree, Unit, AnimationRootNode?>("set_tree_root")

    @JvmField
    public val getTreeRootName: MethodStringName0<AnimationTree, AnimationRootNode?> =
        MethodStringName0<AnimationTree, AnimationRootNode?>("get_tree_root")

    @JvmField
    public val setAdvanceExpressionBaseNodeName: MethodStringName1<AnimationTree, Unit, NodePath> =
        MethodStringName1<AnimationTree, Unit, NodePath>("set_advance_expression_base_node")

    @JvmField
    public val getAdvanceExpressionBaseNodeName: MethodStringName0<AnimationTree, NodePath> =
        MethodStringName0<AnimationTree, NodePath>("get_advance_expression_base_node")

    @JvmField
    public val setAnimationPlayerName: MethodStringName1<AnimationTree, Unit, NodePath> =
        MethodStringName1<AnimationTree, Unit, NodePath>("set_animation_player")

    @JvmField
    public val getAnimationPlayerName: MethodStringName0<AnimationTree, NodePath> =
        MethodStringName0<AnimationTree, NodePath>("get_animation_player")

    @JvmField
    public val setProcessCallbackName:
        MethodStringName1<AnimationTree, Unit, AnimationProcessCallback> =
        MethodStringName1<AnimationTree, Unit, AnimationProcessCallback>("set_process_callback")

    @JvmField
    public val getProcessCallbackName: MethodStringName0<AnimationTree, AnimationProcessCallback> =
        MethodStringName0<AnimationTree, AnimationProcessCallback>("get_process_callback")
  }

  public object MethodBindings {
    internal val setTreeRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "set_tree_root", 2581683800)

    internal val getTreeRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "get_tree_root", 4110384712)

    internal val setAdvanceExpressionBaseNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "set_advance_expression_base_node", 1348162250)

    internal val getAdvanceExpressionBaseNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "get_advance_expression_base_node", 4075236667)

    internal val setAnimationPlayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "set_animation_player", 1348162250)

    internal val getAnimationPlayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "get_animation_player", 4075236667)

    internal val setProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "set_process_callback", 1723352826)

    internal val getProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationTree", "get_process_callback", 891317132)
  }
}
