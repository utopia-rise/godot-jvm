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
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * A Texture2DArray is different from a Texture3D: The Texture2DArray does not support trilinear
 * interpolation between the [Image]s, i.e. no blending. See also [Cubemap] and [CubemapArray], which
 * are texture arrays with specialized cubemap functions.
 *
 * A Texture2DArray is also different from an [AtlasTexture]: In a Texture2DArray, all images are
 * treated separately. In an atlas, the regions (i.e. the single images) can be of different sizes.
 * Furthermore, you usually need to add a padding around the regions, to prevent accidental UV mapping
 * to more than one region. The same goes for mipmapping: Mipmap chains are handled separately for each
 * layer. In an atlas, the slicing has to be done manually in the fragment shader.
 *
 * To create such a texture file yourself, reimport your image files using the Godot Editor import
 * presets. To create a Texture2DArray from code, use [ImageTextureLayered.createFromImages] on an
 * instance of the Texture2DArray class.
 */
@GodotBaseType
public open class Texture2DArray : ImageTextureLayered() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(741, scriptPtr)
  }

  /**
   * Creates a placeholder version of this resource ([PlaceholderTexture2DArray]).
   */
  public final fun createPlaceholder(): Resource? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.createPlaceholderPtr) as Resource?)

  public companion object {
    @JvmField
    public val createPlaceholderName: MethodStringName0<Texture2DArray, Resource?> =
        MethodStringName0<Texture2DArray, Resource?>("create_placeholder")
  }

  public object MethodBindings {
    internal val createPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2DArray", "create_placeholder", 121922552)
  }
}
