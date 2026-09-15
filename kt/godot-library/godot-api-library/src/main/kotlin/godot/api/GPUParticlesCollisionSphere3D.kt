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
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A sphere-shaped 3D particle collision shape affecting [GPUParticles3D] nodes.
 *
 * Particle collision shapes work in real-time and can be moved, rotated and scaled during gameplay.
 * Unlike attractors, non-uniform scaling of collision shapes is *not* supported.
 *
 * **Note:** [ParticleProcessMaterial.collisionMode] must be
 * [ParticleProcessMaterial.COLLISION_RIGID] or [ParticleProcessMaterial.COLLISION_HIDE_ON_CONTACT] on
 * the [GPUParticles3D]'s process material for collision to work.
 *
 * **Note:** Particle collision only affects [GPUParticles3D], not [CPUParticles3D].
 */
@GodotBaseType
public open class GPUParticlesCollisionSphere3D : GPUParticlesCollision3D() {
  /**
   * The collision sphere's radius in 3D units.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(267, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setRadiusPtr)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<GPUParticlesCollisionSphere3D, Unit, Float> =
        MethodStringName1<GPUParticlesCollisionSphere3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<GPUParticlesCollisionSphere3D, Float> =
        MethodStringName0<GPUParticlesCollisionSphere3D, Float>("get_radius")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSphere3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSphere3D", "get_radius", 1740695150)
  }
}
