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
import godot.core.Error
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class for [Texture2DArray], [Cubemap] and [CubemapArray]. Cannot be used directly, but
 * contains all the functions necessary for accessing the derived resource types. See also [Texture3D].
 */
@GodotBaseType
public open class ImageTextureLayered internal constructor() : TextureLayered() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(303, scriptPtr)
  }

  /**
   * Creates an [ImageTextureLayered] from an array of [Image]s. See [Image.create] for the expected
   * data format. The first image decides the width, height, image format and mipmapping setting. The
   * other images *must* have the same width, height, image format and mipmapping setting.
   *
   * Each [Image] represents one `layer`.
   *
   * ```
   * # Fill in an array of Images with different colors.
   * var images = []
   * const LAYERS = 6
   * for i in LAYERS:
   * 	var image = Image.create_empty(128, 128, false, Image.FORMAT_RGB8)
   * 	if i &#37; 3 == 0:
   * 		image.fill(Color.RED)
   * 	elif i &#37; 3 == 1:
   * 		image.fill(Color.GREEN)
   * 	else:
   * 		image.fill(Color.BLUE)
   * 	images.push_back(image)
   *
   * # Create and save a 2D texture array. The array of images must have at least 1 Image.
   * var texture_2d_array = Texture2DArray.new()
   * texture_2d_array.create_from_images(images)
   * ResourceSaver.save(texture_2d_array, "res://texture_2d_array.res", ResourceSaver.FLAG_COMPRESS)
   *
   * # Create and save a cubemap. The array of images must have exactly 6 Images.
   * # The cubemap's images are specified in this order: X+, X-, Y+, Y-, Z+, Z-
   * # (in Godot's coordinate system, so Y+ is "up" and Z- is "forward").
   * var cubemap = Cubemap.new()
   * cubemap.create_from_images(images)
   * ResourceSaver.save(cubemap, "res://cubemap.res", ResourceSaver.FLAG_COMPRESS)
   *
   * # Create and save a cubemap array. The array of images must have a multiple of 6 Images.
   * # Each cubemap's images are specified in this order: X+, X-, Y+, Y-, Z+, Z-
   * # (in Godot's coordinate system, so Y+ is "up" and Z- is "forward").
   * var cubemap_array = CubemapArray.new()
   * cubemap_array.create_from_images(images)
   * ResourceSaver.save(cubemap_array, "res://cubemap_array.res", ResourceSaver.FLAG_COMPRESS)
   * ```
   */
  public final fun createFromImages(images: VariantArray<Image>): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to images)
    TransferContext.callMethod(MethodBindings.createFromImagesPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Replaces the existing [Image] data at the given [layer] with this new image.
   *
   * The given [Image] must have the same width, height, image format, and mipmapping flag as the
   * rest of the referenced images.
   *
   * If the image format is unsupported, it will be decompressed and converted to a similar and
   * supported [Image.Format].
   *
   * The update is immediate: it's synchronized with drawing.
   */
  public final fun updateLayer(image: Image?, layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.updateLayerPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("ImageTextureLayered::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayeredType(): Long {
    throw NotImplementedError("ImageTextureLayered::_getLayeredType can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("ImageTextureLayered::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("ImageTextureLayered::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayers(): Int {
    throw NotImplementedError("ImageTextureLayered::_getLayers can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("ImageTextureLayered::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayerData(layerIndex: Int): Image? {
    throw NotImplementedError("ImageTextureLayered::_getLayerData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val createFromImagesName:
        MethodStringName1<ImageTextureLayered, Error, VariantArray<Image>> =
        MethodStringName1<ImageTextureLayered, Error, VariantArray<Image>>("create_from_images")

    @JvmField
    public val updateLayerName: MethodStringName2<ImageTextureLayered, Unit, Image?, Int> =
        MethodStringName2<ImageTextureLayered, Unit, Image?, Int>("update_layer")
  }

  public object MethodBindings {
    internal val createFromImagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTextureLayered", "create_from_images", 2785773503)

    internal val updateLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTextureLayered", "update_layer", 3331733361)
  }
}
