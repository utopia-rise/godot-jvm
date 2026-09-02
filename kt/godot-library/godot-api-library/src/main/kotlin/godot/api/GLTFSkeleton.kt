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
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class GLTFSkeleton : Resource() {
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
  public final inline var roots: PackedInt32Array
    @JvmName("rootsProperty")
    get() = getRoots()
    @JvmName("rootsProperty")
    set(`value`) {
      setRoots(value)
    }

  public final inline var uniqueNames: VariantArray<String>
    @JvmName("uniqueNamesProperty")
    get() = getUniqueNames()
    @JvmName("uniqueNamesProperty")
    set(`value`) {
      setUniqueNames(value)
    }

  public final inline var godotBoneNode: Dictionary<Any?, Any?>
    @JvmName("godotBoneNodeProperty")
    get() = getGodotBoneNode()
    @JvmName("godotBoneNodeProperty")
    set(`value`) {
      setGodotBoneNode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(253, scriptPtr)
  }

  /**
   * This is a helper function for [joints] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfskeleton.joints
   * //Your changes
   * gltfskeleton.joints = myCoreType
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
   * This is a helper function for [roots] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfskeleton.roots
   * //Your changes
   * gltfskeleton.roots = myCoreType
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

  public final fun getJoints(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJointsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public final fun setJoints(joints: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to joints)
    TransferContext.callMethod(MethodBindings.setJointsPtr)
  }

  public final fun getRoots(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public final fun setRoots(roots: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to roots)
    TransferContext.callMethod(MethodBindings.setRootsPtr)
  }

  public final fun getGodotSkeleton(): Skeleton3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGodotSkeletonPtr)
    return (TransferContext.readReturnValue(OBJECT) as Skeleton3D?)
  }

  public final fun getUniqueNames(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUniqueNamesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  public final fun setUniqueNames(uniqueNames: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to uniqueNames)
    TransferContext.callMethod(MethodBindings.setUniqueNamesPtr)
  }

  /**
   * Returns a [Dictionary] that maps skeleton bone indices to the indices of glTF nodes. This
   * property is unused during import, and only set during export. In a glTF file, a bone is a node, so
   * Godot converts skeleton bones to glTF nodes.
   */
  public final fun getGodotBoneNode(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGodotBoneNodePtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Sets a [Dictionary] that maps skeleton bone indices to the indices of glTF nodes. This property
   * is unused during import, and only set during export. In a glTF file, a bone is a node, so Godot
   * converts skeleton bones to glTF nodes.
   */
  public final fun setGodotBoneNode(godotBoneNode: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to godotBoneNode)
    TransferContext.callMethod(MethodBindings.setGodotBoneNodePtr)
  }

  public final fun getBoneAttachmentCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneAttachmentCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getBoneAttachment(idx: Int): BoneAttachment3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneAttachmentPtr)
    return (TransferContext.readReturnValue(OBJECT) as BoneAttachment3D?)
  }

  public companion object {
    @JvmField
    public val getJointsName: MethodStringName0<GLTFSkeleton, PackedInt32Array> =
        MethodStringName0<GLTFSkeleton, PackedInt32Array>("get_joints")

    @JvmField
    public val setJointsName: MethodStringName1<GLTFSkeleton, Unit, PackedInt32Array> =
        MethodStringName1<GLTFSkeleton, Unit, PackedInt32Array>("set_joints")

    @JvmField
    public val getRootsName: MethodStringName0<GLTFSkeleton, PackedInt32Array> =
        MethodStringName0<GLTFSkeleton, PackedInt32Array>("get_roots")

    @JvmField
    public val setRootsName: MethodStringName1<GLTFSkeleton, Unit, PackedInt32Array> =
        MethodStringName1<GLTFSkeleton, Unit, PackedInt32Array>("set_roots")

    @JvmField
    public val getGodotSkeletonName: MethodStringName0<GLTFSkeleton, Skeleton3D?> =
        MethodStringName0<GLTFSkeleton, Skeleton3D?>("get_godot_skeleton")

    @JvmField
    public val getUniqueNamesName: MethodStringName0<GLTFSkeleton, VariantArray<String>> =
        MethodStringName0<GLTFSkeleton, VariantArray<String>>("get_unique_names")

    @JvmField
    public val setUniqueNamesName: MethodStringName1<GLTFSkeleton, Unit, VariantArray<String>> =
        MethodStringName1<GLTFSkeleton, Unit, VariantArray<String>>("set_unique_names")

    @JvmField
    public val getGodotBoneNodeName: MethodStringName0<GLTFSkeleton, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFSkeleton, Dictionary<Any?, Any?>>("get_godot_bone_node")

    @JvmField
    public val setGodotBoneNodeName: MethodStringName1<GLTFSkeleton, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFSkeleton, Unit, Dictionary<Any?, Any?>>("set_godot_bone_node")

    @JvmField
    public val getBoneAttachmentCountName: MethodStringName0<GLTFSkeleton, Int> =
        MethodStringName0<GLTFSkeleton, Int>("get_bone_attachment_count")

    @JvmField
    public val getBoneAttachmentName: MethodStringName1<GLTFSkeleton, BoneAttachment3D?, Int> =
        MethodStringName1<GLTFSkeleton, BoneAttachment3D?, Int>("get_bone_attachment")
  }

  public object MethodBindings {
    internal val getJointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_joints", 969006518)

    internal val setJointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "set_joints", 3614634198)

    internal val getRootsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_roots", 969006518)

    internal val setRootsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "set_roots", 3614634198)

    internal val getGodotSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_godot_skeleton", 1814733083)

    internal val getUniqueNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_unique_names", 2915620761)

    internal val setUniqueNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "set_unique_names", 381264803)

    internal val getGodotBoneNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_godot_bone_node", 2382534195)

    internal val setGodotBoneNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "set_godot_bone_node", 4155329257)

    internal val getBoneAttachmentCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_bone_attachment_count", 2455072627)

    internal val getBoneAttachmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFSkeleton", "get_bone_attachment", 945440495)
  }
}
