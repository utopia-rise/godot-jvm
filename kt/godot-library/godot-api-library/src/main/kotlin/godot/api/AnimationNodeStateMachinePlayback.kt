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
import godot.core.MethodStringName2
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING_NAME_BOOL
import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Allows control of [AnimationTree] state machines created with [AnimationNodeStateMachine].
 * Retrieve with `$AnimationTree.get("parameters/playback")`.
 *
 * ```gdscript
 * //gdscript
 * var state_machine = $AnimationTree.get("parameters/playback")
 * state_machine.travel("some_state")
 * ```
 *
 * ```csharp
 * //csharp
 * var stateMachine =
 * GetNode<AnimationTree>("AnimationTree").Get("parameters/playback").As<AnimationNodeStateMachinePlayback>();
 * stateMachine.Travel("some_state");
 * ```
 */
@GodotBaseType
public open class AnimationNodeStateMachinePlayback : Resource() {
  /**
   * Emitted when the [state] starts playback. If [state] is a state machine set to grouped mode,
   * its signals are passed through with its name prefixed.
   */
  public val stateStarted: Signal1<StringName> by Signal1

  /**
   * Emitted when the [state] finishes playback. If [state] is a state machine set to grouped mode,
   * its signals are passed through with its name prefixed.
   *
   * If there is a crossfade, this will be fired when the influence of the [getFadingFromNode]
   * animation is no longer present.
   */
  public val stateFinished: Signal1<StringName> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(28, scriptPtr)
  }

  /**
   * Transitions from the current state to another one, following the shortest path.
   *
   * If the path does not connect from the current state, the animation will play after the state
   * teleports.
   *
   * If [resetOnTeleport] is `true`, the animation is played from the beginning when the travel
   * cause a teleportation.
   */
  @JvmOverloads
  public final fun travel(toNode: StringName, resetOnTeleport: Boolean = true): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, toNode, resetOnTeleport)
    TransferContext.callMethod(MethodBindings.travelPtr)
  }

  /**
   * Starts playing the given animation.
   *
   * If [reset] is `true`, the animation is played from the beginning.
   */
  @JvmOverloads
  public final fun start(node: StringName, reset: Boolean = true): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, node, reset)
    TransferContext.callMethod(MethodBindings.startPtr)
  }

  /**
   * If there is a next path by travel or auto advance, immediately transitions from the current
   * state to the next state.
   */
  public final fun next(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.nextPtr)
  }

  /**
   * Stops the currently playing animation.
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPtr)
  }

  /**
   * Returns `true` if an animation is playing.
   */
  public final fun isPlaying(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPlayingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the currently playing animation state.
   *
   * **Note:** When using a cross-fade, the current state changes to the next state immediately
   * after the cross-fade begins.
   */
  public final fun getCurrentNode(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentNodePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the playback position within the current animation state.
   */
  public final fun getCurrentPlayPosition(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentPlayPositionPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the current state length.
   *
   * **Note:** It is possible that any [AnimationRootNode] can be nodes as well as animations. This
   * means that there can be multiple animations within a single state. Which animation length has
   * priority depends on the nodes connected inside it. Also, if a transition does not reset, the
   * remaining length at that point will be returned.
   */
  public final fun getCurrentLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the starting state of currently fading animation.
   */
  public final fun getFadingFromNode(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadingFromNodePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the playback position of the node from [getFadingFromNode]. Returns `0` if no animation
   * fade is occurring.
   */
  public final fun getFadingFromPlayPosition(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadingFromPlayPositionPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the playback state length of the node from [getFadingFromNode]. Returns `0` if no
   * animation fade is occurring.
   */
  public final fun getFadingFromLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadingFromLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the playback position of the current fade animation. Returns `0` if no animation fade
   * is occurring.
   */
  public final fun getFadingPosition(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadingPositionPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the length of the current fade animation. Returns `0` if no animation fade is
   * occurring.
   */
  public final fun getFadingLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadingLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the current travel path as computed internally by the A* algorithm.
   */
  public final fun getTravelPath(): VariantArray<StringName> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTravelPathPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<StringName>)
  }

  /**
   * Transitions from the current state to another one, following the shortest path.
   *
   * If the path does not connect from the current state, the animation will play after the state
   * teleports.
   *
   * If [resetOnTeleport] is `true`, the animation is played from the beginning when the travel
   * cause a teleportation.
   */
  @JvmOverloads
  public final fun travel(toNode: String, resetOnTeleport: Boolean = true) =
      travel(toNode.asCachedStringName(), resetOnTeleport)

  /**
   * Starts playing the given animation.
   *
   * If [reset] is `true`, the animation is played from the beginning.
   */
  @JvmOverloads
  public final fun start(node: String, reset: Boolean = true) =
      start(node.asCachedStringName(), reset)

  public companion object {
    @JvmField
    public val travelName:
        MethodStringName2<AnimationNodeStateMachinePlayback, Unit, StringName, Boolean> =
        MethodStringName2<AnimationNodeStateMachinePlayback, Unit, StringName, Boolean>("travel")

    @JvmField
    public val startName:
        MethodStringName2<AnimationNodeStateMachinePlayback, Unit, StringName, Boolean> =
        MethodStringName2<AnimationNodeStateMachinePlayback, Unit, StringName, Boolean>("start")

    @JvmField
    public val nextName: MethodStringName0<AnimationNodeStateMachinePlayback, Unit> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Unit>("next")

    @JvmField
    public val stopName: MethodStringName0<AnimationNodeStateMachinePlayback, Unit> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Unit>("stop")

    @JvmField
    public val isPlayingName: MethodStringName0<AnimationNodeStateMachinePlayback, Boolean> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Boolean>("is_playing")

    @JvmField
    public val getCurrentNodeName: MethodStringName0<AnimationNodeStateMachinePlayback, StringName>
        = MethodStringName0<AnimationNodeStateMachinePlayback, StringName>("get_current_node")

    @JvmField
    public val getCurrentPlayPositionName:
        MethodStringName0<AnimationNodeStateMachinePlayback, Float> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Float>("get_current_play_position")

    @JvmField
    public val getCurrentLengthName: MethodStringName0<AnimationNodeStateMachinePlayback, Float> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Float>("get_current_length")

    @JvmField
    public val getFadingFromNodeName:
        MethodStringName0<AnimationNodeStateMachinePlayback, StringName> =
        MethodStringName0<AnimationNodeStateMachinePlayback, StringName>("get_fading_from_node")

    @JvmField
    public val getFadingFromPlayPositionName:
        MethodStringName0<AnimationNodeStateMachinePlayback, Float> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Float>("get_fading_from_play_position")

    @JvmField
    public val getFadingFromLengthName: MethodStringName0<AnimationNodeStateMachinePlayback, Float>
        = MethodStringName0<AnimationNodeStateMachinePlayback, Float>("get_fading_from_length")

    @JvmField
    public val getFadingPositionName: MethodStringName0<AnimationNodeStateMachinePlayback, Float> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Float>("get_fading_position")

    @JvmField
    public val getFadingLengthName: MethodStringName0<AnimationNodeStateMachinePlayback, Float> =
        MethodStringName0<AnimationNodeStateMachinePlayback, Float>("get_fading_length")

    @JvmField
    public val getTravelPathName:
        MethodStringName0<AnimationNodeStateMachinePlayback, VariantArray<StringName>> =
        MethodStringName0<AnimationNodeStateMachinePlayback, VariantArray<StringName>>("get_travel_path")
  }

  public object MethodBindings {
    internal val travelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "travel", 3823612587)

    internal val startPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "start", 3823612587)

    internal val nextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "next", 3218959716)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "stop", 3218959716)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "is_playing", 36873697)

    internal val getCurrentNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_current_node", 2002593661)

    internal val getCurrentPlayPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_current_play_position", 1740695150)

    internal val getCurrentLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_current_length", 1740695150)

    internal val getFadingFromNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_fading_from_node", 2002593661)

    internal val getFadingFromPlayPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_fading_from_play_position", 1740695150)

    internal val getFadingFromLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_fading_from_length", 1740695150)

    internal val getFadingPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_fading_position", 1740695150)

    internal val getFadingLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_fading_length", 1740695150)

    internal val getTravelPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeStateMachinePlayback", "get_travel_path", 3995934104)
  }
}
