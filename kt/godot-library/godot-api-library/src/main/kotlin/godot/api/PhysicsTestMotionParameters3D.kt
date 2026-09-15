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
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector3
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_TRANSFORM3D
import godot.writeMethodArguments_VECTOR3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * By changing various properties of this object, such as the motion, you can configure the
 * parameters for [PhysicsServer3D.bodyTestMotion].
 */
@GodotBaseType
public open class PhysicsTestMotionParameters3D : RefCounted() {
  /**
   * Transform in global space where the motion should start. Usually set to
   * [Node3D.globalTransform] for the current body's transform.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var from: Transform3D
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
  public final inline var motion: Vector3
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
   * Maximum number of returned collisions, between `1` and `32`. Always returns the deepest
   * detected collisions.
   */
  public final inline var maxCollisions: Int
    @JvmName("maxCollisionsProperty")
    get() = getMaxCollisions()
    @JvmName("maxCollisionsProperty")
    set(`value`) {
      setMaxCollisions(value)
    }

  /**
   * If set to `true`, shapes of type [PhysicsServer3D.SHAPE_SEPARATION_RAY] are used to detect
   * collisions and can stop the motion. Can be useful when snapping to the ground.
   *
   * If set to `false`, shapes of type [PhysicsServer3D.SHAPE_SEPARATION_RAY] are only used for
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
   * Optional array of body [RID] to exclude from collision. Use [CollisionObject3D.getRid] to get
   * the [RID] associated with a [CollisionObject3D]-derived node.
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
   * used e.g. by [CharacterBody3D] for improving floor detection during floor snapping.
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
   * val myCoreType = physicstestmotionparameters3d.from
   * //Your changes
   * physicstestmotionparameters3d.from = myCoreType
   * ``````
   *
   * Transform in global space where the motion should start. Usually set to
   * [Node3D.globalTransform] for the current body's transform.
   */
  @CoreTypeHelper
  public final fun fromMutate(block: Transform3D.() -> Unit): Transform3D = from.apply {
     block(this)
     from = this
  }

  /**
   * This is a helper function for [motion] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = physicstestmotionparameters3d.motion
   * //Your changes
   * physicstestmotionparameters3d.motion = myCoreType
   * ``````
   *
   * Motion vector to define the length and direction of the motion to test.
   */
  @CoreTypeHelper
  public final fun motionMutate(block: Vector3.() -> Unit): Vector3 = motion.apply {
     block(this)
     motion = this
  }

  public final fun getFrom(): Transform3D {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFromPtr, 18)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  public final fun setFrom(from: Transform3D): Unit {
    TransferContext.writeMethodArguments_TRANSFORM3D(ptr, objectID.id, from)
    TransferContext.callPtrMethod(MethodBindings.setFromPtr, 0)
  }

  public final fun getMotion(): Vector3 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMotionPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  public final fun setMotion(motion: Vector3): Unit {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, motion)
    TransferContext.callPtrMethod(MethodBindings.setMotionPtr, 0)
  }

  public final fun getMargin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMarginPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, margin.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMarginPtr, 0)
  }

  public final fun getMaxCollisions(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxCollisionsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setMaxCollisions(maxCollisions: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxCollisions.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxCollisionsPtr, 0)
  }

  public final fun isCollideSeparationRayEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCollideSeparationRayEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCollideSeparationRayEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setCollideSeparationRayEnabledPtr, 0)
  }

  public final fun getExcludeBodies(): VariantArray<RID> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludeBodiesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  public final fun setExcludeBodies(excludeList: VariantArray<RID>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, excludeList)
    TransferContext.callPtrMethod(MethodBindings.setExcludeBodiesPtr, 0)
  }

  public final fun getExcludeObjects(): VariantArray<Long> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExcludeObjectsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Long>)
  }

  public final fun setExcludeObjects(excludeList: VariantArray<Long>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, excludeList)
    TransferContext.callPtrMethod(MethodBindings.setExcludeObjectsPtr, 0)
  }

  public final fun isRecoveryAsCollisionEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isRecoveryAsCollisionEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setRecoveryAsCollisionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setRecoveryAsCollisionEnabledPtr, 0)
  }

  public companion object {
    @JvmField
    public val getFromName: MethodStringName0<PhysicsTestMotionParameters3D, Transform3D> =
        MethodStringName0<PhysicsTestMotionParameters3D, Transform3D>("get_from")

    @JvmField
    public val setFromName: MethodStringName1<PhysicsTestMotionParameters3D, Unit, Transform3D> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Transform3D>("set_from")

    @JvmField
    public val getMotionName: MethodStringName0<PhysicsTestMotionParameters3D, Vector3> =
        MethodStringName0<PhysicsTestMotionParameters3D, Vector3>("get_motion")

    @JvmField
    public val setMotionName: MethodStringName1<PhysicsTestMotionParameters3D, Unit, Vector3> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Vector3>("set_motion")

    @JvmField
    public val getMarginName: MethodStringName0<PhysicsTestMotionParameters3D, Float> =
        MethodStringName0<PhysicsTestMotionParameters3D, Float>("get_margin")

    @JvmField
    public val setMarginName: MethodStringName1<PhysicsTestMotionParameters3D, Unit, Float> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Float>("set_margin")

    @JvmField
    public val getMaxCollisionsName: MethodStringName0<PhysicsTestMotionParameters3D, Int> =
        MethodStringName0<PhysicsTestMotionParameters3D, Int>("get_max_collisions")

    @JvmField
    public val setMaxCollisionsName: MethodStringName1<PhysicsTestMotionParameters3D, Unit, Int> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Int>("set_max_collisions")

    @JvmField
    public val isCollideSeparationRayEnabledName:
        MethodStringName0<PhysicsTestMotionParameters3D, Boolean> =
        MethodStringName0<PhysicsTestMotionParameters3D, Boolean>("is_collide_separation_ray_enabled")

    @JvmField
    public val setCollideSeparationRayEnabledName:
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Boolean> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Boolean>("set_collide_separation_ray_enabled")

    @JvmField
    public val getExcludeBodiesName:
        MethodStringName0<PhysicsTestMotionParameters3D, VariantArray<RID>> =
        MethodStringName0<PhysicsTestMotionParameters3D, VariantArray<RID>>("get_exclude_bodies")

    @JvmField
    public val setExcludeBodiesName:
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, VariantArray<RID>> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, VariantArray<RID>>("set_exclude_bodies")

    @JvmField
    public val getExcludeObjectsName:
        MethodStringName0<PhysicsTestMotionParameters3D, VariantArray<Long>> =
        MethodStringName0<PhysicsTestMotionParameters3D, VariantArray<Long>>("get_exclude_objects")

    @JvmField
    public val setExcludeObjectsName:
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, VariantArray<Long>> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, VariantArray<Long>>("set_exclude_objects")

    @JvmField
    public val isRecoveryAsCollisionEnabledName:
        MethodStringName0<PhysicsTestMotionParameters3D, Boolean> =
        MethodStringName0<PhysicsTestMotionParameters3D, Boolean>("is_recovery_as_collision_enabled")

    @JvmField
    public val setRecoveryAsCollisionEnabledName:
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Boolean> =
        MethodStringName1<PhysicsTestMotionParameters3D, Unit, Boolean>("set_recovery_as_collision_enabled")
  }

  public object MethodBindings {
    internal val getFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "get_from", 3229777777)

    internal val setFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_from", 2952846383)

    internal val getMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "get_motion", 3360562783)

    internal val setMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_motion", 3460891852)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "get_margin", 1740695150)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_margin", 373806689)

    internal val getMaxCollisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "get_max_collisions", 3905245786)

    internal val setMaxCollisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_max_collisions", 1286410249)

    internal val isCollideSeparationRayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "is_collide_separation_ray_enabled", 36873697)

    internal val setCollideSeparationRayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_collide_separation_ray_enabled", 2586408642)

    internal val getExcludeBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "get_exclude_bodies", 3995934104)

    internal val setExcludeBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_exclude_bodies", 381264803)

    internal val getExcludeObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "get_exclude_objects", 3995934104)

    internal val setExcludeObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_exclude_objects", 381264803)

    internal val isRecoveryAsCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "is_recovery_as_collision_enabled", 36873697)

    internal val setRecoveryAsCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsTestMotionParameters3D", "set_recovery_as_collision_enabled", 2586408642)
  }
}
