// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [MultiMeshInstance2D] is a specialized node to instance a [MultiMesh] resource in 2D. This can be
 * faster to render compared to displaying many [Sprite2D] nodes with large transparent areas,
 * especially if the nodes take up a lot of space on screen at high viewport resolutions. This is
 * because using a mesh designed to fit the sprites' opaque areas will reduce GPU fill rate utilization
 * (at the cost of increased vertex processing utilization).
 *
 * Usage is the same as [MultiMeshInstance3D].
 */
@GodotBaseType
public open class MultiMeshInstance2D : Node2D() {
  /**
   * Emitted when the [texture] is changed.
   */
  public val textureChanged: Signal0 by Signal0

  /**
   * The [MultiMesh] that will be drawn by the [MultiMeshInstance2D].
   */
  public final inline var multimesh: MultiMesh?
    @JvmName("multimeshProperty")
    get() = getMultimesh()
    @JvmName("multimeshProperty")
    set(`value`) {
      setMultimesh(value)
    }

  /**
   * The [Texture2D] that will be used if using the default [CanvasItemMaterial]. Can be accessed as
   * `TEXTURE` in CanvasItem shader.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(387, scriptPtr)
  }

  public final fun setMultimesh(multimesh: MultiMesh?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setMultimeshPtr, multimesh)
  }

  public final fun getMultimesh(): MultiMesh? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getMultimeshPtr) as MultiMesh?)

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setTexturePtr, texture)
  }

  public final fun getTexture(): Texture2D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getTexturePtr) as Texture2D?)

  public companion object {
    @JvmField
    public val setMultimeshName: MethodStringName1<MultiMeshInstance2D, Unit, MultiMesh?> =
        MethodStringName1<MultiMeshInstance2D, Unit, MultiMesh?>("set_multimesh")

    @JvmField
    public val getMultimeshName: MethodStringName0<MultiMeshInstance2D, MultiMesh?> =
        MethodStringName0<MultiMeshInstance2D, MultiMesh?>("get_multimesh")

    @JvmField
    public val setTextureName: MethodStringName1<MultiMeshInstance2D, Unit, Texture2D?> =
        MethodStringName1<MultiMeshInstance2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<MultiMeshInstance2D, Texture2D?> =
        MethodStringName0<MultiMeshInstance2D, Texture2D?>("get_texture")
  }

  public object MethodBindings {
    internal val setMultimeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiMeshInstance2D", "set_multimesh", 2246127404)

    internal val getMultimeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiMeshInstance2D", "get_multimesh", 1385450523)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiMeshInstance2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiMeshInstance2D", "get_texture", 3635182373)
  }
}
