// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_VECTOR3
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_OBJECT
import godot.callPtrMethod_LONG_ret_RID
import godot.callPtrMethod_LONG_ret_VECTOR3
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Vector3
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Describes the motion and collision result from [PhysicsServer3D.bodyTestMotion].
 */
@GodotBaseType
public open class PhysicsTestMotionResult3D : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(548, scriptPtr)
  }

  /**
   * Returns the moving object's travel before collision.
   */
  public final fun getTravel(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getTravelPtr)

  /**
   * Returns the moving object's remaining movement vector.
   */
  public final fun getRemainder(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getRemainderPtr)

  /**
   * Returns the maximum fraction of the motion that can occur without a collision, between `0` and
   * `1`.
   */
  public final fun getCollisionSafeFraction(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCollisionSafeFractionPtr).toFloat()

  /**
   * Returns the minimum fraction of the motion needed to collide, if a collision occurred, between
   * `0` and `1`.
   */
  public final fun getCollisionUnsafeFraction(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCollisionUnsafeFractionPtr).toFloat()

  /**
   * Returns the number of detected collisions.
   */
  public final fun getCollisionCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionCountPtr).toInt()

  /**
   * Returns the point of collision in global coordinates given a collision index (the deepest
   * collision by default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getCollisionPoint(collisionIndex: Int = 0): Vector3 =
      TransferContext.callPtrMethod_LONG_ret_VECTOR3(ptr, objectID.id, MethodBindings.getCollisionPointPtr, collisionIndex.toLong())

  /**
   * Returns the colliding body's shape's normal at the point of collision given a collision index
   * (the deepest collision by default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getCollisionNormal(collisionIndex: Int = 0): Vector3 =
      TransferContext.callPtrMethod_LONG_ret_VECTOR3(ptr, objectID.id, MethodBindings.getCollisionNormalPtr, collisionIndex.toLong())

  /**
   * Returns the colliding body's velocity given a collision index (the deepest collision by
   * default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getColliderVelocity(collisionIndex: Int = 0): Vector3 =
      TransferContext.callPtrMethod_LONG_ret_VECTOR3(ptr, objectID.id, MethodBindings.getColliderVelocityPtr, collisionIndex.toLong())

  /**
   * Returns the unique instance ID of the colliding body's attached [Object] given a collision
   * index (the deepest collision by default), if a collision occurred. See [Object.getInstanceId].
   */
  @JvmOverloads
  public final fun getColliderId(collisionIndex: Int = 0): Long =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getColliderIdPtr, collisionIndex.toLong())

  /**
   * Returns the colliding body's [RID] used by the [PhysicsServer3D] given a collision index (the
   * deepest collision by default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getColliderRid(collisionIndex: Int = 0): RID =
      TransferContext.callPtrMethod_LONG_ret_RID(ptr, objectID.id, MethodBindings.getColliderRidPtr, collisionIndex.toLong())

  /**
   * Returns the colliding body's attached [Object] given a collision index (the deepest collision
   * by default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getCollider(collisionIndex: Int = 0): Object? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT(ptr, objectID.id, MethodBindings.getColliderPtr, collisionIndex.toLong()) as Object?)

  /**
   * Returns the colliding body's shape index given a collision index (the deepest collision by
   * default), if a collision occurred. See [CollisionObject3D].
   */
  @JvmOverloads
  public final fun getColliderShape(collisionIndex: Int = 0): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getColliderShapePtr, collisionIndex.toLong()).toInt()

  /**
   * Returns the moving object's colliding shape given a collision index (the deepest collision by
   * default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getCollisionLocalShape(collisionIndex: Int = 0): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionLocalShapePtr, collisionIndex.toLong()).toInt()

  /**
   * Returns the length of overlap along the collision normal given a collision index (the deepest
   * collision by default), if a collision occurred.
   */
  @JvmOverloads
  public final fun getCollisionDepth(collisionIndex: Int = 0): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCollisionDepthPtr, collisionIndex.toLong()).toFloat()

  public companion object {
    @JvmField
    public val getTravelName: MethodStringName0<PhysicsTestMotionResult3D, Vector3> =
        MethodStringName0<PhysicsTestMotionResult3D, Vector3>("get_travel")

    @JvmField
    public val getRemainderName: MethodStringName0<PhysicsTestMotionResult3D, Vector3> =
        MethodStringName0<PhysicsTestMotionResult3D, Vector3>("get_remainder")

    @JvmField
    public val getCollisionSafeFractionName: MethodStringName0<PhysicsTestMotionResult3D, Float> =
        MethodStringName0<PhysicsTestMotionResult3D, Float>("get_collision_safe_fraction")

    @JvmField
    public val getCollisionUnsafeFractionName: MethodStringName0<PhysicsTestMotionResult3D, Float> =
        MethodStringName0<PhysicsTestMotionResult3D, Float>("get_collision_unsafe_fraction")

    @JvmField
    public val getCollisionCountName: MethodStringName0<PhysicsTestMotionResult3D, Int> =
        MethodStringName0<PhysicsTestMotionResult3D, Int>("get_collision_count")

    @JvmField
    public val getCollisionPointName: MethodStringName1<PhysicsTestMotionResult3D, Vector3, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Vector3, Int>("get_collision_point")

    @JvmField
    public val getCollisionNormalName: MethodStringName1<PhysicsTestMotionResult3D, Vector3, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Vector3, Int>("get_collision_normal")

    @JvmField
    public val getColliderVelocityName: MethodStringName1<PhysicsTestMotionResult3D, Vector3, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Vector3, Int>("get_collider_velocity")

    @JvmField
    public val getColliderIdName: MethodStringName1<PhysicsTestMotionResult3D, Long, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Long, Int>("get_collider_id")

    @JvmField
    public val getColliderRidName: MethodStringName1<PhysicsTestMotionResult3D, RID, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, RID, Int>("get_collider_rid")

    @JvmField
    public val getColliderName: MethodStringName1<PhysicsTestMotionResult3D, Object?, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Object?, Int>("get_collider")

    @JvmField
    public val getColliderShapeName: MethodStringName1<PhysicsTestMotionResult3D, Int, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Int, Int>("get_collider_shape")

    @JvmField
    public val getCollisionLocalShapeName: MethodStringName1<PhysicsTestMotionResult3D, Int, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Int, Int>("get_collision_local_shape")

    @JvmField
    public val getCollisionDepthName: MethodStringName1<PhysicsTestMotionResult3D, Float, Int> =
        MethodStringName1<PhysicsTestMotionResult3D, Float, Int>("get_collision_depth")
  }

  public object MethodBindings {
    internal val getTravelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_travel", 3360562783)

    internal val getRemainderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_remainder", 3360562783)

    internal val getCollisionSafeFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_safe_fraction", 1740695150)

    internal val getCollisionUnsafeFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_unsafe_fraction", 1740695150)

    internal val getCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_count", 3905245786)

    internal val getCollisionPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_point", 1914908202)

    internal val getCollisionNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_normal", 1914908202)

    internal val getColliderVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collider_velocity", 1914908202)

    internal val getColliderIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collider_id", 1591665591)

    internal val getColliderRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collider_rid", 1231817359)

    internal val getColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collider", 2639523548)

    internal val getColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collider_shape", 1591665591)

    internal val getCollisionLocalShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_local_shape", 1591665591)

    internal val getCollisionDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionResult3D", "get_collision_depth", 218038398)
  }
}
