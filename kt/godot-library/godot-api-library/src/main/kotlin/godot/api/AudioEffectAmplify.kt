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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Increases or decreases the volume being routed through the audio bus.
 */
@GodotBaseType
public open class AudioEffectAmplify : AudioEffect() {
  /**
   * Amount of amplification in dB. Positive values make the sound louder, negative values make it
   * quieter. Value can range from -80 to 24.
   */
  public final inline var volumeDb: Float
    @JvmName("volumeDbProperty")
    get() = getVolumeDb()
    @JvmName("volumeDbProperty")
    set(`value`) {
      setVolumeDb(value)
    }

  /**
   * Amount of amplification as a linear value.
   *
   * **Note:** This member modifies [volumeDb] for convenience. The returned value is equivalent to
   * the result of [@GlobalScope.dbToLinear] on [volumeDb]. Setting this member is equivalent to
   * setting [volumeDb] to the result of [@GlobalScope.linearToDb] on a value.
   */
  public final inline var volumeLinear: Float
    @JvmName("volumeLinearProperty")
    get() = getVolumeLinear()
    @JvmName("volumeLinearProperty")
    set(`value`) {
      setVolumeLinear(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(47, scriptPtr)
  }

  public final fun setVolumeDb(volume: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, volume.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setVolumeDbPtr, 0)
  }

  public final fun getVolumeDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVolumeDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setVolumeLinear(volume: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, volume.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setVolumeLinearPtr, 0)
  }

  public final fun getVolumeLinear(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVolumeLinearPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectAmplify::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setVolumeDbName: MethodStringName1<AudioEffectAmplify, Unit, Float> =
        MethodStringName1<AudioEffectAmplify, Unit, Float>("set_volume_db")

    @JvmField
    public val getVolumeDbName: MethodStringName0<AudioEffectAmplify, Float> =
        MethodStringName0<AudioEffectAmplify, Float>("get_volume_db")

    @JvmField
    public val setVolumeLinearName: MethodStringName1<AudioEffectAmplify, Unit, Float> =
        MethodStringName1<AudioEffectAmplify, Unit, Float>("set_volume_linear")

    @JvmField
    public val getVolumeLinearName: MethodStringName0<AudioEffectAmplify, Float> =
        MethodStringName0<AudioEffectAmplify, Float>("get_volume_linear")
  }

  public object MethodBindings {
    internal val setVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectAmplify", "set_volume_db", 373806689)

    internal val getVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectAmplify", "get_volume_db", 1740695150)

    internal val setVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectAmplify", "set_volume_linear", 373806689)

    internal val getVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectAmplify", "get_volume_linear", 1740695150)
  }
}
