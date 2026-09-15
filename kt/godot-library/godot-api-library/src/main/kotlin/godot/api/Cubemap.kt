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
 * A cubemap is made of 6 textures organized in layers. They are typically used for faking
 * reflections in 3D rendering (see [ReflectionProbe]). It can be used to make an object look as if
 * it's reflecting its surroundings. This usually delivers much better performance than other
 * reflection methods.
 *
 * This resource is typically used as a uniform in custom shaders. Few core Godot methods make use
 * of [Cubemap] resources.
 *
 * To create such a texture file yourself, reimport your image files using the Godot Editor import
 * presets. To create a Cubemap from code, use [ImageTextureLayered.createFromImages] on an instance of
 * the Cubemap class.
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
 * **Note:** Godot doesn't support using cubemaps in a [PanoramaSkyMaterial]. To use a cubemap as a
 * skybox, convert the default [PanoramaSkyMaterial] to a [ShaderMaterial] using the **Convert to
 * ShaderMaterial** resource dropdown option, then replace its code with the following:
 *
 * [codeblock lang=text]
 *
 * shader_type sky;
 *
 * uniform samplerCube source_panorama : filter_linear, source_color, hint_default_black;
 *
 * uniform float exposure : hint_range(0, 128) = 1.0;
 *
 * void sky() {
 *
 * 	// If importing a cubemap from another engine, you may need to flip one of the `EYEDIR`
 * components below
 *
 * 	// by replacing it with `-EYEDIR`.
 *
 * 	vec3 eyedir = vec3(EYEDIR.x, EYEDIR.y, EYEDIR.z);
 *
 * 	COLOR = texture(source_panorama, eyedir).rgb * exposure;
 *
 * }
 *
 * ```
 *
 * After replacing the shader code and saving, specify the imported Cubemap resource in the Shader
 * Parameters section of the ShaderMaterial in the inspector.
 *
 * Alternatively, you can use
 * [url=https://danilw.github.io/GLSL-howto/cubemap_to_panorama_js/cubemap_to_panorama.html]this
 * tool[/url] to convert a cubemap to an equirectangular sky map and use [PanoramaSkyMaterial] as
 * usual.
 */
@GodotBaseType
public open class Cubemap : ImageTextureLayered() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(192, scriptPtr)
  }

  /**
   * Creates a placeholder version of this resource ([PlaceholderCubemap]).
   */
  public final fun createPlaceholder(): Resource? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.createPlaceholderPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Resource?)
  }

  public companion object {
    @JvmField
    public val createPlaceholderName: MethodStringName0<Cubemap, Resource?> =
        MethodStringName0<Cubemap, Resource?>("create_placeholder")
  }

  public object MethodBindings {
    internal val createPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Cubemap", "create_placeholder", 121922552)
  }
}
