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
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This [SkeletonModification2D] rotates a bone to look a target. This is extremely helpful for
 * moving character's head to look at the player, rotating a turret to look at a target, or any other
 * case where you want to make a bone rotate towards something quickly and easily.
 */
@GodotBaseType
public open class SkeletonModification2DLookAt : SkeletonModification2D() {
  /**
   * The index of the [Bone2D] node that the modification will operate on.
   */
  public final inline var boneIndex: Int
    @JvmName("boneIndexProperty")
    get() = getBoneIndex()
    @JvmName("boneIndexProperty")
    set(`value`) {
      setBoneIndex(value)
    }

  /**
   * The [Bone2D] node that the modification will operate on.
   */
  public final inline var bone2dNode: NodePath
    @JvmName("bone2dNodeProperty")
    get() = getBone2dNode()
    @JvmName("bone2dNodeProperty")
    set(`value`) {
      setBone2dNode(value)
    }

  /**
   * The NodePath to the node that is the target for the LookAt modification. This node is what the
   * modification will rotate the [Bone2D] to.
   */
  public final inline var targetNodepath: NodePath
    @JvmName("targetNodepathProperty")
    get() = getTargetNode()
    @JvmName("targetNodepathProperty")
    set(`value`) {
      setTargetNode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(671, scriptPtr)
  }

  public final fun setBone2dNode(bone2dNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, bone2dNodepath)
    TransferContext.callMethod(MethodBindings.setBone2dNodePtr)
  }

  public final fun getBone2dNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBone2dNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setBoneIndex(boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.setBoneIndexPtr)
  }

  public final fun getBoneIndex(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setTargetNode(targetNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, targetNodepath)
    TransferContext.callMethod(MethodBindings.setTargetNodePtr)
  }

  public final fun getTargetNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the amount of additional rotation that is to be applied after executing the modification.
   * This allows for offsetting the results by the inputted rotation amount.
   */
  public final fun setAdditionalRotation(rotation: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, rotation.toDouble())
    TransferContext.callMethod(MethodBindings.setAdditionalRotationPtr)
  }

  /**
   * Returns the amount of additional rotation that is applied after the LookAt modification
   * executes.
   */
  public final fun getAdditionalRotation(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAdditionalRotationPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets whether this modification will use constraints or not. When `true`, constraints will be
   * applied when solving the LookAt modification.
   */
  public final fun setEnableConstraint(enableConstraint: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enableConstraint)
    TransferContext.callMethod(MethodBindings.setEnableConstraintPtr)
  }

  /**
   * Returns `true` if the LookAt modification is using constraints.
   */
  public final fun getEnableConstraint(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnableConstraintPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the constraint's minimum allowed angle.
   */
  public final fun setConstraintAngleMin(angleMin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angleMin.toDouble())
    TransferContext.callMethod(MethodBindings.setConstraintAngleMinPtr)
  }

  /**
   * Returns the constraint's minimum allowed angle.
   */
  public final fun getConstraintAngleMin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstraintAngleMinPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the constraint's maximum allowed angle.
   */
  public final fun setConstraintAngleMax(angleMax: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angleMax.toDouble())
    TransferContext.callMethod(MethodBindings.setConstraintAngleMaxPtr)
  }

  /**
   * Returns the constraint's maximum allowed angle.
   */
  public final fun getConstraintAngleMax(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstraintAngleMaxPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * When `true`, the modification will use an inverted joint constraint.
   *
   * An inverted joint constraint only constraints the [Bone2D] to the angles *outside of* the
   * inputted minimum and maximum angles. For this reason, it is referred to as an inverted joint
   * constraint, as it constraints the joint to the outside of the inputted values.
   */
  public final fun setConstraintAngleInvert(invert: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, invert)
    TransferContext.callMethod(MethodBindings.setConstraintAngleInvertPtr)
  }

  /**
   * Returns whether the constraints to this modification are inverted or not.
   */
  public final fun getConstraintAngleInvert(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstraintAngleInvertPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setBone2dNode(bone2dNodepath: String) =
      setBone2dNode(bone2dNodepath.asCachedNodePath())

  public final fun setTargetNode(targetNodepath: String) =
      setTargetNode(targetNodepath.asCachedNodePath())

  public companion object {
    @JvmField
    public val setBone2dNodeName: MethodStringName1<SkeletonModification2DLookAt, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, NodePath>("set_bone2d_node")

    @JvmField
    public val getBone2dNodeName: MethodStringName0<SkeletonModification2DLookAt, NodePath> =
        MethodStringName0<SkeletonModification2DLookAt, NodePath>("get_bone2d_node")

    @JvmField
    public val setBoneIndexName: MethodStringName1<SkeletonModification2DLookAt, Unit, Int> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, Int>("set_bone_index")

    @JvmField
    public val getBoneIndexName: MethodStringName0<SkeletonModification2DLookAt, Int> =
        MethodStringName0<SkeletonModification2DLookAt, Int>("get_bone_index")

    @JvmField
    public val setTargetNodeName: MethodStringName1<SkeletonModification2DLookAt, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<SkeletonModification2DLookAt, NodePath> =
        MethodStringName0<SkeletonModification2DLookAt, NodePath>("get_target_node")

    @JvmField
    public val setAdditionalRotationName:
        MethodStringName1<SkeletonModification2DLookAt, Unit, Float> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, Float>("set_additional_rotation")

    @JvmField
    public val getAdditionalRotationName: MethodStringName0<SkeletonModification2DLookAt, Float> =
        MethodStringName0<SkeletonModification2DLookAt, Float>("get_additional_rotation")

    @JvmField
    public val setEnableConstraintName:
        MethodStringName1<SkeletonModification2DLookAt, Unit, Boolean> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, Boolean>("set_enable_constraint")

    @JvmField
    public val getEnableConstraintName: MethodStringName0<SkeletonModification2DLookAt, Boolean> =
        MethodStringName0<SkeletonModification2DLookAt, Boolean>("get_enable_constraint")

    @JvmField
    public val setConstraintAngleMinName:
        MethodStringName1<SkeletonModification2DLookAt, Unit, Float> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, Float>("set_constraint_angle_min")

    @JvmField
    public val getConstraintAngleMinName: MethodStringName0<SkeletonModification2DLookAt, Float> =
        MethodStringName0<SkeletonModification2DLookAt, Float>("get_constraint_angle_min")

    @JvmField
    public val setConstraintAngleMaxName:
        MethodStringName1<SkeletonModification2DLookAt, Unit, Float> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, Float>("set_constraint_angle_max")

    @JvmField
    public val getConstraintAngleMaxName: MethodStringName0<SkeletonModification2DLookAt, Float> =
        MethodStringName0<SkeletonModification2DLookAt, Float>("get_constraint_angle_max")

    @JvmField
    public val setConstraintAngleInvertName:
        MethodStringName1<SkeletonModification2DLookAt, Unit, Boolean> =
        MethodStringName1<SkeletonModification2DLookAt, Unit, Boolean>("set_constraint_angle_invert")

    @JvmField
    public val getConstraintAngleInvertName:
        MethodStringName0<SkeletonModification2DLookAt, Boolean> =
        MethodStringName0<SkeletonModification2DLookAt, Boolean>("get_constraint_angle_invert")
  }

  public object MethodBindings {
    internal val setBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_bone2d_node", 1348162250)

    internal val getBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_bone2d_node", 4075236667)

    internal val setBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_bone_index", 1286410249)

    internal val getBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_bone_index", 3905245786)

    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_target_node", 4075236667)

    internal val setAdditionalRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_additional_rotation", 373806689)

    internal val getAdditionalRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_additional_rotation", 1740695150)

    internal val setEnableConstraintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_enable_constraint", 2586408642)

    internal val getEnableConstraintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_enable_constraint", 36873697)

    internal val setConstraintAngleMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_constraint_angle_min", 373806689)

    internal val getConstraintAngleMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_constraint_angle_min", 1740695150)

    internal val setConstraintAngleMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_constraint_angle_max", 373806689)

    internal val getConstraintAngleMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_constraint_angle_max", 1740695150)

    internal val setConstraintAngleInvertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "set_constraint_angle_invert", 2586408642)

    internal val getConstraintAngleInvertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DLookAt", "get_constraint_angle_invert", 36873697)
  }
}
