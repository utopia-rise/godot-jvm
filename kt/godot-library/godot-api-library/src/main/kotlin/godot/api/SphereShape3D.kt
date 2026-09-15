// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 3D sphere shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape3D].
 *
 * **Performance:** [SphereShape3D] is fast to check collisions against. It is faster than
 * [BoxShape3D], [CapsuleShape3D], and [CylinderShape3D].
 */
@GodotBaseType
public open class SphereShape3D : Shape3D() {
  /**
   * The sphere's radius. The shape's diameter is double the radius.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(688, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRadiusPtr, 0)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<SphereShape3D, Unit, Float> =
        MethodStringName1<SphereShape3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<SphereShape3D, Float> =
        MethodStringName0<SphereShape3D, Float>("get_radius")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereShape3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SphereShape3D", "get_radius", 1740695150)
  }
}
