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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A raycast represents a ray from its origin to its [targetPosition] that finds the closest object
 * along its path, if it intersects any.
 *
 * [RayCast2D] can ignore some objects by adding them to an exception list, by making its detection
 * reporting ignore [Area2D]s ([collideWithAreas]) or [PhysicsBody2D]s ([collideWithBodies]), or by
 * configuring physics layers.
 *
 * [RayCast2D] calculates intersection every physics frame, and it holds the result until the next
 * physics frame. For an immediate raycast, or if you want to configure a [RayCast2D] multiple times
 * within the same physics frame, use [forceRaycastUpdate].
 *
 * To sweep over a region of 2D space, you can approximate the region with multiple [RayCast2D]s or
 * use [ShapeCast2D].
 */
@GodotBaseType
public open class RayCast2D : Node2D() {
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
   * If `true`, this raycast will not report collisions with its parent node. This property only has
   * an effect if the parent node is a [CollisionObject2D]. See also [Node.getParent] and
   * [addException].
   */
  public final inline var excludeParent: Boolean
    @JvmName("excludeParentProperty")
    get() = getExcludeParentBody()
    @JvmName("excludeParentProperty")
    set(`value`) {
      setExcludeParentBody(value)
    }

  /**
   * The ray's destination point, relative to this raycast's [Node2D.position].
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
   * The ray's collision mask. Only objects in at least one collision layer enabled in the mask will
   * be detected. See
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
   * If `true`, the ray will detect a hit when starting inside shapes. In this case the collision
   * normal will be `Vector2(0, 0)`. Does not affect concave polygon shapes.
   */
  public final inline var hitFromInside: Boolean
    @JvmName("hitFromInsideProperty")
    get() = isHitFromInsideEnabled()
    @JvmName("hitFromInsideProperty")
    set(`value`) {
      setHitFromInside(value)
    }

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
    createNativeObject(600, scriptPtr)
  }

  /**
   * This is a helper function for [targetPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = raycast2d.targetPosition
   * //Your changes
   * raycast2d.targetPosition = myCoreType
   * ``````
   *
   * The ray's destination point, relative to this raycast's [Node2D.position].
   */
  @CoreTypeHelper
  public final fun targetPositionMutate(block: Vector2.() -> Unit): Vector2 = targetPosition.apply {
     block(this)
     targetPosition = this
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEnabledPtr)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTargetPosition(localPoint: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to localPoint)
    TransferContext.callMethod(MethodBindings.setTargetPositionPtr)
  }

  public final fun getTargetPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns whether any object is intersecting with the ray's vector (considering the vector
   * length).
   */
  public final fun isColliding(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollidingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Updates the collision information for the ray immediately, without waiting for the next
   * `_physics_process` call. Use this method, for example, when the ray or its parent has changed
   * state.
   *
   * **Note:** [enabled] does not need to be `true` for this to work.
   */
  public final fun forceRaycastUpdate(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceRaycastUpdatePtr)
  }

  /**
   * Returns the first object that the ray intersects, or `null` if no object is intersecting the
   * ray (i.e. [isColliding] returns `false`).
   *
   * **Note:** This object is not guaranteed to be a [CollisionObject2D]. For example, if the ray
   * intersects a [TileMapLayer], the method will return a [TileMapLayer] instance.
   */
  public final fun getCollider(): Object? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColliderPtr)
    return (TransferContext.readReturnValue(OBJECT) as Object?)
  }

  /**
   * Returns the [RID] of the first object that the ray intersects, or an empty [RID] if no object
   * is intersecting the ray (i.e. [isColliding] returns `false`).
   */
  public final fun getColliderRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColliderRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the shape ID of the first object that the ray intersects, or `0` if no object is
   * intersecting the ray (i.e. [isColliding] returns `false`).
   *
   * To get the intersected shape node, for a [CollisionObject2D] target, use:
   *
   * ```gdscript
   * //gdscript
   * var target = get_collider() # A CollisionObject2D.
   * var shape_id = get_collider_shape() # The shape index in the collider.
   * var owner_id = target.shape_find_owner(shape_id) # The owner ID in the collider.
   * var shape = target.shape_owner_get_owner(owner_id)
   * ```
   *
   * ```csharp
   * //csharp
   * var target = (CollisionObject2D)GetCollider(); // A CollisionObject2D.
   * var shapeId = GetColliderShape(); // The shape index in the collider.
   * var ownerId = target.ShapeFindOwner(shapeId); // The owner ID in the collider.
   * var shape = target.ShapeOwnerGetOwner(ownerId);
   * ```
   */
  public final fun getColliderShape(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColliderShapePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the collision point at which the ray intersects the closest object, in the global
   * coordinate system. If [hitFromInside] is `true` and the ray starts inside of a collision shape,
   * this function will return the origin point of the ray.
   *
   * **Note:** Check that [isColliding] returns `true` before calling this method to ensure the
   * returned point is valid and up-to-date.
   */
  public final fun getCollisionPoint(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionPointPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the normal of the intersecting object's shape at the collision point, or `Vector2(0,
   * 0)` if the ray starts inside the shape and [hitFromInside] is `true`.
   *
   * **Note:** Check that [isColliding] returns `true` before calling this method to ensure the
   * returned normal is valid and up-to-date.
   */
  public final fun getCollisionNormal(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionNormalPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Adds a collision exception so the ray does not report collisions with the specified [RID].
   */
  public final fun addExceptionRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.addExceptionRidPtr)
  }

  /**
   * Adds a collision exception so the ray does not report collisions with the specified [node].
   */
  public final fun addException(node: CollisionObject2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to node)
    TransferContext.callMethod(MethodBindings.addExceptionPtr)
  }

  /**
   * Removes a collision exception so the ray can report collisions with the specified [RID].
   */
  public final fun removeExceptionRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.removeExceptionRidPtr)
  }

  /**
   * Removes a collision exception so the ray can report collisions with the specified [node].
   */
  public final fun removeException(node: CollisionObject2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to node)
    TransferContext.callMethod(MethodBindings.removeExceptionPtr)
  }

  /**
   * Removes all collision exceptions for this ray.
   */
  public final fun clearExceptions(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearExceptionsPtr)
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
   * Based on [value], enables or disables the specified layer in the [collisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setCollisionMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [collisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionMaskValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setExcludeParentBody(mask: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to mask)
    TransferContext.callMethod(MethodBindings.setExcludeParentBodyPtr)
  }

  public final fun getExcludeParentBody(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludeParentBodyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollideWithAreas(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCollideWithAreasPtr)
  }

  public final fun isCollideWithAreasEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollideWithAreasEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollideWithBodies(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCollideWithBodiesPtr)
  }

  public final fun isCollideWithBodiesEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollideWithBodiesEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHitFromInside(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHitFromInsidePtr)
  }

  public final fun isHitFromInsideEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHitFromInsideEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setEnabledName: MethodStringName1<RayCast2D, Unit, Boolean> =
        MethodStringName1<RayCast2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<RayCast2D, Boolean> =
        MethodStringName0<RayCast2D, Boolean>("is_enabled")

    @JvmField
    public val setTargetPositionName: MethodStringName1<RayCast2D, Unit, Vector2> =
        MethodStringName1<RayCast2D, Unit, Vector2>("set_target_position")

    @JvmField
    public val getTargetPositionName: MethodStringName0<RayCast2D, Vector2> =
        MethodStringName0<RayCast2D, Vector2>("get_target_position")

    @JvmField
    public val isCollidingName: MethodStringName0<RayCast2D, Boolean> =
        MethodStringName0<RayCast2D, Boolean>("is_colliding")

    @JvmField
    public val forceRaycastUpdateName: MethodStringName0<RayCast2D, Unit> =
        MethodStringName0<RayCast2D, Unit>("force_raycast_update")

    @JvmField
    public val getColliderName: MethodStringName0<RayCast2D, Object?> =
        MethodStringName0<RayCast2D, Object?>("get_collider")

    @JvmField
    public val getColliderRidName: MethodStringName0<RayCast2D, RID> =
        MethodStringName0<RayCast2D, RID>("get_collider_rid")

    @JvmField
    public val getColliderShapeName: MethodStringName0<RayCast2D, Int> =
        MethodStringName0<RayCast2D, Int>("get_collider_shape")

    @JvmField
    public val getCollisionPointName: MethodStringName0<RayCast2D, Vector2> =
        MethodStringName0<RayCast2D, Vector2>("get_collision_point")

    @JvmField
    public val getCollisionNormalName: MethodStringName0<RayCast2D, Vector2> =
        MethodStringName0<RayCast2D, Vector2>("get_collision_normal")

    @JvmField
    public val addExceptionRidName: MethodStringName1<RayCast2D, Unit, RID> =
        MethodStringName1<RayCast2D, Unit, RID>("add_exception_rid")

    @JvmField
    public val addExceptionName: MethodStringName1<RayCast2D, Unit, CollisionObject2D> =
        MethodStringName1<RayCast2D, Unit, CollisionObject2D>("add_exception")

    @JvmField
    public val removeExceptionRidName: MethodStringName1<RayCast2D, Unit, RID> =
        MethodStringName1<RayCast2D, Unit, RID>("remove_exception_rid")

    @JvmField
    public val removeExceptionName: MethodStringName1<RayCast2D, Unit, CollisionObject2D> =
        MethodStringName1<RayCast2D, Unit, CollisionObject2D>("remove_exception")

    @JvmField
    public val clearExceptionsName: MethodStringName0<RayCast2D, Unit> =
        MethodStringName0<RayCast2D, Unit>("clear_exceptions")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<RayCast2D, Unit, Long> =
        MethodStringName1<RayCast2D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<RayCast2D, Long> =
        MethodStringName0<RayCast2D, Long>("get_collision_mask")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<RayCast2D, Unit, Int, Boolean> =
        MethodStringName2<RayCast2D, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<RayCast2D, Boolean, Int> =
        MethodStringName1<RayCast2D, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setExcludeParentBodyName: MethodStringName1<RayCast2D, Unit, Boolean> =
        MethodStringName1<RayCast2D, Unit, Boolean>("set_exclude_parent_body")

    @JvmField
    public val getExcludeParentBodyName: MethodStringName0<RayCast2D, Boolean> =
        MethodStringName0<RayCast2D, Boolean>("get_exclude_parent_body")

    @JvmField
    public val setCollideWithAreasName: MethodStringName1<RayCast2D, Unit, Boolean> =
        MethodStringName1<RayCast2D, Unit, Boolean>("set_collide_with_areas")

    @JvmField
    public val isCollideWithAreasEnabledName: MethodStringName0<RayCast2D, Boolean> =
        MethodStringName0<RayCast2D, Boolean>("is_collide_with_areas_enabled")

    @JvmField
    public val setCollideWithBodiesName: MethodStringName1<RayCast2D, Unit, Boolean> =
        MethodStringName1<RayCast2D, Unit, Boolean>("set_collide_with_bodies")

    @JvmField
    public val isCollideWithBodiesEnabledName: MethodStringName0<RayCast2D, Boolean> =
        MethodStringName0<RayCast2D, Boolean>("is_collide_with_bodies_enabled")

    @JvmField
    public val setHitFromInsideName: MethodStringName1<RayCast2D, Unit, Boolean> =
        MethodStringName1<RayCast2D, Unit, Boolean>("set_hit_from_inside")

    @JvmField
    public val isHitFromInsideEnabledName: MethodStringName0<RayCast2D, Boolean> =
        MethodStringName0<RayCast2D, Boolean>("is_hit_from_inside_enabled")
  }

  public object MethodBindings {
    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "is_enabled", 36873697)

    internal val setTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_target_position", 743155724)

    internal val getTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_target_position", 3341600327)

    internal val isCollidingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "is_colliding", 36873697)

    internal val forceRaycastUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "force_raycast_update", 3218959716)

    internal val getColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collider", 1981248198)

    internal val getColliderRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collider_rid", 2944877500)

    internal val getColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collider_shape", 3905245786)

    internal val getCollisionPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collision_point", 3341600327)

    internal val getCollisionNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collision_normal", 3341600327)

    internal val addExceptionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "add_exception_rid", 2722037293)

    internal val addExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "add_exception", 3090941106)

    internal val removeExceptionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "remove_exception_rid", 2722037293)

    internal val removeExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "remove_exception", 3090941106)

    internal val clearExceptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "clear_exceptions", 3218959716)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collision_mask", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_collision_mask_value", 1116898809)

    internal val setExcludeParentBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_exclude_parent_body", 2586408642)

    internal val getExcludeParentBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "get_exclude_parent_body", 36873697)

    internal val setCollideWithAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_collide_with_areas", 2586408642)

    internal val isCollideWithAreasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "is_collide_with_areas_enabled", 36873697)

    internal val setCollideWithBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_collide_with_bodies", 2586408642)

    internal val isCollideWithBodiesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "is_collide_with_bodies_enabled", 36873697)

    internal val setHitFromInsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "set_hit_from_inside", 2586408642)

    internal val isHitFromInsideEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast2D", "is_hit_from_inside_enabled", 36873697)
  }
}
