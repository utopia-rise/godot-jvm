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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.Signal1
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
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
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, isMonitoringFeeds)
    TransferContext.callMethod(MethodBindings.setMonitoringFeedsPtr)
  }

  @JvmStatic
  public final fun isMonitoringFeeds(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMonitoringFeedsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [CameraFeed] corresponding to the camera with the given [index].
   */
  @JvmStatic
  public final fun getFeed(index: Int): CameraFeed? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getFeedPtr)
    return (TransferContext.readReturnValue_OBJECT() as CameraFeed?)
  }

  /**
   * Returns the number of [CameraFeed]s registered.
   */
  @JvmStatic
  public final fun getFeedCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFeedCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns an array of [CameraFeed]s.
   */
  @JvmStatic
  public final fun feeds(): VariantArray<CameraFeed> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.feedsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<CameraFeed>)
  }

  /**
   * Adds the camera [feed] to the camera server.
   */
  @JvmStatic
  public final fun addFeed(feed: CameraFeed?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, feed)
    TransferContext.callMethod(MethodBindings.addFeedPtr)
  }

  /**
   * Removes the specified camera [feed].
   */
  @JvmStatic
  public final fun removeFeed(feed: CameraFeed?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, feed)
    TransferContext.callMethod(MethodBindings.removeFeedPtr)
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
