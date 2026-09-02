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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An area light is a type of [Light3D] node that emits light over a two-dimensional area, in the
 * shape of a rectangle. The light is attenuated throughout the distance. This attenuation can be
 * configured by changing the energy, [areaAttenuation], and [areaRange].
 *
 * Light is emitted in the -Z direction of the node's global basis. For an unrotated light, this
 * means that the light is emitted forwards, illuminating the front side of a 3D model (see
 * [Vector3.FORWARD] and [Vector3.MODEL_FRONT]).
 *
 * Area lights can cast soft shadows using PCSS, which you can control by tweaking the size
 * parameter. The shadow map is drawn from the center of the light.
 *
 * **Note:** Area lights have limited support in the Mobile and Compatibility renderers. In the
 * Mobile renderer, the size of the penumbra doesn't vary as it should with PCSS. In Compatibility,
 * area lights cannot cast shadows.
 *
 * **Warning:** Shadows cast by an area light may look incorrect if the object casting shadows
 * doesn't have enough subdivisions and it's very close to the area light. This is the same limitation
 * as the Dual Paraboloid shadow mode on an [OmniLight3D].
 *
 * **Performance:** Area lights are more demanding on the GPU compared to omni and spot lights. In
 * Forward+, there is an additional GPU cost on *all* rendered objects as soon as one area light is
 * present in the view frustum (due to the nature of clustered lighting). Consider using them only for
 * cinematics or when targeting high-end devices.
 */
@GodotBaseType
public open class AreaLight3D : Light3D() {
  /**
   * The range of the area in meters. This determines the maximum distance from any point on the
   * area at which the area can still emit light.
   */
  public final inline var areaRange: Float
    @JvmName("areaRangeProperty")
    get() = getParam(Light3D.Param.RANGE)
    @JvmName("areaRangeProperty")
    set(`value`) {
      setParam(Light3D.Param.RANGE, value)
    }

  /**
   * Controls the distance attenuation function for this area light.
   *
   * A value of `0.0` will maintain a constant brightness through most of the range, but will
   * smoothly attenuate the light at the edge of the range. Use a value of `2.0` for physically
   * accurate lights as it results in the proper inverse square attenuation.
   *
   * **Note:** Setting attenuation to `2.0` or higher may result in distant objects receiving
   * minimal light, even when within range. For example, with a range of `4096`, an object at `100`
   * units is attenuated by a factor of `0.0001`. With a default brightness of `1`, the light would not
   * be visible at that distance.
   *
   * **Note:** Using negative values or values higher than `10.0` may lead to unexpected results.
   */
  public final inline var areaAttenuation: Float
    @JvmName("areaAttenuationProperty")
    get() = getParam(Light3D.Param.ATTENUATION)
    @JvmName("areaAttenuationProperty")
    set(`value`) {
      setParam(Light3D.Param.ATTENUATION, value)
    }

  /**
   * Defines whether the energy is normalized (divided) by the surface area of the light. If set to
   * `true`, changing the size does not affect the total energy output, and does not dramatically alter
   * the brightness of the scene.
   */
  public final inline var areaNormalizeEnergy: Boolean
    @JvmName("areaNormalizeEnergyProperty")
    get() = isAreaNormalizingEnergy()
    @JvmName("areaNormalizeEnergyProperty")
    set(`value`) {
      setAreaNormalizeEnergy(value)
    }

  /**
   * The extents (width and height) of the area in meters.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var areaSize: Vector2
    @JvmName("areaSizeProperty")
    get() = getAreaSize()
    @JvmName("areaSizeProperty")
    set(`value`) {
      setAreaSize(value)
    }

  /**
   * An optional texture to use as a light source. Changing the texture at runtime might impact
   * performance, as it needs to be drawn to the area light atlas with filtered mipmaps.
   *
   * If no texture is assigned, the area light emits uniform light across its surface.
   *
   * **Note:** Area light textures are only supported in the Forward+ and Mobile rendering methods,
   * not Compatibility. To reduce the performance impact of switching textures at runtime, make sure
   * each dimension of an area texture is either a multiple of 128 pixels, or a power of two. This
   * removes the need for a scaling pass, which slows down texture changes. The textures don't
   * necessarily have to be square to be optimal. Examples of optimal texture sizes include 32x64,
   * 128x128, and 256x384.
   */
  public final inline var areaTexture: Texture2D?
    @JvmName("areaTextureProperty")
    get() = getAreaTexture()
    @JvmName("areaTextureProperty")
    set(`value`) {
      setAreaTexture(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(42, scriptPtr)
  }

  /**
   * This is a helper function for [areaSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = arealight3d.areaSize
   * //Your changes
   * arealight3d.areaSize = myCoreType
   * ``````
   *
   * The extents (width and height) of the area in meters.
   */
  @CoreTypeHelper
  public final fun areaSizeMutate(block: Vector2.() -> Unit): Vector2 = areaSize.apply {
     block(this)
     areaSize = this
  }

  public final fun setAreaTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setAreaTexturePtr)
  }

  public final fun getAreaTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAreaTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setAreaSize(areaSize: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to areaSize)
    TransferContext.callMethod(MethodBindings.setAreaSizePtr)
  }

  public final fun getAreaSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAreaSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setAreaNormalizeEnergy(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAreaNormalizeEnergyPtr)
  }

  public final fun isAreaNormalizingEnergy(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAreaNormalizingEnergyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setAreaTextureName: MethodStringName1<AreaLight3D, Unit, Texture2D?> =
        MethodStringName1<AreaLight3D, Unit, Texture2D?>("set_area_texture")

    @JvmField
    public val getAreaTextureName: MethodStringName0<AreaLight3D, Texture2D?> =
        MethodStringName0<AreaLight3D, Texture2D?>("get_area_texture")

    @JvmField
    public val setAreaSizeName: MethodStringName1<AreaLight3D, Unit, Vector2> =
        MethodStringName1<AreaLight3D, Unit, Vector2>("set_area_size")

    @JvmField
    public val getAreaSizeName: MethodStringName0<AreaLight3D, Vector2> =
        MethodStringName0<AreaLight3D, Vector2>("get_area_size")

    @JvmField
    public val setAreaNormalizeEnergyName: MethodStringName1<AreaLight3D, Unit, Boolean> =
        MethodStringName1<AreaLight3D, Unit, Boolean>("set_area_normalize_energy")

    @JvmField
    public val isAreaNormalizingEnergyName: MethodStringName0<AreaLight3D, Boolean> =
        MethodStringName0<AreaLight3D, Boolean>("is_area_normalizing_energy")
  }

  public object MethodBindings {
    internal val setAreaTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AreaLight3D", "set_area_texture", 4051416890)

    internal val getAreaTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AreaLight3D", "get_area_texture", 3635182373)

    internal val setAreaSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AreaLight3D", "set_area_size", 743155724)

    internal val getAreaSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AreaLight3D", "get_area_size", 3341600327)

    internal val setAreaNormalizeEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AreaLight3D", "set_area_normalize_energy", 2586408642)

    internal val isAreaNormalizingEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AreaLight3D", "is_area_normalizing_energy", 36873697)
  }
}
