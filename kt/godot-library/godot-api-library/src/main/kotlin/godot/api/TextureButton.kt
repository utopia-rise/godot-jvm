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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [TextureButton] has the same functionality as [Button], except it uses sprites instead of Godot's
 * [Theme] resource. It is faster to create, but it doesn't support localization like more complex
 * [Control]s.
 *
 * See also [BaseButton] which contains common properties and methods associated with this node.
 *
 * **Note:** Setting a texture for the "normal" state ([textureNormal]) is recommended. If
 * [textureNormal] is not set, the [TextureButton] will still receive input events and be clickable,
 * but the user will not be able to see it unless they activate another one of its states with a
 * texture assigned (e.g., hover over it to show [textureHover]).
 */
@GodotBaseType
public open class TextureButton : BaseButton() {
  /**
   * Texture to display by default, when the node is **not** in the disabled, hover or pressed
   * state. This texture is still displayed in the focused state, with [textureFocused] drawn on top.
   */
  public final inline var textureNormal: Texture2D?
    @JvmName("textureNormalProperty")
    get() = getTextureNormal()
    @JvmName("textureNormalProperty")
    set(`value`) {
      setTextureNormal(value)
    }

  /**
   * Texture to display on mouse down over the node, if the node has keyboard focus and the player
   * presses the Enter key or if the player presses the [BaseButton.shortcut] key. If not assigned, the
   * [TextureButton] displays [textureHover] instead when pressed.
   */
  public final inline var texturePressed: Texture2D?
    @JvmName("texturePressedProperty")
    get() = getTexturePressed()
    @JvmName("texturePressedProperty")
    set(`value`) {
      setTexturePressed(value)
    }

  /**
   * Texture to display when the mouse hovers over the node. If not assigned, the [TextureButton]
   * displays [textureNormal] instead when hovered over.
   */
  public final inline var textureHover: Texture2D?
    @JvmName("textureHoverProperty")
    get() = getTextureHover()
    @JvmName("textureHoverProperty")
    set(`value`) {
      setTextureHover(value)
    }

  /**
   * Texture to display when the node is disabled. See [BaseButton.disabled]. If not assigned, the
   * [TextureButton] displays [textureNormal] instead.
   */
  public final inline var textureDisabled: Texture2D?
    @JvmName("textureDisabledProperty")
    get() = getTextureDisabled()
    @JvmName("textureDisabledProperty")
    set(`value`) {
      setTextureDisabled(value)
    }

  /**
   * Texture to *overlay on the base texture* when the node has mouse or keyboard focus. Because
   * [textureFocused] is displayed on top of the base texture, a partially transparent texture should
   * be used to ensure the base texture remains visible. A texture that represents an outline or an
   * underline works well for this purpose. To disable the focus visual effect, assign a fully
   * transparent texture of any size. Note that disabling the focus visual effect will harm
   * keyboard/controller navigation usability, so this is not recommended for accessibility reasons.
   */
  public final inline var textureFocused: Texture2D?
    @JvmName("textureFocusedProperty")
    get() = getTextureFocused()
    @JvmName("textureFocusedProperty")
    set(`value`) {
      setTextureFocused(value)
    }

  /**
   * Pure black and white [BitMap] image to use for click detection. On the mask, white pixels
   * represent the button's clickable area. Use it to create buttons with curved shapes.
   */
  public final inline var textureClickMask: BitMap?
    @JvmName("textureClickMaskProperty")
    get() = getClickMask()
    @JvmName("textureClickMaskProperty")
    set(`value`) {
      setClickMask(value)
    }

  /**
   * If `true`, the size of the texture won't be considered for minimum size calculation, so the
   * [TextureButton] can be shrunk down past the texture size.
   */
  public final inline var ignoreTextureSize: Boolean
    @JvmName("ignoreTextureSizeProperty")
    get() = getIgnoreTextureSize()
    @JvmName("ignoreTextureSizeProperty")
    set(`value`) {
      setIgnoreTextureSize(value)
    }

  /**
   * Controls the texture's behavior when you resize the node's bounding rectangle. See the
   * [StretchMode] constants for available options.
   */
  public final inline var stretchMode: StretchMode
    @JvmName("stretchModeProperty")
    get() = getStretchMode()
    @JvmName("stretchModeProperty")
    set(`value`) {
      setStretchMode(value)
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

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(746, scriptPtr)
  }

  public final fun setTextureNormal(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTextureNormalPtr)
  }

  public final fun setTexturePressed(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTexturePressedPtr)
  }

  public final fun setTextureHover(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTextureHoverPtr)
  }

  public final fun setTextureDisabled(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTextureDisabledPtr)
  }

  public final fun setTextureFocused(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callMethod(MethodBindings.setTextureFocusedPtr)
  }

  public final fun setClickMask(mask: BitMap?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, mask)
    TransferContext.callMethod(MethodBindings.setClickMaskPtr)
  }

  public final fun setIgnoreTextureSize(ignore: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, ignore)
    TransferContext.callMethod(MethodBindings.setIgnoreTextureSizePtr)
  }

  public final fun setStretchMode(mode: StretchMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setStretchModePtr)
  }

  public final fun setFlipH(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setFlipHPtr)
  }

  public final fun isFlippedH(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlippedHPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFlipV(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setFlipVPtr)
  }

  public final fun isFlippedV(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlippedVPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getTextureNormal(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureNormalPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun getTexturePressed(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePressedPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun getTextureHover(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureHoverPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun getTextureDisabled(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureDisabledPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun getTextureFocused(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureFocusedPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun getClickMask(): BitMap? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClickMaskPtr)
    return (TransferContext.readReturnValue_OBJECT() as BitMap?)
  }

  public final fun getIgnoreTextureSize(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIgnoreTextureSizePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getStretchMode(): StretchMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStretchModePtr)
    return StretchMode.from(TransferContext.readReturnValue_LONG())
  }

  public enum class StretchMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Scale to fit the node's bounding rectangle.
     */
    SCALE(0),
    /**
     * Tile inside the node's bounding rectangle.
     */
    TILE(1),
    /**
     * The texture keeps its original size and stays in the bounding rectangle's top-left corner.
     */
    KEEP(2),
    /**
     * The texture keeps its original size and stays centered in the node's bounding rectangle.
     */
    KEEP_CENTERED(3),
    /**
     * Scale the texture to fit the node's bounding rectangle, but maintain the texture's aspect
     * ratio.
     */
    KEEP_ASPECT(4),
    /**
     * Scale the texture to fit the node's bounding rectangle, center it, and maintain its aspect
     * ratio.
     */
    KEEP_ASPECT_CENTERED(5),
    /**
     * Scale the texture so that the shorter side fits the bounding rectangle. The other side clips
     * to the node's limits.
     */
    KEEP_ASPECT_COVERED(6),
    ;

    public companion object {
      public fun from(`value`: Long): StretchMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextureNormalName: MethodStringName1<TextureButton, Unit, Texture2D?> =
        MethodStringName1<TextureButton, Unit, Texture2D?>("set_texture_normal")

    @JvmField
    public val setTexturePressedName: MethodStringName1<TextureButton, Unit, Texture2D?> =
        MethodStringName1<TextureButton, Unit, Texture2D?>("set_texture_pressed")

    @JvmField
    public val setTextureHoverName: MethodStringName1<TextureButton, Unit, Texture2D?> =
        MethodStringName1<TextureButton, Unit, Texture2D?>("set_texture_hover")

    @JvmField
    public val setTextureDisabledName: MethodStringName1<TextureButton, Unit, Texture2D?> =
        MethodStringName1<TextureButton, Unit, Texture2D?>("set_texture_disabled")

    @JvmField
    public val setTextureFocusedName: MethodStringName1<TextureButton, Unit, Texture2D?> =
        MethodStringName1<TextureButton, Unit, Texture2D?>("set_texture_focused")

    @JvmField
    public val setClickMaskName: MethodStringName1<TextureButton, Unit, BitMap?> =
        MethodStringName1<TextureButton, Unit, BitMap?>("set_click_mask")

    @JvmField
    public val setIgnoreTextureSizeName: MethodStringName1<TextureButton, Unit, Boolean> =
        MethodStringName1<TextureButton, Unit, Boolean>("set_ignore_texture_size")

    @JvmField
    public val setStretchModeName: MethodStringName1<TextureButton, Unit, StretchMode> =
        MethodStringName1<TextureButton, Unit, StretchMode>("set_stretch_mode")

    @JvmField
    public val setFlipHName: MethodStringName1<TextureButton, Unit, Boolean> =
        MethodStringName1<TextureButton, Unit, Boolean>("set_flip_h")

    @JvmField
    public val isFlippedHName: MethodStringName0<TextureButton, Boolean> =
        MethodStringName0<TextureButton, Boolean>("is_flipped_h")

    @JvmField
    public val setFlipVName: MethodStringName1<TextureButton, Unit, Boolean> =
        MethodStringName1<TextureButton, Unit, Boolean>("set_flip_v")

    @JvmField
    public val isFlippedVName: MethodStringName0<TextureButton, Boolean> =
        MethodStringName0<TextureButton, Boolean>("is_flipped_v")

    @JvmField
    public val getTextureNormalName: MethodStringName0<TextureButton, Texture2D?> =
        MethodStringName0<TextureButton, Texture2D?>("get_texture_normal")

    @JvmField
    public val getTexturePressedName: MethodStringName0<TextureButton, Texture2D?> =
        MethodStringName0<TextureButton, Texture2D?>("get_texture_pressed")

    @JvmField
    public val getTextureHoverName: MethodStringName0<TextureButton, Texture2D?> =
        MethodStringName0<TextureButton, Texture2D?>("get_texture_hover")

    @JvmField
    public val getTextureDisabledName: MethodStringName0<TextureButton, Texture2D?> =
        MethodStringName0<TextureButton, Texture2D?>("get_texture_disabled")

    @JvmField
    public val getTextureFocusedName: MethodStringName0<TextureButton, Texture2D?> =
        MethodStringName0<TextureButton, Texture2D?>("get_texture_focused")

    @JvmField
    public val getClickMaskName: MethodStringName0<TextureButton, BitMap?> =
        MethodStringName0<TextureButton, BitMap?>("get_click_mask")

    @JvmField
    public val getIgnoreTextureSizeName: MethodStringName0<TextureButton, Boolean> =
        MethodStringName0<TextureButton, Boolean>("get_ignore_texture_size")

    @JvmField
    public val getStretchModeName: MethodStringName0<TextureButton, StretchMode> =
        MethodStringName0<TextureButton, StretchMode>("get_stretch_mode")
  }

  public object MethodBindings {
    internal val setTextureNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_texture_normal", 4051416890)

    internal val setTexturePressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_texture_pressed", 4051416890)

    internal val setTextureHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_texture_hover", 4051416890)

    internal val setTextureDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_texture_disabled", 4051416890)

    internal val setTextureFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_texture_focused", 4051416890)

    internal val setClickMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_click_mask", 698588216)

    internal val setIgnoreTextureSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_ignore_texture_size", 2586408642)

    internal val setStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_stretch_mode", 252530840)

    internal val setFlipHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_flip_h", 2586408642)

    internal val isFlippedHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "is_flipped_h", 36873697)

    internal val setFlipVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "set_flip_v", 2586408642)

    internal val isFlippedVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "is_flipped_v", 36873697)

    internal val getTextureNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_texture_normal", 3635182373)

    internal val getTexturePressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_texture_pressed", 3635182373)

    internal val getTextureHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_texture_hover", 3635182373)

    internal val getTextureDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_texture_disabled", 3635182373)

    internal val getTextureFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_texture_focused", 3635182373)

    internal val getClickMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_click_mask", 2459671998)

    internal val getIgnoreTextureSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_ignore_texture_size", 36873697)

    internal val getStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureButton", "get_stretch_mode", 33815122)
  }
}
