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
 * [SphereOccluder3D] stores a sphere shape that can be used by the engine's occlusion culling
 * system.
 *
 * See [OccluderInstance3D]'s documentation for instructions on setting up occlusion culling.
 */
@GodotBaseType
public open class SphereOccluder3D : Occluder3D() {
  /**
   * The sphere's radius in 3D units.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(687, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRadiusPtr, radius.toDouble())
  }

  public final fun getRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRadiusPtr).toFloat()

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<SphereOccluder3D, Unit, Float> =
        MethodStringName1<SphereOccluder3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<SphereOccluder3D, Float> =
        MethodStringName0<SphereOccluder3D, Float>("get_radius")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereOccluder3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereOccluder3D", "get_radius", 1740695150)
  }
}
