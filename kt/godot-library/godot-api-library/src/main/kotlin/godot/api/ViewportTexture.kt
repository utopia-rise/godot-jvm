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
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments0
import godot.writeMethodArguments_NODE_PATH
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A [ViewportTexture] provides the content of a [Viewport] as a dynamic [Texture2D]. This can be
 * used to combine the rendering of [Control], [Node2D] and [Node3D] nodes. For example, you can use
 * this texture to display a 3D scene inside a [TextureRect], or a 2D overlay in a [Sprite3D].
 *
 * To get a [ViewportTexture] in code, use the [Viewport.getTexture] method on the target viewport.
 *
 * **Note:** A [ViewportTexture] is always local to its scene (see [Resource.resourceLocalToScene]).
 * If the scene root is not ready, it may return incorrect data (see [signal Node.ready]).
 *
 * **Note:** Instantiating scenes containing a high-resolution [ViewportTexture] may cause
 * noticeable stutter.
 *
 * **Note:** When using a [Viewport] with [Viewport.useHdr2d] set to `true`, the returned texture
 * will be an HDR image that uses linear encoding. This may look darker than normal when displayed
 * directly on screen. To convert to nonlinear sRGB encoding, you can do the following:
 *
 * ```
 * img.convert(Image.FORMAT_RGBA8)
 * img.linear_to_srgb()
 * ```
 *
 * **Note:** Some nodes such as [Decal], [Light3D], and [PointLight2D] do not support using
 * [ViewportTexture] directly. To use texture data from a [ViewportTexture] in these nodes, you need to
 * create an [ImageTexture] by calling [Texture2D.getImage] on the [ViewportTexture] and passing the
 * result to [ImageTexture.createFromImage]. This conversion is a slow operation, so it should not be
 * performed every frame.
 */
@GodotBaseType
public open class ViewportTexture : Texture2D() {
  /**
   * The path to the [Viewport] node to display. This is relative to the local scene root (see
   * [Resource.getLocalScene]), **not** to the nodes that use this texture.
   *
   * **Note:** In the editor, this path is automatically updated when the target viewport or one of
   * its ancestors is renamed or moved. At runtime, this path may not automatically update if the scene
   * root cannot be found.
   */
  public final inline var viewportPath: NodePath
    @JvmName("viewportPathProperty")
    get() = getViewportPathInScene()
    @JvmName("viewportPathProperty")
    set(`value`) {
      setViewportPathInScene(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(797, scriptPtr)
  }

  public final fun setViewportPathInScene(path: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.setViewportPathInScenePtr)
  }

  public final fun getViewportPathInScene(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewportPathInScenePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("ViewportTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("ViewportTexture::_getHeight can't be called from the JVM.")
  }

  public final fun setViewportPathInScene(path: String) =
      setViewportPathInScene(path.asCachedNodePath())

  public companion object {
    @JvmField
    public val setViewportPathInSceneName: MethodStringName1<ViewportTexture, Unit, NodePath> =
        MethodStringName1<ViewportTexture, Unit, NodePath>("set_viewport_path_in_scene")

    @JvmField
    public val getViewportPathInSceneName: MethodStringName0<ViewportTexture, NodePath> =
        MethodStringName0<ViewportTexture, NodePath>("get_viewport_path_in_scene")
  }

  public object MethodBindings {
    internal val setViewportPathInScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ViewportTexture", "set_viewport_path_in_scene", 1348162250)

    internal val getViewportPathInScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ViewportTexture", "get_viewport_path_in_scene", 4075236667)
  }
}
