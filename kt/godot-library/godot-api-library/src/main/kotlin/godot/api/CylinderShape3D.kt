// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 3D cylinder shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape3D].
 *
 * **Note:** There are several known bugs with cylinder collision shapes. Using [CapsuleShape3D] or
 * [BoxShape3D] instead is recommended.
 *
 * **Performance:** [CylinderShape3D] is fast to check collisions against, but it is slower than
 * [CapsuleShape3D], [BoxShape3D], and [SphereShape3D].
 */
@GodotBaseType
public open class CylinderShape3D : Shape3D() {
  /**
   * The cylinder's height.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * The cylinder's radius.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(200, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRadiusPtr, radius.toDouble())
  }

  public final fun getRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRadiusPtr).toFloat()

  public final fun setHeight(height: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setHeightPtr, height.toDouble())
  }

  public final fun getHeight(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getHeightPtr).toFloat()

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<CylinderShape3D, Unit, Float> =
        MethodStringName1<CylinderShape3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<CylinderShape3D, Float> =
        MethodStringName0<CylinderShape3D, Float>("get_radius")

    @JvmField
    public val setHeightName: MethodStringName1<CylinderShape3D, Unit, Float> =
        MethodStringName1<CylinderShape3D, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<CylinderShape3D, Float> =
        MethodStringName0<CylinderShape3D, Float>("get_height")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CylinderShape3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CylinderShape3D", "get_radius", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CylinderShape3D", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CylinderShape3D", "get_height", 1740695150)
  }
}
