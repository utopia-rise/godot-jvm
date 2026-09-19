// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * Playback component of [AudioStreamOggVorbis]. Uses [OggPacketSequencePlayback] for playback data.
 */
@GodotBaseType
public open class AudioStreamPlaybackOggVorbis : AudioStreamPlaybackResampled() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(90, scriptPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getStreamSamplingRate(): Float {
    throw NotImplementedError("AudioStreamPlaybackOggVorbis::_getStreamSamplingRate can't be called from the JVM.")
  }

  public companion object

  public object MethodBindings
}
