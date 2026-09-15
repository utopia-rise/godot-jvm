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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.Signal0
import godot.core.VariantArray
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class for audio streams. Audio streams are used for sound effects and music playback, and
 * support WAV (via [AudioStreamWAV]), Ogg (via [AudioStreamOggVorbis]), and MP3 (via [AudioStreamMP3])
 * file formats.
 */
@GodotBaseType
public abstract class AudioStream : Resource() {
  /**
   * Signal to be emitted to notify when the parameter list changed.
   */
  public val parameterListChanged: Signal0 by Signal0

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(81, scriptPtr)
  }

  /**
   * Override this method to customize the returned value of [instantiatePlayback]. Should return a
   * new [AudioStreamPlayback] created when the stream is played (such as by an [AudioStreamPlayer]).
   */
  public abstract fun _instantiatePlayback(): AudioStreamPlayback?

  /**
   * Override this method to customize the name assigned to this audio stream. Unused by the engine.
   */
  public open fun _getStreamName(): String {
    throw NotImplementedError("AudioStream::_getStreamName is not implemented.")
  }

  /**
   * Override this method to customize the returned value of [getLength]. Should return the length
   * of this audio stream, in seconds.
   */
  public open fun _getLength(): Double {
    throw NotImplementedError("AudioStream::_getLength is not implemented.")
  }

  /**
   * Override this method to customize the returned value of [isMonophonic]. Should return `true` if
   * this audio stream only supports one channel.
   */
  public open fun _isMonophonic(): Boolean {
    throw NotImplementedError("AudioStream::_isMonophonic is not implemented.")
  }

  /**
   * Overridable method. Should return the tempo of this audio stream, in beats per minute (BPM).
   * Used by the engine to determine the position of every beat.
   *
   * Ideally, the returned value should be based off the stream's sample rate
   * ([AudioStreamWAV.mixRate], for example).
   */
  public open fun _getBpm(): Double {
    throw NotImplementedError("AudioStream::_getBpm is not implemented.")
  }

  /**
   * Overridable method. Should return the total number of beats of this audio stream. Used by the
   * engine to determine the position of every beat.
   *
   * Ideally, the returned value should be based off the stream's sample rate
   * ([AudioStreamWAV.mixRate], for example).
   */
  public open fun _getBeatCount(): Int {
    throw NotImplementedError("AudioStream::_getBeatCount is not implemented.")
  }

  /**
   * Override this method to customize the tags for this audio stream. Should return a [Dictionary]
   * of strings with the tag as the key and its content as the value.
   *
   * Commonly used tags include `title`, `artist`, `album`, `tracknumber`, and `date`.
   */
  public open fun _getTags(): Dictionary<Any?, Any?> {
    throw NotImplementedError("AudioStream::_getTags is not implemented.")
  }

  /**
   * Return the controllable parameters of this stream. This array contains dictionaries with a
   * property info description format (see [Object.getPropertyList]). Additionally, the default value
   * for this parameter must be added tho each dictionary in "default_value" field.
   */
  public open fun _getParameterList(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("AudioStream::_getParameterList is not implemented.")
  }

  /**
   * Override this method to return `true` if this stream has a loop.
   */
  public open fun _hasLoop(): Boolean {
    throw NotImplementedError("AudioStream::_hasLoop is not implemented.")
  }

  /**
   * Override this method to return the bar beats of this stream.
   */
  public open fun _getBarBeats(): Int {
    throw NotImplementedError("AudioStream::_getBarBeats is not implemented.")
  }

  /**
   * Returns the length of the audio stream in seconds. If this stream is an
   * [AudioStreamRandomizer], returns the length of the last played stream. If this stream has an
   * indefinite length (such as for [AudioStreamGenerator] and [AudioStreamMicrophone]), returns `0.0`.
   */
  public final fun getLength(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLengthPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Returns `true` if this audio stream only supports one channel (*monophony*), or `false` if the
   * audio stream supports two or more channels (*polyphony*).
   */
  public final fun isMonophonic(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMonophonicPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a newly created [AudioStreamPlayback] intended to play this audio stream. Useful for
   * when you want to extend [_instantiatePlayback] but call [instantiatePlayback] from an internally
   * held AudioStream subresource. An example of this can be found in the source code for
   * `AudioStreamRandomPitch::instantiate_playback`.
   */
  public final fun instantiatePlayback(): AudioStreamPlayback? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.instantiatePlaybackPtr)
    return (TransferContext.readReturnValue_OBJECT() as AudioStreamPlayback?)
  }

  /**
   * Returns if the current [AudioStream] can be used as a sample. Only static streams can be
   * sampled.
   */
  public final fun canBeSampled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canBeSampledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Generates an [AudioSample] based on the current stream.
   */
  public final fun generateSample(): AudioSample? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.generateSamplePtr)
    return (TransferContext.readReturnValue_OBJECT() as AudioSample?)
  }

  /**
   * Returns `true` if the stream is a collection of other streams, `false` otherwise.
   */
  public final fun isMetaStream(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMetaStreamPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val getLengthName: MethodStringName0<AudioStream, Double> =
        MethodStringName0<AudioStream, Double>("get_length")

    @JvmField
    public val isMonophonicName: MethodStringName0<AudioStream, Boolean> =
        MethodStringName0<AudioStream, Boolean>("is_monophonic")

    @JvmField
    public val instantiatePlaybackName: MethodStringName0<AudioStream, AudioStreamPlayback?> =
        MethodStringName0<AudioStream, AudioStreamPlayback?>("instantiate_playback")

    @JvmField
    public val canBeSampledName: MethodStringName0<AudioStream, Boolean> =
        MethodStringName0<AudioStream, Boolean>("can_be_sampled")

    @JvmField
    public val generateSampleName: MethodStringName0<AudioStream, AudioSample?> =
        MethodStringName0<AudioStream, AudioSample?>("generate_sample")

    @JvmField
    public val isMetaStreamName: MethodStringName0<AudioStream, Boolean> =
        MethodStringName0<AudioStream, Boolean>("is_meta_stream")
  }

  public object MethodBindings {
    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStream", "get_length", 1740695150)

    internal val isMonophonicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStream", "is_monophonic", 36873697)

    internal val instantiatePlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStream", "instantiate_playback", 210135309)

    internal val canBeSampledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStream", "can_be_sampled", 36873697)

    internal val generateSamplePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStream", "generate_sample", 2646048999)

    internal val isMetaStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStream", "is_meta_stream", 36873697)
  }
}

internal class AudioStreamDummy : AudioStream() {
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStream::_instantiatePlayback is only implemented by non-JVM code.")
  }
}
