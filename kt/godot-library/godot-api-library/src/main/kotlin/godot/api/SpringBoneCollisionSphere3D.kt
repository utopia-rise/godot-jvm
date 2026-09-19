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
 * A sphere shape collision that interacts with [SpringBoneSimulator3D].
 */
@GodotBaseType
public open class SpringBoneCollisionSphere3D : SpringBoneCollision3D() {
  /**
   * The sphere's radius.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * If `true`, the collision acts to trap the joint within the collision.
   */
  public final inline var inside: Boolean
    @JvmName("insideProperty")
    get() = isInside()
    @JvmName("insideProperty")
    set(`value`) {
      setInside(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(697, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRadiusPtr, radius.toDouble())
  }

  public final fun getRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRadiusPtr).toFloat()

  public final fun setInside(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setInsidePtr, enabled)
  }

  public final fun isInside(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isInsidePtr)

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<SpringBoneCollisionSphere3D, Unit, Float> =
        MethodStringName1<SpringBoneCollisionSphere3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<SpringBoneCollisionSphere3D, Float> =
        MethodStringName0<SpringBoneCollisionSphere3D, Float>("get_radius")

    @JvmField
    public val setInsideName: MethodStringName1<SpringBoneCollisionSphere3D, Unit, Boolean> =
        MethodStringName1<SpringBoneCollisionSphere3D, Unit, Boolean>("set_inside")

    @JvmField
    public val isInsideName: MethodStringName0<SpringBoneCollisionSphere3D, Boolean> =
        MethodStringName0<SpringBoneCollisionSphere3D, Boolean>("is_inside")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollisionSphere3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollisionSphere3D", "get_radius", 1740695150)

    internal val setInsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollisionSphere3D", "set_inside", 2586408642)

    internal val isInsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneCollisionSphere3D", "is_inside", 36873697)
  }
}
