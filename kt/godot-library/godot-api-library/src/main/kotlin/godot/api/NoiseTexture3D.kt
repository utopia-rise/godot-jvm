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
import godot.core.VariantArray
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Uses the [FastNoiseLite] library or other noise generators to fill the texture data of your
 * desired size.
 *
 * The class uses [Thread]s to generate the texture data internally, so [Texture3D.getData] may
 * return `null` if the generation process has not completed yet. In that case, you need to wait for
 * the texture to be generated before accessing the image:
 *
 * ```
 * var texture = NoiseTexture3D.new()
 * texture.noise = FastNoiseLite.new()
 * await texture.changed
 * var data = texture.get_data()
 * ```
 */
@GodotBaseType
public open class NoiseTexture3D : Texture3D() {
  /**
   * Width of the generated texture (in pixels).
   */
  public final inline var width: Int
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * Height of the generated texture (in pixels).
   */
  public final inline var height: Int
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * Depth of the generated texture (in pixels).
   */
  public final inline var depth: Int
    @JvmName("depthProperty")
    get() = getDepth()
    @JvmName("depthProperty")
    set(`value`) {
      setDepth(value)
    }

  /**
   * The instance of the [Noise] object.
   */
  public final inline var noise: Noise?
    @JvmName("noiseProperty")
    get() = getNoise()
    @JvmName("noiseProperty")
    set(`value`) {
      setNoise(value)
    }

  /**
   * A [Gradient] which is used to map the luminance of each pixel to a color value.
   */
  public final inline var colorRamp: Gradient?
    @JvmName("colorRampProperty")
    get() = getColorRamp()
    @JvmName("colorRampProperty")
    set(`value`) {
      setColorRamp(value)
    }

  /**
   * If `true`, a seamless texture is requested from the [Noise] resource.
   *
   * **Note:** Seamless noise textures may take longer to generate and/or can have a lower contrast
   * compared to non-seamless noise depending on the used [Noise] resource. This is because some
   * implementations use higher dimensions for generating seamless noise.
   *
   * **Note:** The default [FastNoiseLite] implementation uses the fallback path for seamless
   * generation. If using a [width], [height] or [depth] lower than the default, you may need to
   * increase [seamlessBlendSkirt] to make seamless blending more effective.
   */
  public final inline var seamless: Boolean
    @JvmName("seamlessProperty")
    get() = getSeamless()
    @JvmName("seamlessProperty")
    set(`value`) {
      setSeamless(value)
    }

  /**
   * If `true`, inverts the noise texture. White becomes black, black becomes white.
   */
  public final inline var invert: Boolean
    @JvmName("invertProperty")
    get() = getInvert()
    @JvmName("invertProperty")
    set(`value`) {
      setInvert(value)
    }

  /**
   * If `true`, the noise image coming from the noise generator is normalized to the range `0.0` to
   * `1.0`.
   *
   * Turning normalization off can affect the contrast and allows you to generate non repeating
   * tileable noise textures.
   */
  public final inline var normalize: Boolean
    @JvmName("normalizeProperty")
    get() = isNormalized()
    @JvmName("normalizeProperty")
    set(`value`) {
      setNormalize(value)
    }

  /**
   * Used for the default/fallback implementation of the seamless texture generation. It determines
   * the distance over which the seams are blended. High values may result in less details and
   * contrast. See [Noise] for further details.
   *
   * **Note:** If using a [width], [height] or [depth] lower than the default, you may need to
   * increase [seamlessBlendSkirt] to make seamless blending more effective.
   */
  public final inline var seamlessBlendSkirt: Float
    @JvmName("seamlessBlendSkirtProperty")
    get() = getSeamlessBlendSkirt()
    @JvmName("seamlessBlendSkirtProperty")
    set(`value`) {
      setSeamlessBlendSkirt(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(425, scriptPtr)
  }

  public final fun setWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun setHeight(height: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to height.toLong())
    TransferContext.callMethod(MethodBindings.setHeightPtr)
  }

  public final fun setDepth(depth: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to depth.toLong())
    TransferContext.callMethod(MethodBindings.setDepthPtr)
  }

  public final fun setNoise(noise: Noise?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to noise)
    TransferContext.callMethod(MethodBindings.setNoisePtr)
  }

  public final fun getNoise(): Noise? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNoisePtr)
    return (TransferContext.readReturnValue(OBJECT) as Noise?)
  }

  public final fun setColorRamp(gradient: Gradient?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to gradient)
    TransferContext.callMethod(MethodBindings.setColorRampPtr)
  }

  public final fun getColorRamp(): Gradient? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorRampPtr)
    return (TransferContext.readReturnValue(OBJECT) as Gradient?)
  }

  public final fun setSeamless(seamless: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to seamless)
    TransferContext.callMethod(MethodBindings.setSeamlessPtr)
  }

  public final fun getSeamless(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSeamlessPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setInvert(invert: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to invert)
    TransferContext.callMethod(MethodBindings.setInvertPtr)
  }

  public final fun getInvert(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInvertPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setNormalize(normalize: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to normalize)
    TransferContext.callMethod(MethodBindings.setNormalizePtr)
  }

  public final fun isNormalized(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isNormalizedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSeamlessBlendSkirt(seamlessBlendSkirt: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to seamlessBlendSkirt.toDouble())
    TransferContext.callMethod(MethodBindings.setSeamlessBlendSkirtPtr)
  }

  public final fun getSeamlessBlendSkirt(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSeamlessBlendSkirtPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("NoiseTexture3D::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("NoiseTexture3D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("NoiseTexture3D::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getDepth(): Int {
    throw NotImplementedError("NoiseTexture3D::_getDepth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("NoiseTexture3D::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getData(): VariantArray<Image> {
    throw NotImplementedError("NoiseTexture3D::_getData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setWidthName: MethodStringName1<NoiseTexture3D, Unit, Int> =
        MethodStringName1<NoiseTexture3D, Unit, Int>("set_width")

    @JvmField
    public val setHeightName: MethodStringName1<NoiseTexture3D, Unit, Int> =
        MethodStringName1<NoiseTexture3D, Unit, Int>("set_height")

    @JvmField
    public val setDepthName: MethodStringName1<NoiseTexture3D, Unit, Int> =
        MethodStringName1<NoiseTexture3D, Unit, Int>("set_depth")

    @JvmField
    public val setNoiseName: MethodStringName1<NoiseTexture3D, Unit, Noise?> =
        MethodStringName1<NoiseTexture3D, Unit, Noise?>("set_noise")

    @JvmField
    public val getNoiseName: MethodStringName0<NoiseTexture3D, Noise?> =
        MethodStringName0<NoiseTexture3D, Noise?>("get_noise")

    @JvmField
    public val setColorRampName: MethodStringName1<NoiseTexture3D, Unit, Gradient?> =
        MethodStringName1<NoiseTexture3D, Unit, Gradient?>("set_color_ramp")

    @JvmField
    public val getColorRampName: MethodStringName0<NoiseTexture3D, Gradient?> =
        MethodStringName0<NoiseTexture3D, Gradient?>("get_color_ramp")

    @JvmField
    public val setSeamlessName: MethodStringName1<NoiseTexture3D, Unit, Boolean> =
        MethodStringName1<NoiseTexture3D, Unit, Boolean>("set_seamless")

    @JvmField
    public val getSeamlessName: MethodStringName0<NoiseTexture3D, Boolean> =
        MethodStringName0<NoiseTexture3D, Boolean>("get_seamless")

    @JvmField
    public val setInvertName: MethodStringName1<NoiseTexture3D, Unit, Boolean> =
        MethodStringName1<NoiseTexture3D, Unit, Boolean>("set_invert")

    @JvmField
    public val getInvertName: MethodStringName0<NoiseTexture3D, Boolean> =
        MethodStringName0<NoiseTexture3D, Boolean>("get_invert")

    @JvmField
    public val setNormalizeName: MethodStringName1<NoiseTexture3D, Unit, Boolean> =
        MethodStringName1<NoiseTexture3D, Unit, Boolean>("set_normalize")

    @JvmField
    public val isNormalizedName: MethodStringName0<NoiseTexture3D, Boolean> =
        MethodStringName0<NoiseTexture3D, Boolean>("is_normalized")

    @JvmField
    public val setSeamlessBlendSkirtName: MethodStringName1<NoiseTexture3D, Unit, Float> =
        MethodStringName1<NoiseTexture3D, Unit, Float>("set_seamless_blend_skirt")

    @JvmField
    public val getSeamlessBlendSkirtName: MethodStringName0<NoiseTexture3D, Float> =
        MethodStringName0<NoiseTexture3D, Float>("get_seamless_blend_skirt")
  }

  public object MethodBindings {
    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_width", 1286410249)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_height", 1286410249)

    internal val setDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_depth", 1286410249)

    internal val setNoisePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_noise", 4135492439)

    internal val getNoisePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "get_noise", 185851837)

    internal val setColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_color_ramp", 2756054477)

    internal val getColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "get_color_ramp", 132272999)

    internal val setSeamlessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_seamless", 2586408642)

    internal val getSeamlessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "get_seamless", 2240911060)

    internal val setInvertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_invert", 2586408642)

    internal val getInvertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "get_invert", 36873697)

    internal val setNormalizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_normalize", 2586408642)

    internal val isNormalizedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "is_normalized", 36873697)

    internal val setSeamlessBlendSkirtPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "set_seamless_blend_skirt", 373806689)

    internal val getSeamlessBlendSkirtPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NoiseTexture3D", "get_seamless_blend_skirt", 191475506)
  }
}
