// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Basis
import godot.core.RID
import godot.core.Transform3D
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * This class extends [PhysicsDirectBodyState3D] by providing additional virtual methods that can be
 * overridden. When these methods are overridden, they will be called instead of the internal methods
 * of the physics server.
 *
 * Intended for use with GDExtension to create custom implementations of [PhysicsDirectBodyState3D].
 */
@GodotBaseType
public abstract class PhysicsDirectBodyState3DExtension : PhysicsDirectBodyState3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(528, scriptPtr)
  }

  public abstract fun _getTotalGravity(): Vector3

  public abstract fun _getTotalLinearDamp(): Float

  public abstract fun _getTotalAngularDamp(): Float

  public abstract fun _getCenterOfMass(): Vector3

  public abstract fun _getCenterOfMassLocal(): Vector3

  public abstract fun _getPrincipalInertiaAxes(): Basis

  public abstract fun _getInverseMass(): Float

  public abstract fun _getInverseInertia(): Vector3

  public abstract fun _getInverseInertiaTensor(): Basis

  public abstract fun _setLinearVelocity(velocity: Vector3): Unit

  public abstract fun _getLinearVelocity(): Vector3

  public abstract fun _setAngularVelocity(velocity: Vector3): Unit

  public abstract fun _getAngularVelocity(): Vector3

  public abstract fun _setTransform(transform: Transform3D): Unit

  public abstract fun _getTransform(): Transform3D

  public abstract fun _getVelocityAtLocalPosition(localPosition: Vector3): Vector3

  public abstract fun _applyCentralImpulse(impulse: Vector3): Unit

  public abstract fun _applyImpulse(impulse: Vector3, position: Vector3): Unit

  public abstract fun _applyTorqueImpulse(impulse: Vector3): Unit

  public abstract fun _applyCentralForce(force: Vector3): Unit

  public abstract fun _applyForce(force: Vector3, position: Vector3): Unit

  public abstract fun _applyTorque(torque: Vector3): Unit

  public abstract fun _addConstantCentralForce(force: Vector3): Unit

  public abstract fun _addConstantForce(force: Vector3, position: Vector3): Unit

  public abstract fun _addConstantTorque(torque: Vector3): Unit

  public abstract fun _setConstantForce(force: Vector3): Unit

  public abstract fun _getConstantForce(): Vector3

  public abstract fun _setConstantTorque(torque: Vector3): Unit

  public abstract fun _getConstantTorque(): Vector3

  public abstract fun _setSleepState(enabled: Boolean): Unit

  public abstract fun _isSleeping(): Boolean

  public abstract fun _setCollisionLayer(layer: Long): Unit

  public abstract fun _getCollisionLayer(): Long

  public abstract fun _setCollisionMask(mask: Long): Unit

  public abstract fun _getCollisionMask(): Long

  public abstract fun _getContactCount(): Int

  public abstract fun _getContactLocalPosition(contactIdx: Int): Vector3

  public abstract fun _getContactLocalNormal(contactIdx: Int): Vector3

  public abstract fun _getContactImpulse(contactIdx: Int): Vector3

  public abstract fun _getContactLocalShape(contactIdx: Int): Int

  public abstract fun _getContactLocalVelocityAtPosition(contactIdx: Int): Vector3

  public abstract fun _getContactCollider(contactIdx: Int): RID

  public abstract fun _getContactColliderPosition(contactIdx: Int): Vector3

  public abstract fun _getContactColliderId(contactIdx: Int): Long

  public abstract fun _getContactColliderObject(contactIdx: Int): Object?

  public abstract fun _getContactColliderShape(contactIdx: Int): Int

  public abstract fun _getContactColliderVelocityAtPosition(contactIdx: Int): Vector3

  public abstract fun _getStep(): Float

  public abstract fun _integrateForces(): Unit

  public abstract fun _getSpaceState(): PhysicsDirectSpaceState3D

  public companion object

  public object MethodBindings
}

internal class PhysicsDirectBodyState3DExtensionDummy : PhysicsDirectBodyState3DExtension() {
  public override fun _getTotalGravity(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getTotalGravity is only implemented by non-JVM code.")
  }

  public override fun _getTotalLinearDamp(): Float {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getTotalLinearDamp is only implemented by non-JVM code.")
  }

  public override fun _getTotalAngularDamp(): Float {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getTotalAngularDamp is only implemented by non-JVM code.")
  }

  public override fun _getCenterOfMass(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getCenterOfMass is only implemented by non-JVM code.")
  }

  public override fun _getCenterOfMassLocal(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getCenterOfMassLocal is only implemented by non-JVM code.")
  }

  public override fun _getPrincipalInertiaAxes(): Basis {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getPrincipalInertiaAxes is only implemented by non-JVM code.")
  }

  public override fun _getInverseMass(): Float {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getInverseMass is only implemented by non-JVM code.")
  }

  public override fun _getInverseInertia(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getInverseInertia is only implemented by non-JVM code.")
  }

  public override fun _getInverseInertiaTensor(): Basis {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getInverseInertiaTensor is only implemented by non-JVM code.")
  }

  public override fun _setLinearVelocity(velocity: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setLinearVelocity is only implemented by non-JVM code.")
  }

  public override fun _getLinearVelocity(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getLinearVelocity is only implemented by non-JVM code.")
  }

  public override fun _setAngularVelocity(velocity: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setAngularVelocity is only implemented by non-JVM code.")
  }

  public override fun _getAngularVelocity(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getAngularVelocity is only implemented by non-JVM code.")
  }

  public override fun _setTransform(transform: Transform3D): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setTransform is only implemented by non-JVM code.")
  }

  public override fun _getTransform(): Transform3D {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getTransform is only implemented by non-JVM code.")
  }

  public override fun _getVelocityAtLocalPosition(localPosition: Vector3): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getVelocityAtLocalPosition is only implemented by non-JVM code.")
  }

  public override fun _applyCentralImpulse(impulse: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_applyCentralImpulse is only implemented by non-JVM code.")
  }

  public override fun _applyImpulse(impulse: Vector3, position: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_applyImpulse is only implemented by non-JVM code.")
  }

  public override fun _applyTorqueImpulse(impulse: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_applyTorqueImpulse is only implemented by non-JVM code.")
  }

  public override fun _applyCentralForce(force: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_applyCentralForce is only implemented by non-JVM code.")
  }

  public override fun _applyForce(force: Vector3, position: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_applyForce is only implemented by non-JVM code.")
  }

  public override fun _applyTorque(torque: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_applyTorque is only implemented by non-JVM code.")
  }

  public override fun _addConstantCentralForce(force: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_addConstantCentralForce is only implemented by non-JVM code.")
  }

  public override fun _addConstantForce(force: Vector3, position: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_addConstantForce is only implemented by non-JVM code.")
  }

  public override fun _addConstantTorque(torque: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_addConstantTorque is only implemented by non-JVM code.")
  }

  public override fun _setConstantForce(force: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setConstantForce is only implemented by non-JVM code.")
  }

  public override fun _getConstantForce(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getConstantForce is only implemented by non-JVM code.")
  }

  public override fun _setConstantTorque(torque: Vector3): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setConstantTorque is only implemented by non-JVM code.")
  }

  public override fun _getConstantTorque(): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getConstantTorque is only implemented by non-JVM code.")
  }

  public override fun _setSleepState(enabled: Boolean): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setSleepState is only implemented by non-JVM code.")
  }

  public override fun _isSleeping(): Boolean {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_isSleeping is only implemented by non-JVM code.")
  }

  public override fun _setCollisionLayer(layer: Long): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setCollisionLayer is only implemented by non-JVM code.")
  }

  public override fun _getCollisionLayer(): Long {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getCollisionLayer is only implemented by non-JVM code.")
  }

  public override fun _setCollisionMask(mask: Long): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_setCollisionMask is only implemented by non-JVM code.")
  }

  public override fun _getCollisionMask(): Long {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getCollisionMask is only implemented by non-JVM code.")
  }

  public override fun _getContactCount(): Int {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactCount is only implemented by non-JVM code.")
  }

  public override fun _getContactLocalPosition(contactIdx: Int): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactLocalPosition is only implemented by non-JVM code.")
  }

  public override fun _getContactLocalNormal(contactIdx: Int): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactLocalNormal is only implemented by non-JVM code.")
  }

  public override fun _getContactImpulse(contactIdx: Int): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactImpulse is only implemented by non-JVM code.")
  }

  public override fun _getContactLocalShape(contactIdx: Int): Int {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactLocalShape is only implemented by non-JVM code.")
  }

  public override fun _getContactLocalVelocityAtPosition(contactIdx: Int): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactLocalVelocityAtPosition is only implemented by non-JVM code.")
  }

  public override fun _getContactCollider(contactIdx: Int): RID {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactCollider is only implemented by non-JVM code.")
  }

  public override fun _getContactColliderPosition(contactIdx: Int): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactColliderPosition is only implemented by non-JVM code.")
  }

  public override fun _getContactColliderId(contactIdx: Int): Long {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactColliderId is only implemented by non-JVM code.")
  }

  public override fun _getContactColliderObject(contactIdx: Int): Object? {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactColliderObject is only implemented by non-JVM code.")
  }

  public override fun _getContactColliderShape(contactIdx: Int): Int {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactColliderShape is only implemented by non-JVM code.")
  }

  public override fun _getContactColliderVelocityAtPosition(contactIdx: Int): Vector3 {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getContactColliderVelocityAtPosition is only implemented by non-JVM code.")
  }

  public override fun _getStep(): Float {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getStep is only implemented by non-JVM code.")
  }

  public override fun _integrateForces(): Unit {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_integrateForces is only implemented by non-JVM code.")
  }

  public override fun _getSpaceState(): PhysicsDirectSpaceState3D {
    throw NotImplementedError("PhysicsDirectBodyState3DExtension::_getSpaceState is only implemented by non-JVM code.")
  }
}
