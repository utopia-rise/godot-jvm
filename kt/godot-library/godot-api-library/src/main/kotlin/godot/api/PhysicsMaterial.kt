// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Holds physics-related properties of a surface, namely its roughness and bounciness. This class is
 * used to apply these properties to a physics body.
 */
@GodotBaseType
public open class PhysicsMaterial : Resource() {
  /**
   * The body's friction. Values range from `0` (frictionless) to `1` (maximum friction).
   */
  public final inline var friction: Float
    @JvmName("frictionProperty")
    get() = getFriction()
    @JvmName("frictionProperty")
    set(`value`) {
      setFriction(value)
    }

  /**
   * If `true`, the physics engine will use the friction of the object marked as "rough" when two
   * objects collide. If `false`, the physics engine will use the lowest friction of all colliding
   * objects instead. If `true` for both colliding objects, the physics engine will use the highest
   * friction.
   */
  public final inline var rough: Boolean
    @JvmName("roughProperty")
    get() = isRough()
    @JvmName("roughProperty")
    set(`value`) {
      setRough(value)
    }

  /**
   * The body's bounciness. Values range from `0` (no bounce) to `1` (full bounciness).
   *
   * **Note:** Even with [bounce] set to `1.0`, some energy will be lost over time due to linear and
   * angular damping. To have a physics body that preserves all its energy over time, set [bounce] to
   * `1.0`, the body's linear damp mode to **Replace** (if applicable), its linear damp to `0.0`, its
   * angular damp mode to **Replace** (if applicable), and its angular damp to `0.0`.
   */
  public final inline var bounce: Float
    @JvmName("bounceProperty")
    get() = getBounce()
    @JvmName("bounceProperty")
    set(`value`) {
      setBounce(value)
    }

  /**
   * If `true`, subtracts the bounciness from the colliding object's bounciness instead of adding
   * it.
   */
  public final inline var absorbent: Boolean
    @JvmName("absorbentProperty")
    get() = isAbsorbent()
    @JvmName("absorbentProperty")
    set(`value`) {
      setAbsorbent(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(533, scriptPtr)
  }

  public final fun setFriction(friction: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFrictionPtr, friction.toDouble())
  }

  public final fun getFriction(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFrictionPtr).toFloat()

  public final fun setRough(rough: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setRoughPtr, rough)
  }

  public final fun isRough(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isRoughPtr)

  public final fun setBounce(bounce: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setBouncePtr, bounce.toDouble())
  }

  public final fun getBounce(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBouncePtr).toFloat()

  public final fun setAbsorbent(absorbent: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAbsorbentPtr, absorbent)
  }

  public final fun isAbsorbent(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isAbsorbentPtr)

  public companion object {
    @JvmField
    public val setFrictionName: MethodStringName1<PhysicsMaterial, Unit, Float> =
        MethodStringName1<PhysicsMaterial, Unit, Float>("set_friction")

    @JvmField
    public val getFrictionName: MethodStringName0<PhysicsMaterial, Float> =
        MethodStringName0<PhysicsMaterial, Float>("get_friction")

    @JvmField
    public val setRoughName: MethodStringName1<PhysicsMaterial, Unit, Boolean> =
        MethodStringName1<PhysicsMaterial, Unit, Boolean>("set_rough")

    @JvmField
    public val isRoughName: MethodStringName0<PhysicsMaterial, Boolean> =
        MethodStringName0<PhysicsMaterial, Boolean>("is_rough")

    @JvmField
    public val setBounceName: MethodStringName1<PhysicsMaterial, Unit, Float> =
        MethodStringName1<PhysicsMaterial, Unit, Float>("set_bounce")

    @JvmField
    public val getBounceName: MethodStringName0<PhysicsMaterial, Float> =
        MethodStringName0<PhysicsMaterial, Float>("get_bounce")

    @JvmField
    public val setAbsorbentName: MethodStringName1<PhysicsMaterial, Unit, Boolean> =
        MethodStringName1<PhysicsMaterial, Unit, Boolean>("set_absorbent")

    @JvmField
    public val isAbsorbentName: MethodStringName0<PhysicsMaterial, Boolean> =
        MethodStringName0<PhysicsMaterial, Boolean>("is_absorbent")
  }

  public object MethodBindings {
    internal val setFrictionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "set_friction", 373806689)

    internal val getFrictionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "get_friction", 1740695150)

    internal val setRoughPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "set_rough", 2586408642)

    internal val isRoughPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "is_rough", 36873697)

    internal val setBouncePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "set_bounce", 373806689)

    internal val getBouncePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "get_bounce", 1740695150)

    internal val setAbsorbentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "set_absorbent", 2586408642)

    internal val isAbsorbentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsMaterial", "is_absorbent", 36873697)
  }
}
