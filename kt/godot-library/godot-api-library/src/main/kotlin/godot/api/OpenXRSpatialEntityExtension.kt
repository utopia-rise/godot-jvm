// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF
import godot.callMethod_RID_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF
import godot.callMethod_RID_LONG_ret_STRING
import godot.callMethod_RID_PACKED_INT_64_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF
import godot.callPtrMethod_LONG_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_RID
import godot.callPtrMethod_RID
import godot.callPtrMethod_RID_ARRAY_OBJECT_ret_BOOL
import godot.callPtrMethod_RID_ARRAY_PACKED_INT_64_ARRAY_OBJECT_ret_RID
import godot.callPtrMethod_RID_LONG_LONG_ret_RID
import godot.callPtrMethod_RID_LONG_ret_PACKED_BYTE_ARRAY
import godot.callPtrMethod_RID_LONG_ret_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_RID_LONG_ret_PACKED_INT_32_ARRAY
import godot.callPtrMethod_RID_LONG_ret_PACKED_VECTOR2_ARRAY
import godot.callPtrMethod_RID_LONG_ret_PACKED_VECTOR3_ARRAY
import godot.callPtrMethod_RID_LONG_ret_RID
import godot.callPtrMethod_RID_ret_BOOL
import godot.callPtrMethod_RID_ret_LONG
import godot.callPtrMethod_RID_ret_RID
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.core.RID
import godot.core.Signal1
import godot.core.VariantArray
import godot.core.VariantCallable
import godot.core.Vector2
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * OpenXR extension that handles spatial entities and, when enabled, allows querying those spatial
 * entities. This extension will also automatically manage [XRTracker] objects for static entities.
 */
@GodotBaseType
public open class OpenXRSpatialEntityExtension : OpenXRExtensionWrapper() {
  /**
   * Emitted when OpenXR recommends running a discovery query because entities managed by this
   * spatial context have (likely) changed.
   */
  public val spatialDiscoveryRecommended: Signal1<RID> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(489, scriptPtr)
  }

  /**
   * Returns `true` if this spatial entity [capability] is supported by the hardware used.
   */
  public final fun supportsCapability(capability: Capability): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.supportsCapabilityPtr, capability.value)

  /**
   * Returns `true` if this [capability] supports the [componentType].
   */
  public final fun supportsComponentType(capability: Capability, componentType: ComponentType):
      Boolean =
      TransferContext.callPtrMethod_LONG_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.supportsComponentTypePtr, capability.value, componentType.value)

  /**
   * Creates a new spatial context that handles entities for the provided capability configurations.
   * [capabilityConfigurations] is an array of [OpenXRSpatialCapabilityConfigurationBaseHeader] with
   * the needed capability configuration data.
   *
   * [next] is an optional parameter that can contain additional information for creating our
   * spatial context.
   *
   * **Note:** This is an asynchronous method and returns an [OpenXRFutureResult] object with which
   * to track the status, discarding this object will not cancel the creation process. On success
   * [userCallback] will be called if specified. The result data for this function is the [RID] for our
   * spatial context.
   */
  @JvmOverloads
  public final fun createSpatialContext(
    capabilityConfigurations: VariantArray<OpenXRSpatialCapabilityConfigurationBaseHeader>,
    next: OpenXRStructureBase? = null,
    userCallback: Callable = VariantCallable(),
  ): OpenXRFutureResult? =
      (TransferContext.callMethod_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.createSpatialContextPtr, capabilityConfigurations, next, userCallback) as OpenXRFutureResult?)

  /**
   * Returns `true` if the spatial context finished its creation and is ready to be used.
   */
  public final fun getSpatialContextReady(spatialContext: RID): Boolean =
      TransferContext.callPtrMethod_RID_ret_BOOL(ptr, objectID.id, MethodBindings.getSpatialContextReadyPtr, spatialContext)

  /**
   * Frees a spatial context previously created when calling [createSpatialContext]. If the spatial
   * context creation is still ongoing, the asynchronous process is cancelled.
   */
  public final fun freeSpatialContext(spatialContext: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.freeSpatialContextPtr, spatialContext)
  }

  /**
   * Returns the OpenXR spatial context handle for this snapshot.
   *
   * **Note:** This method is intended to be used from GDExtensions that implement spatial entity
   * capability handlers.
   */
  public final fun getSpatialContextHandle(spatialContext: RID): Long =
      TransferContext.callPtrMethod_RID_ret_LONG(ptr, objectID.id, MethodBindings.getSpatialContextHandlePtr, spatialContext)

  /**
   * Convenience method when the caller only has an [VariantArray] of [OpenXRSpatialComponentData]
   * and needs to discover spatial entities.
   */
  @JvmOverloads
  public final fun discoverSpatialEntitiesWithComponentData(
    spatialContext: RID,
    componentData: VariantArray<OpenXRSpatialComponentData>,
    next: OpenXRStructureBase? = null,
    userCallback: Callable = VariantCallable(),
  ): OpenXRFutureResult? =
      (TransferContext.callMethod_RID_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.discoverSpatialEntitiesWithComponentDataPtr, spatialContext, componentData, next, userCallback) as OpenXRFutureResult?)

  /**
   * Starts a new discovery query, this will gather all objects tracked by the [spatialContext] that
   * have at least one of the component types specified in [componentTypes].
   *
   * [next] is an optional parameter that can contain additional information for executing the
   * discovery query.
   *
   * **Note:** This is an asynchronous method and returns an [OpenXRFutureResult] object with which
   * to track the status, discarding this object will not cancel the discovery process. On success
   * [userCallback] will be called if specified. The result data for this function is the [RID] for our
   * snapshot.
   */
  @JvmOverloads
  public final fun discoverSpatialEntities(
    spatialContext: RID,
    componentTypes: PackedInt64Array,
    next: OpenXRStructureBase? = null,
    userCallback: Callable = VariantCallable(),
  ): OpenXRFutureResult? =
      (TransferContext.callMethod_RID_PACKED_INT_64_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.discoverSpatialEntitiesPtr, spatialContext, componentTypes, next, userCallback) as OpenXRFutureResult?)

  /**
   * Performs a snapshot for a limited number of entities. This is NOT an asynchronous method and
   * will return the snapshot immediately.
   */
  @JvmOverloads
  public final fun updateSpatialEntities(
    spatialContext: RID,
    entities: VariantArray<RID>,
    componentTypes: PackedInt64Array,
    next: OpenXRStructureBase? = null,
  ): RID =
      TransferContext.callPtrMethod_RID_ARRAY_PACKED_INT_64_ARRAY_OBJECT_ret_RID(ptr, objectID.id, MethodBindings.updateSpatialEntitiesPtr, spatialContext, entities, componentTypes, next)

  /**
   * Frees a spatial snapshot previously created when calling [discoverSpatialEntities]. If the
   * spatial snapshot creation is still ongoing, the asynchronous process is cancelled.
   */
  public final fun freeSpatialSnapshot(spatialSnapshot: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.freeSpatialSnapshotPtr, spatialSnapshot)
  }

  /**
   * Returns the OpenXR spatial snapshot handle for this snapshot.
   *
   * **Note:** This method is intended to be used from GDExtensions that implement spatial entity
   * capability handlers.
   */
  public final fun getSpatialSnapshotHandle(spatialSnapshot: RID): Long =
      TransferContext.callPtrMethod_RID_ret_LONG(ptr, objectID.id, MethodBindings.getSpatialSnapshotHandlePtr, spatialSnapshot)

  /**
   * Returns the spatial context related to this spatial snapshot.
   */
  public final fun getSpatialSnapshotContext(spatialSnapshot: RID): RID =
      TransferContext.callPtrMethod_RID_ret_RID(ptr, objectID.id, MethodBindings.getSpatialSnapshotContextPtr, spatialSnapshot)

  /**
   * Queries the snapshot data. This will find all entities in the snapshot that contain all
   * requested components in [componentData]. The objects held within [componentData] will then be
   * populated with the queried data. [componentData] must always have an object of
   * [OpenXRSpatialQueryResultData] as the first entry.
   *
   * [next] is an optional parameter that can contain additional information passed when setting our
   * query conditions.
   */
  @JvmOverloads
  public final fun querySnapshot(
    spatialSnapshot: RID,
    componentData: VariantArray<OpenXRSpatialComponentData>,
    next: OpenXRStructureBase? = null,
  ): Boolean =
      TransferContext.callPtrMethod_RID_ARRAY_OBJECT_ret_BOOL(ptr, objectID.id, MethodBindings.querySnapshotPtr, spatialSnapshot, componentData, next)

  /**
   * Returns a string from a buffer that was retrieved when taking a snapshot.
   */
  public final fun getString(spatialSnapshot: RID, bufferId: Long): String =
      TransferContext.callMethod_RID_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getStringPtr, spatialSnapshot, bufferId)

  /**
   * Returns a buffer with 8 bit ints from a buffer that was retrieved when taking a snapshot.
   */
  public final fun getUint8Buffer(spatialSnapshot: RID, bufferId: Long): PackedByteArray =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.getUint8BufferPtr, spatialSnapshot, bufferId)

  /**
   * Returns a buffer with 16 bit ints from a buffer that was retrieved when taking a snapshot.
   */
  public final fun getUint16Buffer(spatialSnapshot: RID, bufferId: Long): PackedInt32Array =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.getUint16BufferPtr, spatialSnapshot, bufferId)

  /**
   * Returns a buffer with 32 bit ints from a buffer that was retrieved when taking a snapshot.
   */
  public final fun getUint32Buffer(spatialSnapshot: RID, bufferId: Long): PackedInt32Array =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.getUint32BufferPtr, spatialSnapshot, bufferId)

  /**
   * Returns a buffer with floats from a buffer that was retrieved when taking a snapshot.
   */
  public final fun getFloatBuffer(spatialSnapshot: RID, bufferId: Long): PackedFloat32Array =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.getFloatBufferPtr, spatialSnapshot, bufferId)

  /**
   * Returns a buffer with [Vector2] entries from a buffer that was retrieved when taking a
   * snapshot.
   */
  public final fun getVector2Buffer(spatialSnapshot: RID, bufferId: Long): PackedVector2Array =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_VECTOR2_ARRAY(ptr, objectID.id, MethodBindings.getVector2BufferPtr, spatialSnapshot, bufferId)

  /**
   * Returns a buffer with [Vector3] entries from a buffer that was retrieved when taking a
   * snapshot.
   */
  public final fun getVector3Buffer(spatialSnapshot: RID, bufferId: Long): PackedVector3Array =
      TransferContext.callPtrMethod_RID_LONG_ret_PACKED_VECTOR3_ARRAY(ptr, objectID.id, MethodBindings.getVector3BufferPtr, spatialSnapshot, bufferId)

  /**
   * Returns the [RID] for the specified spatial entity ID.
   */
  public final fun findSpatialEntity(entityId: Long): RID =
      TransferContext.callPtrMethod_LONG_ret_RID(ptr, objectID.id, MethodBindings.findSpatialEntityPtr, entityId)

  /**
   * Registers an entity that was created directly on the OpenXR runtime.
   */
  public final fun addSpatialEntity(
    spatialContext: RID,
    entityId: Long,
    entity: Long,
  ): RID =
      TransferContext.callPtrMethod_RID_LONG_LONG_ret_RID(ptr, objectID.id, MethodBindings.addSpatialEntityPtr, spatialContext, entityId, entity)

  /**
   * Creates a new entity for this [entityId]. The [spatialContext] should match the context that
   * discovered the entity.
   */
  public final fun makeSpatialEntity(spatialContext: RID, entityId: Long): RID =
      TransferContext.callPtrMethod_RID_LONG_ret_RID(ptr, objectID.id, MethodBindings.makeSpatialEntityPtr, spatialContext, entityId)

  /**
   * Returns the internal `XrSpatialEntityIdEXT` associated with the entity.
   */
  public final fun getSpatialEntityId(entity: RID): Long =
      TransferContext.callPtrMethod_RID_ret_LONG(ptr, objectID.id, MethodBindings.getSpatialEntityIdPtr, entity)

  /**
   * Returns the spatial context for this entity.
   */
  public final fun getSpatialEntityContext(entity: RID): RID =
      TransferContext.callPtrMethod_RID_ret_RID(ptr, objectID.id, MethodBindings.getSpatialEntityContextPtr, entity)

  /**
   * Frees an entity previously created when calling [addSpatialEntity] or [makeSpatialEntity].
   */
  public final fun freeSpatialEntity(entity: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.freeSpatialEntityPtr, entity)
  }

  public enum class Capability(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Plane tracking capability.
     */
    PLANE_TRACKING(1000741000),
    /**
     * QR code based marker tracking capability.
     */
    MARKER_TRACKING_QR_CODE(1000743000),
    /**
     * Micro QR code based marker tracking capability.
     */
    MARKER_TRACKING_MICRO_QR_CODE(1000743001),
    /**
     * Aruco marker based marker tracking capability.
     */
    MARKER_TRACKING_ARUCO_MARKER(1000743002),
    /**
     * April tag based marker tracking capability.
     */
    MARKER_TRACKING_APRIL_TAG(1000743003),
    /**
     * Anchor capability.
     */
    ANCHOR(1000762000),
    ;

    public companion object {
      public fun from(`value`: Long): Capability = entries.single { it.`value` == `value` }
    }
  }

  public enum class ComponentType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Component that provides the 2D bounds for a spatial entity. The corresponding list structure
     * is `XrSpatialComponentBounded2DListEXT`; the corresponding data structure is
     * `XrSpatialBounded2DDataEXT`.
     */
    BOUNDED_2D(1),
    /**
     * Component that provides the 3D bounds for a spatial entity. The corresponding list structure
     * is `XrSpatialComponentBounded3DListEXT`; the corresponding data structure is `XrBoxf`.
     */
    BOUNDED_3D(2),
    /**
     * Component that provides the XrSpatialEntityIdEXT of the parent for a spatial entity. The
     * corresponding list structure is `XrSpatialComponentParentListEXT`; the corresponding data
     * structure is `XrSpatialEntityIdEXT`.
     */
    PARENT(3),
    /**
     * Component that provides a 3D mesh for a spatial entity. The corresponding list structure is
     * `XrSpatialComponentMesh3DListEXT`; the corresponding data structure is `XrSpatialMeshDataEXT`.
     */
    MESH_3D(4),
    /**
     * Component that provides the plane alignment enum for a spatial entity. The corresponding list
     * structure is `XrSpatialComponentPlaneAlignmentListEXT`; the corresponding data structure is
     * `XrSpatialPlaneAlignmentEXT` (Added by the `XR_EXT_spatial_plane_tracking` extension).
     */
    PLANE_ALIGNMENT(1000741000),
    /**
     * Component that provides a 2D mesh for a spatial entity. The corresponding list structure is
     * `XrSpatialComponentMesh2DListEXT`; the corresponding data structure is `XrSpatialMeshDataEXT`
     * (Added by the `XR_EXT_spatial_plane_tracking` extension).
     */
    MESH_2D(1000741001),
    /**
     * Component that provides a 2D boundary polygon for a spatial entity. The corresponding list
     * structure is `XrSpatialComponentPolygon2DListEXT`; the corresponding data structure is
     * `XrSpatialPolygon2DDataEXT` (Added by the `XR_EXT_spatial_plane_tracking` extension).
     */
    POLYGON_2D(1000741002),
    /**
     * Component that provides a semantic label for a plane. The corresponding list structure is
     * `XrSpatialComponentPlaneSemanticLabelListEXT`; the corresponding data structure is
     * `XrSpatialPlaneSemanticLabelEXT` (Added by the `XR_EXT_spatial_plane_tracking` extension).
     */
    PLANE_SEMANTIC_LABEL(1000741003),
    /**
     * A component describing the marker type, ID and location. The corresponding list structure is
     * `XrSpatialComponentMarkerListEXT`; the corresponding data structure is `XrSpatialMarkerDataEXT`
     * (Added by the `XR_EXT_spatial_marker_tracking` extension).
     */
    MARKER(1000743000),
    /**
     * Component that provides the location for an anchor. The corresponding list structure is
     * `XrSpatialComponentAnchorListEXT`; the corresponding data structure is `XrPosef` (Added by the
     * `XR_EXT_spatial_anchor` extension).
     */
    ANCHOR(1000762000),
    /**
     * Component that provides the persisted UUID for a spatial entity. The corresponding list
     * structure is [code]XrSpatialComponentPersistenceListEXT; the corresponding data structure is
     * `XrSpatialPersistenceDataEXT` (Added by the `XR_EXT_spatial_persistence` extension).
     */
    PERSISTENCE(1000763000),
    ;

    public companion object {
      public fun from(`value`: Long): ComponentType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val supportsCapabilityName:
        MethodStringName1<OpenXRSpatialEntityExtension, Boolean, Capability> =
        MethodStringName1<OpenXRSpatialEntityExtension, Boolean, Capability>("supports_capability")

    @JvmField
    public val supportsComponentTypeName:
        MethodStringName2<OpenXRSpatialEntityExtension, Boolean, Capability, ComponentType> =
        MethodStringName2<OpenXRSpatialEntityExtension, Boolean, Capability, ComponentType>("supports_component_type")

    @JvmField
    public val createSpatialContextName:
        MethodStringName3<OpenXRSpatialEntityExtension, OpenXRFutureResult?, VariantArray<OpenXRSpatialCapabilityConfigurationBaseHeader>, OpenXRStructureBase?, Callable>
        =
        MethodStringName3<OpenXRSpatialEntityExtension, OpenXRFutureResult?, VariantArray<OpenXRSpatialCapabilityConfigurationBaseHeader>, OpenXRStructureBase?, Callable>("create_spatial_context")

    @JvmField
    public val getSpatialContextReadyName:
        MethodStringName1<OpenXRSpatialEntityExtension, Boolean, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Boolean, RID>("get_spatial_context_ready")

    @JvmField
    public val freeSpatialContextName: MethodStringName1<OpenXRSpatialEntityExtension, Unit, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Unit, RID>("free_spatial_context")

    @JvmField
    public val getSpatialContextHandleName:
        MethodStringName1<OpenXRSpatialEntityExtension, Long, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Long, RID>("get_spatial_context_handle")

    @JvmField
    public val discoverSpatialEntitiesWithComponentDataName:
        MethodStringName4<OpenXRSpatialEntityExtension, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, Callable>
        =
        MethodStringName4<OpenXRSpatialEntityExtension, OpenXRFutureResult?, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?, Callable>("discover_spatial_entities_with_component_data")

    @JvmField
    public val discoverSpatialEntitiesName:
        MethodStringName4<OpenXRSpatialEntityExtension, OpenXRFutureResult?, RID, PackedInt64Array, OpenXRStructureBase?, Callable>
        =
        MethodStringName4<OpenXRSpatialEntityExtension, OpenXRFutureResult?, RID, PackedInt64Array, OpenXRStructureBase?, Callable>("discover_spatial_entities")

    @JvmField
    public val updateSpatialEntitiesName:
        MethodStringName4<OpenXRSpatialEntityExtension, RID, RID, VariantArray<RID>, PackedInt64Array, OpenXRStructureBase?>
        =
        MethodStringName4<OpenXRSpatialEntityExtension, RID, RID, VariantArray<RID>, PackedInt64Array, OpenXRStructureBase?>("update_spatial_entities")

    @JvmField
    public val freeSpatialSnapshotName: MethodStringName1<OpenXRSpatialEntityExtension, Unit, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Unit, RID>("free_spatial_snapshot")

    @JvmField
    public val getSpatialSnapshotHandleName:
        MethodStringName1<OpenXRSpatialEntityExtension, Long, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Long, RID>("get_spatial_snapshot_handle")

    @JvmField
    public val getSpatialSnapshotContextName:
        MethodStringName1<OpenXRSpatialEntityExtension, RID, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, RID, RID>("get_spatial_snapshot_context")

    @JvmField
    public val querySnapshotName:
        MethodStringName3<OpenXRSpatialEntityExtension, Boolean, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?>
        =
        MethodStringName3<OpenXRSpatialEntityExtension, Boolean, RID, VariantArray<OpenXRSpatialComponentData>, OpenXRStructureBase?>("query_snapshot")

    @JvmField
    public val getStringName: MethodStringName2<OpenXRSpatialEntityExtension, String, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, String, RID, Long>("get_string")

    @JvmField
    public val getUint8BufferName:
        MethodStringName2<OpenXRSpatialEntityExtension, PackedByteArray, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, PackedByteArray, RID, Long>("get_uint8_buffer")

    @JvmField
    public val getUint16BufferName:
        MethodStringName2<OpenXRSpatialEntityExtension, PackedInt32Array, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, PackedInt32Array, RID, Long>("get_uint16_buffer")

    @JvmField
    public val getUint32BufferName:
        MethodStringName2<OpenXRSpatialEntityExtension, PackedInt32Array, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, PackedInt32Array, RID, Long>("get_uint32_buffer")

    @JvmField
    public val getFloatBufferName:
        MethodStringName2<OpenXRSpatialEntityExtension, PackedFloat32Array, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, PackedFloat32Array, RID, Long>("get_float_buffer")

    @JvmField
    public val getVector2BufferName:
        MethodStringName2<OpenXRSpatialEntityExtension, PackedVector2Array, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, PackedVector2Array, RID, Long>("get_vector2_buffer")

    @JvmField
    public val getVector3BufferName:
        MethodStringName2<OpenXRSpatialEntityExtension, PackedVector3Array, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, PackedVector3Array, RID, Long>("get_vector3_buffer")

    @JvmField
    public val findSpatialEntityName: MethodStringName1<OpenXRSpatialEntityExtension, RID, Long> =
        MethodStringName1<OpenXRSpatialEntityExtension, RID, Long>("find_spatial_entity")

    @JvmField
    public val addSpatialEntityName:
        MethodStringName3<OpenXRSpatialEntityExtension, RID, RID, Long, Long> =
        MethodStringName3<OpenXRSpatialEntityExtension, RID, RID, Long, Long>("add_spatial_entity")

    @JvmField
    public val makeSpatialEntityName:
        MethodStringName2<OpenXRSpatialEntityExtension, RID, RID, Long> =
        MethodStringName2<OpenXRSpatialEntityExtension, RID, RID, Long>("make_spatial_entity")

    @JvmField
    public val getSpatialEntityIdName: MethodStringName1<OpenXRSpatialEntityExtension, Long, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Long, RID>("get_spatial_entity_id")

    @JvmField
    public val getSpatialEntityContextName:
        MethodStringName1<OpenXRSpatialEntityExtension, RID, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, RID, RID>("get_spatial_entity_context")

    @JvmField
    public val freeSpatialEntityName: MethodStringName1<OpenXRSpatialEntityExtension, Unit, RID> =
        MethodStringName1<OpenXRSpatialEntityExtension, Unit, RID>("free_spatial_entity")
  }

  public object MethodBindings {
    internal val supportsCapabilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "supports_capability", 1940837202)

    internal val supportsComponentTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "supports_component_type", 26842779)

    internal val createSpatialContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "create_spatial_context", 1874506473)

    internal val getSpatialContextReadyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_spatial_context_ready", 4155700596)

    internal val freeSpatialContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "free_spatial_context", 2722037293)

    internal val getSpatialContextHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_spatial_context_handle", 2198884583)

    internal val discoverSpatialEntitiesWithComponentDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "discover_spatial_entities_with_component_data", 1830928590)

    internal val discoverSpatialEntitiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "discover_spatial_entities", 2252833536)

    internal val updateSpatialEntitiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "update_spatial_entities", 3446086438)

    internal val freeSpatialSnapshotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "free_spatial_snapshot", 2722037293)

    internal val getSpatialSnapshotHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_spatial_snapshot_handle", 2198884583)

    internal val getSpatialSnapshotContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_spatial_snapshot_context", 3814569979)

    internal val querySnapshotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "query_snapshot", 641015484)

    internal val getStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_string", 1464764419)

    internal val getUint8BufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_uint8_buffer", 3570600051)

    internal val getUint16BufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_uint16_buffer", 3393655756)

    internal val getUint32BufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_uint32_buffer", 3393655756)

    internal val getFloatBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_float_buffer", 2313216651)

    internal val getVector2BufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_vector2_buffer", 110850971)

    internal val getVector3BufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_vector3_buffer", 1166453791)

    internal val findSpatialEntityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "find_spatial_entity", 937000113)

    internal val addSpatialEntityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "add_spatial_entity", 2256026069)

    internal val makeSpatialEntityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "make_spatial_entity", 2233757277)

    internal val getSpatialEntityIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_spatial_entity_id", 2198884583)

    internal val getSpatialEntityContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "get_spatial_entity_context", 3814569979)

    internal val freeSpatialEntityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialEntityExtension", "free_spatial_entity", 2722037293)
  }
}
