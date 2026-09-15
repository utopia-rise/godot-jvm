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
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Performs a lookup operation on the texture provided as a uniform for the shader.
 */
@GodotBaseType
public open class VisualShaderNodeTextureParameter internal constructor() :
    VisualShaderNodeParameter() {
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

  /**
   * Sets the default color if no texture is assigned to the uniform.
   */
  public final inline var colorDefault: ColorDefault
    @JvmName("colorDefaultProperty")
    get() = getColorDefault()
    @JvmName("colorDefaultProperty")
    set(`value`) {
      setColorDefault(value)
    }

  /**
   * Sets the texture filtering mode.
   */
  public final inline var textureFilter: TextureFilter
    @JvmName("textureFilterProperty")
    get() = getTextureFilter()
    @JvmName("textureFilterProperty")
    set(`value`) {
      setTextureFilter(value)
    }

  /**
   * Sets the texture repeating mode.
   */
  public final inline var textureRepeat: TextureRepeat
    @JvmName("textureRepeatProperty")
    get() = getTextureRepeat()
    @JvmName("textureRepeatProperty")
    set(`value`) {
      setTextureRepeat(value)
    }

  /**
   * Sets the texture source mode. Used for reading from the screen, depth, or normal_roughness
   * texture.
   */
  public final inline var textureSource: TextureSource
    @JvmName("textureSourceProperty")
    get() = getTextureSource()
    @JvmName("textureSourceProperty")
    set(`value`) {
      setTextureSource(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(881, scriptPtr)
  }

  public final fun setTextureType(type: TextureType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, type.value)
    TransferContext.callMethod(MethodBindings.setTextureTypePtr)
  }

  public final fun getTextureType(): TextureType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureTypePtr)
    return TextureType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setColorDefault(color: ColorDefault): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, color.value)
    TransferContext.callMethod(MethodBindings.setColorDefaultPtr)
  }

  public final fun getColorDefault(): ColorDefault {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorDefaultPtr)
    return ColorDefault.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTextureFilter(filter: TextureFilter): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, filter.value)
    TransferContext.callMethod(MethodBindings.setTextureFilterPtr)
  }

  public final fun getTextureFilter(): TextureFilter {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureFilterPtr)
    return TextureFilter.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTextureRepeat(repeat: TextureRepeat): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, repeat.value)
    TransferContext.callMethod(MethodBindings.setTextureRepeatPtr)
  }

  public final fun getTextureRepeat(): TextureRepeat {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureRepeatPtr)
    return TextureRepeat.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTextureSource(source: TextureSource): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, source.value)
    TransferContext.callMethod(MethodBindings.setTextureSourcePtr)
  }

  public final fun getTextureSource(): TextureSource {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureSourcePtr)
    return TextureSource.from(TransferContext.readReturnValue_LONG())
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
     * Adds `hint_anisotropy` as hint to the uniform declaration to use for a flowmap.
     */
    TYPE_ANISOTROPY(3),
    /**
     * Represents the size of the [TextureType] enum.
     */
    TYPE_MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): TextureType = entries.single { it.`value` == `value` }
    }
  }

  public enum class ColorDefault(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Defaults to fully opaque white color.
     */
    WHITE(0),
    /**
     * Defaults to fully opaque black color.
     */
    BLACK(1),
    /**
     * Defaults to fully transparent black color.
     */
    TRANSPARENT(2),
    /**
     * Represents the size of the [ColorDefault] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ColorDefault = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sample the texture using the filter determined by the node this shader is attached to.
     */
    FILTER_DEFAULT(0),
    /**
     * The texture filter reads from the nearest pixel only. This makes the texture look pixelated
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    FILTER_NEAREST(1),
    /**
     * The texture filter blends between the nearest 4 pixels. This makes the texture look smooth
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    FILTER_LINEAR(2),
    /**
     * The texture filter reads from the nearest pixel and blends between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look pixelated from up close, and smooth from a distance.
     *
     * Use this for non-pixel art textures that may be viewed at a low scale (e.g. due to [Camera2D]
     * zoom or sprite scaling), as mipmaps are important to smooth out pixels that are smaller than
     * on-screen pixels.
     */
    FILTER_NEAREST_MIPMAP(3),
    /**
     * The texture filter blends between the nearest 4 pixels and between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look smooth from up close, and smooth from a distance.
     *
     * Use this for non-pixel art textures that may be viewed at a low scale (e.g. due to [Camera2D]
     * zoom or sprite scaling), as mipmaps are important to smooth out pixels that are smaller than
     * on-screen pixels.
     */
    FILTER_LINEAR_MIPMAP(4),
    /**
     * The texture filter reads from the nearest pixel and blends between 2 mipmaps (or uses the
     * nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is
     * `true`) based on the angle between the surface and the camera view. This makes the texture look
     * pixelated from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     *
     * **Note:** This texture filter is rarely useful in 2D projects. [FILTER_NEAREST_MIPMAP] is
     * usually more appropriate in this case.
     */
    FILTER_NEAREST_MIPMAP_ANISOTROPIC(5),
    /**
     * The texture filter blends between the nearest 4 pixels and blends between 2 mipmaps (or uses
     * the nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter]
     * is `true`) based on the angle between the surface and the camera view. This makes the texture
     * look smooth from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     *
     * **Note:** This texture filter is rarely useful in 2D projects. [FILTER_LINEAR_MIPMAP] is
     * usually more appropriate in this case.
     */
    FILTER_LINEAR_MIPMAP_ANISOTROPIC(6),
    /**
     * Represents the size of the [TextureFilter] enum.
     */
    FILTER_MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): TextureFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureRepeat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sample the texture using the repeat mode determined by the node this shader is attached to.
     */
    REPEAT_DEFAULT(0),
    /**
     * Texture will repeat normally.
     */
    REPEAT_ENABLED(1),
    /**
     * Texture will not repeat.
     */
    REPEAT_DISABLED(2),
    /**
     * Represents the size of the [TextureRepeat] enum.
     */
    REPEAT_MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): TextureRepeat = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The texture source is not specified in the shader.
     */
    SOURCE_NONE(0),
    /**
     * The texture source is the screen texture which captures all opaque objects drawn this frame.
     */
    SOURCE_SCREEN(1),
    /**
     * The texture source is the depth texture from the depth prepass.
     */
    SOURCE_DEPTH(2),
    /**
     * The texture source is the normal-roughness buffer from the depth prepass.
     */
    SOURCE_NORMAL_ROUGHNESS(3),
    /**
     * Represents the size of the [TextureSource] enum.
     */
    SOURCE_MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): TextureSource = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextureTypeName:
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureType> =
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureType>("set_texture_type")

    @JvmField
    public val getTextureTypeName: MethodStringName0<VisualShaderNodeTextureParameter, TextureType>
        = MethodStringName0<VisualShaderNodeTextureParameter, TextureType>("get_texture_type")

    @JvmField
    public val setColorDefaultName:
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, ColorDefault> =
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, ColorDefault>("set_color_default")

    @JvmField
    public val getColorDefaultName:
        MethodStringName0<VisualShaderNodeTextureParameter, ColorDefault> =
        MethodStringName0<VisualShaderNodeTextureParameter, ColorDefault>("get_color_default")

    @JvmField
    public val setTextureFilterName:
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureFilter> =
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureFilter>("set_texture_filter")

    @JvmField
    public val getTextureFilterName:
        MethodStringName0<VisualShaderNodeTextureParameter, TextureFilter> =
        MethodStringName0<VisualShaderNodeTextureParameter, TextureFilter>("get_texture_filter")

    @JvmField
    public val setTextureRepeatName:
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureRepeat> =
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureRepeat>("set_texture_repeat")

    @JvmField
    public val getTextureRepeatName:
        MethodStringName0<VisualShaderNodeTextureParameter, TextureRepeat> =
        MethodStringName0<VisualShaderNodeTextureParameter, TextureRepeat>("get_texture_repeat")

    @JvmField
    public val setTextureSourceName:
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureSource> =
        MethodStringName1<VisualShaderNodeTextureParameter, Unit, TextureSource>("set_texture_source")

    @JvmField
    public val getTextureSourceName:
        MethodStringName0<VisualShaderNodeTextureParameter, TextureSource> =
        MethodStringName0<VisualShaderNodeTextureParameter, TextureSource>("get_texture_source")
  }

  public object MethodBindings {
    internal val setTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "set_texture_type", 2227296876)

    internal val getTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "get_texture_type", 367922070)

    internal val setColorDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "set_color_default", 4217624432)

    internal val getColorDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "get_color_default", 3837060134)

    internal val setTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "set_texture_filter", 2147684752)

    internal val getTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "get_texture_filter", 4184490817)

    internal val setTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "set_texture_repeat", 2036143070)

    internal val getTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "get_texture_repeat", 1690132794)

    internal val setTextureSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "set_texture_source", 1212687372)

    internal val getTextureSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTextureParameter", "get_texture_source", 2039092262)
  }
}
