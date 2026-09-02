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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedInt32Array
import godot.core.PackedVector2Array
import godot.core.Rect2
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A navigation mesh can be created either by baking it with the help of the [NavigationServer2D],
 * or by adding vertices and convex polygon indices arrays manually.
 *
 * To bake a navigation mesh at least one outline needs to be added that defines the outer bounds of
 * the baked area.
 *
 * ```gdscript
 * //gdscript
 * var new_navigation_mesh = NavigationPolygon.new()
 * var bounding_outline = PackedVector2Array([Vector2(0, 0), Vector2(0, 50), Vector2(50, 50),
 * Vector2(50, 0)])
 * new_navigation_mesh.add_outline(bounding_outline)
 * NavigationServer2D.bake_from_source_geometry_data(new_navigation_mesh,
 * NavigationMeshSourceGeometryData2D.new());
 * $NavigationRegion2D.navigation_polygon = new_navigation_mesh
 * ```
 *
 * ```csharp
 * //csharp
 * var newNavigationMesh = new NavigationPolygon();
 * Vector2[] boundingOutline = [new Vector2(0, 0), new Vector2(0, 50), new Vector2(50, 50), new
 * Vector2(50, 0)];
 * newNavigationMesh.AddOutline(boundingOutline);
 * NavigationServer2D.BakeFromSourceGeometryData(newNavigationMesh, new
 * NavigationMeshSourceGeometryData2D());
 * GetNode<NavigationRegion2D>("NavigationRegion2D").NavigationPolygon = newNavigationMesh;
 * ```
 *
 * Adding vertices and polygon indices manually.
 *
 * ```gdscript
 * //gdscript
 * var new_navigation_mesh = NavigationPolygon.new()
 * var new_vertices = PackedVector2Array([Vector2(0, 0), Vector2(0, 50), Vector2(50, 50),
 * Vector2(50, 0)])
 * new_navigation_mesh.vertices = new_vertices
 * var new_polygon_indices = PackedInt32Array([0, 1, 2, 3])
 * new_navigation_mesh.add_polygon(new_polygon_indices)
 * $NavigationRegion2D.navigation_polygon = new_navigation_mesh
 * ```
 *
 * ```csharp
 * //csharp
 * var newNavigationMesh = new NavigationPolygon();
 * Vector2[] newVertices = [new Vector2(0, 0), new Vector2(0, 50), new Vector2(50, 50), new
 * Vector2(50, 0)];
 * newNavigationMesh.Vertices = newVertices;
 * int[] newPolygonIndices = [0, 1, 2, 3];
 * newNavigationMesh.AddPolygon(newPolygonIndices);
 * GetNode<NavigationRegion2D>("NavigationRegion2D").NavigationPolygon = newNavigationMesh;
 * ```
 */
@GodotBaseType
public open class NavigationPolygon : Resource() {
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
  public final inline var vertices: PackedVector2Array
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
  public final inline var parsedGeometryType: ParsedGeometryType
    @JvmName("parsedGeometryTypeProperty")
    get() = getParsedGeometryType()
    @JvmName("parsedGeometryTypeProperty")
    set(`value`) {
      setParsedGeometryType(value)
    }

  /**
   * The physics layers to scan for static colliders.
   *
   * Only used when [parsedGeometryType] is [PARSED_GEOMETRY_STATIC_COLLIDERS] or
   * [PARSED_GEOMETRY_BOTH].
   */
  public final inline var parsedCollisionMask: Long
    @JvmName("parsedCollisionMaskProperty")
    get() = getParsedCollisionMask()
    @JvmName("parsedCollisionMaskProperty")
    set(`value`) {
      setParsedCollisionMask(value)
    }

  /**
   * The source of the geometry used when baking.
   */
  public final inline var sourceGeometryMode: SourceGeometryMode
    @JvmName("sourceGeometryModeProperty")
    get() = getSourceGeometryMode()
    @JvmName("sourceGeometryModeProperty")
    set(`value`) {
      setSourceGeometryMode(value)
    }

  /**
   * The group name of nodes that should be parsed for baking source geometry.
   *
   * Only used when [sourceGeometryMode] is [SOURCE_GEOMETRY_GROUPS_WITH_CHILDREN] or
   * [SOURCE_GEOMETRY_GROUPS_EXPLICIT].
   */
  public final inline var sourceGeometryGroupName: StringName
    @JvmName("sourceGeometryGroupNameProperty")
    get() = getSourceGeometryGroupName()
    @JvmName("sourceGeometryGroupNameProperty")
    set(`value`) {
      setSourceGeometryGroupName(value)
    }

  /**
   * The cell size used to rasterize the navigation mesh vertices. Must match with the cell size on
   * the navigation map.
   */
  public final inline var cellSize: Float
    @JvmName("cellSizeProperty")
    get() = getCellSize()
    @JvmName("cellSizeProperty")
    set(`value`) {
      setCellSize(value)
    }

  /**
   * The size of the non-navigable border around the bake bounding area defined by the [bakingRect]
   * [Rect2].
   *
   * In conjunction with the [bakingRect] the border size can be used to bake tile aligned
   * navigation meshes without the tile edges being shrunk by [agentRadius].
   */
  public final inline var borderSize: Float
    @JvmName("borderSizeProperty")
    get() = getBorderSize()
    @JvmName("borderSizeProperty")
    set(`value`) {
      setBorderSize(value)
    }

  /**
   * The distance to erode/shrink the walkable surface when baking the navigation mesh.
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
   * If the baking [Rect2] has an area the navigation mesh baking will be restricted to its
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
  public final inline var bakingRect: Rect2
    @JvmName("bakingRectProperty")
    get() = getBakingRect()
    @JvmName("bakingRectProperty")
    set(`value`) {
      setBakingRect(value)
    }

  /**
   * The position offset applied to the [bakingRect] [Rect2].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bakingRectOffset: Vector2
    @JvmName("bakingRectOffsetProperty")
    get() = getBakingRectOffset()
    @JvmName("bakingRectOffsetProperty")
    set(`value`) {
      setBakingRectOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(413, scriptPtr)
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpolygon.vertices
   * //Your changes
   * navigationpolygon.vertices = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun verticesMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
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
  public final fun verticesMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = vertices.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     vertices = this
  }

  /**
   * This is a helper function for [bakingRect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpolygon.bakingRect
   * //Your changes
   * navigationpolygon.bakingRect = myCoreType
   * ``````
   *
   * If the baking [Rect2] has an area the navigation mesh baking will be restricted to its
   * enclosing area.
   */
  @CoreTypeHelper
  public final fun bakingRectMutate(block: Rect2.() -> Unit): Rect2 = bakingRect.apply {
     block(this)
     bakingRect = this
  }

  /**
   * This is a helper function for [bakingRectOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpolygon.bakingRectOffset
   * //Your changes
   * navigationpolygon.bakingRectOffset = myCoreType
   * ``````
   *
   * The position offset applied to the [bakingRect] [Rect2].
   */
  @CoreTypeHelper
  public final fun bakingRectOffsetMutate(block: Vector2.() -> Unit): Vector2 =
      bakingRectOffset.apply {
     block(this)
     bakingRectOffset = this
  }

  /**
   * Sets the vertices that can be then indexed to create polygons with the [addPolygon] method.
   */
  public final fun setVertices(vertices: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to vertices)
    TransferContext.callMethod(MethodBindings.setVerticesPtr)
  }

  /**
   * Returns a [PackedVector2Array] containing all the vertices being used to create the polygons.
   */
  public final fun getVertices(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVerticesPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Adds a polygon using the indices of the vertices you get when calling [getVertices].
   */
  public final fun addPolygon(polygon: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.addPolygonPtr)
  }

  /**
   * Returns the count of all polygons.
   */
  public final fun getPolygonCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPolygonCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [PackedInt32Array] containing the indices of the vertices of a created polygon.
   */
  public final fun getPolygon(idx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getPolygonPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Clears the array of polygons, but it doesn't clear the array of outlines and vertices.
   */
  public final fun clearPolygons(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPolygonsPtr)
  }

  /**
   * Returns the [NavigationMesh] resulting from this navigation polygon. This navigation mesh can
   * be used to update the navigation mesh of a region with the
   * [NavigationServer3D.regionSetNavigationMesh] API directly.
   */
  public final fun getNavigationMesh(): NavigationMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as NavigationMesh?)
  }

  /**
   * Appends a [PackedVector2Array] that contains the vertices of an outline to the internal array
   * that contains all the outlines.
   */
  public final fun addOutline(outline: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to outline)
    TransferContext.callMethod(MethodBindings.addOutlinePtr)
  }

  /**
   * Adds a [PackedVector2Array] that contains the vertices of an outline to the internal array that
   * contains all the outlines at a fixed position.
   */
  public final fun addOutlineAtIndex(outline: PackedVector2Array, index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to outline, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.addOutlineAtIndexPtr)
  }

  /**
   * Returns the number of outlines that were created in the editor or by script.
   */
  public final fun getOutlineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutlineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Changes an outline created in the editor or by script. You have to call
   * [makePolygonsFromOutlines] for the polygons to update.
   */
  public final fun setOutline(idx: Int, outline: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), PACKED_VECTOR2_ARRAY to outline)
    TransferContext.callMethod(MethodBindings.setOutlinePtr)
  }

  /**
   * Returns a [PackedVector2Array] containing the vertices of an outline that was created in the
   * editor or by script.
   */
  public final fun getOutline(idx: Int): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getOutlinePtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Removes an outline created in the editor or by script. You have to call
   * [makePolygonsFromOutlines] for the polygons to update.
   */
  public final fun removeOutline(idx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.removeOutlinePtr)
  }

  /**
   * Clears the array of the outlines, but it doesn't clear the vertices and the polygons that were
   * created by them.
   */
  public final fun clearOutlines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearOutlinesPtr)
  }

  /**
   * Creates polygons from the outlines added in the editor or by script.
   */
  public final fun makePolygonsFromOutlines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.makePolygonsFromOutlinesPtr)
  }

  public final fun setCellSize(cellSize: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to cellSize.toDouble())
    TransferContext.callMethod(MethodBindings.setCellSizePtr)
  }

  public final fun getCellSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCellSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBorderSize(borderSize: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to borderSize.toDouble())
    TransferContext.callMethod(MethodBindings.setBorderSizePtr)
  }

  public final fun getBorderSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSamplePartitionType(samplePartitionType: SamplePartitionType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to samplePartitionType.value)
    TransferContext.callMethod(MethodBindings.setSamplePartitionTypePtr)
  }

  public final fun getSamplePartitionType(): SamplePartitionType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSamplePartitionTypePtr)
    return SamplePartitionType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setParsedGeometryType(geometryType: ParsedGeometryType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to geometryType.value)
    TransferContext.callMethod(MethodBindings.setParsedGeometryTypePtr)
  }

  public final fun getParsedGeometryType(): ParsedGeometryType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParsedGeometryTypePtr)
    return ParsedGeometryType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setParsedCollisionMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setParsedCollisionMaskPtr)
  }

  public final fun getParsedCollisionMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParsedCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [parsedCollisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setParsedCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setParsedCollisionMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [parsedCollisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getParsedCollisionMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getParsedCollisionMaskValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSourceGeometryMode(geometryMode: SourceGeometryMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to geometryMode.value)
    TransferContext.callMethod(MethodBindings.setSourceGeometryModePtr)
  }

  public final fun getSourceGeometryMode(): SourceGeometryMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSourceGeometryModePtr)
    return SourceGeometryMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSourceGeometryGroupName(groupName: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to groupName)
    TransferContext.callMethod(MethodBindings.setSourceGeometryGroupNamePtr)
  }

  public final fun getSourceGeometryGroupName(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSourceGeometryGroupNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setAgentRadius(agentRadius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to agentRadius.toDouble())
    TransferContext.callMethod(MethodBindings.setAgentRadiusPtr)
  }

  public final fun getAgentRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAgentRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBakingRect(rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.setBakingRectPtr)
  }

  public final fun getBakingRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakingRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setBakingRectOffset(rectOffset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to rectOffset)
    TransferContext.callMethod(MethodBindings.setBakingRectOffsetPtr)
  }

  public final fun getBakingRectOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakingRectOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Clears the internal arrays for vertices and polygon indices.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  public final fun setSourceGeometryGroupName(groupName: String) =
      setSourceGeometryGroupName(groupName.asCachedStringName())

  public enum class SamplePartitionType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Convex partitioning that results in a navigation mesh with convex polygons.
     */
    CONVEX_PARTITION(0),
    /**
     * Triangulation partitioning that results in a navigation mesh with triangle polygons.
     */
    TRIANGULATE(1),
    /**
     * Represents the size of the [SamplePartitionType] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): SamplePartitionType = entries.single { it.`value` == `value` }
    }
  }

  public enum class ParsedGeometryType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Parses mesh instances as obstruction geometry. This includes [Polygon2D], [MeshInstance2D],
     * [MultiMeshInstance2D], and [TileMap] nodes.
     *
     * Meshes are only parsed when they use a 2D vertices surface format.
     */
    MESH_INSTANCES(0),
    /**
     * Parses [StaticBody2D] and [TileMap] colliders as obstruction geometry. The collider should be
     * in any of the layers specified by [parsedCollisionMask].
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
     * by [sourceGeometryGroupName].
     */
    GROUPS_WITH_CHILDREN(1),
    /**
     * Uses nodes in a group for geometry. The group is specified by [sourceGeometryGroupName].
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
    public val setVerticesName: MethodStringName1<NavigationPolygon, Unit, PackedVector2Array> =
        MethodStringName1<NavigationPolygon, Unit, PackedVector2Array>("set_vertices")

    @JvmField
    public val getVerticesName: MethodStringName0<NavigationPolygon, PackedVector2Array> =
        MethodStringName0<NavigationPolygon, PackedVector2Array>("get_vertices")

    @JvmField
    public val addPolygonName: MethodStringName1<NavigationPolygon, Unit, PackedInt32Array> =
        MethodStringName1<NavigationPolygon, Unit, PackedInt32Array>("add_polygon")

    @JvmField
    public val getPolygonCountName: MethodStringName0<NavigationPolygon, Int> =
        MethodStringName0<NavigationPolygon, Int>("get_polygon_count")

    @JvmField
    public val getPolygonName: MethodStringName1<NavigationPolygon, PackedInt32Array, Int> =
        MethodStringName1<NavigationPolygon, PackedInt32Array, Int>("get_polygon")

    @JvmField
    public val clearPolygonsName: MethodStringName0<NavigationPolygon, Unit> =
        MethodStringName0<NavigationPolygon, Unit>("clear_polygons")

    @JvmField
    public val getNavigationMeshName: MethodStringName0<NavigationPolygon, NavigationMesh?> =
        MethodStringName0<NavigationPolygon, NavigationMesh?>("get_navigation_mesh")

    @JvmField
    public val addOutlineName: MethodStringName1<NavigationPolygon, Unit, PackedVector2Array> =
        MethodStringName1<NavigationPolygon, Unit, PackedVector2Array>("add_outline")

    @JvmField
    public val addOutlineAtIndexName:
        MethodStringName2<NavigationPolygon, Unit, PackedVector2Array, Int> =
        MethodStringName2<NavigationPolygon, Unit, PackedVector2Array, Int>("add_outline_at_index")

    @JvmField
    public val getOutlineCountName: MethodStringName0<NavigationPolygon, Int> =
        MethodStringName0<NavigationPolygon, Int>("get_outline_count")

    @JvmField
    public val setOutlineName: MethodStringName2<NavigationPolygon, Unit, Int, PackedVector2Array> =
        MethodStringName2<NavigationPolygon, Unit, Int, PackedVector2Array>("set_outline")

    @JvmField
    public val getOutlineName: MethodStringName1<NavigationPolygon, PackedVector2Array, Int> =
        MethodStringName1<NavigationPolygon, PackedVector2Array, Int>("get_outline")

    @JvmField
    public val removeOutlineName: MethodStringName1<NavigationPolygon, Unit, Int> =
        MethodStringName1<NavigationPolygon, Unit, Int>("remove_outline")

    @JvmField
    public val clearOutlinesName: MethodStringName0<NavigationPolygon, Unit> =
        MethodStringName0<NavigationPolygon, Unit>("clear_outlines")

    @JvmField
    public val makePolygonsFromOutlinesName: MethodStringName0<NavigationPolygon, Unit> =
        MethodStringName0<NavigationPolygon, Unit>("make_polygons_from_outlines")

    @JvmField
    public val setCellSizeName: MethodStringName1<NavigationPolygon, Unit, Float> =
        MethodStringName1<NavigationPolygon, Unit, Float>("set_cell_size")

    @JvmField
    public val getCellSizeName: MethodStringName0<NavigationPolygon, Float> =
        MethodStringName0<NavigationPolygon, Float>("get_cell_size")

    @JvmField
    public val setBorderSizeName: MethodStringName1<NavigationPolygon, Unit, Float> =
        MethodStringName1<NavigationPolygon, Unit, Float>("set_border_size")

    @JvmField
    public val getBorderSizeName: MethodStringName0<NavigationPolygon, Float> =
        MethodStringName0<NavigationPolygon, Float>("get_border_size")

    @JvmField
    public val setSamplePartitionTypeName:
        MethodStringName1<NavigationPolygon, Unit, SamplePartitionType> =
        MethodStringName1<NavigationPolygon, Unit, SamplePartitionType>("set_sample_partition_type")

    @JvmField
    public val getSamplePartitionTypeName: MethodStringName0<NavigationPolygon, SamplePartitionType>
        = MethodStringName0<NavigationPolygon, SamplePartitionType>("get_sample_partition_type")

    @JvmField
    public val setParsedGeometryTypeName:
        MethodStringName1<NavigationPolygon, Unit, ParsedGeometryType> =
        MethodStringName1<NavigationPolygon, Unit, ParsedGeometryType>("set_parsed_geometry_type")

    @JvmField
    public val getParsedGeometryTypeName: MethodStringName0<NavigationPolygon, ParsedGeometryType> =
        MethodStringName0<NavigationPolygon, ParsedGeometryType>("get_parsed_geometry_type")

    @JvmField
    public val setParsedCollisionMaskName: MethodStringName1<NavigationPolygon, Unit, Long> =
        MethodStringName1<NavigationPolygon, Unit, Long>("set_parsed_collision_mask")

    @JvmField
    public val getParsedCollisionMaskName: MethodStringName0<NavigationPolygon, Long> =
        MethodStringName0<NavigationPolygon, Long>("get_parsed_collision_mask")

    @JvmField
    public val setParsedCollisionMaskValueName:
        MethodStringName2<NavigationPolygon, Unit, Int, Boolean> =
        MethodStringName2<NavigationPolygon, Unit, Int, Boolean>("set_parsed_collision_mask_value")

    @JvmField
    public val getParsedCollisionMaskValueName: MethodStringName1<NavigationPolygon, Boolean, Int> =
        MethodStringName1<NavigationPolygon, Boolean, Int>("get_parsed_collision_mask_value")

    @JvmField
    public val setSourceGeometryModeName:
        MethodStringName1<NavigationPolygon, Unit, SourceGeometryMode> =
        MethodStringName1<NavigationPolygon, Unit, SourceGeometryMode>("set_source_geometry_mode")

    @JvmField
    public val getSourceGeometryModeName: MethodStringName0<NavigationPolygon, SourceGeometryMode> =
        MethodStringName0<NavigationPolygon, SourceGeometryMode>("get_source_geometry_mode")

    @JvmField
    public val setSourceGeometryGroupNameName:
        MethodStringName1<NavigationPolygon, Unit, StringName> =
        MethodStringName1<NavigationPolygon, Unit, StringName>("set_source_geometry_group_name")

    @JvmField
    public val getSourceGeometryGroupNameName: MethodStringName0<NavigationPolygon, StringName> =
        MethodStringName0<NavigationPolygon, StringName>("get_source_geometry_group_name")

    @JvmField
    public val setAgentRadiusName: MethodStringName1<NavigationPolygon, Unit, Float> =
        MethodStringName1<NavigationPolygon, Unit, Float>("set_agent_radius")

    @JvmField
    public val getAgentRadiusName: MethodStringName0<NavigationPolygon, Float> =
        MethodStringName0<NavigationPolygon, Float>("get_agent_radius")

    @JvmField
    public val setBakingRectName: MethodStringName1<NavigationPolygon, Unit, Rect2> =
        MethodStringName1<NavigationPolygon, Unit, Rect2>("set_baking_rect")

    @JvmField
    public val getBakingRectName: MethodStringName0<NavigationPolygon, Rect2> =
        MethodStringName0<NavigationPolygon, Rect2>("get_baking_rect")

    @JvmField
    public val setBakingRectOffsetName: MethodStringName1<NavigationPolygon, Unit, Vector2> =
        MethodStringName1<NavigationPolygon, Unit, Vector2>("set_baking_rect_offset")

    @JvmField
    public val getBakingRectOffsetName: MethodStringName0<NavigationPolygon, Vector2> =
        MethodStringName0<NavigationPolygon, Vector2>("get_baking_rect_offset")

    @JvmField
    public val clearName: MethodStringName0<NavigationPolygon, Unit> =
        MethodStringName0<NavigationPolygon, Unit>("clear")
  }

  public object MethodBindings {
    internal val setVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_vertices", 1509147220)

    internal val getVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_vertices", 2961356807)

    internal val addPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "add_polygon", 3614634198)

    internal val getPolygonCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_polygon_count", 3905245786)

    internal val getPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_polygon", 3668444399)

    internal val clearPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "clear_polygons", 3218959716)

    internal val getNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_navigation_mesh", 330232164)

    internal val addOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "add_outline", 1509147220)

    internal val addOutlineAtIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "add_outline_at_index", 1569738947)

    internal val getOutlineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_outline_count", 3905245786)

    internal val setOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_outline", 1201971903)

    internal val getOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_outline", 3946907486)

    internal val removeOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "remove_outline", 1286410249)

    internal val clearOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "clear_outlines", 3218959716)

    internal val makePolygonsFromOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "make_polygons_from_outlines", 3218959716)

    internal val setCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_cell_size", 373806689)

    internal val getCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_cell_size", 1740695150)

    internal val setBorderSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_border_size", 373806689)

    internal val getBorderSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_border_size", 1740695150)

    internal val setSamplePartitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_sample_partition_type", 2441478482)

    internal val getSamplePartitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_sample_partition_type", 3887422851)

    internal val setParsedGeometryTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_parsed_geometry_type", 2507971764)

    internal val getParsedGeometryTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_parsed_geometry_type", 1073219508)

    internal val setParsedCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_parsed_collision_mask", 1286410249)

    internal val getParsedCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_parsed_collision_mask", 3905245786)

    internal val setParsedCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_parsed_collision_mask_value", 300928843)

    internal val getParsedCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_parsed_collision_mask_value", 1116898809)

    internal val setSourceGeometryModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_source_geometry_mode", 4002316705)

    internal val getSourceGeometryModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_source_geometry_mode", 459686762)

    internal val setSourceGeometryGroupNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_source_geometry_group_name", 3304788590)

    internal val getSourceGeometryGroupNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_source_geometry_group_name", 2002593661)

    internal val setAgentRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_agent_radius", 373806689)

    internal val getAgentRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_agent_radius", 1740695150)

    internal val setBakingRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_baking_rect", 2046264180)

    internal val getBakingRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_baking_rect", 1639390495)

    internal val setBakingRectOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "set_baking_rect_offset", 743155724)

    internal val getBakingRectOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "get_baking_rect_offset", 3341600327)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPolygon", "clear", 3218959716)
  }
}
