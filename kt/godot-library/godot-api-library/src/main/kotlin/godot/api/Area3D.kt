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
import godot.core.NodePath
import godot.core.RID
import godot.core.Signal1
import godot.core.Signal4
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import godot.core.asCachedNodePath
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
 * [Area3D] is a region of 3D space defined by one or multiple [CollisionShape3D] or
 * [CollisionPolygon3D] child nodes. It detects when other [CollisionObject3D]s enter or exit it, and
 * it also keeps track of which collision objects haven't exited it yet (i.e. which one are overlapping
 * it).
 *
 * This node can also locally alter or override physics parameters (gravity, damping) and route
 * audio to custom audio buses.
 *
 * **Note:** Areas and bodies created with [PhysicsServer3D] might not interact as expected with
 * [Area3D]s, and might not emit signals or track objects correctly.
 *
 * **Warning:** Using a [ConcavePolygonShape3D] inside a [CollisionShape3D] child of this node
 * (created e.g. by using the **Create Trimesh Collision Sibling** option in the **Mesh** menu that
 * appears when selecting a [MeshInstance3D] node) may give unexpected results, since this collision
 * shape is hollow. If this is not desired, it has to be split into multiple [ConvexPolygonShape3D]s or
 * primitive shapes like [BoxShape3D], or in some cases it may be replaceable by a
 * [CollisionPolygon3D].
 */
@GodotBaseType
public open class Area3D : CollisionObject3D() {
  /**
   * Emitted when a [Shape3D] of the received [body] enters a shape of this area. [body] can be a
   * [PhysicsBody3D], [SoftBody3D] or [GridMap]. [GridMap]s are detected if their [MeshLibrary] has
   * collision shapes configured. Requires [monitoring] to be set to `true`.
   *
   * [localShapeIndex] and [bodyShapeIndex] contain indices of the interacting shapes from this area
   * and the interacting body, respectively. [bodyRid] contains the [RID] of the body. These values can
   * be used with the [PhysicsServer3D].
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will not emit
   * this signal in such cases.
   *
   * **Example:** Get the [CollisionShape3D] node from the shape index:
   *
   * ```gdscript
   * //gdscript
   * var body_shape_owner = body.shape_find_owner(body_shape_index)
   * var body_shape_node = body.shape_owner_get_owner(body_shape_owner)
   *
   * var local_shape_owner = shape_find_owner(local_shape_index)
   * var local_shape_node = shape_owner_get_owner(local_shape_owner)
   * ```
   */
  public val bodyShapeEntered: Signal4<RID, Node3D, Long, Long> by Signal4

  /**
   * Emitted when a [Shape3D] of the received [body] exits a shape of this area. [body] can be a
   * [PhysicsBody3D], [SoftBody3D] or [GridMap]. [GridMap]s are detected if their [MeshLibrary] has
   * collision shapes configured. Requires [monitoring] to be set to `true`.
   *
   * See also [signal body_shape_entered].
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will not emit
   * this signal in such cases.
   */
  public val bodyShapeExited: Signal4<RID, Node3D, Long, Long> by Signal4

  /**
   * Emitted when the received [body] enters this area. [body] can be a [PhysicsBody3D],
   * [SoftBody3D] or [GridMap]. [GridMap]s are detected if their [MeshLibrary] has collision shapes
   * configured. Requires [monitoring] to be set to `true`.
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will not emit
   * this signal in such cases.
   */
  public val bodyEntered: Signal1<Node3D> by Signal1

  /**
   * Emitted when the received [body] exits this area. [body] can be a [PhysicsBody3D], [SoftBody3D]
   * or [GridMap]. [GridMap]s are detected if their [MeshLibrary] has collision shapes configured.
   * Requires [monitoring] to be set to `true`.
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will not emit
   * this signal in such cases.
   */
  public val bodyExited: Signal1<Node3D> by Signal1

  /**
   * Emitted when a [Shape3D] of the received [area] enters a shape of this area. Requires
   * [monitoring] to be set to `true`.
   *
   * [localShapeIndex] and [areaShapeIndex] contain indices of the interacting shapes from this area
   * and the other area, respectively. [areaRid] contains the [RID] of the other area. These values can
   * be used with the [PhysicsServer3D].
   *
   * **Example:** Get the [CollisionShape3D] node from the shape index:
   *
   * ```gdscript
   * //gdscript
   * var other_shape_owner = area.shape_find_owner(area_shape_index)
   * var other_shape_node = area.shape_owner_get_owner(other_shape_owner)
   *
   * var local_shape_owner = shape_find_owner(local_shape_index)
   * var local_shape_node = shape_owner_get_owner(local_shape_owner)
   * ```
   */
  public val areaShapeEntered: Signal4<RID, Area3D, Long, Long> by Signal4

  /**
   * Emitted when a [Shape3D] of the received [area] exits a shape of this area. Requires
   * [monitoring] to be set to `true`.
   *
   * See also [signal area_shape_entered].
   */
  public val areaShapeExited: Signal4<RID, Area3D, Long, Long> by Signal4

  /**
   * Emitted when the received [area] enters this area. Requires [monitoring] to be set to `true`.
   */
  public val areaEntered: Signal1<Area3D> by Signal1

  /**
   * Emitted when the received [area] exits this area. Requires [monitoring] to be set to `true`.
   */
  public val areaExited: Signal1<Area3D> by Signal1

  /**
   * If `true`, the area detects bodies or areas entering and exiting it.
   */
  public final inline var monitoring: Boolean
    @JvmName("monitoringProperty")
    get() = isMonitoring()
    @JvmName("monitoringProperty")
    set(`value`) {
      setMonitoring(value)
    }

  /**
   * If `true`, other monitoring areas can detect this area.
   */
  public final inline var monitorable: Boolean
    @JvmName("monitorableProperty")
    get() = isMonitorable()
    @JvmName("monitorableProperty")
    set(`value`) {
      setMonitorable(value)
    }

  /**
   * The area's priority. Higher priority areas are processed first. The [World3D]'s physics is
   * always processed last, after all areas.
   */
  public final inline var priority: Int
    @JvmName("priorityProperty")
    get() = getPriority()
    @JvmName("priorityProperty")
    set(`value`) {
      setPriority(value)
    }

  /**
   * Override mode for gravity calculations within this area.
   */
  public final inline var gravitySpaceOverride: SpaceOverride
    @JvmName("gravitySpaceOverrideProperty")
    get() = getGravitySpaceOverrideMode()
    @JvmName("gravitySpaceOverrideProperty")
    set(`value`) {
      setGravitySpaceOverrideMode(value)
    }

  /**
   * If `true`, gravity is calculated from a point (set via [gravityPointCenter]). See also
   * [gravitySpaceOverride].
   */
  public final inline var gravityPoint: Boolean
    @JvmName("gravityPointProperty")
    get() = isGravityAPoint()
    @JvmName("gravityPointProperty")
    set(`value`) {
      setGravityIsPoint(value)
    }

  /**
   * The distance at which the gravity strength is equal to [gravity]. For example, on a planet 100
   * meters in radius with a surface gravity of 4.0 m/s², set the [gravity] to 4.0 and the unit
   * distance to 100.0. The gravity will have falloff according to the inverse square law, so in the
   * example, at 200 meters from the center the gravity will be 1.0 m/s² (twice the distance, 1/4th the
   * gravity), at 50 meters it will be 16.0 m/s² (half the distance, 4x the gravity), and so on.
   *
   * The above is true only when the unit distance is a positive number. When this is set to 0.0,
   * the gravity will be constant regardless of distance.
   */
  public final inline var gravityPointUnitDistance: Float
    @JvmName("gravityPointUnitDistanceProperty")
    get() = getGravityPointUnitDistance()
    @JvmName("gravityPointUnitDistanceProperty")
    set(`value`) {
      setGravityPointUnitDistance(value)
    }

  /**
   * If gravity is a point (see [gravityPoint]), this will be the point of attraction.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var gravityPointCenter: Vector3
    @JvmName("gravityPointCenterProperty")
    get() = getGravityPointCenter()
    @JvmName("gravityPointCenterProperty")
    set(`value`) {
      setGravityPointCenter(value)
    }

  /**
   * The area's gravity vector (not normalized).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var gravityDirection: Vector3
    @JvmName("gravityDirectionProperty")
    get() = getGravityDirection()
    @JvmName("gravityDirectionProperty")
    set(`value`) {
      setGravityDirection(value)
    }

  /**
   * The area's gravity intensity (in meters per second squared). This value multiplies the gravity
   * direction. This is useful to alter the force of gravity without altering its direction.
   */
  public final inline var gravity: Float
    @JvmName("gravityProperty")
    get() = getGravity()
    @JvmName("gravityProperty")
    set(`value`) {
      setGravity(value)
    }

  /**
   * Override mode for linear damping calculations within this area.
   */
  public final inline var linearDampSpaceOverride: SpaceOverride
    @JvmName("linearDampSpaceOverrideProperty")
    get() = getLinearDampSpaceOverrideMode()
    @JvmName("linearDampSpaceOverrideProperty")
    set(`value`) {
      setLinearDampSpaceOverrideMode(value)
    }

  /**
   * The rate at which objects stop moving in this area. Represents the linear velocity lost per
   * second.
   *
   * See [ProjectSettings.physics/3d/defaultLinearDamp] for more details about damping.
   */
  public final inline var linearDamp: Float
    @JvmName("linearDampProperty")
    get() = getLinearDamp()
    @JvmName("linearDampProperty")
    set(`value`) {
      setLinearDamp(value)
    }

  /**
   * Override mode for angular damping calculations within this area.
   */
  public final inline var angularDampSpaceOverride: SpaceOverride
    @JvmName("angularDampSpaceOverrideProperty")
    get() = getAngularDampSpaceOverrideMode()
    @JvmName("angularDampSpaceOverrideProperty")
    set(`value`) {
      setAngularDampSpaceOverrideMode(value)
    }

  /**
   * The rate at which objects stop spinning in this area. Represents the angular velocity lost per
   * second.
   *
   * See [ProjectSettings.physics/3d/defaultAngularDamp] for more details about damping.
   */
  public final inline var angularDamp: Float
    @JvmName("angularDampProperty")
    get() = getAngularDamp()
    @JvmName("angularDampProperty")
    set(`value`) {
      setAngularDamp(value)
    }

  /**
   * The magnitude of area-specific wind force.
   *
   * **Note:** This wind force only applies to [SoftBody3D] nodes. Other physics bodies are
   * currently not affected by wind.
   */
  public final inline var windForceMagnitude: Float
    @JvmName("windForceMagnitudeProperty")
    get() = getWindForceMagnitude()
    @JvmName("windForceMagnitudeProperty")
    set(`value`) {
      setWindForceMagnitude(value)
    }

  /**
   * The exponential rate at which wind force decreases with distance from its origin.
   *
   * **Note:** This wind force only applies to [SoftBody3D] nodes. Other physics bodies are
   * currently not affected by wind.
   */
  public final inline var windAttenuationFactor: Float
    @JvmName("windAttenuationFactorProperty")
    get() = getWindAttenuationFactor()
    @JvmName("windAttenuationFactorProperty")
    set(`value`) {
      setWindAttenuationFactor(value)
    }

  /**
   * The [Node3D] which is used to specify the direction and origin of an area-specific wind force.
   * The direction is opposite to the z-axis of the [Node3D]'s local transform, and its origin is the
   * origin of the [Node3D]'s local transform.
   *
   * **Note:** This wind force only applies to [SoftBody3D] nodes. Other physics bodies are
   * currently not affected by wind.
   */
  public final inline var windSourcePath: NodePath
    @JvmName("windSourcePathProperty")
    get() = getWindSourcePath()
    @JvmName("windSourcePathProperty")
    set(`value`) {
      setWindSourcePath(value)
    }

  /**
   * If `true`, the area's audio bus overrides the default audio bus.
   */
  public final inline var audioBusOverride: Boolean
    @JvmName("audioBusOverrideProperty")
    get() = isOverridingAudioBus()
    @JvmName("audioBusOverrideProperty")
    set(`value`) {
      setAudioBusOverride(value)
    }

  /**
   * The name of the area's audio bus.
   */
  public final inline var audioBusName: StringName
    @JvmName("audioBusNameProperty")
    get() = getAudioBusName()
    @JvmName("audioBusNameProperty")
    set(`value`) {
      setAudioBusName(value)
    }

  /**
   * If `true`, the area applies reverb to its associated audio.
   */
  public final inline var reverbBusEnabled: Boolean
    @JvmName("reverbBusEnabledProperty")
    get() = isUsingReverbBus()
    @JvmName("reverbBusEnabledProperty")
    set(`value`) {
      setUseReverbBus(value)
    }

  /**
   * The name of the reverb bus to use for this area's associated audio.
   */
  public final inline var reverbBusName: StringName
    @JvmName("reverbBusNameProperty")
    get() = getReverbBusName()
    @JvmName("reverbBusNameProperty")
    set(`value`) {
      setReverbBusName(value)
    }

  /**
   * The degree to which this area applies reverb to its associated audio. Ranges from `0` to `1`
   * with `0.1` precision.
   */
  public final inline var reverbBusAmount: Float
    @JvmName("reverbBusAmountProperty")
    get() = getReverbAmount()
    @JvmName("reverbBusAmountProperty")
    set(`value`) {
      setReverbAmount(value)
    }

  /**
   * The degree to which this area's reverb is a uniform effect. Ranges from `0` to `1` with `0.1`
   * precision.
   */
  public final inline var reverbBusUniformity: Float
    @JvmName("reverbBusUniformityProperty")
    get() = getReverbUniformity()
    @JvmName("reverbBusUniformityProperty")
    set(`value`) {
      setReverbUniformity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(41, scriptPtr)
  }

  /**
   * This is a helper function for [gravityPointCenter] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = area3d.gravityPointCenter
   * //Your changes
   * area3d.gravityPointCenter = myCoreType
   * ``````
   *
   * If gravity is a point (see [gravityPoint]), this will be the point of attraction.
   */
  @CoreTypeHelper
  public final fun gravityPointCenterMutate(block: Vector3.() -> Unit): Vector3 =
      gravityPointCenter.apply {
     block(this)
     gravityPointCenter = this
  }

  /**
   * This is a helper function for [gravityDirection] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = area3d.gravityDirection
   * //Your changes
   * area3d.gravityDirection = myCoreType
   * ``````
   *
   * The area's gravity vector (not normalized).
   */
  @CoreTypeHelper
  public final fun gravityDirectionMutate(block: Vector3.() -> Unit): Vector3 =
      gravityDirection.apply {
     block(this)
     gravityDirection = this
  }

  public final fun setGravitySpaceOverrideMode(spaceOverrideMode: SpaceOverride): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to spaceOverrideMode.value)
    TransferContext.callMethod(MethodBindings.setGravitySpaceOverrideModePtr)
  }

  public final fun getGravitySpaceOverrideMode(): SpaceOverride {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravitySpaceOverrideModePtr)
    return SpaceOverride.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setGravityIsPoint(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setGravityIsPointPtr)
  }

  public final fun isGravityAPoint(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isGravityAPointPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGravityPointUnitDistance(distanceScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distanceScale.toDouble())
    TransferContext.callMethod(MethodBindings.setGravityPointUnitDistancePtr)
  }

  public final fun getGravityPointUnitDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPointUnitDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setGravityPointCenter(center: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to center)
    TransferContext.callMethod(MethodBindings.setGravityPointCenterPtr)
  }

  public final fun getGravityPointCenter(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPointCenterPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setGravityDirection(direction: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to direction)
    TransferContext.callMethod(MethodBindings.setGravityDirectionPtr)
  }

  public final fun getGravityDirection(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setGravity(gravity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to gravity.toDouble())
    TransferContext.callMethod(MethodBindings.setGravityPtr)
  }

  public final fun getGravity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLinearDampSpaceOverrideMode(spaceOverrideMode: SpaceOverride): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to spaceOverrideMode.value)
    TransferContext.callMethod(MethodBindings.setLinearDampSpaceOverrideModePtr)
  }

  public final fun getLinearDampSpaceOverrideMode(): SpaceOverride {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearDampSpaceOverrideModePtr)
    return SpaceOverride.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAngularDampSpaceOverrideMode(spaceOverrideMode: SpaceOverride): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to spaceOverrideMode.value)
    TransferContext.callMethod(MethodBindings.setAngularDampSpaceOverrideModePtr)
  }

  public final fun getAngularDampSpaceOverrideMode(): SpaceOverride {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularDampSpaceOverrideModePtr)
    return SpaceOverride.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAngularDamp(angularDamp: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to angularDamp.toDouble())
    TransferContext.callMethod(MethodBindings.setAngularDampPtr)
  }

  public final fun getAngularDamp(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularDampPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLinearDamp(linearDamp: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to linearDamp.toDouble())
    TransferContext.callMethod(MethodBindings.setLinearDampPtr)
  }

  public final fun getLinearDamp(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearDampPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPriority(priority: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to priority.toLong())
    TransferContext.callMethod(MethodBindings.setPriorityPtr)
  }

  public final fun getPriority(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPriorityPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setWindForceMagnitude(windForceMagnitude: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to windForceMagnitude.toDouble())
    TransferContext.callMethod(MethodBindings.setWindForceMagnitudePtr)
  }

  public final fun getWindForceMagnitude(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWindForceMagnitudePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setWindAttenuationFactor(windAttenuationFactor: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to windAttenuationFactor.toDouble())
    TransferContext.callMethod(MethodBindings.setWindAttenuationFactorPtr)
  }

  public final fun getWindAttenuationFactor(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWindAttenuationFactorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setWindSourcePath(windSourcePath: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to windSourcePath)
    TransferContext.callMethod(MethodBindings.setWindSourcePathPtr)
  }

  public final fun getWindSourcePath(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWindSourcePathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setMonitorable(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setMonitorablePtr)
  }

  public final fun isMonitorable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMonitorablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMonitoring(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setMonitoringPtr)
  }

  public final fun isMonitoring(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMonitoringPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a list of intersecting [PhysicsBody3D]s, [SoftBody3D]s, and [GridMap]s. The overlapping
   * body's [CollisionObject3D.collisionLayer] must be part of this area's
   * [CollisionObject3D.collisionMask] in order to be detected.
   *
   * For performance reasons (collisions are all processed at the same time) this list is modified
   * once during the physics step, not immediately after objects are moved. Consider using signals
   * instead.
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will not
   * return any such bodies.
   */
  public final fun getOverlappingBodies(): VariantArray<Node3D> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOverlappingBodiesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Node3D>)
  }

  /**
   * Returns a list of intersecting [Area3D]s. The overlapping area's
   * [CollisionObject3D.collisionLayer] must be part of this area's [CollisionObject3D.collisionMask]
   * in order to be detected.
   *
   * For performance reasons (collisions are all processed at the same time) this list is modified
   * once during the physics step, not immediately after objects are moved. Consider using signals
   * instead.
   */
  public final fun getOverlappingAreas(): VariantArray<Area3D> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOverlappingAreasPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Area3D>)
  }

  /**
   * Returns `true` if intersecting any [PhysicsBody3D]s, [SoftBody3D]s, or [GridMap]s, otherwise
   * returns `false`. The overlapping body's [CollisionObject3D.collisionLayer] must be part of this
   * area's [CollisionObject3D.collisionMask] in order to be detected.
   *
   * For performance reasons (collisions are all processed at the same time) the list of overlapping
   * bodies is modified once during the physics step, not immediately after objects are moved. Consider
   * using signals instead.
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will not
   * consider such bodies.
   */
  public final fun hasOverlappingBodies(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasOverlappingBodiesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if intersecting any [Area3D]s, otherwise returns `false`. The overlapping area's
   * [CollisionObject3D.collisionLayer] must be part of this area's [CollisionObject3D.collisionMask]
   * in order to be detected.
   *
   * For performance reasons (collisions are all processed at the same time) the list of overlapping
   * areas is modified once during the physics step, not immediately after objects are moved. Consider
   * using signals instead.
   */
  public final fun hasOverlappingAreas(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasOverlappingAreasPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given physics body intersects or overlaps this [Area3D], `false`
   * otherwise.
   *
   * [body] argument can either be a [PhysicsBody3D], [SoftBody3D], or a [GridMap] instance. While
   * GridMaps are not physics body themselves, they register their tiles with collision shapes as a
   * virtual physics body.
   *
   * **Note:** The result of this test is not immediate after moving objects. For performance, list
   * of overlaps is updated once per frame and before the physics step. Consider using signals instead.
   *
   * **Note:** Godot Physics does not support reporting overlaps with [SoftBody3D], so will return
   * `false` in such cases.
   */
  public final fun overlapsBody(body: Node): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to body)
    TransferContext.callMethod(MethodBindings.overlapsBodyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given [Area3D] intersects or overlaps this [Area3D], `false` otherwise.
   *
   * **Note:** The result of this test is not immediate after moving objects. For performance, list
   * of overlaps is updated once per frame and before the physics step. Consider using signals instead.
   */
  public final fun overlapsArea(area: Node): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to area)
    TransferContext.callMethod(MethodBindings.overlapsAreaPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAudioBusOverride(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAudioBusOverridePtr)
  }

  public final fun isOverridingAudioBus(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOverridingAudioBusPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAudioBusName(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.setAudioBusNamePtr)
  }

  public final fun getAudioBusName(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAudioBusNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setUseReverbBus(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseReverbBusPtr)
  }

  public final fun isUsingReverbBus(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingReverbBusPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setReverbBusName(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.setReverbBusNamePtr)
  }

  public final fun getReverbBusName(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReverbBusNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setReverbAmount(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setReverbAmountPtr)
  }

  public final fun getReverbAmount(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReverbAmountPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setReverbUniformity(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setReverbUniformityPtr)
  }

  public final fun getReverbUniformity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReverbUniformityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setWindSourcePath(windSourcePath: String) =
      setWindSourcePath(windSourcePath.asCachedNodePath())

  public final fun setAudioBusName(name: String) = setAudioBusName(name.asCachedStringName())

  public final fun setReverbBusName(name: String) = setReverbBusName(name.asCachedStringName())

  public enum class SpaceOverride(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This area does not affect gravity/damping.
     */
    DISABLED(0),
    /**
     * This area adds its gravity/damping values to whatever has been calculated so far (in
     * [priority] order).
     */
    COMBINE(1),
    /**
     * This area adds its gravity/damping values to whatever has been calculated so far (in
     * [priority] order), ignoring any lower priority areas.
     */
    COMBINE_REPLACE(2),
    /**
     * This area replaces any gravity/damping, even the defaults, ignoring any lower priority areas.
     */
    REPLACE(3),
    /**
     * This area replaces any gravity/damping calculated so far (in [priority] order), but keeps
     * calculating the rest of the areas.
     */
    REPLACE_COMBINE(4),
    ;

    public companion object {
      public fun from(`value`: Long): SpaceOverride = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setGravitySpaceOverrideModeName: MethodStringName1<Area3D, Unit, SpaceOverride> =
        MethodStringName1<Area3D, Unit, SpaceOverride>("set_gravity_space_override_mode")

    @JvmField
    public val getGravitySpaceOverrideModeName: MethodStringName0<Area3D, SpaceOverride> =
        MethodStringName0<Area3D, SpaceOverride>("get_gravity_space_override_mode")

    @JvmField
    public val setGravityIsPointName: MethodStringName1<Area3D, Unit, Boolean> =
        MethodStringName1<Area3D, Unit, Boolean>("set_gravity_is_point")

    @JvmField
    public val isGravityAPointName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("is_gravity_a_point")

    @JvmField
    public val setGravityPointUnitDistanceName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_gravity_point_unit_distance")

    @JvmField
    public val getGravityPointUnitDistanceName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_gravity_point_unit_distance")

    @JvmField
    public val setGravityPointCenterName: MethodStringName1<Area3D, Unit, Vector3> =
        MethodStringName1<Area3D, Unit, Vector3>("set_gravity_point_center")

    @JvmField
    public val getGravityPointCenterName: MethodStringName0<Area3D, Vector3> =
        MethodStringName0<Area3D, Vector3>("get_gravity_point_center")

    @JvmField
    public val setGravityDirectionName: MethodStringName1<Area3D, Unit, Vector3> =
        MethodStringName1<Area3D, Unit, Vector3>("set_gravity_direction")

    @JvmField
    public val getGravityDirectionName: MethodStringName0<Area3D, Vector3> =
        MethodStringName0<Area3D, Vector3>("get_gravity_direction")

    @JvmField
    public val setGravityName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_gravity")

    @JvmField
    public val getGravityName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_gravity")

    @JvmField
    public val setLinearDampSpaceOverrideModeName: MethodStringName1<Area3D, Unit, SpaceOverride> =
        MethodStringName1<Area3D, Unit, SpaceOverride>("set_linear_damp_space_override_mode")

    @JvmField
    public val getLinearDampSpaceOverrideModeName: MethodStringName0<Area3D, SpaceOverride> =
        MethodStringName0<Area3D, SpaceOverride>("get_linear_damp_space_override_mode")

    @JvmField
    public val setAngularDampSpaceOverrideModeName: MethodStringName1<Area3D, Unit, SpaceOverride> =
        MethodStringName1<Area3D, Unit, SpaceOverride>("set_angular_damp_space_override_mode")

    @JvmField
    public val getAngularDampSpaceOverrideModeName: MethodStringName0<Area3D, SpaceOverride> =
        MethodStringName0<Area3D, SpaceOverride>("get_angular_damp_space_override_mode")

    @JvmField
    public val setAngularDampName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_angular_damp")

    @JvmField
    public val getAngularDampName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_angular_damp")

    @JvmField
    public val setLinearDampName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_linear_damp")

    @JvmField
    public val getLinearDampName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_linear_damp")

    @JvmField
    public val setPriorityName: MethodStringName1<Area3D, Unit, Int> =
        MethodStringName1<Area3D, Unit, Int>("set_priority")

    @JvmField
    public val getPriorityName: MethodStringName0<Area3D, Int> =
        MethodStringName0<Area3D, Int>("get_priority")

    @JvmField
    public val setWindForceMagnitudeName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_wind_force_magnitude")

    @JvmField
    public val getWindForceMagnitudeName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_wind_force_magnitude")

    @JvmField
    public val setWindAttenuationFactorName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_wind_attenuation_factor")

    @JvmField
    public val getWindAttenuationFactorName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_wind_attenuation_factor")

    @JvmField
    public val setWindSourcePathName: MethodStringName1<Area3D, Unit, NodePath> =
        MethodStringName1<Area3D, Unit, NodePath>("set_wind_source_path")

    @JvmField
    public val getWindSourcePathName: MethodStringName0<Area3D, NodePath> =
        MethodStringName0<Area3D, NodePath>("get_wind_source_path")

    @JvmField
    public val setMonitorableName: MethodStringName1<Area3D, Unit, Boolean> =
        MethodStringName1<Area3D, Unit, Boolean>("set_monitorable")

    @JvmField
    public val isMonitorableName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("is_monitorable")

    @JvmField
    public val setMonitoringName: MethodStringName1<Area3D, Unit, Boolean> =
        MethodStringName1<Area3D, Unit, Boolean>("set_monitoring")

    @JvmField
    public val isMonitoringName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("is_monitoring")

    @JvmField
    public val getOverlappingBodiesName: MethodStringName0<Area3D, VariantArray<Node3D>> =
        MethodStringName0<Area3D, VariantArray<Node3D>>("get_overlapping_bodies")

    @JvmField
    public val getOverlappingAreasName: MethodStringName0<Area3D, VariantArray<Area3D>> =
        MethodStringName0<Area3D, VariantArray<Area3D>>("get_overlapping_areas")

    @JvmField
    public val hasOverlappingBodiesName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("has_overlapping_bodies")

    @JvmField
    public val hasOverlappingAreasName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("has_overlapping_areas")

    @JvmField
    public val overlapsBodyName: MethodStringName1<Area3D, Boolean, Node> =
        MethodStringName1<Area3D, Boolean, Node>("overlaps_body")

    @JvmField
    public val overlapsAreaName: MethodStringName1<Area3D, Boolean, Node> =
        MethodStringName1<Area3D, Boolean, Node>("overlaps_area")

    @JvmField
    public val setAudioBusOverrideName: MethodStringName1<Area3D, Unit, Boolean> =
        MethodStringName1<Area3D, Unit, Boolean>("set_audio_bus_override")

    @JvmField
    public val isOverridingAudioBusName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("is_overriding_audio_bus")

    @JvmField
    public val setAudioBusNameName: MethodStringName1<Area3D, Unit, StringName> =
        MethodStringName1<Area3D, Unit, StringName>("set_audio_bus_name")

    @JvmField
    public val getAudioBusNameName: MethodStringName0<Area3D, StringName> =
        MethodStringName0<Area3D, StringName>("get_audio_bus_name")

    @JvmField
    public val setUseReverbBusName: MethodStringName1<Area3D, Unit, Boolean> =
        MethodStringName1<Area3D, Unit, Boolean>("set_use_reverb_bus")

    @JvmField
    public val isUsingReverbBusName: MethodStringName0<Area3D, Boolean> =
        MethodStringName0<Area3D, Boolean>("is_using_reverb_bus")

    @JvmField
    public val setReverbBusNameName: MethodStringName1<Area3D, Unit, StringName> =
        MethodStringName1<Area3D, Unit, StringName>("set_reverb_bus_name")

    @JvmField
    public val getReverbBusNameName: MethodStringName0<Area3D, StringName> =
        MethodStringName0<Area3D, StringName>("get_reverb_bus_name")

    @JvmField
    public val setReverbAmountName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_reverb_amount")

    @JvmField
    public val getReverbAmountName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_reverb_amount")

    @JvmField
    public val setReverbUniformityName: MethodStringName1<Area3D, Unit, Float> =
        MethodStringName1<Area3D, Unit, Float>("set_reverb_uniformity")

    @JvmField
    public val getReverbUniformityName: MethodStringName0<Area3D, Float> =
        MethodStringName0<Area3D, Float>("get_reverb_uniformity")
  }

  public object MethodBindings {
    internal val setGravitySpaceOverrideModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_gravity_space_override_mode", 2311433571)

    internal val getGravitySpaceOverrideModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_gravity_space_override_mode", 958191869)

    internal val setGravityIsPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_gravity_is_point", 2586408642)

    internal val isGravityAPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "is_gravity_a_point", 36873697)

    internal val setGravityPointUnitDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_gravity_point_unit_distance", 373806689)

    internal val getGravityPointUnitDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_gravity_point_unit_distance", 1740695150)

    internal val setGravityPointCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_gravity_point_center", 3460891852)

    internal val getGravityPointCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_gravity_point_center", 3360562783)

    internal val setGravityDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_gravity_direction", 3460891852)

    internal val getGravityDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_gravity_direction", 3360562783)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_gravity", 373806689)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_gravity", 1740695150)

    internal val setLinearDampSpaceOverrideModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_linear_damp_space_override_mode", 2311433571)

    internal val getLinearDampSpaceOverrideModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_linear_damp_space_override_mode", 958191869)

    internal val setAngularDampSpaceOverrideModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_angular_damp_space_override_mode", 2311433571)

    internal val getAngularDampSpaceOverrideModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_angular_damp_space_override_mode", 958191869)

    internal val setAngularDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_angular_damp", 373806689)

    internal val getAngularDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_angular_damp", 1740695150)

    internal val setLinearDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_linear_damp", 373806689)

    internal val getLinearDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_linear_damp", 1740695150)

    internal val setPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_priority", 1286410249)

    internal val getPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_priority", 3905245786)

    internal val setWindForceMagnitudePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_wind_force_magnitude", 373806689)

    internal val getWindForceMagnitudePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_wind_force_magnitude", 1740695150)

    internal val setWindAttenuationFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_wind_attenuation_factor", 373806689)

    internal val getWindAttenuationFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_wind_attenuation_factor", 1740695150)

    internal val setWindSourcePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_wind_source_path", 1348162250)

    internal val getWindSourcePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_wind_source_path", 4075236667)

    internal val setMonitorablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_monitorable", 2586408642)

    internal val isMonitorablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "is_monitorable", 36873697)

    internal val setMonitoringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_monitoring", 2586408642)

    internal val isMonitoringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "is_monitoring", 36873697)

    internal val getOverlappingBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_overlapping_bodies", 3995934104)

    internal val getOverlappingAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_overlapping_areas", 3995934104)

    internal val hasOverlappingBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "has_overlapping_bodies", 36873697)

    internal val hasOverlappingAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "has_overlapping_areas", 36873697)

    internal val overlapsBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "overlaps_body", 3093956946)

    internal val overlapsAreaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "overlaps_area", 3093956946)

    internal val setAudioBusOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_audio_bus_override", 2586408642)

    internal val isOverridingAudioBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "is_overriding_audio_bus", 36873697)

    internal val setAudioBusNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_audio_bus_name", 3304788590)

    internal val getAudioBusNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_audio_bus_name", 2002593661)

    internal val setUseReverbBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_use_reverb_bus", 2586408642)

    internal val isUsingReverbBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "is_using_reverb_bus", 36873697)

    internal val setReverbBusNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_reverb_bus_name", 3304788590)

    internal val getReverbBusNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_reverb_bus_name", 2002593661)

    internal val setReverbAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_reverb_amount", 373806689)

    internal val getReverbAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_reverb_amount", 1740695150)

    internal val setReverbUniformityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "set_reverb_uniformity", 373806689)

    internal val getReverbUniformityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Area3D", "get_reverb_uniformity", 1740695150)
  }
}
