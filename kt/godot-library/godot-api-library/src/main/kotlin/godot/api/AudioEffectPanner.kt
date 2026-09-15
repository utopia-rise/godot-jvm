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
import godot.core.VariantParser.DOUBLE
import kotlin.Double
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Determines how much of the audio signal is sent to the left and right channels. This helps with
 * audio spatialization, giving sounds distinct places in a mix.
 *
 * [AudioStreamPlayer2D] and [AudioStreamPlayer3D] handle panning automatically, following where the
 * source of the sound is on the screen.
 */
@GodotBaseType
public open class AudioEffectPanner : AudioEffect() {
  /**
   * Pan position. Negative values pan the sound to the left, positive pan to the right. Value can
   * range from -1 to 1.
   */
  public final inline var pan: Float
    @JvmName("panProperty")
    get() = getPan()
    @JvmName("panProperty")
    set(`value`) {
      setPan(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(68, scriptPtr)
  }

  public final fun setPan(cpanume: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to cpanume.toDouble())
    TransferContext.callMethod(MethodBindings.setPanPtr)
  }

  public final fun getPan(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPanPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectPanner::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setPanName: MethodStringName1<AudioEffectPanner, Unit, Float> =
        MethodStringName1<AudioEffectPanner, Unit, Float>("set_pan")

    @JvmField
    public val getPanName: MethodStringName0<AudioEffectPanner, Float> =
        MethodStringName0<AudioEffectPanner, Float>("get_pan")
  }

  public object MethodBindings {
    internal val setPanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPanner", "set_pan", 373806689)

    internal val getPanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPanner", "get_pan", 1740695150)
  }
}
