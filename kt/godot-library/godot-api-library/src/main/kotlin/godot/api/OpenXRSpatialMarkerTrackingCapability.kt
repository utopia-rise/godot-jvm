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
import godot.core.Callable
import godot.core.MethodStringName0
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantCallable
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser._RID
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class handles the OpenXR marker tracking spatial entity extension.
 */
@GodotBaseType
public open class OpenXRSpatialMarkerTrackingCapability : OpenXRExtensionWrapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(491, scriptPtr)
  }

  /**
   * Returns `true` if QR code marker tracking is supported by the current device.
   */
  public final fun isQrcodeSupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isQrcodeSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if micro QR code marker tracking is supported by the current device.
   */
  public final fun isMicroQrcodeSupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMicroQrcodeSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if Aruco marker tracking is supported by the current device.
   */
  public final fun isArucoSupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isArucoSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if April tag marker tracking is supported by the current device.
   */
  public final fun isAprilTagSupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAprilTagSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Calls [OpenXRSpatialEntityExtension.discoverSpatialEntities] and
   * [OpenXRSpatialEntityExtension.querySnapshot] with the marker entities associated with
   * [spatialContext].
   *
   * [componentData] are the [OpenXRSpatialComponentData]s to discover for this marker capability.
   *
   * If [nextSnapshotCreate] is non-null, then pass this to the `next` parameter in
   * [OpenXRSpatialEntityExtension.discoverSpatialEntities].
   *
   * If [nextSnapshotQuery] is non-null, then pass this to the `next` parameter in
   * [OpenXRSpatialEntityExtension.querySnapshot].
   *
   * [userCallback], when non-null, is called with two parameters usually twice. The first parameter
   * is the [RID] of the discovery snapshot and the second parameter is a boolean where `false`
   * indicates the discovery snapshot is about to be processed, and `true` indicates the discovery
   * snapshot has been processed and [componentData] has valid data. The second call is skipped if an
   * error was encountered.
   *
   * The returned [OpenXRFutureResult] is identical to the return from
   * [OpenXRSpatialEntityExtension.discoverSpatialEntities].
   */
  @JvmOverloads
  public final fun startEntityDiscovery(
    spatialContext: RID,
    componentData: VariantArray<OpenXRSpatialComponentData>,
    nextSnapshotCreate: OpenXRStructureBase? = null,
    nextSnapshotQuery: OpenXRStructureBase? = null,
    userCallback: Callable = VariantCallable(),
  ): OpenXRFutureResult? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to spatialContext, ARRAY to componentData, OBJECT to nextSnapshotCreate, OBJECT to nextSnapshotQuery, CALLABLE to userCallback)
    TransferContext.callMethod(MethodBindings.startEntityDiscoveryPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRFutureResult?)
  }

  /**
   * Calls [OpenXRSpatialEntityExtension.updateSpatialEntities] and
   * [OpenXRSpatialEntityExtension.querySnapshot] with the marker entities associated with
   * [spatialContext].
   *
   * [componentData] are the [OpenXRSpatialComponentData]s to update for this marker capability.
   *
   * If [nextSnapshotCreate] is non-null, then pass this to the `next` parameter in
   * [OpenXRSpatialEntityExtension.updateSpatialEntities].
   *
   * If [nextSnapshotQuery] is non-null, then pass this to the `next` parameter in
   * [OpenXRSpatialEntityExtension.querySnapshot].
   */
  @JvmOverloads
  public final fun doEntityUpdate(
    spatialContext: RID,
    componentData: VariantArray<OpenXRSpatialComponentData>,
    nextSnapshotCreate: OpenXRStructureBase? = null,
    nextSnapshotQuery: OpenXRStructureBase? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to spatialContext, ARRAY to componentData, OBJECT to nextSnapshotCreate, OBJECT to nextSnapshotQuery)
    TransferContext.callMethod(MethodBindings.doEntityUpdatePtr)
  }

  public companion object {
    @JvmField
    public val isQrcodeSupportedName:
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean> =
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean>("is_qrcode_supported")

    @JvmField
    public val isMicroQrcodeSupportedName:
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean> =
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean>("is_micro_qrcode_supported")

    @JvmField
    public val isArucoSupportedName:
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean> =
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean>("is_aruco_supported")

    @JvmField
    public val isAprilTagSupportedName:
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean> =
        MethodStringName0<OpenXRSpatialMarkerTrackingCapability, Boolean>("is_april_tag_supported")

    @JvmField
    public val startEntityDiscoveryName:
        MethodStringName5<OpenXRSpatialMarkerTrackingCapability, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?, Callable>
        =
        MethodStringName5<OpenXRSpatialMarkerTrackingCapability, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?, Callable>("start_entity_discovery")

    @JvmField
    public val doEntityUpdateName:
        MethodStringName4<OpenXRSpatialMarkerTrackingCapability, Unit, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?>
        =
        MethodStringName4<OpenXRSpatialMarkerTrackingCapability, Unit, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?>("do_entity_update")
  }

  public object MethodBindings {
    internal val isQrcodeSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialMarkerTrackingCapability", "is_qrcode_supported", 2240911060)

    internal val isMicroQrcodeSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialMarkerTrackingCapability", "is_micro_qrcode_supported", 2240911060)

    internal val isArucoSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialMarkerTrackingCapability", "is_aruco_supported", 2240911060)

    internal val isAprilTagSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialMarkerTrackingCapability", "is_april_tag_supported", 2240911060)

    internal val startEntityDiscoveryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialMarkerTrackingCapability", "start_entity_discovery", 3452714169)

    internal val doEntityUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialMarkerTrackingCapability", "do_entity_update", 3138044275)
  }
}
