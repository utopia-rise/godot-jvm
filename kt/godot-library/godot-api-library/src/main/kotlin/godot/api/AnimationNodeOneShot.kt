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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A resource to add to an [AnimationNodeBlendTree]. This animation node will execute a
 * sub-animation and return once it finishes. Blend times for fading in and out can be customized, as
 * well as filters.
 *
 * After setting the request and changing the animation playback, the one-shot node automatically
 * clears the request on the next process frame by setting its `request` value to
 * [ONE_SHOT_REQUEST_NONE].
 *
 * ```gdscript
 * //gdscript
 * # Play child animation connected to "shot" port.
 * animation_tree.set("parameters/OneShot/request", AnimationNodeOneShot.ONE_SHOT_REQUEST_FIRE)
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/OneShot/request"] = AnimationNodeOneShot.ONE_SHOT_REQUEST_FIRE
 *
 * # Abort child animation connected to "shot" port.
 * animation_tree.set("parameters/OneShot/request", AnimationNodeOneShot.ONE_SHOT_REQUEST_ABORT)
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/OneShot/request"] = AnimationNodeOneShot.ONE_SHOT_REQUEST_ABORT
 *
 * # Abort child animation with fading out connected to "shot" port.
 * animation_tree.set("parameters/OneShot/request", AnimationNodeOneShot.ONE_SHOT_REQUEST_FADE_OUT)
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/OneShot/request"] = AnimationNodeOneShot.ONE_SHOT_REQUEST_FADE_OUT
 *
 * # Get current state (read-only).
 * animation_tree.get("parameters/OneShot/active")
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/OneShot/active"]
 *
 * # Get current internal state (read-only).
 * animation_tree.get("parameters/OneShot/internal_active")
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/OneShot/internal_active"]
 * ```
 *
 * ```csharp
 * //csharp
 * // Play child animation connected to "shot" port.
 * animationTree.Set("parameters/OneShot/request", (int)AnimationNodeOneShot.OneShotRequest.Fire);
 *
 * // Abort child animation connected to "shot" port.
 * animationTree.Set("parameters/OneShot/request", (int)AnimationNodeOneShot.OneShotRequest.Abort);
 *
 * // Abort child animation with fading out connected to "shot" port.
 * animationTree.Set("parameters/OneShot/request",
 * (int)AnimationNodeOneShot.OneShotRequest.FadeOut);
 *
 * // Get current state (read-only).
 * animationTree.Get("parameters/OneShot/active");
 *
 * // Get current internal state (read-only).
 * animationTree.Get("parameters/OneShot/internal_active");
 * ```
 */
@GodotBaseType
public open class AnimationNodeOneShot : AnimationNodeSync() {
  /**
   * The blend type.
   */
  public final inline var mixMode: MixMode
    @JvmName("mixModeProperty")
    get() = getMixMode()
    @JvmName("mixModeProperty")
    set(`value`) {
      setMixMode(value)
    }

  /**
   * The fade-in duration. For example, setting this to `1.0` for a 5 second length animation will
   * produce a cross-fade that starts at 0 second and ends at 1 second during the animation.
   *
   * **Note:** [AnimationNodeOneShot] transitions the current state after the fading has finished.
   */
  public final inline var fadeinTime: Double
    @JvmName("fadeinTimeProperty")
    get() = getFadeinTime()
    @JvmName("fadeinTimeProperty")
    set(`value`) {
      setFadeinTime(value)
    }

  /**
   * Determines how cross-fading between animations is eased. If empty, the transition will be
   * linear. Should be a unit [Curve].
   */
  public final inline var fadeinCurve: Curve?
    @JvmName("fadeinCurveProperty")
    get() = getFadeinCurve()
    @JvmName("fadeinCurveProperty")
    set(`value`) {
      setFadeinCurve(value)
    }

  /**
   * The fade-out duration. For example, setting this to `1.0` for a 5 second length animation will
   * produce a cross-fade that starts at 4 second and ends at 5 second during the animation.
   *
   * **Note:** [AnimationNodeOneShot] transitions the current state after the fading has finished.
   */
  public final inline var fadeoutTime: Double
    @JvmName("fadeoutTimeProperty")
    get() = getFadeoutTime()
    @JvmName("fadeoutTimeProperty")
    set(`value`) {
      setFadeoutTime(value)
    }

  /**
   * Determines how cross-fading between animations is eased. If empty, the transition will be
   * linear. Should be a unit [Curve].
   */
  public final inline var fadeoutCurve: Curve?
    @JvmName("fadeoutCurveProperty")
    get() = getFadeoutCurve()
    @JvmName("fadeoutCurveProperty")
    set(`value`) {
      setFadeoutCurve(value)
    }

  /**
   * If `true`, breaks the loop at the end of the loop cycle for transition, even if the animation
   * is looping.
   */
  public final inline var breakLoopAtEnd: Boolean
    @JvmName("breakLoopAtEndProperty")
    get() = isLoopBrokenAtEnd()
    @JvmName("breakLoopAtEndProperty")
    set(`value`) {
      setBreakLoopAtEnd(value)
    }

  /**
   * If `true`, the sub-animation will abort if resumed with a reset after a prior interruption.
   */
  public final inline var abortOnReset: Boolean
    @JvmName("abortOnResetProperty")
    get() = isAbortedOnReset()
    @JvmName("abortOnResetProperty")
    set(`value`) {
      setAbortOnReset(value)
    }

  /**
   * If `true`, the sub-animation will restart automatically after finishing.
   *
   * In other words, to start auto restarting, the animation must be played once with the
   * [ONE_SHOT_REQUEST_FIRE] request. The [ONE_SHOT_REQUEST_ABORT] request stops the auto restarting,
   * but it does not disable the [autorestart] itself. So, the [ONE_SHOT_REQUEST_FIRE] request will
   * start auto restarting again.
   */
  public final inline var autorestart: Boolean
    @JvmName("autorestartProperty")
    get() = hasAutorestart()
    @JvmName("autorestartProperty")
    set(`value`) {
      setAutorestart(value)
    }

  /**
   * The delay after which the automatic restart is triggered, in seconds.
   */
  public final inline var autorestartDelay: Double
    @JvmName("autorestartDelayProperty")
    get() = getAutorestartDelay()
    @JvmName("autorestartDelayProperty")
    set(`value`) {
      setAutorestartDelay(value)
    }

  /**
   * If [autorestart] is `true`, a random additional delay (in seconds) between 0 and this value
   * will be added to [autorestartDelay].
   */
  public final inline var autorestartRandomDelay: Double
    @JvmName("autorestartRandomDelayProperty")
    get() = getAutorestartRandomDelay()
    @JvmName("autorestartRandomDelayProperty")
    set(`value`) {
      setAutorestartRandomDelay(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(25, scriptPtr)
  }

  public final fun setFadeinTime(time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.setFadeinTimePtr)
  }

  public final fun getFadeinTime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadeinTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setFadeinCurve(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setFadeinCurvePtr)
  }

  public final fun getFadeinCurve(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadeinCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setFadeoutTime(time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.setFadeoutTimePtr)
  }

  public final fun getFadeoutTime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadeoutTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setFadeoutCurve(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setFadeoutCurvePtr)
  }

  public final fun getFadeoutCurve(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadeoutCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setBreakLoopAtEnd(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setBreakLoopAtEndPtr)
  }

  public final fun isLoopBrokenAtEnd(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLoopBrokenAtEndPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAbortOnReset(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAbortOnResetPtr)
  }

  public final fun isAbortedOnReset(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAbortedOnResetPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutorestart(active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active)
    TransferContext.callMethod(MethodBindings.setAutorestartPtr)
  }

  public final fun hasAutorestart(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAutorestartPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutorestartDelay(time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.setAutorestartDelayPtr)
  }

  public final fun getAutorestartDelay(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutorestartDelayPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setAutorestartRandomDelay(time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.setAutorestartRandomDelayPtr)
  }

  public final fun getAutorestartRandomDelay(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutorestartRandomDelayPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setMixMode(mode: MixMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setMixModePtr)
  }

  public final fun getMixMode(): MixMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMixModePtr)
    return MixMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class OneShotRequest(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The default state of the request. Nothing is done.
     */
    NONE(0),
    /**
     * The request to play the animation connected to "shot" port.
     */
    FIRE(1),
    /**
     * The request to stop the animation connected to "shot" port.
     */
    ABORT(2),
    /**
     * The request to fade out the animation connected to "shot" port.
     */
    FADE_OUT(3),
    ;

    public companion object {
      public fun from(`value`: Long): OneShotRequest = entries.single { it.`value` == `value` }
    }
  }

  public enum class MixMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Blends two animations. See also [AnimationNodeBlend2].
     */
    BLEND(0),
    /**
     * Blends two animations additively. See also [AnimationNodeAdd2].
     */
    ADD(1),
    ;

    public companion object {
      public fun from(`value`: Long): MixMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFadeinTimeName: MethodStringName1<AnimationNodeOneShot, Unit, Double> =
        MethodStringName1<AnimationNodeOneShot, Unit, Double>("set_fadein_time")

    @JvmField
    public val getFadeinTimeName: MethodStringName0<AnimationNodeOneShot, Double> =
        MethodStringName0<AnimationNodeOneShot, Double>("get_fadein_time")

    @JvmField
    public val setFadeinCurveName: MethodStringName1<AnimationNodeOneShot, Unit, Curve?> =
        MethodStringName1<AnimationNodeOneShot, Unit, Curve?>("set_fadein_curve")

    @JvmField
    public val getFadeinCurveName: MethodStringName0<AnimationNodeOneShot, Curve?> =
        MethodStringName0<AnimationNodeOneShot, Curve?>("get_fadein_curve")

    @JvmField
    public val setFadeoutTimeName: MethodStringName1<AnimationNodeOneShot, Unit, Double> =
        MethodStringName1<AnimationNodeOneShot, Unit, Double>("set_fadeout_time")

    @JvmField
    public val getFadeoutTimeName: MethodStringName0<AnimationNodeOneShot, Double> =
        MethodStringName0<AnimationNodeOneShot, Double>("get_fadeout_time")

    @JvmField
    public val setFadeoutCurveName: MethodStringName1<AnimationNodeOneShot, Unit, Curve?> =
        MethodStringName1<AnimationNodeOneShot, Unit, Curve?>("set_fadeout_curve")

    @JvmField
    public val getFadeoutCurveName: MethodStringName0<AnimationNodeOneShot, Curve?> =
        MethodStringName0<AnimationNodeOneShot, Curve?>("get_fadeout_curve")

    @JvmField
    public val setBreakLoopAtEndName: MethodStringName1<AnimationNodeOneShot, Unit, Boolean> =
        MethodStringName1<AnimationNodeOneShot, Unit, Boolean>("set_break_loop_at_end")

    @JvmField
    public val isLoopBrokenAtEndName: MethodStringName0<AnimationNodeOneShot, Boolean> =
        MethodStringName0<AnimationNodeOneShot, Boolean>("is_loop_broken_at_end")

    @JvmField
    public val setAbortOnResetName: MethodStringName1<AnimationNodeOneShot, Unit, Boolean> =
        MethodStringName1<AnimationNodeOneShot, Unit, Boolean>("set_abort_on_reset")

    @JvmField
    public val isAbortedOnResetName: MethodStringName0<AnimationNodeOneShot, Boolean> =
        MethodStringName0<AnimationNodeOneShot, Boolean>("is_aborted_on_reset")

    @JvmField
    public val setAutorestartName: MethodStringName1<AnimationNodeOneShot, Unit, Boolean> =
        MethodStringName1<AnimationNodeOneShot, Unit, Boolean>("set_autorestart")

    @JvmField
    public val hasAutorestartName: MethodStringName0<AnimationNodeOneShot, Boolean> =
        MethodStringName0<AnimationNodeOneShot, Boolean>("has_autorestart")

    @JvmField
    public val setAutorestartDelayName: MethodStringName1<AnimationNodeOneShot, Unit, Double> =
        MethodStringName1<AnimationNodeOneShot, Unit, Double>("set_autorestart_delay")

    @JvmField
    public val getAutorestartDelayName: MethodStringName0<AnimationNodeOneShot, Double> =
        MethodStringName0<AnimationNodeOneShot, Double>("get_autorestart_delay")

    @JvmField
    public val setAutorestartRandomDelayName: MethodStringName1<AnimationNodeOneShot, Unit, Double>
        = MethodStringName1<AnimationNodeOneShot, Unit, Double>("set_autorestart_random_delay")

    @JvmField
    public val getAutorestartRandomDelayName: MethodStringName0<AnimationNodeOneShot, Double> =
        MethodStringName0<AnimationNodeOneShot, Double>("get_autorestart_random_delay")

    @JvmField
    public val setMixModeName: MethodStringName1<AnimationNodeOneShot, Unit, MixMode> =
        MethodStringName1<AnimationNodeOneShot, Unit, MixMode>("set_mix_mode")

    @JvmField
    public val getMixModeName: MethodStringName0<AnimationNodeOneShot, MixMode> =
        MethodStringName0<AnimationNodeOneShot, MixMode>("get_mix_mode")
  }

  public object MethodBindings {
    internal val setFadeinTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_fadein_time", 373806689)

    internal val getFadeinTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_fadein_time", 1740695150)

    internal val setFadeinCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_fadein_curve", 270443179)

    internal val getFadeinCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_fadein_curve", 2460114913)

    internal val setFadeoutTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_fadeout_time", 373806689)

    internal val getFadeoutTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_fadeout_time", 1740695150)

    internal val setFadeoutCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_fadeout_curve", 270443179)

    internal val getFadeoutCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_fadeout_curve", 2460114913)

    internal val setBreakLoopAtEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_break_loop_at_end", 2586408642)

    internal val isLoopBrokenAtEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "is_loop_broken_at_end", 36873697)

    internal val setAbortOnResetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_abort_on_reset", 2586408642)

    internal val isAbortedOnResetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "is_aborted_on_reset", 36873697)

    internal val setAutorestartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_autorestart", 2586408642)

    internal val hasAutorestartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "has_autorestart", 36873697)

    internal val setAutorestartDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_autorestart_delay", 373806689)

    internal val getAutorestartDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_autorestart_delay", 1740695150)

    internal val setAutorestartRandomDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_autorestart_random_delay", 373806689)

    internal val getAutorestartRandomDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_autorestart_random_delay", 1740695150)

    internal val setMixModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "set_mix_mode", 1018899799)

    internal val getMixModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeOneShot", "get_mix_mode", 3076550526)
  }
}
