// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_VECTOR2I
import godot.callPtrMethod_LONG_LONG_BOOL
import godot.callPtrMethod_LONG_LONG_ret_BOOL
import godot.callPtrMethod_LONG_RECT2I
import godot.callPtrMethod_OBJECT_DOUBLE
import godot.callPtrMethod_RECT2I_BOOL
import godot.callPtrMethod_RECT2I_DOUBLE_ret_ARRAY
import godot.callPtrMethod_VECTOR2I
import godot.callPtrMethod_VECTOR2I_BOOL
import godot.callPtrMethod_VECTOR2I_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedVector2Array
import godot.core.Rect2i
import godot.core.VariantArray
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A two-dimensional array of boolean values, can be used to efficiently store a binary matrix
 * (every matrix element takes only one bit) and query the values using natural cartesian coordinates.
 */
@GodotBaseType
public open class BitMap : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(107, scriptPtr)
  }

  /**
   * Creates a bitmap with the specified size, filled with `false`.
   */
  public final fun create(size: Vector2i): Unit {
    TransferContext.callPtrMethod_VECTOR2I(ptr, objectID.id, MethodBindings.createPtr, size)
  }

  /**
   * Creates a bitmap that matches the given image dimensions, every element of the bitmap is set to
   * `false` if the alpha value of the image at that position is equal to [threshold] or less, and
   * `true` in other case.
   */
  @JvmOverloads
  public final fun createFromImageAlpha(image: Image?, threshold: Float = 0.1f): Unit {
    TransferContext.callPtrMethod_OBJECT_DOUBLE(ptr, objectID.id, MethodBindings.createFromImageAlphaPtr, image, threshold.toDouble())
  }

  /**
   * Sets the bitmap's element at the specified position, to the specified value.
   */
  public final fun setBitv(position: Vector2i, bit: Boolean): Unit {
    TransferContext.callPtrMethod_VECTOR2I_BOOL(ptr, objectID.id, MethodBindings.setBitvPtr, position, bit)
  }

  /**
   * Sets the bitmap's element at the specified position, to the specified value.
   */
  public final fun setBit(
    x: Int,
    y: Int,
    bit: Boolean,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_BOOL(ptr, objectID.id, MethodBindings.setBitPtr, x.toLong(), y.toLong(), bit)
  }

  /**
   * Returns bitmap's value at the specified position.
   */
  public final fun getBitv(position: Vector2i): Boolean =
      TransferContext.callPtrMethod_VECTOR2I_ret_BOOL(ptr, objectID.id, MethodBindings.getBitvPtr, position)

  /**
   * Returns bitmap's value at the specified position.
   */
  public final fun getBit(x: Int, y: Int): Boolean =
      TransferContext.callPtrMethod_LONG_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.getBitPtr, x.toLong(), y.toLong())

  /**
   * Sets a rectangular portion of the bitmap to the specified value.
   */
  public final fun setBitRect(rect: Rect2i, bit: Boolean): Unit {
    TransferContext.callPtrMethod_RECT2I_BOOL(ptr, objectID.id, MethodBindings.setBitRectPtr, rect, bit)
  }

  /**
   * Returns the number of bitmap elements that are set to `true`.
   */
  public final fun getTrueBitCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTrueBitCountPtr).toInt()

  /**
   * Returns bitmap's dimensions.
   */
  public final fun getSize(): Vector2i =
      TransferContext.callPtrMethod0_ret_VECTOR2I(ptr, objectID.id, MethodBindings.getSizePtr)

  /**
   * Resizes the image to [newSize].
   */
  public final fun resize(newSize: Vector2i): Unit {
    TransferContext.callPtrMethod_VECTOR2I(ptr, objectID.id, MethodBindings.resizePtr, newSize)
  }

  /**
   * Applies morphological dilation or erosion to the bitmap. If [pixels] is positive, dilation is
   * applied to the bitmap. If [pixels] is negative, erosion is applied to the bitmap. [rect] defines
   * the area where the morphological operation is applied. Pixels located outside the [rect] are
   * unaffected by [growMask].
   */
  public final fun growMask(pixels: Int, rect: Rect2i): Unit {
    TransferContext.callPtrMethod_LONG_RECT2I(ptr, objectID.id, MethodBindings.growMaskPtr, pixels.toLong(), rect)
  }

  /**
   * Returns an image of the same size as the bitmap and with an [Image.Format] of type
   * [Image.FORMAT_L8]. `true` bits of the bitmap are being converted into white pixels, and `false`
   * bits into black.
   */
  public final fun convertToImage(): Image? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.convertToImagePtr) as Image?)

  /**
   * Creates an [VariantArray] of polygons covering a rectangular portion of the bitmap. It uses a
   * marching squares algorithm, followed by Ramer-Douglas-Peucker (RDP) reduction of the number of
   * vertices. Each polygon is described as a [PackedVector2Array] of its vertices.
   *
   * To get polygons covering the whole bitmap, pass:
   *
   * ```
   * Rect2(Vector2(), get_size())
   * ```
   *
   * [epsilon] is passed to RDP to control how accurately the polygons cover the bitmap: a lower
   * [epsilon] corresponds to more points in the polygons.
   */
  @JvmOverloads
  public final fun opaqueToPolygons(rect: Rect2i, epsilon: Float = 2.0f):
      VariantArray<PackedVector2Array> =
      (TransferContext.callPtrMethod_RECT2I_DOUBLE_ret_ARRAY(ptr, objectID.id, MethodBindings.opaqueToPolygonsPtr, rect, epsilon.toDouble()) as VariantArray<PackedVector2Array>)

  public companion object {
    @JvmField
    public val createName: MethodStringName1<BitMap, Unit, Vector2i> =
        MethodStringName1<BitMap, Unit, Vector2i>("create")

    @JvmField
    public val createFromImageAlphaName: MethodStringName2<BitMap, Unit, Image?, Float> =
        MethodStringName2<BitMap, Unit, Image?, Float>("create_from_image_alpha")

    @JvmField
    public val setBitvName: MethodStringName2<BitMap, Unit, Vector2i, Boolean> =
        MethodStringName2<BitMap, Unit, Vector2i, Boolean>("set_bitv")

    @JvmField
    public val setBitName: MethodStringName3<BitMap, Unit, Int, Int, Boolean> =
        MethodStringName3<BitMap, Unit, Int, Int, Boolean>("set_bit")

    @JvmField
    public val getBitvName: MethodStringName1<BitMap, Boolean, Vector2i> =
        MethodStringName1<BitMap, Boolean, Vector2i>("get_bitv")

    @JvmField
    public val getBitName: MethodStringName2<BitMap, Boolean, Int, Int> =
        MethodStringName2<BitMap, Boolean, Int, Int>("get_bit")

    @JvmField
    public val setBitRectName: MethodStringName2<BitMap, Unit, Rect2i, Boolean> =
        MethodStringName2<BitMap, Unit, Rect2i, Boolean>("set_bit_rect")

    @JvmField
    public val getTrueBitCountName: MethodStringName0<BitMap, Int> =
        MethodStringName0<BitMap, Int>("get_true_bit_count")

    @JvmField
    public val getSizeName: MethodStringName0<BitMap, Vector2i> =
        MethodStringName0<BitMap, Vector2i>("get_size")

    @JvmField
    public val resizeName: MethodStringName1<BitMap, Unit, Vector2i> =
        MethodStringName1<BitMap, Unit, Vector2i>("resize")

    @JvmField
    public val growMaskName: MethodStringName2<BitMap, Unit, Int, Rect2i> =
        MethodStringName2<BitMap, Unit, Int, Rect2i>("grow_mask")

    @JvmField
    public val convertToImageName: MethodStringName0<BitMap, Image?> =
        MethodStringName0<BitMap, Image?>("convert_to_image")

    @JvmField
    public val opaqueToPolygonsName:
        MethodStringName2<BitMap, VariantArray<PackedVector2Array>, Rect2i, Float> =
        MethodStringName2<BitMap, VariantArray<PackedVector2Array>, Rect2i, Float>("opaque_to_polygons")
  }

  public object MethodBindings {
    internal val createPtr: VoidPtr = TypeManager.getMethodBindPtr("BitMap", "create", 1130785943)

    internal val createFromImageAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "create_from_image_alpha", 106271684)

    internal val setBitvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "set_bitv", 4153096796)

    internal val setBitPtr: VoidPtr = TypeManager.getMethodBindPtr("BitMap", "set_bit", 1383440665)

    internal val getBitvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "get_bitv", 3900751641)

    internal val getBitPtr: VoidPtr = TypeManager.getMethodBindPtr("BitMap", "get_bit", 2522259332)

    internal val setBitRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "set_bit_rect", 472162941)

    internal val getTrueBitCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "get_true_bit_count", 3905245786)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "get_size", 3690982128)

    internal val resizePtr: VoidPtr = TypeManager.getMethodBindPtr("BitMap", "resize", 1130785943)

    internal val growMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "grow_mask", 3317281434)

    internal val convertToImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "convert_to_image", 4190603485)

    internal val opaqueToPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BitMap", "opaque_to_polygons", 48478126)
  }
}
