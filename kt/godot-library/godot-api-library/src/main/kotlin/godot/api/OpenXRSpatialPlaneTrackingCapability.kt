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
 * This class handles the OpenXR plane tracking spatial entity extension.
 */
@GodotBaseType
public open class OpenXRSpatialPlaneTrackingCapability : OpenXRExtensionWrapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(492, scriptPtr)
  }

  /**
   * Returns `true` if plane tracking is supported by the current device.
   */
  public final fun isSupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Calls [OpenXRSpatialEntityExtension.discoverSpatialEntities] and
   * [OpenXRSpatialEntityExtension.querySnapshot] with the plane entities associated with
   * [spatialContext].
   *
   * [componentData] are the [OpenXRSpatialComponentData]s to discover for this plane capability.
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

  public companion object {
    @JvmField
    public val isSupportedName: MethodStringName0<OpenXRSpatialPlaneTrackingCapability, Boolean> =
        MethodStringName0<OpenXRSpatialPlaneTrackingCapability, Boolean>("is_supported")

    @JvmField
    public val startEntityDiscoveryName:
        MethodStringName5<OpenXRSpatialPlaneTrackingCapability, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?, Callable>
        =
        MethodStringName5<OpenXRSpatialPlaneTrackingCapability, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?, Callable>("start_entity_discovery")
  }

  public object MethodBindings {
    internal val isSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialPlaneTrackingCapability", "is_supported", 2240911060)

    internal val startEntityDiscoveryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialPlaneTrackingCapability", "start_entity_discovery", 3452714169)
  }
}
