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
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * By changing various properties of this object, such as the point position, you can configure the
 * parameters for [PhysicsDirectSpaceState2D.intersectPoint].
 */
@GodotBaseType
public open class PhysicsPointQueryParameters2D : RefCounted() {
  /**
   * The position being queried for, in global coordinates.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var position: Vector2
    @JvmName("positionProperty")
    get() = getPosition()
    @JvmName("positionProperty")
    set(`value`) {
      setPosition(value)
    }

  /**
   * If different from `0`, restricts the query to a specific canvas layer specified by its instance
   * ID. See [Object.getInstanceId].
   *
   * If `0`, restricts the query to the Viewport's default canvas layer.
   */
  public final inline var canvasInstanceId: Long
    @JvmName("canvasInstanceIdProperty")
    get() = getCanvasInstanceId()
    @JvmName("canvasInstanceIdProperty")
    set(`value`) {
      setCanvasInstanceId(value)
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
   * The list of object [RID]s that will be excluded from collisions. Use [CollisionObject2D.getRid]
   * to get the [RID] associated with a [CollisionObject2D]-derived node.
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
   * If `true`, the query will take [PhysicsBody2D]s into account.
   */
  public final inline var collideWithBodies: Boolean
    @JvmName("collideWithBodiesProperty")
    get() = isCollideWithBodiesEnabled()
    @JvmName("collideWithBodiesProperty")
    set(`value`) {
      setCollideWithBodies(value)
    }

  /**
   * If `true`, the query will take [Area2D]s into account.
   */
  public final inline var collideWithAreas: Boolean
    @JvmName("collideWithAreasProperty")
    get() = isCollideWithAreasEnabled()
    @JvmName("collideWithAreasProperty")
    set(`value`) {
      setCollideWithAreas(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(535, scriptPtr)
  }

  /**
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicspointqueryparameters2d.position
   * //Your changes
   * physicspointqueryparameters2d.position = myCoreType
   * ``````
   *
   * The position being queried for, in global coordinates.
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector2.() -> Unit): Vector2 = position.apply {
     block(this)
     position = this
  }

  public final fun setPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  public final fun getPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setCanvasInstanceId(canvasInstanceId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to canvasInstanceId)
    TransferContext.callMethod(MethodBindings.setCanvasInstanceIdPtr)
  }

  public final fun getCanvasInstanceId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
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

  public companion object {
    @JvmField
    public val setPositionName: MethodStringName1<PhysicsPointQueryParameters2D, Unit, Vector2> =
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, Vector2>("set_position")

    @JvmField
    public val getPositionName: MethodStringName0<PhysicsPointQueryParameters2D, Vector2> =
        MethodStringName0<PhysicsPointQueryParameters2D, Vector2>("get_position")

    @JvmField
    public val setCanvasInstanceIdName: MethodStringName1<PhysicsPointQueryParameters2D, Unit, Long>
        = MethodStringName1<PhysicsPointQueryParameters2D, Unit, Long>("set_canvas_instance_id")

    @JvmField
    public val getCanvasInstanceIdName: MethodStringName0<PhysicsPointQueryParameters2D, Long> =
        MethodStringName0<PhysicsPointQueryParameters2D, Long>("get_canvas_instance_id")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<PhysicsPointQueryParameters2D, Unit, Long> =
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<PhysicsPointQueryParameters2D, Long> =
        MethodStringName0<PhysicsPointQueryParameters2D, Long>("get_collision_mask")

    @JvmField
    public val setExcludeName:
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, VariantArray<RID>> =
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, VariantArray<RID>>("set_exclude")

    @JvmField
    public val getExcludeName: MethodStringName0<PhysicsPointQueryParameters2D, VariantArray<RID>> =
        MethodStringName0<PhysicsPointQueryParameters2D, VariantArray<RID>>("get_exclude")

    @JvmField
    public val setCollideWithBodiesName:
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, Boolean> =
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, Boolean>("set_collide_with_bodies")

    @JvmField
    public val isCollideWithBodiesEnabledName:
        MethodStringName0<PhysicsPointQueryParameters2D, Boolean> =
        MethodStringName0<PhysicsPointQueryParameters2D, Boolean>("is_collide_with_bodies_enabled")

    @JvmField
    public val setCollideWithAreasName:
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, Boolean> =
        MethodStringName1<PhysicsPointQueryParameters2D, Unit, Boolean>("set_collide_with_areas")

    @JvmField
    public val isCollideWithAreasEnabledName:
        MethodStringName0<PhysicsPointQueryParameters2D, Boolean> =
        MethodStringName0<PhysicsPointQueryParameters2D, Boolean>("is_collide_with_areas_enabled")
  }

  public object MethodBindings {
    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "set_position", 743155724)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "get_position", 3341600327)

    internal val setCanvasInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "set_canvas_instance_id", 1286410249)

    internal val getCanvasInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "get_canvas_instance_id", 3905245786)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "get_collision_mask", 3905245786)

    internal val setExcludePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "set_exclude", 381264803)

    internal val getExcludePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "get_exclude", 3995934104)

    internal val setCollideWithBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "set_collide_with_bodies", 2586408642)

    internal val isCollideWithBodiesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "is_collide_with_bodies_enabled", 36873697)

    internal val setCollideWithAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "set_collide_with_areas", 2586408642)

    internal val isCollideWithAreasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsPointQueryParameters2D", "is_collide_with_areas_enabled", 36873697)
  }
}
