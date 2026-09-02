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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.StringName
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Double
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * Represents a light as defined by the `KHR_lights_punctual` glTF extension.
 */
@GodotBaseType
public open class GLTFLight : Resource() {
  /**
   * The [Color] of the light in linear space. Defaults to white. A black color causes the light to
   * have no effect.
   *
   * This value is linear to match glTF, but will be converted to nonlinear sRGB when creating a
   * Godot [Light3D] node upon import, or converted to linear when exporting a Godot [Light3D] to glTF.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var color: Color
    @JvmName("colorProperty")
    get() = getColor()
    @JvmName("colorProperty")
    set(`value`) {
      setColor(value)
    }

  /**
   * The intensity of the light. This is expressed in candelas (lumens per steradian) for point and
   * spot lights, and lux (lumens per m²) for directional lights. When creating a Godot light, this
   * value is converted to a unitless multiplier.
   */
  public final inline var intensity: Float
    @JvmName("intensityProperty")
    get() = getIntensity()
    @JvmName("intensityProperty")
    set(`value`) {
      setIntensity(value)
    }

  /**
   * The type of the light. The values accepted by Godot are "point", "spot", and "directional",
   * which correspond to Godot's [OmniLight3D], [SpotLight3D], and [DirectionalLight3D] respectively.
   */
  public final inline var lightType: String
    @JvmName("lightTypeProperty")
    get() = getLightType()
    @JvmName("lightTypeProperty")
    set(`value`) {
      setLightType(value)
    }

  /**
   * The range of the light, beyond which the light has no effect. glTF lights with no range defined
   * behave like physical lights (which have infinite range). When creating a Godot light, the range is
   * clamped to `4096.0`.
   */
  public final inline var range: Float
    @JvmName("rangeProperty")
    get() = getRange()
    @JvmName("rangeProperty")
    set(`value`) {
      setRange(value)
    }

  /**
   * The inner angle of the cone in a spotlight. Must be less than or equal to the outer cone angle.
   *
   * Within this angle, the light is at full brightness. Between the inner and outer cone angles,
   * there is a transition from full brightness to zero brightness. When creating a Godot
   * [SpotLight3D], the ratio between the inner and outer cone angles is used to calculate the
   * attenuation of the light.
   */
  public final inline var innerConeAngle: Float
    @JvmName("innerConeAngleProperty")
    get() = getInnerConeAngle()
    @JvmName("innerConeAngleProperty")
    set(`value`) {
      setInnerConeAngle(value)
    }

  /**
   * The outer angle of the cone in a spotlight. Must be greater than or equal to the inner angle.
   *
   * At this angle, the light drops off to zero brightness. Between the inner and outer cone angles,
   * there is a transition from full brightness to zero brightness. If this angle is a half turn, then
   * the spotlight emits in all directions. When creating a Godot [SpotLight3D], the outer cone angle
   * is used as the angle of the spotlight.
   */
  public final inline var outerConeAngle: Float
    @JvmName("outerConeAngleProperty")
    get() = getOuterConeAngle()
    @JvmName("outerConeAngleProperty")
    set(`value`) {
      setOuterConeAngle(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(247, scriptPtr)
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltflight.color
   * //Your changes
   * gltflight.color = myCoreType
   * ``````
   *
   * The [Color] of the light in linear space. Defaults to white. A black color causes the light to
   * have no effect.
   *
   * This value is linear to match glTF, but will be converted to nonlinear sRGB when creating a
   * Godot [Light3D] node upon import, or converted to linear when exporting a Godot [Light3D] to glTF.
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  /**
   * Converts this GLTFLight instance into a Godot [Light3D] node.
   */
  public final fun toNode(): Light3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as Light3D?)
  }

  /**
   * Serializes this GLTFLight instance into a [Dictionary].
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toDictionaryPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun getColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setColorPtr)
  }

  public final fun getIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setIntensity(intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.setIntensityPtr)
  }

  public final fun getLightType(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightTypePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setLightType(lightType: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to lightType)
    TransferContext.callMethod(MethodBindings.setLightTypePtr)
  }

  public final fun getRange(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRangePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRange(range: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to range.toDouble())
    TransferContext.callMethod(MethodBindings.setRangePtr)
  }

  public final fun getInnerConeAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInnerConeAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setInnerConeAngle(innerConeAngle: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to innerConeAngle.toDouble())
    TransferContext.callMethod(MethodBindings.setInnerConeAnglePtr)
  }

  public final fun getOuterConeAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOuterConeAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setOuterConeAngle(outerConeAngle: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to outerConeAngle.toDouble())
    TransferContext.callMethod(MethodBindings.setOuterConeAnglePtr)
  }

  public final fun getAdditionalData(extensionName: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName)
    TransferContext.callMethod(MethodBindings.getAdditionalDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public final fun setAdditionalData(extensionName: StringName, additionalData: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName, ANY to additionalData)
    TransferContext.callMethod(MethodBindings.setAdditionalDataPtr)
  }

  public final fun getAdditionalData(extensionName: String): Any? =
      getAdditionalData(extensionName.asCachedStringName())

  public final fun setAdditionalData(extensionName: String, additionalData: Any?) =
      setAdditionalData(extensionName.asCachedStringName(), additionalData)

  public companion object {
    @JvmField
    public val fromNodeName: MethodStringName1<GLTFLight, GLTFLight?, Light3D?> =
        MethodStringName1<GLTFLight, GLTFLight?, Light3D?>("from_node")

    @JvmField
    public val toNodeName: MethodStringName0<GLTFLight, Light3D?> =
        MethodStringName0<GLTFLight, Light3D?>("to_node")

    @JvmField
    public val fromDictionaryName: MethodStringName1<GLTFLight, GLTFLight?, Dictionary<Any?, Any?>>
        = MethodStringName1<GLTFLight, GLTFLight?, Dictionary<Any?, Any?>>("from_dictionary")

    @JvmField
    public val toDictionaryName: MethodStringName0<GLTFLight, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFLight, Dictionary<Any?, Any?>>("to_dictionary")

    @JvmField
    public val getColorName: MethodStringName0<GLTFLight, Color> =
        MethodStringName0<GLTFLight, Color>("get_color")

    @JvmField
    public val setColorName: MethodStringName1<GLTFLight, Unit, Color> =
        MethodStringName1<GLTFLight, Unit, Color>("set_color")

    @JvmField
    public val getIntensityName: MethodStringName0<GLTFLight, Float> =
        MethodStringName0<GLTFLight, Float>("get_intensity")

    @JvmField
    public val setIntensityName: MethodStringName1<GLTFLight, Unit, Float> =
        MethodStringName1<GLTFLight, Unit, Float>("set_intensity")

    @JvmField
    public val getLightTypeName: MethodStringName0<GLTFLight, String> =
        MethodStringName0<GLTFLight, String>("get_light_type")

    @JvmField
    public val setLightTypeName: MethodStringName1<GLTFLight, Unit, String> =
        MethodStringName1<GLTFLight, Unit, String>("set_light_type")

    @JvmField
    public val getRangeName: MethodStringName0<GLTFLight, Float> =
        MethodStringName0<GLTFLight, Float>("get_range")

    @JvmField
    public val setRangeName: MethodStringName1<GLTFLight, Unit, Float> =
        MethodStringName1<GLTFLight, Unit, Float>("set_range")

    @JvmField
    public val getInnerConeAngleName: MethodStringName0<GLTFLight, Float> =
        MethodStringName0<GLTFLight, Float>("get_inner_cone_angle")

    @JvmField
    public val setInnerConeAngleName: MethodStringName1<GLTFLight, Unit, Float> =
        MethodStringName1<GLTFLight, Unit, Float>("set_inner_cone_angle")

    @JvmField
    public val getOuterConeAngleName: MethodStringName0<GLTFLight, Float> =
        MethodStringName0<GLTFLight, Float>("get_outer_cone_angle")

    @JvmField
    public val setOuterConeAngleName: MethodStringName1<GLTFLight, Unit, Float> =
        MethodStringName1<GLTFLight, Unit, Float>("set_outer_cone_angle")

    @JvmField
    public val getAdditionalDataName: MethodStringName1<GLTFLight, Any?, StringName> =
        MethodStringName1<GLTFLight, Any?, StringName>("get_additional_data")

    @JvmField
    public val setAdditionalDataName: MethodStringName2<GLTFLight, Unit, StringName, Any?> =
        MethodStringName2<GLTFLight, Unit, StringName, Any?>("set_additional_data")

    /**
     * Create a new GLTFLight instance from the given Godot [Light3D] node.
     */
    @JvmStatic
    public final fun fromNode(lightNode: Light3D?): GLTFLight? {
      TransferContext.writeMethodArguments(0L, 0L, OBJECT to lightNode)
      TransferContext.callMethod(MethodBindings.fromNodePtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFLight?)
    }

    /**
     * Creates a new GLTFLight instance by parsing the given [Dictionary].
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFLight? {
      TransferContext.writeMethodArguments(0L, 0L, DICTIONARY to dictionary)
      TransferContext.callMethod(MethodBindings.fromDictionaryPtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFLight?)
    }
  }

  public object MethodBindings {
    internal val fromNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "from_node", 3907677874)

    internal val toNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "to_node", 2040811672)

    internal val fromDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "from_dictionary", 4057087208)

    internal val toDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "to_dictionary", 3102165223)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_color", 3200896285)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_color", 2920490490)

    internal val getIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_intensity", 191475506)

    internal val setIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_intensity", 373806689)

    internal val getLightTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_light_type", 2841200299)

    internal val setLightTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_light_type", 83702148)

    internal val getRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_range", 191475506)

    internal val setRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_range", 373806689)

    internal val getInnerConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_inner_cone_angle", 191475506)

    internal val setInnerConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_inner_cone_angle", 373806689)

    internal val getOuterConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_outer_cone_angle", 191475506)

    internal val setOuterConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_outer_cone_angle", 373806689)

    internal val getAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "get_additional_data", 2138907829)

    internal val setAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFLight", "set_additional_data", 3776071444)
  }
}
