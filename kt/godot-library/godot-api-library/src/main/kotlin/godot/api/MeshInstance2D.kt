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
 * Node used for displaying a [Mesh] in 2D. This can be faster to render compared to displaying a
 * [Sprite2D] node with large transparent areas, especially if the node takes up a lot of space on
 * screen at high viewport resolutions. This is because using a mesh designed to fit the sprite's
 * opaque areas will reduce GPU fill rate utilization (at the cost of increased vertex processing
 * utilization).
 *
 * When a [Mesh] has to be instantiated more than thousands of times close to each other, consider
 * using a [MultiMesh] in a [MultiMeshInstance2D] instead.
 *
 * A [MeshInstance2D] can be created from an existing [Sprite2D] via a tool in the editor toolbar.
 * Select the [Sprite2D] node, then choose **Sprite2D > Convert to MeshInstance2D** at the top of the
 * 2D editor viewport.
 */
@GodotBaseType
public open class MeshInstance2D : Node2D() {
  /**
   * Emitted when the [texture] is changed.
   */
  public val textureChanged: Signal0 by Signal0

  /**
   * The [Mesh] that will be drawn by the [MeshInstance2D].
   */
  public final inline var mesh: Mesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
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
    createNativeObject(376, scriptPtr)
  }

  public final fun setMesh(mesh: Mesh?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setMeshPtr, mesh)
  }

  public final fun getMesh(): Mesh? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getMeshPtr) as Mesh?)

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setTexturePtr, texture)
  }

  public final fun getTexture(): Texture2D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getTexturePtr) as Texture2D?)

  public companion object {
    @JvmField
    public val setMeshName: MethodStringName1<MeshInstance2D, Unit, Mesh?> =
        MethodStringName1<MeshInstance2D, Unit, Mesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<MeshInstance2D, Mesh?> =
        MethodStringName0<MeshInstance2D, Mesh?>("get_mesh")

    @JvmField
    public val setTextureName: MethodStringName1<MeshInstance2D, Unit, Texture2D?> =
        MethodStringName1<MeshInstance2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<MeshInstance2D, Texture2D?> =
        MethodStringName0<MeshInstance2D, Texture2D?>("get_texture")
  }

  public object MethodBindings {
    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance2D", "set_mesh", 194775623)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance2D", "get_mesh", 1808005922)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance2D", "get_texture", 3635182373)
  }
}
