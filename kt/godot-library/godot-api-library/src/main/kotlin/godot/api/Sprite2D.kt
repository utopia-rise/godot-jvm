// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Rect2
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A node that displays a 2D texture. The texture displayed can be a region from a larger atlas
 * texture, or a frame from a sprite sheet animation.
 */
@GodotBaseType
public open class Sprite2D : Node2D() {
  /**
   * Emitted when the [frame] changes.
   */
  public val frameChanged: Signal0 by Signal0

  /**
   * Emitted when the [texture] changes.
   */
  public val textureChanged: Signal0 by Signal0

  /**
   * [Texture2D] object to draw.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * If `true`, texture is centered.
   *
   * **Note:** For games with a pixel art aesthetic, textures may appear deformed when centered.
   * This is caused by their position being between pixels. To prevent this, set this property to
   * `false`, or consider enabling [ProjectSettings.rendering/2d/snap/snap2dVerticesToPixel] and
   * [ProjectSettings.rendering/2d/snap/snap2dTransformsToPixel].
   */
  public final inline var centered: Boolean
    @JvmName("centeredProperty")
    get() = isCentered()
    @JvmName("centeredProperty")
    set(`value`) {
      setCentered(value)
    }

  /**
   * The texture's drawing offset.
   *
   * **Note:** When you increase [offset].y in Sprite2D, the sprite moves downward on screen
   * (i.e., +Y is down).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offset: Vector2
    @JvmName("offsetProperty")
    get() = getOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setOffset(value)
    }

  /**
   * If `true`, texture is flipped horizontally.
   */
  public final inline var flipH: Boolean
    @JvmName("flipHProperty")
    get() = isFlippedH()
    @JvmName("flipHProperty")
    set(`value`) {
      setFlipH(value)
    }

  /**
   * If `true`, texture is flipped vertically.
   */
  public final inline var flipV: Boolean
    @JvmName("flipVProperty")
    get() = isFlippedV()
    @JvmName("flipVProperty")
    set(`value`) {
      setFlipV(value)
    }

  /**
   * The number of columns in the sprite sheet. When this property is changed, [frame] is adjusted
   * so that the same visual frame is maintained (same row and column). If that's impossible, [frame]
   * is reset to `0`.
   */
  public final inline var hframes: Int
    @JvmName("hframesProperty")
    get() = getHframes()
    @JvmName("hframesProperty")
    set(`value`) {
      setHframes(value)
    }

  /**
   * The number of rows in the sprite sheet. When this property is changed, [frame] is adjusted so
   * that the same visual frame is maintained (same row and column). If that's impossible, [frame] is
   * reset to `0`.
   */
  public final inline var vframes: Int
    @JvmName("vframesProperty")
    get() = getVframes()
    @JvmName("vframesProperty")
    set(`value`) {
      setVframes(value)
    }

  /**
   * Current frame to display from sprite sheet. [hframes] or [vframes] must be greater than 1. This
   * property is automatically adjusted when [hframes] or [vframes] are changed to keep pointing to the
   * same visual frame (same column and row). If that's impossible, this value is reset to `0`.
   */
  public final inline var frame: Int
    @JvmName("frameProperty")
    get() = getFrame()
    @JvmName("frameProperty")
    set(`value`) {
      setFrame(value)
    }

  /**
   * Coordinates of the frame to display from sprite sheet. This is as an alias for the [frame]
   * property. [hframes] or [vframes] must be greater than 1.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var frameCoords: Vector2i
    @JvmName("frameCoordsProperty")
    get() = getFrameCoords()
    @JvmName("frameCoordsProperty")
    set(`value`) {
      setFrameCoords(value)
    }

  /**
   * If `true`, texture is cut from a larger atlas texture. See [regionRect].
   *
   * **Note:** When using a custom [Shader] on a [Sprite2D], the `UV` shader built-in will refer to
   * the entire texture space. Use the `REGION_RECT` built-in to get the currently visible region
   * defined in [regionRect] instead. See
   * [url=$DOCS_URL/tutorials/shaders/shader_reference/canvas_item_shader.html]CanvasItem shaders[/url]
   * for details.
   */
  public final inline var regionEnabled: Boolean
    @JvmName("regionEnabledProperty")
    get() = isRegionEnabled()
    @JvmName("regionEnabledProperty")
    set(`value`) {
      setRegionEnabled(value)
    }

  /**
   * The region of the atlas texture to display. [regionEnabled] must be `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var regionRect: Rect2
    @JvmName("regionRectProperty")
    get() = getRegionRect()
    @JvmName("regionRectProperty")
    set(`value`) {
      setRegionRect(value)
    }

  /**
   * If `true`, the area outside of the [regionRect] is clipped to avoid bleeding of the surrounding
   * texture pixels. [regionEnabled] must be `true`.
   */
  public final inline var regionFilterClipEnabled: Boolean
    @JvmName("regionFilterClipEnabledProperty")
    get() = isRegionFilterClipEnabled()
    @JvmName("regionFilterClipEnabledProperty")
    set(`value`) {
      setRegionFilterClipEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(699, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = sprite2d.offset
   * //Your changes
   * sprite2d.offset = myCoreType
   * ``````
   *
   * The texture's drawing offset.
   *
   * **Note:** When you increase [offset].y in Sprite2D, the sprite moves downward on screen
   * (i.e., +Y is down).
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [frameCoords] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = sprite2d.frameCoords
   * //Your changes
   * sprite2d.frameCoords = myCoreType
   * ``````
   *
   * Coordinates of the frame to display from sprite sheet. This is as an alias for the [frame]
   * property. [hframes] or [vframes] must be greater than 1.
   */
  @CoreTypeHelper
  public final fun frameCoordsMutate(block: Vector2i.() -> Unit): Vector2i = frameCoords.apply {
     block(this)
     frameCoords = this
  }

  /**
   * This is a helper function for [regionRect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = sprite2d.regionRect
   * //Your changes
   * sprite2d.regionRect = myCoreType
   * ``````
   *
   * The region of the atlas texture to display. [regionEnabled] must be `true`.
   */
  @CoreTypeHelper
  public final fun regionRectMutate(block: Rect2.() -> Unit): Rect2 = regionRect.apply {
     block(this)
     regionRect = this
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setCentered(centered: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to centered)
    TransferContext.callMethod(MethodBindings.setCenteredPtr)
  }

  public final fun isCentered(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCenteredPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  public final fun getOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setFlipH(flipH: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipH)
    TransferContext.callMethod(MethodBindings.setFlipHPtr)
  }

  public final fun isFlippedH(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlippedHPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFlipV(flipV: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipV)
    TransferContext.callMethod(MethodBindings.setFlipVPtr)
  }

  public final fun isFlippedV(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlippedVPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRegionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRegionEnabledPtr)
  }

  public final fun isRegionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRegionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the pixel at the given position is opaque, `false` otherwise. Also returns
   * `false` if the given position is out of bounds or this sprite's [texture] is `null`. [pos] is in
   * local coordinates.
   */
  public final fun isPixelOpaque(pos: Vector2): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to pos)
    TransferContext.callMethod(MethodBindings.isPixelOpaquePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRegionRect(rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.setRegionRectPtr)
  }

  public final fun getRegionRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRegionRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setRegionFilterClipEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRegionFilterClipEnabledPtr)
  }

  public final fun isRegionFilterClipEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRegionFilterClipEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFrame(frame: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frame.toLong())
    TransferContext.callMethod(MethodBindings.setFramePtr)
  }

  public final fun getFrame(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFrameCoords(coords: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.setFrameCoordsPtr)
  }

  public final fun getFrameCoords(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrameCoordsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setVframes(vframes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to vframes.toLong())
    TransferContext.callMethod(MethodBindings.setVframesPtr)
  }

  public final fun getVframes(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVframesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHframes(hframes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to hframes.toLong())
    TransferContext.callMethod(MethodBindings.setHframesPtr)
  }

  public final fun getHframes(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHframesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [Rect2] representing the Sprite2D's boundary in local coordinates.
   *
   * **Example:** Detect if the Sprite2D was clicked:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventMouseButton and event.pressed and event.button_index ==
   * MOUSE_BUTTON_LEFT:
   * 		if get_rect().has_point(to_local(event.position)):
   * 			print("A click!")
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventMouseButton inputEventMouse)
   * 	{
   * 		if (inputEventMouse.Pressed && inputEventMouse.ButtonIndex == MouseButton.Left)
   * 		{
   * 			if (GetRect().HasPoint(ToLocal(inputEventMouse.Position)))
   * 			{
   * 				GD.Print("A click!");
   * 			}
   * 		}
   * 	}
   * }
   * ```
   */
  public final fun getRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<Sprite2D, Unit, Texture2D?> =
        MethodStringName1<Sprite2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<Sprite2D, Texture2D?> =
        MethodStringName0<Sprite2D, Texture2D?>("get_texture")

    @JvmField
    public val setCenteredName: MethodStringName1<Sprite2D, Unit, Boolean> =
        MethodStringName1<Sprite2D, Unit, Boolean>("set_centered")

    @JvmField
    public val isCenteredName: MethodStringName0<Sprite2D, Boolean> =
        MethodStringName0<Sprite2D, Boolean>("is_centered")

    @JvmField
    public val setOffsetName: MethodStringName1<Sprite2D, Unit, Vector2> =
        MethodStringName1<Sprite2D, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<Sprite2D, Vector2> =
        MethodStringName0<Sprite2D, Vector2>("get_offset")

    @JvmField
    public val setFlipHName: MethodStringName1<Sprite2D, Unit, Boolean> =
        MethodStringName1<Sprite2D, Unit, Boolean>("set_flip_h")

    @JvmField
    public val isFlippedHName: MethodStringName0<Sprite2D, Boolean> =
        MethodStringName0<Sprite2D, Boolean>("is_flipped_h")

    @JvmField
    public val setFlipVName: MethodStringName1<Sprite2D, Unit, Boolean> =
        MethodStringName1<Sprite2D, Unit, Boolean>("set_flip_v")

    @JvmField
    public val isFlippedVName: MethodStringName0<Sprite2D, Boolean> =
        MethodStringName0<Sprite2D, Boolean>("is_flipped_v")

    @JvmField
    public val setRegionEnabledName: MethodStringName1<Sprite2D, Unit, Boolean> =
        MethodStringName1<Sprite2D, Unit, Boolean>("set_region_enabled")

    @JvmField
    public val isRegionEnabledName: MethodStringName0<Sprite2D, Boolean> =
        MethodStringName0<Sprite2D, Boolean>("is_region_enabled")

    @JvmField
    public val isPixelOpaqueName: MethodStringName1<Sprite2D, Boolean, Vector2> =
        MethodStringName1<Sprite2D, Boolean, Vector2>("is_pixel_opaque")

    @JvmField
    public val setRegionRectName: MethodStringName1<Sprite2D, Unit, Rect2> =
        MethodStringName1<Sprite2D, Unit, Rect2>("set_region_rect")

    @JvmField
    public val getRegionRectName: MethodStringName0<Sprite2D, Rect2> =
        MethodStringName0<Sprite2D, Rect2>("get_region_rect")

    @JvmField
    public val setRegionFilterClipEnabledName: MethodStringName1<Sprite2D, Unit, Boolean> =
        MethodStringName1<Sprite2D, Unit, Boolean>("set_region_filter_clip_enabled")

    @JvmField
    public val isRegionFilterClipEnabledName: MethodStringName0<Sprite2D, Boolean> =
        MethodStringName0<Sprite2D, Boolean>("is_region_filter_clip_enabled")

    @JvmField
    public val setFrameName: MethodStringName1<Sprite2D, Unit, Int> =
        MethodStringName1<Sprite2D, Unit, Int>("set_frame")

    @JvmField
    public val getFrameName: MethodStringName0<Sprite2D, Int> =
        MethodStringName0<Sprite2D, Int>("get_frame")

    @JvmField
    public val setFrameCoordsName: MethodStringName1<Sprite2D, Unit, Vector2i> =
        MethodStringName1<Sprite2D, Unit, Vector2i>("set_frame_coords")

    @JvmField
    public val getFrameCoordsName: MethodStringName0<Sprite2D, Vector2i> =
        MethodStringName0<Sprite2D, Vector2i>("get_frame_coords")

    @JvmField
    public val setVframesName: MethodStringName1<Sprite2D, Unit, Int> =
        MethodStringName1<Sprite2D, Unit, Int>("set_vframes")

    @JvmField
    public val getVframesName: MethodStringName0<Sprite2D, Int> =
        MethodStringName0<Sprite2D, Int>("get_vframes")

    @JvmField
    public val setHframesName: MethodStringName1<Sprite2D, Unit, Int> =
        MethodStringName1<Sprite2D, Unit, Int>("set_hframes")

    @JvmField
    public val getHframesName: MethodStringName0<Sprite2D, Int> =
        MethodStringName0<Sprite2D, Int>("get_hframes")

    @JvmField
    public val getRectName: MethodStringName0<Sprite2D, Rect2> =
        MethodStringName0<Sprite2D, Rect2>("get_rect")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_texture", 3635182373)

    internal val setCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_centered", 2586408642)

    internal val isCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "is_centered", 36873697)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_offset", 3341600327)

    internal val setFlipHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_flip_h", 2586408642)

    internal val isFlippedHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "is_flipped_h", 36873697)

    internal val setFlipVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_flip_v", 2586408642)

    internal val isFlippedVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "is_flipped_v", 36873697)

    internal val setRegionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_region_enabled", 2586408642)

    internal val isRegionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "is_region_enabled", 36873697)

    internal val isPixelOpaquePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "is_pixel_opaque", 556197845)

    internal val setRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_region_rect", 2046264180)

    internal val getRegionRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_region_rect", 1639390495)

    internal val setRegionFilterClipEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_region_filter_clip_enabled", 2586408642)

    internal val isRegionFilterClipEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "is_region_filter_clip_enabled", 36873697)

    internal val setFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_frame", 1286410249)

    internal val getFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_frame", 3905245786)

    internal val setFrameCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_frame_coords", 1130785943)

    internal val getFrameCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_frame_coords", 3690982128)

    internal val setVframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_vframes", 1286410249)

    internal val getVframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_vframes", 3905245786)

    internal val setHframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "set_hframes", 1286410249)

    internal val getHframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_hframes", 3905245786)

    internal val getRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Sprite2D", "get_rect", 1639390495)
  }
}
