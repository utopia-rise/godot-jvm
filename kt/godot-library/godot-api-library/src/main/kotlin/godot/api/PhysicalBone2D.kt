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
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The [PhysicalBone2D] node is a [RigidBody2D]-based node that can be used to make [Bone2D]s in a
 * [Skeleton2D] react to physics.
 *
 * **Note:** To make the [Bone2D]s visually follow the [PhysicalBone2D] node, use a
 * [SkeletonModification2DPhysicalBones] modification on the [Skeleton2D] parent.
 *
 * **Note:** The [PhysicalBone2D] node does not automatically create a [Joint2D] node to keep
 * [PhysicalBone2D] nodes together. They must be created manually. For most cases, you want to use a
 * [PinJoint2D] node. The [PhysicalBone2D] node will automatically configure the [Joint2D] node once
 * it's been added as a child node.
 */
@GodotBaseType
public open class PhysicalBone2D : RigidBody2D() {
  /**
   * The [NodePath] to the [Bone2D] that this [PhysicalBone2D] should simulate.
   */
  public final inline var bone2dNodepath: NodePath
    @JvmName("bone2dNodepathProperty")
    get() = getBone2dNodepath()
    @JvmName("bone2dNodepathProperty")
    set(`value`) {
      setBone2dNodepath(value)
    }

  /**
   * The index of the [Bone2D] that this [PhysicalBone2D] should simulate.
   */
  public final inline var bone2dIndex: Int
    @JvmName("bone2dIndexProperty")
    get() = getBone2dIndex()
    @JvmName("bone2dIndexProperty")
    set(`value`) {
      setBone2dIndex(value)
    }

  /**
   * If `true`, the [PhysicalBone2D] will automatically configure the first [Joint2D] child node.
   * The automatic configuration is limited to setting up the node properties and positioning the
   * [Joint2D].
   */
  public final inline var autoConfigureJoint: Boolean
    @JvmName("autoConfigureJointProperty")
    get() = getAutoConfigureJoint()
    @JvmName("autoConfigureJointProperty")
    set(`value`) {
      setAutoConfigureJoint(value)
    }

  /**
   * If `true`, the [PhysicalBone2D] will start simulating using physics. If `false`, the
   * [PhysicalBone2D] will follow the transform of the [Bone2D] node.
   *
   * **Note:** To have the [Bone2D]s visually follow the [PhysicalBone2D], use a
   * [SkeletonModification2DPhysicalBones] modification on the [Skeleton2D] node with the [Bone2D]
   * nodes.
   */
  public final inline var simulatePhysics: Boolean
    @JvmName("simulatePhysicsProperty")
    get() = getSimulatePhysics()
    @JvmName("simulatePhysicsProperty")
    set(`value`) {
      setSimulatePhysics(value)
    }

  /**
   * If `true`, the [PhysicalBone2D] will keep the transform of the bone it is bound to when
   * simulating physics.
   */
  public final inline var followBoneWhenSimulating: Boolean
    @JvmName("followBoneWhenSimulatingProperty")
    get() = getFollowBoneWhenSimulating()
    @JvmName("followBoneWhenSimulatingProperty")
    set(`value`) {
      setFollowBoneWhenSimulating(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(519, scriptPtr)
  }

  /**
   * Returns the first [Joint2D] child node, if one exists. This is mainly a helper function to make
   * it easier to get the [Joint2D] that the [PhysicalBone2D] is autoconfiguring.
   */
  public final fun getJoint(): Joint2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getJointPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Joint2D?)
  }

  public final fun getAutoConfigureJoint(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoConfigureJointPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAutoConfigureJoint(autoConfigureJoint: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, autoConfigureJoint)
    TransferContext.callPtrMethod(MethodBindings.setAutoConfigureJointPtr, 0)
  }

  public final fun setSimulatePhysics(simulatePhysics: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, simulatePhysics)
    TransferContext.callPtrMethod(MethodBindings.setSimulatePhysicsPtr, 0)
  }

  public final fun getSimulatePhysics(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSimulatePhysicsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a boolean that indicates whether the [PhysicalBone2D] is running and simulating using
   * the Godot 2D physics engine. When `true`, the PhysicalBone2D node is using physics.
   */
  public final fun isSimulatingPhysics(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isSimulatingPhysicsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setBone2dNodepath(nodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, nodepath)
    TransferContext.callPtrMethod(MethodBindings.setBone2dNodepathPtr, 0)
  }

  public final fun getBone2dNodepath(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBone2dNodepathPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setBone2dIndex(boneIndex: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.setBone2dIndexPtr, 0)
  }

  public final fun getBone2dIndex(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBone2dIndexPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setFollowBoneWhenSimulating(followBone: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, followBone)
    TransferContext.callPtrMethod(MethodBindings.setFollowBoneWhenSimulatingPtr, 0)
  }

  public final fun getFollowBoneWhenSimulating(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFollowBoneWhenSimulatingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setBone2dNodepath(nodepath: String) =
      setBone2dNodepath(nodepath.asCachedNodePath())

  public companion object {
    @JvmField
    public val getJointName: MethodStringName0<PhysicalBone2D, Joint2D?> =
        MethodStringName0<PhysicalBone2D, Joint2D?>("get_joint")

    @JvmField
    public val getAutoConfigureJointName: MethodStringName0<PhysicalBone2D, Boolean> =
        MethodStringName0<PhysicalBone2D, Boolean>("get_auto_configure_joint")

    @JvmField
    public val setAutoConfigureJointName: MethodStringName1<PhysicalBone2D, Unit, Boolean> =
        MethodStringName1<PhysicalBone2D, Unit, Boolean>("set_auto_configure_joint")

    @JvmField
    public val setSimulatePhysicsName: MethodStringName1<PhysicalBone2D, Unit, Boolean> =
        MethodStringName1<PhysicalBone2D, Unit, Boolean>("set_simulate_physics")

    @JvmField
    public val getSimulatePhysicsName: MethodStringName0<PhysicalBone2D, Boolean> =
        MethodStringName0<PhysicalBone2D, Boolean>("get_simulate_physics")

    @JvmField
    public val isSimulatingPhysicsName: MethodStringName0<PhysicalBone2D, Boolean> =
        MethodStringName0<PhysicalBone2D, Boolean>("is_simulating_physics")

    @JvmField
    public val setBone2dNodepathName: MethodStringName1<PhysicalBone2D, Unit, NodePath> =
        MethodStringName1<PhysicalBone2D, Unit, NodePath>("set_bone2d_nodepath")

    @JvmField
    public val getBone2dNodepathName: MethodStringName0<PhysicalBone2D, NodePath> =
        MethodStringName0<PhysicalBone2D, NodePath>("get_bone2d_nodepath")

    @JvmField
    public val setBone2dIndexName: MethodStringName1<PhysicalBone2D, Unit, Int> =
        MethodStringName1<PhysicalBone2D, Unit, Int>("set_bone2d_index")

    @JvmField
    public val getBone2dIndexName: MethodStringName0<PhysicalBone2D, Int> =
        MethodStringName0<PhysicalBone2D, Int>("get_bone2d_index")

    @JvmField
    public val setFollowBoneWhenSimulatingName: MethodStringName1<PhysicalBone2D, Unit, Boolean> =
        MethodStringName1<PhysicalBone2D, Unit, Boolean>("set_follow_bone_when_simulating")

    @JvmField
    public val getFollowBoneWhenSimulatingName: MethodStringName0<PhysicalBone2D, Boolean> =
        MethodStringName0<PhysicalBone2D, Boolean>("get_follow_bone_when_simulating")
  }

  public object MethodBindings {
    internal val getJointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "get_joint", 3582132112)

    internal val getAutoConfigureJointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "get_auto_configure_joint", 36873697)

    internal val setAutoConfigureJointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "set_auto_configure_joint", 2586408642)

    internal val setSimulatePhysicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "set_simulate_physics", 2586408642)

    internal val getSimulatePhysicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "get_simulate_physics", 36873697)

    internal val isSimulatingPhysicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "is_simulating_physics", 36873697)

    internal val setBone2dNodepathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "set_bone2d_nodepath", 1348162250)

    internal val getBone2dNodepathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "get_bone2d_nodepath", 4075236667)

    internal val setBone2dIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "set_bone2d_index", 1286410249)

    internal val getBone2dIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "get_bone2d_index", 3905245786)

    internal val setFollowBoneWhenSimulatingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "set_follow_bone_when_simulating", 2586408642)

    internal val getFollowBoneWhenSimulatingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBone2D", "get_follow_bone_when_simulating", 36873697)
  }
}
