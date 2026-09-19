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
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_PACKED_COLOR_ARRAY
import godot.callPtrMethod0_ret_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_DOUBLE_COLOR
import godot.callPtrMethod_DOUBLE_ret_COLOR
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_COLOR
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_ret_COLOR
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_PACKED_COLOR_ARRAY
import godot.callPtrMethod_PACKED_FLOAT_32_ARRAY
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This resource describes a color transition by defining a set of colored points and how to
 * interpolate between them.
 *
 * See also [Curve] which supports more complex easing methods, but does not support colors.
 */
@GodotBaseType
public open class Gradient : Resource() {
  /**
   * The algorithm used to interpolate between points of the gradient.
   */
  public final inline var interpolationMode: InterpolationMode
    @JvmName("interpolationModeProperty")
    get() = getInterpolationMode()
    @JvmName("interpolationModeProperty")
    set(`value`) {
      setInterpolationMode(value)
    }

  /**
   * The color space used to interpolate between points of the gradient. It does not affect the
   * returned colors, which will always use nonlinear sRGB encoding.
   *
   * **Note:** This setting has no effect when [interpolationMode] is set to
   * [GRADIENT_INTERPOLATE_CONSTANT].
   */
  public final inline var interpolationColorSpace: ColorSpace
    @JvmName("interpolationColorSpaceProperty")
    get() = getInterpolationColorSpace()
    @JvmName("interpolationColorSpaceProperty")
    set(`value`) {
      setInterpolationColorSpace(value)
    }

  /**
   * Gradient's offsets as a [PackedFloat32Array].
   *
   * **Note:** Setting this property updates all offsets at once. To update any offset individually
   * use [setOffset].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offsets: PackedFloat32Array
    @JvmName("offsetsProperty")
    get() = getOffsets()
    @JvmName("offsetsProperty")
    set(`value`) {
      setOffsets(value)
    }

  /**
   * Gradient's colors as a [PackedColorArray].
   *
   * **Note:** Setting this property updates all colors at once. To update any color individually
   * use [setColor].
   */
  public final inline var colors: PackedColorArray
    @JvmName("colorsProperty")
    get() = getColors()
    @JvmName("colorsProperty")
    set(`value`) {
      setColors(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(274, scriptPtr)
  }

  /**
   * This is a helper function for [offsets] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gradient.offsets
   * //Your changes
   * gradient.offsets = myCoreType
   * ``````
   *
   * Gradient's offsets as a [PackedFloat32Array].
   *
   * **Note:** Setting this property updates all offsets at once. To update any offset individually
   * use [setOffset].
   */
  @CoreTypeHelper
  public final fun offsetsMutate(block: PackedFloat32Array.() -> Unit): PackedFloat32Array =
      offsets.apply {
     block(this)
     offsets = this
  }

  /**
   * This is a helper function for [offsets] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Gradient's offsets as a [PackedFloat32Array].
   *
   * **Note:** Setting this property updates all offsets at once. To update any offset individually
   * use [setOffset].
   */
  @CoreTypeHelper
  public final fun offsetsMutateEach(block: (index: Int, `value`: Float) -> Unit):
      PackedFloat32Array = offsets.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     offsets = this
  }

  /**
   * Adds the specified color to the gradient, with the specified offset.
   */
  public final fun addPoint(offset: Float, color: Color): Unit {
    TransferContext.callPtrMethod_DOUBLE_COLOR(ptr, objectID.id, MethodBindings.addPointPtr, offset.toDouble(), color)
  }

  /**
   * Removes the color at index [point].
   */
  public final fun removePoint(point: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.removePointPtr, point.toLong())
  }

  /**
   * Sets the offset for the gradient color at index [point].
   */
  public final fun setOffset(point: Int, offset: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setOffsetPtr, point.toLong(), offset.toDouble())
  }

  /**
   * Returns the offset of the gradient color at index [point].
   */
  public final fun getOffset(point: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getOffsetPtr, point.toLong()).toFloat()

  /**
   * Reverses/mirrors the gradient.
   *
   * **Note:** This method mirrors all points around the middle of the gradient, which may produce
   * unexpected results when [interpolationMode] is set to [GRADIENT_INTERPOLATE_CONSTANT].
   */
  public final fun reverse(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.reversePtr)
  }

  /**
   * Sets the color of the gradient color at index [point].
   */
  public final fun setColor(point: Int, color: Color): Unit {
    TransferContext.callPtrMethod_LONG_COLOR(ptr, objectID.id, MethodBindings.setColorPtr, point.toLong(), color)
  }

  /**
   * Returns the color of the gradient color at index [point].
   */
  public final fun getColor(point: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getColorPtr, point.toLong())

  /**
   * Returns the interpolated color specified by [offset]. [offset] should be between `0.0` and
   * `1.0` (inclusive). Using a value lower than `0.0` will return the same color as `0.0`, and using a
   * value higher than `1.0` will return the same color as `1.0`. If your input value is not within
   * this range, consider using [@GlobalScope.remap] on the input value with output values set to `0.0`
   * and `1.0`.
   */
  public final fun sample(offset: Float): Color =
      TransferContext.callPtrMethod_DOUBLE_ret_COLOR(ptr, objectID.id, MethodBindings.samplePtr, offset.toDouble())

  /**
   * Returns the number of colors in the gradient.
   */
  public final fun getPointCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPointCountPtr).toInt()

  public final fun setOffsets(offsets: PackedFloat32Array): Unit {
    TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.setOffsetsPtr, offsets)
  }

  public final fun getOffsets(): PackedFloat32Array =
      TransferContext.callPtrMethod0_ret_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.getOffsetsPtr)

  public final fun setColors(colors: PackedColorArray): Unit {
    TransferContext.callPtrMethod_PACKED_COLOR_ARRAY(ptr, objectID.id, MethodBindings.setColorsPtr, colors)
  }

  public final fun getColors(): PackedColorArray =
      TransferContext.callPtrMethod0_ret_PACKED_COLOR_ARRAY(ptr, objectID.id, MethodBindings.getColorsPtr)

  public final fun setInterpolationMode(interpolationMode: InterpolationMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setInterpolationModePtr, interpolationMode.value)
  }

  public final fun getInterpolationMode(): InterpolationMode =
      InterpolationMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInterpolationModePtr))

  public final fun setInterpolationColorSpace(interpolationColorSpace: ColorSpace): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setInterpolationColorSpacePtr, interpolationColorSpace.value)
  }

  public final fun getInterpolationColorSpace(): ColorSpace =
      ColorSpace.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInterpolationColorSpacePtr))

  public enum class InterpolationMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Linear interpolation.
     */
    GRADIENT_INTERPOLATE_LINEAR(0),
    /**
     * Constant interpolation, color changes abruptly at each point and stays uniform between. This
     * might cause visible aliasing when used for a gradient texture in some cases.
     */
    GRADIENT_INTERPOLATE_CONSTANT(1),
    /**
     * Cubic interpolation.
     */
    GRADIENT_INTERPOLATE_CUBIC(2),
    ;

    public companion object {
      public fun from(`value`: Long): InterpolationMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ColorSpace(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * sRGB color space.
     */
    GRADIENT_SRGB(0),
    /**
     * Linear sRGB color space.
     */
    GRADIENT_LINEAR_SRGB(1),
    /**
     * [url=https://bottosson.github.io/posts/oklab/]Oklab[/url] color space. This color space
     * provides a smooth and uniform-looking transition between colors.
     */
    GRADIENT_OKLAB(2),
    ;

    public companion object {
      public fun from(`value`: Long): ColorSpace = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addPointName: MethodStringName2<Gradient, Unit, Float, Color> =
        MethodStringName2<Gradient, Unit, Float, Color>("add_point")

    @JvmField
    public val removePointName: MethodStringName1<Gradient, Unit, Int> =
        MethodStringName1<Gradient, Unit, Int>("remove_point")

    @JvmField
    public val setOffsetName: MethodStringName2<Gradient, Unit, Int, Float> =
        MethodStringName2<Gradient, Unit, Int, Float>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName1<Gradient, Float, Int> =
        MethodStringName1<Gradient, Float, Int>("get_offset")

    @JvmField
    public val reverseName: MethodStringName0<Gradient, Unit> =
        MethodStringName0<Gradient, Unit>("reverse")

    @JvmField
    public val setColorName: MethodStringName2<Gradient, Unit, Int, Color> =
        MethodStringName2<Gradient, Unit, Int, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName1<Gradient, Color, Int> =
        MethodStringName1<Gradient, Color, Int>("get_color")

    @JvmField
    public val sampleName: MethodStringName1<Gradient, Color, Float> =
        MethodStringName1<Gradient, Color, Float>("sample")

    @JvmField
    public val getPointCountName: MethodStringName0<Gradient, Int> =
        MethodStringName0<Gradient, Int>("get_point_count")

    @JvmField
    public val setOffsetsName: MethodStringName1<Gradient, Unit, PackedFloat32Array> =
        MethodStringName1<Gradient, Unit, PackedFloat32Array>("set_offsets")

    @JvmField
    public val getOffsetsName: MethodStringName0<Gradient, PackedFloat32Array> =
        MethodStringName0<Gradient, PackedFloat32Array>("get_offsets")

    @JvmField
    public val setColorsName: MethodStringName1<Gradient, Unit, PackedColorArray> =
        MethodStringName1<Gradient, Unit, PackedColorArray>("set_colors")

    @JvmField
    public val getColorsName: MethodStringName0<Gradient, PackedColorArray> =
        MethodStringName0<Gradient, PackedColorArray>("get_colors")

    @JvmField
    public val setInterpolationModeName: MethodStringName1<Gradient, Unit, InterpolationMode> =
        MethodStringName1<Gradient, Unit, InterpolationMode>("set_interpolation_mode")

    @JvmField
    public val getInterpolationModeName: MethodStringName0<Gradient, InterpolationMode> =
        MethodStringName0<Gradient, InterpolationMode>("get_interpolation_mode")

    @JvmField
    public val setInterpolationColorSpaceName: MethodStringName1<Gradient, Unit, ColorSpace> =
        MethodStringName1<Gradient, Unit, ColorSpace>("set_interpolation_color_space")

    @JvmField
    public val getInterpolationColorSpaceName: MethodStringName0<Gradient, ColorSpace> =
        MethodStringName0<Gradient, ColorSpace>("get_interpolation_color_space")
  }

  public object MethodBindings {
    internal val addPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "add_point", 3629403827)

    internal val removePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "remove_point", 1286410249)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "set_offset", 1602489585)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_offset", 4025615559)

    internal val reversePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "reverse", 3218959716)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "set_color", 2878471219)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_color", 2624840992)

    internal val samplePtr: VoidPtr = TypeManager.getMethodBindPtr("Gradient", "sample", 1250405064)

    internal val getPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_point_count", 3905245786)

    internal val setOffsetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "set_offsets", 2899603908)

    internal val getOffsetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_offsets", 675695659)

    internal val setColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "set_colors", 3546319833)

    internal val getColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_colors", 1392750486)

    internal val setInterpolationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "set_interpolation_mode", 1971444490)

    internal val getInterpolationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_interpolation_mode", 3674172981)

    internal val setInterpolationColorSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "set_interpolation_color_space", 3685995981)

    internal val getInterpolationColorSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Gradient", "get_interpolation_color_space", 1538296000)
  }
}
