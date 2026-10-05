// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_RID
import godot.callPtrMethod_RID_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [SpringArm3D] casts a ray or a shape along its Z axis and moves all its direct children to the
 * collision point, with an optional margin. This is useful for 3rd person cameras that move closer to
 * the player when inside a tight space (you may need to exclude the player's collider from the
 * [SpringArm3D]'s collision check).
 */
@GodotBaseType
public open class SpringArm3D : Node3D() {
  /**
   * The layers against which the collision check will be done. See
   * [url=$DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks]Collision
   * layers and masks[/url] in the documentation for more information.
   */
  public final inline var collisionMask: Long
    @JvmName("collisionMaskProperty")
    get() = getCollisionMask()
    @JvmName("collisionMaskProperty")
    set(`value`) {
      setCollisionMask(value)
    }

  /**
   * The [Shape3D] to use for the SpringArm3D.
   *
   * When the shape is set, the SpringArm3D will cast the [Shape3D] on its z axis instead of
   * performing a ray cast.
   */
  public final inline var shape: Shape3D?
    @JvmName("shapeProperty")
    get() = getShape()
    @JvmName("shapeProperty")
    set(`value`) {
      setShape(value)
    }

  /**
   * The maximum extent of the SpringArm3D. This is used as a length for both the ray and the shape
   * cast used internally to calculate the desired position of the SpringArm3D's child nodes.
   *
   * To know more about how to perform a shape cast or a ray cast, please consult the
   * [PhysicsDirectSpaceState3D] documentation.
   */
  public final inline var springLength: Float
    @JvmName("springLengthProperty")
    get() = getLength()
    @JvmName("springLengthProperty")
    set(`value`) {
      setLength(value)
    }

  /**
   * When the collision check is made, a candidate length for the SpringArm3D is given.
   *
   * The margin is then subtracted to this length and the translation is applied to the child
   * objects of the SpringArm3D.
   *
   * This margin is useful for when the SpringArm3D has a [Camera3D] as a child node: without the
   * margin, the [Camera3D] would be placed on the exact point of collision, while with the margin the
   * [Camera3D] would be placed close to the point of collision.
   */
  public final inline var margin: Float
    @JvmName("marginProperty")
    get() = getMargin()
    @JvmName("marginProperty")
    set(`value`) {
      setMargin(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(693, scriptPtr)
  }

  /**
   * Returns the spring arm's current length.
   */
  public final fun getHitLength(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getHitLengthPtr).toFloat()

  public final fun setLength(length: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setLengthPtr, length.toDouble())
  }

  public final fun getLength(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLengthPtr).toFloat()

  public final fun setShape(shape: Shape3D?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setShapePtr, shape)
  }

  public final fun getShape(): Shape3D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getShapePtr) as Shape3D?)

  /**
   * Adds the [PhysicsBody3D] object with the given [RID] to the list of [PhysicsBody3D] objects
   * excluded from the collision check.
   */
  public final fun addExcludedObject(RID: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.addExcludedObjectPtr, RID)
  }

  /**
   * Removes the given [RID] from the list of [PhysicsBody3D] objects excluded from the collision
   * check.
   */
  public final fun removeExcludedObject(RID: RID): Boolean =
      TransferContext.callPtrMethod_RID_ret_BOOL(ptr, objectID.id, MethodBindings.removeExcludedObjectPtr, RID)

  /**
   * Clears the list of [PhysicsBody3D] objects excluded from the collision check.
   */
  public final fun clearExcludedObjects(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearExcludedObjectsPtr)
  }

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCollisionMaskPtr, mask)
  }

  public final fun getCollisionMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionMaskPtr)

  public final fun setMargin(margin: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setMarginPtr, margin.toDouble())
  }

  public final fun getMargin(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getMarginPtr).toFloat()

  public companion object {
    @JvmField
    public val getHitLengthName: MethodStringName0<SpringArm3D, Float> =
        MethodStringName0<SpringArm3D, Float>("get_hit_length")

    @JvmField
    public val setLengthName: MethodStringName1<SpringArm3D, Unit, Float> =
        MethodStringName1<SpringArm3D, Unit, Float>("set_length")

    @JvmField
    public val getLengthName: MethodStringName0<SpringArm3D, Float> =
        MethodStringName0<SpringArm3D, Float>("get_length")

    @JvmField
    public val setShapeName: MethodStringName1<SpringArm3D, Unit, Shape3D?> =
        MethodStringName1<SpringArm3D, Unit, Shape3D?>("set_shape")

    @JvmField
    public val getShapeName: MethodStringName0<SpringArm3D, Shape3D?> =
        MethodStringName0<SpringArm3D, Shape3D?>("get_shape")

    @JvmField
    public val addExcludedObjectName: MethodStringName1<SpringArm3D, Unit, RID> =
        MethodStringName1<SpringArm3D, Unit, RID>("add_excluded_object")

    @JvmField
    public val removeExcludedObjectName: MethodStringName1<SpringArm3D, Boolean, RID> =
        MethodStringName1<SpringArm3D, Boolean, RID>("remove_excluded_object")

    @JvmField
    public val clearExcludedObjectsName: MethodStringName0<SpringArm3D, Unit> =
        MethodStringName0<SpringArm3D, Unit>("clear_excluded_objects")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<SpringArm3D, Unit, Long> =
        MethodStringName1<SpringArm3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<SpringArm3D, Long> =
        MethodStringName0<SpringArm3D, Long>("get_collision_mask")

    @JvmField
    public val setMarginName: MethodStringName1<SpringArm3D, Unit, Float> =
        MethodStringName1<SpringArm3D, Unit, Float>("set_margin")

    @JvmField
    public val getMarginName: MethodStringName0<SpringArm3D, Float> =
        MethodStringName0<SpringArm3D, Float>("get_margin")
  }

  public object MethodBindings {
    internal val getHitLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "get_hit_length", 191475506)

    internal val setLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "set_length", 373806689)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "get_length", 1740695150)

    internal val setShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "set_shape", 1549710052)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "get_shape", 3214262478)

    internal val addExcludedObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "add_excluded_object", 2722037293)

    internal val removeExcludedObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "remove_excluded_object", 3521089500)

    internal val clearExcludedObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "clear_excluded_objects", 3218959716)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "get_collision_mask", 2455072627)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "set_margin", 373806689)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringArm3D", "get_margin", 191475506)
  }
}
