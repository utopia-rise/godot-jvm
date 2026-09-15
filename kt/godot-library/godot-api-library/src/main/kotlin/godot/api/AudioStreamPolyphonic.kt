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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * AudioStream that lets the user play custom streams at any time from code, simultaneously using a
 * single player.
 *
 * Playback control is done via the [AudioStreamPlaybackPolyphonic] instance set inside the player,
 * which can be obtained via [AudioStreamPlayer.getStreamPlayback],
 * [AudioStreamPlayer2D.getStreamPlayback] or [AudioStreamPlayer3D.getStreamPlayback] methods.
 * Obtaining the playback instance is only valid after the `stream` property is set as an
 * [AudioStreamPolyphonic] in those players.
 */
@GodotBaseType
public open class AudioStreamPolyphonic : AudioStream() {
  /**
   * Maximum amount of simultaneous streams that can be played.
   */
  public final inline var polyphony: Int
    @JvmName("polyphonyProperty")
    get() = getPolyphony()
    @JvmName("polyphonyProperty")
    set(`value`) {
      setPolyphony(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(99, scriptPtr)
  }

  public final fun setPolyphony(voices: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voices.toLong())
    TransferContext.callPtrMethod(MethodBindings.setPolyphonyPtr, 0)
  }

  public final fun getPolyphony(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPolyphonyPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamPolyphonic::_instantiatePlayback can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setPolyphonyName: MethodStringName1<AudioStreamPolyphonic, Unit, Int> =
        MethodStringName1<AudioStreamPolyphonic, Unit, Int>("set_polyphony")

    @JvmField
    public val getPolyphonyName: MethodStringName0<AudioStreamPolyphonic, Int> =
        MethodStringName0<AudioStreamPolyphonic, Int>("get_polyphony")
  }

  public object MethodBindings {
    internal val setPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPolyphonic", "set_polyphony", 1286410249)

    internal val getPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPolyphonic", "get_polyphony", 3905245786)
  }
}
