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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
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
 * Captures its surroundings as a cubemap, and stores versions of it with increasing levels of blur
 * to simulate different material roughnesses.
 *
 * The [ReflectionProbe] is used to create high-quality reflections at a low performance cost (when
 * [updateMode] is [UPDATE_ONCE]). [ReflectionProbe]s can be blended together and with the rest of the
 * scene smoothly. [ReflectionProbe]s can also be combined with [VoxelGI], SDFGI
 * ([Environment.sdfgiEnabled]) and screen-space reflections ([Environment.ssrEnabled]) to get more
 * accurate reflections in specific areas. [ReflectionProbe]s render all objects within their
 * [cullMask], so updating them can be quite expensive. It is best to update them once with the
 * important static objects and then leave them as-is.
 *
 * **Note:** Unlike [VoxelGI] and SDFGI, [ReflectionProbe]s only source their environment from a
 * [WorldEnvironment] node. If you specify an [Environment] resource within a [Camera3D] node, it will
 * be ignored by the [ReflectionProbe]. This can lead to incorrect lighting within the
 * [ReflectionProbe].
 *
 * **Note:** When using the Mobile rendering method, only `8` reflection probes can be displayed on
 * each mesh resource, while the Compatibility rendering method only supports up to `2` reflection
 * probes on each mesh. Attempting to display more than `8` reflection probes on a single mesh resource
 * using the Mobile renderer will result in reflection probes flickering in and out as the camera
 * moves, while the Compatibility renderer will not render any additional probes if more than `2`
 * reflection probes are being used.
 *
 * **Note:** When using the Mobile rendering method, reflection probes will only correctly affect
 * meshes whose visibility AABB intersects with the reflection probe's AABB. If using a shader to
 * deform the mesh in a way that makes it go outside its AABB, [GeometryInstance3D.extraCullMargin]
 * must be increased on the mesh. Otherwise, the reflection probe may not be visible on the mesh.
 */
@GodotBaseType
public open class ReflectionProbe : VisualInstance3D() {
  /**
   * Sets how frequently the [ReflectionProbe] is updated. Can be [UPDATE_ONCE] or [UPDATE_ALWAYS].
   */
  public final inline var updateMode: UpdateMode
    @JvmName("updateModeProperty")
    get() = getUpdateMode()
    @JvmName("updateModeProperty")
    set(`value`) {
      setUpdateMode(value)
    }

  /**
   * Defines the reflection intensity. Intensity modulates the strength of the reflection.
   */
  public final inline var intensity: Float
    @JvmName("intensityProperty")
    get() = getIntensity()
    @JvmName("intensityProperty")
    set(`value`) {
      setIntensity(value)
    }

  /**
   * Defines the distance in meters over which a probe blends into the scene.
   */
  public final inline var blendDistance: Float
    @JvmName("blendDistanceProperty")
    get() = getBlendDistance()
    @JvmName("blendDistanceProperty")
    set(`value`) {
      setBlendDistance(value)
    }

  /**
   * The maximum distance away from the [ReflectionProbe] an object can be before it is culled.
   * Decrease this to improve performance, especially when using the [UPDATE_ALWAYS] [updateMode].
   *
   * **Note:** The maximum reflection distance is always at least equal to the probe's extents. This
   * means that decreasing [maxDistance] will not always cull objects from reflections, especially if
   * the reflection probe's box defined by its [size] is already large.
   */
  public final inline var maxDistance: Float
    @JvmName("maxDistanceProperty")
    get() = getMaxDistance()
    @JvmName("maxDistanceProperty")
    set(`value`) {
      setMaxDistance(value)
    }

  /**
   * The size of the reflection probe. The larger the size, the more space covered by the probe,
   * which will lower the perceived resolution. It is best to keep the size only as large as you need
   * it.
   *
   * **Note:** To better fit areas that are not aligned to the grid, you can rotate the
   * [ReflectionProbe] node.
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
   * Sets the origin offset to be used when this [ReflectionProbe] is in [boxProjection] mode. This
   * can be set to a non-zero value to ensure a reflection fits a rectangle-shaped room, while reducing
   * the number of objects that "get in the way" of the reflection.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var originOffset: Vector3
    @JvmName("originOffsetProperty")
    get() = getOriginOffset()
    @JvmName("originOffsetProperty")
    set(`value`) {
      setOriginOffset(value)
    }

  /**
   * If `true`, enables box projection. This makes reflections look more correct in rectangle-shaped
   * rooms by offsetting the reflection center depending on the camera's location.
   *
   * **Note:** To better fit rectangle-shaped rooms that are not aligned to the grid, you can rotate
   * the [ReflectionProbe] node.
   */
  public final inline var boxProjection: Boolean
    @JvmName("boxProjectionProperty")
    get() = isBoxProjectionEnabled()
    @JvmName("boxProjectionProperty")
    set(`value`) {
      setEnableBoxProjection(value)
    }

  /**
   * If `true`, reflections will ignore sky contribution.
   */
  public final inline var interior: Boolean
    @JvmName("interiorProperty")
    get() = isSetAsInterior()
    @JvmName("interiorProperty")
    set(`value`) {
      setAsInterior(value)
    }

  /**
   * If `true`, computes shadows in the reflection probe. This makes the reflection probe slower to
   * render; you may want to disable this if using the [UPDATE_ALWAYS] [updateMode].
   */
  public final inline var enableShadows: Boolean
    @JvmName("enableShadowsProperty")
    get() = areShadowsEnabled()
    @JvmName("enableShadowsProperty")
    set(`value`) {
      setEnableShadows(value)
    }

  /**
   * Sets the cull mask which determines what objects are drawn by this probe. Every
   * [VisualInstance3D] with a layer included in this cull mask will be rendered by the probe. It is
   * best to only include large objects which are likely to take up a lot of space in the reflection in
   * order to save on rendering cost.
   *
   * This can also be used to prevent an object from reflecting upon itself (for instance, a
   * [ReflectionProbe] centered on a vehicle).
   */
  public final inline var cullMask: Long
    @JvmName("cullMaskProperty")
    get() = getCullMask()
    @JvmName("cullMaskProperty")
    set(`value`) {
      setCullMask(value)
    }

  /**
   * Sets the reflection mask which determines what objects have reflections applied from this
   * probe. Every [VisualInstance3D] with a layer included in this reflection mask will have
   * reflections applied from this probe. See also [cullMask], which can be used to exclude objects
   * from appearing in the reflection while still making them affected by the [ReflectionProbe].
   */
  public final inline var reflectionMask: Long
    @JvmName("reflectionMaskProperty")
    get() = getReflectionMask()
    @JvmName("reflectionMaskProperty")
    set(`value`) {
      setReflectionMask(value)
    }

  /**
   * The automatic LOD bias to use for meshes rendered within the [ReflectionProbe] (this is analog
   * to [Viewport.meshLodThreshold]). Higher values will use less detailed versions of meshes that have
   * LOD variations generated. If set to `0.0`, automatic LOD is disabled. Increase [meshLodThreshold]
   * to improve performance at the cost of geometry detail, especially when using the [UPDATE_ALWAYS]
   * [updateMode].
   *
   * **Note:** [meshLodThreshold] does not affect [GeometryInstance3D] visibility ranges (also known
   * as "manual" LOD or hierarchical LOD).
   */
  public final inline var meshLodThreshold: Float
    @JvmName("meshLodThresholdProperty")
    get() = getMeshLodThreshold()
    @JvmName("meshLodThresholdProperty")
    set(`value`) {
      setMeshLodThreshold(value)
    }

  /**
   * The ambient color to use within the [ReflectionProbe]'s box defined by its [size]. The ambient
   * color will smoothly blend with other [ReflectionProbe]s and the rest of the scene (outside the
   * [ReflectionProbe]'s box defined by its [size]).
   */
  public final inline var ambientMode: AmbientMode
    @JvmName("ambientModeProperty")
    get() = getAmbientMode()
    @JvmName("ambientModeProperty")
    set(`value`) {
      setAmbientMode(value)
    }

  /**
   * The custom ambient color to use within the [ReflectionProbe]'s box defined by its [size]. Only
   * effective if [ambientMode] is [AMBIENT_COLOR].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var ambientColor: Color
    @JvmName("ambientColorProperty")
    get() = getAmbientColor()
    @JvmName("ambientColorProperty")
    set(`value`) {
      setAmbientColor(value)
    }

  /**
   * The custom ambient color energy to use within the [ReflectionProbe]'s box defined by its
   * [size]. Only effective if [ambientMode] is [AMBIENT_COLOR].
   */
  public final inline var ambientColorEnergy: Float
    @JvmName("ambientColorEnergyProperty")
    get() = getAmbientColorEnergy()
    @JvmName("ambientColorEnergyProperty")
    set(`value`) {
      setAmbientColorEnergy(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(604, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = reflectionprobe.size
   * //Your changes
   * reflectionprobe.size = myCoreType
   * ``````
   *
   * The size of the reflection probe. The larger the size, the more space covered by the probe,
   * which will lower the perceived resolution. It is best to keep the size only as large as you need
   * it.
   *
   * **Note:** To better fit areas that are not aligned to the grid, you can rotate the
   * [ReflectionProbe] node.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  /**
   * This is a helper function for [originOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = reflectionprobe.originOffset
   * //Your changes
   * reflectionprobe.originOffset = myCoreType
   * ``````
   *
   * Sets the origin offset to be used when this [ReflectionProbe] is in [boxProjection] mode. This
   * can be set to a non-zero value to ensure a reflection fits a rectangle-shaped room, while reducing
   * the number of objects that "get in the way" of the reflection.
   */
  @CoreTypeHelper
  public final fun originOffsetMutate(block: Vector3.() -> Unit): Vector3 = originOffset.apply {
     block(this)
     originOffset = this
  }

  /**
   * This is a helper function for [ambientColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = reflectionprobe.ambientColor
   * //Your changes
   * reflectionprobe.ambientColor = myCoreType
   * ``````
   *
   * The custom ambient color to use within the [ReflectionProbe]'s box defined by its [size]. Only
   * effective if [ambientMode] is [AMBIENT_COLOR].
   */
  @CoreTypeHelper
  public final fun ambientColorMutate(block: Color.() -> Unit): Color = ambientColor.apply {
     block(this)
     ambientColor = this
  }

  public final fun setIntensity(intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.setIntensityPtr)
  }

  public final fun getIntensity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIntensityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBlendDistance(blendDistance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to blendDistance.toDouble())
    TransferContext.callMethod(MethodBindings.setBlendDistancePtr)
  }

  public final fun getBlendDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAmbientMode(ambient: AmbientMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ambient.value)
    TransferContext.callMethod(MethodBindings.setAmbientModePtr)
  }

  public final fun getAmbientMode(): AmbientMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientModePtr)
    return AmbientMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAmbientColor(ambient: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to ambient)
    TransferContext.callMethod(MethodBindings.setAmbientColorPtr)
  }

  public final fun getAmbientColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setAmbientColorEnergy(ambientEnergy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ambientEnergy.toDouble())
    TransferContext.callMethod(MethodBindings.setAmbientColorEnergyPtr)
  }

  public final fun getAmbientColorEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmbientColorEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMaxDistance(maxDistance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to maxDistance.toDouble())
    TransferContext.callMethod(MethodBindings.setMaxDistancePtr)
  }

  public final fun getMaxDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMeshLodThreshold(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setMeshLodThresholdPtr)
  }

  public final fun getMeshLodThreshold(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshLodThresholdPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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

  public final fun setOriginOffset(originOffset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to originOffset)
    TransferContext.callMethod(MethodBindings.setOriginOffsetPtr)
  }

  public final fun getOriginOffset(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setAsInterior(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAsInteriorPtr)
  }

  public final fun isSetAsInterior(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSetAsInteriorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEnableBoxProjection(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEnableBoxProjectionPtr)
  }

  public final fun isBoxProjectionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBoxProjectionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEnableShadows(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEnableShadowsPtr)
  }

  public final fun areShadowsEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areShadowsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCullMask(layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layers)
    TransferContext.callMethod(MethodBindings.setCullMaskPtr)
  }

  public final fun getCullMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCullMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setReflectionMask(layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layers)
    TransferContext.callMethod(MethodBindings.setReflectionMaskPtr)
  }

  public final fun getReflectionMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReflectionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setUpdateMode(mode: UpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setUpdateModePtr)
  }

  public final fun getUpdateMode(): UpdateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpdateModePtr)
    return UpdateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class UpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Update the probe once on the next frame (recommended for most objects). The corresponding
     * radiance map will be generated over the following six frames. This takes more time to update
     * than [UPDATE_ALWAYS], but it has a lower performance cost and can result in higher-quality
     * reflections. The ReflectionProbe is updated when its transform changes, but not when nearby
     * geometry changes. You can force a [ReflectionProbe] update by moving the [ReflectionProbe]
     * slightly in any direction.
     */
    ONCE(0),
    /**
     * Update the probe every frame. This provides better results for fast-moving dynamic objects
     * (such as cars). However, it has a significant performance cost. Due to the cost, it's
     * recommended to only use one ReflectionProbe with [UPDATE_ALWAYS] at most per scene. For all
     * other use cases, use [UPDATE_ONCE].
     */
    ALWAYS(1),
    ;

    public companion object {
      public fun from(`value`: Long): UpdateMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class AmbientMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not apply any ambient lighting inside the [ReflectionProbe]'s box defined by its [size].
     */
    DISABLED(0),
    /**
     * Apply automatically-sourced environment lighting inside the [ReflectionProbe]'s box defined
     * by its [size].
     */
    ENVIRONMENT(1),
    /**
     * Apply custom ambient lighting inside the [ReflectionProbe]'s box defined by its [size]. See
     * [ambientColor] and [ambientColorEnergy].
     */
    COLOR(2),
    ;

    public companion object {
      public fun from(`value`: Long): AmbientMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setIntensityName: MethodStringName1<ReflectionProbe, Unit, Float> =
        MethodStringName1<ReflectionProbe, Unit, Float>("set_intensity")

    @JvmField
    public val getIntensityName: MethodStringName0<ReflectionProbe, Float> =
        MethodStringName0<ReflectionProbe, Float>("get_intensity")

    @JvmField
    public val setBlendDistanceName: MethodStringName1<ReflectionProbe, Unit, Float> =
        MethodStringName1<ReflectionProbe, Unit, Float>("set_blend_distance")

    @JvmField
    public val getBlendDistanceName: MethodStringName0<ReflectionProbe, Float> =
        MethodStringName0<ReflectionProbe, Float>("get_blend_distance")

    @JvmField
    public val setAmbientModeName: MethodStringName1<ReflectionProbe, Unit, AmbientMode> =
        MethodStringName1<ReflectionProbe, Unit, AmbientMode>("set_ambient_mode")

    @JvmField
    public val getAmbientModeName: MethodStringName0<ReflectionProbe, AmbientMode> =
        MethodStringName0<ReflectionProbe, AmbientMode>("get_ambient_mode")

    @JvmField
    public val setAmbientColorName: MethodStringName1<ReflectionProbe, Unit, Color> =
        MethodStringName1<ReflectionProbe, Unit, Color>("set_ambient_color")

    @JvmField
    public val getAmbientColorName: MethodStringName0<ReflectionProbe, Color> =
        MethodStringName0<ReflectionProbe, Color>("get_ambient_color")

    @JvmField
    public val setAmbientColorEnergyName: MethodStringName1<ReflectionProbe, Unit, Float> =
        MethodStringName1<ReflectionProbe, Unit, Float>("set_ambient_color_energy")

    @JvmField
    public val getAmbientColorEnergyName: MethodStringName0<ReflectionProbe, Float> =
        MethodStringName0<ReflectionProbe, Float>("get_ambient_color_energy")

    @JvmField
    public val setMaxDistanceName: MethodStringName1<ReflectionProbe, Unit, Float> =
        MethodStringName1<ReflectionProbe, Unit, Float>("set_max_distance")

    @JvmField
    public val getMaxDistanceName: MethodStringName0<ReflectionProbe, Float> =
        MethodStringName0<ReflectionProbe, Float>("get_max_distance")

    @JvmField
    public val setMeshLodThresholdName: MethodStringName1<ReflectionProbe, Unit, Float> =
        MethodStringName1<ReflectionProbe, Unit, Float>("set_mesh_lod_threshold")

    @JvmField
    public val getMeshLodThresholdName: MethodStringName0<ReflectionProbe, Float> =
        MethodStringName0<ReflectionProbe, Float>("get_mesh_lod_threshold")

    @JvmField
    public val setSizeName: MethodStringName1<ReflectionProbe, Unit, Vector3> =
        MethodStringName1<ReflectionProbe, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<ReflectionProbe, Vector3> =
        MethodStringName0<ReflectionProbe, Vector3>("get_size")

    @JvmField
    public val setOriginOffsetName: MethodStringName1<ReflectionProbe, Unit, Vector3> =
        MethodStringName1<ReflectionProbe, Unit, Vector3>("set_origin_offset")

    @JvmField
    public val getOriginOffsetName: MethodStringName0<ReflectionProbe, Vector3> =
        MethodStringName0<ReflectionProbe, Vector3>("get_origin_offset")

    @JvmField
    public val setAsInteriorName: MethodStringName1<ReflectionProbe, Unit, Boolean> =
        MethodStringName1<ReflectionProbe, Unit, Boolean>("set_as_interior")

    @JvmField
    public val isSetAsInteriorName: MethodStringName0<ReflectionProbe, Boolean> =
        MethodStringName0<ReflectionProbe, Boolean>("is_set_as_interior")

    @JvmField
    public val setEnableBoxProjectionName: MethodStringName1<ReflectionProbe, Unit, Boolean> =
        MethodStringName1<ReflectionProbe, Unit, Boolean>("set_enable_box_projection")

    @JvmField
    public val isBoxProjectionEnabledName: MethodStringName0<ReflectionProbe, Boolean> =
        MethodStringName0<ReflectionProbe, Boolean>("is_box_projection_enabled")

    @JvmField
    public val setEnableShadowsName: MethodStringName1<ReflectionProbe, Unit, Boolean> =
        MethodStringName1<ReflectionProbe, Unit, Boolean>("set_enable_shadows")

    @JvmField
    public val areShadowsEnabledName: MethodStringName0<ReflectionProbe, Boolean> =
        MethodStringName0<ReflectionProbe, Boolean>("are_shadows_enabled")

    @JvmField
    public val setCullMaskName: MethodStringName1<ReflectionProbe, Unit, Long> =
        MethodStringName1<ReflectionProbe, Unit, Long>("set_cull_mask")

    @JvmField
    public val getCullMaskName: MethodStringName0<ReflectionProbe, Long> =
        MethodStringName0<ReflectionProbe, Long>("get_cull_mask")

    @JvmField
    public val setReflectionMaskName: MethodStringName1<ReflectionProbe, Unit, Long> =
        MethodStringName1<ReflectionProbe, Unit, Long>("set_reflection_mask")

    @JvmField
    public val getReflectionMaskName: MethodStringName0<ReflectionProbe, Long> =
        MethodStringName0<ReflectionProbe, Long>("get_reflection_mask")

    @JvmField
    public val setUpdateModeName: MethodStringName1<ReflectionProbe, Unit, UpdateMode> =
        MethodStringName1<ReflectionProbe, Unit, UpdateMode>("set_update_mode")

    @JvmField
    public val getUpdateModeName: MethodStringName0<ReflectionProbe, UpdateMode> =
        MethodStringName0<ReflectionProbe, UpdateMode>("get_update_mode")
  }

  public object MethodBindings {
    internal val setIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_intensity", 373806689)

    internal val getIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_intensity", 1740695150)

    internal val setBlendDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_blend_distance", 373806689)

    internal val getBlendDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_blend_distance", 1740695150)

    internal val setAmbientModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_ambient_mode", 1748981278)

    internal val getAmbientModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_ambient_mode", 1014607621)

    internal val setAmbientColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_ambient_color", 2920490490)

    internal val getAmbientColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_ambient_color", 3444240500)

    internal val setAmbientColorEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_ambient_color_energy", 373806689)

    internal val getAmbientColorEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_ambient_color_energy", 1740695150)

    internal val setMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_max_distance", 373806689)

    internal val getMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_max_distance", 1740695150)

    internal val setMeshLodThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_mesh_lod_threshold", 373806689)

    internal val getMeshLodThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_mesh_lod_threshold", 1740695150)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_size", 3360562783)

    internal val setOriginOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_origin_offset", 3460891852)

    internal val getOriginOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_origin_offset", 3360562783)

    internal val setAsInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_as_interior", 2586408642)

    internal val isSetAsInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "is_set_as_interior", 36873697)

    internal val setEnableBoxProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_enable_box_projection", 2586408642)

    internal val isBoxProjectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "is_box_projection_enabled", 36873697)

    internal val setEnableShadowsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_enable_shadows", 2586408642)

    internal val areShadowsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "are_shadows_enabled", 36873697)

    internal val setCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_cull_mask", 1286410249)

    internal val getCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_cull_mask", 3905245786)

    internal val setReflectionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_reflection_mask", 1286410249)

    internal val getReflectionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_reflection_mask", 3905245786)

    internal val setUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "set_update_mode", 4090221187)

    internal val getUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ReflectionProbe", "get_update_mode", 2367550552)
  }
}
