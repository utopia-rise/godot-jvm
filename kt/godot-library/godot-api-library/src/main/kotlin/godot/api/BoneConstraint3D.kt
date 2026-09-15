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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_NODE_PATH
import godot.writeMethodArguments_LONG_STRING
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class of [SkeletonModifier3D] that modifies the bone set in [setApplyBone] based on the
 * transform of the bone retrieved by [getReferenceBone].
 *
 * **Note:** Most methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g. `settings/<index>/amount`).
 */
@GodotBaseType
public open class BoneConstraint3D : SkeletonModifier3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(111, scriptPtr)
  }

  /**
   * Sets the apply amount of the setting at [index] to [amount].
   */
  public final fun setAmount(index: Int, amount: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, index.toLong(), amount.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAmountPtr, 0)
  }

  /**
   * Returns the apply amount of the setting at [index].
   */
  public final fun getAmount(index: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getAmountPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the apply bone of the setting at [index] to [boneName]. This bone will be modified.
   */
  public final fun setApplyBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setApplyBoneNamePtr)
  }

  /**
   * Returns the apply bone name of the setting at [index]. This bone will be modified.
   */
  public final fun getApplyBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getApplyBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the apply bone of the setting at [index] to [bone]. This bone will be modified.
   */
  public final fun setApplyBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setApplyBonePtr, 0)
  }

  /**
   * Returns the apply bone of the setting at [index]. This bone will be modified.
   */
  public final fun getApplyBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getApplyBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the reference target type of the setting at [index] to [type]. See also [ReferenceType].
   */
  public final fun setReferenceType(index: Int, type: ReferenceType): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), type.value)
    TransferContext.callPtrMethod(MethodBindings.setReferenceTypePtr, 0)
  }

  /**
   * Returns the reference target type of the setting at [index]. See also [ReferenceType].
   */
  public final fun getReferenceType(index: Int): ReferenceType {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getReferenceTypePtr, 2)
    return ReferenceType.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the reference bone of the setting at [index] to [boneName].
   *
   * This bone will be only referenced and not modified by this modifier.
   */
  public final fun setReferenceBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setReferenceBoneNamePtr)
  }

  /**
   * Returns the reference bone name of the setting at [index].
   *
   * This bone will be only referenced and not modified by this modifier.
   */
  public final fun getReferenceBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getReferenceBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the reference bone of the setting at [index] to [bone].
   *
   * This bone will be only referenced and not modified by this modifier.
   */
  public final fun setReferenceBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setReferenceBonePtr, 0)
  }

  /**
   * Returns the reference bone of the setting at [index].
   *
   * This bone will be only referenced and not modified by this modifier.
   */
  public final fun getReferenceBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getReferenceBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the reference node path of the setting at [index] to [node].
   *
   * This node will be only referenced and not modified by this modifier.
   */
  public final fun setReferenceNode(index: Int, node: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, index.toLong(), node)
    TransferContext.callPtrMethod(MethodBindings.setReferenceNodePtr, 0)
  }

  /**
   * Returns the reference node path of the setting at [index].
   *
   * This node will be only referenced and not modified by this modifier.
   */
  public final fun getReferenceNode(index: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getReferenceNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the number of settings in the modifier.
   */
  public final fun setSettingCount(count: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callPtrMethod(MethodBindings.setSettingCountPtr, 0)
  }

  /**
   * Returns the number of settings in the modifier.
   */
  public final fun getSettingCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSettingCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Clear all settings.
   */
  public final fun clearSetting(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearSettingPtr, 0)
  }

  /**
   * Sets the reference node path of the setting at [index] to [node].
   *
   * This node will be only referenced and not modified by this modifier.
   */
  public final fun setReferenceNode(index: Int, node: String) =
      setReferenceNode(index, node.asCachedNodePath())

  public enum class ReferenceType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The reference target is a bone. In this case, the reference target spaces is local space.
     */
    BONE(0),
    /**
     * The reference target is a [Node3D]. In this case, the reference target spaces is model space.
     *
     * In other words, the reference target's coordinates are treated as if it were placed directly
     * under [Skeleton3D] which parent of the [BoneConstraint3D].
     */
    NODE(1),
    ;

    public companion object {
      public fun from(`value`: Long): ReferenceType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setAmountName: MethodStringName2<BoneConstraint3D, Unit, Int, Float> =
        MethodStringName2<BoneConstraint3D, Unit, Int, Float>("set_amount")

    @JvmField
    public val getAmountName: MethodStringName1<BoneConstraint3D, Float, Int> =
        MethodStringName1<BoneConstraint3D, Float, Int>("get_amount")

    @JvmField
    public val setApplyBoneNameName: MethodStringName2<BoneConstraint3D, Unit, Int, String> =
        MethodStringName2<BoneConstraint3D, Unit, Int, String>("set_apply_bone_name")

    @JvmField
    public val getApplyBoneNameName: MethodStringName1<BoneConstraint3D, String, Int> =
        MethodStringName1<BoneConstraint3D, String, Int>("get_apply_bone_name")

    @JvmField
    public val setApplyBoneName: MethodStringName2<BoneConstraint3D, Unit, Int, Int> =
        MethodStringName2<BoneConstraint3D, Unit, Int, Int>("set_apply_bone")

    @JvmField
    public val getApplyBoneName: MethodStringName1<BoneConstraint3D, Int, Int> =
        MethodStringName1<BoneConstraint3D, Int, Int>("get_apply_bone")

    @JvmField
    public val setReferenceTypeName: MethodStringName2<BoneConstraint3D, Unit, Int, ReferenceType> =
        MethodStringName2<BoneConstraint3D, Unit, Int, ReferenceType>("set_reference_type")

    @JvmField
    public val getReferenceTypeName: MethodStringName1<BoneConstraint3D, ReferenceType, Int> =
        MethodStringName1<BoneConstraint3D, ReferenceType, Int>("get_reference_type")

    @JvmField
    public val setReferenceBoneNameName: MethodStringName2<BoneConstraint3D, Unit, Int, String> =
        MethodStringName2<BoneConstraint3D, Unit, Int, String>("set_reference_bone_name")

    @JvmField
    public val getReferenceBoneNameName: MethodStringName1<BoneConstraint3D, String, Int> =
        MethodStringName1<BoneConstraint3D, String, Int>("get_reference_bone_name")

    @JvmField
    public val setReferenceBoneName: MethodStringName2<BoneConstraint3D, Unit, Int, Int> =
        MethodStringName2<BoneConstraint3D, Unit, Int, Int>("set_reference_bone")

    @JvmField
    public val getReferenceBoneName: MethodStringName1<BoneConstraint3D, Int, Int> =
        MethodStringName1<BoneConstraint3D, Int, Int>("get_reference_bone")

    @JvmField
    public val setReferenceNodeName: MethodStringName2<BoneConstraint3D, Unit, Int, NodePath> =
        MethodStringName2<BoneConstraint3D, Unit, Int, NodePath>("set_reference_node")

    @JvmField
    public val getReferenceNodeName: MethodStringName1<BoneConstraint3D, NodePath, Int> =
        MethodStringName1<BoneConstraint3D, NodePath, Int>("get_reference_node")

    @JvmField
    public val setSettingCountName: MethodStringName1<BoneConstraint3D, Unit, Int> =
        MethodStringName1<BoneConstraint3D, Unit, Int>("set_setting_count")

    @JvmField
    public val getSettingCountName: MethodStringName0<BoneConstraint3D, Int> =
        MethodStringName0<BoneConstraint3D, Int>("get_setting_count")

    @JvmField
    public val clearSettingName: MethodStringName0<BoneConstraint3D, Unit> =
        MethodStringName0<BoneConstraint3D, Unit>("clear_setting")
  }

  public object MethodBindings {
    internal val setAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_amount", 1602489585)

    internal val getAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_amount", 2339986948)

    internal val setApplyBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_apply_bone_name", 501894301)

    internal val getApplyBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_apply_bone_name", 844755477)

    internal val setApplyBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_apply_bone", 3937882851)

    internal val getApplyBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_apply_bone", 923996154)

    internal val setReferenceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_reference_type", 1830520418)

    internal val getReferenceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_reference_type", 3456416152)

    internal val setReferenceBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_reference_bone_name", 501894301)

    internal val getReferenceBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_reference_bone_name", 844755477)

    internal val setReferenceBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_reference_bone", 3937882851)

    internal val getReferenceBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_reference_bone", 923996154)

    internal val setReferenceNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_reference_node", 2761262315)

    internal val getReferenceNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_reference_node", 408788394)

    internal val setSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "set_setting_count", 1286410249)

    internal val getSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "get_setting_count", 3905245786)

    internal val clearSettingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneConstraint3D", "clear_setting", 3218959716)
  }
}
