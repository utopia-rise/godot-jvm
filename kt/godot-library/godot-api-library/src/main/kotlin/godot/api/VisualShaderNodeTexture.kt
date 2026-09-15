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
 * Performs a lookup operation on the provided texture, with support for multiple texture sources to
 * choose from.
 */
@GodotBaseType
public open class VisualShaderNodeTexture : VisualShaderNode() {
  /**
   * Determines the source for the lookup.
   */
  public final inline var source: Source
    @JvmName("sourceProperty")
    get() = getSource()
    @JvmName("sourceProperty")
    set(`value`) {
      setSource(value)
    }

  /**
   * The source texture, if needed for the selected [source].
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * Specifies the type of the texture if [source] is set to [SOURCE_TEXTURE].
   */
  public final inline var textureType: TextureType
    @JvmName("textureTypeProperty")
    get() = getTextureType()
    @JvmName("textureTypeProperty")
    set(`value`) {
      setTextureType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(875, scriptPtr)
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

  public final fun setTexture(`value`: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
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
     * Use the texture given as an argument for this function.
     */
    TEXTURE(0),
    /**
     * Use the current viewport's texture as the source.
     */
    SCREEN(1),
    /**
     * Use the texture from this shader's texture built-in (e.g. a texture of a [Sprite2D]).
     */
    SOURCE_2D_TEXTURE(2),
    /**
     * Use the texture from this shader's normal map built-in.
     */
    SOURCE_2D_NORMAL(3),
    /**
     * Use the depth texture captured during the depth prepass. Only available when the depth
     * prepass is used (i.e. in spatial shaders and in the forward_plus or gl_compatibility renderers).
     */
    DEPTH(4),
    /**
     * Use the texture provided in the input port for this function.
     */
    PORT(5),
    /**
     * Use the normal buffer captured during the depth prepass. Only available when the
     * normal-roughness buffer is available (i.e. in spatial shaders and in the forward_plus renderer).
     */
    SOURCE_3D_NORMAL(6),
    /**
     * Use the roughness buffer captured during the depth prepass. Only available when the
     * normal-roughness buffer is available (i.e. in spatial shaders and in the forward_plus renderer).
     */
    ROUGHNESS(7),
    /**
     * Represents the size of the [Source] enum.
     */
    MAX(8),
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
    public val setSourceName: MethodStringName1<VisualShaderNodeTexture, Unit, Source> =
        MethodStringName1<VisualShaderNodeTexture, Unit, Source>("set_source")

    @JvmField
    public val getSourceName: MethodStringName0<VisualShaderNodeTexture, Source> =
        MethodStringName0<VisualShaderNodeTexture, Source>("get_source")

    @JvmField
    public val setTextureName: MethodStringName1<VisualShaderNodeTexture, Unit, Texture2D?> =
        MethodStringName1<VisualShaderNodeTexture, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<VisualShaderNodeTexture, Texture2D?> =
        MethodStringName0<VisualShaderNodeTexture, Texture2D?>("get_texture")

    @JvmField
    public val setTextureTypeName: MethodStringName1<VisualShaderNodeTexture, Unit, TextureType> =
        MethodStringName1<VisualShaderNodeTexture, Unit, TextureType>("set_texture_type")

    @JvmField
    public val getTextureTypeName: MethodStringName0<VisualShaderNodeTexture, TextureType> =
        MethodStringName0<VisualShaderNodeTexture, TextureType>("get_texture_type")
  }

  public object MethodBindings {
    internal val setSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture", "set_source", 905262939)

    internal val getSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture", "get_source", 2896297444)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture", "get_texture", 3635182373)

    internal val setTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture", "set_texture_type", 986314081)

    internal val getTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture", "get_texture_type", 3290430153)
  }
}
