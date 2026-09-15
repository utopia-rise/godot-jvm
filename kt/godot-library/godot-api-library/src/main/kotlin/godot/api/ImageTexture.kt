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
import godot.core.Vector2i
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_VECTOR2I
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * A [Texture2D] based on an [Image]. For an image to be displayed, an [ImageTexture] has to be
 * created from it using the [createFromImage] method:
 *
 * ```
 * var image = Image.load_from_file("res://icon.svg")
 * var texture = ImageTexture.create_from_image(image)
 * $Sprite2D.texture = texture
 * ```
 *
 * This way, textures can be created at run-time by loading images both from within the editor and
 * externally.
 *
 * **Warning:** Prefer to load imported textures with [@GDScript.load] over loading them from within
 * the filesystem dynamically with [Image.load], as it may not work in exported projects:
 *
 * ```
 * var texture = load("res://icon.svg")
 * $Sprite2D.texture = texture
 * ```
 *
 * This is because images have to be imported as a [CompressedTexture2D] first to be loaded with
 * [@GDScript.load]. If you'd still like to load an image file just like any other [Resource], import
 * it as an [Image] resource instead, and then load it normally using the [@GDScript.load] method.
 *
 * **Note:** The image can be retrieved from an imported texture using the [Texture2D.getImage]
 * method, which returns a copy of the image:
 *
 * ```
 * var texture = load("res://icon.svg")
 * var image = texture.get_image()
 * ```
 *
 * An [ImageTexture] is not meant to be operated from within the editor interface directly, and is
 * mostly useful for rendering images on screen dynamically via code. If you need to generate images
 * procedurally from within the editor, consider saving and importing images as custom texture
 * resources implementing a new [EditorImportPlugin].
 *
 * **Note:** The maximum texture size is 16384×16384 pixels due to graphics hardware limitations.
 */
@GodotBaseType
public open class ImageTexture : Texture2D() {
  public final inline val image: Image?
    @JvmName("imageProperty")
    get() = getImage()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(301, scriptPtr)
  }

  /**
   * Replaces the texture's data with a new [Image]. This will re-allocate new memory for the
   * texture.
   *
   * If you want to update the image, but don't need to change its parameters (format, size), use
   * [update] instead for better performance.
   */
  public final fun setImage(image: Image?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, image)
    TransferContext.callPtrMethod(MethodBindings.setImagePtr, 0)
  }

  /**
   * Replaces the texture's data with a new [Image].
   *
   * **Note:** The texture has to be created using [createFromImage] or initialized first with the
   * [setImage] method before it can be updated. The new image dimensions, format, and mipmaps
   * configuration should match the existing texture's image configuration.
   *
   * Use this method over [setImage] if you need to update the texture frequently, which is faster
   * than allocating additional memory for a new texture each time.
   */
  public final fun update(image: Image?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, image)
    TransferContext.callPtrMethod(MethodBindings.updatePtr, 0)
  }

  /**
   * Resizes the texture to the specified dimensions.
   */
  public final fun setSizeOverride(size: Vector2i): Unit {
    TransferContext.writeMethodArguments_VECTOR2I(ptr, objectID.id, size)
    TransferContext.callPtrMethod(MethodBindings.setSizeOverridePtr, 0)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("ImageTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("ImageTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val createFromImageName: MethodStringName1<ImageTexture, ImageTexture?, Image?> =
        MethodStringName1<ImageTexture, ImageTexture?, Image?>("create_from_image")

    @JvmField
    public val setImageName: MethodStringName1<ImageTexture, Unit, Image?> =
        MethodStringName1<ImageTexture, Unit, Image?>("set_image")

    @JvmField
    public val updateName: MethodStringName1<ImageTexture, Unit, Image?> =
        MethodStringName1<ImageTexture, Unit, Image?>("update")

    @JvmField
    public val setSizeOverrideName: MethodStringName1<ImageTexture, Unit, Vector2i> =
        MethodStringName1<ImageTexture, Unit, Vector2i>("set_size_override")

    /**
     * Creates a new [ImageTexture] and initializes it by allocating and setting the data from an
     * [Image].
     */
    @JvmStatic
    public final fun createFromImage(image: Image?): ImageTexture? {
      TransferContext.writeMethodArguments_OBJECT(0L, 0L, image)
      TransferContext.callPtrMethod(MethodBindings.createFromImagePtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as ImageTexture?)
    }
  }

  public object MethodBindings {
    internal val createFromImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTexture", "create_from_image", 2775144163)

    internal val setImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTexture", "set_image", 532598488)

    internal val updatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTexture", "update", 532598488)

    internal val setSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImageTexture", "set_size_override", 1130785943)
  }
}
