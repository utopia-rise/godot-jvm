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
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.NodePath
import godot.core.Signal1
import godot.core.Signal2
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_DOUBLE_BOOL_BOOL
import godot.writeMethodArguments_DOUBLE_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_DOUBLE
import godot.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_BOOL
import godot.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE
import godot.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_BOOL_LONG_LONG
import godot.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE_BOOL
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_DOUBLE
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE_DOUBLE_BOOL
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * An animation player is used for general-purpose playback of animations. It contains a dictionary
 * of [AnimationLibrary] resources and custom blend times between animation transitions.
 *
 * Some methods and properties use a single key to reference an animation directly. These keys are
 * formatted as the key for the library, followed by a forward slash, then the key for the animation
 * within the library, for example `"movement/run"`. If the library's key is an empty string (known as
 * the default library), the forward slash is omitted, being the same key used by the library.
 *
 * [AnimationPlayer] is better-suited than [Tween] for more complex animations, for example ones
 * with non-trivial timings. It can also be used over [Tween] if the animation track editor is more
 * convenient than doing it in code.
 *
 * Updating the target properties of animations occurs at the process frame.
 */
@GodotBaseType
public open class AnimationPlayer : AnimationMixer() {
  /**
   * Emitted when [currentAnimation] changes.
   */
  public val currentAnimationChanged: Signal1<StringName> by Signal1

  /**
   * Emitted when a queued animation plays after the previous animation finished. See also
   * [AnimationPlayer.queue].
   *
   * **Note:** The signal is not emitted when the animation is changed via [AnimationPlayer.play] or
   * by an [AnimationTree].
   */
  public val animationChanged: Signal2<StringName, StringName> by Signal2

  /**
   * The key of the currently playing animation. If no animation is playing, the property's value is
   * an empty string. Changing this value does not restart the animation. See [play] for more
   * information on playing animations.
   *
   * **Note:** While this property appears in the Inspector, it's not meant to be edited, and it's
   * not saved in the scene. This property is mainly used to get the currently playing animation, and
   * internally for animation playback tracks. For more information, see [Animation].
   */
  public final inline var currentAnimation: StringName
    @JvmName("currentAnimationProperty")
    get() = getCurrentAnimation()
    @JvmName("currentAnimationProperty")
    set(`value`) {
      setCurrentAnimation(value)
    }

  /**
   * If playing, the current animation's key, otherwise, the animation last played. When set, this
   * changes the animation, but will not play it unless already playing. See also [currentAnimation].
   */
  public final inline var assignedAnimation: StringName
    @JvmName("assignedAnimationProperty")
    get() = getAssignedAnimation()
    @JvmName("assignedAnimationProperty")
    set(`value`) {
      setAssignedAnimation(value)
    }

  /**
   * The key of the animation to play when the scene loads.
   */
  public final inline var autoplay: StringName
    @JvmName("autoplayProperty")
    get() = getAutoplay()
    @JvmName("autoplayProperty")
    set(`value`) {
      setAutoplay(value)
    }

  /**
   * The length (in seconds) of the currently playing animation.
   */
  public final inline val currentAnimationLength: Double
    @JvmName("currentAnimationLengthProperty")
    get() = getCurrentAnimationLength()

  /**
   * The position (in seconds) of the currently playing animation.
   */
  public final inline val currentAnimationPosition: Double
    @JvmName("currentAnimationPositionProperty")
    get() = getCurrentAnimationPosition()

  /**
   * If `true`, performs [AnimationMixer.capture] before playback automatically. This means just
   * [playWithCapture] is executed with default arguments instead of [play].
   *
   * **Note:** Capture interpolation is only performed if the animation contains a capture track.
   * See also [Animation.UPDATE_CAPTURE].
   */
  public final inline var playbackAutoCapture: Boolean
    @JvmName("playbackAutoCaptureProperty")
    get() = isAutoCapture()
    @JvmName("playbackAutoCaptureProperty")
    set(`value`) {
      setAutoCapture(value)
    }

  /**
   * See also [playWithCapture] and [AnimationMixer.capture].
   *
   * If [playbackAutoCaptureDuration] is negative value, the duration is set to the interval between
   * the current position and the first key.
   */
  public final inline var playbackAutoCaptureDuration: Double
    @JvmName("playbackAutoCaptureDurationProperty")
    get() = getAutoCaptureDuration()
    @JvmName("playbackAutoCaptureDurationProperty")
    set(`value`) {
      setAutoCaptureDuration(value)
    }

  /**
   * The transition type of the capture interpolation. See also [Tween.TransitionType].
   */
  public final inline var playbackAutoCaptureTransitionType: Tween.TransitionType
    @JvmName("playbackAutoCaptureTransitionTypeProperty")
    get() = getAutoCaptureTransitionType()
    @JvmName("playbackAutoCaptureTransitionTypeProperty")
    set(`value`) {
      setAutoCaptureTransitionType(value)
    }

  /**
   * The ease type of the capture interpolation. See also [Tween.EaseType].
   */
  public final inline var playbackAutoCaptureEaseType: Tween.EaseType
    @JvmName("playbackAutoCaptureEaseTypeProperty")
    get() = getAutoCaptureEaseType()
    @JvmName("playbackAutoCaptureEaseTypeProperty")
    set(`value`) {
      setAutoCaptureEaseType(value)
    }

  /**
   * The default time in which to blend animations. Ranges from 0 to 4096 with 0.01 precision.
   */
  public final inline var playbackDefaultBlendTime: Double
    @JvmName("playbackDefaultBlendTimeProperty")
    get() = getDefaultBlendTime()
    @JvmName("playbackDefaultBlendTimeProperty")
    set(`value`) {
      setDefaultBlendTime(value)
    }

  /**
   * The speed scaling ratio. For example, if this value is `1`, then the animation plays at normal
   * speed. If it's `0.5`, then it plays at half speed. If it's `2`, then it plays at double speed.
   *
   * If set to a negative value, the animation is played in reverse. If set to `0`, the animation
   * will not advance.
   */
  public final inline var speedScale: Float
    @JvmName("speedScaleProperty")
    get() = getSpeedScale()
    @JvmName("speedScaleProperty")
    set(`value`) {
      setSpeedScale(value)
    }

  /**
   * If `true` and the engine is running in Movie Maker mode (see [MovieWriter]), exits the engine
   * with [SceneTree.quit] as soon as an animation is done playing in this [AnimationPlayer]. A message
   * is printed when the engine quits for this reason.
   *
   * **Note:** This obeys the same logic as the [signal AnimationMixer.animation_finished] signal,
   * so it will not quit the engine if the animation is set to be looping.
   */
  public final inline var movieQuitOnFinish: Boolean
    @JvmName("movieQuitOnFinishProperty")
    get() = isMovieQuitOnFinishEnabled()
    @JvmName("movieQuitOnFinishProperty")
    set(`value`) {
      setMovieQuitOnFinishEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(35, scriptPtr)
  }

  /**
   * Triggers the [animationTo] animation when the [animationFrom] animation completes.
   */
  public final fun animationSetNext(animationFrom: StringName, animationTo: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, animationFrom, animationTo)
    TransferContext.callPtrMethod(MethodBindings.animationSetNextPtr, 0)
  }

  /**
   * Returns the key of the animation which is queued to play after the [animationFrom] animation.
   */
  public final fun animationGetNext(animationFrom: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, animationFrom)
    TransferContext.callPtrMethod(MethodBindings.animationGetNextPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Specifies a blend time (in seconds) between two animations, referenced by their keys.
   */
  public final fun setBlendTime(
    animationFrom: StringName,
    animationTo: StringName,
    sec: Double,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_DOUBLE(ptr, objectID.id, animationFrom, animationTo, sec)
    TransferContext.callPtrMethod(MethodBindings.setBlendTimePtr, 0)
  }

  /**
   * Returns the blend time (in seconds) between two animations, referenced by their keys.
   */
  public final fun getBlendTime(animationFrom: StringName, animationTo: StringName): Double {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, animationFrom, animationTo)
    TransferContext.callPtrMethod(MethodBindings.getBlendTimePtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setDefaultBlendTime(sec: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, sec)
    TransferContext.callPtrMethod(MethodBindings.setDefaultBlendTimePtr, 0)
  }

  public final fun getDefaultBlendTime(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultBlendTimePtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setAutoCapture(autoCapture: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, autoCapture)
    TransferContext.callPtrMethod(MethodBindings.setAutoCapturePtr, 0)
  }

  public final fun isAutoCapture(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAutoCapturePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAutoCaptureDuration(autoCaptureDuration: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, autoCaptureDuration)
    TransferContext.callPtrMethod(MethodBindings.setAutoCaptureDurationPtr, 0)
  }

  public final fun getAutoCaptureDuration(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoCaptureDurationPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setAutoCaptureTransitionType(autoCaptureTransitionType: Tween.TransitionType):
      Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, autoCaptureTransitionType.value)
    TransferContext.callPtrMethod(MethodBindings.setAutoCaptureTransitionTypePtr, 0)
  }

  public final fun getAutoCaptureTransitionType(): Tween.TransitionType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoCaptureTransitionTypePtr, 2)
    return Tween.TransitionType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAutoCaptureEaseType(autoCaptureEaseType: Tween.EaseType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, autoCaptureEaseType.value)
    TransferContext.callPtrMethod(MethodBindings.setAutoCaptureEaseTypePtr, 0)
  }

  public final fun getAutoCaptureEaseType(): Tween.EaseType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoCaptureEaseTypePtr, 2)
    return Tween.EaseType.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Plays the animation with key [name]. Custom blend times and speed can be set.
   *
   * The [fromEnd] option only affects when switching to a new animation track, or if the same track
   * but at the start or end. It does not affect resuming playback that was paused in the middle of an
   * animation. If [customSpeed] is negative and [fromEnd] is `true`, the animation will play backwards
   * (which is equivalent to calling [playBackwards]).
   *
   * The [AnimationPlayer] keeps track of its current or last played animation with
   * [assignedAnimation]. If this method is called with that same animation [name], or with no [name]
   * parameter, the assigned animation will resume playing if it was paused.
   *
   * **Note:** The animation will be updated the next time the [AnimationPlayer] is processed. If
   * other variables are updated at the same time this is called, they may be updated too early. To
   * perform the update immediately, call `advance(0)`.
   */
  @JvmOverloads
  public final fun play(
    name: StringName = StringName(""),
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_BOOL(ptr, objectID.id, name, customBlend, customSpeed.toDouble(), fromEnd)
    TransferContext.callPtrMethod(MethodBindings.playPtr, 0)
  }

  /**
   * Plays the animation with key [name] and the section starting from [startMarker] and ending on
   * [endMarker].
   *
   * If the start marker is empty, the section starts from the beginning of the animation. If the
   * end marker is empty, the section ends on the end of the animation. See also [play].
   */
  @JvmOverloads
  public final fun playSectionWithMarkers(
    name: StringName = StringName(""),
    startMarker: StringName = StringName(""),
    endMarker: StringName = StringName(""),
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE_DOUBLE_BOOL(ptr, objectID.id, name, startMarker, endMarker, customBlend, customSpeed.toDouble(), fromEnd)
    TransferContext.callPtrMethod(MethodBindings.playSectionWithMarkersPtr, 0)
  }

  /**
   * Plays the animation with key [name] and the section starting from [startTime] and ending on
   * [endTime]. See also [play].
   *
   * Setting [startTime] to a value outside the range of the animation means the start of the
   * animation will be used instead, and setting [endTime] to a value outside the range of the
   * animation means the end of the animation will be used instead. [startTime] cannot be equal to
   * [endTime].
   */
  @JvmOverloads
  public final fun playSection(
    name: StringName = StringName(""),
    startTime: Double = -1.0,
    endTime: Double = -1.0,
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE_BOOL(ptr, objectID.id, name, startTime, endTime, customBlend, customSpeed.toDouble(), fromEnd)
    TransferContext.callPtrMethod(MethodBindings.playSectionPtr, 0)
  }

  /**
   * Plays the animation with key [name] in reverse.
   *
   * This method is a shorthand for [play] with `custom_speed = -1.0` and `from_end = true`, so see
   * its description for more information.
   */
  @JvmOverloads
  public final fun playBackwards(name: StringName = StringName(""), customBlend: Double = -1.0):
      Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE(ptr, objectID.id, name, customBlend)
    TransferContext.callPtrMethod(MethodBindings.playBackwardsPtr, 0)
  }

  /**
   * Plays the animation with key [name] and the section starting from [startMarker] and ending on
   * [endMarker] in reverse.
   *
   * This method is a shorthand for [playSectionWithMarkers] with `custom_speed = -1.0` and
   * `from_end = true`, see its description for more information.
   */
  @JvmOverloads
  public final fun playSectionWithMarkersBackwards(
    name: StringName = StringName(""),
    startMarker: StringName = StringName(""),
    endMarker: StringName = StringName(""),
    customBlend: Double = -1.0,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE(ptr, objectID.id, name, startMarker, endMarker, customBlend)
    TransferContext.callPtrMethod(MethodBindings.playSectionWithMarkersBackwardsPtr, 0)
  }

  /**
   * Plays the animation with key [name] and the section starting from [startTime] and ending on
   * [endTime] in reverse.
   *
   * This method is a shorthand for [playSection] with `custom_speed = -1.0` and `from_end = true`,
   * see its description for more information.
   */
  @JvmOverloads
  public final fun playSectionBackwards(
    name: StringName = StringName(""),
    startTime: Double = -1.0,
    endTime: Double = -1.0,
    customBlend: Double = -1.0,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, name, startTime, endTime, customBlend)
    TransferContext.callPtrMethod(MethodBindings.playSectionBackwardsPtr, 0)
  }

  /**
   * See also [AnimationMixer.capture].
   *
   * You can use this method to use more detailed options for capture than those performed by
   * [playbackAutoCapture]. When [playbackAutoCapture] is `false`, this method is almost the same as
   * the following:
   *
   * ```
   * capture(name, duration, trans_type, ease_type)
   * play(name, custom_blend, custom_speed, from_end)
   * ```
   *
   * If [name] is blank, it specifies [assignedAnimation].
   *
   * If [duration] is a negative value, the duration is set to the interval between the current
   * position and the first key, when [fromEnd] is `true`, uses the interval between the current
   * position and the last key instead.
   *
   * **Note:** The [duration] takes [speedScale] into account, but [customSpeed] does not, because
   * the capture cache is interpolated with the blend result and the result may contain multiple
   * animations.
   */
  @JvmOverloads
  public final fun playWithCapture(
    name: StringName = StringName(""),
    duration: Double = -1.0,
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
    transType: Tween.TransitionType = Tween.TransitionType.LINEAR,
    easeType: Tween.EaseType = Tween.EaseType.IN,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_BOOL_LONG_LONG(ptr, objectID.id, name, duration, customBlend, customSpeed.toDouble(), fromEnd, transType.value, easeType.value)
    TransferContext.callPtrMethod(MethodBindings.playWithCapturePtr, 0)
  }

  /**
   * Pauses the currently playing animation. The [currentAnimationPosition] will be kept and calling
   * [play] or [playBackwards] without arguments or with the same animation name as [assignedAnimation]
   * will resume the animation.
   *
   * See also [stop].
   */
  public final fun pause(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.pausePtr, 0)
  }

  /**
   * Stops the currently playing animation. The animation position is reset to `0` and the
   * `custom_speed` is reset to `1.0`. See also [pause].
   *
   * If [keepState] is `true`, the animation state is not updated visually.
   *
   * **Note:** The method / audio / animation playback tracks will not be processed by this method.
   */
  @JvmOverloads
  public final fun stop(keepState: Boolean = false): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, keepState)
    TransferContext.callPtrMethod(MethodBindings.stopPtr, 0)
  }

  /**
   * Returns `true` if an animation is currently playing (even if [speedScale] and/or `custom_speed`
   * are `0`).
   */
  public final fun isPlaying(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPlayingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the an animation is currently active. An animation is active if it was played
   * by calling [play] and was not finished yet, or was stopped by calling [stop].
   *
   * This can be used to check whether an animation is currently paused or stopped.
   *
   * ```
   * var is_paused = not is_playing() and is_animation_active()
   * var is_stopped = not is_playing() and not is_animation_active()
   * ```
   */
  public final fun isAnimationActive(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAnimationActivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCurrentAnimation(animation: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, animation)
    TransferContext.callPtrMethod(MethodBindings.setCurrentAnimationPtr, 0)
  }

  public final fun getCurrentAnimation(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCurrentAnimationPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setAssignedAnimation(animation: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, animation)
    TransferContext.callPtrMethod(MethodBindings.setAssignedAnimationPtr, 0)
  }

  public final fun getAssignedAnimation(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAssignedAnimationPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Queues an animation for playback once the current animation and all previously queued
   * animations are done.
   *
   * **Note:** If a looped animation is currently playing, the queued animation will never play
   * unless the looped animation is stopped somehow.
   */
  public final fun queue(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.queuePtr, 0)
  }

  /**
   * Returns a list of the animation keys that are currently queued to play.
   */
  public final fun getQueue(): VariantArray<StringName> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getQueuePtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<StringName>)
  }

  /**
   * Clears all queued, unplayed animations.
   */
  public final fun clearQueue(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearQueuePtr, 0)
  }

  public final fun setSpeedScale(speed: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, speed.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSpeedScalePtr, 0)
  }

  public final fun getSpeedScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSpeedScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the actual playing speed of current animation or `0` if not playing. This speed is the
   * [speedScale] property multiplied by `custom_speed` argument specified when calling the [play]
   * method.
   *
   * Returns a negative value if the current animation is playing backwards.
   */
  public final fun getPlayingSpeed(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPlayingSpeedPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAutoplay(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.setAutoplayPtr, 0)
  }

  public final fun getAutoplay(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoplayPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setMovieQuitOnFinishEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setMovieQuitOnFinishEnabledPtr, 0)
  }

  public final fun isMovieQuitOnFinishEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isMovieQuitOnFinishEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getCurrentAnimationPosition(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCurrentAnimationPositionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun getCurrentAnimationLength(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCurrentAnimationLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Changes the start and end markers of the section being played. The current playback position
   * will be clamped within the new section. See also [playSectionWithMarkers].
   *
   * If the argument is empty, the section uses the beginning or end of the animation. If both are
   * empty, it means that the section is not set.
   */
  public final fun setSectionWithMarkers(startMarker: StringName = StringName(""),
      endMarker: StringName = StringName("")): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, startMarker, endMarker)
    TransferContext.callPtrMethod(MethodBindings.setSectionWithMarkersPtr, 0)
  }

  /**
   * Changes the start and end times of the section being played. The current playback position will
   * be clamped within the new section. See also [playSection].
   */
  @JvmOverloads
  public final fun setSection(startTime: Double = -1.0, endTime: Double = -1.0): Unit {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE(ptr, objectID.id, startTime, endTime)
    TransferContext.callPtrMethod(MethodBindings.setSectionPtr, 0)
  }

  /**
   * Resets the current section. Does nothing if a section has not been set.
   */
  public final fun resetSection(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.resetSectionPtr, 0)
  }

  /**
   * Returns the start time of the section currently being played.
   */
  public final fun getSectionStartTime(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSectionStartTimePtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Returns the end time of the section currently being played.
   */
  public final fun getSectionEndTime(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSectionEndTimePtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Returns `true` if an animation is currently playing with a section.
   */
  public final fun hasSection(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasSectionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Seeks the animation to the [seconds] point in time (in seconds). If [update] is `true`, the
   * animation updates too, otherwise it updates at process time. Events between the current frame and
   * [seconds] are skipped.
   *
   * If [updateOnly] is `true`, the method / audio / animation playback tracks will not be
   * processed.
   *
   * **Note:** Seeking to the end of the animation doesn't emit [signal
   * AnimationMixer.animation_finished]. If you want to skip animation and emit the signal, use
   * [AnimationMixer.advance].
   */
  @JvmOverloads
  public final fun seek(
    seconds: Double,
    update: Boolean = false,
    updateOnly: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_DOUBLE_BOOL_BOOL(ptr, objectID.id, seconds, update, updateOnly)
    TransferContext.callPtrMethod(MethodBindings.seekPtr, 0)
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

  /**
   * Sets the call mode used for "Call Method" tracks.
   */
  public final fun setMethodCallMode(mode: AnimationMethodCallMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setMethodCallModePtr, 0)
  }

  /**
   * Returns the call mode used for "Call Method" tracks.
   */
  public final fun getMethodCallMode(): AnimationMethodCallMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMethodCallModePtr, 2)
    return AnimationMethodCallMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the node which node path references will travel from.
   */
  public final fun setRoot(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callPtrMethod(MethodBindings.setRootPtr, 0)
  }

  /**
   * Returns the node which node path references will travel from.
   */
  public final fun getRoot(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRootPtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Triggers the [animationTo] animation when the [animationFrom] animation completes.
   */
  public final fun animationSetNext(animationFrom: String, animationTo: String) =
      animationSetNext(animationFrom.asCachedStringName(), animationTo.asCachedStringName())

  /**
   * Returns the key of the animation which is queued to play after the [animationFrom] animation.
   */
  public final fun animationGetNext(animationFrom: String): StringName =
      animationGetNext(animationFrom.asCachedStringName())

  /**
   * Specifies a blend time (in seconds) between two animations, referenced by their keys.
   */
  public final fun setBlendTime(
    animationFrom: String,
    animationTo: String,
    sec: Double,
  ) = setBlendTime(animationFrom.asCachedStringName(), animationTo.asCachedStringName(), sec)

  /**
   * Returns the blend time (in seconds) between two animations, referenced by their keys.
   */
  public final fun getBlendTime(animationFrom: String, animationTo: String): Double =
      getBlendTime(animationFrom.asCachedStringName(), animationTo.asCachedStringName())

  /**
   * Plays the animation with key [name]. Custom blend times and speed can be set.
   *
   * The [fromEnd] option only affects when switching to a new animation track, or if the same track
   * but at the start or end. It does not affect resuming playback that was paused in the middle of an
   * animation. If [customSpeed] is negative and [fromEnd] is `true`, the animation will play backwards
   * (which is equivalent to calling [playBackwards]).
   *
   * The [AnimationPlayer] keeps track of its current or last played animation with
   * [assignedAnimation]. If this method is called with that same animation [name], or with no [name]
   * parameter, the assigned animation will resume playing if it was paused.
   *
   * **Note:** The animation will be updated the next time the [AnimationPlayer] is processed. If
   * other variables are updated at the same time this is called, they may be updated too early. To
   * perform the update immediately, call `advance(0)`.
   */
  @JvmOverloads
  public final fun play(
    name: String,
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ) = play(name.asCachedStringName(), customBlend, customSpeed, fromEnd)

  /**
   * Plays the animation with key [name] and the section starting from [startMarker] and ending on
   * [endMarker].
   *
   * If the start marker is empty, the section starts from the beginning of the animation. If the
   * end marker is empty, the section ends on the end of the animation. See also [play].
   */
  @JvmOverloads
  public final fun playSectionWithMarkers(
    name: String,
    startMarker: String,
    endMarker: String,
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ) =
      playSectionWithMarkers(name.asCachedStringName(), startMarker.asCachedStringName(), endMarker.asCachedStringName(), customBlend, customSpeed, fromEnd)

  /**
   * Plays the animation with key [name] and the section starting from [startTime] and ending on
   * [endTime]. See also [play].
   *
   * Setting [startTime] to a value outside the range of the animation means the start of the
   * animation will be used instead, and setting [endTime] to a value outside the range of the
   * animation means the end of the animation will be used instead. [startTime] cannot be equal to
   * [endTime].
   */
  @JvmOverloads
  public final fun playSection(
    name: String,
    startTime: Double = -1.0,
    endTime: Double = -1.0,
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ) = playSection(name.asCachedStringName(), startTime, endTime, customBlend, customSpeed, fromEnd)

  /**
   * Plays the animation with key [name] in reverse.
   *
   * This method is a shorthand for [play] with `custom_speed = -1.0` and `from_end = true`, so see
   * its description for more information.
   */
  @JvmOverloads
  public final fun playBackwards(name: String, customBlend: Double = -1.0) =
      playBackwards(name.asCachedStringName(), customBlend)

  /**
   * Plays the animation with key [name] and the section starting from [startMarker] and ending on
   * [endMarker] in reverse.
   *
   * This method is a shorthand for [playSectionWithMarkers] with `custom_speed = -1.0` and
   * `from_end = true`, see its description for more information.
   */
  @JvmOverloads
  public final fun playSectionWithMarkersBackwards(
    name: String,
    startMarker: String,
    endMarker: String,
    customBlend: Double = -1.0,
  ) =
      playSectionWithMarkersBackwards(name.asCachedStringName(), startMarker.asCachedStringName(), endMarker.asCachedStringName(), customBlend)

  /**
   * Plays the animation with key [name] and the section starting from [startTime] and ending on
   * [endTime] in reverse.
   *
   * This method is a shorthand for [playSection] with `custom_speed = -1.0` and `from_end = true`,
   * see its description for more information.
   */
  @JvmOverloads
  public final fun playSectionBackwards(
    name: String,
    startTime: Double = -1.0,
    endTime: Double = -1.0,
    customBlend: Double = -1.0,
  ) = playSectionBackwards(name.asCachedStringName(), startTime, endTime, customBlend)

  /**
   * See also [AnimationMixer.capture].
   *
   * You can use this method to use more detailed options for capture than those performed by
   * [playbackAutoCapture]. When [playbackAutoCapture] is `false`, this method is almost the same as
   * the following:
   *
   * ```
   * capture(name, duration, trans_type, ease_type)
   * play(name, custom_blend, custom_speed, from_end)
   * ```
   *
   * If [name] is blank, it specifies [assignedAnimation].
   *
   * If [duration] is a negative value, the duration is set to the interval between the current
   * position and the first key, when [fromEnd] is `true`, uses the interval between the current
   * position and the last key instead.
   *
   * **Note:** The [duration] takes [speedScale] into account, but [customSpeed] does not, because
   * the capture cache is interpolated with the blend result and the result may contain multiple
   * animations.
   */
  @JvmOverloads
  public final fun playWithCapture(
    name: String,
    duration: Double = -1.0,
    customBlend: Double = -1.0,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
    transType: Tween.TransitionType = Tween.TransitionType.LINEAR,
    easeType: Tween.EaseType = Tween.EaseType.IN,
  ) =
      playWithCapture(name.asCachedStringName(), duration, customBlend, customSpeed, fromEnd, transType, easeType)

  public final fun setCurrentAnimation(animation: String) =
      setCurrentAnimation(animation.asCachedStringName())

  public final fun setAssignedAnimation(animation: String) =
      setAssignedAnimation(animation.asCachedStringName())

  /**
   * Queues an animation for playback once the current animation and all previously queued
   * animations are done.
   *
   * **Note:** If a looped animation is currently playing, the queued animation will never play
   * unless the looped animation is stopped somehow.
   */
  public final fun queue(name: String) = queue(name.asCachedStringName())

  public final fun setAutoplay(name: String) = setAutoplay(name.asCachedStringName())

  /**
   * Changes the start and end markers of the section being played. The current playback position
   * will be clamped within the new section. See also [playSectionWithMarkers].
   *
   * If the argument is empty, the section uses the beginning or end of the animation. If both are
   * empty, it means that the section is not set.
   */
  public final fun setSectionWithMarkers(startMarker: String, endMarker: String) =
      setSectionWithMarkers(startMarker.asCachedStringName(), endMarker.asCachedStringName())

  /**
   * Sets the node which node path references will travel from.
   */
  public final fun setRoot(path: String) = setRoot(path.asCachedNodePath())

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

  public enum class AnimationMethodCallMode(
    public override val `value`: Long,
  ) : GodotEnum {
    DEFERRED(0),
    IMMEDIATE(1),
    ;

    public companion object {
      public fun from(`value`: Long): AnimationMethodCallMode =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val animationSetNextName:
        MethodStringName2<AnimationPlayer, Unit, StringName, StringName> =
        MethodStringName2<AnimationPlayer, Unit, StringName, StringName>("animation_set_next")

    @JvmField
    public val animationGetNextName: MethodStringName1<AnimationPlayer, StringName, StringName> =
        MethodStringName1<AnimationPlayer, StringName, StringName>("animation_get_next")

    @JvmField
    public val setBlendTimeName:
        MethodStringName3<AnimationPlayer, Unit, StringName, StringName, Double> =
        MethodStringName3<AnimationPlayer, Unit, StringName, StringName, Double>("set_blend_time")

    @JvmField
    public val getBlendTimeName: MethodStringName2<AnimationPlayer, Double, StringName, StringName>
        = MethodStringName2<AnimationPlayer, Double, StringName, StringName>("get_blend_time")

    @JvmField
    public val setDefaultBlendTimeName: MethodStringName1<AnimationPlayer, Unit, Double> =
        MethodStringName1<AnimationPlayer, Unit, Double>("set_default_blend_time")

    @JvmField
    public val getDefaultBlendTimeName: MethodStringName0<AnimationPlayer, Double> =
        MethodStringName0<AnimationPlayer, Double>("get_default_blend_time")

    @JvmField
    public val setAutoCaptureName: MethodStringName1<AnimationPlayer, Unit, Boolean> =
        MethodStringName1<AnimationPlayer, Unit, Boolean>("set_auto_capture")

    @JvmField
    public val isAutoCaptureName: MethodStringName0<AnimationPlayer, Boolean> =
        MethodStringName0<AnimationPlayer, Boolean>("is_auto_capture")

    @JvmField
    public val setAutoCaptureDurationName: MethodStringName1<AnimationPlayer, Unit, Double> =
        MethodStringName1<AnimationPlayer, Unit, Double>("set_auto_capture_duration")

    @JvmField
    public val getAutoCaptureDurationName: MethodStringName0<AnimationPlayer, Double> =
        MethodStringName0<AnimationPlayer, Double>("get_auto_capture_duration")

    @JvmField
    public val setAutoCaptureTransitionTypeName:
        MethodStringName1<AnimationPlayer, Unit, Tween.TransitionType> =
        MethodStringName1<AnimationPlayer, Unit, Tween.TransitionType>("set_auto_capture_transition_type")

    @JvmField
    public val getAutoCaptureTransitionTypeName:
        MethodStringName0<AnimationPlayer, Tween.TransitionType> =
        MethodStringName0<AnimationPlayer, Tween.TransitionType>("get_auto_capture_transition_type")

    @JvmField
    public val setAutoCaptureEaseTypeName: MethodStringName1<AnimationPlayer, Unit, Tween.EaseType>
        = MethodStringName1<AnimationPlayer, Unit, Tween.EaseType>("set_auto_capture_ease_type")

    @JvmField
    public val getAutoCaptureEaseTypeName: MethodStringName0<AnimationPlayer, Tween.EaseType> =
        MethodStringName0<AnimationPlayer, Tween.EaseType>("get_auto_capture_ease_type")

    @JvmField
    public val playName:
        MethodStringName4<AnimationPlayer, Unit, StringName, Double, Float, Boolean> =
        MethodStringName4<AnimationPlayer, Unit, StringName, Double, Float, Boolean>("play")

    @JvmField
    public val playSectionWithMarkersName:
        MethodStringName6<AnimationPlayer, Unit, StringName, StringName, StringName, Double, Float, Boolean>
        =
        MethodStringName6<AnimationPlayer, Unit, StringName, StringName, StringName, Double, Float, Boolean>("play_section_with_markers")

    @JvmField
    public val playSectionName:
        MethodStringName6<AnimationPlayer, Unit, StringName, Double, Double, Double, Float, Boolean>
        =
        MethodStringName6<AnimationPlayer, Unit, StringName, Double, Double, Double, Float, Boolean>("play_section")

    @JvmField
    public val playBackwardsName: MethodStringName2<AnimationPlayer, Unit, StringName, Double> =
        MethodStringName2<AnimationPlayer, Unit, StringName, Double>("play_backwards")

    @JvmField
    public val playSectionWithMarkersBackwardsName:
        MethodStringName4<AnimationPlayer, Unit, StringName, StringName, StringName, Double> =
        MethodStringName4<AnimationPlayer, Unit, StringName, StringName, StringName, Double>("play_section_with_markers_backwards")

    @JvmField
    public val playSectionBackwardsName:
        MethodStringName4<AnimationPlayer, Unit, StringName, Double, Double, Double> =
        MethodStringName4<AnimationPlayer, Unit, StringName, Double, Double, Double>("play_section_backwards")

    @JvmField
    public val playWithCaptureName:
        MethodStringName7<AnimationPlayer, Unit, StringName, Double, Double, Float, Boolean, Tween.TransitionType, Tween.EaseType>
        =
        MethodStringName7<AnimationPlayer, Unit, StringName, Double, Double, Float, Boolean, Tween.TransitionType, Tween.EaseType>("play_with_capture")

    @JvmField
    public val pauseName: MethodStringName0<AnimationPlayer, Unit> =
        MethodStringName0<AnimationPlayer, Unit>("pause")

    @JvmField
    public val stopName: MethodStringName1<AnimationPlayer, Unit, Boolean> =
        MethodStringName1<AnimationPlayer, Unit, Boolean>("stop")

    @JvmField
    public val isPlayingName: MethodStringName0<AnimationPlayer, Boolean> =
        MethodStringName0<AnimationPlayer, Boolean>("is_playing")

    @JvmField
    public val isAnimationActiveName: MethodStringName0<AnimationPlayer, Boolean> =
        MethodStringName0<AnimationPlayer, Boolean>("is_animation_active")

    @JvmField
    public val setCurrentAnimationName: MethodStringName1<AnimationPlayer, Unit, StringName> =
        MethodStringName1<AnimationPlayer, Unit, StringName>("set_current_animation")

    @JvmField
    public val getCurrentAnimationName: MethodStringName0<AnimationPlayer, StringName> =
        MethodStringName0<AnimationPlayer, StringName>("get_current_animation")

    @JvmField
    public val setAssignedAnimationName: MethodStringName1<AnimationPlayer, Unit, StringName> =
        MethodStringName1<AnimationPlayer, Unit, StringName>("set_assigned_animation")

    @JvmField
    public val getAssignedAnimationName: MethodStringName0<AnimationPlayer, StringName> =
        MethodStringName0<AnimationPlayer, StringName>("get_assigned_animation")

    @JvmField
    public val queueName: MethodStringName1<AnimationPlayer, Unit, StringName> =
        MethodStringName1<AnimationPlayer, Unit, StringName>("queue")

    @JvmField
    public val getQueueName: MethodStringName0<AnimationPlayer, VariantArray<StringName>> =
        MethodStringName0<AnimationPlayer, VariantArray<StringName>>("get_queue")

    @JvmField
    public val clearQueueName: MethodStringName0<AnimationPlayer, Unit> =
        MethodStringName0<AnimationPlayer, Unit>("clear_queue")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<AnimationPlayer, Unit, Float> =
        MethodStringName1<AnimationPlayer, Unit, Float>("set_speed_scale")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<AnimationPlayer, Float> =
        MethodStringName0<AnimationPlayer, Float>("get_speed_scale")

    @JvmField
    public val getPlayingSpeedName: MethodStringName0<AnimationPlayer, Float> =
        MethodStringName0<AnimationPlayer, Float>("get_playing_speed")

    @JvmField
    public val setAutoplayName: MethodStringName1<AnimationPlayer, Unit, StringName> =
        MethodStringName1<AnimationPlayer, Unit, StringName>("set_autoplay")

    @JvmField
    public val getAutoplayName: MethodStringName0<AnimationPlayer, StringName> =
        MethodStringName0<AnimationPlayer, StringName>("get_autoplay")

    @JvmField
    public val setMovieQuitOnFinishEnabledName: MethodStringName1<AnimationPlayer, Unit, Boolean> =
        MethodStringName1<AnimationPlayer, Unit, Boolean>("set_movie_quit_on_finish_enabled")

    @JvmField
    public val isMovieQuitOnFinishEnabledName: MethodStringName0<AnimationPlayer, Boolean> =
        MethodStringName0<AnimationPlayer, Boolean>("is_movie_quit_on_finish_enabled")

    @JvmField
    public val getCurrentAnimationPositionName: MethodStringName0<AnimationPlayer, Double> =
        MethodStringName0<AnimationPlayer, Double>("get_current_animation_position")

    @JvmField
    public val getCurrentAnimationLengthName: MethodStringName0<AnimationPlayer, Double> =
        MethodStringName0<AnimationPlayer, Double>("get_current_animation_length")

    @JvmField
    public val setSectionWithMarkersName:
        MethodStringName2<AnimationPlayer, Unit, StringName, StringName> =
        MethodStringName2<AnimationPlayer, Unit, StringName, StringName>("set_section_with_markers")

    @JvmField
    public val setSectionName: MethodStringName2<AnimationPlayer, Unit, Double, Double> =
        MethodStringName2<AnimationPlayer, Unit, Double, Double>("set_section")

    @JvmField
    public val resetSectionName: MethodStringName0<AnimationPlayer, Unit> =
        MethodStringName0<AnimationPlayer, Unit>("reset_section")

    @JvmField
    public val getSectionStartTimeName: MethodStringName0<AnimationPlayer, Double> =
        MethodStringName0<AnimationPlayer, Double>("get_section_start_time")

    @JvmField
    public val getSectionEndTimeName: MethodStringName0<AnimationPlayer, Double> =
        MethodStringName0<AnimationPlayer, Double>("get_section_end_time")

    @JvmField
    public val hasSectionName: MethodStringName0<AnimationPlayer, Boolean> =
        MethodStringName0<AnimationPlayer, Boolean>("has_section")

    @JvmField
    public val seekName: MethodStringName3<AnimationPlayer, Unit, Double, Boolean, Boolean> =
        MethodStringName3<AnimationPlayer, Unit, Double, Boolean, Boolean>("seek")

    @JvmField
    public val setProcessCallbackName:
        MethodStringName1<AnimationPlayer, Unit, AnimationProcessCallback> =
        MethodStringName1<AnimationPlayer, Unit, AnimationProcessCallback>("set_process_callback")

    @JvmField
    public val getProcessCallbackName: MethodStringName0<AnimationPlayer, AnimationProcessCallback>
        = MethodStringName0<AnimationPlayer, AnimationProcessCallback>("get_process_callback")

    @JvmField
    public val setMethodCallModeName:
        MethodStringName1<AnimationPlayer, Unit, AnimationMethodCallMode> =
        MethodStringName1<AnimationPlayer, Unit, AnimationMethodCallMode>("set_method_call_mode")

    @JvmField
    public val getMethodCallModeName: MethodStringName0<AnimationPlayer, AnimationMethodCallMode> =
        MethodStringName0<AnimationPlayer, AnimationMethodCallMode>("get_method_call_mode")

    @JvmField
    public val setRootName: MethodStringName1<AnimationPlayer, Unit, NodePath> =
        MethodStringName1<AnimationPlayer, Unit, NodePath>("set_root")

    @JvmField
    public val getRootName: MethodStringName0<AnimationPlayer, NodePath> =
        MethodStringName0<AnimationPlayer, NodePath>("get_root")
  }

  public object MethodBindings {
    internal val animationSetNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "animation_set_next", 3740211285)

    internal val animationGetNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "animation_get_next", 1965194235)

    internal val setBlendTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_blend_time", 3231131886)

    internal val getBlendTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_blend_time", 1958752504)

    internal val setDefaultBlendTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_default_blend_time", 373806689)

    internal val getDefaultBlendTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_default_blend_time", 1740695150)

    internal val setAutoCapturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_auto_capture", 2586408642)

    internal val isAutoCapturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "is_auto_capture", 36873697)

    internal val setAutoCaptureDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_auto_capture_duration", 373806689)

    internal val getAutoCaptureDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_auto_capture_duration", 1740695150)

    internal val setAutoCaptureTransitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_auto_capture_transition_type", 1058637742)

    internal val getAutoCaptureTransitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_auto_capture_transition_type", 3842314528)

    internal val setAutoCaptureEaseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_auto_capture_ease_type", 1208105857)

    internal val getAutoCaptureEaseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_auto_capture_ease_type", 631880200)

    internal val playPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play", 3118260607)

    internal val playSectionWithMarkersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play_section_with_markers", 1421431412)

    internal val playSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play_section", 284774635)

    internal val playBackwardsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play_backwards", 2787282401)

    internal val playSectionWithMarkersBackwardsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play_section_with_markers_backwards", 910195100)

    internal val playSectionBackwardsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play_section_backwards", 831955981)

    internal val playWithCapturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "play_with_capture", 1572969103)

    internal val pausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "pause", 3218959716)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "stop", 107499316)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "is_playing", 36873697)

    internal val isAnimationActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "is_animation_active", 36873697)

    internal val setCurrentAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_current_animation", 3304788590)

    internal val getCurrentAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_current_animation", 2002593661)

    internal val setAssignedAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_assigned_animation", 3304788590)

    internal val getAssignedAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_assigned_animation", 2002593661)

    internal val queuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "queue", 3304788590)

    internal val getQueuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_queue", 2915620761)

    internal val clearQueuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "clear_queue", 3218959716)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_speed_scale", 373806689)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_speed_scale", 1740695150)

    internal val getPlayingSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_playing_speed", 1740695150)

    internal val setAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_autoplay", 3304788590)

    internal val getAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_autoplay", 2002593661)

    internal val setMovieQuitOnFinishEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_movie_quit_on_finish_enabled", 2586408642)

    internal val isMovieQuitOnFinishEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "is_movie_quit_on_finish_enabled", 36873697)

    internal val getCurrentAnimationPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_current_animation_position", 1740695150)

    internal val getCurrentAnimationLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_current_animation_length", 1740695150)

    internal val setSectionWithMarkersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_section_with_markers", 794792241)

    internal val setSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_section", 3749779719)

    internal val resetSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "reset_section", 3218959716)

    internal val getSectionStartTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_section_start_time", 1740695150)

    internal val getSectionEndTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_section_end_time", 1740695150)

    internal val hasSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "has_section", 36873697)

    internal val seekPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "seek", 1807872683)

    internal val setProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_process_callback", 1663839457)

    internal val getProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_process_callback", 4207496604)

    internal val setMethodCallModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_method_call_mode", 3413514846)

    internal val getMethodCallModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_method_call_mode", 3583380054)

    internal val setRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "set_root", 1348162250)

    internal val getRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationPlayer", "get_root", 4075236667)
  }
}
