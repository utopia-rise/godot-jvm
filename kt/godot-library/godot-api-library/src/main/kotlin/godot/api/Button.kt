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
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VerticalAlignment
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [Button] is the standard themed button. It can contain text and an icon, and it will display them
 * according to the current [Theme].
 *
 * **Example:** Create a button and connect a method that will be called when the button is pressed:
 *
 * ```gdscript
 * //gdscript
 * func _ready():
 * 	var button = Button.new()
 * 	button.text = "Click me"
 * 	button.pressed.connect(_button_pressed)
 * 	add_child(button)
 *
 * func _button_pressed():
 * 	print("Hello world!")
 * ```
 *
 * ```csharp
 * //csharp
 * public override void _Ready()
 * {
 * 	var button = new Button();
 * 	button.Text = "Click me";
 * 	button.Pressed += ButtonPressed;
 * 	AddChild(button);
 * }
 *
 * private void ButtonPressed()
 * {
 * 	GD.Print("Hello world!");
 * }
 * ```
 *
 * See also [BaseButton] which contains common properties and methods associated with this node.
 *
 * **Note:** Buttons support multitouch via touch input, allowing multiple buttons to be pressed at
 * the same time. Otherwise, mouse input is used, limiting interaction to one button press at a time.
 */
@GodotBaseType
public open class Button : BaseButton() {
  /**
   * The button's text that will be displayed inside the button's area.
   */
  public final inline var text: String
    @JvmName("textProperty")
    get() = getText()
    @JvmName("textProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * Button's icon, if text is present the icon will be placed before the text.
   *
   * To edit margin and spacing of the icon, use [theme_item h_separation] theme property and
   * `content_margin_*` properties of the used [StyleBox]es.
   */
  public final inline var icon: Texture2D?
    @JvmName("iconProperty")
    get() = getButtonIcon()
    @JvmName("iconProperty")
    set(`value`) {
      setButtonIcon(value)
    }

  /**
   * Flat buttons don't display decoration.
   */
  public final inline var flat: Boolean
    @JvmName("flatProperty")
    get() = isFlat()
    @JvmName("flatProperty")
    set(`value`) {
      setFlat(value)
    }

  /**
   * Text alignment policy for the button's text.
   */
  public final inline var alignment: HorizontalAlignment
    @JvmName("alignmentProperty")
    get() = getTextAlignment()
    @JvmName("alignmentProperty")
    set(`value`) {
      setTextAlignment(value)
    }

  /**
   * Sets the clipping behavior when the text exceeds the node's bounding rectangle.
   */
  public final inline var textOverrunBehavior: TextServer.OverrunBehavior
    @JvmName("textOverrunBehaviorProperty")
    get() = getTextOverrunBehavior()
    @JvmName("textOverrunBehaviorProperty")
    set(`value`) {
      setTextOverrunBehavior(value)
    }

  /**
   * If set to something other than [TextServer.AUTOWRAP_OFF], the text gets wrapped inside the
   * node's bounding rectangle.
   */
  public final inline var autowrapMode: TextServer.AutowrapMode
    @JvmName("autowrapModeProperty")
    get() = getAutowrapMode()
    @JvmName("autowrapModeProperty")
    set(`value`) {
      setAutowrapMode(value)
    }

  /**
   * Autowrap space trimming flags. See [TextServer.BREAK_TRIM_START_EDGE_SPACES] and
   * [TextServer.BREAK_TRIM_END_EDGE_SPACES] for more info.
   */
  public final inline var autowrapTrimFlags: TextServer.LineBreakFlag
    @JvmName("autowrapTrimFlagsProperty")
    get() = getAutowrapTrimFlags()
    @JvmName("autowrapTrimFlagsProperty")
    set(`value`) {
      setAutowrapTrimFlags(value)
    }

  /**
   * If `true`, text that is too large to fit the button is clipped horizontally. If `false`, the
   * button will always be wide enough to hold the text. The text is not vertically clipped, and the
   * button's height is not affected by this property.
   */
  public final inline var clipText: Boolean
    @JvmName("clipTextProperty")
    get() = getClipText()
    @JvmName("clipTextProperty")
    set(`value`) {
      setClipText(value)
    }

  /**
   * Specifies if the icon should be aligned horizontally to the left, right, or center of a button.
   * Uses the same [HorizontalAlignment] constants as the text alignment. If centered horizontally and
   * vertically, text will draw on top of the icon.
   */
  public final inline var iconAlignment: HorizontalAlignment
    @JvmName("iconAlignmentProperty")
    get() = getIconAlignment()
    @JvmName("iconAlignmentProperty")
    set(`value`) {
      setIconAlignment(value)
    }

  /**
   * Specifies if the icon should be aligned vertically to the top, bottom, or center of a button.
   * Uses the same [VerticalAlignment] constants as the text alignment. If centered horizontally and
   * vertically, text will draw on top of the icon.
   */
  public final inline var verticalIconAlignment: VerticalAlignment
    @JvmName("verticalIconAlignmentProperty")
    get() = getVerticalIconAlignment()
    @JvmName("verticalIconAlignmentProperty")
    set(`value`) {
      setVerticalIconAlignment(value)
    }

  /**
   * When enabled, the button's icon will expand/shrink to fit the button's size while keeping its
   * aspect. See also [theme_item icon_max_width].
   */
  public final inline var expandIcon: Boolean
    @JvmName("expandIconProperty")
    get() = isExpandIcon()
    @JvmName("expandIconProperty")
    set(`value`) {
      setExpandIcon(value)
    }

  /**
   * Base text writing direction.
   */
  public final inline var textDirection: Control.TextDirection
    @JvmName("textDirectionProperty")
    get() = getTextDirection()
    @JvmName("textDirectionProperty")
    set(`value`) {
      setTextDirection(value)
    }

  /**
   * Language code used for line-breaking and text shaping algorithms. If left empty, the current
   * locale is used instead.
   */
  public final inline var language: String
    @JvmName("languageProperty")
    get() = getLanguage()
    @JvmName("languageProperty")
    set(`value`) {
      setLanguage(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(118, scriptPtr)
  }

  public final fun setText(text: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, text)
    TransferContext.callMethod(MethodBindings.setTextPtr)
  }

  public final fun getText(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, overrunBehavior.value)
    TransferContext.callPtrMethod(MethodBindings.setTextOverrunBehaviorPtr, 0)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextOverrunBehaviorPtr, 2)
    return TextServer.OverrunBehavior.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAutowrapMode(autowrapMode: TextServer.AutowrapMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, autowrapMode.value)
    TransferContext.callPtrMethod(MethodBindings.setAutowrapModePtr, 0)
  }

  public final fun getAutowrapMode(): TextServer.AutowrapMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutowrapModePtr, 2)
    return TextServer.AutowrapMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAutowrapTrimFlags(autowrapTrimFlags: TextServer.LineBreakFlag): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, autowrapTrimFlags.flag)
    TransferContext.callPtrMethod(MethodBindings.setAutowrapTrimFlagsPtr, 0)
  }

  public final fun getAutowrapTrimFlags(): TextServer.LineBreakFlag {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutowrapTrimFlagsPtr, 2)
    return TextServer.LineBreakFlag(TransferContext.readReturnValue_LONG())
  }

  public final fun setTextDirection(direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, direction.value)
    TransferContext.callPtrMethod(MethodBindings.setTextDirectionPtr, 0)
  }

  public final fun getTextDirection(): Control.TextDirection {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextDirectionPtr, 2)
    return Control.TextDirection.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setLanguage(language: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, language)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setButtonIcon(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callPtrMethod(MethodBindings.setButtonIconPtr, 0)
  }

  public final fun getButtonIcon(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getButtonIconPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun setFlat(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setFlatPtr, 0)
  }

  public final fun isFlat(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isFlatPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setClipText(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setClipTextPtr, 0)
  }

  public final fun getClipText(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getClipTextPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTextAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callPtrMethod(MethodBindings.setTextAlignmentPtr, 0)
  }

  public final fun getTextAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextAlignmentPtr, 2)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setIconAlignment(iconAlignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, iconAlignment.value)
    TransferContext.callPtrMethod(MethodBindings.setIconAlignmentPtr, 0)
  }

  public final fun getIconAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIconAlignmentPtr, 2)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setVerticalIconAlignment(verticalIconAlignment: VerticalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, verticalIconAlignment.value)
    TransferContext.callPtrMethod(MethodBindings.setVerticalIconAlignmentPtr, 0)
  }

  public final fun getVerticalIconAlignment(): VerticalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVerticalIconAlignmentPtr, 2)
    return VerticalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setExpandIcon(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setExpandIconPtr, 0)
  }

  public final fun isExpandIcon(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isExpandIconPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setTextName: MethodStringName1<Button, Unit, String> =
        MethodStringName1<Button, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<Button, String> =
        MethodStringName0<Button, String>("get_text")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName1<Button, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<Button, Unit, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName: MethodStringName0<Button, TextServer.OverrunBehavior> =
        MethodStringName0<Button, TextServer.OverrunBehavior>("get_text_overrun_behavior")

    @JvmField
    public val setAutowrapModeName: MethodStringName1<Button, Unit, TextServer.AutowrapMode> =
        MethodStringName1<Button, Unit, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName0<Button, TextServer.AutowrapMode> =
        MethodStringName0<Button, TextServer.AutowrapMode>("get_autowrap_mode")

    @JvmField
    public val setAutowrapTrimFlagsName: MethodStringName1<Button, Unit, TextServer.LineBreakFlag> =
        MethodStringName1<Button, Unit, TextServer.LineBreakFlag>("set_autowrap_trim_flags")

    @JvmField
    public val getAutowrapTrimFlagsName: MethodStringName0<Button, TextServer.LineBreakFlag> =
        MethodStringName0<Button, TextServer.LineBreakFlag>("get_autowrap_trim_flags")

    @JvmField
    public val setTextDirectionName: MethodStringName1<Button, Unit, Control.TextDirection> =
        MethodStringName1<Button, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<Button, Control.TextDirection> =
        MethodStringName0<Button, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<Button, Unit, String> =
        MethodStringName1<Button, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<Button, String> =
        MethodStringName0<Button, String>("get_language")

    @JvmField
    public val setButtonIconName: MethodStringName1<Button, Unit, Texture2D?> =
        MethodStringName1<Button, Unit, Texture2D?>("set_button_icon")

    @JvmField
    public val getButtonIconName: MethodStringName0<Button, Texture2D?> =
        MethodStringName0<Button, Texture2D?>("get_button_icon")

    @JvmField
    public val setFlatName: MethodStringName1<Button, Unit, Boolean> =
        MethodStringName1<Button, Unit, Boolean>("set_flat")

    @JvmField
    public val isFlatName: MethodStringName0<Button, Boolean> =
        MethodStringName0<Button, Boolean>("is_flat")

    @JvmField
    public val setClipTextName: MethodStringName1<Button, Unit, Boolean> =
        MethodStringName1<Button, Unit, Boolean>("set_clip_text")

    @JvmField
    public val getClipTextName: MethodStringName0<Button, Boolean> =
        MethodStringName0<Button, Boolean>("get_clip_text")

    @JvmField
    public val setTextAlignmentName: MethodStringName1<Button, Unit, HorizontalAlignment> =
        MethodStringName1<Button, Unit, HorizontalAlignment>("set_text_alignment")

    @JvmField
    public val getTextAlignmentName: MethodStringName0<Button, HorizontalAlignment> =
        MethodStringName0<Button, HorizontalAlignment>("get_text_alignment")

    @JvmField
    public val setIconAlignmentName: MethodStringName1<Button, Unit, HorizontalAlignment> =
        MethodStringName1<Button, Unit, HorizontalAlignment>("set_icon_alignment")

    @JvmField
    public val getIconAlignmentName: MethodStringName0<Button, HorizontalAlignment> =
        MethodStringName0<Button, HorizontalAlignment>("get_icon_alignment")

    @JvmField
    public val setVerticalIconAlignmentName: MethodStringName1<Button, Unit, VerticalAlignment> =
        MethodStringName1<Button, Unit, VerticalAlignment>("set_vertical_icon_alignment")

    @JvmField
    public val getVerticalIconAlignmentName: MethodStringName0<Button, VerticalAlignment> =
        MethodStringName0<Button, VerticalAlignment>("get_vertical_icon_alignment")

    @JvmField
    public val setExpandIconName: MethodStringName1<Button, Unit, Boolean> =
        MethodStringName1<Button, Unit, Boolean>("set_expand_icon")

    @JvmField
    public val isExpandIconName: MethodStringName0<Button, Boolean> =
        MethodStringName0<Button, Boolean>("is_expand_icon")
  }

  public object MethodBindings {
    internal val setTextPtr: VoidPtr = TypeManager.getMethodBindPtr("Button", "set_text", 83702148)

    internal val getTextPtr: VoidPtr = TypeManager.getMethodBindPtr("Button", "get_text", 201670096)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_text_overrun_behavior", 1008890932)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_text_overrun_behavior", 3779142101)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_autowrap_mode", 3289138044)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_autowrap_mode", 1549071663)

    internal val setAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_autowrap_trim_flags", 2809697122)

    internal val getAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_autowrap_trim_flags", 2340632602)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_language", 201670096)

    internal val setButtonIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_button_icon", 4051416890)

    internal val getButtonIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_button_icon", 3635182373)

    internal val setFlatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_flat", 2586408642)

    internal val isFlatPtr: VoidPtr = TypeManager.getMethodBindPtr("Button", "is_flat", 36873697)

    internal val setClipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_clip_text", 2586408642)

    internal val getClipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_clip_text", 36873697)

    internal val setTextAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_text_alignment", 2312603777)

    internal val getTextAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_text_alignment", 341400642)

    internal val setIconAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_icon_alignment", 2312603777)

    internal val getIconAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_icon_alignment", 341400642)

    internal val setVerticalIconAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_vertical_icon_alignment", 1796458609)

    internal val getVerticalIconAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "get_vertical_icon_alignment", 3274884059)

    internal val setExpandIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "set_expand_icon", 2586408642)

    internal val isExpandIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Button", "is_expand_icon", 36873697)
  }
}
