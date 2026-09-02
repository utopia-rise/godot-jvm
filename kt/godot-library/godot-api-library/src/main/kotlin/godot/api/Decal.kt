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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [Decal]s are used to project a texture onto a [Mesh] in the scene. Use Decals to add detail to a
 * scene without affecting the underlying [Mesh]. They are often used to add weathering to building,
 * add dirt or mud to the ground, or add variety to props. Decals can be moved at any time, making them
 * suitable for things like blob shadows or laser sight dots.
 *
 * They are made of an [AABB] and a group of [Texture2D]s specifying [Color], normal, ORM (ambient
 * occlusion, roughness, metallic), and emission. Decals are projected within their [AABB] so altering
 * the orientation of the Decal affects the direction in which they are projected. By default, Decals
 * are projected down (i.e. from positive Y to negative Y).
 *
 * The [Texture2D]s associated with the Decal are automatically stored in a texture atlas which is
 * used for drawing the decals so all decals can be drawn at once. Godot uses clustered decals, meaning
 * they are stored in cluster data and drawn when the mesh is drawn, they are not drawn as a
 * post-processing effect after.
 *
 * **Note:** Decals cannot affect an underlying material's transparency, regardless of its
 * transparency mode (alpha blend, alpha scissor, alpha hash, opaque pre-pass). This means translucent
 * or transparent areas of a material will remain translucent or transparent even if an opaque decal is
 * applied on them.
 *
 * **Note:** Decals are only supported in the Forward+ and Mobile rendering methods, not
 * Compatibility. When using the Mobile rendering method, only 8 decals can be displayed on each mesh
 * resource. Attempting to display more than 8 decals on a single mesh resource will result in decals
 * flickering in and out as the camera moves.
 *
 * **Note:** When using the Mobile rendering method, decals will only correctly affect meshes whose
 * visibility AABB intersects with the decal's AABB. If using a shader to deform the mesh in a way that
 * makes it go outside its AABB, [GeometryInstance3D.extraCullMargin] must be increased on the mesh.
 * Otherwise, the decal may not be visible on the mesh.
 */
@GodotBaseType
public open class Decal : VisualInstance3D() {
  /**
   * Sets the size of the [AABB] used by the decal. All dimensions must be set to a value greater
   * than zero (they will be clamped to `0.001` if this is not the case). The AABB goes from `-size/2`
   * to `size/2`.
   *
   * **Note:** To improve culling efficiency of "hard surface" decals, set their [upperFade] and
   * [lowerFade] to `0.0` and set the Y component of the [size] as low as possible. This will reduce
   * the decals' AABB size without affecting their appearance.
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
   * [Texture2D] with the base [Color] of the Decal. Either this or the [textureEmission] must be
   * set for the Decal to be visible. Use the alpha channel like a mask to smoothly blend the edges of
   * the decal with the underlying object.
   *
   * **Note:** Unlike [BaseMaterial3D] whose filter mode can be adjusted on a per-material basis,
   * the filter mode for [Decal] textures is set globally with
   * [ProjectSettings.rendering/textures/decals/filter].
   */
  public final inline var textureAlbedo: Texture2D?
    @JvmName("textureAlbedoProperty")
    get() = getTexture(Decal.DecalTexture.TEXTURE_ALBEDO)
    @JvmName("textureAlbedoProperty")
    set(`value`) {
      setTexture(Decal.DecalTexture.TEXTURE_ALBEDO, value)
    }

  /**
   * [Texture2D] with the per-pixel normal map for the decal. Use this to add extra detail to
   * decals.
   *
   * **Note:** Unlike [BaseMaterial3D] whose filter mode can be adjusted on a per-material basis,
   * the filter mode for [Decal] textures is set globally with
   * [ProjectSettings.rendering/textures/decals/filter].
   *
   * **Note:** Setting this texture alone will not result in a visible decal, as [textureAlbedo]
   * must also be set. To create a normal-only decal, load an albedo texture into [textureAlbedo] and
   * set [albedoMix] to `0.0`. The albedo texture's alpha channel will be used to determine where the
   * underlying surface's normal map should be overridden (and its intensity).
   */
  public final inline var textureNormal: Texture2D?
    @JvmName("textureNormalProperty")
    get() = getTexture(Decal.DecalTexture.TEXTURE_NORMAL)
    @JvmName("textureNormalProperty")
    set(`value`) {
      setTexture(Decal.DecalTexture.TEXTURE_NORMAL, value)
    }

  /**
   * [Texture2D] storing ambient occlusion, roughness, and metallic for the decal. Use this to add
   * extra detail to decals.
   *
   * **Note:** Unlike [BaseMaterial3D] whose filter mode can be adjusted on a per-material basis,
   * the filter mode for [Decal] textures is set globally with
   * [ProjectSettings.rendering/textures/decals/filter].
   *
   * **Note:** Setting this texture alone will not result in a visible decal, as [textureAlbedo]
   * must also be set. To create an ORM-only decal, load an albedo texture into [textureAlbedo] and set
   * [albedoMix] to `0.0`. The albedo texture's alpha channel will be used to determine where the
   * underlying surface's ORM map should be overridden (and its intensity).
   *
   * **Note:** Due to technical limitations, modifying the underlying surface's roughness using
   * [textureOrm] does *not* affect screen-space reflections ([Environment.ssrEnabled]), reflections
   * from [VoxelGI], and reflections from SDFGI ([Environment.sdfgiEnabled]). Only reflections from
   * [ReflectionProbe]s are affected.
   */
  public final inline var textureOrm: Texture2D?
    @JvmName("textureOrmProperty")
    get() = getTexture(Decal.DecalTexture.TEXTURE_ORM)
    @JvmName("textureOrmProperty")
    set(`value`) {
      setTexture(Decal.DecalTexture.TEXTURE_ORM, value)
    }

  /**
   * [Texture2D] with the emission [Color] of the Decal. Either this or the [textureAlbedo] must be
   * set for the Decal to be visible. Use the alpha channel like a mask to smoothly blend the edges of
   * the decal with the underlying object.
   *
   * **Note:** Unlike [BaseMaterial3D] whose filter mode can be adjusted on a per-material basis,
   * the filter mode for [Decal] textures is set globally with
   * [ProjectSettings.rendering/textures/decals/filter].
   */
  public final inline var textureEmission: Texture2D?
    @JvmName("textureEmissionProperty")
    get() = getTexture(Decal.DecalTexture.TEXTURE_EMISSION)
    @JvmName("textureEmissionProperty")
    set(`value`) {
      setTexture(Decal.DecalTexture.TEXTURE_EMISSION, value)
    }

  /**
   * Energy multiplier for the emission texture. This will make the decal emit light at a higher or
   * lower intensity, independently of the albedo color. See also [modulate].
   */
  public final inline var emissionEnergy: Float
    @JvmName("emissionEnergyProperty")
    get() = getEmissionEnergy()
    @JvmName("emissionEnergyProperty")
    set(`value`) {
      setEmissionEnergy(value)
    }

  /**
   * Changes the [Color] of the Decal by multiplying the albedo and emission colors with this value.
   * The alpha component is only taken into account when multiplying the albedo color, not the emission
   * color. See also [emissionEnergy] and [albedoMix] to change the emission and albedo intensity
   * independently of each other.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var modulate: Color
    @JvmName("modulateProperty")
    get() = getModulate()
    @JvmName("modulateProperty")
    set(`value`) {
      setModulate(value)
    }

  /**
   * Blends the albedo [Color] of the decal with albedo [Color] of the underlying mesh. This can be
   * set to `0.0` to create a decal that only affects normal or ORM. In this case, an albedo texture is
   * still required as its alpha channel will determine where the normal and ORM will be overridden.
   * See also [modulate].
   */
  public final inline var albedoMix: Float
    @JvmName("albedoMixProperty")
    get() = getAlbedoMix()
    @JvmName("albedoMixProperty")
    set(`value`) {
      setAlbedoMix(value)
    }

  /**
   * Fades the Decal if the angle between the Decal's [AABB] and the target surface becomes too
   * large. A value of `0` projects the Decal regardless of angle, a value of `1` limits the Decal to
   * surfaces that are nearly perpendicular.
   *
   * **Note:** Setting [normalFade] to a value greater than `0.0` has a small performance cost due
   * to the added normal angle computations.
   */
  public final inline var normalFade: Float
    @JvmName("normalFadeProperty")
    get() = getNormalFade()
    @JvmName("normalFadeProperty")
    set(`value`) {
      setNormalFade(value)
    }

  /**
   * Sets the curve over which the decal will fade as the surface gets further from the center of
   * the [AABB]. Only positive values are valid (negative values will be clamped to `0.0`). See also
   * [lowerFade].
   */
  public final inline var upperFade: Float
    @JvmName("upperFadeProperty")
    get() = getUpperFade()
    @JvmName("upperFadeProperty")
    set(`value`) {
      setUpperFade(value)
    }

  /**
   * Sets the curve over which the decal will fade as the surface gets further from the center of
   * the [AABB]. Only positive values are valid (negative values will be clamped to `0.0`). See also
   * [upperFade].
   */
  public final inline var lowerFade: Float
    @JvmName("lowerFadeProperty")
    get() = getLowerFade()
    @JvmName("lowerFadeProperty")
    set(`value`) {
      setLowerFade(value)
    }

  /**
   * If `true`, decals will smoothly fade away when far from the active [Camera3D] starting at
   * [distanceFadeBegin]. The Decal will fade out over [distanceFadeBegin] + [distanceFadeLength],
   * after which it will be culled and not sent to the shader at all. Use this to reduce the number of
   * active Decals in a scene and thus improve performance.
   */
  public final inline var distanceFadeEnabled: Boolean
    @JvmName("distanceFadeEnabledProperty")
    get() = isDistanceFadeEnabled()
    @JvmName("distanceFadeEnabledProperty")
    set(`value`) {
      setEnableDistanceFade(value)
    }

  /**
   * The distance from the camera at which the Decal begins to fade away (in 3D units).
   */
  public final inline var distanceFadeBegin: Float
    @JvmName("distanceFadeBeginProperty")
    get() = getDistanceFadeBegin()
    @JvmName("distanceFadeBeginProperty")
    set(`value`) {
      setDistanceFadeBegin(value)
    }

  /**
   * The distance over which the Decal fades (in 3D units). The Decal becomes slowly more
   * transparent over this distance and is completely invisible at the end. Higher values result in a
   * smoother fade-out transition, which is more suited when the camera moves fast.
   */
  public final inline var distanceFadeLength: Float
    @JvmName("distanceFadeLengthProperty")
    get() = getDistanceFadeLength()
    @JvmName("distanceFadeLengthProperty")
    set(`value`) {
      setDistanceFadeLength(value)
    }

  /**
   * Specifies which [VisualInstance3D.layers] this decal will project on. By default, Decals affect
   * all layers. This is used so you can specify which types of objects receive the Decal and which do
   * not. This is especially useful so you can ensure that dynamic objects don't accidentally receive a
   * Decal intended for the terrain under them.
   */
  public final inline var cullMask: Long
    @JvmName("cullMaskProperty")
    get() = getCullMask()
    @JvmName("cullMaskProperty")
    set(`value`) {
      setCullMask(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(206, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = decal.size
   * //Your changes
   * decal.size = myCoreType
   * ``````
   *
   * Sets the size of the [AABB] used by the decal. All dimensions must be set to a value greater
   * than zero (they will be clamped to `0.001` if this is not the case). The AABB goes from `-size/2`
   * to `size/2`.
   *
   * **Note:** To improve culling efficiency of "hard surface" decals, set their [upperFade] and
   * [lowerFade] to `0.0` and set the Y component of the [size] as low as possible. This will reduce
   * the decals' AABB size without affecting their appearance.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  /**
   * This is a helper function for [modulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = decal.modulate
   * //Your changes
   * decal.modulate = myCoreType
   * ``````
   *
   * Changes the [Color] of the Decal by multiplying the albedo and emission colors with this value.
   * The alpha component is only taken into account when multiplying the albedo color, not the emission
   * color. See also [emissionEnergy] and [albedoMix] to change the emission and albedo intensity
   * independently of each other.
   */
  @CoreTypeHelper
  public final fun modulateMutate(block: Color.() -> Unit): Color = modulate.apply {
     block(this)
     modulate = this
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

  /**
   * Sets the [Texture2D] associated with the specified [DecalTexture]. This is a convenience
   * method, in most cases you should access the texture directly.
   *
   * For example, instead of `$Decal.set_texture(Decal.TEXTURE_ALBEDO, albedo_tex)`, use
   * `$Decal.texture_albedo = albedo_tex`.
   *
   * One case where this is better than accessing the texture directly is when you want to copy one
   * Decal's textures to another. For example:
   *
   * ```gdscript
   * //gdscript
   * for i in Decal.TEXTURE_MAX:
   * 	$NewDecal.set_texture(i, $OldDecal.get_texture(i))
   * ```
   *
   * ```csharp
   * //csharp
   * for (int i = 0; i < (int)Decal.DecalTexture.Max; i++)
   * {
   * 	GetNode<Decal>("NewDecal").SetTexture(i, GetNode<Decal>("OldDecal").GetTexture(i));
   * }
   * ```
   */
  public final fun setTexture(type: DecalTexture, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  /**
   * Returns the [Texture2D] associated with the specified [DecalTexture]. This is a convenience
   * method, in most cases you should access the texture directly.
   *
   * For example, instead of `albedo_tex = $Decal.get_texture(Decal.TEXTURE_ALBEDO)`, use
   * `albedo_tex = $Decal.texture_albedo`.
   *
   * One case where this is better than accessing the texture directly is when you want to copy one
   * Decal's textures to another. For example:
   *
   * ```gdscript
   * //gdscript
   * for i in Decal.TEXTURE_MAX:
   * 	$NewDecal.set_texture(i, $OldDecal.get_texture(i))
   * ```
   *
   * ```csharp
   * //csharp
   * for (int i = 0; i < (int)Decal.DecalTexture.Max; i++)
   * {
   * 	GetNode<Decal>("NewDecal").SetTexture(i, GetNode<Decal>("OldDecal").GetTexture(i));
   * }
   * ```
   */
  public final fun getTexture(type: DecalTexture): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setEmissionEnergy(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionEnergyPtr)
  }

  public final fun getEmissionEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAlbedoMix(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setAlbedoMixPtr)
  }

  public final fun getAlbedoMix(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlbedoMixPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setModulate(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setModulatePtr)
  }

  public final fun getModulate(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setUpperFade(fade: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fade.toDouble())
    TransferContext.callMethod(MethodBindings.setUpperFadePtr)
  }

  public final fun getUpperFade(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpperFadePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLowerFade(fade: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fade.toDouble())
    TransferContext.callMethod(MethodBindings.setLowerFadePtr)
  }

  public final fun getLowerFade(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLowerFadePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setNormalFade(fade: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fade.toDouble())
    TransferContext.callMethod(MethodBindings.setNormalFadePtr)
  }

  public final fun getNormalFade(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNormalFadePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEnableDistanceFade(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEnableDistanceFadePtr)
  }

  public final fun isDistanceFadeEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDistanceFadeEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDistanceFadeBegin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setDistanceFadeBeginPtr)
  }

  public final fun getDistanceFadeBegin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDistanceFadeBeginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDistanceFadeLength(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setDistanceFadeLengthPtr)
  }

  public final fun getDistanceFadeLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDistanceFadeLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCullMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setCullMaskPtr)
  }

  public final fun getCullMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCullMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class DecalTexture(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * [Texture2D] corresponding to [textureAlbedo].
     */
    TEXTURE_ALBEDO(0),
    /**
     * [Texture2D] corresponding to [textureNormal].
     */
    TEXTURE_NORMAL(1),
    /**
     * [Texture2D] corresponding to [textureOrm].
     */
    TEXTURE_ORM(2),
    /**
     * [Texture2D] corresponding to [textureEmission].
     */
    TEXTURE_EMISSION(3),
    /**
     * Max size of [DecalTexture] enum.
     */
    TEXTURE_MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): DecalTexture = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<Decal, Unit, Vector3> =
        MethodStringName1<Decal, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<Decal, Vector3> =
        MethodStringName0<Decal, Vector3>("get_size")

    @JvmField
    public val setTextureName: MethodStringName2<Decal, Unit, DecalTexture, Texture2D?> =
        MethodStringName2<Decal, Unit, DecalTexture, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName1<Decal, Texture2D?, DecalTexture> =
        MethodStringName1<Decal, Texture2D?, DecalTexture>("get_texture")

    @JvmField
    public val setEmissionEnergyName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_emission_energy")

    @JvmField
    public val getEmissionEnergyName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_emission_energy")

    @JvmField
    public val setAlbedoMixName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_albedo_mix")

    @JvmField
    public val getAlbedoMixName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_albedo_mix")

    @JvmField
    public val setModulateName: MethodStringName1<Decal, Unit, Color> =
        MethodStringName1<Decal, Unit, Color>("set_modulate")

    @JvmField
    public val getModulateName: MethodStringName0<Decal, Color> =
        MethodStringName0<Decal, Color>("get_modulate")

    @JvmField
    public val setUpperFadeName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_upper_fade")

    @JvmField
    public val getUpperFadeName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_upper_fade")

    @JvmField
    public val setLowerFadeName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_lower_fade")

    @JvmField
    public val getLowerFadeName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_lower_fade")

    @JvmField
    public val setNormalFadeName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_normal_fade")

    @JvmField
    public val getNormalFadeName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_normal_fade")

    @JvmField
    public val setEnableDistanceFadeName: MethodStringName1<Decal, Unit, Boolean> =
        MethodStringName1<Decal, Unit, Boolean>("set_enable_distance_fade")

    @JvmField
    public val isDistanceFadeEnabledName: MethodStringName0<Decal, Boolean> =
        MethodStringName0<Decal, Boolean>("is_distance_fade_enabled")

    @JvmField
    public val setDistanceFadeBeginName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_distance_fade_begin")

    @JvmField
    public val getDistanceFadeBeginName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_distance_fade_begin")

    @JvmField
    public val setDistanceFadeLengthName: MethodStringName1<Decal, Unit, Float> =
        MethodStringName1<Decal, Unit, Float>("set_distance_fade_length")

    @JvmField
    public val getDistanceFadeLengthName: MethodStringName0<Decal, Float> =
        MethodStringName0<Decal, Float>("get_distance_fade_length")

    @JvmField
    public val setCullMaskName: MethodStringName1<Decal, Unit, Long> =
        MethodStringName1<Decal, Unit, Long>("set_cull_mask")

    @JvmField
    public val getCullMaskName: MethodStringName0<Decal, Long> =
        MethodStringName0<Decal, Long>("get_cull_mask")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr = TypeManager.getMethodBindPtr("Decal", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr = TypeManager.getMethodBindPtr("Decal", "get_size", 3360562783)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_texture", 2086764391)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_texture", 3244119503)

    internal val setEmissionEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_emission_energy", 373806689)

    internal val getEmissionEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_emission_energy", 1740695150)

    internal val setAlbedoMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_albedo_mix", 373806689)

    internal val getAlbedoMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_albedo_mix", 1740695150)

    internal val setModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_modulate", 2920490490)

    internal val getModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_modulate", 3444240500)

    internal val setUpperFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_upper_fade", 373806689)

    internal val getUpperFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_upper_fade", 1740695150)

    internal val setLowerFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_lower_fade", 373806689)

    internal val getLowerFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_lower_fade", 1740695150)

    internal val setNormalFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_normal_fade", 373806689)

    internal val getNormalFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_normal_fade", 1740695150)

    internal val setEnableDistanceFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_enable_distance_fade", 2586408642)

    internal val isDistanceFadeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "is_distance_fade_enabled", 36873697)

    internal val setDistanceFadeBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_distance_fade_begin", 373806689)

    internal val getDistanceFadeBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_distance_fade_begin", 1740695150)

    internal val setDistanceFadeLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_distance_fade_length", 373806689)

    internal val getDistanceFadeLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_distance_fade_length", 1740695150)

    internal val setCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "set_cull_mask", 1286410249)

    internal val getCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Decal", "get_cull_mask", 3905245786)
  }
}
