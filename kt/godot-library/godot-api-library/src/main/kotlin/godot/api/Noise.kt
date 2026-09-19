// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_ret_DOUBLE
import godot.callPtrMethod_DOUBLE_DOUBLE_ret_DOUBLE
import godot.callPtrMethod_DOUBLE_ret_DOUBLE
import godot.callPtrMethod_LONG_LONG_BOOL_BOOL_BOOL_ret_OBJECT_REF
import godot.callPtrMethod_LONG_LONG_BOOL_BOOL_DOUBLE_BOOL_ret_OBJECT_REF
import godot.callPtrMethod_LONG_LONG_LONG_BOOL_BOOL_ret_ARRAY
import godot.callPtrMethod_LONG_LONG_LONG_BOOL_DOUBLE_BOOL_ret_ARRAY
import godot.callPtrMethod_VECTOR2_ret_DOUBLE
import godot.callPtrMethod_VECTOR3_ret_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class defines the interface for noise generation libraries to inherit from.
 *
 * A default [getSeamlessImage] implementation is provided for libraries that do not provide
 * seamless noise. This function requests a larger image from the [getImage] method, reverses the
 * quadrants of the image, then uses the strips of extra width to blend over the seams.
 *
 * Inheriting noise classes can optionally override this function to provide a more optimal
 * algorithm.
 */
@GodotBaseType
public open class Noise internal constructor() : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(423, scriptPtr)
  }

  /**
   * Returns the 1D noise value at the given (x) coordinate.
   */
  public final fun getNoise1d(x: Float): Float =
      TransferContext.callPtrMethod_DOUBLE_ret_DOUBLE(ptr, objectID.id, MethodBindings.getNoise1dPtr, x.toDouble()).toFloat()

  /**
   * Returns the 2D noise value at the given position.
   */
  public final fun getNoise2d(x: Float, y: Float): Float =
      TransferContext.callPtrMethod_DOUBLE_DOUBLE_ret_DOUBLE(ptr, objectID.id, MethodBindings.getNoise2dPtr, x.toDouble(), y.toDouble()).toFloat()

  /**
   * Returns the 2D noise value at the given position.
   */
  public final fun getNoise2dv(v: Vector2): Float =
      TransferContext.callPtrMethod_VECTOR2_ret_DOUBLE(ptr, objectID.id, MethodBindings.getNoise2dvPtr, v).toFloat()

  /**
   * Returns the 3D noise value at the given position.
   */
  public final fun getNoise3d(
    x: Float,
    y: Float,
    z: Float,
  ): Float =
      TransferContext.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_ret_DOUBLE(ptr, objectID.id, MethodBindings.getNoise3dPtr, x.toDouble(), y.toDouble(), z.toDouble()).toFloat()

  /**
   * Returns the 3D noise value at the given position.
   */
  public final fun getNoise3dv(v: Vector3): Float =
      TransferContext.callPtrMethod_VECTOR3_ret_DOUBLE(ptr, objectID.id, MethodBindings.getNoise3dvPtr, v).toFloat()

  /**
   * Returns an [Image] containing 2D noise values.
   *
   * **Note:** With [normalize] set to `false`, the default implementation expects the noise
   * generator to return values in the range `-1.0` to `1.0`.
   */
  @JvmOverloads
  public final fun getImage(
    width: Int,
    height: Int,
    invert: Boolean = false,
    in3dSpace: Boolean = false,
    normalize: Boolean = true,
  ): Image? =
      (TransferContext.callPtrMethod_LONG_LONG_BOOL_BOOL_BOOL_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getImagePtr, width.toLong(), height.toLong(), invert, in3dSpace, normalize) as Image?)

  /**
   * Returns an [Image] containing seamless 2D noise values.
   *
   * **Note:** With [normalize] set to `false`, the default implementation expects the noise
   * generator to return values in the range `-1.0` to `1.0`.
   */
  @JvmOverloads
  public final fun getSeamlessImage(
    width: Int,
    height: Int,
    invert: Boolean = false,
    in3dSpace: Boolean = false,
    skirt: Float = 0.1f,
    normalize: Boolean = true,
  ): Image? =
      (TransferContext.callPtrMethod_LONG_LONG_BOOL_BOOL_DOUBLE_BOOL_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getSeamlessImagePtr, width.toLong(), height.toLong(), invert, in3dSpace, skirt.toDouble(), normalize) as Image?)

  /**
   * Returns an [VariantArray] of [Image]s containing 3D noise values for use with
   * [ImageTexture3D.create].
   *
   * **Note:** With [normalize] set to `false`, the default implementation expects the noise
   * generator to return values in the range `-1.0` to `1.0`.
   */
  @JvmOverloads
  public final fun getImage3d(
    width: Int,
    height: Int,
    depth: Int,
    invert: Boolean = false,
    normalize: Boolean = true,
  ): VariantArray<Image> =
      (TransferContext.callPtrMethod_LONG_LONG_LONG_BOOL_BOOL_ret_ARRAY(ptr, objectID.id, MethodBindings.getImage3dPtr, width.toLong(), height.toLong(), depth.toLong(), invert, normalize) as VariantArray<Image>)

  /**
   * Returns an [VariantArray] of [Image]s containing seamless 3D noise values for use with
   * [ImageTexture3D.create].
   *
   * **Note:** With [normalize] set to `false`, the default implementation expects the noise
   * generator to return values in the range `-1.0` to `1.0`.
   */
  @JvmOverloads
  public final fun getSeamlessImage3d(
    width: Int,
    height: Int,
    depth: Int,
    invert: Boolean = false,
    skirt: Float = 0.1f,
    normalize: Boolean = true,
  ): VariantArray<Image> =
      (TransferContext.callPtrMethod_LONG_LONG_LONG_BOOL_DOUBLE_BOOL_ret_ARRAY(ptr, objectID.id, MethodBindings.getSeamlessImage3dPtr, width.toLong(), height.toLong(), depth.toLong(), invert, skirt.toDouble(), normalize) as VariantArray<Image>)

  public companion object {
    @JvmField
    public val getNoise1dName: MethodStringName1<Noise, Float, Float> =
        MethodStringName1<Noise, Float, Float>("get_noise_1d")

    @JvmField
    public val getNoise2dName: MethodStringName2<Noise, Float, Float, Float> =
        MethodStringName2<Noise, Float, Float, Float>("get_noise_2d")

    @JvmField
    public val getNoise2dvName: MethodStringName1<Noise, Float, Vector2> =
        MethodStringName1<Noise, Float, Vector2>("get_noise_2dv")

    @JvmField
    public val getNoise3dName: MethodStringName3<Noise, Float, Float, Float, Float> =
        MethodStringName3<Noise, Float, Float, Float, Float>("get_noise_3d")

    @JvmField
    public val getNoise3dvName: MethodStringName1<Noise, Float, Vector3> =
        MethodStringName1<Noise, Float, Vector3>("get_noise_3dv")

    @JvmField
    public val getImageName: MethodStringName5<Noise, Image?, Int, Int, Boolean, Boolean, Boolean> =
        MethodStringName5<Noise, Image?, Int, Int, Boolean, Boolean, Boolean>("get_image")

    @JvmField
    public val getSeamlessImageName:
        MethodStringName6<Noise, Image?, Int, Int, Boolean, Boolean, Float, Boolean> =
        MethodStringName6<Noise, Image?, Int, Int, Boolean, Boolean, Float, Boolean>("get_seamless_image")

    @JvmField
    public val getImage3dName:
        MethodStringName5<Noise, VariantArray<Image>, Int, Int, Int, Boolean, Boolean> =
        MethodStringName5<Noise, VariantArray<Image>, Int, Int, Int, Boolean, Boolean>("get_image_3d")

    @JvmField
    public val getSeamlessImage3dName:
        MethodStringName6<Noise, VariantArray<Image>, Int, Int, Int, Boolean, Float, Boolean> =
        MethodStringName6<Noise, VariantArray<Image>, Int, Int, Int, Boolean, Float, Boolean>("get_seamless_image_3d")
  }

  public object MethodBindings {
    internal val getNoise1dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_noise_1d", 3919130443)

    internal val getNoise2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_noise_2d", 2753205203)

    internal val getNoise2dvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_noise_2dv", 2276447920)

    internal val getNoise3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_noise_3d", 973811851)

    internal val getNoise3dvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_noise_3dv", 1109078154)

    internal val getImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_image", 3180683109)

    internal val getSeamlessImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_seamless_image", 2770743602)

    internal val getImage3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_image_3d", 3977814329)

    internal val getSeamlessImage3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Noise", "get_seamless_image_3d", 451006340)
  }
}
