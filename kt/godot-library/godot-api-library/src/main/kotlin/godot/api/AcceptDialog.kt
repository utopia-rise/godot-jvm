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
import godot.callMethod_STRING_BOOL_STRING_ret_OBJECT
import godot.callMethod_STRING_ret_OBJECT
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * The default use of [AcceptDialog] is to allow it to only be accepted or closed, with the same
 * result. However, the [signal confirmed] and [signal canceled] signals allow to make the two actions
 * different, and the [addButton] method allows to add custom buttons and actions.
 *
 * **Note:** [AcceptDialog] is invisible by default. To make it visible, call one of the `popup_*`
 * methods from [Window] on the node, such as [Window.popupCenteredClamped].
 */
@GodotBaseType
public open class AcceptDialog : Window() {
  /**
   * Emitted when the dialog is accepted, i.e. the OK button is pressed.
   */
  public val confirmed: Signal0 by Signal0

  /**
   * Emitted when the dialog is closed or the button created with [addCancelButton] is pressed.
   */
  public val canceled: Signal0 by Signal0

  /**
   * Emitted when a custom button with an action is pressed. See [addButton].
   */
  public val customAction: Signal1<StringName> by Signal1

  /**
   * The text displayed by the OK button (see [getOkButton]). If empty, a default text will be used.
   */
  public final inline var okButtonText: String
    @JvmName("okButtonTextProperty")
    get() = getOkButtonText()
    @JvmName("okButtonTextProperty")
    set(`value`) {
      setOkButtonText(value)
    }

  /**
   * The text displayed by the dialog.
   */
  public final inline var dialogText: String
    @JvmName("dialogTextProperty")
    get() = getText()
    @JvmName("dialogTextProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * If `true`, the dialog is hidden when the OK button is pressed. You can set it to `false` if you
   * want to do e.g. input validation when receiving the [signal confirmed] signal, and handle hiding
   * the dialog in your own logic.
   *
   * **Note:** Some nodes derived from this class can have a different default value, and
   * potentially their own built-in logic overriding this setting. For example [FileDialog] defaults to
   * `false`, and has its own input validation code that is called when you press OK, which eventually
   * hides the dialog if the input is valid. As such, this property can't be used in [FileDialog] to
   * disable hiding the dialog when pressing OK.
   */
  public final inline var dialogHideOnOk: Boolean
    @JvmName("dialogHideOnOkProperty")
    get() = getHideOnOk()
    @JvmName("dialogHideOnOkProperty")
    set(`value`) {
      setHideOnOk(value)
    }

  /**
   * If `true`, the dialog will be hidden when the `ui_close_dialog` action is pressed (by default,
   * this action is bound to [kbd]Escape[/kbd], or [kbd]Cmd + W[/kbd] on macOS).
   */
  public final inline var dialogCloseOnEscape: Boolean
    @JvmName("dialogCloseOnEscapeProperty")
    get() = getCloseOnEscape()
    @JvmName("dialogCloseOnEscapeProperty")
    set(`value`) {
      setCloseOnEscape(value)
    }

  /**
   * Sets autowrapping for the text in the dialog.
   */
  public final inline var dialogAutowrap: Boolean
    @JvmName("dialogAutowrapProperty")
    get() = hasAutowrap()
    @JvmName("dialogAutowrapProperty")
    set(`value`) {
      setAutowrap(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(4, scriptPtr)
  }

  /**
   * Returns the OK [Button] instance.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getOkButton(): Button? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getOkButtonPtr) as Button?)

  /**
   * Returns the label used for built-in text.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getLabel(): Label? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getLabelPtr) as Label?)

  public final fun setHideOnOk(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setHideOnOkPtr, enabled)
  }

  public final fun getHideOnOk(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getHideOnOkPtr)

  public final fun setCloseOnEscape(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCloseOnEscapePtr, enabled)
  }

  public final fun getCloseOnEscape(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getCloseOnEscapePtr)

  /**
   * Adds a button with label [text] and a custom [action] to the dialog and returns the created
   * button.
   *
   * If [action] is not empty, pressing the button will emit the [signal custom_action] signal with
   * the specified action string.
   *
   * If `true`, [right] will place the button to the right of any sibling buttons.
   *
   * You can use [removeButton] method to remove a button created with this method from the dialog.
   */
  @JvmOverloads
  public final fun addButton(
    text: String,
    right: Boolean = false,
    action: String = "",
  ): Button? =
      (TransferContext.callMethod_STRING_BOOL_STRING_ret_OBJECT(ptr, objectID.id, MethodBindings.addButtonPtr, text, right, action) as Button?)

  /**
   * Adds a button with label [name] and a cancel action to the dialog and returns the created
   * button.
   *
   * You can use [removeButton] method to remove a button created with this method from the dialog.
   */
  public final fun addCancelButton(name: String): Button? =
      (TransferContext.callMethod_STRING_ret_OBJECT(ptr, objectID.id, MethodBindings.addCancelButtonPtr, name) as Button?)

  /**
   * Removes the [button] from the dialog. Does NOT free the [button]. The [button] must be a
   * [Button] added with [addButton] or [addCancelButton] method. After removal, pressing the [button]
   * will no longer emit this dialog's [signal custom_action] or [signal canceled] signals.
   */
  public final fun removeButton(button: Button?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.removeButtonPtr, button)
  }

  /**
   * Registers a [LineEdit] in the dialog. When the enter key is pressed, the dialog will be
   * accepted.
   */
  public final fun registerTextEnter(lineEdit: LineEdit?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.registerTextEnterPtr, lineEdit)
  }

  public final fun setText(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setTextPtr, text)
  }

  public final fun getText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getTextPtr)

  public final fun setAutowrap(autowrap: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAutowrapPtr, autowrap)
  }

  public final fun hasAutowrap(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasAutowrapPtr)

  public final fun setOkButtonText(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setOkButtonTextPtr, text)
  }

  public final fun getOkButtonText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getOkButtonTextPtr)

  public companion object {
    @JvmField
    public val getOkButtonName: MethodStringName0<AcceptDialog, Button?> =
        MethodStringName0<AcceptDialog, Button?>("get_ok_button")

    @JvmField
    public val getLabelName: MethodStringName0<AcceptDialog, Label?> =
        MethodStringName0<AcceptDialog, Label?>("get_label")

    @JvmField
    public val setHideOnOkName: MethodStringName1<AcceptDialog, Unit, Boolean> =
        MethodStringName1<AcceptDialog, Unit, Boolean>("set_hide_on_ok")

    @JvmField
    public val getHideOnOkName: MethodStringName0<AcceptDialog, Boolean> =
        MethodStringName0<AcceptDialog, Boolean>("get_hide_on_ok")

    @JvmField
    public val setCloseOnEscapeName: MethodStringName1<AcceptDialog, Unit, Boolean> =
        MethodStringName1<AcceptDialog, Unit, Boolean>("set_close_on_escape")

    @JvmField
    public val getCloseOnEscapeName: MethodStringName0<AcceptDialog, Boolean> =
        MethodStringName0<AcceptDialog, Boolean>("get_close_on_escape")

    @JvmField
    public val addButtonName: MethodStringName3<AcceptDialog, Button?, String, Boolean, String> =
        MethodStringName3<AcceptDialog, Button?, String, Boolean, String>("add_button")

    @JvmField
    public val addCancelButtonName: MethodStringName1<AcceptDialog, Button?, String> =
        MethodStringName1<AcceptDialog, Button?, String>("add_cancel_button")

    @JvmField
    public val removeButtonName: MethodStringName1<AcceptDialog, Unit, Button?> =
        MethodStringName1<AcceptDialog, Unit, Button?>("remove_button")

    @JvmField
    public val registerTextEnterName: MethodStringName1<AcceptDialog, Unit, LineEdit?> =
        MethodStringName1<AcceptDialog, Unit, LineEdit?>("register_text_enter")

    @JvmField
    public val setTextName: MethodStringName1<AcceptDialog, Unit, String> =
        MethodStringName1<AcceptDialog, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<AcceptDialog, String> =
        MethodStringName0<AcceptDialog, String>("get_text")

    @JvmField
    public val setAutowrapName: MethodStringName1<AcceptDialog, Unit, Boolean> =
        MethodStringName1<AcceptDialog, Unit, Boolean>("set_autowrap")

    @JvmField
    public val hasAutowrapName: MethodStringName0<AcceptDialog, Boolean> =
        MethodStringName0<AcceptDialog, Boolean>("has_autowrap")

    @JvmField
    public val setOkButtonTextName: MethodStringName1<AcceptDialog, Unit, String> =
        MethodStringName1<AcceptDialog, Unit, String>("set_ok_button_text")

    @JvmField
    public val getOkButtonTextName: MethodStringName0<AcceptDialog, String> =
        MethodStringName0<AcceptDialog, String>("get_ok_button_text")
  }

  public object MethodBindings {
    internal val getOkButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "get_ok_button", 1856205918)

    internal val getLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "get_label", 566733104)

    internal val setHideOnOkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "set_hide_on_ok", 2586408642)

    internal val getHideOnOkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "get_hide_on_ok", 36873697)

    internal val setCloseOnEscapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "set_close_on_escape", 2586408642)

    internal val getCloseOnEscapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "get_close_on_escape", 36873697)

    internal val addButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "add_button", 3328440682)

    internal val addCancelButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "add_cancel_button", 242045556)

    internal val removeButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "remove_button", 2068354942)

    internal val registerTextEnterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "register_text_enter", 3714008017)

    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "set_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "get_text", 201670096)

    internal val setAutowrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "set_autowrap", 2586408642)

    internal val hasAutowrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "has_autowrap", 2240911060)

    internal val setOkButtonTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "set_ok_button_text", 83702148)

    internal val getOkButtonTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AcceptDialog", "get_ok_button_text", 201670096)
  }
}
