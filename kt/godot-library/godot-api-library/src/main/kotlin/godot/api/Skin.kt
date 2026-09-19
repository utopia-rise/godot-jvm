// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_STRING_TRANSFORM3D
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_STRING_NAME
import godot.callPtrMethod_LONG_TRANSFORM3D
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_STRING_NAME
import godot.callPtrMethod_LONG_ret_TRANSFORM3D
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.StringName
import godot.core.Transform3D
import godot.core.asCachedStringName
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

@GodotBaseType
public open class Skin : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(679, scriptPtr)
  }

  public final fun setBindCount(bindCount: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBindCountPtr, bindCount.toLong())
  }

  public final fun getBindCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBindCountPtr).toInt()

  public final fun addBind(bone: Int, pose: Transform3D): Unit {
    TransferContext.callPtrMethod_LONG_TRANSFORM3D(ptr, objectID.id, MethodBindings.addBindPtr, bone.toLong(), pose)
  }

  public final fun addNamedBind(name: String, pose: Transform3D): Unit {
    TransferContext.callMethod_STRING_TRANSFORM3D(ptr, objectID.id, MethodBindings.addNamedBindPtr, name, pose)
  }

  public final fun setBindPose(bindIndex: Int, pose: Transform3D): Unit {
    TransferContext.callPtrMethod_LONG_TRANSFORM3D(ptr, objectID.id, MethodBindings.setBindPosePtr, bindIndex.toLong(), pose)
  }

  public final fun getBindPose(bindIndex: Int): Transform3D =
      TransferContext.callPtrMethod_LONG_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.getBindPosePtr, bindIndex.toLong())

  public final fun setBindName(bindIndex: Int, name: StringName): Unit {
    TransferContext.callPtrMethod_LONG_STRING_NAME(ptr, objectID.id, MethodBindings.setBindNamePtr, bindIndex.toLong(), name)
  }

  public final fun getBindName(bindIndex: Int): StringName =
      TransferContext.callPtrMethod_LONG_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getBindNamePtr, bindIndex.toLong())

  public final fun setBindBone(bindIndex: Int, bone: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setBindBonePtr, bindIndex.toLong(), bone.toLong())
  }

  public final fun getBindBone(bindIndex: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getBindBonePtr, bindIndex.toLong()).toInt()

  public final fun clearBinds(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearBindsPtr)
  }

  public final fun setBindName(bindIndex: Int, name: String) =
      setBindName(bindIndex, name.asCachedStringName())

  public companion object {
    @JvmField
    public val setBindCountName: MethodStringName1<Skin, Unit, Int> =
        MethodStringName1<Skin, Unit, Int>("set_bind_count")

    @JvmField
    public val getBindCountName: MethodStringName0<Skin, Int> =
        MethodStringName0<Skin, Int>("get_bind_count")

    @JvmField
    public val addBindName: MethodStringName2<Skin, Unit, Int, Transform3D> =
        MethodStringName2<Skin, Unit, Int, Transform3D>("add_bind")

    @JvmField
    public val addNamedBindName: MethodStringName2<Skin, Unit, String, Transform3D> =
        MethodStringName2<Skin, Unit, String, Transform3D>("add_named_bind")

    @JvmField
    public val setBindPoseName: MethodStringName2<Skin, Unit, Int, Transform3D> =
        MethodStringName2<Skin, Unit, Int, Transform3D>("set_bind_pose")

    @JvmField
    public val getBindPoseName: MethodStringName1<Skin, Transform3D, Int> =
        MethodStringName1<Skin, Transform3D, Int>("get_bind_pose")

    @JvmField
    public val setBindNameName: MethodStringName2<Skin, Unit, Int, StringName> =
        MethodStringName2<Skin, Unit, Int, StringName>("set_bind_name")

    @JvmField
    public val getBindNameName: MethodStringName1<Skin, StringName, Int> =
        MethodStringName1<Skin, StringName, Int>("get_bind_name")

    @JvmField
    public val setBindBoneName: MethodStringName2<Skin, Unit, Int, Int> =
        MethodStringName2<Skin, Unit, Int, Int>("set_bind_bone")

    @JvmField
    public val getBindBoneName: MethodStringName1<Skin, Int, Int> =
        MethodStringName1<Skin, Int, Int>("get_bind_bone")

    @JvmField
    public val clearBindsName: MethodStringName0<Skin, Unit> =
        MethodStringName0<Skin, Unit>("clear_binds")
  }

  public object MethodBindings {
    internal val setBindCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "set_bind_count", 1286410249)

    internal val getBindCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "get_bind_count", 3905245786)

    internal val addBindPtr: VoidPtr = TypeManager.getMethodBindPtr("Skin", "add_bind", 3616898986)

    internal val addNamedBindPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "add_named_bind", 3154712474)

    internal val setBindPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "set_bind_pose", 3616898986)

    internal val getBindPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "get_bind_pose", 1965739696)

    internal val setBindNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "set_bind_name", 3780747571)

    internal val getBindNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "get_bind_name", 659327637)

    internal val setBindBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "set_bind_bone", 3937882851)

    internal val getBindBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "get_bind_bone", 923996154)

    internal val clearBindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skin", "clear_binds", 3218959716)
  }
}
