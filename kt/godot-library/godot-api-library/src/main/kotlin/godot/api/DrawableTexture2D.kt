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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.Rect2i
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2I
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A 2D texture that can be modified via blit calls, copying from a target texture to itself.
 * Primarily intended to be managed in code, a user must call [setup] to initialize the state before
 * drawing. Each [blitRect] call takes at least a rectangle, the area to draw to, and another texture,
 * what to be drawn. The draw calls use a Texture_Blit Shader to process and calculate the result,
 * pixel by pixel. Users can supply their own ShaderMaterial with custom Texture_Blit shaders for more
 * complex behaviors.
 */
@GodotBaseType
public open class DrawableTexture2D : Texture2D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(209, scriptPtr)
  }

  /**
   * Sets the format of this DrawableTexture.
   */
  public final fun setFormat(format: DrawableFormat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value)
    TransferContext.callMethod(MethodBindings.setFormatPtr)
  }

  /**
   * Sets if mipmaps should be used on this DrawableTexture.
   */
  public final fun setUseMipmaps(mipmaps: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to mipmaps)
    TransferContext.callMethod(MethodBindings.setUseMipmapsPtr)
  }

  /**
   * Returns `true` if mipmaps are set to be used on this DrawableTexture.
   */
  public final fun getUseMipmaps(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseMipmapsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Initializes the DrawableTexture to a White texture of the given [width], [height], and
   * [format].
   */
  @JvmOverloads
  public final fun setup(
    width: Int,
    height: Int,
    format: DrawableFormat,
    color: Color = Color(Color(1, 1, 1, 1)),
    useMipmaps: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong(), LONG to height.toLong(), LONG to format.value, COLOR to color, BOOL to useMipmaps)
    TransferContext.callMethod(MethodBindings.setupPtr)
  }

  /**
   * Draws to given [rect] on this texture by copying from the given [source]. A [modulate] color
   * can be passed in for the shader to use, but defaults to White. The [mipmap] value can specify a
   * draw to a lower mipmap level. The [material] parameter can take a ShaderMaterial with a
   * TextureBlit Shader for custom drawing behavior.
   */
  @JvmOverloads
  public final fun blitRect(
    rect: Rect2i,
    source: Texture2D?,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    mipmap: Int = 0,
    material: Material? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to rect, OBJECT to source, COLOR to modulate, LONG to mipmap.toLong(), OBJECT to material)
    TransferContext.callMethod(MethodBindings.blitRectPtr)
  }

  /**
   * Draws to the given [rect] on this texture, as well as on up to 3 DrawableTexture
   * [extraTargets]. All [extraTargets] must be the same size and DrawableFormat as the original
   * target, otherwise the Shader may fail. Expects up to 4 Texture [sources], but will replace missing
   * [sources] with default Black Textures.
   */
  @JvmOverloads
  public final fun blitRectMulti(
    rect: Rect2i,
    sources: VariantArray<Texture2D>,
    extraTargets: VariantArray<DrawableTexture2D>,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    mipmap: Int = 0,
    material: Material? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to rect, ARRAY to sources, ARRAY to extraTargets, COLOR to modulate, LONG to mipmap.toLong(), OBJECT to material)
    TransferContext.callMethod(MethodBindings.blitRectMultiPtr)
  }

  /**
   * Re-calculates the mipmaps for this texture on demand.
   */
  public final fun generateMipmaps(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.generateMipmapsPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("DrawableTexture2D::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("DrawableTexture2D::_getHeight can't be called from the JVM.")
  }

  public enum class DrawableFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * OpenGL texture format RGBA with four components, each with a bitdepth of 8.
     */
    RGBA8(0),
    /**
     * OpenGL texture format RGBA with four components, each with a bitdepth of 8.
     *
     * When drawn to, an sRGB to linear color space conversion is performed.
     */
    RGBA8_SRGB(1),
    /**
     * OpenGL texture format GL_RGBA16F where there are four components, each a 16-bit
     * "half-precision" floating-point value.
     */
    RGBAH(2),
    /**
     * OpenGL texture format GL_RGBA32F where there are four components, each a 32-bit
     * floating-point value.
     */
    RGBAF(3),
    ;

    public companion object {
      public fun from(`value`: Long): DrawableFormat = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFormatName: MethodStringName1<DrawableTexture2D, Unit, DrawableFormat> =
        MethodStringName1<DrawableTexture2D, Unit, DrawableFormat>("set_format")

    @JvmField
    public val setUseMipmapsName: MethodStringName1<DrawableTexture2D, Unit, Boolean> =
        MethodStringName1<DrawableTexture2D, Unit, Boolean>("set_use_mipmaps")

    @JvmField
    public val getUseMipmapsName: MethodStringName0<DrawableTexture2D, Boolean> =
        MethodStringName0<DrawableTexture2D, Boolean>("get_use_mipmaps")

    @JvmField
    public val setupName:
        MethodStringName5<DrawableTexture2D, Unit, Int, Int, DrawableFormat, Color, Boolean> =
        MethodStringName5<DrawableTexture2D, Unit, Int, Int, DrawableFormat, Color, Boolean>("setup")

    @JvmField
    public val blitRectName:
        MethodStringName5<DrawableTexture2D, Unit, Rect2i, Texture2D?, Color, Int, Material?> =
        MethodStringName5<DrawableTexture2D, Unit, Rect2i, Texture2D?, Color, Int, Material?>("blit_rect")

    @JvmField
    public val blitRectMultiName:
        MethodStringName6<DrawableTexture2D, Unit, Rect2i, VariantArray<Texture2D>, VariantArray<DrawableTexture2D>, Color, Int, Material?>
        =
        MethodStringName6<DrawableTexture2D, Unit, Rect2i, VariantArray<Texture2D>, VariantArray<DrawableTexture2D>, Color, Int, Material?>("blit_rect_multi")

    @JvmField
    public val generateMipmapsName: MethodStringName0<DrawableTexture2D, Unit> =
        MethodStringName0<DrawableTexture2D, Unit>("generate_mipmaps")
  }

  public object MethodBindings {
    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "set_format", 2875673594)

    internal val setUseMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "set_use_mipmaps", 2586408642)

    internal val getUseMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "get_use_mipmaps", 36873697)

    internal val setupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "setup", 674365339)

    internal val blitRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "blit_rect", 319217173)

    internal val blitRectMultiPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "blit_rect_multi", 3074783066)

    internal val generateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DrawableTexture2D", "generate_mipmaps", 3218959716)
  }
}
