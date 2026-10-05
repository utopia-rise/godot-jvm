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
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_AABB
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_PACKED_VECTOR3_ARRAY
import godot.callPtrMethod0_ret_STRING_NAME
import godot.callPtrMethod0_ret_VECTOR3
import godot.callPtrMethod_AABB
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_PACKED_INT_32_ARRAY
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_PACKED_INT_32_ARRAY
import godot.callPtrMethod_PACKED_VECTOR3_ARRAY
import godot.callPtrMethod_STRING_NAME
import godot.callPtrMethod_VECTOR3
import godot.common.interop.VoidPtr
import godot.core.AABB
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedInt32Array
import godot.core.PackedVector3Array
import godot.core.StringName
import godot.core.Vector3
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A navigation mesh is a collection of polygons that define which areas of an environment are
 * traversable to aid agents in pathfinding through complicated spaces.
 */
@GodotBaseType
public open class NavigationMesh : Resource() {
  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var vertices: PackedVector3Array
    @JvmName("verticesProperty")
    get() = getVertices()
    @JvmName("verticesProperty")
    set(`value`) {
      setVertices(value)
    }

  /**
   * Partitioning algorithm for creating the navigation mesh polys.
   */
  public final inline var samplePartitionType: SamplePartitionType
    @JvmName("samplePartitionTypeProperty")
    get() = getSamplePartitionType()
    @JvmName("samplePartitionTypeProperty")
    set(`value`) {
      setSamplePartitionType(value)
    }

  /**
   * Determines which type of nodes will be parsed as geometry.
   */
  public final inline var geometryParsedGeometryType: ParsedGeometryType
    @JvmName("geometryParsedGeometryTypeProperty")
    get() = getParsedGeometryType()
    @JvmName("geometryParsedGeometryTypeProperty")
    set(`value`) {
      setParsedGeometryType(value)
    }

  /**
   * The physics layers to scan for static colliders.
   *
   * Only used when [geometryParsedGeometryType] is [PARSED_GEOMETRY_STATIC_COLLIDERS] or
   * [PARSED_GEOMETRY_BOTH].
   */
  public final inline var geometryCollisionMask: Long
    @JvmName("geometryCollisionMaskProperty")
    get() = getCollisionMask()
    @JvmName("geometryCollisionMaskProperty")
    set(`value`) {
      setCollisionMask(value)
    }

  /**
   * The source of the geometry used when baking.
   */
  public final inline var geometrySourceGeometryMode: SourceGeometryMode
    @JvmName("geometrySourceGeometryModeProperty")
    get() = getSourceGeometryMode()
    @JvmName("geometrySourceGeometryModeProperty")
    set(`value`) {
      setSourceGeometryMode(value)
    }

  /**
   * The name of the group to scan for geometry.
   *
   * Only used when [geometrySourceGeometryMode] is [SOURCE_GEOMETRY_GROUPS_WITH_CHILDREN] or
   * [SOURCE_GEOMETRY_GROUPS_EXPLICIT].
   */
  public final inline var geometrySourceGroupName: StringName
    @JvmName("geometrySourceGroupNameProperty")
    get() = getSourceGroupName()
    @JvmName("geometrySourceGroupNameProperty")
    set(`value`) {
      setSourceGroupName(value)
    }

  /**
   * The cell size used to rasterize the navigation mesh vertices on the XZ plane. Must match with
   * the cell size on the navigation map.
   */
  public final inline var cellSize: Float
    @JvmName("cellSizeProperty")
    get() = getCellSize()
    @JvmName("cellSizeProperty")
    set(`value`) {
      setCellSize(value)
    }

  /**
   * The cell height used to rasterize the navigation mesh vertices on the Y axis. Must match with
   * the cell height on the navigation map.
   */
  public final inline var cellHeight: Float
    @JvmName("cellHeightProperty")
    get() = getCellHeight()
    @JvmName("cellHeightProperty")
    set(`value`) {
      setCellHeight(value)
    }

  /**
   * The size of the non-navigable border around the bake bounding area.
   *
   * In conjunction with the [filterBakingAabb] and a [edgeMaxError] value at `1.0` or below the
   * border size can be used to bake tile aligned navigation meshes without the tile edges being shrunk
   * by [agentRadius].
   *
   * **Note:** If this value is not `0.0`, it will be rounded up to the nearest multiple of
   * [cellSize] during baking.
   */
  public final inline var borderSize: Float
    @JvmName("borderSizeProperty")
    get() = getBorderSize()
    @JvmName("borderSizeProperty")
    set(`value`) {
      setBorderSize(value)
    }

  /**
   * The minimum floor to ceiling height that will still allow the floor area to be considered
   * walkable.
   *
   * **Note:** While baking, this value will be rounded up to the nearest multiple of [cellHeight].
   */
  public final inline var agentHeight: Float
    @JvmName("agentHeightProperty")
    get() = getAgentHeight()
    @JvmName("agentHeightProperty")
    set(`value`) {
      setAgentHeight(value)
    }

  /**
   * The distance to erode/shrink the walkable area of the heightfield away from obstructions.
   *
   * **Note:** While baking, this value will be rounded up to the nearest multiple of [cellSize].
   *
   * **Note:** The radius must be equal or higher than `0.0`. If the radius is `0.0`, it won't be
   * possible to fix invalid outline overlaps and other precision errors during the baking process. As
   * a result, some obstacles may be excluded incorrectly from the final navigation mesh, or may delete
   * the navigation mesh's polygons.
   */
  public final inline var agentRadius: Float
    @JvmName("agentRadiusProperty")
    get() = getAgentRadius()
    @JvmName("agentRadiusProperty")
    set(`value`) {
      setAgentRadius(value)
    }

  /**
   * The minimum ledge height that is considered to still be traversable.
   *
   * **Note:** While baking, this value will be rounded down to the nearest multiple of
   * [cellHeight].
   */
  public final inline var agentMaxClimb: Float
    @JvmName("agentMaxClimbProperty")
    get() = getAgentMaxClimb()
    @JvmName("agentMaxClimbProperty")
    set(`value`) {
      setAgentMaxClimb(value)
    }

  /**
   * The maximum slope that is considered walkable, in degrees.
   */
  public final inline var agentMaxSlope: Float
    @JvmName("agentMaxSlopeProperty")
    get() = getAgentMaxSlope()
    @JvmName("agentMaxSlopeProperty")
    set(`value`) {
      setAgentMaxSlope(value)
    }

  /**
   * The minimum size of a region for it to be created.
   *
   * **Note:** This value will be squared to calculate the minimum number of cells allowed to form
   * isolated island areas. For example, a value of 8 will set the number of cells to 64.
   */
  public final inline var regionMinSize: Float
    @JvmName("regionMinSizeProperty")
    get() = getRegionMinSize()
    @JvmName("regionMinSizeProperty")
    set(`value`) {
      setRegionMinSize(value)
    }

  /**
   * Any regions with a size smaller than this will be merged with larger regions if possible.
   *
   * **Note:** This value will be squared to calculate the number of cells. For example, a value of
   * 20 will set the number of cells to 400.
   */
  public final inline var regionMergeSize: Float
    @JvmName("regionMergeSizeProperty")
    get() = getRegionMergeSize()
    @JvmName("regionMergeSizeProperty")
    set(`value`) {
      setRegionMergeSize(value)
    }

  /**
   * The maximum allowed length for contour edges along the border of the mesh. A value of `0.0`
   * disables this feature.
   *
   * **Note:** While baking, this value will be rounded up to the nearest multiple of [cellSize].
   */
  public final inline var edgeMaxLength: Float
    @JvmName("edgeMaxLengthProperty")
    get() = getEdgeMaxLength()
    @JvmName("edgeMaxLengthProperty")
    set(`value`) {
      setEdgeMaxLength(value)
    }

  /**
   * The maximum distance a simplified contour's border edges should deviate the original raw
   * contour.
   */
  public final inline var edgeMaxError: Float
    @JvmName("edgeMaxErrorProperty")
    get() = getEdgeMaxError()
    @JvmName("edgeMaxErrorProperty")
    set(`value`) {
      setEdgeMaxError(value)
    }

  /**
   * The maximum number of vertices allowed for polygons generated during the contour to polygon
   * conversion process.
   */
  public final inline var verticesPerPolygon: Float
    @JvmName("verticesPerPolygonProperty")
    get() = getVerticesPerPolygon()
    @JvmName("verticesPerPolygonProperty")
    set(`value`) {
      setVerticesPerPolygon(value)
    }

  /**
   * The sampling distance to use when generating the detail mesh, in cell unit.
   */
  public final inline var detailSampleDistance: Float
    @JvmName("detailSampleDistanceProperty")
    get() = getDetailSampleDistance()
    @JvmName("detailSampleDistanceProperty")
    set(`value`) {
      setDetailSampleDistance(value)
    }

  /**
   * The maximum distance the detail mesh surface should deviate from heightfield, in cell unit.
   */
  public final inline var detailSampleMaxError: Float
    @JvmName("detailSampleMaxErrorProperty")
    get() = getDetailSampleMaxError()
    @JvmName("detailSampleMaxErrorProperty")
    set(`value`) {
      setDetailSampleMaxError(value)
    }

  /**
   * If `true`, marks non-walkable spans as walkable if their maximum is within [agentMaxClimb] of a
   * walkable neighbor.
   */
  public final inline var filterLowHangingObstacles: Boolean
    @JvmName("filterLowHangingObstaclesProperty")
    get() = getFilterLowHangingObstacles()
    @JvmName("filterLowHangingObstaclesProperty")
    set(`value`) {
      setFilterLowHangingObstacles(value)
    }

  /**
   * If `true`, marks spans that are ledges as non-walkable.
   */
  public final inline var filterLedgeSpans: Boolean
    @JvmName("filterLedgeSpansProperty")
    get() = getFilterLedgeSpans()
    @JvmName("filterLedgeSpansProperty")
    set(`value`) {
      setFilterLedgeSpans(value)
    }

  /**
   * If `true`, marks walkable spans as not walkable if the clearance above the span is less than
   * [agentHeight].
   */
  public final inline var filterWalkableLowHeightSpans: Boolean
    @JvmName("filterWalkableLowHeightSpansProperty")
    get() = getFilterWalkableLowHeightSpans()
    @JvmName("filterWalkableLowHeightSpansProperty")
    set(`value`) {
      setFilterWalkableLowHeightSpans(value)
    }

  /**
   * If the baking [AABB] has a volume the navigation mesh baking will be restricted to its
   * enclosing area.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var filterBakingAabb: AABB
    @JvmName("filterBakingAabbProperty")
    get() = getFilterBakingAabb()
    @JvmName("filterBakingAabbProperty")
    set(`value`) {
      setFilterBakingAabb(value)
    }

  /**
   * The position offset applied to the [filterBakingAabb] [AABB].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var filterBakingAabbOffset: Vector3
    @JvmName("filterBakingAabbOffsetProperty")
    get() = getFilterBakingAabbOffset()
    @JvmName("filterBakingAabbOffsetProperty")
    set(`value`) {
      setFilterBakingAabbOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(401, scriptPtr)
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationmesh.vertices
   * //Your changes
   * navigationmesh.vertices = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun verticesMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      vertices.apply {
     block(this)
     vertices = this
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun verticesMutateEach(block: (index: Int, `value`: Vector3) -> Unit):
      PackedVector3Array = vertices.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     vertices = this
  }

  /**
   * This is a helper function for [filterBakingAabb] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationmesh.filterBakingAabb
   * //Your changes
   * navigationmesh.filterBakingAabb = myCoreType
   * ``````
   *
   * If the baking [AABB] has a volume the navigation mesh baking will be restricted to its
   * enclosing area.
   */
  @CoreTypeHelper
  public final fun filterBakingAabbMutate(block: AABB.() -> Unit): AABB = filterBakingAabb.apply {
     block(this)
     filterBakingAabb = this
  }

  /**
   * This is a helper function for [filterBakingAabbOffset] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationmesh.filterBakingAabbOffset
   * //Your changes
   * navigationmesh.filterBakingAabbOffset = myCoreType
   * ``````
   *
   * The position offset applied to the [filterBakingAabb] [AABB].
   */
  @CoreTypeHelper
  public final fun filterBakingAabbOffsetMutate(block: Vector3.() -> Unit): Vector3 =
      filterBakingAabbOffset.apply {
     block(this)
     filterBakingAabbOffset = this
  }

  public final fun setSamplePartitionType(samplePartitionType: SamplePartitionType): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSamplePartitionTypePtr, samplePartitionType.value)
  }

  public final fun getSamplePartitionType(): SamplePartitionType =
      SamplePartitionType.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSamplePartitionTypePtr))

  public final fun setParsedGeometryType(geometryType: ParsedGeometryType): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setParsedGeometryTypePtr, geometryType.value)
  }

  public final fun getParsedGeometryType(): ParsedGeometryType =
      ParsedGeometryType.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getParsedGeometryTypePtr))

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCollisionMaskPtr, mask)
  }

  public final fun getCollisionMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionMaskPtr)

  /**
   * Based on [value], enables or disables the specified layer in the [geometryCollisionMask], given
   * a [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setCollisionMaskValuePtr, layerNumber.toLong(), value)
  }

  /**
   * Returns whether or not the specified layer of the [geometryCollisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.getCollisionMaskValuePtr, layerNumber.toLong())

  public final fun setSourceGeometryMode(mask: SourceGeometryMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSourceGeometryModePtr, mask.value)
  }

  public final fun getSourceGeometryMode(): SourceGeometryMode =
      SourceGeometryMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSourceGeometryModePtr))

  public final fun setSourceGroupName(mask: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.setSourceGroupNamePtr, mask)
  }

  public final fun getSourceGroupName(): StringName =
      TransferContext.callPtrMethod0_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getSourceGroupNamePtr)

  public final fun setCellSize(cellSize: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setCellSizePtr, cellSize.toDouble())
  }

  public final fun getCellSize(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCellSizePtr).toFloat()

  public final fun setCellHeight(cellHeight: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setCellHeightPtr, cellHeight.toDouble())
  }

  public final fun getCellHeight(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCellHeightPtr).toFloat()

  public final fun setBorderSize(borderSize: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setBorderSizePtr, borderSize.toDouble())
  }

  public final fun getBorderSize(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBorderSizePtr).toFloat()

  public final fun setAgentHeight(agentHeight: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAgentHeightPtr, agentHeight.toDouble())
  }

  public final fun getAgentHeight(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAgentHeightPtr).toFloat()

  public final fun setAgentRadius(agentRadius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAgentRadiusPtr, agentRadius.toDouble())
  }

  public final fun getAgentRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAgentRadiusPtr).toFloat()

  public final fun setAgentMaxClimb(agentMaxClimb: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAgentMaxClimbPtr, agentMaxClimb.toDouble())
  }

  public final fun getAgentMaxClimb(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAgentMaxClimbPtr).toFloat()

  public final fun setAgentMaxSlope(agentMaxSlope: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAgentMaxSlopePtr, agentMaxSlope.toDouble())
  }

  public final fun getAgentMaxSlope(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAgentMaxSlopePtr).toFloat()

  public final fun setRegionMinSize(regionMinSize: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRegionMinSizePtr, regionMinSize.toDouble())
  }

  public final fun getRegionMinSize(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRegionMinSizePtr).toFloat()

  public final fun setRegionMergeSize(regionMergeSize: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRegionMergeSizePtr, regionMergeSize.toDouble())
  }

  public final fun getRegionMergeSize(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRegionMergeSizePtr).toFloat()

  public final fun setEdgeMaxLength(edgeMaxLength: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setEdgeMaxLengthPtr, edgeMaxLength.toDouble())
  }

  public final fun getEdgeMaxLength(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getEdgeMaxLengthPtr).toFloat()

  public final fun setEdgeMaxError(edgeMaxError: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setEdgeMaxErrorPtr, edgeMaxError.toDouble())
  }

  public final fun getEdgeMaxError(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getEdgeMaxErrorPtr).toFloat()

  public final fun setVerticesPerPolygon(verticesPerPolygon: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setVerticesPerPolygonPtr, verticesPerPolygon.toDouble())
  }

  public final fun getVerticesPerPolygon(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getVerticesPerPolygonPtr).toFloat()

  public final fun setDetailSampleDistance(detailSampleDist: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDetailSampleDistancePtr, detailSampleDist.toDouble())
  }

  public final fun getDetailSampleDistance(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDetailSampleDistancePtr).toFloat()

  public final fun setDetailSampleMaxError(detailSampleMaxError: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDetailSampleMaxErrorPtr, detailSampleMaxError.toDouble())
  }

  public final fun getDetailSampleMaxError(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDetailSampleMaxErrorPtr).toFloat()

  public final fun setFilterLowHangingObstacles(filterLowHangingObstacles: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFilterLowHangingObstaclesPtr, filterLowHangingObstacles)
  }

  public final fun getFilterLowHangingObstacles(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getFilterLowHangingObstaclesPtr)

  public final fun setFilterLedgeSpans(filterLedgeSpans: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFilterLedgeSpansPtr, filterLedgeSpans)
  }

  public final fun getFilterLedgeSpans(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getFilterLedgeSpansPtr)

  public final fun setFilterWalkableLowHeightSpans(filterWalkableLowHeightSpans: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFilterWalkableLowHeightSpansPtr, filterWalkableLowHeightSpans)
  }

  public final fun getFilterWalkableLowHeightSpans(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getFilterWalkableLowHeightSpansPtr)

  public final fun setFilterBakingAabb(bakingAabb: AABB): Unit {
    TransferContext.callPtrMethod_AABB(ptr, objectID.id, MethodBindings.setFilterBakingAabbPtr, bakingAabb)
  }

  public final fun getFilterBakingAabb(): AABB =
      TransferContext.callPtrMethod0_ret_AABB(ptr, objectID.id, MethodBindings.getFilterBakingAabbPtr)

  public final fun setFilterBakingAabbOffset(bakingAabbOffset: Vector3): Unit {
    TransferContext.callPtrMethod_VECTOR3(ptr, objectID.id, MethodBindings.setFilterBakingAabbOffsetPtr, bakingAabbOffset)
  }

  public final fun getFilterBakingAabbOffset(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getFilterBakingAabbOffsetPtr)

  /**
   * Sets the vertices that can be then indexed to create polygons with the [addPolygon] method.
   */
  public final fun setVertices(vertices: PackedVector3Array): Unit {
    TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY(ptr, objectID.id, MethodBindings.setVerticesPtr, vertices)
  }

  /**
   * Returns a [PackedVector3Array] containing all the vertices being used to create the polygons.
   */
  public final fun getVertices(): PackedVector3Array =
      TransferContext.callPtrMethod0_ret_PACKED_VECTOR3_ARRAY(ptr, objectID.id, MethodBindings.getVerticesPtr)

  /**
   * Adds a polygon using the indices of the vertices you get when calling [getVertices].
   */
  public final fun addPolygon(polygon: PackedInt32Array): Unit {
    TransferContext.callPtrMethod_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.addPolygonPtr, polygon)
  }

  /**
   * Returns the number of polygons in the navigation mesh.
   */
  public final fun getPolygonCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPolygonCountPtr).toInt()

  /**
   * Returns a [PackedInt32Array] containing the indices of the vertices of a created polygon.
   */
  public final fun getPolygon(idx: Int): PackedInt32Array =
      TransferContext.callPtrMethod_LONG_ret_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.getPolygonPtr, idx.toLong())

  /**
   * Clears the array of polygons, but it doesn't clear the array of vertices.
   */
  public final fun clearPolygons(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPolygonsPtr)
  }

  /**
   * Initializes the navigation mesh by setting the vertices and indices according to a [Mesh].
   *
   * **Note:** The given [mesh] must be of type [Mesh.PRIMITIVE_TRIANGLES] and have an index array.
   */
  public final fun createFromMesh(mesh: Mesh?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.createFromMeshPtr, mesh)
  }

  /**
   * Clears the internal arrays for vertices and polygon indices.
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  public final fun setSourceGroupName(mask: String) = setSourceGroupName(mask.asCachedStringName())

  public enum class SamplePartitionType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Watershed partitioning. Generally the best choice if you precompute the navigation mesh, use
     * this if you have large open areas.
     */
    WATERSHED(0),
    /**
     * Monotone partitioning. Use this if you want fast navigation mesh generation.
     */
    MONOTONE(1),
    /**
     * Layer partitioning. Good choice to use for tiled navigation mesh with medium and small sized
     * tiles.
     */
    LAYERS(2),
    /**
     * Represents the size of the [SamplePartitionType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): SamplePartitionType = entries.single { it.`value` == `value` }
    }
  }

  public enum class ParsedGeometryType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Parses mesh instances as geometry. This includes [MeshInstance3D], [CSGShape3D], and
     * [GridMap] nodes.
     */
    MESH_INSTANCES(0),
    /**
     * Parses [StaticBody3D] colliders as geometry. The collider should be in any of the layers
     * specified by [geometryCollisionMask].
     */
    STATIC_COLLIDERS(1),
    /**
     * Both [PARSED_GEOMETRY_MESH_INSTANCES] and [PARSED_GEOMETRY_STATIC_COLLIDERS].
     */
    BOTH(2),
    /**
     * Represents the size of the [ParsedGeometryType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ParsedGeometryType = entries.single { it.`value` == `value` }
    }
  }

  public enum class SourceGeometryMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Scans the child nodes of the root node recursively for geometry.
     */
    ROOT_NODE_CHILDREN(0),
    /**
     * Scans nodes in a group and their child nodes recursively for geometry. The group is specified
     * by [geometrySourceGroupName].
     */
    GROUPS_WITH_CHILDREN(1),
    /**
     * Uses nodes in a group for geometry. The group is specified by [geometrySourceGroupName].
     */
    GROUPS_EXPLICIT(2),
    /**
     * Represents the size of the [SourceGeometryMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): SourceGeometryMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSamplePartitionTypeName:
        MethodStringName1<NavigationMesh, Unit, SamplePartitionType> =
        MethodStringName1<NavigationMesh, Unit, SamplePartitionType>("set_sample_partition_type")

    @JvmField
    public val getSamplePartitionTypeName: MethodStringName0<NavigationMesh, SamplePartitionType> =
        MethodStringName0<NavigationMesh, SamplePartitionType>("get_sample_partition_type")

    @JvmField
    public val setParsedGeometryTypeName:
        MethodStringName1<NavigationMesh, Unit, ParsedGeometryType> =
        MethodStringName1<NavigationMesh, Unit, ParsedGeometryType>("set_parsed_geometry_type")

    @JvmField
    public val getParsedGeometryTypeName: MethodStringName0<NavigationMesh, ParsedGeometryType> =
        MethodStringName0<NavigationMesh, ParsedGeometryType>("get_parsed_geometry_type")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<NavigationMesh, Unit, Long> =
        MethodStringName1<NavigationMesh, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<NavigationMesh, Long> =
        MethodStringName0<NavigationMesh, Long>("get_collision_mask")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<NavigationMesh, Unit, Int, Boolean> =
        MethodStringName2<NavigationMesh, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<NavigationMesh, Boolean, Int> =
        MethodStringName1<NavigationMesh, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setSourceGeometryModeName:
        MethodStringName1<NavigationMesh, Unit, SourceGeometryMode> =
        MethodStringName1<NavigationMesh, Unit, SourceGeometryMode>("set_source_geometry_mode")

    @JvmField
    public val getSourceGeometryModeName: MethodStringName0<NavigationMesh, SourceGeometryMode> =
        MethodStringName0<NavigationMesh, SourceGeometryMode>("get_source_geometry_mode")

    @JvmField
    public val setSourceGroupNameName: MethodStringName1<NavigationMesh, Unit, StringName> =
        MethodStringName1<NavigationMesh, Unit, StringName>("set_source_group_name")

    @JvmField
    public val getSourceGroupNameName: MethodStringName0<NavigationMesh, StringName> =
        MethodStringName0<NavigationMesh, StringName>("get_source_group_name")

    @JvmField
    public val setCellSizeName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_cell_size")

    @JvmField
    public val getCellSizeName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_cell_size")

    @JvmField
    public val setCellHeightName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_cell_height")

    @JvmField
    public val getCellHeightName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_cell_height")

    @JvmField
    public val setBorderSizeName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_border_size")

    @JvmField
    public val getBorderSizeName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_border_size")

    @JvmField
    public val setAgentHeightName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_agent_height")

    @JvmField
    public val getAgentHeightName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_agent_height")

    @JvmField
    public val setAgentRadiusName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_agent_radius")

    @JvmField
    public val getAgentRadiusName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_agent_radius")

    @JvmField
    public val setAgentMaxClimbName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_agent_max_climb")

    @JvmField
    public val getAgentMaxClimbName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_agent_max_climb")

    @JvmField
    public val setAgentMaxSlopeName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_agent_max_slope")

    @JvmField
    public val getAgentMaxSlopeName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_agent_max_slope")

    @JvmField
    public val setRegionMinSizeName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_region_min_size")

    @JvmField
    public val getRegionMinSizeName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_region_min_size")

    @JvmField
    public val setRegionMergeSizeName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_region_merge_size")

    @JvmField
    public val getRegionMergeSizeName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_region_merge_size")

    @JvmField
    public val setEdgeMaxLengthName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_edge_max_length")

    @JvmField
    public val getEdgeMaxLengthName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_edge_max_length")

    @JvmField
    public val setEdgeMaxErrorName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_edge_max_error")

    @JvmField
    public val getEdgeMaxErrorName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_edge_max_error")

    @JvmField
    public val setVerticesPerPolygonName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_vertices_per_polygon")

    @JvmField
    public val getVerticesPerPolygonName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_vertices_per_polygon")

    @JvmField
    public val setDetailSampleDistanceName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_detail_sample_distance")

    @JvmField
    public val getDetailSampleDistanceName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_detail_sample_distance")

    @JvmField
    public val setDetailSampleMaxErrorName: MethodStringName1<NavigationMesh, Unit, Float> =
        MethodStringName1<NavigationMesh, Unit, Float>("set_detail_sample_max_error")

    @JvmField
    public val getDetailSampleMaxErrorName: MethodStringName0<NavigationMesh, Float> =
        MethodStringName0<NavigationMesh, Float>("get_detail_sample_max_error")

    @JvmField
    public val setFilterLowHangingObstaclesName: MethodStringName1<NavigationMesh, Unit, Boolean> =
        MethodStringName1<NavigationMesh, Unit, Boolean>("set_filter_low_hanging_obstacles")

    @JvmField
    public val getFilterLowHangingObstaclesName: MethodStringName0<NavigationMesh, Boolean> =
        MethodStringName0<NavigationMesh, Boolean>("get_filter_low_hanging_obstacles")

    @JvmField
    public val setFilterLedgeSpansName: MethodStringName1<NavigationMesh, Unit, Boolean> =
        MethodStringName1<NavigationMesh, Unit, Boolean>("set_filter_ledge_spans")

    @JvmField
    public val getFilterLedgeSpansName: MethodStringName0<NavigationMesh, Boolean> =
        MethodStringName0<NavigationMesh, Boolean>("get_filter_ledge_spans")

    @JvmField
    public val setFilterWalkableLowHeightSpansName: MethodStringName1<NavigationMesh, Unit, Boolean>
        = MethodStringName1<NavigationMesh, Unit, Boolean>("set_filter_walkable_low_height_spans")

    @JvmField
    public val getFilterWalkableLowHeightSpansName: MethodStringName0<NavigationMesh, Boolean> =
        MethodStringName0<NavigationMesh, Boolean>("get_filter_walkable_low_height_spans")

    @JvmField
    public val setFilterBakingAabbName: MethodStringName1<NavigationMesh, Unit, AABB> =
        MethodStringName1<NavigationMesh, Unit, AABB>("set_filter_baking_aabb")

    @JvmField
    public val getFilterBakingAabbName: MethodStringName0<NavigationMesh, AABB> =
        MethodStringName0<NavigationMesh, AABB>("get_filter_baking_aabb")

    @JvmField
    public val setFilterBakingAabbOffsetName: MethodStringName1<NavigationMesh, Unit, Vector3> =
        MethodStringName1<NavigationMesh, Unit, Vector3>("set_filter_baking_aabb_offset")

    @JvmField
    public val getFilterBakingAabbOffsetName: MethodStringName0<NavigationMesh, Vector3> =
        MethodStringName0<NavigationMesh, Vector3>("get_filter_baking_aabb_offset")

    @JvmField
    public val setVerticesName: MethodStringName1<NavigationMesh, Unit, PackedVector3Array> =
        MethodStringName1<NavigationMesh, Unit, PackedVector3Array>("set_vertices")

    @JvmField
    public val getVerticesName: MethodStringName0<NavigationMesh, PackedVector3Array> =
        MethodStringName0<NavigationMesh, PackedVector3Array>("get_vertices")

    @JvmField
    public val addPolygonName: MethodStringName1<NavigationMesh, Unit, PackedInt32Array> =
        MethodStringName1<NavigationMesh, Unit, PackedInt32Array>("add_polygon")

    @JvmField
    public val getPolygonCountName: MethodStringName0<NavigationMesh, Int> =
        MethodStringName0<NavigationMesh, Int>("get_polygon_count")

    @JvmField
    public val getPolygonName: MethodStringName1<NavigationMesh, PackedInt32Array, Int> =
        MethodStringName1<NavigationMesh, PackedInt32Array, Int>("get_polygon")

    @JvmField
    public val clearPolygonsName: MethodStringName0<NavigationMesh, Unit> =
        MethodStringName0<NavigationMesh, Unit>("clear_polygons")

    @JvmField
    public val createFromMeshName: MethodStringName1<NavigationMesh, Unit, Mesh?> =
        MethodStringName1<NavigationMesh, Unit, Mesh?>("create_from_mesh")

    @JvmField
    public val clearName: MethodStringName0<NavigationMesh, Unit> =
        MethodStringName0<NavigationMesh, Unit>("clear")
  }

  public object MethodBindings {
    internal val setSamplePartitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_sample_partition_type", 2472437533)

    internal val getSamplePartitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_sample_partition_type", 833513918)

    internal val setParsedGeometryTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_parsed_geometry_type", 3064713163)

    internal val getParsedGeometryTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_parsed_geometry_type", 3928011953)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_collision_mask", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_collision_mask_value", 1116898809)

    internal val setSourceGeometryModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_source_geometry_mode", 2700825194)

    internal val getSourceGeometryModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_source_geometry_mode", 2770484141)

    internal val setSourceGroupNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_source_group_name", 3304788590)

    internal val getSourceGroupNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_source_group_name", 2002593661)

    internal val setCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_cell_size", 373806689)

    internal val getCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_cell_size", 1740695150)

    internal val setCellHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_cell_height", 373806689)

    internal val getCellHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_cell_height", 1740695150)

    internal val setBorderSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_border_size", 373806689)

    internal val getBorderSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_border_size", 1740695150)

    internal val setAgentHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_agent_height", 373806689)

    internal val getAgentHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_agent_height", 1740695150)

    internal val setAgentRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_agent_radius", 373806689)

    internal val getAgentRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_agent_radius", 191475506)

    internal val setAgentMaxClimbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_agent_max_climb", 373806689)

    internal val getAgentMaxClimbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_agent_max_climb", 1740695150)

    internal val setAgentMaxSlopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_agent_max_slope", 373806689)

    internal val getAgentMaxSlopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_agent_max_slope", 1740695150)

    internal val setRegionMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_region_min_size", 373806689)

    internal val getRegionMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_region_min_size", 1740695150)

    internal val setRegionMergeSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_region_merge_size", 373806689)

    internal val getRegionMergeSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_region_merge_size", 1740695150)

    internal val setEdgeMaxLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_edge_max_length", 373806689)

    internal val getEdgeMaxLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_edge_max_length", 1740695150)

    internal val setEdgeMaxErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_edge_max_error", 373806689)

    internal val getEdgeMaxErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_edge_max_error", 1740695150)

    internal val setVerticesPerPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_vertices_per_polygon", 373806689)

    internal val getVerticesPerPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_vertices_per_polygon", 1740695150)

    internal val setDetailSampleDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_detail_sample_distance", 373806689)

    internal val getDetailSampleDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_detail_sample_distance", 1740695150)

    internal val setDetailSampleMaxErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_detail_sample_max_error", 373806689)

    internal val getDetailSampleMaxErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_detail_sample_max_error", 1740695150)

    internal val setFilterLowHangingObstaclesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_filter_low_hanging_obstacles", 2586408642)

    internal val getFilterLowHangingObstaclesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_filter_low_hanging_obstacles", 36873697)

    internal val setFilterLedgeSpansPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_filter_ledge_spans", 2586408642)

    internal val getFilterLedgeSpansPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_filter_ledge_spans", 36873697)

    internal val setFilterWalkableLowHeightSpansPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_filter_walkable_low_height_spans", 2586408642)

    internal val getFilterWalkableLowHeightSpansPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_filter_walkable_low_height_spans", 36873697)

    internal val setFilterBakingAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_filter_baking_aabb", 259215842)

    internal val getFilterBakingAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_filter_baking_aabb", 1068685055)

    internal val setFilterBakingAabbOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_filter_baking_aabb_offset", 3460891852)

    internal val getFilterBakingAabbOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_filter_baking_aabb_offset", 3360562783)

    internal val setVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "set_vertices", 334873810)

    internal val getVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_vertices", 497664490)

    internal val addPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "add_polygon", 3614634198)

    internal val getPolygonCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_polygon_count", 3905245786)

    internal val getPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "get_polygon", 3668444399)

    internal val clearPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "clear_polygons", 3218959716)

    internal val createFromMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "create_from_mesh", 194775623)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMesh", "clear", 3218959716)
  }
}
