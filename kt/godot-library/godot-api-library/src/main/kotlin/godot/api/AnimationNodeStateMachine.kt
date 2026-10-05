// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_VECTOR2
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.callPtrMethod_LONG_ret_STRING_NAME
import godot.callPtrMethod_OBJECT_ret_STRING_NAME
import godot.callPtrMethod_STRING_NAME
import godot.callPtrMethod_STRING_NAME_OBJECT
import godot.callPtrMethod_STRING_NAME_OBJECT_VECTOR2
import godot.callPtrMethod_STRING_NAME_STRING_NAME
import godot.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT
import godot.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL
import godot.callPtrMethod_STRING_NAME_VECTOR2
import godot.callPtrMethod_STRING_NAME_ret_BOOL
import godot.callPtrMethod_STRING_NAME_ret_OBJECT_REF
import godot.callPtrMethod_STRING_NAME_ret_VECTOR2
import godot.callPtrMethod_VECTOR2
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.StringName
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Contains multiple [AnimationRootNode]s representing animation states, connected in a graph. State
 * transitions can be configured to happen automatically or via code, using a shortest-path algorithm.
 * Retrieve the [AnimationNodeStateMachinePlayback] object from the [AnimationTree] node to control it
 * programmatically.
 *
 * ```gdscript
 * //gdscript
 * var state_machine = $AnimationTree.get("parameters/playback")
 * state_machine.travel("some_state")
 * ```
 *
 * ```csharp
 * //csharp
 * var stateMachine = GetNode<AnimationTree>("AnimationTree").Get("parameters/playback") as
 * AnimationNodeStateMachinePlayback;
 * stateMachine.Travel("some_state");
 * ```
 */
@GodotBaseType
public open class AnimationNodeStateMachine : AnimationRootNode() {
  /**
   * This property can define the process of transitions for different use cases. See also
   * [AnimationNodeStateMachine.StateMachineType].
   */
  public final inline var stateMachineType: StateMachineType
    @JvmName("stateMachineTypeProperty")
    get() = getStateMachineType()
    @JvmName("stateMachineTypeProperty")
    set(`value`) {
      setStateMachineType(value)
    }

  /**
   * If `true`, allows teleport to the self state with [AnimationNodeStateMachinePlayback.travel].
   * When the reset option is enabled in [AnimationNodeStateMachinePlayback.travel], the animation is
   * restarted. If `false`, nothing happens on the teleportation to the self state.
   */
  public final inline var allowTransitionToSelf: Boolean
    @JvmName("allowTransitionToSelfProperty")
    get() = isAllowTransitionToSelf()
    @JvmName("allowTransitionToSelfProperty")
    set(`value`) {
      setAllowTransitionToSelf(value)
    }

  /**
   * If `true`, treat the cross-fade to the start and end nodes as a blend with the RESET animation.
   *
   * In most cases, when additional cross-fades are performed in the parent [AnimationNode] of the
   * state machine, setting this property to `false` and matching the cross-fade time of the parent
   * [AnimationNode] and the state machine's start node and end node gives good results.
   */
  public final inline var resetEnds: Boolean
    @JvmName("resetEndsProperty")
    get() = areEndsReset()
    @JvmName("resetEndsProperty")
    set(`value`) {
      setResetEnds(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(27, scriptPtr)
  }

  /**
   * Adds a new animation node to the graph. The [position] is used for display in the editor.
   */
  @JvmOverloads
  public final fun addNode(
    name: StringName,
    node: AnimationNode?,
    position: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_OBJECT_VECTOR2(ptr, objectID.id, MethodBindings.addNodePtr, name, node, position)
  }

  /**
   * Replaces the given animation node with a new animation node.
   */
  public final fun replaceNode(name: StringName, node: AnimationNode?): Unit {
    TransferContext.callPtrMethod_STRING_NAME_OBJECT(ptr, objectID.id, MethodBindings.replaceNodePtr, name, node)
  }

  /**
   * Returns the animation node with the given name.
   */
  public final fun getNode(name: StringName): AnimationNode? =
      (TransferContext.callPtrMethod_STRING_NAME_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getNodePtr, name) as AnimationNode?)

  /**
   * Deletes the given animation node from the graph.
   */
  public final fun removeNode(name: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.removeNodePtr, name)
  }

  /**
   * Renames the given animation node.
   */
  public final fun renameNode(name: StringName, newName: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameNodePtr, name, newName)
  }

  /**
   * Returns `true` if the graph contains the given animation node.
   */
  public final fun hasNode(name: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasNodePtr, name)

  /**
   * Returns the given animation node's name.
   */
  public final fun getNodeName(node: AnimationNode?): StringName =
      TransferContext.callPtrMethod_OBJECT_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getNodeNamePtr, node)

  /**
   * Returns a list containing the names of all animation nodes in this state machine.
   */
  public final fun getNodeList(): VariantArray<StringName> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getNodeListPtr) as VariantArray<StringName>)

  /**
   * Sets the animation node's coordinates. Used for display in the editor.
   */
  public final fun setNodePosition(name: StringName, position: Vector2): Unit {
    TransferContext.callPtrMethod_STRING_NAME_VECTOR2(ptr, objectID.id, MethodBindings.setNodePositionPtr, name, position)
  }

  /**
   * Returns the given animation node's coordinates. Used for display in the editor.
   */
  public final fun getNodePosition(name: StringName): Vector2 =
      TransferContext.callPtrMethod_STRING_NAME_ret_VECTOR2(ptr, objectID.id, MethodBindings.getNodePositionPtr, name)

  /**
   * Returns `true` if there is a transition between the given animation nodes.
   */
  public final fun hasTransition(from: StringName, to: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasTransitionPtr, from, to)

  /**
   * Adds a transition between the given animation nodes.
   */
  public final fun addTransition(
    from: StringName,
    to: StringName,
    transition: AnimationNodeStateMachineTransition?,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, MethodBindings.addTransitionPtr, from, to, transition)
  }

  /**
   * Returns the given transition.
   */
  public final fun getTransition(idx: Int): AnimationNodeStateMachineTransition? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getTransitionPtr, idx.toLong()) as AnimationNodeStateMachineTransition?)

  /**
   * Returns the given transition's start node.
   */
  public final fun getTransitionFrom(idx: Int): StringName =
      TransferContext.callPtrMethod_LONG_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getTransitionFromPtr, idx.toLong())

  /**
   * Returns the given transition's end node.
   */
  public final fun getTransitionTo(idx: Int): StringName =
      TransferContext.callPtrMethod_LONG_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getTransitionToPtr, idx.toLong())

  /**
   * Returns the number of connections in the graph.
   */
  public final fun getTransitionCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTransitionCountPtr).toInt()

  /**
   * Deletes the given transition by index.
   */
  public final fun removeTransitionByIndex(idx: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.removeTransitionByIndexPtr, idx.toLong())
  }

  /**
   * Deletes the transition between the two specified animation nodes.
   */
  public final fun removeTransition(from: StringName, to: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.removeTransitionPtr, from, to)
  }

  /**
   * Sets the draw offset of the graph. Used for display in the editor.
   */
  public final fun setGraphOffset(offset: Vector2): Unit {
    TransferContext.callPtrMethod_VECTOR2(ptr, objectID.id, MethodBindings.setGraphOffsetPtr, offset)
  }

  /**
   * Returns the draw offset of the graph. Used for display in the editor.
   */
  public final fun getGraphOffset(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getGraphOffsetPtr)

  public final fun setStateMachineType(stateMachineType: StateMachineType): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStateMachineTypePtr, stateMachineType.value)
  }

  public final fun getStateMachineType(): StateMachineType =
      StateMachineType.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStateMachineTypePtr))

  public final fun setAllowTransitionToSelf(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAllowTransitionToSelfPtr, enable)
  }

  public final fun isAllowTransitionToSelf(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isAllowTransitionToSelfPtr)

  public final fun setResetEnds(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setResetEndsPtr, enable)
  }

  public final fun areEndsReset(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.areEndsResetPtr)

  /**
   * Adds a new animation node to the graph. The [position] is used for display in the editor.
   */
  @JvmOverloads
  public final fun addNode(
    name: String,
    node: AnimationNode?,
    position: Vector2 = Vector2(0, 0),
  ) = addNode(name.asCachedStringName(), node, position)

  /**
   * Replaces the given animation node with a new animation node.
   */
  public final fun replaceNode(name: String, node: AnimationNode?) =
      replaceNode(name.asCachedStringName(), node)

  /**
   * Returns the animation node with the given name.
   */
  public final fun getNode(name: String): AnimationNode? = getNode(name.asCachedStringName())

  /**
   * Deletes the given animation node from the graph.
   */
  public final fun removeNode(name: String) = removeNode(name.asCachedStringName())

  /**
   * Renames the given animation node.
   */
  public final fun renameNode(name: String, newName: String) =
      renameNode(name.asCachedStringName(), newName.asCachedStringName())

  /**
   * Returns `true` if the graph contains the given animation node.
   */
  public final fun hasNode(name: String): Boolean = hasNode(name.asCachedStringName())

  /**
   * Sets the animation node's coordinates. Used for display in the editor.
   */
  public final fun setNodePosition(name: String, position: Vector2) =
      setNodePosition(name.asCachedStringName(), position)

  /**
   * Returns the given animation node's coordinates. Used for display in the editor.
   */
  public final fun getNodePosition(name: String): Vector2 =
      getNodePosition(name.asCachedStringName())

  /**
   * Returns `true` if there is a transition between the given animation nodes.
   */
  public final fun hasTransition(from: String, to: String): Boolean =
      hasTransition(from.asCachedStringName(), to.asCachedStringName())

  /**
   * Adds a transition between the given animation nodes.
   */
  public final fun addTransition(
    from: String,
    to: String,
    transition: AnimationNodeStateMachineTransition?,
  ) = addTransition(from.asCachedStringName(), to.asCachedStringName(), transition)

  /**
   * Deletes the transition between the two specified animation nodes.
   */
  public final fun removeTransition(from: String, to: String) =
      removeTransition(from.asCachedStringName(), to.asCachedStringName())

  public enum class StateMachineType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Seeking to the beginning is treated as playing from the start state. Transition to the end
     * state is treated as exiting the state machine.
     */
    ROOT(0),
    /**
     * Seeking to the beginning is treated as seeking to the beginning of the animation in the
     * current state. Transition to the end state, or the absence of transitions in each state, is
     * treated as exiting the state machine.
     */
    NESTED(1),
    /**
     * This is a grouped state machine that can be controlled from a parent state machine. It does
     * not work independently. There must be a state machine with [stateMachineType] of
     * [STATE_MACHINE_TYPE_ROOT] or [STATE_MACHINE_TYPE_NESTED] in the parent or ancestor.
     */
    GROUPED(2),
    ;

    public companion object {
      public fun from(`value`: Long): StateMachineType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addNodeName:
        MethodStringName3<AnimationNodeStateMachine, Unit, StringName, AnimationNode?, Vector2> =
        MethodStringName3<AnimationNodeStateMachine, Unit, StringName, AnimationNode?, Vector2>("add_node")

    @JvmField
    public val replaceNodeName:
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, AnimationNode?> =
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, AnimationNode?>("replace_node")

    @JvmField
    public val getNodeName: MethodStringName1<AnimationNodeStateMachine, AnimationNode?, StringName>
        = MethodStringName1<AnimationNodeStateMachine, AnimationNode?, StringName>("get_node")

    @JvmField
    public val removeNodeName: MethodStringName1<AnimationNodeStateMachine, Unit, StringName> =
        MethodStringName1<AnimationNodeStateMachine, Unit, StringName>("remove_node")

    @JvmField
    public val renameNodeName:
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, StringName> =
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, StringName>("rename_node")

    @JvmField
    public val hasNodeName: MethodStringName1<AnimationNodeStateMachine, Boolean, StringName> =
        MethodStringName1<AnimationNodeStateMachine, Boolean, StringName>("has_node")

    @JvmField
    public val getNodeNameName:
        MethodStringName1<AnimationNodeStateMachine, StringName, AnimationNode?> =
        MethodStringName1<AnimationNodeStateMachine, StringName, AnimationNode?>("get_node_name")

    @JvmField
    public val getNodeListName:
        MethodStringName0<AnimationNodeStateMachine, VariantArray<StringName>> =
        MethodStringName0<AnimationNodeStateMachine, VariantArray<StringName>>("get_node_list")

    @JvmField
    public val setNodePositionName:
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, Vector2> =
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, Vector2>("set_node_position")

    @JvmField
    public val getNodePositionName:
        MethodStringName1<AnimationNodeStateMachine, Vector2, StringName> =
        MethodStringName1<AnimationNodeStateMachine, Vector2, StringName>("get_node_position")

    @JvmField
    public val hasTransitionName:
        MethodStringName2<AnimationNodeStateMachine, Boolean, StringName, StringName> =
        MethodStringName2<AnimationNodeStateMachine, Boolean, StringName, StringName>("has_transition")

    @JvmField
    public val addTransitionName:
        MethodStringName3<AnimationNodeStateMachine, Unit, StringName, StringName, AnimationNodeStateMachineTransition?>
        =
        MethodStringName3<AnimationNodeStateMachine, Unit, StringName, StringName, AnimationNodeStateMachineTransition?>("add_transition")

    @JvmField
    public val getTransitionName:
        MethodStringName1<AnimationNodeStateMachine, AnimationNodeStateMachineTransition?, Int> =
        MethodStringName1<AnimationNodeStateMachine, AnimationNodeStateMachineTransition?, Int>("get_transition")

    @JvmField
    public val getTransitionFromName: MethodStringName1<AnimationNodeStateMachine, StringName, Int>
        = MethodStringName1<AnimationNodeStateMachine, StringName, Int>("get_transition_from")

    @JvmField
    public val getTransitionToName: MethodStringName1<AnimationNodeStateMachine, StringName, Int> =
        MethodStringName1<AnimationNodeStateMachine, StringName, Int>("get_transition_to")

    @JvmField
    public val getTransitionCountName: MethodStringName0<AnimationNodeStateMachine, Int> =
        MethodStringName0<AnimationNodeStateMachine, Int>("get_transition_count")

    @JvmField
    public val removeTransitionByIndexName: MethodStringName1<AnimationNodeStateMachine, Unit, Int>
        = MethodStringName1<AnimationNodeStateMachine, Unit, Int>("remove_transition_by_index")

    @JvmField
    public val removeTransitionName:
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, StringName> =
        MethodStringName2<AnimationNodeStateMachine, Unit, StringName, StringName>("remove_transition")

    @JvmField
    public val setGraphOffsetName: MethodStringName1<AnimationNodeStateMachine, Unit, Vector2> =
        MethodStringName1<AnimationNodeStateMachine, Unit, Vector2>("set_graph_offset")

    @JvmField
    public val getGraphOffsetName: MethodStringName0<AnimationNodeStateMachine, Vector2> =
        MethodStringName0<AnimationNodeStateMachine, Vector2>("get_graph_offset")

    @JvmField
    public val setStateMachineTypeName:
        MethodStringName1<AnimationNodeStateMachine, Unit, StateMachineType> =
        MethodStringName1<AnimationNodeStateMachine, Unit, StateMachineType>("set_state_machine_type")

    @JvmField
    public val getStateMachineTypeName:
        MethodStringName0<AnimationNodeStateMachine, StateMachineType> =
        MethodStringName0<AnimationNodeStateMachine, StateMachineType>("get_state_machine_type")

    @JvmField
    public val setAllowTransitionToSelfName:
        MethodStringName1<AnimationNodeStateMachine, Unit, Boolean> =
        MethodStringName1<AnimationNodeStateMachine, Unit, Boolean>("set_allow_transition_to_self")

    @JvmField
    public val isAllowTransitionToSelfName: MethodStringName0<AnimationNodeStateMachine, Boolean> =
        MethodStringName0<AnimationNodeStateMachine, Boolean>("is_allow_transition_to_self")

    @JvmField
    public val setResetEndsName: MethodStringName1<AnimationNodeStateMachine, Unit, Boolean> =
        MethodStringName1<AnimationNodeStateMachine, Unit, Boolean>("set_reset_ends")

    @JvmField
    public val areEndsResetName: MethodStringName0<AnimationNodeStateMachine, Boolean> =
        MethodStringName0<AnimationNodeStateMachine, Boolean>("are_ends_reset")
  }

  public object MethodBindings {
    internal val addNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "add_node", 1980270704)

    internal val replaceNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "replace_node", 2559412862)

    internal val getNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_node", 625644256)

    internal val removeNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "remove_node", 3304788590)

    internal val renameNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "rename_node", 3740211285)

    internal val hasNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "has_node", 2619796661)

    internal val getNodeNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_node_name", 739213945)

    internal val getNodeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_node_list", 3995934104)

    internal val setNodePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "set_node_position", 1999414630)

    internal val getNodePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_node_position", 3100822709)

    internal val hasTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "has_transition", 471820014)

    internal val addTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "add_transition", 795486887)

    internal val getTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_transition", 4192381260)

    internal val getTransitionFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_transition_from", 659327637)

    internal val getTransitionToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_transition_to", 659327637)

    internal val getTransitionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_transition_count", 3905245786)

    internal val removeTransitionByIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "remove_transition_by_index", 1286410249)

    internal val removeTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "remove_transition", 3740211285)

    internal val setGraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "set_graph_offset", 743155724)

    internal val getGraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_graph_offset", 3341600327)

    internal val setStateMachineTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "set_state_machine_type", 2584759088)

    internal val getStateMachineTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "get_state_machine_type", 1140726469)

    internal val setAllowTransitionToSelfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "set_allow_transition_to_self", 2586408642)

    internal val isAllowTransitionToSelfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "is_allow_transition_to_self", 36873697)

    internal val setResetEndsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "set_reset_ends", 2586408642)

    internal val areEndsResetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachine", "are_ends_reset", 36873697)
  }
}
