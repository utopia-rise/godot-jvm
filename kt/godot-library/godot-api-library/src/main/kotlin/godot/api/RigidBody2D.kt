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
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal4
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [RigidBody2D] implements full 2D physics. It cannot be controlled directly, instead, you must
 * apply forces to it (gravity, impulses, etc.), and the physics simulation will calculate the
 * resulting movement, rotation, react to collisions, and affect other physics bodies in its path.
 *
 * The body's behavior can be adjusted via [lockRotation], [freeze], and [freezeMode]. By changing
 * various properties of the object, such as [mass], you can control how the physics simulation acts on
 * it.
 *
 * A rigid body will always maintain its shape and size, even when forces are applied to it. It is
 * useful for objects that can be interacted with in an environment, such as a tree that can be knocked
 * over or a stack of crates that can be pushed around.
 *
 * If you need to directly affect the body, prefer [_integrateForces] as it allows you to directly
 * access the physics state.
 *
 * If you need to override the default physics behavior, you can write a custom force integration
 * function. See [customIntegrator].
 *
 * **Note:** Changing the 2D transform or [linearVelocity] of a [RigidBody2D] very often may lead to
 * some unpredictable behaviors. This also happens when a [RigidBody2D] is the descendant of a
 * constantly moving node, like another [RigidBody2D], as that will cause its global transform to be
 * set whenever its ancestor moves.
 */
@GodotBaseType
public open class RigidBody2D : PhysicsBody2D() {
  /**
   * Emitted when one of this RigidBody2D's [Shape2D]s collides with another [PhysicsBody2D] or
   * [TileMap]'s [Shape2D]s. Requires [contactMonitor] to be set to `true` and [maxContactsReported] to
   * be set high enough to detect all the collisions. [TileMap]s are detected if the [TileSet] has
   * Collision [Shape2D]s.
   *
   * [bodyRid] the [RID] of the other [PhysicsBody2D] or [TileSet]'s [CollisionObject2D] used by the
   * [PhysicsServer2D].
   *
   * [body] the [Node], if it exists in the tree, of the other [PhysicsBody2D] or [TileMap].
   *
   * [bodyShapeIndex] the index of the [Shape2D] of the other [PhysicsBody2D] or [TileMap] used by
   * the [PhysicsServer2D]. Get the [CollisionShape2D] node with
   * `body.shape_owner_get_owner(body.shape_find_owner(body_shape_index))`.
   *
   * [localShapeIndex] the index of the [Shape2D] of this RigidBody2D used by the [PhysicsServer2D].
   * Get the [CollisionShape2D] node with
   * `self.shape_owner_get_owner(self.shape_find_owner(local_shape_index))`.
   */
  public val bodyShapeEntered: Signal4<RID, Node, Long, Long> by Signal4

  /**
   * Emitted when the collision between one of this RigidBody2D's [Shape2D]s and another
   * [PhysicsBody2D] or [TileMap]'s [Shape2D]s ends. Requires [contactMonitor] to be set to `true` and
   * [maxContactsReported] to be set high enough to detect all the collisions. [TileMap]s are detected
   * if the [TileSet] has Collision [Shape2D]s.
   *
   * [bodyRid] the [RID] of the other [PhysicsBody2D] or [TileSet]'s [CollisionObject2D] used by the
   * [PhysicsServer2D].
   *
   * [body] the [Node], if it exists in the tree, of the other [PhysicsBody2D] or [TileMap].
   *
   * [bodyShapeIndex] the index of the [Shape2D] of the other [PhysicsBody2D] or [TileMap] used by
   * the [PhysicsServer2D]. Get the [CollisionShape2D] node with
   * `body.shape_owner_get_owner(body.shape_find_owner(body_shape_index))`.
   *
   * [localShapeIndex] the index of the [Shape2D] of this RigidBody2D used by the [PhysicsServer2D].
   * Get the [CollisionShape2D] node with
   * `self.shape_owner_get_owner(self.shape_find_owner(local_shape_index))`.
   */
  public val bodyShapeExited: Signal4<RID, Node, Long, Long> by Signal4

  /**
   * Emitted when a collision with another [PhysicsBody2D] or [TileMap] occurs. Requires
   * [contactMonitor] to be set to `true` and [maxContactsReported] to be set high enough to detect all
   * the collisions. [TileMap]s are detected if the [TileSet] has Collision [Shape2D]s.
   *
   * [body] the [Node], if it exists in the tree, of the other [PhysicsBody2D] or [TileMap].
   */
  public val bodyEntered: Signal1<Node> by Signal1

  /**
   * Emitted when the collision with another [PhysicsBody2D] or [TileMap] ends. Requires
   * [contactMonitor] to be set to `true` and [maxContactsReported] to be set high enough to detect all
   * the collisions. [TileMap]s are detected if the [TileSet] has Collision [Shape2D]s.
   *
   * [body] the [Node], if it exists in the tree, of the other [PhysicsBody2D] or [TileMap].
   */
  public val bodyExited: Signal1<Node> by Signal1

  /**
   * Emitted when the physics engine changes the body's sleeping state.
   *
   * **Note:** Changing the value [sleeping] will not trigger this signal. It is only emitted if the
   * sleeping state is changed by the physics engine or `emit_signal("sleeping_state_changed")` is
   * used.
   */
  public val sleepingStateChanged: Signal0 by Signal0

  /**
   * The body's mass.
   */
  public final inline var mass: Float
    @JvmName("massProperty")
    get() = getMass()
    @JvmName("massProperty")
    set(`value`) {
      setMass(value)
    }

  /**
   * The physics material override for the body.
   *
   * If a material is assigned to this property, it will be used instead of any other physics
   * material, such as an inherited one.
   */
  public final inline var physicsMaterialOverride: PhysicsMaterial?
    @JvmName("physicsMaterialOverrideProperty")
    get() = getPhysicsMaterialOverride()
    @JvmName("physicsMaterialOverrideProperty")
    set(`value`) {
      setPhysicsMaterialOverride(value)
    }

  /**
   * Multiplies the gravity applied to the body. The body's gravity is calculated from the
   * [ProjectSettings.physics/2d/defaultGravity] project setting and/or any additional gravity vector
   * applied by [Area2D]s.
   */
  public final inline var gravityScale: Float
    @JvmName("gravityScaleProperty")
    get() = getGravityScale()
    @JvmName("gravityScaleProperty")
    set(`value`) {
      setGravityScale(value)
    }

  /**
   * Defines the way the body's center of mass is set.
   */
  public final inline var centerOfMassMode: CenterOfMassMode
    @JvmName("centerOfMassModeProperty")
    get() = getCenterOfMassMode()
    @JvmName("centerOfMassModeProperty")
    set(`value`) {
      setCenterOfMassMode(value)
    }

  /**
   * The body's custom center of mass, relative to the body's origin position, when
   * [centerOfMassMode] is set to [CENTER_OF_MASS_MODE_CUSTOM]. This is the balanced point of the body,
   * where applied forces only cause linear acceleration. Applying forces outside of the center of mass
   * causes angular acceleration.
   *
   * When [centerOfMassMode] is set to [CENTER_OF_MASS_MODE_AUTO] (default value), the center of
   * mass is automatically determined, but this does not update the value of [centerOfMass].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var centerOfMass: Vector2
    @JvmName("centerOfMassProperty")
    get() = getCenterOfMass()
    @JvmName("centerOfMassProperty")
    set(`value`) {
      setCenterOfMass(value)
    }

  /**
   * The body's moment of inertia. This is like mass, but for rotation: it determines how much
   * torque it takes to rotate the body. The moment of inertia is usually computed automatically from
   * the mass and the shapes, but this property allows you to set a custom value.
   *
   * If set to `0`, inertia is automatically computed (default value).
   *
   * **Note:** This value does not change when inertia is automatically computed. Use
   * [PhysicsServer2D] to get the computed inertia.
   *
   * ```gdscript
   * //gdscript
   * @onready var ball = $Ball
   *
   * func get_ball_inertia():
   * 	return 1.0 / PhysicsServer2D.body_get_direct_state(ball.get_rid()).inverse_inertia
   * ```
   *
   * ```csharp
   * //csharp
   * private RigidBody2D _ball;
   *
   * public override void _Ready()
   * {
   * 	_ball = GetNode<RigidBody2D>("Ball");
   * }
   *
   * private float GetBallInertia()
   * {
   * 	return 1.0f / PhysicsServer2D.BodyGetDirectState(_ball.GetRid()).InverseInertia;
   * }
   * ```
   */
  public final inline var inertia: Float
    @JvmName("inertiaProperty")
    get() = getInertia()
    @JvmName("inertiaProperty")
    set(`value`) {
      setInertia(value)
    }

  /**
   * If `true`, the body will not move and will not calculate forces until woken up by another body
   * through, for example, a collision, or by using the [applyImpulse] or [applyForce] methods.
   */
  public final inline var sleeping: Boolean
    @JvmName("sleepingProperty")
    get() = isSleeping()
    @JvmName("sleepingProperty")
    set(`value`) {
      setSleeping(value)
    }

  /**
   * If `true`, the body can enter sleep mode when there is no movement. See [sleeping].
   */
  public final inline var canSleep: Boolean
    @JvmName("canSleepProperty")
    get() = isAbleToSleep()
    @JvmName("canSleepProperty")
    set(`value`) {
      setCanSleep(value)
    }

  /**
   * If `true`, the body cannot rotate. Gravity and forces only apply linear movement.
   */
  public final inline var lockRotation: Boolean
    @JvmName("lockRotationProperty")
    get() = isLockRotationEnabled()
    @JvmName("lockRotationProperty")
    set(`value`) {
      setLockRotationEnabled(value)
    }

  /**
   * If `true`, the body is frozen. Gravity and forces are not applied anymore.
   *
   * See [freezeMode] to set the body's behavior when frozen.
   *
   * **Note:** For a body that is always frozen, use [StaticBody2D] or [AnimatableBody2D] instead.
   */
  public final inline var freeze: Boolean
    @JvmName("freezeProperty")
    get() = isFreezeEnabled()
    @JvmName("freezeProperty")
    set(`value`) {
      setFreezeEnabled(value)
    }

  /**
   * The body's freeze mode. Determines the body's behavior when [freeze] is `true`.
   *
   * **Note:** For a body that is always frozen, use [StaticBody2D] or [AnimatableBody2D] instead.
   */
  public final inline var freezeMode: FreezeMode
    @JvmName("freezeModeProperty")
    get() = getFreezeMode()
    @JvmName("freezeModeProperty")
    set(`value`) {
      setFreezeMode(value)
    }

  /**
   * If `true`, the standard force integration (like gravity or damping) will be disabled for this
   * body. Other than collision response, the body will only move as determined by the
   * [_integrateForces] method, if that virtual method is overridden.
   *
   * Setting this property will call the method [PhysicsServer2D.bodySetOmitForceIntegration]
   * internally.
   */
  public final inline var customIntegrator: Boolean
    @JvmName("customIntegratorProperty")
    get() = isUsingCustomIntegrator()
    @JvmName("customIntegratorProperty")
    set(`value`) {
      setUseCustomIntegrator(value)
    }

  /**
   * Continuous collision detection mode.
   *
   * Continuous collision detection tries to predict where a moving body will collide instead of
   * moving it and correcting its movement after collision. Continuous collision detection is slower,
   * but more precise and misses fewer collisions with small, fast-moving objects. Raycasting and
   * shapecasting methods are available.
   */
  public final inline var continuousCd: CCDMode
    @JvmName("continuousCdProperty")
    get() = getContinuousCollisionDetectionMode()
    @JvmName("continuousCdProperty")
    set(`value`) {
      setContinuousCollisionDetectionMode(value)
    }

  /**
   * If `true`, the RigidBody2D will emit signals when it collides with another body.
   *
   * **Note:** By default the maximum contacts reported is set to 0, meaning nothing will be
   * recorded, see [maxContactsReported].
   */
  public final inline var contactMonitor: Boolean
    @JvmName("contactMonitorProperty")
    get() = isContactMonitorEnabled()
    @JvmName("contactMonitorProperty")
    set(`value`) {
      setContactMonitor(value)
    }

  /**
   * The maximum number of contacts that will be recorded. Requires a value greater than 0 and
   * [contactMonitor] to be set to `true` to start to register contacts. Use [getContactCount] to
   * retrieve the count or [getCollidingBodies] to retrieve bodies that have been collided with.
   *
   * **Note:** The number of contacts is different from the number of collisions. Collisions between
   * parallel edges will result in two contacts (one at each end), and collisions between parallel
   * faces will result in four contacts (one at each corner).
   */
  public final inline var maxContactsReported: Int
    @JvmName("maxContactsReportedProperty")
    get() = getMaxContactsReported()
    @JvmName("maxContactsReportedProperty")
    set(`value`) {
      setMaxContactsReported(value)
    }

  /**
   * The body's linear velocity in pixels per second. Can be used sporadically, but **don't set this
   * every frame**, because physics may run in another thread and runs at a different granularity. Use
   * [_integrateForces] as your process loop for precise control of the body state.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var linearVelocity: Vector2
    @JvmName("linearVelocityProperty")
    get() = getLinearVelocity()
    @JvmName("linearVelocityProperty")
    set(`value`) {
      setLinearVelocity(value)
    }

  /**
   * Defines how [linearDamp] is applied.
   */
  public final inline var linearDampMode: DampMode
    @JvmName("linearDampModeProperty")
    get() = getLinearDampMode()
    @JvmName("linearDampModeProperty")
    set(`value`) {
      setLinearDampMode(value)
    }

  /**
   * Damps the body's movement. By default, the body will use the
   * [ProjectSettings.physics/2d/defaultLinearDamp] setting or any value override set by an [Area2D]
   * the body is in. Depending on [linearDampMode], you can set [linearDamp] to be added to or to
   * replace the body's damping value.
   *
   * See [ProjectSettings.physics/2d/defaultLinearDamp] for more details about damping.
   */
  public final inline var linearDamp: Float
    @JvmName("linearDampProperty")
    get() = getLinearDamp()
    @JvmName("linearDampProperty")
    set(`value`) {
      setLinearDamp(value)
    }

  /**
   * The body's rotational velocity in *radians* per second.
   */
  public final inline var angularVelocity: Float
    @JvmName("angularVelocityProperty")
    get() = getAngularVelocity()
    @JvmName("angularVelocityProperty")
    set(`value`) {
      setAngularVelocity(value)
    }

  /**
   * Defines how [angularDamp] is applied.
   */
  public final inline var angularDampMode: DampMode
    @JvmName("angularDampModeProperty")
    get() = getAngularDampMode()
    @JvmName("angularDampModeProperty")
    set(`value`) {
      setAngularDampMode(value)
    }

  /**
   * Damps the body's rotation. By default, the body will use the
   * [ProjectSettings.physics/2d/defaultAngularDamp] setting or any value override set by an [Area2D]
   * the body is in. Depending on [angularDampMode], you can set [angularDamp] to be added to or to
   * replace the body's damping value.
   *
   * See [ProjectSettings.physics/2d/defaultAngularDamp] for more details about damping.
   */
  public final inline var angularDamp: Float
    @JvmName("angularDampProperty")
    get() = getAngularDamp()
    @JvmName("angularDampProperty")
    set(`value`) {
      setAngularDamp(value)
    }

  /**
   * The body's total constant positional forces applied during each physics update.
   *
   * See [addConstantForce] and [addConstantCentralForce].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constantForce: Vector2
    @JvmName("constantForceProperty")
    get() = getConstantForce()
    @JvmName("constantForceProperty")
    set(`value`) {
      setConstantForce(value)
    }

  /**
   * The body's total constant rotational forces applied during each physics update.
   *
   * See [addConstantTorque].
   */
  public final inline var constantTorque: Float
    @JvmName("constantTorqueProperty")
    get() = getConstantTorque()
    @JvmName("constantTorqueProperty")
    set(`value`) {
      setConstantTorque(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(633, scriptPtr)
  }

  /**
   * This is a helper function for [centerOfMass] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rigidbody2d.centerOfMass
   * //Your changes
   * rigidbody2d.centerOfMass = myCoreType
   * ``````
   *
   * The body's custom center of mass, relative to the body's origin position, when
   * [centerOfMassMode] is set to [CENTER_OF_MASS_MODE_CUSTOM]. This is the balanced point of the body,
   * where applied forces only cause linear acceleration. Applying forces outside of the center of mass
   * causes angular acceleration.
   *
   * When [centerOfMassMode] is set to [CENTER_OF_MASS_MODE_AUTO] (default value), the center of
   * mass is automatically determined, but this does not update the value of [centerOfMass].
   */
  @CoreTypeHelper
  public final fun centerOfMassMutate(block: Vector2.() -> Unit): Vector2 = centerOfMass.apply {
     block(this)
     centerOfMass = this
  }

  /**
   * This is a helper function for [linearVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rigidbody2d.linearVelocity
   * //Your changes
   * rigidbody2d.linearVelocity = myCoreType
   * ``````
   *
   * The body's linear velocity in pixels per second. Can be used sporadically, but **don't set this
   * every frame**, because physics may run in another thread and runs at a different granularity. Use
   * [_integrateForces] as your process loop for precise control of the body state.
   */
  @CoreTypeHelper
  public final fun linearVelocityMutate(block: Vector2.() -> Unit): Vector2 = linearVelocity.apply {
     block(this)
     linearVelocity = this
  }

  /**
   * This is a helper function for [constantForce] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rigidbody2d.constantForce
   * //Your changes
   * rigidbody2d.constantForce = myCoreType
   * ``````
   *
   * The body's total constant positional forces applied during each physics update.
   *
   * See [addConstantForce] and [addConstantCentralForce].
   */
  @CoreTypeHelper
  public final fun constantForceMutate(block: Vector2.() -> Unit): Vector2 = constantForce.apply {
     block(this)
     constantForce = this
  }

  /**
   * Called during physics processing, allowing you to read and safely modify the simulation state
   * for the object. By default, it is called before the standard force integration, but the
   * [customIntegrator] property allows you to disable the standard force integration and do fully
   * custom force integration for a body.
   */
  public open fun _integrateForces(state: PhysicsDirectBodyState2D): Unit {
    throw NotImplementedError("RigidBody2D::_integrateForces is not implemented.")
  }

  public final fun setMass(mass: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mass.toDouble())
    TransferContext.callMethod(MethodBindings.setMassPtr)
  }

  public final fun getMass(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMassPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getInertia(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInertiaPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setInertia(inertia: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to inertia.toDouble())
    TransferContext.callMethod(MethodBindings.setInertiaPtr)
  }

  public final fun setCenterOfMassMode(mode: CenterOfMassMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setCenterOfMassModePtr)
  }

  public final fun getCenterOfMassMode(): CenterOfMassMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterOfMassModePtr)
    return CenterOfMassMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCenterOfMass(centerOfMass: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to centerOfMass)
    TransferContext.callMethod(MethodBindings.setCenterOfMassPtr)
  }

  public final fun getCenterOfMass(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterOfMassPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setPhysicsMaterialOverride(physicsMaterialOverride: PhysicsMaterial?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to physicsMaterialOverride)
    TransferContext.callMethod(MethodBindings.setPhysicsMaterialOverridePtr)
  }

  public final fun getPhysicsMaterialOverride(): PhysicsMaterial? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsMaterialOverridePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsMaterial?)
  }

  public final fun setGravityScale(gravityScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to gravityScale.toDouble())
    TransferContext.callMethod(MethodBindings.setGravityScalePtr)
  }

  public final fun getGravityScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLinearDampMode(linearDampMode: DampMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to linearDampMode.value)
    TransferContext.callMethod(MethodBindings.setLinearDampModePtr)
  }

  public final fun getLinearDampMode(): DampMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearDampModePtr)
    return DampMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAngularDampMode(angularDampMode: DampMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to angularDampMode.value)
    TransferContext.callMethod(MethodBindings.setAngularDampModePtr)
  }

  public final fun getAngularDampMode(): DampMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularDampModePtr)
    return DampMode.from(TransferContext.readReturnValue(LONG) as Long)
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

  public final fun setAngularDamp(angularDamp: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to angularDamp.toDouble())
    TransferContext.callMethod(MethodBindings.setAngularDampPtr)
  }

  public final fun getAngularDamp(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularDampPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLinearVelocity(linearVelocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to linearVelocity)
    TransferContext.callMethod(MethodBindings.setLinearVelocityPtr)
  }

  public final fun getLinearVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setAngularVelocity(angularVelocity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to angularVelocity.toDouble())
    TransferContext.callMethod(MethodBindings.setAngularVelocityPtr)
  }

  public final fun getAngularVelocity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularVelocityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMaxContactsReported(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setMaxContactsReportedPtr)
  }

  public final fun getMaxContactsReported(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxContactsReportedPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of contacts this body has with other bodies. By default, this returns 0
   * unless bodies are configured to monitor contacts (see [contactMonitor]).
   *
   * **Note:** To retrieve the colliding bodies, use [getCollidingBodies].
   */
  public final fun getContactCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContactCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setUseCustomIntegrator(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseCustomIntegratorPtr)
  }

  public final fun isUsingCustomIntegrator(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingCustomIntegratorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setContactMonitor(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setContactMonitorPtr)
  }

  public final fun isContactMonitorEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isContactMonitorEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setContinuousCollisionDetectionMode(mode: CCDMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setContinuousCollisionDetectionModePtr)
  }

  public final fun getContinuousCollisionDetectionMode(): CCDMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getContinuousCollisionDetectionModePtr)
    return CCDMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the body's velocity on the given axis. The velocity in the given vector axis will be set
   * as the given vector length. This is useful for jumping behavior.
   */
  public final fun setAxisVelocity(axisVelocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to axisVelocity)
    TransferContext.callMethod(MethodBindings.setAxisVelocityPtr)
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
  public final fun applyCentralImpulse(impulse: Vector2 = Vector2(0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to impulse)
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
  public final fun applyImpulse(impulse: Vector2, position: Vector2 = Vector2(0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to impulse, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.applyImpulsePtr)
  }

  /**
   * Applies a rotational impulse to the body without affecting the position.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   *
   * **Note:** [inertia] is required for this to work. To have [inertia], an active
   * [CollisionShape2D] must be a child of the node, or you can manually set [inertia].
   */
  public final fun applyTorqueImpulse(torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.applyTorqueImpulsePtr)
  }

  /**
   * Applies a directional force without affecting rotation. A force is time dependent and meant to
   * be applied every physics update.
   *
   * This is equivalent to using [applyForce] at the body's center of mass.
   */
  public final fun applyCentralForce(force: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to force)
    TransferContext.callMethod(MethodBindings.applyCentralForcePtr)
  }

  /**
   * Applies a positioned force to the body. A force is time dependent and meant to be applied every
   * physics update.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  public final fun applyForce(force: Vector2, position: Vector2 = Vector2(0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to force, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.applyForcePtr)
  }

  /**
   * Applies a rotational force without affecting position. A force is time dependent and meant to
   * be applied every physics update.
   *
   * **Note:** [inertia] is required for this to work. To have [inertia], an active
   * [CollisionShape2D] must be a child of the node, or you can manually set [inertia].
   */
  public final fun applyTorque(torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.applyTorquePtr)
  }

  /**
   * Adds a constant directional force without affecting rotation that keeps being applied over time
   * until cleared with `constant_force = Vector2(0, 0)`.
   *
   * This is equivalent to using [addConstantForce] at the body's center of mass.
   */
  public final fun addConstantCentralForce(force: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to force)
    TransferContext.callMethod(MethodBindings.addConstantCentralForcePtr)
  }

  /**
   * Adds a constant positioned force to the body that keeps being applied over time until cleared
   * with `constant_force = Vector2(0, 0)`.
   *
   * [position] is the offset from the body origin in global coordinates.
   */
  @JvmOverloads
  public final fun addConstantForce(force: Vector2, position: Vector2 = Vector2(0, 0)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to force, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.addConstantForcePtr)
  }

  /**
   * Adds a constant rotational force without affecting position that keeps being applied over time
   * until cleared with `constant_torque = 0`.
   */
  public final fun addConstantTorque(torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.addConstantTorquePtr)
  }

  public final fun setConstantForce(force: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to force)
    TransferContext.callMethod(MethodBindings.setConstantForcePtr)
  }

  public final fun getConstantForce(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantForcePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setConstantTorque(torque: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to torque.toDouble())
    TransferContext.callMethod(MethodBindings.setConstantTorquePtr)
  }

  public final fun getConstantTorque(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantTorquePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSleeping(sleeping: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to sleeping)
    TransferContext.callMethod(MethodBindings.setSleepingPtr)
  }

  public final fun isSleeping(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSleepingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCanSleep(ableToSleep: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to ableToSleep)
    TransferContext.callMethod(MethodBindings.setCanSleepPtr)
  }

  public final fun isAbleToSleep(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAbleToSleepPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLockRotationEnabled(lockRotation: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to lockRotation)
    TransferContext.callMethod(MethodBindings.setLockRotationEnabledPtr)
  }

  public final fun isLockRotationEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLockRotationEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFreezeEnabled(freezeMode: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to freezeMode)
    TransferContext.callMethod(MethodBindings.setFreezeEnabledPtr)
  }

  public final fun isFreezeEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFreezeEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFreezeMode(freezeMode: FreezeMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to freezeMode.value)
    TransferContext.callMethod(MethodBindings.setFreezeModePtr)
  }

  public final fun getFreezeMode(): FreezeMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFreezeModePtr)
    return FreezeMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns a list of the bodies colliding with this one. Requires [contactMonitor] to be set to
   * `true` and [maxContactsReported] to be set high enough to detect all the collisions.
   *
   * **Note:** The result of this test is not immediate after moving objects. For performance, list
   * of collisions is updated once per frame and before the physics step. Consider using signals
   * instead.
   */
  public final fun getCollidingBodies(): VariantArray<Node2D> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollidingBodiesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Node2D>)
  }

  public enum class FreezeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Static body freeze mode (default). The body is not affected by gravity and forces. It can be
     * only moved by user code and doesn't collide with other bodies along its path.
     */
    STATIC(0),
    /**
     * Kinematic body freeze mode. Similar to [FREEZE_MODE_STATIC], but collides with other bodies
     * along its path when moved. Useful for a frozen body that needs to be animated.
     */
    KINEMATIC(1),
    ;

    public companion object {
      public fun from(`value`: Long): FreezeMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CenterOfMassMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * In this mode, the body's center of mass is calculated automatically based on its shapes. This
     * assumes that the shapes' origins are also their center of mass.
     */
    AUTO(0),
    /**
     * In this mode, the body's center of mass is set through [centerOfMass]. Defaults to the body's
     * origin position.
     */
    CUSTOM(1),
    ;

    public companion object {
      public fun from(`value`: Long): CenterOfMassMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class DampMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * In this mode, the body's damping value is added to any value set in areas or the default
     * value.
     */
    COMBINE(0),
    /**
     * In this mode, the body's damping value replaces any value set in areas or the default value.
     */
    REPLACE(1),
    ;

    public companion object {
      public fun from(`value`: Long): DampMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CCDMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Continuous collision detection disabled. This is the fastest way to detect body collisions,
     * but can miss small, fast-moving objects.
     */
    DISABLED(0),
    /**
     * Continuous collision detection enabled using raycasting. This is faster than shapecasting but
     * less precise.
     */
    CAST_RAY(1),
    /**
     * Continuous collision detection enabled using shapecasting. This is the slowest CCD method and
     * the most precise.
     */
    CAST_SHAPE(2),
    ;

    public companion object {
      public fun from(`value`: Long): CCDMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setMassName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_mass")

    @JvmField
    public val getMassName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_mass")

    @JvmField
    public val getInertiaName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_inertia")

    @JvmField
    public val setInertiaName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_inertia")

    @JvmField
    public val setCenterOfMassModeName: MethodStringName1<RigidBody2D, Unit, CenterOfMassMode> =
        MethodStringName1<RigidBody2D, Unit, CenterOfMassMode>("set_center_of_mass_mode")

    @JvmField
    public val getCenterOfMassModeName: MethodStringName0<RigidBody2D, CenterOfMassMode> =
        MethodStringName0<RigidBody2D, CenterOfMassMode>("get_center_of_mass_mode")

    @JvmField
    public val setCenterOfMassName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("set_center_of_mass")

    @JvmField
    public val getCenterOfMassName: MethodStringName0<RigidBody2D, Vector2> =
        MethodStringName0<RigidBody2D, Vector2>("get_center_of_mass")

    @JvmField
    public val setPhysicsMaterialOverrideName:
        MethodStringName1<RigidBody2D, Unit, PhysicsMaterial?> =
        MethodStringName1<RigidBody2D, Unit, PhysicsMaterial?>("set_physics_material_override")

    @JvmField
    public val getPhysicsMaterialOverrideName: MethodStringName0<RigidBody2D, PhysicsMaterial?> =
        MethodStringName0<RigidBody2D, PhysicsMaterial?>("get_physics_material_override")

    @JvmField
    public val setGravityScaleName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_gravity_scale")

    @JvmField
    public val getGravityScaleName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_gravity_scale")

    @JvmField
    public val setLinearDampModeName: MethodStringName1<RigidBody2D, Unit, DampMode> =
        MethodStringName1<RigidBody2D, Unit, DampMode>("set_linear_damp_mode")

    @JvmField
    public val getLinearDampModeName: MethodStringName0<RigidBody2D, DampMode> =
        MethodStringName0<RigidBody2D, DampMode>("get_linear_damp_mode")

    @JvmField
    public val setAngularDampModeName: MethodStringName1<RigidBody2D, Unit, DampMode> =
        MethodStringName1<RigidBody2D, Unit, DampMode>("set_angular_damp_mode")

    @JvmField
    public val getAngularDampModeName: MethodStringName0<RigidBody2D, DampMode> =
        MethodStringName0<RigidBody2D, DampMode>("get_angular_damp_mode")

    @JvmField
    public val setLinearDampName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_linear_damp")

    @JvmField
    public val getLinearDampName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_linear_damp")

    @JvmField
    public val setAngularDampName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_angular_damp")

    @JvmField
    public val getAngularDampName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_angular_damp")

    @JvmField
    public val setLinearVelocityName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("set_linear_velocity")

    @JvmField
    public val getLinearVelocityName: MethodStringName0<RigidBody2D, Vector2> =
        MethodStringName0<RigidBody2D, Vector2>("get_linear_velocity")

    @JvmField
    public val setAngularVelocityName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_angular_velocity")

    @JvmField
    public val getAngularVelocityName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_angular_velocity")

    @JvmField
    public val setMaxContactsReportedName: MethodStringName1<RigidBody2D, Unit, Int> =
        MethodStringName1<RigidBody2D, Unit, Int>("set_max_contacts_reported")

    @JvmField
    public val getMaxContactsReportedName: MethodStringName0<RigidBody2D, Int> =
        MethodStringName0<RigidBody2D, Int>("get_max_contacts_reported")

    @JvmField
    public val getContactCountName: MethodStringName0<RigidBody2D, Int> =
        MethodStringName0<RigidBody2D, Int>("get_contact_count")

    @JvmField
    public val setUseCustomIntegratorName: MethodStringName1<RigidBody2D, Unit, Boolean> =
        MethodStringName1<RigidBody2D, Unit, Boolean>("set_use_custom_integrator")

    @JvmField
    public val isUsingCustomIntegratorName: MethodStringName0<RigidBody2D, Boolean> =
        MethodStringName0<RigidBody2D, Boolean>("is_using_custom_integrator")

    @JvmField
    public val setContactMonitorName: MethodStringName1<RigidBody2D, Unit, Boolean> =
        MethodStringName1<RigidBody2D, Unit, Boolean>("set_contact_monitor")

    @JvmField
    public val isContactMonitorEnabledName: MethodStringName0<RigidBody2D, Boolean> =
        MethodStringName0<RigidBody2D, Boolean>("is_contact_monitor_enabled")

    @JvmField
    public val setContinuousCollisionDetectionModeName:
        MethodStringName1<RigidBody2D, Unit, CCDMode> =
        MethodStringName1<RigidBody2D, Unit, CCDMode>("set_continuous_collision_detection_mode")

    @JvmField
    public val getContinuousCollisionDetectionModeName: MethodStringName0<RigidBody2D, CCDMode> =
        MethodStringName0<RigidBody2D, CCDMode>("get_continuous_collision_detection_mode")

    @JvmField
    public val setAxisVelocityName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("set_axis_velocity")

    @JvmField
    public val applyCentralImpulseName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("apply_central_impulse")

    @JvmField
    public val applyImpulseName: MethodStringName2<RigidBody2D, Unit, Vector2, Vector2> =
        MethodStringName2<RigidBody2D, Unit, Vector2, Vector2>("apply_impulse")

    @JvmField
    public val applyTorqueImpulseName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("apply_torque_impulse")

    @JvmField
    public val applyCentralForceName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("apply_central_force")

    @JvmField
    public val applyForceName: MethodStringName2<RigidBody2D, Unit, Vector2, Vector2> =
        MethodStringName2<RigidBody2D, Unit, Vector2, Vector2>("apply_force")

    @JvmField
    public val applyTorqueName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("apply_torque")

    @JvmField
    public val addConstantCentralForceName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("add_constant_central_force")

    @JvmField
    public val addConstantForceName: MethodStringName2<RigidBody2D, Unit, Vector2, Vector2> =
        MethodStringName2<RigidBody2D, Unit, Vector2, Vector2>("add_constant_force")

    @JvmField
    public val addConstantTorqueName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("add_constant_torque")

    @JvmField
    public val setConstantForceName: MethodStringName1<RigidBody2D, Unit, Vector2> =
        MethodStringName1<RigidBody2D, Unit, Vector2>("set_constant_force")

    @JvmField
    public val getConstantForceName: MethodStringName0<RigidBody2D, Vector2> =
        MethodStringName0<RigidBody2D, Vector2>("get_constant_force")

    @JvmField
    public val setConstantTorqueName: MethodStringName1<RigidBody2D, Unit, Float> =
        MethodStringName1<RigidBody2D, Unit, Float>("set_constant_torque")

    @JvmField
    public val getConstantTorqueName: MethodStringName0<RigidBody2D, Float> =
        MethodStringName0<RigidBody2D, Float>("get_constant_torque")

    @JvmField
    public val setSleepingName: MethodStringName1<RigidBody2D, Unit, Boolean> =
        MethodStringName1<RigidBody2D, Unit, Boolean>("set_sleeping")

    @JvmField
    public val isSleepingName: MethodStringName0<RigidBody2D, Boolean> =
        MethodStringName0<RigidBody2D, Boolean>("is_sleeping")

    @JvmField
    public val setCanSleepName: MethodStringName1<RigidBody2D, Unit, Boolean> =
        MethodStringName1<RigidBody2D, Unit, Boolean>("set_can_sleep")

    @JvmField
    public val isAbleToSleepName: MethodStringName0<RigidBody2D, Boolean> =
        MethodStringName0<RigidBody2D, Boolean>("is_able_to_sleep")

    @JvmField
    public val setLockRotationEnabledName: MethodStringName1<RigidBody2D, Unit, Boolean> =
        MethodStringName1<RigidBody2D, Unit, Boolean>("set_lock_rotation_enabled")

    @JvmField
    public val isLockRotationEnabledName: MethodStringName0<RigidBody2D, Boolean> =
        MethodStringName0<RigidBody2D, Boolean>("is_lock_rotation_enabled")

    @JvmField
    public val setFreezeEnabledName: MethodStringName1<RigidBody2D, Unit, Boolean> =
        MethodStringName1<RigidBody2D, Unit, Boolean>("set_freeze_enabled")

    @JvmField
    public val isFreezeEnabledName: MethodStringName0<RigidBody2D, Boolean> =
        MethodStringName0<RigidBody2D, Boolean>("is_freeze_enabled")

    @JvmField
    public val setFreezeModeName: MethodStringName1<RigidBody2D, Unit, FreezeMode> =
        MethodStringName1<RigidBody2D, Unit, FreezeMode>("set_freeze_mode")

    @JvmField
    public val getFreezeModeName: MethodStringName0<RigidBody2D, FreezeMode> =
        MethodStringName0<RigidBody2D, FreezeMode>("get_freeze_mode")

    @JvmField
    public val getCollidingBodiesName: MethodStringName0<RigidBody2D, VariantArray<Node2D>> =
        MethodStringName0<RigidBody2D, VariantArray<Node2D>>("get_colliding_bodies")
  }

  public object MethodBindings {
    internal val setMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_mass", 373806689)

    internal val getMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_mass", 1740695150)

    internal val getInertiaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_inertia", 1740695150)

    internal val setInertiaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_inertia", 373806689)

    internal val setCenterOfMassModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_center_of_mass_mode", 1757235706)

    internal val getCenterOfMassModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_center_of_mass_mode", 3277132817)

    internal val setCenterOfMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_center_of_mass", 743155724)

    internal val getCenterOfMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_center_of_mass", 3341600327)

    internal val setPhysicsMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_physics_material_override", 1784508650)

    internal val getPhysicsMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_physics_material_override", 2521850424)

    internal val setGravityScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_gravity_scale", 373806689)

    internal val getGravityScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_gravity_scale", 1740695150)

    internal val setLinearDampModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_linear_damp_mode", 3406533708)

    internal val getLinearDampModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_linear_damp_mode", 2970511462)

    internal val setAngularDampModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_angular_damp_mode", 3406533708)

    internal val getAngularDampModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_angular_damp_mode", 2970511462)

    internal val setLinearDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_linear_damp", 373806689)

    internal val getLinearDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_linear_damp", 1740695150)

    internal val setAngularDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_angular_damp", 373806689)

    internal val getAngularDampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_angular_damp", 1740695150)

    internal val setLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_linear_velocity", 743155724)

    internal val getLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_linear_velocity", 3341600327)

    internal val setAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_angular_velocity", 373806689)

    internal val getAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_angular_velocity", 1740695150)

    internal val setMaxContactsReportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_max_contacts_reported", 1286410249)

    internal val getMaxContactsReportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_max_contacts_reported", 3905245786)

    internal val getContactCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_contact_count", 3905245786)

    internal val setUseCustomIntegratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_use_custom_integrator", 2586408642)

    internal val isUsingCustomIntegratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "is_using_custom_integrator", 2240911060)

    internal val setContactMonitorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_contact_monitor", 2586408642)

    internal val isContactMonitorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "is_contact_monitor_enabled", 36873697)

    internal val setContinuousCollisionDetectionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_continuous_collision_detection_mode", 1000241384)

    internal val getContinuousCollisionDetectionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_continuous_collision_detection_mode", 815214376)

    internal val setAxisVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_axis_velocity", 743155724)

    internal val applyCentralImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "apply_central_impulse", 3862383994)

    internal val applyImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "apply_impulse", 4288681949)

    internal val applyTorqueImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "apply_torque_impulse", 373806689)

    internal val applyCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "apply_central_force", 743155724)

    internal val applyForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "apply_force", 4288681949)

    internal val applyTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "apply_torque", 373806689)

    internal val addConstantCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "add_constant_central_force", 743155724)

    internal val addConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "add_constant_force", 4288681949)

    internal val addConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "add_constant_torque", 373806689)

    internal val setConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_constant_force", 743155724)

    internal val getConstantForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_constant_force", 3341600327)

    internal val setConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_constant_torque", 373806689)

    internal val getConstantTorquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_constant_torque", 1740695150)

    internal val setSleepingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_sleeping", 2586408642)

    internal val isSleepingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "is_sleeping", 36873697)

    internal val setCanSleepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_can_sleep", 2586408642)

    internal val isAbleToSleepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "is_able_to_sleep", 36873697)

    internal val setLockRotationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_lock_rotation_enabled", 2586408642)

    internal val isLockRotationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "is_lock_rotation_enabled", 36873697)

    internal val setFreezeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_freeze_enabled", 2586408642)

    internal val isFreezeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "is_freeze_enabled", 36873697)

    internal val setFreezeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "set_freeze_mode", 1705112154)

    internal val getFreezeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_freeze_mode", 2016872314)

    internal val getCollidingBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RigidBody2D", "get_colliding_bodies", 3995934104)
  }
}
