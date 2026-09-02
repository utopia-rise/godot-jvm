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
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Resource for environment nodes (like [WorldEnvironment]) that define multiple environment
 * operations (such as background [Sky] or [Color], ambient light, fog, depth-of-field...). These
 * parameters affect the final render of the scene. The order of these operations is:
 *
 * - Depth of Field Blur
 *
 * - Auto Exposure
 *
 * - Glow
 *
 * - Tonemap
 *
 * - Adjustments
 */
@GodotBaseType
public open class Environment : Resource() {
  /**
   * The background mode.
   */
  public final inline var backgroundMode: BGMode
    @JvmName("backgroundModeProperty")
    get() = getBackground()
    @JvmName("backgroundModeProperty")
    set(`value`) {
      setBackground(value)
    }

  /**
   * The [Color] displayed for clear areas of the scene. Only effective when using the [BG_COLOR]
   * background mode.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var backgroundColor: Color
    @JvmName("backgroundColorProperty")
    get() = getBgColor()
    @JvmName("backgroundColorProperty")
    set(`value`) {
      setBgColor(value)
    }

  /**
   * Multiplier for background energy. Increase to make background brighter, decrease to make
   * background dimmer.
   */
  public final inline var backgroundEnergyMultiplier: Float
    @JvmName("backgroundEnergyMultiplierProperty")
    get() = getBgEnergyMultiplier()
    @JvmName("backgroundEnergyMultiplierProperty")
    set(`value`) {
      setBgEnergyMultiplier(value)
    }

  /**
   * Luminance of background measured in nits (candela per square meter). Only used when
   * [ProjectSettings.rendering/lightsAndShadows/usePhysicalLightUnits] is enabled. The default value
   * is roughly equivalent to the sky at midday.
   */
  public final inline var backgroundIntensity: Float
    @JvmName("backgroundIntensityProperty")
    get() = getBgIntensity()
    @JvmName("backgroundIntensityProperty")
    set(`value`) {
      setBgIntensity(value)
    }

  /**
   * The maximum layer ID to display. Only effective when using the [BG_CANVAS] background mode.
   */
  public final inline var backgroundCanvasMaxLayer: Int
    @JvmName("backgroundCanvasMaxLayerProperty")
    get() = getCanvasMaxLayer()
    @JvmName("backgroundCanvasMaxLayerProperty")
    set(`value`) {
      setCanvasMaxLayer(value)
    }

  /**
   * The ID of the camera feed to show in the background.
   */
  public final inline var backgroundCameraFeedId: Int
    @JvmName("backgroundCameraFeedIdProperty")
    get() = getCameraFeedId()
    @JvmName("backgroundCameraFeedIdProperty")
    set(`value`) {
      setCameraFeedId(value)
    }

  /**
   * The [Sky] resource used for this [Environment].
   */
  public final inline var sky: Sky?
    @JvmName("skyProperty")
    get() = getSky()
    @JvmName("skyProperty")
    set(`value`) {
      setSky(value)
    }

  /**
   * If set to a value greater than `0.0`, overrides the field of view to use for sky rendering. If
   * set to `0.0`, the same FOV as the current [Camera3D] is used for sky rendering.
   */
  public final inline var skyCustomFov: Float
    @JvmName("skyCustomFovProperty")
    get() = getSkyCustomFov()
    @JvmName("skyCustomFovProperty")
    set(`value`) {
      setSkyCustomFov(value)
    }

  /**
   * The rotation to use for sky rendering.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var skyRotation: Vector3
    @JvmName("skyRotationProperty")
    get() = getSkyRotation()
    @JvmName("skyRotationProperty")
    set(`value`) {
      setSkyRotation(value)
    }

  /**
   * The ambient light source to use for rendering materials and global illumination.
   */
  public final inline var ambientLightSource: AmbientSource
    @JvmName("ambientLightSourceProperty")
    get() = getAmbientSource()
    @JvmName("ambientLightSourceProperty")
    set(`value`) {
      setAmbientSource(value)
    }

  /**
   * The ambient light's [Color]. Only effective if [ambientLightSkyContribution] is lower than
   * `1.0` (exclusive).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var ambientLightColor: Color
    @JvmName("ambientLightColorProperty")
    get() = getAmbientLightColor()
    @JvmName("ambientLightColorProperty")
    set(`value`) {
      setAmbientLightColor(value)
    }

  /**
   * Defines the amount of light that the sky brings on the scene. A value of `0.0` means that the
   * sky's light emission has no effect on the scene illumination, thus all ambient illumination is
   * provided by the ambient light. On the contrary, a value of `1.0` means that *all* the light that
   * affects the scene is provided by the sky, thus the ambient light parameter has no effect on the
   * scene.
   *
   * **Note:** [ambientLightSkyContribution] is internally clamped between `0.0` and `1.0`
   * (inclusive).
   */
  public final inline var ambientLightSkyContribution: Float
    @JvmName("ambientLightSkyContributionProperty")
    get() = getAmbientLightSkyContribution()
    @JvmName("ambientLightSkyContributionProperty")
    set(`value`) {
      setAmbientLightSkyContribution(value)
    }

  /**
   * The ambient light's energy. The higher the value, the stronger the light. Only effective if
   * [ambientLightSkyContribution] is lower than `1.0` (exclusive).
   */
  public final inline var ambientLightEnergy: Float
    @JvmName("ambientLightEnergyProperty")
    get() = getAmbientLightEnergy()
    @JvmName("ambientLightEnergyProperty")
    set(`value`) {
      setAmbientLightEnergy(value)
    }

  /**
   * The reflected (specular) light source.
   */
  public final inline var reflectedLightSource: ReflectionSource
    @JvmName("reflectedLightSourceProperty")
    get() = getReflectionSource()
    @JvmName("reflectedLightSourceProperty")
    set(`value`) {
      setReflectionSource(value)
    }

  /**
   * The tonemapping mode to use. Tonemapping is the process that "converts" HDR values to be
   * suitable for rendering on an LDR display. (Godot doesn't support rendering on HDR displays yet.)
   */
  public final inline var tonemapMode: ToneMapper
    @JvmName("tonemapModeProperty")
    get() = getTonemapper()
    @JvmName("tonemapModeProperty")
    set(`value`) {
      setTonemapper(value)
    }

  /**
   * Adjusts the brightness of values before they are provided to the tonemapper. Higher
   * [tonemapExposure] values result in a brighter image. See also [tonemapWhite].
   *
   * **Note:** Values provided to the tonemapper will also be multiplied by `2.0` and `1.8` for
   * [TONE_MAPPER_FILMIC] and [TONE_MAPPER_ACES] respectively to produce a similar apparent brightness
   * as [TONE_MAPPER_LINEAR].
   */
  public final inline var tonemapExposure: Float
    @JvmName("tonemapExposureProperty")
    get() = getTonemapExposure()
    @JvmName("tonemapExposureProperty")
    set(`value`) {
      setTonemapExposure(value)
    }

  /**
   * The white reference value for tonemapping, which indicates where bright white is located in the
   * scale of values provided to the tonemapper. For photorealistic lighting, it is recommended to set
   * [tonemapWhite] to at least `6.0`. Higher values result in less blown out highlights, but may make
   * the scene appear lower contrast. [tonemapAgxWhite] will be used instead when using the
   * [TONE_MAPPER_AGX] tonemapper. See also [tonemapExposure].
   *
   * **Note:** [tonemapWhite] must be set to `2.0` or lower on the Mobile renderer to produce bright
   * images.
   *
   * **Note:** [tonemapWhite] is ignored when using [TONE_MAPPER_LINEAR] and will be dynamically
   * adjusted at runtime to never be less than the parent window's [Window.getOutputMaxLinearValue]
   * when using [TONE_MAPPER_REINHARDT] with [Viewport.useHdr2d].
   */
  public final inline var tonemapWhite: Float
    @JvmName("tonemapWhiteProperty")
    get() = getTonemapWhite()
    @JvmName("tonemapWhiteProperty")
    set(`value`) {
      setTonemapWhite(value)
    }

  /**
   * The white reference value for tonemapping, which indicates where bright white is located in the
   * scale of values provided to the tonemapper. For photorealistic lighting, it is recommended to set
   * [tonemapAgxWhite] to at least `6.0`. Higher values result in less blown out highlights, but may
   * make the scene appear lower contrast. [tonemapAgxWhite] is the same as [tonemapWhite], but is only
   * effective with the [TONE_MAPPER_AGX] tonemapper. See also [tonemapExposure].
   *
   * **Note:** When using the Mobile renderer with [Viewport.useHdr2d] disabled, [tonemapAgxWhite]
   * is ignored and a white value of `2.0` will always be used instead. Otherwise, [tonemapAgxWhite]
   * will be dynamically adjusted at runtime by multiplying it by the parent window's
   * [Window.getOutputMaxLinearValue] when using [Viewport.useHdr2d] to ensure good behavior with both
   * SDR and HDR output.
   */
  public final inline var tonemapAgxWhite: Float
    @JvmName("tonemapAgxWhiteProperty")
    get() = getTonemapAgxWhite()
    @JvmName("tonemapAgxWhiteProperty")
    set(`value`) {
      setTonemapAgxWhite(value)
    }

  /**
   * Increasing [tonemapAgxContrast] will make dark values darker and bright values brighter.
   * Produces a higher quality result than [adjustmentContrast] without any additional performance
   * cost, but is only available when using the [TONE_MAPPER_AGX] tonemapper.
   */
  public final inline var tonemapAgxContrast: Float
    @JvmName("tonemapAgxContrastProperty")
    get() = getTonemapAgxContrast()
    @JvmName("tonemapAgxContrastProperty")
    set(`value`) {
      setTonemapAgxContrast(value)
    }

  /**
   * If `true`, screen-space reflections are enabled. Screen-space reflections are more accurate
   * than reflections from [VoxelGI]s or [ReflectionProbe]s, but are slower and can't reflect surfaces
   * occluded by others.
   *
   * **Note:** SSR is only supported in the Forward+ rendering method, not Mobile or Compatibility.
   *
   * **Note:** SSR is not supported on viewports that have a transparent background (where
   * [Viewport.transparentBg] is `true`).
   */
  public final inline var ssrEnabled: Boolean
    @JvmName("ssrEnabledProperty")
    get() = isSsrEnabled()
    @JvmName("ssrEnabledProperty")
    set(`value`) {
      setSsrEnabled(value)
    }

  /**
   * The maximum number of steps for screen-space reflections. Higher values are slower.
   */
  public final inline var ssrMaxSteps: Int
    @JvmName("ssrMaxStepsProperty")
    get() = getSsrMaxSteps()
    @JvmName("ssrMaxStepsProperty")
    set(`value`) {
      setSsrMaxSteps(value)
    }

  /**
   * The fade-in distance for screen-space reflections. Affects the area from the reflected material
   * to the screen-space reflection. Only positive values are valid (negative values will be clamped to
   * `0.0`).
   */
  public final inline var ssrFadeIn: Float
    @JvmName("ssrFadeInProperty")
    get() = getSsrFadeIn()
    @JvmName("ssrFadeInProperty")
    set(`value`) {
      setSsrFadeIn(value)
    }

  /**
   * The fade-out distance for screen-space reflections. Affects the area from the screen-space
   * reflection to the "global" reflection. Only positive values are valid (negative values will be
   * clamped to `0.0`).
   */
  public final inline var ssrFadeOut: Float
    @JvmName("ssrFadeOutProperty")
    get() = getSsrFadeOut()
    @JvmName("ssrFadeOutProperty")
    set(`value`) {
      setSsrFadeOut(value)
    }

  /**
   * The depth tolerance for screen-space reflections.
   */
  public final inline var ssrDepthTolerance: Float
    @JvmName("ssrDepthToleranceProperty")
    get() = getSsrDepthTolerance()
    @JvmName("ssrDepthToleranceProperty")
    set(`value`) {
      setSsrDepthTolerance(value)
    }

  /**
   * If `true`, the screen-space ambient occlusion effect is enabled. This darkens objects' corners
   * and cavities to simulate ambient light not reaching the entire object as in real life. This works
   * well for small, dynamic objects, but baked lighting or ambient occlusion textures will do a better
   * job at displaying ambient occlusion on large static objects. Godot uses a form of SSAO called
   * Adaptive Screen Space Ambient Occlusion which is itself a form of Horizon Based Ambient Occlusion.
   *
   * **Note:** SSAO is only supported in the Forward+ and Compatibility rendering methods, not
   * Mobile.
   */
  public final inline var ssaoEnabled: Boolean
    @JvmName("ssaoEnabledProperty")
    get() = isSsaoEnabled()
    @JvmName("ssaoEnabledProperty")
    set(`value`) {
      setSsaoEnabled(value)
    }

  /**
   * The distance at which objects can occlude each other when calculating screen-space ambient
   * occlusion. Higher values will result in occlusion over a greater distance at the cost of
   * performance and quality.
   */
  public final inline var ssaoRadius: Float
    @JvmName("ssaoRadiusProperty")
    get() = getSsaoRadius()
    @JvmName("ssaoRadiusProperty")
    set(`value`) {
      setSsaoRadius(value)
    }

  /**
   * The primary screen-space ambient occlusion intensity. Acts as a multiplier for the screen-space
   * ambient occlusion effect. A higher value results in darker occlusion.
   */
  public final inline var ssaoIntensity: Float
    @JvmName("ssaoIntensityProperty")
    get() = getSsaoIntensity()
    @JvmName("ssaoIntensityProperty")
    set(`value`) {
      setSsaoIntensity(value)
    }

  /**
   * The distribution of occlusion. A higher value results in darker occlusion, similar to
   * [ssaoIntensity], but with a sharper falloff.
   */
  public final inline var ssaoPower: Float
    @JvmName("ssaoPowerProperty")
    get() = getSsaoPower()
    @JvmName("ssaoPowerProperty")
    set(`value`) {
      setSsaoPower(value)
    }

  /**
   * Sets the strength of the additional level of detail for the screen-space ambient occlusion
   * effect. A high value makes the detail pass more prominent, but it may contribute to aliasing in
   * your final image.
   */
  public final inline var ssaoDetail: Float
    @JvmName("ssaoDetailProperty")
    get() = getSsaoDetail()
    @JvmName("ssaoDetailProperty")
    set(`value`) {
      setSsaoDetail(value)
    }

  /**
   * The threshold for considering whether a given point on a surface is occluded or not represented
   * as an angle from the horizon mapped into the `0.0-1.0` range. A value of `1.0` results in no
   * occlusion.
   */
  public final inline var ssaoHorizon: Float
    @JvmName("ssaoHorizonProperty")
    get() = getSsaoHorizon()
    @JvmName("ssaoHorizonProperty")
    set(`value`) {
      setSsaoHorizon(value)
    }

  /**
   * The amount that the screen-space ambient occlusion effect is allowed to blur over the edges of
   * objects. Setting too high will result in aliasing around the edges of objects. Setting too low
   * will make object edges appear blurry.
   */
  public final inline var ssaoSharpness: Float
    @JvmName("ssaoSharpnessProperty")
    get() = getSsaoSharpness()
    @JvmName("ssaoSharpnessProperty")
    set(`value`) {
      setSsaoSharpness(value)
    }

  /**
   * The screen-space ambient occlusion intensity in direct light. In real life, ambient occlusion
   * only applies to indirect light, which means its effects can't be seen in direct light. Values
   * higher than `0` will make the SSAO effect visible in direct light.
   */
  public final inline var ssaoLightAffect: Float
    @JvmName("ssaoLightAffectProperty")
    get() = getSsaoDirectLightAffect()
    @JvmName("ssaoLightAffectProperty")
    set(`value`) {
      setSsaoDirectLightAffect(value)
    }

  /**
   * The screen-space ambient occlusion intensity on materials that have an AO texture defined.
   * Values higher than `0` will make the SSAO effect visible in areas darkened by AO textures.
   */
  public final inline var ssaoAoChannelAffect: Float
    @JvmName("ssaoAoChannelAffectProperty")
    get() = getSsaoAoChannelAffect()
    @JvmName("ssaoAoChannelAffectProperty")
    set(`value`) {
      setSsaoAoChannelAffect(value)
    }

  /**
   * If `true`, the screen-space indirect lighting effect is enabled. Screen space indirect lighting
   * is a form of indirect lighting that allows diffuse light to bounce between nearby objects.
   * Screen-space indirect lighting works very similarly to screen-space ambient occlusion, in that it
   * only affects a limited range. It is intended to be used along with a form of proper global
   * illumination like SDFGI or [VoxelGI]. Screen-space indirect lighting is not affected by individual
   * light's [Light3D.lightIndirectEnergy].
   *
   * **Note:** SSIL is only supported in the Forward+ rendering method, not Mobile or Compatibility.
   */
  public final inline var ssilEnabled: Boolean
    @JvmName("ssilEnabledProperty")
    get() = isSsilEnabled()
    @JvmName("ssilEnabledProperty")
    set(`value`) {
      setSsilEnabled(value)
    }

  /**
   * The distance that bounced lighting can travel when using the screen space indirect lighting
   * effect. A larger value will result in light bouncing further in a scene, but may result in
   * under-sampling artifacts which look like long spikes surrounding light sources.
   */
  public final inline var ssilRadius: Float
    @JvmName("ssilRadiusProperty")
    get() = getSsilRadius()
    @JvmName("ssilRadiusProperty")
    set(`value`) {
      setSsilRadius(value)
    }

  /**
   * The brightness multiplier for the screen-space indirect lighting effect. A higher value will
   * result in brighter light.
   */
  public final inline var ssilIntensity: Float
    @JvmName("ssilIntensityProperty")
    get() = getSsilIntensity()
    @JvmName("ssilIntensityProperty")
    set(`value`) {
      setSsilIntensity(value)
    }

  /**
   * The amount that the screen-space indirect lighting effect is allowed to blur over the edges of
   * objects. Setting too high will result in aliasing around the edges of objects. Setting too low
   * will make object edges appear blurry.
   */
  public final inline var ssilSharpness: Float
    @JvmName("ssilSharpnessProperty")
    get() = getSsilSharpness()
    @JvmName("ssilSharpnessProperty")
    set(`value`) {
      setSsilSharpness(value)
    }

  /**
   * Amount of normal rejection used when calculating screen-space indirect lighting. Normal
   * rejection uses the normal of a given sample point to reject samples that are facing away from the
   * current pixel. Normal rejection is necessary to avoid light leaking when only one side of an
   * object is illuminated. However, normal rejection can be disabled if light leaking is desirable,
   * such as when the scene mostly contains emissive objects that emit light from faces that cannot be
   * seen from the camera.
   */
  public final inline var ssilNormalRejection: Float
    @JvmName("ssilNormalRejectionProperty")
    get() = getSsilNormalRejection()
    @JvmName("ssilNormalRejectionProperty")
    set(`value`) {
      setSsilNormalRejection(value)
    }

  /**
   * If `true`, enables signed distance field global illumination for meshes that have their
   * [GeometryInstance3D.giMode] set to [GeometryInstance3D.GI_MODE_STATIC]. SDFGI is a real-time
   * global illumination technique that works well with procedurally generated and user-built levels,
   * including in situations where geometry is created during gameplay. The signed distance field is
   * automatically generated around the camera as it moves. Dynamic lights are supported, but dynamic
   * occluders and emissive surfaces are not.
   *
   * **Note:** SDFGI is only supported in the Forward+ rendering method, not Mobile or
   * Compatibility.
   *
   * **Performance:** SDFGI is relatively demanding on the GPU and is not suited to low-end hardware
   * such as integrated graphics (consider [LightmapGI] instead). To improve SDFGI performance, enable
   * [ProjectSettings.rendering/globalIllumination/gi/useHalfResolution] in the Project Settings.
   *
   * **Note:** Meshes should have sufficiently thick walls to avoid light leaks (avoid one-sided
   * walls). For interior levels, enclose your level geometry in a sufficiently large box and bridge
   * the loops to close the mesh.
   */
  public final inline var sdfgiEnabled: Boolean
    @JvmName("sdfgiEnabledProperty")
    get() = isSdfgiEnabled()
    @JvmName("sdfgiEnabledProperty")
    set(`value`) {
      setSdfgiEnabled(value)
    }

  /**
   * If `true`, SDFGI uses an occlusion detection approach to reduce light leaking. Occlusion may
   * however introduce dark blotches in certain spots, which may be undesired in mostly outdoor scenes.
   * [sdfgiUseOcclusion] has a performance impact and should only be enabled when needed.
   */
  public final inline var sdfgiUseOcclusion: Boolean
    @JvmName("sdfgiUseOcclusionProperty")
    get() = isSdfgiUsingOcclusion()
    @JvmName("sdfgiUseOcclusionProperty")
    set(`value`) {
      setSdfgiUseOcclusion(value)
    }

  /**
   * If `true`, SDFGI takes the environment lighting into account. This should be set to `false` for
   * interior scenes.
   */
  public final inline var sdfgiReadSkyLight: Boolean
    @JvmName("sdfgiReadSkyLightProperty")
    get() = isSdfgiReadingSkyLight()
    @JvmName("sdfgiReadSkyLightProperty")
    set(`value`) {
      setSdfgiReadSkyLight(value)
    }

  /**
   * The energy multiplier applied to light every time it bounces from a surface when using SDFGI.
   * Values greater than `0.0` will simulate multiple bounces, resulting in a more realistic
   * appearance. Increasing [sdfgiBounceFeedback] generally has no performance impact. See also
   * [sdfgiEnergy].
   *
   * **Note:** Values greater than `0.5` can cause infinite feedback loops and should be avoided in
   * scenes with bright materials.
   *
   * **Note:** If [sdfgiBounceFeedback] is `0.0`, indirect lighting will not be represented in
   * reflections as light will only bounce one time.
   */
  public final inline var sdfgiBounceFeedback: Float
    @JvmName("sdfgiBounceFeedbackProperty")
    get() = getSdfgiBounceFeedback()
    @JvmName("sdfgiBounceFeedbackProperty")
    set(`value`) {
      setSdfgiBounceFeedback(value)
    }

  /**
   * The number of cascades to use for SDFGI (between 1 and 8). A higher number of cascades allows
   * displaying SDFGI further away while preserving detail up close, at the cost of performance. When
   * using SDFGI on small-scale levels, [sdfgiCascades] can often be decreased between `1` and `4` to
   * improve performance.
   */
  public final inline var sdfgiCascades: Int
    @JvmName("sdfgiCascadesProperty")
    get() = getSdfgiCascades()
    @JvmName("sdfgiCascadesProperty")
    set(`value`) {
      setSdfgiCascades(value)
    }

  /**
   * The cell size to use for the closest SDFGI cascade (in 3D units). Lower values allow SDFGI to
   * be more precise up close, at the cost of making SDFGI updates more demanding. This can cause
   * stuttering when the camera moves fast. Higher values allow SDFGI to cover more ground, while also
   * reducing the performance impact of SDFGI updates.
   *
   * **Note:** This property is linked to [sdfgiMaxDistance] and [sdfgiCascade0Distance]. Changing
   * its value will automatically change those properties as well.
   */
  public final inline var sdfgiMinCellSize: Float
    @JvmName("sdfgiMinCellSizeProperty")
    get() = getSdfgiMinCellSize()
    @JvmName("sdfgiMinCellSizeProperty")
    set(`value`) {
      setSdfgiMinCellSize(value)
    }

  /**
   * **Note:** This property is linked to [sdfgiMinCellSize] and [sdfgiMaxDistance]. Changing its
   * value will automatically change those properties as well.
   */
  public final inline var sdfgiCascade0Distance: Float
    @JvmName("sdfgiCascade0DistanceProperty")
    get() = getSdfgiCascade0Distance()
    @JvmName("sdfgiCascade0DistanceProperty")
    set(`value`) {
      setSdfgiCascade0Distance(value)
    }

  /**
   * The maximum distance at which SDFGI is visible. Beyond this distance, environment lighting or
   * other sources of GI such as [ReflectionProbe] will be used as a fallback.
   *
   * **Note:** This property is linked to [sdfgiMinCellSize] and [sdfgiCascade0Distance]. Changing
   * its value will automatically change those properties as well.
   */
  public final inline var sdfgiMaxDistance: Float
    @JvmName("sdfgiMaxDistanceProperty")
    get() = getSdfgiMaxDistance()
    @JvmName("sdfgiMaxDistanceProperty")
    set(`value`) {
      setSdfgiMaxDistance(value)
    }

  /**
   * The Y scale to use for SDFGI cells. Lower values will result in SDFGI cells being packed
   * together more closely on the Y axis. This is used to balance between quality and covering a lot of
   * vertical ground. [sdfgiYScale] should be set depending on how vertical your scene is (and how fast
   * your camera may move on the Y axis).
   */
  public final inline var sdfgiYScale: SDFGIYScale
    @JvmName("sdfgiYScaleProperty")
    get() = getSdfgiYScale()
    @JvmName("sdfgiYScaleProperty")
    set(`value`) {
      setSdfgiYScale(value)
    }

  /**
   * The energy multiplier to use for SDFGI. Higher values will result in brighter indirect lighting
   * and reflections. See also [sdfgiBounceFeedback].
   */
  public final inline var sdfgiEnergy: Float
    @JvmName("sdfgiEnergyProperty")
    get() = getSdfgiEnergy()
    @JvmName("sdfgiEnergyProperty")
    set(`value`) {
      setSdfgiEnergy(value)
    }

  /**
   * The normal bias to use for SDFGI probes. Increasing this value can reduce visible streaking
   * artifacts on sloped surfaces, at the cost of increased light leaking.
   */
  public final inline var sdfgiNormalBias: Float
    @JvmName("sdfgiNormalBiasProperty")
    get() = getSdfgiNormalBias()
    @JvmName("sdfgiNormalBiasProperty")
    set(`value`) {
      setSdfgiNormalBias(value)
    }

  /**
   * The constant bias to use for SDFGI probes. Increasing this value can reduce visible streaking
   * artifacts on sloped surfaces, at the cost of increased light leaking.
   */
  public final inline var sdfgiProbeBias: Float
    @JvmName("sdfgiProbeBiasProperty")
    get() = getSdfgiProbeBias()
    @JvmName("sdfgiProbeBiasProperty")
    set(`value`) {
      setSdfgiProbeBias(value)
    }

  /**
   * If `true`, the glow effect is enabled. This simulates real world atmosphere and eye/camera
   * behavior by causing bright pixels to bleed onto surrounding pixels.
   *
   * **Note:** When using the Mobile rendering method, glow looks different due to the lower dynamic
   * range available in the Mobile rendering method.
   *
   * **Note:** When using the Compatibility rendering method, glow uses a different implementation
   * with some properties being unavailable and hidden from the inspector: `glow_levels&#47;*`,
   * [glowNormalized], [glowStrength], [glowBlendMode], [glowMix], [glowMap], and [glowMapStrength].
   * This implementation is optimized to run on low-end devices and is less flexible as a result.
   */
  public final inline var glowEnabled: Boolean
    @JvmName("glowEnabledProperty")
    get() = isGlowEnabled()
    @JvmName("glowEnabledProperty")
    set(`value`) {
      setGlowEnabled(value)
    }

  /**
   * If `true`, glow levels will be normalized so that summed together their intensities equal
   * `1.0`.
   *
   * **Note:** [glowNormalized] has no effect when using the Compatibility rendering method, due to
   * this rendering method using a simpler glow implementation optimized for low-end devices.
   */
  public final inline var glowNormalized: Boolean
    @JvmName("glowNormalizedProperty")
    get() = isGlowNormalized()
    @JvmName("glowNormalizedProperty")
    set(`value`) {
      setGlowNormalized(value)
    }

  /**
   * The overall brightness multiplier that is applied to the glow effect just before it is blended
   * with the scene. When using the Mobile rendering method (which only supports a lower dynamic range
   * up to `2.0`), this should be increased to `1.5` to compensate.
   */
  public final inline var glowIntensity: Float
    @JvmName("glowIntensityProperty")
    get() = getGlowIntensity()
    @JvmName("glowIntensityProperty")
    set(`value`) {
      setGlowIntensity(value)
    }

  /**
   * The strength that is used when blurring across the screen to generate the glow effect. This
   * affects the distance and intensity of the blur. When using the Mobile rendering method, this
   * should be increased to compensate for the lower dynamic range.
   *
   * **Note:** [glowStrength] has no effect when using the Compatibility rendering method, due to
   * this rendering method using a simpler glow implementation optimized for low-end devices.
   */
  public final inline var glowStrength: Float
    @JvmName("glowStrengthProperty")
    get() = getGlowStrength()
    @JvmName("glowStrengthProperty")
    set(`value`) {
      setGlowStrength(value)
    }

  /**
   * When using the [GLOW_BLEND_MODE_MIX] [glowBlendMode], this controls how much the source image
   * is blended with the glow layer. A value of `0.0` makes the glow rendering invisible, while a value
   * of `1.0` is equivalent to [GLOW_BLEND_MODE_REPLACE].
   *
   * **Note:** [glowMix] has no effect when using the Compatibility rendering method, due to this
   * rendering method using a simpler glow implementation optimized for low-end devices.
   */
  public final inline var glowMix: Float
    @JvmName("glowMixProperty")
    get() = getGlowMix()
    @JvmName("glowMixProperty")
    set(`value`) {
      setGlowMix(value)
    }

  /**
   * The bloom's intensity. If set to a value higher than `0`, this will make glow visible in areas
   * darker than the [glowHdrThreshold].
   */
  public final inline var glowBloom: Float
    @JvmName("glowBloomProperty")
    get() = getGlowBloom()
    @JvmName("glowBloomProperty")
    set(`value`) {
      setGlowBloom(value)
    }

  /**
   * The glow blending mode.
   *
   * **Note:** The Compatibility renderer always uses [GLOW_BLEND_MODE_SCREEN] and [glowBlendMode]
   * will have no effect.
   */
  public final inline var glowBlendMode: GlowBlendMode
    @JvmName("glowBlendModeProperty")
    get() = getGlowBlendMode()
    @JvmName("glowBlendModeProperty")
    set(`value`) {
      setGlowBlendMode(value)
    }

  /**
   * The lower threshold of the HDR glow. When using the Mobile rendering method (which only
   * supports a lower dynamic range up to `2.0`), this may need to be below `1.0` for glow to be
   * visible. A value of `0.9` works well in this case. This value also needs to be decreased below
   * `1.0` when using glow in 2D, as 2D rendering is performed in SDR.
   */
  public final inline var glowHdrThreshold: Float
    @JvmName("glowHdrThresholdProperty")
    get() = getGlowHdrBleedThreshold()
    @JvmName("glowHdrThresholdProperty")
    set(`value`) {
      setGlowHdrBleedThreshold(value)
    }

  /**
   * Smooths the transition between values that are below and above [glowHdrThreshold] by reducing
   * the amount of glow generated by values that are close to [glowHdrThreshold]. Values above
   * `glow_hdr_threshold + glow_hdr_scale` will not have glow reduced in this way.
   */
  public final inline var glowHdrScale: Float
    @JvmName("glowHdrScaleProperty")
    get() = getGlowHdrBleedScale()
    @JvmName("glowHdrScaleProperty")
    set(`value`) {
      setGlowHdrBleedScale(value)
    }

  /**
   * The higher threshold of the HDR glow. Areas brighter than this threshold will be clamped for
   * the purposes of the glow effect.
   */
  public final inline var glowHdrLuminanceCap: Float
    @JvmName("glowHdrLuminanceCapProperty")
    get() = getGlowHdrLuminanceCap()
    @JvmName("glowHdrLuminanceCapProperty")
    set(`value`) {
      setGlowHdrLuminanceCap(value)
    }

  /**
   * How strong of an influence the [glowMap] should have on the overall glow effect. A strength of
   * `0.0` means the glow map has no influence, while a strength of `1.0` means the glow map has full
   * influence.
   *
   * **Note:** If the glow map has black areas, a value of `1.0` can also turn off the glow effect
   * entirely in specific areas of the screen.
   *
   * **Note:** [glowMapStrength] has no effect when using the Compatibility rendering method, due to
   * this rendering method using a simpler glow implementation optimized for low-end devices.
   */
  public final inline var glowMapStrength: Float
    @JvmName("glowMapStrengthProperty")
    get() = getGlowMapStrength()
    @JvmName("glowMapStrengthProperty")
    set(`value`) {
      setGlowMapStrength(value)
    }

  /**
   * The texture that should be used as a glow map to *multiply* the resulting glow color according
   * to [glowMapStrength]. This can be used to create a "lens dirt" effect. The texture's RGB color
   * channels are used for modulation, but the alpha channel is ignored.
   *
   * **Note:** The texture will be stretched to fit the screen. Therefore, it's recommended to use a
   * texture with an aspect ratio that matches your project's base aspect ratio (typically 16:9).
   *
   * **Note:** [glowMap] has no effect when using the Compatibility rendering method, due to this
   * rendering method using a simpler glow implementation optimized for low-end devices.
   */
  public final inline var glowMap: Texture?
    @JvmName("glowMapProperty")
    get() = getGlowMap()
    @JvmName("glowMapProperty")
    set(`value`) {
      setGlowMap(value)
    }

  /**
   * If `true`, fog effects are enabled.
   */
  public final inline var fogEnabled: Boolean
    @JvmName("fogEnabledProperty")
    get() = isFogEnabled()
    @JvmName("fogEnabledProperty")
    set(`value`) {
      setFogEnabled(value)
    }

  /**
   * The fog mode.
   */
  public final inline var fogMode: FogMode
    @JvmName("fogModeProperty")
    get() = getFogMode()
    @JvmName("fogModeProperty")
    set(`value`) {
      setFogMode(value)
    }

  /**
   * The fog's color.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var fogLightColor: Color
    @JvmName("fogLightColorProperty")
    get() = getFogLightColor()
    @JvmName("fogLightColorProperty")
    set(`value`) {
      setFogLightColor(value)
    }

  /**
   * The fog's brightness. Higher values result in brighter fog.
   */
  public final inline var fogLightEnergy: Float
    @JvmName("fogLightEnergyProperty")
    get() = getFogLightEnergy()
    @JvmName("fogLightEnergyProperty")
    set(`value`) {
      setFogLightEnergy(value)
    }

  /**
   * If set above `0.0`, renders the scene's directional light(s) in the fog color depending on the
   * view angle. This can be used to give the impression that the sun is "piercing" through the fog.
   */
  public final inline var fogSunScatter: Float
    @JvmName("fogSunScatterProperty")
    get() = getFogSunScatter()
    @JvmName("fogSunScatterProperty")
    set(`value`) {
      setFogSunScatter(value)
    }

  /**
   * The fog density to be used. This is demonstrated in different ways depending on the [fogMode]
   * mode chosen:
   *
   * **Exponential Fog Mode:** Higher values result in denser fog. The fog rendering is exponential
   * like in real life.
   *
   * **Depth Fog mode:** The maximum intensity of the deep fog, effect will appear in the distance
   * (relative to the camera). At `1.0` the fog will fully obscure the scene, at `0.0` the fog will not
   * be visible.
   */
  public final inline var fogDensity: Float
    @JvmName("fogDensityProperty")
    get() = getFogDensity()
    @JvmName("fogDensityProperty")
    set(`value`) {
      setFogDensity(value)
    }

  /**
   * If set above `0.0` (exclusive), blends between the fog's color and the color of the background
   * [Sky], as read from the radiance cubemap. This has a small performance cost when set above `0.0`.
   * Must have [backgroundMode] set to [BG_SKY].
   *
   * This is useful to simulate [url=https://en.wikipedia.org/wiki/Aerial_perspective]aerial
   * perspective[/url] in large scenes with low density fog. However, it is not very useful for
   * high-density fog, as the sky will shine through. When set to `1.0`, the fog color comes completely
   * from the [Sky]. If set to `0.0`, aerial perspective is disabled.
   *
   * Notice that this does not sample the [Sky] directly, but rather the radiance cubemap. The
   * cubemap is sampled at a mipmap level depending on the depth of the rendered pixel; the farther
   * away, the higher the resolution of the sampled mipmap. This results in the actual color being a
   * blurred version of the sky, with more blur closer to the camera. The highest mipmap resolution is
   * used at a depth of [Camera3D.far].
   */
  public final inline var fogAerialPerspective: Float
    @JvmName("fogAerialPerspectiveProperty")
    get() = getFogAerialPerspective()
    @JvmName("fogAerialPerspectiveProperty")
    set(`value`) {
      setFogAerialPerspective(value)
    }

  /**
   * The factor to use when affecting the sky with non-volumetric fog. `1.0` means that fog can
   * fully obscure the sky. Lower values reduce the impact of fog on sky rendering, with `0.0` not
   * affecting sky rendering at all.
   *
   * **Note:** [fogSkyAffect] has no visual effect if [fogAerialPerspective] is `1.0`.
   */
  public final inline var fogSkyAffect: Float
    @JvmName("fogSkyAffectProperty")
    get() = getFogSkyAffect()
    @JvmName("fogSkyAffectProperty")
    set(`value`) {
      setFogSkyAffect(value)
    }

  /**
   * The height at which the height fog effect begins.
   */
  public final inline var fogHeight: Float
    @JvmName("fogHeightProperty")
    get() = getFogHeight()
    @JvmName("fogHeightProperty")
    set(`value`) {
      setFogHeight(value)
    }

  /**
   * The density used to increase fog as height decreases. To make fog increase as height increases,
   * use a negative value.
   */
  public final inline var fogHeightDensity: Float
    @JvmName("fogHeightDensityProperty")
    get() = getFogHeightDensity()
    @JvmName("fogHeightDensityProperty")
    set(`value`) {
      setFogHeightDensity(value)
    }

  /**
   * The fog depth's intensity curve. A number of presets are available in the Inspector by
   * right-clicking the curve. Only available when [fogMode] is set to [FOG_MODE_DEPTH].
   */
  public final inline var fogDepthCurve: Float
    @JvmName("fogDepthCurveProperty")
    get() = getFogDepthCurve()
    @JvmName("fogDepthCurveProperty")
    set(`value`) {
      setFogDepthCurve(value)
    }

  /**
   * The fog's depth starting distance from the camera. Only available when [fogMode] is set to
   * [FOG_MODE_DEPTH].
   */
  public final inline var fogDepthBegin: Float
    @JvmName("fogDepthBeginProperty")
    get() = getFogDepthBegin()
    @JvmName("fogDepthBeginProperty")
    set(`value`) {
      setFogDepthBegin(value)
    }

  /**
   * The fog's depth end distance from the camera. If this value is set to `0`, it will be equal to
   * the current camera's [Camera3D.far] value. Only available when [fogMode] is set to
   * [FOG_MODE_DEPTH].
   */
  public final inline var fogDepthEnd: Float
    @JvmName("fogDepthEndProperty")
    get() = getFogDepthEnd()
    @JvmName("fogDepthEndProperty")
    set(`value`) {
      setFogDepthEnd(value)
    }

  /**
   * Enables the volumetric fog effect. Volumetric fog uses a screen-aligned froxel buffer to
   * calculate accurate volumetric scattering in the short to medium range. Volumetric fog interacts
   * with [FogVolume]s and lights to calculate localized and global fog. Volumetric fog uses a PBR
   * single-scattering model based on extinction, scattering, and emission which it exposes to users as
   * density, albedo, and emission.
   *
   * **Note:** Volumetric fog is only supported in the Forward+ rendering method, not Mobile or
   * Compatibility.
   */
  public final inline var volumetricFogEnabled: Boolean
    @JvmName("volumetricFogEnabledProperty")
    get() = isVolumetricFogEnabled()
    @JvmName("volumetricFogEnabledProperty")
    set(`value`) {
      setVolumetricFogEnabled(value)
    }

  /**
   * The base *exponential* density of the volumetric fog. Set this to the lowest density you want
   * to have globally. [FogVolume]s can be used to add to or subtract from this density in specific
   * areas. Fog rendering is exponential as in real life.
   *
   * A value of `0.0` disables global volumetric fog while allowing [FogVolume]s to display
   * volumetric fog in specific areas.
   *
   * To make volumetric fog work as a volumetric *lighting* solution, set [volumetricFogDensity] to
   * the lowest non-zero value (`0.0001`) then increase lights' [Light3D.lightVolumetricFogEnergy] to
   * values between `10000` and `100000` to compensate for the very low density.
   */
  public final inline var volumetricFogDensity: Float
    @JvmName("volumetricFogDensityProperty")
    get() = getVolumetricFogDensity()
    @JvmName("volumetricFogDensityProperty")
    set(`value`) {
      setVolumetricFogDensity(value)
    }

  /**
   * The [Color] of the volumetric fog when interacting with lights. Mist and fog have an albedo
   * close to `Color(1, 1, 1, 1)` while smoke has a darker albedo.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var volumetricFogAlbedo: Color
    @JvmName("volumetricFogAlbedoProperty")
    get() = getVolumetricFogAlbedo()
    @JvmName("volumetricFogAlbedoProperty")
    set(`value`) {
      setVolumetricFogAlbedo(value)
    }

  /**
   * The emitted light from the volumetric fog. Even with emission, volumetric fog will not cast
   * light onto other surfaces. Emission is useful to establish an ambient color. As the volumetric fog
   * effect uses single-scattering only, fog tends to need a little bit of emission to soften the harsh
   * shadows.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var volumetricFogEmission: Color
    @JvmName("volumetricFogEmissionProperty")
    get() = getVolumetricFogEmission()
    @JvmName("volumetricFogEmissionProperty")
    set(`value`) {
      setVolumetricFogEmission(value)
    }

  /**
   * The brightness of the emitted light from the volumetric fog.
   */
  public final inline var volumetricFogEmissionEnergy: Float
    @JvmName("volumetricFogEmissionEnergyProperty")
    get() = getVolumetricFogEmissionEnergy()
    @JvmName("volumetricFogEmissionEnergyProperty")
    set(`value`) {
      setVolumetricFogEmissionEnergy(value)
    }

  /**
   * Scales the strength of Global Illumination used in the volumetric fog's albedo color. A value
   * of `0.0` means that Global Illumination will not impact the volumetric fog.
   * [volumetricFogGiInject] has a small performance cost when set above `0.0`.
   *
   * **Note:** This has no visible effect if [volumetricFogDensity] is `0.0` or if
   * [volumetricFogAlbedo] is a fully black color.
   *
   * **Note:** Only [VoxelGI] and SDFGI ([Environment.sdfgiEnabled]) are taken into account when
   * using [volumetricFogGiInject]. Global illumination from [LightmapGI], [ReflectionProbe] and SSIL
   * (see [ssilEnabled]) will be ignored by volumetric fog.
   */
  public final inline var volumetricFogGiInject: Float
    @JvmName("volumetricFogGiInjectProperty")
    get() = getVolumetricFogGiInject()
    @JvmName("volumetricFogGiInjectProperty")
    set(`value`) {
      setVolumetricFogGiInject(value)
    }

  /**
   * The direction of scattered light as it goes through the volumetric fog. A value close to `1.0`
   * means almost all light is scattered forward. A value close to `0.0` means light is scattered
   * equally in all directions. A value close to `-1.0` means light is scattered mostly backward. Fog
   * and mist scatter light slightly forward, while smoke scatters light equally in all directions.
   */
  public final inline var volumetricFogAnisotropy: Float
    @JvmName("volumetricFogAnisotropyProperty")
    get() = getVolumetricFogAnisotropy()
    @JvmName("volumetricFogAnisotropyProperty")
    set(`value`) {
      setVolumetricFogAnisotropy(value)
    }

  /**
   * The distance over which the volumetric fog is computed. Increase to compute fog over a greater
   * range, decrease to add more detail when a long range is not needed. For best quality fog, keep
   * this as low as possible. See also
   * [ProjectSettings.rendering/environment/volumetricFog/volumeDepth].
   */
  public final inline var volumetricFogLength: Float
    @JvmName("volumetricFogLengthProperty")
    get() = getVolumetricFogLength()
    @JvmName("volumetricFogLengthProperty")
    set(`value`) {
      setVolumetricFogLength(value)
    }

  /**
   * The distribution of size down the length of the froxel buffer. A higher value compresses the
   * froxels closer to the camera and places more detail closer to the camera.
   */
  public final inline var volumetricFogDetailSpread: Float
    @JvmName("volumetricFogDetailSpreadProperty")
    get() = getVolumetricFogDetailSpread()
    @JvmName("volumetricFogDetailSpreadProperty")
    set(`value`) {
      setVolumetricFogDetailSpread(value)
    }

  /**
   * Scales the strength of ambient light used in the volumetric fog. A value of `0.0` means that
   * ambient light will not impact the volumetric fog. [volumetricFogAmbientInject] has a small
   * performance cost when set above `0.0`.
   *
   * **Note:** This has no visible effect if [volumetricFogDensity] is `0.0` or if
   * [volumetricFogAlbedo] is a fully black color.
   */
  public final inline var volumetricFogAmbientInject: Float
    @JvmName("volumetricFogAmbientInjectProperty")
    get() = getVolumetricFogAmbientInject()
    @JvmName("volumetricFogAmbientInjectProperty")
    set(`value`) {
      setVolumetricFogAmbientInject(value)
    }

  /**
   * The factor to use when affecting the sky with volumetric fog. `1.0` means that volumetric fog
   * can fully obscure the sky. Lower values reduce the impact of volumetric fog on sky rendering, with
   * `0.0` not affecting sky rendering at all.
   *
   * **Note:** [volumetricFogSkyAffect] also affects [FogVolume]s, even if [volumetricFogDensity] is
   * `0.0`. If you notice [FogVolume]s are disappearing when looking towards the sky, set
   * [volumetricFogSkyAffect] to `1.0`.
   */
  public final inline var volumetricFogSkyAffect: Float
    @JvmName("volumetricFogSkyAffectProperty")
    get() = getVolumetricFogSkyAffect()
    @JvmName("volumetricFogSkyAffectProperty")
    set(`value`) {
      setVolumetricFogSkyAffect(value)
    }

  /**
   * Enables temporal reprojection in the volumetric fog. Temporal reprojection blends the current
   * frame's volumetric fog with the last frame's volumetric fog to smooth out jagged edges. The
   * performance cost is minimal; however, it leads to moving [FogVolume]s and [Light3D]s "ghosting"
   * and leaving a trail behind them. When temporal reprojection is enabled, try to avoid moving
   * [FogVolume]s or [Light3D]s too fast. Short-lived dynamic lighting effects should have
   * [Light3D.lightVolumetricFogEnergy] set to `0.0` to avoid ghosting.
   */
  public final inline var volumetricFogTemporalReprojectionEnabled: Boolean
    @JvmName("volumetricFogTemporalReprojectionEnabledProperty")
    get() = isVolumetricFogTemporalReprojectionEnabled()
    @JvmName("volumetricFogTemporalReprojectionEnabledProperty")
    set(`value`) {
      setVolumetricFogTemporalReprojectionEnabled(value)
    }

  /**
   * The amount by which to blend the last frame with the current frame. A higher number results in
   * smoother volumetric fog, but makes "ghosting" much worse. A lower value reduces ghosting but can
   * result in the per-frame temporal jitter becoming visible.
   */
  public final inline var volumetricFogTemporalReprojectionAmount: Float
    @JvmName("volumetricFogTemporalReprojectionAmountProperty")
    get() = getVolumetricFogTemporalReprojectionAmount()
    @JvmName("volumetricFogTemporalReprojectionAmountProperty")
    set(`value`) {
      setVolumetricFogTemporalReprojectionAmount(value)
    }

  /**
   * If `true`, enables the `adjustment_*` properties provided by this resource. If `false`,
   * modifications to the `adjustment_*` properties will have no effect on the rendered scene.
   */
  public final inline var adjustmentEnabled: Boolean
    @JvmName("adjustmentEnabledProperty")
    get() = isAdjustmentEnabled()
    @JvmName("adjustmentEnabledProperty")
    set(`value`) {
      setAdjustmentEnabled(value)
    }

  /**
   * Applies a simple brightness adjustment to the rendered image after tonemaping. To adjust scene
   * brightness use [tonemapExposure] instead, which is applied before tonemapping and thus less prone
   * to issues with bright colors. Effective only if [adjustmentEnabled] is `true`.
   */
  public final inline var adjustmentBrightness: Float
    @JvmName("adjustmentBrightnessProperty")
    get() = getAdjustmentBrightness()
    @JvmName("adjustmentBrightnessProperty")
    set(`value`) {
      setAdjustmentBrightness(value)
    }

  /**
   * Increasing [adjustmentContrast] will make dark values darker and bright values brighter. This
   * simple adjustment is applied to the rendered image after tonemaping. When set to a value greater
   * than `1.0`, [adjustmentContrast] is prone to clipping colors that become too bright or too dark.
   * Effective only if [adjustmentEnabled] is `true`.
   */
  public final inline var adjustmentContrast: Float
    @JvmName("adjustmentContrastProperty")
    get() = getAdjustmentContrast()
    @JvmName("adjustmentContrastProperty")
    set(`value`) {
      setAdjustmentContrast(value)
    }

  /**
   * Applies a simple saturation adjustment to the rendered image after tonemaping. When
   * [adjustmentSaturation] is set to `0.0`, the rendered image will be fully converted to a grayscale
   * image. Effective only if [adjustmentEnabled] is `true`.
   */
  public final inline var adjustmentSaturation: Float
    @JvmName("adjustmentSaturationProperty")
    get() = getAdjustmentSaturation()
    @JvmName("adjustmentSaturationProperty")
    set(`value`) {
      setAdjustmentSaturation(value)
    }

  /**
   * The [Texture2D] or [Texture3D] lookup table (LUT) to use for the built-in post-process color
   * grading. Can use a [GradientTexture1D] for a 1-dimensional LUT, or a [Texture3D] for a more
   * complex LUT. Effective only if [adjustmentEnabled] is `true`.
   *
   * **Note:** Color correction does not currently support HDR output due to only supporting values
   * in the SDR (0.0 to 1.0) range.
   */
  public final inline var adjustmentColorCorrection: Texture?
    @JvmName("adjustmentColorCorrectionProperty")
    get() = getAdjustmentColorCorrection()
    @JvmName("adjustmentColorCorrectionProperty")
    set(`value`) {
      setAdjustmentColorCorrection(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(219, scriptPtr)
  }

  /**
   * This is a helper function for [backgroundColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = environment.backgroundColor
   * //Your changes
   * environment.backgroundColor = myCoreType
   * ``````
   *
   * The [Color] displayed for clear areas of the scene. Only effective when using the [BG_COLOR]
   * background mode.
   */
  @CoreTypeHelper
  public final fun backgroundColorMutate(block: Color.() -> Unit): Color = backgroundColor.apply {
     block(this)
     backgroundColor = this
  }

  /**
   * This is a helper function for [skyRotation] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = environment.skyRotation
   * //Your changes
   * environment.skyRotation = myCoreType
   * ``````
   *
   * The rotation to use for sky rendering.
   */
  @CoreTypeHelper
  public final fun skyRotationMutate(block: Vector3.() -> Unit): Vector3 = skyRotation.apply {
     block(this)
     skyRotation = this
  }

  /**
   * This is a helper function for [ambientLightColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = environment.ambientLightColor
   * //Your changes
   * environment.ambientLightColor = myCoreType
   * ``````
   *
   * The ambient light's [Color]. Only effective if [ambientLightSkyContribution] is lower than
   * `1.0` (exclusive).
   */
  @CoreTypeHelper
  public final fun ambientLightColorMutate(block: Color.() -> Unit): Color =
      ambientLightColor.apply {
     block(this)
     ambientLightColor = this
  }

  /**
   * This is a helper function for [fogLightColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = environment.fogLightColor
   * //Your changes
   * environment.fogLightColor = myCoreType
   * ``````
   *
   * The fog's color.
   */
  @CoreTypeHelper
  public final fun fogLightColorMutate(block: Color.() -> Unit): Color = fogLightColor.apply {
     block(this)
     fogLightColor = this
  }

  /**
   * This is a helper function for [volumetricFogAlbedo] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = environment.volumetricFogAlbedo
   * //Your changes
   * environment.volumetricFogAlbedo = myCoreType
   * ``````
   *
   * The [Color] of the volumetric fog when interacting with lights. Mist and fog have an albedo
   * close to `Color(1, 1, 1, 1)` while smoke has a darker albedo.
   */
  @CoreTypeHelper
  public final fun volumetricFogAlbedoMutate(block: Color.() -> Unit): Color =
      volumetricFogAlbedo.apply {
     block(this)
     volumetricFogAlbedo = this
  }

  /**
   * This is a helper function for [volumetricFogEmission] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = environment.volumetricFogEmission
   * //Your changes
   * environment.volumetricFogEmission = myCoreType
   * ``````
   *
   * The emitted light from the volumetric fog. Even with emission, volumetric fog will not cast
   * light onto other surfaces. Emission is useful to establish an ambient color. As the volumetric fog
   * effect uses single-scattering only, fog tends to need a little bit of emission to soften the harsh
   * shadows.
   */
  @CoreTypeHelper
  public final fun volumetricFogEmissionMutate(block: Color.() -> Unit): Color =
      volumetricFogEmission.apply {
     block(this)
     volumetricFogEmission = this
  }

  public final fun setBackground(mode: BGMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBackgroundPtr)
  }

  public final fun getBackground(): BGMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBackgroundPtr)
    return BGMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSky(sky: Sky?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to sky)
    TransferContext.callMethod(MethodBindings.setSkyPtr)
  }

  public final fun getSky(): Sky? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyPtr)
    return (TransferContext.readReturnValue(OBJECT) as Sky?)
  }

  public final fun setSkyCustomFov(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setSkyCustomFovPtr)
  }

  public final fun getSkyCustomFov(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyCustomFovPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSkyRotation(eulerRadians: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to eulerRadians)
    TransferContext.callMethod(MethodBindings.setSkyRotationPtr)
  }

  public final fun getSkyRotation(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkyRotationPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setBgColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setBgColorPtr)
  }

  public final fun getBgColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBgColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setBgEnergyMultiplier(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setBgEnergyMultiplierPtr)
  }

  public final fun getBgEnergyMultiplier(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBgEnergyMultiplierPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBgIntensity(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setBgIntensityPtr)
  }

  public final fun getBgIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBgIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCanvasMaxLayer(layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.setCanvasMaxLayerPtr)
  }

  public final fun getCanvasMaxLayer(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasMaxLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCameraFeedId(id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.setCameraFeedIdPtr)
  }

  public final fun getCameraFeedId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraFeedIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setAmbientLightColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setAmbientLightColorPtr)
  }

  public final fun getAmbientLightColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientLightColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setAmbientSource(source: AmbientSource): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to source.value)
    TransferContext.callMethod(MethodBindings.setAmbientSourcePtr)
  }

  public final fun getAmbientSource(): AmbientSource {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientSourcePtr)
    return AmbientSource.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAmbientLightEnergy(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setAmbientLightEnergyPtr)
  }

  public final fun getAmbientLightEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientLightEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAmbientLightSkyContribution(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setAmbientLightSkyContributionPtr)
  }

  public final fun getAmbientLightSkyContribution(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientLightSkyContributionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setReflectionSource(source: ReflectionSource): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to source.value)
    TransferContext.callMethod(MethodBindings.setReflectionSourcePtr)
  }

  public final fun getReflectionSource(): ReflectionSource {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReflectionSourcePtr)
    return ReflectionSource.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTonemapper(mode: ToneMapper): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTonemapperPtr)
  }

  public final fun getTonemapper(): ToneMapper {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTonemapperPtr)
    return ToneMapper.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTonemapExposure(exposure: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to exposure.toDouble())
    TransferContext.callMethod(MethodBindings.setTonemapExposurePtr)
  }

  public final fun getTonemapExposure(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTonemapExposurePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTonemapWhite(white: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to white.toDouble())
    TransferContext.callMethod(MethodBindings.setTonemapWhitePtr)
  }

  public final fun getTonemapWhite(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTonemapWhitePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTonemapAgxWhite(white: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to white.toDouble())
    TransferContext.callMethod(MethodBindings.setTonemapAgxWhitePtr)
  }

  public final fun getTonemapAgxWhite(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTonemapAgxWhitePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTonemapAgxContrast(contrast: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to contrast.toDouble())
    TransferContext.callMethod(MethodBindings.setTonemapAgxContrastPtr)
  }

  public final fun getTonemapAgxContrast(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTonemapAgxContrastPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsrEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSsrEnabledPtr)
  }

  public final fun isSsrEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSsrEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSsrMaxSteps(maxSteps: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxSteps.toLong())
    TransferContext.callMethod(MethodBindings.setSsrMaxStepsPtr)
  }

  public final fun getSsrMaxSteps(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsrMaxStepsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSsrFadeIn(fadeIn: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fadeIn.toDouble())
    TransferContext.callMethod(MethodBindings.setSsrFadeInPtr)
  }

  public final fun getSsrFadeIn(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsrFadeInPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsrFadeOut(fadeOut: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fadeOut.toDouble())
    TransferContext.callMethod(MethodBindings.setSsrFadeOutPtr)
  }

  public final fun getSsrFadeOut(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsrFadeOutPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsrDepthTolerance(depthTolerance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to depthTolerance.toDouble())
    TransferContext.callMethod(MethodBindings.setSsrDepthTolerancePtr)
  }

  public final fun getSsrDepthTolerance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsrDepthTolerancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSsaoEnabledPtr)
  }

  public final fun isSsaoEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSsaoEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSsaoRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoRadiusPtr)
  }

  public final fun getSsaoRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoIntensity(intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoIntensityPtr)
  }

  public final fun getSsaoIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoPower(power: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to power.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoPowerPtr)
  }

  public final fun getSsaoPower(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoPowerPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoDetail(detail: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to detail.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoDetailPtr)
  }

  public final fun getSsaoDetail(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoDetailPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoHorizon(horizon: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to horizon.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoHorizonPtr)
  }

  public final fun getSsaoHorizon(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoHorizonPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoSharpness(sharpness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to sharpness.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoSharpnessPtr)
  }

  public final fun getSsaoSharpness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoSharpnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoDirectLightAffect(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoDirectLightAffectPtr)
  }

  public final fun getSsaoDirectLightAffect(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoDirectLightAffectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsaoAoChannelAffect(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setSsaoAoChannelAffectPtr)
  }

  public final fun getSsaoAoChannelAffect(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsaoAoChannelAffectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsilEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSsilEnabledPtr)
  }

  public final fun isSsilEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSsilEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSsilRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setSsilRadiusPtr)
  }

  public final fun getSsilRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsilRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsilIntensity(intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.setSsilIntensityPtr)
  }

  public final fun getSsilIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsilIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsilSharpness(sharpness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to sharpness.toDouble())
    TransferContext.callMethod(MethodBindings.setSsilSharpnessPtr)
  }

  public final fun getSsilSharpness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsilSharpnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSsilNormalRejection(normalRejection: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to normalRejection.toDouble())
    TransferContext.callMethod(MethodBindings.setSsilNormalRejectionPtr)
  }

  public final fun getSsilNormalRejection(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSsilNormalRejectionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSdfgiEnabledPtr)
  }

  public final fun isSdfgiEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSdfgiEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSdfgiCascades(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setSdfgiCascadesPtr)
  }

  public final fun getSdfgiCascades(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiCascadesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSdfgiMinCellSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiMinCellSizePtr)
  }

  public final fun getSdfgiMinCellSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiMinCellSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiMaxDistance(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiMaxDistancePtr)
  }

  public final fun getSdfgiMaxDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiMaxDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiCascade0Distance(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiCascade0DistancePtr)
  }

  public final fun getSdfgiCascade0Distance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiCascade0DistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiYScale(scale: SDFGIYScale): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to scale.value)
    TransferContext.callMethod(MethodBindings.setSdfgiYScalePtr)
  }

  public final fun getSdfgiYScale(): SDFGIYScale {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiYScalePtr)
    return SDFGIYScale.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSdfgiUseOcclusion(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSdfgiUseOcclusionPtr)
  }

  public final fun isSdfgiUsingOcclusion(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSdfgiUsingOcclusionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSdfgiBounceFeedback(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiBounceFeedbackPtr)
  }

  public final fun getSdfgiBounceFeedback(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiBounceFeedbackPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiReadSkyLight(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSdfgiReadSkyLightPtr)
  }

  public final fun isSdfgiReadingSkyLight(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSdfgiReadingSkyLightPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSdfgiEnergy(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiEnergyPtr)
  }

  public final fun getSdfgiEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiNormalBias(bias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to bias.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiNormalBiasPtr)
  }

  public final fun getSdfgiNormalBias(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiNormalBiasPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSdfgiProbeBias(bias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to bias.toDouble())
    TransferContext.callMethod(MethodBindings.setSdfgiProbeBiasPtr)
  }

  public final fun getSdfgiProbeBias(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfgiProbeBiasPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setGlowEnabledPtr)
  }

  public final fun isGlowEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isGlowEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the intensity of the glow level [idx]. A value above `0.0` enables the level. Each level
   * relies on the previous level. This means that enabling higher glow levels will slow down the glow
   * effect rendering, even if previous levels aren't enabled.
   */
  public final fun setGlowLevel(idx: Int, intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowLevelPtr)
  }

  /**
   * Returns the intensity of the glow level [idx].
   */
  public final fun getGlowLevel(idx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getGlowLevelPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowNormalized(normalize: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to normalize)
    TransferContext.callMethod(MethodBindings.setGlowNormalizedPtr)
  }

  public final fun isGlowNormalized(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isGlowNormalizedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGlowIntensity(intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowIntensityPtr)
  }

  public final fun getGlowIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowStrength(strength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowStrengthPtr)
  }

  public final fun getGlowStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowMix(mix: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mix.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowMixPtr)
  }

  public final fun getGlowMix(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowMixPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowBloom(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowBloomPtr)
  }

  public final fun getGlowBloom(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowBloomPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowBlendMode(mode: GlowBlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setGlowBlendModePtr)
  }

  public final fun getGlowBlendMode(): GlowBlendMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowBlendModePtr)
    return GlowBlendMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setGlowHdrBleedThreshold(threshold: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to threshold.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowHdrBleedThresholdPtr)
  }

  public final fun getGlowHdrBleedThreshold(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowHdrBleedThresholdPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowHdrBleedScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowHdrBleedScalePtr)
  }

  public final fun getGlowHdrBleedScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowHdrBleedScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowHdrLuminanceCap(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowHdrLuminanceCapPtr)
  }

  public final fun getGlowHdrLuminanceCap(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowHdrLuminanceCapPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowMapStrength(strength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.setGlowMapStrengthPtr)
  }

  public final fun getGlowMapStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowMapStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGlowMap(mode: Texture?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mode)
    TransferContext.callMethod(MethodBindings.setGlowMapPtr)
  }

  public final fun getGlowMap(): Texture? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlowMapPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture?)
  }

  public final fun setFogEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFogEnabledPtr)
  }

  public final fun isFogEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFogEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFogMode(mode: FogMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setFogModePtr)
  }

  public final fun getFogMode(): FogMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogModePtr)
    return FogMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFogLightColor(lightColor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to lightColor)
    TransferContext.callMethod(MethodBindings.setFogLightColorPtr)
  }

  public final fun getFogLightColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogLightColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setFogLightEnergy(lightEnergy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to lightEnergy.toDouble())
    TransferContext.callMethod(MethodBindings.setFogLightEnergyPtr)
  }

  public final fun getFogLightEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogLightEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogSunScatter(sunScatter: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to sunScatter.toDouble())
    TransferContext.callMethod(MethodBindings.setFogSunScatterPtr)
  }

  public final fun getFogSunScatter(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogSunScatterPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogDensity(density: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to density.toDouble())
    TransferContext.callMethod(MethodBindings.setFogDensityPtr)
  }

  public final fun getFogDensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogDensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogHeight(height: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to height.toDouble())
    TransferContext.callMethod(MethodBindings.setFogHeightPtr)
  }

  public final fun getFogHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogHeightDensity(heightDensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to heightDensity.toDouble())
    TransferContext.callMethod(MethodBindings.setFogHeightDensityPtr)
  }

  public final fun getFogHeightDensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogHeightDensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogAerialPerspective(aerialPerspective: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to aerialPerspective.toDouble())
    TransferContext.callMethod(MethodBindings.setFogAerialPerspectivePtr)
  }

  public final fun getFogAerialPerspective(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogAerialPerspectivePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogSkyAffect(skyAffect: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to skyAffect.toDouble())
    TransferContext.callMethod(MethodBindings.setFogSkyAffectPtr)
  }

  public final fun getFogSkyAffect(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogSkyAffectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogDepthCurve(curve: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curve.toDouble())
    TransferContext.callMethod(MethodBindings.setFogDepthCurvePtr)
  }

  public final fun getFogDepthCurve(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogDepthCurvePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogDepthBegin(begin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to begin.toDouble())
    TransferContext.callMethod(MethodBindings.setFogDepthBeginPtr)
  }

  public final fun getFogDepthBegin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogDepthBeginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFogDepthEnd(end: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to end.toDouble())
    TransferContext.callMethod(MethodBindings.setFogDepthEndPtr)
  }

  public final fun getFogDepthEnd(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFogDepthEndPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setVolumetricFogEnabledPtr)
  }

  public final fun isVolumetricFogEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVolumetricFogEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVolumetricFogEmission(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setVolumetricFogEmissionPtr)
  }

  public final fun getVolumetricFogEmission(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogEmissionPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setVolumetricFogAlbedo(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setVolumetricFogAlbedoPtr)
  }

  public final fun getVolumetricFogAlbedo(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogAlbedoPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setVolumetricFogDensity(density: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to density.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogDensityPtr)
  }

  public final fun getVolumetricFogDensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogDensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogEmissionEnergy(begin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to begin.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogEmissionEnergyPtr)
  }

  public final fun getVolumetricFogEmissionEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogEmissionEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogAnisotropy(anisotropy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to anisotropy.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogAnisotropyPtr)
  }

  public final fun getVolumetricFogAnisotropy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogAnisotropyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogLength(length: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogLengthPtr)
  }

  public final fun getVolumetricFogLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogDetailSpread(detailSpread: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to detailSpread.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogDetailSpreadPtr)
  }

  public final fun getVolumetricFogDetailSpread(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogDetailSpreadPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogGiInject(giInject: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to giInject.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogGiInjectPtr)
  }

  public final fun getVolumetricFogGiInject(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogGiInjectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogAmbientInject(enabled: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to enabled.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogAmbientInjectPtr)
  }

  public final fun getVolumetricFogAmbientInject(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogAmbientInjectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogSkyAffect(skyAffect: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to skyAffect.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogSkyAffectPtr)
  }

  public final fun getVolumetricFogSkyAffect(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogSkyAffectPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumetricFogTemporalReprojectionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setVolumetricFogTemporalReprojectionEnabledPtr)
  }

  public final fun isVolumetricFogTemporalReprojectionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVolumetricFogTemporalReprojectionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVolumetricFogTemporalReprojectionAmount(temporalReprojectionAmount: Float):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to temporalReprojectionAmount.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumetricFogTemporalReprojectionAmountPtr)
  }

  public final fun getVolumetricFogTemporalReprojectionAmount(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumetricFogTemporalReprojectionAmountPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAdjustmentEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAdjustmentEnabledPtr)
  }

  public final fun isAdjustmentEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAdjustmentEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAdjustmentBrightness(brightness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to brightness.toDouble())
    TransferContext.callMethod(MethodBindings.setAdjustmentBrightnessPtr)
  }

  public final fun getAdjustmentBrightness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAdjustmentBrightnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAdjustmentContrast(contrast: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to contrast.toDouble())
    TransferContext.callMethod(MethodBindings.setAdjustmentContrastPtr)
  }

  public final fun getAdjustmentContrast(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAdjustmentContrastPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAdjustmentSaturation(saturation: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to saturation.toDouble())
    TransferContext.callMethod(MethodBindings.setAdjustmentSaturationPtr)
  }

  public final fun getAdjustmentSaturation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAdjustmentSaturationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAdjustmentColorCorrection(colorCorrection: Texture?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to colorCorrection)
    TransferContext.callMethod(MethodBindings.setAdjustmentColorCorrectionPtr)
  }

  public final fun getAdjustmentColorCorrection(): Texture? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAdjustmentColorCorrectionPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture?)
  }

  public enum class BGMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Clears the background using the clear color defined in
     * [ProjectSettings.rendering/environment/defaults/defaultClearColor].
     */
    CLEAR_COLOR(0),
    /**
     * Clears the background using a custom clear color.
     */
    COLOR(1),
    /**
     * Displays a user-defined sky in the background.
     */
    SKY(2),
    /**
     * Displays a [CanvasLayer] in the background.
     */
    CANVAS(3),
    /**
     * Keeps on screen every pixel drawn in the background. This is the fastest background mode, but
     * it can only be safely used in fully-interior scenes (no visible sky or sky reflections). If
     * enabled in a scene where the background is visible, "ghost trail" artifacts will be visible when
     * moving the camera.
     */
    KEEP(4),
    /**
     * Displays a camera feed in the background.
     */
    CAMERA_FEED(5),
    /**
     * Represents the size of the [BGMode] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): BGMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class AmbientSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Gather ambient light from whichever source is specified as the background.
     */
    BG(0),
    /**
     * Disable ambient light. This provides a slight performance boost over [AMBIENT_SOURCE_SKY].
     */
    DISABLED(1),
    /**
     * Specify a specific [Color] for ambient light. This provides a slight performance boost over
     * [AMBIENT_SOURCE_SKY].
     */
    COLOR(2),
    /**
     * Gather ambient light from the [Sky] regardless of what the background is.
     */
    SKY(3),
    ;

    public companion object {
      public fun from(`value`: Long): AmbientSource = entries.single { it.`value` == `value` }
    }
  }

  public enum class ReflectionSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the background for reflections.
     */
    BG(0),
    /**
     * Disable reflections. This provides a slight performance boost over other options.
     */
    DISABLED(1),
    /**
     * Use the [Sky] for reflections regardless of what the background is.
     */
    SKY(2),
    ;

    public companion object {
      public fun from(`value`: Long): ReflectionSource = entries.single { it.`value` == `value` }
    }
  }

  public enum class ToneMapper(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Does not modify color data, resulting in a linear tonemapping curve which unnaturally clips
     * bright values, causing bright lighting to look blown out. The simplest and fastest tonemapper.
     */
    LINEAR(0),
    /**
     * A simple tonemapping curve that rolls off bright values to prevent clipping. This results in
     * an image that can appear dull and low contrast. Slower than [TONE_MAPPER_LINEAR].
     *
     * **Note:** When [tonemapWhite] is left at the default value of `1.0`, [TONE_MAPPER_REINHARDT]
     * produces an identical image to [TONE_MAPPER_LINEAR].
     */
    REINHARDT(1),
    /**
     * Uses a film-like tonemapping curve to prevent clipping of bright values and provide better
     * contrast than [TONE_MAPPER_REINHARDT]. Slightly slower than [TONE_MAPPER_REINHARDT].
     *
     * **Note:** This tonemapper does not support HDR output because it produces output in the SDR
     * range. It is recommended to use a different tonemapper when rendering to an HDR screen.
     */
    FILMIC(2),
    /**
     * Uses a high-contrast film-like tonemapping curve and desaturates bright values for a more
     * realistic appearance. Slightly slower than [TONE_MAPPER_FILMIC].
     *
     * **Note:** This tonemapping operator is called "ACES Fitted" in Godot 3.x.
     *
     * **Note:** This tonemapper does not support HDR output because it produces output in the SDR
     * range. It is recommended to use a different tonemapper when rendering to an HDR screen.
     */
    ACES(3),
    /**
     * Uses an adjustable film-like tonemapping curve and desaturates bright values for a more
     * realistic appearance. Better than other tonemappers at maintaining the hue of colors as they
     * become brighter. The slowest tonemapping option.
     */
    AGX(4),
    ;

    public companion object {
      public fun from(`value`: Long): ToneMapper = entries.single { it.`value` == `value` }
    }
  }

  public enum class GlowBlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Adds the glow effect to the scene.
     */
    ADDITIVE(0),
    /**
     * Adds the glow effect to the scene after modifying the glow influence based on the scene
     * value; dark values will be highly influenced by glow and bright values will not be influenced by
     * glow. This approach avoids bright values becoming overly bright from the glow effect.
     * [tonemapWhite] is used to determine the maximum scene value where the glow should have no
     * influence. When [tonemapMode] is set to [TONE_MAPPER_LINEAR] and [Viewport.useHdr2d] is `true`,
     * the parent window's [Window.getOutputMaxLinearValue] will be used as the maximum scene value.
     */
    SCREEN(1),
    /**
     * Adds the glow effect to the tonemapped image after modifying the glow influence based on the
     * image value; dark values and bright values will not be influenced by glow and mid-range values
     * will be highly influenced by glow. This approach avoids bright values becoming overly bright
     * from the glow effect. The glow will have the largest influence on image values of `0.25` and
     * will have no influence when applied to image values greater than `1.0`.
     *
     * **Note:** This blend mode does not support HDR output because expects a maximum output value
     * of `1.0`. It is recommended to use a different blend mode when rendering to an HDR screen.
     */
    SOFTLIGHT(2),
    /**
     * Replaces all pixels' color by the glow effect. This can be used to simulate a full-screen
     * blur effect by tweaking the glow parameters to match the original image's brightness or to
     * preview glow configuration in the editor.
     */
    REPLACE(3),
    /**
     * Mixes the glow image with the scene image. Best used with [glowBloom] to avoid darkening the
     * scene.
     */
    MIX(4),
    ;

    public companion object {
      public fun from(`value`: Long): GlowBlendMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class FogMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use a physically-based fog model defined primarily by fog density.
     */
    EXPONENTIAL(0),
    /**
     * Use a simple fog model defined by start and end positions and a custom curve. While not
     * physically accurate, this model can be useful when you need more artistic control.
     */
    DEPTH(1),
    ;

    public companion object {
      public fun from(`value`: Long): FogMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class SDFGIYScale(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use 50&#37; scale for SDFGI on the Y (vertical) axis. SDFGI cells will be twice as short as
     * they are wide. This allows providing increased GI detail and reduced light leaking with thin
     * floors and ceilings. This is usually the best choice for scenes that don't feature much
     * verticality.
     */
    Y_SCALE_50_PERCENT(0),
    /**
     * Use 75&#37; scale for SDFGI on the Y (vertical) axis. This is a balance between the 50&#37;
     * and 100&#37; SDFGI Y scales.
     */
    Y_SCALE_75_PERCENT(1),
    /**
     * Use 100&#37; scale for SDFGI on the Y (vertical) axis. SDFGI cells will be as tall as they
     * are wide. This is usually the best choice for highly vertical scenes. The downside is that light
     * leaking may become more noticeable with thin floors and ceilings.
     */
    Y_SCALE_100_PERCENT(2),
    ;

    public companion object {
      public fun from(`value`: Long): SDFGIYScale = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setBackgroundName: MethodStringName1<Environment, Unit, BGMode> =
        MethodStringName1<Environment, Unit, BGMode>("set_background")

    @JvmField
    public val getBackgroundName: MethodStringName0<Environment, BGMode> =
        MethodStringName0<Environment, BGMode>("get_background")

    @JvmField
    public val setSkyName: MethodStringName1<Environment, Unit, Sky?> =
        MethodStringName1<Environment, Unit, Sky?>("set_sky")

    @JvmField
    public val getSkyName: MethodStringName0<Environment, Sky?> =
        MethodStringName0<Environment, Sky?>("get_sky")

    @JvmField
    public val setSkyCustomFovName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sky_custom_fov")

    @JvmField
    public val getSkyCustomFovName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sky_custom_fov")

    @JvmField
    public val setSkyRotationName: MethodStringName1<Environment, Unit, Vector3> =
        MethodStringName1<Environment, Unit, Vector3>("set_sky_rotation")

    @JvmField
    public val getSkyRotationName: MethodStringName0<Environment, Vector3> =
        MethodStringName0<Environment, Vector3>("get_sky_rotation")

    @JvmField
    public val setBgColorName: MethodStringName1<Environment, Unit, Color> =
        MethodStringName1<Environment, Unit, Color>("set_bg_color")

    @JvmField
    public val getBgColorName: MethodStringName0<Environment, Color> =
        MethodStringName0<Environment, Color>("get_bg_color")

    @JvmField
    public val setBgEnergyMultiplierName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_bg_energy_multiplier")

    @JvmField
    public val getBgEnergyMultiplierName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_bg_energy_multiplier")

    @JvmField
    public val setBgIntensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_bg_intensity")

    @JvmField
    public val getBgIntensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_bg_intensity")

    @JvmField
    public val setCanvasMaxLayerName: MethodStringName1<Environment, Unit, Int> =
        MethodStringName1<Environment, Unit, Int>("set_canvas_max_layer")

    @JvmField
    public val getCanvasMaxLayerName: MethodStringName0<Environment, Int> =
        MethodStringName0<Environment, Int>("get_canvas_max_layer")

    @JvmField
    public val setCameraFeedIdName: MethodStringName1<Environment, Unit, Int> =
        MethodStringName1<Environment, Unit, Int>("set_camera_feed_id")

    @JvmField
    public val getCameraFeedIdName: MethodStringName0<Environment, Int> =
        MethodStringName0<Environment, Int>("get_camera_feed_id")

    @JvmField
    public val setAmbientLightColorName: MethodStringName1<Environment, Unit, Color> =
        MethodStringName1<Environment, Unit, Color>("set_ambient_light_color")

    @JvmField
    public val getAmbientLightColorName: MethodStringName0<Environment, Color> =
        MethodStringName0<Environment, Color>("get_ambient_light_color")

    @JvmField
    public val setAmbientSourceName: MethodStringName1<Environment, Unit, AmbientSource> =
        MethodStringName1<Environment, Unit, AmbientSource>("set_ambient_source")

    @JvmField
    public val getAmbientSourceName: MethodStringName0<Environment, AmbientSource> =
        MethodStringName0<Environment, AmbientSource>("get_ambient_source")

    @JvmField
    public val setAmbientLightEnergyName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ambient_light_energy")

    @JvmField
    public val getAmbientLightEnergyName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ambient_light_energy")

    @JvmField
    public val setAmbientLightSkyContributionName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ambient_light_sky_contribution")

    @JvmField
    public val getAmbientLightSkyContributionName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ambient_light_sky_contribution")

    @JvmField
    public val setReflectionSourceName: MethodStringName1<Environment, Unit, ReflectionSource> =
        MethodStringName1<Environment, Unit, ReflectionSource>("set_reflection_source")

    @JvmField
    public val getReflectionSourceName: MethodStringName0<Environment, ReflectionSource> =
        MethodStringName0<Environment, ReflectionSource>("get_reflection_source")

    @JvmField
    public val setTonemapperName: MethodStringName1<Environment, Unit, ToneMapper> =
        MethodStringName1<Environment, Unit, ToneMapper>("set_tonemapper")

    @JvmField
    public val getTonemapperName: MethodStringName0<Environment, ToneMapper> =
        MethodStringName0<Environment, ToneMapper>("get_tonemapper")

    @JvmField
    public val setTonemapExposureName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_tonemap_exposure")

    @JvmField
    public val getTonemapExposureName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_tonemap_exposure")

    @JvmField
    public val setTonemapWhiteName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_tonemap_white")

    @JvmField
    public val getTonemapWhiteName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_tonemap_white")

    @JvmField
    public val setTonemapAgxWhiteName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_tonemap_agx_white")

    @JvmField
    public val getTonemapAgxWhiteName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_tonemap_agx_white")

    @JvmField
    public val setTonemapAgxContrastName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_tonemap_agx_contrast")

    @JvmField
    public val getTonemapAgxContrastName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_tonemap_agx_contrast")

    @JvmField
    public val setSsrEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_ssr_enabled")

    @JvmField
    public val isSsrEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_ssr_enabled")

    @JvmField
    public val setSsrMaxStepsName: MethodStringName1<Environment, Unit, Int> =
        MethodStringName1<Environment, Unit, Int>("set_ssr_max_steps")

    @JvmField
    public val getSsrMaxStepsName: MethodStringName0<Environment, Int> =
        MethodStringName0<Environment, Int>("get_ssr_max_steps")

    @JvmField
    public val setSsrFadeInName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssr_fade_in")

    @JvmField
    public val getSsrFadeInName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssr_fade_in")

    @JvmField
    public val setSsrFadeOutName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssr_fade_out")

    @JvmField
    public val getSsrFadeOutName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssr_fade_out")

    @JvmField
    public val setSsrDepthToleranceName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssr_depth_tolerance")

    @JvmField
    public val getSsrDepthToleranceName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssr_depth_tolerance")

    @JvmField
    public val setSsaoEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_ssao_enabled")

    @JvmField
    public val isSsaoEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_ssao_enabled")

    @JvmField
    public val setSsaoRadiusName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_radius")

    @JvmField
    public val getSsaoRadiusName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_radius")

    @JvmField
    public val setSsaoIntensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_intensity")

    @JvmField
    public val getSsaoIntensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_intensity")

    @JvmField
    public val setSsaoPowerName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_power")

    @JvmField
    public val getSsaoPowerName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_power")

    @JvmField
    public val setSsaoDetailName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_detail")

    @JvmField
    public val getSsaoDetailName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_detail")

    @JvmField
    public val setSsaoHorizonName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_horizon")

    @JvmField
    public val getSsaoHorizonName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_horizon")

    @JvmField
    public val setSsaoSharpnessName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_sharpness")

    @JvmField
    public val getSsaoSharpnessName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_sharpness")

    @JvmField
    public val setSsaoDirectLightAffectName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_direct_light_affect")

    @JvmField
    public val getSsaoDirectLightAffectName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_direct_light_affect")

    @JvmField
    public val setSsaoAoChannelAffectName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssao_ao_channel_affect")

    @JvmField
    public val getSsaoAoChannelAffectName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssao_ao_channel_affect")

    @JvmField
    public val setSsilEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_ssil_enabled")

    @JvmField
    public val isSsilEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_ssil_enabled")

    @JvmField
    public val setSsilRadiusName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssil_radius")

    @JvmField
    public val getSsilRadiusName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssil_radius")

    @JvmField
    public val setSsilIntensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssil_intensity")

    @JvmField
    public val getSsilIntensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssil_intensity")

    @JvmField
    public val setSsilSharpnessName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssil_sharpness")

    @JvmField
    public val getSsilSharpnessName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssil_sharpness")

    @JvmField
    public val setSsilNormalRejectionName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_ssil_normal_rejection")

    @JvmField
    public val getSsilNormalRejectionName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_ssil_normal_rejection")

    @JvmField
    public val setSdfgiEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_sdfgi_enabled")

    @JvmField
    public val isSdfgiEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_sdfgi_enabled")

    @JvmField
    public val setSdfgiCascadesName: MethodStringName1<Environment, Unit, Int> =
        MethodStringName1<Environment, Unit, Int>("set_sdfgi_cascades")

    @JvmField
    public val getSdfgiCascadesName: MethodStringName0<Environment, Int> =
        MethodStringName0<Environment, Int>("get_sdfgi_cascades")

    @JvmField
    public val setSdfgiMinCellSizeName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_min_cell_size")

    @JvmField
    public val getSdfgiMinCellSizeName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_min_cell_size")

    @JvmField
    public val setSdfgiMaxDistanceName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_max_distance")

    @JvmField
    public val getSdfgiMaxDistanceName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_max_distance")

    @JvmField
    public val setSdfgiCascade0DistanceName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_cascade0_distance")

    @JvmField
    public val getSdfgiCascade0DistanceName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_cascade0_distance")

    @JvmField
    public val setSdfgiYScaleName: MethodStringName1<Environment, Unit, SDFGIYScale> =
        MethodStringName1<Environment, Unit, SDFGIYScale>("set_sdfgi_y_scale")

    @JvmField
    public val getSdfgiYScaleName: MethodStringName0<Environment, SDFGIYScale> =
        MethodStringName0<Environment, SDFGIYScale>("get_sdfgi_y_scale")

    @JvmField
    public val setSdfgiUseOcclusionName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_sdfgi_use_occlusion")

    @JvmField
    public val isSdfgiUsingOcclusionName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_sdfgi_using_occlusion")

    @JvmField
    public val setSdfgiBounceFeedbackName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_bounce_feedback")

    @JvmField
    public val getSdfgiBounceFeedbackName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_bounce_feedback")

    @JvmField
    public val setSdfgiReadSkyLightName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_sdfgi_read_sky_light")

    @JvmField
    public val isSdfgiReadingSkyLightName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_sdfgi_reading_sky_light")

    @JvmField
    public val setSdfgiEnergyName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_energy")

    @JvmField
    public val getSdfgiEnergyName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_energy")

    @JvmField
    public val setSdfgiNormalBiasName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_normal_bias")

    @JvmField
    public val getSdfgiNormalBiasName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_normal_bias")

    @JvmField
    public val setSdfgiProbeBiasName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_sdfgi_probe_bias")

    @JvmField
    public val getSdfgiProbeBiasName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_sdfgi_probe_bias")

    @JvmField
    public val setGlowEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_glow_enabled")

    @JvmField
    public val isGlowEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_glow_enabled")

    @JvmField
    public val setGlowLevelName: MethodStringName2<Environment, Unit, Int, Float> =
        MethodStringName2<Environment, Unit, Int, Float>("set_glow_level")

    @JvmField
    public val getGlowLevelName: MethodStringName1<Environment, Float, Int> =
        MethodStringName1<Environment, Float, Int>("get_glow_level")

    @JvmField
    public val setGlowNormalizedName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_glow_normalized")

    @JvmField
    public val isGlowNormalizedName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_glow_normalized")

    @JvmField
    public val setGlowIntensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_intensity")

    @JvmField
    public val getGlowIntensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_intensity")

    @JvmField
    public val setGlowStrengthName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_strength")

    @JvmField
    public val getGlowStrengthName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_strength")

    @JvmField
    public val setGlowMixName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_mix")

    @JvmField
    public val getGlowMixName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_mix")

    @JvmField
    public val setGlowBloomName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_bloom")

    @JvmField
    public val getGlowBloomName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_bloom")

    @JvmField
    public val setGlowBlendModeName: MethodStringName1<Environment, Unit, GlowBlendMode> =
        MethodStringName1<Environment, Unit, GlowBlendMode>("set_glow_blend_mode")

    @JvmField
    public val getGlowBlendModeName: MethodStringName0<Environment, GlowBlendMode> =
        MethodStringName0<Environment, GlowBlendMode>("get_glow_blend_mode")

    @JvmField
    public val setGlowHdrBleedThresholdName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_hdr_bleed_threshold")

    @JvmField
    public val getGlowHdrBleedThresholdName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_hdr_bleed_threshold")

    @JvmField
    public val setGlowHdrBleedScaleName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_hdr_bleed_scale")

    @JvmField
    public val getGlowHdrBleedScaleName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_hdr_bleed_scale")

    @JvmField
    public val setGlowHdrLuminanceCapName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_hdr_luminance_cap")

    @JvmField
    public val getGlowHdrLuminanceCapName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_hdr_luminance_cap")

    @JvmField
    public val setGlowMapStrengthName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_glow_map_strength")

    @JvmField
    public val getGlowMapStrengthName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_glow_map_strength")

    @JvmField
    public val setGlowMapName: MethodStringName1<Environment, Unit, Texture?> =
        MethodStringName1<Environment, Unit, Texture?>("set_glow_map")

    @JvmField
    public val getGlowMapName: MethodStringName0<Environment, Texture?> =
        MethodStringName0<Environment, Texture?>("get_glow_map")

    @JvmField
    public val setFogEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_fog_enabled")

    @JvmField
    public val isFogEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_fog_enabled")

    @JvmField
    public val setFogModeName: MethodStringName1<Environment, Unit, FogMode> =
        MethodStringName1<Environment, Unit, FogMode>("set_fog_mode")

    @JvmField
    public val getFogModeName: MethodStringName0<Environment, FogMode> =
        MethodStringName0<Environment, FogMode>("get_fog_mode")

    @JvmField
    public val setFogLightColorName: MethodStringName1<Environment, Unit, Color> =
        MethodStringName1<Environment, Unit, Color>("set_fog_light_color")

    @JvmField
    public val getFogLightColorName: MethodStringName0<Environment, Color> =
        MethodStringName0<Environment, Color>("get_fog_light_color")

    @JvmField
    public val setFogLightEnergyName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_light_energy")

    @JvmField
    public val getFogLightEnergyName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_light_energy")

    @JvmField
    public val setFogSunScatterName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_sun_scatter")

    @JvmField
    public val getFogSunScatterName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_sun_scatter")

    @JvmField
    public val setFogDensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_density")

    @JvmField
    public val getFogDensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_density")

    @JvmField
    public val setFogHeightName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_height")

    @JvmField
    public val getFogHeightName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_height")

    @JvmField
    public val setFogHeightDensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_height_density")

    @JvmField
    public val getFogHeightDensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_height_density")

    @JvmField
    public val setFogAerialPerspectiveName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_aerial_perspective")

    @JvmField
    public val getFogAerialPerspectiveName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_aerial_perspective")

    @JvmField
    public val setFogSkyAffectName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_sky_affect")

    @JvmField
    public val getFogSkyAffectName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_sky_affect")

    @JvmField
    public val setFogDepthCurveName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_depth_curve")

    @JvmField
    public val getFogDepthCurveName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_depth_curve")

    @JvmField
    public val setFogDepthBeginName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_depth_begin")

    @JvmField
    public val getFogDepthBeginName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_depth_begin")

    @JvmField
    public val setFogDepthEndName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_fog_depth_end")

    @JvmField
    public val getFogDepthEndName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_fog_depth_end")

    @JvmField
    public val setVolumetricFogEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_volumetric_fog_enabled")

    @JvmField
    public val isVolumetricFogEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_volumetric_fog_enabled")

    @JvmField
    public val setVolumetricFogEmissionName: MethodStringName1<Environment, Unit, Color> =
        MethodStringName1<Environment, Unit, Color>("set_volumetric_fog_emission")

    @JvmField
    public val getVolumetricFogEmissionName: MethodStringName0<Environment, Color> =
        MethodStringName0<Environment, Color>("get_volumetric_fog_emission")

    @JvmField
    public val setVolumetricFogAlbedoName: MethodStringName1<Environment, Unit, Color> =
        MethodStringName1<Environment, Unit, Color>("set_volumetric_fog_albedo")

    @JvmField
    public val getVolumetricFogAlbedoName: MethodStringName0<Environment, Color> =
        MethodStringName0<Environment, Color>("get_volumetric_fog_albedo")

    @JvmField
    public val setVolumetricFogDensityName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_density")

    @JvmField
    public val getVolumetricFogDensityName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_density")

    @JvmField
    public val setVolumetricFogEmissionEnergyName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_emission_energy")

    @JvmField
    public val getVolumetricFogEmissionEnergyName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_emission_energy")

    @JvmField
    public val setVolumetricFogAnisotropyName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_anisotropy")

    @JvmField
    public val getVolumetricFogAnisotropyName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_anisotropy")

    @JvmField
    public val setVolumetricFogLengthName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_length")

    @JvmField
    public val getVolumetricFogLengthName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_length")

    @JvmField
    public val setVolumetricFogDetailSpreadName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_detail_spread")

    @JvmField
    public val getVolumetricFogDetailSpreadName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_detail_spread")

    @JvmField
    public val setVolumetricFogGiInjectName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_gi_inject")

    @JvmField
    public val getVolumetricFogGiInjectName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_gi_inject")

    @JvmField
    public val setVolumetricFogAmbientInjectName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_ambient_inject")

    @JvmField
    public val getVolumetricFogAmbientInjectName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_ambient_inject")

    @JvmField
    public val setVolumetricFogSkyAffectName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_sky_affect")

    @JvmField
    public val getVolumetricFogSkyAffectName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_volumetric_fog_sky_affect")

    @JvmField
    public val setVolumetricFogTemporalReprojectionEnabledName:
        MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_volumetric_fog_temporal_reprojection_enabled")

    @JvmField
    public val isVolumetricFogTemporalReprojectionEnabledName:
        MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_volumetric_fog_temporal_reprojection_enabled")

    @JvmField
    public val setVolumetricFogTemporalReprojectionAmountName:
        MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_volumetric_fog_temporal_reprojection_amount")

    @JvmField
    public val getVolumetricFogTemporalReprojectionAmountName: MethodStringName0<Environment, Float>
        = MethodStringName0<Environment, Float>("get_volumetric_fog_temporal_reprojection_amount")

    @JvmField
    public val setAdjustmentEnabledName: MethodStringName1<Environment, Unit, Boolean> =
        MethodStringName1<Environment, Unit, Boolean>("set_adjustment_enabled")

    @JvmField
    public val isAdjustmentEnabledName: MethodStringName0<Environment, Boolean> =
        MethodStringName0<Environment, Boolean>("is_adjustment_enabled")

    @JvmField
    public val setAdjustmentBrightnessName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_adjustment_brightness")

    @JvmField
    public val getAdjustmentBrightnessName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_adjustment_brightness")

    @JvmField
    public val setAdjustmentContrastName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_adjustment_contrast")

    @JvmField
    public val getAdjustmentContrastName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_adjustment_contrast")

    @JvmField
    public val setAdjustmentSaturationName: MethodStringName1<Environment, Unit, Float> =
        MethodStringName1<Environment, Unit, Float>("set_adjustment_saturation")

    @JvmField
    public val getAdjustmentSaturationName: MethodStringName0<Environment, Float> =
        MethodStringName0<Environment, Float>("get_adjustment_saturation")

    @JvmField
    public val setAdjustmentColorCorrectionName: MethodStringName1<Environment, Unit, Texture?> =
        MethodStringName1<Environment, Unit, Texture?>("set_adjustment_color_correction")

    @JvmField
    public val getAdjustmentColorCorrectionName: MethodStringName0<Environment, Texture?> =
        MethodStringName0<Environment, Texture?>("get_adjustment_color_correction")
  }

  public object MethodBindings {
    internal val setBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_background", 4071623990)

    internal val getBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_background", 1843210413)

    internal val setSkyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sky", 3336722921)

    internal val getSkyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sky", 1177136966)

    internal val setSkyCustomFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sky_custom_fov", 373806689)

    internal val getSkyCustomFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sky_custom_fov", 1740695150)

    internal val setSkyRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sky_rotation", 3460891852)

    internal val getSkyRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sky_rotation", 3360562783)

    internal val setBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_bg_color", 2920490490)

    internal val getBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_bg_color", 3444240500)

    internal val setBgEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_bg_energy_multiplier", 373806689)

    internal val getBgEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_bg_energy_multiplier", 1740695150)

    internal val setBgIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_bg_intensity", 373806689)

    internal val getBgIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_bg_intensity", 1740695150)

    internal val setCanvasMaxLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_canvas_max_layer", 1286410249)

    internal val getCanvasMaxLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_canvas_max_layer", 3905245786)

    internal val setCameraFeedIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_camera_feed_id", 1286410249)

    internal val getCameraFeedIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_camera_feed_id", 3905245786)

    internal val setAmbientLightColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ambient_light_color", 2920490490)

    internal val getAmbientLightColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ambient_light_color", 3444240500)

    internal val setAmbientSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ambient_source", 2607780160)

    internal val getAmbientSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ambient_source", 67453933)

    internal val setAmbientLightEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ambient_light_energy", 373806689)

    internal val getAmbientLightEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ambient_light_energy", 1740695150)

    internal val setAmbientLightSkyContributionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ambient_light_sky_contribution", 373806689)

    internal val getAmbientLightSkyContributionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ambient_light_sky_contribution", 1740695150)

    internal val setReflectionSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_reflection_source", 299673197)

    internal val getReflectionSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_reflection_source", 777700713)

    internal val setTonemapperPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_tonemapper", 1509116664)

    internal val getTonemapperPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_tonemapper", 2908408137)

    internal val setTonemapExposurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_tonemap_exposure", 373806689)

    internal val getTonemapExposurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_tonemap_exposure", 1740695150)

    internal val setTonemapWhitePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_tonemap_white", 373806689)

    internal val getTonemapWhitePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_tonemap_white", 1740695150)

    internal val setTonemapAgxWhitePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_tonemap_agx_white", 373806689)

    internal val getTonemapAgxWhitePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_tonemap_agx_white", 1740695150)

    internal val setTonemapAgxContrastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_tonemap_agx_contrast", 373806689)

    internal val getTonemapAgxContrastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_tonemap_agx_contrast", 1740695150)

    internal val setSsrEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssr_enabled", 2586408642)

    internal val isSsrEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_ssr_enabled", 36873697)

    internal val setSsrMaxStepsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssr_max_steps", 1286410249)

    internal val getSsrMaxStepsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssr_max_steps", 3905245786)

    internal val setSsrFadeInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssr_fade_in", 373806689)

    internal val getSsrFadeInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssr_fade_in", 1740695150)

    internal val setSsrFadeOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssr_fade_out", 373806689)

    internal val getSsrFadeOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssr_fade_out", 1740695150)

    internal val setSsrDepthTolerancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssr_depth_tolerance", 373806689)

    internal val getSsrDepthTolerancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssr_depth_tolerance", 1740695150)

    internal val setSsaoEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_enabled", 2586408642)

    internal val isSsaoEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_ssao_enabled", 36873697)

    internal val setSsaoRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_radius", 373806689)

    internal val getSsaoRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_radius", 1740695150)

    internal val setSsaoIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_intensity", 373806689)

    internal val getSsaoIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_intensity", 1740695150)

    internal val setSsaoPowerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_power", 373806689)

    internal val getSsaoPowerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_power", 1740695150)

    internal val setSsaoDetailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_detail", 373806689)

    internal val getSsaoDetailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_detail", 1740695150)

    internal val setSsaoHorizonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_horizon", 373806689)

    internal val getSsaoHorizonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_horizon", 1740695150)

    internal val setSsaoSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_sharpness", 373806689)

    internal val getSsaoSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_sharpness", 1740695150)

    internal val setSsaoDirectLightAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_direct_light_affect", 373806689)

    internal val getSsaoDirectLightAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_direct_light_affect", 1740695150)

    internal val setSsaoAoChannelAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssao_ao_channel_affect", 373806689)

    internal val getSsaoAoChannelAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssao_ao_channel_affect", 1740695150)

    internal val setSsilEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssil_enabled", 2586408642)

    internal val isSsilEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_ssil_enabled", 36873697)

    internal val setSsilRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssil_radius", 373806689)

    internal val getSsilRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssil_radius", 1740695150)

    internal val setSsilIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssil_intensity", 373806689)

    internal val getSsilIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssil_intensity", 1740695150)

    internal val setSsilSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssil_sharpness", 373806689)

    internal val getSsilSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssil_sharpness", 1740695150)

    internal val setSsilNormalRejectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_ssil_normal_rejection", 373806689)

    internal val getSsilNormalRejectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_ssil_normal_rejection", 1740695150)

    internal val setSdfgiEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_enabled", 2586408642)

    internal val isSdfgiEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_sdfgi_enabled", 36873697)

    internal val setSdfgiCascadesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_cascades", 1286410249)

    internal val getSdfgiCascadesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_cascades", 3905245786)

    internal val setSdfgiMinCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_min_cell_size", 373806689)

    internal val getSdfgiMinCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_min_cell_size", 1740695150)

    internal val setSdfgiMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_max_distance", 373806689)

    internal val getSdfgiMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_max_distance", 1740695150)

    internal val setSdfgiCascade0DistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_cascade0_distance", 373806689)

    internal val getSdfgiCascade0DistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_cascade0_distance", 1740695150)

    internal val setSdfgiYScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_y_scale", 3608608372)

    internal val getSdfgiYScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_y_scale", 2568002245)

    internal val setSdfgiUseOcclusionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_use_occlusion", 2586408642)

    internal val isSdfgiUsingOcclusionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_sdfgi_using_occlusion", 36873697)

    internal val setSdfgiBounceFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_bounce_feedback", 373806689)

    internal val getSdfgiBounceFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_bounce_feedback", 1740695150)

    internal val setSdfgiReadSkyLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_read_sky_light", 2586408642)

    internal val isSdfgiReadingSkyLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_sdfgi_reading_sky_light", 36873697)

    internal val setSdfgiEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_energy", 373806689)

    internal val getSdfgiEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_energy", 1740695150)

    internal val setSdfgiNormalBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_normal_bias", 373806689)

    internal val getSdfgiNormalBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_normal_bias", 1740695150)

    internal val setSdfgiProbeBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_sdfgi_probe_bias", 373806689)

    internal val getSdfgiProbeBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_sdfgi_probe_bias", 1740695150)

    internal val setGlowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_enabled", 2586408642)

    internal val isGlowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_glow_enabled", 36873697)

    internal val setGlowLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_level", 1602489585)

    internal val getGlowLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_level", 2339986948)

    internal val setGlowNormalizedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_normalized", 2586408642)

    internal val isGlowNormalizedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_glow_normalized", 36873697)

    internal val setGlowIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_intensity", 373806689)

    internal val getGlowIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_intensity", 1740695150)

    internal val setGlowStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_strength", 373806689)

    internal val getGlowStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_strength", 1740695150)

    internal val setGlowMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_mix", 373806689)

    internal val getGlowMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_mix", 1740695150)

    internal val setGlowBloomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_bloom", 373806689)

    internal val getGlowBloomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_bloom", 1740695150)

    internal val setGlowBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_blend_mode", 2561587761)

    internal val getGlowBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_blend_mode", 1529667332)

    internal val setGlowHdrBleedThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_hdr_bleed_threshold", 373806689)

    internal val getGlowHdrBleedThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_hdr_bleed_threshold", 1740695150)

    internal val setGlowHdrBleedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_hdr_bleed_scale", 373806689)

    internal val getGlowHdrBleedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_hdr_bleed_scale", 1740695150)

    internal val setGlowHdrLuminanceCapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_hdr_luminance_cap", 373806689)

    internal val getGlowHdrLuminanceCapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_hdr_luminance_cap", 1740695150)

    internal val setGlowMapStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_map_strength", 373806689)

    internal val getGlowMapStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_map_strength", 1740695150)

    internal val setGlowMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_glow_map", 1790811099)

    internal val getGlowMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_glow_map", 4037048985)

    internal val setFogEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_enabled", 2586408642)

    internal val isFogEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_fog_enabled", 36873697)

    internal val setFogModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_mode", 3059806579)

    internal val getFogModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_mode", 2456062483)

    internal val setFogLightColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_light_color", 2920490490)

    internal val getFogLightColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_light_color", 3444240500)

    internal val setFogLightEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_light_energy", 373806689)

    internal val getFogLightEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_light_energy", 1740695150)

    internal val setFogSunScatterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_sun_scatter", 373806689)

    internal val getFogSunScatterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_sun_scatter", 1740695150)

    internal val setFogDensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_density", 373806689)

    internal val getFogDensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_density", 1740695150)

    internal val setFogHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_height", 373806689)

    internal val getFogHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_height", 1740695150)

    internal val setFogHeightDensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_height_density", 373806689)

    internal val getFogHeightDensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_height_density", 1740695150)

    internal val setFogAerialPerspectivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_aerial_perspective", 373806689)

    internal val getFogAerialPerspectivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_aerial_perspective", 1740695150)

    internal val setFogSkyAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_sky_affect", 373806689)

    internal val getFogSkyAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_sky_affect", 1740695150)

    internal val setFogDepthCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_depth_curve", 373806689)

    internal val getFogDepthCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_depth_curve", 1740695150)

    internal val setFogDepthBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_depth_begin", 373806689)

    internal val getFogDepthBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_depth_begin", 1740695150)

    internal val setFogDepthEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_fog_depth_end", 373806689)

    internal val getFogDepthEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_fog_depth_end", 1740695150)

    internal val setVolumetricFogEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_enabled", 2586408642)

    internal val isVolumetricFogEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_volumetric_fog_enabled", 36873697)

    internal val setVolumetricFogEmissionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_emission", 2920490490)

    internal val getVolumetricFogEmissionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_emission", 3444240500)

    internal val setVolumetricFogAlbedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_albedo", 2920490490)

    internal val getVolumetricFogAlbedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_albedo", 3444240500)

    internal val setVolumetricFogDensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_density", 373806689)

    internal val getVolumetricFogDensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_density", 1740695150)

    internal val setVolumetricFogEmissionEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_emission_energy", 373806689)

    internal val getVolumetricFogEmissionEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_emission_energy", 1740695150)

    internal val setVolumetricFogAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_anisotropy", 373806689)

    internal val getVolumetricFogAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_anisotropy", 1740695150)

    internal val setVolumetricFogLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_length", 373806689)

    internal val getVolumetricFogLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_length", 1740695150)

    internal val setVolumetricFogDetailSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_detail_spread", 373806689)

    internal val getVolumetricFogDetailSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_detail_spread", 1740695150)

    internal val setVolumetricFogGiInjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_gi_inject", 373806689)

    internal val getVolumetricFogGiInjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_gi_inject", 1740695150)

    internal val setVolumetricFogAmbientInjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_ambient_inject", 373806689)

    internal val getVolumetricFogAmbientInjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_ambient_inject", 1740695150)

    internal val setVolumetricFogSkyAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_sky_affect", 373806689)

    internal val getVolumetricFogSkyAffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_sky_affect", 1740695150)

    internal val setVolumetricFogTemporalReprojectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_temporal_reprojection_enabled", 2586408642)

    internal val isVolumetricFogTemporalReprojectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_volumetric_fog_temporal_reprojection_enabled", 36873697)

    internal val setVolumetricFogTemporalReprojectionAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_volumetric_fog_temporal_reprojection_amount", 373806689)

    internal val getVolumetricFogTemporalReprojectionAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_volumetric_fog_temporal_reprojection_amount", 1740695150)

    internal val setAdjustmentEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_adjustment_enabled", 2586408642)

    internal val isAdjustmentEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "is_adjustment_enabled", 36873697)

    internal val setAdjustmentBrightnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_adjustment_brightness", 373806689)

    internal val getAdjustmentBrightnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_adjustment_brightness", 1740695150)

    internal val setAdjustmentContrastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_adjustment_contrast", 373806689)

    internal val getAdjustmentContrastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_adjustment_contrast", 1740695150)

    internal val setAdjustmentSaturationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_adjustment_saturation", 373806689)

    internal val getAdjustmentSaturationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_adjustment_saturation", 1740695150)

    internal val setAdjustmentColorCorrectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "set_adjustment_color_correction", 1790811099)

    internal val getAdjustmentColorCorrectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Environment", "get_adjustment_color_correction", 4037048985)
  }
}
