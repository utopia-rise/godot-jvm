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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A baked signed distance field 3D particle collision shape affecting [GPUParticles3D] nodes.
 *
 * Signed distance fields (SDF) allow for efficiently representing approximate collision shapes for
 * convex and concave objects of any shape. This is more flexible than
 * [GPUParticlesCollisionHeightField3D], but it requires a baking step.
 *
 * **Baking:** The signed distance field texture can be baked by selecting the
 * [GPUParticlesCollisionSDF3D] node in the editor, then clicking **Bake SDF** at the top of the 3D
 * viewport. Any *visible* [MeshInstance3D]s within the [size] will be taken into account for baking,
 * regardless of their [GeometryInstance3D.giMode].
 *
 * **Note:** Baking a [GPUParticlesCollisionSDF3D]'s [texture] is only possible within the editor,
 * as there is no bake method exposed for use in exported projects. However, it's still possible to
 * load pre-baked [Texture3D]s into its [texture] property in an exported project.
 *
 * **Note:** [ParticleProcessMaterial.collisionMode] must be
 * [ParticleProcessMaterial.COLLISION_RIGID] or [ParticleProcessMaterial.COLLISION_HIDE_ON_CONTACT] on
 * the [GPUParticles3D]'s process material for collision to work.
 *
 * **Note:** Particle collision only affects [GPUParticles3D], not [CPUParticles3D].
 */
@GodotBaseType
public open class GPUParticlesCollisionSDF3D : GPUParticlesCollision3D() {
  /**
   * The collision SDF's size in 3D units. To improve SDF quality, the [size] should be set as small
   * as possible while covering the parts of the scene you need.
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

  /**
   * The bake resolution to use for the signed distance field [texture]. The texture must be baked
   * again for changes to the [resolution] property to be effective. Higher resolutions have a greater
   * performance cost and take more time to bake. Higher resolutions also result in larger baked
   * textures, leading to increased VRAM and storage space requirements. To improve performance and
   * reduce bake times, use the lowest resolution possible for the object you're representing the
   * collision of.
   */
  public final inline var resolution: Resolution
    @JvmName("resolutionProperty")
    get() = getResolution()
    @JvmName("resolutionProperty")
    set(`value`) {
      setResolution(value)
    }

  /**
   * The collision shape's thickness. Unlike other particle colliders, [GPUParticlesCollisionSDF3D]
   * is actually hollow on the inside. [thickness] can be increased to prevent particles from tunneling
   * through the collision shape at high speeds, or when the [GPUParticlesCollisionSDF3D] is moved.
   */
  public final inline var thickness: Float
    @JvmName("thicknessProperty")
    get() = getThickness()
    @JvmName("thicknessProperty")
    set(`value`) {
      setThickness(value)
    }

  /**
   * The visual layers to account for when baking the particle collision SDF. Only [MeshInstance3D]s
   * whose [VisualInstance3D.layers] match with this [bakeMask] will be included in the generated
   * particle collision SDF. By default, all objects are taken into account for the particle collision
   * SDF baking.
   */
  public final inline var bakeMask: Long
    @JvmName("bakeMaskProperty")
    get() = getBakeMask()
    @JvmName("bakeMaskProperty")
    set(`value`) {
      setBakeMask(value)
    }

  /**
   * The 3D texture representing the signed distance field.
   */
  public final inline var texture: Texture3D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(268, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gpuparticlescollisionsdf3d.size
   * //Your changes
   * gpuparticlescollisionsdf3d.size = myCoreType
   * ``````
   *
   * The collision SDF's size in 3D units. To improve SDF quality, the [size] should be set as small
   * as possible while covering the parts of the scene you need.
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

  public final fun setResolution(resolution: Resolution): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to resolution.value)
    TransferContext.callMethod(MethodBindings.setResolutionPtr)
  }

  public final fun getResolution(): Resolution {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getResolutionPtr)
    return Resolution.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTexture(texture: Texture3D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture3D?)
  }

  public final fun setThickness(thickness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to thickness.toDouble())
    TransferContext.callMethod(MethodBindings.setThicknessPtr)
  }

  public final fun getThickness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThicknessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBakeMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setBakeMaskPtr)
  }

  public final fun getBakeMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakeMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [bakeMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setBakeMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setBakeMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [bakeMask] is enabled, given a [layerNumber]
   * between 1 and 32.
   */
  public final fun getBakeMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getBakeMaskValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class Resolution(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Bake a 16×16×16 signed distance field. This is the fastest option, but also the least
     * precise.
     */
    RESOLUTION_16(0),
    /**
     * Bake a 32×32×32 signed distance field.
     */
    RESOLUTION_32(1),
    /**
     * Bake a 64×64×64 signed distance field.
     */
    RESOLUTION_64(2),
    /**
     * Bake a 128×128×128 signed distance field.
     */
    RESOLUTION_128(3),
    /**
     * Bake a 256×256×256 signed distance field.
     */
    RESOLUTION_256(4),
    /**
     * Bake a 512×512×512 signed distance field. This is the slowest option, but also the most
     * precise.
     */
    RESOLUTION_512(5),
    /**
     * Represents the size of the [Resolution] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): Resolution = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Vector3> =
        MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<GPUParticlesCollisionSDF3D, Vector3> =
        MethodStringName0<GPUParticlesCollisionSDF3D, Vector3>("get_size")

    @JvmField
    public val setResolutionName: MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Resolution> =
        MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Resolution>("set_resolution")

    @JvmField
    public val getResolutionName: MethodStringName0<GPUParticlesCollisionSDF3D, Resolution> =
        MethodStringName0<GPUParticlesCollisionSDF3D, Resolution>("get_resolution")

    @JvmField
    public val setTextureName: MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Texture3D?> =
        MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Texture3D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<GPUParticlesCollisionSDF3D, Texture3D?> =
        MethodStringName0<GPUParticlesCollisionSDF3D, Texture3D?>("get_texture")

    @JvmField
    public val setThicknessName: MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Float> =
        MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Float>("set_thickness")

    @JvmField
    public val getThicknessName: MethodStringName0<GPUParticlesCollisionSDF3D, Float> =
        MethodStringName0<GPUParticlesCollisionSDF3D, Float>("get_thickness")

    @JvmField
    public val setBakeMaskName: MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Long> =
        MethodStringName1<GPUParticlesCollisionSDF3D, Unit, Long>("set_bake_mask")

    @JvmField
    public val getBakeMaskName: MethodStringName0<GPUParticlesCollisionSDF3D, Long> =
        MethodStringName0<GPUParticlesCollisionSDF3D, Long>("get_bake_mask")

    @JvmField
    public val setBakeMaskValueName:
        MethodStringName2<GPUParticlesCollisionSDF3D, Unit, Int, Boolean> =
        MethodStringName2<GPUParticlesCollisionSDF3D, Unit, Int, Boolean>("set_bake_mask_value")

    @JvmField
    public val getBakeMaskValueName: MethodStringName1<GPUParticlesCollisionSDF3D, Boolean, Int> =
        MethodStringName1<GPUParticlesCollisionSDF3D, Boolean, Int>("get_bake_mask_value")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "get_size", 3360562783)

    internal val setResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "set_resolution", 1155629297)

    internal val getResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "get_resolution", 2919555867)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "set_texture", 1188404210)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "get_texture", 373985333)

    internal val setThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "set_thickness", 373806689)

    internal val getThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "get_thickness", 1740695150)

    internal val setBakeMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "set_bake_mask", 1286410249)

    internal val getBakeMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "get_bake_mask", 3905245786)

    internal val setBakeMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "set_bake_mask_value", 300928843)

    internal val getBakeMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionSDF3D", "get_bake_mask_value", 1116898809)
  }
}
