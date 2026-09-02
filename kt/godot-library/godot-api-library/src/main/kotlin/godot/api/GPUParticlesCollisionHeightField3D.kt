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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A real-time heightmap-shaped 3D particle collision shape affecting [GPUParticles3D] nodes.
 *
 * Heightmap shapes allow for efficiently representing collisions for convex and concave objects
 * with a single "floor" (such as terrain). This is less flexible than [GPUParticlesCollisionSDF3D],
 * but it doesn't require a baking step.
 *
 * [GPUParticlesCollisionHeightField3D] can also be regenerated in real-time when it is moved, when
 * the camera moves, or even continuously. This makes [GPUParticlesCollisionHeightField3D] a good
 * choice for weather effects such as rain and snow and games with highly dynamic geometry. However,
 * this class is limited since heightmaps cannot represent overhangs (e.g. indoors or caves).
 *
 * **Note:** [ParticleProcessMaterial.collisionMode] must be `true` on the [GPUParticles3D]'s
 * process material for collision to work.
 *
 * **Note:** Particle collision only affects [GPUParticles3D], not [CPUParticles3D].
 */
@GodotBaseType
public open class GPUParticlesCollisionHeightField3D : GPUParticlesCollision3D() {
  /**
   * The collision heightmap's size in 3D units. To improve heightmap quality, [size] should be set
   * as small as possible while covering the parts of the scene you need.
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
   * Higher resolutions can represent small details more accurately in large scenes, at the cost of
   * lower performance. If [updateMode] is [UPDATE_MODE_ALWAYS], consider using the lowest resolution
   * possible.
   */
  public final inline var resolution: Resolution
    @JvmName("resolutionProperty")
    get() = getResolution()
    @JvmName("resolutionProperty")
    set(`value`) {
      setResolution(value)
    }

  /**
   * The update policy to use for the generated heightmap.
   */
  public final inline var updateMode: UpdateMode
    @JvmName("updateModeProperty")
    get() = getUpdateMode()
    @JvmName("updateModeProperty")
    set(`value`) {
      setUpdateMode(value)
    }

  /**
   * If `true`, the [GPUParticlesCollisionHeightField3D] will follow the current camera in global
   * space. The [GPUParticlesCollisionHeightField3D] does not need to be a child of the [Camera3D] node
   * for this to work.
   *
   * Following the camera has a performance cost, as it will force the heightmap to update whenever
   * the camera moves. Consider lowering [resolution] to improve performance if [followCameraEnabled]
   * is `true`.
   */
  public final inline var followCameraEnabled: Boolean
    @JvmName("followCameraEnabledProperty")
    get() = isFollowCameraEnabled()
    @JvmName("followCameraEnabledProperty")
    set(`value`) {
      setFollowCameraEnabled(value)
    }

  /**
   * The visual layers to account for when updating the heightmap. Only [MeshInstance3D]s whose
   * [VisualInstance3D.layers] match with this [heightfieldMask] will be included in the heightmap
   * collision update. By default, all 20 user-visible layers are taken into account for updating the
   * heightmap collision.
   *
   * **Note:** Since the [heightfieldMask] allows for 32 layers to be stored in total, there are an
   * additional 12 layers that are only used internally by the engine and aren't exposed in the editor.
   * Setting [heightfieldMask] using a script allows you to toggle those reserved layers, which can be
   * useful for editor plugins.
   *
   * To adjust [heightfieldMask] more easily using a script, use [getHeightfieldMaskValue] and
   * [setHeightfieldMaskValue].
   */
  public final inline var heightfieldMask: Long
    @JvmName("heightfieldMaskProperty")
    get() = getHeightfieldMask()
    @JvmName("heightfieldMaskProperty")
    set(`value`) {
      setHeightfieldMask(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(267, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gpuparticlescollisionheightfield3d.size
   * //Your changes
   * gpuparticlescollisionheightfield3d.size = myCoreType
   * ``````
   *
   * The collision heightmap's size in 3D units. To improve heightmap quality, [size] should be set
   * as small as possible while covering the parts of the scene you need.
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

  public final fun setUpdateMode(updateMode: UpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to updateMode.value)
    TransferContext.callMethod(MethodBindings.setUpdateModePtr)
  }

  public final fun getUpdateMode(): UpdateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpdateModePtr)
    return UpdateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setHeightfieldMask(heightfieldMask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to heightfieldMask)
    TransferContext.callMethod(MethodBindings.setHeightfieldMaskPtr)
  }

  public final fun getHeightfieldMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightfieldMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [heightfieldMask], given a
   * [layerNumber] between `1` and `20`, inclusive.
   */
  public final fun setHeightfieldMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setHeightfieldMaskValuePtr)
  }

  /**
   * Returns `true` if the specified layer of the [heightfieldMask] is enabled, given a
   * [layerNumber] between `1` and `20`, inclusive.
   */
  public final fun getHeightfieldMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getHeightfieldMaskValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFollowCameraEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFollowCameraEnabledPtr)
  }

  public final fun isFollowCameraEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFollowCameraEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class Resolution(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Generate a 256×256 heightmap. Intended for small-scale scenes, or larger scenes with no
     * distant particles.
     */
    RESOLUTION_256(0),
    /**
     * Generate a 512×512 heightmap. Intended for medium-scale scenes, or larger scenes with no
     * distant particles.
     */
    RESOLUTION_512(1),
    /**
     * Generate a 1024×1024 heightmap. Intended for large scenes with distant particles.
     */
    RESOLUTION_1024(2),
    /**
     * Generate a 2048×2048 heightmap. Intended for very large scenes with distant particles.
     */
    RESOLUTION_2048(3),
    /**
     * Generate a 4096×4096 heightmap. Intended for huge scenes with distant particles.
     */
    RESOLUTION_4096(4),
    /**
     * Generate a 8192×8192 heightmap. Intended for gigantic scenes with distant particles.
     */
    RESOLUTION_8192(5),
    /**
     * Represents the size of the [Resolution] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): Resolution = entries.single { it.`value` == `value` }
    }
  }

  public enum class UpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Only update the heightmap when the [GPUParticlesCollisionHeightField3D] node is moved, or
     * when the camera moves if [followCameraEnabled] is `true`. An update can be forced by slightly
     * moving the [GPUParticlesCollisionHeightField3D] in any direction, or by calling
     * [RenderingServer.particlesCollisionHeightFieldUpdate].
     */
    WHEN_MOVED(0),
    /**
     * Update the heightmap every frame. This has a significant performance cost. This update should
     * only be used when geometry that particles can collide with changes significantly during
     * gameplay.
     */
    ALWAYS(1),
    ;

    public companion object {
      public fun from(`value`: Long): UpdateMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Vector3> =
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<GPUParticlesCollisionHeightField3D, Vector3> =
        MethodStringName0<GPUParticlesCollisionHeightField3D, Vector3>("get_size")

    @JvmField
    public val setResolutionName:
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Resolution> =
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Resolution>("set_resolution")

    @JvmField
    public val getResolutionName: MethodStringName0<GPUParticlesCollisionHeightField3D, Resolution>
        = MethodStringName0<GPUParticlesCollisionHeightField3D, Resolution>("get_resolution")

    @JvmField
    public val setUpdateModeName:
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, UpdateMode> =
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, UpdateMode>("set_update_mode")

    @JvmField
    public val getUpdateModeName: MethodStringName0<GPUParticlesCollisionHeightField3D, UpdateMode>
        = MethodStringName0<GPUParticlesCollisionHeightField3D, UpdateMode>("get_update_mode")

    @JvmField
    public val setHeightfieldMaskName:
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Long> =
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Long>("set_heightfield_mask")

    @JvmField
    public val getHeightfieldMaskName: MethodStringName0<GPUParticlesCollisionHeightField3D, Long> =
        MethodStringName0<GPUParticlesCollisionHeightField3D, Long>("get_heightfield_mask")

    @JvmField
    public val setHeightfieldMaskValueName:
        MethodStringName2<GPUParticlesCollisionHeightField3D, Unit, Int, Boolean> =
        MethodStringName2<GPUParticlesCollisionHeightField3D, Unit, Int, Boolean>("set_heightfield_mask_value")

    @JvmField
    public val getHeightfieldMaskValueName:
        MethodStringName1<GPUParticlesCollisionHeightField3D, Boolean, Int> =
        MethodStringName1<GPUParticlesCollisionHeightField3D, Boolean, Int>("get_heightfield_mask_value")

    @JvmField
    public val setFollowCameraEnabledName:
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Boolean> =
        MethodStringName1<GPUParticlesCollisionHeightField3D, Unit, Boolean>("set_follow_camera_enabled")

    @JvmField
    public val isFollowCameraEnabledName:
        MethodStringName0<GPUParticlesCollisionHeightField3D, Boolean> =
        MethodStringName0<GPUParticlesCollisionHeightField3D, Boolean>("is_follow_camera_enabled")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "get_size", 3360562783)

    internal val setResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "set_resolution", 1009996517)

    internal val getResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "get_resolution", 1156065644)

    internal val setUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "set_update_mode", 673680859)

    internal val getUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "get_update_mode", 1998141380)

    internal val setHeightfieldMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "set_heightfield_mask", 1286410249)

    internal val getHeightfieldMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "get_heightfield_mask", 3905245786)

    internal val setHeightfieldMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "set_heightfield_mask_value", 300928843)

    internal val getHeightfieldMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "get_heightfield_mask_value", 1116898809)

    internal val setFollowCameraEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "set_follow_camera_enabled", 2586408642)

    internal val isFollowCameraEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticlesCollisionHeightField3D", "is_follow_camera_enabled", 36873697)
  }
}
