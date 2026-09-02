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
import godot.core.BitFieldBase
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR3
import godot.core.VariantParser._RID
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

public infix fun Long.or(other: NavigationPathQueryParameters3D.PathMetadataFlags): Long =
    this.or(other.flag)

public infix fun Long.xor(other: NavigationPathQueryParameters3D.PathMetadataFlags): Long =
    this.xor(other.flag)

public infix fun Long.and(other: NavigationPathQueryParameters3D.PathMetadataFlags): Long =
    this.and(other.flag)

/**
 * By changing various properties of this object, such as the start and target position, you can
 * configure path queries to the [NavigationServer3D].
 */
@GodotBaseType
public open class NavigationPathQueryParameters3D : RefCounted() {
  /**
   * The navigation map [RID] used in the path query.
   */
  public final inline var map: RID
    @JvmName("mapProperty")
    get() = getMap()
    @JvmName("mapProperty")
    set(`value`) {
      setMap(value)
    }

  /**
   * The pathfinding start position in global coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var startPosition: Vector3
    @JvmName("startPositionProperty")
    get() = getStartPosition()
    @JvmName("startPositionProperty")
    set(`value`) {
      setStartPosition(value)
    }

  /**
   * The pathfinding target position in global coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var targetPosition: Vector3
    @JvmName("targetPositionProperty")
    get() = getTargetPosition()
    @JvmName("targetPositionProperty")
    set(`value`) {
      setTargetPosition(value)
    }

  /**
   * The navigation layers the query will use (as a bitmask).
   */
  public final inline var navigationLayers: Long
    @JvmName("navigationLayersProperty")
    get() = getNavigationLayers()
    @JvmName("navigationLayersProperty")
    set(`value`) {
      setNavigationLayers(value)
    }

  /**
   * The pathfinding algorithm used in the path query.
   */
  public final inline var pathfindingAlgorithm: PathfindingAlgorithm
    @JvmName("pathfindingAlgorithmProperty")
    get() = getPathfindingAlgorithm()
    @JvmName("pathfindingAlgorithmProperty")
    set(`value`) {
      setPathfindingAlgorithm(value)
    }

  /**
   * The path postprocessing applied to the raw path corridor found by the [pathfindingAlgorithm].
   */
  public final inline var pathPostprocessing: PathPostProcessing
    @JvmName("pathPostprocessingProperty")
    get() = getPathPostprocessing()
    @JvmName("pathPostprocessingProperty")
    set(`value`) {
      setPathPostprocessing(value)
    }

  /**
   * Additional information to include with the navigation path.
   */
  public final inline var metadataFlags: PathMetadataFlags
    @JvmName("metadataFlagsProperty")
    get() = getMetadataFlags()
    @JvmName("metadataFlagsProperty")
    set(`value`) {
      setMetadataFlags(value)
    }

  /**
   * If `true` a simplified version of the path will be returned with less critical path points
   * removed. The simplification amount is controlled by [simplifyEpsilon]. The simplification uses a
   * variant of Ramer-Douglas-Peucker algorithm for curve point decimation.
   *
   * Path simplification can be helpful to mitigate various path following issues that can arise
   * with certain agent types and script behaviors. E.g. "steering" agents or avoidance in "open
   * fields".
   */
  public final inline var simplifyPath: Boolean
    @JvmName("simplifyPathProperty")
    get() = getSimplifyPath()
    @JvmName("simplifyPathProperty")
    set(`value`) {
      setSimplifyPath(value)
    }

  /**
   * The path simplification amount in worlds units.
   */
  public final inline var simplifyEpsilon: Float
    @JvmName("simplifyEpsilonProperty")
    get() = getSimplifyEpsilon()
    @JvmName("simplifyEpsilonProperty")
    set(`value`) {
      setSimplifyEpsilon(value)
    }

  /**
   * The list of region [RID]s that will be excluded from the path query. Use
   * [NavigationRegion3D.getRid] to get the [RID] associated with a [NavigationRegion3D] node.
   *
   * **Note:** The returned array is copied and any changes to it will not update the original
   * property value. To update the value you need to modify the returned array, and then set it to the
   * property again.
   */
  public final inline var excludedRegions: VariantArray<RID>
    @JvmName("excludedRegionsProperty")
    get() = getExcludedRegions()
    @JvmName("excludedRegionsProperty")
    set(`value`) {
      setExcludedRegions(value)
    }

  /**
   * The list of region [RID]s that will be included by the path query. Use
   * [NavigationRegion3D.getRid] to get the [RID] associated with a [NavigationRegion3D] node. If left
   * empty all regions are included. If a region ends up being both included and excluded at the same
   * time it will be excluded.
   *
   * **Note:** The returned array is copied and any changes to it will not update the original
   * property value. To update the value you need to modify the returned array, and then set it to the
   * property again.
   */
  public final inline var includedRegions: VariantArray<RID>
    @JvmName("includedRegionsProperty")
    get() = getIncludedRegions()
    @JvmName("includedRegionsProperty")
    set(`value`) {
      setIncludedRegions(value)
    }

  /**
   * The maximum allowed length of the returned path in world units. A path will be clipped when
   * going over this length. A value of `0` or below counts as disabled.
   */
  public final inline var pathReturnMaxLength: Float
    @JvmName("pathReturnMaxLengthProperty")
    get() = getPathReturnMaxLength()
    @JvmName("pathReturnMaxLengthProperty")
    set(`value`) {
      setPathReturnMaxLength(value)
    }

  /**
   * The maximum allowed radius in world units that the returned path can be from the path start.
   * The path will be clipped when going over this radius. A value of `0` or below counts as disabled.
   *
   * **Note:** This will perform a sphere shaped clip operation on the path with the first path
   * position being the sphere's center position.
   */
  public final inline var pathReturnMaxRadius: Float
    @JvmName("pathReturnMaxRadiusProperty")
    get() = getPathReturnMaxRadius()
    @JvmName("pathReturnMaxRadiusProperty")
    set(`value`) {
      setPathReturnMaxRadius(value)
    }

  /**
   * The maximum number of polygons that are searched before the pathfinding cancels the search for
   * a path to the (possibly unreachable or very far away) target position polygon. In this case the
   * pathfinding resets and builds a path from the start polygon to the polygon that was found closest
   * to the target position so far. A value of `0` or below counts as unlimited. In case of unlimited
   * the pathfinding will search all polygons connected with the start polygon until either the target
   * position polygon is found or all available polygon search options are exhausted.
   */
  public final inline var pathSearchMaxPolygons: Int
    @JvmName("pathSearchMaxPolygonsProperty")
    get() = getPathSearchMaxPolygons()
    @JvmName("pathSearchMaxPolygonsProperty")
    set(`value`) {
      setPathSearchMaxPolygons(value)
    }

  /**
   * The maximum distance a searched polygon can be away from the start polygon before the
   * pathfinding cancels the search for a path to the (possibly unreachable or very far away) target
   * position polygon. In this case the pathfinding resets and builds a path from the start polygon to
   * the polygon that was found closest to the target position so far. A value of `0` or below counts
   * as unlimited. In case of unlimited the pathfinding will search all polygons connected with the
   * start polygon until either the target position polygon is found or all available polygon search
   * options are exhausted.
   */
  public final inline var pathSearchMaxDistance: Float
    @JvmName("pathSearchMaxDistanceProperty")
    get() = getPathSearchMaxDistance()
    @JvmName("pathSearchMaxDistanceProperty")
    set(`value`) {
      setPathSearchMaxDistance(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(410, scriptPtr)
  }

  /**
   * This is a helper function for [startPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpathqueryparameters3d.startPosition
   * //Your changes
   * navigationpathqueryparameters3d.startPosition = myCoreType
   * ``````
   *
   * The pathfinding start position in global coordinates.
   */
  @CoreTypeHelper
  public final fun startPositionMutate(block: Vector3.() -> Unit): Vector3 = startPosition.apply {
     block(this)
     startPosition = this
  }

  /**
   * This is a helper function for [targetPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpathqueryparameters3d.targetPosition
   * //Your changes
   * navigationpathqueryparameters3d.targetPosition = myCoreType
   * ``````
   *
   * The pathfinding target position in global coordinates.
   */
  @CoreTypeHelper
  public final fun targetPositionMutate(block: Vector3.() -> Unit): Vector3 = targetPosition.apply {
     block(this)
     targetPosition = this
  }

  public final fun setPathfindingAlgorithm(pathfindingAlgorithm: PathfindingAlgorithm): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pathfindingAlgorithm.value)
    TransferContext.callMethod(MethodBindings.setPathfindingAlgorithmPtr)
  }

  public final fun getPathfindingAlgorithm(): PathfindingAlgorithm {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathfindingAlgorithmPtr)
    return PathfindingAlgorithm.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setPathPostprocessing(pathPostprocessing: PathPostProcessing): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pathPostprocessing.value)
    TransferContext.callMethod(MethodBindings.setPathPostprocessingPtr)
  }

  public final fun getPathPostprocessing(): PathPostProcessing {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathPostprocessingPtr)
    return PathPostProcessing.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMap(map: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to map)
    TransferContext.callMethod(MethodBindings.setMapPtr)
  }

  public final fun getMap(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMapPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setStartPosition(startPosition: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to startPosition)
    TransferContext.callMethod(MethodBindings.setStartPositionPtr)
  }

  public final fun getStartPosition(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStartPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setTargetPosition(targetPosition: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to targetPosition)
    TransferContext.callMethod(MethodBindings.setTargetPositionPtr)
  }

  public final fun getTargetPosition(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setNavigationLayers(navigationLayers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to navigationLayers)
    TransferContext.callMethod(MethodBindings.setNavigationLayersPtr)
  }

  public final fun getNavigationLayers(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMetadataFlags(flags: PathMetadataFlags): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flags.flag)
    TransferContext.callMethod(MethodBindings.setMetadataFlagsPtr)
  }

  public final fun getMetadataFlags(): PathMetadataFlags {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMetadataFlagsPtr)
    return PathMetadataFlags(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSimplifyPath(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSimplifyPathPtr)
  }

  public final fun getSimplifyPath(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSimplifyPathPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSimplifyEpsilon(epsilon: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to epsilon.toDouble())
    TransferContext.callMethod(MethodBindings.setSimplifyEpsilonPtr)
  }

  public final fun getSimplifyEpsilon(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSimplifyEpsilonPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setIncludedRegions(regions: VariantArray<RID>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to regions)
    TransferContext.callMethod(MethodBindings.setIncludedRegionsPtr)
  }

  public final fun getIncludedRegions(): VariantArray<RID> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIncludedRegionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<RID>)
  }

  public final fun setExcludedRegions(regions: VariantArray<RID>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to regions)
    TransferContext.callMethod(MethodBindings.setExcludedRegionsPtr)
  }

  public final fun getExcludedRegions(): VariantArray<RID> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludedRegionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<RID>)
  }

  public final fun setPathReturnMaxLength(length: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.setPathReturnMaxLengthPtr)
  }

  public final fun getPathReturnMaxLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathReturnMaxLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPathReturnMaxRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setPathReturnMaxRadiusPtr)
  }

  public final fun getPathReturnMaxRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathReturnMaxRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPathSearchMaxPolygons(maxPolygons: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxPolygons.toLong())
    TransferContext.callMethod(MethodBindings.setPathSearchMaxPolygonsPtr)
  }

  public final fun getPathSearchMaxPolygons(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathSearchMaxPolygonsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPathSearchMaxDistance(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setPathSearchMaxDistancePtr)
  }

  public final fun getPathSearchMaxDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathSearchMaxDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public enum class PathfindingAlgorithm(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The path query uses the default A* pathfinding algorithm.
     */
    ASTAR(0),
    ;

    public companion object {
      public fun from(`value`: Long): PathfindingAlgorithm =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class PathPostProcessing(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Applies a funnel algorithm to the raw path corridor found by the pathfinding algorithm. This
     * will result in the shortest path possible inside the path corridor. This postprocessing very
     * much depends on the navigation mesh polygon layout and the created corridor. Especially tile- or
     * gridbased layouts can face artificial corners with diagonal movement due to a jagged path
     * corridor imposed by the cell shapes.
     */
    POSTPROCESSING_CORRIDORFUNNEL(0),
    /**
     * Centers every path position in the middle of the traveled navigation mesh polygon edge. This
     * creates better paths for tile- or gridbased layouts that restrict the movement to the cells
     * center.
     */
    POSTPROCESSING_EDGECENTERED(1),
    /**
     * Applies no postprocessing and returns the raw path corridor as found by the pathfinding
     * algorithm.
     */
    POSTPROCESSING_NONE(2),
    ;

    public companion object {
      public fun from(`value`: Long): PathPostProcessing = entries.single { it.`value` == `value` }
    }
  }

  public class PathMetadataFlags(
    flag: Long,
  ) : BitFieldBase<PathMetadataFlags>(flag) {
    protected override fun wrap(flag: Long): PathMetadataFlags = PathMetadataFlags(flag)

    public companion object {
      /**
       * Don't include any additional metadata about the returned path.
       */
      @JvmField
      public val INCLUDE_NONE: PathMetadataFlags = PathMetadataFlags(0)

      /**
       * Include the type of navigation primitive (region or link) that each point of the path goes
       * through.
       */
      @JvmField
      public val INCLUDE_TYPES: PathMetadataFlags = PathMetadataFlags(1)

      /**
       * Include the [RID]s of the regions and links that each point of the path goes through.
       */
      @JvmField
      public val INCLUDE_RIDS: PathMetadataFlags = PathMetadataFlags(2)

      /**
       * Include the `ObjectID`s of the [Object]s which manage the regions and links each point of
       * the path goes through.
       */
      @JvmField
      public val INCLUDE_OWNERS: PathMetadataFlags = PathMetadataFlags(4)

      /**
       * Include all available metadata about the returned path.
       */
      @JvmField
      public val INCLUDE_ALL: PathMetadataFlags = PathMetadataFlags(7)
    }
  }

  public companion object {
    @JvmField
    public val setPathfindingAlgorithmName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, PathfindingAlgorithm> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, PathfindingAlgorithm>("set_pathfinding_algorithm")

    @JvmField
    public val getPathfindingAlgorithmName:
        MethodStringName0<NavigationPathQueryParameters3D, PathfindingAlgorithm> =
        MethodStringName0<NavigationPathQueryParameters3D, PathfindingAlgorithm>("get_pathfinding_algorithm")

    @JvmField
    public val setPathPostprocessingName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, PathPostProcessing> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, PathPostProcessing>("set_path_postprocessing")

    @JvmField
    public val getPathPostprocessingName:
        MethodStringName0<NavigationPathQueryParameters3D, PathPostProcessing> =
        MethodStringName0<NavigationPathQueryParameters3D, PathPostProcessing>("get_path_postprocessing")

    @JvmField
    public val setMapName: MethodStringName1<NavigationPathQueryParameters3D, Unit, RID> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, RID>("set_map")

    @JvmField
    public val getMapName: MethodStringName0<NavigationPathQueryParameters3D, RID> =
        MethodStringName0<NavigationPathQueryParameters3D, RID>("get_map")

    @JvmField
    public val setStartPositionName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Vector3> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Vector3>("set_start_position")

    @JvmField
    public val getStartPositionName: MethodStringName0<NavigationPathQueryParameters3D, Vector3> =
        MethodStringName0<NavigationPathQueryParameters3D, Vector3>("get_start_position")

    @JvmField
    public val setTargetPositionName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Vector3> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Vector3>("set_target_position")

    @JvmField
    public val getTargetPositionName: MethodStringName0<NavigationPathQueryParameters3D, Vector3> =
        MethodStringName0<NavigationPathQueryParameters3D, Vector3>("get_target_position")

    @JvmField
    public val setNavigationLayersName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Long> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Long>("set_navigation_layers")

    @JvmField
    public val getNavigationLayersName: MethodStringName0<NavigationPathQueryParameters3D, Long> =
        MethodStringName0<NavigationPathQueryParameters3D, Long>("get_navigation_layers")

    @JvmField
    public val setMetadataFlagsName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, PathMetadataFlags> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, PathMetadataFlags>("set_metadata_flags")

    @JvmField
    public val getMetadataFlagsName:
        MethodStringName0<NavigationPathQueryParameters3D, PathMetadataFlags> =
        MethodStringName0<NavigationPathQueryParameters3D, PathMetadataFlags>("get_metadata_flags")

    @JvmField
    public val setSimplifyPathName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Boolean> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Boolean>("set_simplify_path")

    @JvmField
    public val getSimplifyPathName: MethodStringName0<NavigationPathQueryParameters3D, Boolean> =
        MethodStringName0<NavigationPathQueryParameters3D, Boolean>("get_simplify_path")

    @JvmField
    public val setSimplifyEpsilonName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float>("set_simplify_epsilon")

    @JvmField
    public val getSimplifyEpsilonName: MethodStringName0<NavigationPathQueryParameters3D, Float> =
        MethodStringName0<NavigationPathQueryParameters3D, Float>("get_simplify_epsilon")

    @JvmField
    public val setIncludedRegionsName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, VariantArray<RID>> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, VariantArray<RID>>("set_included_regions")

    @JvmField
    public val getIncludedRegionsName:
        MethodStringName0<NavigationPathQueryParameters3D, VariantArray<RID>> =
        MethodStringName0<NavigationPathQueryParameters3D, VariantArray<RID>>("get_included_regions")

    @JvmField
    public val setExcludedRegionsName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, VariantArray<RID>> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, VariantArray<RID>>("set_excluded_regions")

    @JvmField
    public val getExcludedRegionsName:
        MethodStringName0<NavigationPathQueryParameters3D, VariantArray<RID>> =
        MethodStringName0<NavigationPathQueryParameters3D, VariantArray<RID>>("get_excluded_regions")

    @JvmField
    public val setPathReturnMaxLengthName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float>("set_path_return_max_length")

    @JvmField
    public val getPathReturnMaxLengthName: MethodStringName0<NavigationPathQueryParameters3D, Float>
        = MethodStringName0<NavigationPathQueryParameters3D, Float>("get_path_return_max_length")

    @JvmField
    public val setPathReturnMaxRadiusName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float>("set_path_return_max_radius")

    @JvmField
    public val getPathReturnMaxRadiusName: MethodStringName0<NavigationPathQueryParameters3D, Float>
        = MethodStringName0<NavigationPathQueryParameters3D, Float>("get_path_return_max_radius")

    @JvmField
    public val setPathSearchMaxPolygonsName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Int> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Int>("set_path_search_max_polygons")

    @JvmField
    public val getPathSearchMaxPolygonsName: MethodStringName0<NavigationPathQueryParameters3D, Int>
        = MethodStringName0<NavigationPathQueryParameters3D, Int>("get_path_search_max_polygons")

    @JvmField
    public val setPathSearchMaxDistanceName:
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float> =
        MethodStringName1<NavigationPathQueryParameters3D, Unit, Float>("set_path_search_max_distance")

    @JvmField
    public val getPathSearchMaxDistanceName:
        MethodStringName0<NavigationPathQueryParameters3D, Float> =
        MethodStringName0<NavigationPathQueryParameters3D, Float>("get_path_search_max_distance")
  }

  public object MethodBindings {
    internal val setPathfindingAlgorithmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_pathfinding_algorithm", 394560454)

    internal val getPathfindingAlgorithmPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_pathfinding_algorithm", 3398491350)

    internal val setPathPostprocessingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_path_postprocessing", 2267362344)

    internal val getPathPostprocessingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_path_postprocessing", 3883858360)

    internal val setMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_map", 2722037293)

    internal val getMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_map", 2944877500)

    internal val setStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_start_position", 3460891852)

    internal val getStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_start_position", 3360562783)

    internal val setTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_target_position", 3460891852)

    internal val getTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_target_position", 3360562783)

    internal val setNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_navigation_layers", 1286410249)

    internal val getNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_navigation_layers", 3905245786)

    internal val setMetadataFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_metadata_flags", 2713846708)

    internal val getMetadataFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_metadata_flags", 1582332802)

    internal val setSimplifyPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_simplify_path", 2586408642)

    internal val getSimplifyPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_simplify_path", 36873697)

    internal val setSimplifyEpsilonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_simplify_epsilon", 373806689)

    internal val getSimplifyEpsilonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_simplify_epsilon", 1740695150)

    internal val setIncludedRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_included_regions", 381264803)

    internal val getIncludedRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_included_regions", 3995934104)

    internal val setExcludedRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_excluded_regions", 381264803)

    internal val getExcludedRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_excluded_regions", 3995934104)

    internal val setPathReturnMaxLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_path_return_max_length", 373806689)

    internal val getPathReturnMaxLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_path_return_max_length", 1740695150)

    internal val setPathReturnMaxRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_path_return_max_radius", 373806689)

    internal val getPathReturnMaxRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_path_return_max_radius", 1740695150)

    internal val setPathSearchMaxPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_path_search_max_polygons", 1286410249)

    internal val getPathSearchMaxPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_path_search_max_polygons", 3905245786)

    internal val setPathSearchMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "set_path_search_max_distance", 373806689)

    internal val getPathSearchMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryParameters3D", "get_path_search_max_distance", 1740695150)
  }
}
