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
import godot.core.MethodStringName6
import godot.core.PackedFloat32Array
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Transform2D
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
import godot.core.Vector2
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * PhysicsServer2D is the server responsible for all 2D physics. It can directly create and
 * manipulate all physics objects:
 *
 * - A *space* is a self-contained world for a physics simulation. It contains bodies, areas, and
 * joints. Its state can be queried for collision and intersection information, and several parameters
 * of the simulation can be modified.
 *
 * - A *shape* is a geometric shape such as a circle, a rectangle, a capsule, or a polygon. It can
 * be used for collision detection by adding it to a body/area, possibly with an extra transformation
 * relative to the body/area's origin. Bodies/areas can have multiple (transformed) shapes added to
 * them, and a single shape can be added to bodies/areas multiple times with different local
 * transformations.
 *
 * - A *body* is a physical object which can be in static, kinematic, or rigid mode. Its state (such
 * as position and velocity) can be queried and updated. A force integration callback can be set to
 * customize the body's physics.
 *
 * - An *area* is a region in space which can be used to detect bodies and areas entering and
 * exiting it. A body monitoring callback can be set to report entering/exiting body shapes, and
 * similarly an area monitoring callback can be set. Gravity and damping can be overridden within the
 * area by setting area parameters.
 *
 * - A *joint* is a constraint, either between two bodies or on one body relative to a point.
 * Parameters such as the joint bias and the rest length of a spring joint can be adjusted.
 *
 * Physics objects in [PhysicsServer2D] may be created and manipulated independently; they do not
 * have to be tied to nodes in the scene tree.
 *
 * **Note:** All the 2D physics nodes use the physics server internally. Adding a physics node to
 * the scene tree will cause a corresponding physics object to be created in the physics server. A
 * rigid body node registers a callback that updates the node's transform with the transform of the
 * respective body object in the physics server (every physics update). An area node registers a
 * callback to inform the area node about overlaps with the respective area object in the physics
 * server. The raycast node queries the direct state of the relevant space in the physics server.
 */
@GodotBaseType
public object PhysicsServer2D : Object() {
  @JvmField
  public val worldBoundaryShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("world_boundary_shape_create")

  @JvmField
  public val separationRayShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("separation_ray_shape_create")

  @JvmField
  public val segmentShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("segment_shape_create")

  @JvmField
  public val circleShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("circle_shape_create")

  @JvmField
  public val rectangleShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("rectangle_shape_create")

  @JvmField
  public val capsuleShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("capsule_shape_create")

  @JvmField
  public val convexPolygonShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("convex_polygon_shape_create")

  @JvmField
  public val concavePolygonShapeCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("concave_polygon_shape_create")

  @JvmField
  public val shapeSetDataName: MethodStringName2<PhysicsServer2D, Unit, RID, Any?> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Any?>("shape_set_data")

  @JvmField
  public val shapeGetTypeName: MethodStringName1<PhysicsServer2D, ShapeType, RID> =
      MethodStringName1<PhysicsServer2D, ShapeType, RID>("shape_get_type")

  @JvmField
  public val shapeGetDataName: MethodStringName1<PhysicsServer2D, Any?, RID> =
      MethodStringName1<PhysicsServer2D, Any?, RID>("shape_get_data")

  @JvmField
  public val spaceCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("space_create")

  @JvmField
  public val spaceSetActiveName: MethodStringName2<PhysicsServer2D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Boolean>("space_set_active")

  @JvmField
  public val spaceIsActiveName: MethodStringName1<PhysicsServer2D, Boolean, RID> =
      MethodStringName1<PhysicsServer2D, Boolean, RID>("space_is_active")

  @JvmField
  public val spaceSetParamName: MethodStringName3<PhysicsServer2D, Unit, RID, SpaceParameter, Float>
      = MethodStringName3<PhysicsServer2D, Unit, RID, SpaceParameter, Float>("space_set_param")

  @JvmField
  public val spaceGetParamName: MethodStringName2<PhysicsServer2D, Float, RID, SpaceParameter> =
      MethodStringName2<PhysicsServer2D, Float, RID, SpaceParameter>("space_get_param")

  @JvmField
  public val spaceGetDirectStateName:
      MethodStringName1<PhysicsServer2D, PhysicsDirectSpaceState2D?, RID> =
      MethodStringName1<PhysicsServer2D, PhysicsDirectSpaceState2D?, RID>("space_get_direct_state")

  @JvmField
  public val areaCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("area_create")

  @JvmField
  public val areaSetSpaceName: MethodStringName2<PhysicsServer2D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer2D, Unit, RID, RID>("area_set_space")

  @JvmField
  public val areaGetSpaceName: MethodStringName1<PhysicsServer2D, RID, RID> =
      MethodStringName1<PhysicsServer2D, RID, RID>("area_get_space")

  @JvmField
  public val areaAddShapeName:
      MethodStringName4<PhysicsServer2D, Unit, RID, RID, Transform2D, Boolean> =
      MethodStringName4<PhysicsServer2D, Unit, RID, RID, Transform2D, Boolean>("area_add_shape")

  @JvmField
  public val areaSetShapeName: MethodStringName3<PhysicsServer2D, Unit, RID, Int, RID> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, RID>("area_set_shape")

  @JvmField
  public val areaSetShapeTransformName:
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, Transform2D> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, Transform2D>("area_set_shape_transform")

  @JvmField
  public val areaSetShapeDisabledName: MethodStringName3<PhysicsServer2D, Unit, RID, Int, Boolean> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, Boolean>("area_set_shape_disabled")

  @JvmField
  public val areaGetShapeCountName: MethodStringName1<PhysicsServer2D, Int, RID> =
      MethodStringName1<PhysicsServer2D, Int, RID>("area_get_shape_count")

  @JvmField
  public val areaGetShapeName: MethodStringName2<PhysicsServer2D, RID, RID, Int> =
      MethodStringName2<PhysicsServer2D, RID, RID, Int>("area_get_shape")

  @JvmField
  public val areaGetShapeTransformName: MethodStringName2<PhysicsServer2D, Transform2D, RID, Int> =
      MethodStringName2<PhysicsServer2D, Transform2D, RID, Int>("area_get_shape_transform")

  @JvmField
  public val areaRemoveShapeName: MethodStringName2<PhysicsServer2D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Int>("area_remove_shape")

  @JvmField
  public val areaClearShapesName: MethodStringName1<PhysicsServer2D, Unit, RID> =
      MethodStringName1<PhysicsServer2D, Unit, RID>("area_clear_shapes")

  @JvmField
  public val areaSetCollisionLayerName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("area_set_collision_layer")

  @JvmField
  public val areaGetCollisionLayerName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("area_get_collision_layer")

  @JvmField
  public val areaSetCollisionMaskName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("area_set_collision_mask")

  @JvmField
  public val areaGetCollisionMaskName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("area_get_collision_mask")

  @JvmField
  public val areaSetParamName: MethodStringName3<PhysicsServer2D, Unit, RID, AreaParameter, Any?> =
      MethodStringName3<PhysicsServer2D, Unit, RID, AreaParameter, Any?>("area_set_param")

  @JvmField
  public val areaSetTransformName: MethodStringName2<PhysicsServer2D, Unit, RID, Transform2D> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Transform2D>("area_set_transform")

  @JvmField
  public val areaGetParamName: MethodStringName2<PhysicsServer2D, Any?, RID, AreaParameter> =
      MethodStringName2<PhysicsServer2D, Any?, RID, AreaParameter>("area_get_param")

  @JvmField
  public val areaGetTransformName: MethodStringName1<PhysicsServer2D, Transform2D, RID> =
      MethodStringName1<PhysicsServer2D, Transform2D, RID>("area_get_transform")

  @JvmField
  public val areaAttachObjectInstanceIdName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("area_attach_object_instance_id")

  @JvmField
  public val areaGetObjectInstanceIdName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("area_get_object_instance_id")

  @JvmField
  public val areaAttachCanvasInstanceIdName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("area_attach_canvas_instance_id")

  @JvmField
  public val areaGetCanvasInstanceIdName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("area_get_canvas_instance_id")

  @JvmField
  public val areaSetMonitorCallbackName: MethodStringName2<PhysicsServer2D, Unit, RID, Callable> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Callable>("area_set_monitor_callback")

  @JvmField
  public val areaSetAreaMonitorCallbackName: MethodStringName2<PhysicsServer2D, Unit, RID, Callable>
      = MethodStringName2<PhysicsServer2D, Unit, RID, Callable>("area_set_area_monitor_callback")

  @JvmField
  public val areaSetMonitorableName: MethodStringName2<PhysicsServer2D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Boolean>("area_set_monitorable")

  @JvmField
  public val bodyCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("body_create")

  @JvmField
  public val bodySetSpaceName: MethodStringName2<PhysicsServer2D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer2D, Unit, RID, RID>("body_set_space")

  @JvmField
  public val bodyGetSpaceName: MethodStringName1<PhysicsServer2D, RID, RID> =
      MethodStringName1<PhysicsServer2D, RID, RID>("body_get_space")

  @JvmField
  public val bodySetModeName: MethodStringName2<PhysicsServer2D, Unit, RID, BodyMode> =
      MethodStringName2<PhysicsServer2D, Unit, RID, BodyMode>("body_set_mode")

  @JvmField
  public val bodyGetModeName: MethodStringName1<PhysicsServer2D, BodyMode, RID> =
      MethodStringName1<PhysicsServer2D, BodyMode, RID>("body_get_mode")

  @JvmField
  public val bodyAddShapeName:
      MethodStringName4<PhysicsServer2D, Unit, RID, RID, Transform2D, Boolean> =
      MethodStringName4<PhysicsServer2D, Unit, RID, RID, Transform2D, Boolean>("body_add_shape")

  @JvmField
  public val bodySetShapeName: MethodStringName3<PhysicsServer2D, Unit, RID, Int, RID> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, RID>("body_set_shape")

  @JvmField
  public val bodySetShapeTransformName:
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, Transform2D> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, Transform2D>("body_set_shape_transform")

  @JvmField
  public val bodyGetShapeCountName: MethodStringName1<PhysicsServer2D, Int, RID> =
      MethodStringName1<PhysicsServer2D, Int, RID>("body_get_shape_count")

  @JvmField
  public val bodyGetShapeName: MethodStringName2<PhysicsServer2D, RID, RID, Int> =
      MethodStringName2<PhysicsServer2D, RID, RID, Int>("body_get_shape")

  @JvmField
  public val bodyGetShapeTransformName: MethodStringName2<PhysicsServer2D, Transform2D, RID, Int> =
      MethodStringName2<PhysicsServer2D, Transform2D, RID, Int>("body_get_shape_transform")

  @JvmField
  public val bodyRemoveShapeName: MethodStringName2<PhysicsServer2D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Int>("body_remove_shape")

  @JvmField
  public val bodyClearShapesName: MethodStringName1<PhysicsServer2D, Unit, RID> =
      MethodStringName1<PhysicsServer2D, Unit, RID>("body_clear_shapes")

  @JvmField
  public val bodySetShapeDisabledName: MethodStringName3<PhysicsServer2D, Unit, RID, Int, Boolean> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Int, Boolean>("body_set_shape_disabled")

  @JvmField
  public val bodySetShapeAsOneWayCollisionName:
      MethodStringName5<PhysicsServer2D, Unit, RID, Int, Boolean, Float, Vector2> =
      MethodStringName5<PhysicsServer2D, Unit, RID, Int, Boolean, Float, Vector2>("body_set_shape_as_one_way_collision")

  @JvmField
  public val bodyAttachObjectInstanceIdName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("body_attach_object_instance_id")

  @JvmField
  public val bodyGetObjectInstanceIdName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("body_get_object_instance_id")

  @JvmField
  public val bodyAttachCanvasInstanceIdName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("body_attach_canvas_instance_id")

  @JvmField
  public val bodyGetCanvasInstanceIdName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("body_get_canvas_instance_id")

  @JvmField
  public val bodySetContinuousCollisionDetectionModeName:
      MethodStringName2<PhysicsServer2D, Unit, RID, CCDMode> =
      MethodStringName2<PhysicsServer2D, Unit, RID, CCDMode>("body_set_continuous_collision_detection_mode")

  @JvmField
  public val bodyGetContinuousCollisionDetectionModeName:
      MethodStringName1<PhysicsServer2D, CCDMode, RID> =
      MethodStringName1<PhysicsServer2D, CCDMode, RID>("body_get_continuous_collision_detection_mode")

  @JvmField
  public val bodySetCollisionLayerName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("body_set_collision_layer")

  @JvmField
  public val bodyGetCollisionLayerName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("body_get_collision_layer")

  @JvmField
  public val bodySetCollisionMaskName: MethodStringName2<PhysicsServer2D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Long>("body_set_collision_mask")

  @JvmField
  public val bodyGetCollisionMaskName: MethodStringName1<PhysicsServer2D, Long, RID> =
      MethodStringName1<PhysicsServer2D, Long, RID>("body_get_collision_mask")

  @JvmField
  public val bodySetCollisionPriorityName: MethodStringName2<PhysicsServer2D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Float>("body_set_collision_priority")

  @JvmField
  public val bodyGetCollisionPriorityName: MethodStringName1<PhysicsServer2D, Float, RID> =
      MethodStringName1<PhysicsServer2D, Float, RID>("body_get_collision_priority")

  @JvmField
  public val bodySetParamName: MethodStringName3<PhysicsServer2D, Unit, RID, BodyParameter, Any?> =
      MethodStringName3<PhysicsServer2D, Unit, RID, BodyParameter, Any?>("body_set_param")

  @JvmField
  public val bodyGetParamName: MethodStringName2<PhysicsServer2D, Any?, RID, BodyParameter> =
      MethodStringName2<PhysicsServer2D, Any?, RID, BodyParameter>("body_get_param")

  @JvmField
  public val bodyResetMassPropertiesName: MethodStringName1<PhysicsServer2D, Unit, RID> =
      MethodStringName1<PhysicsServer2D, Unit, RID>("body_reset_mass_properties")

  @JvmField
  public val bodySetStateName: MethodStringName3<PhysicsServer2D, Unit, RID, BodyState, Any?> =
      MethodStringName3<PhysicsServer2D, Unit, RID, BodyState, Any?>("body_set_state")

  @JvmField
  public val bodyGetStateName: MethodStringName2<PhysicsServer2D, Any?, RID, BodyState> =
      MethodStringName2<PhysicsServer2D, Any?, RID, BodyState>("body_get_state")

  @JvmField
  public val bodyApplyCentralImpulseName: MethodStringName2<PhysicsServer2D, Unit, RID, Vector2> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Vector2>("body_apply_central_impulse")

  @JvmField
  public val bodyApplyTorqueImpulseName: MethodStringName2<PhysicsServer2D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Float>("body_apply_torque_impulse")

  @JvmField
  public val bodyApplyImpulseName: MethodStringName3<PhysicsServer2D, Unit, RID, Vector2, Vector2> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Vector2, Vector2>("body_apply_impulse")

  @JvmField
  public val bodyApplyCentralForceName: MethodStringName2<PhysicsServer2D, Unit, RID, Vector2> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Vector2>("body_apply_central_force")

  @JvmField
  public val bodyApplyForceName: MethodStringName3<PhysicsServer2D, Unit, RID, Vector2, Vector2> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Vector2, Vector2>("body_apply_force")

  @JvmField
  public val bodyApplyTorqueName: MethodStringName2<PhysicsServer2D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Float>("body_apply_torque")

  @JvmField
  public val bodyAddConstantCentralForceName: MethodStringName2<PhysicsServer2D, Unit, RID, Vector2>
      = MethodStringName2<PhysicsServer2D, Unit, RID, Vector2>("body_add_constant_central_force")

  @JvmField
  public val bodyAddConstantForceName:
      MethodStringName3<PhysicsServer2D, Unit, RID, Vector2, Vector2> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Vector2, Vector2>("body_add_constant_force")

  @JvmField
  public val bodyAddConstantTorqueName: MethodStringName2<PhysicsServer2D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Float>("body_add_constant_torque")

  @JvmField
  public val bodySetConstantForceName: MethodStringName2<PhysicsServer2D, Unit, RID, Vector2> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Vector2>("body_set_constant_force")

  @JvmField
  public val bodyGetConstantForceName: MethodStringName1<PhysicsServer2D, Vector2, RID> =
      MethodStringName1<PhysicsServer2D, Vector2, RID>("body_get_constant_force")

  @JvmField
  public val bodySetConstantTorqueName: MethodStringName2<PhysicsServer2D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Float>("body_set_constant_torque")

  @JvmField
  public val bodyGetConstantTorqueName: MethodStringName1<PhysicsServer2D, Float, RID> =
      MethodStringName1<PhysicsServer2D, Float, RID>("body_get_constant_torque")

  @JvmField
  public val bodySetAxisVelocityName: MethodStringName2<PhysicsServer2D, Unit, RID, Vector2> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Vector2>("body_set_axis_velocity")

  @JvmField
  public val bodyAddCollisionExceptionName: MethodStringName2<PhysicsServer2D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer2D, Unit, RID, RID>("body_add_collision_exception")

  @JvmField
  public val bodyRemoveCollisionExceptionName: MethodStringName2<PhysicsServer2D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer2D, Unit, RID, RID>("body_remove_collision_exception")

  @JvmField
  public val bodySetMaxContactsReportedName: MethodStringName2<PhysicsServer2D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Int>("body_set_max_contacts_reported")

  @JvmField
  public val bodyGetMaxContactsReportedName: MethodStringName1<PhysicsServer2D, Int, RID> =
      MethodStringName1<PhysicsServer2D, Int, RID>("body_get_max_contacts_reported")

  @JvmField
  public val bodySetOmitForceIntegrationName: MethodStringName2<PhysicsServer2D, Unit, RID, Boolean>
      = MethodStringName2<PhysicsServer2D, Unit, RID, Boolean>("body_set_omit_force_integration")

  @JvmField
  public val bodyIsOmittingForceIntegrationName: MethodStringName1<PhysicsServer2D, Boolean, RID> =
      MethodStringName1<PhysicsServer2D, Boolean, RID>("body_is_omitting_force_integration")

  @JvmField
  public val bodySetStateSyncCallbackName: MethodStringName2<PhysicsServer2D, Unit, RID, Callable> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Callable>("body_set_state_sync_callback")

  @JvmField
  public val bodySetForceIntegrationCallbackName:
      MethodStringName3<PhysicsServer2D, Unit, RID, Callable, Any?> =
      MethodStringName3<PhysicsServer2D, Unit, RID, Callable, Any?>("body_set_force_integration_callback")

  @JvmField
  public val bodyTestMotionName:
      MethodStringName3<PhysicsServer2D, Boolean, RID, PhysicsTestMotionParameters2D, PhysicsTestMotionResult2D?>
      =
      MethodStringName3<PhysicsServer2D, Boolean, RID, PhysicsTestMotionParameters2D, PhysicsTestMotionResult2D?>("body_test_motion")

  @JvmField
  public val bodyGetDirectStateName:
      MethodStringName1<PhysicsServer2D, PhysicsDirectBodyState2D?, RID> =
      MethodStringName1<PhysicsServer2D, PhysicsDirectBodyState2D?, RID>("body_get_direct_state")

  @JvmField
  public val jointCreateName: MethodStringName0<PhysicsServer2D, RID> =
      MethodStringName0<PhysicsServer2D, RID>("joint_create")

  @JvmField
  public val jointClearName: MethodStringName1<PhysicsServer2D, Unit, RID> =
      MethodStringName1<PhysicsServer2D, Unit, RID>("joint_clear")

  @JvmField
  public val jointSetParamName: MethodStringName3<PhysicsServer2D, Unit, RID, JointParam, Float> =
      MethodStringName3<PhysicsServer2D, Unit, RID, JointParam, Float>("joint_set_param")

  @JvmField
  public val jointGetParamName: MethodStringName2<PhysicsServer2D, Float, RID, JointParam> =
      MethodStringName2<PhysicsServer2D, Float, RID, JointParam>("joint_get_param")

  @JvmField
  public val jointDisableCollisionsBetweenBodiesName:
      MethodStringName2<PhysicsServer2D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer2D, Unit, RID, Boolean>("joint_disable_collisions_between_bodies")

  @JvmField
  public val jointIsDisabledCollisionsBetweenBodiesName:
      MethodStringName1<PhysicsServer2D, Boolean, RID> =
      MethodStringName1<PhysicsServer2D, Boolean, RID>("joint_is_disabled_collisions_between_bodies")

  @JvmField
  public val jointMakePinName: MethodStringName4<PhysicsServer2D, Unit, RID, Vector2, RID, RID> =
      MethodStringName4<PhysicsServer2D, Unit, RID, Vector2, RID, RID>("joint_make_pin")

  @JvmField
  public val jointMakeGrooveName:
      MethodStringName6<PhysicsServer2D, Unit, RID, Vector2, Vector2, Vector2, RID, RID> =
      MethodStringName6<PhysicsServer2D, Unit, RID, Vector2, Vector2, Vector2, RID, RID>("joint_make_groove")

  @JvmField
  public val jointMakeDampedSpringName:
      MethodStringName5<PhysicsServer2D, Unit, RID, Vector2, Vector2, RID, RID> =
      MethodStringName5<PhysicsServer2D, Unit, RID, Vector2, Vector2, RID, RID>("joint_make_damped_spring")

  @JvmField
  public val pinJointSetFlagName:
      MethodStringName3<PhysicsServer2D, Unit, RID, PinJointFlag, Boolean> =
      MethodStringName3<PhysicsServer2D, Unit, RID, PinJointFlag, Boolean>("pin_joint_set_flag")

  @JvmField
  public val pinJointGetFlagName: MethodStringName2<PhysicsServer2D, Boolean, RID, PinJointFlag> =
      MethodStringName2<PhysicsServer2D, Boolean, RID, PinJointFlag>("pin_joint_get_flag")

  @JvmField
  public val pinJointSetParamName:
      MethodStringName3<PhysicsServer2D, Unit, RID, PinJointParam, Float> =
      MethodStringName3<PhysicsServer2D, Unit, RID, PinJointParam, Float>("pin_joint_set_param")

  @JvmField
  public val pinJointGetParamName: MethodStringName2<PhysicsServer2D, Float, RID, PinJointParam> =
      MethodStringName2<PhysicsServer2D, Float, RID, PinJointParam>("pin_joint_get_param")

  @JvmField
  public val dampedSpringJointSetParamName:
      MethodStringName3<PhysicsServer2D, Unit, RID, DampedSpringParam, Float> =
      MethodStringName3<PhysicsServer2D, Unit, RID, DampedSpringParam, Float>("damped_spring_joint_set_param")

  @JvmField
  public val dampedSpringJointGetParamName:
      MethodStringName2<PhysicsServer2D, Float, RID, DampedSpringParam> =
      MethodStringName2<PhysicsServer2D, Float, RID, DampedSpringParam>("damped_spring_joint_get_param")

  @JvmField
  public val jointGetTypeName: MethodStringName1<PhysicsServer2D, JointType, RID> =
      MethodStringName1<PhysicsServer2D, JointType, RID>("joint_get_type")

  @JvmField
  public val freeRidName: MethodStringName1<PhysicsServer2D, Unit, RID> =
      MethodStringName1<PhysicsServer2D, Unit, RID>("free_rid")

  @JvmField
  public val setActiveName: MethodStringName1<PhysicsServer2D, Unit, Boolean> =
      MethodStringName1<PhysicsServer2D, Unit, Boolean>("set_active")

  @JvmField
  public val getProcessInfoName: MethodStringName1<PhysicsServer2D, Int, ProcessInfo> =
      MethodStringName1<PhysicsServer2D, Int, ProcessInfo>("get_process_info")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(24)
  }

  /**
   * Creates a 2D world boundary shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the shape's normal direction and distance properties.
   */
  @JvmStatic
  public final fun worldBoundaryShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.worldBoundaryShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D separation ray shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the shape's `length` and `slide_on_slope` properties.
   */
  @JvmStatic
  public final fun separationRayShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.separationRayShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D segment shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the segment's start and end points.
   */
  @JvmStatic
  public final fun segmentShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.segmentShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D circle shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the circle's radius.
   */
  @JvmStatic
  public final fun circleShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.circleShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D rectangle shape in the physics server, and returns the [RID] that identifies it.
   * Use [shapeSetData] to set the rectangle's half-extents.
   */
  @JvmStatic
  public final fun rectangleShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.rectangleShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D capsule shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the capsule's height and radius.
   */
  @JvmStatic
  public final fun capsuleShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.capsuleShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D convex polygon shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the convex polygon's points.
   */
  @JvmStatic
  public final fun convexPolygonShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.convexPolygonShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2D concave polygon shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the concave polygon's segments.
   */
  @JvmStatic
  public final fun concavePolygonShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.concavePolygonShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the shape data that defines the configuration of the shape. The [data] to be passed
   * depends on the shape's type (see [shapeGetType]):
   *
   * - [SHAPE_WORLD_BOUNDARY]: an array of length two containing a [Vector2] `normal` direction and
   * a [Double] distance `d`,
   *
   * - [SHAPE_SEPARATION_RAY]: a dictionary containing the key `length` with a [Double] value and
   * the key `slide_on_slope` with a [Boolean] value,
   *
   * - [SHAPE_SEGMENT]: a [Rect2] `rect` containing the first point of the segment in
   * `rect.position` and the second point of the segment in `rect.size`,
   *
   * - [SHAPE_CIRCLE]: a [Double] `radius`,
   *
   * - [SHAPE_RECTANGLE]: a [Vector2] `half_extents`,
   *
   * - [SHAPE_CAPSULE]: an array of length two (or a [Vector2]) containing a [Double] `height` and a
   * [Double] `radius`,
   *
   * - [SHAPE_CONVEX_POLYGON]: either a [PackedVector2Array] of points defining a convex polygon in
   * counterclockwise order (the clockwise outward normal of each segment formed by consecutive points
   * is calculated internally), or a [PackedFloat32Array] of length divisible by four so that every
   * 4-tuple of [Double]s contains the coordinates of a point followed by the coordinates of the
   * clockwise outward normal vector to the segment between the current point and the next point,
   *
   * - [SHAPE_CONCAVE_POLYGON]: a [PackedVector2Array] of length divisible by two (each pair of
   * points forms one segment).
   *
   * **Warning:** In the case of [SHAPE_CONVEX_POLYGON], this method does not check if the points
   * supplied actually form a convex polygon (unlike the [CollisionPolygon2D.polygon] property).
   */
  @JvmStatic
  public final fun shapeSetData(shape: RID, `data`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape, ANY to data)
    TransferContext.callMethod(MethodBindings.shapeSetDataPtr)
  }

  /**
   * Returns the shape's type.
   */
  @JvmStatic
  public final fun shapeGetType(shape: RID): ShapeType {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape)
    TransferContext.callMethod(MethodBindings.shapeGetTypePtr)
    return ShapeType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the shape data that defines the configuration of the shape, such as the half-extents of
   * a rectangle or the segments of a concave shape. See [shapeSetData] for the precise format of this
   * data in each case.
   */
  @JvmStatic
  public final fun shapeGetData(shape: RID): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape)
    TransferContext.callMethod(MethodBindings.shapeGetDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Creates a 2D space in the physics server, and returns the [RID] that identifies it. A space
   * contains bodies and areas, and controls the stepping of the physics simulation of the objects in
   * it.
   */
  @JvmStatic
  public final fun spaceCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.spaceCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Activates or deactivates the space. If [active] is `false`, then the physics server will not do
   * anything with this space in its physics step.
   */
  @JvmStatic
  public final fun spaceSetActive(space: RID, active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space, BOOL to active)
    TransferContext.callMethod(MethodBindings.spaceSetActivePtr)
  }

  /**
   * Returns `true` if the space is active.
   */
  @JvmStatic
  public final fun spaceIsActive(space: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space)
    TransferContext.callMethod(MethodBindings.spaceIsActivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the value of the given space parameter.
   */
  @JvmStatic
  public final fun spaceSetParam(
    space: RID,
    `param`: SpaceParameter,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.spaceSetParamPtr)
  }

  /**
   * Returns the value of the given space parameter.
   */
  @JvmStatic
  public final fun spaceGetParam(space: RID, `param`: SpaceParameter): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space, LONG to param.value)
    TransferContext.callMethod(MethodBindings.spaceGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the state of a space, a [PhysicsDirectSpaceState2D]. This object can be used for
   * collision/intersection queries.
   */
  @JvmStatic
  public final fun spaceGetDirectState(space: RID): PhysicsDirectSpaceState2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space)
    TransferContext.callMethod(MethodBindings.spaceGetDirectStatePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsDirectSpaceState2D?)
  }

  /**
   * Creates a 2D area object in the physics server, and returns the [RID] that identifies it. The
   * default settings for the created area include a collision layer and mask set to `1`, and
   * `monitorable` set to `false`.
   *
   * Use [areaAddShape] to add shapes to it, use [areaSetTransform] to set its transform, and use
   * [areaSetSpace] to add the area to a space. If you want the area to be detectable use
   * [areaSetMonitorable].
   */
  @JvmStatic
  public final fun areaCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areaCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Adds the area to the given space, after removing the area from the previously assigned space
   * (if any).
   *
   * **Note:** To remove an area from a space without immediately adding it back elsewhere, use
   * `PhysicsServer2D.area_set_space(area, RID())`.
   */
  @JvmStatic
  public final fun areaSetSpace(area: RID, space: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, _RID to space)
    TransferContext.callMethod(MethodBindings.areaSetSpacePtr)
  }

  /**
   * Returns the [RID] of the space assigned to the area. Returns an empty [RID] if no space is
   * assigned.
   */
  @JvmStatic
  public final fun areaGetSpace(area: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetSpacePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Adds a shape to the area, with the given local transform. The shape (together with its
   * [transform] and [disabled] properties) is added to an array of shapes, and the shapes of an area
   * are usually referenced by their index in this array.
   */
  @JvmOverloads
  @JvmStatic
  public final fun areaAddShape(
    area: RID,
    shape: RID,
    transform: Transform2D = Transform2D(),
    disabled: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, _RID to shape, TRANSFORM2D to transform, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.areaAddShapePtr)
  }

  /**
   * Replaces the area's shape at the given index by another shape, while not affecting the
   * `transform` and `disabled` properties at the same index.
   */
  @JvmStatic
  public final fun areaSetShape(
    area: RID,
    shapeIdx: Int,
    shape: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong(), _RID to shape)
    TransferContext.callMethod(MethodBindings.areaSetShapePtr)
  }

  /**
   * Sets the local transform matrix of the area's shape with the given index.
   */
  @JvmStatic
  public final fun areaSetShapeTransform(
    area: RID,
    shapeIdx: Int,
    transform: Transform2D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong(), TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.areaSetShapeTransformPtr)
  }

  /**
   * Sets the disabled property of the area's shape with the given index. If [disabled] is `true`,
   * then the shape will not detect any other shapes entering or exiting it.
   */
  @JvmStatic
  public final fun areaSetShapeDisabled(
    area: RID,
    shapeIdx: Int,
    disabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.areaSetShapeDisabledPtr)
  }

  /**
   * Returns the number of shapes added to the area.
   */
  @JvmStatic
  public final fun areaGetShapeCount(area: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [RID] of the shape with the given index in the area's array of shapes.
   */
  @JvmStatic
  public final fun areaGetShape(area: RID, shapeIdx: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.areaGetShapePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the local transform matrix of the shape with the given index in the area's array of
   * shapes.
   */
  @JvmStatic
  public final fun areaGetShapeTransform(area: RID, shapeIdx: Int): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.areaGetShapeTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Removes the shape with the given index from the area's array of shapes. The shape itself is not
   * deleted, so it can continue to be used elsewhere or added back later. As a result of this
   * operation, the area's shapes which used to have indices higher than [shapeIdx] will have their
   * index decreased by one.
   */
  @JvmStatic
  public final fun areaRemoveShape(area: RID, shapeIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.areaRemoveShapePtr)
  }

  /**
   * Removes all shapes from the area. This does not delete the shapes themselves, so they can
   * continue to be used elsewhere or added back later.
   */
  @JvmStatic
  public final fun areaClearShapes(area: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaClearShapesPtr)
  }

  /**
   * Assigns the area to one or many physics layers, via a bitmask.
   */
  @JvmStatic
  public final fun areaSetCollisionLayer(area: RID, layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to layer)
    TransferContext.callMethod(MethodBindings.areaSetCollisionLayerPtr)
  }

  /**
   * Returns the physics layer or layers the area belongs to, as a bitmask.
   */
  @JvmStatic
  public final fun areaGetCollisionLayer(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets which physics layers the area will monitor, via a bitmask.
   */
  @JvmStatic
  public final fun areaSetCollisionMask(area: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to mask)
    TransferContext.callMethod(MethodBindings.areaSetCollisionMaskPtr)
  }

  /**
   * Returns the physics layer or layers the area can contact with, as a bitmask.
   */
  @JvmStatic
  public final fun areaGetCollisionMask(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the value of the given area parameter.
   */
  @JvmStatic
  public final fun areaSetParam(
    area: RID,
    `param`: AreaParameter,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to param.value, ANY to value)
    TransferContext.callMethod(MethodBindings.areaSetParamPtr)
  }

  /**
   * Sets the transform matrix of the area.
   */
  @JvmStatic
  public final fun areaSetTransform(area: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.areaSetTransformPtr)
  }

  /**
   * Returns the value of the given area parameter.
   */
  @JvmStatic
  public final fun areaGetParam(area: RID, `param`: AreaParameter): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to param.value)
    TransferContext.callMethod(MethodBindings.areaGetParamPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the transform matrix of the area.
   */
  @JvmStatic
  public final fun areaGetTransform(area: RID): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Attaches the `ObjectID` of an [Object] to the area. Use [Object.getInstanceId] to get the
   * `ObjectID` of a [CollisionObject2D].
   */
  @JvmStatic
  public final fun areaAttachObjectInstanceId(area: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to id)
    TransferContext.callMethod(MethodBindings.areaAttachObjectInstanceIdPtr)
  }

  /**
   * Returns the `ObjectID` attached to the area. Use [@GlobalScope.instanceFromId] to retrieve an
   * [Object] from a nonzero `ObjectID`.
   */
  @JvmStatic
  public final fun areaGetObjectInstanceId(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetObjectInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Attaches the `ObjectID` of a canvas to the area. Use [Object.getInstanceId] to get the
   * `ObjectID` of a [CanvasLayer].
   */
  @JvmStatic
  public final fun areaAttachCanvasInstanceId(area: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to id)
    TransferContext.callMethod(MethodBindings.areaAttachCanvasInstanceIdPtr)
  }

  /**
   * Returns the `ObjectID` of the canvas attached to the area. Use [@GlobalScope.instanceFromId] to
   * retrieve a [CanvasLayer] from a nonzero `ObjectID`.
   */
  @JvmStatic
  public final fun areaGetCanvasInstanceId(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetCanvasInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the area's body monitor callback. This callback will be called when any other (shape of a)
   * body enters or exits (a shape of) the given area, and must take the following five parameters:
   *
   * 1. an integer `status`: either [AREA_BODY_ADDED] or [AREA_BODY_REMOVED] depending on whether
   * the other body shape entered or exited the area,
   *
   * 2. an [RID] `body_rid`: the [RID] of the body that entered or exited the area,
   *
   * 3. an integer `instance_id`: the `ObjectID` attached to the body,
   *
   * 4. an integer `body_shape_idx`: the index of the shape of the body that entered or exited the
   * area,
   *
   * 5. an integer `self_shape_idx`: the index of the shape of the area where the body entered or
   * exited.
   *
   * By counting (or keeping track of) the shapes that enter and exit, it can be determined if a
   * body (with all its shapes) is entering for the first time or exiting for the last time.
   */
  @JvmStatic
  public final fun areaSetMonitorCallback(area: RID, callback: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.areaSetMonitorCallbackPtr)
  }

  /**
   * Sets the area's area monitor callback. This callback will be called when any other (shape of
   * an) area enters or exits (a shape of) the given area, and must take the following five parameters:
   *
   * 1. an integer `status`: either [AREA_BODY_ADDED] or [AREA_BODY_REMOVED] depending on whether
   * the other area's shape entered or exited the area,
   *
   * 2. an [RID] `area_rid`: the [RID] of the other area that entered or exited the area,
   *
   * 3. an integer `instance_id`: the `ObjectID` attached to the other area,
   *
   * 4. an integer `area_shape_idx`: the index of the shape of the other area that entered or exited
   * the area,
   *
   * 5. an integer `self_shape_idx`: the index of the shape of the area where the other area entered
   * or exited.
   *
   * By counting (or keeping track of) the shapes that enter and exit, it can be determined if an
   * area (with all its shapes) is entering for the first time or exiting for the last time.
   */
  @JvmStatic
  public final fun areaSetAreaMonitorCallback(area: RID, callback: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.areaSetAreaMonitorCallbackPtr)
  }

  /**
   * Sets whether the area is monitorable or not. If [monitorable] is `true`, the area monitoring
   * callback of other areas will be called when this area enters or exits them.
   */
  @JvmStatic
  public final fun areaSetMonitorable(area: RID, monitorable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, BOOL to monitorable)
    TransferContext.callMethod(MethodBindings.areaSetMonitorablePtr)
  }

  /**
   * Creates a 2D body object in the physics server, and returns the [RID] that identifies it. The
   * default settings for the created area include a collision layer and mask set to `1`, and body mode
   * set to [BODY_MODE_RIGID].
   *
   * Use [bodyAddShape] to add shapes to it, use [bodySetState] to set its transform, and use
   * [bodySetSpace] to add the body to a space.
   */
  @JvmStatic
  public final fun bodyCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.bodyCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Adds the body to the given space, after removing the body from the previously assigned space
   * (if any). If the body's mode is set to [BODY_MODE_RIGID], then adding the body to a space will
   * have the following additional effects:
   *
   * - If the parameter [BODY_PARAM_CENTER_OF_MASS] has never been set explicitly, then the value of
   * that parameter will be recalculated based on the body's shapes.
   *
   * - If the parameter [BODY_PARAM_INERTIA] is set to a value `<= 0.0`, then the value of that
   * parameter will be recalculated based on the body's shapes, mass, and center of mass.
   *
   * **Note:** To remove a body from a space without immediately adding it back elsewhere, use
   * `PhysicsServer2D.body_set_space(body, RID())`.
   */
  @JvmStatic
  public final fun bodySetSpace(body: RID, space: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to space)
    TransferContext.callMethod(MethodBindings.bodySetSpacePtr)
  }

  /**
   * Returns the [RID] of the space assigned to the body. Returns an empty [RID] if no space is
   * assigned.
   */
  @JvmStatic
  public final fun bodyGetSpace(body: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetSpacePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the body's mode.
   */
  @JvmStatic
  public final fun bodySetMode(body: RID, mode: BodyMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.bodySetModePtr)
  }

  /**
   * Returns the body's mode.
   */
  @JvmStatic
  public final fun bodyGetMode(body: RID): BodyMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetModePtr)
    return BodyMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Adds a shape to the area, with the given local transform. The shape (together with its
   * [transform] and [disabled] properties) is added to an array of shapes, and the shapes of a body
   * are usually referenced by their index in this array.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyAddShape(
    body: RID,
    shape: RID,
    transform: Transform2D = Transform2D(),
    disabled: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to shape, TRANSFORM2D to transform, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.bodyAddShapePtr)
  }

  /**
   * Replaces the body's shape at the given index by another shape, while not affecting the
   * `transform`, `disabled`, and one-way collision properties at the same index.
   */
  @JvmStatic
  public final fun bodySetShape(
    body: RID,
    shapeIdx: Int,
    shape: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong(), _RID to shape)
    TransferContext.callMethod(MethodBindings.bodySetShapePtr)
  }

  /**
   * Sets the local transform matrix of the body's shape with the given index.
   */
  @JvmStatic
  public final fun bodySetShapeTransform(
    body: RID,
    shapeIdx: Int,
    transform: Transform2D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong(), TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.bodySetShapeTransformPtr)
  }

  /**
   * Returns the number of shapes added to the body.
   */
  @JvmStatic
  public final fun bodyGetShapeCount(body: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [RID] of the shape with the given index in the body's array of shapes.
   */
  @JvmStatic
  public final fun bodyGetShape(body: RID, shapeIdx: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.bodyGetShapePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the local transform matrix of the shape with the given index in the area's array of
   * shapes.
   */
  @JvmStatic
  public final fun bodyGetShapeTransform(body: RID, shapeIdx: Int): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.bodyGetShapeTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Removes the shape with the given index from the body's array of shapes. The shape itself is not
   * deleted, so it can continue to be used elsewhere or added back later. As a result of this
   * operation, the body's shapes which used to have indices higher than [shapeIdx] will have their
   * index decreased by one.
   */
  @JvmStatic
  public final fun bodyRemoveShape(body: RID, shapeIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.bodyRemoveShapePtr)
  }

  /**
   * Removes all shapes from the body. This does not delete the shapes themselves, so they can
   * continue to be used elsewhere or added back later.
   */
  @JvmStatic
  public final fun bodyClearShapes(body: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyClearShapesPtr)
  }

  /**
   * Sets the disabled property of the body's shape with the given index. If [disabled] is `true`,
   * then the shape will be ignored in all collision detection.
   */
  @JvmStatic
  public final fun bodySetShapeDisabled(
    body: RID,
    shapeIdx: Int,
    disabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.bodySetShapeDisabledPtr)
  }

  /**
   * Sets the one-way collision properties of the body's shape with the given index. If [enable] is
   * `true`, the one-way collision direction given by [direction] in the shape's local space (that is
   * `body_get_shape_transform(body, shape_idx).basis_xform(direction).normalized()` in the body's
   * local space) will be used to ignore collisions with the shape in the opposite direction, and to
   * ensure depenetration of kinematic bodies happens in this direction.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodySetShapeAsOneWayCollision(
    body: RID,
    shapeIdx: Int,
    enable: Boolean,
    margin: Float,
    direction: Vector2 = Vector2(0, 1),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong(), BOOL to enable, DOUBLE to margin.toDouble(), VECTOR2 to direction)
    TransferContext.callMethod(MethodBindings.bodySetShapeAsOneWayCollisionPtr)
  }

  /**
   * Attaches the `ObjectID` of an [Object] to the body. Use [Object.getInstanceId] to get the
   * `ObjectID` of a [CollisionObject2D].
   */
  @JvmStatic
  public final fun bodyAttachObjectInstanceId(body: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to id)
    TransferContext.callMethod(MethodBindings.bodyAttachObjectInstanceIdPtr)
  }

  /**
   * Returns the `ObjectID` attached to the body. Use [@GlobalScope.instanceFromId] to retrieve an
   * [Object] from a nonzero `ObjectID`.
   */
  @JvmStatic
  public final fun bodyGetObjectInstanceId(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetObjectInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Attaches the `ObjectID` of a canvas to the body. Use [Object.getInstanceId] to get the
   * `ObjectID` of a [CanvasLayer].
   */
  @JvmStatic
  public final fun bodyAttachCanvasInstanceId(body: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to id)
    TransferContext.callMethod(MethodBindings.bodyAttachCanvasInstanceIdPtr)
  }

  /**
   * Returns the `ObjectID` of the canvas attached to the body. Use [@GlobalScope.instanceFromId] to
   * retrieve a [CanvasLayer] from a nonzero `ObjectID`.
   */
  @JvmStatic
  public final fun bodyGetCanvasInstanceId(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCanvasInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the continuous collision detection mode.
   *
   * Continuous collision detection tries to predict where a moving body would collide in between
   * physics updates, instead of moving it and correcting its movement if it collided.
   */
  @JvmStatic
  public final fun bodySetContinuousCollisionDetectionMode(body: RID, mode: CCDMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.bodySetContinuousCollisionDetectionModePtr)
  }

  /**
   * Returns the body's continuous collision detection mode.
   */
  @JvmStatic
  public final fun bodyGetContinuousCollisionDetectionMode(body: RID): CCDMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetContinuousCollisionDetectionModePtr)
    return CCDMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the physics layer or layers the body belongs to, via a bitmask.
   */
  @JvmStatic
  public final fun bodySetCollisionLayer(body: RID, layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to layer)
    TransferContext.callMethod(MethodBindings.bodySetCollisionLayerPtr)
  }

  /**
   * Returns the physics layer or layers the body belongs to, as a bitmask.
   */
  @JvmStatic
  public final fun bodyGetCollisionLayer(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the physics layer or layers the body can collide with, via a bitmask.
   */
  @JvmStatic
  public final fun bodySetCollisionMask(body: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to mask)
    TransferContext.callMethod(MethodBindings.bodySetCollisionMaskPtr)
  }

  /**
   * Returns the physics layer or layers the body can collide with, as a bitmask.
   */
  @JvmStatic
  public final fun bodyGetCollisionMask(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the body's collision priority. This is used in the depenetration phase of
   * [bodyTestMotion]. The higher the priority is, the lower the penetration into the body will be.
   */
  @JvmStatic
  public final fun bodySetCollisionPriority(body: RID, priority: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to priority.toDouble())
    TransferContext.callMethod(MethodBindings.bodySetCollisionPriorityPtr)
  }

  /**
   * Returns the body's collision priority. This is used in the depenetration phase of
   * [bodyTestMotion]. The higher the priority is, the lower the penetration into the body will be.
   */
  @JvmStatic
  public final fun bodyGetCollisionPriority(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCollisionPriorityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the value of the given body parameter.
   */
  @JvmStatic
  public final fun bodySetParam(
    body: RID,
    `param`: BodyParameter,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to param.value, ANY to value)
    TransferContext.callMethod(MethodBindings.bodySetParamPtr)
  }

  /**
   * Returns the value of the given body parameter.
   */
  @JvmStatic
  public final fun bodyGetParam(body: RID, `param`: BodyParameter): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to param.value)
    TransferContext.callMethod(MethodBindings.bodyGetParamPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Restores the default inertia and center of mass of the body based on its shapes. This undoes
   * any custom values previously set using [bodySetParam].
   */
  @JvmStatic
  public final fun bodyResetMassProperties(body: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyResetMassPropertiesPtr)
  }

  /**
   * Sets the value of a body's state.
   *
   * **Note:** The state change doesn't take effect immediately. The state will change on the next
   * physics frame.
   */
  @JvmStatic
  public final fun bodySetState(
    body: RID,
    state: BodyState,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to state.value, ANY to value)
    TransferContext.callMethod(MethodBindings.bodySetStatePtr)
  }

  /**
   * Returns the value of the given state of the body.
   */
  @JvmStatic
  public final fun bodyGetState(body: RID, state: BodyState): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to state.value)
    TransferContext.callMethod(MethodBindings.bodyGetStatePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Applies a directional impulse to the body, at the body's center of mass. The impulse does not
   * affect rotation.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   *
   * This is equivalent to using [bodyApplyImpulse] at the body's center of mass.
   */
  @JvmStatic
  public final fun bodyApplyCentralImpulse(body: RID, impulse: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to impulse)
    TransferContext.callMethod(MethodBindings.bodyApplyCentralImpulsePtr)
  }

  /**
   * Applies a rotational impulse to the body. The impulse does not affect position.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   */
  @JvmStatic
  public final fun bodyApplyTorqueImpulse(body: RID, impulse: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to impulse.toDouble())
    TransferContext.callMethod(MethodBindings.bodyApplyTorqueImpulsePtr)
  }

  /**
   * Applies a positioned impulse to the body. The impulse can affect rotation if [position] is
   * different from the body's center of mass.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyApplyImpulse(
    body: RID,
    impulse: Vector2,
    position: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to impulse, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.bodyApplyImpulsePtr)
  }

  /**
   * Applies a directional force to the body, at the body's center of mass. The force does not
   * affect rotation. A force is time dependent and meant to be applied every physics update.
   *
   * This is equivalent to using [bodyApplyForce] at the body's center of mass.
   */
  @JvmStatic
  public final fun bodyApplyCentralForce(body: RID, force: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to force)
    TransferContext.callMethod(MethodBindings.bodyApplyCentralForcePtr)
  }

  /**
   * Applies a positioned force to the body. The force can affect rotation if [position] is
   * different from the body's center of mass. A force is time dependent and meant to be applied every
   * physics update.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyApplyForce(
    body: RID,
    force: Vector2,
    position: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to force, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.bodyApplyForcePtr)
  }

  /**
   * Applies a rotational force to the body. The force does not affect position. A force is time
   * dependent and meant to be applied every physics update.
   */
  @JvmStatic
  public final fun bodyApplyTorque(body: RID, torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.bodyApplyTorquePtr)
  }

  /**
   * Adds a constant directional force to the body. The force does not affect rotation. The force
   * remains applied over time until cleared with `PhysicsServer2D.body_set_constant_force(body,
   * Vector2(0, 0))`.
   *
   * This is equivalent to using [bodyAddConstantForce] at the body's center of mass.
   */
  @JvmStatic
  public final fun bodyAddConstantCentralForce(body: RID, force: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to force)
    TransferContext.callMethod(MethodBindings.bodyAddConstantCentralForcePtr)
  }

  /**
   * Adds a constant positioned force to the body. The force can affect rotation if [position] is
   * different from the body's center of mass. The force remains applied over time until cleared with
   * `PhysicsServer2D.body_set_constant_force(body, Vector2(0, 0))`.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyAddConstantForce(
    body: RID,
    force: Vector2,
    position: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to force, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.bodyAddConstantForcePtr)
  }

  /**
   * Adds a constant rotational force to the body. The force does not affect position. The force
   * remains applied over time until cleared with `PhysicsServer2D.body_set_constant_torque(body, 0)`.
   */
  @JvmStatic
  public final fun bodyAddConstantTorque(body: RID, torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.bodyAddConstantTorquePtr)
  }

  /**
   * Sets the body's total constant positional force applied during each physics update.
   *
   * See [bodyAddConstantForce] and [bodyAddConstantCentralForce].
   */
  @JvmStatic
  public final fun bodySetConstantForce(body: RID, force: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to force)
    TransferContext.callMethod(MethodBindings.bodySetConstantForcePtr)
  }

  /**
   * Returns the body's total constant positional force applied during each physics update.
   *
   * See [bodyAddConstantForce] and [bodyAddConstantCentralForce].
   */
  @JvmStatic
  public final fun bodyGetConstantForce(body: RID): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetConstantForcePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the body's total constant rotational force applied during each physics update.
   *
   * See [bodyAddConstantTorque].
   */
  @JvmStatic
  public final fun bodySetConstantTorque(body: RID, torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.bodySetConstantTorquePtr)
  }

  /**
   * Returns the body's total constant rotational force applied during each physics update.
   *
   * See [bodyAddConstantTorque].
   */
  @JvmStatic
  public final fun bodyGetConstantTorque(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetConstantTorquePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Modifies the body's linear velocity so that its projection to the axis
   * `axis_velocity.normalized()` is exactly `axis_velocity.length()`. This is useful for jumping
   * behavior.
   */
  @JvmStatic
  public final fun bodySetAxisVelocity(body: RID, axisVelocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR2 to axisVelocity)
    TransferContext.callMethod(MethodBindings.bodySetAxisVelocityPtr)
  }

  /**
   * Adds [exceptedBody] to the body's list of collision exceptions, so that collisions with it are
   * ignored.
   */
  @JvmStatic
  public final fun bodyAddCollisionException(body: RID, exceptedBody: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to exceptedBody)
    TransferContext.callMethod(MethodBindings.bodyAddCollisionExceptionPtr)
  }

  /**
   * Removes [exceptedBody] from the body's list of collision exceptions, so that collisions with it
   * are no longer ignored.
   */
  @JvmStatic
  public final fun bodyRemoveCollisionException(body: RID, exceptedBody: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to exceptedBody)
    TransferContext.callMethod(MethodBindings.bodyRemoveCollisionExceptionPtr)
  }

  /**
   * Sets the maximum number of contacts that the body can report. If [amount] is greater than zero,
   * then the body will keep track of at most this many contacts with other bodies.
   */
  @JvmStatic
  public final fun bodySetMaxContactsReported(body: RID, amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.bodySetMaxContactsReportedPtr)
  }

  /**
   * Returns the maximum number of contacts that the body can report. See
   * [bodySetMaxContactsReported].
   */
  @JvmStatic
  public final fun bodyGetMaxContactsReported(body: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetMaxContactsReportedPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets whether the body omits the standard force integration. If [enable] is `true`, the body
   * will not automatically use applied forces, torques, and damping to update the body's linear and
   * angular velocity. In this case, [bodySetForceIntegrationCallback] can be used to manually update
   * the linear and angular velocity instead.
   *
   * This method is called when the property [RigidBody2D.customIntegrator] is set.
   */
  @JvmStatic
  public final fun bodySetOmitForceIntegration(body: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, BOOL to enable)
    TransferContext.callMethod(MethodBindings.bodySetOmitForceIntegrationPtr)
  }

  /**
   * Returns `true` if the body is omitting the standard force integration. See
   * [bodySetOmitForceIntegration].
   */
  @JvmStatic
  public final fun bodyIsOmittingForceIntegration(body: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyIsOmittingForceIntegrationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the body's state synchronization callback function to [callable]. Use an empty [Callable]
   * ([code skip-lint]Callable()[/code]) to clear the callback.
   *
   * The function [callable] will be called every physics frame, assuming that the body was active
   * during the previous physics tick, and can be used to fetch the latest state from the physics
   * server.
   *
   * The function [callable] must take the following parameters:
   *
   * 1. `state`: a [PhysicsDirectBodyState2D], used to retrieve the body's state.
   */
  @JvmStatic
  public final fun bodySetStateSyncCallback(body: RID, callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.bodySetStateSyncCallbackPtr)
  }

  /**
   * Sets the body's custom force integration callback function to [callable]. Use an empty
   * [Callable] ([code skip-lint]Callable()[/code]) to clear the custom callback.
   *
   * The function [callable] will be called every physics tick, before the standard force
   * integration (see [bodySetOmitForceIntegration]). It can be used for example to update the body's
   * linear and angular velocity based on contact with other bodies.
   *
   * If [userdata] is not `null`, the function [callable] must take the following two parameters:
   *
   * 1. `state`: a [PhysicsDirectBodyState2D] used to retrieve and modify the body's state,
   *
   * 2. [code skip-lint]userdata[/code]: a [Any]; its value will be the [userdata] passed into this
   * method.
   *
   * If [userdata] is `null`, then [callable] must take only the `state` parameter.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodySetForceIntegrationCallback(
    body: RID,
    callable: Callable,
    userdata: Any? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, CALLABLE to callable, ANY to userdata)
    TransferContext.callMethod(MethodBindings.bodySetForceIntegrationCallbackPtr)
  }

  /**
   * Returns `true` if a collision would result from moving the body along a motion vector from a
   * given point in space. See [PhysicsTestMotionParameters2D] for the available motion parameters.
   * Optionally a [PhysicsTestMotionResult2D] object can be passed, which will be used to store the
   * information about the resulting collision.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyTestMotion(
    body: RID,
    parameters: PhysicsTestMotionParameters2D,
    result: PhysicsTestMotionResult2D? = null,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, OBJECT to parameters, OBJECT to result)
    TransferContext.callMethod(MethodBindings.bodyTestMotionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [PhysicsDirectBodyState2D] of the body. Returns `null` if the body is destroyed or
   * not assigned to a space.
   */
  @JvmStatic
  public final fun bodyGetDirectState(body: RID): PhysicsDirectBodyState2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetDirectStatePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsDirectBodyState2D?)
  }

  /**
   * Creates a 2D joint in the physics server, and returns the [RID] that identifies it. To set the
   * joint type, use [jointMakeDampedSpring], [jointMakeGroove] or [jointMakePin]. Use [jointSetParam]
   * to set generic joint parameters.
   */
  @JvmStatic
  public final fun jointCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.jointCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Destroys the joint with the given [RID], creates a new uninitialized joint, and makes the [RID]
   * refer to this new joint.
   */
  @JvmStatic
  public final fun jointClear(joint: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointClearPtr)
  }

  /**
   * Sets the value of the given joint parameter.
   */
  @JvmStatic
  public final fun jointSetParam(
    joint: RID,
    `param`: JointParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.jointSetParamPtr)
  }

  /**
   * Returns the value of the given joint parameter.
   */
  @JvmStatic
  public final fun jointGetParam(joint: RID, `param`: JointParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.jointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets whether the bodies attached to the [Joint2D] will collide with each other.
   */
  @JvmStatic
  public final fun jointDisableCollisionsBetweenBodies(joint: RID, disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, BOOL to disable)
    TransferContext.callMethod(MethodBindings.jointDisableCollisionsBetweenBodiesPtr)
  }

  /**
   * Returns whether the bodies attached to the [Joint2D] will collide with each other.
   */
  @JvmStatic
  public final fun jointIsDisabledCollisionsBetweenBodies(joint: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointIsDisabledCollisionsBetweenBodiesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Makes the joint a pin joint. If [bodyB] is an empty [RID], then [bodyA] is pinned to the point
   * [anchor] (given in global coordinates); otherwise, [bodyA] is pinned to [bodyB] at the point
   * [anchor] (given in global coordinates). To set the parameters which are specific to the pin joint,
   * see [pinJointSetParam].
   */
  @JvmOverloads
  @JvmStatic
  public final fun jointMakePin(
    joint: RID,
    anchor: Vector2,
    bodyA: RID,
    bodyB: RID = RID(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, VECTOR2 to anchor, _RID to bodyA, _RID to bodyB)
    TransferContext.callMethod(MethodBindings.jointMakePinPtr)
  }

  /**
   * Makes the joint a groove joint.
   */
  @JvmOverloads
  @JvmStatic
  public final fun jointMakeGroove(
    joint: RID,
    groove1A: Vector2,
    groove2A: Vector2,
    anchorB: Vector2,
    bodyA: RID = RID(),
    bodyB: RID = RID(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, VECTOR2 to groove1A, VECTOR2 to groove2A, VECTOR2 to anchorB, _RID to bodyA, _RID to bodyB)
    TransferContext.callMethod(MethodBindings.jointMakeGroovePtr)
  }

  /**
   * Makes the joint a damped spring joint, attached at the point [anchorA] (given in global
   * coordinates) on the body [bodyA] and at the point [anchorB] (given in global coordinates) on the
   * body [bodyB]. To set the parameters which are specific to the damped spring, see
   * [dampedSpringJointSetParam].
   */
  @JvmOverloads
  @JvmStatic
  public final fun jointMakeDampedSpring(
    joint: RID,
    anchorA: Vector2,
    anchorB: Vector2,
    bodyA: RID,
    bodyB: RID = RID(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, VECTOR2 to anchorA, VECTOR2 to anchorB, _RID to bodyA, _RID to bodyB)
    TransferContext.callMethod(MethodBindings.jointMakeDampedSpringPtr)
  }

  /**
   * Sets a pin joint flag.
   */
  @JvmStatic
  public final fun pinJointSetFlag(
    joint: RID,
    flag: PinJointFlag,
    enabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.pinJointSetFlagPtr)
  }

  /**
   * Gets a pin joint flag.
   */
  @JvmStatic
  public final fun pinJointGetFlag(joint: RID, flag: PinJointFlag): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.pinJointGetFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets a pin joint parameter.
   */
  @JvmStatic
  public final fun pinJointSetParam(
    joint: RID,
    `param`: PinJointParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.pinJointSetParamPtr)
  }

  /**
   * Returns the value of a pin joint parameter.
   */
  @JvmStatic
  public final fun pinJointGetParam(joint: RID, `param`: PinJointParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.pinJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the value of the given damped spring joint parameter.
   */
  @JvmStatic
  public final fun dampedSpringJointSetParam(
    joint: RID,
    `param`: DampedSpringParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.dampedSpringJointSetParamPtr)
  }

  /**
   * Returns the value of the given damped spring joint parameter.
   */
  @JvmStatic
  public final fun dampedSpringJointGetParam(joint: RID, `param`: DampedSpringParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.dampedSpringJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the joint's type.
   */
  @JvmStatic
  public final fun jointGetType(joint: RID): JointType {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointGetTypePtr)
    return JointType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Destroys any of the objects created by PhysicsServer2D. If the [RID] passed is not one of the
   * objects that can be created by PhysicsServer2D, an error will be printed to the console.
   */
  @JvmStatic
  public final fun freeRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.freeRidPtr)
  }

  /**
   * Activates or deactivates the 2D physics server. If [active] is `false`, then the physics server
   * will not do anything in its physics step.
   */
  @JvmStatic
  public final fun setActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active)
    TransferContext.callMethod(MethodBindings.setActivePtr)
  }

  /**
   * Returns the value of a physics engine state specified by [processInfo].
   */
  @JvmStatic
  public final fun getProcessInfo(processInfo: ProcessInfo): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to processInfo.value)
    TransferContext.callMethod(MethodBindings.getProcessInfoPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public enum class SpaceParameter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get the maximum distance a pair of bodies has to move before their collision
     * status has to be recalculated. The default value of this parameter is
     * [ProjectSettings.physics/2d/solver/contactRecycleRadius].
     */
    CONTACT_RECYCLE_RADIUS(0),
    /**
     * Constant to set/get the maximum distance a shape can be from another before they are
     * considered separated and the contact is discarded. The default value of this parameter is
     * [ProjectSettings.physics/2d/solver/contactMaxSeparation].
     */
    CONTACT_MAX_SEPARATION(1),
    /**
     * Constant to set/get the maximum distance a shape can penetrate another shape before it is
     * considered a collision. The default value of this parameter is
     * [ProjectSettings.physics/2d/solver/contactMaxAllowedPenetration].
     */
    CONTACT_MAX_ALLOWED_PENETRATION(2),
    /**
     * Constant to set/get the default solver bias for all physics contacts. A solver bias is a
     * factor controlling how much two objects "rebound", after overlapping, to avoid leaving them in
     * that state because of numerical imprecision. The default value of this parameter is
     * [ProjectSettings.physics/2d/solver/defaultContactBias].
     */
    CONTACT_DEFAULT_BIAS(3),
    /**
     * Constant to set/get the threshold linear velocity of activity. A body marked as potentially
     * inactive for both linear and angular velocity will be put to sleep after the time given. The
     * default value of this parameter is [ProjectSettings.physics/2d/sleepThresholdLinear].
     */
    BODY_LINEAR_VELOCITY_SLEEP_THRESHOLD(4),
    /**
     * Constant to set/get the threshold angular velocity of activity. A body marked as potentially
     * inactive for both linear and angular velocity will be put to sleep after the time given. The
     * default value of this parameter is [ProjectSettings.physics/2d/sleepThresholdAngular].
     */
    BODY_ANGULAR_VELOCITY_SLEEP_THRESHOLD(5),
    /**
     * Constant to set/get the maximum time of activity. A body marked as potentially inactive for
     * both linear and angular velocity will be put to sleep after this time. The default value of this
     * parameter is [ProjectSettings.physics/2d/timeBeforeSleep].
     */
    BODY_TIME_TO_SLEEP(6),
    /**
     * Constant to set/get the default solver bias for all physics constraints. A solver bias is a
     * factor controlling how much two objects "rebound", after violating a constraint, to avoid
     * leaving them in that state because of numerical imprecision. The default value of this parameter
     * is [ProjectSettings.physics/2d/solver/defaultConstraintBias].
     */
    CONSTRAINT_DEFAULT_BIAS(7),
    /**
     * Constant to set/get the number of solver iterations for all contacts and constraints. The
     * greater the number of iterations, the more accurate the collisions will be. However, a greater
     * number of iterations requires more CPU power, which can decrease performance. The default value
     * of this parameter is [ProjectSettings.physics/2d/solver/solverIterations].
     */
    SOLVER_ITERATIONS(8),
    ;

    public companion object {
      public fun from(`value`: Long): SpaceParameter = entries.single { it.`value` == `value` }
    }
  }

  public enum class ShapeType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This is the constant for creating world boundary shapes. A world boundary shape is an
     * *infinite* line with an origin point, and a normal. Thus, it can be used for front/behind
     * checks.
     */
    WORLD_BOUNDARY(0),
    /**
     * This is the constant for creating separation ray shapes. A separation ray is defined by a
     * length and separates itself from what is touching its far endpoint. Useful for character
     * controllers.
     */
    SEPARATION_RAY(1),
    /**
     * This is the constant for creating segment shapes. A segment shape is a *finite* line from a
     * point A to a point B. It can be checked for intersections.
     */
    SEGMENT(2),
    /**
     * This is the constant for creating circle shapes. A circle shape only has a radius. It can be
     * used for intersections and inside/outside checks.
     */
    CIRCLE(3),
    /**
     * This is the constant for creating rectangle shapes. A rectangle shape is defined by a width
     * and a height. It can be used for intersections and inside/outside checks.
     */
    RECTANGLE(4),
    /**
     * This is the constant for creating capsule shapes. A capsule shape is defined by a radius and
     * a length. It can be used for intersections and inside/outside checks.
     */
    CAPSULE(5),
    /**
     * This is the constant for creating convex polygon shapes. A polygon is defined by a list of
     * points. It can be used for intersections and inside/outside checks.
     */
    CONVEX_POLYGON(6),
    /**
     * This is the constant for creating concave polygon shapes. A polygon is defined by a list of
     * points. It can be used for intersections checks, but not for inside/outside checks.
     */
    CONCAVE_POLYGON(7),
    /**
     * This constant is used internally by the engine. Any attempt to create this kind of shape
     * results in an error.
     */
    CUSTOM(8),
    ;

    public companion object {
      public fun from(`value`: Long): ShapeType = entries.single { it.`value` == `value` }
    }
  }

  public enum class AreaParameter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get gravity override mode in an area. See [AreaSpaceOverrideMode] for
     * possible values. The default value of this parameter is [AREA_SPACE_OVERRIDE_DISABLED].
     */
    GRAVITY_OVERRIDE_MODE(0),
    /**
     * Constant to set/get gravity strength in an area. The default value of this parameter is
     * `9.80665`.
     */
    GRAVITY(1),
    /**
     * Constant to set/get gravity vector/center in an area. The default value of this parameter is
     * `Vector2(0, -1)`.
     */
    GRAVITY_VECTOR(2),
    /**
     * Constant to set/get whether the gravity vector of an area is a direction, or a center point.
     * The default value of this parameter is `false`.
     */
    GRAVITY_IS_POINT(3),
    /**
     * Constant to set/get the distance at which the gravity strength is equal to the gravity
     * controlled by [AREA_PARAM_GRAVITY]. For example, on a planet 100 pixels in radius with a surface
     * gravity of 4.0 px/s², set the gravity to 4.0 and the unit distance to 100.0. The gravity will
     * have falloff according to the inverse square law, so in the example, at 200 pixels from the
     * center the gravity will be 1.0 px/s² (twice the distance, 1/4th the gravity), at 50 pixels it
     * will be 16.0 px/s² (half the distance, 4x the gravity), and so on.
     *
     * The above is true only when the unit distance is a positive number. When the unit distance is
     * set to 0.0, the gravity will be constant regardless of distance. The default value of this
     * parameter is `0.0`.
     */
    GRAVITY_POINT_UNIT_DISTANCE(4),
    /**
     * Constant to set/get linear damping override mode in an area. See [AreaSpaceOverrideMode] for
     * possible values. The default value of this parameter is [AREA_SPACE_OVERRIDE_DISABLED].
     */
    LINEAR_DAMP_OVERRIDE_MODE(5),
    /**
     * Constant to set/get the linear damping factor of an area. The default value of this parameter
     * is `0.1`.
     */
    LINEAR_DAMP(6),
    /**
     * Constant to set/get angular damping override mode in an area. See [AreaSpaceOverrideMode] for
     * possible values. The default value of this parameter is [AREA_SPACE_OVERRIDE_DISABLED].
     */
    ANGULAR_DAMP_OVERRIDE_MODE(7),
    /**
     * Constant to set/get the angular damping factor of an area. The default value of this
     * parameter is `1.0`.
     */
    ANGULAR_DAMP(8),
    /**
     * Constant to set/get the priority (order of processing) of an area. The default value of this
     * parameter is `0`.
     */
    PRIORITY(9),
    ;

    public companion object {
      public fun from(`value`: Long): AreaParameter = entries.single { it.`value` == `value` }
    }
  }

  public enum class AreaSpaceOverrideMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This area does not affect gravity/damp. These are generally areas that exist only to detect
     * collisions, and objects entering or exiting them.
     */
    DISABLED(0),
    /**
     * This area adds its gravity/damp values to whatever has been calculated so far. This way, many
     * overlapping areas can combine their physics to make interesting effects.
     */
    COMBINE(1),
    /**
     * This area adds its gravity/damp values to whatever has been calculated so far. Then stops
     * taking into account the rest of the areas, even the default one.
     */
    COMBINE_REPLACE(2),
    /**
     * This area replaces any gravity/damp, even the default one, and stops taking into account the
     * rest of the areas.
     */
    REPLACE(3),
    /**
     * This area replaces any gravity/damp calculated so far, but keeps calculating the rest of the
     * areas, down to the default one.
     */
    REPLACE_COMBINE(4),
    ;

    public companion object {
      public fun from(`value`: Long): AreaSpaceOverrideMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class BodyMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant for static bodies. In this mode, a body can be only moved by user code and doesn't
     * collide with other bodies along its path when moved.
     */
    STATIC(0),
    /**
     * Constant for kinematic bodies. In this mode, a body can be only moved by user code and
     * collides with other bodies along its path.
     */
    KINEMATIC(1),
    /**
     * Constant for rigid bodies. In this mode, a body can be pushed by other bodies and has forces
     * applied.
     */
    RIGID(2),
    /**
     * Constant for linear rigid bodies. In this mode, a body can not rotate, and only its linear
     * velocity is affected by external forces.
     */
    RIGID_LINEAR(3),
    ;

    public companion object {
      public fun from(`value`: Long): BodyMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class BodyParameter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get a body's bounce factor. The default value of this parameter is `0.0`.
     */
    BOUNCE(0),
    /**
     * Constant to set/get a body's friction. The default value of this parameter is `1.0`.
     */
    FRICTION(1),
    /**
     * Constant to set/get a body's mass. The default value of this parameter is `1.0`. If the
     * body's mode is set to [BODY_MODE_RIGID], then setting this parameter will have the following
     * additional effects:
     *
     * - If the parameter [BODY_PARAM_CENTER_OF_MASS] has never been set explicitly, then the value
     * of that parameter will be recalculated based on the body's shapes.
     *
     * - If the parameter [BODY_PARAM_INERTIA] is set to a value `<= 0.0`, then the value of that
     * parameter will be recalculated based on the body's shapes, mass, and center of mass.
     */
    MASS(2),
    /**
     * Constant to set/get a body's inertia. The default value of this parameter is `0.0`. If the
     * body's inertia is set to a value `<= 0.0`, then the inertia will be recalculated based on the
     * body's shapes, mass, and center of mass.
     */
    INERTIA(3),
    /**
     * Constant to set/get a body's center of mass position in the body's local coordinate system.
     * The default value of this parameter is `Vector2(0, 0)`. If this parameter is never set
     * explicitly, then it is recalculated based on the body's shapes when setting the parameter
     * [BODY_PARAM_MASS] or when calling [bodySetSpace].
     */
    CENTER_OF_MASS(4),
    /**
     * Constant to set/get a body's gravity multiplier. The default value of this parameter is
     * `1.0`.
     */
    GRAVITY_SCALE(5),
    /**
     * Constant to set/get a body's linear damping mode. See [BodyDampMode] for possible values. The
     * default value of this parameter is [BODY_DAMP_MODE_COMBINE].
     */
    LINEAR_DAMP_MODE(6),
    /**
     * Constant to set/get a body's angular damping mode. See [BodyDampMode] for possible values.
     * The default value of this parameter is [BODY_DAMP_MODE_COMBINE].
     */
    ANGULAR_DAMP_MODE(7),
    /**
     * Constant to set/get a body's linear damping factor. The default value of this parameter is
     * `0.0`.
     */
    LINEAR_DAMP(8),
    /**
     * Constant to set/get a body's angular damping factor. The default value of this parameter is
     * `0.0`.
     */
    ANGULAR_DAMP(9),
    /**
     * Represents the size of the [BodyParameter] enum.
     */
    MAX(10),
    ;

    public companion object {
      public fun from(`value`: Long): BodyParameter = entries.single { it.`value` == `value` }
    }
  }

  public enum class BodyDampMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The body's damping value is added to any value set in areas or the default value.
     */
    COMBINE(0),
    /**
     * The body's damping value replaces any value set in areas or the default value.
     */
    REPLACE(1),
    ;

    public companion object {
      public fun from(`value`: Long): BodyDampMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class BodyState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get the current transform matrix of the body.
     */
    TRANSFORM(0),
    /**
     * Constant to set/get the current linear velocity of the body.
     */
    LINEAR_VELOCITY(1),
    /**
     * Constant to set/get the current angular velocity of the body.
     */
    ANGULAR_VELOCITY(2),
    /**
     * Constant to sleep/wake up a body, or to get whether it is sleeping.
     */
    SLEEPING(3),
    /**
     * Constant to set/get whether the body can sleep.
     */
    CAN_SLEEP(4),
    ;

    public companion object {
      public fun from(`value`: Long): BodyState = entries.single { it.`value` == `value` }
    }
  }

  public enum class JointType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to create pin joints.
     */
    PIN(0),
    /**
     * Constant to create groove joints.
     */
    GROOVE(1),
    /**
     * Constant to create damped spring joints.
     */
    DAMPED_SPRING(2),
    /**
     * Represents the size of the [JointType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): JointType = entries.single { it.`value` == `value` }
    }
  }

  public enum class JointParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get how fast the joint pulls the bodies back to satisfy the joint constraint.
     * The lower the value, the more the two bodies can pull on the joint. The default value of this
     * parameter is `0.0`.
     *
     * **Note:** In Godot Physics, this parameter is only used for pin joints and groove joints.
     */
    BIAS(0),
    /**
     * Constant to set/get the maximum speed with which the joint can apply corrections. The default
     * value of this parameter is `3.40282e+38`.
     *
     * **Note:** In Godot Physics, this parameter is only used for groove joints.
     */
    MAX_BIAS(1),
    /**
     * Constant to set/get the maximum force that the joint can use to act on the two bodies. The
     * default value of this parameter is `3.40282e+38`.
     *
     * **Note:** In Godot Physics, this parameter is only used for groove joints.
     */
    MAX_FORCE(2),
    ;

    public companion object {
      public fun from(`value`: Long): JointParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class PinJointParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get a how much the bond of the pin joint can flex. The default value of this
     * parameter is `0.0`.
     */
    SOFTNESS(0),
    /**
     * The maximum rotation around the pin.
     */
    LIMIT_UPPER(1),
    /**
     * The minimum rotation around the pin.
     */
    LIMIT_LOWER(2),
    /**
     * Target speed for the motor. In radians per second.
     */
    MOTOR_TARGET_VELOCITY(3),
    ;

    public companion object {
      public fun from(`value`: Long): PinJointParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class PinJointFlag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If `true`, the pin has a maximum and a minimum rotation.
     */
    ANGULAR_LIMIT_ENABLED(0),
    /**
     * If `true`, a motor turns the pin.
     */
    MOTOR_ENABLED(1),
    ;

    public companion object {
      public fun from(`value`: Long): PinJointFlag = entries.single { it.`value` == `value` }
    }
  }

  public enum class DampedSpringParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sets the resting length of the spring joint. The joint will always try to go to back this
     * length when pulled apart. The default value of this parameter is the distance between the
     * joint's anchor points.
     */
    REST_LENGTH(0),
    /**
     * Sets the stiffness of the spring joint. The joint applies a force equal to the stiffness
     * times the distance from its resting length. The default value of this parameter is `20.0`.
     */
    STIFFNESS(1),
    /**
     * Sets the damping ratio of the spring joint. A value of 0 indicates an undamped spring, while
     * 1 causes the system to reach equilibrium as fast as possible (critical damping). The default
     * value of this parameter is `1.5`.
     */
    DAMPING(2),
    ;

    public companion object {
      public fun from(`value`: Long): DampedSpringParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class CCDMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables continuous collision detection. This is the fastest way to detect body collisions,
     * but it can miss small and/or fast-moving objects.
     */
    DISABLED(0),
    /**
     * Enables continuous collision detection by raycasting. It is faster than shapecasting, but
     * less precise.
     */
    CAST_RAY(1),
    /**
     * Enables continuous collision detection by shapecasting. It is the slowest CCD method, and the
     * most precise.
     */
    CAST_SHAPE(2),
    ;

    public companion object {
      public fun from(`value`: Long): CCDMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class AreaBodyStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The value of the first parameter and area callback function receives, when an object enters
     * one of its shapes.
     */
    ADDED(0),
    /**
     * The value of the first parameter and area callback function receives, when an object exits
     * one of its shapes.
     */
    REMOVED(1),
    ;

    public companion object {
      public fun from(`value`: Long): AreaBodyStatus = entries.single { it.`value` == `value` }
    }
  }

  public enum class ProcessInfo(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to get the number of objects that are not sleeping.
     */
    INFO_ACTIVE_OBJECTS(0),
    /**
     * Constant to get the number of possible collisions.
     */
    INFO_COLLISION_PAIRS(1),
    /**
     * Constant to get the number of space regions where a collision could occur.
     */
    INFO_ISLAND_COUNT(2),
    ;

    public companion object {
      public fun from(`value`: Long): ProcessInfo = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val worldBoundaryShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "world_boundary_shape_create", 529393457)

    internal val separationRayShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "separation_ray_shape_create", 529393457)

    internal val segmentShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "segment_shape_create", 529393457)

    internal val circleShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "circle_shape_create", 529393457)

    internal val rectangleShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "rectangle_shape_create", 529393457)

    internal val capsuleShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "capsule_shape_create", 529393457)

    internal val convexPolygonShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "convex_polygon_shape_create", 529393457)

    internal val concavePolygonShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "concave_polygon_shape_create", 529393457)

    internal val shapeSetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "shape_set_data", 3175752987)

    internal val shapeGetTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "shape_get_type", 1240598777)

    internal val shapeGetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "shape_get_data", 4171304767)

    internal val spaceCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "space_create", 529393457)

    internal val spaceSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "space_set_active", 1265174801)

    internal val spaceIsActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "space_is_active", 4155700596)

    internal val spaceSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "space_set_param", 949194586)

    internal val spaceGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "space_get_param", 874111783)

    internal val spaceGetDirectStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "space_get_direct_state", 3160173886)

    internal val areaCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_create", 529393457)

    internal val areaSetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_space", 395945892)

    internal val areaGetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_space", 3814569979)

    internal val areaAddShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_add_shape", 339056240)

    internal val areaSetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_shape", 2310537182)

    internal val areaSetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_shape_transform", 736082694)

    internal val areaSetShapeDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_shape_disabled", 2658558584)

    internal val areaGetShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_shape_count", 2198884583)

    internal val areaGetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_shape", 1066463050)

    internal val areaGetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_shape_transform", 1324854622)

    internal val areaRemoveShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_remove_shape", 3411492887)

    internal val areaClearShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_clear_shapes", 2722037293)

    internal val areaSetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_collision_layer", 3411492887)

    internal val areaGetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_collision_layer", 2198884583)

    internal val areaSetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_collision_mask", 3411492887)

    internal val areaGetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_collision_mask", 2198884583)

    internal val areaSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_param", 1257146028)

    internal val areaSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_transform", 1246044741)

    internal val areaGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_param", 3047435120)

    internal val areaGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_transform", 213527486)

    internal val areaAttachObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_attach_object_instance_id", 3411492887)

    internal val areaGetObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_object_instance_id", 2198884583)

    internal val areaAttachCanvasInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_attach_canvas_instance_id", 3411492887)

    internal val areaGetCanvasInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_get_canvas_instance_id", 2198884583)

    internal val areaSetMonitorCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_monitor_callback", 3379118538)

    internal val areaSetAreaMonitorCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_area_monitor_callback", 3379118538)

    internal val areaSetMonitorablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "area_set_monitorable", 1265174801)

    internal val bodyCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_create", 529393457)

    internal val bodySetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_space", 395945892)

    internal val bodyGetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_space", 3814569979)

    internal val bodySetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_mode", 1658067650)

    internal val bodyGetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_mode", 3261702585)

    internal val bodyAddShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_add_shape", 339056240)

    internal val bodySetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_shape", 2310537182)

    internal val bodySetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_shape_transform", 736082694)

    internal val bodyGetShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_shape_count", 2198884583)

    internal val bodyGetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_shape", 1066463050)

    internal val bodyGetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_shape_transform", 1324854622)

    internal val bodyRemoveShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_remove_shape", 3411492887)

    internal val bodyClearShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_clear_shapes", 2722037293)

    internal val bodySetShapeDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_shape_disabled", 2658558584)

    internal val bodySetShapeAsOneWayCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_shape_as_one_way_collision", 2389283141)

    internal val bodyAttachObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_attach_object_instance_id", 3411492887)

    internal val bodyGetObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_object_instance_id", 2198884583)

    internal val bodyAttachCanvasInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_attach_canvas_instance_id", 3411492887)

    internal val bodyGetCanvasInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_canvas_instance_id", 2198884583)

    internal val bodySetContinuousCollisionDetectionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_continuous_collision_detection_mode", 1882257015)

    internal val bodyGetContinuousCollisionDetectionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_continuous_collision_detection_mode", 2661282217)

    internal val bodySetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_collision_layer", 3411492887)

    internal val bodyGetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_collision_layer", 2198884583)

    internal val bodySetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_collision_mask", 3411492887)

    internal val bodyGetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_collision_mask", 2198884583)

    internal val bodySetCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_collision_priority", 1794382983)

    internal val bodyGetCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_collision_priority", 866169185)

    internal val bodySetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_param", 2715630609)

    internal val bodyGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_param", 3208033526)

    internal val bodyResetMassPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_reset_mass_properties", 2722037293)

    internal val bodySetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_state", 1706355209)

    internal val bodyGetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_state", 4036367961)

    internal val bodyApplyCentralImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_apply_central_impulse", 3201125042)

    internal val bodyApplyTorqueImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_apply_torque_impulse", 1794382983)

    internal val bodyApplyImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_apply_impulse", 205485391)

    internal val bodyApplyCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_apply_central_force", 3201125042)

    internal val bodyApplyForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_apply_force", 205485391)

    internal val bodyApplyTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_apply_torque", 1794382983)

    internal val bodyAddConstantCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_add_constant_central_force", 3201125042)

    internal val bodyAddConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_add_constant_force", 205485391)

    internal val bodyAddConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_add_constant_torque", 1794382983)

    internal val bodySetConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_constant_force", 3201125042)

    internal val bodyGetConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_constant_force", 2440833711)

    internal val bodySetConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_constant_torque", 1794382983)

    internal val bodyGetConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_constant_torque", 866169185)

    internal val bodySetAxisVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_axis_velocity", 3201125042)

    internal val bodyAddCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_add_collision_exception", 395945892)

    internal val bodyRemoveCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_remove_collision_exception", 395945892)

    internal val bodySetMaxContactsReportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_max_contacts_reported", 3411492887)

    internal val bodyGetMaxContactsReportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_max_contacts_reported", 2198884583)

    internal val bodySetOmitForceIntegrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_omit_force_integration", 1265174801)

    internal val bodyIsOmittingForceIntegrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_is_omitting_force_integration", 4155700596)

    internal val bodySetStateSyncCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_state_sync_callback", 3379118538)

    internal val bodySetForceIntegrationCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_set_force_integration_callback", 3059434249)

    internal val bodyTestMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_test_motion", 1699844009)

    internal val bodyGetDirectStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "body_get_direct_state", 1191931871)

    internal val jointCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_create", 529393457)

    internal val jointClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_clear", 2722037293)

    internal val jointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_set_param", 3972556514)

    internal val jointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_get_param", 4016448949)

    internal val jointDisableCollisionsBetweenBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_disable_collisions_between_bodies", 1265174801)

    internal val jointIsDisabledCollisionsBetweenBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_is_disabled_collisions_between_bodies", 4155700596)

    internal val jointMakePinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_make_pin", 1612646186)

    internal val jointMakeGroovePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_make_groove", 481430435)

    internal val jointMakeDampedSpringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_make_damped_spring", 1994657646)

    internal val pinJointSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "pin_joint_set_flag", 3520002352)

    internal val pinJointGetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "pin_joint_get_flag", 2647867364)

    internal val pinJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "pin_joint_set_param", 550574241)

    internal val pinJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "pin_joint_get_param", 348281383)

    internal val dampedSpringJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "damped_spring_joint_set_param", 220564071)

    internal val dampedSpringJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "damped_spring_joint_get_param", 2075871277)

    internal val jointGetTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "joint_get_type", 4262502231)

    internal val freeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "free_rid", 2722037293)

    internal val setActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "set_active", 2586408642)

    internal val getProcessInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer2D", "get_process_info", 576496006)
  }
}
