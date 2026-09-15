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
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Particle collision shapes can be used to make particles stop or bounce against them.
 *
 * Particle collision shapes work in real-time and can be moved, rotated and scaled during gameplay.
 * Unlike attractors, non-uniform scaling of collision shapes is *not* supported.
 *
 * Particle collision shapes can be temporarily disabled by hiding them.
 *
 * **Note:** [ParticleProcessMaterial.collisionMode] must be
 * [ParticleProcessMaterial.COLLISION_RIGID] or [ParticleProcessMaterial.COLLISION_HIDE_ON_CONTACT] on
 * the [GPUParticles3D]'s process material for collision to work.
 *
 * **Note:** Particle collision only affects [GPUParticles3D], not [CPUParticles3D].
 *
 * **Note:** Particles pushed by a collider that is being moved will not be interpolated, which can
 * result in visible stuttering. This can be alleviated by setting [GPUParticles3D.fixedFps] to `0` or
 * a value that matches or exceeds the target framerate.
 */
@GodotBaseType
public open class GPUParticlesCollision3D internal constructor() : VisualInstance3D() {
  /**
   * The particle rendering layers ([VisualInstance3D.layers]) that will be affected by the
   * collision shape. By default, all particles that have [ParticleProcessMaterial.collisionMode] set
   * to [ParticleProcessMaterial.COLLISION_RIGID] or
   * [ParticleProcessMaterial.COLLISION_HIDE_ON_CONTACT] will be affected by a collision shape.
   *
   * After configuring particle nodes accordingly, specific layers can be unchecked to prevent
   * certain particles from being affected by colliders. For example, this can be used if you're using
   * a collider as part of a spell effect but don't want the collider to affect unrelated weather
   * particles at the same position.
   *
   * Particle collision can also be disabled on a per-process material basis by setting
   * [ParticleProcessMaterial.collisionMode] on the [GPUParticles3D] node.
   */
  public final inline var cullMask: Long
    @JvmName("cullMaskProperty")
    get() = getCullMask()
    @JvmName("cullMaskProperty")
    set(`value`) {
      setCullMask(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(263, scriptPtr)
  }

  public final fun setCullMask(mask: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mask)
    TransferContext.callMethod(MethodBindings.setCullMaskPtr)
  }

  public final fun getCullMask(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCullMaskPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val setCullMaskName: MethodStringName1<GPUParticlesCollision3D, Unit, Long> =
        MethodStringName1<GPUParticlesCollision3D, Unit, Long>("set_cull_mask")

    @JvmField
    public val getCullMaskName: MethodStringName0<GPUParticlesCollision3D, Long> =
        MethodStringName0<GPUParticlesCollision3D, Long>("get_cull_mask")
  }

  public object MethodBindings {
    internal val setCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollision3D", "set_cull_mask", 1286410249)

    internal val getCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollision3D", "get_cull_mask", 3905245786)
  }
}
