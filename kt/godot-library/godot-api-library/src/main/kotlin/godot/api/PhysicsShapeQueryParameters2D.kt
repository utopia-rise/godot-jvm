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
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * By changing various properties of this object, such as the shape, you can configure the
 * parameters for [PhysicsDirectSpaceState2D]'s methods.
 */
@GodotBaseType
public open class PhysicsShapeQueryParameters2D : RefCounted() {
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
   * The collision margin for the shape.
   */
  public final inline var margin: Float
    @JvmName("marginProperty")
    get() = getMargin()
    @JvmName("marginProperty")
    set(`value`) {
      setMargin(value)
    }

  /**
   * The motion of the shape being queried for.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var motion: Vector2
    @JvmName("motionProperty")
    get() = getMotion()
    @JvmName("motionProperty")
    set(`value`) {
      setMotion(value)
    }

  /**
   * The [Shape2D] that will be used for collision/intersection queries. This stores the actual
   * reference which avoids the shape to be released while being used for queries, so always prefer
   * using this over [shapeRid].
   */
  public final inline var shape: Resource?
    @JvmName("shapeProperty")
    get() = getShape()
    @JvmName("shapeProperty")
    set(`value`) {
      setShape(value)
    }

  /**
   * The queried shape's [RID] that will be used for collision/intersection queries. Use this over
   * [shape] if you want to optimize for performance using the Servers API:
   *
   * ```gdscript
   * //gdscript
   * var shape_rid = PhysicsServer2D.circle_shape_create()
   * var radius = 64
   * PhysicsServer2D.shape_set_data(shape_rid, radius)
   *
   * var params = PhysicsShapeQueryParameters2D.new()
   * params.shape_rid = shape_rid
   *
   * # Execute physics queries here...
   *
   * # Release the shape when done with physics queries.
   * PhysicsServer2D.free_rid(shape_rid)
   * ```
   *
   * ```csharp
   * //csharp
   * RID shapeRid = PhysicsServer2D.CircleShapeCreate();
   * int radius = 64;
   * PhysicsServer2D.ShapeSetData(shapeRid, radius);
   *
   * var params = new PhysicsShapeQueryParameters2D();
   * params.ShapeRid = shapeRid;
   *
   * // Execute physics queries here...
   *
   * // Release the shape when done with physics queries.
   * PhysicsServer2D.FreeRid(shapeRid);
   * ```
   */
  public final inline var shapeRid: RID
    @JvmName("shapeRidProperty")
    get() = getShapeRid()
    @JvmName("shapeRidProperty")
    set(`value`) {
      setShapeRid(value)
    }

  /**
   * The queried shape's transform matrix.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var transform: Transform2D
    @JvmName("transformProperty")
    get() = getTransform()
    @JvmName("transformProperty")
    set(`value`) {
      setTransform(value)
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
    createNativeObject(544, scriptPtr)
  }

  /**
   * This is a helper function for [motion] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsshapequeryparameters2d.motion
   * //Your changes
   * physicsshapequeryparameters2d.motion = myCoreType
   * ``````
   *
   * The motion of the shape being queried for.
   */
  @CoreTypeHelper
  public final fun motionMutate(block: Vector2.() -> Unit): Vector2 = motion.apply {
     block(this)
     motion = this
  }

  /**
   * This is a helper function for [transform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicsshapequeryparameters2d.transform
   * //Your changes
   * physicsshapequeryparameters2d.transform = myCoreType
   * ``````
   *
   * The queried shape's transform matrix.
   */
  @CoreTypeHelper
  public final fun transformMutate(block: Transform2D.() -> Unit): Transform2D = transform.apply {
     block(this)
     transform = this
  }

  public final fun setShape(shape: Resource?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shape)
    TransferContext.callMethod(MethodBindings.setShapePtr)
  }

  public final fun getShape(): Resource? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapePtr)
    return (TransferContext.readReturnValue(OBJECT) as Resource?)
  }

  public final fun setShapeRid(shape: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shape)
    TransferContext.callMethod(MethodBindings.setShapeRidPtr)
  }

  public final fun getShapeRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapeRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setTransform(transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  public final fun getTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  public final fun setMotion(motion: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to motion)
    TransferContext.callMethod(MethodBindings.setMotionPtr)
  }

  public final fun getMotion(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.setMarginPtr)
  }

  public final fun getMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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
    public val setShapeName: MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Resource?> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Resource?>("set_shape")

    @JvmField
    public val getShapeName: MethodStringName0<PhysicsShapeQueryParameters2D, Resource?> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Resource?>("get_shape")

    @JvmField
    public val setShapeRidName: MethodStringName1<PhysicsShapeQueryParameters2D, Unit, RID> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, RID>("set_shape_rid")

    @JvmField
    public val getShapeRidName: MethodStringName0<PhysicsShapeQueryParameters2D, RID> =
        MethodStringName0<PhysicsShapeQueryParameters2D, RID>("get_shape_rid")

    @JvmField
    public val setTransformName: MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Transform2D>
        = MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Transform2D>("set_transform")

    @JvmField
    public val getTransformName: MethodStringName0<PhysicsShapeQueryParameters2D, Transform2D> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Transform2D>("get_transform")

    @JvmField
    public val setMotionName: MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Vector2> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Vector2>("set_motion")

    @JvmField
    public val getMotionName: MethodStringName0<PhysicsShapeQueryParameters2D, Vector2> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Vector2>("get_motion")

    @JvmField
    public val setMarginName: MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Float> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Float>("set_margin")

    @JvmField
    public val getMarginName: MethodStringName0<PhysicsShapeQueryParameters2D, Float> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Float>("get_margin")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Long> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<PhysicsShapeQueryParameters2D, Long> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Long>("get_collision_mask")

    @JvmField
    public val setExcludeName:
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, VariantArray<RID>> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, VariantArray<RID>>("set_exclude")

    @JvmField
    public val getExcludeName: MethodStringName0<PhysicsShapeQueryParameters2D, VariantArray<RID>> =
        MethodStringName0<PhysicsShapeQueryParameters2D, VariantArray<RID>>("get_exclude")

    @JvmField
    public val setCollideWithBodiesName:
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Boolean> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Boolean>("set_collide_with_bodies")

    @JvmField
    public val isCollideWithBodiesEnabledName:
        MethodStringName0<PhysicsShapeQueryParameters2D, Boolean> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Boolean>("is_collide_with_bodies_enabled")

    @JvmField
    public val setCollideWithAreasName:
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Boolean> =
        MethodStringName1<PhysicsShapeQueryParameters2D, Unit, Boolean>("set_collide_with_areas")

    @JvmField
    public val isCollideWithAreasEnabledName:
        MethodStringName0<PhysicsShapeQueryParameters2D, Boolean> =
        MethodStringName0<PhysicsShapeQueryParameters2D, Boolean>("is_collide_with_areas_enabled")
  }

  public object MethodBindings {
    internal val setShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_shape", 968641751)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_shape", 121922552)

    internal val setShapeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_shape_rid", 2722037293)

    internal val getShapeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_shape_rid", 2944877500)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_transform", 2761652528)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_transform", 3814499831)

    internal val setMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_motion", 743155724)

    internal val getMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_motion", 3341600327)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_margin", 373806689)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_margin", 1740695150)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_collision_mask", 3905245786)

    internal val setExcludePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_exclude", 381264803)

    internal val getExcludePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "get_exclude", 3995934104)

    internal val setCollideWithBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_collide_with_bodies", 2586408642)

    internal val isCollideWithBodiesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "is_collide_with_bodies_enabled", 36873697)

    internal val setCollideWithAreasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "set_collide_with_areas", 2586408642)

    internal val isCollideWithAreasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsShapeQueryParameters2D", "is_collide_with_areas_enabled", 36873697)
  }
}
