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
import godot.core.Basis
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Transform3D
import godot.core.VariantParser.BASIS
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.TRANSFORM3D
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
import kotlin.jvm.JvmOverloads

/**
 * Provides direct access to a physics body in the [PhysicsServer3D], allowing safe changes to
 * physics properties. This object is passed via the direct state callback of [RigidBody3D], and is
 * intended for changing the direct state of that body. See [RigidBody3D.IntegrateForces].
 */
@GodotBaseType
public open class PhysicsDirectBodyState3D internal constructor() : Object() {
  /**
   * The timestep (delta) used for the simulation.
   */
  public final inline val step: Float
    @JvmName("stepProperty")
    get() = getStep()

  /**
   * The inverse of the mass of the body.
   */
  public final inline val inverseMass: Float
    @JvmName("inverseMassProperty")
    get() = getInverseMass()

  /**
   * The rate at which the body stops rotating, if there are not any other forces moving it.
   */
  public final inline val totalAngularDamp: Float
    @JvmName("totalAngularDampProperty")
    get() = getTotalAngularDamp()

  /**
   * The rate at which the body stops moving, if there are not any other forces moving it.
   */
  public final inline val totalLinearDamp: Float
    @JvmName("totalLinearDampProperty")
    get() = getTotalLinearDamp()

  /**
   * The inverse of the inertia of the body.
   */
  public final inline val inverseInertia: Vector3
    @JvmName("inverseInertiaProperty")
    get() = getInverseInertia()

  /**
   * The inverse of the inertia tensor of the body.
   */
  public final inline val inverseInertiaTensor: Basis
    @JvmName("inverseInertiaTensorProperty")
    get() = getInverseInertiaTensor()

  /**
   * The total gravity vector being currently applied to this body.
   */
  public final inline val totalGravity: Vector3
    @JvmName("totalGravityProperty")
    get() = getTotalGravity()

  /**
   * The body's center of mass position relative to the body's center in the global coordinate
   * system.
   */
  public final inline val centerOfMass: Vector3
    @JvmName("centerOfMassProperty")
    get() = getCenterOfMass()

  /**
   * The body's center of mass position in the body's local coordinate system.
   */
  public final inline val centerOfMassLocal: Vector3
    @JvmName("centerOfMassLocalProperty")
    get() = getCenterOfMassLocal()

  public final inline val principalInertiaAxes: Basis
    @JvmName("principalInertiaAxesProperty")
    get() = getPrincipalInertiaAxes()

  /**
   * The body's rotational velocity in *radians* per second.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var angularVelocity: Vector3
    @JvmName("angularVelocityProperty")
    get() = getAngularVelocity()
    @JvmName("angularVelocityProperty")
    set(`value`) {
      setAngularVelocity(value)
    }

  /**
   * The body's linear velocity in units per second.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var linearVelocity: Vector3
    @JvmName("linearVelocityProperty")
    get() = getLinearVelocity()
    @JvmName("linearVelocityProperty")
    set(`value`) {
      setLinearVelocity(value)
    }

  /**
   * If `true`, this body is currently sleeping (not active).
   */
  public final inline var sleeping: Boolean
    @JvmName("sleepingProperty")
    get() = isSleeping()
    @JvmName("sleepingProperty")
    set(`value`) {
      setSleepState(value)
    }

  /**
   * The body's collision layer.
   */
  public final inline var collisionLayer: Long
    @JvmName("collisionLayerProperty")
    get() = getCollisionLayer()
    @JvmName("collisionLayerProperty")
    set(`value`) {
      setCollisionLayer(value)
    }

  /**
   * The body's collision mask.
   */
  public final inline var collisionMask: Long
    @JvmName("collisionMaskProperty")
    get() = getCollisionMask()
    @JvmName("collisionMaskProperty")
    set(`value`) {
      setCollisionMask(value)
    }

  /**
   * The body's transformation matrix.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var transform: Transform3D
    @JvmName("transformProperty")
    get() = getTransform()
    @JvmName("transformProperty")
    set(`value`) {
      setTransform(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(528, scriptPtr)
  }

  /**
   * This is a helper function for [angularVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsdirectbodystate3d.angularVelocity
   * //Your changes
   * physicsdirectbodystate3d.angularVelocity = myCoreType
   * ``````
   *
   * The body's rotational velocity in *radians* per second.
   */
  @CoreTypeHelper
  public final fun angularVelocityMutate(block: Vector3.() -> Unit): Vector3 =
      angularVelocity.apply {
     block(this)
     angularVelocity = this
  }

  /**
   * This is a helper function for [linearVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsdirectbodystate3d.linearVelocity
   * //Your changes
   * physicsdirectbodystate3d.linearVelocity = myCoreType
   * ``````
   *
   * The body's linear velocity in units per second.
   */
  @CoreTypeHelper
  public final fun linearVelocityMutate(block: Vector3.() -> Unit): Vector3 = linearVelocity.apply {
     block(this)
     linearVelocity = this
  }

  /**
   * This is a helper function for [transform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsdirectbodystate3d.transform
   * //Your changes
   * physicsdirectbodystate3d.transform = myCoreType
   * ``````
   *
   * The body's transformation matrix.
   */
  @CoreTypeHelper
  public final fun transformMutate(block: Transform3D.() -> Unit): Transform3D = transform.apply {
     block(this)
     transform = this
  }

  public final fun getTotalGravity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalGravityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getTotalLinearDamp(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalLinearDampPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getTotalAngularDamp(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalAngularDampPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getCenterOfMass(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterOfMassPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getCenterOfMassLocal(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterOfMassLocalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getPrincipalInertiaAxes(): Basis {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPrincipalInertiaAxesPtr)
    return (TransferContext.readReturnValue(BASIS) as Basis)
  }

  public final fun getInverseMass(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInverseMassPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getInverseInertia(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInverseInertiaPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getInverseInertiaTensor(): Basis {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInverseInertiaTensorPtr)
    return (TransferContext.readReturnValue(BASIS) as Basis)
  }

  public final fun setLinearVelocity(velocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to velocity)
    TransferContext.callMethod(MethodBindings.setLinearVelocityPtr)
  }

  public final fun getLinearVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setAngularVelocity(velocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to velocity)
    TransferContext.callMethod(MethodBindings.setAngularVelocityPtr)
  }

  public final fun getAngularVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setTransform(transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  public final fun getTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Returns the body's velocity at the given relative position.
   *
   * [localPosition] is the offset from the body origin in global coordinates.
   */
  public final fun getVelocityAtLocalPosition(localPosition: Vector3): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to localPosition)
    TransferContext.callMethod(MethodBindings.getVelocityAtLocalPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Applies a directional impulse without affecting rotation.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   *
   * This is equivalent to using [applyImpulse] at the body's center of mass.
   */
  @JvmOverloads
  public final fun applyCentralImpulse(impulse: Vector3 = Vector3(0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to impulse)
    TransferContext.callMethod(MethodBindings.applyCentralImpulsePtr)
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
  public final fun applyImpulse(impulse: Vector3, position: Vector3 = Vector3(0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to impulse, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.applyImpulsePtr)
  }

  /**
   * Applies a rotational impulse to the body without affecting the position.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   *
   * **Note:** [inverseInertia] is required for this to work. To have [inverseInertia], an active
   * [CollisionShape3D] must be a child of the node, or you can manually set [inverseInertia].
   */
  public final fun applyTorqueImpulse(impulse: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to impulse)
    TransferContext.callMethod(MethodBindings.applyTorqueImpulsePtr)
  }

  /**
   * Applies a directional force without affecting rotation. A force is time dependent and meant to
   * be applied every physics update.
   *
   * This is equivalent to using [applyForce] at the body's center of mass.
   */
  @JvmOverloads
  public final fun applyCentralForce(force: Vector3 = Vector3(0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.applyCentralForcePtr)
  }

  /**
   * Applies a positioned force to the body. A force is time dependent and meant to be applied every
   * physics update.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  public final fun applyForce(force: Vector3, position: Vector3 = Vector3(0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to force, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.applyForcePtr)
  }

  /**
   * Applies a rotational force without affecting position. A force is time dependent and meant to
   * be applied every physics update.
   *
   * **Note:** [inverseInertia] is required for this to work. To have [inverseInertia], an active
   * [CollisionShape3D] must be a child of the node, or you can manually set [inverseInertia].
   */
  public final fun applyTorque(torque: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to torque)
    TransferContext.callMethod(MethodBindings.applyTorquePtr)
  }

  /**
   * Adds a constant directional force without affecting rotation that keeps being applied over time
   * until cleared with `constant_force = Vector3(0, 0, 0)`.
   *
   * This is equivalent to using [addConstantForce] at the body's center of mass.
   */
  @JvmOverloads
  public final fun addConstantCentralForce(force: Vector3 = Vector3(0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.addConstantCentralForcePtr)
  }

  /**
   * Adds a constant positioned force to the body that keeps being applied over time until cleared
   * with `constant_force = Vector3(0, 0, 0)`.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  public final fun addConstantForce(force: Vector3, position: Vector3 = Vector3(0, 0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to force, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.addConstantForcePtr)
  }

  /**
   * Adds a constant rotational force without affecting position that keeps being applied over time
   * until cleared with `constant_torque = Vector3(0, 0, 0)`.
   */
  public final fun addConstantTorque(torque: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to torque)
    TransferContext.callMethod(MethodBindings.addConstantTorquePtr)
  }

  /**
   * Sets the body's total constant positional forces applied during each physics update.
   *
   * See [addConstantForce] and [addConstantCentralForce].
   */
  public final fun setConstantForce(force: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.setConstantForcePtr)
  }

  /**
   * Returns the body's total constant positional forces applied during each physics update.
   *
   * See [addConstantForce] and [addConstantCentralForce].
   */
  public final fun getConstantForce(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantForcePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the body's total constant rotational forces applied during each physics update.
   *
   * See [addConstantTorque].
   */
  public final fun setConstantTorque(torque: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to torque)
    TransferContext.callMethod(MethodBindings.setConstantTorquePtr)
  }

  /**
   * Returns the body's total constant rotational forces applied during each physics update.
   *
   * See [addConstantTorque].
   */
  public final fun getConstantTorque(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantTorquePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setSleepState(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSleepStatePtr)
  }

  public final fun isSleeping(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSleepingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollisionLayer(layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer)
    TransferContext.callMethod(MethodBindings.setCollisionLayerPtr)
  }

  public final fun getCollisionLayer(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setCollisionMaskPtr)
  }

  public final fun getCollisionMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the number of contacts this body has with other bodies.
   *
   * **Note:** By default, this returns 0 unless bodies are configured to monitor contacts. See
   * [RigidBody3D.contactMonitor].
   */
  public final fun getContactCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContactCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the position of the contact point on the body in the global coordinate system.
   */
  public final fun getContactLocalPosition(contactIdx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactLocalPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the local normal at the contact point.
   */
  public final fun getContactLocalNormal(contactIdx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactLocalNormalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Impulse created by the contact.
   */
  public final fun getContactImpulse(contactIdx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactImpulsePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the local shape index of the collision.
   */
  public final fun getContactLocalShape(contactIdx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactLocalShapePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the linear velocity vector at the body's contact point.
   */
  public final fun getContactLocalVelocityAtPosition(contactIdx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactLocalVelocityAtPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the collider's [RID].
   */
  public final fun getContactCollider(contactIdx: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactColliderPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the position of the contact point on the collider in the global coordinate system.
   */
  public final fun getContactColliderPosition(contactIdx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactColliderPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the collider's object id.
   */
  public final fun getContactColliderId(contactIdx: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactColliderIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the collider object.
   */
  public final fun getContactColliderObject(contactIdx: Int): Object? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactColliderObjectPtr)
    return (TransferContext.readReturnValue(OBJECT) as Object?)
  }

  /**
   * Returns the collider's shape index.
   */
  public final fun getContactColliderShape(contactIdx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactColliderShapePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the linear velocity vector at the collider's contact point.
   */
  public final fun getContactColliderVelocityAtPosition(contactIdx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to contactIdx.toLong())
    TransferContext.callMethod(MethodBindings.getContactColliderVelocityAtPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getStep(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStepPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Updates the body's linear and angular velocity by applying gravity and damping for the
   * equivalent of one physics tick.
   */
  public final fun integrateForces(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.integrateForcesPtr)
  }

  /**
   * Returns the current state of the space, useful for queries.
   */
  public final fun getSpaceState(): PhysicsDirectSpaceState3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpaceStatePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsDirectSpaceState3D)
  }

  public companion object {
    @JvmField
    public val getTotalGravityName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_total_gravity")

    @JvmField
    public val getTotalLinearDampName: MethodStringName0<PhysicsDirectBodyState3D, Float> =
        MethodStringName0<PhysicsDirectBodyState3D, Float>("get_total_linear_damp")

    @JvmField
    public val getTotalAngularDampName: MethodStringName0<PhysicsDirectBodyState3D, Float> =
        MethodStringName0<PhysicsDirectBodyState3D, Float>("get_total_angular_damp")

    @JvmField
    public val getCenterOfMassName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_center_of_mass")

    @JvmField
    public val getCenterOfMassLocalName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_center_of_mass_local")

    @JvmField
    public val getPrincipalInertiaAxesName: MethodStringName0<PhysicsDirectBodyState3D, Basis> =
        MethodStringName0<PhysicsDirectBodyState3D, Basis>("get_principal_inertia_axes")

    @JvmField
    public val getInverseMassName: MethodStringName0<PhysicsDirectBodyState3D, Float> =
        MethodStringName0<PhysicsDirectBodyState3D, Float>("get_inverse_mass")

    @JvmField
    public val getInverseInertiaName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_inverse_inertia")

    @JvmField
    public val getInverseInertiaTensorName: MethodStringName0<PhysicsDirectBodyState3D, Basis> =
        MethodStringName0<PhysicsDirectBodyState3D, Basis>("get_inverse_inertia_tensor")

    @JvmField
    public val setLinearVelocityName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("set_linear_velocity")

    @JvmField
    public val getLinearVelocityName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_linear_velocity")

    @JvmField
    public val setAngularVelocityName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("set_angular_velocity")

    @JvmField
    public val getAngularVelocityName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_angular_velocity")

    @JvmField
    public val setTransformName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Transform3D> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Transform3D>("set_transform")

    @JvmField
    public val getTransformName: MethodStringName0<PhysicsDirectBodyState3D, Transform3D> =
        MethodStringName0<PhysicsDirectBodyState3D, Transform3D>("get_transform")

    @JvmField
    public val getVelocityAtLocalPositionName:
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Vector3>("get_velocity_at_local_position")

    @JvmField
    public val applyCentralImpulseName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("apply_central_impulse")

    @JvmField
    public val applyImpulseName: MethodStringName2<PhysicsDirectBodyState3D, Unit, Vector3, Vector3>
        = MethodStringName2<PhysicsDirectBodyState3D, Unit, Vector3, Vector3>("apply_impulse")

    @JvmField
    public val applyTorqueImpulseName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("apply_torque_impulse")

    @JvmField
    public val applyCentralForceName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("apply_central_force")

    @JvmField
    public val applyForceName: MethodStringName2<PhysicsDirectBodyState3D, Unit, Vector3, Vector3> =
        MethodStringName2<PhysicsDirectBodyState3D, Unit, Vector3, Vector3>("apply_force")

    @JvmField
    public val applyTorqueName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("apply_torque")

    @JvmField
    public val addConstantCentralForceName:
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("add_constant_central_force")

    @JvmField
    public val addConstantForceName:
        MethodStringName2<PhysicsDirectBodyState3D, Unit, Vector3, Vector3> =
        MethodStringName2<PhysicsDirectBodyState3D, Unit, Vector3, Vector3>("add_constant_force")

    @JvmField
    public val addConstantTorqueName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("add_constant_torque")

    @JvmField
    public val setConstantForceName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("set_constant_force")

    @JvmField
    public val getConstantForceName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_constant_force")

    @JvmField
    public val setConstantTorqueName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Vector3>("set_constant_torque")

    @JvmField
    public val getConstantTorqueName: MethodStringName0<PhysicsDirectBodyState3D, Vector3> =
        MethodStringName0<PhysicsDirectBodyState3D, Vector3>("get_constant_torque")

    @JvmField
    public val setSleepStateName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Boolean> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Boolean>("set_sleep_state")

    @JvmField
    public val isSleepingName: MethodStringName0<PhysicsDirectBodyState3D, Boolean> =
        MethodStringName0<PhysicsDirectBodyState3D, Boolean>("is_sleeping")

    @JvmField
    public val setCollisionLayerName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Long> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Long>("set_collision_layer")

    @JvmField
    public val getCollisionLayerName: MethodStringName0<PhysicsDirectBodyState3D, Long> =
        MethodStringName0<PhysicsDirectBodyState3D, Long>("get_collision_layer")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<PhysicsDirectBodyState3D, Unit, Long> =
        MethodStringName1<PhysicsDirectBodyState3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<PhysicsDirectBodyState3D, Long> =
        MethodStringName0<PhysicsDirectBodyState3D, Long>("get_collision_mask")

    @JvmField
    public val getContactCountName: MethodStringName0<PhysicsDirectBodyState3D, Int> =
        MethodStringName0<PhysicsDirectBodyState3D, Int>("get_contact_count")

    @JvmField
    public val getContactLocalPositionName:
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>("get_contact_local_position")

    @JvmField
    public val getContactLocalNormalName: MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>
        = MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>("get_contact_local_normal")

    @JvmField
    public val getContactImpulseName: MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>("get_contact_impulse")

    @JvmField
    public val getContactLocalShapeName: MethodStringName1<PhysicsDirectBodyState3D, Int, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Int, Int>("get_contact_local_shape")

    @JvmField
    public val getContactLocalVelocityAtPositionName:
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>("get_contact_local_velocity_at_position")

    @JvmField
    public val getContactColliderName: MethodStringName1<PhysicsDirectBodyState3D, RID, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, RID, Int>("get_contact_collider")

    @JvmField
    public val getContactColliderPositionName:
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>("get_contact_collider_position")

    @JvmField
    public val getContactColliderIdName: MethodStringName1<PhysicsDirectBodyState3D, Long, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Long, Int>("get_contact_collider_id")

    @JvmField
    public val getContactColliderObjectName:
        MethodStringName1<PhysicsDirectBodyState3D, Object?, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Object?, Int>("get_contact_collider_object")

    @JvmField
    public val getContactColliderShapeName: MethodStringName1<PhysicsDirectBodyState3D, Int, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Int, Int>("get_contact_collider_shape")

    @JvmField
    public val getContactColliderVelocityAtPositionName:
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int> =
        MethodStringName1<PhysicsDirectBodyState3D, Vector3, Int>("get_contact_collider_velocity_at_position")

    @JvmField
    public val getStepName: MethodStringName0<PhysicsDirectBodyState3D, Float> =
        MethodStringName0<PhysicsDirectBodyState3D, Float>("get_step")

    @JvmField
    public val integrateForcesName: MethodStringName0<PhysicsDirectBodyState3D, Unit> =
        MethodStringName0<PhysicsDirectBodyState3D, Unit>("integrate_forces")

    @JvmField
    public val getSpaceStateName:
        MethodStringName0<PhysicsDirectBodyState3D, PhysicsDirectSpaceState3D> =
        MethodStringName0<PhysicsDirectBodyState3D, PhysicsDirectSpaceState3D>("get_space_state")
  }

  public object MethodBindings {
    internal val getTotalGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_total_gravity", 3360562783)

    internal val getTotalLinearDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_total_linear_damp", 1740695150)

    internal val getTotalAngularDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_total_angular_damp", 1740695150)

    internal val getCenterOfMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_center_of_mass", 3360562783)

    internal val getCenterOfMassLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_center_of_mass_local", 3360562783)

    internal val getPrincipalInertiaAxesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_principal_inertia_axes", 2716978435)

    internal val getInverseMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_inverse_mass", 1740695150)

    internal val getInverseInertiaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_inverse_inertia", 3360562783)

    internal val getInverseInertiaTensorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_inverse_inertia_tensor", 2716978435)

    internal val setLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_linear_velocity", 3460891852)

    internal val getLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_linear_velocity", 3360562783)

    internal val setAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_angular_velocity", 3460891852)

    internal val getAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_angular_velocity", 3360562783)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_transform", 2952846383)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_transform", 3229777777)

    internal val getVelocityAtLocalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_velocity_at_local_position", 192990374)

    internal val applyCentralImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "apply_central_impulse", 2007698547)

    internal val applyImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "apply_impulse", 2754756483)

    internal val applyTorqueImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "apply_torque_impulse", 3460891852)

    internal val applyCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "apply_central_force", 2007698547)

    internal val applyForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "apply_force", 2754756483)

    internal val applyTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "apply_torque", 3460891852)

    internal val addConstantCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "add_constant_central_force", 2007698547)

    internal val addConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "add_constant_force", 2754756483)

    internal val addConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "add_constant_torque", 3460891852)

    internal val setConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_constant_force", 3460891852)

    internal val getConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_constant_force", 3360562783)

    internal val setConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_constant_torque", 3460891852)

    internal val getConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_constant_torque", 3360562783)

    internal val setSleepStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_sleep_state", 2586408642)

    internal val isSleepingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "is_sleeping", 36873697)

    internal val setCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_collision_layer", 1286410249)

    internal val getCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_collision_layer", 3905245786)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_collision_mask", 3905245786)

    internal val getContactCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_count", 3905245786)

    internal val getContactLocalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_local_position", 711720468)

    internal val getContactLocalNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_local_normal", 711720468)

    internal val getContactImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_impulse", 711720468)

    internal val getContactLocalShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_local_shape", 923996154)

    internal val getContactLocalVelocityAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_local_velocity_at_position", 711720468)

    internal val getContactColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_collider", 495598643)

    internal val getContactColliderPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_collider_position", 711720468)

    internal val getContactColliderIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_collider_id", 923996154)

    internal val getContactColliderObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_collider_object", 3332903315)

    internal val getContactColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_collider_shape", 923996154)

    internal val getContactColliderVelocityAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_contact_collider_velocity_at_position", 711720468)

    internal val getStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_step", 1740695150)

    internal val integrateForcesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "integrate_forces", 3218959716)

    internal val getSpaceStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectBodyState3D", "get_space_state", 2069328350)
  }
}
