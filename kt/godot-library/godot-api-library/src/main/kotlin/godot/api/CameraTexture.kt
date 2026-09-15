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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This texture gives access to the camera texture provided by a [CameraFeed].
 *
 * **Note:** Many cameras supply YCbCr images which need to be converted in a shader.
 */
@GodotBaseType
public open class CameraTexture : Texture2D() {
  /**
   * The ID of the [CameraFeed] for which we want to display the image.
   */
  public final inline var cameraFeedId: Int
    @JvmName("cameraFeedIdProperty")
    get() = getCameraFeedId()
    @JvmName("cameraFeedIdProperty")
    set(`value`) {
      setCameraFeedId(value)
    }

  /**
   * Which image within the [CameraFeed] we want access to, important if the camera image is split
   * in a Y and CbCr component.
   */
  public final inline var whichFeed: CameraServer.FeedImage
    @JvmName("whichFeedProperty")
    get() = getWhichFeed()
    @JvmName("whichFeedProperty")
    set(`value`) {
      setWhichFeed(value)
    }

  /**
   * Convenience property that gives access to the active property of the [CameraFeed].
   */
  public final inline var cameraIsActive: Boolean
    @JvmName("cameraIsActiveProperty")
    get() = getCameraActive()
    @JvmName("cameraIsActiveProperty")
    set(`value`) {
      setCameraActive(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(140, scriptPtr)
  }

  public final fun setCameraFeedId(feedId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feedId.toLong())
    TransferContext.callMethod(MethodBindings.setCameraFeedIdPtr)
  }

  public final fun getCameraFeedId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraFeedIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setWhichFeed(whichFeed: CameraServer.FeedImage): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to whichFeed.value)
    TransferContext.callMethod(MethodBindings.setWhichFeedPtr)
  }

  public final fun getWhichFeed(): CameraServer.FeedImage {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWhichFeedPtr)
    return CameraServer.FeedImage.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCameraActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active)
    TransferContext.callMethod(MethodBindings.setCameraActivePtr)
  }

  public final fun getCameraActive(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraActivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("CameraTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("CameraTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setCameraFeedIdName: MethodStringName1<CameraTexture, Unit, Int> =
        MethodStringName1<CameraTexture, Unit, Int>("set_camera_feed_id")

    @JvmField
    public val getCameraFeedIdName: MethodStringName0<CameraTexture, Int> =
        MethodStringName0<CameraTexture, Int>("get_camera_feed_id")

    @JvmField
    public val setWhichFeedName: MethodStringName1<CameraTexture, Unit, CameraServer.FeedImage> =
        MethodStringName1<CameraTexture, Unit, CameraServer.FeedImage>("set_which_feed")

    @JvmField
    public val getWhichFeedName: MethodStringName0<CameraTexture, CameraServer.FeedImage> =
        MethodStringName0<CameraTexture, CameraServer.FeedImage>("get_which_feed")

    @JvmField
    public val setCameraActiveName: MethodStringName1<CameraTexture, Unit, Boolean> =
        MethodStringName1<CameraTexture, Unit, Boolean>("set_camera_active")

    @JvmField
    public val getCameraActiveName: MethodStringName0<CameraTexture, Boolean> =
        MethodStringName0<CameraTexture, Boolean>("get_camera_active")
  }

  public object MethodBindings {
    internal val setCameraFeedIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraTexture", "set_camera_feed_id", 1286410249)

    internal val getCameraFeedIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraTexture", "get_camera_feed_id", 3905245786)

    internal val setWhichFeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraTexture", "set_which_feed", 1595299230)

    internal val getWhichFeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraTexture", "get_which_feed", 91039457)

    internal val setCameraActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraTexture", "set_camera_active", 2586408642)

    internal val getCameraActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraTexture", "get_camera_active", 36873697)
  }
}
