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
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Vector3
import godot.readReturnValue_BOOL
import godot.readReturnValue_COLOR
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_COLOR
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_VECTOR3
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
 * [RayCast3D] can ignore some objects by adding them to an exception list, by making its detection
 * reporting ignore [Area3D]s ([collideWithAreas]) or [PhysicsBody3D]s ([collideWithBodies]), or by
 * configuring physics layers.
 *
 * [RayCast3D] calculates intersection every physics frame, and it holds the result until the next
 * physics frame. For an immediate raycast, or if you want to configure a [RayCast3D] multiple times
 * within the same physics frame, use [forceRaycastUpdate].
 *
 * To sweep over a region of 3D space, you can approximate the region with multiple [RayCast3D]s or
 * use [ShapeCast3D].
 */
@GodotBaseType
public open class RayCast3D : Node3D() {
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
   * an effect if the parent node is a [CollisionObject3D]. See also [Node.getParent] and
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
   * The ray's destination point, relative to this raycast's [Node3D.position].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var targetPosition: Vector3
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
   * normal will be `Vector3(0, 0, 0)`. Does not affect shapes with no volume like concave polygon or
   * heightmap.
   */
  public final inline var hitFromInside: Boolean
    @JvmName("hitFromInsideProperty")
    get() = isHitFromInsideEnabled()
    @JvmName("hitFromInsideProperty")
    set(`value`) {
      setHitFromInside(value)
    }

  /**
   * If `true`, the ray will hit back faces with concave polygon shapes with back face enabled or
   * heightmap shapes.
   */
  public final inline var hitBackFaces: Boolean
    @JvmName("hitBackFacesProperty")
    get() = isHitBackFacesEnabled()
    @JvmName("hitBackFacesProperty")
    set(`value`) {
      setHitBackFaces(value)
    }

  /**
   * If `true`, collisions with [Area3D]s will be reported.
   */
  public final inline var collideWithAreas: Boolean
    @JvmName("collideWithAreasProperty")
    get() = isCollideWithAreasEnabled()
    @JvmName("collideWithAreasProperty")
    set(`value`) {
      setCollideWithAreas(value)
    }

  /**
   * If `true`, collisions with [PhysicsBody3D]s will be reported.
   */
  public final inline var collideWithBodies: Boolean
    @JvmName("collideWithBodiesProperty")
    get() = isCollideWithBodiesEnabled()
    @JvmName("collideWithBodiesProperty")
    set(`value`) {
      setCollideWithBodies(value)
    }

  /**
   * The custom color to use to draw the shape in the editor and at run-time if **Visible Collision
   * Shapes** is enabled in the **Debug** menu. This color will be highlighted at run-time if the
   * [RayCast3D] is colliding with something.
   *
   * If set to `Color(0.0, 0.0, 0.0)` (by default), the color set in
   * [ProjectSettings.debug/shapes/collision/shapeColor] is used.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var debugShapeCustomColor: Color
    @JvmName("debugShapeCustomColorProperty")
    get() = getDebugShapeCustomColor()
    @JvmName("debugShapeCustomColorProperty")
    set(`value`) {
      setDebugShapeCustomColor(value)
    }

  /**
   * If set to `1`, a line is used as the debug shape. Otherwise, a truncated pyramid is drawn to
   * represent the [RayCast3D]. Requires **Visible Collision Shapes** to be enabled in the **Debug**
   * menu for the debug shape to be visible at run-time.
   */
  public final inline var debugShapeThickness: Int
    @JvmName("debugShapeThicknessProperty")
    get() = getDebugShapeThickness()
    @JvmName("debugShapeThicknessProperty")
    set(`value`) {
      setDebugShapeThickness(value)
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
   * val myCoreType = raycast3d.targetPosition
   * //Your changes
   * raycast3d.targetPosition = myCoreType
   * ``````
   *
   * The ray's destination point, relative to this raycast's [Node3D.position].
   */
  @CoreTypeHelper
  public final fun targetPositionMutate(block: Vector3.() -> Unit): Vector3 = targetPosition.apply {
     block(this)
     targetPosition = this
  }

  /**
   * This is a helper function for [debugShapeCustomColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = raycast3d.debugShapeCustomColor
   * //Your changes
   * raycast3d.debugShapeCustomColor = myCoreType
   * ``````
   *
   * The custom color to use to draw the shape in the editor and at run-time if **Visible Collision
   * Shapes** is enabled in the **Debug** menu. This color will be highlighted at run-time if the
   * [RayCast3D] is colliding with something.
   *
   * If set to `Color(0.0, 0.0, 0.0)` (by default), the color set in
   * [ProjectSettings.debug/shapes/collision/shapeColor] is used.
   */
  @CoreTypeHelper
  public final fun debugShapeCustomColorMutate(block: Color.() -> Unit): Color =
      debugShapeCustomColor.apply {
     block(this)
     debugShapeCustomColor = this
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

  public final fun setTargetPosition(localPoint: Vector3): Unit {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, localPoint)
    TransferContext.callPtrMethod(MethodBindings.setTargetPositionPtr, 0)
  }

  public final fun getTargetPosition(): Vector3 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTargetPositionPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns whether any object is intersecting with the ray's vector (considering the vector
   * length).
   */
  public final fun isColliding(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCollidingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Updates the collision information for the ray immediately, without waiting for the next
   * `_physics_process` call. Use this method, for example, when the ray or its parent has changed
   * state.
   *
   * **Note:** [enabled] does not need to be `true` for this to work.
   */
  public final fun forceRaycastUpdate(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.forceRaycastUpdatePtr, 0)
  }

  /**
   * Returns the first object that the ray intersects, or `null` if no object is intersecting the
   * ray (i.e. [isColliding] returns `false`).
   *
   * **Note:** This object is not guaranteed to be a [CollisionObject3D]. For example, if the ray
   * intersects a [CSGShape3D] or a [GridMap], the method will return a [CSGShape3D] or [GridMap]
   * instance.
   */
  public final fun getCollider(): Object? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Object?)
  }

  /**
   * Returns the [RID] of the first object that the ray intersects, or an empty [RID] if no object
   * is intersecting the ray (i.e. [isColliding] returns `false`).
   */
  public final fun getColliderRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the shape ID of the first object that the ray intersects, or `0` if no object is
   * intersecting the ray (i.e. [isColliding] returns `false`).
   *
   * To get the intersected shape node, for a [CollisionObject3D] target, use:
   *
   * ```gdscript
   * //gdscript
   * var target = get_collider() # A CollisionObject3D.
   * var shape_id = get_collider_shape() # The shape index in the collider.
   * var owner_id = target.shape_find_owner(shape_id) # The owner ID in the collider.
   * var shape = target.shape_owner_get_owner(owner_id)
   * ```
   *
   * ```csharp
   * //csharp
   * var target = (CollisionObject3D)GetCollider(); // A CollisionObject3D.
   * var shapeId = GetColliderShape(); // The shape index in the collider.
   * var ownerId = target.ShapeFindOwner(shapeId); // The owner ID in the collider.
   * var shape = target.ShapeOwnerGetOwner(ownerId);
   * ```
   */
  public final fun getColliderShape(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColliderShapePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the collision point at which the ray intersects the closest object, in the global
   * coordinate system. If [hitFromInside] is `true` and the ray starts inside of a collision shape,
   * this function will return the origin point of the ray.
   *
   * **Note:** Check that [isColliding] returns `true` before calling this method to ensure the
   * returned point is valid and up-to-date.
   */
  public final fun getCollisionPoint(): Vector3 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionPointPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the normal of the intersecting object's shape at the collision point, or `Vector3(0, 0,
   * 0)` if the ray starts inside the shape and [hitFromInside] is `true`.
   *
   * **Note:** Check that [isColliding] returns `true` before calling this method to ensure the
   * returned normal is valid and up-to-date.
   */
  public final fun getCollisionNormal(): Vector3 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionNormalPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the collision object's face index at the collision point, or `-1` if the shape
   * intersecting the ray is not a [ConcavePolygonShape3D].
   */
  public final fun getCollisionFaceIndex(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionFaceIndexPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a collision exception so the ray does not report collisions with the specified [RID].
   */
  public final fun addExceptionRid(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callPtrMethod(MethodBindings.addExceptionRidPtr, 0)
  }

  /**
   * Adds a collision exception so the ray does not report collisions with the specified [node].
   */
  public final fun addException(node: CollisionObject3D): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, node)
    TransferContext.callPtrMethod(MethodBindings.addExceptionPtr, 0)
  }

  /**
   * Removes a collision exception so the ray can report collisions with the specified [RID].
   */
  public final fun removeExceptionRid(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callPtrMethod(MethodBindings.removeExceptionRidPtr, 0)
  }

  /**
   * Removes a collision exception so the ray can report collisions with the specified [node].
   */
  public final fun removeException(node: CollisionObject3D): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, node)
    TransferContext.callPtrMethod(MethodBindings.removeExceptionPtr, 0)
  }

  /**
   * Removes all collision exceptions for this ray.
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

  public final fun setHitFromInside(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setHitFromInsidePtr, 0)
  }

  public final fun isHitFromInsideEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isHitFromInsideEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setHitBackFaces(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setHitBackFacesPtr, 0)
  }

  public final fun isHitBackFacesEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isHitBackFacesEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDebugShapeCustomColor(debugShapeCustomColor: Color): Unit {
    TransferContext.writeMethodArguments_COLOR(ptr, objectID.id, debugShapeCustomColor)
    TransferContext.callPtrMethod(MethodBindings.setDebugShapeCustomColorPtr, 0)
  }

  public final fun getDebugShapeCustomColor(): Color {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDebugShapeCustomColorPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  public final fun setDebugShapeThickness(debugShapeThickness: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, debugShapeThickness.toLong())
    TransferContext.callPtrMethod(MethodBindings.setDebugShapeThicknessPtr, 0)
  }

  public final fun getDebugShapeThickness(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDebugShapeThicknessPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setEnabledName: MethodStringName1<RayCast3D, Unit, Boolean> =
        MethodStringName1<RayCast3D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("is_enabled")

    @JvmField
    public val setTargetPositionName: MethodStringName1<RayCast3D, Unit, Vector3> =
        MethodStringName1<RayCast3D, Unit, Vector3>("set_target_position")

    @JvmField
    public val getTargetPositionName: MethodStringName0<RayCast3D, Vector3> =
        MethodStringName0<RayCast3D, Vector3>("get_target_position")

    @JvmField
    public val isCollidingName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("is_colliding")

    @JvmField
    public val forceRaycastUpdateName: MethodStringName0<RayCast3D, Unit> =
        MethodStringName0<RayCast3D, Unit>("force_raycast_update")

    @JvmField
    public val getColliderName: MethodStringName0<RayCast3D, Object?> =
        MethodStringName0<RayCast3D, Object?>("get_collider")

    @JvmField
    public val getColliderRidName: MethodStringName0<RayCast3D, RID> =
        MethodStringName0<RayCast3D, RID>("get_collider_rid")

    @JvmField
    public val getColliderShapeName: MethodStringName0<RayCast3D, Int> =
        MethodStringName0<RayCast3D, Int>("get_collider_shape")

    @JvmField
    public val getCollisionPointName: MethodStringName0<RayCast3D, Vector3> =
        MethodStringName0<RayCast3D, Vector3>("get_collision_point")

    @JvmField
    public val getCollisionNormalName: MethodStringName0<RayCast3D, Vector3> =
        MethodStringName0<RayCast3D, Vector3>("get_collision_normal")

    @JvmField
    public val getCollisionFaceIndexName: MethodStringName0<RayCast3D, Int> =
        MethodStringName0<RayCast3D, Int>("get_collision_face_index")

    @JvmField
    public val addExceptionRidName: MethodStringName1<RayCast3D, Unit, RID> =
        MethodStringName1<RayCast3D, Unit, RID>("add_exception_rid")

    @JvmField
    public val addExceptionName: MethodStringName1<RayCast3D, Unit, CollisionObject3D> =
        MethodStringName1<RayCast3D, Unit, CollisionObject3D>("add_exception")

    @JvmField
    public val removeExceptionRidName: MethodStringName1<RayCast3D, Unit, RID> =
        MethodStringName1<RayCast3D, Unit, RID>("remove_exception_rid")

    @JvmField
    public val removeExceptionName: MethodStringName1<RayCast3D, Unit, CollisionObject3D> =
        MethodStringName1<RayCast3D, Unit, CollisionObject3D>("remove_exception")

    @JvmField
    public val clearExceptionsName: MethodStringName0<RayCast3D, Unit> =
        MethodStringName0<RayCast3D, Unit>("clear_exceptions")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<RayCast3D, Unit, Long> =
        MethodStringName1<RayCast3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<RayCast3D, Long> =
        MethodStringName0<RayCast3D, Long>("get_collision_mask")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<RayCast3D, Unit, Int, Boolean> =
        MethodStringName2<RayCast3D, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<RayCast3D, Boolean, Int> =
        MethodStringName1<RayCast3D, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setExcludeParentBodyName: MethodStringName1<RayCast3D, Unit, Boolean> =
        MethodStringName1<RayCast3D, Unit, Boolean>("set_exclude_parent_body")

    @JvmField
    public val getExcludeParentBodyName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("get_exclude_parent_body")

    @JvmField
    public val setCollideWithAreasName: MethodStringName1<RayCast3D, Unit, Boolean> =
        MethodStringName1<RayCast3D, Unit, Boolean>("set_collide_with_areas")

    @JvmField
    public val isCollideWithAreasEnabledName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("is_collide_with_areas_enabled")

    @JvmField
    public val setCollideWithBodiesName: MethodStringName1<RayCast3D, Unit, Boolean> =
        MethodStringName1<RayCast3D, Unit, Boolean>("set_collide_with_bodies")

    @JvmField
    public val isCollideWithBodiesEnabledName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("is_collide_with_bodies_enabled")

    @JvmField
    public val setHitFromInsideName: MethodStringName1<RayCast3D, Unit, Boolean> =
        MethodStringName1<RayCast3D, Unit, Boolean>("set_hit_from_inside")

    @JvmField
    public val isHitFromInsideEnabledName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("is_hit_from_inside_enabled")

    @JvmField
    public val setHitBackFacesName: MethodStringName1<RayCast3D, Unit, Boolean> =
        MethodStringName1<RayCast3D, Unit, Boolean>("set_hit_back_faces")

    @JvmField
    public val isHitBackFacesEnabledName: MethodStringName0<RayCast3D, Boolean> =
        MethodStringName0<RayCast3D, Boolean>("is_hit_back_faces_enabled")

    @JvmField
    public val setDebugShapeCustomColorName: MethodStringName1<RayCast3D, Unit, Color> =
        MethodStringName1<RayCast3D, Unit, Color>("set_debug_shape_custom_color")

    @JvmField
    public val getDebugShapeCustomColorName: MethodStringName0<RayCast3D, Color> =
        MethodStringName0<RayCast3D, Color>("get_debug_shape_custom_color")

    @JvmField
    public val setDebugShapeThicknessName: MethodStringName1<RayCast3D, Unit, Int> =
        MethodStringName1<RayCast3D, Unit, Int>("set_debug_shape_thickness")

    @JvmField
    public val getDebugShapeThicknessName: MethodStringName0<RayCast3D, Int> =
        MethodStringName0<RayCast3D, Int>("get_debug_shape_thickness")
  }

  public object MethodBindings {
    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "is_enabled", 36873697)

    internal val setTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_target_position", 3460891852)

    internal val getTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_target_position", 3360562783)

    internal val isCollidingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "is_colliding", 36873697)

    internal val forceRaycastUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "force_raycast_update", 3218959716)

    internal val getColliderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collider", 1981248198)

    internal val getColliderRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collider_rid", 2944877500)

    internal val getColliderShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collider_shape", 3905245786)

    internal val getCollisionPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collision_point", 3360562783)

    internal val getCollisionNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collision_normal", 3360562783)

    internal val getCollisionFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collision_face_index", 3905245786)

    internal val addExceptionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "add_exception_rid", 2722037293)

    internal val addExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "add_exception", 1976431078)

    internal val removeExceptionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "remove_exception_rid", 2722037293)

    internal val removeExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "remove_exception", 1976431078)

    internal val clearExceptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "clear_exceptions", 3218959716)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collision_mask", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_collision_mask_value", 1116898809)

    internal val setExcludeParentBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_exclude_parent_body", 2586408642)

    internal val getExcludeParentBodyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_exclude_parent_body", 36873697)

    internal val setCollideWithAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_collide_with_areas", 2586408642)

    internal val isCollideWithAreasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "is_collide_with_areas_enabled", 36873697)

    internal val setCollideWithBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_collide_with_bodies", 2586408642)

    internal val isCollideWithBodiesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "is_collide_with_bodies_enabled", 36873697)

    internal val setHitFromInsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_hit_from_inside", 2586408642)

    internal val isHitFromInsideEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "is_hit_from_inside_enabled", 36873697)

    internal val setHitBackFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_hit_back_faces", 2586408642)

    internal val isHitBackFacesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "is_hit_back_faces_enabled", 36873697)

    internal val setDebugShapeCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_debug_shape_custom_color", 2920490490)

    internal val getDebugShapeCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_debug_shape_custom_color", 3444240500)

    internal val setDebugShapeThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "set_debug_shape_thickness", 1286410249)

    internal val getDebugShapeThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RayCast3D", "get_debug_shape_thickness", 3905245786)
  }
}
