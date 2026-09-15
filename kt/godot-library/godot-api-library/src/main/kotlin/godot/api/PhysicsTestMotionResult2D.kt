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
import godot.core.RID
import godot.core.Vector2
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Describes the motion and collision result from [PhysicsServer2D.bodyTestMotion].
 */
@GodotBaseType
public open class PhysicsTestMotionResult2D : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(547, scriptPtr)
  }

  /**
   * Returns the moving object's travel before collision.
   */
  public final fun getTravel(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTravelPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the moving object's remaining movement vector.
   */
  public final fun getRemainder(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRemainderPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the point of collision in global coordinates, if a collision occurred.
   */
  public final fun getCollisionPoint(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionPointPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the colliding body's shape's normal at the point of collision, if a collision occurred.
   */
  public final fun getCollisionNormal(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionNormalPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the colliding body's velocity, if a collision occurred.
   */
  public final fun getColliderVelocity(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderVelocityPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the unique instance ID of the colliding body's attached [Object], if a collision
   * occurred. See [Object.getInstanceId].
   */
  public final fun getColliderId(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderIdPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns the colliding body's [RID] used by the [PhysicsServer2D], if a collision occurred.
   */
  public final fun getColliderRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the colliding body's attached [Object], if a collision occurred.
   */
  public final fun getCollider(): Object? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Object?)
  }

  /**
   * Returns the colliding body's shape index, if a collision occurred. See [CollisionObject2D].
   */
  public final fun getColliderShape(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderShapePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the moving object's colliding shape, if a collision occurred.
   */
  public final fun getCollisionLocalShape(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionLocalShapePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the length of overlap along the collision normal, if a collision occurred.
   */
  public final fun getCollisionDepth(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionDepthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the maximum fraction of the motion that can occur without a collision, between `0` and
   * `1`.
   */
  public final fun getCollisionSafeFraction(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionSafeFractionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the minimum fraction of the motion needed to collide, if a collision occurred, between
   * `0` and `1`.
   */
  public final fun getCollisionUnsafeFraction(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionUnsafeFractionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val getTravelName: MethodStringName0<PhysicsTestMotionResult2D, Vector2> =
        MethodStringName0<PhysicsTestMotionResult2D, Vector2>("get_travel")

    @JvmField
    public val getRemainderName: MethodStringName0<PhysicsTestMotionResult2D, Vector2> =
        MethodStringName0<PhysicsTestMotionResult2D, Vector2>("get_remainder")

    @JvmField
    public val getCollisionPointName: MethodStringName0<PhysicsTestMotionResult2D, Vector2> =
        MethodStringName0<PhysicsTestMotionResult2D, Vector2>("get_collision_point")

    @JvmField
    public val getCollisionNormalName: MethodStringName0<PhysicsTestMotionResult2D, Vector2> =
        MethodStringName0<PhysicsTestMotionResult2D, Vector2>("get_collision_normal")

    @JvmField
    public val getColliderVelocityName: MethodStringName0<PhysicsTestMotionResult2D, Vector2> =
        MethodStringName0<PhysicsTestMotionResult2D, Vector2>("get_collider_velocity")

    @JvmField
    public val getColliderIdName: MethodStringName0<PhysicsTestMotionResult2D, Long> =
        MethodStringName0<PhysicsTestMotionResult2D, Long>("get_collider_id")

    @JvmField
    public val getColliderRidName: MethodStringName0<PhysicsTestMotionResult2D, RID> =
        MethodStringName0<PhysicsTestMotionResult2D, RID>("get_collider_rid")

    @JvmField
    public val getColliderName: MethodStringName0<PhysicsTestMotionResult2D, Object?> =
        MethodStringName0<PhysicsTestMotionResult2D, Object?>("get_collider")

    @JvmField
    public val getColliderShapeName: MethodStringName0<PhysicsTestMotionResult2D, Int> =
        MethodStringName0<PhysicsTestMotionResult2D, Int>("get_collider_shape")

    @JvmField
    public val getCollisionLocalShapeName: MethodStringName0<PhysicsTestMotionResult2D, Int> =
        MethodStringName0<PhysicsTestMotionResult2D, Int>("get_collision_local_shape")

    @JvmField
    public val getCollisionDepthName: MethodStringName0<PhysicsTestMotionResult2D, Float> =
        MethodStringName0<PhysicsTestMotionResult2D, Float>("get_collision_depth")

    @JvmField
    public val getCollisionSafeFractionName: MethodStringName0<PhysicsTestMotionResult2D, Float> =
        MethodStringName0<PhysicsTestMotionResult2D, Float>("get_collision_safe_fraction")

    @JvmField
    public val getCollisionUnsafeFractionName: MethodStringName0<PhysicsTestMotionResult2D, Float> =
        MethodStringName0<PhysicsTestMotionResult2D, Float>("get_collision_unsafe_fraction")
  }

  public object MethodBindings {
    internal val getTravelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_travel", 3341600327)

    internal val getRemainderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_remainder", 3341600327)

    internal val getCollisionPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collision_point", 3341600327)

    internal val getCollisionNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collision_normal", 3341600327)

    internal val getColliderVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collider_velocity", 3341600327)

    internal val getColliderIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collider_id", 3905245786)

    internal val getColliderRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collider_rid", 2944877500)

    internal val getColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collider", 1981248198)

    internal val getColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collider_shape", 3905245786)

    internal val getCollisionLocalShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collision_local_shape", 3905245786)

    internal val getCollisionDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collision_depth", 1740695150)

    internal val getCollisionSafeFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collision_safe_fraction", 1740695150)

    internal val getCollisionUnsafeFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult2D", "get_collision_unsafe_fraction", 1740695150)
  }
}
