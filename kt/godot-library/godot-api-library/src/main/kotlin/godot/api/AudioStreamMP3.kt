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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedByteArray
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Boolean
import kotlin.Byte
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * MP3 audio stream driver. See [data] if you want to load an MP3 file at run-time. More info can be
 * found in [ResourceImporterMP3].
 *
 * **Note:** This class can optionally support legacy MP1 and MP2 formats, provided that the engine
 * is compiled with the `minimp3_extra_formats=yes` SCons option. These extra formats are not enabled
 * by default.
 */
@GodotBaseType
public open class AudioStreamMP3 : AudioStream() {
  /**
   * Contains the audio data in bytes.
   *
   * You can load a file without having to import it beforehand using the code snippet below. Keep
   * in mind that this snippet loads the whole file into memory and may not be ideal for huge files
   * (hundreds of megabytes or more).
   *
   * ```gdscript
   * //gdscript
   * func load_mp3(path):
   * 	var file = FileAccess.open(path, FileAccess.READ)
   * 	var sound = AudioStreamMP3.new()
   * 	sound.data = file.get_buffer(file.get_length())
   * 	return sound
   * ```
   *
   * ```csharp
   * //csharp
   * public AudioStreamMP3 LoadMP3(string path)
   * {
   * 	using var file = FileAccess.Open(path, FileAccess.ModeFlags.Read);
   * 	var sound = new AudioStreamMP3();
   * 	sound.Data = file.GetBuffer(file.GetLength());
   * 	return sound;
   * }
   * ```
   *
   *
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

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = audiostreammp3.data
   * //Your changes
   * audiostreammp3.data = myCoreType
   * ``````
   *
   * Contains the audio data in bytes.
   *
   * You can load a file without having to import it beforehand using the code snippet below. Keep
   * in mind that this snippet loads the whole file into memory and may not be ideal for huge files
   * (hundreds of megabytes or more).
   *
   * ```gdscript
   * //gdscript
   * func load_mp3(path):
   * 	var file = FileAccess.open(path, FileAccess.READ)
   * 	var sound = AudioStreamMP3.new()
   * 	sound.data = file.get_buffer(file.get_length())
   * 	return sound
   * ```
   *
   * ```csharp
   * //csharp
   * public AudioStreamMP3 LoadMP3(string path)
   * {
   * 	using var file = FileAccess.Open(path, FileAccess.ModeFlags.Read);
   * 	var sound = new AudioStreamMP3();
   * 	sound.Data = file.GetBuffer(file.GetLength());
   * 	return sound;
   * }
   * ```
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
   * You can load a file without having to import it beforehand using the code snippet below. Keep
   * in mind that this snippet loads the whole file into memory and may not be ideal for huge files
   * (hundreds of megabytes or more).
   *
   * ```gdscript
   * //gdscript
   * func load_mp3(path):
   * 	var file = FileAccess.open(path, FileAccess.READ)
   * 	var sound = AudioStreamMP3.new()
   * 	sound.data = file.get_buffer(file.get_length())
   * 	return sound
   * ```
   *
   * ```csharp
   * //csharp
   * public AudioStreamMP3 LoadMP3(string path)
   * {
   * 	using var file = FileAccess.Open(path, FileAccess.ModeFlags.Read);
   * 	var sound = new AudioStreamMP3();
   * 	sound.Data = file.GetBuffer(file.GetLength());
   * 	return sound;
   * }
   * ```
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

  public final fun setLoop(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setLoopPtr)
  }

  public final fun hasLoop(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasLoopPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLoopOffset(seconds: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to seconds)
    TransferContext.callMethod(MethodBindings.setLoopOffsetPtr)
  }

  public final fun getLoopOffset(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoopOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setBpm(bpm: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to bpm)
    TransferContext.callMethod(MethodBindings.setBpmPtr)
  }

  public final fun getBpm(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBpmPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setBeatCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setBeatCountPtr)
  }

  public final fun getBeatCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBeatCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setBarBeats(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setBarBeatsPtr)
  }

  public final fun getBarBeats(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBarBeatsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamMP3::_instantiatePlayback can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val loadFromBufferName:
        MethodStringName1<AudioStreamMP3, AudioStreamMP3?, PackedByteArray> =
        MethodStringName1<AudioStreamMP3, AudioStreamMP3?, PackedByteArray>("load_from_buffer")

    @JvmField
    public val loadFromFileName: MethodStringName1<AudioStreamMP3, AudioStreamMP3?, String> =
        MethodStringName1<AudioStreamMP3, AudioStreamMP3?, String>("load_from_file")

    @JvmField
    public val setDataName: MethodStringName1<AudioStreamMP3, Unit, PackedByteArray> =
        MethodStringName1<AudioStreamMP3, Unit, PackedByteArray>("set_data")

    @JvmField
    public val getDataName: MethodStringName0<AudioStreamMP3, PackedByteArray> =
        MethodStringName0<AudioStreamMP3, PackedByteArray>("get_data")

    @JvmField
    public val setLoopName: MethodStringName1<AudioStreamMP3, Unit, Boolean> =
        MethodStringName1<AudioStreamMP3, Unit, Boolean>("set_loop")

    @JvmField
    public val hasLoopName: MethodStringName0<AudioStreamMP3, Boolean> =
        MethodStringName0<AudioStreamMP3, Boolean>("has_loop")

    @JvmField
    public val setLoopOffsetName: MethodStringName1<AudioStreamMP3, Unit, Double> =
        MethodStringName1<AudioStreamMP3, Unit, Double>("set_loop_offset")

    @JvmField
    public val getLoopOffsetName: MethodStringName0<AudioStreamMP3, Double> =
        MethodStringName0<AudioStreamMP3, Double>("get_loop_offset")

    @JvmField
    public val setBpmName: MethodStringName1<AudioStreamMP3, Unit, Double> =
        MethodStringName1<AudioStreamMP3, Unit, Double>("set_bpm")

    @JvmField
    public val getBpmName: MethodStringName0<AudioStreamMP3, Double> =
        MethodStringName0<AudioStreamMP3, Double>("get_bpm")

    @JvmField
    public val setBeatCountName: MethodStringName1<AudioStreamMP3, Unit, Int> =
        MethodStringName1<AudioStreamMP3, Unit, Int>("set_beat_count")

    @JvmField
    public val getBeatCountName: MethodStringName0<AudioStreamMP3, Int> =
        MethodStringName0<AudioStreamMP3, Int>("get_beat_count")

    @JvmField
    public val setBarBeatsName: MethodStringName1<AudioStreamMP3, Unit, Int> =
        MethodStringName1<AudioStreamMP3, Unit, Int>("set_bar_beats")

    @JvmField
    public val getBarBeatsName: MethodStringName0<AudioStreamMP3, Int> =
        MethodStringName0<AudioStreamMP3, Int>("get_bar_beats")

    /**
     * Creates a new [AudioStreamMP3] instance from the given buffer. The buffer must contain MP3
     * data.
     */
    @JvmStatic
    public final fun loadFromBuffer(streamData: PackedByteArray): AudioStreamMP3? {
      TransferContext.writeMethodArguments(0L, 0L, PACKED_BYTE_ARRAY to streamData)
      TransferContext.callMethod(MethodBindings.loadFromBufferPtr)
      return (TransferContext.readReturnValue(OBJECT) as AudioStreamMP3?)
    }

    /**
     * Creates a new [AudioStreamMP3] instance from the given file path. The file must be in MP3
     * format.
     */
    @JvmStatic
    public final fun loadFromFile(path: String): AudioStreamMP3? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.loadFromFilePtr)
      return (TransferContext.readReturnValue(OBJECT) as AudioStreamMP3?)
    }
  }

  public object MethodBindings {
    internal val loadFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "load_from_buffer", 1674970313)

    internal val loadFromFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "load_from_file", 4238362998)

    internal val setDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "set_data", 2971499966)

    internal val getDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "get_data", 2362200018)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "set_loop", 2586408642)

    internal val hasLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "has_loop", 36873697)

    internal val setLoopOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "set_loop_offset", 373806689)

    internal val getLoopOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "get_loop_offset", 1740695150)

    internal val setBpmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "set_bpm", 373806689)

    internal val getBpmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "get_bpm", 1740695150)

    internal val setBeatCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "set_beat_count", 1286410249)

    internal val getBeatCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "get_beat_count", 3905245786)

    internal val setBarBeatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "set_bar_beats", 1286410249)

    internal val getBarBeatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamMP3", "get_bar_beats", 3905245786)
  }
}
