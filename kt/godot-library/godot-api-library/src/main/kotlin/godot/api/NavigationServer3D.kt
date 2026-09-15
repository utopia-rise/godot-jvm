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
import godot.core.AABB
import godot.core.Callable
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedVector3Array
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantCallable
import godot.core.Vector3
import godot.readReturnValue_AABB
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_VECTOR3_ARRAY
import godot.readReturnValue_RID
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_OBJECT_OBJECT
import godot.writeMethodArguments_OBJECT_OBJECT_CALLABLE
import godot.writeMethodArguments_OBJECT_OBJECT_OBJECT_CALLABLE
import godot.writeMethodArguments_PACKED_VECTOR3_ARRAY_DOUBLE
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_RID_BOOL
import godot.writeMethodArguments_RID_CALLABLE
import godot.writeMethodArguments_RID_DOUBLE
import godot.writeMethodArguments_RID_LONG
import godot.writeMethodArguments_RID_LONG_BOOL
import godot.writeMethodArguments_RID_OBJECT
import godot.writeMethodArguments_RID_PACKED_VECTOR3_ARRAY
import godot.writeMethodArguments_RID_RID
import godot.writeMethodArguments_RID_TRANSFORM3D
import godot.writeMethodArguments_RID_VECTOR3
import godot.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL
import godot.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * NavigationServer3D is the server that handles navigation maps, regions and agents. It does not
 * handle A* navigation from [AStar3D].
 *
 * Maps are divided into regions, which are composed of navigation meshes. Together, they define the
 * navigable areas in the 3D world.
 *
 * **Note:** Most [NavigationServer3D] changes take effect after the next physics frame and not
 * immediately. This includes all changes made to maps, regions or agents by navigation-related nodes
 * in the scene tree or made through scripts.
 *
 * For two regions to be connected to each other, they must share a similar edge. An edge is
 * considered connected to another if both of its two vertices are at a distance less than
 * `edge_connection_margin` to the respective other edge's vertex.
 *
 * You may assign navigation layers to regions with [NavigationServer3D.regionSetNavigationLayers],
 * which then can be checked upon when requesting a path with [NavigationServer3D.mapGetPath]. This can
 * be used to allow or deny certain areas for some objects.
 *
 * To use the collision avoidance system, you may use agents. You can set an agent's target
 * velocity, then the servers will emit a callback with a modified velocity.
 *
 * **Note:** The collision avoidance system ignores regions. Using the modified velocity directly
 * may move an agent outside of the traversable area. This is a limitation of the collision avoidance
 * system, any more complex situation may require the use of the physics engine.
 *
 * This server keeps tracks of any call and executes them during the sync phase. This means that you
 * can request any change to the map, using any thread, without worrying.
 */
@GodotBaseType
public object NavigationServer3D : Object() {
  @JvmField
  public val getMapsName: MethodStringName0<NavigationServer3D, VariantArray<RID>> =
      MethodStringName0<NavigationServer3D, VariantArray<RID>>("get_maps")

  @JvmField
  public val mapCreateName: MethodStringName0<NavigationServer3D, RID> =
      MethodStringName0<NavigationServer3D, RID>("map_create")

  @JvmField
  public val mapSetActiveName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("map_set_active")

  @JvmField
  public val mapIsActiveName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("map_is_active")

  @JvmField
  public val mapSetUpName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("map_set_up")

  @JvmField
  public val mapGetUpName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("map_get_up")

  @JvmField
  public val mapSetCellSizeName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("map_set_cell_size")

  @JvmField
  public val mapGetCellSizeName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("map_get_cell_size")

  @JvmField
  public val mapSetCellHeightName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("map_set_cell_height")

  @JvmField
  public val mapGetCellHeightName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("map_get_cell_height")

  @JvmField
  public val mapSetMergeRasterizerCellScaleName:
      MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("map_set_merge_rasterizer_cell_scale")

  @JvmField
  public val mapGetMergeRasterizerCellScaleName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("map_get_merge_rasterizer_cell_scale")

  @JvmField
  public val mapSetUseEdgeConnectionsName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean>
      = MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("map_set_use_edge_connections")

  @JvmField
  public val mapGetUseEdgeConnectionsName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("map_get_use_edge_connections")

  @JvmField
  public val mapSetEdgeConnectionMarginName: MethodStringName2<NavigationServer3D, Unit, RID, Float>
      = MethodStringName2<NavigationServer3D, Unit, RID, Float>("map_set_edge_connection_margin")

  @JvmField
  public val mapGetEdgeConnectionMarginName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("map_get_edge_connection_margin")

  @JvmField
  public val mapSetLinkConnectionRadiusName: MethodStringName2<NavigationServer3D, Unit, RID, Float>
      = MethodStringName2<NavigationServer3D, Unit, RID, Float>("map_set_link_connection_radius")

  @JvmField
  public val mapGetLinkConnectionRadiusName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("map_get_link_connection_radius")

  @JvmField
  public val mapGetPathName:
      MethodStringName5<NavigationServer3D, PackedVector3Array, RID, Vector3, Vector3, Boolean, Long>
      =
      MethodStringName5<NavigationServer3D, PackedVector3Array, RID, Vector3, Vector3, Boolean, Long>("map_get_path")

  @JvmField
  public val mapGetClosestPointToSegmentName:
      MethodStringName4<NavigationServer3D, Vector3, RID, Vector3, Vector3, Boolean> =
      MethodStringName4<NavigationServer3D, Vector3, RID, Vector3, Vector3, Boolean>("map_get_closest_point_to_segment")

  @JvmField
  public val mapGetClosestPointName: MethodStringName2<NavigationServer3D, Vector3, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Vector3, RID, Vector3>("map_get_closest_point")

  @JvmField
  public val mapGetClosestPointNormalName:
      MethodStringName2<NavigationServer3D, Vector3, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Vector3, RID, Vector3>("map_get_closest_point_normal")

  @JvmField
  public val mapGetClosestPointOwnerName: MethodStringName2<NavigationServer3D, RID, RID, Vector3> =
      MethodStringName2<NavigationServer3D, RID, RID, Vector3>("map_get_closest_point_owner")

  @JvmField
  public val mapGetLinksName: MethodStringName1<NavigationServer3D, VariantArray<RID>, RID> =
      MethodStringName1<NavigationServer3D, VariantArray<RID>, RID>("map_get_links")

  @JvmField
  public val mapGetRegionsName: MethodStringName1<NavigationServer3D, VariantArray<RID>, RID> =
      MethodStringName1<NavigationServer3D, VariantArray<RID>, RID>("map_get_regions")

  @JvmField
  public val mapGetAgentsName: MethodStringName1<NavigationServer3D, VariantArray<RID>, RID> =
      MethodStringName1<NavigationServer3D, VariantArray<RID>, RID>("map_get_agents")

  @JvmField
  public val mapGetObstaclesName: MethodStringName1<NavigationServer3D, VariantArray<RID>, RID> =
      MethodStringName1<NavigationServer3D, VariantArray<RID>, RID>("map_get_obstacles")

  @JvmField
  public val mapForceUpdateName: MethodStringName1<NavigationServer3D, Unit, RID> =
      MethodStringName1<NavigationServer3D, Unit, RID>("map_force_update")

  @JvmField
  public val mapGetIterationIdName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("map_get_iteration_id")

  @JvmField
  public val mapSetUseAsyncIterationsName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean>
      = MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("map_set_use_async_iterations")

  @JvmField
  public val mapGetUseAsyncIterationsName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("map_get_use_async_iterations")

  @JvmField
  public val mapGetRandomPointName:
      MethodStringName3<NavigationServer3D, Vector3, RID, Long, Boolean> =
      MethodStringName3<NavigationServer3D, Vector3, RID, Long, Boolean>("map_get_random_point")

  @JvmField
  public val queryPathName:
      MethodStringName3<NavigationServer3D, Unit, NavigationPathQueryParameters3D?, NavigationPathQueryResult3D?, Callable>
      =
      MethodStringName3<NavigationServer3D, Unit, NavigationPathQueryParameters3D?, NavigationPathQueryResult3D?, Callable>("query_path")

  @JvmField
  public val regionCreateName: MethodStringName0<NavigationServer3D, RID> =
      MethodStringName0<NavigationServer3D, RID>("region_create")

  @JvmField
  public val regionGetIterationIdName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("region_get_iteration_id")

  @JvmField
  public val regionSetUseAsyncIterationsName:
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("region_set_use_async_iterations")

  @JvmField
  public val regionGetUseAsyncIterationsName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("region_get_use_async_iterations")

  @JvmField
  public val regionSetEnabledName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("region_set_enabled")

  @JvmField
  public val regionGetEnabledName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("region_get_enabled")

  @JvmField
  public val regionSetUseEdgeConnectionsName:
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("region_set_use_edge_connections")

  @JvmField
  public val regionGetUseEdgeConnectionsName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("region_get_use_edge_connections")

  @JvmField
  public val regionSetEnterCostName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("region_set_enter_cost")

  @JvmField
  public val regionGetEnterCostName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("region_get_enter_cost")

  @JvmField
  public val regionSetTravelCostName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("region_set_travel_cost")

  @JvmField
  public val regionGetTravelCostName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("region_get_travel_cost")

  @JvmField
  public val regionSetOwnerIdName: MethodStringName2<NavigationServer3D, Unit, RID, Long> =
      MethodStringName2<NavigationServer3D, Unit, RID, Long>("region_set_owner_id")

  @JvmField
  public val regionGetOwnerIdName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("region_get_owner_id")

  @JvmField
  public val regionOwnsPointName: MethodStringName2<NavigationServer3D, Boolean, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Boolean, RID, Vector3>("region_owns_point")

  @JvmField
  public val regionSetMapName: MethodStringName2<NavigationServer3D, Unit, RID, RID> =
      MethodStringName2<NavigationServer3D, Unit, RID, RID>("region_set_map")

  @JvmField
  public val regionGetMapName: MethodStringName1<NavigationServer3D, RID, RID> =
      MethodStringName1<NavigationServer3D, RID, RID>("region_get_map")

  @JvmField
  public val regionSetNavigationLayersName: MethodStringName2<NavigationServer3D, Unit, RID, Long> =
      MethodStringName2<NavigationServer3D, Unit, RID, Long>("region_set_navigation_layers")

  @JvmField
  public val regionGetNavigationLayersName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("region_get_navigation_layers")

  @JvmField
  public val regionSetTransformName: MethodStringName2<NavigationServer3D, Unit, RID, Transform3D> =
      MethodStringName2<NavigationServer3D, Unit, RID, Transform3D>("region_set_transform")

  @JvmField
  public val regionGetTransformName: MethodStringName1<NavigationServer3D, Transform3D, RID> =
      MethodStringName1<NavigationServer3D, Transform3D, RID>("region_get_transform")

  @JvmField
  public val regionSetNavigationMeshName:
      MethodStringName2<NavigationServer3D, Unit, RID, NavigationMesh?> =
      MethodStringName2<NavigationServer3D, Unit, RID, NavigationMesh?>("region_set_navigation_mesh")

  @JvmField
  public val regionBakeNavigationMeshName:
      MethodStringName2<NavigationServer3D, Unit, NavigationMesh?, Node?> =
      MethodStringName2<NavigationServer3D, Unit, NavigationMesh?, Node?>("region_bake_navigation_mesh")

  @JvmField
  public val regionGetConnectionsCountName: MethodStringName1<NavigationServer3D, Int, RID> =
      MethodStringName1<NavigationServer3D, Int, RID>("region_get_connections_count")

  @JvmField
  public val regionGetConnectionPathwayStartName:
      MethodStringName2<NavigationServer3D, Vector3, RID, Int> =
      MethodStringName2<NavigationServer3D, Vector3, RID, Int>("region_get_connection_pathway_start")

  @JvmField
  public val regionGetConnectionPathwayEndName:
      MethodStringName2<NavigationServer3D, Vector3, RID, Int> =
      MethodStringName2<NavigationServer3D, Vector3, RID, Int>("region_get_connection_pathway_end")

  @JvmField
  public val regionGetClosestPointToSegmentName:
      MethodStringName4<NavigationServer3D, Vector3, RID, Vector3, Vector3, Boolean> =
      MethodStringName4<NavigationServer3D, Vector3, RID, Vector3, Vector3, Boolean>("region_get_closest_point_to_segment")

  @JvmField
  public val regionGetClosestPointName: MethodStringName2<NavigationServer3D, Vector3, RID, Vector3>
      = MethodStringName2<NavigationServer3D, Vector3, RID, Vector3>("region_get_closest_point")

  @JvmField
  public val regionGetClosestPointNormalName:
      MethodStringName2<NavigationServer3D, Vector3, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Vector3, RID, Vector3>("region_get_closest_point_normal")

  @JvmField
  public val regionGetRandomPointName:
      MethodStringName3<NavigationServer3D, Vector3, RID, Long, Boolean> =
      MethodStringName3<NavigationServer3D, Vector3, RID, Long, Boolean>("region_get_random_point")

  @JvmField
  public val regionGetBoundsName: MethodStringName1<NavigationServer3D, AABB, RID> =
      MethodStringName1<NavigationServer3D, AABB, RID>("region_get_bounds")

  @JvmField
  public val linkCreateName: MethodStringName0<NavigationServer3D, RID> =
      MethodStringName0<NavigationServer3D, RID>("link_create")

  @JvmField
  public val linkGetIterationIdName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("link_get_iteration_id")

  @JvmField
  public val linkSetMapName: MethodStringName2<NavigationServer3D, Unit, RID, RID> =
      MethodStringName2<NavigationServer3D, Unit, RID, RID>("link_set_map")

  @JvmField
  public val linkGetMapName: MethodStringName1<NavigationServer3D, RID, RID> =
      MethodStringName1<NavigationServer3D, RID, RID>("link_get_map")

  @JvmField
  public val linkSetEnabledName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("link_set_enabled")

  @JvmField
  public val linkGetEnabledName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("link_get_enabled")

  @JvmField
  public val linkSetBidirectionalName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("link_set_bidirectional")

  @JvmField
  public val linkIsBidirectionalName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("link_is_bidirectional")

  @JvmField
  public val linkSetNavigationLayersName: MethodStringName2<NavigationServer3D, Unit, RID, Long> =
      MethodStringName2<NavigationServer3D, Unit, RID, Long>("link_set_navigation_layers")

  @JvmField
  public val linkGetNavigationLayersName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("link_get_navigation_layers")

  @JvmField
  public val linkSetStartPositionName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("link_set_start_position")

  @JvmField
  public val linkGetStartPositionName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("link_get_start_position")

  @JvmField
  public val linkSetEndPositionName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("link_set_end_position")

  @JvmField
  public val linkGetEndPositionName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("link_get_end_position")

  @JvmField
  public val linkSetEnterCostName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("link_set_enter_cost")

  @JvmField
  public val linkGetEnterCostName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("link_get_enter_cost")

  @JvmField
  public val linkSetTravelCostName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("link_set_travel_cost")

  @JvmField
  public val linkGetTravelCostName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("link_get_travel_cost")

  @JvmField
  public val linkSetOwnerIdName: MethodStringName2<NavigationServer3D, Unit, RID, Long> =
      MethodStringName2<NavigationServer3D, Unit, RID, Long>("link_set_owner_id")

  @JvmField
  public val linkGetOwnerIdName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("link_get_owner_id")

  @JvmField
  public val agentCreateName: MethodStringName0<NavigationServer3D, RID> =
      MethodStringName0<NavigationServer3D, RID>("agent_create")

  @JvmField
  public val agentSetAvoidanceEnabledName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean>
      = MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("agent_set_avoidance_enabled")

  @JvmField
  public val agentGetAvoidanceEnabledName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("agent_get_avoidance_enabled")

  @JvmField
  public val agentSetUse3dAvoidanceName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("agent_set_use_3d_avoidance")

  @JvmField
  public val agentGetUse3dAvoidanceName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("agent_get_use_3d_avoidance")

  @JvmField
  public val agentSetMapName: MethodStringName2<NavigationServer3D, Unit, RID, RID> =
      MethodStringName2<NavigationServer3D, Unit, RID, RID>("agent_set_map")

  @JvmField
  public val agentGetMapName: MethodStringName1<NavigationServer3D, RID, RID> =
      MethodStringName1<NavigationServer3D, RID, RID>("agent_get_map")

  @JvmField
  public val agentSetPausedName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("agent_set_paused")

  @JvmField
  public val agentGetPausedName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("agent_get_paused")

  @JvmField
  public val agentSetNeighborDistanceName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_neighbor_distance")

  @JvmField
  public val agentGetNeighborDistanceName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_neighbor_distance")

  @JvmField
  public val agentSetMaxNeighborsName: MethodStringName2<NavigationServer3D, Unit, RID, Int> =
      MethodStringName2<NavigationServer3D, Unit, RID, Int>("agent_set_max_neighbors")

  @JvmField
  public val agentGetMaxNeighborsName: MethodStringName1<NavigationServer3D, Int, RID> =
      MethodStringName1<NavigationServer3D, Int, RID>("agent_get_max_neighbors")

  @JvmField
  public val agentSetTimeHorizonAgentsName: MethodStringName2<NavigationServer3D, Unit, RID, Float>
      = MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_time_horizon_agents")

  @JvmField
  public val agentGetTimeHorizonAgentsName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_time_horizon_agents")

  @JvmField
  public val agentSetTimeHorizonObstaclesName:
      MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_time_horizon_obstacles")

  @JvmField
  public val agentGetTimeHorizonObstaclesName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_time_horizon_obstacles")

  @JvmField
  public val agentSetRadiusName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_radius")

  @JvmField
  public val agentGetRadiusName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_radius")

  @JvmField
  public val agentSetHeightName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_height")

  @JvmField
  public val agentGetHeightName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_height")

  @JvmField
  public val agentSetMaxSpeedName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_max_speed")

  @JvmField
  public val agentGetMaxSpeedName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_max_speed")

  @JvmField
  public val agentSetVelocityForcedName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("agent_set_velocity_forced")

  @JvmField
  public val agentSetVelocityName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("agent_set_velocity")

  @JvmField
  public val agentGetVelocityName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("agent_get_velocity")

  @JvmField
  public val agentSetPositionName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("agent_set_position")

  @JvmField
  public val agentGetPositionName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("agent_get_position")

  @JvmField
  public val agentIsMapChangedName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("agent_is_map_changed")

  @JvmField
  public val agentSetAvoidanceCallbackName:
      MethodStringName2<NavigationServer3D, Unit, RID, Callable> =
      MethodStringName2<NavigationServer3D, Unit, RID, Callable>("agent_set_avoidance_callback")

  @JvmField
  public val agentHasAvoidanceCallbackName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("agent_has_avoidance_callback")

  @JvmField
  public val agentSetAvoidanceLayersName: MethodStringName2<NavigationServer3D, Unit, RID, Long> =
      MethodStringName2<NavigationServer3D, Unit, RID, Long>("agent_set_avoidance_layers")

  @JvmField
  public val agentGetAvoidanceLayersName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("agent_get_avoidance_layers")

  @JvmField
  public val agentSetAvoidanceMaskName: MethodStringName2<NavigationServer3D, Unit, RID, Long> =
      MethodStringName2<NavigationServer3D, Unit, RID, Long>("agent_set_avoidance_mask")

  @JvmField
  public val agentGetAvoidanceMaskName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("agent_get_avoidance_mask")

  @JvmField
  public val agentSetAvoidancePriorityName: MethodStringName2<NavigationServer3D, Unit, RID, Float>
      = MethodStringName2<NavigationServer3D, Unit, RID, Float>("agent_set_avoidance_priority")

  @JvmField
  public val agentGetAvoidancePriorityName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("agent_get_avoidance_priority")

  @JvmField
  public val obstacleCreateName: MethodStringName0<NavigationServer3D, RID> =
      MethodStringName0<NavigationServer3D, RID>("obstacle_create")

  @JvmField
  public val obstacleSetAvoidanceEnabledName:
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("obstacle_set_avoidance_enabled")

  @JvmField
  public val obstacleGetAvoidanceEnabledName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("obstacle_get_avoidance_enabled")

  @JvmField
  public val obstacleSetUse3dAvoidanceName:
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("obstacle_set_use_3d_avoidance")

  @JvmField
  public val obstacleGetUse3dAvoidanceName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("obstacle_get_use_3d_avoidance")

  @JvmField
  public val obstacleSetMapName: MethodStringName2<NavigationServer3D, Unit, RID, RID> =
      MethodStringName2<NavigationServer3D, Unit, RID, RID>("obstacle_set_map")

  @JvmField
  public val obstacleGetMapName: MethodStringName1<NavigationServer3D, RID, RID> =
      MethodStringName1<NavigationServer3D, RID, RID>("obstacle_get_map")

  @JvmField
  public val obstacleSetPausedName: MethodStringName2<NavigationServer3D, Unit, RID, Boolean> =
      MethodStringName2<NavigationServer3D, Unit, RID, Boolean>("obstacle_set_paused")

  @JvmField
  public val obstacleGetPausedName: MethodStringName1<NavigationServer3D, Boolean, RID> =
      MethodStringName1<NavigationServer3D, Boolean, RID>("obstacle_get_paused")

  @JvmField
  public val obstacleSetRadiusName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("obstacle_set_radius")

  @JvmField
  public val obstacleGetRadiusName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("obstacle_get_radius")

  @JvmField
  public val obstacleSetHeightName: MethodStringName2<NavigationServer3D, Unit, RID, Float> =
      MethodStringName2<NavigationServer3D, Unit, RID, Float>("obstacle_set_height")

  @JvmField
  public val obstacleGetHeightName: MethodStringName1<NavigationServer3D, Float, RID> =
      MethodStringName1<NavigationServer3D, Float, RID>("obstacle_get_height")

  @JvmField
  public val obstacleSetVelocityName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("obstacle_set_velocity")

  @JvmField
  public val obstacleGetVelocityName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("obstacle_get_velocity")

  @JvmField
  public val obstacleSetPositionName: MethodStringName2<NavigationServer3D, Unit, RID, Vector3> =
      MethodStringName2<NavigationServer3D, Unit, RID, Vector3>("obstacle_set_position")

  @JvmField
  public val obstacleGetPositionName: MethodStringName1<NavigationServer3D, Vector3, RID> =
      MethodStringName1<NavigationServer3D, Vector3, RID>("obstacle_get_position")

  @JvmField
  public val obstacleSetVerticesName:
      MethodStringName2<NavigationServer3D, Unit, RID, PackedVector3Array> =
      MethodStringName2<NavigationServer3D, Unit, RID, PackedVector3Array>("obstacle_set_vertices")

  @JvmField
  public val obstacleGetVerticesName: MethodStringName1<NavigationServer3D, PackedVector3Array, RID>
      = MethodStringName1<NavigationServer3D, PackedVector3Array, RID>("obstacle_get_vertices")

  @JvmField
  public val obstacleSetAvoidanceLayersName: MethodStringName2<NavigationServer3D, Unit, RID, Long>
      = MethodStringName2<NavigationServer3D, Unit, RID, Long>("obstacle_set_avoidance_layers")

  @JvmField
  public val obstacleGetAvoidanceLayersName: MethodStringName1<NavigationServer3D, Long, RID> =
      MethodStringName1<NavigationServer3D, Long, RID>("obstacle_get_avoidance_layers")

  @JvmField
  public val parseSourceGeometryDataName:
      MethodStringName4<NavigationServer3D, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Node?, Callable>
      =
      MethodStringName4<NavigationServer3D, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Node?, Callable>("parse_source_geometry_data")

  @JvmField
  public val bakeFromSourceGeometryDataName:
      MethodStringName3<NavigationServer3D, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Callable>
      =
      MethodStringName3<NavigationServer3D, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Callable>("bake_from_source_geometry_data")

  @JvmField
  public val bakeFromSourceGeometryDataAsyncName:
      MethodStringName3<NavigationServer3D, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Callable>
      =
      MethodStringName3<NavigationServer3D, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Callable>("bake_from_source_geometry_data_async")

  @JvmField
  public val isBakingNavigationMeshName:
      MethodStringName1<NavigationServer3D, Boolean, NavigationMesh?> =
      MethodStringName1<NavigationServer3D, Boolean, NavigationMesh?>("is_baking_navigation_mesh")

  @JvmField
  public val sourceGeometryParserCreateName: MethodStringName0<NavigationServer3D, RID> =
      MethodStringName0<NavigationServer3D, RID>("source_geometry_parser_create")

  @JvmField
  public val sourceGeometryParserSetCallbackName:
      MethodStringName2<NavigationServer3D, Unit, RID, Callable> =
      MethodStringName2<NavigationServer3D, Unit, RID, Callable>("source_geometry_parser_set_callback")

  @JvmField
  public val simplifyPathName:
      MethodStringName2<NavigationServer3D, PackedVector3Array, PackedVector3Array, Float> =
      MethodStringName2<NavigationServer3D, PackedVector3Array, PackedVector3Array, Float>("simplify_path")

  @JvmField
  public val freeRidName: MethodStringName1<NavigationServer3D, Unit, RID> =
      MethodStringName1<NavigationServer3D, Unit, RID>("free_rid")

  @JvmField
  public val setActiveName: MethodStringName1<NavigationServer3D, Unit, Boolean> =
      MethodStringName1<NavigationServer3D, Unit, Boolean>("set_active")

  @JvmField
  public val setDebugEnabledName: MethodStringName1<NavigationServer3D, Unit, Boolean> =
      MethodStringName1<NavigationServer3D, Unit, Boolean>("set_debug_enabled")

  @JvmField
  public val getDebugEnabledName: MethodStringName0<NavigationServer3D, Boolean> =
      MethodStringName0<NavigationServer3D, Boolean>("get_debug_enabled")

  @JvmField
  public val getProcessInfoName: MethodStringName1<NavigationServer3D, Int, ProcessInfo> =
      MethodStringName1<NavigationServer3D, Int, ProcessInfo>("get_process_info")

  /**
   * Emitted when a navigation map is updated, when a region moves or is modified.
   */
  @JvmStatic
  public val mapChanged: Signal1<RID> by Signal1

  /**
   * Emitted when navigation debug settings are changed. Only available in debug builds.
   */
  @JvmStatic
  public val navigationDebugChanged: Signal0 by Signal0

  /**
   * Emitted when avoidance debug settings are changed. Only available in debug builds.
   */
  @JvmStatic
  public val avoidanceDebugChanged: Signal0 by Signal0

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(20)
  }

  /**
   * Returns all created navigation map [RID]s on the NavigationServer. This returns both 2D and 3D
   * created navigation maps as there is technically no distinction between them.
   */
  @JvmStatic
  public final fun getMaps(): VariantArray<RID> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMapsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  /**
   * Create a new map.
   */
  @JvmStatic
  public final fun mapCreate(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.mapCreatePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Sets the map active.
   */
  @JvmStatic
  public final fun mapSetActive(map: RID, active: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, map, active)
    TransferContext.callMethod(MethodBindings.mapSetActivePtr)
  }

  /**
   * Returns `true` if the map is active.
   */
  @JvmStatic
  public final fun mapIsActive(map: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapIsActivePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the map up direction.
   */
  @JvmStatic
  public final fun mapSetUp(map: RID, up: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, map, up)
    TransferContext.callMethod(MethodBindings.mapSetUpPtr)
  }

  /**
   * Returns the map's up direction.
   */
  @JvmStatic
  public final fun mapGetUp(map: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetUpPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the map cell size used to rasterize the navigation mesh vertices on the XZ plane. Must
   * match with the cell size of the used navigation meshes.
   */
  @JvmStatic
  public final fun mapSetCellSize(map: RID, cellSize: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, map, cellSize.toDouble())
    TransferContext.callMethod(MethodBindings.mapSetCellSizePtr)
  }

  /**
   * Returns the map cell size used to rasterize the navigation mesh vertices on the XZ plane.
   */
  @JvmStatic
  public final fun mapGetCellSize(map: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetCellSizePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the map cell height used to rasterize the navigation mesh vertices on the Y axis. Must
   * match with the cell height of the used navigation meshes.
   */
  @JvmStatic
  public final fun mapSetCellHeight(map: RID, cellHeight: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, map, cellHeight.toDouble())
    TransferContext.callMethod(MethodBindings.mapSetCellHeightPtr)
  }

  /**
   * Returns the map cell height used to rasterize the navigation mesh vertices on the Y axis.
   */
  @JvmStatic
  public final fun mapGetCellHeight(map: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetCellHeightPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Set the map's internal merge rasterizer cell scale used to control merging sensitivity.
   */
  @JvmStatic
  public final fun mapSetMergeRasterizerCellScale(map: RID, scale: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, map, scale.toDouble())
    TransferContext.callMethod(MethodBindings.mapSetMergeRasterizerCellScalePtr)
  }

  /**
   * Returns map's internal merge rasterizer cell scale.
   */
  @JvmStatic
  public final fun mapGetMergeRasterizerCellScale(map: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetMergeRasterizerCellScalePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Set the navigation [map] edge connection use. If [enabled] is `true`, the navigation map allows
   * navigation regions to use edge connections to connect with other navigation regions within
   * proximity of the navigation map edge connection margin.
   */
  @JvmStatic
  public final fun mapSetUseEdgeConnections(map: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, map, enabled)
    TransferContext.callMethod(MethodBindings.mapSetUseEdgeConnectionsPtr)
  }

  /**
   * Returns `true` if the navigation [map] allows navigation regions to use edge connections to
   * connect with other navigation regions within proximity of the navigation map edge connection
   * margin.
   */
  @JvmStatic
  public final fun mapGetUseEdgeConnections(map: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetUseEdgeConnectionsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Set the map edge connection margin used to weld the compatible region edges.
   */
  @JvmStatic
  public final fun mapSetEdgeConnectionMargin(map: RID, margin: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, map, margin.toDouble())
    TransferContext.callMethod(MethodBindings.mapSetEdgeConnectionMarginPtr)
  }

  /**
   * Returns the edge connection margin of the map. This distance is the minimum vertex distance
   * needed to connect two edges from different regions.
   */
  @JvmStatic
  public final fun mapGetEdgeConnectionMargin(map: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetEdgeConnectionMarginPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Set the map's link connection radius used to connect links to navigation polygons.
   */
  @JvmStatic
  public final fun mapSetLinkConnectionRadius(map: RID, radius: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, map, radius.toDouble())
    TransferContext.callMethod(MethodBindings.mapSetLinkConnectionRadiusPtr)
  }

  /**
   * Returns the link connection radius of the map. This distance is the maximum range any link will
   * search for navigation mesh polygons to connect to.
   */
  @JvmStatic
  public final fun mapGetLinkConnectionRadius(map: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetLinkConnectionRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the navigation path to reach the destination from the origin. [navigationLayers] is a
   * bitmask of all region navigation layers that are allowed to be in the path.
   */
  @JvmOverloads
  @JvmStatic
  public final fun mapGetPath(
    map: RID,
    origin: Vector3,
    destination: Vector3,
    optimize: Boolean,
    navigationLayers: Long = 1,
  ): PackedVector3Array {
    TransferContext.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL_LONG(ptr, objectID.id, map, origin, destination, optimize, navigationLayers)
    TransferContext.callMethod(MethodBindings.mapGetPathPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Returns the navigation mesh surface point closest to the provided [start] and [end] segment on
   * the navigation [map].
   *
   * If [useCollision] is `true`, a closest point test is only done when the segment intersects with
   * the navigation mesh surface.
   */
  @JvmOverloads
  @JvmStatic
  public final fun mapGetClosestPointToSegment(
    map: RID,
    start: Vector3,
    end: Vector3,
    useCollision: Boolean = false,
  ): Vector3 {
    TransferContext.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL(ptr, objectID.id, map, start, end, useCollision)
    TransferContext.callMethod(MethodBindings.mapGetClosestPointToSegmentPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the navigation mesh surface point closest to the provided [toPoint] on the navigation
   * [map].
   */
  @JvmStatic
  public final fun mapGetClosestPoint(map: RID, toPoint: Vector3): Vector3 {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, map, toPoint)
    TransferContext.callMethod(MethodBindings.mapGetClosestPointPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the navigation mesh surface normal closest to the provided [toPoint] on the navigation
   * [map].
   */
  @JvmStatic
  public final fun mapGetClosestPointNormal(map: RID, toPoint: Vector3): Vector3 {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, map, toPoint)
    TransferContext.callMethod(MethodBindings.mapGetClosestPointNormalPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the owner region RID for the navigation mesh surface point closest to the provided
   * [toPoint] on the navigation [map].
   */
  @JvmStatic
  public final fun mapGetClosestPointOwner(map: RID, toPoint: Vector3): RID {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, map, toPoint)
    TransferContext.callMethod(MethodBindings.mapGetClosestPointOwnerPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns all navigation link [RID]s that are currently assigned to the requested navigation
   * [map].
   */
  @JvmStatic
  public final fun mapGetLinks(map: RID): VariantArray<RID> {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetLinksPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  /**
   * Returns all navigation regions [RID]s that are currently assigned to the requested navigation
   * [map].
   */
  @JvmStatic
  public final fun mapGetRegions(map: RID): VariantArray<RID> {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetRegionsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  /**
   * Returns all navigation agents [RID]s that are currently assigned to the requested navigation
   * [map].
   */
  @JvmStatic
  public final fun mapGetAgents(map: RID): VariantArray<RID> {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetAgentsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  /**
   * Returns all navigation obstacle [RID]s that are currently assigned to the requested navigation
   * [map].
   */
  @JvmStatic
  public final fun mapGetObstacles(map: RID): VariantArray<RID> {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetObstaclesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  /**
   * This function immediately forces synchronization of the specified navigation [map] [RID]. By
   * default navigation maps are only synchronized at the end of each physics frame. This function can
   * be used to immediately (re)calculate all the navigation meshes and region connections of the
   * navigation map. This makes it possible to query a navigation path for a changed map immediately
   * and in the same frame (multiple times if needed).
   *
   * Due to technical restrictions the current NavigationServer command queue will be flushed. This
   * means all already queued update commands for this physics frame will be executed, even those
   * intended for other maps, regions and agents not part of the specified map. The expensive
   * computation of the navigation meshes and region connections of a map will only be done for the
   * specified map. Other maps will receive the normal synchronization at the end of the physics frame.
   * Should the specified map receive changes after the forced update it will update again as well when
   * the other maps receive their update.
   *
   * Avoidance processing and dispatch of the `safe_velocity` signals is unaffected by this function
   * and continues to happen for all maps and agents at the end of the physics frame.
   *
   * **Note:** With great power comes great responsibility. This function should only be used by
   * users that really know what they are doing and have a good reason for it. Forcing an immediate
   * update of a navigation map requires locking the NavigationServer and flushing the entire
   * NavigationServer command queue. Not only can this severely impact the performance of a game but it
   * can also introduce bugs if used inappropriately without much foresight.
   */
  @JvmStatic
  public final fun mapForceUpdate(map: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapForceUpdatePtr)
  }

  /**
   * Returns the current iteration id of the navigation map. Every time the navigation map changes
   * and synchronizes the iteration id increases. An iteration id of 0 means the navigation map has
   * never synchronized.
   *
   * **Note:** The iteration id will wrap back to 1 after reaching its range limit.
   */
  @JvmStatic
  public final fun mapGetIterationId(map: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetIterationIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * If [enabled] is `true` the [map] synchronization uses an async process that runs on a
   * background thread.
   */
  @JvmStatic
  public final fun mapSetUseAsyncIterations(map: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, map, enabled)
    TransferContext.callMethod(MethodBindings.mapSetUseAsyncIterationsPtr)
  }

  /**
   * Returns `true` if the [map] synchronization uses an async process that runs on a background
   * thread.
   */
  @JvmStatic
  public final fun mapGetUseAsyncIterations(map: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, map)
    TransferContext.callMethod(MethodBindings.mapGetUseAsyncIterationsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a random position picked from all map region polygons with matching [navigationLayers].
   *
   * If [uniformly] is `true`, all map regions, polygons, and faces are weighted by their surface
   * area (slower).
   *
   * If [uniformly] is `false`, just a random region and a random polygon are picked (faster).
   */
  @JvmStatic
  public final fun mapGetRandomPoint(
    map: RID,
    navigationLayers: Long,
    uniformly: Boolean,
  ): Vector3 {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, map, navigationLayers, uniformly)
    TransferContext.callMethod(MethodBindings.mapGetRandomPointPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Queries a path in a given navigation map. Start and target position and other parameters are
   * defined through [NavigationPathQueryParameters3D]. Updates the provided
   * [NavigationPathQueryResult3D] result object with the path among other results requested by the
   * query. After the process is finished the optional [callback] will be called.
   */
  @JvmOverloads
  @JvmStatic
  public final fun queryPath(
    parameters: NavigationPathQueryParameters3D?,
    result: NavigationPathQueryResult3D?,
    callback: Callable = VariantCallable(),
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, parameters, result, callback)
    TransferContext.callMethod(MethodBindings.queryPathPtr)
  }

  /**
   * Creates a new region.
   */
  @JvmStatic
  public final fun regionCreate(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.regionCreatePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the current iteration ID of the navigation region. Every time the navigation region
   * changes and synchronizes, the iteration ID increases. An iteration ID of `0` means the navigation
   * region has never synchronized.
   *
   * **Note:** The iteration ID will wrap around to `1` after reaching its range limit.
   */
  @JvmStatic
  public final fun regionGetIterationId(region: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetIterationIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * If [enabled] is `true` the [region] uses an async synchronization process that runs on a
   * background thread.
   */
  @JvmStatic
  public final fun regionSetUseAsyncIterations(region: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, region, enabled)
    TransferContext.callMethod(MethodBindings.regionSetUseAsyncIterationsPtr)
  }

  /**
   * Returns `true` if the [region] uses an async synchronization process that runs on a background
   * thread.
   */
  @JvmStatic
  public final fun regionGetUseAsyncIterations(region: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetUseAsyncIterationsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If [enabled] is `true`, the specified [region] will contribute to its current navigation map.
   */
  @JvmStatic
  public final fun regionSetEnabled(region: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, region, enabled)
    TransferContext.callMethod(MethodBindings.regionSetEnabledPtr)
  }

  /**
   * Returns `true` if the specified [region] is enabled.
   */
  @JvmStatic
  public final fun regionGetEnabled(region: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If [enabled] is `true`, the navigation [region] will use edge connections to connect with other
   * navigation regions within proximity of the navigation map edge connection margin.
   */
  @JvmStatic
  public final fun regionSetUseEdgeConnections(region: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, region, enabled)
    TransferContext.callMethod(MethodBindings.regionSetUseEdgeConnectionsPtr)
  }

  /**
   * Returns `true` if the navigation [region] is set to use edge connections to connect with other
   * navigation regions within proximity of the navigation map edge connection margin.
   */
  @JvmStatic
  public final fun regionGetUseEdgeConnections(region: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetUseEdgeConnectionsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the [enterCost] for this [region].
   */
  @JvmStatic
  public final fun regionSetEnterCost(region: RID, enterCost: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, region, enterCost.toDouble())
    TransferContext.callMethod(MethodBindings.regionSetEnterCostPtr)
  }

  /**
   * Returns the enter cost of this [region].
   */
  @JvmStatic
  public final fun regionGetEnterCost(region: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetEnterCostPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the [travelCost] for this [region].
   */
  @JvmStatic
  public final fun regionSetTravelCost(region: RID, travelCost: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, region, travelCost.toDouble())
    TransferContext.callMethod(MethodBindings.regionSetTravelCostPtr)
  }

  /**
   * Returns the travel cost of this [region].
   */
  @JvmStatic
  public final fun regionGetTravelCost(region: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetTravelCostPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Set the `ObjectID` of the object which manages this region.
   */
  @JvmStatic
  public final fun regionSetOwnerId(region: RID, ownerId: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, region, ownerId)
    TransferContext.callMethod(MethodBindings.regionSetOwnerIdPtr)
  }

  /**
   * Returns the `ObjectID` of the object which manages this region.
   */
  @JvmStatic
  public final fun regionGetOwnerId(region: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetOwnerIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns `true` if the provided [point] in world space is currently owned by the provided
   * navigation [region]. Owned in this context means that one of the region's navigation mesh polygon
   * faces has a possible position at the closest distance to this point compared to all other
   * navigation meshes from other navigation regions that are also registered on the navigation map of
   * the provided region.
   *
   * If multiple navigation meshes have positions at equal distance the navigation region whose
   * polygons are processed first wins the ownership. Polygons are processed in the same order that
   * navigation regions were registered on the NavigationServer.
   *
   * **Note:** If navigation meshes from different navigation regions overlap (which should be
   * avoided in general) the result might not be what is expected.
   */
  @JvmStatic
  public final fun regionOwnsPoint(region: RID, point: Vector3): Boolean {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, region, point)
    TransferContext.callMethod(MethodBindings.regionOwnsPointPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the map for the region.
   */
  @JvmStatic
  public final fun regionSetMap(region: RID, map: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, region, map)
    TransferContext.callMethod(MethodBindings.regionSetMapPtr)
  }

  /**
   * Returns the navigation map [RID] the requested [region] is currently assigned to.
   */
  @JvmStatic
  public final fun regionGetMap(region: RID): RID {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetMapPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Set the region's navigation layers. This allows selecting regions from a path request (when
   * using [NavigationServer3D.mapGetPath]).
   */
  @JvmStatic
  public final fun regionSetNavigationLayers(region: RID, navigationLayers: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, region, navigationLayers)
    TransferContext.callMethod(MethodBindings.regionSetNavigationLayersPtr)
  }

  /**
   * Returns the region's navigation layers.
   */
  @JvmStatic
  public final fun regionGetNavigationLayers(region: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetNavigationLayersPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Sets the global transformation for the region.
   */
  @JvmStatic
  public final fun regionSetTransform(region: RID, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments_RID_TRANSFORM3D(ptr, objectID.id, region, transform)
    TransferContext.callMethod(MethodBindings.regionSetTransformPtr)
  }

  /**
   * Returns the global transformation of this [region].
   */
  @JvmStatic
  public final fun regionGetTransform(region: RID): Transform3D {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetTransformPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Sets the navigation mesh for the region.
   */
  @JvmStatic
  public final fun regionSetNavigationMesh(region: RID, navigationMesh: NavigationMesh?): Unit {
    TransferContext.writeMethodArguments_RID_OBJECT(ptr, objectID.id, region, navigationMesh)
    TransferContext.callMethod(MethodBindings.regionSetNavigationMeshPtr)
  }

  /**
   * Bakes the [navigationMesh] with bake source geometry collected starting from the [rootNode].
   */
  @JvmStatic
  public final fun regionBakeNavigationMesh(navigationMesh: NavigationMesh?, rootNode: Node?):
      Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT(ptr, objectID.id, navigationMesh, rootNode)
    TransferContext.callMethod(MethodBindings.regionBakeNavigationMeshPtr)
  }

  /**
   * Returns how many connections this [region] has with other regions in the map.
   */
  @JvmStatic
  public final fun regionGetConnectionsCount(region: RID): Int {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetConnectionsCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the starting point of a connection door. [connection] is an index between 0 and the
   * return value of [regionGetConnectionsCount].
   */
  @JvmStatic
  public final fun regionGetConnectionPathwayStart(region: RID, connection: Int): Vector3 {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, region, connection.toLong())
    TransferContext.callMethod(MethodBindings.regionGetConnectionPathwayStartPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the ending point of a connection door. [connection] is an index between 0 and the
   * return value of [regionGetConnectionsCount].
   */
  @JvmStatic
  public final fun regionGetConnectionPathwayEnd(region: RID, connection: Int): Vector3 {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, region, connection.toLong())
    TransferContext.callMethod(MethodBindings.regionGetConnectionPathwayEndPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the navigation mesh surface point closest to the provided [start] and [end] segment on
   * the navigation [region].
   *
   * If [useCollision] is `true`, a closest point test is only done when the segment intersects with
   * the navigation mesh surface.
   */
  @JvmOverloads
  @JvmStatic
  public final fun regionGetClosestPointToSegment(
    region: RID,
    start: Vector3,
    end: Vector3,
    useCollision: Boolean = false,
  ): Vector3 {
    TransferContext.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL(ptr, objectID.id, region, start, end, useCollision)
    TransferContext.callMethod(MethodBindings.regionGetClosestPointToSegmentPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the navigation mesh surface point closest to the provided [toPoint] on the navigation
   * [region].
   */
  @JvmStatic
  public final fun regionGetClosestPoint(region: RID, toPoint: Vector3): Vector3 {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, region, toPoint)
    TransferContext.callMethod(MethodBindings.regionGetClosestPointPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the navigation mesh surface normal closest to the provided [toPoint] on the navigation
   * [region].
   */
  @JvmStatic
  public final fun regionGetClosestPointNormal(region: RID, toPoint: Vector3): Vector3 {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, region, toPoint)
    TransferContext.callMethod(MethodBindings.regionGetClosestPointNormalPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns a random position picked from all region polygons with matching [navigationLayers].
   *
   * If [uniformly] is `true`, all region polygons and faces are weighted by their surface area
   * (slower).
   *
   * If [uniformly] is `false`, just a random polygon and face is picked (faster).
   */
  @JvmStatic
  public final fun regionGetRandomPoint(
    region: RID,
    navigationLayers: Long,
    uniformly: Boolean,
  ): Vector3 {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, region, navigationLayers, uniformly)
    TransferContext.callMethod(MethodBindings.regionGetRandomPointPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the axis-aligned bounding box for the [region]'s transformed navigation mesh.
   */
  @JvmStatic
  public final fun regionGetBounds(region: RID): AABB {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, region)
    TransferContext.callMethod(MethodBindings.regionGetBoundsPtr)
    return TransferContext.readReturnValue_AABB()
  }

  /**
   * Create a new link between two positions on a map.
   */
  @JvmStatic
  public final fun linkCreate(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.linkCreatePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the current iteration ID of the navigation link. Every time the navigation link changes
   * and synchronizes, the iteration ID increases. An iteration ID of `0` means the navigation link has
   * never synchronized.
   *
   * **Note:** The iteration ID will wrap around to `1` after reaching its range limit.
   */
  @JvmStatic
  public final fun linkGetIterationId(link: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetIterationIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Sets the navigation map [RID] for the link.
   */
  @JvmStatic
  public final fun linkSetMap(link: RID, map: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, link, map)
    TransferContext.callMethod(MethodBindings.linkSetMapPtr)
  }

  /**
   * Returns the navigation map [RID] the requested [link] is currently assigned to.
   */
  @JvmStatic
  public final fun linkGetMap(link: RID): RID {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetMapPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * If [enabled] is `true`, the specified [link] will contribute to its current navigation map.
   */
  @JvmStatic
  public final fun linkSetEnabled(link: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, link, enabled)
    TransferContext.callMethod(MethodBindings.linkSetEnabledPtr)
  }

  /**
   * Returns `true` if the specified [link] is enabled.
   */
  @JvmStatic
  public final fun linkGetEnabled(link: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets whether this [link] can be travelled in both directions.
   */
  @JvmStatic
  public final fun linkSetBidirectional(link: RID, bidirectional: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, link, bidirectional)
    TransferContext.callMethod(MethodBindings.linkSetBidirectionalPtr)
  }

  /**
   * Returns whether this [link] can be travelled in both directions.
   */
  @JvmStatic
  public final fun linkIsBidirectional(link: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkIsBidirectionalPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Set the links's navigation layers. This allows selecting links from a path request (when using
   * [NavigationServer3D.mapGetPath]).
   */
  @JvmStatic
  public final fun linkSetNavigationLayers(link: RID, navigationLayers: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, link, navigationLayers)
    TransferContext.callMethod(MethodBindings.linkSetNavigationLayersPtr)
  }

  /**
   * Returns the navigation layers for this [link].
   */
  @JvmStatic
  public final fun linkGetNavigationLayers(link: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetNavigationLayersPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Sets the entry position for this [link].
   */
  @JvmStatic
  public final fun linkSetStartPosition(link: RID, position: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, link, position)
    TransferContext.callMethod(MethodBindings.linkSetStartPositionPtr)
  }

  /**
   * Returns the starting position of this [link].
   */
  @JvmStatic
  public final fun linkGetStartPosition(link: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetStartPositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the exit position for the [link].
   */
  @JvmStatic
  public final fun linkSetEndPosition(link: RID, position: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, link, position)
    TransferContext.callMethod(MethodBindings.linkSetEndPositionPtr)
  }

  /**
   * Returns the ending position of this [link].
   */
  @JvmStatic
  public final fun linkGetEndPosition(link: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetEndPositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the [enterCost] for this [link].
   */
  @JvmStatic
  public final fun linkSetEnterCost(link: RID, enterCost: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, link, enterCost.toDouble())
    TransferContext.callMethod(MethodBindings.linkSetEnterCostPtr)
  }

  /**
   * Returns the enter cost of this [link].
   */
  @JvmStatic
  public final fun linkGetEnterCost(link: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetEnterCostPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the [travelCost] for this [link].
   */
  @JvmStatic
  public final fun linkSetTravelCost(link: RID, travelCost: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, link, travelCost.toDouble())
    TransferContext.callMethod(MethodBindings.linkSetTravelCostPtr)
  }

  /**
   * Returns the travel cost of this [link].
   */
  @JvmStatic
  public final fun linkGetTravelCost(link: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetTravelCostPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Set the `ObjectID` of the object which manages this link.
   */
  @JvmStatic
  public final fun linkSetOwnerId(link: RID, ownerId: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, link, ownerId)
    TransferContext.callMethod(MethodBindings.linkSetOwnerIdPtr)
  }

  /**
   * Returns the `ObjectID` of the object which manages this link.
   */
  @JvmStatic
  public final fun linkGetOwnerId(link: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, link)
    TransferContext.callMethod(MethodBindings.linkGetOwnerIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Creates the agent.
   */
  @JvmStatic
  public final fun agentCreate(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.agentCreatePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * If [enabled] is `true`, the provided [agent] calculates avoidance.
   */
  @JvmStatic
  public final fun agentSetAvoidanceEnabled(agent: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, agent, enabled)
    TransferContext.callMethod(MethodBindings.agentSetAvoidanceEnabledPtr)
  }

  /**
   * Returns `true` if the provided [agent] has avoidance enabled.
   */
  @JvmStatic
  public final fun agentGetAvoidanceEnabled(agent: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetAvoidanceEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets if the agent uses the 2D avoidance or the 3D avoidance while avoidance is enabled.
   *
   * If `true` the agent calculates avoidance velocities in 3D for the xyz-axis, e.g. for games that
   * take place in air, underwater or space. The 3D using agent only avoids other 3D avoidance using
   * agent's. The 3D using agent only reacts to radius based avoidance obstacles. The 3D using agent
   * ignores any vertices based obstacles. The 3D using agent only avoids other 3D using agent's.
   *
   * If `false` the agent calculates avoidance velocities in 2D along the xz-axis ignoring the
   * y-axis. The 2D using agent only avoids other 2D avoidance using agent's. The 2D using agent reacts
   * to radius avoidance obstacles. The 2D using agent reacts to vertices based avoidance obstacles.
   * The 2D using agent only avoids other 2D using agent's. 2D using agents will ignore other 2D using
   * agents or obstacles that are below their current position or above their current position
   * including the agents height in 2D avoidance.
   */
  @JvmStatic
  public final fun agentSetUse3dAvoidance(agent: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, agent, enabled)
    TransferContext.callMethod(MethodBindings.agentSetUse3dAvoidancePtr)
  }

  /**
   * Returns `true` if the provided [agent] uses avoidance in 3D space Vector3(x,y,z) instead of
   * horizontal 2D Vector2(x,y) / Vector3(x,0.0,z).
   */
  @JvmStatic
  public final fun agentGetUse3dAvoidance(agent: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetUse3dAvoidancePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Puts the agent in the map.
   */
  @JvmStatic
  public final fun agentSetMap(agent: RID, map: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, agent, map)
    TransferContext.callMethod(MethodBindings.agentSetMapPtr)
  }

  /**
   * Returns the navigation map [RID] the requested [agent] is currently assigned to.
   */
  @JvmStatic
  public final fun agentGetMap(agent: RID): RID {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetMapPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * If [paused] is `true` the specified [agent] will not be processed. For example, it will not
   * calculate avoidance velocities or receive avoidance callbacks.
   */
  @JvmStatic
  public final fun agentSetPaused(agent: RID, paused: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, agent, paused)
    TransferContext.callMethod(MethodBindings.agentSetPausedPtr)
  }

  /**
   * Returns `true` if the specified [agent] is paused.
   */
  @JvmStatic
  public final fun agentGetPaused(agent: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetPausedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the maximum distance to other agents this agent takes into account in the navigation. The
   * larger this number, the longer the running time of the simulation. If the number is too low, the
   * simulation will not be safe.
   */
  @JvmStatic
  public final fun agentSetNeighborDistance(agent: RID, distance: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, distance.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetNeighborDistancePtr)
  }

  /**
   * Returns the maximum distance to other agents the specified [agent] takes into account in the
   * navigation.
   */
  @JvmStatic
  public final fun agentGetNeighborDistance(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetNeighborDistancePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the maximum number of other agents the agent takes into account in the navigation. The
   * larger this number, the longer the running time of the simulation. If the number is too low, the
   * simulation will not be safe.
   */
  @JvmStatic
  public final fun agentSetMaxNeighbors(agent: RID, count: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, agent, count.toLong())
    TransferContext.callMethod(MethodBindings.agentSetMaxNeighborsPtr)
  }

  /**
   * Returns the maximum number of other agents the specified [agent] takes into account in the
   * navigation.
   */
  @JvmStatic
  public final fun agentGetMaxNeighbors(agent: RID): Int {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetMaxNeighborsPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * The minimal amount of time for which the agent's velocities that are computed by the simulation
   * are safe with respect to other agents. The larger this number, the sooner this agent will respond
   * to the presence of other agents, but the less freedom this agent has in choosing its velocities. A
   * too high value will slow down agents movement considerably. Must be positive.
   */
  @JvmStatic
  public final fun agentSetTimeHorizonAgents(agent: RID, timeHorizon: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, timeHorizon.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetTimeHorizonAgentsPtr)
  }

  /**
   * Returns the minimal amount of time for which the specified [agent]'s velocities that are
   * computed by the simulation are safe with respect to other agents.
   */
  @JvmStatic
  public final fun agentGetTimeHorizonAgents(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetTimeHorizonAgentsPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * The minimal amount of time for which the agent's velocities that are computed by the simulation
   * are safe with respect to static avoidance obstacles. The larger this number, the sooner this agent
   * will respond to the presence of static avoidance obstacles, but the less freedom this agent has in
   * choosing its velocities. A too high value will slow down agents movement considerably. Must be
   * positive.
   */
  @JvmStatic
  public final fun agentSetTimeHorizonObstacles(agent: RID, timeHorizon: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, timeHorizon.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetTimeHorizonObstaclesPtr)
  }

  /**
   * Returns the minimal amount of time for which the specified [agent]'s velocities that are
   * computed by the simulation are safe with respect to static avoidance obstacles.
   */
  @JvmStatic
  public final fun agentGetTimeHorizonObstacles(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetTimeHorizonObstaclesPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the radius of the agent.
   */
  @JvmStatic
  public final fun agentSetRadius(agent: RID, radius: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, radius.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetRadiusPtr)
  }

  /**
   * Returns the radius of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetRadius(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Updates the provided [agent] [height].
   */
  @JvmStatic
  public final fun agentSetHeight(agent: RID, height: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, height.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetHeightPtr)
  }

  /**
   * Returns the `height` of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetHeight(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetHeightPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the maximum speed of the agent. Must be positive.
   */
  @JvmStatic
  public final fun agentSetMaxSpeed(agent: RID, maxSpeed: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, maxSpeed.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetMaxSpeedPtr)
  }

  /**
   * Returns the maximum speed of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetMaxSpeed(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetMaxSpeedPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Replaces the internal velocity in the collision avoidance simulation with [velocity] for the
   * specified [agent]. When an agent is teleported to a new position this function should be used in
   * the same frame. If called frequently this function can get agents stuck.
   */
  @JvmStatic
  public final fun agentSetVelocityForced(agent: RID, velocity: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, agent, velocity)
    TransferContext.callMethod(MethodBindings.agentSetVelocityForcedPtr)
  }

  /**
   * Sets [velocity] as the new wanted velocity for the specified [agent]. The avoidance simulation
   * will try to fulfill this velocity if possible but will modify it to avoid collision with other
   * agent's and obstacles. When an agent is teleported to a new position use [agentSetVelocityForced]
   * as well to reset the internal simulation velocity.
   */
  @JvmStatic
  public final fun agentSetVelocity(agent: RID, velocity: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, agent, velocity)
    TransferContext.callMethod(MethodBindings.agentSetVelocityPtr)
  }

  /**
   * Returns the velocity of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetVelocity(agent: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetVelocityPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the position of the agent in world space.
   */
  @JvmStatic
  public final fun agentSetPosition(agent: RID, position: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, agent, position)
    TransferContext.callMethod(MethodBindings.agentSetPositionPtr)
  }

  /**
   * Returns the position of the specified [agent] in world space.
   */
  @JvmStatic
  public final fun agentGetPosition(agent: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetPositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns `true` if the map got changed the previous frame.
   */
  @JvmStatic
  public final fun agentIsMapChanged(agent: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentIsMapChangedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the callback [Callable] that gets called after each avoidance processing step for the
   * [agent]. The calculated `safe_velocity` will be dispatched with a signal to the object just before
   * the physics calculations.
   *
   * **Note:** Created callbacks are always processed independently of the SceneTree state as long
   * as the agent is on a navigation map and not freed. To disable the dispatch of a callback from an
   * agent use [agentSetAvoidanceCallback] again with an empty [Callable].
   */
  @JvmStatic
  public final fun agentSetAvoidanceCallback(agent: RID, callback: Callable): Unit {
    TransferContext.writeMethodArguments_RID_CALLABLE(ptr, objectID.id, agent, callback)
    TransferContext.callMethod(MethodBindings.agentSetAvoidanceCallbackPtr)
  }

  /**
   * Return `true` if the specified [agent] has an avoidance callback.
   */
  @JvmStatic
  public final fun agentHasAvoidanceCallback(agent: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentHasAvoidanceCallbackPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Set the agent's `avoidance_layers` bitmask.
   */
  @JvmStatic
  public final fun agentSetAvoidanceLayers(agent: RID, layers: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, agent, layers)
    TransferContext.callMethod(MethodBindings.agentSetAvoidanceLayersPtr)
  }

  /**
   * Returns the `avoidance_layers` bitmask of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetAvoidanceLayers(agent: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetAvoidanceLayersPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Set the agent's `avoidance_mask` bitmask.
   */
  @JvmStatic
  public final fun agentSetAvoidanceMask(agent: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, agent, mask)
    TransferContext.callMethod(MethodBindings.agentSetAvoidanceMaskPtr)
  }

  /**
   * Returns the `avoidance_mask` bitmask of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetAvoidanceMask(agent: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetAvoidanceMaskPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Set the agent's `avoidance_priority` with a [priority] between 0.0 (lowest priority) to 1.0
   * (highest priority).
   *
   * The specified [agent] does not adjust the velocity for other agents that would match the
   * `avoidance_mask` but have a lower `avoidance_priority`. This in turn makes the other agents with
   * lower priority adjust their velocities even more to avoid collision with this agent.
   */
  @JvmStatic
  public final fun agentSetAvoidancePriority(agent: RID, priority: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, agent, priority.toDouble())
    TransferContext.callMethod(MethodBindings.agentSetAvoidancePriorityPtr)
  }

  /**
   * Returns the `avoidance_priority` of the specified [agent].
   */
  @JvmStatic
  public final fun agentGetAvoidancePriority(agent: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, agent)
    TransferContext.callMethod(MethodBindings.agentGetAvoidancePriorityPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Creates a new obstacle.
   */
  @JvmStatic
  public final fun obstacleCreate(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.obstacleCreatePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * If [enabled] is `true`, the provided [obstacle] affects avoidance using agents.
   */
  @JvmStatic
  public final fun obstacleSetAvoidanceEnabled(obstacle: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, obstacle, enabled)
    TransferContext.callMethod(MethodBindings.obstacleSetAvoidanceEnabledPtr)
  }

  /**
   * Returns `true` if the provided [obstacle] has avoidance enabled.
   */
  @JvmStatic
  public final fun obstacleGetAvoidanceEnabled(obstacle: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetAvoidanceEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets if the [obstacle] uses the 2D avoidance or the 3D avoidance while avoidance is enabled.
   */
  @JvmStatic
  public final fun obstacleSetUse3dAvoidance(obstacle: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, obstacle, enabled)
    TransferContext.callMethod(MethodBindings.obstacleSetUse3dAvoidancePtr)
  }

  /**
   * Returns `true` if the provided [obstacle] uses avoidance in 3D space Vector3(x,y,z) instead of
   * horizontal 2D Vector2(x,y) / Vector3(x,0.0,z).
   */
  @JvmStatic
  public final fun obstacleGetUse3dAvoidance(obstacle: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetUse3dAvoidancePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Assigns the [obstacle] to a navigation map.
   */
  @JvmStatic
  public final fun obstacleSetMap(obstacle: RID, map: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, obstacle, map)
    TransferContext.callMethod(MethodBindings.obstacleSetMapPtr)
  }

  /**
   * Returns the navigation map [RID] the requested [obstacle] is currently assigned to.
   */
  @JvmStatic
  public final fun obstacleGetMap(obstacle: RID): RID {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetMapPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * If [paused] is `true` the specified [obstacle] will not be processed. For example, it will no
   * longer affect avoidance velocities.
   */
  @JvmStatic
  public final fun obstacleSetPaused(obstacle: RID, paused: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, obstacle, paused)
    TransferContext.callMethod(MethodBindings.obstacleSetPausedPtr)
  }

  /**
   * Returns `true` if the specified [obstacle] is paused.
   */
  @JvmStatic
  public final fun obstacleGetPaused(obstacle: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetPausedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the radius of the dynamic obstacle.
   */
  @JvmStatic
  public final fun obstacleSetRadius(obstacle: RID, radius: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, obstacle, radius.toDouble())
    TransferContext.callMethod(MethodBindings.obstacleSetRadiusPtr)
  }

  /**
   * Returns the radius of the specified dynamic [obstacle].
   */
  @JvmStatic
  public final fun obstacleGetRadius(obstacle: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the [height] for the [obstacle]. In 3D agents will ignore obstacles that are above or
   * below them while using 2D avoidance.
   */
  @JvmStatic
  public final fun obstacleSetHeight(obstacle: RID, height: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, obstacle, height.toDouble())
    TransferContext.callMethod(MethodBindings.obstacleSetHeightPtr)
  }

  /**
   * Returns the `height` of the specified [obstacle].
   */
  @JvmStatic
  public final fun obstacleGetHeight(obstacle: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetHeightPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets [velocity] of the dynamic [obstacle]. Allows other agents to better predict the movement
   * of the dynamic obstacle. Only works in combination with the radius of the obstacle.
   */
  @JvmStatic
  public final fun obstacleSetVelocity(obstacle: RID, velocity: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, obstacle, velocity)
    TransferContext.callMethod(MethodBindings.obstacleSetVelocityPtr)
  }

  /**
   * Returns the velocity of the specified dynamic [obstacle].
   */
  @JvmStatic
  public final fun obstacleGetVelocity(obstacle: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetVelocityPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Updates the [position] in world space for the [obstacle].
   */
  @JvmStatic
  public final fun obstacleSetPosition(obstacle: RID, position: Vector3): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR3(ptr, objectID.id, obstacle, position)
    TransferContext.callMethod(MethodBindings.obstacleSetPositionPtr)
  }

  /**
   * Returns the position of the specified [obstacle] in world space.
   */
  @JvmStatic
  public final fun obstacleGetPosition(obstacle: RID): Vector3 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetPositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the outline vertices for the obstacle. If the vertices are winded in clockwise order
   * agents will be pushed in by the obstacle, else they will be pushed out.
   */
  @JvmStatic
  public final fun obstacleSetVertices(obstacle: RID, vertices: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments_RID_PACKED_VECTOR3_ARRAY(ptr, objectID.id, obstacle, vertices)
    TransferContext.callMethod(MethodBindings.obstacleSetVerticesPtr)
  }

  /**
   * Returns the outline vertices for the specified [obstacle].
   */
  @JvmStatic
  public final fun obstacleGetVertices(obstacle: RID): PackedVector3Array {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetVerticesPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Set the obstacles's `avoidance_layers` bitmask.
   */
  @JvmStatic
  public final fun obstacleSetAvoidanceLayers(obstacle: RID, layers: Long): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, obstacle, layers)
    TransferContext.callMethod(MethodBindings.obstacleSetAvoidanceLayersPtr)
  }

  /**
   * Returns the `avoidance_layers` bitmask of the specified [obstacle].
   */
  @JvmStatic
  public final fun obstacleGetAvoidanceLayers(obstacle: RID): Long {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, obstacle)
    TransferContext.callMethod(MethodBindings.obstacleGetAvoidanceLayersPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Parses the [SceneTree] for source geometry according to the properties of [navigationMesh].
   * Updates the provided [sourceGeometryData] resource with the resulting data. The resource can then
   * be used to bake a navigation mesh with [bakeFromSourceGeometryData]. After the process is finished
   * the optional [callback] will be called.
   *
   * **Note:** This function needs to run on the main thread or with a deferred call as the
   * SceneTree is not thread-safe.
   *
   * **Performance:** While convenient, reading data arrays from [Mesh] resources can affect the
   * frame rate negatively. The data needs to be received from the GPU, stalling the [RenderingServer]
   * in the process. For performance prefer the use of e.g. collision shapes or creating the data
   * arrays entirely in code.
   */
  @JvmOverloads
  @JvmStatic
  public final fun parseSourceGeometryData(
    navigationMesh: NavigationMesh?,
    sourceGeometryData: NavigationMeshSourceGeometryData3D?,
    rootNode: Node?,
    callback: Callable = VariantCallable(),
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, navigationMesh, sourceGeometryData, rootNode, callback)
    TransferContext.callMethod(MethodBindings.parseSourceGeometryDataPtr)
  }

  /**
   * Bakes the provided [navigationMesh] with the data from the provided [sourceGeometryData]. After
   * the process is finished the optional [callback] will be called.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bakeFromSourceGeometryData(
    navigationMesh: NavigationMesh?,
    sourceGeometryData: NavigationMeshSourceGeometryData3D?,
    callback: Callable = VariantCallable(),
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, navigationMesh, sourceGeometryData, callback)
    TransferContext.callMethod(MethodBindings.bakeFromSourceGeometryDataPtr)
  }

  /**
   * Bakes the provided [navigationMesh] with the data from the provided [sourceGeometryData] as an
   * async task running on a background thread. After the process is finished the optional [callback]
   * will be called.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bakeFromSourceGeometryDataAsync(
    navigationMesh: NavigationMesh?,
    sourceGeometryData: NavigationMeshSourceGeometryData3D?,
    callback: Callable = VariantCallable(),
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, navigationMesh, sourceGeometryData, callback)
    TransferContext.callMethod(MethodBindings.bakeFromSourceGeometryDataAsyncPtr)
  }

  /**
   * Returns `true` when the provided navigation mesh is being baked on a background thread.
   */
  @JvmStatic
  public final fun isBakingNavigationMesh(navigationMesh: NavigationMesh?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, navigationMesh)
    TransferContext.callMethod(MethodBindings.isBakingNavigationMeshPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Creates a new source geometry parser. If a [Callable] is set for the parser with
   * [sourceGeometryParserSetCallback] the callback will be called for every single node that gets
   * parsed whenever [parseSourceGeometryData] is used.
   */
  @JvmStatic
  public final fun sourceGeometryParserCreate(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.sourceGeometryParserCreatePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Sets the [callback] [Callable] for the specific source geometry [parser]. The [Callable] will
   * receive a call with the following parameters:
   *
   * - `navigation_mesh` - The [NavigationMesh] reference used to define the parse settings. Do NOT
   * edit or add directly to the navigation mesh.
   *
   * - `source_geometry_data` - The [NavigationMeshSourceGeometryData3D] reference. Add custom
   * source geometry for navigation mesh baking to this object.
   *
   * - `node` - The [Node] that is parsed.
   */
  @JvmStatic
  public final fun sourceGeometryParserSetCallback(parser: RID, callback: Callable): Unit {
    TransferContext.writeMethodArguments_RID_CALLABLE(ptr, objectID.id, parser, callback)
    TransferContext.callMethod(MethodBindings.sourceGeometryParserSetCallbackPtr)
  }

  /**
   * Returns a simplified version of [path] with less critical path points removed. The
   * simplification amount is in worlds units and controlled by [epsilon]. The simplification uses a
   * variant of Ramer-Douglas-Peucker algorithm for curve point decimation.
   *
   * Path simplification can be helpful to mitigate various path following issues that can arise
   * with certain agent types and script behaviors. E.g. "steering" agents or avoidance in "open
   * fields".
   */
  @JvmStatic
  public final fun simplifyPath(path: PackedVector3Array, epsilon: Float): PackedVector3Array {
    TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_DOUBLE(ptr, objectID.id, path, epsilon.toDouble())
    TransferContext.callMethod(MethodBindings.simplifyPathPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Destroys the given RID.
   */
  @JvmStatic
  public final fun freeRid(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.freeRidPtr)
  }

  /**
   * Control activation of this server.
   */
  @JvmStatic
  public final fun setActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, active)
    TransferContext.callMethod(MethodBindings.setActivePtr)
  }

  /**
   * If `true` enables debug mode on the NavigationServer.
   */
  @JvmStatic
  public final fun setDebugEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setDebugEnabledPtr)
  }

  /**
   * Returns `true` when the NavigationServer has debug enabled.
   */
  @JvmStatic
  public final fun getDebugEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDebugEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns information about the current state of the NavigationServer.
   */
  @JvmStatic
  public final fun getProcessInfo(processInfo: ProcessInfo): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, processInfo.value)
    TransferContext.callMethod(MethodBindings.getProcessInfoPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public enum class ProcessInfo(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to get the number of active navigation maps.
     */
    INFO_ACTIVE_MAPS(0),
    /**
     * Constant to get the number of active navigation regions.
     */
    INFO_REGION_COUNT(1),
    /**
     * Constant to get the number of active navigation agents processing avoidance.
     */
    INFO_AGENT_COUNT(2),
    /**
     * Constant to get the number of active navigation links.
     */
    INFO_LINK_COUNT(3),
    /**
     * Constant to get the number of navigation mesh polygons.
     */
    INFO_POLYGON_COUNT(4),
    /**
     * Constant to get the number of navigation mesh polygon edges.
     */
    INFO_EDGE_COUNT(5),
    /**
     * Constant to get the number of navigation mesh polygon edges that were merged due to edge key
     * overlap.
     */
    INFO_EDGE_MERGE_COUNT(6),
    /**
     * Constant to get the number of navigation mesh polygon edges that are considered connected by
     * edge proximity.
     */
    INFO_EDGE_CONNECTION_COUNT(7),
    /**
     * Constant to get the number of navigation mesh polygon edges that could not be merged but may
     * be still connected by edge proximity or with links.
     */
    INFO_EDGE_FREE_COUNT(8),
    /**
     * Constant to get the number of active navigation obstacles.
     */
    INFO_OBSTACLE_COUNT(9),
    ;

    public companion object {
      public fun from(`value`: Long): ProcessInfo = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val getMapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "get_maps", 3995934104)

    internal val mapCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_create", 529393457)

    internal val mapSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_active", 1265174801)

    internal val mapIsActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_is_active", 4155700596)

    internal val mapSetUpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_up", 3227306858)

    internal val mapGetUpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_up", 531438156)

    internal val mapSetCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_cell_size", 1794382983)

    internal val mapGetCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_cell_size", 866169185)

    internal val mapSetCellHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_cell_height", 1794382983)

    internal val mapGetCellHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_cell_height", 866169185)

    internal val mapSetMergeRasterizerCellScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_merge_rasterizer_cell_scale", 1794382983)

    internal val mapGetMergeRasterizerCellScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_merge_rasterizer_cell_scale", 866169185)

    internal val mapSetUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_use_edge_connections", 1265174801)

    internal val mapGetUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_use_edge_connections", 4155700596)

    internal val mapSetEdgeConnectionMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_edge_connection_margin", 1794382983)

    internal val mapGetEdgeConnectionMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_edge_connection_margin", 866169185)

    internal val mapSetLinkConnectionRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_link_connection_radius", 1794382983)

    internal val mapGetLinkConnectionRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_link_connection_radius", 866169185)

    internal val mapGetPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_path", 276783190)

    internal val mapGetClosestPointToSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_closest_point_to_segment", 3830095642)

    internal val mapGetClosestPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_closest_point", 2056183332)

    internal val mapGetClosestPointNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_closest_point_normal", 2056183332)

    internal val mapGetClosestPointOwnerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_closest_point_owner", 553364610)

    internal val mapGetLinksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_links", 2684255073)

    internal val mapGetRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_regions", 2684255073)

    internal val mapGetAgentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_agents", 2684255073)

    internal val mapGetObstaclesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_obstacles", 2684255073)

    internal val mapForceUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_force_update", 2722037293)

    internal val mapGetIterationIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_iteration_id", 2198884583)

    internal val mapSetUseAsyncIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_set_use_async_iterations", 1265174801)

    internal val mapGetUseAsyncIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_use_async_iterations", 4155700596)

    internal val mapGetRandomPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "map_get_random_point", 722801526)

    internal val queryPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "query_path", 2146930868)

    internal val regionCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_create", 529393457)

    internal val regionGetIterationIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_iteration_id", 2198884583)

    internal val regionSetUseAsyncIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_use_async_iterations", 1265174801)

    internal val regionGetUseAsyncIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_use_async_iterations", 4155700596)

    internal val regionSetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_enabled", 1265174801)

    internal val regionGetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_enabled", 4155700596)

    internal val regionSetUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_use_edge_connections", 1265174801)

    internal val regionGetUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_use_edge_connections", 4155700596)

    internal val regionSetEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_enter_cost", 1794382983)

    internal val regionGetEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_enter_cost", 866169185)

    internal val regionSetTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_travel_cost", 1794382983)

    internal val regionGetTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_travel_cost", 866169185)

    internal val regionSetOwnerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_owner_id", 3411492887)

    internal val regionGetOwnerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_owner_id", 2198884583)

    internal val regionOwnsPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_owns_point", 2360011153)

    internal val regionSetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_map", 395945892)

    internal val regionGetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_map", 3814569979)

    internal val regionSetNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_navigation_layers", 3411492887)

    internal val regionGetNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_navigation_layers", 2198884583)

    internal val regionSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_transform", 3935195649)

    internal val regionGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_transform", 1128465797)

    internal val regionSetNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_set_navigation_mesh", 2764952978)

    internal val regionBakeNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_bake_navigation_mesh", 1401173477)

    internal val regionGetConnectionsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_connections_count", 2198884583)

    internal val regionGetConnectionPathwayStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_connection_pathway_start", 3440143363)

    internal val regionGetConnectionPathwayEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_connection_pathway_end", 3440143363)

    internal val regionGetClosestPointToSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_closest_point_to_segment", 3830095642)

    internal val regionGetClosestPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_closest_point", 2056183332)

    internal val regionGetClosestPointNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_closest_point_normal", 2056183332)

    internal val regionGetRandomPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_random_point", 722801526)

    internal val regionGetBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "region_get_bounds", 974181306)

    internal val linkCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_create", 529393457)

    internal val linkGetIterationIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_iteration_id", 2198884583)

    internal val linkSetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_map", 395945892)

    internal val linkGetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_map", 3814569979)

    internal val linkSetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_enabled", 1265174801)

    internal val linkGetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_enabled", 4155700596)

    internal val linkSetBidirectionalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_bidirectional", 1265174801)

    internal val linkIsBidirectionalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_is_bidirectional", 4155700596)

    internal val linkSetNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_navigation_layers", 3411492887)

    internal val linkGetNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_navigation_layers", 2198884583)

    internal val linkSetStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_start_position", 3227306858)

    internal val linkGetStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_start_position", 531438156)

    internal val linkSetEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_end_position", 3227306858)

    internal val linkGetEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_end_position", 531438156)

    internal val linkSetEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_enter_cost", 1794382983)

    internal val linkGetEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_enter_cost", 866169185)

    internal val linkSetTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_travel_cost", 1794382983)

    internal val linkGetTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_travel_cost", 866169185)

    internal val linkSetOwnerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_set_owner_id", 3411492887)

    internal val linkGetOwnerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "link_get_owner_id", 2198884583)

    internal val agentCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_create", 529393457)

    internal val agentSetAvoidanceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_avoidance_enabled", 1265174801)

    internal val agentGetAvoidanceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_avoidance_enabled", 4155700596)

    internal val agentSetUse3dAvoidancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_use_3d_avoidance", 1265174801)

    internal val agentGetUse3dAvoidancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_use_3d_avoidance", 4155700596)

    internal val agentSetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_map", 395945892)

    internal val agentGetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_map", 3814569979)

    internal val agentSetPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_paused", 1265174801)

    internal val agentGetPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_paused", 4155700596)

    internal val agentSetNeighborDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_neighbor_distance", 1794382983)

    internal val agentGetNeighborDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_neighbor_distance", 866169185)

    internal val agentSetMaxNeighborsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_max_neighbors", 3411492887)

    internal val agentGetMaxNeighborsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_max_neighbors", 2198884583)

    internal val agentSetTimeHorizonAgentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_time_horizon_agents", 1794382983)

    internal val agentGetTimeHorizonAgentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_time_horizon_agents", 866169185)

    internal val agentSetTimeHorizonObstaclesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_time_horizon_obstacles", 1794382983)

    internal val agentGetTimeHorizonObstaclesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_time_horizon_obstacles", 866169185)

    internal val agentSetRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_radius", 1794382983)

    internal val agentGetRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_radius", 866169185)

    internal val agentSetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_height", 1794382983)

    internal val agentGetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_height", 866169185)

    internal val agentSetMaxSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_max_speed", 1794382983)

    internal val agentGetMaxSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_max_speed", 866169185)

    internal val agentSetVelocityForcedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_velocity_forced", 3227306858)

    internal val agentSetVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_velocity", 3227306858)

    internal val agentGetVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_velocity", 531438156)

    internal val agentSetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_position", 3227306858)

    internal val agentGetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_position", 531438156)

    internal val agentIsMapChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_is_map_changed", 4155700596)

    internal val agentSetAvoidanceCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_avoidance_callback", 3379118538)

    internal val agentHasAvoidanceCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_has_avoidance_callback", 4155700596)

    internal val agentSetAvoidanceLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_avoidance_layers", 3411492887)

    internal val agentGetAvoidanceLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_avoidance_layers", 2198884583)

    internal val agentSetAvoidanceMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_avoidance_mask", 3411492887)

    internal val agentGetAvoidanceMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_avoidance_mask", 2198884583)

    internal val agentSetAvoidancePriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_set_avoidance_priority", 1794382983)

    internal val agentGetAvoidancePriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "agent_get_avoidance_priority", 866169185)

    internal val obstacleCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_create", 529393457)

    internal val obstacleSetAvoidanceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_avoidance_enabled", 1265174801)

    internal val obstacleGetAvoidanceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_avoidance_enabled", 4155700596)

    internal val obstacleSetUse3dAvoidancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_use_3d_avoidance", 1265174801)

    internal val obstacleGetUse3dAvoidancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_use_3d_avoidance", 4155700596)

    internal val obstacleSetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_map", 395945892)

    internal val obstacleGetMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_map", 3814569979)

    internal val obstacleSetPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_paused", 1265174801)

    internal val obstacleGetPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_paused", 4155700596)

    internal val obstacleSetRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_radius", 1794382983)

    internal val obstacleGetRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_radius", 866169185)

    internal val obstacleSetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_height", 1794382983)

    internal val obstacleGetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_height", 866169185)

    internal val obstacleSetVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_velocity", 3227306858)

    internal val obstacleGetVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_velocity", 531438156)

    internal val obstacleSetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_position", 3227306858)

    internal val obstacleGetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_position", 531438156)

    internal val obstacleSetVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_vertices", 4030257846)

    internal val obstacleGetVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_vertices", 808965560)

    internal val obstacleSetAvoidanceLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_set_avoidance_layers", 3411492887)

    internal val obstacleGetAvoidanceLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "obstacle_get_avoidance_layers", 2198884583)

    internal val parseSourceGeometryDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "parse_source_geometry_data", 3172802542)

    internal val bakeFromSourceGeometryDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "bake_from_source_geometry_data", 1286748856)

    internal val bakeFromSourceGeometryDataAsyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "bake_from_source_geometry_data_async", 1286748856)

    internal val isBakingNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "is_baking_navigation_mesh", 3142026141)

    internal val sourceGeometryParserCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "source_geometry_parser_create", 529393457)

    internal val sourceGeometryParserSetCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "source_geometry_parser_set_callback", 3379118538)

    internal val simplifyPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "simplify_path", 2344122170)

    internal val freeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "free_rid", 2722037293)

    internal val setActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "set_active", 2586408642)

    internal val setDebugEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "set_debug_enabled", 2586408642)

    internal val getDebugEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "get_debug_enabled", 36873697)

    internal val getProcessInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationServer3D", "get_process_info", 1938440894)
  }
}
