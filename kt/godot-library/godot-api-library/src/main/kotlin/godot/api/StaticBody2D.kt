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
import godot.core.Vector2
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_VECTOR2
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A static 2D physics body. It can't be moved by external forces or contacts, but can be moved
 * manually by other means such as code, [AnimationMixer]s (with [AnimationMixer.callbackModeProcess]
 * set to [AnimationMixer.ANIMATION_CALLBACK_MODE_PROCESS_PHYSICS]), and [RemoteTransform2D].
 *
 * When [StaticBody2D] is moved, it is teleported to its new position without affecting other
 * physics bodies in its path. If this is not desired, use [AnimatableBody2D] instead.
 *
 * [StaticBody2D] is useful for completely static objects like floors and walls, as well as moving
 * surfaces like conveyor belts and circular revolving platforms (by using [constantLinearVelocity] and
 * [constantAngularVelocity]).
 */
@GodotBaseType
public open class StaticBody2D : PhysicsBody2D() {
  /**
   * The physics material override for the body.
   *
   * If a material is assigned to this property, it will be used instead of any other physics
   * material, such as an inherited one.
   */
  public final inline var physicsMaterialOverride: PhysicsMaterial?
    @JvmName("physicsMaterialOverrideProperty")
    get() = getPhysicsMaterialOverride()
    @JvmName("physicsMaterialOverrideProperty")
    set(`value`) {
      setPhysicsMaterialOverride(value)
    }

  /**
   * The body's constant linear velocity. This does not move the body, but affects touching bodies,
   * as if it were moving.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constantLinearVelocity: Vector2
    @JvmName("constantLinearVelocityProperty")
    get() = getConstantLinearVelocity()
    @JvmName("constantLinearVelocityProperty")
    set(`value`) {
      setConstantLinearVelocity(value)
    }

  /**
   * The body's constant angular velocity. This does not rotate the body, but affects touching
   * bodies, as if it were rotating.
   */
  public final inline var constantAngularVelocity: Float
    @JvmName("constantAngularVelocityProperty")
    get() = getConstantAngularVelocity()
    @JvmName("constantAngularVelocityProperty")
    set(`value`) {
      setConstantAngularVelocity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(704, scriptPtr)
  }

  /**
   * This is a helper function for [constantLinearVelocity] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = staticbody2d.constantLinearVelocity
   * //Your changes
   * staticbody2d.constantLinearVelocity = myCoreType
   * ``````
   *
   * The body's constant linear velocity. This does not move the body, but affects touching bodies,
   * as if it were moving.
   */
  @CoreTypeHelper
  public final fun constantLinearVelocityMutate(block: Vector2.() -> Unit): Vector2 =
      constantLinearVelocity.apply {
     block(this)
     constantLinearVelocity = this
  }

  public final fun setConstantLinearVelocity(vel: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, vel)
    TransferContext.callPtrMethod(MethodBindings.setConstantLinearVelocityPtr, 0)
  }

  public final fun setConstantAngularVelocity(vel: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, vel.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setConstantAngularVelocityPtr, 0)
  }

  public final fun getConstantLinearVelocity(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getConstantLinearVelocityPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public final fun getConstantAngularVelocity(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getConstantAngularVelocityPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPhysicsMaterialOverride(physicsMaterialOverride: PhysicsMaterial?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, physicsMaterialOverride)
    TransferContext.callPtrMethod(MethodBindings.setPhysicsMaterialOverridePtr, 0)
  }

  public final fun getPhysicsMaterialOverride(): PhysicsMaterial? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPhysicsMaterialOverridePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as PhysicsMaterial?)
  }

  public companion object {
    @JvmField
    public val setConstantLinearVelocityName: MethodStringName1<StaticBody2D, Unit, Vector2> =
        MethodStringName1<StaticBody2D, Unit, Vector2>("set_constant_linear_velocity")

    @JvmField
    public val setConstantAngularVelocityName: MethodStringName1<StaticBody2D, Unit, Float> =
        MethodStringName1<StaticBody2D, Unit, Float>("set_constant_angular_velocity")

    @JvmField
    public val getConstantLinearVelocityName: MethodStringName0<StaticBody2D, Vector2> =
        MethodStringName0<StaticBody2D, Vector2>("get_constant_linear_velocity")

    @JvmField
    public val getConstantAngularVelocityName: MethodStringName0<StaticBody2D, Float> =
        MethodStringName0<StaticBody2D, Float>("get_constant_angular_velocity")

    @JvmField
    public val setPhysicsMaterialOverrideName:
        MethodStringName1<StaticBody2D, Unit, PhysicsMaterial?> =
        MethodStringName1<StaticBody2D, Unit, PhysicsMaterial?>("set_physics_material_override")

    @JvmField
    public val getPhysicsMaterialOverrideName: MethodStringName0<StaticBody2D, PhysicsMaterial?> =
        MethodStringName0<StaticBody2D, PhysicsMaterial?>("get_physics_material_override")
  }

  public object MethodBindings {
    internal val setConstantLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody2D", "set_constant_linear_velocity", 743155724)

    internal val setConstantAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody2D", "set_constant_angular_velocity", 373806689)

    internal val getConstantLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody2D", "get_constant_linear_velocity", 3341600327)

    internal val getConstantAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody2D", "get_constant_angular_velocity", 1740695150)

    internal val setPhysicsMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody2D", "set_physics_material_override", 1784508650)

    internal val getPhysicsMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody2D", "get_physics_material_override", 2521850424)
  }
}
