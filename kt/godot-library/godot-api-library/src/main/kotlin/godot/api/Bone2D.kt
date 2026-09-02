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
import godot.core.Transform2D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.TRANSFORM2D
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A hierarchy of [Bone2D]s can be bound to a [Skeleton2D] to control and animate other [Node2D]
 * nodes.
 *
 * You can use [Bone2D] and [Skeleton2D] nodes to animate 2D meshes created with the [Polygon2D] UV
 * editor.
 *
 * Each bone has a [rest] transform that you can reset to with [applyRest]. These rest poses are
 * relative to the bone's parent.
 *
 * If in the editor, you can set the rest pose of an entire skeleton using a menu option, from the
 * code, you need to iterate over the bones to set their individual rest poses.
 */
@GodotBaseType
public open class Bone2D : Node2D() {
  /**
   * Rest transform of the bone. You can reset the node's transforms to this value using
   * [applyRest].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rest: Transform2D
    @JvmName("restProperty")
    get() = getRest()
    @JvmName("restProperty")
    set(`value`) {
      setRest(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(111, scriptPtr)
  }

  /**
   * This is a helper function for [rest] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = bone2d.rest
   * //Your changes
   * bone2d.rest = myCoreType
   * ``````
   *
   * Rest transform of the bone. You can reset the node's transforms to this value using
   * [applyRest].
   */
  @CoreTypeHelper
  public final fun restMutate(block: Transform2D.() -> Unit): Transform2D = rest.apply {
     block(this)
     rest = this
  }

  public final fun setRest(rest: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to rest)
    TransferContext.callMethod(MethodBindings.setRestPtr)
  }

  public final fun getRest(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRestPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Resets the bone to the rest pose. This is equivalent to setting [Node2D.transform] to [rest].
   */
  public final fun applyRest(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.applyRestPtr)
  }

  /**
   * Returns the node's [rest] [Transform2D] if it doesn't have a parent, or its rest pose relative
   * to its parent.
   */
  public final fun getSkeletonRest(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonRestPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the node's index as part of the entire skeleton. See [Skeleton2D].
   */
  public final fun getIndexInSkeleton(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIndexInSkeletonPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * When set to `true`, the [Bone2D] node will attempt to automatically calculate the bone angle
   * and length using the first child [Bone2D] node, if one exists. If none exist, the [Bone2D] cannot
   * automatically calculate these values and will print a warning.
   */
  public final fun setAutocalculateLengthAndAngle(autoCalculate: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to autoCalculate)
    TransferContext.callMethod(MethodBindings.setAutocalculateLengthAndAnglePtr)
  }

  /**
   * Returns whether this [Bone2D] is going to autocalculate its length and bone angle using its
   * first [Bone2D] child node, if one exists. If there are no [Bone2D] children, then it cannot
   * autocalculate these values and will print a warning.
   */
  public final fun getAutocalculateLengthAndAngle(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutocalculateLengthAndAnglePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the length of the bone in the [Bone2D].
   */
  public final fun setLength(length: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.setLengthPtr)
  }

  /**
   * Returns the length of the bone in the [Bone2D] node.
   */
  public final fun getLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the bone angle for the [Bone2D]. This is typically set to the rotation from the [Bone2D]
   * to a child [Bone2D] node.
   *
   * **Note:** This is different from the [Bone2D]'s rotation. The bone's angle is the rotation of
   * the bone shown by the gizmo, which is unaffected by the [Bone2D]'s [Node2D.transform].
   */
  public final fun setBoneAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to angle.toDouble())
    TransferContext.callMethod(MethodBindings.setBoneAnglePtr)
  }

  /**
   * Returns the angle of the bone in the [Bone2D].
   *
   * **Note:** This is different from the [Bone2D]'s rotation. The bone's angle is the rotation of
   * the bone shown by the gizmo, which is unaffected by the [Bone2D]'s [Node2D.transform].
   */
  public final fun getBoneAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public companion object {
    @JvmField
    public val setRestName: MethodStringName1<Bone2D, Unit, Transform2D> =
        MethodStringName1<Bone2D, Unit, Transform2D>("set_rest")

    @JvmField
    public val getRestName: MethodStringName0<Bone2D, Transform2D> =
        MethodStringName0<Bone2D, Transform2D>("get_rest")

    @JvmField
    public val applyRestName: MethodStringName0<Bone2D, Unit> =
        MethodStringName0<Bone2D, Unit>("apply_rest")

    @JvmField
    public val getSkeletonRestName: MethodStringName0<Bone2D, Transform2D> =
        MethodStringName0<Bone2D, Transform2D>("get_skeleton_rest")

    @JvmField
    public val getIndexInSkeletonName: MethodStringName0<Bone2D, Int> =
        MethodStringName0<Bone2D, Int>("get_index_in_skeleton")

    @JvmField
    public val setAutocalculateLengthAndAngleName: MethodStringName1<Bone2D, Unit, Boolean> =
        MethodStringName1<Bone2D, Unit, Boolean>("set_autocalculate_length_and_angle")

    @JvmField
    public val getAutocalculateLengthAndAngleName: MethodStringName0<Bone2D, Boolean> =
        MethodStringName0<Bone2D, Boolean>("get_autocalculate_length_and_angle")

    @JvmField
    public val setLengthName: MethodStringName1<Bone2D, Unit, Float> =
        MethodStringName1<Bone2D, Unit, Float>("set_length")

    @JvmField
    public val getLengthName: MethodStringName0<Bone2D, Float> =
        MethodStringName0<Bone2D, Float>("get_length")

    @JvmField
    public val setBoneAngleName: MethodStringName1<Bone2D, Unit, Float> =
        MethodStringName1<Bone2D, Unit, Float>("set_bone_angle")

    @JvmField
    public val getBoneAngleName: MethodStringName0<Bone2D, Float> =
        MethodStringName0<Bone2D, Float>("get_bone_angle")
  }

  public object MethodBindings {
    internal val setRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "set_rest", 2761652528)

    internal val getRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "get_rest", 3814499831)

    internal val applyRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "apply_rest", 3218959716)

    internal val getSkeletonRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "get_skeleton_rest", 3814499831)

    internal val getIndexInSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "get_index_in_skeleton", 3905245786)

    internal val setAutocalculateLengthAndAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "set_autocalculate_length_and_angle", 2586408642)

    internal val getAutocalculateLengthAndAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "get_autocalculate_length_and_angle", 36873697)

    internal val setLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "set_length", 373806689)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "get_length", 1740695150)

    internal val setBoneAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "set_bone_angle", 373806689)

    internal val getBoneAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Bone2D", "get_bone_angle", 1740695150)
  }
}
