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
import godot.core.RID
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * An internal object containing a mapping from a [Skin] used within the context of a particular
 * [MeshInstance3D] to refer to the skeleton's [RID] in the RenderingServer.
 *
 * See also [MeshInstance3D.getSkinReference] and [RenderingServer.instanceAttachSkeleton].
 *
 * Note that despite the similar naming, the skeleton RID used in the [RenderingServer] does not
 * have a direct one-to-one correspondence to a [Skeleton3D] node.
 *
 * In particular, a [Skeleton3D] node with no [MeshInstance3D] children may be unknown to the
 * [RenderingServer].
 *
 * On the other hand, a [Skeleton3D] with multiple [MeshInstance3D] nodes which each have different
 * [MeshInstance3D.skin] objects may have multiple SkinReference instances (and hence, multiple
 * skeleton [RID]s).
 */
@GodotBaseType
public open class SkinReference internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(680, scriptPtr)
  }

  /**
   * Returns the [RID] owned by this SkinReference, as returned by [RenderingServer.skeletonCreate].
   */
  public final fun getSkeleton(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the [Skin] connected to this SkinReference. In the case of [MeshInstance3D] with no
   * [MeshInstance3D.skin] assigned, this will reference an internal default [Skin] owned by that
   * [MeshInstance3D].
   *
   * Note that a single [Skin] may have more than one [SkinReference] in the case that it is shared
   * by meshes across multiple [Skeleton3D] nodes.
   */
  public final fun getSkin(): Skin? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinPtr)
    return (TransferContext.readReturnValue_OBJECT() as Skin?)
  }

  public companion object {
    @JvmField
    public val getSkeletonName: MethodStringName0<SkinReference, RID> =
        MethodStringName0<SkinReference, RID>("get_skeleton")

    @JvmField
    public val getSkinName: MethodStringName0<SkinReference, Skin?> =
        MethodStringName0<SkinReference, Skin?>("get_skin")
  }

  public object MethodBindings {
    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkinReference", "get_skeleton", 2944877500)

    internal val getSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkinReference", "get_skin", 2074563878)
  }
}
