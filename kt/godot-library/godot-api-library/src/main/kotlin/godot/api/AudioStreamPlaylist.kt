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
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An audio stream that can play back sub-streams in sequence. Streams can be added to the Playlist
 * with [setListStream], and shuffled with [shuffle].
 */
@GodotBaseType
public open class AudioStreamPlaylist : AudioStream() {
  /**
   * If `true`, the playlist will shuffle each time playback starts and each time it loops.
   */
  public final inline var shuffle: Boolean
    @JvmName("shuffleProperty")
    get() = getShuffle()
    @JvmName("shuffleProperty")
    set(`value`) {
      setShuffle(value)
    }

  /**
   * If `true`, the playlist will loop, otherwise the playlist will end when the last stream is
   * finished.
   */
  public final inline var loop: Boolean
    @JvmName("loopProperty")
    get() = hasLoop()
    @JvmName("loopProperty")
    set(`value`) {
      setLoop(value)
    }

  /**
   * Fade time used when a stream ends, when going to the next one. Streams are expected to have an
   * extra bit of audio after the end to help with fading.
   */
  public final inline var fadeTime: Float
    @JvmName("fadeTimeProperty")
    get() = getFadeTime()
    @JvmName("fadeTimeProperty")
    set(`value`) {
      setFadeTime(value)
    }

  /**
   * Amount of streams in the playlist.
   */
  public final inline var streamCount: Int
    @JvmName("streamCountProperty")
    get() = getStreamCount()
    @JvmName("streamCountProperty")
    set(`value`) {
      setStreamCount(value)
    }

  public final inline var stream0: AudioStream?
    @JvmName("stream0Property")
    get() = getListStream(0)
    @JvmName("stream0Property")
    set(`value`) {
      setListStream(0, value)
    }

  public final inline var stream1: AudioStream?
    @JvmName("stream1Property")
    get() = getListStream(1)
    @JvmName("stream1Property")
    set(`value`) {
      setListStream(1, value)
    }

  public final inline var stream2: AudioStream?
    @JvmName("stream2Property")
    get() = getListStream(2)
    @JvmName("stream2Property")
    set(`value`) {
      setListStream(2, value)
    }

  public final inline var stream3: AudioStream?
    @JvmName("stream3Property")
    get() = getListStream(3)
    @JvmName("stream3Property")
    set(`value`) {
      setListStream(3, value)
    }

  public final inline var stream4: AudioStream?
    @JvmName("stream4Property")
    get() = getListStream(4)
    @JvmName("stream4Property")
    set(`value`) {
      setListStream(4, value)
    }

  public final inline var stream5: AudioStream?
    @JvmName("stream5Property")
    get() = getListStream(5)
    @JvmName("stream5Property")
    set(`value`) {
      setListStream(5, value)
    }

  public final inline var stream6: AudioStream?
    @JvmName("stream6Property")
    get() = getListStream(6)
    @JvmName("stream6Property")
    set(`value`) {
      setListStream(6, value)
    }

  public final inline var stream7: AudioStream?
    @JvmName("stream7Property")
    get() = getListStream(7)
    @JvmName("stream7Property")
    set(`value`) {
      setListStream(7, value)
    }

  public final inline var stream8: AudioStream?
    @JvmName("stream8Property")
    get() = getListStream(8)
    @JvmName("stream8Property")
    set(`value`) {
      setListStream(8, value)
    }

  public final inline var stream9: AudioStream?
    @JvmName("stream9Property")
    get() = getListStream(9)
    @JvmName("stream9Property")
    set(`value`) {
      setListStream(9, value)
    }

  public final inline var stream10: AudioStream?
    @JvmName("stream10Property")
    get() = getListStream(10)
    @JvmName("stream10Property")
    set(`value`) {
      setListStream(10, value)
    }

  public final inline var stream11: AudioStream?
    @JvmName("stream11Property")
    get() = getListStream(11)
    @JvmName("stream11Property")
    set(`value`) {
      setListStream(11, value)
    }

  public final inline var stream12: AudioStream?
    @JvmName("stream12Property")
    get() = getListStream(12)
    @JvmName("stream12Property")
    set(`value`) {
      setListStream(12, value)
    }

  public final inline var stream13: AudioStream?
    @JvmName("stream13Property")
    get() = getListStream(13)
    @JvmName("stream13Property")
    set(`value`) {
      setListStream(13, value)
    }

  public final inline var stream14: AudioStream?
    @JvmName("stream14Property")
    get() = getListStream(14)
    @JvmName("stream14Property")
    set(`value`) {
      setListStream(14, value)
    }

  public final inline var stream15: AudioStream?
    @JvmName("stream15Property")
    get() = getListStream(15)
    @JvmName("stream15Property")
    set(`value`) {
      setListStream(15, value)
    }

  public final inline var stream16: AudioStream?
    @JvmName("stream16Property")
    get() = getListStream(16)
    @JvmName("stream16Property")
    set(`value`) {
      setListStream(16, value)
    }

  public final inline var stream17: AudioStream?
    @JvmName("stream17Property")
    get() = getListStream(17)
    @JvmName("stream17Property")
    set(`value`) {
      setListStream(17, value)
    }

  public final inline var stream18: AudioStream?
    @JvmName("stream18Property")
    get() = getListStream(18)
    @JvmName("stream18Property")
    set(`value`) {
      setListStream(18, value)
    }

  public final inline var stream19: AudioStream?
    @JvmName("stream19Property")
    get() = getListStream(19)
    @JvmName("stream19Property")
    set(`value`) {
      setListStream(19, value)
    }

  public final inline var stream20: AudioStream?
    @JvmName("stream20Property")
    get() = getListStream(20)
    @JvmName("stream20Property")
    set(`value`) {
      setListStream(20, value)
    }

  public final inline var stream21: AudioStream?
    @JvmName("stream21Property")
    get() = getListStream(21)
    @JvmName("stream21Property")
    set(`value`) {
      setListStream(21, value)
    }

  public final inline var stream22: AudioStream?
    @JvmName("stream22Property")
    get() = getListStream(22)
    @JvmName("stream22Property")
    set(`value`) {
      setListStream(22, value)
    }

  public final inline var stream23: AudioStream?
    @JvmName("stream23Property")
    get() = getListStream(23)
    @JvmName("stream23Property")
    set(`value`) {
      setListStream(23, value)
    }

  public final inline var stream24: AudioStream?
    @JvmName("stream24Property")
    get() = getListStream(24)
    @JvmName("stream24Property")
    set(`value`) {
      setListStream(24, value)
    }

  public final inline var stream25: AudioStream?
    @JvmName("stream25Property")
    get() = getListStream(25)
    @JvmName("stream25Property")
    set(`value`) {
      setListStream(25, value)
    }

  public final inline var stream26: AudioStream?
    @JvmName("stream26Property")
    get() = getListStream(26)
    @JvmName("stream26Property")
    set(`value`) {
      setListStream(26, value)
    }

  public final inline var stream27: AudioStream?
    @JvmName("stream27Property")
    get() = getListStream(27)
    @JvmName("stream27Property")
    set(`value`) {
      setListStream(27, value)
    }

  public final inline var stream28: AudioStream?
    @JvmName("stream28Property")
    get() = getListStream(28)
    @JvmName("stream28Property")
    set(`value`) {
      setListStream(28, value)
    }

  public final inline var stream29: AudioStream?
    @JvmName("stream29Property")
    get() = getListStream(29)
    @JvmName("stream29Property")
    set(`value`) {
      setListStream(29, value)
    }

  public final inline var stream30: AudioStream?
    @JvmName("stream30Property")
    get() = getListStream(30)
    @JvmName("stream30Property")
    set(`value`) {
      setListStream(30, value)
    }

  public final inline var stream31: AudioStream?
    @JvmName("stream31Property")
    get() = getListStream(31)
    @JvmName("stream31Property")
    set(`value`) {
      setListStream(31, value)
    }

  public final inline var stream32: AudioStream?
    @JvmName("stream32Property")
    get() = getListStream(32)
    @JvmName("stream32Property")
    set(`value`) {
      setListStream(32, value)
    }

  public final inline var stream33: AudioStream?
    @JvmName("stream33Property")
    get() = getListStream(33)
    @JvmName("stream33Property")
    set(`value`) {
      setListStream(33, value)
    }

  public final inline var stream34: AudioStream?
    @JvmName("stream34Property")
    get() = getListStream(34)
    @JvmName("stream34Property")
    set(`value`) {
      setListStream(34, value)
    }

  public final inline var stream35: AudioStream?
    @JvmName("stream35Property")
    get() = getListStream(35)
    @JvmName("stream35Property")
    set(`value`) {
      setListStream(35, value)
    }

  public final inline var stream36: AudioStream?
    @JvmName("stream36Property")
    get() = getListStream(36)
    @JvmName("stream36Property")
    set(`value`) {
      setListStream(36, value)
    }

  public final inline var stream37: AudioStream?
    @JvmName("stream37Property")
    get() = getListStream(37)
    @JvmName("stream37Property")
    set(`value`) {
      setListStream(37, value)
    }

  public final inline var stream38: AudioStream?
    @JvmName("stream38Property")
    get() = getListStream(38)
    @JvmName("stream38Property")
    set(`value`) {
      setListStream(38, value)
    }

  public final inline var stream39: AudioStream?
    @JvmName("stream39Property")
    get() = getListStream(39)
    @JvmName("stream39Property")
    set(`value`) {
      setListStream(39, value)
    }

  public final inline var stream40: AudioStream?
    @JvmName("stream40Property")
    get() = getListStream(40)
    @JvmName("stream40Property")
    set(`value`) {
      setListStream(40, value)
    }

  public final inline var stream41: AudioStream?
    @JvmName("stream41Property")
    get() = getListStream(41)
    @JvmName("stream41Property")
    set(`value`) {
      setListStream(41, value)
    }

  public final inline var stream42: AudioStream?
    @JvmName("stream42Property")
    get() = getListStream(42)
    @JvmName("stream42Property")
    set(`value`) {
      setListStream(42, value)
    }

  public final inline var stream43: AudioStream?
    @JvmName("stream43Property")
    get() = getListStream(43)
    @JvmName("stream43Property")
    set(`value`) {
      setListStream(43, value)
    }

  public final inline var stream44: AudioStream?
    @JvmName("stream44Property")
    get() = getListStream(44)
    @JvmName("stream44Property")
    set(`value`) {
      setListStream(44, value)
    }

  public final inline var stream45: AudioStream?
    @JvmName("stream45Property")
    get() = getListStream(45)
    @JvmName("stream45Property")
    set(`value`) {
      setListStream(45, value)
    }

  public final inline var stream46: AudioStream?
    @JvmName("stream46Property")
    get() = getListStream(46)
    @JvmName("stream46Property")
    set(`value`) {
      setListStream(46, value)
    }

  public final inline var stream47: AudioStream?
    @JvmName("stream47Property")
    get() = getListStream(47)
    @JvmName("stream47Property")
    set(`value`) {
      setListStream(47, value)
    }

  public final inline var stream48: AudioStream?
    @JvmName("stream48Property")
    get() = getListStream(48)
    @JvmName("stream48Property")
    set(`value`) {
      setListStream(48, value)
    }

  public final inline var stream49: AudioStream?
    @JvmName("stream49Property")
    get() = getListStream(49)
    @JvmName("stream49Property")
    set(`value`) {
      setListStream(49, value)
    }

  public final inline var stream50: AudioStream?
    @JvmName("stream50Property")
    get() = getListStream(50)
    @JvmName("stream50Property")
    set(`value`) {
      setListStream(50, value)
    }

  public final inline var stream51: AudioStream?
    @JvmName("stream51Property")
    get() = getListStream(51)
    @JvmName("stream51Property")
    set(`value`) {
      setListStream(51, value)
    }

  public final inline var stream52: AudioStream?
    @JvmName("stream52Property")
    get() = getListStream(52)
    @JvmName("stream52Property")
    set(`value`) {
      setListStream(52, value)
    }

  public final inline var stream53: AudioStream?
    @JvmName("stream53Property")
    get() = getListStream(53)
    @JvmName("stream53Property")
    set(`value`) {
      setListStream(53, value)
    }

  public final inline var stream54: AudioStream?
    @JvmName("stream54Property")
    get() = getListStream(54)
    @JvmName("stream54Property")
    set(`value`) {
      setListStream(54, value)
    }

  public final inline var stream55: AudioStream?
    @JvmName("stream55Property")
    get() = getListStream(55)
    @JvmName("stream55Property")
    set(`value`) {
      setListStream(55, value)
    }

  public final inline var stream56: AudioStream?
    @JvmName("stream56Property")
    get() = getListStream(56)
    @JvmName("stream56Property")
    set(`value`) {
      setListStream(56, value)
    }

  public final inline var stream57: AudioStream?
    @JvmName("stream57Property")
    get() = getListStream(57)
    @JvmName("stream57Property")
    set(`value`) {
      setListStream(57, value)
    }

  public final inline var stream58: AudioStream?
    @JvmName("stream58Property")
    get() = getListStream(58)
    @JvmName("stream58Property")
    set(`value`) {
      setListStream(58, value)
    }

  public final inline var stream59: AudioStream?
    @JvmName("stream59Property")
    get() = getListStream(59)
    @JvmName("stream59Property")
    set(`value`) {
      setListStream(59, value)
    }

  public final inline var stream60: AudioStream?
    @JvmName("stream60Property")
    get() = getListStream(60)
    @JvmName("stream60Property")
    set(`value`) {
      setListStream(60, value)
    }

  public final inline var stream61: AudioStream?
    @JvmName("stream61Property")
    get() = getListStream(61)
    @JvmName("stream61Property")
    set(`value`) {
      setListStream(61, value)
    }

  public final inline var stream62: AudioStream?
    @JvmName("stream62Property")
    get() = getListStream(62)
    @JvmName("stream62Property")
    set(`value`) {
      setListStream(62, value)
    }

  public final inline var stream63: AudioStream?
    @JvmName("stream63Property")
    get() = getListStream(63)
    @JvmName("stream63Property")
    set(`value`) {
      setListStream(63, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(98, scriptPtr)
  }

  public final fun setStreamCount(streamCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to streamCount.toLong())
    TransferContext.callMethod(MethodBindings.setStreamCountPtr)
  }

  public final fun getStreamCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the BPM of the playlist, which can vary depending on the clip being played.
   */
  public final fun getBpm(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBpmPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets the stream at playback position index.
   */
  public final fun setListStream(streamIndex: Int, audioStream: AudioStream?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to streamIndex.toLong(), OBJECT to audioStream)
    TransferContext.callMethod(MethodBindings.setListStreamPtr)
  }

  /**
   * Returns the stream at playback position index.
   */
  public final fun getListStream(streamIndex: Int): AudioStream? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to streamIndex.toLong())
    TransferContext.callMethod(MethodBindings.getListStreamPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioStream?)
  }

  public final fun setShuffle(shuffle: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to shuffle)
    TransferContext.callMethod(MethodBindings.setShufflePtr)
  }

  public final fun getShuffle(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShufflePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFadeTime(dec: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to dec.toDouble())
    TransferContext.callMethod(MethodBindings.setFadeTimePtr)
  }

  public final fun getFadeTime(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFadeTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLoop(loop: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to loop)
    TransferContext.callMethod(MethodBindings.setLoopPtr)
  }

  public final fun hasLoop(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasLoopPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamPlaylist::_instantiatePlayback can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setStreamCountName: MethodStringName1<AudioStreamPlaylist, Unit, Int> =
        MethodStringName1<AudioStreamPlaylist, Unit, Int>("set_stream_count")

    @JvmField
    public val getStreamCountName: MethodStringName0<AudioStreamPlaylist, Int> =
        MethodStringName0<AudioStreamPlaylist, Int>("get_stream_count")

    @JvmField
    public val getBpmName: MethodStringName0<AudioStreamPlaylist, Double> =
        MethodStringName0<AudioStreamPlaylist, Double>("get_bpm")

    @JvmField
    public val setListStreamName: MethodStringName2<AudioStreamPlaylist, Unit, Int, AudioStream?> =
        MethodStringName2<AudioStreamPlaylist, Unit, Int, AudioStream?>("set_list_stream")

    @JvmField
    public val getListStreamName: MethodStringName1<AudioStreamPlaylist, AudioStream?, Int> =
        MethodStringName1<AudioStreamPlaylist, AudioStream?, Int>("get_list_stream")

    @JvmField
    public val setShuffleName: MethodStringName1<AudioStreamPlaylist, Unit, Boolean> =
        MethodStringName1<AudioStreamPlaylist, Unit, Boolean>("set_shuffle")

    @JvmField
    public val getShuffleName: MethodStringName0<AudioStreamPlaylist, Boolean> =
        MethodStringName0<AudioStreamPlaylist, Boolean>("get_shuffle")

    @JvmField
    public val setFadeTimeName: MethodStringName1<AudioStreamPlaylist, Unit, Float> =
        MethodStringName1<AudioStreamPlaylist, Unit, Float>("set_fade_time")

    @JvmField
    public val getFadeTimeName: MethodStringName0<AudioStreamPlaylist, Float> =
        MethodStringName0<AudioStreamPlaylist, Float>("get_fade_time")

    @JvmField
    public val setLoopName: MethodStringName1<AudioStreamPlaylist, Unit, Boolean> =
        MethodStringName1<AudioStreamPlaylist, Unit, Boolean>("set_loop")

    @JvmField
    public val hasLoopName: MethodStringName0<AudioStreamPlaylist, Boolean> =
        MethodStringName0<AudioStreamPlaylist, Boolean>("has_loop")

    /**
     * Maximum amount of streams supported in the playlist.
     */
    public final const val MAX_STREAMS: Long = 64
  }

  public object MethodBindings {
    internal val setStreamCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "set_stream_count", 1286410249)

    internal val getStreamCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "get_stream_count", 3905245786)

    internal val getBpmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "get_bpm", 1740695150)

    internal val setListStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "set_list_stream", 111075094)

    internal val getListStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "get_list_stream", 2739380747)

    internal val setShufflePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "set_shuffle", 2586408642)

    internal val getShufflePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "get_shuffle", 36873697)

    internal val setFadeTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "set_fade_time", 373806689)

    internal val getFadeTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "get_fade_time", 1740695150)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "set_loop", 2586408642)

    internal val hasLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaylist", "has_loop", 36873697)
  }
}
