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
import godot.core.ClockDirection
import godot.core.Color
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedByteArray
import godot.core.Rect2i
import godot.core.Vector2i
import godot.readReturnValue_BOOL
import godot.readReturnValue_COLOR
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_BYTE_ARRAY
import godot.readReturnValue_RECT2I
import godot.readReturnValue_VECTOR2I
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_BOOL_BOOL_DOUBLE
import godot.writeMethodArguments_BOOL_DOUBLE
import godot.writeMethodArguments_BOOL_LONG
import godot.writeMethodArguments_COLOR
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_BOOL_LONG
import godot.writeMethodArguments_LONG_LONG_BOOL_LONG_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_LONG_LONG_COLOR
import godot.writeMethodArguments_LONG_LONG_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_OBJECT_BOOL
import godot.writeMethodArguments_OBJECT_OBJECT_RECT2I_VECTOR2I
import godot.writeMethodArguments_OBJECT_RECT2I_VECTOR2I
import godot.writeMethodArguments_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_PACKED_BYTE_ARRAY_DOUBLE
import godot.writeMethodArguments_RECT2I
import godot.writeMethodArguments_RECT2I_COLOR
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_BOOL_BOOL_DOUBLE
import godot.writeMethodArguments_STRING_BOOL_DOUBLE
import godot.writeMethodArguments_STRING_DOUBLE
import godot.writeMethodArguments_VECTOR2I
import godot.writeMethodArguments_VECTOR2I_COLOR
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Native image datatype. Contains image data which can be converted to an [ImageTexture] and
 * provides commonly used *image processing* methods. The maximum width and height for an [Image] are
 * [MAX_WIDTH] and [MAX_HEIGHT].
 *
 * An [Image] cannot be assigned to a texture property of an object directly (such as
 * [Sprite2D.texture]), and has to be converted manually to an [ImageTexture] first.
 *
 * **Note:** Methods that modify the image data cannot be used on VRAM-compressed images. Use
 * [decompress] to convert the image to an uncompressed format first.
 *
 * **Note:** The maximum image size is 16384×16384 pixels due to graphics hardware limitations.
 * Larger images may fail to import.
 */
@GodotBaseType
public open class Image : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(298, scriptPtr)
  }

  /**
   * Returns the image's width.
   */
  public final fun getWidth(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getWidthPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the image's height.
   */
  public final fun getHeight(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHeightPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the image's size (width and height).
   */
  public final fun getSize(): Vector2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSizePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  /**
   * Returns `true` if the image has generated mipmaps.
   */
  public final fun hasMipmaps(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasMipmapsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns this image's format.
   */
  public final fun getFormat(): Format {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFormatPtr, 2)
    return Format.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns a copy of the image's raw data.
   */
  public final fun getData(): PackedByteArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDataPtr, 29)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Returns size (in bytes) of the image's raw data.
   */
  public final fun getDataSize(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDataSizePtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Converts this image's format to the given [format].
   */
  public final fun convert(format: Format): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, format.value)
    TransferContext.callPtrMethod(MethodBindings.convertPtr, 0)
  }

  /**
   * Returns the number of mipmap levels or 0 if the image has no mipmaps. The largest main level
   * image is not counted as a mipmap level by this method, so if you want to include it you can add 1
   * to this count.
   */
  public final fun getMipmapCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMipmapCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the offset where the image's mipmap with index [mipmap] is stored in the [data]
   * dictionary.
   */
  public final fun getMipmapOffset(mipmap: Int): Long {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mipmap.toLong())
    TransferContext.callPtrMethod(MethodBindings.getMipmapOffsetPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Resizes the image to the nearest power of 2 for the width and height. If [square] is `true`,
   * sets width and height to be the same. New pixels are calculated using the [interpolation] mode
   * defined via [Interpolation] constants.
   */
  @JvmOverloads
  public final fun resizeToPo2(square: Boolean = false, interpolation: Interpolation =
      Image.Interpolation.INTERPOLATE_BILINEAR): Unit {
    TransferContext.writeMethodArguments_BOOL_LONG(ptr, objectID.id, square, interpolation.value)
    TransferContext.callPtrMethod(MethodBindings.resizeToPo2Ptr, 0)
  }

  /**
   * Resizes the image to the given [width] and [height]. New pixels are calculated using the
   * [interpolation] mode defined via [Interpolation] constants.
   *
   * **Note:** If the image's format is [FORMAT_RGBA4444], [FORMAT_RGB565], or [FORMAT_RGBE9995], it
   * will be temporarily converted to either [FORMAT_RGBA8] or [FORMAT_RGBAH]. This can affect the
   * quality of the resized image.
   */
  @JvmOverloads
  public final fun resize(
    width: Int,
    height: Int,
    interpolation: Interpolation = Image.Interpolation.INTERPOLATE_BILINEAR,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, width.toLong(), height.toLong(), interpolation.value)
    TransferContext.callPtrMethod(MethodBindings.resizePtr, 0)
  }

  /**
   * Shrinks the image by a factor of 2 on each axis (this divides the pixel count by 4).
   */
  public final fun shrinkX2(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.shrinkX2Ptr, 0)
  }

  /**
   * Crops the image to the given [width] and [height]. If the specified size is larger than the
   * current size, the extra area is filled with black pixels.
   */
  public final fun crop(width: Int, height: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, width.toLong(), height.toLong())
    TransferContext.callPtrMethod(MethodBindings.cropPtr, 0)
  }

  /**
   * Flips the image horizontally.
   */
  public final fun flipX(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.flipXPtr, 0)
  }

  /**
   * Flips the image vertically.
   */
  public final fun flipY(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.flipYPtr, 0)
  }

  /**
   * Generates mipmaps for the image. Mipmaps are precalculated lower-resolution copies of the image
   * that are automatically used if the image needs to be scaled down when rendered. They help improve
   * image quality and performance when rendering. This method returns an error if the image is
   * compressed, in a custom format, or if the image's width/height is `0`. Enabling [renormalize] when
   * generating mipmaps for normal map textures will make sure all resulting vector values are
   * normalized.
   *
   * It is possible to check if the image has mipmaps by calling [hasMipmaps] or [getMipmapCount].
   * Calling [generateMipmaps] on an image that already has mipmaps will replace existing mipmaps in
   * the image.
   */
  @JvmOverloads
  public final fun generateMipmaps(renormalize: Boolean = false): Error {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, renormalize)
    TransferContext.callPtrMethod(MethodBindings.generateMipmapsPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Removes the image's mipmaps.
   */
  public final fun clearMipmaps(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearMipmapsPtr, 0)
  }

  /**
   * Overwrites data of an existing [Image]. Non-static equivalent of [createFromData].
   */
  public final fun setData(
    width: Int,
    height: Int,
    useMipmaps: Boolean,
    format: Format,
    `data`: PackedByteArray,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_BOOL_LONG_PACKED_BYTE_ARRAY(ptr, objectID.id, width.toLong(), height.toLong(), useMipmaps, format.value, data)
    TransferContext.callPtrMethod(MethodBindings.setDataPtr, 0)
  }

  /**
   * Returns `true` if the image has no data.
   */
  public final fun isEmpty(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEmptyPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Loads an image from file [path]. See
   * [url=$DOCS_URL/tutorials/assets_pipeline/importing_images.html#supported-image-formats]Supported
   * image formats[/url] for a list of supported image formats and limitations.
   *
   * **Warning:** This method should only be used in the editor or in cases when you need to load
   * external images at run-time, such as images located at the `user://` directory, and may not work
   * in exported projects.
   *
   * See also [ImageTexture] description for usage examples.
   */
  public final fun load(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.loadPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Saves the image as a PNG file to the file at [path].
   */
  public final fun savePng(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.savePngPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Saves the image as a PNG file to a byte array.
   */
  public final fun savePngToBuffer(): PackedByteArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.savePngToBufferPtr, 29)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Saves the image as a JPEG file to [path] with the specified [quality] between `0.01` and `1.0`
   * (inclusive). Higher [quality] values result in better-looking output at the cost of larger file
   * sizes. Recommended [quality] values are between `0.75` and `0.90`. Even at quality `1.00`, JPEG
   * compression remains lossy.
   *
   * **Note:** JPEG does not save an alpha channel. If the [Image] contains an alpha channel, the
   * image will still be saved, but the resulting JPEG file won't contain the alpha channel.
   */
  @JvmOverloads
  public final fun saveJpg(path: String, quality: Float = 0.75f): Error {
    TransferContext.writeMethodArguments_STRING_DOUBLE(ptr, objectID.id, path, quality.toDouble())
    TransferContext.callMethod(MethodBindings.saveJpgPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Saves the image as a JPEG file to a byte array with the specified [quality] between `0.01` and
   * `1.0` (inclusive). Higher [quality] values result in better-looking output at the cost of larger
   * byte array sizes (and therefore memory usage). Recommended [quality] values are between `0.75` and
   * `0.90`. Even at quality `1.00`, JPEG compression remains lossy.
   *
   * **Note:** JPEG does not save an alpha channel. If the [Image] contains an alpha channel, the
   * image will still be saved, but the resulting byte array won't contain the alpha channel.
   */
  @JvmOverloads
  public final fun saveJpgToBuffer(quality: Float = 0.75f): PackedByteArray {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, quality.toDouble())
    TransferContext.callPtrMethod(MethodBindings.saveJpgToBufferPtr, 29)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Saves the image as an EXR file to [path]. If [grayscale] is `true` and the image has only one
   * channel, it will be saved explicitly as monochrome rather than one red channel. Set [colorImage]
   * to `true` when saving a color image, such as a screenshot. Negative values will be included when
   * [colorImage] is `false`, which may be useful for saving raw floating point data such as a lightmap
   * that includes negative light information. Color component values in the resulting EXR file will
   * not exceed [maxLinearValue] if [maxLinearValue] is not negative. This function will return
   * [ERR_UNAVAILABLE] if Godot was compiled without the TinyEXR module.
   *
   * When saving screenshots of a project that uses HDR output, use [Window.getOutputMaxLinearValue]
   * for [maxLinearValue].
   */
  @JvmOverloads
  public final fun saveExr(
    path: String,
    grayscale: Boolean = false,
    colorImage: Boolean = false,
    maxLinearValue: Float = -1.0f,
  ): Error {
    TransferContext.writeMethodArguments_STRING_BOOL_BOOL_DOUBLE(ptr, objectID.id, path, grayscale, colorImage, maxLinearValue.toDouble())
    TransferContext.callMethod(MethodBindings.saveExrPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Saves the image as an EXR file to a byte array. If [grayscale] is `true` and the image has only
   * one channel, it will be saved explicitly as monochrome rather than one red channel. Set
   * [colorImage] to `true` when saving a color image, such as a screenshot. Negative values will be
   * included when [colorImage] is `false`, which may be useful for saving raw floating point data such
   * as a lightmap that includes negative light information. Color component values in the resulting
   * EXR file will not exceed [maxLinearValue] if [maxLinearValue] is not negative. This function will
   * return an empty byte array if Godot was compiled without the TinyEXR module.
   *
   * When saving screenshots of a project that uses HDR output, use [Window.getOutputMaxLinearValue]
   * for [maxLinearValue].
   */
  @JvmOverloads
  public final fun saveExrToBuffer(
    grayscale: Boolean = false,
    colorImage: Boolean = false,
    maxLinearValue: Float = -1.0f,
  ): PackedByteArray {
    TransferContext.writeMethodArguments_BOOL_BOOL_DOUBLE(ptr, objectID.id, grayscale, colorImage, maxLinearValue.toDouble())
    TransferContext.callPtrMethod(MethodBindings.saveExrToBufferPtr, 29)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Saves the image as a DDS (DirectDraw Surface) file to [path]. DDS is a container format that
   * can store textures in various compression formats, such as DXT1, DXT5, or BC7. This function will
   * return [ERR_UNAVAILABLE] if Godot was compiled without the DDS module.
   *
   * **Note:** The DDS module may be disabled in certain builds, which means [saveDds] will return
   * [ERR_UNAVAILABLE] when it is called from an exported project.
   */
  public final fun saveDds(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.saveDdsPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Saves the image as a DDS (DirectDraw Surface) file to a byte array. DDS is a container format
   * that can store textures in various compression formats, such as DXT1, DXT5, or BC7. This function
   * will return an empty byte array if Godot was compiled without the DDS module.
   *
   * **Note:** The DDS module may be disabled in certain builds, which means [saveDdsToBuffer] will
   * return an empty byte array when it is called from an exported project.
   */
  public final fun saveDdsToBuffer(): PackedByteArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.saveDdsToBufferPtr, 29)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Saves the image as a WebP (Web Picture) file to the file at [path]. By default it will save
   * lossless. If [lossy] is `true`, the image will be saved lossy, using the [quality] setting between
   * `0.0` and `1.0` (inclusive). Lossless WebP offers more efficient compression than PNG.
   *
   * **Note:** The WebP format is limited to a size of 16383×16383 pixels, while PNG can save larger
   * images.
   */
  @JvmOverloads
  public final fun saveWebp(
    path: String,
    lossy: Boolean = false,
    quality: Float = 0.75f,
  ): Error {
    TransferContext.writeMethodArguments_STRING_BOOL_DOUBLE(ptr, objectID.id, path, lossy, quality.toDouble())
    TransferContext.callMethod(MethodBindings.saveWebpPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Saves the image as a WebP (Web Picture) file to a byte array. By default it will save lossless.
   * If [lossy] is `true`, the image will be saved lossy, using the [quality] setting between `0.0` and
   * `1.0` (inclusive). Lossless WebP offers more efficient compression than PNG.
   *
   * **Note:** The WebP format is limited to a size of 16383×16383 pixels, while PNG can save larger
   * images.
   */
  @JvmOverloads
  public final fun saveWebpToBuffer(lossy: Boolean = false, quality: Float = 0.75f):
      PackedByteArray {
    TransferContext.writeMethodArguments_BOOL_DOUBLE(ptr, objectID.id, lossy, quality.toDouble())
    TransferContext.callPtrMethod(MethodBindings.saveWebpToBufferPtr, 29)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Returns [ALPHA_BLEND] if the image has data for alpha values. Returns [ALPHA_BIT] if all the
   * alpha values are stored in a single bit. Returns [ALPHA_NONE] if no data for alpha values is
   * found.
   */
  public final fun detectAlpha(): AlphaMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.detectAlphaPtr, 2)
    return AlphaMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns `true` if all the image's pixels have an alpha value of 0. Returns `false` if any pixel
   * has an alpha value higher than 0.
   */
  public final fun isInvisible(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isInvisiblePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the color channels used by this image. If the image is compressed, the original
   * [source] must be specified.
   */
  @JvmOverloads
  public final fun detectUsedChannels(source: CompressSource = Image.CompressSource.GENERIC):
      UsedChannels {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, source.value)
    TransferContext.callPtrMethod(MethodBindings.detectUsedChannelsPtr, 2)
    return UsedChannels.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Compresses the image with a VRAM-compressed format to use less memory. Can not directly access
   * pixel data while the image is compressed. Returns error if the chosen compression mode is not
   * available.
   *
   * The [source] parameter helps to pick the best compression method for DXT and ETC2 formats. It
   * is ignored for ASTC compression.
   *
   * The [astcFormat] parameter is only taken into account when using ASTC compression; it is
   * ignored for all other formats.
   *
   * **Note:** [compress] is only supported in editor builds. When run in an exported project, this
   * method always returns [ERR_UNAVAILABLE].
   */
  @JvmOverloads
  public final fun compress(
    mode: CompressMode,
    source: CompressSource = Image.CompressSource.GENERIC,
    astcFormat: ASTCFormat = Image.ASTCFormat.ASTC_FORMAT_4x4,
  ): Error {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, mode.value, source.value, astcFormat.value)
    TransferContext.callPtrMethod(MethodBindings.compressPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Compresses the image with a VRAM-compressed format to use less memory. Can not directly access
   * pixel data while the image is compressed. Returns error if the chosen compression mode is not
   * available.
   *
   * This is an alternative to [compress] that lets the user supply the channels used in order for
   * the compressor to pick the best DXT and ETC2 formats. For other formats (non DXT or ETC2), this
   * argument is ignored.
   *
   * The [astcFormat] parameter is only taken into account when using ASTC compression; it is
   * ignored for all other formats.
   *
   * **Note:** [compressFromChannels] is only supported in editor builds. When run in an exported
   * project, this method always returns [ERR_UNAVAILABLE].
   */
  @JvmOverloads
  public final fun compressFromChannels(
    mode: CompressMode,
    channels: UsedChannels,
    astcFormat: ASTCFormat = Image.ASTCFormat.ASTC_FORMAT_4x4,
  ): Error {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, mode.value, channels.value, astcFormat.value)
    TransferContext.callPtrMethod(MethodBindings.compressFromChannelsPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Decompresses the image if it is VRAM-compressed in a supported format. This increases memory
   * utilization, but allows modifying the image. Returns [OK] if the format is supported, otherwise
   * [ERR_UNAVAILABLE]. All VRAM-compressed formats supported by Godot can be decompressed with this
   * method, except [FORMAT_ETC2_R11S], [FORMAT_ETC2_RG11S], and [FORMAT_ETC2_RGB8A1].
   */
  public final fun decompress(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.decompressPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns `true` if the image is compressed.
   */
  public final fun isCompressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCompressedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Rotates the image in the specified [direction] by `90` degrees. The width and height of the
   * image must be greater than `1`. If the width and height are not equal, the image will be resized.
   */
  public final fun rotate90(direction: ClockDirection): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, direction.value)
    TransferContext.callPtrMethod(MethodBindings.rotate90Ptr, 0)
  }

  /**
   * Rotates the image by `180` degrees. The width and height of the image must be greater than `1`.
   */
  public final fun rotate180(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.rotate180Ptr, 0)
  }

  /**
   * Blends low-alpha pixels with nearby pixels.
   */
  public final fun fixAlphaEdges(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.fixAlphaEdgesPtr, 0)
  }

  /**
   * Multiplies color values with alpha values. Resulting color values for a pixel are `(color *
   * alpha)/256`. See also [CanvasItemMaterial.blendMode].
   */
  public final fun premultiplyAlpha(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.premultiplyAlphaPtr, 0)
  }

  /**
   * Converts the raw data from nonlinear sRGB encoding to linear encoding using a lookup table.
   * Only works on images with [FORMAT_RGB8] or [FORMAT_RGBA8] formats.
   *
   * **Note:** The 8-bit formats required by this method are not suitable for storing linearly
   * encoded values; a significant amount of color information will be lost in darker values. To
   * maintain image quality, this method should not be used.
   */
  public final fun srgbToLinear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.srgbToLinearPtr, 0)
  }

  /**
   * Converts the entire image from linear encoding to nonlinear sRGB encoding by using a lookup
   * table. Only works on images with [FORMAT_RGB8] or [FORMAT_RGBA8] formats.
   */
  public final fun linearToSrgb(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.linearToSrgbPtr, 0)
  }

  /**
   * Converts the image's data to represent coordinates on a 3D plane. This is used when the image
   * represents a normal map. A normal map can add lots of detail to a 3D surface without increasing
   * the polygon count.
   */
  public final fun normalMapToXy(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.normalMapToXyPtr, 0)
  }

  /**
   * Converts a standard linear RGBE (Red Green Blue Exponent) image to an image that uses nonlinear
   * sRGB encoding.
   */
  public final fun rgbeToSrgb(): Image? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.rgbeToSrgbPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

  /**
   * Converts a bump map to a normal map. A bump map provides a height offset per-pixel, while a
   * normal map provides a normal direction per pixel.
   */
  @JvmOverloads
  public final fun bumpMapToNormalMap(bumpScale: Float = 1.0f): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, bumpScale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.bumpMapToNormalMapPtr, 0)
  }

  /**
   * Compute image metrics on the current image and the compared image. This can be used to
   * calculate the similarity between two images.
   *
   * The dictionary contains `max`, `mean`, `mean_squared`, `root_mean_squared` and `peak_snr`.
   */
  public final fun computeImageMetrics(comparedImage: Image?, useLuma: Boolean):
      Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments_OBJECT_BOOL(ptr, objectID.id, comparedImage, useLuma)
    TransferContext.callPtrMethod(MethodBindings.computeImageMetricsPtr, 27)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Copies [srcRect] from [src] image to this image at coordinates [dst], clipped accordingly to
   * both image bounds. This image and [src] image **must** have the same format. [srcRect] with
   * non-positive size is treated as empty.
   *
   * **Note:** The alpha channel data in [src] will overwrite the corresponding data in this image
   * at the target position. To blend alpha channels, use [blendRect] instead.
   */
  public final fun blitRect(
    src: Image?,
    srcRect: Rect2i,
    dst: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_RECT2I_VECTOR2I(ptr, objectID.id, src, srcRect, dst)
    TransferContext.callPtrMethod(MethodBindings.blitRectPtr, 0)
  }

  /**
   * Blits [srcRect] area from [src] image to this image at the coordinates given by [dst], clipped
   * accordingly to both image bounds. [src] pixel is copied onto [dst] if the corresponding [mask]
   * pixel's alpha value is not 0. This image and [src] image **must** have the same format. [src]
   * image and [mask] image **must** have the same size (width and height) but they can have different
   * formats. [srcRect] with non-positive size is treated as empty.
   */
  public final fun blitRectMask(
    src: Image?,
    mask: Image?,
    srcRect: Rect2i,
    dst: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT_RECT2I_VECTOR2I(ptr, objectID.id, src, mask, srcRect, dst)
    TransferContext.callPtrMethod(MethodBindings.blitRectMaskPtr, 0)
  }

  /**
   * Alpha-blends [srcRect] from [src] image to this image at coordinates [dst], clipped accordingly
   * to both image bounds. This image and [src] image **must** have the same format. [srcRect] with
   * non-positive size is treated as empty.
   */
  public final fun blendRect(
    src: Image?,
    srcRect: Rect2i,
    dst: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_RECT2I_VECTOR2I(ptr, objectID.id, src, srcRect, dst)
    TransferContext.callPtrMethod(MethodBindings.blendRectPtr, 0)
  }

  /**
   * Alpha-blends [srcRect] from [src] image to this image using [mask] image at coordinates [dst],
   * clipped accordingly to both image bounds. Alpha channels are required for both [src] and [mask].
   * [dst] pixels and [src] pixels will blend if the corresponding mask pixel's alpha value is not 0.
   * This image and [src] image **must** have the same format. [src] image and [mask] image **must**
   * have the same size (width and height) but they can have different formats. [srcRect] with
   * non-positive size is treated as empty.
   */
  public final fun blendRectMask(
    src: Image?,
    mask: Image?,
    srcRect: Rect2i,
    dst: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT_RECT2I_VECTOR2I(ptr, objectID.id, src, mask, srcRect, dst)
    TransferContext.callPtrMethod(MethodBindings.blendRectMaskPtr, 0)
  }

  /**
   * Fills the image with [color].
   */
  public final fun fill(color: Color): Unit {
    TransferContext.writeMethodArguments_COLOR(ptr, objectID.id, color)
    TransferContext.callPtrMethod(MethodBindings.fillPtr, 0)
  }

  /**
   * Fills [rect] with [color].
   */
  public final fun fillRect(rect: Rect2i, color: Color): Unit {
    TransferContext.writeMethodArguments_RECT2I_COLOR(ptr, objectID.id, rect, color)
    TransferContext.callPtrMethod(MethodBindings.fillRectPtr, 0)
  }

  /**
   * Returns a [Rect2i] enclosing the visible portion of the image, considering each pixel with a
   * non-zero alpha channel as visible.
   */
  public final fun getUsedRect(): Rect2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUsedRectPtr, 8)
    return TransferContext.readReturnValue_RECT2I()
  }

  /**
   * Returns a new [Image] that is a copy of this [Image]'s area specified with [region].
   */
  public final fun getRegion(region: Rect2i): Image? {
    TransferContext.writeMethodArguments_RECT2I(ptr, objectID.id, region)
    TransferContext.callPtrMethod(MethodBindings.getRegionPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

  /**
   * Copies [src] image to this image.
   */
  public final fun copyFrom(src: Image?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, src)
    TransferContext.callPtrMethod(MethodBindings.copyFromPtr, 0)
  }

  /**
   * Returns the color of the pixel at [point].
   *
   * This is the same as [getPixel], but with a [Vector2i] argument instead of two integer
   * arguments.
   */
  public final fun getPixelv(point: Vector2i): Color {
    TransferContext.writeMethodArguments_VECTOR2I(ptr, objectID.id, point)
    TransferContext.callPtrMethod(MethodBindings.getPixelvPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  /**
   * Returns the color of the pixel at `(x, y)`.
   *
   * This is the same as [getPixelv], but with two integer arguments instead of a [Vector2i]
   * argument.
   */
  public final fun getPixel(x: Int, y: Int): Color {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, x.toLong(), y.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPixelPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  /**
   * Sets the [Color] of the pixel at [point] to [color].
   *
   * ```gdscript
   * //gdscript
   * var img_width = 10
   * var img_height = 5
   * var img = Image.create(img_width, img_height, false, Image.FORMAT_RGBA8)
   *
   * img.set_pixelv(Vector2i(1, 2), Color.RED) # Sets the color at (1, 2) to red.
   * ```
   *
   * ```csharp
   * //csharp
   * int imgWidth = 10;
   * int imgHeight = 5;
   * var img = Image.Create(imgWidth, imgHeight, false, Image.Format.Rgba8);
   *
   * img.SetPixelv(new Vector2I(1, 2), Colors.Red); // Sets the color at (1, 2) to red.
   * ```
   *
   * This is the same as [setPixel], but with a [Vector2i] argument instead of two integer
   * arguments.
   *
   * **Note:** Depending on the image's format, the color set here may be clamped or lose precision.
   * Do not assume the color returned by [getPixelv] to be identical to the one set here; any
   * comparisons will likely need to use an approximation like [Color.isEqualApprox].
   *
   * **Note:** On grayscale image formats, only the red channel of [color] is used (and alpha if
   * relevant). The green and blue channels are ignored.
   */
  public final fun setPixelv(point: Vector2i, color: Color): Unit {
    TransferContext.writeMethodArguments_VECTOR2I_COLOR(ptr, objectID.id, point, color)
    TransferContext.callPtrMethod(MethodBindings.setPixelvPtr, 0)
  }

  /**
   * Sets the [Color] of the pixel at `(x, y)` to [color].
   *
   * ```gdscript
   * //gdscript
   * var img_width = 10
   * var img_height = 5
   * var img = Image.create(img_width, img_height, false, Image.FORMAT_RGBA8)
   *
   * img.set_pixel(1, 2, Color.RED) # Sets the color at (1, 2) to red.
   * ```
   *
   * ```csharp
   * //csharp
   * int imgWidth = 10;
   * int imgHeight = 5;
   * var img = Image.Create(imgWidth, imgHeight, false, Image.Format.Rgba8);
   *
   * img.SetPixel(1, 2, Colors.Red); // Sets the color at (1, 2) to red.
   * ```
   *
   * This is the same as [setPixelv], but with a two integer arguments instead of a [Vector2i]
   * argument.
   *
   * **Note:** Depending on the image's format, the color set here may be clamped or lose precision.
   * Do not assume the color returned by [getPixel] to be identical to the one set here; any
   * comparisons will likely need to use an approximation like [Color.isEqualApprox].
   *
   * **Note:** On grayscale image formats, only the red channel of [color] is used (and alpha if
   * relevant). The green and blue channels are ignored.
   */
  public final fun setPixel(
    x: Int,
    y: Int,
    color: Color,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_COLOR(ptr, objectID.id, x.toLong(), y.toLong(), color)
    TransferContext.callPtrMethod(MethodBindings.setPixelPtr, 0)
  }

  /**
   * Adjusts this image's [brightness], [contrast], and [saturation] by the given values. Does not
   * work if the image is compressed (see [isCompressed]).
   */
  public final fun adjustBcs(
    brightness: Float,
    contrast: Float,
    saturation: Float,
  ): Unit {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, brightness.toDouble(), contrast.toDouble(), saturation.toDouble())
    TransferContext.callPtrMethod(MethodBindings.adjustBcsPtr, 0)
  }

  /**
   * Loads an image from the binary contents of a PNG file.
   */
  public final fun loadPngFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadPngFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of a JPEG file.
   */
  public final fun loadJpgFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadJpgFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of a WebP file.
   */
  public final fun loadWebpFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadWebpFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of a TGA file.
   *
   * **Note:** This method is only available in engine builds with the TGA module enabled. By
   * default, the TGA module is enabled, but it can be disabled at build-time using the
   * `module_tga_enabled=no` SCons option.
   */
  public final fun loadTgaFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadTgaFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of a BMP file.
   *
   * **Note:** Godot's BMP module doesn't support 16-bit per pixel images. Only 1-bit, 4-bit, 8-bit,
   * 24-bit, and 32-bit per pixel images are supported.
   *
   * **Note:** This method is only available in engine builds with the BMP module enabled. By
   * default, the BMP module is enabled, but it can be disabled at build-time using the
   * `module_bmp_enabled=no` SCons option.
   */
  public final fun loadBmpFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadBmpFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of a
   * [url=https://github.com/KhronosGroup/KTX-Software]KTX[/url] file. Unlike most image formats, KTX
   * can store VRAM-compressed data and embed mipmaps.
   *
   * **Note:** Godot's libktx implementation only supports 2D images. Cubemaps, texture arrays, and
   * de-padding are not supported.
   *
   * **Note:** This method is only available in engine builds with the KTX module enabled. By
   * default, the KTX module is enabled, but it can be disabled at build-time using the
   * `module_ktx_enabled=no` SCons option.
   */
  public final fun loadKtxFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadKtxFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of a DDS file.
   *
   * **Note:** This method is only available in engine builds with the DDS module enabled. By
   * default, the DDS module is enabled, but it can be disabled at build-time using the
   * `module_dds_enabled=no` SCons option.
   */
  public final fun loadDdsFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadDdsFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the binary contents of an OpenEXR file.
   */
  public final fun loadExrFromBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callPtrMethod(MethodBindings.loadExrFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the UTF-8 binary contents of an **uncompressed** SVG file (**.svg**).
   *
   * **Note:** Beware when using compressed SVG files (like **.svgz**), they need to be
   * `decompressed` before loading.
   *
   * **Note:** This method is only available in engine builds with the SVG module enabled. By
   * default, the SVG module is enabled, but it can be disabled at build-time using the
   * `module_svg_enabled=no` SCons option.
   */
  @JvmOverloads
  public final fun loadSvgFromBuffer(buffer: PackedByteArray, scale: Float = 1.0f): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_DOUBLE(ptr, objectID.id, buffer, scale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.loadSvgFromBufferPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads an image from the string contents of an SVG file (**.svg**).
   *
   * **Note:** This method is only available in engine builds with the SVG module enabled. By
   * default, the SVG module is enabled, but it can be disabled at build-time using the
   * `module_svg_enabled=no` SCons option.
   */
  @JvmOverloads
  public final fun loadSvgFromString(svgStr: String, scale: Float = 1.0f): Error {
    TransferContext.writeMethodArguments_STRING_DOUBLE(ptr, objectID.id, svgStr, scale.toDouble())
    TransferContext.callMethod(MethodBindings.loadSvgFromStringPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Format(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Texture format with a single 8-bit depth representing luminance.
     */
    L8(0),
    /**
     * OpenGL texture format with two values, luminance and alpha each stored with 8 bits.
     */
    LA8(1),
    /**
     * OpenGL texture format `RED` with a single component and a bitdepth of 8.
     */
    R8(2),
    /**
     * OpenGL texture format `RG` with two components and a bitdepth of 8 for each.
     */
    RG8(3),
    /**
     * OpenGL texture format `RGB` with three components, each with a bitdepth of 8.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    RGB8(4),
    /**
     * OpenGL texture format `RGBA` with four components, each with a bitdepth of 8.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    RGBA8(5),
    /**
     * OpenGL texture format `RGBA` with four components, each with a bitdepth of 4.
     */
    RGBA4444(6),
    /**
     * OpenGL texture format `RGB` with three components. Red and blue have a bitdepth of 5, and
     * green has a bitdepth of 6.
     */
    RGB565(7),
    /**
     * OpenGL texture format `GL_R32F` where there's one component, a 32-bit floating-point value.
     */
    RF(8),
    /**
     * OpenGL texture format `GL_RG32F` where there are two components, each a 32-bit floating-point
     * values.
     */
    RGF(9),
    /**
     * OpenGL texture format `GL_RGB32F` where there are three components, each a 32-bit
     * floating-point values.
     */
    RGBF(10),
    /**
     * OpenGL texture format `GL_RGBA32F` where there are four components, each a 32-bit
     * floating-point values.
     */
    RGBAF(11),
    /**
     * OpenGL texture format `GL_R16F` where there's one component, a 16-bit "half-precision"
     * floating-point value.
     */
    RH(12),
    /**
     * OpenGL texture format `GL_RG16F` where there are two components, each a 16-bit
     * "half-precision" floating-point value.
     */
    RGH(13),
    /**
     * OpenGL texture format `GL_RGB16F` where there are three components, each a 16-bit
     * "half-precision" floating-point value.
     */
    RGBH(14),
    /**
     * OpenGL texture format `GL_RGBA16F` where there are four components, each a 16-bit
     * "half-precision" floating-point value.
     */
    RGBAH(15),
    /**
     * A special OpenGL texture format where the three color components have 9 bits of precision and
     * all three share a single 5-bit exponent.
     */
    RGBE9995(16),
    /**
     * The [url=https://en.wikipedia.org/wiki/S3_Texture_Compression]S3TC[/url] texture format that
     * uses Block Compression 1, and is the smallest variation of S3TC, only providing 1 bit of alpha
     * and color data being premultiplied with alpha.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    DXT1(17),
    /**
     * The [url=https://en.wikipedia.org/wiki/S3_Texture_Compression]S3TC[/url] texture format that
     * uses Block Compression 2, and color data is interpreted as not having been premultiplied by
     * alpha. Well suited for images with sharp alpha transitions between translucent and opaque areas.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    DXT3(18),
    /**
     * The [url=https://en.wikipedia.org/wiki/S3_Texture_Compression]S3TC[/url] texture format also
     * known as Block Compression 3 or BC3 that contains 64 bits of alpha channel data followed by 64
     * bits of DXT1-encoded color data. Color data is not premultiplied by alpha, same as DXT3. DXT5
     * generally produces superior results for transparent gradients compared to DXT3.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    DXT5(19),
    /**
     * Texture format that uses
     * [url=https://www.khronos.org/opengl/wiki/Red_Green_Texture_Compression]Red Green Texture
     * Compression[/url], normalizing the red channel data using the same compression algorithm that
     * DXT5 uses for the alpha channel.
     */
    RGTC_R(20),
    /**
     * Texture format that uses
     * [url=https://www.khronos.org/opengl/wiki/Red_Green_Texture_Compression]Red Green Texture
     * Compression[/url], normalizing the red and green channel data using the same compression
     * algorithm that DXT5 uses for the alpha channel.
     */
    RGTC_RG(21),
    /**
     * Texture format that uses
     * [url=https://www.khronos.org/opengl/wiki/BPTC_Texture_Compression]BPTC[/url] compression with
     * unsigned normalized RGBA components.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    BPTC_RGBA(22),
    /**
     * Texture format that uses
     * [url=https://www.khronos.org/opengl/wiki/BPTC_Texture_Compression]BPTC[/url] compression with
     * signed floating-point RGB components.
     */
    BPTC_RGBF(23),
    /**
     * Texture format that uses
     * [url=https://www.khronos.org/opengl/wiki/BPTC_Texture_Compression]BPTC[/url] compression with
     * unsigned floating-point RGB components.
     */
    BPTC_RGBFU(24),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC1]Ericsson Texture
     * Compression format 1[/url], also referred to as "ETC1", and is part of the OpenGL ES graphics
     * standard. This format cannot store an alpha channel.
     */
    ETC(25),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`R11_EAC` variant), which provides one channel of unsigned data.
     */
    ETC2_R11(26),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`SIGNED_R11_EAC` variant), which provides one channel of signed
     * data.
     */
    ETC2_R11S(27),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`RG11_EAC` variant), which provides two channels of unsigned data.
     */
    ETC2_RG11(28),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`SIGNED_RG11_EAC` variant), which provides two channels of signed
     * data.
     */
    ETC2_RG11S(29),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`RGB8` variant), which is a follow-up of ETC1 and compresses RGB888
     * data.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    ETC2_RGB8(30),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`RGBA8`variant), which compresses RGBA8888 data with full alpha
     * support.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    ETC2_RGBA8(31),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`RGB8_PUNCHTHROUGH_ALPHA1` variant), which compresses RGBA data to
     * make alpha either fully transparent or fully opaque.
     *
     * **Note:** When creating an [ImageTexture], a nonlinear sRGB to linear encoding conversion is
     * performed.
     */
    ETC2_RGB8A1(32),
    /**
     * [url=https://en.wikipedia.org/wiki/Ericsson_Texture_Compression#ETC2_and_EAC]Ericsson Texture
     * Compression format 2[/url] (`RGBA8` variant), which compresses RA data and interprets it as two
     * channels (red and green). See also [FORMAT_ETC2_RGBA8].
     */
    ETC2_RA_AS_RG(33),
    /**
     * The [url=https://en.wikipedia.org/wiki/S3_Texture_Compression]S3TC[/url] texture format also
     * known as Block Compression 3 or BC3, which compresses RA data and interprets it as two channels
     * (red and green). See also [FORMAT_DXT5].
     */
    DXT5_RA_AS_RG(34),
    /**
     * [url=https://en.wikipedia.org/wiki/Adaptive_scalable_texture_compression]Adaptive Scalable
     * Texture Compression[/url]. This implements the 4×4 (high quality) mode.
     */
    ASTC_4x4(35),
    /**
     * Same format as [FORMAT_ASTC_4x4], but with the hint to let the GPU know it is used for HDR.
     */
    ASTC_4x4_HDR(36),
    /**
     * [url=https://en.wikipedia.org/wiki/Adaptive_scalable_texture_compression]Adaptive Scalable
     * Texture Compression[/url]. This implements the 8×8 (low quality) mode.
     */
    ASTC_8x8(37),
    /**
     * Same format as [FORMAT_ASTC_8x8], but with the hint to let the GPU know it is used for HDR.
     */
    ASTC_8x8_HDR(38),
    /**
     * OpenGL texture format `GL_R16` where there's one component, a 16-bit unsigned normalized
     * integer value. Since the value is normalized, each component is clamped between `0.0` and `1.0`
     * (inclusive).
     *
     * **Note:** Due to limited hardware support, it is mainly recommended to be used on desktop or
     * console devices. It may be unsupported on mobile or web, and will consequently be converted to
     * [FORMAT_RF].
     */
    R16(39),
    /**
     * OpenGL texture format `GL_RG16` where there are two components, each a 16-bit unsigned
     * normalized integer value. Since the value is normalized, each component is clamped between `0.0`
     * and `1.0` (inclusive).
     *
     * **Note:** Due to limited hardware support, it is mainly recommended to be used on desktop or
     * console devices. It may be unsupported on mobile or web, and will consequently be converted to
     * [FORMAT_RGF].
     */
    RG16(40),
    /**
     * OpenGL texture format `GL_RGB16` where there are three components, each a 16-bit unsigned
     * normalized integer value. Since the value is normalized, each component is clamped between `0.0`
     * and `1.0` (inclusive).
     *
     * **Note:** Due to limited hardware support, it is mainly recommended to be used on desktop or
     * console devices. It may be unsupported on mobile or web, and will consequently be converted to
     * [FORMAT_RGBF].
     */
    RGB16(41),
    /**
     * OpenGL texture format `GL_RGBA16` where there are four components, each a 16-bit unsigned
     * normalized integer value. Since the value is normalized, each component is clamped between `0.0`
     * and `1.0` (inclusive).
     *
     * **Note:** Due to limited hardware support, it is mainly recommended to be used on desktop or
     * console devices. It may be unsupported on mobile or web, and will consequently be converted to
     * [FORMAT_RGBAF].
     */
    RGBA16(42),
    /**
     * OpenGL texture format `GL_R16UI` where there's one component, a 16-bit unsigned integer
     * value. Each component is clamped between `0` and `65535` (inclusive).
     *
     * **Note:** When used in a shader, the texture requires usage of `usampler` samplers.
     * Additionally, it only supports nearest-neighbor filtering under the Compatibility renderer.
     *
     * **Note:** When sampling using [Image.getPixel], returned [Color]s have to be divided by
     * `65535` to get the correct color value.
     */
    R16I(43),
    /**
     * OpenGL texture format `GL_RG16UI` where there are two components, each a 16-bit unsigned
     * integer value. Each component is clamped between `0` and `65535` (inclusive).
     *
     * **Note:** When used in a shader, the texture requires usage of `usampler` samplers.
     * Additionally, it only supports nearest-neighbor filtering under the Compatibility renderer.
     *
     * **Note:** When sampling using [Image.getPixel], returned [Color]s have to be divided by
     * `65535` to get the correct color value.
     */
    RG16I(44),
    /**
     * OpenGL texture format `GL_RGB16UI` where there are three components, each a 16-bit unsigned
     * integer value. Each component is clamped between `0` and `65535` (inclusive).
     *
     * **Note:** When used in a shader, the texture requires usage of `usampler` samplers.
     * Additionally, it only supports nearest-neighbor filtering under the Compatibility renderer.
     *
     * **Note:** When sampling using [Image.getPixel], returned [Color]s have to be divided by
     * `65535` to get the correct color value.
     */
    RGB16I(45),
    /**
     * OpenGL texture format `GL_RGBA16UI` where there are four components, each a 16-bit unsigned
     * integer value. Each component is clamped between `0` and `65535` (inclusive).
     *
     * **Note:** When used in a shader, the texture requires usage of `usampler` samplers.
     * Additionally, it only supports nearest-neighbor filtering under the Compatibility renderer.
     *
     * **Note:** When sampling using [Image.getPixel], returned [Color]s have to be divided by
     * `65535` to get the correct color value.
     */
    RGBA16I(46),
    /**
     * Represents the size of the [Format] enum.
     */
    MAX(47),
    ;

    public companion object {
      public fun from(`value`: Long): Format = entries.single { it.`value` == `value` }
    }
  }

  public enum class Interpolation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Performs nearest-neighbor interpolation. If the image is resized, it will be pixelated.
     */
    INTERPOLATE_NEAREST(0),
    /**
     * Performs bilinear interpolation. If the image is resized, it will be blurry. This mode is
     * faster than [INTERPOLATE_CUBIC], but it results in lower quality.
     */
    INTERPOLATE_BILINEAR(1),
    /**
     * Performs cubic interpolation. If the image is resized, it will be blurry. This mode often
     * gives better results compared to [INTERPOLATE_BILINEAR], at the cost of being slower.
     */
    INTERPOLATE_CUBIC(2),
    /**
     * Performs bilinear separately on the two most-suited mipmap levels, then linearly interpolates
     * between them.
     *
     * It's slower than [INTERPOLATE_BILINEAR], but produces higher-quality results with far fewer
     * aliasing artifacts.
     *
     * If the image does not have mipmaps, they will be generated and used internally, but no
     * mipmaps will be generated on the resulting image.
     *
     * **Note:** If you intend to scale multiple copies of the original image, it's better to call
     * [generateMipmaps]] on it in advance, to avoid wasting processing power in generating them again
     * and again.
     *
     * On the other hand, if the image already has mipmaps, they will be used, and a new set will be
     * generated for the resulting image.
     */
    INTERPOLATE_TRILINEAR(3),
    /**
     * Performs Lanczos interpolation. This is the slowest image resizing mode, but it typically
     * gives the best results, especially when downscaling images.
     */
    INTERPOLATE_LANCZOS(4),
    ;

    public companion object {
      public fun from(`value`: Long): Interpolation = entries.single { it.`value` == `value` }
    }
  }

  public enum class AlphaMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Image is fully opaque. It does not store alpha data.
     */
    NONE(0),
    /**
     * Image stores either fully opaque or fully transparent pixels. Also known as punchthrough
     * alpha.
     */
    BIT(1),
    /**
     * Image stores alpha data with values varying between `0.0` and `1.0`.
     */
    BLEND(2),
    ;

    public companion object {
      public fun from(`value`: Long): AlphaMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CompressMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use S3TC compression.
     */
    S3TC(0),
    /**
     * Use ETC compression.
     */
    ETC(1),
    /**
     * Use ETC2 compression.
     */
    ETC2(2),
    /**
     * Use BPTC compression.
     */
    BPTC(3),
    /**
     * Use ASTC compression.
     */
    ASTC(4),
    /**
     * Represents the size of the [CompressMode] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): CompressMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class UsedChannels(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The image only uses one channel for luminance (grayscale).
     */
    L(0),
    /**
     * The image uses two channels for luminance and alpha, respectively.
     */
    LA(1),
    /**
     * The image only uses the red channel.
     */
    R(2),
    /**
     * The image uses two channels for red and green.
     */
    RG(3),
    /**
     * The image uses three channels for red, green, and blue.
     */
    RGB(4),
    /**
     * The image uses four channels for red, green, blue, and alpha.
     */
    RGBA(5),
    ;

    public companion object {
      public fun from(`value`: Long): UsedChannels = entries.single { it.`value` == `value` }
    }
  }

  public enum class CompressSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Source texture (before compression) is a regular texture. Default for all textures.
     */
    GENERIC(0),
    /**
     * Source texture (before compression) uses nonlinear sRGB encoding.
     */
    SRGB(1),
    /**
     * Source texture (before compression) is a normal texture (e.g. it can be compressed into two
     * channels).
     */
    NORMAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): CompressSource = entries.single { it.`value` == `value` }
    }
  }

  public enum class ASTCFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Hint to indicate that the high quality 4×4 ASTC compression format should be used.
     */
    ASTC_FORMAT_4x4(0),
    /**
     * Hint to indicate that the low quality 8×8 ASTC compression format should be used.
     */
    ASTC_FORMAT_8x8(1),
    ;

    public companion object {
      public fun from(`value`: Long): ASTCFormat = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getWidthName: MethodStringName0<Image, Int> =
        MethodStringName0<Image, Int>("get_width")

    @JvmField
    public val getHeightName: MethodStringName0<Image, Int> =
        MethodStringName0<Image, Int>("get_height")

    @JvmField
    public val getSizeName: MethodStringName0<Image, Vector2i> =
        MethodStringName0<Image, Vector2i>("get_size")

    @JvmField
    public val hasMipmapsName: MethodStringName0<Image, Boolean> =
        MethodStringName0<Image, Boolean>("has_mipmaps")

    @JvmField
    public val getFormatName: MethodStringName0<Image, Format> =
        MethodStringName0<Image, Format>("get_format")

    @JvmField
    public val getDataName: MethodStringName0<Image, PackedByteArray> =
        MethodStringName0<Image, PackedByteArray>("get_data")

    @JvmField
    public val getDataSizeName: MethodStringName0<Image, Long> =
        MethodStringName0<Image, Long>("get_data_size")

    @JvmField
    public val convertName: MethodStringName1<Image, Unit, Format> =
        MethodStringName1<Image, Unit, Format>("convert")

    @JvmField
    public val getMipmapCountName: MethodStringName0<Image, Int> =
        MethodStringName0<Image, Int>("get_mipmap_count")

    @JvmField
    public val getMipmapOffsetName: MethodStringName1<Image, Long, Int> =
        MethodStringName1<Image, Long, Int>("get_mipmap_offset")

    @JvmField
    public val resizeToPo2Name: MethodStringName2<Image, Unit, Boolean, Interpolation> =
        MethodStringName2<Image, Unit, Boolean, Interpolation>("resize_to_po2")

    @JvmField
    public val resizeName: MethodStringName3<Image, Unit, Int, Int, Interpolation> =
        MethodStringName3<Image, Unit, Int, Int, Interpolation>("resize")

    @JvmField
    public val shrinkX2Name: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("shrink_x2")

    @JvmField
    public val cropName: MethodStringName2<Image, Unit, Int, Int> =
        MethodStringName2<Image, Unit, Int, Int>("crop")

    @JvmField
    public val flipXName: MethodStringName0<Image, Unit> = MethodStringName0<Image, Unit>("flip_x")

    @JvmField
    public val flipYName: MethodStringName0<Image, Unit> = MethodStringName0<Image, Unit>("flip_y")

    @JvmField
    public val generateMipmapsName: MethodStringName1<Image, Error, Boolean> =
        MethodStringName1<Image, Error, Boolean>("generate_mipmaps")

    @JvmField
    public val clearMipmapsName: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("clear_mipmaps")

    @JvmField
    public val createName: MethodStringName4<Image, Image?, Int, Int, Boolean, Format> =
        MethodStringName4<Image, Image?, Int, Int, Boolean, Format>("create")

    @JvmField
    public val createEmptyName: MethodStringName4<Image, Image?, Int, Int, Boolean, Format> =
        MethodStringName4<Image, Image?, Int, Int, Boolean, Format>("create_empty")

    @JvmField
    public val createFromDataName:
        MethodStringName5<Image, Image?, Int, Int, Boolean, Format, PackedByteArray> =
        MethodStringName5<Image, Image?, Int, Int, Boolean, Format, PackedByteArray>("create_from_data")

    @JvmField
    public val setDataName:
        MethodStringName5<Image, Unit, Int, Int, Boolean, Format, PackedByteArray> =
        MethodStringName5<Image, Unit, Int, Int, Boolean, Format, PackedByteArray>("set_data")

    @JvmField
    public val isEmptyName: MethodStringName0<Image, Boolean> =
        MethodStringName0<Image, Boolean>("is_empty")

    @JvmField
    public val loadName: MethodStringName1<Image, Error, String> =
        MethodStringName1<Image, Error, String>("load")

    @JvmField
    public val loadFromFileName: MethodStringName1<Image, Image?, String> =
        MethodStringName1<Image, Image?, String>("load_from_file")

    @JvmField
    public val savePngName: MethodStringName1<Image, Error, String> =
        MethodStringName1<Image, Error, String>("save_png")

    @JvmField
    public val savePngToBufferName: MethodStringName0<Image, PackedByteArray> =
        MethodStringName0<Image, PackedByteArray>("save_png_to_buffer")

    @JvmField
    public val saveJpgName: MethodStringName2<Image, Error, String, Float> =
        MethodStringName2<Image, Error, String, Float>("save_jpg")

    @JvmField
    public val saveJpgToBufferName: MethodStringName1<Image, PackedByteArray, Float> =
        MethodStringName1<Image, PackedByteArray, Float>("save_jpg_to_buffer")

    @JvmField
    public val saveExrName: MethodStringName4<Image, Error, String, Boolean, Boolean, Float> =
        MethodStringName4<Image, Error, String, Boolean, Boolean, Float>("save_exr")

    @JvmField
    public val saveExrToBufferName:
        MethodStringName3<Image, PackedByteArray, Boolean, Boolean, Float> =
        MethodStringName3<Image, PackedByteArray, Boolean, Boolean, Float>("save_exr_to_buffer")

    @JvmField
    public val saveDdsName: MethodStringName1<Image, Error, String> =
        MethodStringName1<Image, Error, String>("save_dds")

    @JvmField
    public val saveDdsToBufferName: MethodStringName0<Image, PackedByteArray> =
        MethodStringName0<Image, PackedByteArray>("save_dds_to_buffer")

    @JvmField
    public val saveWebpName: MethodStringName3<Image, Error, String, Boolean, Float> =
        MethodStringName3<Image, Error, String, Boolean, Float>("save_webp")

    @JvmField
    public val saveWebpToBufferName: MethodStringName2<Image, PackedByteArray, Boolean, Float> =
        MethodStringName2<Image, PackedByteArray, Boolean, Float>("save_webp_to_buffer")

    @JvmField
    public val detectAlphaName: MethodStringName0<Image, AlphaMode> =
        MethodStringName0<Image, AlphaMode>("detect_alpha")

    @JvmField
    public val isInvisibleName: MethodStringName0<Image, Boolean> =
        MethodStringName0<Image, Boolean>("is_invisible")

    @JvmField
    public val detectUsedChannelsName: MethodStringName1<Image, UsedChannels, CompressSource> =
        MethodStringName1<Image, UsedChannels, CompressSource>("detect_used_channels")

    @JvmField
    public val compressName:
        MethodStringName3<Image, Error, CompressMode, CompressSource, ASTCFormat> =
        MethodStringName3<Image, Error, CompressMode, CompressSource, ASTCFormat>("compress")

    @JvmField
    public val compressFromChannelsName:
        MethodStringName3<Image, Error, CompressMode, UsedChannels, ASTCFormat> =
        MethodStringName3<Image, Error, CompressMode, UsedChannels, ASTCFormat>("compress_from_channels")

    @JvmField
    public val decompressName: MethodStringName0<Image, Error> =
        MethodStringName0<Image, Error>("decompress")

    @JvmField
    public val isCompressedName: MethodStringName0<Image, Boolean> =
        MethodStringName0<Image, Boolean>("is_compressed")

    @JvmField
    public val rotate90Name: MethodStringName1<Image, Unit, ClockDirection> =
        MethodStringName1<Image, Unit, ClockDirection>("rotate_90")

    @JvmField
    public val rotate180Name: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("rotate_180")

    @JvmField
    public val fixAlphaEdgesName: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("fix_alpha_edges")

    @JvmField
    public val premultiplyAlphaName: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("premultiply_alpha")

    @JvmField
    public val srgbToLinearName: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("srgb_to_linear")

    @JvmField
    public val linearToSrgbName: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("linear_to_srgb")

    @JvmField
    public val normalMapToXyName: MethodStringName0<Image, Unit> =
        MethodStringName0<Image, Unit>("normal_map_to_xy")

    @JvmField
    public val rgbeToSrgbName: MethodStringName0<Image, Image?> =
        MethodStringName0<Image, Image?>("rgbe_to_srgb")

    @JvmField
    public val bumpMapToNormalMapName: MethodStringName1<Image, Unit, Float> =
        MethodStringName1<Image, Unit, Float>("bump_map_to_normal_map")

    @JvmField
    public val computeImageMetricsName:
        MethodStringName2<Image, Dictionary<Any?, Any?>, Image?, Boolean> =
        MethodStringName2<Image, Dictionary<Any?, Any?>, Image?, Boolean>("compute_image_metrics")

    @JvmField
    public val blitRectName: MethodStringName3<Image, Unit, Image?, Rect2i, Vector2i> =
        MethodStringName3<Image, Unit, Image?, Rect2i, Vector2i>("blit_rect")

    @JvmField
    public val blitRectMaskName: MethodStringName4<Image, Unit, Image?, Image?, Rect2i, Vector2i> =
        MethodStringName4<Image, Unit, Image?, Image?, Rect2i, Vector2i>("blit_rect_mask")

    @JvmField
    public val blendRectName: MethodStringName3<Image, Unit, Image?, Rect2i, Vector2i> =
        MethodStringName3<Image, Unit, Image?, Rect2i, Vector2i>("blend_rect")

    @JvmField
    public val blendRectMaskName: MethodStringName4<Image, Unit, Image?, Image?, Rect2i, Vector2i> =
        MethodStringName4<Image, Unit, Image?, Image?, Rect2i, Vector2i>("blend_rect_mask")

    @JvmField
    public val fillName: MethodStringName1<Image, Unit, Color> =
        MethodStringName1<Image, Unit, Color>("fill")

    @JvmField
    public val fillRectName: MethodStringName2<Image, Unit, Rect2i, Color> =
        MethodStringName2<Image, Unit, Rect2i, Color>("fill_rect")

    @JvmField
    public val getUsedRectName: MethodStringName0<Image, Rect2i> =
        MethodStringName0<Image, Rect2i>("get_used_rect")

    @JvmField
    public val getRegionName: MethodStringName1<Image, Image?, Rect2i> =
        MethodStringName1<Image, Image?, Rect2i>("get_region")

    @JvmField
    public val copyFromName: MethodStringName1<Image, Unit, Image?> =
        MethodStringName1<Image, Unit, Image?>("copy_from")

    @JvmField
    public val getPixelvName: MethodStringName1<Image, Color, Vector2i> =
        MethodStringName1<Image, Color, Vector2i>("get_pixelv")

    @JvmField
    public val getPixelName: MethodStringName2<Image, Color, Int, Int> =
        MethodStringName2<Image, Color, Int, Int>("get_pixel")

    @JvmField
    public val setPixelvName: MethodStringName2<Image, Unit, Vector2i, Color> =
        MethodStringName2<Image, Unit, Vector2i, Color>("set_pixelv")

    @JvmField
    public val setPixelName: MethodStringName3<Image, Unit, Int, Int, Color> =
        MethodStringName3<Image, Unit, Int, Int, Color>("set_pixel")

    @JvmField
    public val adjustBcsName: MethodStringName3<Image, Unit, Float, Float, Float> =
        MethodStringName3<Image, Unit, Float, Float, Float>("adjust_bcs")

    @JvmField
    public val loadPngFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_png_from_buffer")

    @JvmField
    public val loadJpgFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_jpg_from_buffer")

    @JvmField
    public val loadWebpFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_webp_from_buffer")

    @JvmField
    public val loadTgaFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_tga_from_buffer")

    @JvmField
    public val loadBmpFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_bmp_from_buffer")

    @JvmField
    public val loadKtxFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_ktx_from_buffer")

    @JvmField
    public val loadDdsFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_dds_from_buffer")

    @JvmField
    public val loadExrFromBufferName: MethodStringName1<Image, Error, PackedByteArray> =
        MethodStringName1<Image, Error, PackedByteArray>("load_exr_from_buffer")

    @JvmField
    public val loadSvgFromBufferName: MethodStringName2<Image, Error, PackedByteArray, Float> =
        MethodStringName2<Image, Error, PackedByteArray, Float>("load_svg_from_buffer")

    @JvmField
    public val loadSvgFromStringName: MethodStringName2<Image, Error, String, Float> =
        MethodStringName2<Image, Error, String, Float>("load_svg_from_string")

    /**
     * The maximal width allowed for [Image] resources.
     */
    public final const val MAX_WIDTH: Long = 16777216

    /**
     * The maximal height allowed for [Image] resources.
     */
    public final const val MAX_HEIGHT: Long = 16777216

    /**
     * Creates an empty image of the given size and format. If [useMipmaps] is `true`, generates
     * mipmaps for this image (see [generateMipmaps]).
     */
    @JvmStatic
    public final fun create(
      width: Int,
      height: Int,
      useMipmaps: Boolean,
      format: Format,
    ): Image? {
      TransferContext.writeMethodArguments_LONG_LONG_BOOL_LONG(0L, 0L, width.toLong(), height.toLong(), useMipmaps, format.value)
      TransferContext.callPtrMethod(MethodBindings.createPtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as Image?)
    }

    /**
     * Creates an empty image of the given size and format. If [useMipmaps] is `true`, generates
     * mipmaps for this image (see [generateMipmaps]).
     */
    @JvmStatic
    public final fun createEmpty(
      width: Int,
      height: Int,
      useMipmaps: Boolean,
      format: Format,
    ): Image? {
      TransferContext.writeMethodArguments_LONG_LONG_BOOL_LONG(0L, 0L, width.toLong(), height.toLong(), useMipmaps, format.value)
      TransferContext.callPtrMethod(MethodBindings.createEmptyPtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as Image?)
    }

    /**
     * Creates a new image of the given size and format. Fills the image with the given raw data. If
     * [useMipmaps] is `true`, loads the mipmaps for this image from [data]. See [generateMipmaps].
     */
    @JvmStatic
    public final fun createFromData(
      width: Int,
      height: Int,
      useMipmaps: Boolean,
      format: Format,
      `data`: PackedByteArray,
    ): Image? {
      TransferContext.writeMethodArguments_LONG_LONG_BOOL_LONG_PACKED_BYTE_ARRAY(0L, 0L, width.toLong(), height.toLong(), useMipmaps, format.value, data)
      TransferContext.callPtrMethod(MethodBindings.createFromDataPtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as Image?)
    }

    /**
     * Creates a new [Image] and loads data from the specified file.
     */
    @JvmStatic
    public final fun loadFromFile(path: String): Image? {
      TransferContext.writeMethodArguments_STRING(0L, 0L, path)
      TransferContext.callMethod(MethodBindings.loadFromFilePtr)
      return (TransferContext.readReturnValue_OBJECT() as Image?)
    }
  }

  public object MethodBindings {
    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_width", 3905245786)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_height", 3905245786)

    internal val getSizePtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "get_size", 3690982128)

    internal val hasMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "has_mipmaps", 36873697)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_format", 3847873762)

    internal val getDataPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "get_data", 2362200018)

    internal val getDataSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_data_size", 3905245786)

    internal val convertPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "convert", 2120693146)

    internal val getMipmapCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_mipmap_count", 3905245786)

    internal val getMipmapOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_mipmap_offset", 923996154)

    internal val resizeToPo2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "resize_to_po2", 4189212329)

    internal val resizePtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "resize", 994498151)

    internal val shrinkX2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "shrink_x2", 3218959716)

    internal val cropPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "crop", 3937882851)

    internal val flipXPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "flip_x", 3218959716)

    internal val flipYPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "flip_y", 3218959716)

    internal val generateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "generate_mipmaps", 1633102583)

    internal val clearMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "clear_mipmaps", 3218959716)

    internal val createPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "create", 986942177)

    internal val createEmptyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "create_empty", 986942177)

    internal val createFromDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "create_from_data", 299398494)

    internal val setDataPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "set_data", 2740482212)

    internal val isEmptyPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "is_empty", 36873697)

    internal val loadPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "load", 166001499)

    internal val loadFromFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_from_file", 736337515)

    internal val savePngPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "save_png", 2113323047)

    internal val savePngToBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "save_png_to_buffer", 2362200018)

    internal val saveJpgPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "save_jpg", 2800019068)

    internal val saveJpgToBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "save_jpg_to_buffer", 592235273)

    internal val saveExrPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "save_exr", 2018602448)

    internal val saveExrToBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "save_exr_to_buffer", 1477518536)

    internal val saveDdsPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "save_dds", 2113323047)

    internal val saveDdsToBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "save_dds_to_buffer", 2362200018)

    internal val saveWebpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "save_webp", 2781156876)

    internal val saveWebpToBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "save_webp_to_buffer", 1214628238)

    internal val detectAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "detect_alpha", 2030116505)

    internal val isInvisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "is_invisible", 36873697)

    internal val detectUsedChannelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "detect_used_channels", 2703139984)

    internal val compressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "compress", 2975424957)

    internal val compressFromChannelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "compress_from_channels", 4212890953)

    internal val decompressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "decompress", 166280745)

    internal val isCompressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "is_compressed", 36873697)

    internal val rotate90Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "rotate_90", 1901204267)

    internal val rotate180Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "rotate_180", 3218959716)

    internal val fixAlphaEdgesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "fix_alpha_edges", 3218959716)

    internal val premultiplyAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "premultiply_alpha", 3218959716)

    internal val srgbToLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "srgb_to_linear", 3218959716)

    internal val linearToSrgbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "linear_to_srgb", 3218959716)

    internal val normalMapToXyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "normal_map_to_xy", 3218959716)

    internal val rgbeToSrgbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "rgbe_to_srgb", 564927088)

    internal val bumpMapToNormalMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "bump_map_to_normal_map", 3423495036)

    internal val computeImageMetricsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "compute_image_metrics", 3080961247)

    internal val blitRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "blit_rect", 2903928755)

    internal val blitRectMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "blit_rect_mask", 3383581145)

    internal val blendRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "blend_rect", 2903928755)

    internal val blendRectMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "blend_rect_mask", 3383581145)

    internal val fillPtr: VoidPtr = TypeManager.getMethodBindPtr("Image", "fill", 2920490490)

    internal val fillRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "fill_rect", 514693913)

    internal val getUsedRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_used_rect", 410525958)

    internal val getRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_region", 2601441065)

    internal val copyFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "copy_from", 532598488)

    internal val getPixelvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_pixelv", 1532707496)

    internal val getPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "get_pixel", 2165839948)

    internal val setPixelvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "set_pixelv", 287851464)

    internal val setPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "set_pixel", 3733378741)

    internal val adjustBcsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "adjust_bcs", 2385087082)

    internal val loadPngFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_png_from_buffer", 680677267)

    internal val loadJpgFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_jpg_from_buffer", 680677267)

    internal val loadWebpFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_webp_from_buffer", 680677267)

    internal val loadTgaFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_tga_from_buffer", 680677267)

    internal val loadBmpFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_bmp_from_buffer", 680677267)

    internal val loadKtxFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_ktx_from_buffer", 680677267)

    internal val loadDdsFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_dds_from_buffer", 680677267)

    internal val loadExrFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_exr_from_buffer", 680677267)

    internal val loadSvgFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_svg_from_buffer", 311853421)

    internal val loadSvgFromStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Image", "load_svg_from_string", 3254053600)
  }
}
