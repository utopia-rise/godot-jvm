// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Particle emitter nodes can be used in "start" step of particle shaders and they define the
 * starting position of the particles. Connect them to the Position output port.
 */
@GodotBaseType
public open class VisualShaderNodeParticleEmitter internal constructor() : VisualShaderNode() {
  /**
   * If `true`, the result of this emitter is projected to 2D space. By default it is `false` and
   * meant for use in 3D space.
   */
  public final inline var mode2d: Boolean
    @JvmName("mode2dProperty")
    get() = isMode2d()
    @JvmName("mode2dProperty")
    set(`value`) {
      setMode2d(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(854, scriptPtr)
  }

  public final fun setMode2d(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setMode2dPtr, enabled)
  }

  public final fun isMode2d(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isMode2dPtr)

  public companion object {
    @JvmField
    public val setMode2dName: MethodStringName1<VisualShaderNodeParticleEmitter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeParticleEmitter, Unit, Boolean>("set_mode_2d")

    @JvmField
    public val isMode2dName: MethodStringName0<VisualShaderNodeParticleEmitter, Boolean> =
        MethodStringName0<VisualShaderNodeParticleEmitter, Boolean>("is_mode_2d")
  }

  public object MethodBindings {
    internal val setMode2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleEmitter", "set_mode_2d", 2586408642)

    internal val isMode2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleEmitter", "is_mode_2d", 36873697)
  }
}
