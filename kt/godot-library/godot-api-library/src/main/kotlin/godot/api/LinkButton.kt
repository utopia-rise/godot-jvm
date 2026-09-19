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
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantArray
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A button that represents a link. This type of button is primarily used for interactions that
 * cause a context change (like linking to a web page).
 *
 * See also [BaseButton] which contains common properties and methods associated with this node.
 */
@GodotBaseType
public open class LinkButton : BaseButton() {
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
   * The underline mode to use for the text.
   */
  public final inline var underline: UnderlineMode
    @JvmName("underlineProperty")
    get() = getUnderlineMode()
    @JvmName("underlineProperty")
    set(`value`) {
      setUnderlineMode(value)
    }

  /**
   * The [url=https://en.wikipedia.org/wiki/Uniform_Resource_Identifier]URI[/url] for this
   * [LinkButton]. If set to a valid URI, pressing the button opens the URI using the operating
   * system's default program for the protocol (via [OS.shellOpen]). HTTP and HTTPS URLs open the
   * default web browser.
   *
   * ```gdscript
   * //gdscript
   * uri = "https://godotengine.org"  # Opens the URL in the default web browser.
   * uri = "C:\SomeFolder"  # Opens the file explorer at the given path.
   * uri = "C:\SomeImage.png"  # Opens the given image in the default viewing app.
   * ```
   *
   * ```csharp
   * //csharp
   * Uri = "https://godotengine.org"; // Opens the URL in the default web browser.
   * Uri = "C:\SomeFolder"; // Opens the file explorer at the given path.
   * Uri = "C:\SomeImage.png"; // Opens the given image in the default viewing app.
   * ```
   */
  public final inline var uri: String
    @JvmName("uriProperty")
    get() = getUri()
    @JvmName("uriProperty")
    set(`value`) {
      setUri(value)
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
   * Ellipsis character used for text clipping.
   */
  public final inline var ellipsisChar: String
    @JvmName("ellipsisCharProperty")
    get() = getEllipsisChar()
    @JvmName("ellipsisCharProperty")
    set(`value`) {
      setEllipsisChar(value)
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

  /**
   * Set BiDi algorithm override for the structured text.
   */
  public final inline var structuredTextBidiOverride: TextServer.StructuredTextParser
    @JvmName("structuredTextBidiOverrideProperty")
    get() = getStructuredTextBidiOverride()
    @JvmName("structuredTextBidiOverrideProperty")
    set(`value`) {
      setStructuredTextBidiOverride(value)
    }

  /**
   * Set additional options for BiDi override.
   */
  public final inline var structuredTextBidiOverrideOptions: VariantArray<Any?>
    @JvmName("structuredTextBidiOverrideOptionsProperty")
    get() = getStructuredTextBidiOverrideOptions()
    @JvmName("structuredTextBidiOverrideOptionsProperty")
    set(`value`) {
      setStructuredTextBidiOverrideOptions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(362, scriptPtr)
  }

  public final fun setText(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setTextPtr, text)
  }

  public final fun getText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getTextPtr)

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextOverrunBehaviorPtr, overrunBehavior.value)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior =
      TextServer.OverrunBehavior.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextOverrunBehaviorPtr))

  public final fun setEllipsisChar(char: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setEllipsisCharPtr, char)
  }

  public final fun getEllipsisChar(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getEllipsisCharPtr)

  public final fun setTextDirection(direction: Control.TextDirection): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextDirectionPtr, direction.value)
  }

  public final fun getTextDirection(): Control.TextDirection =
      Control.TextDirection.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextDirectionPtr))

  public final fun setLanguage(language: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setLanguagePtr, language)
  }

  public final fun getLanguage(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getLanguagePtr)

  public final fun setUri(uri: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setUriPtr, uri)
  }

  public final fun getUri(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getUriPtr)

  public final fun setUnderlineMode(underlineMode: UnderlineMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setUnderlineModePtr, underlineMode.value)
  }

  public final fun getUnderlineMode(): UnderlineMode =
      UnderlineMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getUnderlineModePtr))

  public final fun setStructuredTextBidiOverride(parser: TextServer.StructuredTextParser): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverridePtr, parser.value)
  }

  public final fun getStructuredTextBidiOverride(): TextServer.StructuredTextParser =
      TextServer.StructuredTextParser.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverridePtr))

  public final fun setStructuredTextBidiOverrideOptions(args: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverrideOptionsPtr, args)
  }

  public final fun getStructuredTextBidiOverrideOptions(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverrideOptionsPtr) as VariantArray<Any?>)

  public enum class UnderlineMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The LinkButton will always show an underline at the bottom of its text.
     */
    ALWAYS(0),
    /**
     * The LinkButton will show an underline at the bottom of its text when the mouse cursor is over
     * it.
     */
    ON_HOVER(1),
    /**
     * The LinkButton will never show an underline at the bottom of its text.
     */
    NEVER(2),
    ;

    public companion object {
      public fun from(`value`: Long): UnderlineMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextName: MethodStringName1<LinkButton, Unit, String> =
        MethodStringName1<LinkButton, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<LinkButton, String> =
        MethodStringName0<LinkButton, String>("get_text")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName1<LinkButton, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<LinkButton, Unit, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName: MethodStringName0<LinkButton, TextServer.OverrunBehavior>
        = MethodStringName0<LinkButton, TextServer.OverrunBehavior>("get_text_overrun_behavior")

    @JvmField
    public val setEllipsisCharName: MethodStringName1<LinkButton, Unit, String> =
        MethodStringName1<LinkButton, Unit, String>("set_ellipsis_char")

    @JvmField
    public val getEllipsisCharName: MethodStringName0<LinkButton, String> =
        MethodStringName0<LinkButton, String>("get_ellipsis_char")

    @JvmField
    public val setTextDirectionName: MethodStringName1<LinkButton, Unit, Control.TextDirection> =
        MethodStringName1<LinkButton, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<LinkButton, Control.TextDirection> =
        MethodStringName0<LinkButton, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<LinkButton, Unit, String> =
        MethodStringName1<LinkButton, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<LinkButton, String> =
        MethodStringName0<LinkButton, String>("get_language")

    @JvmField
    public val setUriName: MethodStringName1<LinkButton, Unit, String> =
        MethodStringName1<LinkButton, Unit, String>("set_uri")

    @JvmField
    public val getUriName: MethodStringName0<LinkButton, String> =
        MethodStringName0<LinkButton, String>("get_uri")

    @JvmField
    public val setUnderlineModeName: MethodStringName1<LinkButton, Unit, UnderlineMode> =
        MethodStringName1<LinkButton, Unit, UnderlineMode>("set_underline_mode")

    @JvmField
    public val getUnderlineModeName: MethodStringName0<LinkButton, UnderlineMode> =
        MethodStringName0<LinkButton, UnderlineMode>("get_underline_mode")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<LinkButton, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<LinkButton, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<LinkButton, TextServer.StructuredTextParser> =
        MethodStringName0<LinkButton, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<LinkButton, Unit, VariantArray<Any?>> =
        MethodStringName1<LinkButton, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<LinkButton, VariantArray<Any?>> =
        MethodStringName0<LinkButton, VariantArray<Any?>>("get_structured_text_bidi_override_options")
  }

  public object MethodBindings {
    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_text", 201670096)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_text_overrun_behavior", 1008890932)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_text_overrun_behavior", 3779142101)

    internal val setEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_ellipsis_char", 83702148)

    internal val getEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_ellipsis_char", 201670096)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_language", 201670096)

    internal val setUriPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_uri", 83702148)

    internal val getUriPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_uri", 201670096)

    internal val setUnderlineModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_underline_mode", 4032947085)

    internal val getUnderlineModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_underline_mode", 568343738)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LinkButton", "get_structured_text_bidi_override_options", 3995934104)
  }
}
