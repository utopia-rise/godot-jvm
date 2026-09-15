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
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Simple state machine for cases which don't require a more advanced [AnimationNodeStateMachine].
 * Animations can be connected to the inputs and transition times can be specified.
 *
 * After setting the request and changing the animation playback, the transition node automatically
 * clears the request on the next process frame by setting its `transition_request` value to empty.
 *
 * **Note:** When using a cross-fade, `current_state` and `current_index` change to the next state
 * immediately after the cross-fade begins.
 *
 * ```gdscript
 * //gdscript
 * # Play child animation connected to "state_2" port.
 * animation_tree.set("parameters/Transition/transition_request", "state_2")
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/Transition/transition_request"] = "state_2"
 *
 * # Get current state name (read-only).
 * animation_tree.get("parameters/Transition/current_state")
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/Transition/current_state"]
 *
 * # Get current state index (read-only).
 * animation_tree.get("parameters/Transition/current_index")
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/Transition/current_index"]
 * ```
 *
 * ```csharp
 * //csharp
 * // Play child animation connected to "state_2" port.
 * animationTree.Set("parameters/Transition/transition_request", "state_2");
 *
 * // Get current state name (read-only).
 * animationTree.Get("parameters/Transition/current_state");
 *
 * // Get current state index (read-only).
 * animationTree.Get("parameters/Transition/current_index");
 * ```
 */
@GodotBaseType
public open class AnimationNodeTransition : AnimationNodeSync() {
  /**
   * Cross-fading time (in seconds) between each animation connected to the inputs.
   *
   * **Note:** [AnimationNodeTransition] transitions the current state immediately after the start
   * of the fading. The precise remaining time can only be inferred from the main animation. When
   * [AnimationNodeOutput] is considered as the most upstream, so the [xfadeTime] is not scaled
   * depending on the downstream delta. See also [AnimationNodeOneShot.fadeoutTime].
   */
  public final inline var xfadeTime: Double
    @JvmName("xfadeTimeProperty")
    get() = getXfadeTime()
    @JvmName("xfadeTimeProperty")
    set(`value`) {
      setXfadeTime(value)
    }

  /**
   * Determines how cross-fading between animations is eased. If empty, the transition will be
   * linear. Should be a unit [Curve].
   */
  public final inline var xfadeCurve: Curve?
    @JvmName("xfadeCurveProperty")
    get() = getXfadeCurve()
    @JvmName("xfadeCurveProperty")
    set(`value`) {
      setXfadeCurve(value)
    }

  /**
   * If `true`, allows transition to the self state. When the reset option is enabled in input, the
   * animation is restarted. If `false`, nothing happens on the transition to the self state.
   */
  public final inline var allowTransitionToSelf: Boolean
    @JvmName("allowTransitionToSelfProperty")
    get() = isAllowTransitionToSelf()
    @JvmName("allowTransitionToSelfProperty")
    set(`value`) {
      setAllowTransitionToSelf(value)
    }

  /**
   * The number of enabled input ports for this animation node.
   */
  public final inline var inputCount: Int
    @JvmName("inputCountProperty")
    get() = getInputCount()
    @JvmName("inputCountProperty")
    set(`value`) {
      setInputCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(34, scriptPtr)
  }

  public final fun setInputCount(inputCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to inputCount.toLong())
    TransferContext.callMethod(MethodBindings.setInputCountPtr)
  }

  /**
   * Enables or disables auto-advance for the given [input] index. If enabled, state changes to the
   * next input after playing the animation once. If enabled for the last input state, it loops to the
   * first.
   */
  public final fun setInputAsAutoAdvance(input: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setInputAsAutoAdvancePtr)
  }

  /**
   * Returns `true` if auto-advance is enabled for the given [input] index.
   */
  public final fun isInputSetAsAutoAdvance(input: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong())
    TransferContext.callMethod(MethodBindings.isInputSetAsAutoAdvancePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, breaks the loop at the end of the loop cycle for transition, even if the animation
   * is looping.
   */
  public final fun setInputBreakLoopAtEnd(input: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setInputBreakLoopAtEndPtr)
  }

  /**
   * Returns whether the animation breaks the loop at the end of the loop cycle for transition.
   */
  public final fun isInputLoopBrokenAtEnd(input: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong())
    TransferContext.callMethod(MethodBindings.isInputLoopBrokenAtEndPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, the destination animation is restarted when the animation transitions.
   */
  public final fun setInputReset(input: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setInputResetPtr)
  }

  /**
   * Returns whether the animation restarts when the animation transitions from the other animation.
   */
  public final fun isInputReset(input: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong())
    TransferContext.callMethod(MethodBindings.isInputResetPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setXfadeTime(time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.setXfadeTimePtr)
  }

  public final fun getXfadeTime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getXfadeTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setXfadeCurve(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setXfadeCurvePtr)
  }

  public final fun getXfadeCurve(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getXfadeCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setAllowTransitionToSelf(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAllowTransitionToSelfPtr)
  }

  public final fun isAllowTransitionToSelf(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAllowTransitionToSelfPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setInputCountName: MethodStringName1<AnimationNodeTransition, Unit, Int> =
        MethodStringName1<AnimationNodeTransition, Unit, Int>("set_input_count")

    @JvmField
    public val setInputAsAutoAdvanceName:
        MethodStringName2<AnimationNodeTransition, Unit, Int, Boolean> =
        MethodStringName2<AnimationNodeTransition, Unit, Int, Boolean>("set_input_as_auto_advance")

    @JvmField
    public val isInputSetAsAutoAdvanceName: MethodStringName1<AnimationNodeTransition, Boolean, Int>
        = MethodStringName1<AnimationNodeTransition, Boolean, Int>("is_input_set_as_auto_advance")

    @JvmField
    public val setInputBreakLoopAtEndName:
        MethodStringName2<AnimationNodeTransition, Unit, Int, Boolean> =
        MethodStringName2<AnimationNodeTransition, Unit, Int, Boolean>("set_input_break_loop_at_end")

    @JvmField
    public val isInputLoopBrokenAtEndName: MethodStringName1<AnimationNodeTransition, Boolean, Int>
        = MethodStringName1<AnimationNodeTransition, Boolean, Int>("is_input_loop_broken_at_end")

    @JvmField
    public val setInputResetName: MethodStringName2<AnimationNodeTransition, Unit, Int, Boolean> =
        MethodStringName2<AnimationNodeTransition, Unit, Int, Boolean>("set_input_reset")

    @JvmField
    public val isInputResetName: MethodStringName1<AnimationNodeTransition, Boolean, Int> =
        MethodStringName1<AnimationNodeTransition, Boolean, Int>("is_input_reset")

    @JvmField
    public val setXfadeTimeName: MethodStringName1<AnimationNodeTransition, Unit, Double> =
        MethodStringName1<AnimationNodeTransition, Unit, Double>("set_xfade_time")

    @JvmField
    public val getXfadeTimeName: MethodStringName0<AnimationNodeTransition, Double> =
        MethodStringName0<AnimationNodeTransition, Double>("get_xfade_time")

    @JvmField
    public val setXfadeCurveName: MethodStringName1<AnimationNodeTransition, Unit, Curve?> =
        MethodStringName1<AnimationNodeTransition, Unit, Curve?>("set_xfade_curve")

    @JvmField
    public val getXfadeCurveName: MethodStringName0<AnimationNodeTransition, Curve?> =
        MethodStringName0<AnimationNodeTransition, Curve?>("get_xfade_curve")

    @JvmField
    public val setAllowTransitionToSelfName:
        MethodStringName1<AnimationNodeTransition, Unit, Boolean> =
        MethodStringName1<AnimationNodeTransition, Unit, Boolean>("set_allow_transition_to_self")

    @JvmField
    public val isAllowTransitionToSelfName: MethodStringName0<AnimationNodeTransition, Boolean> =
        MethodStringName0<AnimationNodeTransition, Boolean>("is_allow_transition_to_self")
  }

  public object MethodBindings {
    internal val setInputCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_input_count", 1286410249)

    internal val setInputAsAutoAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_input_as_auto_advance", 300928843)

    internal val isInputSetAsAutoAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "is_input_set_as_auto_advance", 1116898809)

    internal val setInputBreakLoopAtEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_input_break_loop_at_end", 300928843)

    internal val isInputLoopBrokenAtEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "is_input_loop_broken_at_end", 1116898809)

    internal val setInputResetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_input_reset", 300928843)

    internal val isInputResetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "is_input_reset", 1116898809)

    internal val setXfadeTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_xfade_time", 373806689)

    internal val getXfadeTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "get_xfade_time", 1740695150)

    internal val setXfadeCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_xfade_curve", 270443179)

    internal val getXfadeCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "get_xfade_curve", 2460114913)

    internal val setAllowTransitionToSelfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "set_allow_transition_to_self", 2586408642)

    internal val isAllowTransitionToSelfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTransition", "is_allow_transition_to_self", 36873697)
  }
}
