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
 * A 3D capsule shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape3D].
 *
 * **Performance:** [CapsuleShape3D] is fast to check collisions against. It is faster than
 * [CylinderShape3D], but slower than [SphereShape3D] and [BoxShape3D].
 */
@GodotBaseType
public open class CapsuleShape3D : Shape3D() {
  /**
   * The capsule's radius.
   *
   * **Note:** The [radius] of a capsule cannot be greater than half of its [height]. Otherwise, the
   * capsule becomes a sphere. If the [radius] is greater than half of the [height], the properties
   * adjust to a valid value.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * The capsule's full height, including the hemispheres.
   *
   * **Note:** The [height] of a capsule must be at least twice its [radius]. Otherwise, the capsule
   * becomes a sphere. If the [height] is less than twice the [radius], the properties adjust to a
   * valid value.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * The capsule's height, excluding the hemispheres. This is the height of the central cylindrical
   * part in the middle of the capsule, and is the distance between the centers of the two hemispheres.
   * This is a wrapper for [height].
   */
  public final inline var midHeight: Float
    @JvmName("midHeightProperty")
    get() = getMidHeight()
    @JvmName("midHeightProperty")
    set(`value`) {
      setMidHeight(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(149, scriptPtr)
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

  public final fun setHeight(height: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, height.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setHeightPtr, 0)
  }

  public final fun getHeight(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHeightPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMidHeight(midHeight: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, midHeight.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMidHeightPtr, 0)
  }

  public final fun getMidHeight(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMidHeightPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<CapsuleShape3D, Unit, Float> =
        MethodStringName1<CapsuleShape3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<CapsuleShape3D, Float> =
        MethodStringName0<CapsuleShape3D, Float>("get_radius")

    @JvmField
    public val setHeightName: MethodStringName1<CapsuleShape3D, Unit, Float> =
        MethodStringName1<CapsuleShape3D, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<CapsuleShape3D, Float> =
        MethodStringName0<CapsuleShape3D, Float>("get_height")

    @JvmField
    public val setMidHeightName: MethodStringName1<CapsuleShape3D, Unit, Float> =
        MethodStringName1<CapsuleShape3D, Unit, Float>("set_mid_height")

    @JvmField
    public val getMidHeightName: MethodStringName0<CapsuleShape3D, Float> =
        MethodStringName0<CapsuleShape3D, Float>("get_mid_height")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape3D", "get_radius", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape3D", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape3D", "get_height", 1740695150)

    internal val setMidHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape3D", "set_mid_height", 373806689)

    internal val getMidHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape3D", "get_mid_height", 1740695150)
  }
}
