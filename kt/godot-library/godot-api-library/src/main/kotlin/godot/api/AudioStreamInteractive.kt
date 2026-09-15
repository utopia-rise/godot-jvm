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
import godot.core.MethodStringName9
import godot.core.PackedInt32Array
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_INT_32_ARRAY
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_LONG_LONG_LONG_DOUBLE_BOOL_LONG_BOOL
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_LONG_STRING_NAME
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This is an audio stream that can playback music interactively, combining clips and a transition
 * table. Clips must be added first, and then the transition rules via the [addTransition].
 * Additionally, this stream exports a property parameter to control the playback via
 * [AudioStreamPlayer], [AudioStreamPlayer2D], or [AudioStreamPlayer3D].
 *
 * The way this is used is by filling a number of clips, then configuring the transition table. From
 * there, clips are selected for playback and the music will smoothly go from the current to the new
 * one while using the corresponding transition rule defined in the transition table.
 */
@GodotBaseType
public open class AudioStreamInteractive : AudioStream() {
  /**
   * Amount of clips contained in this interactive player.
   */
  public final inline var clipCount: Int
    @JvmName("clipCountProperty")
    get() = getClipCount()
    @JvmName("clipCountProperty")
    set(`value`) {
      setClipCount(value)
    }

  /**
   * Index of the initial clip, which will be played first when this stream is played.
   */
  public final inline var initialClip: Int
    @JvmName("initialClipProperty")
    get() = getInitialClip()
    @JvmName("initialClipProperty")
    set(`value`) {
      setInitialClip(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(84, scriptPtr)
  }

  public final fun setClipCount(clipCount: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipCount.toLong())
    TransferContext.callPtrMethod(MethodBindings.setClipCountPtr, 0)
  }

  public final fun getClipCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getClipCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setInitialClip(clipIndex: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.setInitialClipPtr, 0)
  }

  public final fun getInitialClip(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInitialClipPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Set the name of the current clip (for easier identification).
   */
  public final fun setClipName(clipIndex: Int, name: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, clipIndex.toLong(), name)
    TransferContext.callPtrMethod(MethodBindings.setClipNamePtr, 0)
  }

  /**
   * Return the name of a clip.
   */
  public final fun getClipName(clipIndex: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipIndex.toLong())
    TransferContext.callMethod(MethodBindings.getClipNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Set the [AudioStream] associated with the current clip.
   */
  public final fun setClipStream(clipIndex: Int, stream: AudioStream?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, clipIndex.toLong(), stream)
    TransferContext.callPtrMethod(MethodBindings.setClipStreamPtr, 0)
  }

  /**
   * Return the [AudioStream] associated with a clip.
   */
  public final fun getClipStream(clipIndex: Int): AudioStream? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.getClipStreamPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AudioStream?)
  }

  /**
   * Set whether a clip will auto-advance by changing the auto-advance mode.
   */
  public final fun setClipAutoAdvance(clipIndex: Int, mode: AutoAdvanceMode): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, clipIndex.toLong(), mode.value)
    TransferContext.callPtrMethod(MethodBindings.setClipAutoAdvancePtr, 0)
  }

  /**
   * Return whether a clip has auto-advance enabled. See [setClipAutoAdvance].
   */
  public final fun getClipAutoAdvance(clipIndex: Int): AutoAdvanceMode {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.getClipAutoAdvancePtr, 2)
    return AutoAdvanceMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Set the index of the next clip towards which this clip will auto advance to when finished. If
   * the clip being played loops, then auto-advance will be ignored.
   */
  public final fun setClipAutoAdvanceNextClip(clipIndex: Int, autoAdvanceNextClip: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, clipIndex.toLong(), autoAdvanceNextClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.setClipAutoAdvanceNextClipPtr, 0)
  }

  /**
   * Return the clip towards which the clip referenced by [clipIndex] will auto-advance to.
   */
  public final fun getClipAutoAdvanceNextClip(clipIndex: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.getClipAutoAdvanceNextClipPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Add a transition between two clips. Provide the indices of the source and destination clips, or
   * use the [CLIP_ANY] constant to indicate that transition happens to/from any clip to this one.
   *
   * * [fromTime] indicates the moment in the current clip the transition will begin after
   * triggered.
   *
   * * [toTime] indicates the time in the next clip that the playback will start from.
   *
   * * [fadeMode] indicates how the fade will happen between clips. If unsure, just use
   * [FADE_AUTOMATIC] which uses the most common type of fade for each situation.
   *
   * * [fadeBeats] indicates how many beats the fade will take. Using decimals is allowed.
   *
   * * [useFillerClip] indicates that there will be a filler clip used between the source and
   * destination clips.
   *
   * * [fillerClip] the index of the filler clip.
   *
   * * If [holdPrevious] is used, then this clip will be remembered. This can be used together with
   * [AUTO_ADVANCE_RETURN_TO_HOLD] to return to this clip after another is done playing.
   */
  @JvmOverloads
  public final fun addTransition(
    fromClip: Int,
    toClip: Int,
    fromTime: TransitionFromTime,
    toTime: TransitionToTime,
    fadeMode: FadeMode,
    fadeBeats: Float,
    useFillerClip: Boolean = false,
    fillerClip: Int = -1,
    holdPrevious: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG_DOUBLE_BOOL_LONG_BOOL(ptr, objectID.id, fromClip.toLong(), toClip.toLong(), fromTime.value, toTime.value, fadeMode.value, fadeBeats.toDouble(), useFillerClip, fillerClip.toLong(), holdPrevious)
    TransferContext.callPtrMethod(MethodBindings.addTransitionPtr, 0)
  }

  /**
   * Returns `true` if a given transition exists (was added via [addTransition]).
   */
  public final fun hasTransition(fromClip: Int, toClip: Int): Boolean {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.hasTransitionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Erase a transition by providing [fromClip] and [toClip] clip indices. [CLIP_ANY] can be used
   * for either argument or both.
   */
  public final fun eraseTransition(fromClip: Int, toClip: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.eraseTransitionPtr, 0)
  }

  /**
   * Return the list of transitions (from, to interleaved).
   */
  public final fun getTransitionList(): PackedInt32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransitionListPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  /**
   * Return the source time position for a transition (see [addTransition]).
   */
  public final fun getTransitionFromTime(fromClip: Int, toClip: Int): TransitionFromTime {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTransitionFromTimePtr, 2)
    return TransitionFromTime.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Return the destination time position for a transition (see [addTransition]).
   */
  public final fun getTransitionToTime(fromClip: Int, toClip: Int): TransitionToTime {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTransitionToTimePtr, 2)
    return TransitionToTime.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Return the mode for a transition (see [addTransition]).
   */
  public final fun getTransitionFadeMode(fromClip: Int, toClip: Int): FadeMode {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTransitionFadeModePtr, 2)
    return FadeMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Return the time (in beats) for a transition (see [addTransition]).
   */
  public final fun getTransitionFadeBeats(fromClip: Int, toClip: Int): Float {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTransitionFadeBeatsPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Return whether a transition uses the *filler clip* functionality (see [addTransition]).
   */
  public final fun isTransitionUsingFillerClip(fromClip: Int, toClip: Int): Boolean {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.isTransitionUsingFillerClipPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Return the filler clip for a transition (see [addTransition]).
   */
  public final fun getTransitionFillerClip(fromClip: Int, toClip: Int): Int {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTransitionFillerClipPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Return whether a transition uses the *hold previous* functionality (see [addTransition]).
   */
  public final fun isTransitionHoldingPrevious(fromClip: Int, toClip: Int): Boolean {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromClip.toLong(), toClip.toLong())
    TransferContext.callPtrMethod(MethodBindings.isTransitionHoldingPreviousPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamInteractive::_instantiatePlayback can't be called from the JVM.")
  }

  /**
   * Set the name of the current clip (for easier identification).
   */
  public final fun setClipName(clipIndex: Int, name: String) =
      setClipName(clipIndex, name.asCachedStringName())

  public enum class TransitionFromTime(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Start transition as soon as possible, don't wait for any specific time position.
     */
    IMMEDIATE(0),
    /**
     * Transition when the clip playback position reaches the next beat.
     */
    NEXT_BEAT(1),
    /**
     * Transition when the clip playback position reaches the next bar.
     */
    NEXT_BAR(2),
    /**
     * Transition when the current clip finished playing.
     */
    END(3),
    ;

    public companion object {
      public fun from(`value`: Long): TransitionFromTime = entries.single { it.`value` == `value` }
    }
  }

  public enum class TransitionToTime(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Transition to the same position in the destination clip. This is useful when both clips have
     * exactly the same length and the music should fade between them.
     */
    SAME_POSITION(0),
    /**
     * Transition to the start of the destination clip.
     */
    START(1),
    /**
     * Transition to the last played position in the destination clip, if there was a previous
     * transition from that clip. Otherwise, plays from the start of the destination clip.
     */
    PREVIOUS_POSITION(2),
    ;

    public companion object {
      public fun from(`value`: Long): TransitionToTime = entries.single { it.`value` == `value` }
    }
  }

  public enum class FadeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not use fade for the transition. This is useful when transitioning from a clip-end to
     * clip-beginning, and each clip has their begin/end.
     */
    DISABLED(0),
    /**
     * Use a fade-in in the next clip, let the current clip finish.
     */
    IN(1),
    /**
     * Use a fade-out in the current clip, the next clip will start by itself.
     */
    OUT(2),
    /**
     * Use a cross-fade between clips.
     */
    CROSS(3),
    /**
     * Use automatic fade logic depending on the transition from/to. It is recommended to use this
     * by default.
     */
    AUTOMATIC(4),
    ;

    public companion object {
      public fun from(`value`: Long): FadeMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class AutoAdvanceMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disable auto-advance (default).
     */
    DISABLED(0),
    /**
     * Enable auto-advance, a clip must be specified.
     */
    ENABLED(1),
    /**
     * Enable auto-advance, but instead of specifying a clip, the playback will return to hold (see
     * [addTransition]).
     */
    RETURN_TO_HOLD(2),
    ;

    public companion object {
      public fun from(`value`: Long): AutoAdvanceMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setClipCountName: MethodStringName1<AudioStreamInteractive, Unit, Int> =
        MethodStringName1<AudioStreamInteractive, Unit, Int>("set_clip_count")

    @JvmField
    public val getClipCountName: MethodStringName0<AudioStreamInteractive, Int> =
        MethodStringName0<AudioStreamInteractive, Int>("get_clip_count")

    @JvmField
    public val setInitialClipName: MethodStringName1<AudioStreamInteractive, Unit, Int> =
        MethodStringName1<AudioStreamInteractive, Unit, Int>("set_initial_clip")

    @JvmField
    public val getInitialClipName: MethodStringName0<AudioStreamInteractive, Int> =
        MethodStringName0<AudioStreamInteractive, Int>("get_initial_clip")

    @JvmField
    public val setClipNameName: MethodStringName2<AudioStreamInteractive, Unit, Int, StringName> =
        MethodStringName2<AudioStreamInteractive, Unit, Int, StringName>("set_clip_name")

    @JvmField
    public val getClipNameName: MethodStringName1<AudioStreamInteractive, StringName, Int> =
        MethodStringName1<AudioStreamInteractive, StringName, Int>("get_clip_name")

    @JvmField
    public val setClipStreamName: MethodStringName2<AudioStreamInteractive, Unit, Int, AudioStream?>
        = MethodStringName2<AudioStreamInteractive, Unit, Int, AudioStream?>("set_clip_stream")

    @JvmField
    public val getClipStreamName: MethodStringName1<AudioStreamInteractive, AudioStream?, Int> =
        MethodStringName1<AudioStreamInteractive, AudioStream?, Int>("get_clip_stream")

    @JvmField
    public val setClipAutoAdvanceName:
        MethodStringName2<AudioStreamInteractive, Unit, Int, AutoAdvanceMode> =
        MethodStringName2<AudioStreamInteractive, Unit, Int, AutoAdvanceMode>("set_clip_auto_advance")

    @JvmField
    public val getClipAutoAdvanceName:
        MethodStringName1<AudioStreamInteractive, AutoAdvanceMode, Int> =
        MethodStringName1<AudioStreamInteractive, AutoAdvanceMode, Int>("get_clip_auto_advance")

    @JvmField
    public val setClipAutoAdvanceNextClipName:
        MethodStringName2<AudioStreamInteractive, Unit, Int, Int> =
        MethodStringName2<AudioStreamInteractive, Unit, Int, Int>("set_clip_auto_advance_next_clip")

    @JvmField
    public val getClipAutoAdvanceNextClipName: MethodStringName1<AudioStreamInteractive, Int, Int> =
        MethodStringName1<AudioStreamInteractive, Int, Int>("get_clip_auto_advance_next_clip")

    @JvmField
    public val addTransitionName:
        MethodStringName9<AudioStreamInteractive, Unit, Int, Int, TransitionFromTime, TransitionToTime, FadeMode, Float, Boolean, Int, Boolean>
        =
        MethodStringName9<AudioStreamInteractive, Unit, Int, Int, TransitionFromTime, TransitionToTime, FadeMode, Float, Boolean, Int, Boolean>("add_transition")

    @JvmField
    public val hasTransitionName: MethodStringName2<AudioStreamInteractive, Boolean, Int, Int> =
        MethodStringName2<AudioStreamInteractive, Boolean, Int, Int>("has_transition")

    @JvmField
    public val eraseTransitionName: MethodStringName2<AudioStreamInteractive, Unit, Int, Int> =
        MethodStringName2<AudioStreamInteractive, Unit, Int, Int>("erase_transition")

    @JvmField
    public val getTransitionListName: MethodStringName0<AudioStreamInteractive, PackedInt32Array> =
        MethodStringName0<AudioStreamInteractive, PackedInt32Array>("get_transition_list")

    @JvmField
    public val getTransitionFromTimeName:
        MethodStringName2<AudioStreamInteractive, TransitionFromTime, Int, Int> =
        MethodStringName2<AudioStreamInteractive, TransitionFromTime, Int, Int>("get_transition_from_time")

    @JvmField
    public val getTransitionToTimeName:
        MethodStringName2<AudioStreamInteractive, TransitionToTime, Int, Int> =
        MethodStringName2<AudioStreamInteractive, TransitionToTime, Int, Int>("get_transition_to_time")

    @JvmField
    public val getTransitionFadeModeName:
        MethodStringName2<AudioStreamInteractive, FadeMode, Int, Int> =
        MethodStringName2<AudioStreamInteractive, FadeMode, Int, Int>("get_transition_fade_mode")

    @JvmField
    public val getTransitionFadeBeatsName:
        MethodStringName2<AudioStreamInteractive, Float, Int, Int> =
        MethodStringName2<AudioStreamInteractive, Float, Int, Int>("get_transition_fade_beats")

    @JvmField
    public val isTransitionUsingFillerClipName:
        MethodStringName2<AudioStreamInteractive, Boolean, Int, Int> =
        MethodStringName2<AudioStreamInteractive, Boolean, Int, Int>("is_transition_using_filler_clip")

    @JvmField
    public val getTransitionFillerClipName: MethodStringName2<AudioStreamInteractive, Int, Int, Int>
        = MethodStringName2<AudioStreamInteractive, Int, Int, Int>("get_transition_filler_clip")

    @JvmField
    public val isTransitionHoldingPreviousName:
        MethodStringName2<AudioStreamInteractive, Boolean, Int, Int> =
        MethodStringName2<AudioStreamInteractive, Boolean, Int, Int>("is_transition_holding_previous")

    /**
     * This constant describes that any clip is valid for a specific transition as either source or
     * destination.
     */
    public final const val CLIP_ANY: Long = -1
  }

  public object MethodBindings {
    internal val setClipCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "set_clip_count", 1286410249)

    internal val getClipCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_clip_count", 3905245786)

    internal val setInitialClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "set_initial_clip", 1286410249)

    internal val getInitialClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_initial_clip", 3905245786)

    internal val setClipNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "set_clip_name", 3780747571)

    internal val getClipNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_clip_name", 659327637)

    internal val setClipStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "set_clip_stream", 111075094)

    internal val getClipStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_clip_stream", 2739380747)

    internal val setClipAutoAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "set_clip_auto_advance", 57217598)

    internal val getClipAutoAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_clip_auto_advance", 1778634807)

    internal val setClipAutoAdvanceNextClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "set_clip_auto_advance_next_clip", 3937882851)

    internal val getClipAutoAdvanceNextClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_clip_auto_advance_next_clip", 923996154)

    internal val addTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "add_transition", 1630280552)

    internal val hasTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "has_transition", 2522259332)

    internal val eraseTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "erase_transition", 3937882851)

    internal val getTransitionListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_transition_list", 1930428628)

    internal val getTransitionFromTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_transition_from_time", 3453338158)

    internal val getTransitionToTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_transition_to_time", 1369651373)

    internal val getTransitionFadeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_transition_fade_mode", 4065396087)

    internal val getTransitionFadeBeatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_transition_fade_beats", 3085491603)

    internal val isTransitionUsingFillerClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "is_transition_using_filler_clip", 2522259332)

    internal val getTransitionFillerClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "get_transition_filler_clip", 3175239445)

    internal val isTransitionHoldingPreviousPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamInteractive", "is_transition_holding_previous", 2522259332)
  }
}
