// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL_ret_ARRAY
import godot.callPtrMethod_STRING_NAME_LONG_ret_OBJECT_REF
import godot.callPtrMethod_STRING_NAME_OBJECT_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A custom shader program implemented in the Godot shading language, saved with the `.gdshader`
 * extension.
 *
 * This class is used by a [ShaderMaterial] and allows you to write your own custom behavior for
 * rendering visual items or updating particle information. For a detailed explanation and usage,
 * please see the tutorials linked below.
 */
@GodotBaseType
public open class Shader : Resource() {
  /**
   * Returns the shader's code as the user has written it, not the full generated code used
   * internally.
   */
  public final inline var code: String
    @JvmName("codeProperty")
    get() = getCode()
    @JvmName("codeProperty")
    set(`value`) {
      setCode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(654, scriptPtr)
  }

  /**
   * Returns the shader mode for the shader.
   */
  public final fun getMode(): Mode =
      Mode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getModePtr))

  public final fun setCode(code: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setCodePtr, code)
  }

  public final fun getCode(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getCodePtr)

  /**
   * Sets the default texture to be used with a texture uniform. The default is used if a texture is
   * not set in the [ShaderMaterial].
   *
   * **Note:** [name] must match the name of the uniform in the code exactly.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  public final fun setDefaultTextureParameter(
    name: StringName,
    texture: Texture?,
    index: Int = 0,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_OBJECT_LONG(ptr, objectID.id, MethodBindings.setDefaultTextureParameterPtr, name, texture, index.toLong())
  }

  /**
   * Returns the texture that is set as default for the specified parameter.
   *
   * **Note:** [name] must match the name of the uniform in the code exactly.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  public final fun getDefaultTextureParameter(name: StringName, index: Int = 0): Texture? =
      (TransferContext.callPtrMethod_STRING_NAME_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getDefaultTextureParameterPtr, name, index.toLong()) as Texture?)

  /**
   * Returns the list of shader uniforms that can be assigned to a [ShaderMaterial], for use with
   * [ShaderMaterial.setShaderParameter] and [ShaderMaterial.getShaderParameter]. The parameters
   * returned are contained in dictionaries in a similar format to the ones returned by
   * [Object.getPropertyList].
   *
   * If argument [getGroups] is `true`, parameter grouping hints are also included in the list.
   */
  @JvmOverloads
  public final fun getShaderUniformList(getGroups: Boolean = false): VariantArray<Any?> =
      (TransferContext.callPtrMethod_BOOL_ret_ARRAY(ptr, objectID.id, MethodBindings.getShaderUniformListPtr, getGroups) as VariantArray<Any?>)

  /**
   * Only available when running in the editor. Opens a popup that visualizes the generated shader
   * code, including all variants and internal shader code. See also
   * [Material.inspectNativeShaderCode].
   */
  public final fun inspectNativeShaderCode(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.inspectNativeShaderCodePtr)
  }

  /**
   * Sets the default texture to be used with a texture uniform. The default is used if a texture is
   * not set in the [ShaderMaterial].
   *
   * **Note:** [name] must match the name of the uniform in the code exactly.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  public final fun setDefaultTextureParameter(
    name: String,
    texture: Texture?,
    index: Int = 0,
  ) = setDefaultTextureParameter(name.asCachedStringName(), texture, index)

  /**
   * Returns the texture that is set as default for the specified parameter.
   *
   * **Note:** [name] must match the name of the uniform in the code exactly.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  public final fun getDefaultTextureParameter(name: String, index: Int = 0): Texture? =
      getDefaultTextureParameter(name.asCachedStringName(), index)

  public enum class Mode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Mode used to draw all 3D objects.
     */
    SPATIAL(0),
    /**
     * Mode used to draw all 2D objects.
     */
    CANVAS_ITEM(1),
    /**
     * Mode used to calculate particle information on a per-particle basis. Not used for drawing.
     */
    PARTICLES(2),
    /**
     * Mode used for drawing skies. Only works with shaders attached to [Sky] objects.
     */
    SKY(3),
    /**
     * Mode used for setting the color and density of volumetric fog effect.
     */
    FOG(4),
    /**
     * Mode used for drawing to DrawableTexture resources via blit calls.
     */
    TEXTURE_BLIT(5),
    ;

    public companion object {
      public fun from(`value`: Long): Mode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getModeName: MethodStringName0<Shader, Mode> =
        MethodStringName0<Shader, Mode>("get_mode")

    @JvmField
    public val setCodeName: MethodStringName1<Shader, Unit, String> =
        MethodStringName1<Shader, Unit, String>("set_code")

    @JvmField
    public val getCodeName: MethodStringName0<Shader, String> =
        MethodStringName0<Shader, String>("get_code")

    @JvmField
    public val setDefaultTextureParameterName:
        MethodStringName3<Shader, Unit, StringName, Texture?, Int> =
        MethodStringName3<Shader, Unit, StringName, Texture?, Int>("set_default_texture_parameter")

    @JvmField
    public val getDefaultTextureParameterName: MethodStringName2<Shader, Texture?, StringName, Int>
        = MethodStringName2<Shader, Texture?, StringName, Int>("get_default_texture_parameter")

    @JvmField
    public val getShaderUniformListName: MethodStringName1<Shader, VariantArray<Any?>, Boolean> =
        MethodStringName1<Shader, VariantArray<Any?>, Boolean>("get_shader_uniform_list")

    @JvmField
    public val inspectNativeShaderCodeName: MethodStringName0<Shader, Unit> =
        MethodStringName0<Shader, Unit>("inspect_native_shader_code")
  }

  public object MethodBindings {
    internal val getModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shader", "get_mode", 3392948163)

    internal val setCodePtr: VoidPtr = TypeManager.getMethodBindPtr("Shader", "set_code", 83702148)

    internal val getCodePtr: VoidPtr = TypeManager.getMethodBindPtr("Shader", "get_code", 201670096)

    internal val setDefaultTextureParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shader", "set_default_texture_parameter", 3850209648)

    internal val getDefaultTextureParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shader", "get_default_texture_parameter", 4213877425)

    internal val getShaderUniformListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shader", "get_shader_uniform_list", 1230511656)

    internal val inspectNativeShaderCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shader", "inspect_native_shader_code", 3218959716)
  }
}
