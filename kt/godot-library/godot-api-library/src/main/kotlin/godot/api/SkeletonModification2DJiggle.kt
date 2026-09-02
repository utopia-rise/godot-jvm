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
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This modification moves a series of bones, typically called a bone chain, towards a target. What
 * makes this modification special is that it calculates the velocity and acceleration for each bone in
 * the bone chain, and runs a very light physics-like calculation using the inputted values. This
 * allows the bones to overshoot the target and "jiggle" around. It can be configured to act more like
 * a spring, or sway around like cloth might.
 *
 * This modification is useful for adding additional motion to things like hair, the edges of
 * clothing, and more. It has several settings to that allow control over how the joint moves when the
 * target moves.
 *
 * **Note:** The Jiggle modifier has `jiggle_joints`, which are the data objects that hold the data
 * for each joint in the Jiggle chain. This is different from than [Bone2D] nodes! Jiggle joints hold
 * the data needed for each [Bone2D] in the bone chain used by the Jiggle modification.
 */
@GodotBaseType
public open class SkeletonModification2DJiggle : SkeletonModification2D() {
  /**
   * The NodePath to the node that is the target for the Jiggle modification. This node is what the
   * Jiggle chain will attempt to rotate the bone chain to.
   */
  public final inline var targetNodepath: NodePath
    @JvmName("targetNodepathProperty")
    get() = getTargetNode()
    @JvmName("targetNodepathProperty")
    set(`value`) {
      setTargetNode(value)
    }

  /**
   * The amount of Jiggle joints in the Jiggle modification.
   */
  public final inline var jiggleDataChainLength: Int
    @JvmName("jiggleDataChainLengthProperty")
    get() = getJiggleDataChainLength()
    @JvmName("jiggleDataChainLengthProperty")
    set(`value`) {
      setJiggleDataChainLength(value)
    }

  /**
   * The default amount of stiffness assigned to the Jiggle joints, if they are not overridden.
   * Higher values act more like springs, quickly moving into the correct position.
   */
  public final inline var stiffness: Float
    @JvmName("stiffnessProperty")
    get() = getStiffness()
    @JvmName("stiffnessProperty")
    set(`value`) {
      setStiffness(value)
    }

  /**
   * The default amount of mass assigned to the Jiggle joints, if they are not overridden. Higher
   * values lead to faster movements and more overshooting.
   */
  public final inline var mass: Float
    @JvmName("massProperty")
    get() = getMass()
    @JvmName("massProperty")
    set(`value`) {
      setMass(value)
    }

  /**
   * The default amount of damping applied to the Jiggle joints, if they are not overridden. Higher
   * values lead to more of the calculated velocity being applied.
   */
  public final inline var damping: Float
    @JvmName("dampingProperty")
    get() = getDamping()
    @JvmName("dampingProperty")
    set(`value`) {
      setDamping(value)
    }

  /**
   * Whether the gravity vector, [gravity], should be applied to the Jiggle joints, assuming they
   * are not overriding the default settings.
   */
  public final inline var useGravity: Boolean
    @JvmName("useGravityProperty")
    get() = getUseGravity()
    @JvmName("useGravityProperty")
    set(`value`) {
      setUseGravity(value)
    }

  /**
   * The default amount of gravity applied to the Jiggle joints, if they are not overridden.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var gravity: Vector2
    @JvmName("gravityProperty")
    get() = getGravity()
    @JvmName("gravityProperty")
    set(`value`) {
      setGravity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(670, scriptPtr)
  }

  /**
   * This is a helper function for [gravity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = skeletonmodification2djiggle.gravity
   * //Your changes
   * skeletonmodification2djiggle.gravity = myCoreType
   * ``````
   *
   * The default amount of gravity applied to the Jiggle joints, if they are not overridden.
   */
  @CoreTypeHelper
  public final fun gravityMutate(block: Vector2.() -> Unit): Vector2 = gravity.apply {
     block(this)
     gravity = this
  }

  public final fun setTargetNode(targetNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to targetNodepath)
    TransferContext.callMethod(MethodBindings.setTargetNodePtr)
  }

  public final fun getTargetNode(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetNodePtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setJiggleDataChainLength(length: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to length.toLong())
    TransferContext.callMethod(MethodBindings.setJiggleDataChainLengthPtr)
  }

  public final fun getJiggleDataChainLength(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJiggleDataChainLengthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setStiffness(stiffness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to stiffness.toDouble())
    TransferContext.callMethod(MethodBindings.setStiffnessPtr)
  }

  public final fun getStiffness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStiffnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMass(mass: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mass.toDouble())
    TransferContext.callMethod(MethodBindings.setMassPtr)
  }

  public final fun getMass(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMassPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDamping(damping: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to damping.toDouble())
    TransferContext.callMethod(MethodBindings.setDampingPtr)
  }

  public final fun getDamping(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDampingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setUseGravity(useGravity: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useGravity)
    TransferContext.callMethod(MethodBindings.setUseGravityPtr)
  }

  public final fun getUseGravity(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseGravityPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGravity(gravity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to gravity)
    TransferContext.callMethod(MethodBindings.setGravityPtr)
  }

  public final fun getGravity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * If `true`, the Jiggle modifier will take colliders into account, keeping them from entering
   * into these collision objects.
   */
  public final fun setUseColliders(useColliders: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useColliders)
    TransferContext.callMethod(MethodBindings.setUseCollidersPtr)
  }

  /**
   * Returns whether the jiggle modifier is taking physics colliders into account when solving.
   */
  public final fun getUseColliders(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseCollidersPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the collision mask that the Jiggle modifier will use when reacting to colliders, if the
   * Jiggle modifier is set to take colliders into account.
   */
  public final fun setCollisionMask(collisionMask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to collisionMask.toLong())
    TransferContext.callMethod(MethodBindings.setCollisionMaskPtr)
  }

  /**
   * Returns the collision mask used by the Jiggle modifier when collisions are enabled.
   */
  public final fun getCollisionMask(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Resets the internal jiggle simulation state to the current bone positions, clearing velocity,
   * acceleration, and accumulated forces.
   */
  public final fun reset(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetPtr)
  }

  /**
   * Sets the [Bone2D] node assigned to the Jiggle joint at [jointIdx].
   */
  public final fun setJiggleJointBone2dNode(jointIdx: Int, bone2dNode: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), NODE_PATH to bone2dNode)
    TransferContext.callMethod(MethodBindings.setJiggleJointBone2dNodePtr)
  }

  /**
   * Returns the [Bone2D] node assigned to the Jiggle joint at [jointIdx].
   */
  public final fun getJiggleJointBone2dNode(jointIdx: Int): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointBone2dNodePtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Sets the bone index, [boneIdx], of the Jiggle joint at [jointIdx]. When possible, this will
   * also update the `bone2d_node` of the Jiggle joint based on data provided by the linked skeleton.
   */
  public final fun setJiggleJointBoneIndex(jointIdx: Int, boneIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), LONG to boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.setJiggleJointBoneIndexPtr)
  }

  /**
   * Returns the index of the [Bone2D] node assigned to the Jiggle joint at [jointIdx].
   */
  public final fun getJiggleJointBoneIndex(jointIdx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointBoneIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets whether the Jiggle joint at [jointIdx] should override the default Jiggle joint settings.
   * Setting this to `true` will make the joint use its own settings rather than the default ones
   * attached to the modification.
   */
  public final fun setJiggleJointOverride(jointIdx: Int, `override`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), BOOL to override)
    TransferContext.callMethod(MethodBindings.setJiggleJointOverridePtr)
  }

  /**
   * Returns a boolean that indicates whether the joint at [jointIdx] is overriding the default
   * Jiggle joint data defined in the modification.
   */
  public final fun getJiggleJointOverride(jointIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the of stiffness of the Jiggle joint at [jointIdx].
   */
  public final fun setJiggleJointStiffness(jointIdx: Int, stiffness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), DOUBLE to stiffness.toDouble())
    TransferContext.callMethod(MethodBindings.setJiggleJointStiffnessPtr)
  }

  /**
   * Returns the stiffness of the Jiggle joint at [jointIdx].
   */
  public final fun getJiggleJointStiffness(jointIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointStiffnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the of mass of the Jiggle joint at [jointIdx].
   */
  public final fun setJiggleJointMass(jointIdx: Int, mass: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), DOUBLE to mass.toDouble())
    TransferContext.callMethod(MethodBindings.setJiggleJointMassPtr)
  }

  /**
   * Returns the amount of mass of the jiggle joint at [jointIdx].
   */
  public final fun getJiggleJointMass(jointIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointMassPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the amount of damping of the Jiggle joint at [jointIdx].
   */
  public final fun setJiggleJointDamping(jointIdx: Int, damping: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), DOUBLE to damping.toDouble())
    TransferContext.callMethod(MethodBindings.setJiggleJointDampingPtr)
  }

  /**
   * Returns the amount of damping of the Jiggle joint at [jointIdx].
   */
  public final fun getJiggleJointDamping(jointIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointDampingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets whether the Jiggle joint at [jointIdx] should use gravity.
   */
  public final fun setJiggleJointUseGravity(jointIdx: Int, useGravity: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), BOOL to useGravity)
    TransferContext.callMethod(MethodBindings.setJiggleJointUseGravityPtr)
  }

  /**
   * Returns a boolean that indicates whether the joint at [jointIdx] is using gravity or not.
   */
  public final fun getJiggleJointUseGravity(jointIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointUseGravityPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the gravity vector of the Jiggle joint at [jointIdx].
   */
  public final fun setJiggleJointGravity(jointIdx: Int, gravity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong(), VECTOR2 to gravity)
    TransferContext.callMethod(MethodBindings.setJiggleJointGravityPtr)
  }

  /**
   * Returns a [Vector2] representing the amount of gravity the Jiggle joint at [jointIdx] is
   * influenced by.
   */
  public final fun getJiggleJointGravity(jointIdx: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getJiggleJointGravityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setTargetNode(targetNodepath: String) =
      setTargetNode(targetNodepath.asCachedNodePath())

  /**
   * Sets the [Bone2D] node assigned to the Jiggle joint at [jointIdx].
   */
  public final fun setJiggleJointBone2dNode(jointIdx: Int, bone2dNode: String) =
      setJiggleJointBone2dNode(jointIdx, bone2dNode.asCachedNodePath())

  public companion object {
    @JvmField
    public val setTargetNodeName: MethodStringName1<SkeletonModification2DJiggle, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<SkeletonModification2DJiggle, NodePath> =
        MethodStringName0<SkeletonModification2DJiggle, NodePath>("get_target_node")

    @JvmField
    public val setJiggleDataChainLengthName:
        MethodStringName1<SkeletonModification2DJiggle, Unit, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Int>("set_jiggle_data_chain_length")

    @JvmField
    public val getJiggleDataChainLengthName: MethodStringName0<SkeletonModification2DJiggle, Int> =
        MethodStringName0<SkeletonModification2DJiggle, Int>("get_jiggle_data_chain_length")

    @JvmField
    public val setStiffnessName: MethodStringName1<SkeletonModification2DJiggle, Unit, Float> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Float>("set_stiffness")

    @JvmField
    public val getStiffnessName: MethodStringName0<SkeletonModification2DJiggle, Float> =
        MethodStringName0<SkeletonModification2DJiggle, Float>("get_stiffness")

    @JvmField
    public val setMassName: MethodStringName1<SkeletonModification2DJiggle, Unit, Float> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Float>("set_mass")

    @JvmField
    public val getMassName: MethodStringName0<SkeletonModification2DJiggle, Float> =
        MethodStringName0<SkeletonModification2DJiggle, Float>("get_mass")

    @JvmField
    public val setDampingName: MethodStringName1<SkeletonModification2DJiggle, Unit, Float> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Float>("set_damping")

    @JvmField
    public val getDampingName: MethodStringName0<SkeletonModification2DJiggle, Float> =
        MethodStringName0<SkeletonModification2DJiggle, Float>("get_damping")

    @JvmField
    public val setUseGravityName: MethodStringName1<SkeletonModification2DJiggle, Unit, Boolean> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Boolean>("set_use_gravity")

    @JvmField
    public val getUseGravityName: MethodStringName0<SkeletonModification2DJiggle, Boolean> =
        MethodStringName0<SkeletonModification2DJiggle, Boolean>("get_use_gravity")

    @JvmField
    public val setGravityName: MethodStringName1<SkeletonModification2DJiggle, Unit, Vector2> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Vector2>("set_gravity")

    @JvmField
    public val getGravityName: MethodStringName0<SkeletonModification2DJiggle, Vector2> =
        MethodStringName0<SkeletonModification2DJiggle, Vector2>("get_gravity")

    @JvmField
    public val setUseCollidersName: MethodStringName1<SkeletonModification2DJiggle, Unit, Boolean> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Boolean>("set_use_colliders")

    @JvmField
    public val getUseCollidersName: MethodStringName0<SkeletonModification2DJiggle, Boolean> =
        MethodStringName0<SkeletonModification2DJiggle, Boolean>("get_use_colliders")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<SkeletonModification2DJiggle, Unit, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Unit, Int>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<SkeletonModification2DJiggle, Int> =
        MethodStringName0<SkeletonModification2DJiggle, Int>("get_collision_mask")

    @JvmField
    public val resetName: MethodStringName0<SkeletonModification2DJiggle, Unit> =
        MethodStringName0<SkeletonModification2DJiggle, Unit>("reset")

    @JvmField
    public val setJiggleJointBone2dNodeName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, NodePath> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, NodePath>("set_jiggle_joint_bone2d_node")

    @JvmField
    public val getJiggleJointBone2dNodeName:
        MethodStringName1<SkeletonModification2DJiggle, NodePath, Int> =
        MethodStringName1<SkeletonModification2DJiggle, NodePath, Int>("get_jiggle_joint_bone2d_node")

    @JvmField
    public val setJiggleJointBoneIndexName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Int> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Int>("set_jiggle_joint_bone_index")

    @JvmField
    public val getJiggleJointBoneIndexName:
        MethodStringName1<SkeletonModification2DJiggle, Int, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Int, Int>("get_jiggle_joint_bone_index")

    @JvmField
    public val setJiggleJointOverrideName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Boolean> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Boolean>("set_jiggle_joint_override")

    @JvmField
    public val getJiggleJointOverrideName:
        MethodStringName1<SkeletonModification2DJiggle, Boolean, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Boolean, Int>("get_jiggle_joint_override")

    @JvmField
    public val setJiggleJointStiffnessName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Float> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Float>("set_jiggle_joint_stiffness")

    @JvmField
    public val getJiggleJointStiffnessName:
        MethodStringName1<SkeletonModification2DJiggle, Float, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Float, Int>("get_jiggle_joint_stiffness")

    @JvmField
    public val setJiggleJointMassName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Float> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Float>("set_jiggle_joint_mass")

    @JvmField
    public val getJiggleJointMassName: MethodStringName1<SkeletonModification2DJiggle, Float, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Float, Int>("get_jiggle_joint_mass")

    @JvmField
    public val setJiggleJointDampingName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Float> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Float>("set_jiggle_joint_damping")

    @JvmField
    public val getJiggleJointDampingName:
        MethodStringName1<SkeletonModification2DJiggle, Float, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Float, Int>("get_jiggle_joint_damping")

    @JvmField
    public val setJiggleJointUseGravityName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Boolean> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Boolean>("set_jiggle_joint_use_gravity")

    @JvmField
    public val getJiggleJointUseGravityName:
        MethodStringName1<SkeletonModification2DJiggle, Boolean, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Boolean, Int>("get_jiggle_joint_use_gravity")

    @JvmField
    public val setJiggleJointGravityName:
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Vector2> =
        MethodStringName2<SkeletonModification2DJiggle, Unit, Int, Vector2>("set_jiggle_joint_gravity")

    @JvmField
    public val getJiggleJointGravityName:
        MethodStringName1<SkeletonModification2DJiggle, Vector2, Int> =
        MethodStringName1<SkeletonModification2DJiggle, Vector2, Int>("get_jiggle_joint_gravity")
  }

  public object MethodBindings {
    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_target_node", 4075236667)

    internal val setJiggleDataChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_data_chain_length", 1286410249)

    internal val getJiggleDataChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_data_chain_length", 2455072627)

    internal val setStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_stiffness", 373806689)

    internal val getStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_stiffness", 1740695150)

    internal val setMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_mass", 373806689)

    internal val getMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_mass", 1740695150)

    internal val setDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_damping", 373806689)

    internal val getDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_damping", 1740695150)

    internal val setUseGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_use_gravity", 2586408642)

    internal val getUseGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_use_gravity", 36873697)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_gravity", 743155724)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_gravity", 3341600327)

    internal val setUseCollidersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_use_colliders", 2586408642)

    internal val getUseCollidersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_use_colliders", 36873697)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_collision_mask", 3905245786)

    internal val resetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "reset", 3218959716)

    internal val setJiggleJointBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_bone2d_node", 2761262315)

    internal val getJiggleJointBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_bone2d_node", 408788394)

    internal val setJiggleJointBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_bone_index", 3937882851)

    internal val getJiggleJointBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_bone_index", 923996154)

    internal val setJiggleJointOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_override", 300928843)

    internal val getJiggleJointOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_override", 1116898809)

    internal val setJiggleJointStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_stiffness", 1602489585)

    internal val getJiggleJointStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_stiffness", 2339986948)

    internal val setJiggleJointMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_mass", 1602489585)

    internal val getJiggleJointMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_mass", 2339986948)

    internal val setJiggleJointDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_damping", 1602489585)

    internal val getJiggleJointDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_damping", 2339986948)

    internal val setJiggleJointUseGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_use_gravity", 300928843)

    internal val getJiggleJointUseGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_use_gravity", 1116898809)

    internal val setJiggleJointGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "set_jiggle_joint_gravity", 163021252)

    internal val getJiggleJointGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DJiggle", "get_jiggle_joint_gravity", 2299179447)
  }
}
