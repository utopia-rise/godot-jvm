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
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod0_ret_VECTOR2
import godot.callPtrMethod_VECTOR2_ret_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Vector2
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Holds collision data from the movement of a [PhysicsBody2D], usually from
 * [PhysicsBody2D.moveAndCollide]. When a [PhysicsBody2D] is moved, it stops if it detects a collision
 * with another body. If a collision is detected, a [KinematicCollision2D] object is returned.
 *
 * The collision data includes the colliding object, the remaining motion, and the collision
 * position. This data can be used to determine a custom response to the collision.
 */
@GodotBaseType
public open class KinematicCollision2D : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(345, scriptPtr)
  }

  /**
   * Returns the point of collision in global coordinates.
   */
  public final fun getPosition(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getPositionPtr)

  /**
   * Returns the colliding body's shape's normal at the point of collision.
   */
  public final fun getNormal(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getNormalPtr)

  /**
   * Returns the moving object's travel before collision.
   */
  public final fun getTravel(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getTravelPtr)

  /**
   * Returns the moving object's remaining movement vector.
   */
  public final fun getRemainder(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getRemainderPtr)

  /**
   * Returns the collision angle according to [upDirection], which is [Vector2.UP] by default. This
   * value is always positive.
   */
  @JvmOverloads
  public final fun getAngle(upDirection: Vector2 = Vector2(0, -1)): Float =
      TransferContext.callPtrMethod_VECTOR2_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAnglePtr, upDirection).toFloat()

  /**
   * Returns the colliding body's length of overlap along the collision normal.
   */
  public final fun getDepth(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDepthPtr).toFloat()

  /**
   * Returns the moving object's colliding shape.
   */
  public final fun getLocalShape(): Object? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getLocalShapePtr) as Object?)

  /**
   * Returns the colliding body's attached [Object].
   */
  public final fun getCollider(): Object? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getColliderPtr) as Object?)

  /**
   * Returns the unique instance ID of the colliding body's attached [Object]. See
   * [Object.getInstanceId].
   */
  public final fun getColliderId(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getColliderIdPtr)

  /**
   * Returns the colliding body's [RID] used by the [PhysicsServer2D].
   */
  public final fun getColliderRid(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getColliderRidPtr)

  /**
   * Returns the colliding body's shape.
   */
  public final fun getColliderShape(): Object? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getColliderShapePtr) as Object?)

  /**
   * Returns the colliding body's shape index. See [CollisionObject2D].
   */
  public final fun getColliderShapeIndex(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getColliderShapeIndexPtr).toInt()

  /**
   * Returns the colliding body's velocity.
   */
  public final fun getColliderVelocity(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getColliderVelocityPtr)

  public companion object {
    @JvmField
    public val getPositionName: MethodStringName0<KinematicCollision2D, Vector2> =
        MethodStringName0<KinematicCollision2D, Vector2>("get_position")

    @JvmField
    public val getNormalName: MethodStringName0<KinematicCollision2D, Vector2> =
        MethodStringName0<KinematicCollision2D, Vector2>("get_normal")

    @JvmField
    public val getTravelName: MethodStringName0<KinematicCollision2D, Vector2> =
        MethodStringName0<KinematicCollision2D, Vector2>("get_travel")

    @JvmField
    public val getRemainderName: MethodStringName0<KinematicCollision2D, Vector2> =
        MethodStringName0<KinematicCollision2D, Vector2>("get_remainder")

    @JvmField
    public val getAngleName: MethodStringName1<KinematicCollision2D, Float, Vector2> =
        MethodStringName1<KinematicCollision2D, Float, Vector2>("get_angle")

    @JvmField
    public val getDepthName: MethodStringName0<KinematicCollision2D, Float> =
        MethodStringName0<KinematicCollision2D, Float>("get_depth")

    @JvmField
    public val getLocalShapeName: MethodStringName0<KinematicCollision2D, Object?> =
        MethodStringName0<KinematicCollision2D, Object?>("get_local_shape")

    @JvmField
    public val getColliderName: MethodStringName0<KinematicCollision2D, Object?> =
        MethodStringName0<KinematicCollision2D, Object?>("get_collider")

    @JvmField
    public val getColliderIdName: MethodStringName0<KinematicCollision2D, Long> =
        MethodStringName0<KinematicCollision2D, Long>("get_collider_id")

    @JvmField
    public val getColliderRidName: MethodStringName0<KinematicCollision2D, RID> =
        MethodStringName0<KinematicCollision2D, RID>("get_collider_rid")

    @JvmField
    public val getColliderShapeName: MethodStringName0<KinematicCollision2D, Object?> =
        MethodStringName0<KinematicCollision2D, Object?>("get_collider_shape")

    @JvmField
    public val getColliderShapeIndexName: MethodStringName0<KinematicCollision2D, Int> =
        MethodStringName0<KinematicCollision2D, Int>("get_collider_shape_index")

    @JvmField
    public val getColliderVelocityName: MethodStringName0<KinematicCollision2D, Vector2> =
        MethodStringName0<KinematicCollision2D, Vector2>("get_collider_velocity")
  }

  public object MethodBindings {
    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_position", 3341600327)

    internal val getNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_normal", 3341600327)

    internal val getTravelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_travel", 3341600327)

    internal val getRemainderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_remainder", 3341600327)

    internal val getAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_angle", 2841063350)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_depth", 1740695150)

    internal val getLocalShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_local_shape", 1981248198)

    internal val getColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_collider", 1981248198)

    internal val getColliderIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_collider_id", 3905245786)

    internal val getColliderRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_collider_rid", 2944877500)

    internal val getColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_collider_shape", 1981248198)

    internal val getColliderShapeIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_collider_shape_index", 3905245786)

    internal val getColliderVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("KinematicCollision2D", "get_collider_velocity", 3341600327)
  }
}
