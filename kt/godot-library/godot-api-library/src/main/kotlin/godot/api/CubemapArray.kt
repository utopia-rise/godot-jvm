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
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [CubemapArray]s are made of an array of [Cubemap]s. Like [Cubemap]s, they are made of multiple
 * textures, the amount of which must be divisible by 6 (one for each face of the cube).
 *
 * The primary benefit of [CubemapArray]s is that they can be accessed in shader code using a single
 * texture reference. In other words, you can pass multiple [Cubemap]s into a shader using a single
 * [CubemapArray]. [Cubemap]s are allocated in adjacent cache regions on the GPU, which makes
 * [CubemapArray]s the most efficient way to store multiple [Cubemap]s.
 *
 * Godot uses [CubemapArray]s internally for many effects, including the [Sky] if you set
 * [ProjectSettings.rendering/reflections/skyReflections/textureArrayReflections] to `true`.
 *
 * To create such a texture file yourself, reimport your image files using the Godot Editor import
 * presets. To create a CubemapArray from code, use [ImageTextureLayered.createFromImages] on an
 * instance of the CubemapArray class.
 *
 * The expected image order is X+, X-, Y+, Y-, Z+, Z- (in Godot's coordinate system, so Y+ is "up"
 * and Z- is "forward"). You can use one of the following templates as a base:
 *
 * -
 * [url=https://raw.githubusercontent.com/godotengine/godot-docs/master/tutorials/assets_pipeline/img/cubemap_template_2x3.webp]2×3
 * cubemap template (default layout option)[/url]
 *
 * -
 * [url=https://raw.githubusercontent.com/godotengine/godot-docs/master/tutorials/assets_pipeline/img/cubemap_template_3x2.webp]3×2
 * cubemap template[/url]
 *
 * -
 * [url=https://raw.githubusercontent.com/godotengine/godot-docs/master/tutorials/assets_pipeline/img/cubemap_template_1x6.webp]1×6
 * cubemap template[/url]
 *
 * -
 * [url=https://raw.githubusercontent.com/godotengine/godot-docs/master/tutorials/assets_pipeline/img/cubemap_template_6x1.webp]6×1
 * cubemap template[/url]
 *
 * Multiple layers are stacked on top of each other when using the default vertical import option
 * (with the first layer at the top). Alternatively, you can choose a horizontal layout in the import
 * options (with the first layer at the left).
 *
 * **Note:** [CubemapArray] is not supported in the Compatibility renderer due to graphics API
 * limitations.
 */
@GodotBaseType
public open class CubemapArray : ImageTextureLayered() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(193, scriptPtr)
  }

  /**
   * Creates a placeholder version of this resource ([PlaceholderCubemapArray]).
   */
  public final fun createPlaceholder(): Resource? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.createPlaceholderPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Resource?)
  }

  public companion object {
    @JvmField
    public val createPlaceholderName: MethodStringName0<CubemapArray, Resource?> =
        MethodStringName0<CubemapArray, Resource?>("create_placeholder")
  }

  public object MethodBindings {
    internal val createPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CubemapArray", "create_placeholder", 121922552)
  }
}
