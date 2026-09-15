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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedInt32Array
import godot.core.Transform3D
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_INT_32_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_DICTIONARY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_PACKED_INT_32_ARRAY
import kotlin.Any
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class GLTFSkin : Resource() {
  public final inline var skinRoot: Int
    @JvmName("skinRootProperty")
    get() = getSkinRoot()
    @JvmName("skinRootProperty")
    set(`value`) {
      setSkinRoot(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var jointsOriginal: PackedInt32Array
    @JvmName("jointsOriginalProperty")
    get() = getJointsOriginal()
    @JvmName("jointsOriginalProperty")
    set(`value`) {
      setJointsOriginal(value)
    }

  public final inline var inverseBinds: VariantArray<Transform3D>
    @JvmName("inverseBindsProperty")
    get() = getInverseBinds()
    @JvmName("inverseBindsProperty")
    set(`value`) {
      setInverseBinds(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var joints: PackedInt32Array
    @JvmName("jointsProperty")
    get() = getJoints()
    @JvmName("jointsProperty")
    set(`value`) {
      setJoints(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var nonJoints: PackedInt32Array
    @JvmName("nonJointsProperty")
    get() = getNonJoints()
    @JvmName("nonJointsProperty")
    set(`value`) {
      setNonJoints(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var roots: PackedInt32Array
    @JvmName("rootsProperty")
    get() = getRoots()
    @JvmName("rootsProperty")
    set(`value`) {
      setRoots(value)
    }

  public final inline var skeleton: Int
    @JvmName("skeletonProperty")
    get() = getSkeleton()
    @JvmName("skeletonProperty")
    set(`value`) {
      setSkeleton(value)
    }

  public final inline var jointIToBoneI: Dictionary<Any?, Any?>
    @JvmName("jointIToBoneIProperty")
    get() = getJointIToBoneI()
    @JvmName("jointIToBoneIProperty")
    set(`value`) {
      setJointIToBoneI(value)
    }

  public final inline var jointIToName: Dictionary<Any?, Any?>
    @JvmName("jointIToNameProperty")
    get() = getJointIToName()
    @JvmName("jointIToNameProperty")
    set(`value`) {
      setJointIToName(value)
    }

  public final inline var godotSkin: Skin?
    @JvmName("godotSkinProperty")
    get() = getGodotSkin()
    @JvmName("godotSkinProperty")
    set(`value`) {
      setGodotSkin(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(252, scriptPtr)
  }

  /**
   * This is a helper function for [jointsOriginal] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfskin.jointsOriginal
   * //Your changes
   * gltfskin.jointsOriginal = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun jointsOriginalMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      jointsOriginal.apply {
     block(this)
     jointsOriginal = this
  }

  /**
   * This is a helper function for [jointsOriginal] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun jointsOriginalMutateEach(block: (index: Int, `value`: Int) -> Unit):
      PackedInt32Array = jointsOriginal.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     jointsOriginal = this
  }

  /**
   * This is a helper function for [joints] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfskin.joints
   * //Your changes
   * gltfskin.joints = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun jointsMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      joints.apply {
     block(this)
     joints = this
  }

  /**
   * This is a helper function for [joints] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun jointsMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array =
      joints.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     joints = this
  }

  /**
   * This is a helper function for [nonJoints] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfskin.nonJoints
   * //Your changes
   * gltfskin.nonJoints = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun nonJointsMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      nonJoints.apply {
     block(this)
     nonJoints = this
  }

  /**
   * This is a helper function for [nonJoints] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun nonJointsMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array
      = nonJoints.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     nonJoints = this
  }

  /**
   * This is a helper function for [roots] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfskin.roots
   * //Your changes
   * gltfskin.roots = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun rootsMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array = roots.apply {
     block(this)
     roots = this
  }

  /**
   * This is a helper function for [roots] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun rootsMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array =
      roots.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     roots = this
  }

  public final fun getSkinRoot(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinRootPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setSkinRoot(skinRoot: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, skinRoot.toLong())
    TransferContext.callMethod(MethodBindings.setSkinRootPtr)
  }

  public final fun getJointsOriginal(): PackedInt32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJointsOriginalPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  public final fun setJointsOriginal(jointsOriginal: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments_PACKED_INT_32_ARRAY(ptr, objectID.id, jointsOriginal)
    TransferContext.callMethod(MethodBindings.setJointsOriginalPtr)
  }

  public final fun getInverseBinds(): VariantArray<Transform3D> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInverseBindsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Transform3D>)
  }

  public final fun setInverseBinds(inverseBinds: VariantArray<Transform3D>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, inverseBinds)
    TransferContext.callMethod(MethodBindings.setInverseBindsPtr)
  }

  public final fun getJoints(): PackedInt32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJointsPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  public final fun setJoints(joints: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments_PACKED_INT_32_ARRAY(ptr, objectID.id, joints)
    TransferContext.callMethod(MethodBindings.setJointsPtr)
  }

  public final fun getNonJoints(): PackedInt32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNonJointsPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  public final fun setNonJoints(nonJoints: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments_PACKED_INT_32_ARRAY(ptr, objectID.id, nonJoints)
    TransferContext.callMethod(MethodBindings.setNonJointsPtr)
  }

  public final fun getRoots(): PackedInt32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootsPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  public final fun setRoots(roots: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments_PACKED_INT_32_ARRAY(ptr, objectID.id, roots)
    TransferContext.callMethod(MethodBindings.setRootsPtr)
  }

  public final fun getSkeleton(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setSkeleton(skeleton: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, skeleton.toLong())
    TransferContext.callMethod(MethodBindings.setSkeletonPtr)
  }

  public final fun getJointIToBoneI(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJointIToBoneIPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public final fun setJointIToBoneI(jointIToBoneI: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments_DICTIONARY(ptr, objectID.id, jointIToBoneI)
    TransferContext.callMethod(MethodBindings.setJointIToBoneIPtr)
  }

  public final fun getJointIToName(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJointIToNamePtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public final fun setJointIToName(jointIToName: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments_DICTIONARY(ptr, objectID.id, jointIToName)
    TransferContext.callMethod(MethodBindings.setJointIToNamePtr)
  }

  public final fun getGodotSkin(): Skin? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGodotSkinPtr)
    return (TransferContext.readReturnValue_OBJECT() as Skin?)
  }

  public final fun setGodotSkin(godotSkin: Skin?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, godotSkin)
    TransferContext.callMethod(MethodBindings.setGodotSkinPtr)
  }

  public companion object {
    @JvmField
    public val getSkinRootName: MethodStringName0<GLTFSkin, Int> =
        MethodStringName0<GLTFSkin, Int>("get_skin_root")

    @JvmField
    public val setSkinRootName: MethodStringName1<GLTFSkin, Unit, Int> =
        MethodStringName1<GLTFSkin, Unit, Int>("set_skin_root")

    @JvmField
    public val getJointsOriginalName: MethodStringName0<GLTFSkin, PackedInt32Array> =
        MethodStringName0<GLTFSkin, PackedInt32Array>("get_joints_original")

    @JvmField
    public val setJointsOriginalName: MethodStringName1<GLTFSkin, Unit, PackedInt32Array> =
        MethodStringName1<GLTFSkin, Unit, PackedInt32Array>("set_joints_original")

    @JvmField
    public val getInverseBindsName: MethodStringName0<GLTFSkin, VariantArray<Transform3D>> =
        MethodStringName0<GLTFSkin, VariantArray<Transform3D>>("get_inverse_binds")

    @JvmField
    public val setInverseBindsName: MethodStringName1<GLTFSkin, Unit, VariantArray<Transform3D>> =
        MethodStringName1<GLTFSkin, Unit, VariantArray<Transform3D>>("set_inverse_binds")

    @JvmField
    public val getJointsName: MethodStringName0<GLTFSkin, PackedInt32Array> =
        MethodStringName0<GLTFSkin, PackedInt32Array>("get_joints")

    @JvmField
    public val setJointsName: MethodStringName1<GLTFSkin, Unit, PackedInt32Array> =
        MethodStringName1<GLTFSkin, Unit, PackedInt32Array>("set_joints")

    @JvmField
    public val getNonJointsName: MethodStringName0<GLTFSkin, PackedInt32Array> =
        MethodStringName0<GLTFSkin, PackedInt32Array>("get_non_joints")

    @JvmField
    public val setNonJointsName: MethodStringName1<GLTFSkin, Unit, PackedInt32Array> =
        MethodStringName1<GLTFSkin, Unit, PackedInt32Array>("set_non_joints")

    @JvmField
    public val getRootsName: MethodStringName0<GLTFSkin, PackedInt32Array> =
        MethodStringName0<GLTFSkin, PackedInt32Array>("get_roots")

    @JvmField
    public val setRootsName: MethodStringName1<GLTFSkin, Unit, PackedInt32Array> =
        MethodStringName1<GLTFSkin, Unit, PackedInt32Array>("set_roots")

    @JvmField
    public val getSkeletonName: MethodStringName0<GLTFSkin, Int> =
        MethodStringName0<GLTFSkin, Int>("get_skeleton")

    @JvmField
    public val setSkeletonName: MethodStringName1<GLTFSkin, Unit, Int> =
        MethodStringName1<GLTFSkin, Unit, Int>("set_skeleton")

    @JvmField
    public val getJointIToBoneIName: MethodStringName0<GLTFSkin, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFSkin, Dictionary<Any?, Any?>>("get_joint_i_to_bone_i")

    @JvmField
    public val setJointIToBoneIName: MethodStringName1<GLTFSkin, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFSkin, Unit, Dictionary<Any?, Any?>>("set_joint_i_to_bone_i")

    @JvmField
    public val getJointIToNameName: MethodStringName0<GLTFSkin, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFSkin, Dictionary<Any?, Any?>>("get_joint_i_to_name")

    @JvmField
    public val setJointIToNameName: MethodStringName1<GLTFSkin, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFSkin, Unit, Dictionary<Any?, Any?>>("set_joint_i_to_name")

    @JvmField
    public val getGodotSkinName: MethodStringName0<GLTFSkin, Skin?> =
        MethodStringName0<GLTFSkin, Skin?>("get_godot_skin")

    @JvmField
    public val setGodotSkinName: MethodStringName1<GLTFSkin, Unit, Skin?> =
        MethodStringName1<GLTFSkin, Unit, Skin?>("set_godot_skin")
  }

  public object MethodBindings {
    internal val getSkinRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_skin_root", 2455072627)

    internal val setSkinRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_skin_root", 1286410249)

    internal val getJointsOriginalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_joints_original", 969006518)

    internal val setJointsOriginalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_joints_original", 3614634198)

    internal val getInverseBindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_inverse_binds", 2915620761)

    internal val setInverseBindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_inverse_binds", 381264803)

    internal val getJointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_joints", 969006518)

    internal val setJointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_joints", 3614634198)

    internal val getNonJointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_non_joints", 969006518)

    internal val setNonJointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_non_joints", 3614634198)

    internal val getRootsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_roots", 969006518)

    internal val setRootsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_roots", 3614634198)

    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_skeleton", 2455072627)

    internal val setSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_skeleton", 1286410249)

    internal val getJointIToBoneIPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_joint_i_to_bone_i", 2382534195)

    internal val setJointIToBoneIPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_joint_i_to_bone_i", 4155329257)

    internal val getJointIToNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_joint_i_to_name", 2382534195)

    internal val setJointIToNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_joint_i_to_name", 4155329257)

    internal val getGodotSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "get_godot_skin", 1032037385)

    internal val setGodotSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkin", "set_godot_skin", 3971435618)
  }
}
