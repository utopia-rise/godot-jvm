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
import godot.core.MethodStringName4
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * By changing various properties of this object, such as the ray position, you can configure the
 * parameters for [PhysicsDirectSpaceState3D.intersectRay].
 */
@GodotBaseType
public open class PhysicsRayQueryParameters3D : RefCounted() {
  /**
   * The starting point of the ray being queried for, in global coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var from: Vector3
    @JvmName("fromProperty")
    get() = getFrom()
    @JvmName("fromProperty")
    set(`value`) {
      setFrom(value)
    }

  /**
   * The ending point of the ray being queried for, in global coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var to: Vector3
    @JvmName("toProperty")
    get() = getTo()
    @JvmName("toProperty")
    set(`value`) {
      setTo(value)
    }

  /**
   * The physics layers the query will detect (as a bitmask). By default, all collision layers are
   * detected. See
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
   * The list of object [RID]s that will be excluded from collisions. Use [CollisionObject3D.getRid]
   * to get the [RID] associated with a [CollisionObject3D]-derived node.
   *
   * **Note:** The returned array is copied and any changes to it will not update the original
   * property value. To update the value you need to modify the returned array, and then assign it to
   * the property again.
   */
  public final inline var exclude: VariantArray<RID>
    @JvmName("excludeProperty")
    get() = getExclude()
    @JvmName("excludeProperty")
    set(`value`) {
      setExclude(value)
    }

  /**
   * If `true`, the query will take [PhysicsBody3D]s into account.
   */
  public final inline var collideWithBodies: Boolean
    @JvmName("collideWithBodiesProperty")
    get() = isCollideWithBodiesEnabled()
    @JvmName("collideWithBodiesProperty")
    set(`value`) {
      setCollideWithBodies(value)
    }

  /**
   * If `true`, the query will take [Area3D]s into account.
   */
  public final inline var collideWithAreas: Boolean
    @JvmName("collideWithAreasProperty")
    get() = isCollideWithAreasEnabled()
    @JvmName("collideWithAreasProperty")
    set(`value`) {
      setCollideWithAreas(value)
    }

  /**
   * If `true`, the query will detect a hit when starting inside shapes. In this case the collision
   * normal will be `Vector3(0, 0, 0)`. Does not affect concave polygon shapes or heightmap shapes.
   */
  public final inline var hitFromInside: Boolean
    @JvmName("hitFromInsideProperty")
    get() = isHitFromInsideEnabled()
    @JvmName("hitFromInsideProperty")
    set(`value`) {
      setHitFromInside(value)
    }

  /**
   * If `true`, the query will hit back faces with concave polygon shapes with back face enabled or
   * heightmap shapes.
   */
  public final inline var hitBackFaces: Boolean
    @JvmName("hitBackFacesProperty")
    get() = isHitBackFacesEnabled()
    @JvmName("hitBackFacesProperty")
    set(`value`) {
      setHitBackFaces(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(538, scriptPtr)
  }

  /**
   * This is a helper function for [from] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsrayqueryparameters3d.from
   * //Your changes
   * physicsrayqueryparameters3d.from = myCoreType
   * ``````
   *
   * The starting point of the ray being queried for, in global coordinates.
   */
  @CoreTypeHelper
  public final fun fromMutate(block: Vector3.() -> Unit): Vector3 = from.apply {
     block(this)
     from = this
  }

  /**
   * This is a helper function for [to] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsrayqueryparameters3d.to
   * //Your changes
   * physicsrayqueryparameters3d.to = myCoreType
   * ``````
   *
   * The ending point of the ray being queried for, in global coordinates.
   */
  @CoreTypeHelper
  public final fun toMutate(block: Vector3.() -> Unit): Vector3 = to.apply {
     block(this)
     to = this
  }

  public final fun setFrom(from: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to from)
    TransferContext.callMethod(MethodBindings.setFromPtr)
  }

  public final fun getFrom(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFromPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setTo(to: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to to)
    TransferContext.callMethod(MethodBindings.setToPtr)
  }

  public final fun getTo(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getToPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setCollisionMask(collisionMask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to collisionMask)
    TransferContext.callMethod(MethodBindings.setCollisionMaskPtr)
  }

  public final fun getCollisionMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setExclude(exclude: VariantArray<RID>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to exclude)
    TransferContext.callMethod(MethodBindings.setExcludePtr)
  }

  public final fun getExclude(): VariantArray<RID> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludePtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<RID>)
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

  public final fun setCollideWithAreas(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCollideWithAreasPtr)
  }

  public final fun isCollideWithAreasEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollideWithAreasEnabledPtr)
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

  public final fun setHitBackFaces(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHitBackFacesPtr)
  }

  public final fun isHitBackFacesEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHitBackFacesEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val createName:
        MethodStringName4<PhysicsRayQueryParameters3D, PhysicsRayQueryParameters3D?, Vector3, Vector3, Long, VariantArray<RID>>
        =
        MethodStringName4<PhysicsRayQueryParameters3D, PhysicsRayQueryParameters3D?, Vector3, Vector3, Long, VariantArray<RID>>("create")

    @JvmField
    public val setFromName: MethodStringName1<PhysicsRayQueryParameters3D, Unit, Vector3> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Vector3>("set_from")

    @JvmField
    public val getFromName: MethodStringName0<PhysicsRayQueryParameters3D, Vector3> =
        MethodStringName0<PhysicsRayQueryParameters3D, Vector3>("get_from")

    @JvmField
    public val setToName: MethodStringName1<PhysicsRayQueryParameters3D, Unit, Vector3> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Vector3>("set_to")

    @JvmField
    public val getToName: MethodStringName0<PhysicsRayQueryParameters3D, Vector3> =
        MethodStringName0<PhysicsRayQueryParameters3D, Vector3>("get_to")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<PhysicsRayQueryParameters3D, Unit, Long> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<PhysicsRayQueryParameters3D, Long> =
        MethodStringName0<PhysicsRayQueryParameters3D, Long>("get_collision_mask")

    @JvmField
    public val setExcludeName:
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, VariantArray<RID>> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, VariantArray<RID>>("set_exclude")

    @JvmField
    public val getExcludeName: MethodStringName0<PhysicsRayQueryParameters3D, VariantArray<RID>> =
        MethodStringName0<PhysicsRayQueryParameters3D, VariantArray<RID>>("get_exclude")

    @JvmField
    public val setCollideWithBodiesName:
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean>("set_collide_with_bodies")

    @JvmField
    public val isCollideWithBodiesEnabledName:
        MethodStringName0<PhysicsRayQueryParameters3D, Boolean> =
        MethodStringName0<PhysicsRayQueryParameters3D, Boolean>("is_collide_with_bodies_enabled")

    @JvmField
    public val setCollideWithAreasName:
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean>("set_collide_with_areas")

    @JvmField
    public val isCollideWithAreasEnabledName:
        MethodStringName0<PhysicsRayQueryParameters3D, Boolean> =
        MethodStringName0<PhysicsRayQueryParameters3D, Boolean>("is_collide_with_areas_enabled")

    @JvmField
    public val setHitFromInsideName: MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean>("set_hit_from_inside")

    @JvmField
    public val isHitFromInsideEnabledName: MethodStringName0<PhysicsRayQueryParameters3D, Boolean> =
        MethodStringName0<PhysicsRayQueryParameters3D, Boolean>("is_hit_from_inside_enabled")

    @JvmField
    public val setHitBackFacesName: MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean> =
        MethodStringName1<PhysicsRayQueryParameters3D, Unit, Boolean>("set_hit_back_faces")

    @JvmField
    public val isHitBackFacesEnabledName: MethodStringName0<PhysicsRayQueryParameters3D, Boolean> =
        MethodStringName0<PhysicsRayQueryParameters3D, Boolean>("is_hit_back_faces_enabled")

    /**
     * Returns a new, pre-configured [PhysicsRayQueryParameters3D] object. Use it to quickly create
     * query parameters using the most common options.
     *
     * ```
     * var query = PhysicsRayQueryParameters3D.create(position, position + Vector3(0, -10, 0))
     * var collision = get_world_3d().direct_space_state.intersect_ray(query)
     * ```
     */
    @JvmOverloads
    @JvmStatic
    public final fun create(
      from: Vector3,
      to: Vector3,
      collisionMask: Long = 4294967295,
      exclude: VariantArray<RID> = godot.core.variantArrayOf(),
    ): PhysicsRayQueryParameters3D? {
      TransferContext.writeMethodArguments(0L, 0L, VECTOR3 to from, VECTOR3 to to, LONG to collisionMask, ARRAY to exclude)
      TransferContext.callMethod(MethodBindings.createPtr)
      return (TransferContext.readReturnValue(OBJECT) as PhysicsRayQueryParameters3D?)
    }
  }

  public object MethodBindings {
    internal val createPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "create", 3110599579)

    internal val setFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_from", 3460891852)

    internal val getFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "get_from", 3360562783)

    internal val setToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_to", 3460891852)

    internal val getToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "get_to", 3360562783)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "get_collision_mask", 3905245786)

    internal val setExcludePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_exclude", 381264803)

    internal val getExcludePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "get_exclude", 3995934104)

    internal val setCollideWithBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_collide_with_bodies", 2586408642)

    internal val isCollideWithBodiesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "is_collide_with_bodies_enabled", 36873697)

    internal val setCollideWithAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_collide_with_areas", 2586408642)

    internal val isCollideWithAreasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "is_collide_with_areas_enabled", 36873697)

    internal val setHitFromInsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_hit_from_inside", 2586408642)

    internal val isHitFromInsideEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "is_hit_from_inside_enabled", 36873697)

    internal val setHitBackFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "set_hit_back_faces", 2586408642)

    internal val isHitBackFacesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsRayQueryParameters3D", "is_hit_back_faces_enabled", 36873697)
  }
}
