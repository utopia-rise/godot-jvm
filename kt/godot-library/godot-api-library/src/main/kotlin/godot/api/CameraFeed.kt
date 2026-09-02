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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Signal0
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.TRANSFORM2D
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A camera feed gives you access to a single physical camera attached to your device. When enabled,
 * Godot will start capturing frames from the camera which can then be used. See also [CameraServer].
 *
 * **Note:** Many cameras will return YCbCr images which are split into two textures and need to be
 * combined in a shader. Godot does this automatically for you if you set the environment to show the
 * camera image in the background.
 *
 * **Note:** This class is currently only implemented on Linux, Android, macOS, and iOS. On other
 * platforms no [CameraFeed]s will be available. To get a [CameraFeed] on iOS, enable
 * [EditorExportPlatformIOS.modules/camera].
 */
@GodotBaseType
public open class CameraFeed : RefCounted() {
  /**
   * Emitted when a new frame is available.
   */
  public val frameChanged: Signal0 by Signal0

  /**
   * Emitted when the format has changed.
   */
  public val formatChanged: Signal0 by Signal0

  /**
   * If `true`, the feed is active.
   */
  public final inline var feedIsActive: Boolean
    @JvmName("feedIsActiveProperty")
    get() = isActive()
    @JvmName("feedIsActiveProperty")
    set(`value`) {
      setActive(value)
    }

  /**
   * The transform applied to the camera's image.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var feedTransform: Transform2D
    @JvmName("feedTransformProperty")
    get() = getTransform()
    @JvmName("feedTransformProperty")
    set(`value`) {
      setTransform(value)
    }

  /**
   * Formats supported by the feed. Each entry is a [Dictionary] describing format parameters.
   */
  public final inline val formats: VariantArray<Any?>
    @JvmName("formatsProperty")
    get() = getFormats()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(140, scriptPtr)
  }

  /**
   * This is a helper function for [feedTransform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = camerafeed.feedTransform
   * //Your changes
   * camerafeed.feedTransform = myCoreType
   * ``````
   *
   * The transform applied to the camera's image.
   */
  @CoreTypeHelper
  public final fun feedTransformMutate(block: Transform2D.() -> Unit): Transform2D =
      feedTransform.apply {
     block(this)
     feedTransform = this
  }

  /**
   * Called when the camera feed is activated.
   */
  public open fun _activateFeed(): Boolean {
    throw NotImplementedError("CameraFeed::_activateFeed is not implemented.")
  }

  /**
   * Called when the camera feed is deactivated.
   */
  public open fun _deactivateFeed(): Unit {
    throw NotImplementedError("CameraFeed::_deactivateFeed is not implemented.")
  }

  /**
   * Override this method to set the format of the camera feed.
   */
  public open fun _setFormat(index: Int, parameters: Dictionary<Any?, Any?>): Boolean {
    throw NotImplementedError("CameraFeed::_setFormat is not implemented.")
  }

  /**
   * Override this method to define supported formats of the camera feed.
   */
  public open fun _getFormats(): VariantArray<Any?> {
    throw NotImplementedError("CameraFeed::_getFormats is not implemented.")
  }

  /**
   * Returns the unique ID for this feed.
   */
  public final fun getId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun isActive(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isActivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active)
    TransferContext.callMethod(MethodBindings.setActivePtr)
  }

  /**
   * Returns the camera's name.
   */
  public final fun getName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the camera's name.
   */
  public final fun setName(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setNamePtr)
  }

  /**
   * Returns the position of camera on the device.
   */
  public final fun getPosition(): FeedPosition {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return FeedPosition.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the position of this camera.
   */
  public final fun setPosition(position: FeedPosition): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to position.value)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  public final fun getTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  public final fun setTransform(transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  /**
   * Sets RGB image for this feed.
   */
  public final fun setRgbImage(rgbImage: Image?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to rgbImage)
    TransferContext.callMethod(MethodBindings.setRgbImagePtr)
  }

  /**
   * Sets YCbCr image for this feed.
   */
  public final fun setYcbcrImage(ycbcrImage: Image?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to ycbcrImage)
    TransferContext.callMethod(MethodBindings.setYcbcrImagePtr)
  }

  /**
   * Sets Y and CbCr images for this feed.
   */
  public final fun setYcbcrImages(yImage: Image?, cbcrImage: Image?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to yImage, OBJECT to cbcrImage)
    TransferContext.callMethod(MethodBindings.setYcbcrImagesPtr)
  }

  /**
   * Sets the feed as external feed provided by another library.
   */
  public final fun setExternal(width: Int, height: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong(), LONG to height.toLong())
    TransferContext.callMethod(MethodBindings.setExternalPtr)
  }

  /**
   * Returns the texture backend ID (usable by some external libraries that need a handle to a
   * texture to write data).
   */
  public final fun getTextureTexId(feedImageType: CameraServer.FeedImage): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feedImageType.value)
    TransferContext.callMethod(MethodBindings.getTextureTexIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns feed image data type.
   */
  public final fun getDatatype(): FeedDataType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDatatypePtr)
    return FeedDataType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun getFormats(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Sets the feed format parameters for the given [index] in the [formats] array. Returns `true` on
   * success. By default, the YUYV encoded stream is transformed to [FEED_RGB]. The YUYV encoded stream
   * output format can be changed by setting [parameters]'s `output` entry to one of the following:
   *
   * - `"separate"` will result in [FEED_YCBCR_SEP];
   *
   * - `"grayscale"` will result in desaturated [FEED_RGB];
   *
   * - `"copy"` will result in [FEED_YCBCR].
   */
  public final fun setFormat(index: Int, parameters: Dictionary<Any?, Any?>): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DICTIONARY to parameters)
    TransferContext.callMethod(MethodBindings.setFormatPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class FeedDataType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No image set for the feed.
     */
    NOIMAGE(0),
    /**
     * Feed supplies RGB images.
     */
    RGB(1),
    /**
     * Feed supplies YCbCr images that need to be converted to RGB.
     */
    YCBCR(2),
    /**
     * Feed supplies separate Y and CbCr images that need to be combined and converted to RGB.
     */
    YCBCR_SEP(3),
    /**
     * Feed supplies external image.
     */
    EXTERNAL(4),
    ;

    public companion object {
      public fun from(`value`: Long): FeedDataType = entries.single { it.`value` == `value` }
    }
  }

  public enum class FeedPosition(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Unspecified position.
     */
    UNSPECIFIED(0),
    /**
     * Camera is mounted at the front of the device.
     */
    FRONT(1),
    /**
     * Camera is mounted at the back of the device.
     */
    BACK(2),
    ;

    public companion object {
      public fun from(`value`: Long): FeedPosition = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getIdName: MethodStringName0<CameraFeed, Int> =
        MethodStringName0<CameraFeed, Int>("get_id")

    @JvmField
    public val isActiveName: MethodStringName0<CameraFeed, Boolean> =
        MethodStringName0<CameraFeed, Boolean>("is_active")

    @JvmField
    public val setActiveName: MethodStringName1<CameraFeed, Unit, Boolean> =
        MethodStringName1<CameraFeed, Unit, Boolean>("set_active")

    @JvmField
    public val getNameName: MethodStringName0<CameraFeed, String> =
        MethodStringName0<CameraFeed, String>("get_name")

    @JvmField
    public val setNameName: MethodStringName1<CameraFeed, Unit, String> =
        MethodStringName1<CameraFeed, Unit, String>("set_name")

    @JvmField
    public val getPositionName: MethodStringName0<CameraFeed, FeedPosition> =
        MethodStringName0<CameraFeed, FeedPosition>("get_position")

    @JvmField
    public val setPositionName: MethodStringName1<CameraFeed, Unit, FeedPosition> =
        MethodStringName1<CameraFeed, Unit, FeedPosition>("set_position")

    @JvmField
    public val getTransformName: MethodStringName0<CameraFeed, Transform2D> =
        MethodStringName0<CameraFeed, Transform2D>("get_transform")

    @JvmField
    public val setTransformName: MethodStringName1<CameraFeed, Unit, Transform2D> =
        MethodStringName1<CameraFeed, Unit, Transform2D>("set_transform")

    @JvmField
    public val setRgbImageName: MethodStringName1<CameraFeed, Unit, Image?> =
        MethodStringName1<CameraFeed, Unit, Image?>("set_rgb_image")

    @JvmField
    public val setYcbcrImageName: MethodStringName1<CameraFeed, Unit, Image?> =
        MethodStringName1<CameraFeed, Unit, Image?>("set_ycbcr_image")

    @JvmField
    public val setYcbcrImagesName: MethodStringName2<CameraFeed, Unit, Image?, Image?> =
        MethodStringName2<CameraFeed, Unit, Image?, Image?>("set_ycbcr_images")

    @JvmField
    public val setExternalName: MethodStringName2<CameraFeed, Unit, Int, Int> =
        MethodStringName2<CameraFeed, Unit, Int, Int>("set_external")

    @JvmField
    public val getTextureTexIdName: MethodStringName1<CameraFeed, Long, CameraServer.FeedImage> =
        MethodStringName1<CameraFeed, Long, CameraServer.FeedImage>("get_texture_tex_id")

    @JvmField
    public val getDatatypeName: MethodStringName0<CameraFeed, FeedDataType> =
        MethodStringName0<CameraFeed, FeedDataType>("get_datatype")

    @JvmField
    public val getFormatsName: MethodStringName0<CameraFeed, VariantArray<Any?>> =
        MethodStringName0<CameraFeed, VariantArray<Any?>>("get_formats")

    @JvmField
    public val setFormatName: MethodStringName2<CameraFeed, Boolean, Int, Dictionary<Any?, Any?>> =
        MethodStringName2<CameraFeed, Boolean, Int, Dictionary<Any?, Any?>>("set_format")
  }

  public object MethodBindings {
    internal val getIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_id", 3905245786)

    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "is_active", 36873697)

    internal val setActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_active", 2586408642)

    internal val getNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_name", 201670096)

    internal val setNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_name", 83702148)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_position", 2711679033)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_position", 611162623)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_transform", 3814499831)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_transform", 2761652528)

    internal val setRgbImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_rgb_image", 532598488)

    internal val setYcbcrImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_ycbcr_image", 532598488)

    internal val setYcbcrImagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_ycbcr_images", 1986484629)

    internal val setExternalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_external", 3937882851)

    internal val getTextureTexIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_texture_tex_id", 1135699418)

    internal val getDatatypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_datatype", 1477782850)

    internal val getFormatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "get_formats", 3995934104)

    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraFeed", "set_format", 31872775)
  }
}
