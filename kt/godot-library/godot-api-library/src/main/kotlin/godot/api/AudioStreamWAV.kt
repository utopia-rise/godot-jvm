// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * AudioStreamWAV stores sound samples loaded from WAV files. To play the stored sound, use an
 * [AudioStreamPlayer] (for non-positional audio) or [AudioStreamPlayer2D]/[AudioStreamPlayer3D] (for
 * positional audio). The sound can be looped.
 *
 * This class can also be used to store dynamically-generated PCM audio data. See also
 * [AudioStreamGenerator] for procedural audio generation.
 */
@GodotBaseType
public open class AudioStreamWAV : AudioStream() {
  /**
   * Contains the audio data in bytes.
   *
   * **Note:** If [format] is set to [FORMAT_8_BITS], this property expects signed 8-bit PCM data.
   * To convert from unsigned 8-bit PCM, subtract 128 from each byte.
   *
   * **Note:** If [format] is set to [FORMAT_QOA], this property expects data from a full QOA file.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var `data`: PackedByteArray
    @JvmName("dataProperty")
    get() = getData()
    @JvmName("dataProperty")
    set(`value`) {
      setData(value)
    }

  /**
   * Audio format.
   */
  public final inline var format: Format
    @JvmName("formatProperty")
    get() = getFormat()
    @JvmName("formatProperty")
    set(`value`) {
      setFormat(value)
    }

  /**
   * The loop mode.
   */
  public final inline var loopMode: LoopMode
    @JvmName("loopModeProperty")
    get() = getLoopMode()
    @JvmName("loopModeProperty")
    set(`value`) {
      setLoopMode(value)
    }

  /**
   * The loop start point (in number of samples, relative to the beginning of the stream).
   */
  public final inline var loopBegin: Int
    @JvmName("loopBeginProperty")
    get() = getLoopBegin()
    @JvmName("loopBeginProperty")
    set(`value`) {
      setLoopBegin(value)
    }

  /**
   * The loop end point (in number of samples, relative to the beginning of the stream).
   */
  public final inline var loopEnd: Int
    @JvmName("loopEndProperty")
    get() = getLoopEnd()
    @JvmName("loopEndProperty")
    set(`value`) {
      setLoopEnd(value)
    }

  /**
   * The sample rate for mixing this audio. Higher values require more storage space, but result in
   * better quality.
   *
   * In games, common sample rates in use are `11025`, `16000`, `22050`, `32000`, `44100`, and
   * `48000`.
   *
   * According to the
   * [url=https://en.wikipedia.org/wiki/Nyquist&#37;E2&#37;80&#37;93Shannon_sampling_theorem]Nyquist-Shannon
   * sampling theorem[/url], there is no quality difference to human hearing when going past 40,000 Hz
   * (since most humans can only hear up to ~20,000 Hz, often less). If you are using lower-pitched
   * sounds such as voices, lower sample rates such as `32000` or `22050` may be usable with no loss in
   * quality.
   */
  public final inline var mixRate: Int
    @JvmName("mixRateProperty")
    get() = getMixRate()
    @JvmName("mixRateProperty")
    set(`value`) {
      setMixRate(value)
    }

  /**
   * If `true`, audio is stereo.
   */
  public final inline var stereo: Boolean
    @JvmName("stereoProperty")
    get() = isStereo()
    @JvmName("stereoProperty")
    set(`value`) {
      setStereo(value)
    }

  /**
   * Contains user-defined tags if found in the WAV data.
   *
   * Commonly used tags include `title`, `artist`, `album`, `tracknumber`, and `date` (`date` does
   * not have a standard date format).
   *
   * **Note:** No tag is *guaranteed* to be present in every file, so make sure to account for the
   * keys not always existing.
   *
   * **Note:** Only WAV files using a `LIST` chunk with an identifier of `INFO` to encode the tags
   * are currently supported.
   */
  public final inline var tags: Dictionary<Any?, Any?>
    @JvmName("tagsProperty")
    get() = getTags()
    @JvmName("tagsProperty")
    set(`value`) {
      setTags(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(104, scriptPtr)
  }

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = audiostreamwav.data
   * //Your changes
   * audiostreamwav.data = myCoreType
   * ``````
   *
   * Contains the audio data in bytes.
   *
   * **Note:** If [format] is set to [FORMAT_8_BITS], this property expects signed 8-bit PCM data.
   * To convert from unsigned 8-bit PCM, subtract 128 from each byte.
   *
   * **Note:** If [format] is set to [FORMAT_QOA], this property expects data from a full QOA file.
   */
  @CoreTypeHelper
  public final fun dataMutate(block: PackedByteArray.() -> Unit): PackedByteArray = data.apply {
     block(this)
     data = this
  }

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Contains the audio data in bytes.
   *
   * **Note:** If [format] is set to [FORMAT_8_BITS], this property expects signed 8-bit PCM data.
   * To convert from unsigned 8-bit PCM, subtract 128 from each byte.
   *
   * **Note:** If [format] is set to [FORMAT_QOA], this property expects data from a full QOA file.
   */
  @CoreTypeHelper
  public final fun dataMutateEach(block: (index: Int, `value`: Byte) -> Unit): PackedByteArray =
      data.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     data = this
  }

  public final fun setData(`data`: PackedByteArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.setDataPtr)
  }

  public final fun getData(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDataPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  public final fun setFormat(format: Format): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value)
    TransferContext.callMethod(MethodBindings.setFormatPtr)
  }

  public final fun getFormat(): Format {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return Format.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLoopMode(loopMode: LoopMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to loopMode.value)
    TransferContext.callMethod(MethodBindings.setLoopModePtr)
  }

  public final fun getLoopMode(): LoopMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoopModePtr)
    return LoopMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLoopBegin(loopBegin: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to loopBegin.toLong())
    TransferContext.callMethod(MethodBindings.setLoopBeginPtr)
  }

  public final fun getLoopBegin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoopBeginPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setLoopEnd(loopEnd: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to loopEnd.toLong())
    TransferContext.callMethod(MethodBindings.setLoopEndPtr)
  }

  public final fun getLoopEnd(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoopEndPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMixRate(mixRate: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mixRate.toLong())
    TransferContext.callMethod(MethodBindings.setMixRatePtr)
  }

  public final fun getMixRate(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMixRatePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setStereo(stereo: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to stereo)
    TransferContext.callMethod(MethodBindings.setStereoPtr)
  }

  public final fun isStereo(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isStereoPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTags(tags: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to tags)
    TransferContext.callMethod(MethodBindings.setTagsPtr)
  }

  public final fun getTags(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTagsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Saves the AudioStreamWAV as a WAV file to [path]. Samples with IMA ADPCM or Quite OK Audio
   * formats can't be saved.
   *
   * **Note:** A `.wav` extension is automatically appended to [path] if it is missing.
   */
  public final fun saveToWav(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.saveToWavPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamWAV::_instantiatePlayback can't be called from the JVM.")
  }

  public enum class Format(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 8-bit PCM audio codec.
     */
    FORMAT_8_BITS(0),
    /**
     * 16-bit PCM audio codec.
     */
    FORMAT_16_BITS(1),
    /**
     * Audio is lossily compressed as IMA ADPCM.
     */
    IMA_ADPCM(2),
    /**
     * Audio is lossily compressed as [url=https://qoaformat.org/]Quite OK Audio[/url].
     */
    QOA(3),
    ;

    public companion object {
      public fun from(`value`: Long): Format = entries.single { it.`value` == `value` }
    }
  }

  public enum class LoopMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Audio does not loop.
     */
    DISABLED(0),
    /**
     * Audio loops the data between [loopBegin] and [loopEnd], playing forward only.
     */
    FORWARD(1),
    /**
     * Audio loops the data between [loopBegin] and [loopEnd], playing back and forth.
     */
    PINGPONG(2),
    /**
     * Audio loops the data between [loopBegin] and [loopEnd], playing backward only.
     */
    BACKWARD(3),
    ;

    public companion object {
      public fun from(`value`: Long): LoopMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val loadFromBufferName:
        MethodStringName2<AudioStreamWAV, AudioStreamWAV?, PackedByteArray, Dictionary<Any?, Any?>>
        =
        MethodStringName2<AudioStreamWAV, AudioStreamWAV?, PackedByteArray, Dictionary<Any?, Any?>>("load_from_buffer")

    @JvmField
    public val loadFromFileName:
        MethodStringName2<AudioStreamWAV, AudioStreamWAV?, String, Dictionary<Any?, Any?>> =
        MethodStringName2<AudioStreamWAV, AudioStreamWAV?, String, Dictionary<Any?, Any?>>("load_from_file")

    @JvmField
    public val setDataName: MethodStringName1<AudioStreamWAV, Unit, PackedByteArray> =
        MethodStringName1<AudioStreamWAV, Unit, PackedByteArray>("set_data")

    @JvmField
    public val getDataName: MethodStringName0<AudioStreamWAV, PackedByteArray> =
        MethodStringName0<AudioStreamWAV, PackedByteArray>("get_data")

    @JvmField
    public val setFormatName: MethodStringName1<AudioStreamWAV, Unit, Format> =
        MethodStringName1<AudioStreamWAV, Unit, Format>("set_format")

    @JvmField
    public val getFormatName: MethodStringName0<AudioStreamWAV, Format> =
        MethodStringName0<AudioStreamWAV, Format>("get_format")

    @JvmField
    public val setLoopModeName: MethodStringName1<AudioStreamWAV, Unit, LoopMode> =
        MethodStringName1<AudioStreamWAV, Unit, LoopMode>("set_loop_mode")

    @JvmField
    public val getLoopModeName: MethodStringName0<AudioStreamWAV, LoopMode> =
        MethodStringName0<AudioStreamWAV, LoopMode>("get_loop_mode")

    @JvmField
    public val setLoopBeginName: MethodStringName1<AudioStreamWAV, Unit, Int> =
        MethodStringName1<AudioStreamWAV, Unit, Int>("set_loop_begin")

    @JvmField
    public val getLoopBeginName: MethodStringName0<AudioStreamWAV, Int> =
        MethodStringName0<AudioStreamWAV, Int>("get_loop_begin")

    @JvmField
    public val setLoopEndName: MethodStringName1<AudioStreamWAV, Unit, Int> =
        MethodStringName1<AudioStreamWAV, Unit, Int>("set_loop_end")

    @JvmField
    public val getLoopEndName: MethodStringName0<AudioStreamWAV, Int> =
        MethodStringName0<AudioStreamWAV, Int>("get_loop_end")

    @JvmField
    public val setMixRateName: MethodStringName1<AudioStreamWAV, Unit, Int> =
        MethodStringName1<AudioStreamWAV, Unit, Int>("set_mix_rate")

    @JvmField
    public val getMixRateName: MethodStringName0<AudioStreamWAV, Int> =
        MethodStringName0<AudioStreamWAV, Int>("get_mix_rate")

    @JvmField
    public val setStereoName: MethodStringName1<AudioStreamWAV, Unit, Boolean> =
        MethodStringName1<AudioStreamWAV, Unit, Boolean>("set_stereo")

    @JvmField
    public val isStereoName: MethodStringName0<AudioStreamWAV, Boolean> =
        MethodStringName0<AudioStreamWAV, Boolean>("is_stereo")

    @JvmField
    public val setTagsName: MethodStringName1<AudioStreamWAV, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<AudioStreamWAV, Unit, Dictionary<Any?, Any?>>("set_tags")

    @JvmField
    public val getTagsName: MethodStringName0<AudioStreamWAV, Dictionary<Any?, Any?>> =
        MethodStringName0<AudioStreamWAV, Dictionary<Any?, Any?>>("get_tags")

    @JvmField
    public val saveToWavName: MethodStringName1<AudioStreamWAV, Error, String> =
        MethodStringName1<AudioStreamWAV, Error, String>("save_to_wav")

    /**
     * Creates a new [AudioStreamWAV] instance from the given buffer. The buffer must contain WAV
     * data.
     *
     * The keys and values of [options] match the properties of [ResourceImporterWAV]. The usage of
     * [options] is identical to [AudioStreamWAV.loadFromFile].
     */
    @JvmOverloads
    @JvmStatic
    public final fun loadFromBuffer(streamData: PackedByteArray, options: Dictionary<Any?, Any?> =
        Dictionary()): AudioStreamWAV? {
      TransferContext.writeMethodArguments(0L, 0L, PACKED_BYTE_ARRAY to streamData, DICTIONARY to options)
      TransferContext.callMethod(MethodBindings.loadFromBufferPtr)
      return (TransferContext.readReturnValue(OBJECT) as AudioStreamWAV?)
    }

    /**
     * Creates a new [AudioStreamWAV] instance from the given file path. The file must be in WAV
     * format.
     *
     * The keys and values of [options] match the properties of [ResourceImporterWAV].
     *
     * **Example:** Load the first file dropped as a WAV and play it:
     *
     * ```
     * @onready var audio_player = $AudioStreamPlayer
     *
     * func _ready():
     * 	get_window().files_dropped.connect(_on_files_dropped)
     *
     * func _on_files_dropped(files):
     * 	if files[0].get_extension() == "wav":
     * 		audio_player.stream = AudioStreamWAV.load_from_file(files[0], {
     * 				"force/max_rate": true,
     * 				"force/max_rate_hz": 11025
     * 			})
     * 		audio_player.play()
     * ```
     */
    @JvmOverloads
    @JvmStatic
    public final fun loadFromFile(path: String, options: Dictionary<Any?, Any?> = Dictionary()):
        AudioStreamWAV? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path, DICTIONARY to options)
      TransferContext.callMethod(MethodBindings.loadFromFilePtr)
      return (TransferContext.readReturnValue(OBJECT) as AudioStreamWAV?)
    }
  }

  public object MethodBindings {
    internal val loadFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "load_from_buffer", 4266838938)

    internal val loadFromFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "load_from_file", 4015802384)

    internal val setDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_data", 2971499966)

    internal val getDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_data", 2362200018)

    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_format", 60648488)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_format", 3151724922)

    internal val setLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_loop_mode", 2444882972)

    internal val getLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_loop_mode", 393560655)

    internal val setLoopBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_loop_begin", 1286410249)

    internal val getLoopBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_loop_begin", 3905245786)

    internal val setLoopEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_loop_end", 1286410249)

    internal val getLoopEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_loop_end", 3905245786)

    internal val setMixRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_mix_rate", 1286410249)

    internal val getMixRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_mix_rate", 3905245786)

    internal val setStereoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_stereo", 2586408642)

    internal val isStereoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "is_stereo", 36873697)

    internal val setTagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "set_tags", 4155329257)

    internal val getTagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "get_tags", 3102165223)

    internal val saveToWavPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamWAV", "save_to_wav", 166001499)
  }
}
