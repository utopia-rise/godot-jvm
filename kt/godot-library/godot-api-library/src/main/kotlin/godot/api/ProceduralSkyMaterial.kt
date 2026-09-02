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
 * [ProceduralSkyMaterial] provides a way to create an effective background quickly by defining
 * procedural parameters for the sun, the sky and the ground. The sky and ground are defined by a main
 * color, a color at the horizon, and an easing curve to interpolate between them. Suns are described
 * by a position in the sky, a color, and a max angle from the sun at which the easing curve ends. The
 * max angle therefore defines the size of the sun in the sky.
 *
 * [ProceduralSkyMaterial] supports up to 4 suns, using the color, and energy, direction, and
 * angular distance of the first four [DirectionalLight3D] nodes in the scene. This means that the suns
 * are defined individually by the properties of their corresponding [DirectionalLight3D]s and globally
 * by [sunAngleMax] and [sunCurve].
 *
 * [ProceduralSkyMaterial] uses a lightweight shader to draw the sky and is therefore suited for
 * real-time updates. This makes it a great option for a sky that is simple and computationally cheap,
 * but unrealistic. If you need a more realistic procedural option, use [PhysicalSkyMaterial].
 */
@GodotBaseType
public open class ProceduralSkyMaterial : Material() {
  /**
   * Color of the sky at the top. Blends with [skyHorizonColor].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var skyTopColor: Color
    @JvmName("skyTopColorProperty")
    get() = getSkyTopColor()
    @JvmName("skyTopColorProperty")
    set(`value`) {
      setSkyTopColor(value)
    }

  /**
   * Color of the sky at the horizon. Blends with [skyTopColor].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var skyHorizonColor: Color
    @JvmName("skyHorizonColorProperty")
    get() = getSkyHorizonColor()
    @JvmName("skyHorizonColorProperty")
    set(`value`) {
      setSkyHorizonColor(value)
    }

  /**
   * How quickly the [skyHorizonColor] fades into the [skyTopColor].
   */
  public final inline var skyCurve: Float
    @JvmName("skyCurveProperty")
    get() = getSkyCurve()
    @JvmName("skyCurveProperty")
    set(`value`) {
      setSkyCurve(value)
    }

  /**
   * Multiplier for sky color. A higher value will make the sky brighter.
   */
  public final inline var skyEnergyMultiplier: Float
    @JvmName("skyEnergyMultiplierProperty")
    get() = getSkyEnergyMultiplier()
    @JvmName("skyEnergyMultiplierProperty")
    set(`value`) {
      setSkyEnergyMultiplier(value)
    }

  /**
   * The sky cover texture to use. This texture must use an equirectangular projection (similar to
   * [PanoramaSkyMaterial]). The texture's colors will be *added* to the existing sky color, and will
   * be multiplied by [skyEnergyMultiplier] and [skyCoverModulate]. This is mainly suited to displaying
   * stars at night, but it can also be used to display clouds at day or night (with a
   * non-physically-accurate look).
   */
  public final inline var skyCover: Texture2D?
    @JvmName("skyCoverProperty")
    get() = getSkyCover()
    @JvmName("skyCoverProperty")
    set(`value`) {
      setSkyCover(value)
    }

  /**
   * The tint to apply to the [skyCover] texture. This can be used to change the sky cover's colors
   * or opacity independently of the sky energy, which is useful for day/night or weather transitions.
   * Only effective if a texture is defined in [skyCover].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var skyCoverModulate: Color
    @JvmName("skyCoverModulateProperty")
    get() = getSkyCoverModulate()
    @JvmName("skyCoverModulateProperty")
    set(`value`) {
      setSkyCoverModulate(value)
    }

  /**
   * Color of the ground at the bottom. Blends with [groundHorizonColor].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var groundBottomColor: Color
    @JvmName("groundBottomColorProperty")
    get() = getGroundBottomColor()
    @JvmName("groundBottomColorProperty")
    set(`value`) {
      setGroundBottomColor(value)
    }

  /**
   * Color of the ground at the horizon. Blends with [groundBottomColor].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var groundHorizonColor: Color
    @JvmName("groundHorizonColorProperty")
    get() = getGroundHorizonColor()
    @JvmName("groundHorizonColorProperty")
    set(`value`) {
      setGroundHorizonColor(value)
    }

  /**
   * How quickly the [groundHorizonColor] fades into the [groundBottomColor].
   */
  public final inline var groundCurve: Float
    @JvmName("groundCurveProperty")
    get() = getGroundCurve()
    @JvmName("groundCurveProperty")
    set(`value`) {
      setGroundCurve(value)
    }

  /**
   * Multiplier for ground color. A higher value will make the ground brighter.
   */
  public final inline var groundEnergyMultiplier: Float
    @JvmName("groundEnergyMultiplierProperty")
    get() = getGroundEnergyMultiplier()
    @JvmName("groundEnergyMultiplierProperty")
    set(`value`) {
      setGroundEnergyMultiplier(value)
    }

  /**
   * Distance from center of sun where it fades out completely.
   */
  public final inline var sunAngleMax: Float
    @JvmName("sunAngleMaxProperty")
    get() = getSunAngleMax()
    @JvmName("sunAngleMaxProperty")
    set(`value`) {
      setSunAngleMax(value)
    }

  /**
   * How quickly the sun fades away between the edge of the sun disk and [sunAngleMax].
   */
  public final inline var sunCurve: Float
    @JvmName("sunCurveProperty")
    get() = getSunCurve()
    @JvmName("sunCurveProperty")
    set(`value`) {
      setSunCurve(value)
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
   * The sky's overall brightness multiplier. Higher values result in a brighter sky.
   */
  public final inline var energyMultiplier: Float
    @JvmName("energyMultiplierProperty")
    get() = getEnergyMultiplier()
    @JvmName("energyMultiplierProperty")
    set(`value`) {
      setEnergyMultiplier(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(572, scriptPtr)
  }

  /**
   * This is a helper function for [skyTopColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = proceduralskymaterial.skyTopColor
   * //Your changes
   * proceduralskymaterial.skyTopColor = myCoreType
   * ``````
   *
   * Color of the sky at the top. Blends with [skyHorizonColor].
   */
  @CoreTypeHelper
  public final fun skyTopColorMutate(block: Color.() -> Unit): Color = skyTopColor.apply {
     block(this)
     skyTopColor = this
  }

  /**
   * This is a helper function for [skyHorizonColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = proceduralskymaterial.skyHorizonColor
   * //Your changes
   * proceduralskymaterial.skyHorizonColor = myCoreType
   * ``````
   *
   * Color of the sky at the horizon. Blends with [skyTopColor].
   */
  @CoreTypeHelper
  public final fun skyHorizonColorMutate(block: Color.() -> Unit): Color = skyHorizonColor.apply {
     block(this)
     skyHorizonColor = this
  }

  /**
   * This is a helper function for [skyCoverModulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = proceduralskymaterial.skyCoverModulate
   * //Your changes
   * proceduralskymaterial.skyCoverModulate = myCoreType
   * ``````
   *
   * The tint to apply to the [skyCover] texture. This can be used to change the sky cover's colors
   * or opacity independently of the sky energy, which is useful for day/night or weather transitions.
   * Only effective if a texture is defined in [skyCover].
   */
  @CoreTypeHelper
  public final fun skyCoverModulateMutate(block: Color.() -> Unit): Color = skyCoverModulate.apply {
     block(this)
     skyCoverModulate = this
  }

  /**
   * This is a helper function for [groundBottomColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = proceduralskymaterial.groundBottomColor
   * //Your changes
   * proceduralskymaterial.groundBottomColor = myCoreType
   * ``````
   *
   * Color of the ground at the bottom. Blends with [groundHorizonColor].
   */
  @CoreTypeHelper
  public final fun groundBottomColorMutate(block: Color.() -> Unit): Color =
      groundBottomColor.apply {
     block(this)
     groundBottomColor = this
  }

  /**
   * This is a helper function for [groundHorizonColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = proceduralskymaterial.groundHorizonColor
   * //Your changes
   * proceduralskymaterial.groundHorizonColor = myCoreType
   * ``````
   *
   * Color of the ground at the horizon. Blends with [groundBottomColor].
   */
  @CoreTypeHelper
  public final fun groundHorizonColorMutate(block: Color.() -> Unit): Color =
      groundHorizonColor.apply {
     block(this)
     groundHorizonColor = this
  }

  public final fun setSkyTopColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setSkyTopColorPtr)
  }

  public final fun getSkyTopColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyTopColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setSkyHorizonColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setSkyHorizonColorPtr)
  }

  public final fun getSkyHorizonColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyHorizonColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setSkyCurve(curve: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curve.toDouble())
    TransferContext.callMethod(MethodBindings.setSkyCurvePtr)
  }

  public final fun getSkyCurve(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyCurvePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSkyEnergyMultiplier(multiplier: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to multiplier.toDouble())
    TransferContext.callMethod(MethodBindings.setSkyEnergyMultiplierPtr)
  }

  public final fun getSkyEnergyMultiplier(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyEnergyMultiplierPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSkyCover(skyCover: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to skyCover)
    TransferContext.callMethod(MethodBindings.setSkyCoverPtr)
  }

  public final fun getSkyCover(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyCoverPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setSkyCoverModulate(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setSkyCoverModulatePtr)
  }

  public final fun getSkyCoverModulate(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyCoverModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setGroundBottomColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setGroundBottomColorPtr)
  }

  public final fun getGroundBottomColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGroundBottomColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setGroundHorizonColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setGroundHorizonColorPtr)
  }

  public final fun getGroundHorizonColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGroundHorizonColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setGroundCurve(curve: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curve.toDouble())
    TransferContext.callMethod(MethodBindings.setGroundCurvePtr)
  }

  public final fun getGroundCurve(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGroundCurvePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGroundEnergyMultiplier(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setGroundEnergyMultiplierPtr)
  }

  public final fun getGroundEnergyMultiplier(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGroundEnergyMultiplierPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSunAngleMax(degrees: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to degrees.toDouble())
    TransferContext.callMethod(MethodBindings.setSunAngleMaxPtr)
  }

  public final fun getSunAngleMax(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSunAngleMaxPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSunCurve(curve: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curve.toDouble())
    TransferContext.callMethod(MethodBindings.setSunCurvePtr)
  }

  public final fun getSunCurve(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSunCurvePtr)
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

  public final fun setEnergyMultiplier(multiplier: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to multiplier.toDouble())
    TransferContext.callMethod(MethodBindings.setEnergyMultiplierPtr)
  }

  public final fun getEnergyMultiplier(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnergyMultiplierPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("ProceduralSkyMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("ProceduralSkyMaterial::_getShaderMode can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setSkyTopColorName: MethodStringName1<ProceduralSkyMaterial, Unit, Color> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Color>("set_sky_top_color")

    @JvmField
    public val getSkyTopColorName: MethodStringName0<ProceduralSkyMaterial, Color> =
        MethodStringName0<ProceduralSkyMaterial, Color>("get_sky_top_color")

    @JvmField
    public val setSkyHorizonColorName: MethodStringName1<ProceduralSkyMaterial, Unit, Color> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Color>("set_sky_horizon_color")

    @JvmField
    public val getSkyHorizonColorName: MethodStringName0<ProceduralSkyMaterial, Color> =
        MethodStringName0<ProceduralSkyMaterial, Color>("get_sky_horizon_color")

    @JvmField
    public val setSkyCurveName: MethodStringName1<ProceduralSkyMaterial, Unit, Float> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_sky_curve")

    @JvmField
    public val getSkyCurveName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_sky_curve")

    @JvmField
    public val setSkyEnergyMultiplierName: MethodStringName1<ProceduralSkyMaterial, Unit, Float> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_sky_energy_multiplier")

    @JvmField
    public val getSkyEnergyMultiplierName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_sky_energy_multiplier")

    @JvmField
    public val setSkyCoverName: MethodStringName1<ProceduralSkyMaterial, Unit, Texture2D?> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Texture2D?>("set_sky_cover")

    @JvmField
    public val getSkyCoverName: MethodStringName0<ProceduralSkyMaterial, Texture2D?> =
        MethodStringName0<ProceduralSkyMaterial, Texture2D?>("get_sky_cover")

    @JvmField
    public val setSkyCoverModulateName: MethodStringName1<ProceduralSkyMaterial, Unit, Color> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Color>("set_sky_cover_modulate")

    @JvmField
    public val getSkyCoverModulateName: MethodStringName0<ProceduralSkyMaterial, Color> =
        MethodStringName0<ProceduralSkyMaterial, Color>("get_sky_cover_modulate")

    @JvmField
    public val setGroundBottomColorName: MethodStringName1<ProceduralSkyMaterial, Unit, Color> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Color>("set_ground_bottom_color")

    @JvmField
    public val getGroundBottomColorName: MethodStringName0<ProceduralSkyMaterial, Color> =
        MethodStringName0<ProceduralSkyMaterial, Color>("get_ground_bottom_color")

    @JvmField
    public val setGroundHorizonColorName: MethodStringName1<ProceduralSkyMaterial, Unit, Color> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Color>("set_ground_horizon_color")

    @JvmField
    public val getGroundHorizonColorName: MethodStringName0<ProceduralSkyMaterial, Color> =
        MethodStringName0<ProceduralSkyMaterial, Color>("get_ground_horizon_color")

    @JvmField
    public val setGroundCurveName: MethodStringName1<ProceduralSkyMaterial, Unit, Float> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_ground_curve")

    @JvmField
    public val getGroundCurveName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_ground_curve")

    @JvmField
    public val setGroundEnergyMultiplierName: MethodStringName1<ProceduralSkyMaterial, Unit, Float>
        = MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_ground_energy_multiplier")

    @JvmField
    public val getGroundEnergyMultiplierName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_ground_energy_multiplier")

    @JvmField
    public val setSunAngleMaxName: MethodStringName1<ProceduralSkyMaterial, Unit, Float> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_sun_angle_max")

    @JvmField
    public val getSunAngleMaxName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_sun_angle_max")

    @JvmField
    public val setSunCurveName: MethodStringName1<ProceduralSkyMaterial, Unit, Float> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_sun_curve")

    @JvmField
    public val getSunCurveName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_sun_curve")

    @JvmField
    public val setUseDebandingName: MethodStringName1<ProceduralSkyMaterial, Unit, Boolean> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Boolean>("set_use_debanding")

    @JvmField
    public val getUseDebandingName: MethodStringName0<ProceduralSkyMaterial, Boolean> =
        MethodStringName0<ProceduralSkyMaterial, Boolean>("get_use_debanding")

    @JvmField
    public val setEnergyMultiplierName: MethodStringName1<ProceduralSkyMaterial, Unit, Float> =
        MethodStringName1<ProceduralSkyMaterial, Unit, Float>("set_energy_multiplier")

    @JvmField
    public val getEnergyMultiplierName: MethodStringName0<ProceduralSkyMaterial, Float> =
        MethodStringName0<ProceduralSkyMaterial, Float>("get_energy_multiplier")
  }

  public object MethodBindings {
    internal val setSkyTopColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sky_top_color", 2920490490)

    internal val getSkyTopColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sky_top_color", 3444240500)

    internal val setSkyHorizonColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sky_horizon_color", 2920490490)

    internal val getSkyHorizonColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sky_horizon_color", 3444240500)

    internal val setSkyCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sky_curve", 373806689)

    internal val getSkyCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sky_curve", 1740695150)

    internal val setSkyEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sky_energy_multiplier", 373806689)

    internal val getSkyEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sky_energy_multiplier", 1740695150)

    internal val setSkyCoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sky_cover", 4051416890)

    internal val getSkyCoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sky_cover", 3635182373)

    internal val setSkyCoverModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sky_cover_modulate", 2920490490)

    internal val getSkyCoverModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sky_cover_modulate", 3444240500)

    internal val setGroundBottomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_ground_bottom_color", 2920490490)

    internal val getGroundBottomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_ground_bottom_color", 3444240500)

    internal val setGroundHorizonColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_ground_horizon_color", 2920490490)

    internal val getGroundHorizonColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_ground_horizon_color", 3444240500)

    internal val setGroundCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_ground_curve", 373806689)

    internal val getGroundCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_ground_curve", 1740695150)

    internal val setGroundEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_ground_energy_multiplier", 373806689)

    internal val getGroundEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_ground_energy_multiplier", 1740695150)

    internal val setSunAngleMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sun_angle_max", 373806689)

    internal val getSunAngleMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sun_angle_max", 1740695150)

    internal val setSunCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_sun_curve", 373806689)

    internal val getSunCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_sun_curve", 1740695150)

    internal val setUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_use_debanding", 2586408642)

    internal val getUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_use_debanding", 36873697)

    internal val setEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "set_energy_multiplier", 373806689)

    internal val getEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ProceduralSkyMaterial", "get_energy_multiplier", 1740695150)
  }
}
