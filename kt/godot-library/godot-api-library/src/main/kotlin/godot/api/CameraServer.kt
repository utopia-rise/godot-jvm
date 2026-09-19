// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.Signal1
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * The [CameraServer] keeps track of different cameras accessible in Godot. These are external
 * cameras such as webcams or the cameras on your phone.
 *
 * It is notably used to provide AR modules with a video feed from the camera.
 *
 * **Note:** This class is currently only implemented on Linux, Android, macOS, and iOS. On other
 * platforms no [CameraFeed]s will be available. To get a [CameraFeed] on iOS, enable
 * [EditorExportPlatformIOS.modules/camera].
 */
@GodotBaseType
public object CameraServer : Object() {
  @JvmField
  public val setMonitoringFeedsName: MethodStringName1<CameraServer, Unit, Boolean> =
      MethodStringName1<CameraServer, Unit, Boolean>("set_monitoring_feeds")

  @JvmField
  public val isMonitoringFeedsName: MethodStringName0<CameraServer, Boolean> =
      MethodStringName0<CameraServer, Boolean>("is_monitoring_feeds")

  @JvmField
  public val getFeedName: MethodStringName1<CameraServer, CameraFeed?, Int> =
      MethodStringName1<CameraServer, CameraFeed?, Int>("get_feed")

  @JvmField
  public val getFeedCountName: MethodStringName0<CameraServer, Int> =
      MethodStringName0<CameraServer, Int>("get_feed_count")

  @JvmField
  public val feedsName: MethodStringName0<CameraServer, VariantArray<CameraFeed>> =
      MethodStringName0<CameraServer, VariantArray<CameraFeed>>("feeds")

  @JvmField
  public val addFeedName: MethodStringName1<CameraServer, Unit, CameraFeed?> =
      MethodStringName1<CameraServer, Unit, CameraFeed?>("add_feed")

  @JvmField
  public val removeFeedName: MethodStringName1<CameraServer, Unit, CameraFeed?> =
      MethodStringName1<CameraServer, Unit, CameraFeed?>("remove_feed")

  /**
   * Emitted when a [CameraFeed] is added (e.g. a webcam is plugged in).
   */
  @JvmStatic
  public val cameraFeedAdded: Signal1<Long> by Signal1

  /**
   * Emitted when a [CameraFeed] is removed (e.g. a webcam is unplugged).
   */
  @JvmStatic
  public val cameraFeedRemoved: Signal1<Long> by Signal1

  /**
   * Emitted when camera feeds are updated.
   */
  @JvmStatic
  public val cameraFeedsUpdated: Signal0 by Signal0

  /**
   * If `true`, the server is actively monitoring available camera feeds.
   *
   * This has a performance cost, so only set it to `true` when you're actively accessing the
   * camera.
   *
   * **Note:** After setting it to `true`, you can receive updated camera feeds through the [signal
   * camera_feeds_updated] signal.
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	CameraServer.camera_feeds_updated.connect(_on_camera_feeds_updated)
   * 	CameraServer.monitoring_feeds = true
   *
   * func _on_camera_feeds_updated():
   * 	var feeds = CameraServer.feeds()
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	CameraServer.CameraFeedsUpdated += OnCameraFeedsUpdated;
   * 	CameraServer.MonitoringFeeds = true;
   * }
   *
   * void OnCameraFeedsUpdated()
   * {
   * 	var feeds = CameraServer.Feeds();
   * }
   * ```
   */
  @JvmStatic
  public final inline var monitoringFeeds: Boolean
    @JvmName("monitoringFeedsProperty")
    get() = isMonitoringFeeds()
    @JvmName("monitoringFeedsProperty")
    set(`value`) {
      setMonitoringFeeds(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(2)
  }

  @JvmStatic
  public final fun setMonitoringFeeds(isMonitoringFeeds: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setMonitoringFeedsPtr, isMonitoringFeeds)
  }

  @JvmStatic
  public final fun isMonitoringFeeds(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isMonitoringFeedsPtr)

  /**
   * Returns the [CameraFeed] corresponding to the camera with the given [index].
   */
  @JvmStatic
  public final fun getFeed(index: Int): CameraFeed? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getFeedPtr, index.toLong()) as CameraFeed?)

  /**
   * Returns the number of [CameraFeed]s registered.
   */
  @JvmStatic
  public final fun getFeedCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFeedCountPtr).toInt()

  /**
   * Returns an array of [CameraFeed]s.
   */
  @JvmStatic
  public final fun feeds(): VariantArray<CameraFeed> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.feedsPtr) as VariantArray<CameraFeed>)

  /**
   * Adds the camera [feed] to the camera server.
   */
  @JvmStatic
  public final fun addFeed(feed: CameraFeed?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.addFeedPtr, feed)
  }

  /**
   * Removes the specified camera [feed].
   */
  @JvmStatic
  public final fun removeFeed(feed: CameraFeed?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.removeFeedPtr, feed)
  }

  public enum class FeedImage(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The RGBA camera image.
     */
    RGBA(0),
    /**
     * The [url=https://en.wikipedia.org/wiki/YCbCr]YCbCr[/url] camera image.
     */
    YCBCR(0),
    /**
     * The Y component camera image.
     */
    Y(0),
    /**
     * The CbCr component camera image.
     */
    CBCR(1),
    ;

    public companion object {
      public fun from(`value`: Long): FeedImage = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val setMonitoringFeedsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "set_monitoring_feeds", 2586408642)

    internal val isMonitoringFeedsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "is_monitoring_feeds", 36873697)

    internal val getFeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "get_feed", 361927068)

    internal val getFeedCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "get_feed_count", 2455072627)

    internal val feedsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "feeds", 2915620761)

    internal val addFeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "add_feed", 3204782488)

    internal val removeFeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraServer", "remove_feed", 3204782488)
  }
}
