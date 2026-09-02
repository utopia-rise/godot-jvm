// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A box-shaped attractor that influences particles from [GPUParticles3D] nodes. Can be used to
 * attract particles towards its origin, or to push them away from its origin.
 *
 * Particle attractors work in real-time and can be moved, rotated and scaled during gameplay.
 * Unlike collision shapes, non-uniform scaling of attractors is also supported.
 *
 * **Note:** Particle attractors only affect [GPUParticles3D], not [CPUParticles3D].
 */
@GodotBaseType
public open class GPUParticlesAttractorBox3D : GPUParticlesAttractor3D() {
  /**
   * The attractor box's size in 3D units.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector3
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(262, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gpuparticlesattractorbox3d.size
   * //Your changes
   * gpuparticlesattractorbox3d.size = myCoreType
   * ``````
   *
   * The attractor box's size in 3D units.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<GPUParticlesAttractorBox3D, Unit, Vector3> =
        MethodStringName1<GPUParticlesAttractorBox3D, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<GPUParticlesAttractorBox3D, Vector3> =
        MethodStringName0<GPUParticlesAttractorBox3D, Vector3>("get_size")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractorBox3D", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesAttractorBox3D", "get_size", 3360562783)
  }
}
