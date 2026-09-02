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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The [PhysicalSkyMaterial] uses the Preetham analytic daylight model to draw a sky based on
 * physical properties. This results in a substantially more realistic sky than the
 * [ProceduralSkyMaterial], but it is slightly slower and less flexible.
 *
 * The [PhysicalSkyMaterial] only supports one sun. The color, energy, and direction of the sun are
 * taken from the first [DirectionalLight3D] in the scene tree.
 */
@GodotBaseType
public open class PhysicalSkyMaterial : Material() {
  /**
   * Controls the strength of the [url=https://en.wikipedia.org/wiki/Rayleigh_scattering]Rayleigh
   * scattering[/url]. Rayleigh scattering results from light colliding with small particles. It is
   * responsible for the blue color of the sky.
   */
  public final inline var rayleighCoefficient: Float
    @JvmName("rayleighCoefficientProperty")
    get() = getRayleighCoefficient()
    @JvmName("rayleighCoefficientProperty")
    set(`value`) {
      setRayleighCoefficient(value)
    }

  /**
   * Controls the [Color] of the [url=https://en.wikipedia.org/wiki/Rayleigh_scattering]Rayleigh
   * scattering[/url]. While not physically accurate, this allows for the creation of alien-looking
   * planets. For example, setting this to a red [Color] results in a Mars-looking atmosphere with a
   * corresponding blue sunset.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rayleighColor: Color
    @JvmName("rayleighColorProperty")
    get() = getRayleighColor()
    @JvmName("rayleighColorProperty")
    set(`value`) {
      setRayleighColor(value)
    }

  /**
   * Controls the strength of [url=https://en.wikipedia.org/wiki/Mie_scattering]Mie scattering[/url]
   * for the sky. Mie scattering results from light colliding with larger particles (like water). On
   * earth, Mie scattering results in a whitish color around the sun and horizon.
   */
  public final inline var mieCoefficient: Float
    @JvmName("mieCoefficientProperty")
    get() = getMieCoefficient()
    @JvmName("mieCoefficientProperty")
    set(`value`) {
      setMieCoefficient(value)
    }

  /**
   * Controls the direction of the [url=https://en.wikipedia.org/wiki/Mie_scattering]Mie
   * scattering[/url]. A value of `1` means that when light hits a particle it's passing through
   * straight forward. A value of `-1` means that all light is scatter backwards.
   */
  public final inline var mieEccentricity: Float
    @JvmName("mieEccentricityProperty")
    get() = getMieEccentricity()
    @JvmName("mieEccentricityProperty")
    set(`value`) {
      setMieEccentricity(value)
    }

  /**
   * Controls the [Color] of the [url=https://en.wikipedia.org/wiki/Mie_scattering]Mie
   * scattering[/url] effect. While not physically accurate, this allows for the creation of
   * alien-looking planets.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var mieColor: Color
    @JvmName("mieColorProperty")
    get() = getMieColor()
    @JvmName("mieColorProperty")
    set(`value`) {
      setMieColor(value)
    }

  /**
   * Sets the thickness of the atmosphere. High turbidity creates a foggy-looking atmosphere, while
   * a low turbidity results in a clearer atmosphere.
   */
  public final inline var turbidity: Float
    @JvmName("turbidityProperty")
    get() = getTurbidity()
    @JvmName("turbidityProperty")
    set(`value`) {
      setTurbidity(value)
    }

  /**
   * Sets the size of the sun disk. Default value is based on Sol's perceived size from Earth.
   */
  public final inline var sunDiskScale: Float
    @JvmName("sunDiskScaleProperty")
    get() = getSunDiskScale()
    @JvmName("sunDiskScaleProperty")
    set(`value`) {
      setSunDiskScale(value)
    }

  /**
   * Modulates the [Color] on the bottom half of the sky to represent the ground.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var groundColor: Color
    @JvmName("groundColorProperty")
    get() = getGroundColor()
    @JvmName("groundColorProperty")
    set(`value`) {
      setGroundColor(value)
    }

  /**
   * The sky's overall brightness multiplier. Higher values result in a brighter sky.
   */
  public final inline var energyMultiplier: Float
    @JvmName("energyMultiplierProperty")
    get() = getEnergyMultiplier()
    @JvmName("energyMultiplierProperty")
    set(`value`) {
      setEnergyMultiplier(value)
    }

  /**
   * If `true`, enables debanding. Debanding adds a small amount of noise which helps reduce banding
   * that appears from the smooth changes in color in the sky.
   */
  public final inline var useDebanding: Boolean
    @JvmName("useDebandingProperty")
    get() = getUseDebanding()
    @JvmName("useDebandingProperty")
    set(`value`) {
      setUseDebanding(value)
    }

  /**
   * [Texture2D] for the night sky. This is added to the sky, so if it is bright enough, it may be
   * visible during the day.
   */
  public final inline var nightSky: Texture2D?
    @JvmName("nightSkyProperty")
    get() = getNightSky()
    @JvmName("nightSkyProperty")
    set(`value`) {
      setNightSky(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(523, scriptPtr)
  }

  /**
   * This is a helper function for [rayleighColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicalskymaterial.rayleighColor
   * //Your changes
   * physicalskymaterial.rayleighColor = myCoreType
   * ``````
   *
   * Controls the [Color] of the [url=https://en.wikipedia.org/wiki/Rayleigh_scattering]Rayleigh
   * scattering[/url]. While not physically accurate, this allows for the creation of alien-looking
   * planets. For example, setting this to a red [Color] results in a Mars-looking atmosphere with a
   * corresponding blue sunset.
   */
  @CoreTypeHelper
  public final fun rayleighColorMutate(block: Color.() -> Unit): Color = rayleighColor.apply {
     block(this)
     rayleighColor = this
  }

  /**
   * This is a helper function for [mieColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicalskymaterial.mieColor
   * //Your changes
   * physicalskymaterial.mieColor = myCoreType
   * ``````
   *
   * Controls the [Color] of the [url=https://en.wikipedia.org/wiki/Mie_scattering]Mie
   * scattering[/url] effect. While not physically accurate, this allows for the creation of
   * alien-looking planets.
   */
  @CoreTypeHelper
  public final fun mieColorMutate(block: Color.() -> Unit): Color = mieColor.apply {
     block(this)
     mieColor = this
  }

  /**
   * This is a helper function for [groundColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicalskymaterial.groundColor
   * //Your changes
   * physicalskymaterial.groundColor = myCoreType
   * ``````
   *
   * Modulates the [Color] on the bottom half of the sky to represent the ground.
   */
  @CoreTypeHelper
  public final fun groundColorMutate(block: Color.() -> Unit): Color = groundColor.apply {
     block(this)
     groundColor = this
  }

  public final fun setRayleighCoefficient(rayleigh: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to rayleigh.toDouble())
    TransferContext.callMethod(MethodBindings.setRayleighCoefficientPtr)
  }

  public final fun getRayleighCoefficient(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRayleighCoefficientPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRayleighColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setRayleighColorPtr)
  }

  public final fun getRayleighColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRayleighColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setMieCoefficient(mie: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mie.toDouble())
    TransferContext.callMethod(MethodBindings.setMieCoefficientPtr)
  }

  public final fun getMieCoefficient(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMieCoefficientPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMieEccentricity(eccentricity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to eccentricity.toDouble())
    TransferContext.callMethod(MethodBindings.setMieEccentricityPtr)
  }

  public final fun getMieEccentricity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMieEccentricityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMieColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setMieColorPtr)
  }

  public final fun getMieColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMieColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setTurbidity(turbidity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to turbidity.toDouble())
    TransferContext.callMethod(MethodBindings.setTurbidityPtr)
  }

  public final fun getTurbidity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTurbidityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSunDiskScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setSunDiskScalePtr)
  }

  public final fun getSunDiskScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSunDiskScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGroundColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setGroundColorPtr)
  }

  public final fun getGroundColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGroundColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setEnergyMultiplier(multiplier: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to multiplier.toDouble())
    TransferContext.callMethod(MethodBindings.setEnergyMultiplierPtr)
  }

  public final fun getEnergyMultiplier(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnergyMultiplierPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setUseDebanding(useDebanding: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useDebanding)
    TransferContext.callMethod(MethodBindings.setUseDebandingPtr)
  }

  public final fun getUseDebanding(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseDebandingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setNightSky(nightSky: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to nightSky)
    TransferContext.callMethod(MethodBindings.setNightSkyPtr)
  }

  public final fun getNightSky(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNightSkyPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("PhysicalSkyMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("PhysicalSkyMaterial::_getShaderMode can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setRayleighCoefficientName: MethodStringName1<PhysicalSkyMaterial, Unit, Float> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Float>("set_rayleigh_coefficient")

    @JvmField
    public val getRayleighCoefficientName: MethodStringName0<PhysicalSkyMaterial, Float> =
        MethodStringName0<PhysicalSkyMaterial, Float>("get_rayleigh_coefficient")

    @JvmField
    public val setRayleighColorName: MethodStringName1<PhysicalSkyMaterial, Unit, Color> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Color>("set_rayleigh_color")

    @JvmField
    public val getRayleighColorName: MethodStringName0<PhysicalSkyMaterial, Color> =
        MethodStringName0<PhysicalSkyMaterial, Color>("get_rayleigh_color")

    @JvmField
    public val setMieCoefficientName: MethodStringName1<PhysicalSkyMaterial, Unit, Float> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Float>("set_mie_coefficient")

    @JvmField
    public val getMieCoefficientName: MethodStringName0<PhysicalSkyMaterial, Float> =
        MethodStringName0<PhysicalSkyMaterial, Float>("get_mie_coefficient")

    @JvmField
    public val setMieEccentricityName: MethodStringName1<PhysicalSkyMaterial, Unit, Float> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Float>("set_mie_eccentricity")

    @JvmField
    public val getMieEccentricityName: MethodStringName0<PhysicalSkyMaterial, Float> =
        MethodStringName0<PhysicalSkyMaterial, Float>("get_mie_eccentricity")

    @JvmField
    public val setMieColorName: MethodStringName1<PhysicalSkyMaterial, Unit, Color> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Color>("set_mie_color")

    @JvmField
    public val getMieColorName: MethodStringName0<PhysicalSkyMaterial, Color> =
        MethodStringName0<PhysicalSkyMaterial, Color>("get_mie_color")

    @JvmField
    public val setTurbidityName: MethodStringName1<PhysicalSkyMaterial, Unit, Float> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Float>("set_turbidity")

    @JvmField
    public val getTurbidityName: MethodStringName0<PhysicalSkyMaterial, Float> =
        MethodStringName0<PhysicalSkyMaterial, Float>("get_turbidity")

    @JvmField
    public val setSunDiskScaleName: MethodStringName1<PhysicalSkyMaterial, Unit, Float> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Float>("set_sun_disk_scale")

    @JvmField
    public val getSunDiskScaleName: MethodStringName0<PhysicalSkyMaterial, Float> =
        MethodStringName0<PhysicalSkyMaterial, Float>("get_sun_disk_scale")

    @JvmField
    public val setGroundColorName: MethodStringName1<PhysicalSkyMaterial, Unit, Color> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Color>("set_ground_color")

    @JvmField
    public val getGroundColorName: MethodStringName0<PhysicalSkyMaterial, Color> =
        MethodStringName0<PhysicalSkyMaterial, Color>("get_ground_color")

    @JvmField
    public val setEnergyMultiplierName: MethodStringName1<PhysicalSkyMaterial, Unit, Float> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Float>("set_energy_multiplier")

    @JvmField
    public val getEnergyMultiplierName: MethodStringName0<PhysicalSkyMaterial, Float> =
        MethodStringName0<PhysicalSkyMaterial, Float>("get_energy_multiplier")

    @JvmField
    public val setUseDebandingName: MethodStringName1<PhysicalSkyMaterial, Unit, Boolean> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Boolean>("set_use_debanding")

    @JvmField
    public val getUseDebandingName: MethodStringName0<PhysicalSkyMaterial, Boolean> =
        MethodStringName0<PhysicalSkyMaterial, Boolean>("get_use_debanding")

    @JvmField
    public val setNightSkyName: MethodStringName1<PhysicalSkyMaterial, Unit, Texture2D?> =
        MethodStringName1<PhysicalSkyMaterial, Unit, Texture2D?>("set_night_sky")

    @JvmField
    public val getNightSkyName: MethodStringName0<PhysicalSkyMaterial, Texture2D?> =
        MethodStringName0<PhysicalSkyMaterial, Texture2D?>("get_night_sky")
  }

  public object MethodBindings {
    internal val setRayleighCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_rayleigh_coefficient", 373806689)

    internal val getRayleighCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_rayleigh_coefficient", 1740695150)

    internal val setRayleighColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_rayleigh_color", 2920490490)

    internal val getRayleighColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_rayleigh_color", 3444240500)

    internal val setMieCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_mie_coefficient", 373806689)

    internal val getMieCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_mie_coefficient", 1740695150)

    internal val setMieEccentricityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_mie_eccentricity", 373806689)

    internal val getMieEccentricityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_mie_eccentricity", 1740695150)

    internal val setMieColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_mie_color", 2920490490)

    internal val getMieColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_mie_color", 3444240500)

    internal val setTurbidityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_turbidity", 373806689)

    internal val getTurbidityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_turbidity", 1740695150)

    internal val setSunDiskScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_sun_disk_scale", 373806689)

    internal val getSunDiskScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_sun_disk_scale", 1740695150)

    internal val setGroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_ground_color", 2920490490)

    internal val getGroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_ground_color", 3444240500)

    internal val setEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_energy_multiplier", 373806689)

    internal val getEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_energy_multiplier", 1740695150)

    internal val setUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_use_debanding", 2586408642)

    internal val getUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_use_debanding", 36873697)

    internal val setNightSkyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "set_night_sky", 4051416890)

    internal val getNightSkyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalSkyMaterial", "get_night_sky", 3635182373)
  }
}
