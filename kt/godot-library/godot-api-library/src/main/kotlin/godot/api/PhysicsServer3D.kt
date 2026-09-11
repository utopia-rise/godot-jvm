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
import godot.core.PackedFloat32Array
import godot.core.PackedFloat64Array
import godot.core.PackedVector3Array
import godot.core.Plane
import godot.core.RID
import godot.core.Transform3D
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR3
import godot.core.VariantParser._RID
import godot.core.Vector3
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
 * PhysicsServer3D is the server responsible for all 3D physics. It can directly create and
 * manipulate all physics objects:
 *
 * - A *space* is a self-contained world for a physics simulation. It contains bodies, areas, and
 * joints. Its state can be queried for collision and intersection information, and several parameters
 * of the simulation can be modified.
 *
 * - A *shape* is a geometric shape such as a sphere, a box, a cylinder, or a polygon. It can be
 * used for collision detection by adding it to a body/area, possibly with an extra transformation
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
 * Physics objects in [PhysicsServer3D] may be created and manipulated independently; they do not
 * have to be tied to nodes in the scene tree.
 *
 * **Note:** All the 3D physics nodes use the physics server internally. Adding a physics node to
 * the scene tree will cause a corresponding physics object to be created in the physics server. A
 * rigid body node registers a callback that updates the node's transform with the transform of the
 * respective body object in the physics server (every physics update). An area node registers a
 * callback to inform the area node about overlaps with the respective area object in the physics
 * server. The raycast node queries the direct state of the relevant space in the physics server.
 */
@GodotBaseType
public object PhysicsServer3D : Object() {
  @JvmField
  public val worldBoundaryShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("world_boundary_shape_create")

  @JvmField
  public val separationRayShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("separation_ray_shape_create")

  @JvmField
  public val sphereShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("sphere_shape_create")

  @JvmField
  public val boxShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("box_shape_create")

  @JvmField
  public val capsuleShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("capsule_shape_create")

  @JvmField
  public val cylinderShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("cylinder_shape_create")

  @JvmField
  public val convexPolygonShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("convex_polygon_shape_create")

  @JvmField
  public val concavePolygonShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("concave_polygon_shape_create")

  @JvmField
  public val heightmapShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("heightmap_shape_create")

  @JvmField
  public val customShapeCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("custom_shape_create")

  @JvmField
  public val shapeSetDataName: MethodStringName2<PhysicsServer3D, Unit, RID, Any?> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Any?>("shape_set_data")

  @JvmField
  public val shapeSetMarginName: MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("shape_set_margin")

  @JvmField
  public val shapeGetTypeName: MethodStringName1<PhysicsServer3D, ShapeType, RID> =
      MethodStringName1<PhysicsServer3D, ShapeType, RID>("shape_get_type")

  @JvmField
  public val shapeGetDataName: MethodStringName1<PhysicsServer3D, Any?, RID> =
      MethodStringName1<PhysicsServer3D, Any?, RID>("shape_get_data")

  @JvmField
  public val shapeGetMarginName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("shape_get_margin")

  @JvmField
  public val spaceCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("space_create")

  @JvmField
  public val spaceSetActiveName: MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("space_set_active")

  @JvmField
  public val spaceIsActiveName: MethodStringName1<PhysicsServer3D, Boolean, RID> =
      MethodStringName1<PhysicsServer3D, Boolean, RID>("space_is_active")

  @JvmField
  public val spaceSetParamName: MethodStringName3<PhysicsServer3D, Unit, RID, SpaceParameter, Float>
      = MethodStringName3<PhysicsServer3D, Unit, RID, SpaceParameter, Float>("space_set_param")

  @JvmField
  public val spaceGetParamName: MethodStringName2<PhysicsServer3D, Float, RID, SpaceParameter> =
      MethodStringName2<PhysicsServer3D, Float, RID, SpaceParameter>("space_get_param")

  @JvmField
  public val spaceGetDirectStateName:
      MethodStringName1<PhysicsServer3D, PhysicsDirectSpaceState3D?, RID> =
      MethodStringName1<PhysicsServer3D, PhysicsDirectSpaceState3D?, RID>("space_get_direct_state")

  @JvmField
  public val areaCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("area_create")

  @JvmField
  public val areaSetSpaceName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("area_set_space")

  @JvmField
  public val areaGetSpaceName: MethodStringName1<PhysicsServer3D, RID, RID> =
      MethodStringName1<PhysicsServer3D, RID, RID>("area_get_space")

  @JvmField
  public val areaAddShapeName:
      MethodStringName4<PhysicsServer3D, Unit, RID, RID, Transform3D, Boolean> =
      MethodStringName4<PhysicsServer3D, Unit, RID, RID, Transform3D, Boolean>("area_add_shape")

  @JvmField
  public val areaSetShapeName: MethodStringName3<PhysicsServer3D, Unit, RID, Int, RID> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, RID>("area_set_shape")

  @JvmField
  public val areaSetShapeTransformName:
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Transform3D> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Transform3D>("area_set_shape_transform")

  @JvmField
  public val areaSetShapeDisabledName: MethodStringName3<PhysicsServer3D, Unit, RID, Int, Boolean> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Boolean>("area_set_shape_disabled")

  @JvmField
  public val areaGetShapeCountName: MethodStringName1<PhysicsServer3D, Int, RID> =
      MethodStringName1<PhysicsServer3D, Int, RID>("area_get_shape_count")

  @JvmField
  public val areaGetShapeName: MethodStringName2<PhysicsServer3D, RID, RID, Int> =
      MethodStringName2<PhysicsServer3D, RID, RID, Int>("area_get_shape")

  @JvmField
  public val areaGetShapeTransformName: MethodStringName2<PhysicsServer3D, Transform3D, RID, Int> =
      MethodStringName2<PhysicsServer3D, Transform3D, RID, Int>("area_get_shape_transform")

  @JvmField
  public val areaRemoveShapeName: MethodStringName2<PhysicsServer3D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Int>("area_remove_shape")

  @JvmField
  public val areaClearShapesName: MethodStringName1<PhysicsServer3D, Unit, RID> =
      MethodStringName1<PhysicsServer3D, Unit, RID>("area_clear_shapes")

  @JvmField
  public val areaSetCollisionLayerName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("area_set_collision_layer")

  @JvmField
  public val areaGetCollisionLayerName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("area_get_collision_layer")

  @JvmField
  public val areaSetCollisionMaskName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("area_set_collision_mask")

  @JvmField
  public val areaGetCollisionMaskName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("area_get_collision_mask")

  @JvmField
  public val areaSetParamName: MethodStringName3<PhysicsServer3D, Unit, RID, AreaParameter, Any?> =
      MethodStringName3<PhysicsServer3D, Unit, RID, AreaParameter, Any?>("area_set_param")

  @JvmField
  public val areaSetTransformName: MethodStringName2<PhysicsServer3D, Unit, RID, Transform3D> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Transform3D>("area_set_transform")

  @JvmField
  public val areaGetParamName: MethodStringName2<PhysicsServer3D, Any?, RID, AreaParameter> =
      MethodStringName2<PhysicsServer3D, Any?, RID, AreaParameter>("area_get_param")

  @JvmField
  public val areaGetTransformName: MethodStringName1<PhysicsServer3D, Transform3D, RID> =
      MethodStringName1<PhysicsServer3D, Transform3D, RID>("area_get_transform")

  @JvmField
  public val areaAttachObjectInstanceIdName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("area_attach_object_instance_id")

  @JvmField
  public val areaGetObjectInstanceIdName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("area_get_object_instance_id")

  @JvmField
  public val areaSetMonitorCallbackName: MethodStringName2<PhysicsServer3D, Unit, RID, Callable> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Callable>("area_set_monitor_callback")

  @JvmField
  public val areaSetAreaMonitorCallbackName: MethodStringName2<PhysicsServer3D, Unit, RID, Callable>
      = MethodStringName2<PhysicsServer3D, Unit, RID, Callable>("area_set_area_monitor_callback")

  @JvmField
  public val areaSetMonitorableName: MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("area_set_monitorable")

  @JvmField
  public val areaSetRayPickableName: MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("area_set_ray_pickable")

  @JvmField
  public val bodyCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("body_create")

  @JvmField
  public val bodySetSpaceName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("body_set_space")

  @JvmField
  public val bodyGetSpaceName: MethodStringName1<PhysicsServer3D, RID, RID> =
      MethodStringName1<PhysicsServer3D, RID, RID>("body_get_space")

  @JvmField
  public val bodySetModeName: MethodStringName2<PhysicsServer3D, Unit, RID, BodyMode> =
      MethodStringName2<PhysicsServer3D, Unit, RID, BodyMode>("body_set_mode")

  @JvmField
  public val bodyGetModeName: MethodStringName1<PhysicsServer3D, BodyMode, RID> =
      MethodStringName1<PhysicsServer3D, BodyMode, RID>("body_get_mode")

  @JvmField
  public val bodySetCollisionLayerName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("body_set_collision_layer")

  @JvmField
  public val bodyGetCollisionLayerName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("body_get_collision_layer")

  @JvmField
  public val bodySetCollisionMaskName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("body_set_collision_mask")

  @JvmField
  public val bodyGetCollisionMaskName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("body_get_collision_mask")

  @JvmField
  public val bodySetCollisionPriorityName: MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("body_set_collision_priority")

  @JvmField
  public val bodyGetCollisionPriorityName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("body_get_collision_priority")

  @JvmField
  public val bodyAddShapeName:
      MethodStringName4<PhysicsServer3D, Unit, RID, RID, Transform3D, Boolean> =
      MethodStringName4<PhysicsServer3D, Unit, RID, RID, Transform3D, Boolean>("body_add_shape")

  @JvmField
  public val bodySetShapeName: MethodStringName3<PhysicsServer3D, Unit, RID, Int, RID> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, RID>("body_set_shape")

  @JvmField
  public val bodySetShapeTransformName:
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Transform3D> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Transform3D>("body_set_shape_transform")

  @JvmField
  public val bodySetShapeDisabledName: MethodStringName3<PhysicsServer3D, Unit, RID, Int, Boolean> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Boolean>("body_set_shape_disabled")

  @JvmField
  public val bodyGetShapeCountName: MethodStringName1<PhysicsServer3D, Int, RID> =
      MethodStringName1<PhysicsServer3D, Int, RID>("body_get_shape_count")

  @JvmField
  public val bodyGetShapeName: MethodStringName2<PhysicsServer3D, RID, RID, Int> =
      MethodStringName2<PhysicsServer3D, RID, RID, Int>("body_get_shape")

  @JvmField
  public val bodyGetShapeTransformName: MethodStringName2<PhysicsServer3D, Transform3D, RID, Int> =
      MethodStringName2<PhysicsServer3D, Transform3D, RID, Int>("body_get_shape_transform")

  @JvmField
  public val bodyRemoveShapeName: MethodStringName2<PhysicsServer3D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Int>("body_remove_shape")

  @JvmField
  public val bodyClearShapesName: MethodStringName1<PhysicsServer3D, Unit, RID> =
      MethodStringName1<PhysicsServer3D, Unit, RID>("body_clear_shapes")

  @JvmField
  public val bodyAttachObjectInstanceIdName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("body_attach_object_instance_id")

  @JvmField
  public val bodyGetObjectInstanceIdName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("body_get_object_instance_id")

  @JvmField
  public val bodySetEnableContinuousCollisionDetectionName:
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("body_set_enable_continuous_collision_detection")

  @JvmField
  public val bodyIsContinuousCollisionDetectionEnabledName:
      MethodStringName1<PhysicsServer3D, Boolean, RID> =
      MethodStringName1<PhysicsServer3D, Boolean, RID>("body_is_continuous_collision_detection_enabled")

  @JvmField
  public val bodySetParamName: MethodStringName3<PhysicsServer3D, Unit, RID, BodyParameter, Any?> =
      MethodStringName3<PhysicsServer3D, Unit, RID, BodyParameter, Any?>("body_set_param")

  @JvmField
  public val bodyGetParamName: MethodStringName2<PhysicsServer3D, Any?, RID, BodyParameter> =
      MethodStringName2<PhysicsServer3D, Any?, RID, BodyParameter>("body_get_param")

  @JvmField
  public val bodyResetMassPropertiesName: MethodStringName1<PhysicsServer3D, Unit, RID> =
      MethodStringName1<PhysicsServer3D, Unit, RID>("body_reset_mass_properties")

  @JvmField
  public val bodySetStateName: MethodStringName3<PhysicsServer3D, Unit, RID, BodyState, Any?> =
      MethodStringName3<PhysicsServer3D, Unit, RID, BodyState, Any?>("body_set_state")

  @JvmField
  public val bodyGetStateName: MethodStringName2<PhysicsServer3D, Any?, RID, BodyState> =
      MethodStringName2<PhysicsServer3D, Any?, RID, BodyState>("body_get_state")

  @JvmField
  public val bodyApplyCentralImpulseName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_apply_central_impulse")

  @JvmField
  public val bodyApplyImpulseName: MethodStringName3<PhysicsServer3D, Unit, RID, Vector3, Vector3> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Vector3, Vector3>("body_apply_impulse")

  @JvmField
  public val bodyApplyTorqueImpulseName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_apply_torque_impulse")

  @JvmField
  public val bodyApplyCentralForceName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_apply_central_force")

  @JvmField
  public val bodyApplyForceName: MethodStringName3<PhysicsServer3D, Unit, RID, Vector3, Vector3> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Vector3, Vector3>("body_apply_force")

  @JvmField
  public val bodyApplyTorqueName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_apply_torque")

  @JvmField
  public val bodyAddConstantCentralForceName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>
      = MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_add_constant_central_force")

  @JvmField
  public val bodyAddConstantForceName:
      MethodStringName3<PhysicsServer3D, Unit, RID, Vector3, Vector3> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Vector3, Vector3>("body_add_constant_force")

  @JvmField
  public val bodyAddConstantTorqueName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_add_constant_torque")

  @JvmField
  public val bodySetConstantForceName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_set_constant_force")

  @JvmField
  public val bodyGetConstantForceName: MethodStringName1<PhysicsServer3D, Vector3, RID> =
      MethodStringName1<PhysicsServer3D, Vector3, RID>("body_get_constant_force")

  @JvmField
  public val bodySetConstantTorqueName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_set_constant_torque")

  @JvmField
  public val bodyGetConstantTorqueName: MethodStringName1<PhysicsServer3D, Vector3, RID> =
      MethodStringName1<PhysicsServer3D, Vector3, RID>("body_get_constant_torque")

  @JvmField
  public val bodySetAxisVelocityName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("body_set_axis_velocity")

  @JvmField
  public val bodySetAxisLockName: MethodStringName3<PhysicsServer3D, Unit, RID, BodyAxis, Boolean> =
      MethodStringName3<PhysicsServer3D, Unit, RID, BodyAxis, Boolean>("body_set_axis_lock")

  @JvmField
  public val bodyIsAxisLockedName: MethodStringName2<PhysicsServer3D, Boolean, RID, BodyAxis> =
      MethodStringName2<PhysicsServer3D, Boolean, RID, BodyAxis>("body_is_axis_locked")

  @JvmField
  public val bodyAddCollisionExceptionName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("body_add_collision_exception")

  @JvmField
  public val bodyRemoveCollisionExceptionName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("body_remove_collision_exception")

  @JvmField
  public val bodySetMaxContactsReportedName: MethodStringName2<PhysicsServer3D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Int>("body_set_max_contacts_reported")

  @JvmField
  public val bodyGetMaxContactsReportedName: MethodStringName1<PhysicsServer3D, Int, RID> =
      MethodStringName1<PhysicsServer3D, Int, RID>("body_get_max_contacts_reported")

  @JvmField
  public val bodySetOmitForceIntegrationName: MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>
      = MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("body_set_omit_force_integration")

  @JvmField
  public val bodyIsOmittingForceIntegrationName: MethodStringName1<PhysicsServer3D, Boolean, RID> =
      MethodStringName1<PhysicsServer3D, Boolean, RID>("body_is_omitting_force_integration")

  @JvmField
  public val bodySetStateSyncCallbackName: MethodStringName2<PhysicsServer3D, Unit, RID, Callable> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Callable>("body_set_state_sync_callback")

  @JvmField
  public val bodySetForceIntegrationCallbackName:
      MethodStringName3<PhysicsServer3D, Unit, RID, Callable, Any?> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Callable, Any?>("body_set_force_integration_callback")

  @JvmField
  public val bodySetRayPickableName: MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("body_set_ray_pickable")

  @JvmField
  public val bodyTestMotionName:
      MethodStringName3<PhysicsServer3D, Boolean, RID, PhysicsTestMotionParameters3D, PhysicsTestMotionResult3D?>
      =
      MethodStringName3<PhysicsServer3D, Boolean, RID, PhysicsTestMotionParameters3D, PhysicsTestMotionResult3D?>("body_test_motion")

  @JvmField
  public val bodyGetDirectStateName:
      MethodStringName1<PhysicsServer3D, PhysicsDirectBodyState3D?, RID> =
      MethodStringName1<PhysicsServer3D, PhysicsDirectBodyState3D?, RID>("body_get_direct_state")

  @JvmField
  public val softBodyCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("soft_body_create")

  @JvmField
  public val softBodyUpdateRenderingServerName:
      MethodStringName2<PhysicsServer3D, Unit, RID, PhysicsServer3DRenderingServerHandler> =
      MethodStringName2<PhysicsServer3D, Unit, RID, PhysicsServer3DRenderingServerHandler>("soft_body_update_rendering_server")

  @JvmField
  public val softBodySetSpaceName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("soft_body_set_space")

  @JvmField
  public val softBodyGetSpaceName: MethodStringName1<PhysicsServer3D, RID, RID> =
      MethodStringName1<PhysicsServer3D, RID, RID>("soft_body_get_space")

  @JvmField
  public val softBodySetMeshName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("soft_body_set_mesh")

  @JvmField
  public val softBodyGetBoundsName: MethodStringName1<PhysicsServer3D, AABB, RID> =
      MethodStringName1<PhysicsServer3D, AABB, RID>("soft_body_get_bounds")

  @JvmField
  public val softBodySetCollisionLayerName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("soft_body_set_collision_layer")

  @JvmField
  public val softBodyGetCollisionLayerName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("soft_body_get_collision_layer")

  @JvmField
  public val softBodySetCollisionMaskName: MethodStringName2<PhysicsServer3D, Unit, RID, Long> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Long>("soft_body_set_collision_mask")

  @JvmField
  public val softBodyGetCollisionMaskName: MethodStringName1<PhysicsServer3D, Long, RID> =
      MethodStringName1<PhysicsServer3D, Long, RID>("soft_body_get_collision_mask")

  @JvmField
  public val softBodyAddCollisionExceptionName: MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("soft_body_add_collision_exception")

  @JvmField
  public val softBodyRemoveCollisionExceptionName:
      MethodStringName2<PhysicsServer3D, Unit, RID, RID> =
      MethodStringName2<PhysicsServer3D, Unit, RID, RID>("soft_body_remove_collision_exception")

  @JvmField
  public val softBodySetStateName: MethodStringName3<PhysicsServer3D, Unit, RID, BodyState, Any?> =
      MethodStringName3<PhysicsServer3D, Unit, RID, BodyState, Any?>("soft_body_set_state")

  @JvmField
  public val softBodyGetStateName: MethodStringName2<PhysicsServer3D, Any?, RID, BodyState> =
      MethodStringName2<PhysicsServer3D, Any?, RID, BodyState>("soft_body_get_state")

  @JvmField
  public val softBodySetTransformName: MethodStringName2<PhysicsServer3D, Unit, RID, Transform3D> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Transform3D>("soft_body_set_transform")

  @JvmField
  public val softBodySetRayPickableName: MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("soft_body_set_ray_pickable")

  @JvmField
  public val softBodySetSimulationPrecisionName: MethodStringName2<PhysicsServer3D, Unit, RID, Int>
      = MethodStringName2<PhysicsServer3D, Unit, RID, Int>("soft_body_set_simulation_precision")

  @JvmField
  public val softBodyGetSimulationPrecisionName: MethodStringName1<PhysicsServer3D, Int, RID> =
      MethodStringName1<PhysicsServer3D, Int, RID>("soft_body_get_simulation_precision")

  @JvmField
  public val softBodySetTotalMassName: MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("soft_body_set_total_mass")

  @JvmField
  public val softBodyGetTotalMassName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("soft_body_get_total_mass")

  @JvmField
  public val softBodySetLinearStiffnessName: MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("soft_body_set_linear_stiffness")

  @JvmField
  public val softBodyGetLinearStiffnessName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("soft_body_get_linear_stiffness")

  @JvmField
  public val softBodySetShrinkingFactorName: MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("soft_body_set_shrinking_factor")

  @JvmField
  public val softBodyGetShrinkingFactorName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("soft_body_get_shrinking_factor")

  @JvmField
  public val softBodySetPressureCoefficientName:
      MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("soft_body_set_pressure_coefficient")

  @JvmField
  public val softBodyGetPressureCoefficientName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("soft_body_get_pressure_coefficient")

  @JvmField
  public val softBodySetDampingCoefficientName: MethodStringName2<PhysicsServer3D, Unit, RID, Float>
      = MethodStringName2<PhysicsServer3D, Unit, RID, Float>("soft_body_set_damping_coefficient")

  @JvmField
  public val softBodyGetDampingCoefficientName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("soft_body_get_damping_coefficient")

  @JvmField
  public val softBodySetDragCoefficientName: MethodStringName2<PhysicsServer3D, Unit, RID, Float> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Float>("soft_body_set_drag_coefficient")

  @JvmField
  public val softBodyGetDragCoefficientName: MethodStringName1<PhysicsServer3D, Float, RID> =
      MethodStringName1<PhysicsServer3D, Float, RID>("soft_body_get_drag_coefficient")

  @JvmField
  public val softBodyMovePointName: MethodStringName3<PhysicsServer3D, Unit, RID, Int, Vector3> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Vector3>("soft_body_move_point")

  @JvmField
  public val softBodyGetPointGlobalPositionName:
      MethodStringName2<PhysicsServer3D, Vector3, RID, Int> =
      MethodStringName2<PhysicsServer3D, Vector3, RID, Int>("soft_body_get_point_global_position")

  @JvmField
  public val softBodyRemoveAllPinnedPointsName: MethodStringName1<PhysicsServer3D, Unit, RID> =
      MethodStringName1<PhysicsServer3D, Unit, RID>("soft_body_remove_all_pinned_points")

  @JvmField
  public val softBodyPinPointName: MethodStringName3<PhysicsServer3D, Unit, RID, Int, Boolean> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Boolean>("soft_body_pin_point")

  @JvmField
  public val softBodyIsPointPinnedName: MethodStringName2<PhysicsServer3D, Boolean, RID, Int> =
      MethodStringName2<PhysicsServer3D, Boolean, RID, Int>("soft_body_is_point_pinned")

  @JvmField
  public val softBodyApplyPointImpulseName:
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Vector3> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Vector3>("soft_body_apply_point_impulse")

  @JvmField
  public val softBodyApplyPointForceName:
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Vector3> =
      MethodStringName3<PhysicsServer3D, Unit, RID, Int, Vector3>("soft_body_apply_point_force")

  @JvmField
  public val softBodyApplyCentralImpulseName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>
      = MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("soft_body_apply_central_impulse")

  @JvmField
  public val softBodyApplyCentralForceName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("soft_body_apply_central_force")

  @JvmField
  public val jointCreateName: MethodStringName0<PhysicsServer3D, RID> =
      MethodStringName0<PhysicsServer3D, RID>("joint_create")

  @JvmField
  public val jointClearName: MethodStringName1<PhysicsServer3D, Unit, RID> =
      MethodStringName1<PhysicsServer3D, Unit, RID>("joint_clear")

  @JvmField
  public val jointMakePinName:
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Vector3, RID, Vector3> =
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Vector3, RID, Vector3>("joint_make_pin")

  @JvmField
  public val pinJointSetParamName:
      MethodStringName3<PhysicsServer3D, Unit, RID, PinJointParam, Float> =
      MethodStringName3<PhysicsServer3D, Unit, RID, PinJointParam, Float>("pin_joint_set_param")

  @JvmField
  public val pinJointGetParamName: MethodStringName2<PhysicsServer3D, Float, RID, PinJointParam> =
      MethodStringName2<PhysicsServer3D, Float, RID, PinJointParam>("pin_joint_get_param")

  @JvmField
  public val pinJointSetLocalAName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("pin_joint_set_local_a")

  @JvmField
  public val pinJointGetLocalAName: MethodStringName1<PhysicsServer3D, Vector3, RID> =
      MethodStringName1<PhysicsServer3D, Vector3, RID>("pin_joint_get_local_a")

  @JvmField
  public val pinJointSetLocalBName: MethodStringName2<PhysicsServer3D, Unit, RID, Vector3> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Vector3>("pin_joint_set_local_b")

  @JvmField
  public val pinJointGetLocalBName: MethodStringName1<PhysicsServer3D, Vector3, RID> =
      MethodStringName1<PhysicsServer3D, Vector3, RID>("pin_joint_get_local_b")

  @JvmField
  public val jointMakeHingeName:
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D> =
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D>("joint_make_hinge")

  @JvmField
  public val hingeJointSetParamName:
      MethodStringName3<PhysicsServer3D, Unit, RID, HingeJointParam, Float> =
      MethodStringName3<PhysicsServer3D, Unit, RID, HingeJointParam, Float>("hinge_joint_set_param")

  @JvmField
  public val hingeJointGetParamName: MethodStringName2<PhysicsServer3D, Float, RID, HingeJointParam>
      = MethodStringName2<PhysicsServer3D, Float, RID, HingeJointParam>("hinge_joint_get_param")

  @JvmField
  public val hingeJointSetFlagName:
      MethodStringName3<PhysicsServer3D, Unit, RID, HingeJointFlag, Boolean> =
      MethodStringName3<PhysicsServer3D, Unit, RID, HingeJointFlag, Boolean>("hinge_joint_set_flag")

  @JvmField
  public val hingeJointGetFlagName: MethodStringName2<PhysicsServer3D, Boolean, RID, HingeJointFlag>
      = MethodStringName2<PhysicsServer3D, Boolean, RID, HingeJointFlag>("hinge_joint_get_flag")

  @JvmField
  public val jointMakeSliderName:
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D> =
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D>("joint_make_slider")

  @JvmField
  public val sliderJointSetParamName:
      MethodStringName3<PhysicsServer3D, Unit, RID, SliderJointParam, Float> =
      MethodStringName3<PhysicsServer3D, Unit, RID, SliderJointParam, Float>("slider_joint_set_param")

  @JvmField
  public val sliderJointGetParamName:
      MethodStringName2<PhysicsServer3D, Float, RID, SliderJointParam> =
      MethodStringName2<PhysicsServer3D, Float, RID, SliderJointParam>("slider_joint_get_param")

  @JvmField
  public val jointMakeConeTwistName:
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D> =
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D>("joint_make_cone_twist")

  @JvmField
  public val coneTwistJointSetParamName:
      MethodStringName3<PhysicsServer3D, Unit, RID, ConeTwistJointParam, Float> =
      MethodStringName3<PhysicsServer3D, Unit, RID, ConeTwistJointParam, Float>("cone_twist_joint_set_param")

  @JvmField
  public val coneTwistJointGetParamName:
      MethodStringName2<PhysicsServer3D, Float, RID, ConeTwistJointParam> =
      MethodStringName2<PhysicsServer3D, Float, RID, ConeTwistJointParam>("cone_twist_joint_get_param")

  @JvmField
  public val jointGetTypeName: MethodStringName1<PhysicsServer3D, JointType, RID> =
      MethodStringName1<PhysicsServer3D, JointType, RID>("joint_get_type")

  @JvmField
  public val jointSetSolverPriorityName: MethodStringName2<PhysicsServer3D, Unit, RID, Int> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Int>("joint_set_solver_priority")

  @JvmField
  public val jointGetSolverPriorityName: MethodStringName1<PhysicsServer3D, Int, RID> =
      MethodStringName1<PhysicsServer3D, Int, RID>("joint_get_solver_priority")

  @JvmField
  public val jointDisableCollisionsBetweenBodiesName:
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean> =
      MethodStringName2<PhysicsServer3D, Unit, RID, Boolean>("joint_disable_collisions_between_bodies")

  @JvmField
  public val jointIsDisabledCollisionsBetweenBodiesName:
      MethodStringName1<PhysicsServer3D, Boolean, RID> =
      MethodStringName1<PhysicsServer3D, Boolean, RID>("joint_is_disabled_collisions_between_bodies")

  @JvmField
  public val jointMakeGeneric6dofName:
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D> =
      MethodStringName5<PhysicsServer3D, Unit, RID, RID, Transform3D, RID, Transform3D>("joint_make_generic_6dof")

  @JvmField
  public val generic6dofJointSetParamName:
      MethodStringName4<PhysicsServer3D, Unit, RID, Vector3.Axis, G6DOFJointAxisParam, Float> =
      MethodStringName4<PhysicsServer3D, Unit, RID, Vector3.Axis, G6DOFJointAxisParam, Float>("generic_6dof_joint_set_param")

  @JvmField
  public val generic6dofJointGetParamName:
      MethodStringName3<PhysicsServer3D, Float, RID, Vector3.Axis, G6DOFJointAxisParam> =
      MethodStringName3<PhysicsServer3D, Float, RID, Vector3.Axis, G6DOFJointAxisParam>("generic_6dof_joint_get_param")

  @JvmField
  public val generic6dofJointSetFlagName:
      MethodStringName4<PhysicsServer3D, Unit, RID, Vector3.Axis, G6DOFJointAxisFlag, Boolean> =
      MethodStringName4<PhysicsServer3D, Unit, RID, Vector3.Axis, G6DOFJointAxisFlag, Boolean>("generic_6dof_joint_set_flag")

  @JvmField
  public val generic6dofJointGetFlagName:
      MethodStringName3<PhysicsServer3D, Boolean, RID, Vector3.Axis, G6DOFJointAxisFlag> =
      MethodStringName3<PhysicsServer3D, Boolean, RID, Vector3.Axis, G6DOFJointAxisFlag>("generic_6dof_joint_get_flag")

  @JvmField
  public val freeRidName: MethodStringName1<PhysicsServer3D, Unit, RID> =
      MethodStringName1<PhysicsServer3D, Unit, RID>("free_rid")

  @JvmField
  public val setActiveName: MethodStringName1<PhysicsServer3D, Unit, Boolean> =
      MethodStringName1<PhysicsServer3D, Unit, Boolean>("set_active")

  @JvmField
  public val getProcessInfoName: MethodStringName1<PhysicsServer3D, Int, ProcessInfo> =
      MethodStringName1<PhysicsServer3D, Int, ProcessInfo>("get_process_info")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(26)
  }

  /**
   * Creates a 3D world boundary shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the shape's normal direction and distance properties.
   */
  @JvmStatic
  public final fun worldBoundaryShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.worldBoundaryShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D separation ray shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the shape's `length` and `slide_on_slope` properties.
   */
  @JvmStatic
  public final fun separationRayShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.separationRayShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D sphere shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the sphere's radius.
   */
  @JvmStatic
  public final fun sphereShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.sphereShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D box shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the box's half-extents.
   */
  @JvmStatic
  public final fun boxShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.boxShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D capsule shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the capsule's height and radius.
   */
  @JvmStatic
  public final fun capsuleShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.capsuleShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D cylinder shape in the physics server, and returns the [RID] that identifies it.
   * Use [shapeSetData] to set the cylinder's height and radius.
   */
  @JvmStatic
  public final fun cylinderShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cylinderShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D convex polygon shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the convex polygon's points.
   */
  @JvmStatic
  public final fun convexPolygonShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.convexPolygonShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D concave polygon shape in the physics server, and returns the [RID] that identifies
   * it. Use [shapeSetData] to set the concave polygon's triangles.
   */
  @JvmStatic
  public final fun concavePolygonShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.concavePolygonShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 3D heightmap shape in the physics server, and returns the [RID] that identifies it.
   * Use [shapeSetData] to set the heightmap's data.
   */
  @JvmStatic
  public final fun heightmapShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.heightmapShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a custom shape in the physics server, and returns the [RID] that identifies it. Use
   * [shapeSetData] to set the shape's data.
   *
   * **Note:** Custom shapes are not supported by the built-in physics servers, so calling this
   * method always produces an error when using Godot Physics or Jolt Physics. Custom physics servers
   * implemented as GDExtensions may support a custom shape.
   */
  @JvmStatic
  public final fun customShapeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.customShapeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the shape data that configures the shape. The [data] to be passed depends on the shape's
   * type (see [shapeGetType]):
   *
   * - [SHAPE_WORLD_BOUNDARY]: a [Plane],
   *
   * - [SHAPE_SEPARATION_RAY]: a dictionary containing the key `"length"` with a [Double] value and
   * the key `"slide_on_slope"` with a [Boolean] value,
   *
   * - [SHAPE_SPHERE]: a [Double] that is the radius of the sphere,
   *
   * - [SHAPE_BOX]: a [Vector3] containing the half-extents of the box,
   *
   * - [SHAPE_CAPSULE]: a dictionary containing the keys `"height"` and `"radius"` with [Double]
   * values,
   *
   * - [SHAPE_CYLINDER]: a dictionary containing the keys `"height"` and `"radius"` with [Double]
   * values,
   *
   * - [SHAPE_CONVEX_POLYGON]: a [PackedVector3Array] of points defining a convex polygon (the shape
   * will be the convex hull of the points),
   *
   * - [SHAPE_CONCAVE_POLYGON]: a dictionary containing the key `"faces"` with a
   * [PackedVector3Array] value (with a length divisible by 3, so that each 3-tuple of points forms a
   * face) and the key `"backface_collision"` with a [Boolean] value,
   *
   * - [SHAPE_HEIGHTMAP]: a dictionary containing the keys `"width"` and `"depth"` with [Long]
   * values, and the key `"heights"` with a value that is a packed array of [Double]s of length `width
   * * depth` (that is a [PackedFloat32Array], or a [PackedFloat64Array] if Godot was compiled with the
   * `precision=double` option), and optionally the keys `"min_height"` and `"max_height"` with
   * [Double] values,
   *
   * - [SHAPE_SOFT_BODY]: the input [data] is ignored and this method has no effect,
   *
   * - [SHAPE_CUSTOM]: the input [data] is interpreted by a custom physics server, if it supports
   * custom shapes.
   */
  @JvmStatic
  public final fun shapeSetData(shape: RID, `data`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape, ANY to data)
    TransferContext.callMethod(MethodBindings.shapeSetDataPtr)
  }

  /**
   * Sets the collision margin for the shape.
   *
   * **Note:** This is not used in Godot Physics.
   */
  @JvmStatic
  public final fun shapeSetMargin(shape: RID, margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.shapeSetMarginPtr)
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
   * Returns the shape data that configures the shape, such as the half-extents of a box or the
   * triangles of a concave (trimesh) shape. See [shapeSetData] for the precise format of this data in
   * each case.
   */
  @JvmStatic
  public final fun shapeGetData(shape: RID): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape)
    TransferContext.callMethod(MethodBindings.shapeGetDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the collision margin for the shape.
   *
   * **Note:** This is not used in Godot Physics, so will always return `0`.
   */
  @JvmStatic
  public final fun shapeGetMargin(shape: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape)
    TransferContext.callMethod(MethodBindings.shapeGetMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Creates a space. A space is a collection of parameters for the physics engine that can be
   * assigned to an area or a body. It can be assigned to an area with [areaSetSpace], or to a body
   * with [bodySetSpace].
   */
  @JvmStatic
  public final fun spaceCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.spaceCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Marks a space as active. It will not have an effect, unless it is assigned to an area or body.
   */
  @JvmStatic
  public final fun spaceSetActive(space: RID, active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space, BOOL to active)
    TransferContext.callMethod(MethodBindings.spaceSetActivePtr)
  }

  /**
   * Returns whether the space is active.
   */
  @JvmStatic
  public final fun spaceIsActive(space: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space)
    TransferContext.callMethod(MethodBindings.spaceIsActivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the value for a space parameter. A list of available parameters is on the [SpaceParameter]
   * constants.
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
   * Returns the value of a space parameter.
   */
  @JvmStatic
  public final fun spaceGetParam(space: RID, `param`: SpaceParameter): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space, LONG to param.value)
    TransferContext.callMethod(MethodBindings.spaceGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the state of a space, a [PhysicsDirectSpaceState3D]. This object can be used to make
   * collision/intersection queries.
   */
  @JvmStatic
  public final fun spaceGetDirectState(space: RID): PhysicsDirectSpaceState3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to space)
    TransferContext.callMethod(MethodBindings.spaceGetDirectStatePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsDirectSpaceState3D?)
  }

  /**
   * Creates a 3D area object in the physics server, and returns the [RID] that identifies it. The
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
   * Assigns a space to the area.
   */
  @JvmStatic
  public final fun areaSetSpace(area: RID, space: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, _RID to space)
    TransferContext.callMethod(MethodBindings.areaSetSpacePtr)
  }

  /**
   * Returns the space assigned to the area.
   */
  @JvmStatic
  public final fun areaGetSpace(area: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetSpacePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Adds a shape to the area, along with a transform matrix. Shapes are usually referenced by their
   * index, so you should track which shape has a given index.
   */
  @JvmOverloads
  @JvmStatic
  public final fun areaAddShape(
    area: RID,
    shape: RID,
    transform: Transform3D = Transform3D(),
    disabled: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, _RID to shape, TRANSFORM3D to transform, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.areaAddShapePtr)
  }

  /**
   * Substitutes a given area shape by another. The old shape is selected by its index, the new one
   * by its [RID].
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
   * Sets the transform matrix for an area shape.
   */
  @JvmStatic
  public final fun areaSetShapeTransform(
    area: RID,
    shapeIdx: Int,
    transform: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong(), TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.areaSetShapeTransformPtr)
  }

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
   * Returns the number of shapes assigned to an area.
   */
  @JvmStatic
  public final fun areaGetShapeCount(area: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [RID] of the nth shape of an area.
   */
  @JvmStatic
  public final fun areaGetShape(area: RID, shapeIdx: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.areaGetShapePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the transform matrix of a shape within an area.
   */
  @JvmStatic
  public final fun areaGetShapeTransform(area: RID, shapeIdx: Int): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.areaGetShapeTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Removes a shape from an area. It does not delete the shape, so it can be reassigned later.
   */
  @JvmStatic
  public final fun areaRemoveShape(area: RID, shapeIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.areaRemoveShapePtr)
  }

  /**
   * Removes all shapes from an area. It does not delete the shapes, so they can be reassigned
   * later.
   */
  @JvmStatic
  public final fun areaClearShapes(area: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaClearShapesPtr)
  }

  /**
   * Assigns the area to one or many physics layers.
   */
  @JvmStatic
  public final fun areaSetCollisionLayer(area: RID, layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to layer)
    TransferContext.callMethod(MethodBindings.areaSetCollisionLayerPtr)
  }

  /**
   * Returns the physics layer or layers an area belongs to.
   */
  @JvmStatic
  public final fun areaGetCollisionLayer(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets which physics layers the area will monitor.
   */
  @JvmStatic
  public final fun areaSetCollisionMask(area: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to mask)
    TransferContext.callMethod(MethodBindings.areaSetCollisionMaskPtr)
  }

  /**
   * Returns the physics layer or layers an area can contact with.
   */
  @JvmStatic
  public final fun areaGetCollisionMask(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the value for an area parameter. A list of available parameters is on the [AreaParameter]
   * constants.
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
   * Sets the transform matrix for an area.
   */
  @JvmStatic
  public final fun areaSetTransform(area: RID, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.areaSetTransformPtr)
  }

  /**
   * Returns an area parameter value. A list of available parameters is on the [AreaParameter]
   * constants.
   */
  @JvmStatic
  public final fun areaGetParam(area: RID, `param`: AreaParameter): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to param.value)
    TransferContext.callMethod(MethodBindings.areaGetParamPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the transform matrix for an area.
   */
  @JvmStatic
  public final fun areaGetTransform(area: RID): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Assigns the area to a descendant of [Object], so it can exist in the node tree.
   */
  @JvmStatic
  public final fun areaAttachObjectInstanceId(area: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, LONG to id)
    TransferContext.callMethod(MethodBindings.areaAttachObjectInstanceIdPtr)
  }

  /**
   * Gets the instance ID of the object the area is assigned to.
   */
  @JvmStatic
  public final fun areaGetObjectInstanceId(area: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area)
    TransferContext.callMethod(MethodBindings.areaGetObjectInstanceIdPtr)
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

  @JvmStatic
  public final fun areaSetMonitorable(area: RID, monitorable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, BOOL to monitorable)
    TransferContext.callMethod(MethodBindings.areaSetMonitorablePtr)
  }

  /**
   * Sets object pickable with rays.
   */
  @JvmStatic
  public final fun areaSetRayPickable(area: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to area, BOOL to enable)
    TransferContext.callMethod(MethodBindings.areaSetRayPickablePtr)
  }

  /**
   * Creates a 3D body object in the physics server, and returns the [RID] that identifies it. The
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
   * Assigns a space to the body (see [spaceCreate]).
   */
  @JvmStatic
  public final fun bodySetSpace(body: RID, space: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to space)
    TransferContext.callMethod(MethodBindings.bodySetSpacePtr)
  }

  /**
   * Returns the [RID] of the space assigned to a body.
   */
  @JvmStatic
  public final fun bodyGetSpace(body: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetSpacePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the body mode.
   */
  @JvmStatic
  public final fun bodySetMode(body: RID, mode: BodyMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.bodySetModePtr)
  }

  /**
   * Returns the body mode.
   */
  @JvmStatic
  public final fun bodyGetMode(body: RID): BodyMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetModePtr)
    return BodyMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the physics layer or layers a body belongs to.
   */
  @JvmStatic
  public final fun bodySetCollisionLayer(body: RID, layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to layer)
    TransferContext.callMethod(MethodBindings.bodySetCollisionLayerPtr)
  }

  /**
   * Returns the physics layer or layers a body belongs to.
   */
  @JvmStatic
  public final fun bodyGetCollisionLayer(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the physics layer or layers a body can collide with.
   */
  @JvmStatic
  public final fun bodySetCollisionMask(body: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to mask)
    TransferContext.callMethod(MethodBindings.bodySetCollisionMaskPtr)
  }

  /**
   * Returns the physics layer or layers a body can collide with.
   */
  @JvmStatic
  public final fun bodyGetCollisionMask(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the body's collision priority.
   */
  @JvmStatic
  public final fun bodySetCollisionPriority(body: RID, priority: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to priority.toDouble())
    TransferContext.callMethod(MethodBindings.bodySetCollisionPriorityPtr)
  }

  /**
   * Returns the body's collision priority.
   */
  @JvmStatic
  public final fun bodyGetCollisionPriority(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetCollisionPriorityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Adds a shape to the body, along with a transform matrix. Shapes are usually referenced by their
   * index, so you should track which shape has a given index.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyAddShape(
    body: RID,
    shape: RID,
    transform: Transform3D = Transform3D(),
    disabled: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to shape, TRANSFORM3D to transform, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.bodyAddShapePtr)
  }

  /**
   * Substitutes a given body shape by another. The old shape is selected by its index, the new one
   * by its [RID].
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
   * Sets the transform matrix for a body shape.
   */
  @JvmStatic
  public final fun bodySetShapeTransform(
    body: RID,
    shapeIdx: Int,
    transform: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong(), TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.bodySetShapeTransformPtr)
  }

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
   * Returns the number of shapes assigned to a body.
   */
  @JvmStatic
  public final fun bodyGetShapeCount(body: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [RID] of the nth shape of a body.
   */
  @JvmStatic
  public final fun bodyGetShape(body: RID, shapeIdx: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.bodyGetShapePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the transform matrix of a body shape.
   */
  @JvmStatic
  public final fun bodyGetShapeTransform(body: RID, shapeIdx: Int): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.bodyGetShapeTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Removes a shape from a body. The shape is not deleted, so it can be reused afterwards.
   */
  @JvmStatic
  public final fun bodyRemoveShape(body: RID, shapeIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to shapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.bodyRemoveShapePtr)
  }

  /**
   * Removes all shapes from a body.
   */
  @JvmStatic
  public final fun bodyClearShapes(body: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyClearShapesPtr)
  }

  /**
   * Assigns the area to a descendant of [Object], so it can exist in the node tree.
   */
  @JvmStatic
  public final fun bodyAttachObjectInstanceId(body: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to id)
    TransferContext.callMethod(MethodBindings.bodyAttachObjectInstanceIdPtr)
  }

  /**
   * Gets the instance ID of the object the area is assigned to.
   */
  @JvmStatic
  public final fun bodyGetObjectInstanceId(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetObjectInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If `true`, the continuous collision detection mode is enabled.
   *
   * Continuous collision detection tries to predict where a moving body will collide, instead of
   * moving it and correcting its movement if it collided.
   */
  @JvmStatic
  public final fun bodySetEnableContinuousCollisionDetection(body: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, BOOL to enable)
    TransferContext.callMethod(MethodBindings.bodySetEnableContinuousCollisionDetectionPtr)
  }

  /**
   * If `true`, the continuous collision detection mode is enabled.
   */
  @JvmStatic
  public final fun bodyIsContinuousCollisionDetectionEnabled(body: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyIsContinuousCollisionDetectionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets a body parameter. A list of available parameters is on the [BodyParameter] constants.
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
   * Returns the value of a body parameter. A list of available parameters is on the [BodyParameter]
   * constants.
   */
  @JvmStatic
  public final fun bodyGetParam(body: RID, `param`: BodyParameter): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to param.value)
    TransferContext.callMethod(MethodBindings.bodyGetParamPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Restores the default inertia and center of mass based on shapes to cancel any custom values
   * previously set using [bodySetParam].
   */
  @JvmStatic
  public final fun bodyResetMassProperties(body: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyResetMassPropertiesPtr)
  }

  /**
   * Sets a body state.
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
   * Returns a body state.
   */
  @JvmStatic
  public final fun bodyGetState(body: RID, state: BodyState): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to state.value)
    TransferContext.callMethod(MethodBindings.bodyGetStatePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Applies a directional impulse without affecting rotation.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   *
   * This is equivalent to using [bodyApplyImpulse] at the body's center of mass.
   */
  @JvmStatic
  public final fun bodyApplyCentralImpulse(body: RID, impulse: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to impulse)
    TransferContext.callMethod(MethodBindings.bodyApplyCentralImpulsePtr)
  }

  /**
   * Applies a positioned impulse to the body.
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
    impulse: Vector3,
    position: Vector3 = Vector3(0, 0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to impulse, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.bodyApplyImpulsePtr)
  }

  /**
   * Applies a rotational impulse to the body without affecting the position.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   */
  @JvmStatic
  public final fun bodyApplyTorqueImpulse(body: RID, impulse: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to impulse)
    TransferContext.callMethod(MethodBindings.bodyApplyTorqueImpulsePtr)
  }

  /**
   * Applies a directional force without affecting rotation. A force is time dependent and meant to
   * be applied every physics update.
   *
   * This is equivalent to using [bodyApplyForce] at the body's center of mass.
   */
  @JvmStatic
  public final fun bodyApplyCentralForce(body: RID, force: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.bodyApplyCentralForcePtr)
  }

  /**
   * Applies a positioned force to the body. A force is time dependent and meant to be applied every
   * physics update.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyApplyForce(
    body: RID,
    force: Vector3,
    position: Vector3 = Vector3(0, 0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to force, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.bodyApplyForcePtr)
  }

  /**
   * Applies a rotational force without affecting position. A force is time dependent and meant to
   * be applied every physics update.
   */
  @JvmStatic
  public final fun bodyApplyTorque(body: RID, torque: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to torque)
    TransferContext.callMethod(MethodBindings.bodyApplyTorquePtr)
  }

  /**
   * Adds a constant directional force without affecting rotation that keeps being applied over time
   * until cleared with `body_set_constant_force(body, Vector3(0, 0, 0))`.
   *
   * This is equivalent to using [bodyAddConstantForce] at the body's center of mass.
   */
  @JvmStatic
  public final fun bodyAddConstantCentralForce(body: RID, force: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.bodyAddConstantCentralForcePtr)
  }

  /**
   * Adds a constant positioned force to the body that keeps being applied over time until cleared
   * with `body_set_constant_force(body, Vector3(0, 0, 0))`.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyAddConstantForce(
    body: RID,
    force: Vector3,
    position: Vector3 = Vector3(0, 0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to force, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.bodyAddConstantForcePtr)
  }

  /**
   * Adds a constant rotational force without affecting position that keeps being applied over time
   * until cleared with `body_set_constant_torque(body, Vector3(0, 0, 0))`.
   */
  @JvmStatic
  public final fun bodyAddConstantTorque(body: RID, torque: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to torque)
    TransferContext.callMethod(MethodBindings.bodyAddConstantTorquePtr)
  }

  /**
   * Sets the body's total constant positional forces applied during each physics update.
   *
   * See [bodyAddConstantForce] and [bodyAddConstantCentralForce].
   */
  @JvmStatic
  public final fun bodySetConstantForce(body: RID, force: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.bodySetConstantForcePtr)
  }

  /**
   * Returns the body's total constant positional forces applied during each physics update.
   *
   * See [bodyAddConstantForce] and [bodyAddConstantCentralForce].
   */
  @JvmStatic
  public final fun bodyGetConstantForce(body: RID): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetConstantForcePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the body's total constant rotational forces applied during each physics update.
   *
   * See [bodyAddConstantTorque].
   */
  @JvmStatic
  public final fun bodySetConstantTorque(body: RID, torque: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to torque)
    TransferContext.callMethod(MethodBindings.bodySetConstantTorquePtr)
  }

  /**
   * Returns the body's total constant rotational forces applied during each physics update.
   *
   * See [bodyAddConstantTorque].
   */
  @JvmStatic
  public final fun bodyGetConstantTorque(body: RID): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetConstantTorquePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets an axis velocity. The velocity in the given vector axis will be set as the given vector
   * length. This is useful for jumping behavior.
   */
  @JvmStatic
  public final fun bodySetAxisVelocity(body: RID, axisVelocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to axisVelocity)
    TransferContext.callMethod(MethodBindings.bodySetAxisVelocityPtr)
  }

  @JvmStatic
  public final fun bodySetAxisLock(
    body: RID,
    axis: BodyAxis,
    lock: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to axis.value, BOOL to lock)
    TransferContext.callMethod(MethodBindings.bodySetAxisLockPtr)
  }

  @JvmStatic
  public final fun bodyIsAxisLocked(body: RID, axis: BodyAxis): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to axis.value)
    TransferContext.callMethod(MethodBindings.bodyIsAxisLockedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a body to the list of bodies exempt from collisions.
   */
  @JvmStatic
  public final fun bodyAddCollisionException(body: RID, exceptedBody: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to exceptedBody)
    TransferContext.callMethod(MethodBindings.bodyAddCollisionExceptionPtr)
  }

  /**
   * Removes a body from the list of bodies exempt from collisions.
   *
   * Continuous collision detection tries to predict where a moving body will collide, instead of
   * moving it and correcting its movement if it collided.
   */
  @JvmStatic
  public final fun bodyRemoveCollisionException(body: RID, exceptedBody: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to exceptedBody)
    TransferContext.callMethod(MethodBindings.bodyRemoveCollisionExceptionPtr)
  }

  /**
   * Sets the maximum contacts to report. Bodies can keep a log of the contacts with other bodies.
   * This is enabled by setting the maximum number of contacts reported to a number greater than 0.
   */
  @JvmStatic
  public final fun bodySetMaxContactsReported(body: RID, amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.bodySetMaxContactsReportedPtr)
  }

  /**
   * Returns the maximum contacts that can be reported. See [bodySetMaxContactsReported].
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
   * This method is called when the property [RigidBody3D.customIntegrator] is set.
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
   * 1. `state`: a [PhysicsDirectBodyState3D], used to retrieve the body's state.
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
   * 1. `state`: a [PhysicsDirectBodyState3D], used to retrieve and modify the body's state,
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
   * Sets the body pickable with rays if [enable] is set.
   */
  @JvmStatic
  public final fun bodySetRayPickable(body: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, BOOL to enable)
    TransferContext.callMethod(MethodBindings.bodySetRayPickablePtr)
  }

  /**
   * Returns `true` if a collision would result from moving along a motion vector from a given point
   * in space. [PhysicsTestMotionParameters3D] is passed to set motion parameters.
   * [PhysicsTestMotionResult3D] can be passed to return additional information.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bodyTestMotion(
    body: RID,
    parameters: PhysicsTestMotionParameters3D,
    result: PhysicsTestMotionResult3D? = null,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, OBJECT to parameters, OBJECT to result)
    TransferContext.callMethod(MethodBindings.bodyTestMotionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [PhysicsDirectBodyState3D] of the body. Returns `null` if the body is destroyed or
   * removed from the physics space.
   */
  @JvmStatic
  public final fun bodyGetDirectState(body: RID): PhysicsDirectBodyState3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.bodyGetDirectStatePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsDirectBodyState3D?)
  }

  /**
   * Creates a new soft body and returns its internal [RID].
   */
  @JvmStatic
  public final fun softBodyCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.softBodyCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Requests that the physics server updates the rendering server with the latest positions of the
   * given soft body's points through the [renderingServerHandler] interface.
   */
  @JvmStatic
  public final fun softBodyUpdateRenderingServer(body: RID,
      renderingServerHandler: PhysicsServer3DRenderingServerHandler): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, OBJECT to renderingServerHandler)
    TransferContext.callMethod(MethodBindings.softBodyUpdateRenderingServerPtr)
  }

  /**
   * Assigns a space to the given soft body (see [spaceCreate]).
   */
  @JvmStatic
  public final fun softBodySetSpace(body: RID, space: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to space)
    TransferContext.callMethod(MethodBindings.softBodySetSpacePtr)
  }

  /**
   * Returns the [RID] of the space assigned to the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetSpace(body: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetSpacePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the mesh of the given soft body.
   */
  @JvmStatic
  public final fun softBodySetMesh(body: RID, mesh: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to mesh)
    TransferContext.callMethod(MethodBindings.softBodySetMeshPtr)
  }

  /**
   * Returns the bounds of the given soft body in global coordinates.
   */
  @JvmStatic
  public final fun softBodyGetBounds(body: RID): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetBoundsPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  /**
   * Sets the physics layer or layers the given soft body belongs to.
   */
  @JvmStatic
  public final fun softBodySetCollisionLayer(body: RID, layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to layer)
    TransferContext.callMethod(MethodBindings.softBodySetCollisionLayerPtr)
  }

  /**
   * Returns the physics layer or layers that the given soft body belongs to.
   */
  @JvmStatic
  public final fun softBodyGetCollisionLayer(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the physics layer or layers the given soft body can collide with.
   */
  @JvmStatic
  public final fun softBodySetCollisionMask(body: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to mask)
    TransferContext.callMethod(MethodBindings.softBodySetCollisionMaskPtr)
  }

  /**
   * Returns the physics layer or layers that the given soft body can collide with.
   */
  @JvmStatic
  public final fun softBodyGetCollisionMask(body: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Adds the given body to the list of bodies exempt from collisions.
   */
  @JvmStatic
  public final fun softBodyAddCollisionException(body: RID, bodyB: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to bodyB)
    TransferContext.callMethod(MethodBindings.softBodyAddCollisionExceptionPtr)
  }

  /**
   * Removes the given body from the list of bodies exempt from collisions.
   */
  @JvmStatic
  public final fun softBodyRemoveCollisionException(body: RID, bodyB: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, _RID to bodyB)
    TransferContext.callMethod(MethodBindings.softBodyRemoveCollisionExceptionPtr)
  }

  /**
   * Sets the given body state for the given body.
   *
   * **Note:** Godot's default physics implementation does not support [BODY_STATE_LINEAR_VELOCITY],
   * [BODY_STATE_ANGULAR_VELOCITY], [BODY_STATE_SLEEPING], or [BODY_STATE_CAN_SLEEP].
   */
  @JvmStatic
  public final fun softBodySetState(
    body: RID,
    state: BodyState,
    variant: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to state.value, ANY to variant)
    TransferContext.callMethod(MethodBindings.softBodySetStatePtr)
  }

  /**
   * Returns the given soft body state.
   *
   * **Note:** Godot's default physics implementation does not support [BODY_STATE_LINEAR_VELOCITY],
   * [BODY_STATE_ANGULAR_VELOCITY], [BODY_STATE_SLEEPING], or [BODY_STATE_CAN_SLEEP].
   */
  @JvmStatic
  public final fun softBodyGetState(body: RID, state: BodyState): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to state.value)
    TransferContext.callMethod(MethodBindings.softBodyGetStatePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets the global transform of the given soft body.
   */
  @JvmStatic
  public final fun softBodySetTransform(body: RID, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.softBodySetTransformPtr)
  }

  /**
   * Sets whether the given soft body will be pickable when using object picking.
   */
  @JvmStatic
  public final fun softBodySetRayPickable(body: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, BOOL to enable)
    TransferContext.callMethod(MethodBindings.softBodySetRayPickablePtr)
  }

  /**
   * Sets the simulation precision of the given soft body. Increasing this value will improve the
   * resulting simulation, but can affect performance. Use with care.
   */
  @JvmStatic
  public final fun softBodySetSimulationPrecision(body: RID, simulationPrecision: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to simulationPrecision.toLong())
    TransferContext.callMethod(MethodBindings.softBodySetSimulationPrecisionPtr)
  }

  /**
   * Returns the simulation precision of the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetSimulationPrecision(body: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetSimulationPrecisionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the total mass for the given soft body.
   */
  @JvmStatic
  public final fun softBodySetTotalMass(body: RID, totalMass: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to totalMass.toDouble())
    TransferContext.callMethod(MethodBindings.softBodySetTotalMassPtr)
  }

  /**
   * Returns the total mass assigned to the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetTotalMass(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetTotalMassPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the linear stiffness of the given soft body. Higher values will result in a stiffer body,
   * while lower values will increase the body's ability to bend. The value can be between `0.0` and
   * `1.0` (inclusive).
   */
  @JvmStatic
  public final fun softBodySetLinearStiffness(body: RID, stiffness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to stiffness.toDouble())
    TransferContext.callMethod(MethodBindings.softBodySetLinearStiffnessPtr)
  }

  /**
   * Returns the linear stiffness of the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetLinearStiffness(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetLinearStiffnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the shrinking factor of the given soft body.
   */
  @JvmStatic
  public final fun softBodySetShrinkingFactor(body: RID, shrinkingFactor: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to shrinkingFactor.toDouble())
    TransferContext.callMethod(MethodBindings.softBodySetShrinkingFactorPtr)
  }

  /**
   * Returns the shrinking factor of the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetShrinkingFactor(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetShrinkingFactorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the pressure coefficient of the given soft body. Simulates pressure build-up from inside
   * this body. Higher values increase the strength of this effect.
   */
  @JvmStatic
  public final fun softBodySetPressureCoefficient(body: RID, pressureCoefficient: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to pressureCoefficient.toDouble())
    TransferContext.callMethod(MethodBindings.softBodySetPressureCoefficientPtr)
  }

  /**
   * Returns the pressure coefficient of the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetPressureCoefficient(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetPressureCoefficientPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the damping coefficient of the given soft body. Higher values will slow down the body more
   * noticeably when forces are applied.
   */
  @JvmStatic
  public final fun softBodySetDampingCoefficient(body: RID, dampingCoefficient: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to dampingCoefficient.toDouble())
    TransferContext.callMethod(MethodBindings.softBodySetDampingCoefficientPtr)
  }

  /**
   * Returns the damping coefficient of the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetDampingCoefficient(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetDampingCoefficientPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the drag coefficient of the given soft body. Higher values increase this body's air
   * resistance.
   *
   * **Note:** This value is currently unused by Godot's default physics implementation.
   */
  @JvmStatic
  public final fun softBodySetDragCoefficient(body: RID, dragCoefficient: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, DOUBLE to dragCoefficient.toDouble())
    TransferContext.callMethod(MethodBindings.softBodySetDragCoefficientPtr)
  }

  /**
   * Returns the drag coefficient of the given soft body.
   */
  @JvmStatic
  public final fun softBodyGetDragCoefficient(body: RID): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyGetDragCoefficientPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Moves the given soft body point to a position in global coordinates.
   */
  @JvmStatic
  public final fun softBodyMovePoint(
    body: RID,
    pointIndex: Int,
    globalPosition: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to pointIndex.toLong(), VECTOR3 to globalPosition)
    TransferContext.callMethod(MethodBindings.softBodyMovePointPtr)
  }

  /**
   * Returns the current position of the given soft body point in global coordinates.
   */
  @JvmStatic
  public final fun softBodyGetPointGlobalPosition(body: RID, pointIndex: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to pointIndex.toLong())
    TransferContext.callMethod(MethodBindings.softBodyGetPointGlobalPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Unpins all points of the given soft body.
   */
  @JvmStatic
  public final fun softBodyRemoveAllPinnedPoints(body: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.softBodyRemoveAllPinnedPointsPtr)
  }

  /**
   * Pins or unpins the given soft body point based on the value of [pin].
   *
   * **Note:** Pinning a point effectively makes it kinematic, preventing it from being affected by
   * forces, but you can still move it using [softBodyMovePoint].
   */
  @JvmStatic
  public final fun softBodyPinPoint(
    body: RID,
    pointIndex: Int,
    pin: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to pointIndex.toLong(), BOOL to pin)
    TransferContext.callMethod(MethodBindings.softBodyPinPointPtr)
  }

  /**
   * Returns whether the given soft body point is pinned.
   */
  @JvmStatic
  public final fun softBodyIsPointPinned(body: RID, pointIndex: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to pointIndex.toLong())
    TransferContext.callMethod(MethodBindings.softBodyIsPointPinnedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Applies an impulse to a point.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   */
  @JvmStatic
  public final fun softBodyApplyPointImpulse(
    body: RID,
    pointIndex: Int,
    impulse: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to pointIndex.toLong(), VECTOR3 to impulse)
    TransferContext.callMethod(MethodBindings.softBodyApplyPointImpulsePtr)
  }

  /**
   * Applies a force to a point. A force is time dependent and meant to be applied every physics
   * update.
   */
  @JvmStatic
  public final fun softBodyApplyPointForce(
    body: RID,
    pointIndex: Int,
    force: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, LONG to pointIndex.toLong(), VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.softBodyApplyPointForcePtr)
  }

  /**
   * Distributes and applies an impulse to all points.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   */
  @JvmStatic
  public final fun softBodyApplyCentralImpulse(body: RID, impulse: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to impulse)
    TransferContext.callMethod(MethodBindings.softBodyApplyCentralImpulsePtr)
  }

  /**
   * Distributes and applies a force to all points. A force is time dependent and meant to be
   * applied every physics update.
   */
  @JvmStatic
  public final fun softBodyApplyCentralForce(body: RID, force: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.softBodyApplyCentralForcePtr)
  }

  @JvmStatic
  public final fun jointCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.jointCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  @JvmStatic
  public final fun jointClear(joint: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointClearPtr)
  }

  @JvmStatic
  public final fun jointMakePin(
    joint: RID,
    bodyA: RID,
    localA: Vector3,
    bodyB: RID,
    localB: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, _RID to bodyA, VECTOR3 to localA, _RID to bodyB, VECTOR3 to localB)
    TransferContext.callMethod(MethodBindings.jointMakePinPtr)
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
   * Gets a pin joint parameter.
   */
  @JvmStatic
  public final fun pinJointGetParam(joint: RID, `param`: PinJointParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.pinJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets position of the joint in the local space of body a of the joint.
   */
  @JvmStatic
  public final fun pinJointSetLocalA(joint: RID, localA: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, VECTOR3 to localA)
    TransferContext.callMethod(MethodBindings.pinJointSetLocalAPtr)
  }

  /**
   * Returns position of the joint in the local space of body a of the joint.
   */
  @JvmStatic
  public final fun pinJointGetLocalA(joint: RID): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.pinJointGetLocalAPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets position of the joint in the local space of body b of the joint.
   */
  @JvmStatic
  public final fun pinJointSetLocalB(joint: RID, localB: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, VECTOR3 to localB)
    TransferContext.callMethod(MethodBindings.pinJointSetLocalBPtr)
  }

  /**
   * Returns position of the joint in the local space of body b of the joint.
   */
  @JvmStatic
  public final fun pinJointGetLocalB(joint: RID): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.pinJointGetLocalBPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  @JvmStatic
  public final fun jointMakeHinge(
    joint: RID,
    bodyA: RID,
    hingeA: Transform3D,
    bodyB: RID,
    hingeB: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, _RID to bodyA, TRANSFORM3D to hingeA, _RID to bodyB, TRANSFORM3D to hingeB)
    TransferContext.callMethod(MethodBindings.jointMakeHingePtr)
  }

  /**
   * Sets a hinge joint parameter.
   */
  @JvmStatic
  public final fun hingeJointSetParam(
    joint: RID,
    `param`: HingeJointParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.hingeJointSetParamPtr)
  }

  /**
   * Gets a hinge joint parameter.
   */
  @JvmStatic
  public final fun hingeJointGetParam(joint: RID, `param`: HingeJointParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.hingeJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets a hinge joint flag.
   */
  @JvmStatic
  public final fun hingeJointSetFlag(
    joint: RID,
    flag: HingeJointFlag,
    enabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.hingeJointSetFlagPtr)
  }

  /**
   * Gets a hinge joint flag.
   */
  @JvmStatic
  public final fun hingeJointGetFlag(joint: RID, flag: HingeJointFlag): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.hingeJointGetFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  @JvmStatic
  public final fun jointMakeSlider(
    joint: RID,
    bodyA: RID,
    localRefA: Transform3D,
    bodyB: RID,
    localRefB: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, _RID to bodyA, TRANSFORM3D to localRefA, _RID to bodyB, TRANSFORM3D to localRefB)
    TransferContext.callMethod(MethodBindings.jointMakeSliderPtr)
  }

  /**
   * Gets a slider joint parameter.
   */
  @JvmStatic
  public final fun sliderJointSetParam(
    joint: RID,
    `param`: SliderJointParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.sliderJointSetParamPtr)
  }

  /**
   * Gets a slider joint parameter.
   */
  @JvmStatic
  public final fun sliderJointGetParam(joint: RID, `param`: SliderJointParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.sliderJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  @JvmStatic
  public final fun jointMakeConeTwist(
    joint: RID,
    bodyA: RID,
    localRefA: Transform3D,
    bodyB: RID,
    localRefB: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, _RID to bodyA, TRANSFORM3D to localRefA, _RID to bodyB, TRANSFORM3D to localRefB)
    TransferContext.callMethod(MethodBindings.jointMakeConeTwistPtr)
  }

  /**
   * Sets a cone twist joint parameter.
   */
  @JvmStatic
  public final fun coneTwistJointSetParam(
    joint: RID,
    `param`: ConeTwistJointParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.coneTwistJointSetParamPtr)
  }

  /**
   * Gets a cone twist joint parameter.
   */
  @JvmStatic
  public final fun coneTwistJointGetParam(joint: RID, `param`: ConeTwistJointParam): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to param.value)
    TransferContext.callMethod(MethodBindings.coneTwistJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the type of the Joint3D.
   */
  @JvmStatic
  public final fun jointGetType(joint: RID): JointType {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointGetTypePtr)
    return JointType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the priority value of the Joint3D.
   *
   * **Note:** Only supported when using GodotPhysics3D. This method has no effect when using Jolt
   * Physics, as it does not support joint solver priority.
   */
  @JvmStatic
  public final fun jointSetSolverPriority(joint: RID, priority: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to priority.toLong())
    TransferContext.callMethod(MethodBindings.jointSetSolverPriorityPtr)
  }

  /**
   * Gets the priority value of the Joint3D.
   *
   * **Note:** Only supported when using GodotPhysics3D. This method always returns `1` when using
   * Jolt Physics, as it does not support joint solver priority.
   */
  @JvmStatic
  public final fun jointGetSolverPriority(joint: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointGetSolverPriorityPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets whether the bodies attached to the [Joint3D] will collide with each other.
   */
  @JvmStatic
  public final fun jointDisableCollisionsBetweenBodies(joint: RID, disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, BOOL to disable)
    TransferContext.callMethod(MethodBindings.jointDisableCollisionsBetweenBodiesPtr)
  }

  /**
   * Returns whether the bodies attached to the [Joint3D] will collide with each other.
   */
  @JvmStatic
  public final fun jointIsDisabledCollisionsBetweenBodies(joint: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint)
    TransferContext.callMethod(MethodBindings.jointIsDisabledCollisionsBetweenBodiesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Make the joint a generic six degrees of freedom (6DOF) joint. Use [generic6dofJointSetFlag] and
   * [generic6dofJointSetParam] to set the joint's flags and parameters respectively.
   */
  @JvmStatic
  public final fun jointMakeGeneric6dof(
    joint: RID,
    bodyA: RID,
    localRefA: Transform3D,
    bodyB: RID,
    localRefB: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, _RID to bodyA, TRANSFORM3D to localRefA, _RID to bodyB, TRANSFORM3D to localRefB)
    TransferContext.callMethod(MethodBindings.jointMakeGeneric6dofPtr)
  }

  /**
   * Sets the value of a given generic 6DOF joint parameter.
   */
  @JvmStatic
  public final fun generic6dofJointSetParam(
    joint: RID,
    axis: Vector3.Axis,
    `param`: G6DOFJointAxisParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to axis.value, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.generic6dofJointSetParamPtr)
  }

  /**
   * Returns the value of a generic 6DOF joint parameter.
   */
  @JvmStatic
  public final fun generic6dofJointGetParam(
    joint: RID,
    axis: Vector3.Axis,
    `param`: G6DOFJointAxisParam,
  ): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to axis.value, LONG to param.value)
    TransferContext.callMethod(MethodBindings.generic6dofJointGetParamPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the value of a given generic 6DOF joint flag.
   */
  @JvmStatic
  public final fun generic6dofJointSetFlag(
    joint: RID,
    axis: Vector3.Axis,
    flag: G6DOFJointAxisFlag,
    enable: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to axis.value, LONG to flag.value, BOOL to enable)
    TransferContext.callMethod(MethodBindings.generic6dofJointSetFlagPtr)
  }

  /**
   * Returns the value of a generic 6DOF joint flag.
   */
  @JvmStatic
  public final fun generic6dofJointGetFlag(
    joint: RID,
    axis: Vector3.Axis,
    flag: G6DOFJointAxisFlag,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to joint, LONG to axis.value, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.generic6dofJointGetFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Destroys any of the objects created by PhysicsServer3D. If the [RID] passed is not one of the
   * objects that can be created by PhysicsServer3D, an error will be sent to the console.
   */
  @JvmStatic
  public final fun freeRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.freeRidPtr)
  }

  /**
   * Activates or deactivates the 3D physics engine.
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

  public enum class JointType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The [Joint3D] is a [PinJoint3D].
     */
    PIN(0),
    /**
     * The [Joint3D] is a [HingeJoint3D].
     */
    HINGE(1),
    /**
     * The [Joint3D] is a [SliderJoint3D].
     */
    SLIDER(2),
    /**
     * The [Joint3D] is a [ConeTwistJoint3D].
     */
    CONE_TWIST(3),
    /**
     * The [Joint3D] is a [Generic6DOFJoint3D].
     */
    JOINT_TYPE_6DOF(4),
    /**
     * Represents the size of the [JointType] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): JointType = entries.single { it.`value` == `value` }
    }
  }

  public enum class PinJointParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The strength with which the pinned objects try to stay in positional relation to each other.
     * The higher, the stronger.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    BIAS(0),
    /**
     * The strength with which the pinned objects try to stay in velocity relation to each other.
     * The higher, the stronger.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    DAMPING(1),
    /**
     * If above 0, this value is the maximum value for an impulse that this Joint3D puts on its
     * ends.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    IMPULSE_CLAMP(2),
    ;

    public companion object {
      public fun from(`value`: Long): PinJointParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class HingeJointParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The speed with which the two bodies get pulled together when they move in different
     * directions.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    BIAS(0),
    /**
     * The maximum rotation across the Hinge.
     */
    LIMIT_UPPER(1),
    /**
     * The minimum rotation across the Hinge.
     */
    LIMIT_LOWER(2),
    /**
     * The speed with which the rotation across the axis perpendicular to the hinge gets corrected.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LIMIT_BIAS(3),
    /**
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LIMIT_SOFTNESS(4),
    /**
     * The lower this value, the more the rotation gets slowed down.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LIMIT_RELAXATION(5),
    /**
     * Target speed for the motor.
     */
    MOTOR_TARGET_VELOCITY(6),
    /**
     * Maximum acceleration for the motor.
     */
    MOTOR_MAX_IMPULSE(7),
    ;

    public companion object {
      public fun from(`value`: Long): HingeJointParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class HingeJointFlag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If `true`, the Hinge has a maximum and a minimum rotation.
     */
    USE_LIMIT(0),
    /**
     * If `true`, a motor turns the Hinge.
     */
    ENABLE_MOTOR(1),
    ;

    public companion object {
      public fun from(`value`: Long): HingeJointFlag = entries.single { it.`value` == `value` }
    }
  }

  public enum class SliderJointParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The maximum difference between the pivot points on their X axis before damping happens.
     */
    LINEAR_LIMIT_UPPER(0),
    /**
     * The minimum difference between the pivot points on their X axis before damping happens.
     */
    LINEAR_LIMIT_LOWER(1),
    /**
     * A factor applied to the movement across the slider axis once the limits get surpassed. The
     * lower, the slower the movement.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_LIMIT_SOFTNESS(2),
    /**
     * The amount of restitution once the limits are surpassed. The lower, the more velocity-energy
     * gets lost.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_LIMIT_RESTITUTION(3),
    /**
     * The amount of damping once the slider limits are surpassed.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_LIMIT_DAMPING(4),
    /**
     * A factor applied to the movement across the slider axis as long as the slider is in the
     * limits. The lower, the slower the movement.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_MOTION_SOFTNESS(5),
    /**
     * The amount of restitution inside the slider limits.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_MOTION_RESTITUTION(6),
    /**
     * The amount of damping inside the slider limits.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_MOTION_DAMPING(7),
    /**
     * A factor applied to the movement across axes orthogonal to the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_ORTHOGONAL_SOFTNESS(8),
    /**
     * The amount of restitution when movement is across axes orthogonal to the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_ORTHOGONAL_RESTITUTION(9),
    /**
     * The amount of damping when movement is across axes orthogonal to the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_ORTHOGONAL_DAMPING(10),
    /**
     * The upper limit of rotation in the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_LIMIT_UPPER(11),
    /**
     * The lower limit of rotation in the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_LIMIT_LOWER(12),
    /**
     * A factor applied to the all rotation once the limit is surpassed.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_LIMIT_SOFTNESS(13),
    /**
     * The amount of restitution of the rotation when the limit is surpassed.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_LIMIT_RESTITUTION(14),
    /**
     * The amount of damping of the rotation when the limit is surpassed.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_LIMIT_DAMPING(15),
    /**
     * A factor that gets applied to the all rotation in the limits.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_MOTION_SOFTNESS(16),
    /**
     * The amount of restitution of the rotation in the limits.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_MOTION_RESTITUTION(17),
    /**
     * The amount of damping of the rotation in the limits.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_MOTION_DAMPING(18),
    /**
     * A factor that gets applied to the all rotation across axes orthogonal to the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_ORTHOGONAL_SOFTNESS(19),
    /**
     * The amount of restitution of the rotation across axes orthogonal to the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_ORTHOGONAL_RESTITUTION(20),
    /**
     * The amount of damping of the rotation across axes orthogonal to the slider.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_ORTHOGONAL_DAMPING(21),
    /**
     * Represents the size of the [SliderJointParam] enum.
     */
    MAX(22),
    ;

    public companion object {
      public fun from(`value`: Long): SliderJointParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class ConeTwistJointParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Swing is rotation from side to side, around the axis perpendicular to the twist axis.
     *
     * The swing span defines, how much rotation will not get corrected along the swing axis.
     *
     * Could be defined as looseness in the [ConeTwistJoint3D]. If below 0.05, this behavior is
     * locked.
     */
    SWING_SPAN(0),
    /**
     * Twist is the rotation around the twist axis, this value defined how far the joint can twist.
     * Twist is locked if below 0.05.
     */
    TWIST_SPAN(1),
    /**
     * The speed with which the swing or twist will take place. The higher, the faster.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    BIAS(2),
    /**
     * The ease with which the Joint3D twists, if it's too low, it takes more force to twist the
     * joint.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    SOFTNESS(3),
    /**
     * Defines, how fast the swing- and twist-speed-difference on both sides gets synced.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    RELAXATION(4),
    ;

    public companion object {
      public fun from(`value`: Long): ConeTwistJointParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class G6DOFJointAxisParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The minimum difference between the pivot points' axes.
     */
    LINEAR_LOWER_LIMIT(0),
    /**
     * The maximum difference between the pivot points' axes.
     */
    LINEAR_UPPER_LIMIT(1),
    /**
     * A factor that gets applied to the movement across the axes. The lower, the slower the
     * movement.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_LIMIT_SOFTNESS(2),
    /**
     * The amount of restitution on the axes movement. The lower, the more velocity-energy gets
     * lost.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_RESTITUTION(3),
    /**
     * The amount of damping that happens at the linear motion across the axes.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    LINEAR_DAMPING(4),
    /**
     * The velocity that the joint's linear motor will attempt to reach.
     */
    LINEAR_MOTOR_TARGET_VELOCITY(5),
    /**
     * The maximum force that the linear motor can apply while trying to reach the target velocity.
     */
    LINEAR_MOTOR_FORCE_LIMIT(6),
    LINEAR_SPRING_STIFFNESS(7),
    LINEAR_SPRING_DAMPING(8),
    LINEAR_SPRING_EQUILIBRIUM_POINT(9),
    /**
     * The minimum rotation in negative direction to break loose and rotate around the axes.
     */
    ANGULAR_LOWER_LIMIT(10),
    /**
     * The minimum rotation in positive direction to break loose and rotate around the axes.
     */
    ANGULAR_UPPER_LIMIT(11),
    /**
     * A factor that gets multiplied onto all rotations across the axes.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_LIMIT_SOFTNESS(12),
    /**
     * The amount of rotational damping across the axes. The lower, the more damping occurs.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_DAMPING(13),
    /**
     * The amount of rotational restitution across the axes. The lower, the more restitution occurs.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_RESTITUTION(14),
    /**
     * The maximum amount of force that can occur, when rotating around the axes.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_FORCE_LIMIT(15),
    /**
     * When correcting the crossing of limits in rotation across the axes, this error tolerance
     * factor defines how much the correction gets slowed down. The lower, the slower.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    ANGULAR_ERP(16),
    /**
     * Target speed for the motor at the axes.
     */
    ANGULAR_MOTOR_TARGET_VELOCITY(17),
    /**
     * Maximum acceleration for the motor at the axes.
     */
    ANGULAR_MOTOR_FORCE_LIMIT(18),
    ANGULAR_SPRING_STIFFNESS(19),
    ANGULAR_SPRING_DAMPING(20),
    ANGULAR_SPRING_EQUILIBRIUM_POINT(21),
    /**
     * Represents the size of the [G6DOFJointAxisParam] enum.
     */
    MAX(22),
    ;

    public companion object {
      public fun from(`value`: Long): G6DOFJointAxisParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class G6DOFJointAxisFlag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If set, linear motion is possible within the given limits.
     */
    FLAG_ENABLE_LINEAR_LIMIT(0),
    /**
     * If set, rotational motion is possible.
     */
    FLAG_ENABLE_ANGULAR_LIMIT(1),
    FLAG_ENABLE_ANGULAR_SPRING(2),
    FLAG_ENABLE_LINEAR_SPRING(3),
    /**
     * If set, there is a rotational motor across these axes.
     */
    FLAG_ENABLE_MOTOR(4),
    /**
     * If set, there is a linear motor on this axis that targets a specific velocity.
     */
    FLAG_ENABLE_LINEAR_MOTOR(5),
    /**
     * Represents the size of the [G6DOFJointAxisFlag] enum.
     */
    FLAG_MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): G6DOFJointAxisFlag = entries.single { it.`value` == `value` }
    }
  }

  public enum class ShapeType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant for creating a world boundary shape (used by the [WorldBoundaryShape3D] resource).
     */
    WORLD_BOUNDARY(0),
    /**
     * Constant for creating a separation ray shape (used by the [SeparationRayShape3D] resource).
     */
    SEPARATION_RAY(1),
    /**
     * Constant for creating a sphere shape (used by the [SphereShape3D] resource).
     */
    SPHERE(2),
    /**
     * Constant for creating a box shape (used by the [BoxShape3D] resource).
     */
    BOX(3),
    /**
     * Constant for creating a capsule shape (used by the [CapsuleShape3D] resource).
     */
    CAPSULE(4),
    /**
     * Constant for creating a cylinder shape (used by the [CylinderShape3D] resource).
     */
    CYLINDER(5),
    /**
     * Constant for creating a convex polygon shape (used by the [ConvexPolygonShape3D] resource).
     */
    CONVEX_POLYGON(6),
    /**
     * Constant for creating a concave polygon (trimesh) shape (used by the [ConcavePolygonShape3D]
     * resource).
     */
    CONCAVE_POLYGON(7),
    /**
     * Constant for creating a heightmap shape (used by the [HeightMapShape3D] resource).
     */
    HEIGHTMAP(8),
    /**
     * Constant used internally for a soft body shape. Any attempt to create this kind of shape
     * results in an error.
     */
    SOFT_BODY(9),
    /**
     * Constant used internally for a custom shape. Any attempt to create this kind of shape results
     * in an error when using Godot Physics or Jolt Physics.
     */
    CUSTOM(10),
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
     * possible values.
     */
    GRAVITY_OVERRIDE_MODE(0),
    /**
     * Constant to set/get gravity strength in an area.
     */
    GRAVITY(1),
    /**
     * Constant to set/get gravity vector/center in an area.
     */
    GRAVITY_VECTOR(2),
    /**
     * Constant to set/get whether the gravity vector of an area is a direction, or a center point.
     */
    GRAVITY_IS_POINT(3),
    /**
     * Constant to set/get the distance at which the gravity strength is equal to the gravity
     * controlled by [AREA_PARAM_GRAVITY]. For example, on a planet 100 meters in radius with a surface
     * gravity of 4.0 m/s², set the gravity to 4.0 and the unit distance to 100.0. The gravity will
     * have falloff according to the inverse square law, so in the example, at 200 meters from the
     * center the gravity will be 1.0 m/s² (twice the distance, 1/4th the gravity), at 50 meters it
     * will be 16.0 m/s² (half the distance, 4x the gravity), and so on.
     *
     * The above is true only when the unit distance is a positive number. When this is set to 0.0,
     * the gravity will be constant regardless of distance.
     */
    GRAVITY_POINT_UNIT_DISTANCE(4),
    /**
     * Constant to set/get linear damping override mode in an area. See [AreaSpaceOverrideMode] for
     * possible values.
     */
    LINEAR_DAMP_OVERRIDE_MODE(5),
    /**
     * Constant to set/get the linear damping factor of an area.
     */
    LINEAR_DAMP(6),
    /**
     * Constant to set/get angular damping override mode in an area. See [AreaSpaceOverrideMode] for
     * possible values.
     */
    ANGULAR_DAMP_OVERRIDE_MODE(7),
    /**
     * Constant to set/get the angular damping factor of an area.
     */
    ANGULAR_DAMP(8),
    /**
     * Constant to set/get the priority (order of processing) of an area.
     */
    PRIORITY(9),
    /**
     * Constant to set/get the magnitude of area-specific wind force. This wind force only applies
     * to [SoftBody3D] nodes. Other physics bodies are currently not affected by wind.
     */
    WIND_FORCE_MAGNITUDE(10),
    /**
     * Constant to set/get the 3D vector that specifies the origin from which an area-specific wind
     * blows.
     */
    WIND_SOURCE(11),
    /**
     * Constant to set/get the 3D vector that specifies the direction in which an area-specific wind
     * blows.
     */
    WIND_DIRECTION(12),
    /**
     * Constant to set/get the exponential rate at which wind force decreases with distance from its
     * origin.
     */
    WIND_ATTENUATION_FACTOR(13),
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
     * Constant to set/get a body's bounce factor.
     */
    BOUNCE(0),
    /**
     * Constant to set/get a body's friction.
     */
    FRICTION(1),
    /**
     * Constant to set/get a body's mass.
     */
    MASS(2),
    /**
     * Constant to set/get a body's inertia.
     */
    INERTIA(3),
    /**
     * Constant to set/get a body's center of mass position in the body's local coordinate system.
     */
    CENTER_OF_MASS(4),
    /**
     * Constant to set/get a body's gravity multiplier.
     */
    GRAVITY_SCALE(5),
    /**
     * Constant to set/get a body's linear damping mode. See [BodyDampMode] for possible values.
     */
    LINEAR_DAMP_MODE(6),
    /**
     * Constant to set/get a body's angular damping mode. See [BodyDampMode] for possible values.
     */
    ANGULAR_DAMP_MODE(7),
    /**
     * Constant to set/get a body's linear damping factor.
     */
    LINEAR_DAMP(8),
    /**
     * Constant to set/get a body's angular damping factor.
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

  public enum class SpaceParameter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant to set/get the maximum distance a pair of bodies has to move before their collision
     * status has to be recalculated.
     */
    CONTACT_RECYCLE_RADIUS(0),
    /**
     * Constant to set/get the maximum distance a shape can be from another before they are
     * considered separated and the contact is discarded.
     */
    CONTACT_MAX_SEPARATION(1),
    /**
     * Constant to set/get the maximum distance a shape can penetrate another shape before it is
     * considered a collision.
     */
    CONTACT_MAX_ALLOWED_PENETRATION(2),
    /**
     * Constant to set/get the default solver bias for all physics contacts. A solver bias is a
     * factor controlling how much two objects "rebound", after overlapping, to avoid leaving them in
     * that state because of numerical imprecision.
     */
    CONTACT_DEFAULT_BIAS(3),
    /**
     * Constant to set/get the threshold linear velocity of activity. A body marked as potentially
     * inactive for both linear and angular velocity will be put to sleep after the time given.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    BODY_LINEAR_VELOCITY_SLEEP_THRESHOLD(4),
    /**
     * Constant to set/get the threshold angular velocity of activity. A body marked as potentially
     * inactive for both linear and angular velocity will be put to sleep after the time given.
     *
     * **Note:** Only supported when using GodotPhysics3D. This parameter is ignored when using Jolt
     * Physics.
     */
    BODY_ANGULAR_VELOCITY_SLEEP_THRESHOLD(5),
    /**
     * Constant to set/get the maximum time of activity. A body marked as potentially inactive for
     * both linear and angular velocity will be put to sleep after this time.
     */
    BODY_TIME_TO_SLEEP(6),
    /**
     * Constant to set/get the number of solver iterations for contacts and constraints. The greater
     * the number of iterations, the more accurate the collisions and constraints will be. However, a
     * greater number of iterations requires more CPU power, which can decrease performance.
     */
    SOLVER_ITERATIONS(7),
    ;

    public companion object {
      public fun from(`value`: Long): SpaceParameter = entries.single { it.`value` == `value` }
    }
  }

  public enum class BodyAxis(
    public override val `value`: Long,
  ) : GodotEnum {
    LINEAR_X(1),
    LINEAR_Y(2),
    LINEAR_Z(4),
    ANGULAR_X(8),
    ANGULAR_Y(16),
    ANGULAR_Z(32),
    ;

    public companion object {
      public fun from(`value`: Long): BodyAxis = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val worldBoundaryShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "world_boundary_shape_create", 529393457)

    internal val separationRayShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "separation_ray_shape_create", 529393457)

    internal val sphereShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "sphere_shape_create", 529393457)

    internal val boxShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "box_shape_create", 529393457)

    internal val capsuleShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "capsule_shape_create", 529393457)

    internal val cylinderShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "cylinder_shape_create", 529393457)

    internal val convexPolygonShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "convex_polygon_shape_create", 529393457)

    internal val concavePolygonShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "concave_polygon_shape_create", 529393457)

    internal val heightmapShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "heightmap_shape_create", 529393457)

    internal val customShapeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "custom_shape_create", 529393457)

    internal val shapeSetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "shape_set_data", 3175752987)

    internal val shapeSetMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "shape_set_margin", 1794382983)

    internal val shapeGetTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "shape_get_type", 3418923367)

    internal val shapeGetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "shape_get_data", 4171304767)

    internal val shapeGetMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "shape_get_margin", 866169185)

    internal val spaceCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "space_create", 529393457)

    internal val spaceSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "space_set_active", 1265174801)

    internal val spaceIsActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "space_is_active", 4155700596)

    internal val spaceSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "space_set_param", 2406017470)

    internal val spaceGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "space_get_param", 1523206731)

    internal val spaceGetDirectStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "space_get_direct_state", 2048616813)

    internal val areaCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_create", 529393457)

    internal val areaSetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_space", 395945892)

    internal val areaGetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_space", 3814569979)

    internal val areaAddShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_add_shape", 3711419014)

    internal val areaSetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_shape", 2310537182)

    internal val areaSetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_shape_transform", 675327471)

    internal val areaSetShapeDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_shape_disabled", 2658558584)

    internal val areaGetShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_shape_count", 2198884583)

    internal val areaGetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_shape", 1066463050)

    internal val areaGetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_shape_transform", 1050775521)

    internal val areaRemoveShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_remove_shape", 3411492887)

    internal val areaClearShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_clear_shapes", 2722037293)

    internal val areaSetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_collision_layer", 3411492887)

    internal val areaGetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_collision_layer", 2198884583)

    internal val areaSetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_collision_mask", 3411492887)

    internal val areaGetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_collision_mask", 2198884583)

    internal val areaSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_param", 2980114638)

    internal val areaSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_transform", 3935195649)

    internal val areaGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_param", 890056067)

    internal val areaGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_transform", 1128465797)

    internal val areaAttachObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_attach_object_instance_id", 3411492887)

    internal val areaGetObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_get_object_instance_id", 2198884583)

    internal val areaSetMonitorCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_monitor_callback", 3379118538)

    internal val areaSetAreaMonitorCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_area_monitor_callback", 3379118538)

    internal val areaSetMonitorablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_monitorable", 1265174801)

    internal val areaSetRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "area_set_ray_pickable", 1265174801)

    internal val bodyCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_create", 529393457)

    internal val bodySetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_space", 395945892)

    internal val bodyGetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_space", 3814569979)

    internal val bodySetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_mode", 606803466)

    internal val bodyGetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_mode", 2488819728)

    internal val bodySetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_collision_layer", 3411492887)

    internal val bodyGetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_collision_layer", 2198884583)

    internal val bodySetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_collision_mask", 3411492887)

    internal val bodyGetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_collision_mask", 2198884583)

    internal val bodySetCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_collision_priority", 1794382983)

    internal val bodyGetCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_collision_priority", 866169185)

    internal val bodyAddShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_add_shape", 3711419014)

    internal val bodySetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_shape", 2310537182)

    internal val bodySetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_shape_transform", 675327471)

    internal val bodySetShapeDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_shape_disabled", 2658558584)

    internal val bodyGetShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_shape_count", 2198884583)

    internal val bodyGetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_shape", 1066463050)

    internal val bodyGetShapeTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_shape_transform", 1050775521)

    internal val bodyRemoveShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_remove_shape", 3411492887)

    internal val bodyClearShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_clear_shapes", 2722037293)

    internal val bodyAttachObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_attach_object_instance_id", 3411492887)

    internal val bodyGetObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_object_instance_id", 2198884583)

    internal val bodySetEnableContinuousCollisionDetectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_enable_continuous_collision_detection", 1265174801)

    internal val bodyIsContinuousCollisionDetectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_is_continuous_collision_detection_enabled", 4155700596)

    internal val bodySetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_param", 910941953)

    internal val bodyGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_param", 3385027841)

    internal val bodyResetMassPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_reset_mass_properties", 2722037293)

    internal val bodySetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_state", 599977762)

    internal val bodyGetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_state", 1850449534)

    internal val bodyApplyCentralImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_apply_central_impulse", 3227306858)

    internal val bodyApplyImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_apply_impulse", 390416203)

    internal val bodyApplyTorqueImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_apply_torque_impulse", 3227306858)

    internal val bodyApplyCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_apply_central_force", 3227306858)

    internal val bodyApplyForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_apply_force", 390416203)

    internal val bodyApplyTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_apply_torque", 3227306858)

    internal val bodyAddConstantCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_add_constant_central_force", 3227306858)

    internal val bodyAddConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_add_constant_force", 390416203)

    internal val bodyAddConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_add_constant_torque", 3227306858)

    internal val bodySetConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_constant_force", 3227306858)

    internal val bodyGetConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_constant_force", 531438156)

    internal val bodySetConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_constant_torque", 3227306858)

    internal val bodyGetConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_constant_torque", 531438156)

    internal val bodySetAxisVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_axis_velocity", 3227306858)

    internal val bodySetAxisLockPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_axis_lock", 2020836892)

    internal val bodyIsAxisLockedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_is_axis_locked", 587853580)

    internal val bodyAddCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_add_collision_exception", 395945892)

    internal val bodyRemoveCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_remove_collision_exception", 395945892)

    internal val bodySetMaxContactsReportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_max_contacts_reported", 3411492887)

    internal val bodyGetMaxContactsReportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_max_contacts_reported", 2198884583)

    internal val bodySetOmitForceIntegrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_omit_force_integration", 1265174801)

    internal val bodyIsOmittingForceIntegrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_is_omitting_force_integration", 4155700596)

    internal val bodySetStateSyncCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_state_sync_callback", 3379118538)

    internal val bodySetForceIntegrationCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_force_integration_callback", 3059434249)

    internal val bodySetRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_set_ray_pickable", 1265174801)

    internal val bodyTestMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_test_motion", 1944921792)

    internal val bodyGetDirectStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "body_get_direct_state", 3029727957)

    internal val softBodyCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_create", 529393457)

    internal val softBodyUpdateRenderingServerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_update_rendering_server", 2218179753)

    internal val softBodySetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_space", 395945892)

    internal val softBodyGetSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_space", 3814569979)

    internal val softBodySetMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_mesh", 395945892)

    internal val softBodyGetBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_bounds", 974181306)

    internal val softBodySetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_collision_layer", 3411492887)

    internal val softBodyGetCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_collision_layer", 2198884583)

    internal val softBodySetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_collision_mask", 3411492887)

    internal val softBodyGetCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_collision_mask", 2198884583)

    internal val softBodyAddCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_add_collision_exception", 395945892)

    internal val softBodyRemoveCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_remove_collision_exception", 395945892)

    internal val softBodySetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_state", 599977762)

    internal val softBodyGetStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_state", 1850449534)

    internal val softBodySetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_transform", 3935195649)

    internal val softBodySetRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_ray_pickable", 1265174801)

    internal val softBodySetSimulationPrecisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_simulation_precision", 3411492887)

    internal val softBodyGetSimulationPrecisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_simulation_precision", 2198884583)

    internal val softBodySetTotalMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_total_mass", 1794382983)

    internal val softBodyGetTotalMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_total_mass", 866169185)

    internal val softBodySetLinearStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_linear_stiffness", 1794382983)

    internal val softBodyGetLinearStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_linear_stiffness", 866169185)

    internal val softBodySetShrinkingFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_shrinking_factor", 1794382983)

    internal val softBodyGetShrinkingFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_shrinking_factor", 866169185)

    internal val softBodySetPressureCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_pressure_coefficient", 1794382983)

    internal val softBodyGetPressureCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_pressure_coefficient", 866169185)

    internal val softBodySetDampingCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_damping_coefficient", 1794382983)

    internal val softBodyGetDampingCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_damping_coefficient", 866169185)

    internal val softBodySetDragCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_set_drag_coefficient", 1794382983)

    internal val softBodyGetDragCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_drag_coefficient", 866169185)

    internal val softBodyMovePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_move_point", 831953689)

    internal val softBodyGetPointGlobalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_get_point_global_position", 3440143363)

    internal val softBodyRemoveAllPinnedPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_remove_all_pinned_points", 2722037293)

    internal val softBodyPinPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_pin_point", 2658558584)

    internal val softBodyIsPointPinnedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_is_point_pinned", 3120086654)

    internal val softBodyApplyPointImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_apply_point_impulse", 831953689)

    internal val softBodyApplyPointForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_apply_point_force", 831953689)

    internal val softBodyApplyCentralImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_apply_central_impulse", 3227306858)

    internal val softBodyApplyCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "soft_body_apply_central_force", 3227306858)

    internal val jointCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_create", 529393457)

    internal val jointClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_clear", 2722037293)

    internal val jointMakePinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_make_pin", 4280171926)

    internal val pinJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "pin_joint_set_param", 810685294)

    internal val pinJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "pin_joint_get_param", 2817972347)

    internal val pinJointSetLocalAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "pin_joint_set_local_a", 3227306858)

    internal val pinJointGetLocalAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "pin_joint_get_local_a", 531438156)

    internal val pinJointSetLocalBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "pin_joint_set_local_b", 3227306858)

    internal val pinJointGetLocalBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "pin_joint_get_local_b", 531438156)

    internal val jointMakeHingePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_make_hinge", 1684107643)

    internal val hingeJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "hinge_joint_set_param", 3165502333)

    internal val hingeJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "hinge_joint_get_param", 2129207581)

    internal val hingeJointSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "hinge_joint_set_flag", 1601626188)

    internal val hingeJointGetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "hinge_joint_get_flag", 4165147865)

    internal val jointMakeSliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_make_slider", 1684107643)

    internal val sliderJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "slider_joint_set_param", 2264833593)

    internal val sliderJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "slider_joint_get_param", 3498644957)

    internal val jointMakeConeTwistPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_make_cone_twist", 1684107643)

    internal val coneTwistJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "cone_twist_joint_set_param", 808587618)

    internal val coneTwistJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "cone_twist_joint_get_param", 1134789658)

    internal val jointGetTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_get_type", 4290791900)

    internal val jointSetSolverPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_set_solver_priority", 3411492887)

    internal val jointGetSolverPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_get_solver_priority", 2198884583)

    internal val jointDisableCollisionsBetweenBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_disable_collisions_between_bodies", 1265174801)

    internal val jointIsDisabledCollisionsBetweenBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_is_disabled_collisions_between_bodies", 4155700596)

    internal val jointMakeGeneric6dofPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "joint_make_generic_6dof", 1684107643)

    internal val generic6dofJointSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "generic_6dof_joint_set_param", 2600081391)

    internal val generic6dofJointGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "generic_6dof_joint_get_param", 467122058)

    internal val generic6dofJointSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "generic_6dof_joint_set_flag", 3570926903)

    internal val generic6dofJointGetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "generic_6dof_joint_get_flag", 4158090196)

    internal val freeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "free_rid", 2722037293)

    internal val setActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "set_active", 2586408642)

    internal val getProcessInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3D", "get_process_info", 1332958745)
  }
}
