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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.RID
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantCallable
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_CALLABLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_CALLABLE
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_OBJECT_RID_CALLABLE
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_RID_ARRAY_OBJECT_OBJECT
import godot.writeMethodArguments_RID_ARRAY_OBJECT_OBJECT_CALLABLE
import godot.writeMethodArguments_TRANSFORM3D_RID_OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This is an internal class that handles the OpenXR anchor spatial entity extension.
 */
@GodotBaseType
public open class OpenXRSpatialAnchorCapability : OpenXRExtensionWrapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(468, scriptPtr)
  }

  /**
   * Returns `true` if spatial anchors are supported by the hardware. Only returns a valid value
   * after OpenXR has been initialized.
   */
  public final fun isSpatialAnchorSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSpatialAnchorSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if persistent spatial anchors are supported by the hardware. Only returns a
   * valid value after OpenXR has been initialized.
   */
  public final fun isSpatialPersistenceSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSpatialPersistenceSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if this persistence scope is supported by our spatial anchor capability.
   *
   * **Note:** Only valid after an OpenXR instance has been created.
   */
  public final fun isPersistenceScopeSupported(scope: PersistenceScope): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, scope.value)
    TransferContext.callMethod(MethodBindings.isPersistenceScopeSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Calls [createPersistenceContext] with a configuration that likely works with the XR runtime.
   *
   * [userCallback] is called when the context is created.
   */
  @JvmOverloads
  public final fun createDefaultPersistenceContext(userCallback: Callable = VariantCallable()):
      OpenXRFutureResult? {
    TransferContext.writeMethodArguments_CALLABLE(ptr, objectID.id, userCallback)
    TransferContext.callMethod(MethodBindings.createDefaultPersistenceContextPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRFutureResult?)
  }

  /**
   * Creates a new persistence context for storing persistent data.
   *
   * **Note:** This is an asynchronous method and returns an [OpenXRFutureResult] object with which
   * to track the status, discarding this object will not cancel the creation process. On success
   * [userCallback] will be called if specified. The result value for this function is the [RID] for
   * our persistence context.
   */
  @JvmOverloads
  public final fun createPersistenceContext(scope: PersistenceScope, userCallback: Callable =
      VariantCallable()): OpenXRFutureResult? {
    TransferContext.writeMethodArguments_LONG_CALLABLE(ptr, objectID.id, scope.value, userCallback)
    TransferContext.callMethod(MethodBindings.createPersistenceContextPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRFutureResult?)
  }

  /**
   * Returns the internal handle for this persistence context.
   *
   * **Note:** For GDExtension implementations.
   */
  public final fun getPersistenceContextHandle(persistenceContext: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, persistenceContext)
    TransferContext.callMethod(MethodBindings.getPersistenceContextHandlePtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Frees a persistence context previously created with [createPersistenceContext].
   */
  public final fun freePersistenceContext(persistenceContext: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, persistenceContext)
    TransferContext.callMethod(MethodBindings.freePersistenceContextPtr)
  }

  /**
   * Creates a new anchor that will be tracked by the XR runtime. The [transform] should be a
   * transform in the local space of your [XROrigin3D] node. If [spatialContext] is not specified the
   * default will be used, this requires
   * [ProjectSettings.xr/openxr/extensions/spatialEntity/enableBuiltinAnchorDetection] to be set. The
   * returned tracker will track the location in case our reference space changes.
   *
   * [next] must be a valid next object for the `XrSpatialAnchorCreateInfoEXT` chain.
   */
  @JvmOverloads
  public final fun createNewAnchor(
    transform: Transform3D,
    spatialContext: RID = RID(),
    next: OpenXRStructureBase? = null,
  ): OpenXRAnchorTracker? {
    TransferContext.writeMethodArguments_TRANSFORM3D_RID_OBJECT(ptr, objectID.id, transform, spatialContext, next)
    TransferContext.callMethod(MethodBindings.createNewAnchorPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRAnchorTracker?)
  }

  /**
   * Remove an anchor previously created with [createNewAnchor]. If this anchor was persistent you
   * must first call [unpersistAnchor] and await its callback.
   */
  public final fun removeAnchor(anchorTracker: OpenXRAnchorTracker?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, anchorTracker)
    TransferContext.callMethod(MethodBindings.removeAnchorPtr)
  }

  /**
   * Changes this anchor into a persistent anchor. This means its location will be stored on the
   * device and the anchor will be restored the next time your application starts. If
   * [persistenceContext] is not specified the default will be used, this requires
   * [ProjectSettings.xr/openxr/extensions/spatialEntity/enableBuiltinAnchorDetection] to be set.
   *
   * **Note:** This is an asynchronous method and returns an [OpenXRFutureResult] object with which
   * to track the status, discarding this object will not cancel the creation process. On success
   * [userCallback] will be called if specified. The result value for this function is a boolean which
   * will be set to `true` on successful completion.
   */
  @JvmOverloads
  public final fun persistAnchor(
    anchorTracker: OpenXRAnchorTracker?,
    persistenceContext: RID = RID(),
    userCallback: Callable = VariantCallable(),
  ): OpenXRFutureResult? {
    TransferContext.writeMethodArguments_OBJECT_RID_CALLABLE(ptr, objectID.id, anchorTracker, persistenceContext, userCallback)
    TransferContext.callMethod(MethodBindings.persistAnchorPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRFutureResult?)
  }

  /**
   * Removes the persistent data from this anchor. The runtime will not recreate the anchor when
   * your application restarts. If [persistenceContext] is not specified the default will be used, this
   * requires [ProjectSettings.xr/openxr/extensions/spatialEntity/enabled] to be set.
   *
   * **Note:** This is an asynchronous method and returns an [OpenXRFutureResult] object with which
   * to track the status, discarding this object will not cancel the creation process. On success
   * [userCallback] will be called if specified. The result value for this function is a boolean which
   * will be set to `true` on successful completion.
   */
  @JvmOverloads
  public final fun unpersistAnchor(
    anchorTracker: OpenXRAnchorTracker?,
    persistenceContext: RID = RID(),
    userCallback: Callable = VariantCallable(),
  ): OpenXRFutureResult? {
    TransferContext.writeMethodArguments_OBJECT_RID_CALLABLE(ptr, objectID.id, anchorTracker, persistenceContext, userCallback)
    TransferContext.callMethod(MethodBindings.unpersistAnchorPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRFutureResult?)
  }

  /**
   * Calls [OpenXRSpatialEntityExtension.discoverSpatialEntities] and
   * [OpenXRSpatialEntityExtension.querySnapshot] with the anchor entities associated with
   * [spatialContext].
   *
   * [componentData] are the [OpenXRSpatialComponentData]s to discover for this anchor capability.
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
    TransferContext.writeMethodArguments_RID_ARRAY_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, spatialContext, componentData, nextSnapshotCreate, nextSnapshotQuery, userCallback)
    TransferContext.callMethod(MethodBindings.startEntityDiscoveryPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRFutureResult?)
  }

  /**
   * Calls [OpenXRSpatialEntityExtension.updateSpatialEntities] and
   * [OpenXRSpatialEntityExtension.querySnapshot] with the anchor entities associated with
   * [spatialContext].
   *
   * [componentData] are the [OpenXRSpatialComponentData]s to update for this anchor capability.
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
    TransferContext.writeMethodArguments_RID_ARRAY_OBJECT_OBJECT(ptr, objectID.id, spatialContext, componentData, nextSnapshotCreate, nextSnapshotQuery)
    TransferContext.callMethod(MethodBindings.doEntityUpdatePtr)
  }

  public enum class PersistenceScope(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Provides the application with read-only access (i.e. application cannot modify this scope) to
     * spatial entities persisted and managed by the system. The application can use the UUID in the
     * persistence component for this scope to correlate entities across spatial contexts and device
     * reboots.
     */
    SYSTEM_MANAGED(1),
    /**
     * Persistence operations and data access is limited to spatial anchors, on the same device, for
     * the same user and same app (using [persistAnchor] and [unpersistAnchor] functions)
     */
    LOCAL_ANCHORS(1000781000),
    ;

    public companion object {
      public fun from(`value`: Long): PersistenceScope = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val isSpatialAnchorSupportedName:
        MethodStringName0<OpenXRSpatialAnchorCapability, Boolean> =
        MethodStringName0<OpenXRSpatialAnchorCapability, Boolean>("is_spatial_anchor_supported")

    @JvmField
    public val isSpatialPersistenceSupportedName:
        MethodStringName0<OpenXRSpatialAnchorCapability, Boolean> =
        MethodStringName0<OpenXRSpatialAnchorCapability, Boolean>("is_spatial_persistence_supported")

    @JvmField
    public val isPersistenceScopeSupportedName:
        MethodStringName1<OpenXRSpatialAnchorCapability, Boolean, PersistenceScope> =
        MethodStringName1<OpenXRSpatialAnchorCapability, Boolean, PersistenceScope>("is_persistence_scope_supported")

    @JvmField
    public val createDefaultPersistenceContextName:
        MethodStringName1<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, Callable> =
        MethodStringName1<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, Callable>("create_default_persistence_context")

    @JvmField
    public val createPersistenceContextName:
        MethodStringName2<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, PersistenceScope, Callable>
        =
        MethodStringName2<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, PersistenceScope, Callable>("create_persistence_context")

    @JvmField
    public val getPersistenceContextHandleName:
        MethodStringName1<OpenXRSpatialAnchorCapability, Long, RID> =
        MethodStringName1<OpenXRSpatialAnchorCapability, Long, RID>("get_persistence_context_handle")

    @JvmField
    public val freePersistenceContextName:
        MethodStringName1<OpenXRSpatialAnchorCapability, Unit, RID> =
        MethodStringName1<OpenXRSpatialAnchorCapability, Unit, RID>("free_persistence_context")

    @JvmField
    public val createNewAnchorName:
        MethodStringName3<OpenXRSpatialAnchorCapability, OpenXRAnchorTracker?, Transform3D, RID, OpenXRStructureBase?>
        =
        MethodStringName3<OpenXRSpatialAnchorCapability, OpenXRAnchorTracker?, Transform3D, RID, OpenXRStructureBase?>("create_new_anchor")

    @JvmField
    public val removeAnchorName:
        MethodStringName1<OpenXRSpatialAnchorCapability, Unit, OpenXRAnchorTracker?> =
        MethodStringName1<OpenXRSpatialAnchorCapability, Unit, OpenXRAnchorTracker?>("remove_anchor")

    @JvmField
    public val persistAnchorName:
        MethodStringName3<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, OpenXRAnchorTracker?, RID, Callable>
        =
        MethodStringName3<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, OpenXRAnchorTracker?, RID, Callable>("persist_anchor")

    @JvmField
    public val unpersistAnchorName:
        MethodStringName3<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, OpenXRAnchorTracker?, RID, Callable>
        =
        MethodStringName3<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, OpenXRAnchorTracker?, RID, Callable>("unpersist_anchor")

    @JvmField
    public val startEntityDiscoveryName:
        MethodStringName5<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?, Callable>
        =
        MethodStringName5<OpenXRSpatialAnchorCapability, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?, Callable>("start_entity_discovery")

    @JvmField
    public val doEntityUpdateName:
        MethodStringName4<OpenXRSpatialAnchorCapability, Unit, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?>
        =
        MethodStringName4<OpenXRSpatialAnchorCapability, Unit, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, OpenXRStructureBase?>("do_entity_update")
  }

  public object MethodBindings {
    internal val isSpatialAnchorSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "is_spatial_anchor_supported", 2240911060)

    internal val isSpatialPersistenceSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "is_spatial_persistence_supported", 2240911060)

    internal val isPersistenceScopeSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "is_persistence_scope_supported", 3651771626)

    internal val createDefaultPersistenceContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "create_default_persistence_context", 1401033661)

    internal val createPersistenceContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "create_persistence_context", 856276630)

    internal val getPersistenceContextHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "get_persistence_context_handle", 2198884583)

    internal val freePersistenceContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "free_persistence_context", 2722037293)

    internal val createNewAnchorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "create_new_anchor", 4088043487)

    internal val removeAnchorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "remove_anchor", 3579451518)

    internal val persistAnchorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "persist_anchor", 4244202513)

    internal val unpersistAnchorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "unpersist_anchor", 4244202513)

    internal val startEntityDiscoveryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "start_entity_discovery", 3452714169)

    internal val doEntityUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialAnchorCapability", "do_entity_update", 3138044275)
  }
}
