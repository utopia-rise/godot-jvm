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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.VariantArray
import godot.core.Vector2
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_VECTOR2
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Shape casting allows to detect collision objects by sweeping its [shape] along the cast direction
 * determined by [targetPosition]. This is similar to [RayCast2D], but it allows for sweeping a region
 * of space, rather than just a straight line. [ShapeCast2D] can detect multiple collision objects. It
 * is useful for things like wide laser beams or snapping a simple shape to a floor.
 *
 * Immediate collision overlaps can be done with the [targetPosition] set to `Vector2(0, 0)` and by
 * calling [forceShapecastUpdate] within the same physics frame. This helps to overcome some
 * limitations of [Area2D] when used as an instantaneous detection area, as collision information isn't
 * immediately available to it.
 *
 * **Note:** Shape casting is more computationally expensive than ray casting.
 */
@GodotBaseType
public open class ShapeCast2D : Node2D() {
  /**
   * If `true`, collisions will be reported.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * The shape to be used for collision queries.
   */
  public final inline var shape: Shape2D?
    @JvmName("shapeProperty")
    get() = getShape()
    @JvmName("shapeProperty")
    set(`value`) {
      setShape(value)
    }

  /**
   * If `true`, the parent node will be excluded from collision detection.
   */
  public final inline var excludeParent: Boolean
    @JvmName("excludeParentProperty")
    get() = getExcludeParentBody()
    @JvmName("excludeParentProperty")
    set(`value`) {
      setExcludeParentBody(value)
    }

  /**
   * The shape's destination point, relative to this node's [Node2D.position].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var targetPosition: Vector2
    @JvmName("targetPositionProperty")
    get() = getTargetPosition()
    @JvmName("targetPositionProperty")
    set(`value`) {
      setTargetPosition(value)
    }

  /**
   * The collision margin for the shape. A larger margin helps detecting collisions more
   * consistently, at the cost of precision.
   */
  public final inline var margin: Float
    @JvmName("marginProperty")
    get() = getMargin()
    @JvmName("marginProperty")
    set(`value`) {
      setMargin(value)
    }

  /**
   * The number of intersections can be limited with this parameter, to reduce the processing time.
   */
  public final inline var maxResults: Int
    @JvmName("maxResultsProperty")
    get() = getMaxResults()
    @JvmName("maxResultsProperty")
    set(`value`) {
      setMaxResults(value)
    }

  /**
   * The shape's collision mask. Only objects in at least one collision layer enabled in the mask
   * will be detected. See
   * [url=$DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks]Collision
   * layers and masks[/url] in the documentation for more information.
   */
  public final inline var collisionMask: Long
    @JvmName("collisionMaskProperty")
    get() = getCollisionMask()
    @JvmName("collisionMaskProperty")
    set(`value`) {
      setCollisionMask(value)
    }

  /**
   * Returns the complete collision information from the collision sweep. The data returned is the
   * same as in the [PhysicsDirectSpaceState2D.getRestInfo] method.
   */
  public final inline val collisionResult: VariantArray<Any?>
    @JvmName("collisionResultProperty")
    get() = getCollisionResult()

  /**
   * If `true`, collisions with [Area2D]s will be reported.
   */
  public final inline var collideWithAreas: Boolean
    @JvmName("collideWithAreasProperty")
    get() = isCollideWithAreasEnabled()
    @JvmName("collideWithAreasProperty")
    set(`value`) {
      setCollideWithAreas(value)
    }

  /**
   * If `true`, collisions with [PhysicsBody2D]s will be reported.
   */
  public final inline var collideWithBodies: Boolean
    @JvmName("collideWithBodiesProperty")
    get() = isCollideWithBodiesEnabled()
    @JvmName("collideWithBodiesProperty")
    set(`value`) {
      setCollideWithBodies(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(661, scriptPtr)
  }

  /**
   * This is a helper function for [targetPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = shapecast2d.targetPosition
   * //Your changes
   * shapecast2d.targetPosition = myCoreType
   * ``````
   *
   * The shape's destination point, relative to this node's [Node2D.position].
   */
  @CoreTypeHelper
  public final fun targetPositionMutate(block: Vector2.() -> Unit): Vector2 = targetPosition.apply {
     block(this)
     targetPosition = this
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setEnabledPtr, 0)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setShape(shape: Shape2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, shape)
    TransferContext.callPtrMethod(MethodBindings.setShapePtr, 0)
  }

  public final fun getShape(): Shape2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getShapePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Shape2D?)
  }

  public final fun setTargetPosition(localPoint: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, localPoint)
    TransferContext.callPtrMethod(MethodBindings.setTargetPositionPtr, 0)
  }

  public final fun getTargetPosition(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTargetPositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public final fun setMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, margin.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMarginPtr, 0)
  }

  public final fun getMargin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMarginPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMaxResults(maxResults: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxResults.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxResultsPtr, 0)
  }

  public final fun getMaxResults(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxResultsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns whether any object is intersecting with the shape's vector (considering the vector
   * length).
   */
  public final fun isColliding(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCollidingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * The number of collisions detected at the point of impact. Use this to iterate over multiple
   * collisions as provided by [getCollider], [getColliderShape], [getCollisionPoint], and
   * [getCollisionNormal] methods.
   */
  public final fun getCollisionCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Updates the collision information for the shape immediately, without waiting for the next
   * `_physics_process` call. Use this method, for example, when the shape or its parent has changed
   * state.
   *
   * **Note:** Setting [enabled] to `true` is not required for this to work.
   */
  public final fun forceShapecastUpdate(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.forceShapecastUpdatePtr, 0)
  }

  /**
   * Returns the collided [Object] of one of the multiple collisions at [index], or `null` if no
   * object is intersecting the shape (i.e. [isColliding] returns `false`).
   */
  public final fun getCollider(index: Int): Object? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getColliderPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Object?)
  }

  /**
   * Returns the [RID] of the collided object of one of the multiple collisions at [index].
   */
  public final fun getColliderRid(index: Int): RID {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getColliderRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the shape ID of the colliding shape of one of the multiple collisions at [index], or
   * `0` if no object is intersecting the shape (i.e. [isColliding] returns `false`).
   */
  public final fun getColliderShape(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getColliderShapePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the collision point of one of the multiple collisions at [index] where the shape
   * intersects the colliding object.
   *
   * **Note:** This point is in the **global** coordinate system.
   */
  public final fun getCollisionPoint(index: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCollisionPointPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the normal of one of the multiple collisions at [index] of the intersecting object.
   */
  public final fun getCollisionNormal(index: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCollisionNormalPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the fraction from this cast's origin to its [targetPosition] of how far the shape can
   * move without triggering a collision, as a value between `0.0` and `1.0`.
   */
  public final fun getClosestCollisionSafeFraction(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getClosestCollisionSafeFractionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the fraction from this cast's origin to its [targetPosition] of how far the shape must
   * move to trigger a collision, as a value between `0.0` and `1.0`.
   *
   * In ideal conditions this would be the same as [getClosestCollisionSafeFraction], however shape
   * casting is calculated in discrete steps, so the precise point of collision can occur between two
   * calculated positions.
   */
  public final fun getClosestCollisionUnsafeFraction(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getClosestCollisionUnsafeFractionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Adds a collision exception so the shape does not report collisions with the specified [RID].
   */
  public final fun addExceptionRid(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callPtrMethod(MethodBindings.addExceptionRidPtr, 0)
  }

  /**
   * Adds a collision exception so the shape does not report collisions with the specified node.
   */
  public final fun addException(node: CollisionObject2D): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, node)
    TransferContext.callPtrMethod(MethodBindings.addExceptionPtr, 0)
  }

  /**
   * Removes a collision exception so the shape does report collisions with the specified [RID].
   */
  public final fun removeExceptionRid(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callPtrMethod(MethodBindings.removeExceptionRidPtr, 0)
  }

  /**
   * Removes a collision exception so the shape does report collisions with the specified node.
   */
  public final fun removeException(node: CollisionObject2D): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, node)
    TransferContext.callPtrMethod(MethodBindings.removeExceptionPtr, 0)
  }

  /**
   * Removes all collision exceptions for this shape.
   */
  public final fun clearExceptions(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearExceptionsPtr, 0)
  }

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mask)
    TransferContext.callPtrMethod(MethodBindings.setCollisionMaskPtr, 0)
  }

  public final fun getCollisionMask(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionMaskPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callPtrMethod(MethodBindings.setCollisionMaskValuePtr, 0)
  }

  /**
   * Returns whether or not the specified layer of the [collisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCollisionMaskValuePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setExcludeParentBody(mask: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, mask)
    TransferContext.callPtrMethod(MethodBindings.setExcludeParentBodyPtr, 0)
  }

  public final fun getExcludeParentBody(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getExcludeParentBodyPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCollideWithAreas(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setCollideWithAreasPtr, 0)
  }

  public final fun isCollideWithAreasEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCollideWithAreasEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCollideWithBodies(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setCollideWithBodiesPtr, 0)
  }

  public final fun isCollideWithBodiesEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCollideWithBodiesEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getCollisionResult(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionResultPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  public companion object {
    @JvmField
    public val setEnabledName: MethodStringName1<ShapeCast2D, Unit, Boolean> =
        MethodStringName1<ShapeCast2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<ShapeCast2D, Boolean> =
        MethodStringName0<ShapeCast2D, Boolean>("is_enabled")

    @JvmField
    public val setShapeName: MethodStringName1<ShapeCast2D, Unit, Shape2D?> =
        MethodStringName1<ShapeCast2D, Unit, Shape2D?>("set_shape")

    @JvmField
    public val getShapeName: MethodStringName0<ShapeCast2D, Shape2D?> =
        MethodStringName0<ShapeCast2D, Shape2D?>("get_shape")

    @JvmField
    public val setTargetPositionName: MethodStringName1<ShapeCast2D, Unit, Vector2> =
        MethodStringName1<ShapeCast2D, Unit, Vector2>("set_target_position")

    @JvmField
    public val getTargetPositionName: MethodStringName0<ShapeCast2D, Vector2> =
        MethodStringName0<ShapeCast2D, Vector2>("get_target_position")

    @JvmField
    public val setMarginName: MethodStringName1<ShapeCast2D, Unit, Float> =
        MethodStringName1<ShapeCast2D, Unit, Float>("set_margin")

    @JvmField
    public val getMarginName: MethodStringName0<ShapeCast2D, Float> =
        MethodStringName0<ShapeCast2D, Float>("get_margin")

    @JvmField
    public val setMaxResultsName: MethodStringName1<ShapeCast2D, Unit, Int> =
        MethodStringName1<ShapeCast2D, Unit, Int>("set_max_results")

    @JvmField
    public val getMaxResultsName: MethodStringName0<ShapeCast2D, Int> =
        MethodStringName0<ShapeCast2D, Int>("get_max_results")

    @JvmField
    public val isCollidingName: MethodStringName0<ShapeCast2D, Boolean> =
        MethodStringName0<ShapeCast2D, Boolean>("is_colliding")

    @JvmField
    public val getCollisionCountName: MethodStringName0<ShapeCast2D, Int> =
        MethodStringName0<ShapeCast2D, Int>("get_collision_count")

    @JvmField
    public val forceShapecastUpdateName: MethodStringName0<ShapeCast2D, Unit> =
        MethodStringName0<ShapeCast2D, Unit>("force_shapecast_update")

    @JvmField
    public val getColliderName: MethodStringName1<ShapeCast2D, Object?, Int> =
        MethodStringName1<ShapeCast2D, Object?, Int>("get_collider")

    @JvmField
    public val getColliderRidName: MethodStringName1<ShapeCast2D, RID, Int> =
        MethodStringName1<ShapeCast2D, RID, Int>("get_collider_rid")

    @JvmField
    public val getColliderShapeName: MethodStringName1<ShapeCast2D, Int, Int> =
        MethodStringName1<ShapeCast2D, Int, Int>("get_collider_shape")

    @JvmField
    public val getCollisionPointName: MethodStringName1<ShapeCast2D, Vector2, Int> =
        MethodStringName1<ShapeCast2D, Vector2, Int>("get_collision_point")

    @JvmField
    public val getCollisionNormalName: MethodStringName1<ShapeCast2D, Vector2, Int> =
        MethodStringName1<ShapeCast2D, Vector2, Int>("get_collision_normal")

    @JvmField
    public val getClosestCollisionSafeFractionName: MethodStringName0<ShapeCast2D, Float> =
        MethodStringName0<ShapeCast2D, Float>("get_closest_collision_safe_fraction")

    @JvmField
    public val getClosestCollisionUnsafeFractionName: MethodStringName0<ShapeCast2D, Float> =
        MethodStringName0<ShapeCast2D, Float>("get_closest_collision_unsafe_fraction")

    @JvmField
    public val addExceptionRidName: MethodStringName1<ShapeCast2D, Unit, RID> =
        MethodStringName1<ShapeCast2D, Unit, RID>("add_exception_rid")

    @JvmField
    public val addExceptionName: MethodStringName1<ShapeCast2D, Unit, CollisionObject2D> =
        MethodStringName1<ShapeCast2D, Unit, CollisionObject2D>("add_exception")

    @JvmField
    public val removeExceptionRidName: MethodStringName1<ShapeCast2D, Unit, RID> =
        MethodStringName1<ShapeCast2D, Unit, RID>("remove_exception_rid")

    @JvmField
    public val removeExceptionName: MethodStringName1<ShapeCast2D, Unit, CollisionObject2D> =
        MethodStringName1<ShapeCast2D, Unit, CollisionObject2D>("remove_exception")

    @JvmField
    public val clearExceptionsName: MethodStringName0<ShapeCast2D, Unit> =
        MethodStringName0<ShapeCast2D, Unit>("clear_exceptions")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<ShapeCast2D, Unit, Long> =
        MethodStringName1<ShapeCast2D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<ShapeCast2D, Long> =
        MethodStringName0<ShapeCast2D, Long>("get_collision_mask")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<ShapeCast2D, Unit, Int, Boolean> =
        MethodStringName2<ShapeCast2D, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<ShapeCast2D, Boolean, Int> =
        MethodStringName1<ShapeCast2D, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setExcludeParentBodyName: MethodStringName1<ShapeCast2D, Unit, Boolean> =
        MethodStringName1<ShapeCast2D, Unit, Boolean>("set_exclude_parent_body")

    @JvmField
    public val getExcludeParentBodyName: MethodStringName0<ShapeCast2D, Boolean> =
        MethodStringName0<ShapeCast2D, Boolean>("get_exclude_parent_body")

    @JvmField
    public val setCollideWithAreasName: MethodStringName1<ShapeCast2D, Unit, Boolean> =
        MethodStringName1<ShapeCast2D, Unit, Boolean>("set_collide_with_areas")

    @JvmField
    public val isCollideWithAreasEnabledName: MethodStringName0<ShapeCast2D, Boolean> =
        MethodStringName0<ShapeCast2D, Boolean>("is_collide_with_areas_enabled")

    @JvmField
    public val setCollideWithBodiesName: MethodStringName1<ShapeCast2D, Unit, Boolean> =
        MethodStringName1<ShapeCast2D, Unit, Boolean>("set_collide_with_bodies")

    @JvmField
    public val isCollideWithBodiesEnabledName: MethodStringName0<ShapeCast2D, Boolean> =
        MethodStringName0<ShapeCast2D, Boolean>("is_collide_with_bodies_enabled")

    @JvmField
    public val getCollisionResultName: MethodStringName0<ShapeCast2D, VariantArray<Any?>> =
        MethodStringName0<ShapeCast2D, VariantArray<Any?>>("get_collision_result")
  }

  public object MethodBindings {
    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "is_enabled", 36873697)

    internal val setShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_shape", 771364740)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_shape", 522005891)

    internal val setTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_target_position", 743155724)

    internal val getTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_target_position", 3341600327)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_margin", 373806689)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_margin", 1740695150)

    internal val setMaxResultsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_max_results", 1286410249)

    internal val getMaxResultsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_max_results", 3905245786)

    internal val isCollidingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "is_colliding", 36873697)

    internal val getCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collision_count", 3905245786)

    internal val forceShapecastUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "force_shapecast_update", 3218959716)

    internal val getColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collider", 3332903315)

    internal val getColliderRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collider_rid", 495598643)

    internal val getColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collider_shape", 923996154)

    internal val getCollisionPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collision_point", 2299179447)

    internal val getCollisionNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collision_normal", 2299179447)

    internal val getClosestCollisionSafeFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_closest_collision_safe_fraction", 1740695150)

    internal val getClosestCollisionUnsafeFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_closest_collision_unsafe_fraction", 1740695150)

    internal val addExceptionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "add_exception_rid", 2722037293)

    internal val addExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "add_exception", 3090941106)

    internal val removeExceptionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "remove_exception_rid", 2722037293)

    internal val removeExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "remove_exception", 3090941106)

    internal val clearExceptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "clear_exceptions", 3218959716)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collision_mask", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collision_mask_value", 1116898809)

    internal val setExcludeParentBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_exclude_parent_body", 2586408642)

    internal val getExcludeParentBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_exclude_parent_body", 36873697)

    internal val setCollideWithAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_collide_with_areas", 2586408642)

    internal val isCollideWithAreasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "is_collide_with_areas_enabled", 36873697)

    internal val setCollideWithBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "set_collide_with_bodies", 2586408642)

    internal val isCollideWithBodiesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "is_collide_with_bodies_enabled", 36873697)

    internal val getCollisionResultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShapeCast2D", "get_collision_result", 3995934104)
  }
}
