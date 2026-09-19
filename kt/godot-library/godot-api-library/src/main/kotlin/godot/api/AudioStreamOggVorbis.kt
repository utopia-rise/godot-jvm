// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_STRING_ret_OBJECT_REF
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DICTIONARY
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DICTIONARY
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_PACKED_BYTE_ARRAY_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedByteArray
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * The AudioStreamOggVorbis class is a specialized [AudioStream] for handling Ogg Vorbis file
 * formats. It offers functionality for loading and playing back Ogg Vorbis files, as well as managing
 * looping and other playback properties. More info can be found in [ResourceImporterOggVorbis].
 *
 * This class is part of the audio stream system, which also supports WAV files through the
 * [AudioStreamWAV] class, and MP3 files through the [AudioStreamMP3] class.
 */
@GodotBaseType
public open class AudioStreamOggVorbis : AudioStream() {
  /**
   * Contains the raw Ogg data for this stream.
   */
  public final inline var packetSequence: OggPacketSequence?
    @JvmName("packetSequenceProperty")
    get() = getPacketSequence()
    @JvmName("packetSequenceProperty")
    set(`value`) {
      setPacketSequence(value)
    }

  /**
   * The tempo of the audio track, measured in beats per minute.
   */
  public final inline var bpm: Double
    @JvmName("bpmProperty")
    get() = getBpm()
    @JvmName("bpmProperty")
    set(`value`) {
      setBpm(value)
    }

  /**
   * The length of the audio track, in beats. The actual duration of the audio file might be longer
   * than what is indicated by this property. It defines the end of the audio for looping,
   * [AudioStreamPlaylist], and [AudioStreamInteractive].
   */
  public final inline var beatCount: Int
    @JvmName("beatCountProperty")
    get() = getBeatCount()
    @JvmName("beatCountProperty")
    set(`value`) {
      setBeatCount(value)
    }

  /**
   * The number of beats within a single bar in the audio track.
   */
  public final inline var barBeats: Int
    @JvmName("barBeatsProperty")
    get() = getBarBeats()
    @JvmName("barBeatsProperty")
    set(`value`) {
      setBarBeats(value)
    }

  /**
   * Contains user-defined tags if found in the Ogg Vorbis data.
   *
   * Commonly used tags include `title`, `artist`, `album`, `tracknumber`, and `date` (`date` does
   * not have a standard date format).
   *
   * **Note:** No tag is *guaranteed* to be present in every file, so make sure to account for the
   * keys not always existing.
   */
  public final inline var tags: Dictionary<Any?, Any?>
    @JvmName("tagsProperty")
    get() = getTags()
    @JvmName("tagsProperty")
    set(`value`) {
      setTags(value)
    }

  /**
   * If `true`, the stream will play again from the specified [loopOffset] once it reaches the end
   * of the audio track, or once it reaches the end of the last beat according to the amount specified
   * in [beatCount]. Useful for ambient sounds and background music.
   */
  public final inline var loop: Boolean
    @JvmName("loopProperty")
    get() = hasLoop()
    @JvmName("loopProperty")
    set(`value`) {
      setLoop(value)
    }

  /**
   * Time in seconds at which the stream starts after being looped.
   */
  public final inline var loopOffset: Double
    @JvmName("loopOffsetProperty")
    get() = getLoopOffset()
    @JvmName("loopOffsetProperty")
    set(`value`) {
      setLoopOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(87, scriptPtr)
  }

  public final fun setPacketSequence(packetSequence: OggPacketSequence?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setPacketSequencePtr, packetSequence)
  }

  public final fun getPacketSequence(): OggPacketSequence? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getPacketSequencePtr) as OggPacketSequence?)

  public final fun setLoop(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setLoopPtr, enable)
  }

  public final fun hasLoop(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasLoopPtr)

  public final fun setLoopOffset(seconds: Double): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setLoopOffsetPtr, seconds)
  }

  public final fun getLoopOffset(): Double =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLoopOffsetPtr)

  public final fun setBpm(bpm: Double): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setBpmPtr, bpm)
  }

  public final fun getBpm(): Double =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBpmPtr)

  public final fun setBeatCount(count: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBeatCountPtr, count.toLong())
  }

  public final fun getBeatCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBeatCountPtr).toInt()

  public final fun setBarBeats(count: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBarBeatsPtr, count.toLong())
  }

  public final fun getBarBeats(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBarBeatsPtr).toInt()

  public final fun setTags(tags: Dictionary<Any?, Any?>): Unit {
    TransferContext.callPtrMethod_DICTIONARY(ptr, objectID.id, MethodBindings.setTagsPtr, tags)
  }

  public final fun getTags(): Dictionary<Any?, Any?> =
      (TransferContext.callPtrMethod0_ret_DICTIONARY(ptr, objectID.id, MethodBindings.getTagsPtr) as Dictionary<Any?, Any?>)

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamOggVorbis::_instantiatePlayback can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val loadFromBufferName:
        MethodStringName1<AudioStreamOggVorbis, AudioStreamOggVorbis?, PackedByteArray> =
        MethodStringName1<AudioStreamOggVorbis, AudioStreamOggVorbis?, PackedByteArray>("load_from_buffer")

    @JvmField
    public val loadFromFileName:
        MethodStringName1<AudioStreamOggVorbis, AudioStreamOggVorbis?, String> =
        MethodStringName1<AudioStreamOggVorbis, AudioStreamOggVorbis?, String>("load_from_file")

    @JvmField
    public val setPacketSequenceName:
        MethodStringName1<AudioStreamOggVorbis, Unit, OggPacketSequence?> =
        MethodStringName1<AudioStreamOggVorbis, Unit, OggPacketSequence?>("set_packet_sequence")

    @JvmField
    public val getPacketSequenceName: MethodStringName0<AudioStreamOggVorbis, OggPacketSequence?> =
        MethodStringName0<AudioStreamOggVorbis, OggPacketSequence?>("get_packet_sequence")

    @JvmField
    public val setLoopName: MethodStringName1<AudioStreamOggVorbis, Unit, Boolean> =
        MethodStringName1<AudioStreamOggVorbis, Unit, Boolean>("set_loop")

    @JvmField
    public val hasLoopName: MethodStringName0<AudioStreamOggVorbis, Boolean> =
        MethodStringName0<AudioStreamOggVorbis, Boolean>("has_loop")

    @JvmField
    public val setLoopOffsetName: MethodStringName1<AudioStreamOggVorbis, Unit, Double> =
        MethodStringName1<AudioStreamOggVorbis, Unit, Double>("set_loop_offset")

    @JvmField
    public val getLoopOffsetName: MethodStringName0<AudioStreamOggVorbis, Double> =
        MethodStringName0<AudioStreamOggVorbis, Double>("get_loop_offset")

    @JvmField
    public val setBpmName: MethodStringName1<AudioStreamOggVorbis, Unit, Double> =
        MethodStringName1<AudioStreamOggVorbis, Unit, Double>("set_bpm")

    @JvmField
    public val getBpmName: MethodStringName0<AudioStreamOggVorbis, Double> =
        MethodStringName0<AudioStreamOggVorbis, Double>("get_bpm")

    @JvmField
    public val setBeatCountName: MethodStringName1<AudioStreamOggVorbis, Unit, Int> =
        MethodStringName1<AudioStreamOggVorbis, Unit, Int>("set_beat_count")

    @JvmField
    public val getBeatCountName: MethodStringName0<AudioStreamOggVorbis, Int> =
        MethodStringName0<AudioStreamOggVorbis, Int>("get_beat_count")

    @JvmField
    public val setBarBeatsName: MethodStringName1<AudioStreamOggVorbis, Unit, Int> =
        MethodStringName1<AudioStreamOggVorbis, Unit, Int>("set_bar_beats")

    @JvmField
    public val getBarBeatsName: MethodStringName0<AudioStreamOggVorbis, Int> =
        MethodStringName0<AudioStreamOggVorbis, Int>("get_bar_beats")

    @JvmField
    public val setTagsName: MethodStringName1<AudioStreamOggVorbis, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<AudioStreamOggVorbis, Unit, Dictionary<Any?, Any?>>("set_tags")

    @JvmField
    public val getTagsName: MethodStringName0<AudioStreamOggVorbis, Dictionary<Any?, Any?>> =
        MethodStringName0<AudioStreamOggVorbis, Dictionary<Any?, Any?>>("get_tags")

    /**
     * Creates a new [AudioStreamOggVorbis] instance from the given buffer. The buffer must contain
     * Ogg Vorbis data.
     */
    @JvmStatic
    public final fun loadFromBuffer(streamData: PackedByteArray): AudioStreamOggVorbis? =
        (TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_ret_OBJECT_REF(0L, 0L, MethodBindings.loadFromBufferPtr, streamData) as AudioStreamOggVorbis?)

    /**
     * Creates a new [AudioStreamOggVorbis] instance from the given file path. The file must be in
     * Ogg Vorbis format.
     */
    @JvmStatic
    public final fun loadFromFile(path: String): AudioStreamOggVorbis? =
        (TransferContext.callMethod_STRING_ret_OBJECT_REF(0L, 0L, MethodBindings.loadFromFilePtr, path) as AudioStreamOggVorbis?)
  }

  public object MethodBindings {
    internal val loadFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "load_from_buffer", 354904730)

    internal val loadFromFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "load_from_file", 797568536)

    internal val setPacketSequencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_packet_sequence", 438882457)

    internal val getPacketSequencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "get_packet_sequence", 2801636033)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_loop", 2586408642)

    internal val hasLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "has_loop", 36873697)

    internal val setLoopOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_loop_offset", 373806689)

    internal val getLoopOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "get_loop_offset", 1740695150)

    internal val setBpmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_bpm", 373806689)

    internal val getBpmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "get_bpm", 1740695150)

    internal val setBeatCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_beat_count", 1286410249)

    internal val getBeatCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "get_beat_count", 3905245786)

    internal val setBarBeatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_bar_beats", 1286410249)

    internal val getBarBeatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "get_bar_beats", 3905245786)

    internal val setTagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "set_tags", 4155329257)

    internal val getTagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamOggVorbis", "get_tags", 3102165223)
  }
}
