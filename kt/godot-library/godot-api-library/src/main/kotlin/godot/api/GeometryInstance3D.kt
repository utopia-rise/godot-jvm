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
import godot.core.AABB
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.StringName
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base node for geometry-based visual instances. Shares some common functionality like visibility
 * and custom materials.
 */
@GodotBaseType
public open class GeometryInstance3D : VisualInstance3D() {
  /**
   * The material override for the whole geometry.
   *
   * If a material is assigned to this property, it will be used instead of any material set in any
   * material slot of the mesh.
   */
  public final inline var materialOverride: Material?
    @JvmName("materialOverrideProperty")
    get() = getMaterialOverride()
    @JvmName("materialOverrideProperty")
    set(`value`) {
      setMaterialOverride(value)
    }

  /**
   * The material overlay for the whole geometry.
   *
   * If a material is assigned to this property, it will be rendered on top of any other active
   * material for all the surfaces.
   */
  public final inline var materialOverlay: Material?
    @JvmName("materialOverlayProperty")
    get() = getMaterialOverlay()
    @JvmName("materialOverlayProperty")
    set(`value`) {
      setMaterialOverlay(value)
    }

  /**
   * The transparency applied to the whole geometry (as a multiplier of the materials' existing
   * transparency). `0.0` is fully opaque, while `1.0` is fully transparent. Values greater than `0.0`
   * (exclusive) will force the geometry's materials to go through the transparent pipeline, which is
   * slower to render and can exhibit rendering issues due to incorrect transparency sorting. However,
   * unlike using a transparent material, setting [transparency] to a value greater than `0.0`
   * (exclusive) will *not* disable shadow rendering.
   *
   * In spatial shaders, `1.0 - transparency` is set as the default value of the `ALPHA` built-in.
   *
   * **Note:** [transparency] is clamped between `0.0` and `1.0`, so this property cannot be used to
   * make transparent materials more opaque than they originally are.
   *
   * **Note:** Only supported when using the Forward+ rendering method. When using the Mobile or
   * Compatibility rendering method, [transparency] is ignored and is considered as always being `0.0`.
   */
  public final inline var transparency: Float
    @JvmName("transparencyProperty")
    get() = getTransparency()
    @JvmName("transparencyProperty")
    set(`value`) {
      setTransparency(value)
    }

  /**
   * The mode used to cast shadows from this instance.
   */
  public final inline var castShadow: ShadowCastingSetting
    @JvmName("castShadowProperty")
    get() = getCastShadowsSetting()
    @JvmName("castShadowProperty")
    set(`value`) {
      setCastShadowsSetting(value)
    }

  /**
   * The extra distance added to the GeometryInstance3D's bounding box ([AABB]) to increase its cull
   * box.
   */
  public final inline var extraCullMargin: Float
    @JvmName("extraCullMarginProperty")
    get() = getExtraCullMargin()
    @JvmName("extraCullMarginProperty")
    set(`value`) {
      setExtraCullMargin(value)
    }

  /**
   * Overrides the bounding box of this node with a custom one. This can be used to avoid the
   * expensive [AABB] recalculation that happens when a skeleton is used with a [MeshInstance3D] or to
   * have precise control over the [MeshInstance3D]'s bounding box. To use the default AABB, set value
   * to an [AABB] with all fields set to `0.0`. To avoid frustum culling, set [customAabb] to a very
   * large AABB that covers your entire game world such as `AABB(-10000, -10000, -10000, 20000, 20000,
   * 20000)`. To disable all forms of culling (including occlusion and layer culling), call
   * [RenderingServer.instanceSetIgnoreCulling] on the [GeometryInstance3D]'s [RID].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var customAabb: AABB
    @JvmName("customAabbProperty")
    get() = getCustomAabb()
    @JvmName("customAabbProperty")
    set(`value`) {
      setCustomAabb(value)
    }

  /**
   * Changes how quickly the mesh transitions to a lower level of detail. A value of 0 will force
   * the mesh to its lowest level of detail, a value of 1 will use the default settings, and larger
   * values will keep the mesh in a higher level of detail at farther distances.
   *
   * Useful for testing level of detail transitions in the editor.
   */
  public final inline var lodBias: Float
    @JvmName("lodBiasProperty")
    get() = getLodBias()
    @JvmName("lodBiasProperty")
    set(`value`) {
      setLodBias(value)
    }

  /**
   * If `true`, disables occlusion culling for this instance. Useful for gizmos that must be
   * rendered even when occlusion culling is in use.
   *
   * **Note:** [ignoreOcclusionCulling] does not affect frustum culling (which is what happens when
   * an object is not visible given the camera's angle). To avoid frustum culling, set [customAabb] to
   * a very large AABB that covers your entire game world such as `AABB(-10000, -10000, -10000, 20000,
   * 20000, 20000)`.
   */
  public final inline var ignoreOcclusionCulling: Boolean
    @JvmName("ignoreOcclusionCullingProperty")
    get() = isIgnoringOcclusionCulling()
    @JvmName("ignoreOcclusionCullingProperty")
    set(`value`) {
      setIgnoreOcclusionCulling(value)
    }

  /**
   * The global illumination mode to use for the whole geometry. To avoid inconsistent results, use
   * a mode that matches the purpose of the mesh during gameplay (static/dynamic).
   *
   * **Note:** Lights' bake mode will also affect the global illumination rendering. See
   * [Light3D.lightBakeMode].
   */
  public final inline var giMode: GIMode
    @JvmName("giModeProperty")
    get() = getGiMode()
    @JvmName("giModeProperty")
    set(`value`) {
      setGiMode(value)
    }

  /**
   * The texel density to use for lightmapping in [LightmapGI]. Greater scale values provide higher
   * resolution in the lightmap, which can result in sharper shadows for lights that have both direct
   * and indirect light baked. However, greater scale values will also increase the space taken by the
   * mesh in the lightmap texture, which increases the memory, storage, and bake time requirements.
   * When using a single mesh at different scales, consider adjusting this value to keep the lightmap
   * texel density consistent across meshes.
   *
   * For example, doubling [giLightmapTexelScale] doubles the lightmap texture resolution for this
   * object *on each axis*, so it will *quadruple* the texel count.
   */
  public final inline var giLightmapTexelScale: Float
    @JvmName("giLightmapTexelScaleProperty")
    get() = getLightmapTexelScale()
    @JvmName("giLightmapTexelScaleProperty")
    set(`value`) {
      setLightmapTexelScale(value)
    }

  /**
   * The texel density to use for lightmapping in [LightmapGI].
   */
  public final inline var giLightmapScale: LightmapScale
    @JvmName("giLightmapScaleProperty")
    get() = getLightmapScale()
    @JvmName("giLightmapScaleProperty")
    set(`value`) {
      setLightmapScale(value)
    }

  /**
   * Starting distance from which the GeometryInstance3D will be visible, taking
   * [visibilityRangeBeginMargin] into account as well. The default value of 0 is used to disable the
   * range check.
   */
  public final inline var visibilityRangeBegin: Float
    @JvmName("visibilityRangeBeginProperty")
    get() = getVisibilityRangeBegin()
    @JvmName("visibilityRangeBeginProperty")
    set(`value`) {
      setVisibilityRangeBegin(value)
    }

  /**
   * Margin for the [visibilityRangeBegin] threshold. The GeometryInstance3D will only change its
   * visibility state when it goes over or under the [visibilityRangeBegin] threshold by this amount.
   *
   * If [visibilityRangeFadeMode] is [VISIBILITY_RANGE_FADE_DISABLED], this acts as a hysteresis
   * distance. If [visibilityRangeFadeMode] is [VISIBILITY_RANGE_FADE_SELF] or
   * [VISIBILITY_RANGE_FADE_DEPENDENCIES], this acts as a fade transition distance and must be set to a
   * value greater than `0.0` for the effect to be noticeable.
   */
  public final inline var visibilityRangeBeginMargin: Float
    @JvmName("visibilityRangeBeginMarginProperty")
    get() = getVisibilityRangeBeginMargin()
    @JvmName("visibilityRangeBeginMarginProperty")
    set(`value`) {
      setVisibilityRangeBeginMargin(value)
    }

  /**
   * Distance from which the GeometryInstance3D will be hidden, taking [visibilityRangeEndMargin]
   * into account as well. The default value of 0 is used to disable the range check.
   */
  public final inline var visibilityRangeEnd: Float
    @JvmName("visibilityRangeEndProperty")
    get() = getVisibilityRangeEnd()
    @JvmName("visibilityRangeEndProperty")
    set(`value`) {
      setVisibilityRangeEnd(value)
    }

  /**
   * Margin for the [visibilityRangeEnd] threshold. The GeometryInstance3D will only change its
   * visibility state when it goes over or under the [visibilityRangeEnd] threshold by this amount.
   *
   * If [visibilityRangeFadeMode] is [VISIBILITY_RANGE_FADE_DISABLED], this acts as a hysteresis
   * distance. If [visibilityRangeFadeMode] is [VISIBILITY_RANGE_FADE_SELF] or
   * [VISIBILITY_RANGE_FADE_DEPENDENCIES], this acts as a fade transition distance and must be set to a
   * value greater than `0.0` for the effect to be noticeable.
   */
  public final inline var visibilityRangeEndMargin: Float
    @JvmName("visibilityRangeEndMarginProperty")
    get() = getVisibilityRangeEndMargin()
    @JvmName("visibilityRangeEndMarginProperty")
    set(`value`) {
      setVisibilityRangeEndMargin(value)
    }

  /**
   * Controls which instances will be faded when approaching the limits of the visibility range.
   */
  public final inline var visibilityRangeFadeMode: VisibilityRangeFadeMode
    @JvmName("visibilityRangeFadeModeProperty")
    get() = getVisibilityRangeFadeMode()
    @JvmName("visibilityRangeFadeModeProperty")
    set(`value`) {
      setVisibilityRangeFadeMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(274, scriptPtr)
  }

  /**
   * This is a helper function for [customAabb] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = geometryinstance3d.customAabb
   * //Your changes
   * geometryinstance3d.customAabb = myCoreType
   * ``````
   *
   * Overrides the bounding box of this node with a custom one. This can be used to avoid the
   * expensive [AABB] recalculation that happens when a skeleton is used with a [MeshInstance3D] or to
   * have precise control over the [MeshInstance3D]'s bounding box. To use the default AABB, set value
   * to an [AABB] with all fields set to `0.0`. To avoid frustum culling, set [customAabb] to a very
   * large AABB that covers your entire game world such as `AABB(-10000, -10000, -10000, 20000, 20000,
   * 20000)`. To disable all forms of culling (including occlusion and layer culling), call
   * [RenderingServer.instanceSetIgnoreCulling] on the [GeometryInstance3D]'s [RID].
   */
  @CoreTypeHelper
  public final fun customAabbMutate(block: AABB.() -> Unit): AABB = customAabb.apply {
     block(this)
     customAabb = this
  }

  public final fun setMaterialOverride(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialOverridePtr)
  }

  public final fun getMaterialOverride(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialOverridePtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  public final fun setMaterialOverlay(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialOverlayPtr)
  }

  public final fun getMaterialOverlay(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialOverlayPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  public final fun setCastShadowsSetting(shadowCastingSetting: ShadowCastingSetting): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shadowCastingSetting.value)
    TransferContext.callMethod(MethodBindings.setCastShadowsSettingPtr)
  }

  public final fun getCastShadowsSetting(): ShadowCastingSetting {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCastShadowsSettingPtr)
    return ShadowCastingSetting.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLodBias(bias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to bias.toDouble())
    TransferContext.callMethod(MethodBindings.setLodBiasPtr)
  }

  public final fun getLodBias(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLodBiasPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTransparency(transparency: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to transparency.toDouble())
    TransferContext.callMethod(MethodBindings.setTransparencyPtr)
  }

  public final fun getTransparency(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransparencyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeEndMargin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeEndMarginPtr)
  }

  public final fun getVisibilityRangeEndMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeEndMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeEnd(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeEndPtr)
  }

  public final fun getVisibilityRangeEnd(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeEndPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeBeginMargin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeBeginMarginPtr)
  }

  public final fun getVisibilityRangeBeginMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeBeginMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeBegin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeBeginPtr)
  }

  public final fun getVisibilityRangeBegin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeBeginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeFadeMode(mode: VisibilityRangeFadeMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVisibilityRangeFadeModePtr)
  }

  public final fun getVisibilityRangeFadeMode(): VisibilityRangeFadeMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeFadeModePtr)
    return VisibilityRangeFadeMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Set the value of a shader uniform for this instance only
   * ([url=$DOCS_URL/tutorials/shaders/shader_reference/shading_language.html#per-instance-uniforms]per-instance
   * uniform[/url]). See also [ShaderMaterial.setShaderParameter] to assign a uniform on all instances
   * using the same [ShaderMaterial].
   *
   * **Note:** For a shader uniform to be assignable on a per-instance basis, it *must* be defined
   * with `instance uniform ...` rather than `uniform ...` in the shader code.
   *
   * **Note:** [name] is case-sensitive and must match the name of the uniform in the code exactly
   * (not the capitalized name in the inspector).
   *
   * **Note:** Per-instance shader uniforms are only available in Spatial and CanvasItem shaders,
   * but not for Fog, Sky, or Particles shaders.
   */
  public final fun setInstanceShaderParameter(name: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to value)
    TransferContext.callMethod(MethodBindings.setInstanceShaderParameterPtr)
  }

  /**
   * Get the value of a shader parameter as set on this instance.
   */
  public final fun getInstanceShaderParameter(name: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getInstanceShaderParameterPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public final fun setExtraCullMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.setExtraCullMarginPtr)
  }

  public final fun getExtraCullMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExtraCullMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLightmapTexelScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setLightmapTexelScalePtr)
  }

  public final fun getLightmapTexelScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightmapTexelScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLightmapScale(scale: LightmapScale): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to scale.value)
    TransferContext.callMethod(MethodBindings.setLightmapScalePtr)
  }

  public final fun getLightmapScale(): LightmapScale {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightmapScalePtr)
    return LightmapScale.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setGiMode(mode: GIMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setGiModePtr)
  }

  public final fun getGiMode(): GIMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGiModePtr)
    return GIMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setIgnoreOcclusionCulling(ignoreCulling: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to ignoreCulling)
    TransferContext.callMethod(MethodBindings.setIgnoreOcclusionCullingPtr)
  }

  public final fun isIgnoringOcclusionCulling(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIgnoringOcclusionCullingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCustomAabb(aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.setCustomAabbPtr)
  }

  public final fun getCustomAabb(): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  /**
   * Set the value of a shader uniform for this instance only
   * ([url=$DOCS_URL/tutorials/shaders/shader_reference/shading_language.html#per-instance-uniforms]per-instance
   * uniform[/url]). See also [ShaderMaterial.setShaderParameter] to assign a uniform on all instances
   * using the same [ShaderMaterial].
   *
   * **Note:** For a shader uniform to be assignable on a per-instance basis, it *must* be defined
   * with `instance uniform ...` rather than `uniform ...` in the shader code.
   *
   * **Note:** [name] is case-sensitive and must match the name of the uniform in the code exactly
   * (not the capitalized name in the inspector).
   *
   * **Note:** Per-instance shader uniforms are only available in Spatial and CanvasItem shaders,
   * but not for Fog, Sky, or Particles shaders.
   */
  public final fun setInstanceShaderParameter(name: String, `value`: Any?) =
      setInstanceShaderParameter(name.asCachedStringName(), value)

  /**
   * Get the value of a shader parameter as set on this instance.
   */
  public final fun getInstanceShaderParameter(name: String): Any? =
      getInstanceShaderParameter(name.asCachedStringName())

  public enum class ShadowCastingSetting(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Will not cast any shadows. Use this to improve performance for small geometry that is
     * unlikely to cast noticeable shadows (such as debris).
     */
    OFF(0),
    /**
     * Will cast shadows from all visible faces in the GeometryInstance3D.
     *
     * Will take culling into account, so faces not being rendered will not be taken into account
     * when shadow casting.
     */
    ON(1),
    /**
     * Will cast shadows from all visible faces in the GeometryInstance3D.
     *
     * Will not take culling into account, so all faces will be taken into account when shadow
     * casting.
     */
    DOUBLE_SIDED(2),
    /**
     * Will only show the shadows casted from this object.
     *
     * In other words, the actual mesh will not be visible, only the shadows casted from the mesh
     * will be.
     */
    SHADOWS_ONLY(3),
    ;

    public companion object {
      public fun from(`value`: Long): ShadowCastingSetting =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class GIMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disabled global illumination mode. Use for dynamic objects that do not contribute to global
     * illumination (such as characters). When using [VoxelGI] and SDFGI, the geometry will *receive*
     * indirect lighting and reflections but the geometry will not be considered in GI baking.
     */
    DISABLED(0),
    /**
     * Baked global illumination mode. Use for static objects that contribute to global illumination
     * (such as level geometry). This GI mode is effective when using [VoxelGI], SDFGI and
     * [LightmapGI].
     */
    STATIC(1),
    /**
     * Dynamic global illumination mode. Use for dynamic objects that contribute to global
     * illumination. This GI mode is only effective when using [VoxelGI], but it has a higher
     * performance impact than [GI_MODE_STATIC]. When using other GI methods, this will act the same as
     * [GI_MODE_DISABLED]. When using [LightmapGI], the object will receive indirect lighting using
     * lightmap probes instead of using the baked lightmap texture.
     */
    DYNAMIC(2),
    ;

    public companion object {
      public fun from(`value`: Long): GIMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LightmapScale(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The standard texel density for lightmapping with [LightmapGI].
     */
    LIGHTMAP_SCALE_1X(0),
    /**
     * Multiplies texel density by 2× for lightmapping with [LightmapGI]. To ensure consistency in
     * texel density, use this when scaling a mesh by a factor between 1.5 and 3.0.
     */
    LIGHTMAP_SCALE_2X(1),
    /**
     * Multiplies texel density by 4× for lightmapping with [LightmapGI]. To ensure consistency in
     * texel density, use this when scaling a mesh by a factor between 3.0 and 6.0.
     */
    LIGHTMAP_SCALE_4X(2),
    /**
     * Multiplies texel density by 8× for lightmapping with [LightmapGI]. To ensure consistency in
     * texel density, use this when scaling a mesh by a factor greater than 6.0.
     */
    LIGHTMAP_SCALE_8X(3),
    /**
     * Represents the size of the [LightmapScale] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): LightmapScale = entries.single { it.`value` == `value` }
    }
  }

  public enum class VisibilityRangeFadeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Will not fade itself nor its visibility dependencies, hysteresis will be used instead. This
     * is the fastest approach to manual LOD, but it can result in noticeable LOD transitions depending
     * on how the LOD meshes are authored. See [visibilityRangeBegin] and [Node3D.visibilityParent] for
     * more information.
     */
    DISABLED(0),
    /**
     * Will fade-out itself when reaching the limits of its own visibility range. This is slower
     * than [VISIBILITY_RANGE_FADE_DISABLED], but it can provide smoother transitions. The fading range
     * is determined by [visibilityRangeBeginMargin] and [visibilityRangeEndMargin].
     *
     * **Note:** Only supported when using the Forward+ rendering method. When using the Mobile or
     * Compatibility rendering method, this mode acts like [VISIBILITY_RANGE_FADE_DISABLED] but with
     * hysteresis disabled.
     */
    SELF(1),
    /**
     * Will fade-in its visibility dependencies (see [Node3D.visibilityParent]) when reaching the
     * limits of its own visibility range. This is slower than [VISIBILITY_RANGE_FADE_DISABLED], but it
     * can provide smoother transitions. The fading range is determined by [visibilityRangeBeginMargin]
     * and [visibilityRangeEndMargin].
     *
     * **Note:** Only supported when using the Forward+ rendering method. When using the Mobile or
     * Compatibility rendering method, this mode acts like [VISIBILITY_RANGE_FADE_DISABLED] but with
     * hysteresis disabled.
     */
    DEPENDENCIES(2),
    ;

    public companion object {
      public fun from(`value`: Long): VisibilityRangeFadeMode =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setMaterialOverrideName: MethodStringName1<GeometryInstance3D, Unit, Material?> =
        MethodStringName1<GeometryInstance3D, Unit, Material?>("set_material_override")

    @JvmField
    public val getMaterialOverrideName: MethodStringName0<GeometryInstance3D, Material?> =
        MethodStringName0<GeometryInstance3D, Material?>("get_material_override")

    @JvmField
    public val setMaterialOverlayName: MethodStringName1<GeometryInstance3D, Unit, Material?> =
        MethodStringName1<GeometryInstance3D, Unit, Material?>("set_material_overlay")

    @JvmField
    public val getMaterialOverlayName: MethodStringName0<GeometryInstance3D, Material?> =
        MethodStringName0<GeometryInstance3D, Material?>("get_material_overlay")

    @JvmField
    public val setCastShadowsSettingName:
        MethodStringName1<GeometryInstance3D, Unit, ShadowCastingSetting> =
        MethodStringName1<GeometryInstance3D, Unit, ShadowCastingSetting>("set_cast_shadows_setting")

    @JvmField
    public val getCastShadowsSettingName:
        MethodStringName0<GeometryInstance3D, ShadowCastingSetting> =
        MethodStringName0<GeometryInstance3D, ShadowCastingSetting>("get_cast_shadows_setting")

    @JvmField
    public val setLodBiasName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_lod_bias")

    @JvmField
    public val getLodBiasName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_lod_bias")

    @JvmField
    public val setTransparencyName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_transparency")

    @JvmField
    public val getTransparencyName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_transparency")

    @JvmField
    public val setVisibilityRangeEndMarginName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_visibility_range_end_margin")

    @JvmField
    public val getVisibilityRangeEndMarginName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_visibility_range_end_margin")

    @JvmField
    public val setVisibilityRangeEndName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_visibility_range_end")

    @JvmField
    public val getVisibilityRangeEndName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_visibility_range_end")

    @JvmField
    public val setVisibilityRangeBeginMarginName: MethodStringName1<GeometryInstance3D, Unit, Float>
        = MethodStringName1<GeometryInstance3D, Unit, Float>("set_visibility_range_begin_margin")

    @JvmField
    public val getVisibilityRangeBeginMarginName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_visibility_range_begin_margin")

    @JvmField
    public val setVisibilityRangeBeginName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_visibility_range_begin")

    @JvmField
    public val getVisibilityRangeBeginName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_visibility_range_begin")

    @JvmField
    public val setVisibilityRangeFadeModeName:
        MethodStringName1<GeometryInstance3D, Unit, VisibilityRangeFadeMode> =
        MethodStringName1<GeometryInstance3D, Unit, VisibilityRangeFadeMode>("set_visibility_range_fade_mode")

    @JvmField
    public val getVisibilityRangeFadeModeName:
        MethodStringName0<GeometryInstance3D, VisibilityRangeFadeMode> =
        MethodStringName0<GeometryInstance3D, VisibilityRangeFadeMode>("get_visibility_range_fade_mode")

    @JvmField
    public val setInstanceShaderParameterName:
        MethodStringName2<GeometryInstance3D, Unit, StringName, Any?> =
        MethodStringName2<GeometryInstance3D, Unit, StringName, Any?>("set_instance_shader_parameter")

    @JvmField
    public val getInstanceShaderParameterName:
        MethodStringName1<GeometryInstance3D, Any?, StringName> =
        MethodStringName1<GeometryInstance3D, Any?, StringName>("get_instance_shader_parameter")

    @JvmField
    public val setExtraCullMarginName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_extra_cull_margin")

    @JvmField
    public val getExtraCullMarginName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_extra_cull_margin")

    @JvmField
    public val setLightmapTexelScaleName: MethodStringName1<GeometryInstance3D, Unit, Float> =
        MethodStringName1<GeometryInstance3D, Unit, Float>("set_lightmap_texel_scale")

    @JvmField
    public val getLightmapTexelScaleName: MethodStringName0<GeometryInstance3D, Float> =
        MethodStringName0<GeometryInstance3D, Float>("get_lightmap_texel_scale")

    @JvmField
    public val setLightmapScaleName: MethodStringName1<GeometryInstance3D, Unit, LightmapScale> =
        MethodStringName1<GeometryInstance3D, Unit, LightmapScale>("set_lightmap_scale")

    @JvmField
    public val getLightmapScaleName: MethodStringName0<GeometryInstance3D, LightmapScale> =
        MethodStringName0<GeometryInstance3D, LightmapScale>("get_lightmap_scale")

    @JvmField
    public val setGiModeName: MethodStringName1<GeometryInstance3D, Unit, GIMode> =
        MethodStringName1<GeometryInstance3D, Unit, GIMode>("set_gi_mode")

    @JvmField
    public val getGiModeName: MethodStringName0<GeometryInstance3D, GIMode> =
        MethodStringName0<GeometryInstance3D, GIMode>("get_gi_mode")

    @JvmField
    public val setIgnoreOcclusionCullingName: MethodStringName1<GeometryInstance3D, Unit, Boolean> =
        MethodStringName1<GeometryInstance3D, Unit, Boolean>("set_ignore_occlusion_culling")

    @JvmField
    public val isIgnoringOcclusionCullingName: MethodStringName0<GeometryInstance3D, Boolean> =
        MethodStringName0<GeometryInstance3D, Boolean>("is_ignoring_occlusion_culling")

    @JvmField
    public val setCustomAabbName: MethodStringName1<GeometryInstance3D, Unit, AABB> =
        MethodStringName1<GeometryInstance3D, Unit, AABB>("set_custom_aabb")

    @JvmField
    public val getCustomAabbName: MethodStringName0<GeometryInstance3D, AABB> =
        MethodStringName0<GeometryInstance3D, AABB>("get_custom_aabb")
  }

  public object MethodBindings {
    internal val setMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_material_override", 2757459619)

    internal val getMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_material_override", 5934680)

    internal val setMaterialOverlayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_material_overlay", 2757459619)

    internal val getMaterialOverlayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_material_overlay", 5934680)

    internal val setCastShadowsSettingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_cast_shadows_setting", 856677339)

    internal val getCastShadowsSettingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_cast_shadows_setting", 3383019359)

    internal val setLodBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_lod_bias", 373806689)

    internal val getLodBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_lod_bias", 1740695150)

    internal val setTransparencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_transparency", 373806689)

    internal val getTransparencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_transparency", 1740695150)

    internal val setVisibilityRangeEndMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_visibility_range_end_margin", 373806689)

    internal val getVisibilityRangeEndMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_visibility_range_end_margin", 1740695150)

    internal val setVisibilityRangeEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_visibility_range_end", 373806689)

    internal val getVisibilityRangeEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_visibility_range_end", 1740695150)

    internal val setVisibilityRangeBeginMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_visibility_range_begin_margin", 373806689)

    internal val getVisibilityRangeBeginMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_visibility_range_begin_margin", 1740695150)

    internal val setVisibilityRangeBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_visibility_range_begin", 373806689)

    internal val getVisibilityRangeBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_visibility_range_begin", 1740695150)

    internal val setVisibilityRangeFadeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_visibility_range_fade_mode", 1440117808)

    internal val getVisibilityRangeFadeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_visibility_range_fade_mode", 2067221882)

    internal val setInstanceShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_instance_shader_parameter", 3776071444)

    internal val getInstanceShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_instance_shader_parameter", 2760726917)

    internal val setExtraCullMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_extra_cull_margin", 373806689)

    internal val getExtraCullMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_extra_cull_margin", 1740695150)

    internal val setLightmapTexelScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_lightmap_texel_scale", 373806689)

    internal val getLightmapTexelScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_lightmap_texel_scale", 1740695150)

    internal val setLightmapScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_lightmap_scale", 2462696582)

    internal val getLightmapScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_lightmap_scale", 798767852)

    internal val setGiModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_gi_mode", 2548557163)

    internal val getGiModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_gi_mode", 2188566509)

    internal val setIgnoreOcclusionCullingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_ignore_occlusion_culling", 2586408642)

    internal val isIgnoringOcclusionCullingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "is_ignoring_occlusion_culling", 2240911060)

    internal val setCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "set_custom_aabb", 259215842)

    internal val getCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GeometryInstance3D", "get_custom_aabb", 1068685055)
  }
}
