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
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
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
 * By changing various properties of this object, such as the motion, you can configure the
 * parameters for [PhysicsServer2D.bodyTestMotion].
 */
@GodotBaseType
public open class PhysicsTestMotionParameters2D : RefCounted() {
  /**
   * Transform in global space where the motion should start. Usually set to
   * [Node2D.globalTransform] for the current body's transform.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var from: Transform2D
    @JvmName("fromProperty")
    get() = getFrom()
    @JvmName("fromProperty")
    set(`value`) {
      setFrom(value)
    }

  /**
   * Motion vector to define the length and direction of the motion to test.
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
   * Increases the size of the shapes involved in the collision detection.
   */
  public final inline var margin: Float
    @JvmName("marginProperty")
    get() = getMargin()
    @JvmName("marginProperty")
    set(`value`) {
      setMargin(value)
    }

  /**
   * If set to `true`, shapes of type [PhysicsServer2D.SHAPE_SEPARATION_RAY] are used to detect
   * collisions and can stop the motion. Can be useful when snapping to the ground.
   *
   * If set to `false`, shapes of type [PhysicsServer2D.SHAPE_SEPARATION_RAY] are only used for
   * separation when overlapping with other bodies. That's the main use for separation ray shapes.
   */
  public final inline var collideSeparationRay: Boolean
    @JvmName("collideSeparationRayProperty")
    get() = isCollideSeparationRayEnabled()
    @JvmName("collideSeparationRayProperty")
    set(`value`) {
      setCollideSeparationRayEnabled(value)
    }

  /**
   * Optional array of body [RID] to exclude from collision. Use [CollisionObject2D.getRid] to get
   * the [RID] associated with a [CollisionObject2D]-derived node.
   */
  public final inline var excludeBodies: VariantArray<RID>
    @JvmName("excludeBodiesProperty")
    get() = getExcludeBodies()
    @JvmName("excludeBodiesProperty")
    set(`value`) {
      setExcludeBodies(value)
    }

  /**
   * Optional array of object unique instance ID to exclude from collision. See
   * [Object.getInstanceId].
   */
  public final inline var excludeObjects: VariantArray<Long>
    @JvmName("excludeObjectsProperty")
    get() = getExcludeObjects()
    @JvmName("excludeObjectsProperty")
    set(`value`) {
      setExcludeObjects(value)
    }

  /**
   * If set to `true`, any depenetration from the recovery phase is reported as a collision; this is
   * used e.g. by [CharacterBody2D] for improving floor detection during floor snapping.
   *
   * If set to `false`, only collisions resulting from the motion are reported, which is generally
   * the desired behavior.
   */
  public final inline var recoveryAsCollision: Boolean
    @JvmName("recoveryAsCollisionProperty")
    get() = isRecoveryAsCollisionEnabled()
    @JvmName("recoveryAsCollisionProperty")
    set(`value`) {
      setRecoveryAsCollisionEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(546, scriptPtr)
  }

  /**
   * This is a helper function for [from] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicstestmotionparameters2d.from
   * //Your changes
   * physicstestmotionparameters2d.from = myCoreType
   * ``````
   *
   * Transform in global space where the motion should start. Usually set to
   * [Node2D.globalTransform] for the current body's transform.
   */
  @CoreTypeHelper
  public final fun fromMutate(block: Transform2D.() -> Unit): Transform2D = from.apply {
     block(this)
     from = this
  }

  /**
   * This is a helper function for [motion] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicstestmotionparameters2d.motion
   * //Your changes
   * physicstestmotionparameters2d.motion = myCoreType
   * ``````
   *
   * Motion vector to define the length and direction of the motion to test.
   */
  @CoreTypeHelper
  public final fun motionMutate(block: Vector2.() -> Unit): Vector2 = motion.apply {
     block(this)
     motion = this
  }

  public final fun getFrom(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFromPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  public final fun setFrom(from: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to from)
    TransferContext.callMethod(MethodBindings.setFromPtr)
  }

  public final fun getMotion(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMotion(motion: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to motion)
    TransferContext.callMethod(MethodBindings.setMotionPtr)
  }

  public final fun getMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.setMarginPtr)
  }

  public final fun isCollideSeparationRayEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollideSeparationRayEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollideSeparationRayEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCollideSeparationRayEnabledPtr)
  }

  public final fun getExcludeBodies(): VariantArray<RID> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludeBodiesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<RID>)
  }

  public final fun setExcludeBodies(excludeList: VariantArray<RID>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to excludeList)
    TransferContext.callMethod(MethodBindings.setExcludeBodiesPtr)
  }

  public final fun getExcludeObjects(): VariantArray<Long> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludeObjectsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Long>)
  }

  public final fun setExcludeObjects(excludeList: VariantArray<Long>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to excludeList)
    TransferContext.callMethod(MethodBindings.setExcludeObjectsPtr)
  }

  public final fun isRecoveryAsCollisionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRecoveryAsCollisionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRecoveryAsCollisionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRecoveryAsCollisionEnabledPtr)
  }

  public companion object {
    @JvmField
    public val getFromName: MethodStringName0<PhysicsTestMotionParameters2D, Transform2D> =
        MethodStringName0<PhysicsTestMotionParameters2D, Transform2D>("get_from")

    @JvmField
    public val setFromName: MethodStringName1<PhysicsTestMotionParameters2D, Unit, Transform2D> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Transform2D>("set_from")

    @JvmField
    public val getMotionName: MethodStringName0<PhysicsTestMotionParameters2D, Vector2> =
        MethodStringName0<PhysicsTestMotionParameters2D, Vector2>("get_motion")

    @JvmField
    public val setMotionName: MethodStringName1<PhysicsTestMotionParameters2D, Unit, Vector2> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Vector2>("set_motion")

    @JvmField
    public val getMarginName: MethodStringName0<PhysicsTestMotionParameters2D, Float> =
        MethodStringName0<PhysicsTestMotionParameters2D, Float>("get_margin")

    @JvmField
    public val setMarginName: MethodStringName1<PhysicsTestMotionParameters2D, Unit, Float> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Float>("set_margin")

    @JvmField
    public val isCollideSeparationRayEnabledName:
        MethodStringName0<PhysicsTestMotionParameters2D, Boolean> =
        MethodStringName0<PhysicsTestMotionParameters2D, Boolean>("is_collide_separation_ray_enabled")

    @JvmField
    public val setCollideSeparationRayEnabledName:
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Boolean> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Boolean>("set_collide_separation_ray_enabled")

    @JvmField
    public val getExcludeBodiesName:
        MethodStringName0<PhysicsTestMotionParameters2D, VariantArray<RID>> =
        MethodStringName0<PhysicsTestMotionParameters2D, VariantArray<RID>>("get_exclude_bodies")

    @JvmField
    public val setExcludeBodiesName:
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, VariantArray<RID>> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, VariantArray<RID>>("set_exclude_bodies")

    @JvmField
    public val getExcludeObjectsName:
        MethodStringName0<PhysicsTestMotionParameters2D, VariantArray<Long>> =
        MethodStringName0<PhysicsTestMotionParameters2D, VariantArray<Long>>("get_exclude_objects")

    @JvmField
    public val setExcludeObjectsName:
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, VariantArray<Long>> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, VariantArray<Long>>("set_exclude_objects")

    @JvmField
    public val isRecoveryAsCollisionEnabledName:
        MethodStringName0<PhysicsTestMotionParameters2D, Boolean> =
        MethodStringName0<PhysicsTestMotionParameters2D, Boolean>("is_recovery_as_collision_enabled")

    @JvmField
    public val setRecoveryAsCollisionEnabledName:
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Boolean> =
        MethodStringName1<PhysicsTestMotionParameters2D, Unit, Boolean>("set_recovery_as_collision_enabled")
  }

  public object MethodBindings {
    internal val getFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "get_from", 3814499831)

    internal val setFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_from", 2761652528)

    internal val getMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "get_motion", 3341600327)

    internal val setMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_motion", 743155724)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "get_margin", 1740695150)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_margin", 373806689)

    internal val isCollideSeparationRayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "is_collide_separation_ray_enabled", 36873697)

    internal val setCollideSeparationRayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_collide_separation_ray_enabled", 2586408642)

    internal val getExcludeBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "get_exclude_bodies", 3995934104)

    internal val setExcludeBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_exclude_bodies", 381264803)

    internal val getExcludeObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "get_exclude_objects", 3995934104)

    internal val setExcludeObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_exclude_objects", 381264803)

    internal val isRecoveryAsCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "is_recovery_as_collision_enabled", 36873697)

    internal val setRecoveryAsCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters2D", "set_recovery_as_collision_enabled", 2586408642)
  }
}
