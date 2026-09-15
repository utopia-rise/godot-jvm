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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector3
import godot.readReturnValue_ARRAY
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_DOUBLE_DOUBLE
import godot.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE
import godot.writeMethodArguments_LONG_LONG_BOOL_BOOL_BOOL
import godot.writeMethodArguments_LONG_LONG_BOOL_BOOL_DOUBLE_BOOL
import godot.writeMethodArguments_LONG_LONG_LONG_BOOL_BOOL
import godot.writeMethodArguments_LONG_LONG_LONG_BOOL_DOUBLE_BOOL
import godot.writeMethodArguments_VECTOR2
import godot.writeMethodArguments_VECTOR3
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
  public final fun getNoise1d(x: Float): Float {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, x.toDouble())
    TransferContext.callPtrMethod(MethodBindings.getNoise1dPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the 2D noise value at the given position.
   */
  public final fun getNoise2d(x: Float, y: Float): Float {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE(ptr, objectID.id, x.toDouble(), y.toDouble())
    TransferContext.callPtrMethod(MethodBindings.getNoise2dPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the 2D noise value at the given position.
   */
  public final fun getNoise2dv(v: Vector2): Float {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, v)
    TransferContext.callPtrMethod(MethodBindings.getNoise2dvPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the 3D noise value at the given position.
   */
  public final fun getNoise3d(
    x: Float,
    y: Float,
    z: Float,
  ): Float {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, x.toDouble(), y.toDouble(), z.toDouble())
    TransferContext.callPtrMethod(MethodBindings.getNoise3dPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the 3D noise value at the given position.
   */
  public final fun getNoise3dv(v: Vector3): Float {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, v)
    TransferContext.callPtrMethod(MethodBindings.getNoise3dvPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

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
  ): Image? {
    TransferContext.writeMethodArguments_LONG_LONG_BOOL_BOOL_BOOL(ptr, objectID.id, width.toLong(), height.toLong(), invert, in3dSpace, normalize)
    TransferContext.callPtrMethod(MethodBindings.getImagePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

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
  ): Image? {
    TransferContext.writeMethodArguments_LONG_LONG_BOOL_BOOL_DOUBLE_BOOL(ptr, objectID.id, width.toLong(), height.toLong(), invert, in3dSpace, skirt.toDouble(), normalize)
    TransferContext.callPtrMethod(MethodBindings.getSeamlessImagePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

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
  ): VariantArray<Image> {
    TransferContext.writeMethodArguments_LONG_LONG_LONG_BOOL_BOOL(ptr, objectID.id, width.toLong(), height.toLong(), depth.toLong(), invert, normalize)
    TransferContext.callMethod(MethodBindings.getImage3dPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Image>)
  }

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
  ): VariantArray<Image> {
    TransferContext.writeMethodArguments_LONG_LONG_LONG_BOOL_DOUBLE_BOOL(ptr, objectID.id, width.toLong(), height.toLong(), depth.toLong(), invert, skirt.toDouble(), normalize)
    TransferContext.callMethod(MethodBindings.getSeamlessImage3dPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Image>)
  }

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
