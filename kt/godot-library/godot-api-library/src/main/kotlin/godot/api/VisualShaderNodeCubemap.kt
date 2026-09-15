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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to `texture(cubemap, vec3)` in the shader language. Returns a color vector and alpha
 * channel as scalar.
 */
@GodotBaseType
public open class VisualShaderNodeCubemap : VisualShaderNode() {
  /**
   * Defines which source should be used for the sampling.
   */
  public final inline var source: Source
    @JvmName("sourceProperty")
    get() = getSource()
    @JvmName("sourceProperty")
    set(`value`) {
      setSource(value)
    }

  /**
   * The [Cubemap] texture to sample when using [SOURCE_TEXTURE] as [source].
   */
  public final inline var cubeMap: TextureLayered?
    @JvmName("cubeMapProperty")
    get() = getCubeMap()
    @JvmName("cubeMapProperty")
    set(`value`) {
      setCubeMap(value)
    }

  /**
   * Defines the type of data provided by the source texture.
   */
  public final inline var textureType: TextureType
    @JvmName("textureTypeProperty")
    get() = getTextureType()
    @JvmName("textureTypeProperty")
    set(`value`) {
      setTextureType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(817, scriptPtr)
  }

  public final fun setSource(`value`: Source): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, value.value)
    TransferContext.callMethod(MethodBindings.setSourcePtr)
  }

  public final fun getSource(): Source {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSourcePtr)
    return Source.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setCubeMap(`value`: TextureLayered?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.setCubeMapPtr)
  }

  public final fun getCubeMap(): TextureLayered? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCubeMapPtr)
    return (TransferContext.readReturnValue_OBJECT() as TextureLayered?)
  }

  public final fun setTextureType(`value`: TextureType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, value.value)
    TransferContext.callMethod(MethodBindings.setTextureTypePtr)
  }

  public final fun getTextureType(): TextureType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureTypePtr)
    return TextureType.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Source(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the [Cubemap] set via [cubeMap]. If this is set to [source], the `samplerCube` port is
     * ignored.
     */
    TEXTURE(0),
    /**
     * Use the [Cubemap] sampler reference passed via the `samplerCube` port. If this is set to
     * [source], the [cubeMap] texture is ignored.
     */
    PORT(1),
    /**
     * Represents the size of the [Source] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): Source = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No hints are added to the uniform declaration.
     */
    TYPE_DATA(0),
    /**
     * Adds `source_color` as hint to the uniform declaration for proper conversion from nonlinear
     * sRGB encoding to linear encoding.
     */
    TYPE_COLOR(1),
    /**
     * Adds `hint_normal` as hint to the uniform declaration, which internally converts the texture
     * for proper usage as normal map.
     */
    TYPE_NORMAL_MAP(2),
    /**
     * Represents the size of the [TextureType] enum.
     */
    TYPE_MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): TextureType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSourceName: MethodStringName1<VisualShaderNodeCubemap, Unit, Source> =
        MethodStringName1<VisualShaderNodeCubemap, Unit, Source>("set_source")

    @JvmField
    public val getSourceName: MethodStringName0<VisualShaderNodeCubemap, Source> =
        MethodStringName0<VisualShaderNodeCubemap, Source>("get_source")

    @JvmField
    public val setCubeMapName: MethodStringName1<VisualShaderNodeCubemap, Unit, TextureLayered?> =
        MethodStringName1<VisualShaderNodeCubemap, Unit, TextureLayered?>("set_cube_map")

    @JvmField
    public val getCubeMapName: MethodStringName0<VisualShaderNodeCubemap, TextureLayered?> =
        MethodStringName0<VisualShaderNodeCubemap, TextureLayered?>("get_cube_map")

    @JvmField
    public val setTextureTypeName: MethodStringName1<VisualShaderNodeCubemap, Unit, TextureType> =
        MethodStringName1<VisualShaderNodeCubemap, Unit, TextureType>("set_texture_type")

    @JvmField
    public val getTextureTypeName: MethodStringName0<VisualShaderNodeCubemap, TextureType> =
        MethodStringName0<VisualShaderNodeCubemap, TextureType>("get_texture_type")
  }

  public object MethodBindings {
    internal val setSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCubemap", "set_source", 1625400621)

    internal val getSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCubemap", "get_source", 2222048781)

    internal val setCubeMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCubemap", "set_cube_map", 1278366092)

    internal val getCubeMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCubemap", "get_cube_map", 3984243839)

    internal val setTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCubemap", "set_texture_type", 1899718876)

    internal val getTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCubemap", "get_texture_type", 3356498888)
  }
}
