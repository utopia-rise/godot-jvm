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
import godot.core.MethodStringName0
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.RID
import godot.core.Rect2
import godot.core.Vector2
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_RID_RECT2_BOOL_COLOR_BOOL
import godot.writeMethodArguments_RID_RECT2_RECT2_COLOR_BOOL_BOOL
import godot.writeMethodArguments_RID_VECTOR2_COLOR_BOOL
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A texture works by registering an image in the video hardware, which then can be used in 3D
 * models or 2D [Sprite2D] or GUI [Control].
 *
 * Textures are often created by loading them from a file. See [@GDScript.load].
 *
 * [Texture2D] is a base for other resources. It cannot be used directly.
 *
 * **Note:** The maximum texture size is 16384×16384 pixels due to graphics hardware limitations.
 * Larger textures may fail to import.
 */
@GodotBaseType
public abstract class Texture2D : Texture() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(740, scriptPtr)
  }

  /**
   * Called when [getImage] is called.
   */
  public open fun _getImage(): Image? {
    throw NotImplementedError("Texture2D::_getImage is not implemented.")
  }

  /**
   * Called when [getFormat] is called.
   */
  public open fun _getFormat(): Image.Format {
    throw NotImplementedError("Texture2D::_getFormat is not implemented.")
  }

  /**
   * Called when [getMipmapCount] is called.
   */
  public open fun _getMipmapCount(): Int {
    throw NotImplementedError("Texture2D::_getMipmapCount is not implemented.")
  }

  /**
   * Called when the [Texture2D]'s width is queried.
   */
  public abstract fun _getWidth(): Int

  /**
   * Called when the [Texture2D]'s height is queried.
   */
  public abstract fun _getHeight(): Int

  /**
   * Called when a pixel's opaque state in the [Texture2D] is queried at the specified `(x, y)`
   * position.
   */
  public open fun _isPixelOpaque(x: Int, y: Int): Boolean {
    throw NotImplementedError("Texture2D::_isPixelOpaque is not implemented.")
  }

  /**
   * Called when the presence of an alpha channel in the [Texture2D] is queried.
   */
  public open fun _hasAlpha(): Boolean {
    throw NotImplementedError("Texture2D::_hasAlpha is not implemented.")
  }

  /**
   * Called when [hasMipmaps] is called.
   */
  public open fun _hasMipmaps(): Boolean {
    throw NotImplementedError("Texture2D::_hasMipmaps is not implemented.")
  }

  /**
   * Called when the entire [Texture2D] is requested to be drawn over a [CanvasItem], with the
   * top-left offset specified in [pos]. [modulate] specifies a multiplier for the colors being drawn,
   * while [transpose] specifies whether drawing should be performed in column-major order instead of
   * row-major order (resulting in 90-degree clockwise rotation).
   *
   * **Note:** This is only used in 2D rendering, not 3D.
   */
  public open fun _draw(
    toCanvasItem: RID,
    pos: Vector2,
    modulate: Color,
    transpose: Boolean,
  ): Unit {
    throw NotImplementedError("Texture2D::_draw is not implemented.")
  }

  /**
   * Called when the [Texture2D] is requested to be drawn onto [CanvasItem]'s specified [rect].
   * [modulate] specifies a multiplier for the colors being drawn, while [transpose] specifies whether
   * drawing should be performed in column-major order instead of row-major order (resulting in
   * 90-degree clockwise rotation).
   *
   * **Note:** This is only used in 2D rendering, not 3D.
   */
  public open fun _drawRect(
    toCanvasItem: RID,
    rect: Rect2,
    tile: Boolean,
    modulate: Color,
    transpose: Boolean,
  ): Unit {
    throw NotImplementedError("Texture2D::_drawRect is not implemented.")
  }

  /**
   * Called when a part of the [Texture2D] specified by [srcRect]'s coordinates is requested to be
   * drawn onto [CanvasItem]'s specified [rect]. [modulate] specifies a multiplier for the colors being
   * drawn, while [transpose] specifies whether drawing should be performed in column-major order
   * instead of row-major order (resulting in 90-degree clockwise rotation).
   *
   * **Note:** This is only used in 2D rendering, not 3D.
   */
  public open fun _drawRectRegion(
    toCanvasItem: RID,
    rect: Rect2,
    srcRect: Rect2,
    modulate: Color,
    transpose: Boolean,
    clipUv: Boolean,
  ): Unit {
    throw NotImplementedError("Texture2D::_drawRectRegion is not implemented.")
  }

  /**
   * Returns the image format of the texture.
   */
  public final fun getFormat(): Image.Format {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return Image.Format.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the number of mipmaps of the texture.
   */
  public final fun getMipmapCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMipmapCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the texture width in pixels.
   */
  public final fun getWidth(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWidthPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the texture height in pixels.
   */
  public final fun getHeight(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the texture size in pixels.
   */
  public final fun getSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns `true` if this [Texture2D] has an alpha channel.
   */
  public final fun hasAlpha(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAlphaPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the texture has mipmaps.
   */
  public final fun hasMipmaps(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasMipmapsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Draws the texture using a [CanvasItem] with the [RenderingServer] API at the specified
   * [position].
   */
  @JvmOverloads
  public final fun draw(
    canvasItem: RID,
    position: Vector2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_BOOL(ptr, objectID.id, canvasItem, position, modulate, transpose)
    TransferContext.callMethod(MethodBindings.drawPtr)
  }

  /**
   * Draws the texture using a [CanvasItem] with the [RenderingServer] API.
   */
  @JvmOverloads
  public final fun drawRect(
    canvasItem: RID,
    rect: Rect2,
    tile: Boolean,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_RID_RECT2_BOOL_COLOR_BOOL(ptr, objectID.id, canvasItem, rect, tile, modulate, transpose)
    TransferContext.callMethod(MethodBindings.drawRectPtr)
  }

  /**
   * Draws a part of the texture using a [CanvasItem] with the [RenderingServer] API.
   */
  @JvmOverloads
  public final fun drawRectRegion(
    canvasItem: RID,
    rect: Rect2,
    srcRect: Rect2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
    clipUv: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments_RID_RECT2_RECT2_COLOR_BOOL_BOOL(ptr, objectID.id, canvasItem, rect, srcRect, modulate, transpose, clipUv)
    TransferContext.callMethod(MethodBindings.drawRectRegionPtr)
  }

  /**
   * Returns an [Image] that is a copy of data from this [Texture2D] (a new [Image] is created each
   * time). [Image]s can be accessed and manipulated directly.
   *
   * **Note:** This will return `null` if this [Texture2D] is invalid.
   *
   * **Note:** This will fetch the texture data from the GPU, which might cause performance problems
   * when overused. Avoid calling [getImage] every frame, especially on large textures.
   */
  public final fun getImage(): Image? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getImagePtr)
    return (TransferContext.readReturnValue_OBJECT() as Image?)
  }

  /**
   * Creates a placeholder version of this resource ([PlaceholderTexture2D]).
   */
  public final fun createPlaceholder(): Resource? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createPlaceholderPtr)
    return (TransferContext.readReturnValue_OBJECT() as Resource?)
  }

  public companion object {
    @JvmField
    public val getFormatName: MethodStringName0<Texture2D, Image.Format> =
        MethodStringName0<Texture2D, Image.Format>("get_format")

    @JvmField
    public val getMipmapCountName: MethodStringName0<Texture2D, Int> =
        MethodStringName0<Texture2D, Int>("get_mipmap_count")

    @JvmField
    public val getWidthName: MethodStringName0<Texture2D, Int> =
        MethodStringName0<Texture2D, Int>("get_width")

    @JvmField
    public val getHeightName: MethodStringName0<Texture2D, Int> =
        MethodStringName0<Texture2D, Int>("get_height")

    @JvmField
    public val getSizeName: MethodStringName0<Texture2D, Vector2> =
        MethodStringName0<Texture2D, Vector2>("get_size")

    @JvmField
    public val hasAlphaName: MethodStringName0<Texture2D, Boolean> =
        MethodStringName0<Texture2D, Boolean>("has_alpha")

    @JvmField
    public val hasMipmapsName: MethodStringName0<Texture2D, Boolean> =
        MethodStringName0<Texture2D, Boolean>("has_mipmaps")

    @JvmField
    public val drawName: MethodStringName4<Texture2D, Unit, RID, Vector2, Color, Boolean> =
        MethodStringName4<Texture2D, Unit, RID, Vector2, Color, Boolean>("draw")

    @JvmField
    public val drawRectName: MethodStringName5<Texture2D, Unit, RID, Rect2, Boolean, Color, Boolean>
        = MethodStringName5<Texture2D, Unit, RID, Rect2, Boolean, Color, Boolean>("draw_rect")

    @JvmField
    public val drawRectRegionName:
        MethodStringName6<Texture2D, Unit, RID, Rect2, Rect2, Color, Boolean, Boolean> =
        MethodStringName6<Texture2D, Unit, RID, Rect2, Rect2, Color, Boolean, Boolean>("draw_rect_region")

    @JvmField
    public val getImageName: MethodStringName0<Texture2D, Image?> =
        MethodStringName0<Texture2D, Image?>("get_image")

    @JvmField
    public val createPlaceholderName: MethodStringName0<Texture2D, Resource?> =
        MethodStringName0<Texture2D, Resource?>("create_placeholder")
  }

  public object MethodBindings {
    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "get_format", 3847873762)

    internal val getMipmapCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "get_mipmap_count", 3905245786)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "get_width", 3905245786)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "get_height", 3905245786)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "get_size", 3341600327)

    internal val hasAlphaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "has_alpha", 36873697)

    internal val hasMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "has_mipmaps", 36873697)

    internal val drawPtr: VoidPtr = TypeManager.getMethodBindPtr("Texture2D", "draw", 2729649137)

    internal val drawRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "draw_rect", 3499451691)

    internal val drawRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "draw_rect_region", 2963678660)

    internal val getImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "get_image", 4190603485)

    internal val createPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2D", "create_placeholder", 121922552)
  }
}

internal class Texture2DDummy : Texture2D() {
  public override fun _getWidth(): Int {
    throw NotImplementedError("Texture2D::_getWidth is only implemented by non-JVM code.")
  }

  public override fun _getHeight(): Int {
    throw NotImplementedError("Texture2D::_getHeight is only implemented by non-JVM code.")
  }
}
