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
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_NODE_PATH
import godot.callPtrMethod_LONG_ret_NODE_PATH
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedNodePath
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This modification takes the transforms of [PhysicalBone2D] nodes and applies them to [Bone2D]
 * nodes. This allows the [Bone2D] nodes to react to physics thanks to the linked [PhysicalBone2D]
 * nodes.
 */
@GodotBaseType
public open class SkeletonModification2DPhysicalBones : SkeletonModification2D() {
  /**
   * The number of [PhysicalBone2D] nodes linked in this modification.
   */
  public final inline var physicalBoneChainLength: Int
    @JvmName("physicalBoneChainLengthProperty")
    get() = getPhysicalBoneChainLength()
    @JvmName("physicalBoneChainLengthProperty")
    set(`value`) {
      setPhysicalBoneChainLength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(672, scriptPtr)
  }

  public final fun setPhysicalBoneChainLength(length: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setPhysicalBoneChainLengthPtr, length.toLong())
  }

  public final fun getPhysicalBoneChainLength(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPhysicalBoneChainLengthPtr).toInt()

  /**
   * Sets the [PhysicalBone2D] node at [jointIdx].
   *
   * **Note:** This is just the index used for this modification, not the bone index used in the
   * [Skeleton2D].
   */
  public final fun setPhysicalBoneNode(jointIdx: Int, physicalbone2dNode: NodePath): Unit {
    TransferContext.callPtrMethod_LONG_NODE_PATH(ptr, objectID.id, MethodBindings.setPhysicalBoneNodePtr, jointIdx.toLong(), physicalbone2dNode)
  }

  /**
   * Returns the [PhysicalBone2D] node at [jointIdx].
   */
  public final fun getPhysicalBoneNode(jointIdx: Int): NodePath =
      TransferContext.callPtrMethod_LONG_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getPhysicalBoneNodePtr, jointIdx.toLong())

  /**
   * Empties the list of [PhysicalBone2D] nodes and populates it with all [PhysicalBone2D] nodes
   * that are children of the [Skeleton2D].
   */
  public final fun fetchPhysicalBones(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.fetchPhysicalBonesPtr)
  }

  /**
   * Tell the [PhysicalBone2D] nodes to start simulating and interacting with the physics world.
   *
   * Optionally, an array of bone names can be passed to this function, and that will cause only
   * [PhysicalBone2D] nodes with those names to start simulating.
   */
  @JvmOverloads
  public final fun startSimulation(bones: VariantArray<StringName> = godot.core.variantArrayOf()):
      Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.startSimulationPtr, bones)
  }

  /**
   * Tell the [PhysicalBone2D] nodes to stop simulating and interacting with the physics world.
   *
   * Optionally, an array of bone names can be passed to this function, and that will cause only
   * [PhysicalBone2D] nodes with those names to stop simulating.
   */
  @JvmOverloads
  public final fun stopSimulation(bones: VariantArray<StringName> = godot.core.variantArrayOf()):
      Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.stopSimulationPtr, bones)
  }

  /**
   * Sets the [PhysicalBone2D] node at [jointIdx].
   *
   * **Note:** This is just the index used for this modification, not the bone index used in the
   * [Skeleton2D].
   */
  public final fun setPhysicalBoneNode(jointIdx: Int, physicalbone2dNode: String) =
      setPhysicalBoneNode(jointIdx, physicalbone2dNode.asCachedNodePath())

  public companion object {
    @JvmField
    public val setPhysicalBoneChainLengthName:
        MethodStringName1<SkeletonModification2DPhysicalBones, Unit, Int> =
        MethodStringName1<SkeletonModification2DPhysicalBones, Unit, Int>("set_physical_bone_chain_length")

    @JvmField
    public val getPhysicalBoneChainLengthName:
        MethodStringName0<SkeletonModification2DPhysicalBones, Int> =
        MethodStringName0<SkeletonModification2DPhysicalBones, Int>("get_physical_bone_chain_length")

    @JvmField
    public val setPhysicalBoneNodeName:
        MethodStringName2<SkeletonModification2DPhysicalBones, Unit, Int, NodePath> =
        MethodStringName2<SkeletonModification2DPhysicalBones, Unit, Int, NodePath>("set_physical_bone_node")

    @JvmField
    public val getPhysicalBoneNodeName:
        MethodStringName1<SkeletonModification2DPhysicalBones, NodePath, Int> =
        MethodStringName1<SkeletonModification2DPhysicalBones, NodePath, Int>("get_physical_bone_node")

    @JvmField
    public val fetchPhysicalBonesName: MethodStringName0<SkeletonModification2DPhysicalBones, Unit>
        = MethodStringName0<SkeletonModification2DPhysicalBones, Unit>("fetch_physical_bones")

    @JvmField
    public val startSimulationName:
        MethodStringName1<SkeletonModification2DPhysicalBones, Unit, VariantArray<StringName>> =
        MethodStringName1<SkeletonModification2DPhysicalBones, Unit, VariantArray<StringName>>("start_simulation")

    @JvmField
    public val stopSimulationName:
        MethodStringName1<SkeletonModification2DPhysicalBones, Unit, VariantArray<StringName>> =
        MethodStringName1<SkeletonModification2DPhysicalBones, Unit, VariantArray<StringName>>("stop_simulation")
  }

  public object MethodBindings {
    internal val setPhysicalBoneChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "set_physical_bone_chain_length", 1286410249)

    internal val getPhysicalBoneChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "get_physical_bone_chain_length", 2455072627)

    internal val setPhysicalBoneNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "set_physical_bone_node", 2761262315)

    internal val getPhysicalBoneNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "get_physical_bone_node", 408788394)

    internal val fetchPhysicalBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "fetch_physical_bones", 3218959716)

    internal val startSimulationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "start_simulation", 2787316981)

    internal val stopSimulationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DPhysicalBones", "stop_simulation", 2787316981)
  }
}
