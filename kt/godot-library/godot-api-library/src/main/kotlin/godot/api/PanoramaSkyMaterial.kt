// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.VariantParser.BOOL
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
 * A resource referenced in a [Sky] that is used to draw a background. [PanoramaSkyMaterial]
 * functions similar to skyboxes in other engines, except it uses an equirectangular sky map instead of
 * a [Cubemap].
 *
 * Using an HDR panorama is strongly recommended for accurate, high-quality reflections. Godot
 * supports the Radiance HDR (`.hdr`) and OpenEXR (`.exr`) image formats for this purpose.
 *
 * You can use
 * [url=https://danilw.github.io/GLSL-howto/cubemap_to_panorama_js/cubemap_to_panorama.html]this
 * tool[/url] to convert a cubemap to an equirectangular sky map.
 */
@GodotBaseType
public open class PanoramaSkyMaterial : Material() {
  /**
   * [Texture2D] to be applied to the [PanoramaSkyMaterial].
   */
  public final inline var panorama: Texture2D?
    @JvmName("panoramaProperty")
    get() = getPanorama()
    @JvmName("panoramaProperty")
    set(`value`) {
      setPanorama(value)
    }

  /**
   * A boolean value to determine if the background texture should be filtered or not.
   */
  public final inline var filter: Boolean
    @JvmName("filterProperty")
    get() = isFilteringEnabled()
    @JvmName("filterProperty")
    set(`value`) {
      setFilteringEnabled(value)
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
    createNativeObject(509, scriptPtr)
  }

  public final fun setPanorama(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setPanoramaPtr)
  }

  public final fun getPanorama(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPanoramaPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setFilteringEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFilteringEnabledPtr)
  }

  public final fun isFilteringEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFilteringEnabledPtr)
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
    throw NotImplementedError("PanoramaSkyMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("PanoramaSkyMaterial::_getShaderMode can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setPanoramaName: MethodStringName1<PanoramaSkyMaterial, Unit, Texture2D?> =
        MethodStringName1<PanoramaSkyMaterial, Unit, Texture2D?>("set_panorama")

    @JvmField
    public val getPanoramaName: MethodStringName0<PanoramaSkyMaterial, Texture2D?> =
        MethodStringName0<PanoramaSkyMaterial, Texture2D?>("get_panorama")

    @JvmField
    public val setFilteringEnabledName: MethodStringName1<PanoramaSkyMaterial, Unit, Boolean> =
        MethodStringName1<PanoramaSkyMaterial, Unit, Boolean>("set_filtering_enabled")

    @JvmField
    public val isFilteringEnabledName: MethodStringName0<PanoramaSkyMaterial, Boolean> =
        MethodStringName0<PanoramaSkyMaterial, Boolean>("is_filtering_enabled")

    @JvmField
    public val setEnergyMultiplierName: MethodStringName1<PanoramaSkyMaterial, Unit, Float> =
        MethodStringName1<PanoramaSkyMaterial, Unit, Float>("set_energy_multiplier")

    @JvmField
    public val getEnergyMultiplierName: MethodStringName0<PanoramaSkyMaterial, Float> =
        MethodStringName0<PanoramaSkyMaterial, Float>("get_energy_multiplier")
  }

  public object MethodBindings {
    internal val setPanoramaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PanoramaSkyMaterial", "set_panorama", 4051416890)

    internal val getPanoramaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PanoramaSkyMaterial", "get_panorama", 3635182373)

    internal val setFilteringEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PanoramaSkyMaterial", "set_filtering_enabled", 2586408642)

    internal val isFilteringEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PanoramaSkyMaterial", "is_filtering_enabled", 36873697)

    internal val setEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PanoramaSkyMaterial", "set_energy_multiplier", 373806689)

    internal val getEnergyMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PanoramaSkyMaterial", "get_energy_multiplier", 1740695150)
  }
}
