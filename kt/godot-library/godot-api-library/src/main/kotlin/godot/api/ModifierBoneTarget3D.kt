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
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node selects a bone in a [Skeleton3D] and attaches to it. This means that the
 * [ModifierBoneTarget3D] node will dynamically copy the 3D transform of the selected bone.
 *
 * The functionality is similar to [BoneAttachment3D], but this node adopts the [SkeletonModifier3D]
 * cycle and is intended to be used as another [SkeletonModifier3D]'s target.
 */
@GodotBaseType
public open class ModifierBoneTarget3D : SkeletonModifier3D() {
  /**
   * The name of the attached bone.
   */
  public final inline var boneName: String
    @JvmName("boneNameProperty")
    get() = getBoneName()
    @JvmName("boneNameProperty")
    set(`value`) {
      setBoneName(value)
    }

  /**
   * The index of the attached bone.
   */
  public final inline var bone: Int
    @JvmName("boneProperty")
    get() = getBone()
    @JvmName("boneProperty")
    set(`value`) {
      setBone(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(384, scriptPtr)
  }

  public final fun setBoneName(boneName: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, boneName)
    TransferContext.callMethod(MethodBindings.setBoneNamePtr)
  }

  public final fun getBoneName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setBone(bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bone.toLong())
    TransferContext.callMethod(MethodBindings.setBonePtr)
  }

  public final fun getBone(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setBoneNameName: MethodStringName1<ModifierBoneTarget3D, Unit, String> =
        MethodStringName1<ModifierBoneTarget3D, Unit, String>("set_bone_name")

    @JvmField
    public val getBoneNameName: MethodStringName0<ModifierBoneTarget3D, String> =
        MethodStringName0<ModifierBoneTarget3D, String>("get_bone_name")

    @JvmField
    public val setBoneName: MethodStringName1<ModifierBoneTarget3D, Unit, Int> =
        MethodStringName1<ModifierBoneTarget3D, Unit, Int>("set_bone")

    @JvmField
    public val getBoneName: MethodStringName0<ModifierBoneTarget3D, Int> =
        MethodStringName0<ModifierBoneTarget3D, Int>("get_bone")
  }

  public object MethodBindings {
    internal val setBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ModifierBoneTarget3D", "set_bone_name", 83702148)

    internal val getBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ModifierBoneTarget3D", "get_bone_name", 201670096)

    internal val setBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ModifierBoneTarget3D", "set_bone", 1286410249)

    internal val getBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ModifierBoneTarget3D", "get_bone", 3905245786)
  }
}
