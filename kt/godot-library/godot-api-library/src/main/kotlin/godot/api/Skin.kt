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
import godot.core.MethodStringName2
import godot.core.StringName
import godot.core.Transform3D
import godot.core.asCachedStringName
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING_NAME
import godot.readReturnValue_TRANSFORM3D
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_STRING_NAME
import godot.writeMethodArguments_LONG_TRANSFORM3D
import godot.writeMethodArguments_STRING_TRANSFORM3D
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
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bindCount.toLong())
    TransferContext.callMethod(MethodBindings.setBindCountPtr)
  }

  public final fun getBindCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun addBind(bone: Int, pose: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, bone.toLong(), pose)
    TransferContext.callMethod(MethodBindings.addBindPtr)
  }

  public final fun addNamedBind(name: String, pose: Transform3D): Unit {
    TransferContext.writeMethodArguments_STRING_TRANSFORM3D(ptr, objectID.id, name, pose)
    TransferContext.callMethod(MethodBindings.addNamedBindPtr)
  }

  public final fun setBindPose(bindIndex: Int, pose: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, bindIndex.toLong(), pose)
    TransferContext.callMethod(MethodBindings.setBindPosePtr)
  }

  public final fun getBindPose(bindIndex: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bindIndex.toLong())
    TransferContext.callMethod(MethodBindings.getBindPosePtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  public final fun setBindName(bindIndex: Int, name: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, bindIndex.toLong(), name)
    TransferContext.callMethod(MethodBindings.setBindNamePtr)
  }

  public final fun getBindName(bindIndex: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bindIndex.toLong())
    TransferContext.callMethod(MethodBindings.getBindNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setBindBone(bindIndex: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, bindIndex.toLong(), bone.toLong())
    TransferContext.callMethod(MethodBindings.setBindBonePtr)
  }

  public final fun getBindBone(bindIndex: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bindIndex.toLong())
    TransferContext.callMethod(MethodBindings.getBindBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun clearBinds(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearBindsPtr)
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
