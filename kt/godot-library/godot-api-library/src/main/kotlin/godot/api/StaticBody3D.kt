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
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A static 3D physics body. It can't be moved by external forces or contacts, but can be moved
 * manually by other means such as code, [AnimationMixer]s (with [AnimationMixer.callbackModeProcess]
 * set to [AnimationMixer.ANIMATION_CALLBACK_MODE_PROCESS_PHYSICS]), and [RemoteTransform3D].
 *
 * When [StaticBody3D] is moved, it is teleported to its new position without affecting other
 * physics bodies in its path. If this is not desired, use [AnimatableBody3D] instead.
 *
 * [StaticBody3D] is useful for completely static objects like floors and walls, as well as moving
 * surfaces like conveyor belts and circular revolving platforms (by using [constantLinearVelocity] and
 * [constantAngularVelocity]).
 */
@GodotBaseType
public open class StaticBody3D : PhysicsBody3D() {
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
  public final inline var constantLinearVelocity: Vector3
    @JvmName("constantLinearVelocityProperty")
    get() = getConstantLinearVelocity()
    @JvmName("constantLinearVelocityProperty")
    set(`value`) {
      setConstantLinearVelocity(value)
    }

  /**
   * The body's constant angular velocity. This does not rotate the body, but affects touching
   * bodies, as if it were rotating.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var constantAngularVelocity: Vector3
    @JvmName("constantAngularVelocityProperty")
    get() = getConstantAngularVelocity()
    @JvmName("constantAngularVelocityProperty")
    set(`value`) {
      setConstantAngularVelocity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(705, scriptPtr)
  }

  /**
   * This is a helper function for [constantLinearVelocity] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = staticbody3d.constantLinearVelocity
   * //Your changes
   * staticbody3d.constantLinearVelocity = myCoreType
   * ``````
   *
   * The body's constant linear velocity. This does not move the body, but affects touching bodies,
   * as if it were moving.
   */
  @CoreTypeHelper
  public final fun constantLinearVelocityMutate(block: Vector3.() -> Unit): Vector3 =
      constantLinearVelocity.apply {
     block(this)
     constantLinearVelocity = this
  }

  /**
   * This is a helper function for [constantAngularVelocity] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = staticbody3d.constantAngularVelocity
   * //Your changes
   * staticbody3d.constantAngularVelocity = myCoreType
   * ``````
   *
   * The body's constant angular velocity. This does not rotate the body, but affects touching
   * bodies, as if it were rotating.
   */
  @CoreTypeHelper
  public final fun constantAngularVelocityMutate(block: Vector3.() -> Unit): Vector3 =
      constantAngularVelocity.apply {
     block(this)
     constantAngularVelocity = this
  }

  public final fun setConstantLinearVelocity(vel: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to vel)
    TransferContext.callMethod(MethodBindings.setConstantLinearVelocityPtr)
  }

  public final fun setConstantAngularVelocity(vel: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to vel)
    TransferContext.callMethod(MethodBindings.setConstantAngularVelocityPtr)
  }

  public final fun getConstantLinearVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantLinearVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getConstantAngularVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantAngularVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setPhysicsMaterialOverride(physicsMaterialOverride: PhysicsMaterial?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to physicsMaterialOverride)
    TransferContext.callMethod(MethodBindings.setPhysicsMaterialOverridePtr)
  }

  public final fun getPhysicsMaterialOverride(): PhysicsMaterial? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsMaterialOverridePtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsMaterial?)
  }

  public companion object {
    @JvmField
    public val setConstantLinearVelocityName: MethodStringName1<StaticBody3D, Unit, Vector3> =
        MethodStringName1<StaticBody3D, Unit, Vector3>("set_constant_linear_velocity")

    @JvmField
    public val setConstantAngularVelocityName: MethodStringName1<StaticBody3D, Unit, Vector3> =
        MethodStringName1<StaticBody3D, Unit, Vector3>("set_constant_angular_velocity")

    @JvmField
    public val getConstantLinearVelocityName: MethodStringName0<StaticBody3D, Vector3> =
        MethodStringName0<StaticBody3D, Vector3>("get_constant_linear_velocity")

    @JvmField
    public val getConstantAngularVelocityName: MethodStringName0<StaticBody3D, Vector3> =
        MethodStringName0<StaticBody3D, Vector3>("get_constant_angular_velocity")

    @JvmField
    public val setPhysicsMaterialOverrideName:
        MethodStringName1<StaticBody3D, Unit, PhysicsMaterial?> =
        MethodStringName1<StaticBody3D, Unit, PhysicsMaterial?>("set_physics_material_override")

    @JvmField
    public val getPhysicsMaterialOverrideName: MethodStringName0<StaticBody3D, PhysicsMaterial?> =
        MethodStringName0<StaticBody3D, PhysicsMaterial?>("get_physics_material_override")
  }

  public object MethodBindings {
    internal val setConstantLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody3D", "set_constant_linear_velocity", 3460891852)

    internal val setConstantAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody3D", "set_constant_angular_velocity", 3460891852)

    internal val getConstantLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody3D", "get_constant_linear_velocity", 3360562783)

    internal val getConstantAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody3D", "get_constant_angular_velocity", 3360562783)

    internal val setPhysicsMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody3D", "set_physics_material_override", 1784508650)

    internal val getPhysicsMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StaticBody3D", "get_physics_material_override", 2521850424)
  }
}
