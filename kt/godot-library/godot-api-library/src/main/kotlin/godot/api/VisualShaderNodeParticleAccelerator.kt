// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Particle accelerator can be used in "process" step of particle shader. It will accelerate the
 * particles. Connect it to the Velocity output port.
 */
@GodotBaseType
public open class VisualShaderNodeParticleAccelerator : VisualShaderNode() {
  /**
   * Defines in what manner the particles will be accelerated.
   */
  public final inline var mode: Mode
    @JvmName("modeProperty")
    get() = getMode()
    @JvmName("modeProperty")
    set(`value`) {
      setMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(850, scriptPtr)
  }

  public final fun setMode(mode: Mode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setModePtr, mode.value)
  }

  public final fun getMode(): Mode =
      Mode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getModePtr))

  public enum class Mode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The particles will be accelerated based on their velocity.
     */
    LINEAR(0),
    /**
     * The particles will be accelerated towards or away from the center.
     */
    RADIAL(1),
    /**
     * The particles will be accelerated tangentially to the radius vector from center to their
     * position.
     */
    TANGENTIAL(2),
    /**
     * Represents the size of the [Mode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): Mode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setModeName: MethodStringName1<VisualShaderNodeParticleAccelerator, Unit, Mode> =
        MethodStringName1<VisualShaderNodeParticleAccelerator, Unit, Mode>("set_mode")

    @JvmField
    public val getModeName: MethodStringName0<VisualShaderNodeParticleAccelerator, Mode> =
        MethodStringName0<VisualShaderNodeParticleAccelerator, Mode>("get_mode")
  }

  public object MethodBindings {
    internal val setModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleAccelerator", "set_mode", 3457585749)

    internal val getModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleAccelerator", "get_mode", 2660365633)
  }
}
