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
import godot.core.RID
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
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class serves as a default material with a wide variety of rendering features and properties
 * without the need to write shader code. See the tutorial below for details.
 */
@GodotBaseType
public open class BaseMaterial3D internal constructor() : Material() {
  /**
   * The material's transparency mode. Some transparency modes will disable shadow casting. Any
   * transparency mode other than [TRANSPARENCY_DISABLED] has a greater performance impact compared to
   * opaque rendering. See also [blendMode].
   */
  public final inline var transparency: Transparency
    @JvmName("transparencyProperty")
    get() = getTransparency()
    @JvmName("transparencyProperty")
    set(`value`) {
      setTransparency(value)
    }

  /**
   * Threshold at which the alpha scissor will discard values. Higher values will result in more
   * pixels being discarded. If the material becomes too opaque at a distance, try increasing
   * [alphaScissorThreshold]. If the material disappears at a distance, try decreasing
   * [alphaScissorThreshold].
   */
  public final inline var alphaScissorThreshold: Float
    @JvmName("alphaScissorThresholdProperty")
    get() = getAlphaScissorThreshold()
    @JvmName("alphaScissorThresholdProperty")
    set(`value`) {
      setAlphaScissorThreshold(value)
    }

  /**
   * The hashing scale for Alpha Hash. Recommended values between `0` and `2`.
   */
  public final inline var alphaHashScale: Float
    @JvmName("alphaHashScaleProperty")
    get() = getAlphaHashScale()
    @JvmName("alphaHashScaleProperty")
    set(`value`) {
      setAlphaHashScale(value)
    }

  /**
   * The type of alpha antialiasing to apply.
   */
  public final inline var alphaAntialiasingMode: AlphaAntiAliasing
    @JvmName("alphaAntialiasingModeProperty")
    get() = getAlphaAntialiasing()
    @JvmName("alphaAntialiasingModeProperty")
    set(`value`) {
      setAlphaAntialiasing(value)
    }

  /**
   * Threshold at which antialiasing will be applied on the alpha channel.
   */
  public final inline var alphaAntialiasingEdge: Float
    @JvmName("alphaAntialiasingEdgeProperty")
    get() = getAlphaAntialiasingEdge()
    @JvmName("alphaAntialiasingEdgeProperty")
    set(`value`) {
      setAlphaAntialiasingEdge(value)
    }

  /**
   * The material's blend mode.
   *
   * **Note:** Values other than `Mix` force the object into the transparent pipeline.
   */
  public final inline var blendMode: BlendMode
    @JvmName("blendModeProperty")
    get() = getBlendMode()
    @JvmName("blendModeProperty")
    set(`value`) {
      setBlendMode(value)
    }

  /**
   * Determines which side of the triangle to cull depending on whether the triangle faces towards
   * or away from the camera.
   */
  public final inline var cullMode: CullMode
    @JvmName("cullModeProperty")
    get() = getCullMode()
    @JvmName("cullModeProperty")
    set(`value`) {
      setCullMode(value)
    }

  /**
   * Determines when depth rendering takes place. See also [transparency].
   */
  public final inline var depthDrawMode: DepthDrawMode
    @JvmName("depthDrawModeProperty")
    get() = getDepthDrawMode()
    @JvmName("depthDrawModeProperty")
    set(`value`) {
      setDepthDrawMode(value)
    }

  /**
   * If `true`, depth testing is disabled and the object will be drawn in render order.
   */
  public final inline var noDepthTest: Boolean
    @JvmName("noDepthTestProperty")
    get() = getFlag(BaseMaterial3D.Flags.DISABLE_DEPTH_TEST)
    @JvmName("noDepthTestProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.DISABLE_DEPTH_TEST, value)
    }

  /**
   * Determines which comparison operator is used when testing depth.
   *
   * **Note:** Changing [depthTest] to a non-default value only has a visible effect when used on a
   * transparent material, or a material that has [depthDrawMode] set to [DEPTH_DRAW_DISABLED].
   */
  public final inline var depthTest: DepthTest
    @JvmName("depthTestProperty")
    get() = getDepthTest()
    @JvmName("depthTestProperty")
    set(`value`) {
      setDepthTest(value)
    }

  /**
   * Sets whether the shading takes place, per-pixel, per-vertex or unshaded. Per-vertex lighting is
   * faster, making it the best choice for mobile applications, however it looks considerably worse
   * than per-pixel. Unshaded rendering is the fastest, but disables all interactions with lights.
   */
  public final inline var shadingMode: ShadingMode
    @JvmName("shadingModeProperty")
    get() = getShadingMode()
    @JvmName("shadingModeProperty")
    set(`value`) {
      setShadingMode(value)
    }

  /**
   * The algorithm used for diffuse light scattering.
   */
  public final inline var diffuseMode: DiffuseMode
    @JvmName("diffuseModeProperty")
    get() = getDiffuseMode()
    @JvmName("diffuseModeProperty")
    set(`value`) {
      setDiffuseMode(value)
    }

  /**
   * The method for rendering the specular blob.
   *
   * **Note:** [specularMode] only applies to the specular blob. It does not affect specular
   * reflections from the sky, screen-space reflections, [VoxelGI], SDFGI or [ReflectionProbe]s. To
   * disable reflections from these sources as well, set [metallicSpecular] to `0.0` instead.
   */
  public final inline var specularMode: SpecularMode
    @JvmName("specularModeProperty")
    get() = getSpecularMode()
    @JvmName("specularModeProperty")
    set(`value`) {
      setSpecularMode(value)
    }

  /**
   * If `true`, the object receives no ambient light.
   */
  public final inline var disableAmbientLight: Boolean
    @JvmName("disableAmbientLightProperty")
    get() = getFlag(BaseMaterial3D.Flags.DISABLE_AMBIENT_LIGHT)
    @JvmName("disableAmbientLightProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.DISABLE_AMBIENT_LIGHT, value)
    }

  /**
   * If `true`, the object will not be affected by fog (neither volumetric nor depth fog). This is
   * useful for unshaded or transparent materials (e.g. particles), which without this setting will be
   * affected even if fully transparent.
   */
  public final inline var disableFog: Boolean
    @JvmName("disableFogProperty")
    get() = getFlag(BaseMaterial3D.Flags.DISABLE_FOG)
    @JvmName("disableFogProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.DISABLE_FOG, value)
    }

  /**
   * If `true`, disables specular occlusion even if
   * [ProjectSettings.rendering/reflections/specularOcclusion/enabled] is `false`.
   */
  public final inline var disableSpecularOcclusion: Boolean
    @JvmName("disableSpecularOcclusionProperty")
    get() = getFlag(BaseMaterial3D.Flags.DISABLE_SPECULAR_OCCLUSION)
    @JvmName("disableSpecularOcclusionProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.DISABLE_SPECULAR_OCCLUSION, value)
    }

  /**
   * If `true`, the vertex color is used as albedo color.
   */
  public final inline var vertexColorUseAsAlbedo: Boolean
    @JvmName("vertexColorUseAsAlbedoProperty")
    get() = getFlag(BaseMaterial3D.Flags.ALBEDO_FROM_VERTEX_COLOR)
    @JvmName("vertexColorUseAsAlbedoProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.ALBEDO_FROM_VERTEX_COLOR, value)
    }

  /**
   * If `true`, vertex colors are considered to be stored in nonlinear sRGB encoding and are
   * converted to linear encoding during rendering. If `false`, vertex colors are considered to be
   * stored in linear encoding and are rendered as-is. See also [albedoTextureForceSrgb].
   *
   * **Note:** Only effective when using the Forward+ and Mobile rendering methods, not
   * Compatibility.
   */
  public final inline var vertexColorIsSrgb: Boolean
    @JvmName("vertexColorIsSrgbProperty")
    get() = getFlag(BaseMaterial3D.Flags.SRGB_VERTEX_COLOR)
    @JvmName("vertexColorIsSrgbProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.SRGB_VERTEX_COLOR, value)
    }

  /**
   * The material's base color.
   *
   * **Note:** If [detailEnabled] is `true` and a [detailAlbedo] texture is specified, [albedoColor]
   * will *not* modulate the detail texture. This can be used to color partial areas of a material by
   * not specifying an albedo texture and using a transparent [detailAlbedo] texture instead.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var albedoColor: Color
    @JvmName("albedoColorProperty")
    get() = getAlbedo()
    @JvmName("albedoColorProperty")
    set(`value`) {
      setAlbedo(value)
    }

  /**
   * Texture to multiply by [albedoColor]. Used for basic texturing of objects.
   *
   * If the texture appears unexpectedly too dark or too bright, check [albedoTextureForceSrgb].
   */
  public final inline var albedoTexture: Texture2D?
    @JvmName("albedoTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.ALBEDO)
    @JvmName("albedoTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.ALBEDO, value)
    }

  /**
   * If `true`, forces a conversion of the [albedoTexture] from nonlinear sRGB encoding to linear
   * encoding. See also [vertexColorIsSrgb].
   *
   * This should only be enabled when needed (typically when using a [ViewportTexture] as
   * [albedoTexture]). If [albedoTextureForceSrgb] is `true` when it shouldn't be, the texture will
   * appear to be too dark. If [albedoTextureForceSrgb] is `false` when it shouldn't be, the texture
   * will appear to be too bright.
   */
  public final inline var albedoTextureForceSrgb: Boolean
    @JvmName("albedoTextureForceSrgbProperty")
    get() = getFlag(BaseMaterial3D.Flags.ALBEDO_TEXTURE_FORCE_SRGB)
    @JvmName("albedoTextureForceSrgbProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.ALBEDO_TEXTURE_FORCE_SRGB, value)
    }

  /**
   * Enables multichannel signed distance field rendering shader. Use [msdfPixelRange] and
   * [msdfOutlineSize] to configure MSDF parameters.
   */
  public final inline var albedoTextureMsdf: Boolean
    @JvmName("albedoTextureMsdfProperty")
    get() = getFlag(BaseMaterial3D.Flags.ALBEDO_TEXTURE_MSDF)
    @JvmName("albedoTextureMsdfProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.ALBEDO_TEXTURE_MSDF, value)
    }

  /**
   * The Occlusion/Roughness/Metallic texture to use. This is a more efficient replacement of
   * [aoTexture], [roughnessTexture] and [metallicTexture] in [ORMMaterial3D]. Ambient occlusion is
   * stored in the red channel. Roughness map is stored in the green channel. Metallic map is stored in
   * the blue channel. The alpha channel is ignored.
   */
  public final inline var ormTexture: Texture2D?
    @JvmName("ormTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.ORM)
    @JvmName("ormTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.ORM, value)
    }

  /**
   * A high value makes the material appear more like a metal. Non-metals use their albedo as the
   * diffuse color and add diffuse to the specular reflection. With non-metals, the reflection appears
   * on top of the albedo color. Metals use their albedo as a multiplier to the specular reflection and
   * set the diffuse color to black resulting in a tinted reflection. Materials work better when fully
   * metal or fully non-metal, values between `0` and `1` should only be used for blending between
   * metal and non-metal sections. To alter the amount of reflection use [roughness].
   */
  public final inline var metallic: Float
    @JvmName("metallicProperty")
    get() = getMetallic()
    @JvmName("metallicProperty")
    set(`value`) {
      setMetallic(value)
    }

  /**
   * Adjusts the strength of specular reflections. Specular reflections are composed of scene
   * reflections and the specular lobe which is the bright spot that is reflected from light sources.
   * When set to `0.0`, no specular reflections will be visible. This differs from the
   * [SPECULAR_DISABLED] [SpecularMode] as [SPECULAR_DISABLED] only applies to the specular lobe from
   * the light source.
   *
   * **Note:** Unlike [metallic], this is not energy-conserving, so it should be left at `0.5` in
   * most cases. See also [roughness].
   */
  public final inline var metallicSpecular: Float
    @JvmName("metallicSpecularProperty")
    get() = getSpecular()
    @JvmName("metallicSpecularProperty")
    set(`value`) {
      setSpecular(value)
    }

  /**
   * Texture used to specify metallic for an object. This is multiplied by [metallic].
   */
  public final inline var metallicTexture: Texture2D?
    @JvmName("metallicTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.METALLIC)
    @JvmName("metallicTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.METALLIC, value)
    }

  /**
   * Specifies the channel of the [metallicTexture] in which the metallic information is stored.
   * This is useful when you store the information for multiple effects in a single texture. For
   * example if you stored metallic in the red channel, roughness in the blue, and ambient occlusion in
   * the green you could reduce the number of textures you use.
   */
  public final inline var metallicTextureChannel: TextureChannel
    @JvmName("metallicTextureChannelProperty")
    get() = getMetallicTextureChannel()
    @JvmName("metallicTextureChannelProperty")
    set(`value`) {
      setMetallicTextureChannel(value)
    }

  /**
   * Surface reflection. A value of `0` represents a perfect mirror while a value of `1` completely
   * blurs the reflection. See also [metallic].
   */
  public final inline var roughness: Float
    @JvmName("roughnessProperty")
    get() = getRoughness()
    @JvmName("roughnessProperty")
    set(`value`) {
      setRoughness(value)
    }

  /**
   * Texture used to control the roughness per-pixel. Multiplied by [roughness].
   */
  public final inline var roughnessTexture: Texture2D?
    @JvmName("roughnessTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.ROUGHNESS)
    @JvmName("roughnessTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.ROUGHNESS, value)
    }

  /**
   * Specifies the channel of the [roughnessTexture] in which the roughness information is stored.
   * This is useful when you store the information for multiple effects in a single texture. For
   * example if you stored metallic in the red channel, roughness in the blue, and ambient occlusion in
   * the green you could reduce the number of textures you use.
   */
  public final inline var roughnessTextureChannel: TextureChannel
    @JvmName("roughnessTextureChannelProperty")
    get() = getRoughnessTextureChannel()
    @JvmName("roughnessTextureChannelProperty")
    set(`value`) {
      setRoughnessTextureChannel(value)
    }

  /**
   * If `true`, the body emits light. Emitting light makes the object appear brighter. The object
   * can also cast light on other objects if a [VoxelGI], SDFGI, or [LightmapGI] is used and this
   * object is used in baked lighting.
   */
  public final inline var emissionEnabled: Boolean
    @JvmName("emissionEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.EMISSION)
    @JvmName("emissionEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.EMISSION, value)
    }

  /**
   * The emitted light's color. See [emissionEnabled].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emission: Color
    @JvmName("emissionProperty")
    get() = getEmission()
    @JvmName("emissionProperty")
    set(`value`) {
      setEmission(value)
    }

  /**
   * Multiplier for emitted light. See [emissionEnabled].
   */
  public final inline var emissionEnergyMultiplier: Float
    @JvmName("emissionEnergyMultiplierProperty")
    get() = getEmissionEnergyMultiplier()
    @JvmName("emissionEnergyMultiplierProperty")
    set(`value`) {
      setEmissionEnergyMultiplier(value)
    }

  /**
   * Luminance of emitted light, measured in nits (candela per square meter). Only available when
   * [ProjectSettings.rendering/lightsAndShadows/usePhysicalLightUnits] is enabled. The default is
   * roughly equivalent to an indoor lightbulb.
   */
  public final inline var emissionIntensity: Float
    @JvmName("emissionIntensityProperty")
    get() = getEmissionIntensity()
    @JvmName("emissionIntensityProperty")
    set(`value`) {
      setEmissionIntensity(value)
    }

  /**
   * Sets how [emission] interacts with [emissionTexture]. Can either add or multiply.
   */
  public final inline var emissionOperator: EmissionOperator
    @JvmName("emissionOperatorProperty")
    get() = getEmissionOperator()
    @JvmName("emissionOperatorProperty")
    set(`value`) {
      setEmissionOperator(value)
    }

  /**
   * Use `UV2` to read from the [emissionTexture].
   */
  public final inline var emissionOnUv2: Boolean
    @JvmName("emissionOnUv2Property")
    get() = getFlag(BaseMaterial3D.Flags.EMISSION_ON_UV2)
    @JvmName("emissionOnUv2Property")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.EMISSION_ON_UV2, value)
    }

  /**
   * Texture that specifies how much surface emits light at a given point.
   */
  public final inline var emissionTexture: Texture2D?
    @JvmName("emissionTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.EMISSION)
    @JvmName("emissionTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.EMISSION, value)
    }

  /**
   * If `true`, normal mapping is enabled. This has a slight performance cost, especially on mobile
   * GPUs.
   */
  public final inline var normalEnabled: Boolean
    @JvmName("normalEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.NORMAL_MAPPING)
    @JvmName("normalEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.NORMAL_MAPPING, value)
    }

  /**
   * The strength of the normal map's effect.
   */
  public final inline var normalScale: Float
    @JvmName("normalScaleProperty")
    get() = getNormalScale()
    @JvmName("normalScaleProperty")
    set(`value`) {
      setNormalScale(value)
    }

  /**
   * Texture used to specify the normal at a given pixel. The [normalTexture] only uses the red and
   * green channels; the blue and alpha channels are ignored. The normal read from [normalTexture] is
   * oriented around the surface normal provided by the [Mesh].
   *
   * **Note:** The mesh must have both normals and tangents defined in its vertex data. Otherwise,
   * the normal map won't render correctly and will only appear to darken the whole surface. If
   * creating geometry with [SurfaceTool], you can use [SurfaceTool.generateNormals] and
   * [SurfaceTool.generateTangents] to automatically generate normals and tangents respectively.
   *
   * **Note:** Godot expects the normal map to use X+, Y+, and Z+ coordinates. See
   * [url=http://wiki.polycount.com/wiki/Normal_Map_Technical_Details#Common_Swizzle_Coordinates]this
   * page[/url] for a comparison of normal map coordinates expected by popular engines.
   *
   * **Note:** If [detailEnabled] is `true`, the [detailAlbedo] texture is drawn *below* the
   * [normalTexture]. To display a normal map *above* the [detailAlbedo] texture, use [detailNormal]
   * instead.
   */
  public final inline var normalTexture: Texture2D?
    @JvmName("normalTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.NORMAL)
    @JvmName("normalTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.NORMAL, value)
    }

  /**
   * If `true`, the bent normal map is enabled. This allows for more accurate indirect lighting and
   * specular occlusion.
   */
  public final inline var bentNormalEnabled: Boolean
    @JvmName("bentNormalEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.BENT_NORMAL_MAPPING)
    @JvmName("bentNormalEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.BENT_NORMAL_MAPPING, value)
    }

  /**
   * Texture that specifies the average direction of incoming ambient light at a given pixel. The
   * [bentNormalTexture] only uses the red and green channels; the blue and alpha channels are ignored.
   * The normal read from [bentNormalTexture] is oriented around the surface normal provided by the
   * [Mesh].
   *
   * **Note:** A bent normal map is different from a regular normal map. When baking a bent normal
   * map make sure to use **a cosine distribution** for the bent normal map to work correctly.
   *
   * **Note:** The mesh must have both normals and tangents defined in its vertex data. Otherwise,
   * the shading produced by the bent normal map will not look correct. If creating geometry with
   * [SurfaceTool], you can use [SurfaceTool.generateNormals] and [SurfaceTool.generateTangents] to
   * automatically generate normals and tangents respectively.
   *
   * **Note:** Godot expects the bent normal map to use X+, Y+, and Z+ coordinates. See
   * [url=http://wiki.polycount.com/wiki/Normal_Map_Technical_Details#Common_Swizzle_Coordinates]this
   * page[/url] for a comparison of normal map coordinates expected by popular engines.
   */
  public final inline var bentNormalTexture: Texture2D?
    @JvmName("bentNormalTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.BENT_NORMAL)
    @JvmName("bentNormalTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.BENT_NORMAL, value)
    }

  /**
   * If `true`, rim effect is enabled. Rim lighting increases the brightness at glancing angles on
   * an object.
   *
   * **Note:** Rim lighting is not visible if the material's [shadingMode] is
   * [SHADING_MODE_UNSHADED].
   */
  public final inline var rimEnabled: Boolean
    @JvmName("rimEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.RIM)
    @JvmName("rimEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.RIM, value)
    }

  /**
   * Sets the strength of the rim lighting effect.
   */
  public final inline var rim: Float
    @JvmName("rimProperty")
    get() = getRim()
    @JvmName("rimProperty")
    set(`value`) {
      setRim(value)
    }

  /**
   * The amount of to blend light and albedo color when rendering rim effect. If `0` the light color
   * is used, while `1` means albedo color is used. An intermediate value generally works best.
   */
  public final inline var rimTint: Float
    @JvmName("rimTintProperty")
    get() = getRimTint()
    @JvmName("rimTintProperty")
    set(`value`) {
      setRimTint(value)
    }

  /**
   * Texture used to set the strength of the rim lighting effect per-pixel. Multiplied by [rim].
   */
  public final inline var rimTexture: Texture2D?
    @JvmName("rimTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.RIM)
    @JvmName("rimTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.RIM, value)
    }

  /**
   * If `true`, clearcoat rendering is enabled. Adds a secondary transparent pass to the lighting
   * calculation resulting in an added specular blob. This makes materials appear as if they have a
   * clear layer on them that can be either glossy or rough.
   *
   * **Note:** Clearcoat rendering is not visible if the material's [shadingMode] is
   * [SHADING_MODE_UNSHADED].
   */
  public final inline var clearcoatEnabled: Boolean
    @JvmName("clearcoatEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.CLEARCOAT)
    @JvmName("clearcoatEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.CLEARCOAT, value)
    }

  /**
   * Sets the strength of the clearcoat effect. Setting to `0` looks the same as disabling the
   * clearcoat effect.
   */
  public final inline var clearcoat: Float
    @JvmName("clearcoatProperty")
    get() = getClearcoat()
    @JvmName("clearcoatProperty")
    set(`value`) {
      setClearcoat(value)
    }

  /**
   * Sets the roughness of the clearcoat pass. A higher value results in a rougher clearcoat while a
   * lower value results in a smoother clearcoat.
   */
  public final inline var clearcoatRoughness: Float
    @JvmName("clearcoatRoughnessProperty")
    get() = getClearcoatRoughness()
    @JvmName("clearcoatRoughnessProperty")
    set(`value`) {
      setClearcoatRoughness(value)
    }

  /**
   * Texture that defines the strength of the clearcoat effect and the glossiness of the clearcoat.
   * Strength is specified in the red channel while glossiness is specified in the green channel.
   */
  public final inline var clearcoatTexture: Texture2D?
    @JvmName("clearcoatTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.CLEARCOAT)
    @JvmName("clearcoatTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.CLEARCOAT, value)
    }

  /**
   * If `true`, anisotropy is enabled. Anisotropy changes the shape of the specular blob and aligns
   * it to tangent space. This is useful for brushed aluminum and hair reflections.
   *
   * **Note:** Mesh tangents are needed for anisotropy to work. If the mesh does not contain
   * tangents, the anisotropy effect will appear broken.
   *
   * **Note:** Material anisotropy should not to be confused with anisotropic texture filtering,
   * which can be enabled by setting [textureFilter] to
   * [TEXTURE_FILTER_LINEAR_WITH_MIPMAPS_ANISOTROPIC].
   */
  public final inline var anisotropyEnabled: Boolean
    @JvmName("anisotropyEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.ANISOTROPY)
    @JvmName("anisotropyEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.ANISOTROPY, value)
    }

  /**
   * The strength of the anisotropy effect. This is multiplied by [anisotropyFlowmap]'s alpha
   * channel if a texture is defined there and the texture contains an alpha channel.
   */
  public final inline var anisotropy: Float
    @JvmName("anisotropyProperty")
    get() = getAnisotropy()
    @JvmName("anisotropyProperty")
    set(`value`) {
      setAnisotropy(value)
    }

  /**
   * Texture that offsets the tangent map for anisotropy calculations and optionally controls the
   * anisotropy effect (if an alpha channel is present). The flowmap texture is expected to be a
   * derivative map, with the red channel representing distortion on the X axis and green channel
   * representing distortion on the Y axis. Values below 0.5 will result in negative distortion,
   * whereas values above 0.5 will result in positive distortion.
   *
   * If present, the texture's alpha channel will be used to multiply the strength of the
   * [anisotropy] effect. Fully opaque pixels will keep the anisotropy effect's original strength while
   * fully transparent pixels will disable the anisotropy effect entirely. The flowmap texture's blue
   * channel is ignored.
   */
  public final inline var anisotropyFlowmap: Texture2D?
    @JvmName("anisotropyFlowmapProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.FLOWMAP)
    @JvmName("anisotropyFlowmapProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.FLOWMAP, value)
    }

  /**
   * If `true`, ambient occlusion is enabled. Ambient occlusion darkens areas based on the
   * [aoTexture].
   */
  public final inline var aoEnabled: Boolean
    @JvmName("aoEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.AMBIENT_OCCLUSION)
    @JvmName("aoEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.AMBIENT_OCCLUSION, value)
    }

  /**
   * Amount that ambient occlusion affects lighting from lights. If `0`, ambient occlusion only
   * affects ambient light. If `1`, ambient occlusion affects lights just as much as it affects ambient
   * light. This can be used to impact the strength of the ambient occlusion effect, but typically
   * looks unrealistic.
   */
  public final inline var aoLightAffect: Float
    @JvmName("aoLightAffectProperty")
    get() = getAoLightAffect()
    @JvmName("aoLightAffectProperty")
    set(`value`) {
      setAoLightAffect(value)
    }

  /**
   * Texture that defines the amount of ambient occlusion for a given point on the object.
   */
  public final inline var aoTexture: Texture2D?
    @JvmName("aoTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.AMBIENT_OCCLUSION)
    @JvmName("aoTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.AMBIENT_OCCLUSION, value)
    }

  /**
   * If `true`, use `UV2` coordinates to look up from the [aoTexture].
   */
  public final inline var aoOnUv2: Boolean
    @JvmName("aoOnUv2Property")
    get() = getFlag(BaseMaterial3D.Flags.AO_ON_UV2)
    @JvmName("aoOnUv2Property")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.AO_ON_UV2, value)
    }

  /**
   * Specifies the channel of the [aoTexture] in which the ambient occlusion information is stored.
   * This is useful when you store the information for multiple effects in a single texture. For
   * example if you stored metallic in the red channel, roughness in the blue, and ambient occlusion in
   * the green you could reduce the number of textures you use.
   */
  public final inline var aoTextureChannel: TextureChannel
    @JvmName("aoTextureChannelProperty")
    get() = getAoTextureChannel()
    @JvmName("aoTextureChannelProperty")
    set(`value`) {
      setAoTextureChannel(value)
    }

  /**
   * If `true`, height mapping is enabled (also called "parallax mapping" or "depth mapping"). See
   * also [normalEnabled]. Height mapping is a demanding feature on the GPU, so it should only be used
   * on materials where it makes a significant visual difference.
   *
   * **Note:** Height mapping is not supported if triplanar mapping is used on the same material.
   * The value of [heightmapEnabled] will be ignored if [uv1Triplanar] is enabled.
   */
  public final inline var heightmapEnabled: Boolean
    @JvmName("heightmapEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.HEIGHT_MAPPING)
    @JvmName("heightmapEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.HEIGHT_MAPPING, value)
    }

  /**
   * The heightmap scale to use for the parallax effect (see [heightmapEnabled]). The default value
   * is tuned so that the highest point (value = 255) appears to be 5 cm higher than the lowest point
   * (value = 0). Higher values result in a deeper appearance, but may result in artifacts appearing
   * when looking at the material from oblique angles, especially when the camera moves. Negative
   * values can be used to invert the parallax effect, but this is different from inverting the texture
   * using [heightmapFlipTexture] as the material will also appear to be "closer" to the camera. In
   * most cases, [heightmapScale] should be kept to a positive value.
   *
   * **Note:** If the height map effect looks strange regardless of this value, try adjusting
   * [heightmapFlipBinormal] and [heightmapFlipTangent]. See also [heightmapTexture] for
   * recommendations on authoring heightmap textures, as the way the heightmap texture is authored
   * affects how [heightmapScale] behaves.
   */
  public final inline var heightmapScale: Float
    @JvmName("heightmapScaleProperty")
    get() = getHeightmapScale()
    @JvmName("heightmapScaleProperty")
    set(`value`) {
      setHeightmapScale(value)
    }

  /**
   * If `true`, uses parallax occlusion mapping to represent depth in the material instead of simple
   * offset mapping (see [heightmapEnabled]). This results in a more convincing depth effect, but is
   * much more expensive on the GPU. Only enable this on materials where it makes a significant visual
   * difference.
   */
  public final inline var heightmapDeepParallax: Boolean
    @JvmName("heightmapDeepParallaxProperty")
    get() = isHeightmapDeepParallaxEnabled()
    @JvmName("heightmapDeepParallaxProperty")
    set(`value`) {
      setHeightmapDeepParallax(value)
    }

  /**
   * The number of layers to use for parallax occlusion mapping when the camera is far away from the
   * material. Higher values result in a more convincing depth effect, especially in materials that
   * have steep height changes. Higher values have a significant cost on the GPU, so it should only be
   * increased on materials where it makes a significant visual difference.
   *
   * **Note:** Only effective if [heightmapDeepParallax] is `true`.
   */
  public final inline var heightmapMinLayers: Int
    @JvmName("heightmapMinLayersProperty")
    get() = getHeightmapDeepParallaxMinLayers()
    @JvmName("heightmapMinLayersProperty")
    set(`value`) {
      setHeightmapDeepParallaxMinLayers(value)
    }

  /**
   * The number of layers to use for parallax occlusion mapping when the camera is up close to the
   * material. Higher values result in a more convincing depth effect, especially in materials that
   * have steep height changes. Higher values have a significant cost on the GPU, so it should only be
   * increased on materials where it makes a significant visual difference.
   *
   * **Note:** Only effective if [heightmapDeepParallax] is `true`.
   */
  public final inline var heightmapMaxLayers: Int
    @JvmName("heightmapMaxLayersProperty")
    get() = getHeightmapDeepParallaxMaxLayers()
    @JvmName("heightmapMaxLayersProperty")
    set(`value`) {
      setHeightmapDeepParallaxMaxLayers(value)
    }

  /**
   * If `true`, flips the mesh's tangent vectors when interpreting the height map. If the heightmap
   * effect looks strange when the camera moves (even with a reasonable [heightmapScale]), try setting
   * this to `true`.
   */
  public final inline var heightmapFlipTangent: Boolean
    @JvmName("heightmapFlipTangentProperty")
    get() = getHeightmapDeepParallaxFlipTangent()
    @JvmName("heightmapFlipTangentProperty")
    set(`value`) {
      setHeightmapDeepParallaxFlipTangent(value)
    }

  /**
   * If `true`, flips the mesh's binormal vectors when interpreting the height map. If the heightmap
   * effect looks strange when the camera moves (even with a reasonable [heightmapScale]), try setting
   * this to `true`.
   */
  public final inline var heightmapFlipBinormal: Boolean
    @JvmName("heightmapFlipBinormalProperty")
    get() = getHeightmapDeepParallaxFlipBinormal()
    @JvmName("heightmapFlipBinormalProperty")
    set(`value`) {
      setHeightmapDeepParallaxFlipBinormal(value)
    }

  /**
   * The texture to use as a height map. See also [heightmapEnabled].
   *
   * For best results, the texture should be normalized (with [heightmapScale] reduced to
   * compensate). In [url=https://gimp.org]GIMP[/url], this can be done using **Colors > Auto >
   * Equalize**. If the texture only uses a small part of its available range, the parallax effect may
   * look strange, especially when the camera moves.
   *
   * **Note:** To reduce memory usage and improve loading times, you may be able to use a
   * lower-resolution heightmap texture as most heightmaps are only comprised of low-frequency data.
   */
  public final inline var heightmapTexture: Texture2D?
    @JvmName("heightmapTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.HEIGHTMAP)
    @JvmName("heightmapTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.HEIGHTMAP, value)
    }

  /**
   * If `true`, interprets the height map texture as a depth map, with brighter values appearing to
   * be "lower" in altitude compared to darker values.
   *
   * This can be enabled for compatibility with some materials authored for Godot 3.x. This is not
   * necessary if the Invert import option was used to invert the depth map in Godot 3.x, in which case
   * [heightmapFlipTexture] should remain `false`.
   */
  public final inline var heightmapFlipTexture: Boolean
    @JvmName("heightmapFlipTextureProperty")
    get() = getFlag(BaseMaterial3D.Flags.INVERT_HEIGHTMAP)
    @JvmName("heightmapFlipTextureProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.INVERT_HEIGHTMAP, value)
    }

  /**
   * If `true`, subsurface scattering is enabled. Emulates light that penetrates an object's
   * surface, is scattered, and then emerges. Subsurface scattering quality is controlled by
   * [ProjectSettings.rendering/environment/subsurfaceScattering/subsurfaceScatteringQuality].
   *
   * **Note:** Subsurface scattering is not supported on viewports that have a transparent
   * background (where [Viewport.transparentBg] is `true`).
   */
  public final inline var subsurfScatterEnabled: Boolean
    @JvmName("subsurfScatterEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.SUBSURFACE_SCATTERING)
    @JvmName("subsurfScatterEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.SUBSURFACE_SCATTERING, value)
    }

  /**
   * The strength of the subsurface scattering effect. The depth of the effect is also controlled by
   * [ProjectSettings.rendering/environment/subsurfaceScattering/subsurfaceScatteringScale], which is
   * set globally.
   */
  public final inline var subsurfScatterStrength: Float
    @JvmName("subsurfScatterStrengthProperty")
    get() = getSubsurfaceScatteringStrength()
    @JvmName("subsurfScatterStrengthProperty")
    set(`value`) {
      setSubsurfaceScatteringStrength(value)
    }

  /**
   * If `true`, subsurface scattering will use a special mode optimized for the color and density of
   * human skin, such as boosting the intensity of the red channel in subsurface scattering.
   */
  public final inline var subsurfScatterSkinMode: Boolean
    @JvmName("subsurfScatterSkinModeProperty")
    get() = getFlag(BaseMaterial3D.Flags.SUBSURFACE_MODE_SKIN)
    @JvmName("subsurfScatterSkinModeProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.SUBSURFACE_MODE_SKIN, value)
    }

  /**
   * Texture used to control the subsurface scattering strength. Stored in the red texture channel.
   * Multiplied by [subsurfScatterStrength].
   */
  public final inline var subsurfScatterTexture: Texture2D?
    @JvmName("subsurfScatterTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.SUBSURFACE_SCATTERING)
    @JvmName("subsurfScatterTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.SUBSURFACE_SCATTERING, value)
    }

  /**
   * If `true`, enables subsurface scattering transmittance. Only effective if
   * [subsurfScatterEnabled] is `true`. See also [backlightEnabled].
   */
  public final inline var subsurfScatterTransmittanceEnabled: Boolean
    @JvmName("subsurfScatterTransmittanceEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.SUBSURFACE_TRANSMITTANCE)
    @JvmName("subsurfScatterTransmittanceEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.SUBSURFACE_TRANSMITTANCE, value)
    }

  /**
   * The color to multiply the subsurface scattering transmittance effect with. Ignored if
   * [subsurfScatterSkinMode] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var subsurfScatterTransmittanceColor: Color
    @JvmName("subsurfScatterTransmittanceColorProperty")
    get() = getTransmittanceColor()
    @JvmName("subsurfScatterTransmittanceColorProperty")
    set(`value`) {
      setTransmittanceColor(value)
    }

  /**
   * The texture to use for multiplying the intensity of the subsurface scattering transmittance
   * intensity. See also [subsurfScatterTexture]. Ignored if [subsurfScatterSkinMode] is `true`.
   */
  public final inline var subsurfScatterTransmittanceTexture: Texture2D?
    @JvmName("subsurfScatterTransmittanceTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.SUBSURFACE_TRANSMITTANCE)
    @JvmName("subsurfScatterTransmittanceTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.SUBSURFACE_TRANSMITTANCE, value)
    }

  /**
   * The depth of the subsurface scattering transmittance effect.
   */
  public final inline var subsurfScatterTransmittanceDepth: Float
    @JvmName("subsurfScatterTransmittanceDepthProperty")
    get() = getTransmittanceDepth()
    @JvmName("subsurfScatterTransmittanceDepthProperty")
    set(`value`) {
      setTransmittanceDepth(value)
    }

  /**
   * The intensity of the subsurface scattering transmittance effect.
   */
  public final inline var subsurfScatterTransmittanceBoost: Float
    @JvmName("subsurfScatterTransmittanceBoostProperty")
    get() = getTransmittanceBoost()
    @JvmName("subsurfScatterTransmittanceBoostProperty")
    set(`value`) {
      setTransmittanceBoost(value)
    }

  /**
   * If `true`, the backlight effect is enabled. See also [subsurfScatterTransmittanceEnabled].
   */
  public final inline var backlightEnabled: Boolean
    @JvmName("backlightEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.BACKLIGHT)
    @JvmName("backlightEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.BACKLIGHT, value)
    }

  /**
   * The color used by the backlight effect. Represents the light passing through an object.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var backlight: Color
    @JvmName("backlightProperty")
    get() = getBacklight()
    @JvmName("backlightProperty")
    set(`value`) {
      setBacklight(value)
    }

  /**
   * Texture used to control the backlight effect per-pixel. Added to [backlight].
   */
  public final inline var backlightTexture: Texture2D?
    @JvmName("backlightTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.BACKLIGHT)
    @JvmName("backlightTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.BACKLIGHT, value)
    }

  /**
   * If `true`, the refraction effect is enabled. Distorts transparency based on light from behind
   * the object.
   *
   * **Note:** Refraction is implemented using the screen texture. Only opaque materials will appear
   * in the refraction, since transparent materials do not appear in the screen texture.
   */
  public final inline var refractionEnabled: Boolean
    @JvmName("refractionEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.REFRACTION)
    @JvmName("refractionEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.REFRACTION, value)
    }

  /**
   * The strength of the refraction effect.
   */
  public final inline var refractionScale: Float
    @JvmName("refractionScaleProperty")
    get() = getRefraction()
    @JvmName("refractionScaleProperty")
    set(`value`) {
      setRefraction(value)
    }

  /**
   * Texture that controls the strength of the refraction per-pixel. Multiplied by
   * [refractionScale].
   */
  public final inline var refractionTexture: Texture2D?
    @JvmName("refractionTextureProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.REFRACTION)
    @JvmName("refractionTextureProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.REFRACTION, value)
    }

  /**
   * Specifies the channel of the [refractionTexture] in which the refraction information is stored.
   * This is useful when you store the information for multiple effects in a single texture. For
   * example if you stored refraction in the red channel, roughness in the blue, and ambient occlusion
   * in the green you could reduce the number of textures you use.
   */
  public final inline var refractionTextureChannel: TextureChannel
    @JvmName("refractionTextureChannelProperty")
    get() = getRefractionTextureChannel()
    @JvmName("refractionTextureChannelProperty")
    set(`value`) {
      setRefractionTextureChannel(value)
    }

  /**
   * If `true`, enables the detail overlay. Detail is a second texture that gets mixed over the
   * surface of the object based on [detailMask] and [detailAlbedo]'s alpha channel. This can be used
   * to add variation to objects, or to blend between two different albedo/normal textures.
   */
  public final inline var detailEnabled: Boolean
    @JvmName("detailEnabledProperty")
    get() = getFeature(BaseMaterial3D.Feature.DETAIL)
    @JvmName("detailEnabledProperty")
    set(`value`) {
      setFeature(BaseMaterial3D.Feature.DETAIL, value)
    }

  /**
   * Texture used to specify how the detail textures get blended with the base textures.
   * [detailMask] can be used together with [detailAlbedo]'s alpha channel (if any).
   */
  public final inline var detailMask: Texture2D?
    @JvmName("detailMaskProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.DETAIL_MASK)
    @JvmName("detailMaskProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.DETAIL_MASK, value)
    }

  /**
   * Specifies how the [detailAlbedo] should blend with the current `ALBEDO`.
   */
  public final inline var detailBlendMode: BlendMode
    @JvmName("detailBlendModeProperty")
    get() = getDetailBlendMode()
    @JvmName("detailBlendModeProperty")
    set(`value`) {
      setDetailBlendMode(value)
    }

  /**
   * Specifies whether to use `UV` or `UV2` for the detail layer.
   */
  public final inline var detailUvLayer: DetailUV
    @JvmName("detailUvLayerProperty")
    get() = getDetailUv()
    @JvmName("detailUvLayerProperty")
    set(`value`) {
      setDetailUv(value)
    }

  /**
   * Texture that specifies the color of the detail overlay. [detailAlbedo]'s alpha channel is used
   * as a mask, even when the material is opaque. To use a dedicated texture as a mask, see
   * [detailMask].
   *
   * **Note:** [detailAlbedo] is *not* modulated by [albedoColor].
   */
  public final inline var detailAlbedo: Texture2D?
    @JvmName("detailAlbedoProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.DETAIL_ALBEDO)
    @JvmName("detailAlbedoProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.DETAIL_ALBEDO, value)
    }

  /**
   * Texture that specifies the per-pixel normal of the detail overlay. The [detailNormal] texture
   * only uses the red and green channels; the blue and alpha channels are ignored. The normal read
   * from [detailNormal] is oriented around the surface normal provided by the [Mesh].
   *
   * **Note:** Godot expects the normal map to use X+, Y+, and Z+ coordinates. See
   * [url=http://wiki.polycount.com/wiki/Normal_Map_Technical_Details#Common_Swizzle_Coordinates]this
   * page[/url] for a comparison of normal map coordinates expected by popular engines.
   */
  public final inline var detailNormal: Texture2D?
    @JvmName("detailNormalProperty")
    get() = getTexture(BaseMaterial3D.TextureParam.DETAIL_NORMAL)
    @JvmName("detailNormalProperty")
    set(`value`) {
      setTexture(BaseMaterial3D.TextureParam.DETAIL_NORMAL, value)
    }

  /**
   * How much to scale the `UV` coordinates. This is multiplied by `UV` in the vertex function. The
   * Z component is used when [uv1Triplanar] is enabled, but it is not used anywhere else.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var uv1Scale: Vector3
    @JvmName("uv1ScaleProperty")
    get() = getUv1Scale()
    @JvmName("uv1ScaleProperty")
    set(`value`) {
      setUv1Scale(value)
    }

  /**
   * How much to offset the `UV` coordinates. This amount will be added to `UV` in the vertex
   * function. This can be used to offset a texture. The Z component is used when [uv1Triplanar] is
   * enabled, but it is not used anywhere else.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var uv1Offset: Vector3
    @JvmName("uv1OffsetProperty")
    get() = getUv1Offset()
    @JvmName("uv1OffsetProperty")
    set(`value`) {
      setUv1Offset(value)
    }

  /**
   * If `true`, instead of using `UV` textures will use a triplanar texture lookup to determine how
   * to apply textures. Triplanar uses the orientation of the object's surface to blend between texture
   * coordinates. It reads from the source texture 3 times, once for each axis and then blends between
   * the results based on how closely the pixel aligns with each axis. This is often used for natural
   * features to get a realistic blend of materials. Because triplanar texturing requires many more
   * texture reads per-pixel it is much slower than normal UV texturing. Additionally, because it is
   * blending the texture between the three axes, it is unsuitable when you are trying to achieve crisp
   * texturing.
   */
  public final inline var uv1Triplanar: Boolean
    @JvmName("uv1TriplanarProperty")
    get() = getFlag(BaseMaterial3D.Flags.UV1_USE_TRIPLANAR)
    @JvmName("uv1TriplanarProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.UV1_USE_TRIPLANAR, value)
    }

  /**
   * A lower number blends the texture more softly while a higher number blends the texture more
   * sharply.
   *
   * **Note:** [uv1TriplanarSharpness] is clamped between `0.0` and `150.0` (inclusive) as values
   * outside that range can look broken depending on the mesh.
   */
  public final inline var uv1TriplanarSharpness: Float
    @JvmName("uv1TriplanarSharpnessProperty")
    get() = getUv1TriplanarBlendSharpness()
    @JvmName("uv1TriplanarSharpnessProperty")
    set(`value`) {
      setUv1TriplanarBlendSharpness(value)
    }

  /**
   * If `true`, triplanar mapping for `UV` is calculated in world space rather than object local
   * space. See also [uv1Triplanar].
   */
  public final inline var uv1WorldTriplanar: Boolean
    @JvmName("uv1WorldTriplanarProperty")
    get() = getFlag(BaseMaterial3D.Flags.UV1_USE_WORLD_TRIPLANAR)
    @JvmName("uv1WorldTriplanarProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.UV1_USE_WORLD_TRIPLANAR, value)
    }

  /**
   * How much to scale the `UV2` coordinates. This is multiplied by `UV2` in the vertex function.
   * The Z component is used when [uv2Triplanar] is enabled, but it is not used anywhere else.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var uv2Scale: Vector3
    @JvmName("uv2ScaleProperty")
    get() = getUv2Scale()
    @JvmName("uv2ScaleProperty")
    set(`value`) {
      setUv2Scale(value)
    }

  /**
   * How much to offset the `UV2` coordinates. This amount will be added to `UV2` in the vertex
   * function. This can be used to offset a texture. The Z component is used when [uv2Triplanar] is
   * enabled, but it is not used anywhere else.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var uv2Offset: Vector3
    @JvmName("uv2OffsetProperty")
    get() = getUv2Offset()
    @JvmName("uv2OffsetProperty")
    set(`value`) {
      setUv2Offset(value)
    }

  /**
   * If `true`, instead of using `UV2` textures will use a triplanar texture lookup to determine how
   * to apply textures. Triplanar uses the orientation of the object's surface to blend between texture
   * coordinates. It reads from the source texture 3 times, once for each axis and then blends between
   * the results based on how closely the pixel aligns with each axis. This is often used for natural
   * features to get a realistic blend of materials. Because triplanar texturing requires many more
   * texture reads per-pixel it is much slower than normal UV texturing. Additionally, because it is
   * blending the texture between the three axes, it is unsuitable when you are trying to achieve crisp
   * texturing.
   */
  public final inline var uv2Triplanar: Boolean
    @JvmName("uv2TriplanarProperty")
    get() = getFlag(BaseMaterial3D.Flags.UV2_USE_TRIPLANAR)
    @JvmName("uv2TriplanarProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.UV2_USE_TRIPLANAR, value)
    }

  /**
   * A lower number blends the texture more softly while a higher number blends the texture more
   * sharply.
   *
   * **Note:** [uv2TriplanarSharpness] is clamped between `0.0` and `150.0` (inclusive) as values
   * outside that range can look broken depending on the mesh.
   */
  public final inline var uv2TriplanarSharpness: Float
    @JvmName("uv2TriplanarSharpnessProperty")
    get() = getUv2TriplanarBlendSharpness()
    @JvmName("uv2TriplanarSharpnessProperty")
    set(`value`) {
      setUv2TriplanarBlendSharpness(value)
    }

  /**
   * If `true`, triplanar mapping for `UV2` is calculated in world space rather than object local
   * space. See also [uv2Triplanar].
   */
  public final inline var uv2WorldTriplanar: Boolean
    @JvmName("uv2WorldTriplanarProperty")
    get() = getFlag(BaseMaterial3D.Flags.UV2_USE_WORLD_TRIPLANAR)
    @JvmName("uv2WorldTriplanarProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.UV2_USE_WORLD_TRIPLANAR, value)
    }

  /**
   * Filter flags for the texture.
   *
   * **Note:** [heightmapTexture] is always sampled with linear filtering, even if nearest-neighbor
   * filtering is selected here. This is to ensure the heightmap effect looks as intended. If you need
   * sharper height transitions between pixels, resize the heightmap texture in an image editor with
   * nearest-neighbor filtering.
   */
  public final inline var textureFilter: TextureFilter
    @JvmName("textureFilterProperty")
    get() = getTextureFilter()
    @JvmName("textureFilterProperty")
    set(`value`) {
      setTextureFilter(value)
    }

  /**
   * If `true`, the texture repeats when exceeding the texture's size. See
   * [FLAG_USE_TEXTURE_REPEAT].
   */
  public final inline var textureRepeat: Boolean
    @JvmName("textureRepeatProperty")
    get() = getFlag(BaseMaterial3D.Flags.USE_TEXTURE_REPEAT)
    @JvmName("textureRepeatProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.USE_TEXTURE_REPEAT, value)
    }

  /**
   * If `true`, the object receives no shadow that would otherwise be cast onto it.
   */
  public final inline var disableReceiveShadows: Boolean
    @JvmName("disableReceiveShadowsProperty")
    get() = getFlag(BaseMaterial3D.Flags.DONT_RECEIVE_SHADOWS)
    @JvmName("disableReceiveShadowsProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.DONT_RECEIVE_SHADOWS, value)
    }

  /**
   * If `true`, enables the "shadow to opacity" render mode where lighting modifies the alpha so
   * shadowed areas are opaque and non-shadowed areas are transparent. Useful for overlaying shadows
   * onto a camera feed in AR.
   */
  public final inline var shadowToOpacity: Boolean
    @JvmName("shadowToOpacityProperty")
    get() = getFlag(BaseMaterial3D.Flags.USE_SHADOW_TO_OPACITY)
    @JvmName("shadowToOpacityProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.USE_SHADOW_TO_OPACITY, value)
    }

  /**
   * Controls how the object faces the camera.
   *
   * **Note:** Billboard mode is not suitable for VR because the left-right vector of the camera is
   * not horizontal when the screen is attached to your head instead of on the table. See
   * [url=https://github.com/godotengine/godot/issues/41567]GitHub issue #41567[/url] for details.
   */
  public final inline var billboardMode: BillboardMode
    @JvmName("billboardModeProperty")
    get() = getBillboardMode()
    @JvmName("billboardModeProperty")
    set(`value`) {
      setBillboardMode(value)
    }

  /**
   * If `true`, the shader will keep the scale set for the mesh. Otherwise, the scale is lost when
   * billboarding. Only applies when [billboardMode] is not [BILLBOARD_DISABLED].
   */
  public final inline var billboardKeepScale: Boolean
    @JvmName("billboardKeepScaleProperty")
    get() = getFlag(BaseMaterial3D.Flags.BILLBOARD_KEEP_SCALE)
    @JvmName("billboardKeepScaleProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.BILLBOARD_KEEP_SCALE, value)
    }

  /**
   * The number of horizontal frames in the particle sprite sheet. Only enabled when using
   * [BILLBOARD_PARTICLES]. See [billboardMode].
   */
  public final inline var particlesAnimHFrames: Int
    @JvmName("particlesAnimHFramesProperty")
    get() = getParticlesAnimHFrames()
    @JvmName("particlesAnimHFramesProperty")
    set(`value`) {
      setParticlesAnimHFrames(value)
    }

  /**
   * The number of vertical frames in the particle sprite sheet. Only enabled when using
   * [BILLBOARD_PARTICLES]. See [billboardMode].
   */
  public final inline var particlesAnimVFrames: Int
    @JvmName("particlesAnimVFramesProperty")
    get() = getParticlesAnimVFrames()
    @JvmName("particlesAnimVFramesProperty")
    set(`value`) {
      setParticlesAnimVFrames(value)
    }

  /**
   * If `true`, particle animations are looped. Only enabled when using [BILLBOARD_PARTICLES]. See
   * [billboardMode].
   */
  public final inline var particlesAnimLoop: Boolean
    @JvmName("particlesAnimLoopProperty")
    get() = getParticlesAnimLoop()
    @JvmName("particlesAnimLoopProperty")
    set(`value`) {
      setParticlesAnimLoop(value)
    }

  /**
   * If `true`, enables the vertex grow setting. This can be used to create mesh-based outlines
   * using a second material pass and its [cullMode] set to [CULL_FRONT]. See also [growAmount].
   *
   * **Note:** Vertex growth cannot create new vertices, which means that visible gaps may occur in
   * sharp corners. This can be alleviated by designing the mesh to use smooth normals exclusively
   * using [url=http://wiki.polycount.com/wiki/Face_weighted_normals]face weighted normals[/url] in the
   * 3D authoring software. In this case, grow will be able to join every outline together, just like
   * in the original mesh.
   */
  public final inline var grow: Boolean
    @JvmName("growProperty")
    get() = isGrowEnabled()
    @JvmName("growProperty")
    set(`value`) {
      setGrowEnabled(value)
    }

  /**
   * Grows object vertices in the direction of their normals. Only effective if [grow] is `true`.
   */
  public final inline var growAmount: Float
    @JvmName("growAmountProperty")
    get() = getGrow()
    @JvmName("growAmountProperty")
    set(`value`) {
      setGrow(value)
    }

  /**
   * If `true`, the object is rendered at the same size regardless of distance. The object's size on
   * screen is the same as if the camera was `1.0` units away from the object's origin, regardless of
   * the actual distance from the camera. The [Camera3D]'s field of view (or [Camera3D.size] when in
   * orthogonal/frustum mode) still affects the size the object is drawn at.
   */
  public final inline var fixedSize: Boolean
    @JvmName("fixedSizeProperty")
    get() = getFlag(BaseMaterial3D.Flags.FIXED_SIZE)
    @JvmName("fixedSizeProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.FIXED_SIZE, value)
    }

  /**
   * If `true`, render point size can be changed.
   *
   * **Note:** This is only effective for objects whose geometry is point-based rather than
   * triangle-based. See also [pointSize].
   */
  public final inline var usePointSize: Boolean
    @JvmName("usePointSizeProperty")
    get() = getFlag(BaseMaterial3D.Flags.USE_POINT_SIZE)
    @JvmName("usePointSizeProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.USE_POINT_SIZE, value)
    }

  /**
   * The point size in pixels. See [usePointSize].
   */
  public final inline var pointSize: Float
    @JvmName("pointSizeProperty")
    get() = getPointSize()
    @JvmName("pointSizeProperty")
    set(`value`) {
      setPointSize(value)
    }

  /**
   * If `true`, enables parts of the shader required for [GPUParticles3D] trails to function. This
   * also requires using a mesh with appropriate skinning, such as [RibbonTrailMesh] or
   * [TubeTrailMesh]. Enabling this feature outside of materials used in [GPUParticles3D] meshes will
   * break material rendering.
   */
  public final inline var useParticleTrails: Boolean
    @JvmName("useParticleTrailsProperty")
    get() = getFlag(BaseMaterial3D.Flags.PARTICLE_TRAILS_MODE)
    @JvmName("useParticleTrailsProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.PARTICLE_TRAILS_MODE, value)
    }

  /**
   * If `true` use [zClipScale] to scale the object being rendered towards the camera to avoid
   * clipping into things like walls.
   */
  public final inline var useZClipScale: Boolean
    @JvmName("useZClipScaleProperty")
    get() = getFlag(BaseMaterial3D.Flags.USE_Z_CLIP_SCALE)
    @JvmName("useZClipScaleProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.USE_Z_CLIP_SCALE, value)
    }

  /**
   * Scales the object being rendered towards the camera to avoid clipping into things like walls.
   * This is intended to be used for objects that are fixed with respect to the camera like player
   * arms, tools, etc. Lighting and shadows will continue to work correctly when this setting is
   * adjusted, but screen-space effects like SSAO and SSR may break with lower scales. Therefore, try
   * to keep this setting as close to `1.0` as possible.
   */
  public final inline var zClipScale: Float
    @JvmName("zClipScaleProperty")
    get() = getZClipScale()
    @JvmName("zClipScaleProperty")
    set(`value`) {
      setZClipScale(value)
    }

  /**
   * If `true` use [fovOverride] to override the [Camera3D]'s field of view angle.
   */
  public final inline var useFovOverride: Boolean
    @JvmName("useFovOverrideProperty")
    get() = getFlag(BaseMaterial3D.Flags.USE_FOV_OVERRIDE)
    @JvmName("useFovOverrideProperty")
    set(`value`) {
      setFlag(BaseMaterial3D.Flags.USE_FOV_OVERRIDE, value)
    }

  /**
   * Overrides the [Camera3D]'s field of view angle (in degrees).
   *
   * **Note:** This behaves as if the field of view is set on a [Camera3D] with
   * [Camera3D.keepAspect] set to [Camera3D.KEEP_HEIGHT]. Additionally, it may not look correct on a
   * non-perspective camera where the field of view setting is ignored.
   */
  public final inline var fovOverride: Float
    @JvmName("fovOverrideProperty")
    get() = getFovOverride()
    @JvmName("fovOverrideProperty")
    set(`value`) {
      setFovOverride(value)
    }

  /**
   * If `true`, the proximity fade effect is enabled. The proximity fade effect fades out each pixel
   * based on its distance to another object.
   */
  public final inline var proximityFadeEnabled: Boolean
    @JvmName("proximityFadeEnabledProperty")
    get() = isProximityFadeEnabled()
    @JvmName("proximityFadeEnabledProperty")
    set(`value`) {
      setProximityFadeEnabled(value)
    }

  /**
   * Distance over which the fade effect takes place. The larger the distance the longer it takes
   * for an object to fade.
   */
  public final inline var proximityFadeDistance: Float
    @JvmName("proximityFadeDistanceProperty")
    get() = getProximityFadeDistance()
    @JvmName("proximityFadeDistanceProperty")
    set(`value`) {
      setProximityFadeDistance(value)
    }

  /**
   * The width of the range around the shape between the minimum and maximum representable signed
   * distance.
   */
  public final inline var msdfPixelRange: Float
    @JvmName("msdfPixelRangeProperty")
    get() = getMsdfPixelRange()
    @JvmName("msdfPixelRangeProperty")
    set(`value`) {
      setMsdfPixelRange(value)
    }

  /**
   * The width of the shape outline.
   */
  public final inline var msdfOutlineSize: Float
    @JvmName("msdfOutlineSizeProperty")
    get() = getMsdfOutlineSize()
    @JvmName("msdfOutlineSizeProperty")
    set(`value`) {
      setMsdfOutlineSize(value)
    }

  /**
   * Specifies which type of fade to use. Can be any of the [DistanceFadeMode]s.
   */
  public final inline var distanceFadeMode: DistanceFadeMode
    @JvmName("distanceFadeModeProperty")
    get() = getDistanceFade()
    @JvmName("distanceFadeModeProperty")
    set(`value`) {
      setDistanceFade(value)
    }

  /**
   * Distance at which the object starts to become visible. If the object is less than this distance
   * away, it will be invisible.
   *
   * **Note:** If [distanceFadeMinDistance] is greater than [distanceFadeMaxDistance], the behavior
   * will be reversed. The object will start to fade away at [distanceFadeMaxDistance] and will fully
   * disappear once it reaches [distanceFadeMinDistance].
   */
  public final inline var distanceFadeMinDistance: Float
    @JvmName("distanceFadeMinDistanceProperty")
    get() = getDistanceFadeMinDistance()
    @JvmName("distanceFadeMinDistanceProperty")
    set(`value`) {
      setDistanceFadeMinDistance(value)
    }

  /**
   * Distance at which the object appears fully opaque.
   *
   * **Note:** If [distanceFadeMaxDistance] is less than [distanceFadeMinDistance], the behavior
   * will be reversed. The object will start to fade away at [distanceFadeMaxDistance] and will fully
   * disappear once it reaches [distanceFadeMinDistance].
   */
  public final inline var distanceFadeMaxDistance: Float
    @JvmName("distanceFadeMaxDistanceProperty")
    get() = getDistanceFadeMaxDistance()
    @JvmName("distanceFadeMaxDistanceProperty")
    set(`value`) {
      setDistanceFadeMaxDistance(value)
    }

  /**
   * The stencil effect mode.
   */
  public final inline var stencilMode: StencilMode
    @JvmName("stencilModeProperty")
    get() = getStencilMode()
    @JvmName("stencilModeProperty")
    set(`value`) {
      setStencilMode(value)
    }

  /**
   * The flags dictating how the stencil operation behaves.
   */
  public final inline var stencilFlags: Int
    @JvmName("stencilFlagsProperty")
    get() = getStencilFlags()
    @JvmName("stencilFlagsProperty")
    set(`value`) {
      setStencilFlags(value)
    }

  /**
   * The comparison operator to use for stencil masking operations.
   */
  public final inline var stencilCompare: StencilCompare
    @JvmName("stencilCompareProperty")
    get() = getStencilCompare()
    @JvmName("stencilCompareProperty")
    set(`value`) {
      setStencilCompare(value)
    }

  /**
   * The stencil reference value (0-255). Typically a power of 2.
   */
  public final inline var stencilReference: Int
    @JvmName("stencilReferenceProperty")
    get() = getStencilReference()
    @JvmName("stencilReferenceProperty")
    set(`value`) {
      setStencilReference(value)
    }

  /**
   * The primary color of the stencil effect.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var stencilColor: Color
    @JvmName("stencilColorProperty")
    get() = getStencilEffectColor()
    @JvmName("stencilColorProperty")
    set(`value`) {
      setStencilEffectColor(value)
    }

  /**
   * The outline thickness for [STENCIL_MODE_OUTLINE].
   */
  public final inline var stencilOutlineThickness: Float
    @JvmName("stencilOutlineThicknessProperty")
    get() = getStencilEffectOutlineThickness()
    @JvmName("stencilOutlineThicknessProperty")
    set(`value`) {
      setStencilEffectOutlineThickness(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(108, scriptPtr)
  }

  /**
   * This is a helper function for [albedoColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.albedoColor
   * //Your changes
   * basematerial3d.albedoColor = myCoreType
   * ``````
   *
   * The material's base color.
   *
   * **Note:** If [detailEnabled] is `true` and a [detailAlbedo] texture is specified, [albedoColor]
   * will *not* modulate the detail texture. This can be used to color partial areas of a material by
   * not specifying an albedo texture and using a transparent [detailAlbedo] texture instead.
   */
  @CoreTypeHelper
  public final fun albedoColorMutate(block: Color.() -> Unit): Color = albedoColor.apply {
     block(this)
     albedoColor = this
  }

  /**
   * This is a helper function for [emission] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.emission
   * //Your changes
   * basematerial3d.emission = myCoreType
   * ``````
   *
   * The emitted light's color. See [emissionEnabled].
   */
  @CoreTypeHelper
  public final fun emissionMutate(block: Color.() -> Unit): Color = emission.apply {
     block(this)
     emission = this
  }

  /**
   * This is a helper function for [subsurfScatterTransmittanceColor] to make dealing with local
   * copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.subsurfScatterTransmittanceColor
   * //Your changes
   * basematerial3d.subsurfScatterTransmittanceColor = myCoreType
   * ``````
   *
   * The color to multiply the subsurface scattering transmittance effect with. Ignored if
   * [subsurfScatterSkinMode] is `true`.
   */
  @CoreTypeHelper
  public final fun subsurfScatterTransmittanceColorMutate(block: Color.() -> Unit): Color =
      subsurfScatterTransmittanceColor.apply {
     block(this)
     subsurfScatterTransmittanceColor = this
  }

  /**
   * This is a helper function for [backlight] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.backlight
   * //Your changes
   * basematerial3d.backlight = myCoreType
   * ``````
   *
   * The color used by the backlight effect. Represents the light passing through an object.
   */
  @CoreTypeHelper
  public final fun backlightMutate(block: Color.() -> Unit): Color = backlight.apply {
     block(this)
     backlight = this
  }

  /**
   * This is a helper function for [uv1Scale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.uv1Scale
   * //Your changes
   * basematerial3d.uv1Scale = myCoreType
   * ``````
   *
   * How much to scale the `UV` coordinates. This is multiplied by `UV` in the vertex function. The
   * Z component is used when [uv1Triplanar] is enabled, but it is not used anywhere else.
   */
  @CoreTypeHelper
  public final fun uv1ScaleMutate(block: Vector3.() -> Unit): Vector3 = uv1Scale.apply {
     block(this)
     uv1Scale = this
  }

  /**
   * This is a helper function for [uv1Offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.uv1Offset
   * //Your changes
   * basematerial3d.uv1Offset = myCoreType
   * ``````
   *
   * How much to offset the `UV` coordinates. This amount will be added to `UV` in the vertex
   * function. This can be used to offset a texture. The Z component is used when [uv1Triplanar] is
   * enabled, but it is not used anywhere else.
   */
  @CoreTypeHelper
  public final fun uv1OffsetMutate(block: Vector3.() -> Unit): Vector3 = uv1Offset.apply {
     block(this)
     uv1Offset = this
  }

  /**
   * This is a helper function for [uv2Scale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.uv2Scale
   * //Your changes
   * basematerial3d.uv2Scale = myCoreType
   * ``````
   *
   * How much to scale the `UV2` coordinates. This is multiplied by `UV2` in the vertex function.
   * The Z component is used when [uv2Triplanar] is enabled, but it is not used anywhere else.
   */
  @CoreTypeHelper
  public final fun uv2ScaleMutate(block: Vector3.() -> Unit): Vector3 = uv2Scale.apply {
     block(this)
     uv2Scale = this
  }

  /**
   * This is a helper function for [uv2Offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.uv2Offset
   * //Your changes
   * basematerial3d.uv2Offset = myCoreType
   * ``````
   *
   * How much to offset the `UV2` coordinates. This amount will be added to `UV2` in the vertex
   * function. This can be used to offset a texture. The Z component is used when [uv2Triplanar] is
   * enabled, but it is not used anywhere else.
   */
  @CoreTypeHelper
  public final fun uv2OffsetMutate(block: Vector3.() -> Unit): Vector3 = uv2Offset.apply {
     block(this)
     uv2Offset = this
  }

  /**
   * This is a helper function for [stencilColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = basematerial3d.stencilColor
   * //Your changes
   * basematerial3d.stencilColor = myCoreType
   * ``````
   *
   * The primary color of the stencil effect.
   */
  @CoreTypeHelper
  public final fun stencilColorMutate(block: Color.() -> Unit): Color = stencilColor.apply {
     block(this)
     stencilColor = this
  }

  public final fun setAlbedo(albedo: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to albedo)
    TransferContext.callMethod(MethodBindings.setAlbedoPtr)
  }

  public final fun getAlbedo(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlbedoPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setTransparency(transparency: Transparency): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to transparency.value)
    TransferContext.callMethod(MethodBindings.setTransparencyPtr)
  }

  public final fun getTransparency(): Transparency {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransparencyPtr)
    return Transparency.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAlphaAntialiasing(alphaAa: AlphaAntiAliasing): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alphaAa.value)
    TransferContext.callMethod(MethodBindings.setAlphaAntialiasingPtr)
  }

  public final fun getAlphaAntialiasing(): AlphaAntiAliasing {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaAntialiasingPtr)
    return AlphaAntiAliasing.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAlphaAntialiasingEdge(edge: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to edge.toDouble())
    TransferContext.callMethod(MethodBindings.setAlphaAntialiasingEdgePtr)
  }

  public final fun getAlphaAntialiasingEdge(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaAntialiasingEdgePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setShadingMode(shadingMode: ShadingMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shadingMode.value)
    TransferContext.callMethod(MethodBindings.setShadingModePtr)
  }

  public final fun getShadingMode(): ShadingMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadingModePtr)
    return ShadingMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSpecular(specular: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to specular.toDouble())
    TransferContext.callMethod(MethodBindings.setSpecularPtr)
  }

  public final fun getSpecular(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpecularPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMetallic(metallic: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to metallic.toDouble())
    TransferContext.callMethod(MethodBindings.setMetallicPtr)
  }

  public final fun getMetallic(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMetallicPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRoughness(roughness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to roughness.toDouble())
    TransferContext.callMethod(MethodBindings.setRoughnessPtr)
  }

  public final fun getRoughness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRoughnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmission(emission: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to emission)
    TransferContext.callMethod(MethodBindings.setEmissionPtr)
  }

  public final fun getEmission(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setEmissionEnergyMultiplier(emissionEnergyMultiplier: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to emissionEnergyMultiplier.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionEnergyMultiplierPtr)
  }

  public final fun getEmissionEnergyMultiplier(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionEnergyMultiplierPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionIntensity(emissionEnergyMultiplier: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to emissionEnergyMultiplier.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionIntensityPtr)
  }

  public final fun getEmissionIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setNormalScale(normalScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to normalScale.toDouble())
    TransferContext.callMethod(MethodBindings.setNormalScalePtr)
  }

  public final fun getNormalScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNormalScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRim(rim: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to rim.toDouble())
    TransferContext.callMethod(MethodBindings.setRimPtr)
  }

  public final fun getRim(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRimPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRimTint(rimTint: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to rimTint.toDouble())
    TransferContext.callMethod(MethodBindings.setRimTintPtr)
  }

  public final fun getRimTint(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRimTintPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setClearcoat(clearcoat: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to clearcoat.toDouble())
    TransferContext.callMethod(MethodBindings.setClearcoatPtr)
  }

  public final fun getClearcoat(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClearcoatPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setClearcoatRoughness(clearcoatRoughness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to clearcoatRoughness.toDouble())
    TransferContext.callMethod(MethodBindings.setClearcoatRoughnessPtr)
  }

  public final fun getClearcoatRoughness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClearcoatRoughnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAnisotropy(anisotropy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to anisotropy.toDouble())
    TransferContext.callMethod(MethodBindings.setAnisotropyPtr)
  }

  public final fun getAnisotropy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnisotropyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setHeightmapScale(heightmapScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to heightmapScale.toDouble())
    TransferContext.callMethod(MethodBindings.setHeightmapScalePtr)
  }

  public final fun getHeightmapScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightmapScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSubsurfaceScatteringStrength(strength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.setSubsurfaceScatteringStrengthPtr)
  }

  public final fun getSubsurfaceScatteringStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubsurfaceScatteringStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTransmittanceColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setTransmittanceColorPtr)
  }

  public final fun getTransmittanceColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransmittanceColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setTransmittanceDepth(depth: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to depth.toDouble())
    TransferContext.callMethod(MethodBindings.setTransmittanceDepthPtr)
  }

  public final fun getTransmittanceDepth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransmittanceDepthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTransmittanceBoost(boost: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to boost.toDouble())
    TransferContext.callMethod(MethodBindings.setTransmittanceBoostPtr)
  }

  public final fun getTransmittanceBoost(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransmittanceBoostPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBacklight(backlight: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to backlight)
    TransferContext.callMethod(MethodBindings.setBacklightPtr)
  }

  public final fun getBacklight(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBacklightPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setRefraction(refraction: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to refraction.toDouble())
    TransferContext.callMethod(MethodBindings.setRefractionPtr)
  }

  public final fun getRefraction(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRefractionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPointSize(pointSize: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pointSize.toDouble())
    TransferContext.callMethod(MethodBindings.setPointSizePtr)
  }

  public final fun getPointSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDetailUv(detailUv: DetailUV): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to detailUv.value)
    TransferContext.callMethod(MethodBindings.setDetailUvPtr)
  }

  public final fun getDetailUv(): DetailUV {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDetailUvPtr)
    return DetailUV.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setBlendMode(blendMode: BlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendMode.value)
    TransferContext.callMethod(MethodBindings.setBlendModePtr)
  }

  public final fun getBlendMode(): BlendMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendModePtr)
    return BlendMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDepthDrawMode(depthDrawMode: DepthDrawMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to depthDrawMode.value)
    TransferContext.callMethod(MethodBindings.setDepthDrawModePtr)
  }

  public final fun getDepthDrawMode(): DepthDrawMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthDrawModePtr)
    return DepthDrawMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDepthTest(depthTest: DepthTest): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to depthTest.value)
    TransferContext.callMethod(MethodBindings.setDepthTestPtr)
  }

  public final fun getDepthTest(): DepthTest {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthTestPtr)
    return DepthTest.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCullMode(cullMode: CullMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cullMode.value)
    TransferContext.callMethod(MethodBindings.setCullModePtr)
  }

  public final fun getCullMode(): CullMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCullModePtr)
    return CullMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDiffuseMode(diffuseMode: DiffuseMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to diffuseMode.value)
    TransferContext.callMethod(MethodBindings.setDiffuseModePtr)
  }

  public final fun getDiffuseMode(): DiffuseMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiffuseModePtr)
    return DiffuseMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSpecularMode(specularMode: SpecularMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to specularMode.value)
    TransferContext.callMethod(MethodBindings.setSpecularModePtr)
  }

  public final fun getSpecularMode(): SpecularMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpecularModePtr)
    return SpecularMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If [enable] is `true`, enables the specified [flag]. Flags are optional behavior that can be
   * turned on and off. Only one flag can be enabled at a time with this function, the flag enumerators
   * cannot be bit-masked together to enable or disable multiple flags at once. Flags can also be
   * enabled by setting their corresponding property to `true`.
   */
  public final fun setFlag(flag: Flags, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFlagPtr)
  }

  /**
   * Returns `true` if the specified [flag] is enabled.
   */
  public final fun getFlag(flag: Flags): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.getFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTextureFilter(mode: TextureFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTextureFilterPtr)
  }

  public final fun getTextureFilter(): TextureFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureFilterPtr)
    return TextureFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If [enable] is `true`, enables the specified [feature]. Many features that are available in
   * [BaseMaterial3D] need to be enabled before use. This way, the cost for using the feature is only
   * incurred when specified. Features can also be enabled by setting their corresponding property to
   * `true`.
   */
  public final fun setFeature(feature: Feature, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feature.value, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFeaturePtr)
  }

  /**
   * Returns `true` if the specified [feature] is enabled.
   */
  public final fun getFeature(feature: Feature): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feature.value)
    TransferContext.callMethod(MethodBindings.getFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the texture for the slot specified by [param].
   */
  public final fun setTexture(`param`: TextureParam, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  /**
   * Returns the [Texture2D] associated with the specified texture [param].
   */
  public final fun getTexture(`param`: TextureParam): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setDetailBlendMode(detailBlendMode: BlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to detailBlendMode.value)
    TransferContext.callMethod(MethodBindings.setDetailBlendModePtr)
  }

  public final fun getDetailBlendMode(): BlendMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDetailBlendModePtr)
    return BlendMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setUv1Scale(scale: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to scale)
    TransferContext.callMethod(MethodBindings.setUv1ScalePtr)
  }

  public final fun getUv1Scale(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv1ScalePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setUv1Offset(offset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to offset)
    TransferContext.callMethod(MethodBindings.setUv1OffsetPtr)
  }

  public final fun getUv1Offset(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv1OffsetPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setUv1TriplanarBlendSharpness(sharpness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to sharpness.toDouble())
    TransferContext.callMethod(MethodBindings.setUv1TriplanarBlendSharpnessPtr)
  }

  public final fun getUv1TriplanarBlendSharpness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv1TriplanarBlendSharpnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setUv2Scale(scale: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to scale)
    TransferContext.callMethod(MethodBindings.setUv2ScalePtr)
  }

  public final fun getUv2Scale(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv2ScalePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setUv2Offset(offset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to offset)
    TransferContext.callMethod(MethodBindings.setUv2OffsetPtr)
  }

  public final fun getUv2Offset(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv2OffsetPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setUv2TriplanarBlendSharpness(sharpness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to sharpness.toDouble())
    TransferContext.callMethod(MethodBindings.setUv2TriplanarBlendSharpnessPtr)
  }

  public final fun getUv2TriplanarBlendSharpness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv2TriplanarBlendSharpnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBillboardMode(mode: BillboardMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBillboardModePtr)
  }

  public final fun getBillboardMode(): BillboardMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBillboardModePtr)
    return BillboardMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setParticlesAnimHFrames(frames: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frames.toLong())
    TransferContext.callMethod(MethodBindings.setParticlesAnimHFramesPtr)
  }

  public final fun getParticlesAnimHFrames(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParticlesAnimHFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setParticlesAnimVFrames(frames: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frames.toLong())
    TransferContext.callMethod(MethodBindings.setParticlesAnimVFramesPtr)
  }

  public final fun getParticlesAnimVFrames(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParticlesAnimVFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setParticlesAnimLoop(loop: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to loop)
    TransferContext.callMethod(MethodBindings.setParticlesAnimLoopPtr)
  }

  public final fun getParticlesAnimLoop(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParticlesAnimLoopPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHeightmapDeepParallax(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHeightmapDeepParallaxPtr)
  }

  public final fun isHeightmapDeepParallaxEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHeightmapDeepParallaxEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHeightmapDeepParallaxMinLayers(layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.setHeightmapDeepParallaxMinLayersPtr)
  }

  public final fun getHeightmapDeepParallaxMinLayers(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightmapDeepParallaxMinLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHeightmapDeepParallaxMaxLayers(layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.setHeightmapDeepParallaxMaxLayersPtr)
  }

  public final fun getHeightmapDeepParallaxMaxLayers(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightmapDeepParallaxMaxLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHeightmapDeepParallaxFlipTangent(flip: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flip)
    TransferContext.callMethod(MethodBindings.setHeightmapDeepParallaxFlipTangentPtr)
  }

  public final fun getHeightmapDeepParallaxFlipTangent(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightmapDeepParallaxFlipTangentPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHeightmapDeepParallaxFlipBinormal(flip: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flip)
    TransferContext.callMethod(MethodBindings.setHeightmapDeepParallaxFlipBinormalPtr)
  }

  public final fun getHeightmapDeepParallaxFlipBinormal(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightmapDeepParallaxFlipBinormalPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGrow(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setGrowPtr)
  }

  public final fun getGrow(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGrowPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionOperator(`operator`: EmissionOperator): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to `operator`.value)
    TransferContext.callMethod(MethodBindings.setEmissionOperatorPtr)
  }

  public final fun getEmissionOperator(): EmissionOperator {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionOperatorPtr)
    return EmissionOperator.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAoLightAffect(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setAoLightAffectPtr)
  }

  public final fun getAoLightAffect(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAoLightAffectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAlphaScissorThreshold(threshold: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to threshold.toDouble())
    TransferContext.callMethod(MethodBindings.setAlphaScissorThresholdPtr)
  }

  public final fun getAlphaScissorThreshold(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaScissorThresholdPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAlphaHashScale(threshold: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to threshold.toDouble())
    TransferContext.callMethod(MethodBindings.setAlphaHashScalePtr)
  }

  public final fun getAlphaHashScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaHashScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGrowEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setGrowEnabledPtr)
  }

  public final fun isGrowEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isGrowEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMetallicTextureChannel(channel: TextureChannel): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to channel.value)
    TransferContext.callMethod(MethodBindings.setMetallicTextureChannelPtr)
  }

  public final fun getMetallicTextureChannel(): TextureChannel {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMetallicTextureChannelPtr)
    return TextureChannel.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRoughnessTextureChannel(channel: TextureChannel): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to channel.value)
    TransferContext.callMethod(MethodBindings.setRoughnessTextureChannelPtr)
  }

  public final fun getRoughnessTextureChannel(): TextureChannel {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRoughnessTextureChannelPtr)
    return TextureChannel.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAoTextureChannel(channel: TextureChannel): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to channel.value)
    TransferContext.callMethod(MethodBindings.setAoTextureChannelPtr)
  }

  public final fun getAoTextureChannel(): TextureChannel {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAoTextureChannelPtr)
    return TextureChannel.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRefractionTextureChannel(channel: TextureChannel): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to channel.value)
    TransferContext.callMethod(MethodBindings.setRefractionTextureChannelPtr)
  }

  public final fun getRefractionTextureChannel(): TextureChannel {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRefractionTextureChannelPtr)
    return TextureChannel.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setProximityFadeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setProximityFadeEnabledPtr)
  }

  public final fun isProximityFadeEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isProximityFadeEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setProximityFadeDistance(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setProximityFadeDistancePtr)
  }

  public final fun getProximityFadeDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProximityFadeDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMsdfPixelRange(range: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to range.toDouble())
    TransferContext.callMethod(MethodBindings.setMsdfPixelRangePtr)
  }

  public final fun getMsdfPixelRange(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMsdfPixelRangePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMsdfOutlineSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setMsdfOutlineSizePtr)
  }

  public final fun getMsdfOutlineSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMsdfOutlineSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDistanceFade(mode: DistanceFadeMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setDistanceFadePtr)
  }

  public final fun getDistanceFade(): DistanceFadeMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDistanceFadePtr)
    return DistanceFadeMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDistanceFadeMaxDistance(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setDistanceFadeMaxDistancePtr)
  }

  public final fun getDistanceFadeMaxDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDistanceFadeMaxDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDistanceFadeMinDistance(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setDistanceFadeMinDistancePtr)
  }

  public final fun getDistanceFadeMinDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDistanceFadeMinDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setZClipScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setZClipScalePtr)
  }

  public final fun getZClipScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZClipScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFovOverride(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setFovOverridePtr)
  }

  public final fun getFovOverride(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFovOverridePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setStencilMode(stencilMode: StencilMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stencilMode.value)
    TransferContext.callMethod(MethodBindings.setStencilModePtr)
  }

  public final fun getStencilMode(): StencilMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStencilModePtr)
    return StencilMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStencilFlags(stencilFlags: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stencilFlags.toLong())
    TransferContext.callMethod(MethodBindings.setStencilFlagsPtr)
  }

  public final fun getStencilFlags(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStencilFlagsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setStencilCompare(stencilCompare: StencilCompare): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stencilCompare.value)
    TransferContext.callMethod(MethodBindings.setStencilComparePtr)
  }

  public final fun getStencilCompare(): StencilCompare {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStencilComparePtr)
    return StencilCompare.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStencilReference(stencilReference: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stencilReference.toLong())
    TransferContext.callMethod(MethodBindings.setStencilReferencePtr)
  }

  public final fun getStencilReference(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStencilReferencePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setStencilEffectColor(stencilColor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to stencilColor)
    TransferContext.callMethod(MethodBindings.setStencilEffectColorPtr)
  }

  public final fun getStencilEffectColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStencilEffectColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setStencilEffectOutlineThickness(stencilOutlineThickness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to stencilOutlineThickness.toDouble())
    TransferContext.callMethod(MethodBindings.setStencilEffectOutlineThicknessPtr)
  }

  public final fun getStencilEffectOutlineThickness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStencilEffectOutlineThicknessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("BaseMaterial3D::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("BaseMaterial3D::_getShaderMode can't be called from the JVM.")
  }

  public enum class TextureParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Texture specifying per-pixel color.
     */
    ALBEDO(0),
    /**
     * Texture specifying per-pixel metallic value.
     */
    METALLIC(1),
    /**
     * Texture specifying per-pixel roughness value.
     */
    ROUGHNESS(2),
    /**
     * Texture specifying per-pixel emission color.
     */
    EMISSION(3),
    /**
     * Texture specifying per-pixel normal vector.
     */
    NORMAL(4),
    /**
     * Texture specifying per-pixel bent normal vector.
     */
    BENT_NORMAL(18),
    /**
     * Texture specifying per-pixel rim value.
     */
    RIM(5),
    /**
     * Texture specifying per-pixel clearcoat value.
     */
    CLEARCOAT(6),
    /**
     * Texture specifying per-pixel flowmap direction for use with [anisotropy].
     */
    FLOWMAP(7),
    /**
     * Texture specifying per-pixel ambient occlusion value.
     */
    AMBIENT_OCCLUSION(8),
    /**
     * Texture specifying per-pixel height.
     */
    HEIGHTMAP(9),
    /**
     * Texture specifying per-pixel subsurface scattering.
     */
    SUBSURFACE_SCATTERING(10),
    /**
     * Texture specifying per-pixel transmittance for subsurface scattering.
     */
    SUBSURFACE_TRANSMITTANCE(11),
    /**
     * Texture specifying per-pixel backlight color.
     */
    BACKLIGHT(12),
    /**
     * Texture specifying per-pixel refraction strength.
     */
    REFRACTION(13),
    /**
     * Texture specifying per-pixel detail mask blending value.
     */
    DETAIL_MASK(14),
    /**
     * Texture specifying per-pixel detail color.
     */
    DETAIL_ALBEDO(15),
    /**
     * Texture specifying per-pixel detail normal.
     */
    DETAIL_NORMAL(16),
    /**
     * Texture holding ambient occlusion, roughness, and metallic.
     */
    ORM(17),
    /**
     * Represents the size of the [TextureParam] enum.
     */
    MAX(19),
    ;

    public companion object {
      public fun from(`value`: Long): TextureParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The texture filter reads from the nearest pixel only. This makes the texture look pixelated
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    NEAREST(0),
    /**
     * The texture filter blends between the nearest 4 pixels. This makes the texture look smooth
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    LINEAR(1),
    /**
     * The texture filter reads from the nearest pixel and blends between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look pixelated from up close, and smooth from a distance.
     */
    NEAREST_WITH_MIPMAPS(2),
    /**
     * The texture filter blends between the nearest 4 pixels and between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look smooth from up close, and smooth from a distance.
     */
    LINEAR_WITH_MIPMAPS(3),
    /**
     * The texture filter reads from the nearest pixel and blends between 2 mipmaps (or uses the
     * nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is
     * `true`) based on the angle between the surface and the camera view. This makes the texture look
     * pixelated from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     */
    NEAREST_WITH_MIPMAPS_ANISOTROPIC(4),
    /**
     * The texture filter blends between the nearest 4 pixels and blends between 2 mipmaps (or uses
     * the nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter]
     * is `true`) based on the angle between the surface and the camera view. This makes the texture
     * look smooth from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     */
    LINEAR_WITH_MIPMAPS_ANISOTROPIC(5),
    /**
     * Represents the size of the [TextureFilter] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): TextureFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class DetailUV(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use `UV` with the detail texture.
     */
    DETAIL_UV_1(0),
    /**
     * Use `UV2` with the detail texture.
     */
    DETAIL_UV_2(1),
    ;

    public companion object {
      public fun from(`value`: Long): DetailUV = entries.single { it.`value` == `value` }
    }
  }

  public enum class Transparency(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The material will not use transparency. This is the fastest to render.
     */
    DISABLED(0),
    /**
     * The material will use the texture's alpha values for transparency. This is the slowest to
     * render, and disables shadow casting.
     */
    ALPHA(1),
    /**
     * The material will cut off all values below a threshold, the rest will remain opaque. The
     * opaque portions will be rendered in the depth prepass. This is faster to render than alpha
     * blending, but slower than opaque rendering. This also supports casting shadows.
     */
    ALPHA_SCISSOR(2),
    /**
     * The material will cut off all values below a spatially-deterministic threshold, the rest will
     * remain opaque. This is faster to render than alpha blending, but slower than opaque rendering.
     * This also supports casting shadows. Alpha hashing is suited for hair rendering.
     */
    ALPHA_HASH(3),
    /**
     * The material will use the texture's alpha value for transparency, but will discard fragments
     * with an alpha of less than 0.99 during the depth prepass and fragments with an alpha less than
     * 0.1 during the shadow pass. This also supports casting shadows.
     */
    ALPHA_DEPTH_PRE_PASS(4),
    /**
     * Represents the size of the [Transparency] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): Transparency = entries.single { it.`value` == `value` }
    }
  }

  public enum class ShadingMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The object will not receive shadows. This is the fastest to render, but it disables all
     * interactions with lights.
     */
    UNSHADED(0),
    /**
     * The object will be shaded per pixel. Useful for realistic shading effects.
     */
    PER_PIXEL(1),
    /**
     * The object will be shaded per vertex. Useful when you want cheaper shaders and do not care
     * about visual quality.
     */
    PER_VERTEX(2),
    /**
     * Represents the size of the [ShadingMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ShadingMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Feature(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant for setting [emissionEnabled].
     */
    EMISSION(0),
    /**
     * Constant for setting [normalEnabled].
     */
    NORMAL_MAPPING(1),
    /**
     * Constant for setting [rimEnabled].
     */
    RIM(2),
    /**
     * Constant for setting [clearcoatEnabled].
     */
    CLEARCOAT(3),
    /**
     * Constant for setting [anisotropyEnabled].
     */
    ANISOTROPY(4),
    /**
     * Constant for setting [aoEnabled].
     */
    AMBIENT_OCCLUSION(5),
    /**
     * Constant for setting [heightmapEnabled].
     */
    HEIGHT_MAPPING(6),
    /**
     * Constant for setting [subsurfScatterEnabled].
     */
    SUBSURFACE_SCATTERING(7),
    /**
     * Constant for setting [subsurfScatterTransmittanceEnabled].
     */
    SUBSURFACE_TRANSMITTANCE(8),
    /**
     * Constant for setting [backlightEnabled].
     */
    BACKLIGHT(9),
    /**
     * Constant for setting [refractionEnabled].
     */
    REFRACTION(10),
    /**
     * Constant for setting [detailEnabled].
     */
    DETAIL(11),
    /**
     * Constant for setting [bentNormalEnabled].
     */
    BENT_NORMAL_MAPPING(12),
    /**
     * Represents the size of the [Feature] enum.
     */
    MAX(13),
    ;

    public companion object {
      public fun from(`value`: Long): Feature = entries.single { it.`value` == `value` }
    }
  }

  public enum class BlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default blend mode. The color of the object is blended over the background based on the
     * object's alpha value.
     */
    MIX(0),
    /**
     * The color of the object is added to the background.
     */
    ADD(1),
    /**
     * The color of the object is subtracted from the background.
     */
    SUB(2),
    /**
     * The color of the object is multiplied by the background.
     */
    MUL(3),
    /**
     * The color of the object is added to the background and the alpha channel is used to mask out
     * the background. This is effectively a hybrid of the blend mix and add modes, useful for effects
     * like fire where you want the flame to add but the smoke to mix. By default, this works with
     * unshaded materials using premultiplied textures. For shaded materials, use the
     * `PREMUL_ALPHA_FACTOR` built-in so that lighting can be modulated as well.
     */
    PREMULT_ALPHA(4),
    ;

    public companion object {
      public fun from(`value`: Long): BlendMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class AlphaAntiAliasing(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables Alpha AntiAliasing for the material.
     */
    ANTIALIASING_OFF(0),
    /**
     * Enables AlphaToCoverage. Alpha values in the material are passed to the AntiAliasing sample
     * mask.
     */
    ANTIALIASING_ALPHA_TO_COVERAGE(1),
    /**
     * Enables AlphaToCoverage and forces all non-zero alpha values to `1`. Alpha values in the
     * material are passed to the AntiAliasing sample mask.
     */
    ANTIALIASING_ALPHA_TO_COVERAGE_AND_TO_ONE(2),
    ;

    public companion object {
      public fun from(`value`: Long): AlphaAntiAliasing = entries.single { it.`value` == `value` }
    }
  }

  public enum class DepthDrawMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default depth draw mode. Depth is drawn only for opaque objects during the opaque prepass (if
     * any) and during the opaque pass.
     */
    OPAQUE_ONLY(0),
    /**
     * Objects will write to depth during the opaque and the transparent passes. Transparent objects
     * that are close to the camera may obscure other transparent objects behind them.
     *
     * **Note:** This does not influence whether transparent objects are included in the depth
     * prepass or not. For that, see [Transparency].
     */
    ALWAYS(1),
    /**
     * Objects will not write their depth to the depth buffer, even during the depth prepass (if
     * enabled).
     */
    DISABLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): DepthDrawMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class DepthTest(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Depth test will discard the pixel if it is behind other pixels.
     */
    DEFAULT(0),
    /**
     * Depth test will discard the pixel if it is in front of other pixels. Useful for stencil
     * effects.
     */
    INVERTED(1),
    ;

    public companion object {
      public fun from(`value`: Long): DepthTest = entries.single { it.`value` == `value` }
    }
  }

  public enum class CullMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default cull mode. The back of the object is culled when not visible. Back face triangles
     * will be culled when facing the camera. This results in only the front side of triangles being
     * drawn. For closed-surface meshes, this means that only the exterior of the mesh will be visible.
     */
    BACK(0),
    /**
     * Front face triangles will be culled when facing the camera. This results in only the back
     * side of triangles being drawn. For closed-surface meshes, this means that the interior of the
     * mesh will be drawn instead of the exterior.
     */
    FRONT(1),
    /**
     * No face culling is performed; both the front face and back face will be visible.
     */
    DISABLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): CullMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Flags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables the depth test, so this object is drawn on top of all others drawn before it. This
     * puts the object in the transparent draw pass where it is sorted based on distance to camera.
     * Objects drawn after it in the draw order may cover it. This also disables writing to depth.
     */
    DISABLE_DEPTH_TEST(0),
    /**
     * Set `ALBEDO` to the per-vertex color specified in the mesh.
     */
    ALBEDO_FROM_VERTEX_COLOR(1),
    /**
     * Vertex colors are considered to be stored in nonlinear sRGB encoding and are converted to
     * linear encoding during rendering. See also [vertexColorIsSrgb].
     *
     * **Note:** Only effective when using the Forward+ and Mobile rendering methods.
     */
    SRGB_VERTEX_COLOR(2),
    /**
     * Uses point size to alter the size of primitive points. Also changes the albedo texture lookup
     * to use `POINT_COORD` instead of `UV`.
     */
    USE_POINT_SIZE(3),
    /**
     * Object is scaled by depth so that it always appears the same size on screen.
     */
    FIXED_SIZE(4),
    /**
     * Shader will keep the scale set for the mesh. Otherwise the scale is lost when billboarding.
     * Only applies when [billboardMode] is [BILLBOARD_ENABLED].
     */
    BILLBOARD_KEEP_SCALE(5),
    /**
     * Use triplanar texture lookup for all texture lookups that would normally use `UV`.
     */
    UV1_USE_TRIPLANAR(6),
    /**
     * Use triplanar texture lookup for all texture lookups that would normally use `UV2`.
     */
    UV2_USE_TRIPLANAR(7),
    /**
     * Use triplanar texture lookup for all texture lookups that would normally use `UV`.
     */
    UV1_USE_WORLD_TRIPLANAR(8),
    /**
     * Use triplanar texture lookup for all texture lookups that would normally use `UV2`.
     */
    UV2_USE_WORLD_TRIPLANAR(9),
    /**
     * Use `UV2` coordinates to look up from the [aoTexture].
     */
    AO_ON_UV2(10),
    /**
     * Use `UV2` coordinates to look up from the [emissionTexture].
     */
    EMISSION_ON_UV2(11),
    /**
     * Forces the shader to convert albedo from nonlinear sRGB encoding to linear encoding. See also
     * [albedoTextureForceSrgb].
     */
    ALBEDO_TEXTURE_FORCE_SRGB(12),
    /**
     * Disables receiving shadows from other objects.
     */
    DONT_RECEIVE_SHADOWS(13),
    /**
     * Disables receiving ambient light.
     */
    DISABLE_AMBIENT_LIGHT(14),
    /**
     * Enables the shadow to opacity feature.
     */
    USE_SHADOW_TO_OPACITY(15),
    /**
     * Enables the texture to repeat when UV coordinates are outside the 0-1 range. If using one of
     * the linear filtering modes, this can result in artifacts at the edges of a texture when the
     * sampler filters across the edges of the texture.
     */
    USE_TEXTURE_REPEAT(16),
    /**
     * Invert values read from a depth texture to convert them to height values (heightmap).
     */
    INVERT_HEIGHTMAP(17),
    /**
     * Enables the skin mode for subsurface scattering which is used to improve the look of
     * subsurface scattering when used for human skin.
     */
    SUBSURFACE_MODE_SKIN(18),
    /**
     * Enables parts of the shader required for [GPUParticles3D] trails to function. This also
     * requires using a mesh with appropriate skinning, such as [RibbonTrailMesh] or [TubeTrailMesh].
     * Enabling this feature outside of materials used in [GPUParticles3D] meshes will break material
     * rendering.
     */
    PARTICLE_TRAILS_MODE(19),
    /**
     * Enables multichannel signed distance field rendering shader.
     */
    ALBEDO_TEXTURE_MSDF(20),
    /**
     * Disables receiving depth-based or volumetric fog.
     */
    DISABLE_FOG(21),
    /**
     * Disables specular occlusion.
     */
    DISABLE_SPECULAR_OCCLUSION(22),
    /**
     * Enables using [zClipScale].
     */
    USE_Z_CLIP_SCALE(23),
    /**
     * Enables using [fovOverride].
     */
    USE_FOV_OVERRIDE(24),
    /**
     * Represents the size of the [Flags] enum.
     */
    MAX(25),
    ;

    public companion object {
      public fun from(`value`: Long): Flags = entries.single { it.`value` == `value` }
    }
  }

  public enum class DiffuseMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default diffuse scattering algorithm.
     */
    BURLEY(0),
    /**
     * Diffuse scattering ignores roughness.
     */
    LAMBERT(1),
    /**
     * Extends Lambert to cover more than 90 degrees when roughness increases.
     */
    LAMBERT_WRAP(2),
    /**
     * Uses a hard cut for lighting, with smoothing affected by roughness.
     */
    TOON(3),
    ;

    public companion object {
      public fun from(`value`: Long): DiffuseMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class SpecularMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default specular blob.
     *
     * **Note:** Forward+ uses multiscattering for more accurate reflections, although the impact of
     * multiscattering is more noticeable on rough metallic surfaces than on smooth, non-metallic
     * surfaces.
     *
     * **Note:** Mobile and Compatibility don't perform multiscattering for performance reasons.
     * Instead, they perform single scattering, which means rough metallic surfaces may look slightly
     * darker than intended.
     */
    SCHLICK_GGX(0),
    /**
     * Toon blob which changes size based on roughness.
     */
    TOON(1),
    /**
     * No specular blob. This is slightly faster to render than other specular modes.
     */
    DISABLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): SpecularMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class BillboardMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Billboard mode is disabled.
     */
    DISABLED(0),
    /**
     * The object's Z axis will always face the camera.
     */
    ENABLED(1),
    /**
     * The object's X axis will always face the camera.
     */
    FIXED_Y(2),
    /**
     * Used for particle systems when assigned to [GPUParticles3D] and [CPUParticles3D] nodes
     * (flipbook animation). Enables `particles_anim_*` properties.
     *
     * The [ParticleProcessMaterial.animSpeedMin] or [CPUParticles3D.animSpeedMin] should also be
     * set to a value bigger than zero for the animation to play.
     */
    PARTICLES(3),
    ;

    public companion object {
      public fun from(`value`: Long): BillboardMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureChannel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Used to read from the red channel of a texture.
     */
    RED(0),
    /**
     * Used to read from the green channel of a texture.
     */
    GREEN(1),
    /**
     * Used to read from the blue channel of a texture.
     */
    BLUE(2),
    /**
     * Used to read from the alpha channel of a texture.
     */
    ALPHA(3),
    /**
     * Used to read from the linear (non-perceptual) average of the red, green and blue channels of
     * a texture.
     */
    GRAYSCALE(4),
    ;

    public companion object {
      public fun from(`value`: Long): TextureChannel = entries.single { it.`value` == `value` }
    }
  }

  public enum class EmissionOperator(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Adds the emission color to the color from the emission texture.
     */
    ADD(0),
    /**
     * Multiplies the emission color by the color from the emission texture.
     */
    MULTIPLY(1),
    ;

    public companion object {
      public fun from(`value`: Long): EmissionOperator = entries.single { it.`value` == `value` }
    }
  }

  public enum class DistanceFadeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not use distance fade.
     */
    DISABLED(0),
    /**
     * Smoothly fades the object out based on each pixel's distance from the camera using the alpha
     * channel.
     */
    PIXEL_ALPHA(1),
    /**
     * Smoothly fades the object out based on each pixel's distance from the camera using a
     * dithering approach. Dithering discards pixels based on a set pattern to smoothly fade without
     * enabling transparency. On certain hardware, this can be faster than [DISTANCE_FADE_PIXEL_ALPHA].
     */
    PIXEL_DITHER(2),
    /**
     * Smoothly fades the object out based on the object's distance from the camera using a
     * dithering approach. Dithering discards pixels based on a set pattern to smoothly fade without
     * enabling transparency. On certain hardware, this can be faster than [DISTANCE_FADE_PIXEL_ALPHA]
     * and [DISTANCE_FADE_PIXEL_DITHER].
     */
    OBJECT_DITHER(3),
    ;

    public companion object {
      public fun from(`value`: Long): DistanceFadeMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class StencilMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables stencil operations.
     */
    DISABLED(0),
    /**
     * Stencil preset which applies an outline to the object.
     *
     * **Note:** Requires a [Material.nextPass] material which will be automatically applied. Any
     * manual changes made to [Material.nextPass] will be lost when the stencil properties are modified
     * or the scene is reloaded. To safely apply a [Material.nextPass] material on a material that uses
     * stencil presets, use [GeometryInstance3D.materialOverlay] instead.
     */
    OUTLINE(1),
    /**
     * Stencil preset which shows a silhouette of the object behind walls.
     *
     * **Note:** Requires a [Material.nextPass] material which will be automatically applied. Any
     * manual changes made to [Material.nextPass] will be lost when the stencil properties are modified
     * or the scene is reloaded. To safely apply a [Material.nextPass] material on a material that uses
     * stencil presets, use [GeometryInstance3D.materialOverlay] instead.
     */
    XRAY(2),
    /**
     * Enables stencil operations without a preset.
     */
    CUSTOM(3),
    ;

    public companion object {
      public fun from(`value`: Long): StencilMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class StencilFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The material will only be rendered where it passes a stencil comparison with existing stencil
     * buffer values.
     */
    READ(1),
    /**
     * The material will write the reference value to the stencil buffer where it passes the depth
     * test.
     */
    WRITE(2),
    /**
     * The material will write the reference value to the stencil buffer where it fails the depth
     * test.
     */
    WRITE_DEPTH_FAIL(4),
    ;

    public companion object {
      public fun from(`value`: Long): StencilFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class StencilCompare(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Always passes the stencil test.
     */
    ALWAYS(0),
    /**
     * Passes the stencil test when the reference value is less than the existing stencil value.
     */
    LESS(1),
    /**
     * Passes the stencil test when the reference value is equal to the existing stencil value.
     */
    EQUAL(2),
    /**
     * Passes the stencil test when the reference value is less than or equal to the existing
     * stencil value.
     */
    LESS_OR_EQUAL(3),
    /**
     * Passes the stencil test when the reference value is greater than the existing stencil value.
     */
    GREATER(4),
    /**
     * Passes the stencil test when the reference value is not equal to the existing stencil value.
     */
    NOT_EQUAL(5),
    /**
     * Passes the stencil test when the reference value is greater than or equal to the existing
     * stencil value.
     */
    GREATER_OR_EQUAL(6),
    ;

    public companion object {
      public fun from(`value`: Long): StencilCompare = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setAlbedoName: MethodStringName1<BaseMaterial3D, Unit, Color> =
        MethodStringName1<BaseMaterial3D, Unit, Color>("set_albedo")

    @JvmField
    public val getAlbedoName: MethodStringName0<BaseMaterial3D, Color> =
        MethodStringName0<BaseMaterial3D, Color>("get_albedo")

    @JvmField
    public val setTransparencyName: MethodStringName1<BaseMaterial3D, Unit, Transparency> =
        MethodStringName1<BaseMaterial3D, Unit, Transparency>("set_transparency")

    @JvmField
    public val getTransparencyName: MethodStringName0<BaseMaterial3D, Transparency> =
        MethodStringName0<BaseMaterial3D, Transparency>("get_transparency")

    @JvmField
    public val setAlphaAntialiasingName: MethodStringName1<BaseMaterial3D, Unit, AlphaAntiAliasing>
        = MethodStringName1<BaseMaterial3D, Unit, AlphaAntiAliasing>("set_alpha_antialiasing")

    @JvmField
    public val getAlphaAntialiasingName: MethodStringName0<BaseMaterial3D, AlphaAntiAliasing> =
        MethodStringName0<BaseMaterial3D, AlphaAntiAliasing>("get_alpha_antialiasing")

    @JvmField
    public val setAlphaAntialiasingEdgeName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_alpha_antialiasing_edge")

    @JvmField
    public val getAlphaAntialiasingEdgeName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_alpha_antialiasing_edge")

    @JvmField
    public val setShadingModeName: MethodStringName1<BaseMaterial3D, Unit, ShadingMode> =
        MethodStringName1<BaseMaterial3D, Unit, ShadingMode>("set_shading_mode")

    @JvmField
    public val getShadingModeName: MethodStringName0<BaseMaterial3D, ShadingMode> =
        MethodStringName0<BaseMaterial3D, ShadingMode>("get_shading_mode")

    @JvmField
    public val setSpecularName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_specular")

    @JvmField
    public val getSpecularName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_specular")

    @JvmField
    public val setMetallicName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_metallic")

    @JvmField
    public val getMetallicName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_metallic")

    @JvmField
    public val setRoughnessName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_roughness")

    @JvmField
    public val getRoughnessName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_roughness")

    @JvmField
    public val setEmissionName: MethodStringName1<BaseMaterial3D, Unit, Color> =
        MethodStringName1<BaseMaterial3D, Unit, Color>("set_emission")

    @JvmField
    public val getEmissionName: MethodStringName0<BaseMaterial3D, Color> =
        MethodStringName0<BaseMaterial3D, Color>("get_emission")

    @JvmField
    public val setEmissionEnergyMultiplierName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_emission_energy_multiplier")

    @JvmField
    public val getEmissionEnergyMultiplierName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_emission_energy_multiplier")

    @JvmField
    public val setEmissionIntensityName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_emission_intensity")

    @JvmField
    public val getEmissionIntensityName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_emission_intensity")

    @JvmField
    public val setNormalScaleName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_normal_scale")

    @JvmField
    public val getNormalScaleName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_normal_scale")

    @JvmField
    public val setRimName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_rim")

    @JvmField
    public val getRimName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_rim")

    @JvmField
    public val setRimTintName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_rim_tint")

    @JvmField
    public val getRimTintName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_rim_tint")

    @JvmField
    public val setClearcoatName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_clearcoat")

    @JvmField
    public val getClearcoatName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_clearcoat")

    @JvmField
    public val setClearcoatRoughnessName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_clearcoat_roughness")

    @JvmField
    public val getClearcoatRoughnessName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_clearcoat_roughness")

    @JvmField
    public val setAnisotropyName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_anisotropy")

    @JvmField
    public val getAnisotropyName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_anisotropy")

    @JvmField
    public val setHeightmapScaleName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_heightmap_scale")

    @JvmField
    public val getHeightmapScaleName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_heightmap_scale")

    @JvmField
    public val setSubsurfaceScatteringStrengthName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_subsurface_scattering_strength")

    @JvmField
    public val getSubsurfaceScatteringStrengthName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_subsurface_scattering_strength")

    @JvmField
    public val setTransmittanceColorName: MethodStringName1<BaseMaterial3D, Unit, Color> =
        MethodStringName1<BaseMaterial3D, Unit, Color>("set_transmittance_color")

    @JvmField
    public val getTransmittanceColorName: MethodStringName0<BaseMaterial3D, Color> =
        MethodStringName0<BaseMaterial3D, Color>("get_transmittance_color")

    @JvmField
    public val setTransmittanceDepthName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_transmittance_depth")

    @JvmField
    public val getTransmittanceDepthName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_transmittance_depth")

    @JvmField
    public val setTransmittanceBoostName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_transmittance_boost")

    @JvmField
    public val getTransmittanceBoostName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_transmittance_boost")

    @JvmField
    public val setBacklightName: MethodStringName1<BaseMaterial3D, Unit, Color> =
        MethodStringName1<BaseMaterial3D, Unit, Color>("set_backlight")

    @JvmField
    public val getBacklightName: MethodStringName0<BaseMaterial3D, Color> =
        MethodStringName0<BaseMaterial3D, Color>("get_backlight")

    @JvmField
    public val setRefractionName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_refraction")

    @JvmField
    public val getRefractionName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_refraction")

    @JvmField
    public val setPointSizeName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_point_size")

    @JvmField
    public val getPointSizeName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_point_size")

    @JvmField
    public val setDetailUvName: MethodStringName1<BaseMaterial3D, Unit, DetailUV> =
        MethodStringName1<BaseMaterial3D, Unit, DetailUV>("set_detail_uv")

    @JvmField
    public val getDetailUvName: MethodStringName0<BaseMaterial3D, DetailUV> =
        MethodStringName0<BaseMaterial3D, DetailUV>("get_detail_uv")

    @JvmField
    public val setBlendModeName: MethodStringName1<BaseMaterial3D, Unit, BlendMode> =
        MethodStringName1<BaseMaterial3D, Unit, BlendMode>("set_blend_mode")

    @JvmField
    public val getBlendModeName: MethodStringName0<BaseMaterial3D, BlendMode> =
        MethodStringName0<BaseMaterial3D, BlendMode>("get_blend_mode")

    @JvmField
    public val setDepthDrawModeName: MethodStringName1<BaseMaterial3D, Unit, DepthDrawMode> =
        MethodStringName1<BaseMaterial3D, Unit, DepthDrawMode>("set_depth_draw_mode")

    @JvmField
    public val getDepthDrawModeName: MethodStringName0<BaseMaterial3D, DepthDrawMode> =
        MethodStringName0<BaseMaterial3D, DepthDrawMode>("get_depth_draw_mode")

    @JvmField
    public val setDepthTestName: MethodStringName1<BaseMaterial3D, Unit, DepthTest> =
        MethodStringName1<BaseMaterial3D, Unit, DepthTest>("set_depth_test")

    @JvmField
    public val getDepthTestName: MethodStringName0<BaseMaterial3D, DepthTest> =
        MethodStringName0<BaseMaterial3D, DepthTest>("get_depth_test")

    @JvmField
    public val setCullModeName: MethodStringName1<BaseMaterial3D, Unit, CullMode> =
        MethodStringName1<BaseMaterial3D, Unit, CullMode>("set_cull_mode")

    @JvmField
    public val getCullModeName: MethodStringName0<BaseMaterial3D, CullMode> =
        MethodStringName0<BaseMaterial3D, CullMode>("get_cull_mode")

    @JvmField
    public val setDiffuseModeName: MethodStringName1<BaseMaterial3D, Unit, DiffuseMode> =
        MethodStringName1<BaseMaterial3D, Unit, DiffuseMode>("set_diffuse_mode")

    @JvmField
    public val getDiffuseModeName: MethodStringName0<BaseMaterial3D, DiffuseMode> =
        MethodStringName0<BaseMaterial3D, DiffuseMode>("get_diffuse_mode")

    @JvmField
    public val setSpecularModeName: MethodStringName1<BaseMaterial3D, Unit, SpecularMode> =
        MethodStringName1<BaseMaterial3D, Unit, SpecularMode>("set_specular_mode")

    @JvmField
    public val getSpecularModeName: MethodStringName0<BaseMaterial3D, SpecularMode> =
        MethodStringName0<BaseMaterial3D, SpecularMode>("get_specular_mode")

    @JvmField
    public val setFlagName: MethodStringName2<BaseMaterial3D, Unit, Flags, Boolean> =
        MethodStringName2<BaseMaterial3D, Unit, Flags, Boolean>("set_flag")

    @JvmField
    public val getFlagName: MethodStringName1<BaseMaterial3D, Boolean, Flags> =
        MethodStringName1<BaseMaterial3D, Boolean, Flags>("get_flag")

    @JvmField
    public val setTextureFilterName: MethodStringName1<BaseMaterial3D, Unit, TextureFilter> =
        MethodStringName1<BaseMaterial3D, Unit, TextureFilter>("set_texture_filter")

    @JvmField
    public val getTextureFilterName: MethodStringName0<BaseMaterial3D, TextureFilter> =
        MethodStringName0<BaseMaterial3D, TextureFilter>("get_texture_filter")

    @JvmField
    public val setFeatureName: MethodStringName2<BaseMaterial3D, Unit, Feature, Boolean> =
        MethodStringName2<BaseMaterial3D, Unit, Feature, Boolean>("set_feature")

    @JvmField
    public val getFeatureName: MethodStringName1<BaseMaterial3D, Boolean, Feature> =
        MethodStringName1<BaseMaterial3D, Boolean, Feature>("get_feature")

    @JvmField
    public val setTextureName: MethodStringName2<BaseMaterial3D, Unit, TextureParam, Texture2D?> =
        MethodStringName2<BaseMaterial3D, Unit, TextureParam, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName1<BaseMaterial3D, Texture2D?, TextureParam> =
        MethodStringName1<BaseMaterial3D, Texture2D?, TextureParam>("get_texture")

    @JvmField
    public val setDetailBlendModeName: MethodStringName1<BaseMaterial3D, Unit, BlendMode> =
        MethodStringName1<BaseMaterial3D, Unit, BlendMode>("set_detail_blend_mode")

    @JvmField
    public val getDetailBlendModeName: MethodStringName0<BaseMaterial3D, BlendMode> =
        MethodStringName0<BaseMaterial3D, BlendMode>("get_detail_blend_mode")

    @JvmField
    public val setUv1ScaleName: MethodStringName1<BaseMaterial3D, Unit, Vector3> =
        MethodStringName1<BaseMaterial3D, Unit, Vector3>("set_uv1_scale")

    @JvmField
    public val getUv1ScaleName: MethodStringName0<BaseMaterial3D, Vector3> =
        MethodStringName0<BaseMaterial3D, Vector3>("get_uv1_scale")

    @JvmField
    public val setUv1OffsetName: MethodStringName1<BaseMaterial3D, Unit, Vector3> =
        MethodStringName1<BaseMaterial3D, Unit, Vector3>("set_uv1_offset")

    @JvmField
    public val getUv1OffsetName: MethodStringName0<BaseMaterial3D, Vector3> =
        MethodStringName0<BaseMaterial3D, Vector3>("get_uv1_offset")

    @JvmField
    public val setUv1TriplanarBlendSharpnessName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_uv1_triplanar_blend_sharpness")

    @JvmField
    public val getUv1TriplanarBlendSharpnessName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_uv1_triplanar_blend_sharpness")

    @JvmField
    public val setUv2ScaleName: MethodStringName1<BaseMaterial3D, Unit, Vector3> =
        MethodStringName1<BaseMaterial3D, Unit, Vector3>("set_uv2_scale")

    @JvmField
    public val getUv2ScaleName: MethodStringName0<BaseMaterial3D, Vector3> =
        MethodStringName0<BaseMaterial3D, Vector3>("get_uv2_scale")

    @JvmField
    public val setUv2OffsetName: MethodStringName1<BaseMaterial3D, Unit, Vector3> =
        MethodStringName1<BaseMaterial3D, Unit, Vector3>("set_uv2_offset")

    @JvmField
    public val getUv2OffsetName: MethodStringName0<BaseMaterial3D, Vector3> =
        MethodStringName0<BaseMaterial3D, Vector3>("get_uv2_offset")

    @JvmField
    public val setUv2TriplanarBlendSharpnessName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_uv2_triplanar_blend_sharpness")

    @JvmField
    public val getUv2TriplanarBlendSharpnessName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_uv2_triplanar_blend_sharpness")

    @JvmField
    public val setBillboardModeName: MethodStringName1<BaseMaterial3D, Unit, BillboardMode> =
        MethodStringName1<BaseMaterial3D, Unit, BillboardMode>("set_billboard_mode")

    @JvmField
    public val getBillboardModeName: MethodStringName0<BaseMaterial3D, BillboardMode> =
        MethodStringName0<BaseMaterial3D, BillboardMode>("get_billboard_mode")

    @JvmField
    public val setParticlesAnimHFramesName: MethodStringName1<BaseMaterial3D, Unit, Int> =
        MethodStringName1<BaseMaterial3D, Unit, Int>("set_particles_anim_h_frames")

    @JvmField
    public val getParticlesAnimHFramesName: MethodStringName0<BaseMaterial3D, Int> =
        MethodStringName0<BaseMaterial3D, Int>("get_particles_anim_h_frames")

    @JvmField
    public val setParticlesAnimVFramesName: MethodStringName1<BaseMaterial3D, Unit, Int> =
        MethodStringName1<BaseMaterial3D, Unit, Int>("set_particles_anim_v_frames")

    @JvmField
    public val getParticlesAnimVFramesName: MethodStringName0<BaseMaterial3D, Int> =
        MethodStringName0<BaseMaterial3D, Int>("get_particles_anim_v_frames")

    @JvmField
    public val setParticlesAnimLoopName: MethodStringName1<BaseMaterial3D, Unit, Boolean> =
        MethodStringName1<BaseMaterial3D, Unit, Boolean>("set_particles_anim_loop")

    @JvmField
    public val getParticlesAnimLoopName: MethodStringName0<BaseMaterial3D, Boolean> =
        MethodStringName0<BaseMaterial3D, Boolean>("get_particles_anim_loop")

    @JvmField
    public val setHeightmapDeepParallaxName: MethodStringName1<BaseMaterial3D, Unit, Boolean> =
        MethodStringName1<BaseMaterial3D, Unit, Boolean>("set_heightmap_deep_parallax")

    @JvmField
    public val isHeightmapDeepParallaxEnabledName: MethodStringName0<BaseMaterial3D, Boolean> =
        MethodStringName0<BaseMaterial3D, Boolean>("is_heightmap_deep_parallax_enabled")

    @JvmField
    public val setHeightmapDeepParallaxMinLayersName: MethodStringName1<BaseMaterial3D, Unit, Int> =
        MethodStringName1<BaseMaterial3D, Unit, Int>("set_heightmap_deep_parallax_min_layers")

    @JvmField
    public val getHeightmapDeepParallaxMinLayersName: MethodStringName0<BaseMaterial3D, Int> =
        MethodStringName0<BaseMaterial3D, Int>("get_heightmap_deep_parallax_min_layers")

    @JvmField
    public val setHeightmapDeepParallaxMaxLayersName: MethodStringName1<BaseMaterial3D, Unit, Int> =
        MethodStringName1<BaseMaterial3D, Unit, Int>("set_heightmap_deep_parallax_max_layers")

    @JvmField
    public val getHeightmapDeepParallaxMaxLayersName: MethodStringName0<BaseMaterial3D, Int> =
        MethodStringName0<BaseMaterial3D, Int>("get_heightmap_deep_parallax_max_layers")

    @JvmField
    public val setHeightmapDeepParallaxFlipTangentName:
        MethodStringName1<BaseMaterial3D, Unit, Boolean> =
        MethodStringName1<BaseMaterial3D, Unit, Boolean>("set_heightmap_deep_parallax_flip_tangent")

    @JvmField
    public val getHeightmapDeepParallaxFlipTangentName: MethodStringName0<BaseMaterial3D, Boolean> =
        MethodStringName0<BaseMaterial3D, Boolean>("get_heightmap_deep_parallax_flip_tangent")

    @JvmField
    public val setHeightmapDeepParallaxFlipBinormalName:
        MethodStringName1<BaseMaterial3D, Unit, Boolean> =
        MethodStringName1<BaseMaterial3D, Unit, Boolean>("set_heightmap_deep_parallax_flip_binormal")

    @JvmField
    public val getHeightmapDeepParallaxFlipBinormalName: MethodStringName0<BaseMaterial3D, Boolean>
        = MethodStringName0<BaseMaterial3D, Boolean>("get_heightmap_deep_parallax_flip_binormal")

    @JvmField
    public val setGrowName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_grow")

    @JvmField
    public val getGrowName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_grow")

    @JvmField
    public val setEmissionOperatorName: MethodStringName1<BaseMaterial3D, Unit, EmissionOperator> =
        MethodStringName1<BaseMaterial3D, Unit, EmissionOperator>("set_emission_operator")

    @JvmField
    public val getEmissionOperatorName: MethodStringName0<BaseMaterial3D, EmissionOperator> =
        MethodStringName0<BaseMaterial3D, EmissionOperator>("get_emission_operator")

    @JvmField
    public val setAoLightAffectName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_ao_light_affect")

    @JvmField
    public val getAoLightAffectName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_ao_light_affect")

    @JvmField
    public val setAlphaScissorThresholdName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_alpha_scissor_threshold")

    @JvmField
    public val getAlphaScissorThresholdName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_alpha_scissor_threshold")

    @JvmField
    public val setAlphaHashScaleName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_alpha_hash_scale")

    @JvmField
    public val getAlphaHashScaleName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_alpha_hash_scale")

    @JvmField
    public val setGrowEnabledName: MethodStringName1<BaseMaterial3D, Unit, Boolean> =
        MethodStringName1<BaseMaterial3D, Unit, Boolean>("set_grow_enabled")

    @JvmField
    public val isGrowEnabledName: MethodStringName0<BaseMaterial3D, Boolean> =
        MethodStringName0<BaseMaterial3D, Boolean>("is_grow_enabled")

    @JvmField
    public val setMetallicTextureChannelName:
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel> =
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel>("set_metallic_texture_channel")

    @JvmField
    public val getMetallicTextureChannelName: MethodStringName0<BaseMaterial3D, TextureChannel> =
        MethodStringName0<BaseMaterial3D, TextureChannel>("get_metallic_texture_channel")

    @JvmField
    public val setRoughnessTextureChannelName:
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel> =
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel>("set_roughness_texture_channel")

    @JvmField
    public val getRoughnessTextureChannelName: MethodStringName0<BaseMaterial3D, TextureChannel> =
        MethodStringName0<BaseMaterial3D, TextureChannel>("get_roughness_texture_channel")

    @JvmField
    public val setAoTextureChannelName: MethodStringName1<BaseMaterial3D, Unit, TextureChannel> =
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel>("set_ao_texture_channel")

    @JvmField
    public val getAoTextureChannelName: MethodStringName0<BaseMaterial3D, TextureChannel> =
        MethodStringName0<BaseMaterial3D, TextureChannel>("get_ao_texture_channel")

    @JvmField
    public val setRefractionTextureChannelName:
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel> =
        MethodStringName1<BaseMaterial3D, Unit, TextureChannel>("set_refraction_texture_channel")

    @JvmField
    public val getRefractionTextureChannelName: MethodStringName0<BaseMaterial3D, TextureChannel> =
        MethodStringName0<BaseMaterial3D, TextureChannel>("get_refraction_texture_channel")

    @JvmField
    public val setProximityFadeEnabledName: MethodStringName1<BaseMaterial3D, Unit, Boolean> =
        MethodStringName1<BaseMaterial3D, Unit, Boolean>("set_proximity_fade_enabled")

    @JvmField
    public val isProximityFadeEnabledName: MethodStringName0<BaseMaterial3D, Boolean> =
        MethodStringName0<BaseMaterial3D, Boolean>("is_proximity_fade_enabled")

    @JvmField
    public val setProximityFadeDistanceName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_proximity_fade_distance")

    @JvmField
    public val getProximityFadeDistanceName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_proximity_fade_distance")

    @JvmField
    public val setMsdfPixelRangeName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_msdf_pixel_range")

    @JvmField
    public val getMsdfPixelRangeName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_msdf_pixel_range")

    @JvmField
    public val setMsdfOutlineSizeName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_msdf_outline_size")

    @JvmField
    public val getMsdfOutlineSizeName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_msdf_outline_size")

    @JvmField
    public val setDistanceFadeName: MethodStringName1<BaseMaterial3D, Unit, DistanceFadeMode> =
        MethodStringName1<BaseMaterial3D, Unit, DistanceFadeMode>("set_distance_fade")

    @JvmField
    public val getDistanceFadeName: MethodStringName0<BaseMaterial3D, DistanceFadeMode> =
        MethodStringName0<BaseMaterial3D, DistanceFadeMode>("get_distance_fade")

    @JvmField
    public val setDistanceFadeMaxDistanceName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_distance_fade_max_distance")

    @JvmField
    public val getDistanceFadeMaxDistanceName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_distance_fade_max_distance")

    @JvmField
    public val setDistanceFadeMinDistanceName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_distance_fade_min_distance")

    @JvmField
    public val getDistanceFadeMinDistanceName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_distance_fade_min_distance")

    @JvmField
    public val setZClipScaleName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_z_clip_scale")

    @JvmField
    public val getZClipScaleName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_z_clip_scale")

    @JvmField
    public val setFovOverrideName: MethodStringName1<BaseMaterial3D, Unit, Float> =
        MethodStringName1<BaseMaterial3D, Unit, Float>("set_fov_override")

    @JvmField
    public val getFovOverrideName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_fov_override")

    @JvmField
    public val setStencilModeName: MethodStringName1<BaseMaterial3D, Unit, StencilMode> =
        MethodStringName1<BaseMaterial3D, Unit, StencilMode>("set_stencil_mode")

    @JvmField
    public val getStencilModeName: MethodStringName0<BaseMaterial3D, StencilMode> =
        MethodStringName0<BaseMaterial3D, StencilMode>("get_stencil_mode")

    @JvmField
    public val setStencilFlagsName: MethodStringName1<BaseMaterial3D, Unit, Int> =
        MethodStringName1<BaseMaterial3D, Unit, Int>("set_stencil_flags")

    @JvmField
    public val getStencilFlagsName: MethodStringName0<BaseMaterial3D, Int> =
        MethodStringName0<BaseMaterial3D, Int>("get_stencil_flags")

    @JvmField
    public val setStencilCompareName: MethodStringName1<BaseMaterial3D, Unit, StencilCompare> =
        MethodStringName1<BaseMaterial3D, Unit, StencilCompare>("set_stencil_compare")

    @JvmField
    public val getStencilCompareName: MethodStringName0<BaseMaterial3D, StencilCompare> =
        MethodStringName0<BaseMaterial3D, StencilCompare>("get_stencil_compare")

    @JvmField
    public val setStencilReferenceName: MethodStringName1<BaseMaterial3D, Unit, Int> =
        MethodStringName1<BaseMaterial3D, Unit, Int>("set_stencil_reference")

    @JvmField
    public val getStencilReferenceName: MethodStringName0<BaseMaterial3D, Int> =
        MethodStringName0<BaseMaterial3D, Int>("get_stencil_reference")

    @JvmField
    public val setStencilEffectColorName: MethodStringName1<BaseMaterial3D, Unit, Color> =
        MethodStringName1<BaseMaterial3D, Unit, Color>("set_stencil_effect_color")

    @JvmField
    public val getStencilEffectColorName: MethodStringName0<BaseMaterial3D, Color> =
        MethodStringName0<BaseMaterial3D, Color>("get_stencil_effect_color")

    @JvmField
    public val setStencilEffectOutlineThicknessName: MethodStringName1<BaseMaterial3D, Unit, Float>
        = MethodStringName1<BaseMaterial3D, Unit, Float>("set_stencil_effect_outline_thickness")

    @JvmField
    public val getStencilEffectOutlineThicknessName: MethodStringName0<BaseMaterial3D, Float> =
        MethodStringName0<BaseMaterial3D, Float>("get_stencil_effect_outline_thickness")
  }

  public object MethodBindings {
    internal val setAlbedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_albedo", 2920490490)

    internal val getAlbedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_albedo", 3444240500)

    internal val setTransparencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_transparency", 3435651667)

    internal val getTransparencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_transparency", 990903061)

    internal val setAlphaAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_alpha_antialiasing", 3212649852)

    internal val getAlphaAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_alpha_antialiasing", 2889939400)

    internal val setAlphaAntialiasingEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_alpha_antialiasing_edge", 373806689)

    internal val getAlphaAntialiasingEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_alpha_antialiasing_edge", 1740695150)

    internal val setShadingModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_shading_mode", 3368750322)

    internal val getShadingModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_shading_mode", 2132070559)

    internal val setSpecularPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_specular", 373806689)

    internal val getSpecularPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_specular", 1740695150)

    internal val setMetallicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_metallic", 373806689)

    internal val getMetallicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_metallic", 1740695150)

    internal val setRoughnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_roughness", 373806689)

    internal val getRoughnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_roughness", 1740695150)

    internal val setEmissionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_emission", 2920490490)

    internal val getEmissionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_emission", 3444240500)

    internal val setEmissionEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_emission_energy_multiplier", 373806689)

    internal val getEmissionEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_emission_energy_multiplier", 1740695150)

    internal val setEmissionIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_emission_intensity", 373806689)

    internal val getEmissionIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_emission_intensity", 1740695150)

    internal val setNormalScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_normal_scale", 373806689)

    internal val getNormalScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_normal_scale", 1740695150)

    internal val setRimPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_rim", 373806689)

    internal val getRimPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_rim", 1740695150)

    internal val setRimTintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_rim_tint", 373806689)

    internal val getRimTintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_rim_tint", 1740695150)

    internal val setClearcoatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_clearcoat", 373806689)

    internal val getClearcoatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_clearcoat", 1740695150)

    internal val setClearcoatRoughnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_clearcoat_roughness", 373806689)

    internal val getClearcoatRoughnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_clearcoat_roughness", 1740695150)

    internal val setAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_anisotropy", 373806689)

    internal val getAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_anisotropy", 1740695150)

    internal val setHeightmapScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_heightmap_scale", 373806689)

    internal val getHeightmapScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_heightmap_scale", 1740695150)

    internal val setSubsurfaceScatteringStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_subsurface_scattering_strength", 373806689)

    internal val getSubsurfaceScatteringStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_subsurface_scattering_strength", 1740695150)

    internal val setTransmittanceColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_transmittance_color", 2920490490)

    internal val getTransmittanceColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_transmittance_color", 3444240500)

    internal val setTransmittanceDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_transmittance_depth", 373806689)

    internal val getTransmittanceDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_transmittance_depth", 1740695150)

    internal val setTransmittanceBoostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_transmittance_boost", 373806689)

    internal val getTransmittanceBoostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_transmittance_boost", 1740695150)

    internal val setBacklightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_backlight", 2920490490)

    internal val getBacklightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_backlight", 3444240500)

    internal val setRefractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_refraction", 373806689)

    internal val getRefractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_refraction", 1740695150)

    internal val setPointSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_point_size", 373806689)

    internal val getPointSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_point_size", 1740695150)

    internal val setDetailUvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_detail_uv", 456801921)

    internal val getDetailUvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_detail_uv", 2306920512)

    internal val setBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_blend_mode", 2830186259)

    internal val getBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_blend_mode", 4022690962)

    internal val setDepthDrawModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_depth_draw_mode", 1456584748)

    internal val getDepthDrawModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_depth_draw_mode", 2578197639)

    internal val setDepthTestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_depth_test", 3918692338)

    internal val getDepthTestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_depth_test", 3434785811)

    internal val setCullModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_cull_mode", 2338909218)

    internal val getCullModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_cull_mode", 1941499586)

    internal val setDiffuseModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_diffuse_mode", 1045299638)

    internal val getDiffuseModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_diffuse_mode", 3973617136)

    internal val setSpecularModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_specular_mode", 584737147)

    internal val getSpecularModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_specular_mode", 2569953298)

    internal val setFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_flag", 3070159527)

    internal val getFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_flag", 1286410065)

    internal val setTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_texture_filter", 22904437)

    internal val getTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_texture_filter", 3289213076)

    internal val setFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_feature", 2819288693)

    internal val getFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_feature", 1965241794)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_texture", 464208135)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_texture", 329605813)

    internal val setDetailBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_detail_blend_mode", 2830186259)

    internal val getDetailBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_detail_blend_mode", 4022690962)

    internal val setUv1ScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_uv1_scale", 3460891852)

    internal val getUv1ScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_uv1_scale", 3360562783)

    internal val setUv1OffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_uv1_offset", 3460891852)

    internal val getUv1OffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_uv1_offset", 3360562783)

    internal val setUv1TriplanarBlendSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_uv1_triplanar_blend_sharpness", 373806689)

    internal val getUv1TriplanarBlendSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_uv1_triplanar_blend_sharpness", 1740695150)

    internal val setUv2ScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_uv2_scale", 3460891852)

    internal val getUv2ScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_uv2_scale", 3360562783)

    internal val setUv2OffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_uv2_offset", 3460891852)

    internal val getUv2OffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_uv2_offset", 3360562783)

    internal val setUv2TriplanarBlendSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_uv2_triplanar_blend_sharpness", 373806689)

    internal val getUv2TriplanarBlendSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_uv2_triplanar_blend_sharpness", 1740695150)

    internal val setBillboardModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_billboard_mode", 4202036497)

    internal val getBillboardModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_billboard_mode", 1283840139)

    internal val setParticlesAnimHFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_particles_anim_h_frames", 1286410249)

    internal val getParticlesAnimHFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_particles_anim_h_frames", 3905245786)

    internal val setParticlesAnimVFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_particles_anim_v_frames", 1286410249)

    internal val getParticlesAnimVFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_particles_anim_v_frames", 3905245786)

    internal val setParticlesAnimLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_particles_anim_loop", 2586408642)

    internal val getParticlesAnimLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_particles_anim_loop", 36873697)

    internal val setHeightmapDeepParallaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_heightmap_deep_parallax", 2586408642)

    internal val isHeightmapDeepParallaxEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "is_heightmap_deep_parallax_enabled", 36873697)

    internal val setHeightmapDeepParallaxMinLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_heightmap_deep_parallax_min_layers", 1286410249)

    internal val getHeightmapDeepParallaxMinLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_heightmap_deep_parallax_min_layers", 3905245786)

    internal val setHeightmapDeepParallaxMaxLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_heightmap_deep_parallax_max_layers", 1286410249)

    internal val getHeightmapDeepParallaxMaxLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_heightmap_deep_parallax_max_layers", 3905245786)

    internal val setHeightmapDeepParallaxFlipTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_heightmap_deep_parallax_flip_tangent", 2586408642)

    internal val getHeightmapDeepParallaxFlipTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_heightmap_deep_parallax_flip_tangent", 36873697)

    internal val setHeightmapDeepParallaxFlipBinormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_heightmap_deep_parallax_flip_binormal", 2586408642)

    internal val getHeightmapDeepParallaxFlipBinormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_heightmap_deep_parallax_flip_binormal", 36873697)

    internal val setGrowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_grow", 373806689)

    internal val getGrowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_grow", 1740695150)

    internal val setEmissionOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_emission_operator", 3825128922)

    internal val getEmissionOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_emission_operator", 974205018)

    internal val setAoLightAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_ao_light_affect", 373806689)

    internal val getAoLightAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_ao_light_affect", 1740695150)

    internal val setAlphaScissorThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_alpha_scissor_threshold", 373806689)

    internal val getAlphaScissorThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_alpha_scissor_threshold", 1740695150)

    internal val setAlphaHashScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_alpha_hash_scale", 373806689)

    internal val getAlphaHashScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_alpha_hash_scale", 1740695150)

    internal val setGrowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_grow_enabled", 2586408642)

    internal val isGrowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "is_grow_enabled", 36873697)

    internal val setMetallicTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_metallic_texture_channel", 744167988)

    internal val getMetallicTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_metallic_texture_channel", 568133867)

    internal val setRoughnessTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_roughness_texture_channel", 744167988)

    internal val getRoughnessTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_roughness_texture_channel", 568133867)

    internal val setAoTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_ao_texture_channel", 744167988)

    internal val getAoTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_ao_texture_channel", 568133867)

    internal val setRefractionTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_refraction_texture_channel", 744167988)

    internal val getRefractionTextureChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_refraction_texture_channel", 568133867)

    internal val setProximityFadeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_proximity_fade_enabled", 2586408642)

    internal val isProximityFadeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "is_proximity_fade_enabled", 36873697)

    internal val setProximityFadeDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_proximity_fade_distance", 373806689)

    internal val getProximityFadeDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_proximity_fade_distance", 1740695150)

    internal val setMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_msdf_pixel_range", 373806689)

    internal val getMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_msdf_pixel_range", 1740695150)

    internal val setMsdfOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_msdf_outline_size", 373806689)

    internal val getMsdfOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_msdf_outline_size", 1740695150)

    internal val setDistanceFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_distance_fade", 1379478617)

    internal val getDistanceFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_distance_fade", 2694575734)

    internal val setDistanceFadeMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_distance_fade_max_distance", 373806689)

    internal val getDistanceFadeMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_distance_fade_max_distance", 1740695150)

    internal val setDistanceFadeMinDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_distance_fade_min_distance", 373806689)

    internal val getDistanceFadeMinDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_distance_fade_min_distance", 1740695150)

    internal val setZClipScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_z_clip_scale", 373806689)

    internal val getZClipScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_z_clip_scale", 1740695150)

    internal val setFovOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_fov_override", 373806689)

    internal val getFovOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_fov_override", 1740695150)

    internal val setStencilModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_stencil_mode", 2272367200)

    internal val getStencilModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_stencil_mode", 2908443456)

    internal val setStencilFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_stencil_flags", 1286410249)

    internal val getStencilFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_stencil_flags", 3905245786)

    internal val setStencilComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_stencil_compare", 3741726481)

    internal val getStencilComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_stencil_compare", 2824600492)

    internal val setStencilReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_stencil_reference", 1286410249)

    internal val getStencilReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_stencil_reference", 3905245786)

    internal val setStencilEffectColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_stencil_effect_color", 2920490490)

    internal val getStencilEffectColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_stencil_effect_color", 3444240500)

    internal val setStencilEffectOutlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "set_stencil_effect_outline_thickness", 373806689)

    internal val getStencilEffectOutlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseMaterial3D", "get_stencil_effect_outline_thickness", 1740695150)
  }
}
