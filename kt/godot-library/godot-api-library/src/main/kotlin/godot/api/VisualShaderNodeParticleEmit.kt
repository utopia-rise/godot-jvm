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
 * This node internally calls `emit_subparticle` shader method. It will emit a particle from the
 * configured sub-emitter and also allows to customize how its emitted. Requires a sub-emitter assigned
 * to the particles node with this shader.
 */
@GodotBaseType
public open class VisualShaderNodeParticleEmit : VisualShaderNode() {
  /**
   * Flags used to override the properties defined in the sub-emitter's process material.
   */
  public final inline var flags: EmitFlags
    @JvmName("flagsProperty")
    get() = getFlags()
    @JvmName("flagsProperty")
    set(`value`) {
      setFlags(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(853, scriptPtr)
  }

  public final fun setFlags(flags: EmitFlags): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFlagsPtr, flags.value)
  }

  public final fun getFlags(): EmitFlags =
      EmitFlags.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFlagsPtr))

  public enum class EmitFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If enabled, the particle starts with the position defined by this node.
     */
    POSITION(1),
    /**
     * If enabled, the particle starts with the rotation and scale defined by this node.
     */
    ROT_SCALE(2),
    /**
     * If enabled,the particle starts with the velocity defined by this node.
     */
    VELOCITY(4),
    /**
     * If enabled, the particle starts with the color defined by this node.
     */
    COLOR(8),
    /**
     * If enabled, the particle starts with the `CUSTOM` data defined by this node.
     */
    CUSTOM(16),
    ;

    public companion object {
      public fun from(`value`: Long): EmitFlags = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFlagsName: MethodStringName1<VisualShaderNodeParticleEmit, Unit, EmitFlags> =
        MethodStringName1<VisualShaderNodeParticleEmit, Unit, EmitFlags>("set_flags")

    @JvmField
    public val getFlagsName: MethodStringName0<VisualShaderNodeParticleEmit, EmitFlags> =
        MethodStringName0<VisualShaderNodeParticleEmit, EmitFlags>("get_flags")
  }

  public object MethodBindings {
    internal val setFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleEmit", "set_flags", 3960756792)

    internal val getFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleEmit", "get_flags", 171277835)
  }
}
