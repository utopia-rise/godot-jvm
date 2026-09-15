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
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Picks a random AudioStream from the pool, depending on the playback mode, and applies random
 * pitch shifting and volume shifting during playback.
 */
@GodotBaseType
public open class AudioStreamRandomizer : AudioStream() {
  /**
   * Controls how this AudioStreamRandomizer picks which AudioStream to play next.
   */
  public final inline var playbackMode: PlaybackMode
    @JvmName("playbackModeProperty")
    get() = getPlaybackMode()
    @JvmName("playbackModeProperty")
    set(`value`) {
      setPlaybackMode(value)
    }

  /**
   * The largest possible frequency multiplier of the random pitch variation. Pitch will be randomly
   * chosen within a range of [code skip-lint]1.0 / random_pitch[/code] and [code
   * skip-lint]random_pitch[/code]. A value of `1.0` means no variation. A value of `2.0` means pitch
   * will be randomized between double and half.
   *
   * **Note:** Setting this property also sets [randomPitchSemitones].
   */
  public final inline var randomPitch: Float
    @JvmName("randomPitchProperty")
    get() = getRandomPitch()
    @JvmName("randomPitchProperty")
    set(`value`) {
      setRandomPitch(value)
    }

  /**
   * The largest possible distance, in semitones, of the random pitch variation. A value of `0.0`
   * means no variation.
   *
   * **Note:** Setting this property also sets [randomPitch].
   */
  public final inline var randomPitchSemitones: Float
    @JvmName("randomPitchSemitonesProperty")
    get() = getRandomPitchSemitones()
    @JvmName("randomPitchSemitonesProperty")
    set(`value`) {
      setRandomPitchSemitones(value)
    }

  /**
   * The intensity of random volume variation. Volume will be increased or decreased by a random
   * value up to [code skip-lint]random_volume_offset_db[/code]. A value of `0.0` means no variation. A
   * value of `3.0` means volume will be randomized between `-3.0 dB` and `+3.0 dB`.
   */
  public final inline var randomVolumeOffsetDb: Float
    @JvmName("randomVolumeOffsetDbProperty")
    get() = getRandomVolumeOffsetDb()
    @JvmName("randomVolumeOffsetDbProperty")
    set(`value`) {
      setRandomVolumeOffsetDb(value)
    }

  /**
   * The number of streams in the stream pool.
   */
  public final inline var streamsCount: Int
    @JvmName("streamsCountProperty")
    get() = getStreamsCount()
    @JvmName("streamsCountProperty")
    set(`value`) {
      setStreamsCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(100, scriptPtr)
  }

  /**
   * Insert a stream at the specified index. If the index is less than zero, the insertion occurs at
   * the end of the underlying pool.
   */
  @JvmOverloads
  public final fun addStream(
    index: Int,
    stream: AudioStream?,
    weight: Float = 1.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to stream, DOUBLE to weight.toDouble())
    TransferContext.callMethod(MethodBindings.addStreamPtr)
  }

  /**
   * Move a stream from one index to another.
   */
  public final fun moveStream(indexFrom: Int, indexTo: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to indexFrom.toLong(), LONG to indexTo.toLong())
    TransferContext.callMethod(MethodBindings.moveStreamPtr)
  }

  /**
   * Remove the stream at the specified index.
   */
  public final fun removeStream(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removeStreamPtr)
  }

  /**
   * Set the AudioStream at the specified index.
   */
  public final fun setStream(index: Int, stream: AudioStream?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to stream)
    TransferContext.callMethod(MethodBindings.setStreamPtr)
  }

  /**
   * Returns the stream at the specified index.
   */
  public final fun getStream(index: Int): AudioStream? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStreamPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioStream?)
  }

  /**
   * Set the probability weight of the stream at the specified index. The higher this value, the
   * more likely that the randomizer will choose this stream during random playback modes.
   */
  public final fun setStreamProbabilityWeight(index: Int, weight: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to weight.toDouble())
    TransferContext.callMethod(MethodBindings.setStreamProbabilityWeightPtr)
  }

  /**
   * Returns the probability weight associated with the stream at the given index.
   */
  public final fun getStreamProbabilityWeight(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStreamProbabilityWeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setStreamsCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setStreamsCountPtr)
  }

  public final fun getStreamsCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setRandomPitch(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setRandomPitchPtr)
  }

  public final fun getRandomPitch(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRandomPitchPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRandomPitchSemitones(semitones: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to semitones.toDouble())
    TransferContext.callMethod(MethodBindings.setRandomPitchSemitonesPtr)
  }

  public final fun getRandomPitchSemitones(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRandomPitchSemitonesPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRandomVolumeOffsetDb(dbOffset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to dbOffset.toDouble())
    TransferContext.callMethod(MethodBindings.setRandomVolumeOffsetDbPtr)
  }

  public final fun getRandomVolumeOffsetDb(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRandomVolumeOffsetDbPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPlaybackMode(mode: PlaybackMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setPlaybackModePtr)
  }

  public final fun getPlaybackMode(): PlaybackMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaybackModePtr)
    return PlaybackMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamRandomizer::_instantiatePlayback can't be called from the JVM.")
  }

  public enum class PlaybackMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Pick a stream at random according to the probability weights chosen for each stream, but
     * avoid playing the same stream twice in a row whenever possible. If only 1 sound is present in
     * the pool, the same sound will always play, effectively allowing repeats to occur.
     */
    RANDOM_NO_REPEATS(0),
    /**
     * Pick a stream at random according to the probability weights chosen for each stream. If only
     * 1 sound is present in the pool, the same sound will always play.
     */
    RANDOM(1),
    /**
     * Play streams in the order they appear in the stream pool. If only 1 sound is present in the
     * pool, the same sound will always play.
     */
    SEQUENTIAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): PlaybackMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addStreamName:
        MethodStringName3<AudioStreamRandomizer, Unit, Int, AudioStream?, Float> =
        MethodStringName3<AudioStreamRandomizer, Unit, Int, AudioStream?, Float>("add_stream")

    @JvmField
    public val moveStreamName: MethodStringName2<AudioStreamRandomizer, Unit, Int, Int> =
        MethodStringName2<AudioStreamRandomizer, Unit, Int, Int>("move_stream")

    @JvmField
    public val removeStreamName: MethodStringName1<AudioStreamRandomizer, Unit, Int> =
        MethodStringName1<AudioStreamRandomizer, Unit, Int>("remove_stream")

    @JvmField
    public val setStreamName: MethodStringName2<AudioStreamRandomizer, Unit, Int, AudioStream?> =
        MethodStringName2<AudioStreamRandomizer, Unit, Int, AudioStream?>("set_stream")

    @JvmField
    public val getStreamName: MethodStringName1<AudioStreamRandomizer, AudioStream?, Int> =
        MethodStringName1<AudioStreamRandomizer, AudioStream?, Int>("get_stream")

    @JvmField
    public val setStreamProbabilityWeightName:
        MethodStringName2<AudioStreamRandomizer, Unit, Int, Float> =
        MethodStringName2<AudioStreamRandomizer, Unit, Int, Float>("set_stream_probability_weight")

    @JvmField
    public val getStreamProbabilityWeightName: MethodStringName1<AudioStreamRandomizer, Float, Int>
        = MethodStringName1<AudioStreamRandomizer, Float, Int>("get_stream_probability_weight")

    @JvmField
    public val setStreamsCountName: MethodStringName1<AudioStreamRandomizer, Unit, Int> =
        MethodStringName1<AudioStreamRandomizer, Unit, Int>("set_streams_count")

    @JvmField
    public val getStreamsCountName: MethodStringName0<AudioStreamRandomizer, Int> =
        MethodStringName0<AudioStreamRandomizer, Int>("get_streams_count")

    @JvmField
    public val setRandomPitchName: MethodStringName1<AudioStreamRandomizer, Unit, Float> =
        MethodStringName1<AudioStreamRandomizer, Unit, Float>("set_random_pitch")

    @JvmField
    public val getRandomPitchName: MethodStringName0<AudioStreamRandomizer, Float> =
        MethodStringName0<AudioStreamRandomizer, Float>("get_random_pitch")

    @JvmField
    public val setRandomPitchSemitonesName: MethodStringName1<AudioStreamRandomizer, Unit, Float> =
        MethodStringName1<AudioStreamRandomizer, Unit, Float>("set_random_pitch_semitones")

    @JvmField
    public val getRandomPitchSemitonesName: MethodStringName0<AudioStreamRandomizer, Float> =
        MethodStringName0<AudioStreamRandomizer, Float>("get_random_pitch_semitones")

    @JvmField
    public val setRandomVolumeOffsetDbName: MethodStringName1<AudioStreamRandomizer, Unit, Float> =
        MethodStringName1<AudioStreamRandomizer, Unit, Float>("set_random_volume_offset_db")

    @JvmField
    public val getRandomVolumeOffsetDbName: MethodStringName0<AudioStreamRandomizer, Float> =
        MethodStringName0<AudioStreamRandomizer, Float>("get_random_volume_offset_db")

    @JvmField
    public val setPlaybackModeName: MethodStringName1<AudioStreamRandomizer, Unit, PlaybackMode> =
        MethodStringName1<AudioStreamRandomizer, Unit, PlaybackMode>("set_playback_mode")

    @JvmField
    public val getPlaybackModeName: MethodStringName0<AudioStreamRandomizer, PlaybackMode> =
        MethodStringName0<AudioStreamRandomizer, PlaybackMode>("get_playback_mode")
  }

  public object MethodBindings {
    internal val addStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "add_stream", 1892018854)

    internal val moveStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "move_stream", 3937882851)

    internal val removeStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "remove_stream", 1286410249)

    internal val setStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_stream", 111075094)

    internal val getStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_stream", 2739380747)

    internal val setStreamProbabilityWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_stream_probability_weight", 1602489585)

    internal val getStreamProbabilityWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_stream_probability_weight", 2339986948)

    internal val setStreamsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_streams_count", 1286410249)

    internal val getStreamsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_streams_count", 3905245786)

    internal val setRandomPitchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_random_pitch", 373806689)

    internal val getRandomPitchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_random_pitch", 1740695150)

    internal val setRandomPitchSemitonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_random_pitch_semitones", 373806689)

    internal val getRandomPitchSemitonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_random_pitch_semitones", 1740695150)

    internal val setRandomVolumeOffsetDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_random_volume_offset_db", 373806689)

    internal val getRandomVolumeOffsetDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_random_volume_offset_db", 1740695150)

    internal val setPlaybackModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "set_playback_mode", 3950967023)

    internal val getPlaybackModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamRandomizer", "get_playback_mode", 3943055077)
  }
}
