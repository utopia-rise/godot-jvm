// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Particle attractors can be used to attract particles towards the attractor's origin, or to push
 * them away from the attractor's origin.
 *
 * Particle attractors work in real-time and can be moved, rotated and scaled during gameplay.
 * Unlike collision shapes, non-uniform scaling of attractors is also supported.
 *
 * Attractors can be temporarily disabled by hiding them, or by setting their [strength] to `0.0`.
 *
 * **Note:** Particle attractors only affect [GPUParticles3D], not [CPUParticles3D].
 */
@GodotBaseType
public open class GPUParticlesAttractor3D internal constructor() : VisualInstance3D() {
  /**
   * Adjusts the strength of the attractor. If [strength] is negative, particles will be pushed in
   * the opposite direction. Particles will be pushed *away* from the attractor's origin if
   * [directionality] is `0.0`, or towards local +Z if [directionality] is greater than `0.0`.
   */
  public final inline var strength: Float
    @JvmName("strengthProperty")
    get() = getStrength()
    @JvmName("strengthProperty")
    set(`value`) {
      setStrength(value)
    }

  /**
   * The particle attractor's attenuation. Higher values result in more gradual pushing of particles
   * as they come closer to the attractor's origin. Zero or negative values will cause particles to be
   * pushed very fast as soon as the touch the attractor's edges.
   */
  public final inline var attenuation: Float
    @JvmName("attenuationProperty")
    get() = getAttenuation()
    @JvmName("attenuationProperty")
    set(`value`) {
      setAttenuation(value)
    }

  /**
   * Adjusts how directional the attractor is. At `0.0`, the attractor is not directional at all: it
   * will attract particles towards its center. At `1.0`, the attractor is fully directional: particles
   * will always be pushed towards local -Z (or +Z if [strength] is negative).
   *
   * **Note:** If [directionality] is greater than `0.0`, the direction in which particles are
   * pushed can be changed by rotating the [GPUParticlesAttractor3D] node.
   */
  public final inline var directionality: Float
    @JvmName("directionalityProperty")
    get() = getDirectionality()
    @JvmName("directionalityProperty")
    set(`value`) {
      setDirectionality(value)
    }

  /**
   * The particle rendering layers ([VisualInstance3D.layers]) that will be affected by the
   * attractor. By default, all particles are affected by an attractor.
   *
   * After configuring particle nodes accordingly, specific layers can be unchecked to prevent
   * certain particles from being affected by attractors. For example, this can be used if you're using
   * an attractor as part of a spell effect but don't want the attractor to affect unrelated weather
   * particles at the same position.
   *
   * Particle attraction can also be disabled on a per-process material basis by setting
   * [ParticleProcessMaterial.attractorInteractionEnabled] on the [GPUParticles3D] node.
   */
  public final inline var cullMask: Long
    @JvmName("cullMaskProperty")
    get() = getCullMask()
    @JvmName("cullMaskProperty")
    set(`value`) {
      setCullMask(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(259, scriptPtr)
  }

  public final fun setCullMask(mask: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCullMaskPtr, mask)
  }

  public final fun getCullMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCullMaskPtr)

  public final fun setStrength(strength: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setStrengthPtr, strength.toDouble())
  }

  public final fun getStrength(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getStrengthPtr).toFloat()

  public final fun setAttenuation(attenuation: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAttenuationPtr, attenuation.toDouble())
  }

  public final fun getAttenuation(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAttenuationPtr).toFloat()

  public final fun setDirectionality(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDirectionalityPtr, amount.toDouble())
  }

  public final fun getDirectionality(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDirectionalityPtr).toFloat()

  public companion object {
    @JvmField
    public val setCullMaskName: MethodStringName1<GPUParticlesAttractor3D, Unit, Long> =
        MethodStringName1<GPUParticlesAttractor3D, Unit, Long>("set_cull_mask")

    @JvmField
    public val getCullMaskName: MethodStringName0<GPUParticlesAttractor3D, Long> =
        MethodStringName0<GPUParticlesAttractor3D, Long>("get_cull_mask")

    @JvmField
    public val setStrengthName: MethodStringName1<GPUParticlesAttractor3D, Unit, Float> =
        MethodStringName1<GPUParticlesAttractor3D, Unit, Float>("set_strength")

    @JvmField
    public val getStrengthName: MethodStringName0<GPUParticlesAttractor3D, Float> =
        MethodStringName0<GPUParticlesAttractor3D, Float>("get_strength")

    @JvmField
    public val setAttenuationName: MethodStringName1<GPUParticlesAttractor3D, Unit, Float> =
        MethodStringName1<GPUParticlesAttractor3D, Unit, Float>("set_attenuation")

    @JvmField
    public val getAttenuationName: MethodStringName0<GPUParticlesAttractor3D, Float> =
        MethodStringName0<GPUParticlesAttractor3D, Float>("get_attenuation")

    @JvmField
    public val setDirectionalityName: MethodStringName1<GPUParticlesAttractor3D, Unit, Float> =
        MethodStringName1<GPUParticlesAttractor3D, Unit, Float>("set_directionality")

    @JvmField
    public val getDirectionalityName: MethodStringName0<GPUParticlesAttractor3D, Float> =
        MethodStringName0<GPUParticlesAttractor3D, Float>("get_directionality")
  }

  public object MethodBindings {
    internal val setCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "set_cull_mask", 1286410249)

    internal val getCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "get_cull_mask", 3905245786)

    internal val setStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "set_strength", 373806689)

    internal val getStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "get_strength", 1740695150)

    internal val setAttenuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "set_attenuation", 373806689)

    internal val getAttenuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "get_attenuation", 1740695150)

    internal val setDirectionalityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "set_directionality", 373806689)

    internal val getDirectionalityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractor3D", "get_directionality", 1740695150)
  }
}
