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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector3
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_TRANSFORM3D_VECTOR3_OBJECT_DOUBLE_BOOL_LONG
import godot.writeMethodArguments_VECTOR3_BOOL_DOUBLE_BOOL_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [PhysicsBody3D] is an abstract base class for 3D game objects affected by physics. All 3D physics
 * bodies inherit from it.
 *
 * **Warning:** With a non-uniform scale, this node will likely not behave as expected. It is
 * advised to keep its scale the same on all axes and adjust its collision shape(s) instead.
 */
@GodotBaseType
public open class PhysicsBody3D internal constructor() : CollisionObject3D() {
  /**
   * Lock the body's linear movement in the X axis.
   */
  public final inline var axisLockLinearX: Boolean
    @JvmName("axisLockLinearXProperty")
    get() = getAxisLock(PhysicsServer3D.BodyAxis.LINEAR_X)
    @JvmName("axisLockLinearXProperty")
    set(`value`) {
      setAxisLock(PhysicsServer3D.BodyAxis.LINEAR_X, value)
    }

  /**
   * Lock the body's linear movement in the Y axis.
   */
  public final inline var axisLockLinearY: Boolean
    @JvmName("axisLockLinearYProperty")
    get() = getAxisLock(PhysicsServer3D.BodyAxis.LINEAR_Y)
    @JvmName("axisLockLinearYProperty")
    set(`value`) {
      setAxisLock(PhysicsServer3D.BodyAxis.LINEAR_Y, value)
    }

  /**
   * Lock the body's linear movement in the Z axis.
   */
  public final inline var axisLockLinearZ: Boolean
    @JvmName("axisLockLinearZProperty")
    get() = getAxisLock(PhysicsServer3D.BodyAxis.LINEAR_Z)
    @JvmName("axisLockLinearZProperty")
    set(`value`) {
      setAxisLock(PhysicsServer3D.BodyAxis.LINEAR_Z, value)
    }

  /**
   * Lock the body's rotation in the X axis.
   */
  public final inline var axisLockAngularX: Boolean
    @JvmName("axisLockAngularXProperty")
    get() = getAxisLock(PhysicsServer3D.BodyAxis.ANGULAR_X)
    @JvmName("axisLockAngularXProperty")
    set(`value`) {
      setAxisLock(PhysicsServer3D.BodyAxis.ANGULAR_X, value)
    }

  /**
   * Lock the body's rotation in the Y axis.
   */
  public final inline var axisLockAngularY: Boolean
    @JvmName("axisLockAngularYProperty")
    get() = getAxisLock(PhysicsServer3D.BodyAxis.ANGULAR_Y)
    @JvmName("axisLockAngularYProperty")
    set(`value`) {
      setAxisLock(PhysicsServer3D.BodyAxis.ANGULAR_Y, value)
    }

  /**
   * Lock the body's rotation in the Z axis.
   */
  public final inline var axisLockAngularZ: Boolean
    @JvmName("axisLockAngularZProperty")
    get() = getAxisLock(PhysicsServer3D.BodyAxis.ANGULAR_Z)
    @JvmName("axisLockAngularZProperty")
    set(`value`) {
      setAxisLock(PhysicsServer3D.BodyAxis.ANGULAR_Z, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(524, scriptPtr)
  }

  /**
   * Moves the body along the vector [motion]. In order to be frame rate independent in
   * [Node.PhysicsProcess] or [Node.Process], [motion] should be computed using `delta`.
   *
   * The body will stop if it collides. Returns a [KinematicCollision3D], which contains information
   * about the collision when stopped, or when touching another body along the motion.
   *
   * If [testOnly] is `true`, the body does not move but the would-be collision information is
   * given.
   *
   * [safeMargin] is the extra margin used for collision recovery (see [CharacterBody3D.safeMargin]
   * for more details).
   *
   * If [recoveryAsCollision] is `true`, any depenetration from the recovery phase is also reported
   * as a collision; this is used e.g. by [CharacterBody3D] for improving floor detection during floor
   * snapping.
   *
   * [maxCollisions] allows to retrieve more than one collision result.
   */
  @JvmOverloads
  public final fun moveAndCollide(
    motion: Vector3,
    testOnly: Boolean = false,
    safeMargin: Float = 0.001f,
    recoveryAsCollision: Boolean = false,
    maxCollisions: Int = 1,
  ): KinematicCollision3D? {
    TransferContext.writeMethodArguments_VECTOR3_BOOL_DOUBLE_BOOL_LONG(ptr, objectID.id, motion, testOnly, safeMargin.toDouble(), recoveryAsCollision, maxCollisions.toLong())
    TransferContext.callPtrMethod(MethodBindings.moveAndCollidePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as KinematicCollision3D?)
  }

  /**
   * Checks for collisions without moving the body. In order to be frame rate independent in
   * [Node.PhysicsProcess] or [Node.Process], [motion] should be computed using `delta`.
   *
   * Virtually sets the node's position, scale and rotation to that of the given [Transform3D], then
   * tries to move the body along the vector [motion]. Returns `true` if a collision would stop the
   * body from moving along the whole path.
   *
   * [collision] is an optional object of type [KinematicCollision3D], which contains additional
   * information about the collision when stopped, or when touching another body along the motion.
   *
   * [safeMargin] is the extra margin used for collision recovery (see [CharacterBody3D.safeMargin]
   * for more details).
   *
   * If [recoveryAsCollision] is `true`, any depenetration from the recovery phase is also reported
   * as a collision; this is useful for checking whether the body would *touch* any other bodies.
   *
   * [maxCollisions] allows to retrieve more than one collision result.
   */
  @JvmOverloads
  public final fun testMove(
    from: Transform3D,
    motion: Vector3,
    collision: KinematicCollision3D? = null,
    safeMargin: Float = 0.001f,
    recoveryAsCollision: Boolean = false,
    maxCollisions: Int = 1,
  ): Boolean {
    TransferContext.writeMethodArguments_TRANSFORM3D_VECTOR3_OBJECT_DOUBLE_BOOL_LONG(ptr, objectID.id, from, motion, collision, safeMargin.toDouble(), recoveryAsCollision, maxCollisions.toLong())
    TransferContext.callPtrMethod(MethodBindings.testMovePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the gravity vector computed from all sources that can affect the body, including all
   * gravity overrides from [Area3D] nodes and the global world gravity.
   */
  public final fun getGravity(): Vector3 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGravityPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Locks or unlocks the specified linear or rotational [axis] depending on the value of [lock].
   */
  public final fun setAxisLock(axis: PhysicsServer3D.BodyAxis, lock: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, axis.value, lock)
    TransferContext.callPtrMethod(MethodBindings.setAxisLockPtr, 0)
  }

  /**
   * Returns `true` if the specified linear or rotational [axis] is locked.
   */
  public final fun getAxisLock(axis: PhysicsServer3D.BodyAxis): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, axis.value)
    TransferContext.callPtrMethod(MethodBindings.getAxisLockPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns an array of nodes that were added as collision exceptions for this body.
   */
  public final fun getCollisionExceptions(): VariantArray<PhysicsBody3D> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionExceptionsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<PhysicsBody3D>)
  }

  /**
   * Adds a body to the list of bodies that this body can't collide with.
   */
  public final fun addCollisionExceptionWith(body: Node): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, body)
    TransferContext.callPtrMethod(MethodBindings.addCollisionExceptionWithPtr, 0)
  }

  /**
   * Removes a body from the list of bodies that this body can't collide with.
   */
  public final fun removeCollisionExceptionWith(body: Node): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, body)
    TransferContext.callPtrMethod(MethodBindings.removeCollisionExceptionWithPtr, 0)
  }

  public companion object {
    @JvmField
    public val moveAndCollideName:
        MethodStringName5<PhysicsBody3D, KinematicCollision3D?, Vector3, Boolean, Float, Boolean, Int>
        =
        MethodStringName5<PhysicsBody3D, KinematicCollision3D?, Vector3, Boolean, Float, Boolean, Int>("move_and_collide")

    @JvmField
    public val testMoveName:
        MethodStringName6<PhysicsBody3D, Boolean, Transform3D, Vector3, KinematicCollision3D?, Float, Boolean, Int>
        =
        MethodStringName6<PhysicsBody3D, Boolean, Transform3D, Vector3, KinematicCollision3D?, Float, Boolean, Int>("test_move")

    @JvmField
    public val getGravityName: MethodStringName0<PhysicsBody3D, Vector3> =
        MethodStringName0<PhysicsBody3D, Vector3>("get_gravity")

    @JvmField
    public val setAxisLockName:
        MethodStringName2<PhysicsBody3D, Unit, PhysicsServer3D.BodyAxis, Boolean> =
        MethodStringName2<PhysicsBody3D, Unit, PhysicsServer3D.BodyAxis, Boolean>("set_axis_lock")

    @JvmField
    public val getAxisLockName: MethodStringName1<PhysicsBody3D, Boolean, PhysicsServer3D.BodyAxis>
        = MethodStringName1<PhysicsBody3D, Boolean, PhysicsServer3D.BodyAxis>("get_axis_lock")

    @JvmField
    public val getCollisionExceptionsName:
        MethodStringName0<PhysicsBody3D, VariantArray<PhysicsBody3D>> =
        MethodStringName0<PhysicsBody3D, VariantArray<PhysicsBody3D>>("get_collision_exceptions")

    @JvmField
    public val addCollisionExceptionWithName: MethodStringName1<PhysicsBody3D, Unit, Node> =
        MethodStringName1<PhysicsBody3D, Unit, Node>("add_collision_exception_with")

    @JvmField
    public val removeCollisionExceptionWithName: MethodStringName1<PhysicsBody3D, Unit, Node> =
        MethodStringName1<PhysicsBody3D, Unit, Node>("remove_collision_exception_with")
  }

  public object MethodBindings {
    internal val moveAndCollidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "move_and_collide", 3208792678)

    internal val testMovePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "test_move", 2481691619)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "get_gravity", 3360562783)

    internal val setAxisLockPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "set_axis_lock", 1787895195)

    internal val getAxisLockPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "get_axis_lock", 2264617709)

    internal val getCollisionExceptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "get_collision_exceptions", 2915620761)

    internal val addCollisionExceptionWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "add_collision_exception_with", 1078189570)

    internal val removeCollisionExceptionWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody3D", "remove_collision_exception_with", 1078189570)
  }
}
