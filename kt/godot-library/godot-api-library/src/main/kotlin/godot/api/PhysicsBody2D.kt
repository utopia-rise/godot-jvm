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
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.Vector2
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_DOUBLE_BOOL
import godot.writeMethodArguments_VECTOR2_BOOL_DOUBLE_BOOL
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * [PhysicsBody2D] is an abstract base class for 2D game objects affected by physics. All 2D physics
 * bodies inherit from it.
 */
@GodotBaseType
public open class PhysicsBody2D internal constructor() : CollisionObject2D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(523, scriptPtr)
  }

  /**
   * Moves the body along the vector [motion]. In order to be frame rate independent in
   * [Node.PhysicsProcess] or [Node.Process], [motion] should be computed using `delta`.
   *
   * Returns a [KinematicCollision2D], which contains information about the collision when stopped,
   * or when touching another body along the motion.
   *
   * If [testOnly] is `true`, the body does not move but the would-be collision information is
   * given.
   *
   * [safeMargin] is the extra margin used for collision recovery (see [CharacterBody2D.safeMargin]
   * for more details).
   *
   * If [recoveryAsCollision] is `true`, any depenetration from the recovery phase is also reported
   * as a collision; this is used e.g. by [CharacterBody2D] for improving floor detection during floor
   * snapping.
   */
  @JvmOverloads
  public final fun moveAndCollide(
    motion: Vector2,
    testOnly: Boolean = false,
    safeMargin: Float = 0.08f,
    recoveryAsCollision: Boolean = false,
  ): KinematicCollision2D? {
    TransferContext.writeMethodArguments_VECTOR2_BOOL_DOUBLE_BOOL(ptr, objectID.id, motion, testOnly, safeMargin.toDouble(), recoveryAsCollision)
    TransferContext.callPtrMethod(MethodBindings.moveAndCollidePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as KinematicCollision2D?)
  }

  /**
   * Checks for collisions without moving the body. In order to be frame rate independent in
   * [Node.PhysicsProcess] or [Node.Process], [motion] should be computed using `delta`.
   *
   * Virtually sets the node's position, scale and rotation to that of the given [Transform2D], then
   * tries to move the body along the vector [motion]. Returns `true` if a collision would stop the
   * body from moving along the whole path.
   *
   * [collision] is an optional object of type [KinematicCollision2D], which contains additional
   * information about the collision when stopped, or when touching another body along the motion.
   *
   * [safeMargin] is the extra margin used for collision recovery (see [CharacterBody2D.safeMargin]
   * for more details).
   *
   * If [recoveryAsCollision] is `true`, any depenetration from the recovery phase is also reported
   * as a collision; this is useful for checking whether the body would *touch* any other bodies.
   */
  @JvmOverloads
  public final fun testMove(
    from: Transform2D,
    motion: Vector2,
    collision: KinematicCollision2D? = null,
    safeMargin: Float = 0.08f,
    recoveryAsCollision: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_DOUBLE_BOOL(ptr, objectID.id, from, motion, collision, safeMargin.toDouble(), recoveryAsCollision)
    TransferContext.callPtrMethod(MethodBindings.testMovePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the gravity vector computed from all sources that can affect the body, including all
   * gravity overrides from [Area2D] nodes and the global world gravity.
   */
  public final fun getGravity(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGravityPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns an array of nodes that were added as collision exceptions for this body.
   */
  public final fun getCollisionExceptions(): VariantArray<PhysicsBody2D> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionExceptionsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<PhysicsBody2D>)
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
        MethodStringName4<PhysicsBody2D, KinematicCollision2D?, Vector2, Boolean, Float, Boolean> =
        MethodStringName4<PhysicsBody2D, KinematicCollision2D?, Vector2, Boolean, Float, Boolean>("move_and_collide")

    @JvmField
    public val testMoveName:
        MethodStringName5<PhysicsBody2D, Boolean, Transform2D, Vector2, KinematicCollision2D?, Float, Boolean>
        =
        MethodStringName5<PhysicsBody2D, Boolean, Transform2D, Vector2, KinematicCollision2D?, Float, Boolean>("test_move")

    @JvmField
    public val getGravityName: MethodStringName0<PhysicsBody2D, Vector2> =
        MethodStringName0<PhysicsBody2D, Vector2>("get_gravity")

    @JvmField
    public val getCollisionExceptionsName:
        MethodStringName0<PhysicsBody2D, VariantArray<PhysicsBody2D>> =
        MethodStringName0<PhysicsBody2D, VariantArray<PhysicsBody2D>>("get_collision_exceptions")

    @JvmField
    public val addCollisionExceptionWithName: MethodStringName1<PhysicsBody2D, Unit, Node> =
        MethodStringName1<PhysicsBody2D, Unit, Node>("add_collision_exception_with")

    @JvmField
    public val removeCollisionExceptionWithName: MethodStringName1<PhysicsBody2D, Unit, Node> =
        MethodStringName1<PhysicsBody2D, Unit, Node>("remove_collision_exception_with")
  }

  public object MethodBindings {
    internal val moveAndCollidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody2D", "move_and_collide", 3681923724)

    internal val testMovePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody2D", "test_move", 3324464701)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody2D", "get_gravity", 3341600327)

    internal val getCollisionExceptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody2D", "get_collision_exceptions", 2915620761)

    internal val addCollisionExceptionWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody2D", "add_collision_exception_with", 1078189570)

    internal val removeCollisionExceptionWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsBody2D", "remove_collision_exception_with", 1078189570)
  }
}
