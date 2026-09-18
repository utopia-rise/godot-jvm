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
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING_NAME
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A resource to add to an [AnimationNodeBlendTree]. Only has one output port using the [animation]
 * property. Used as an input for [AnimationNode]s that blend animations together.
 */
@GodotBaseType
public open class AnimationNodeAnimation : AnimationRootNode() {
  /**
   * Animation to use as an output. It is one of the animations provided by
   * [AnimationTree.animPlayer].
   */
  public final inline var animation: StringName
    @JvmName("animationProperty")
    get() = getAnimation()
    @JvmName("animationProperty")
    set(`value`) {
      setAnimation(value)
    }

  /**
   * Determines the playback direction of the animation.
   */
  public final inline var playMode: PlayMode
    @JvmName("playModeProperty")
    get() = getPlayMode()
    @JvmName("playModeProperty")
    set(`value`) {
      setPlayMode(value)
    }

  /**
   * If `true`, on receiving a request to play an animation from the start, the first frame is not
   * drawn, but only processed, and playback starts from the next frame.
   *
   * See also the notes of [AnimationPlayer.play].
   */
  public final inline var advanceOnStart: Boolean
    @JvmName("advanceOnStartProperty")
    get() = isAdvanceOnStart()
    @JvmName("advanceOnStartProperty")
    set(`value`) {
      setAdvanceOnStart(value)
    }

  /**
   * If `true`, [AnimationNode] provides an animation based on the [Animation] resource with some
   * parameters adjusted.
   */
  public final inline var useCustomTimeline: Boolean
    @JvmName("useCustomTimelineProperty")
    get() = isUsingCustomTimeline()
    @JvmName("useCustomTimelineProperty")
    set(`value`) {
      setUseCustomTimeline(value)
    }

  /**
   * The length of the custom timeline.
   *
   * If [stretchTimeScale] is `true`, scales the animation to this length.
   */
  public final inline var timelineLength: Double
    @JvmName("timelineLengthProperty")
    get() = getTimelineLength()
    @JvmName("timelineLengthProperty")
    set(`value`) {
      setTimelineLength(value)
    }

  /**
   * If `true`, scales the time so that the length specified in [timelineLength] is one cycle.
   *
   * This is useful for matching the periods of walking and running animations.
   *
   * If `false`, the original animation length is respected. If you set the loop to [loopMode], the
   * animation will loop in [timelineLength].
   */
  public final inline var stretchTimeScale: Boolean
    @JvmName("stretchTimeScaleProperty")
    get() = isStretchingTimeScale()
    @JvmName("stretchTimeScaleProperty")
    set(`value`) {
      setStretchTimeScale(value)
    }

  /**
   * If [useCustomTimeline] is `true`, offset the start position of the animation.
   *
   * This is useful for adjusting which foot steps first in 3D walking animations.
   */
  public final inline var startOffset: Double
    @JvmName("startOffsetProperty")
    get() = getStartOffset()
    @JvmName("startOffsetProperty")
    set(`value`) {
      setStartOffset(value)
    }

  /**
   * If [useCustomTimeline] is `true`, override the loop settings of the original [Animation]
   * resource with the value.
   *
   * **Note:** If the [Animation.loopMode] isn't set to looping, the
   * [Animation.trackSetInterpolationLoopWrap] option will not be respected. If you cannot get the
   * expected behavior, consider duplicating the [Animation] resource and changing the loop settings.
   */
  public final inline var loopMode: Animation.LoopMode
    @JvmName("loopModeProperty")
    get() = getLoopMode()
    @JvmName("loopModeProperty")
    set(`value`) {
      setLoopMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(18, scriptPtr)
  }

  public final fun setAnimation(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.setAnimationPtr, 0)
  }

  public final fun getAnimation(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAnimationPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setPlayMode(mode: PlayMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setPlayModePtr, 0)
  }

  public final fun getPlayMode(): PlayMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPlayModePtr, 2)
    return PlayMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAdvanceOnStart(advanceOnStart: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, advanceOnStart)
    TransferContext.callPtrMethod(MethodBindings.setAdvanceOnStartPtr, 0)
  }

  public final fun isAdvanceOnStart(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAdvanceOnStartPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setUseCustomTimeline(useCustomTimeline: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, useCustomTimeline)
    TransferContext.callPtrMethod(MethodBindings.setUseCustomTimelinePtr, 0)
  }

  public final fun isUsingCustomTimeline(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isUsingCustomTimelinePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTimelineLength(timelineLength: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, timelineLength)
    TransferContext.callPtrMethod(MethodBindings.setTimelineLengthPtr, 0)
  }

  public final fun getTimelineLength(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTimelineLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setStretchTimeScale(stretchTimeScale: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, stretchTimeScale)
    TransferContext.callPtrMethod(MethodBindings.setStretchTimeScalePtr, 0)
  }

  public final fun isStretchingTimeScale(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isStretchingTimeScalePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setStartOffset(startOffset: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, startOffset)
    TransferContext.callPtrMethod(MethodBindings.setStartOffsetPtr, 0)
  }

  public final fun getStartOffset(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStartOffsetPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setLoopMode(loopMode: Animation.LoopMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, loopMode.value)
    TransferContext.callPtrMethod(MethodBindings.setLoopModePtr, 0)
  }

  public final fun getLoopMode(): Animation.LoopMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLoopModePtr, 2)
    return Animation.LoopMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAnimation(name: String) = setAnimation(name.asCachedStringName())

  public enum class PlayMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Plays animation in forward direction.
     */
    FORWARD(0),
    /**
     * Plays animation in backward direction.
     */
    BACKWARD(1),
    ;

    public companion object {
      public fun from(`value`: Long): PlayMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setAnimationName: MethodStringName1<AnimationNodeAnimation, Unit, StringName> =
        MethodStringName1<AnimationNodeAnimation, Unit, StringName>("set_animation")

    @JvmField
    public val getAnimationName: MethodStringName0<AnimationNodeAnimation, StringName> =
        MethodStringName0<AnimationNodeAnimation, StringName>("get_animation")

    @JvmField
    public val setPlayModeName: MethodStringName1<AnimationNodeAnimation, Unit, PlayMode> =
        MethodStringName1<AnimationNodeAnimation, Unit, PlayMode>("set_play_mode")

    @JvmField
    public val getPlayModeName: MethodStringName0<AnimationNodeAnimation, PlayMode> =
        MethodStringName0<AnimationNodeAnimation, PlayMode>("get_play_mode")

    @JvmField
    public val setAdvanceOnStartName: MethodStringName1<AnimationNodeAnimation, Unit, Boolean> =
        MethodStringName1<AnimationNodeAnimation, Unit, Boolean>("set_advance_on_start")

    @JvmField
    public val isAdvanceOnStartName: MethodStringName0<AnimationNodeAnimation, Boolean> =
        MethodStringName0<AnimationNodeAnimation, Boolean>("is_advance_on_start")

    @JvmField
    public val setUseCustomTimelineName: MethodStringName1<AnimationNodeAnimation, Unit, Boolean> =
        MethodStringName1<AnimationNodeAnimation, Unit, Boolean>("set_use_custom_timeline")

    @JvmField
    public val isUsingCustomTimelineName: MethodStringName0<AnimationNodeAnimation, Boolean> =
        MethodStringName0<AnimationNodeAnimation, Boolean>("is_using_custom_timeline")

    @JvmField
    public val setTimelineLengthName: MethodStringName1<AnimationNodeAnimation, Unit, Double> =
        MethodStringName1<AnimationNodeAnimation, Unit, Double>("set_timeline_length")

    @JvmField
    public val getTimelineLengthName: MethodStringName0<AnimationNodeAnimation, Double> =
        MethodStringName0<AnimationNodeAnimation, Double>("get_timeline_length")

    @JvmField
    public val setStretchTimeScaleName: MethodStringName1<AnimationNodeAnimation, Unit, Boolean> =
        MethodStringName1<AnimationNodeAnimation, Unit, Boolean>("set_stretch_time_scale")

    @JvmField
    public val isStretchingTimeScaleName: MethodStringName0<AnimationNodeAnimation, Boolean> =
        MethodStringName0<AnimationNodeAnimation, Boolean>("is_stretching_time_scale")

    @JvmField
    public val setStartOffsetName: MethodStringName1<AnimationNodeAnimation, Unit, Double> =
        MethodStringName1<AnimationNodeAnimation, Unit, Double>("set_start_offset")

    @JvmField
    public val getStartOffsetName: MethodStringName0<AnimationNodeAnimation, Double> =
        MethodStringName0<AnimationNodeAnimation, Double>("get_start_offset")

    @JvmField
    public val setLoopModeName: MethodStringName1<AnimationNodeAnimation, Unit, Animation.LoopMode>
        = MethodStringName1<AnimationNodeAnimation, Unit, Animation.LoopMode>("set_loop_mode")

    @JvmField
    public val getLoopModeName: MethodStringName0<AnimationNodeAnimation, Animation.LoopMode> =
        MethodStringName0<AnimationNodeAnimation, Animation.LoopMode>("get_loop_mode")
  }

  public object MethodBindings {
    internal val setAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_animation", 3304788590)

    internal val getAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "get_animation", 2002593661)

    internal val setPlayModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_play_mode", 3347718873)

    internal val getPlayModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "get_play_mode", 2061244637)

    internal val setAdvanceOnStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_advance_on_start", 2586408642)

    internal val isAdvanceOnStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "is_advance_on_start", 36873697)

    internal val setUseCustomTimelinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_use_custom_timeline", 2586408642)

    internal val isUsingCustomTimelinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "is_using_custom_timeline", 36873697)

    internal val setTimelineLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_timeline_length", 373806689)

    internal val getTimelineLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "get_timeline_length", 1740695150)

    internal val setStretchTimeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_stretch_time_scale", 2586408642)

    internal val isStretchingTimeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "is_stretching_time_scale", 36873697)

    internal val setStartOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_start_offset", 373806689)

    internal val getStartOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "get_start_offset", 1740695150)

    internal val setLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "set_loop_mode", 3155355575)

    internal val getLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeAnimation", "get_loop_mode", 1988889481)
  }
}
