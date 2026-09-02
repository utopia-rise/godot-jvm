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
 * Casts light in a 2D environment. A light is defined as a color, an energy value, a mode (see
 * constants), and various other parameters (range and shadows-related).
 */
@GodotBaseType
public open class Light2D internal constructor() : Node2D() {
  /**
   * If `true`, Light2D will emit light.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * If `true`, Light2D will only appear when editing the scene.
   */
  public final inline var editorOnly: Boolean
    @JvmName("editorOnlyProperty")
    get() = isEditorOnly()
    @JvmName("editorOnlyProperty")
    set(`value`) {
      setEditorOnly(value)
    }

  /**
   * The Light2D's [Color].
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
   * The Light2D's energy value. The larger the value, the stronger the light.
   */
  public final inline var energy: Float
    @JvmName("energyProperty")
    get() = getEnergy()
    @JvmName("energyProperty")
    set(`value`) {
      setEnergy(value)
    }

  /**
   * The Light2D's blend mode.
   */
  public final inline var blendMode: BlendMode
    @JvmName("blendModeProperty")
    get() = getBlendMode()
    @JvmName("blendModeProperty")
    set(`value`) {
      setBlendMode(value)
    }

  /**
   * Minimum `z` value of objects that are affected by the Light2D.
   */
  public final inline var rangeZMin: Int
    @JvmName("rangeZMinProperty")
    get() = getZRangeMin()
    @JvmName("rangeZMinProperty")
    set(`value`) {
      setZRangeMin(value)
    }

  /**
   * Maximum `z` value of objects that are affected by the Light2D.
   */
  public final inline var rangeZMax: Int
    @JvmName("rangeZMaxProperty")
    get() = getZRangeMax()
    @JvmName("rangeZMaxProperty")
    set(`value`) {
      setZRangeMax(value)
    }

  /**
   * Minimum layer value of objects that are affected by the Light2D.
   */
  public final inline var rangeLayerMin: Int
    @JvmName("rangeLayerMinProperty")
    get() = getLayerRangeMin()
    @JvmName("rangeLayerMinProperty")
    set(`value`) {
      setLayerRangeMin(value)
    }

  /**
   * Maximum layer value of objects that are affected by the Light2D.
   */
  public final inline var rangeLayerMax: Int
    @JvmName("rangeLayerMaxProperty")
    get() = getLayerRangeMax()
    @JvmName("rangeLayerMaxProperty")
    set(`value`) {
      setLayerRangeMax(value)
    }

  /**
   * The layer mask. Only objects with a matching [CanvasItem.lightMask] will be affected by the
   * Light2D. See also [shadowItemCullMask], which affects which objects can cast shadows.
   *
   * **Note:** [rangeItemCullMask] is ignored by [DirectionalLight2D], which will always light a 2D
   * node regardless of the 2D node's [CanvasItem.lightMask].
   */
  public final inline var rangeItemCullMask: Int
    @JvmName("rangeItemCullMaskProperty")
    get() = getItemCullMask()
    @JvmName("rangeItemCullMaskProperty")
    set(`value`) {
      setItemCullMask(value)
    }

  /**
   * If `true`, the Light2D will cast shadows.
   */
  public final inline var shadowEnabled: Boolean
    @JvmName("shadowEnabledProperty")
    get() = isShadowEnabled()
    @JvmName("shadowEnabledProperty")
    set(`value`) {
      setShadowEnabled(value)
    }

  /**
   * [Color] of shadows cast by the Light2D.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var shadowColor: Color
    @JvmName("shadowColorProperty")
    get() = getShadowColor()
    @JvmName("shadowColorProperty")
    set(`value`) {
      setShadowColor(value)
    }

  /**
   * Shadow filter type.
   */
  public final inline var shadowFilter: ShadowFilter
    @JvmName("shadowFilterProperty")
    get() = getShadowFilter()
    @JvmName("shadowFilterProperty")
    set(`value`) {
      setShadowFilter(value)
    }

  /**
   * Smoothing value for shadows. Higher values will result in softer shadows, at the cost of
   * visible streaks that can appear in shadow rendering. [shadowFilterSmooth] only has an effect if
   * [shadowFilter] is [SHADOW_FILTER_PCF5] or [SHADOW_FILTER_PCF13].
   */
  public final inline var shadowFilterSmooth: Float
    @JvmName("shadowFilterSmoothProperty")
    get() = getShadowSmooth()
    @JvmName("shadowFilterSmoothProperty")
    set(`value`) {
      setShadowSmooth(value)
    }

  /**
   * The shadow mask. Used with [LightOccluder2D] to cast shadows. Only occluders with a matching
   * [CanvasItem.lightMask] will cast shadows. See also [rangeItemCullMask], which affects which
   * objects can *receive* the light.
   */
  public final inline var shadowItemCullMask: Int
    @JvmName("shadowItemCullMaskProperty")
    get() = getItemShadowCullMask()
    @JvmName("shadowItemCullMaskProperty")
    set(`value`) {
      setItemShadowCullMask(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(353, scriptPtr)
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = light2d.color
   * //Your changes
   * light2d.color = myCoreType
   * ``````
   *
   * The Light2D's [Color].
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  /**
   * This is a helper function for [shadowColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = light2d.shadowColor
   * //Your changes
   * light2d.shadowColor = myCoreType
   * ``````
   *
   * [Color] of shadows cast by the Light2D.
   */
  @CoreTypeHelper
  public final fun shadowColorMutate(block: Color.() -> Unit): Color = shadowColor.apply {
     block(this)
     shadowColor = this
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEnabledPtr)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEditorOnly(editorOnly: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to editorOnly)
    TransferContext.callMethod(MethodBindings.setEditorOnlyPtr)
  }

  public final fun isEditorOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditorOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setColorPtr)
  }

  public final fun getColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setEnergy(energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.setEnergyPtr)
  }

  public final fun getEnergy(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnergyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setZRangeMin(z: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to z.toLong())
    TransferContext.callMethod(MethodBindings.setZRangeMinPtr)
  }

  public final fun getZRangeMin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZRangeMinPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setZRangeMax(z: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to z.toLong())
    TransferContext.callMethod(MethodBindings.setZRangeMaxPtr)
  }

  public final fun getZRangeMax(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZRangeMaxPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setLayerRangeMin(layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.setLayerRangeMinPtr)
  }

  public final fun getLayerRangeMin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayerRangeMinPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setLayerRangeMax(layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.setLayerRangeMaxPtr)
  }

  public final fun getLayerRangeMax(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayerRangeMaxPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setItemCullMask(itemCullMask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to itemCullMask.toLong())
    TransferContext.callMethod(MethodBindings.setItemCullMaskPtr)
  }

  public final fun getItemCullMask(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getItemCullMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setItemShadowCullMask(itemShadowCullMask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to itemShadowCullMask.toLong())
    TransferContext.callMethod(MethodBindings.setItemShadowCullMaskPtr)
  }

  public final fun getItemShadowCullMask(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getItemShadowCullMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setShadowEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setShadowEnabledPtr)
  }

  public final fun isShadowEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShadowEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShadowSmooth(smooth: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to smooth.toDouble())
    TransferContext.callMethod(MethodBindings.setShadowSmoothPtr)
  }

  public final fun getShadowSmooth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowSmoothPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setShadowFilter(filter: ShadowFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.setShadowFilterPtr)
  }

  public final fun getShadowFilter(): ShadowFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowFilterPtr)
    return ShadowFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setShadowColor(shadowColor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to shadowColor)
    TransferContext.callMethod(MethodBindings.setShadowColorPtr)
  }

  public final fun getShadowColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShadowColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setBlendMode(mode: BlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBlendModePtr)
  }

  public final fun getBlendMode(): BlendMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendModePtr)
    return BlendMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the light's height, which is used in 2D normal mapping. See [PointLight2D.height] and
   * [DirectionalLight2D.height].
   */
  public final fun setHeight(height: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to height.toDouble())
    TransferContext.callMethod(MethodBindings.setHeightPtr)
  }

  /**
   * Returns the light's height, which is used in 2D normal mapping. See [PointLight2D.height] and
   * [DirectionalLight2D.height].
   */
  public final fun getHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public enum class ShadowFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No filter applies to the shadow map. This provides hard shadow edges and is the fastest to
     * render. See [shadowFilter].
     */
    NONE(0),
    /**
     * Percentage closer filtering (5 samples) applies to the shadow map. This is slower compared to
     * hard shadow rendering. See [shadowFilter].
     */
    PCF5(1),
    /**
     * Percentage closer filtering (13 samples) applies to the shadow map. This is the slowest
     * shadow filtering mode, and should be used sparingly. See [shadowFilter].
     */
    PCF13(2),
    ;

    public companion object {
      public fun from(`value`: Long): ShadowFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class BlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Adds the value of pixels corresponding to the Light2D to the values of pixels under it. This
     * is the common behavior of a light.
     */
    ADD(0),
    /**
     * Subtracts the value of pixels corresponding to the Light2D to the values of pixels under it,
     * resulting in inversed light effect.
     */
    SUB(1),
    /**
     * Mix the value of pixels corresponding to the Light2D to the values of pixels under it by
     * linear interpolation.
     */
    MIX(2),
    ;

    public companion object {
      public fun from(`value`: Long): BlendMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setEnabledName: MethodStringName1<Light2D, Unit, Boolean> =
        MethodStringName1<Light2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<Light2D, Boolean> =
        MethodStringName0<Light2D, Boolean>("is_enabled")

    @JvmField
    public val setEditorOnlyName: MethodStringName1<Light2D, Unit, Boolean> =
        MethodStringName1<Light2D, Unit, Boolean>("set_editor_only")

    @JvmField
    public val isEditorOnlyName: MethodStringName0<Light2D, Boolean> =
        MethodStringName0<Light2D, Boolean>("is_editor_only")

    @JvmField
    public val setColorName: MethodStringName1<Light2D, Unit, Color> =
        MethodStringName1<Light2D, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<Light2D, Color> =
        MethodStringName0<Light2D, Color>("get_color")

    @JvmField
    public val setEnergyName: MethodStringName1<Light2D, Unit, Float> =
        MethodStringName1<Light2D, Unit, Float>("set_energy")

    @JvmField
    public val getEnergyName: MethodStringName0<Light2D, Float> =
        MethodStringName0<Light2D, Float>("get_energy")

    @JvmField
    public val setZRangeMinName: MethodStringName1<Light2D, Unit, Int> =
        MethodStringName1<Light2D, Unit, Int>("set_z_range_min")

    @JvmField
    public val getZRangeMinName: MethodStringName0<Light2D, Int> =
        MethodStringName0<Light2D, Int>("get_z_range_min")

    @JvmField
    public val setZRangeMaxName: MethodStringName1<Light2D, Unit, Int> =
        MethodStringName1<Light2D, Unit, Int>("set_z_range_max")

    @JvmField
    public val getZRangeMaxName: MethodStringName0<Light2D, Int> =
        MethodStringName0<Light2D, Int>("get_z_range_max")

    @JvmField
    public val setLayerRangeMinName: MethodStringName1<Light2D, Unit, Int> =
        MethodStringName1<Light2D, Unit, Int>("set_layer_range_min")

    @JvmField
    public val getLayerRangeMinName: MethodStringName0<Light2D, Int> =
        MethodStringName0<Light2D, Int>("get_layer_range_min")

    @JvmField
    public val setLayerRangeMaxName: MethodStringName1<Light2D, Unit, Int> =
        MethodStringName1<Light2D, Unit, Int>("set_layer_range_max")

    @JvmField
    public val getLayerRangeMaxName: MethodStringName0<Light2D, Int> =
        MethodStringName0<Light2D, Int>("get_layer_range_max")

    @JvmField
    public val setItemCullMaskName: MethodStringName1<Light2D, Unit, Int> =
        MethodStringName1<Light2D, Unit, Int>("set_item_cull_mask")

    @JvmField
    public val getItemCullMaskName: MethodStringName0<Light2D, Int> =
        MethodStringName0<Light2D, Int>("get_item_cull_mask")

    @JvmField
    public val setItemShadowCullMaskName: MethodStringName1<Light2D, Unit, Int> =
        MethodStringName1<Light2D, Unit, Int>("set_item_shadow_cull_mask")

    @JvmField
    public val getItemShadowCullMaskName: MethodStringName0<Light2D, Int> =
        MethodStringName0<Light2D, Int>("get_item_shadow_cull_mask")

    @JvmField
    public val setShadowEnabledName: MethodStringName1<Light2D, Unit, Boolean> =
        MethodStringName1<Light2D, Unit, Boolean>("set_shadow_enabled")

    @JvmField
    public val isShadowEnabledName: MethodStringName0<Light2D, Boolean> =
        MethodStringName0<Light2D, Boolean>("is_shadow_enabled")

    @JvmField
    public val setShadowSmoothName: MethodStringName1<Light2D, Unit, Float> =
        MethodStringName1<Light2D, Unit, Float>("set_shadow_smooth")

    @JvmField
    public val getShadowSmoothName: MethodStringName0<Light2D, Float> =
        MethodStringName0<Light2D, Float>("get_shadow_smooth")

    @JvmField
    public val setShadowFilterName: MethodStringName1<Light2D, Unit, ShadowFilter> =
        MethodStringName1<Light2D, Unit, ShadowFilter>("set_shadow_filter")

    @JvmField
    public val getShadowFilterName: MethodStringName0<Light2D, ShadowFilter> =
        MethodStringName0<Light2D, ShadowFilter>("get_shadow_filter")

    @JvmField
    public val setShadowColorName: MethodStringName1<Light2D, Unit, Color> =
        MethodStringName1<Light2D, Unit, Color>("set_shadow_color")

    @JvmField
    public val getShadowColorName: MethodStringName0<Light2D, Color> =
        MethodStringName0<Light2D, Color>("get_shadow_color")

    @JvmField
    public val setBlendModeName: MethodStringName1<Light2D, Unit, BlendMode> =
        MethodStringName1<Light2D, Unit, BlendMode>("set_blend_mode")

    @JvmField
    public val getBlendModeName: MethodStringName0<Light2D, BlendMode> =
        MethodStringName0<Light2D, BlendMode>("get_blend_mode")

    @JvmField
    public val setHeightName: MethodStringName1<Light2D, Unit, Float> =
        MethodStringName1<Light2D, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<Light2D, Float> =
        MethodStringName0<Light2D, Float>("get_height")
  }

  public object MethodBindings {
    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "is_enabled", 36873697)

    internal val setEditorOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_editor_only", 2586408642)

    internal val isEditorOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "is_editor_only", 36873697)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_color", 3444240500)

    internal val setEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_energy", 373806689)

    internal val getEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_energy", 1740695150)

    internal val setZRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_z_range_min", 1286410249)

    internal val getZRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_z_range_min", 3905245786)

    internal val setZRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_z_range_max", 1286410249)

    internal val getZRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_z_range_max", 3905245786)

    internal val setLayerRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_layer_range_min", 1286410249)

    internal val getLayerRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_layer_range_min", 3905245786)

    internal val setLayerRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_layer_range_max", 1286410249)

    internal val getLayerRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_layer_range_max", 3905245786)

    internal val setItemCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_item_cull_mask", 1286410249)

    internal val getItemCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_item_cull_mask", 3905245786)

    internal val setItemShadowCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_item_shadow_cull_mask", 1286410249)

    internal val getItemShadowCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_item_shadow_cull_mask", 3905245786)

    internal val setShadowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_shadow_enabled", 2586408642)

    internal val isShadowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "is_shadow_enabled", 36873697)

    internal val setShadowSmoothPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_shadow_smooth", 373806689)

    internal val getShadowSmoothPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_shadow_smooth", 1740695150)

    internal val setShadowFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_shadow_filter", 3209356555)

    internal val getShadowFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_shadow_filter", 1973619177)

    internal val setShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_shadow_color", 2920490490)

    internal val getShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_shadow_color", 3444240500)

    internal val setBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_blend_mode", 2916638796)

    internal val getBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_blend_mode", 936255250)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Light2D", "get_height", 1740695150)
  }
}
