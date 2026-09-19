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
 * A 2D capsule shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape2D].
 *
 * **Performance:** [CapsuleShape2D] is fast to check collisions against, but it is slower than
 * [RectangleShape2D] and [CircleShape2D].
 */
@GodotBaseType
public open class CapsuleShape2D : Shape2D() {
  /**
   * The capsule's radius.
   *
   * **Note:** The [radius] of a capsule cannot be greater than half of its [height]. Otherwise, the
   * capsule becomes a circle. If the [radius] is greater than half of the [height], the properties
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
   * The capsule's full height, including the semicircles.
   *
   * **Note:** The [height] of a capsule must be at least twice its [radius]. Otherwise, the capsule
   * becomes a circle. If the [height] is less than twice the [radius], the properties adjust to a
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
   * The capsule's height, excluding the semicircles. This is the height of the central rectangular
   * part in the middle of the capsule, and is the distance between the centers of the two semicircles.
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
    createNativeObject(148, scriptPtr)
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

  public final fun setMidHeight(midHeight: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setMidHeightPtr, midHeight.toDouble())
  }

  public final fun getMidHeight(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getMidHeightPtr).toFloat()

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<CapsuleShape2D, Unit, Float> =
        MethodStringName1<CapsuleShape2D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<CapsuleShape2D, Float> =
        MethodStringName0<CapsuleShape2D, Float>("get_radius")

    @JvmField
    public val setHeightName: MethodStringName1<CapsuleShape2D, Unit, Float> =
        MethodStringName1<CapsuleShape2D, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<CapsuleShape2D, Float> =
        MethodStringName0<CapsuleShape2D, Float>("get_height")

    @JvmField
    public val setMidHeightName: MethodStringName1<CapsuleShape2D, Unit, Float> =
        MethodStringName1<CapsuleShape2D, Unit, Float>("set_mid_height")

    @JvmField
    public val getMidHeightName: MethodStringName0<CapsuleShape2D, Float> =
        MethodStringName0<CapsuleShape2D, Float>("get_mid_height")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape2D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape2D", "get_radius", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape2D", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape2D", "get_height", 1740695150)

    internal val setMidHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape2D", "set_mid_height", 373806689)

    internal val getMidHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CapsuleShape2D", "get_mid_height", 1740695150)
  }
}
