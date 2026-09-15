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
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING_NAME
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Playback component of [AudioStreamInteractive]. Contains functions to change the currently played
 * clip.
 */
@GodotBaseType
public open class AudioStreamPlaybackInteractive internal constructor() : AudioStreamPlayback() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(89, scriptPtr)
  }

  /**
   * Switch to a clip (by name).
   */
  public final fun switchToClipByName(clipName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, clipName)
    TransferContext.callMethod(MethodBindings.switchToClipByNamePtr)
  }

  /**
   * Switch to a clip (by index).
   */
  public final fun switchToClip(clipIndex: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, clipIndex.toLong())
    TransferContext.callMethod(MethodBindings.switchToClipPtr)
  }

  /**
   * Return the index of the currently playing clip. You can use this to get the name of the
   * currently playing clip with [AudioStreamInteractive.getClipName].
   *
   * **Example:** Get the currently playing clip name from inside an [AudioStreamPlayer] node.
   *
   * ```gdscript
   * //gdscript
   * var playing_clip_name = stream.get_clip_name(get_stream_playback().get_current_clip_index())
   * ```
   */
  public final fun getCurrentClipIndex(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentClipIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _start(fromPos: Double): Unit {
    throw NotImplementedError("AudioStreamPlaybackInteractive::_start can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _stop(): Unit {
    throw NotImplementedError("AudioStreamPlaybackInteractive::_stop can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _isPlaying(): Boolean {
    throw NotImplementedError("AudioStreamPlaybackInteractive::_isPlaying can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getPlaybackPosition(): Double {
    throw NotImplementedError("AudioStreamPlaybackInteractive::_getPlaybackPosition can't be called from the JVM.")
  }

  /**
   * Switch to a clip (by name).
   */
  public final fun switchToClipByName(clipName: String) =
      switchToClipByName(clipName.asCachedStringName())

  public companion object {
    @JvmField
    public val switchToClipByNameName:
        MethodStringName1<AudioStreamPlaybackInteractive, Unit, StringName> =
        MethodStringName1<AudioStreamPlaybackInteractive, Unit, StringName>("switch_to_clip_by_name")

    @JvmField
    public val switchToClipName: MethodStringName1<AudioStreamPlaybackInteractive, Unit, Int> =
        MethodStringName1<AudioStreamPlaybackInteractive, Unit, Int>("switch_to_clip")

    @JvmField
    public val getCurrentClipIndexName: MethodStringName0<AudioStreamPlaybackInteractive, Int> =
        MethodStringName0<AudioStreamPlaybackInteractive, Int>("get_current_clip_index")
  }

  public object MethodBindings {
    internal val switchToClipByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaybackInteractive", "switch_to_clip_by_name", 3304788590)

    internal val switchToClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaybackInteractive", "switch_to_clip", 1286410249)

    internal val getCurrentClipIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaybackInteractive", "get_current_clip_index", 3905245786)
  }
}
